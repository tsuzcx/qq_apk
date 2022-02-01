package com.tencent.ilivesdk.playview.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.view.Surface;
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

public class PlayTextureView
  extends GLTextureView
  implements GLSurfaceView.Renderer, VideoPlayController
{
  static final String TAG = "Render|PlayTextureView";
  private final int DEFAULT_FRAME_RATE = 25;
  private boolean mContentVisible = true;
  private Context mContext;
  private float mCropValue = 0.0F;
  private int mCurFrameCount = 0;
  private byte[] mCurRGBAData = null;
  private BaseRender mCurRender = null;
  private long mCurTime = 0L;
  private VideoFileDecodeListener mDecodeListener = new PlayTextureView.1(this);
  private Thread mDecodeThread = null;
  private String mFilepath = null;
  private int mFrameTime = 0;
  private int mGLViewHeight = 0;
  private int mGLViewWidth = 0;
  private int mHalfVideoWidth = 0;
  private VideoFileDecoder mHardDecoder = null;
  private Runnable mHardwareDecodeWaitForRunnable = new PlayTextureView.7(this);
  private boolean mHasRGBAData = false;
  private boolean mIsPortrait = true;
  private Object mLock = new Object();
  private boolean mLoop = false;
  private boolean mNeedConfigViewport = true;
  private PlayTextureView.IntervalFpsLogTimer mOnPreviewFrameLogTimer = new PlayTextureView.IntervalFpsLogTimer(4000);
  private VideoPLayListener mPlayListener = null;
  private boolean mPlayStarting = false;
  private BaseRender mRGBARender = null;
  private VideoFileDecoder mSoftDecoder = null;
  private Runnable mSoftwareDecodeWaitForRunnable = new PlayTextureView.8(this);
  private boolean mStopping = false;
  private BaseRender mSurfaceTextureRender = null;
  private String mTmpFilePath = null;
  private boolean mUseHardwareDecoder = false;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  private Handler mViewHandler = new Handler();
  private boolean mViewReady = false;
  
  public PlayTextureView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public PlayTextureView(Context paramContext, VideoPLayListener paramVideoPLayListener)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mPlayListener = paramVideoPLayListener;
    init();
  }
  
  public PlayTextureView(Context paramContext, VideoPLayListener paramVideoPLayListener, boolean paramBoolean)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mPlayListener = paramVideoPLayListener;
    this.mUseHardwareDecoder = paramBoolean;
    init();
  }
  
  public PlayTextureView(Context paramContext, boolean paramBoolean)
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
      if (this.mHalfVideoWidth > this.mVideoHeight)
      {
        this.mCropValue = calCrop(this.mVideoHeight, this.mHalfVideoWidth, this.mGLViewWidth, this.mGLViewHeight);
        return;
      }
      this.mCropValue = calCrop(this.mHalfVideoWidth, this.mVideoHeight, this.mGLViewWidth, this.mGLViewHeight);
      return;
    }
    if (this.mHalfVideoWidth * 9 >= this.mVideoHeight * 16)
    {
      this.mCropValue = calCrop(this.mHalfVideoWidth, this.mVideoHeight, this.mGLViewWidth, this.mGLViewHeight);
      return;
    }
    this.mCropValue = 0.0F;
  }
  
  private float calCrop(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 != 0) && (paramInt3 != 0) && (paramInt1 != 0) && (paramInt4 != 0))
    {
      if (paramInt2 * paramInt3 == paramInt1 * paramInt4) {
        LogUtils.i("Render|PlayTextureView", " crop 0");
      }
    }
    else {
      return 0.0F;
    }
    if (paramInt2 * paramInt3 > paramInt1 * paramInt4)
    {
      f = 0.5F - paramInt4 * paramInt1 * 0.5F / paramInt3 / paramInt2;
      LogUtils.i("Render|PlayTextureView", " crop height = " + f);
      return f;
    }
    float f = paramInt3 * paramInt2 * 0.5F / paramInt4 / paramInt1 - 0.5F;
    LogUtils.i("Render|PlayTextureView", " crop width = " + f);
    return f;
  }
  
  private void callbackError(int paramInt)
  {
    if ((this.mPlayListener != null) && (this.mViewHandler != null)) {
      this.mViewHandler.post(new PlayTextureView.4(this, paramInt));
    }
  }
  
  private void configViewportOnDraw()
  {
    if (this.mIsPortrait) {
      if (this.mHalfVideoWidth < this.mVideoHeight) {
        if (this.mCurRender != null)
        {
          this.mCurRender.setCropValue(this.mCropValue);
          GLES20.glViewport(0, 0, this.mGLViewWidth, this.mGLViewHeight);
        }
      }
    }
    int i;
    int j;
    do
    {
      do
      {
        do
        {
          return;
          i = this.mGLViewWidth * 9 / 16;
          if (this.mHalfVideoWidth != 0) {
            i = this.mGLViewWidth * this.mVideoHeight / this.mHalfVideoWidth;
          }
          j = (this.mGLViewHeight - i) * 2 / 3;
        } while (this.mCurRender == null);
        this.mCurRender.setCropValue(this.mCropValue);
        GLES20.glViewport(0, j, this.mGLViewWidth, i);
        return;
        if (this.mHalfVideoWidth * 9 < this.mVideoHeight * 16) {
          break;
        }
      } while (this.mCurRender == null);
      this.mCurRender.setCropValue(this.mCropValue);
      GLES20.glViewport(0, 0, this.mGLViewWidth, this.mGLViewHeight);
      return;
      i = this.mHalfVideoWidth * this.mGLViewHeight / this.mVideoHeight;
      j = (this.mGLViewWidth - i) / 2;
    } while (this.mCurRender == null);
    this.mCurRender.setCropValue(this.mCropValue);
    GLES20.glViewport(j, 0, i, this.mGLViewHeight);
  }
  
  private boolean fileIsExists(String paramString)
  {
    try
    {
      if (new File(paramString).exists())
      {
        LogUtils.i("Render|PlayTextureView", paramString + "--------->file have exist");
        return true;
      }
      LogUtils.i("Render|PlayTextureView", paramString + "---------->file not exists");
      return false;
    }
    catch (Exception paramString)
    {
      LogUtils.e("Render|PlayTextureView", "--------->fileIsExists exception");
      paramString.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  private String getAssetsFiles(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: new 259	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   10: aload_0
    //   11: getfield 163	com/tencent/ilivesdk/playview/view/PlayTextureView:mContext	Landroid/content/Context;
    //   14: invokevirtual 332	android/content/Context:getFilesDir	()Ljava/io/File;
    //   17: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20: ldc_w 337
    //   23: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 6
    //   35: aload_0
    //   36: aload 6
    //   38: invokespecial 339	com/tencent/ilivesdk/playview/view/PlayTextureView:fileIsExists	(Ljava/lang/String;)Z
    //   41: ifne +107 -> 148
    //   44: aload_0
    //   45: getfield 163	com/tencent/ilivesdk/playview/view/PlayTextureView:mContext	Landroid/content/Context;
    //   48: invokevirtual 343	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   51: astore_3
    //   52: aload_3
    //   53: aload_1
    //   54: invokevirtual 349	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   57: astore_3
    //   58: aload_3
    //   59: invokevirtual 355	java/io/InputStream:available	()I
    //   62: istore_2
    //   63: ldc 12
    //   65: new 259	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 260	java/lang/StringBuilder:<init>	()V
    //   72: ldc_w 357
    //   75: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: iload_2
    //   79: invokevirtual 360	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 256	com/tencent/ilivesdk/utils/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: iload_2
    //   89: newarray byte
    //   91: astore 8
    //   93: aload_3
    //   94: aload 8
    //   96: invokevirtual 364	java/io/InputStream:read	([B)I
    //   99: pop
    //   100: aload_0
    //   101: getfield 163	com/tencent/ilivesdk/playview/view/PlayTextureView:mContext	Landroid/content/Context;
    //   104: aload_1
    //   105: iconst_0
    //   106: invokevirtual 368	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   109: astore_1
    //   110: aload_1
    //   111: astore 5
    //   113: aload_3
    //   114: astore 4
    //   116: aload_1
    //   117: aload 8
    //   119: invokevirtual 374	java/io/FileOutputStream:write	([B)V
    //   122: aload_1
    //   123: astore 5
    //   125: aload_3
    //   126: astore 4
    //   128: aload_1
    //   129: invokevirtual 377	java/io/FileOutputStream:flush	()V
    //   132: aload_3
    //   133: ifnull +7 -> 140
    //   136: aload_3
    //   137: invokevirtual 380	java/io/InputStream:close	()V
    //   140: aload_1
    //   141: ifnull +7 -> 148
    //   144: aload_1
    //   145: invokevirtual 381	java/io/FileOutputStream:close	()V
    //   148: aload 6
    //   150: astore_3
    //   151: aload_3
    //   152: areturn
    //   153: astore 6
    //   155: aconst_null
    //   156: astore_1
    //   157: aconst_null
    //   158: astore_3
    //   159: aload_1
    //   160: astore 5
    //   162: aload_3
    //   163: astore 4
    //   165: aload 6
    //   167: invokevirtual 382	java/io/IOException:printStackTrace	()V
    //   170: aload_3
    //   171: ifnull +7 -> 178
    //   174: aload_3
    //   175: invokevirtual 380	java/io/InputStream:close	()V
    //   178: aload 7
    //   180: astore_3
    //   181: aload_1
    //   182: ifnull -31 -> 151
    //   185: aload_1
    //   186: invokevirtual 381	java/io/FileOutputStream:close	()V
    //   189: aconst_null
    //   190: areturn
    //   191: astore_1
    //   192: aconst_null
    //   193: areturn
    //   194: astore_1
    //   195: aconst_null
    //   196: astore 5
    //   198: aconst_null
    //   199: astore_3
    //   200: aload_3
    //   201: ifnull +7 -> 208
    //   204: aload_3
    //   205: invokevirtual 380	java/io/InputStream:close	()V
    //   208: aload 5
    //   210: ifnull +8 -> 218
    //   213: aload 5
    //   215: invokevirtual 381	java/io/FileOutputStream:close	()V
    //   218: aload_1
    //   219: athrow
    //   220: astore_3
    //   221: goto -81 -> 140
    //   224: astore_1
    //   225: goto -77 -> 148
    //   228: astore_3
    //   229: goto -51 -> 178
    //   232: astore_3
    //   233: goto -25 -> 208
    //   236: astore_3
    //   237: goto -19 -> 218
    //   240: astore_1
    //   241: aconst_null
    //   242: astore 5
    //   244: goto -44 -> 200
    //   247: astore_1
    //   248: aload 4
    //   250: astore_3
    //   251: goto -51 -> 200
    //   254: astore 6
    //   256: aconst_null
    //   257: astore_1
    //   258: goto -99 -> 159
    //   261: astore 6
    //   263: goto -104 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	PlayTextureView
    //   0	266	1	paramString	String
    //   62	27	2	i	int
    //   51	154	3	localObject1	Object
    //   220	1	3	localIOException1	java.io.IOException
    //   228	1	3	localIOException2	java.io.IOException
    //   232	1	3	localIOException3	java.io.IOException
    //   236	1	3	localIOException4	java.io.IOException
    //   250	1	3	localObject2	Object
    //   114	135	4	localObject3	Object
    //   111	132	5	str1	String
    //   33	116	6	str2	String
    //   153	13	6	localIOException5	java.io.IOException
    //   254	1	6	localIOException6	java.io.IOException
    //   261	1	6	localIOException7	java.io.IOException
    //   1	178	7	localObject4	Object
    //   91	27	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   52	58	153	java/io/IOException
    //   185	189	191	java/io/IOException
    //   52	58	194	finally
    //   136	140	220	java/io/IOException
    //   144	148	224	java/io/IOException
    //   174	178	228	java/io/IOException
    //   204	208	232	java/io/IOException
    //   213	218	236	java/io/IOException
    //   58	110	240	finally
    //   116	122	247	finally
    //   128	132	247	finally
    //   165	170	247	finally
    //   58	110	254	java/io/IOException
    //   116	122	261	java/io/IOException
    //   128	132	261	java/io/IOException
  }
  
  private Surface getSurface()
  {
    if ((this.mSurfaceTextureRender != null) && ((this.mSurfaceTextureRender instanceof SurfaceTextureBlendRender))) {
      return ((SurfaceTextureBlendRender)this.mSurfaceTextureRender).getSurface();
    }
    return null;
  }
  
  private void init()
  {
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    setRenderer(this);
    setRenderMode(0);
    setVisibility(8);
  }
  
  private void processDecodeEnd()
  {
    queueEvent(new PlayTextureView.5(this));
  }
  
  private void processDecodeError(int paramInt)
  {
    queueEvent(new PlayTextureView.6(this, paramInt));
  }
  
  private void releaseRenderGLThread()
  {
    if (this.mSurfaceTextureRender != null)
    {
      this.mSurfaceTextureRender.destroy();
      this.mSurfaceTextureRender = null;
    }
    if (this.mRGBARender != null)
    {
      this.mRGBARender.destroy();
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
      this.mSoftDecoder = new SoftwareFileDecoder(this.mLoop);
      this.mSoftDecoder.setDecodeListener(this.mDecodeListener);
      this.mRGBARender = new RGBABlendRender();
      this.mRGBARender.setup();
      this.mHasRGBAData = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.mUseHardwareDecoder = false;
        LogUtils.i("Render|PlayTextureView", "mSurfaceTextureRender Exception switch  soft decode Exception=" + localException);
        localException.printStackTrace();
      }
    }
  }
  
  private void setupFrameListenerOES()
  {
    if ((this.mSurfaceTextureRender != null) && (this.mSurfaceTextureRender.getRenderType() == 1) && (((SurfaceTextureBlendRender)this.mSurfaceTextureRender).getVideoTexture() != null)) {
      ((SurfaceTextureBlendRender)this.mSurfaceTextureRender).getVideoTexture().setOnFrameAvailableListener(new PlayTextureView.11(this));
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
    if ((!this.mViewReady) || (this.mCurRender == null) || (this.mVideoWidth <= 0) || (this.mVideoHeight <= 0)) {
      return;
    }
    if ((this.mNeedConfigViewport) && (this.mVideoWidth > 0) && (this.mVideoHeight > 0) && (this.mGLViewWidth > 0) && (this.mGLViewHeight > 0))
    {
      _calcCropValue();
      configViewportOnDraw();
      this.mNeedConfigViewport = false;
    }
    if (this.mUseHardwareDecoder) {
      this.mCurRender.draw(null, 0, 0, false);
    }
    for (;;)
    {
      if (this.mFrameTime > 0)
      {
        this.mCurFrameCount += 1;
        this.mCurTime = (this.mFrameTime * this.mCurFrameCount);
        this.mViewHandler.post(new PlayTextureView.10(this));
      }
      if (this.mOnPreviewFrameLogTimer.isTimeToWriteLog()) {
        LogUtils.i("Render|PlayTextureView", "onDrawFrame fps= " + this.mOnPreviewFrameLogTimer.getFps());
      }
      if (this.mContentVisible) {
        break;
      }
      GLES20.glClear(16384);
      GLES20.glFinish();
      return;
      synchronized (this.mLock)
      {
        if ((this.mCurRGBAData != null) && (this.mHasRGBAData)) {
          this.mCurRender.draw(this.mCurRGBAData, this.mVideoWidth, this.mVideoHeight, false);
        }
      }
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    LogUtils.i("Render|PlayTextureView", "===================gl render onSurfaceChanged " + paramInt1 + " h=" + paramInt2);
    paramGL10.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    this.mGLViewWidth = paramInt1;
    this.mGLViewHeight = paramInt2;
    if (this.mGLViewWidth > this.mGLViewHeight) {}
    for (boolean bool = false;; bool = true)
    {
      this.mIsPortrait = bool;
      if ((this.mVideoWidth > 0) && (this.mVideoHeight > 0) && (this.mGLViewWidth > 0) && (this.mGLViewHeight > 0)) {
        this.mNeedConfigViewport = true;
      }
      if (!this.mViewReady)
      {
        this.mViewReady = true;
        this.mViewHandler.post(new PlayTextureView.9(this));
      }
      return;
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    LogUtils.i("Render|PlayTextureView", "===================gl render onSurfaceCreated");
    setupDecodeRender();
  }
  
  public void playAssetsFile(String paramString)
  {
    LogUtils.i("Render|PlayTextureView", " playAssetsFile , want to play filename =" + paramString);
    if (this.mPlayStarting)
    {
      LogUtils.i("Render|PlayTextureView", " playAssetsFile , one has played , return");
      return;
    }
    if (this.mViewReady)
    {
      LogUtils.i("Render|PlayTextureView", " playAssetsFile , view not ready , return ");
      return;
    }
    this.mPlayStarting = true;
    paramString = getAssetsFiles(paramString);
    if (paramString != null)
    {
      this.mFilepath = paramString;
      this.mCurRender = null;
      new Thread(new PlayTextureView.3(this)).start();
      setVisibility(0);
      return;
    }
    LogUtils.i("Render|PlayTextureView", "assets file , get error");
    callbackError(-1);
    this.mPlayStarting = false;
  }
  
  public void playFile(String paramString)
  {
    if (this.mStopping) {}
    for (this.mTmpFilePath = paramString;; this.mTmpFilePath = null)
    {
      LogUtils.i("Render|PlayTextureView", " playFile , want to play filepath =" + paramString);
      if (!this.mPlayStarting) {
        break;
      }
      LogUtils.i("Render|PlayTextureView", " playFile , one has played , return");
      return;
    }
    if (this.mViewReady)
    {
      LogUtils.i("Render|PlayTextureView", " playFile , view not ready , return ");
      return;
    }
    this.mPlayStarting = true;
    if (fileIsExists(paramString))
    {
      this.mFilepath = paramString;
      this.mCurRender = null;
      new Thread(new PlayTextureView.2(this)).start();
      setVisibility(0);
      return;
    }
    LogUtils.i("Render|PlayTextureView", " file , get error");
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
    if (this.mHardDecoder != null) {
      this.mHardDecoder.setLoopState(this.mLoop);
    }
    if (this.mSoftDecoder != null) {
      this.mSoftDecoder.setLoopState(this.mLoop);
    }
  }
  
  public void setPlayListener(VideoPLayListener paramVideoPLayListener)
  {
    this.mPlayListener = paramVideoPLayListener;
  }
  
  public void stop()
  {
    LogUtils.i("Render|PlayTextureView", "==============PlayView Stop");
    if (!this.mViewReady) {
      return;
    }
    if (this.mUseHardwareDecoder) {
      if (this.mHardDecoder != null) {
        this.mHardDecoder.stop();
      }
    }
    for (;;)
    {
      this.mStopping = true;
      return;
      if (this.mSoftDecoder != null) {
        this.mSoftDecoder.stop();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.playview.view.PlayTextureView
 * JD-Core Version:    0.7.0.1
 */