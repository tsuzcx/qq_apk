package com.tencent.live2;

import android.graphics.Bitmap;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.rtmp.ui.TXCloudVideoView;

public abstract class V2TXLivePusher
{
  public abstract int enableCustomVideoCapture(boolean paramBoolean);
  
  public abstract int enableCustomVideoProcess(boolean paramBoolean, V2TXLiveDef.V2TXLivePixelFormat paramV2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType paramV2TXLiveBufferType);
  
  public abstract int enableVolumeEvaluation(int paramInt);
  
  public abstract TXAudioEffectManager getAudioEffectManager();
  
  public abstract TXBeautyManager getBeautyManager();
  
  public abstract TXDeviceManager getDeviceManager();
  
  public abstract int isPushing();
  
  public abstract int sendCustomVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame);
  
  public abstract int setAudioQuality(V2TXLiveDef.V2TXLiveAudioQuality paramV2TXLiveAudioQuality);
  
  public abstract int setEncoderMirror(boolean paramBoolean);
  
  public abstract int setMixTranscodingConfig(V2TXLiveDef.V2TXLiveTranscodingConfig paramV2TXLiveTranscodingConfig);
  
  public abstract void setObserver(V2TXLivePusherObserver paramV2TXLivePusherObserver);
  
  public abstract int setProperty(String paramString, Object paramObject);
  
  public abstract int setRenderMirror(V2TXLiveDef.V2TXLiveMirrorType paramV2TXLiveMirrorType);
  
  public abstract int setRenderRotation(V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation);
  
  public abstract int setRenderView(SurfaceView paramSurfaceView);
  
  public abstract int setRenderView(TextureView paramTextureView);
  
  public abstract int setRenderView(TXCloudVideoView paramTXCloudVideoView);
  
  public abstract int setVideoQuality(V2TXLiveDef.V2TXLiveVideoResolution paramV2TXLiveVideoResolution, V2TXLiveDef.V2TXLiveVideoResolutionMode paramV2TXLiveVideoResolutionMode);
  
  public abstract int setWatermark(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void showDebugView(boolean paramBoolean);
  
  public abstract int snapshot();
  
  public abstract int startCamera(boolean paramBoolean);
  
  public abstract int startMicrophone();
  
  public abstract int startPush(String paramString);
  
  public abstract int startScreenCapture();
  
  public abstract int stopCamera();
  
  public abstract int stopMicrophone();
  
  public abstract int stopPush();
  
  public abstract int stopScreenCapture();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.V2TXLivePusher
 * JD-Core Version:    0.7.0.1
 */