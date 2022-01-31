package com.tencent.jalpha.videoplayer.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import com.tencent.jalpha.common.IntervalFpsLogTimer;
import com.tencent.jalpha.common.Logger;
import com.tencent.jalpha.common.Utils;
import com.tencent.jalpha.videoplayer.decoder.HardwareFileDecoder;
import com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecodeListener;
import com.tencent.jalpha.videoplayer.interfaces.IVideoFileDecoder;
import com.tencent.jalpha.videoplayer.interfaces.IVideoPLayListener;
import com.tencent.jalpha.videoplayer.render.BaseRender;
import com.tencent.jalpha.videoplayer.render.RenderFactory;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class JalphaTextureView
  extends GLTextureView
  implements GLSurfaceView.Renderer
{
  private final int DEFAULT_FRAME_RATE = 25;
  private String TAG = "VideoPlayer|PlayView";
  private boolean mContentVisible = true;
  private Context mContext;
  private int mCurFrameCount = 0;
  private BaseRender mCurRender = null;
  private long mCurTime = 0L;
  private IVideoFileDecodeListener mDecodeListener = new JalphaTextureView.1(this);
  private Thread mDecodeThread = null;
  private RenderFactory mFactory;
  private String mFilepath = null;
  private int mFrameTime = 0;
  private int mGLViewHeight = 0;
  private int mGLViewWidth = 0;
  private IVideoFileDecoder mHardDecoder = null;
  private Runnable mHardwareDecodeWaitForRunnable = new JalphaTextureView.6(this);
  private Object mLock = new Object();
  private boolean mLoop = false;
  private boolean mNeedConfigViewport = true;
  private IntervalFpsLogTimer mOnPreviewFrameLogTimer = new IntervalFpsLogTimer(4000);
  private IVideoPLayListener mPlayListener = null;
  private boolean mPlayStarting = false;
  private boolean mStopping = false;
  private BaseRender mSurfaceTextureRender = null;
  private String mTmpFilePath = null;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  private Handler mViewHandler = new Handler();
  private boolean mViewReady = false;
  
  public JalphaTextureView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public JalphaTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public JalphaTextureView(Context paramContext, IVideoPLayListener paramIVideoPLayListener)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mPlayListener = paramIVideoPLayListener;
    init();
  }
  
  private void callbackError(int paramInt)
  {
    if ((this.mPlayListener != null) && (this.mViewHandler != null)) {
      this.mViewHandler.post(new JalphaTextureView.3(this, paramInt));
    }
  }
  
  private void configViewportOnDraw()
  {
    if (this.mCurRender != null) {
      GLES20.glViewport(0, 0, this.mGLViewWidth, this.mGLViewHeight);
    }
  }
  
  private Surface getSurface()
  {
    if (this.mSurfaceTextureRender != null) {
      return this.mSurfaceTextureRender.getSurface();
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
    queueEvent(new JalphaTextureView.4(this));
  }
  
  private void processDecodeError(int paramInt)
  {
    queueEvent(new JalphaTextureView.5(this, paramInt));
  }
  
  private void releaseRenderGLThread()
  {
    if (this.mSurfaceTextureRender != null)
    {
      this.mSurfaceTextureRender.destroy();
      this.mSurfaceTextureRender = null;
    }
  }
  
  private void setupDecodeRender()
  {
    this.mHardDecoder = new HardwareFileDecoder(this.mLoop);
    this.mHardDecoder.setDecodeListener(this.mDecodeListener);
    try
    {
      this.mSurfaceTextureRender = this.mFactory.createRender();
      this.mSurfaceTextureRender.setup();
      setupFrameListenerOES();
      return;
    }
    catch (Exception localException)
    {
      Logger.v(this.TAG, "mSurfaceTextureRender Exception switch  soft decode Exception=" + localException);
      localException.printStackTrace();
    }
  }
  
  private void setupFrameListenerOES()
  {
    if ((this.mSurfaceTextureRender != null) && (this.mSurfaceTextureRender.getRenderType() == 1) && (this.mSurfaceTextureRender.getVideoTexture() != null)) {
      this.mSurfaceTextureRender.getVideoTexture().setOnFrameAvailableListener(new JalphaTextureView.9(this));
    }
  }
  
  private void startDecode()
  {
    this.mFrameTime = 0;
    this.mDecodeThread = new Thread(this.mHardwareDecodeWaitForRunnable);
    this.mDecodeThread.start();
  }
  
  public boolean getContentVisible()
  {
    return this.mContentVisible;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if ((!this.mViewReady) || (this.mCurRender == null) || (this.mVideoWidth <= 0) || (this.mVideoHeight <= 0)) {}
    do
    {
      return;
      if ((this.mNeedConfigViewport) && (this.mVideoWidth > 0) && (this.mVideoHeight > 0) && (this.mGLViewWidth > 0) && (this.mGLViewHeight > 0))
      {
        configViewportOnDraw();
        if (this.mSurfaceTextureRender != null) {
          this.mSurfaceTextureRender.updateSize(this.mGLViewWidth, this.mGLViewHeight, this.mVideoWidth, this.mVideoHeight);
        }
        this.mNeedConfigViewport = false;
      }
      this.mCurRender.draw(null, this.mGLViewWidth, this.mGLViewHeight);
      if (this.mFrameTime > 0)
      {
        this.mCurFrameCount += 1;
        this.mCurTime = (this.mFrameTime * this.mCurFrameCount);
        this.mViewHandler.post(new JalphaTextureView.8(this));
      }
      if (this.mOnPreviewFrameLogTimer.isTimeToWriteLog()) {
        Logger.i(this.TAG, "onDrawFrame fps= " + this.mOnPreviewFrameLogTimer.getFps());
      }
    } while (this.mContentVisible);
    GLES20.glClear(16384);
    GLES20.glFinish();
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    Logger.e(this.TAG, "===================gl render onSurfaceChanged " + paramInt1 + " h=" + paramInt2);
    paramGL10.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    this.mGLViewWidth = paramInt1;
    this.mGLViewHeight = paramInt2;
    this.mNeedConfigViewport = true;
    if (!this.mViewReady)
    {
      this.mViewReady = true;
      this.mViewHandler.post(new JalphaTextureView.7(this));
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    Logger.e(this.TAG, "===================gl render onSurfaceCreated");
    setupDecodeRender();
  }
  
  public void playFile(String paramString)
  {
    if (this.mStopping) {}
    for (this.mTmpFilePath = paramString;; this.mTmpFilePath = null)
    {
      Logger.e(this.TAG, " playFile , want to play filepath =" + paramString);
      if (!this.mPlayStarting) {
        break;
      }
      Logger.v(this.TAG, " playFile , one has already in playing , return");
      return;
    }
    this.mPlayStarting = true;
    if (Utils.fileIsExists(paramString))
    {
      this.mFilepath = paramString;
      this.mCurRender = null;
      new Thread(new JalphaTextureView.2(this)).start();
      setVisibility(0);
      return;
    }
    Logger.e(this.TAG, " file , get error");
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
  }
  
  public void setNeedLowPrecision(boolean paramBoolean) {}
  
  public void setPlayListener(IVideoPLayListener paramIVideoPLayListener)
  {
    this.mPlayListener = paramIVideoPLayListener;
  }
  
  public void setRenderFactory(RenderFactory paramRenderFactory)
  {
    this.mFactory = paramRenderFactory;
  }
  
  public void stop()
  {
    Log.v(this.TAG, "==============PlayView Stop");
    if (!this.mViewReady) {
      return;
    }
    if (this.mHardDecoder != null) {
      this.mHardDecoder.stop();
    }
    setVisibility(8);
    this.mStopping = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.jalpha.videoplayer.view.JalphaTextureView
 * JD-Core Version:    0.7.0.1
 */