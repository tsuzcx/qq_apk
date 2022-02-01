package com.tencent.live2.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.basic.util.h;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.live2.V2TXLiveDef.V2TXLiveAudioQuality;
import com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMirrorType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMode;
import com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat;
import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.V2TXLiveDef.V2TXLiveTranscodingConfig;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoFrame;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolutionMode;
import com.tencent.live2.V2TXLivePusher;
import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.live2.b.e;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class V2TXLivePusherImpl
  extends V2TXLivePusher
{
  private static final String TAG = "V2-TXLivePusherImpl";
  private a.b mAsyncState = a.b.a;
  private Context mContext;
  private V2TXLivePusher mInnerPusher;
  private f mMainHandler = new f(Looper.getMainLooper());
  private String mURL;
  private V2TXLiveDef.V2TXLiveMode mURLMode;
  
  static
  {
    h.f();
  }
  
  public V2TXLivePusherImpl(Context paramContext, V2TXLiveDef.V2TXLiveMode paramV2TXLiveMode)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mURLMode = paramV2TXLiveMode;
    if (paramV2TXLiveMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC)
    {
      this.mInnerPusher = new e(this.mContext);
      return;
    }
    this.mInnerPusher = new com.tencent.live2.a.b(this.mContext);
  }
  
  private void apiOnlineError(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (paramBoolean)
    {
      paramString = new StringBuilder();
      paramString.append("v2_api_pusher(");
      paramString.append(hashCode());
      paramString.append(")");
      Monitor.a(1, paramString.toString(), str, 0);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("v2_api_pusher(");
    paramString.append(hashCode());
    paramString.append(") ");
    paramString.append(str);
    TXCLog.e("V2-TXLivePusherImpl", paramString.toString());
  }
  
  private void apiOnlineLog(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (paramBoolean)
    {
      paramString = new StringBuilder();
      paramString.append("v2_api_pusher(");
      paramString.append(hashCode());
      paramString.append(")");
      Monitor.a(1, paramString.toString(), str, 0);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("v2_api_pusher(");
    paramString.append(hashCode());
    paramString.append(") ");
    paramString.append(str);
    TXCLog.i("V2-TXLivePusherImpl", paramString.toString());
  }
  
  private void runOnMainThreadAsync(Runnable paramRunnable)
  {
    this.mMainHandler.post(paramRunnable);
  }
  
  public int enableCustomVideoCapture(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableCustomVideoCapture:");
    localStringBuilder.append(paramBoolean);
    apiOnlineLog(localStringBuilder.toString(), false);
    runOnMainThreadAsync(new V2TXLivePusherImpl.24(this, paramBoolean));
    return 0;
  }
  
  public int enableCustomVideoProcess(boolean paramBoolean, V2TXLiveDef.V2TXLivePixelFormat paramV2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType paramV2TXLiveBufferType)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enableCustomVideoProcess：");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" format:");
    ((StringBuilder)localObject).append(paramV2TXLivePixelFormat);
    ((StringBuilder)localObject).append("type:");
    ((StringBuilder)localObject).append(paramV2TXLiveBufferType);
    apiOnlineLog(((StringBuilder)localObject).toString(), false);
    if (paramBoolean)
    {
      localObject = this.mURLMode;
      V2TXLiveDef.V2TXLiveMode localV2TXLiveMode = V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC;
      int i = 1;
      int j = 1;
      if (localObject == localV2TXLiveMode)
      {
        if (paramV2TXLivePixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D)
        {
          i = j;
          if (paramV2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture) {}
        }
        else if (paramV2TXLivePixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420)
        {
          i = j;
          if (paramV2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteBuffer) {}
        }
        else if ((paramV2TXLivePixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420) && (paramV2TXLiveBufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray))
        {
          i = j;
        }
        else
        {
          i = 0;
        }
        if (i == 0)
        {
          apiOnlineError("enable custom video process fail. nonsupport format or type.", false);
          return -4;
        }
      }
      else if (this.mURLMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP)
      {
        if ((paramV2TXLivePixelFormat != V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D) || (paramV2TXLiveBufferType != V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture)) {
          i = 0;
        }
        if (i == 0)
        {
          apiOnlineError("enable custom video process fail. nonsupport format or type.", false);
          return -4;
        }
      }
    }
    runOnMainThreadAsync(new V2TXLivePusherImpl.23(this, paramBoolean, paramV2TXLivePixelFormat, paramV2TXLiveBufferType));
    return 0;
  }
  
  public int enableVolumeEvaluation(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableVolumeEvaluation:");
    localStringBuilder.append(paramInt);
    apiOnlineLog(localStringBuilder.toString(), false);
    runOnMainThreadAsync(new V2TXLivePusherImpl.22(this, paramInt));
    return 0;
  }
  
  public TXAudioEffectManager getAudioEffectManager()
  {
    return this.mInnerPusher.getAudioEffectManager();
  }
  
  public TXBeautyManager getBeautyManager()
  {
    return this.mInnerPusher.getBeautyManager();
  }
  
  public TXDeviceManager getDeviceManager()
  {
    return this.mInnerPusher.getDeviceManager();
  }
  
  public int isPushing()
  {
    Object localObject = this.mAsyncState;
    a.b localb = a.b.a;
    int i = 0;
    if (localObject == localb)
    {
      localObject = this.mInnerPusher;
      if (localObject != null) {
        i = ((V2TXLivePusher)localObject).isPushing();
      }
      return i;
    }
    if (this.mAsyncState == a.b.b) {
      return 1;
    }
    if (this.mAsyncState == a.b.c) {}
    return 0;
  }
  
  public int sendCustomVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame)
  {
    if (paramV2TXLiveVideoFrame == null)
    {
      apiOnlineError("sendCustomVideoFrame frame is null.", false);
      return -2;
    }
    return this.mInnerPusher.sendCustomVideoFrame(paramV2TXLiveVideoFrame);
  }
  
  public int setAudioQuality(V2TXLiveDef.V2TXLiveAudioQuality paramV2TXLiveAudioQuality)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAudioQuality: quality-");
    localStringBuilder.append(paramV2TXLiveAudioQuality);
    apiOnlineLog(localStringBuilder.toString(), false);
    runOnMainThreadAsync(new V2TXLivePusherImpl.17(this, paramV2TXLiveAudioQuality));
    return 0;
  }
  
  public int setEncoderMirror(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setEncoderMirror:");
    localStringBuilder.append(paramBoolean);
    apiOnlineLog(localStringBuilder.toString(), false);
    runOnMainThreadAsync(new V2TXLivePusherImpl.21(this, paramBoolean));
    return 0;
  }
  
  public int setMixTranscodingConfig(V2TXLiveDef.V2TXLiveTranscodingConfig paramV2TXLiveTranscodingConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setMixTranscodingConfig: config-");
    localStringBuilder.append(paramV2TXLiveTranscodingConfig);
    apiOnlineLog(localStringBuilder.toString(), false);
    if (isPushing() != 1)
    {
      apiOnlineError("set mix transcoding config failed. pusher can't set mix transcoding config before calling startPush.", false);
      return -3;
    }
    if (this.mURLMode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP)
    {
      apiOnlineError("set mix transcoding config failed. pusher isn't support set mix transcoding when RTMP mode.", false);
      return -4;
    }
    if (paramV2TXLiveTranscodingConfig == null) {
      paramV2TXLiveTranscodingConfig = null;
    } else {
      paramV2TXLiveTranscodingConfig = new V2TXLiveDef.V2TXLiveTranscodingConfig(paramV2TXLiveTranscodingConfig);
    }
    runOnMainThreadAsync(new V2TXLivePusherImpl.3(this, paramV2TXLiveTranscodingConfig));
    return 0;
  }
  
  public void setObserver(V2TXLivePusherObserver paramV2TXLivePusherObserver)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setObserver: ");
    localStringBuilder.append(paramV2TXLivePusherObserver);
    apiOnlineLog(localStringBuilder.toString(), false);
    runOnMainThreadAsync(new V2TXLivePusherImpl.1(this, paramV2TXLivePusherObserver));
  }
  
  public int setProperty(String paramString, Object paramObject)
  {
    if (paramString != "sendSEIMessage")
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setProperty: key-");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" value-");
      localStringBuilder.append(paramObject);
      apiOnlineLog(localStringBuilder.toString(), false);
    }
    runOnMainThreadAsync(new V2TXLivePusherImpl.2(this, paramString, paramObject));
    return 0;
  }
  
  public int setRenderMirror(V2TXLiveDef.V2TXLiveMirrorType paramV2TXLiveMirrorType)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRenderMirror: type-");
    localStringBuilder.append(paramV2TXLiveMirrorType);
    apiOnlineLog(localStringBuilder.toString(), false);
    runOnMainThreadAsync(new V2TXLivePusherImpl.7(this, paramV2TXLiveMirrorType));
    return 0;
  }
  
  public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRenderRotation: rotation-");
    localStringBuilder.append(paramV2TXLiveRotation);
    apiOnlineLog(localStringBuilder.toString(), false);
    runOnMainThreadAsync(new V2TXLivePusherImpl.8(this, paramV2TXLiveRotation));
    return 0;
  }
  
  public int setRenderView(SurfaceView paramSurfaceView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRenderView: view-");
    String str;
    if (paramSurfaceView != null) {
      str = String.valueOf(paramSurfaceView.hashCode());
    } else {
      str = "null";
    }
    localStringBuilder.append(str);
    apiOnlineLog(localStringBuilder.toString(), false);
    runOnMainThreadAsync(new V2TXLivePusherImpl.6(this, paramSurfaceView));
    return 0;
  }
  
  public int setRenderView(TextureView paramTextureView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRenderView: view-");
    String str;
    if (paramTextureView != null) {
      str = String.valueOf(paramTextureView.hashCode());
    } else {
      str = "null";
    }
    localStringBuilder.append(str);
    apiOnlineLog(localStringBuilder.toString(), false);
    runOnMainThreadAsync(new V2TXLivePusherImpl.5(this, paramTextureView));
    return 0;
  }
  
  public int setRenderView(TXCloudVideoView paramTXCloudVideoView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRenderView: view-");
    String str;
    if (paramTXCloudVideoView != null) {
      str = String.valueOf(paramTXCloudVideoView.hashCode());
    } else {
      str = "null";
    }
    localStringBuilder.append(str);
    apiOnlineLog(localStringBuilder.toString(), false);
    runOnMainThreadAsync(new V2TXLivePusherImpl.4(this, paramTXCloudVideoView));
    return 0;
  }
  
  public int setVideoQuality(V2TXLiveDef.V2TXLiveVideoResolution paramV2TXLiveVideoResolution, V2TXLiveDef.V2TXLiveVideoResolutionMode paramV2TXLiveVideoResolutionMode)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVideoQuality: resolution-");
    localStringBuilder.append(paramV2TXLiveVideoResolution);
    localStringBuilder.append(" mode-");
    localStringBuilder.append(paramV2TXLiveVideoResolutionMode);
    apiOnlineLog(localStringBuilder.toString(), false);
    runOnMainThreadAsync(new V2TXLivePusherImpl.18(this, paramV2TXLiveVideoResolution, paramV2TXLiveVideoResolutionMode));
    return 0;
  }
  
  public int setWatermark(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setWatermark:");
    localStringBuilder.append(paramBitmap);
    localStringBuilder.append(" x-");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append(" y-");
    localStringBuilder.append(paramFloat2);
    localStringBuilder.append("scale-");
    localStringBuilder.append(paramFloat3);
    apiOnlineLog(localStringBuilder.toString(), false);
    runOnMainThreadAsync(new V2TXLivePusherImpl.20(this, paramBitmap, paramFloat1, paramFloat2, paramFloat3));
    return 0;
  }
  
  public void showDebugView(boolean paramBoolean)
  {
    runOnMainThreadAsync(new V2TXLivePusherImpl.25(this, paramBoolean));
  }
  
  public int snapshot()
  {
    if (isPushing() == 0)
    {
      apiOnlineError("snapshot: snapshot is not allowed before the pusher starts pushing.", false);
      return -3;
    }
    apiOnlineLog("snapshot", false);
    runOnMainThreadAsync(new V2TXLivePusherImpl.19(this));
    return 0;
  }
  
  public int startCamera(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startCamera: frontCamera-");
    localStringBuilder.append(paramBoolean);
    apiOnlineLog(localStringBuilder.toString(), true);
    runOnMainThreadAsync(new V2TXLivePusherImpl.9(this, paramBoolean));
    return 0;
  }
  
  public int startMicrophone()
  {
    apiOnlineLog("startMicrophone", true);
    runOnMainThreadAsync(new V2TXLivePusherImpl.13(this));
    return 0;
  }
  
  public int startPush(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startPush: url:");
    ((StringBuilder)localObject).append(b.b(paramString));
    apiOnlineLog(((StringBuilder)localObject).toString(), true);
    if (TextUtils.isEmpty(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startPush fail, url invalid:");
      ((StringBuilder)localObject).append(paramString);
      apiOnlineError(((StringBuilder)localObject).toString(), false);
      return -2;
    }
    localObject = b.a(paramString);
    if (localObject != this.mURLMode)
    {
      apiOnlineError("start push fail. invalid mode.", false);
      return -2;
    }
    if (localObject == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC)
    {
      localObject = com.tencent.live2.b.b.a(paramString);
      if ((localObject == null) || (!((com.tencent.live2.b.b)localObject).a()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("start push fail. invalid param. [url:");
        localStringBuilder.append(paramString);
        localStringBuilder.append("][param:");
        localStringBuilder.append(localObject);
        localStringBuilder.append("]");
        apiOnlineError(localStringBuilder.toString(), false);
        return -2;
      }
    }
    this.mAsyncState = a.b.b;
    runOnMainThreadAsync(new V2TXLivePusherImpl.15(this, paramString));
    return 0;
  }
  
  public int startScreenCapture()
  {
    apiOnlineLog("startScreenCapture:", true);
    runOnMainThreadAsync(new V2TXLivePusherImpl.11(this));
    return 0;
  }
  
  public int stopCamera()
  {
    apiOnlineLog("stopCamera", true);
    runOnMainThreadAsync(new V2TXLivePusherImpl.10(this));
    return 0;
  }
  
  public int stopMicrophone()
  {
    apiOnlineLog("stopMicrophone", true);
    runOnMainThreadAsync(new V2TXLivePusherImpl.14(this));
    return 0;
  }
  
  public int stopPush()
  {
    apiOnlineLog("stopPush", true);
    this.mAsyncState = a.b.c;
    runOnMainThreadAsync(new V2TXLivePusherImpl.16(this));
    return 0;
  }
  
  public int stopScreenCapture()
  {
    apiOnlineLog("stopScreenCapture: ", true);
    runOnMainThreadAsync(new V2TXLivePusherImpl.12(this));
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePusherImpl
 * JD-Core Version:    0.7.0.1
 */