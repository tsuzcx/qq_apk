package com.tencent.ilivesdk.playview.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View.MeasureSpec;
import com.tencent.ilivesdk.playview.codec.HardwareFileDecoder;
import com.tencent.ilivesdk.playview.codec.SoftwareFileDecoder;
import com.tencent.ilivesdk.playview.codec.VideoFileDecodeListener;
import com.tencent.ilivesdk.playview.codec.VideoFileDecoder;
import com.tencent.ilivesdk.playview.render.BaseRender;
import com.tencent.ilivesdk.playview.render.RGBABlendRender;
import com.tencent.ilivesdk.playview.render.SurfaceTextureBlendRender;
import com.tencent.ilivesdk.utils.LogUtils;
import java.io.File;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class PlayView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer, VideoPlayController
{
  static final String TAG = "MediaPESdk|PlayView";
  static int sStatusBarHeight = -1;
  private final int DEFAULT_FRAME_RATE = 25;
  private boolean mContentVisible = true;
  private Context mContext;
  private float mCropValue = 0.0F;
  private int mCurFrameCount = 0;
  private byte[] mCurRGBAData = null;
  private BaseRender mCurRender = null;
  private long mCurTime = 0L;
  private VideoFileDecodeListener mDecodeListener = new PlayView.1(this);
  private Thread mDecodeThread = null;
  private String mFilepath = null;
  private int mFrameTime = 0;
  private int mGLViewHeight = 0;
  private int mGLViewWidth = 0;
  private int mHalfVideoWidth = 0;
  private VideoFileDecoder mHardDecoder = null;
  private Runnable mHardwareDecodeWaitForRunnable = new PlayView.7(this);
  private boolean mHasRGBAData = false;
  private boolean mIsPortrait = true;
  private Object mLock = new Object();
  private boolean mLoop = false;
  private boolean mNeedConfigViewport = true;
  private boolean mNotOnMeasure = false;
  private PlayView.IntervalFpsLogTimer mOnPreviewFrameLogTimer = new PlayView.IntervalFpsLogTimer(4000);
  private VideoPLayListener mPlayListener = null;
  private boolean mPlayStarting = false;
  private BaseRender mRGBARender = null;
  private VideoFileDecoder mSoftDecoder = null;
  private Runnable mSoftwareDecodeWaitForRunnable = new PlayView.8(this);
  private boolean mStopping = false;
  private BaseRender mSurfaceTextureRender = null;
  private String mTmpFilePath = null;
  private boolean mUseHardwareDecoder = false;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  private Handler mViewHandler = new Handler();
  private boolean mViewReady = false;
  
  public PlayView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public PlayView(Context paramContext, VideoPLayListener paramVideoPLayListener)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mPlayListener = paramVideoPLayListener;
    init();
  }
  
  public PlayView(Context paramContext, VideoPLayListener paramVideoPLayListener, boolean paramBoolean)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mPlayListener = paramVideoPLayListener;
    this.mUseHardwareDecoder = paramBoolean;
    init();
  }
  
  public PlayView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mUseHardwareDecoder = paramBoolean;
    init();
  }
  
  private void _calcCropValue()
  {
    if (this.mIsPortrait)
    {
      i = this.mHalfVideoWidth;
      j = this.mVideoHeight;
      if (i > j)
      {
        this.mCropValue = calCrop(j, i, this.mGLViewWidth, this.mGLViewHeight);
        return;
      }
      this.mCropValue = calCrop(i, j, this.mGLViewWidth, this.mGLViewHeight);
      return;
    }
    int i = this.mHalfVideoWidth;
    int j = this.mVideoHeight;
    if (i * 9 >= j * 16)
    {
      this.mCropValue = calCrop(i, j, this.mGLViewWidth, this.mGLViewHeight);
      return;
    }
    this.mCropValue = 0.0F;
  }
  
  private float calCrop(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = 0.0F;
    float f1 = f2;
    if (paramInt2 != 0)
    {
      f1 = f2;
      if (paramInt3 != 0)
      {
        f1 = f2;
        if (paramInt1 != 0)
        {
          f1 = f2;
          if (paramInt4 != 0)
          {
            int i = paramInt2 * paramInt3;
            int j = paramInt1 * paramInt4;
            if (i == j)
            {
              LogUtils.i("MediaPESdk|PlayView", " crop 0");
              return 0.0F;
            }
            if (i > j)
            {
              f1 = 0.5F - paramInt4 * paramInt1 * 0.5F / paramInt3 / paramInt2;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(" crop height = ");
              localStringBuilder.append(f1);
              LogUtils.i("MediaPESdk|PlayView", localStringBuilder.toString());
              return f1;
            }
            f1 = paramInt3 * paramInt2 * 0.5F / paramInt4 / paramInt1 - 0.5F;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(" crop width = ");
            localStringBuilder.append(f1);
            LogUtils.i("MediaPESdk|PlayView", localStringBuilder.toString());
          }
        }
      }
    }
    return f1;
  }
  
  private void callbackError(int paramInt)
  {
    if (this.mPlayListener != null)
    {
      Handler localHandler = this.mViewHandler;
      if (localHandler != null) {
        localHandler.post(new PlayView.4(this, paramInt));
      }
    }
  }
  
  private void configViewportOnDraw()
  {
    int j;
    BaseRender localBaseRender;
    int i;
    if (this.mIsPortrait)
    {
      j = this.mHalfVideoWidth;
      int k = this.mVideoHeight;
      if (j < k)
      {
        localBaseRender = this.mCurRender;
        if (localBaseRender != null)
        {
          localBaseRender.setCropValue(this.mCropValue);
          GLES20.glViewport(0, 0, this.mGLViewWidth, this.mGLViewHeight);
        }
      }
      else
      {
        int m = this.mGLViewWidth;
        i = m * 9 / 16;
        if (j != 0) {
          i = m * k / j;
        }
        j = (this.mGLViewHeight - i) * 2 / 3;
        localBaseRender = this.mCurRender;
        if (localBaseRender != null)
        {
          localBaseRender.setCropValue(this.mCropValue);
          GLES20.glViewport(0, j, this.mGLViewWidth, i);
        }
      }
    }
    else
    {
      i = this.mHalfVideoWidth;
      j = this.mVideoHeight;
      if (i * 9 >= j * 16)
      {
        localBaseRender = this.mCurRender;
        if (localBaseRender != null)
        {
          localBaseRender.setCropValue(this.mCropValue);
          GLES20.glViewport(0, 0, this.mGLViewWidth, this.mGLViewHeight);
        }
      }
      else
      {
        i = i * this.mGLViewHeight / j;
        j = (this.mGLViewWidth - i) / 2;
        localBaseRender = this.mCurRender;
        if (localBaseRender != null)
        {
          localBaseRender.setCropValue(this.mCropValue);
          GLES20.glViewport(j, 0, i, this.mGLViewHeight);
        }
      }
    }
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    double d1 = paramContext.getResources().getDisplayMetrics().density;
    double d2 = paramFloat;
    Double.isNaN(d2);
    Double.isNaN(d1);
    return (int)(d2 * d1 + 0.5D);
  }
  
  private boolean fileIsExists(String paramString)
  {
    try
    {
      if (new File(paramString).exists())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("--------->file have exist");
        LogUtils.i("MediaPESdk|PlayView", localStringBuilder.toString());
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("---------->file not exists");
      LogUtils.i("MediaPESdk|PlayView", localStringBuilder.toString());
      return false;
    }
    catch (Exception paramString)
    {
      LogUtils.i("MediaPESdk|PlayView", "--------->fileIsExists exception");
      paramString.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  private String getAssetsFiles(String paramString)
  {
    // Byte code:
    //   0: new 265	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: getfield 170	com/tencent/ilivesdk/playview/view/PlayView:mContext	Landroid/content/Context;
    //   13: invokevirtual 360	android/content/Context:getFilesDir	()Ljava/io/File;
    //   16: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload_3
    //   21: ldc_w 365
    //   24: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_3
    //   29: aload_1
    //   30: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_3
    //   35: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore 6
    //   40: aload_0
    //   41: aload 6
    //   43: invokespecial 367	com/tencent/ilivesdk/playview/view/PlayView:fileIsExists	(Ljava/lang/String;)Z
    //   46: ifne +204 -> 250
    //   49: aload_0
    //   50: getfield 170	com/tencent/ilivesdk/playview/view/PlayView:mContext	Landroid/content/Context;
    //   53: invokevirtual 371	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   56: astore_3
    //   57: aconst_null
    //   58: astore 5
    //   60: aload_3
    //   61: aload_1
    //   62: invokevirtual 377	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   65: astore_3
    //   66: aload_3
    //   67: invokevirtual 383	java/io/InputStream:available	()I
    //   70: istore_2
    //   71: new 265	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 266	java/lang/StringBuilder:<init>	()V
    //   78: astore 4
    //   80: aload 4
    //   82: ldc_w 385
    //   85: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 4
    //   91: iload_2
    //   92: invokevirtual 388	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: ldc 12
    //   98: aload 4
    //   100: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 262	com/tencent/ilivesdk/utils/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: iload_2
    //   107: newarray byte
    //   109: astore 7
    //   111: aload_3
    //   112: aload 7
    //   114: invokevirtual 392	java/io/InputStream:read	([B)I
    //   117: pop
    //   118: aload_0
    //   119: getfield 170	com/tencent/ilivesdk/playview/view/PlayView:mContext	Landroid/content/Context;
    //   122: aload_1
    //   123: iconst_0
    //   124: invokevirtual 396	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   127: astore_1
    //   128: aload_3
    //   129: astore 4
    //   131: aload_1
    //   132: astore 5
    //   134: aload_1
    //   135: aload 7
    //   137: invokevirtual 402	java/io/FileOutputStream:write	([B)V
    //   140: aload_3
    //   141: astore 4
    //   143: aload_1
    //   144: astore 5
    //   146: aload_1
    //   147: invokevirtual 405	java/io/FileOutputStream:flush	()V
    //   150: aload_3
    //   151: ifnull +7 -> 158
    //   154: aload_3
    //   155: invokevirtual 408	java/io/InputStream:close	()V
    //   158: aload_1
    //   159: ifnull +91 -> 250
    //   162: aload_1
    //   163: invokevirtual 409	java/io/FileOutputStream:close	()V
    //   166: aload 6
    //   168: areturn
    //   169: astore 6
    //   171: goto +26 -> 197
    //   174: astore_1
    //   175: goto +55 -> 230
    //   178: astore 6
    //   180: aconst_null
    //   181: astore_1
    //   182: goto +15 -> 197
    //   185: astore_1
    //   186: aconst_null
    //   187: astore_3
    //   188: goto +42 -> 230
    //   191: astore 6
    //   193: aconst_null
    //   194: astore_1
    //   195: aload_1
    //   196: astore_3
    //   197: aload_3
    //   198: astore 4
    //   200: aload_1
    //   201: astore 5
    //   203: aload 6
    //   205: invokevirtual 410	java/io/IOException:printStackTrace	()V
    //   208: aload_3
    //   209: ifnull +7 -> 216
    //   212: aload_3
    //   213: invokevirtual 408	java/io/InputStream:close	()V
    //   216: aload_1
    //   217: ifnull +7 -> 224
    //   220: aload_1
    //   221: invokevirtual 409	java/io/FileOutputStream:close	()V
    //   224: aconst_null
    //   225: areturn
    //   226: astore_1
    //   227: aload 4
    //   229: astore_3
    //   230: aload_3
    //   231: ifnull +7 -> 238
    //   234: aload_3
    //   235: invokevirtual 408	java/io/InputStream:close	()V
    //   238: aload 5
    //   240: ifnull +8 -> 248
    //   243: aload 5
    //   245: invokevirtual 409	java/io/FileOutputStream:close	()V
    //   248: aload_1
    //   249: athrow
    //   250: aload 6
    //   252: areturn
    //   253: astore_3
    //   254: goto -96 -> 158
    //   257: astore_1
    //   258: aload 6
    //   260: areturn
    //   261: astore_3
    //   262: goto -46 -> 216
    //   265: astore_1
    //   266: aconst_null
    //   267: areturn
    //   268: astore_3
    //   269: goto -31 -> 238
    //   272: astore_3
    //   273: goto -25 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	this	PlayView
    //   0	276	1	paramString	String
    //   70	37	2	i	int
    //   7	228	3	localObject1	Object
    //   253	1	3	localIOException1	java.io.IOException
    //   261	1	3	localIOException2	java.io.IOException
    //   268	1	3	localIOException3	java.io.IOException
    //   272	1	3	localIOException4	java.io.IOException
    //   78	150	4	localObject2	Object
    //   58	186	5	str1	String
    //   38	129	6	str2	String
    //   169	1	6	localIOException5	java.io.IOException
    //   178	1	6	localIOException6	java.io.IOException
    //   191	68	6	localIOException7	java.io.IOException
    //   109	27	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   134	140	169	java/io/IOException
    //   146	150	169	java/io/IOException
    //   66	128	174	finally
    //   66	128	178	java/io/IOException
    //   60	66	185	finally
    //   60	66	191	java/io/IOException
    //   134	140	226	finally
    //   146	150	226	finally
    //   203	208	226	finally
    //   154	158	253	java/io/IOException
    //   162	166	257	java/io/IOException
    //   212	216	261	java/io/IOException
    //   220	224	265	java/io/IOException
    //   234	238	268	java/io/IOException
    //   243	248	272	java/io/IOException
  }
  
  public static int getContentViewHeight(Context paramContext)
  {
    return getScreenHeight(paramContext) - getStatusBarHeight(paramContext);
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    int j = sStatusBarHeight;
    int i = -1;
    if (j != -1) {
      return j;
    }
    Resources localResources = paramContext.getResources();
    j = localResources.getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = localResources.getDimensionPixelSize(j);
    }
    j = i;
    if (i <= 0) {
      j = dip2px(paramContext, 25.0F);
    }
    sStatusBarHeight = j;
    return j;
  }
  
  private Surface getSurface()
  {
    BaseRender localBaseRender = this.mSurfaceTextureRender;
    if ((localBaseRender != null) && ((localBaseRender instanceof SurfaceTextureBlendRender))) {
      return ((SurfaceTextureBlendRender)localBaseRender).getSurface();
    }
    return null;
  }
  
  private void init()
  {
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    setRenderer(this);
    setRenderMode(0);
    getHolder().setFormat(-2);
    setVisibility(8);
    setZOrderOnTop(true);
  }
  
  private void processDecodeEnd()
  {
    queueEvent(new PlayView.5(this));
  }
  
  private void processDecodeError(int paramInt)
  {
    queueEvent(new PlayView.6(this, paramInt));
  }
  
  private void releaseRenderGLThread()
  {
    BaseRender localBaseRender = this.mSurfaceTextureRender;
    if (localBaseRender != null)
    {
      localBaseRender.destroy();
      this.mSurfaceTextureRender = null;
    }
    localBaseRender = this.mRGBARender;
    if (localBaseRender != null)
    {
      localBaseRender.destroy();
      this.mRGBARender = null;
    }
  }
  
  private void setupDecodeRender()
  {
    this.mHardDecoder = new HardwareFileDecoder(this.mLoop);
    this.mHardDecoder.setDecodeListener(this.mDecodeListener);
    try
    {
      this.mSurfaceTextureRender = new SurfaceTextureBlendRender();
      this.mSurfaceTextureRender.setup();
      setupFrameListenerOES();
    }
    catch (Exception localException)
    {
      this.mUseHardwareDecoder = false;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mSurfaceTextureRender Exception switch  soft decode Exception=");
      localStringBuilder.append(localException);
      LogUtils.i("MediaPESdk|PlayView", localStringBuilder.toString());
      localException.printStackTrace();
    }
    this.mSoftDecoder = new SoftwareFileDecoder(this.mLoop);
    this.mSoftDecoder.setDecodeListener(this.mDecodeListener);
    this.mRGBARender = new RGBABlendRender();
    this.mRGBARender.setup();
    this.mHasRGBAData = false;
  }
  
  private void setupFrameListenerOES()
  {
    BaseRender localBaseRender = this.mSurfaceTextureRender;
    if ((localBaseRender != null) && (localBaseRender.getRenderType() == 1) && (((SurfaceTextureBlendRender)this.mSurfaceTextureRender).getVideoTexture() != null)) {
      ((SurfaceTextureBlendRender)this.mSurfaceTextureRender).getVideoTexture().setOnFrameAvailableListener(new PlayView.11(this));
    }
  }
  
  private void startDecode()
  {
    this.mFrameTime = 0;
    if (this.mUseHardwareDecoder)
    {
      this.mDecodeThread = new Thread(this.mHardwareDecodeWaitForRunnable);
      this.mDecodeThread.start();
      return;
    }
    this.mDecodeThread = new Thread(this.mSoftwareDecodeWaitForRunnable);
    this.mDecodeThread.start();
  }
  
  public boolean getContentVisible()
  {
    return this.mContentVisible;
  }
  
  public void initDecodeType(boolean paramBoolean)
  {
    this.mUseHardwareDecoder = paramBoolean;
  }
  
  public void onDrawFrame(GL10 arg1)
  {
    if ((this.mViewReady) && (this.mCurRender != null))
    {
      int i = this.mVideoWidth;
      if (i > 0)
      {
        int j = this.mVideoHeight;
        if (j <= 0) {
          return;
        }
        if ((this.mNeedConfigViewport) && (i > 0) && (j > 0) && (this.mGLViewWidth > 0) && (this.mGLViewHeight > 0))
        {
          _calcCropValue();
          configViewportOnDraw();
          this.mNeedConfigViewport = false;
        }
        if (this.mUseHardwareDecoder) {
          this.mCurRender.draw(null, 0, 0, false);
        }
        synchronized (this.mLock)
        {
          if ((this.mCurRGBAData != null) && (this.mHasRGBAData)) {
            this.mCurRender.draw(this.mCurRGBAData, this.mVideoWidth, this.mVideoHeight, false);
          }
          i = this.mFrameTime;
          if (i > 0)
          {
            this.mCurFrameCount += 1;
            this.mCurTime = (i * this.mCurFrameCount);
            this.mViewHandler.post(new PlayView.10(this));
          }
          if (this.mOnPreviewFrameLogTimer.isTimeToWriteLog())
          {
            ??? = new StringBuilder();
            ???.append("onDrawFrame fps= ");
            ???.append(this.mOnPreviewFrameLogTimer.getFps());
            LogUtils.i("MediaPESdk|PlayView", ???.toString());
          }
          if (!this.mContentVisible)
          {
            GLES20.glClear(16384);
            GLES20.glFinish();
          }
          return;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mNotOnMeasure)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    paramInt1 = getContentViewHeight(getContext());
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (paramInt1 < paramInt2) {
      paramInt1 = paramInt2;
    }
    setMeasuredDimension(i, paramInt1);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("===================gl render onSurfaceChanged ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" h=");
    localStringBuilder.append(paramInt2);
    LogUtils.e("MediaPESdk|PlayView", localStringBuilder.toString());
    paramGL10.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    this.mGLViewWidth = paramInt1;
    this.mGLViewHeight = paramInt2;
    boolean bool;
    if (this.mGLViewWidth > this.mGLViewHeight) {
      bool = false;
    } else {
      bool = true;
    }
    this.mIsPortrait = bool;
    if ((this.mVideoWidth > 0) && (this.mVideoHeight > 0) && (this.mGLViewWidth > 0) && (this.mGLViewHeight > 0)) {
      this.mNeedConfigViewport = true;
    }
    if (!this.mViewReady)
    {
      this.mViewReady = true;
      this.mViewHandler.post(new PlayView.9(this));
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    LogUtils.e("MediaPESdk|PlayView", "===================gl render onSurfaceCreated");
    setupDecodeRender();
  }
  
  public void playAssetsFile(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" playAssetsFile , want to play filename =");
    localStringBuilder.append(paramString);
    LogUtils.i("MediaPESdk|PlayView", localStringBuilder.toString());
    if (this.mPlayStarting)
    {
      LogUtils.i("MediaPESdk|PlayView", " playAssetsFile , one has played , return");
      return;
    }
    if (this.mViewReady)
    {
      LogUtils.i("MediaPESdk|PlayView", " playAssetsFile , view not ready , return ");
      return;
    }
    this.mPlayStarting = true;
    paramString = getAssetsFiles(paramString);
    if (paramString != null)
    {
      this.mFilepath = paramString;
      this.mCurRender = null;
      new Thread(new PlayView.3(this)).start();
      setVisibility(0);
      return;
    }
    LogUtils.e("MediaPESdk|PlayView", "assets file , get error");
    callbackError(-1);
    this.mPlayStarting = false;
  }
  
  public void playFile(String paramString)
  {
    if (this.mStopping) {
      this.mTmpFilePath = paramString;
    } else {
      this.mTmpFilePath = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" playFile , want to play filepath =");
    localStringBuilder.append(paramString);
    LogUtils.e("MediaPESdk|PlayView", localStringBuilder.toString());
    if (this.mPlayStarting)
    {
      LogUtils.i("MediaPESdk|PlayView", " playFile , one has played , return");
      return;
    }
    if (this.mViewReady)
    {
      LogUtils.i("MediaPESdk|PlayView", " playFile , view not ready , return ");
      return;
    }
    this.mPlayStarting = true;
    if (fileIsExists(paramString))
    {
      this.mFilepath = paramString;
      this.mCurRender = null;
      new Thread(new PlayView.2(this)).start();
      setVisibility(0);
      return;
    }
    LogUtils.e("MediaPESdk|PlayView", " file , get error");
    callbackError(-1);
    this.mPlayStarting = false;
  }
  
  public void setContentVisible(boolean paramBoolean)
  {
    this.mContentVisible = paramBoolean;
  }
  
  public void setLoopState(boolean paramBoolean)
  {
    this.mLoop = paramBoolean;
    VideoFileDecoder localVideoFileDecoder = this.mHardDecoder;
    if (localVideoFileDecoder != null) {
      localVideoFileDecoder.setLoopState(this.mLoop);
    }
    localVideoFileDecoder = this.mSoftDecoder;
    if (localVideoFileDecoder != null) {
      localVideoFileDecoder.setLoopState(this.mLoop);
    }
  }
  
  public void setNotOnMeasure(boolean paramBoolean)
  {
    this.mNotOnMeasure = paramBoolean;
  }
  
  public void setPlayListener(VideoPLayListener paramVideoPLayListener)
  {
    this.mPlayListener = paramVideoPLayListener;
  }
  
  public void stop()
  {
    LogUtils.i("MediaPESdk|PlayView", "==============PlayView Stop");
    if (!this.mViewReady) {
      return;
    }
    VideoFileDecoder localVideoFileDecoder;
    if (this.mUseHardwareDecoder)
    {
      localVideoFileDecoder = this.mHardDecoder;
      if (localVideoFileDecoder != null) {
        localVideoFileDecoder.stop();
      }
    }
    else
    {
      localVideoFileDecoder = this.mSoftDecoder;
      if (localVideoFileDecoder != null) {
        localVideoFileDecoder.stop();
      }
    }
    this.mStopping = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayView
 * JD-Core Version:    0.7.0.1
 */