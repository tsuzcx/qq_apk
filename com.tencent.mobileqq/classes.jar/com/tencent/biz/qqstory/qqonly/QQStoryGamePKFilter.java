package com.tencent.biz.qqstory.qqonly;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodePlayer;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.filter.QQBaseFilter;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class QQStoryGamePKFilter
  extends QQBaseFilter
{
  public static final int MOVIE_FILTER_MESSAGE_START = 2;
  public static final int MOVIE_FILTER_MESSAGE_STOP = 1;
  public static final String TAG = "QQStoryGamePKFilter";
  private Handler gameDecodeHandler;
  private HandlerThread gameDecodeThread;
  private DecodePlayer mDecodePlayer;
  private boolean mIsSurfaceCreated;
  private float[] mMvpMatrix = new float[16];
  private RenderBuffer mRenderFBO;
  private float[] mRevertMatrix = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  private int mRivalTextureID = -1;
  private SurfaceTexture mSurfaceTexture;
  private TextureRender mTextureRender;
  private String mVideoPath;
  private QQStoryGamePKFilter.OnFrameAvailableListener onFrameAvailableListener;
  
  public QQStoryGamePKFilter(QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(183, paramQQFilterRenderManager);
    initTexture();
  }
  
  private void initTexture()
  {
    Object localObject = this.mRenderFBO;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.mTextureRender;
    if (localObject != null) {
      ((TextureRender)localObject).release();
    }
  }
  
  private void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    if (this.mDecodePlayer.getCurrentState() == 3) {
      this.mSurfaceTexture = paramSurfaceTexture;
    }
  }
  
  private void stopPlay()
  {
    DecodePlayer localDecodePlayer = this.mDecodePlayer;
    if (localDecodePlayer != null) {
      localDecodePlayer.stopPlay();
    }
  }
  
  public boolean isFilterWork()
  {
    return this.mIsSurfaceCreated;
  }
  
  public void onDrawFrame()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDrawFrame: decodePlayer state=");
    ((StringBuilder)localObject).append(this.mDecodePlayer.getCurrentState());
    ((StringBuilder)localObject).append(", rivalTextureId=");
    ((StringBuilder)localObject).append(this.mRivalTextureID);
    ((StringBuilder)localObject).append(", inputTextureId=");
    ((StringBuilder)localObject).append(this.mInputTextureID);
    Log.v("wyx", ((StringBuilder)localObject).toString());
    localObject = this.mDecodePlayer;
    if ((localObject != null) && (((DecodePlayer)localObject).getCurrentState() == 3) && (this.mSurfaceTexture != null) && (!this.mIsSurfaceCreated))
    {
      int i = GLES20.glGetError();
      if ((i != 0) && (SdkContext.getInstance().getLogger().isEnable()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("previousUnknownError: glError 0x");
        ((StringBuilder)localObject).append(Integer.toHexString(i));
        localObject = ((StringBuilder)localObject).toString();
        SdkContext.getInstance().getLogger().e("QQStoryGamePKFilter", (String)localObject);
      }
      if (this.mTextureRender == null) {
        this.mTextureRender = new TextureRender();
      }
      this.mIsSurfaceCreated = true;
    }
    if (this.mIsSurfaceCreated)
    {
      localObject = this.mDecodePlayer;
      if ((localObject != null) && (((DecodePlayer)localObject).getCurrentState() == 3) && (this.mSurfaceTexture != null)) {
        if (this.mRenderFBO == null) {
          this.mRenderFBO = new RenderBuffer(720, 1280, 33984);
        }
      }
    }
    try
    {
      this.mRenderFBO.bind();
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16384);
      this.mSurfaceTexture.updateTexImage();
      Matrix.setIdentityM(this.mMvpMatrix, 0);
      Matrix.translateM(this.mMvpMatrix, 0, 0.5F, 0.0F, 0.0F);
      Matrix.scaleM(this.mMvpMatrix, 0, 0.5F, 0.5F, 1.0F);
      this.mTextureRender.drawTexture(36197, this.mRivalTextureID, null, this.mMvpMatrix);
      Matrix.setIdentityM(this.mMvpMatrix, 0);
      Matrix.translateM(this.mMvpMatrix, 0, -0.5F, 0.0F, 0.0F);
      Matrix.scaleM(this.mMvpMatrix, 0, 0.5F, 0.5F, 1.0F);
      this.mTextureRender.drawTexture(3553, this.mInputTextureID, null, this.mMvpMatrix);
      this.mRenderFBO.unbind();
      this.mOutputTextureID = this.mRenderFBO.getTexId();
      return;
    }
    catch (Throwable localThrowable)
    {
      label394:
      break label394;
    }
    this.mOutputTextureID = this.mInputTextureID;
    return;
    this.mOutputTextureID = this.mInputTextureID;
  }
  
  public void onSurfaceDestroy()
  {
    Object localObject = this.mRenderFBO;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.mTextureRender;
    if (localObject != null) {
      ((TextureRender)localObject).release();
    }
    if (this.gameDecodeHandler != null) {
      this.gameDecodeHandler = null;
    }
    localObject = this.gameDecodeThread;
    if (localObject != null)
    {
      if (((HandlerThread)localObject).isAlive()) {
        this.gameDecodeThread.quit();
      }
      this.gameDecodeThread = null;
    }
    stopPlay();
    this.mIsSurfaceCreated = false;
  }
  
  public void startPlay(String paramString1, String paramString2, boolean paramBoolean, float paramFloat1, float paramFloat2, HWDecodeListener paramHWDecodeListener)
  {
    Object localObject = this.gameDecodeThread;
    if ((localObject == null) || (!((HandlerThread)localObject).isAlive()))
    {
      this.gameDecodeThread = new HandlerThread("GameDecodeThread");
      this.gameDecodeThread.start();
      this.gameDecodeHandler = new QQStoryGamePKFilter.1(this, this.gameDecodeThread.getLooper());
    }
    localObject = this.onFrameAvailableListener;
    if (localObject != null) {
      ((QQStoryGamePKFilter.OnFrameAvailableListener)localObject).disable();
    }
    this.mSurfaceTexture = null;
    if (FileUtil.fileExistsAndNotEmpty(paramString1)) {
      paramString1 = Message.obtain(this.gameDecodeHandler, 2, new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), paramHWDecodeListener });
    } else {
      paramString1 = Message.obtain(this.gameDecodeHandler, 1);
    }
    this.gameDecodeHandler.removeMessages(2);
    this.gameDecodeHandler.removeMessages(1);
    this.gameDecodeHandler.sendMessage(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.qqonly.QQStoryGamePKFilter
 * JD-Core Version:    0.7.0.1
 */