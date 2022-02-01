package com.tencent.live2.impl;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.basic.util.h;
import com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveFillMode;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMode;
import com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat;
import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class V2TXLivePlayerImpl
  extends V2TXLivePlayer
{
  private static final String TAG = "V2-TXLivePlayerImpl";
  private a.b mAsyncState = a.b.a;
  private V2TXLiveDef.V2TXLiveBufferType mBufferType;
  private float mCacheMaxTime;
  private float mCacheMinTime;
  private Context mContext;
  private boolean mEnableCustomRendering;
  private boolean mEnableDebugView;
  private V2TXLivePlayer mInnerPlayer;
  private boolean mIsPauseAudio;
  private boolean mIsPauseVideo;
  private f mMainHandler = new f(Looper.getMainLooper());
  private V2TXLiveDef.V2TXLivePixelFormat mPixelFormat;
  private V2TXLivePlayerObserver mPlayerObserver;
  private int mPlayoutVolume = -1;
  private HashMap<String, Object> mPropertyMap;
  private V2TXLiveDef.V2TXLiveFillMode mRenderFillMode;
  private V2TXLiveDef.V2TXLiveRotation mRenderRotation;
  private Surface mSurface;
  private a.a mSurfaceSize;
  private Object mView;
  private int mVolumeIntervals = -1;
  
  static
  {
    h.f();
  }
  
  public V2TXLivePlayerImpl(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create: context-");
    localStringBuilder.append(paramContext);
    apiLog(localStringBuilder.toString());
    this.mContext = paramContext.getApplicationContext();
    this.mPropertyMap = new HashMap();
  }
  
  private void apiError(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v2_api_player(");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(") ");
    localStringBuilder.append(paramString);
    TXCLog.e("V2-TXLivePlayerImpl", localStringBuilder.toString());
  }
  
  private void apiLog(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v2_api_player(");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(") ");
    localStringBuilder.append(paramString);
    TXCLog.i("V2-TXLivePlayerImpl", localStringBuilder.toString());
  }
  
  private void runOnMainThreadAsync(Runnable paramRunnable)
  {
    this.mMainHandler.post(paramRunnable);
  }
  
  private void setupParams()
  {
    Object localObject1 = this.mInnerPlayer;
    if (localObject1 == null) {
      return;
    }
    ((V2TXLivePlayer)localObject1).setObserver(this.mPlayerObserver);
    ((V2TXLivePlayer)localObject1).enableCustomRendering(this.mEnableCustomRendering, this.mPixelFormat, this.mBufferType);
    Object localObject2 = this.mView;
    if (localObject2 != null) {
      if ((localObject2 instanceof TXCloudVideoView)) {
        ((V2TXLivePlayer)localObject1).setRenderView((TXCloudVideoView)localObject2);
      } else if ((localObject2 instanceof TextureView)) {
        ((V2TXLivePlayer)localObject1).setRenderView((TextureView)localObject2);
      } else if ((localObject2 instanceof SurfaceView)) {
        ((V2TXLivePlayer)localObject1).setRenderView((SurfaceView)localObject2);
      }
    }
    localObject2 = this.mRenderFillMode;
    if (localObject2 != null) {
      ((V2TXLivePlayer)localObject1).setRenderFillMode((V2TXLiveDef.V2TXLiveFillMode)localObject2);
    }
    localObject2 = this.mRenderRotation;
    if (localObject2 != null) {
      ((V2TXLivePlayer)localObject1).setRenderRotation((V2TXLiveDef.V2TXLiveRotation)localObject2);
    }
    if (this.mIsPauseAudio) {
      ((V2TXLivePlayer)localObject1).pauseAudio();
    } else {
      ((V2TXLivePlayer)localObject1).resumeAudio();
    }
    if (this.mIsPauseVideo) {
      ((V2TXLivePlayer)localObject1).pauseVideo();
    } else {
      ((V2TXLivePlayer)localObject1).resumeVideo();
    }
    float f1 = this.mCacheMinTime;
    if (f1 > 0.0F)
    {
      float f2 = this.mCacheMaxTime;
      if (f2 > 0.0F) {
        ((V2TXLivePlayer)localObject1).setCacheParams(f1, f2);
      }
    }
    int i = this.mPlayoutVolume;
    if (i > 0) {
      ((V2TXLivePlayer)localObject1).setPlayoutVolume(i);
    }
    i = this.mVolumeIntervals;
    if (i > 0) {
      ((V2TXLivePlayer)localObject1).enableVolumeEvaluation(i);
    }
    ((V2TXLivePlayer)localObject1).showDebugView(this.mEnableDebugView);
    localObject2 = this.mSurface;
    if (localObject2 != null) {
      ((V2TXLivePlayer)localObject1).setProperty("setSurface", localObject2);
    }
    localObject2 = this.mSurfaceSize;
    if (localObject2 != null) {
      ((V2TXLivePlayer)localObject1).setProperty("setSurfaceSize", localObject2);
    }
    localObject1 = this.mPropertyMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      this.mInnerPlayer.setProperty((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
    }
  }
  
  public int enableCustomRendering(boolean paramBoolean, V2TXLiveDef.V2TXLivePixelFormat paramV2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType paramV2TXLiveBufferType)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableCustomRendering: enable-");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" pixelFormat-");
    localStringBuilder.append(paramV2TXLivePixelFormat);
    localStringBuilder.append(" bufferType-");
    localStringBuilder.append(paramV2TXLiveBufferType);
    apiLog(localStringBuilder.toString());
    runOnMainThreadAsync(new V2TXLivePlayerImpl.18(this, paramBoolean, paramV2TXLivePixelFormat, paramV2TXLiveBufferType));
    return 0;
  }
  
  public int enableVolumeEvaluation(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableVolumeEvaluation: intervalMs-");
    localStringBuilder.append(paramInt);
    apiLog(localStringBuilder.toString());
    runOnMainThreadAsync(new V2TXLivePlayerImpl.16(this, paramInt));
    return 0;
  }
  
  public int isPlaying()
  {
    Object localObject = this.mAsyncState;
    a.b localb = a.b.a;
    int i = 0;
    if (localObject == localb)
    {
      localObject = this.mInnerPlayer;
      if (localObject != null) {
        i = ((V2TXLivePlayer)localObject).isPlaying();
      }
      return i;
    }
    if (this.mAsyncState == a.b.b) {
      return 1;
    }
    if (this.mAsyncState == a.b.c) {}
    return 0;
  }
  
  public int pauseAudio()
  {
    apiLog("pauseAudio: ");
    runOnMainThreadAsync(new V2TXLivePlayerImpl.10(this));
    return 0;
  }
  
  public int pauseVideo()
  {
    apiLog("pauseVideo: ");
    runOnMainThreadAsync(new V2TXLivePlayerImpl.12(this));
    return 0;
  }
  
  public int resumeAudio()
  {
    apiLog("resumeAudio: ");
    runOnMainThreadAsync(new V2TXLivePlayerImpl.11(this));
    return 0;
  }
  
  public int resumeVideo()
  {
    apiLog("resumeVideo: ");
    runOnMainThreadAsync(new V2TXLivePlayerImpl.13(this));
    return 0;
  }
  
  public int setCacheParams(float paramFloat1, float paramFloat2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCacheParams: minTime-");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append(" maxTime-");
    localStringBuilder.append(paramFloat2);
    apiLog(localStringBuilder.toString());
    if ((paramFloat1 > 0.0F) && (paramFloat2 > 0.0F))
    {
      if (isPlaying() == 1)
      {
        apiError("set cache param failed, cant's set param when playing.");
        return -3;
      }
      runOnMainThreadAsync(new V2TXLivePlayerImpl.15(this, paramFloat2, paramFloat1));
      return 0;
    }
    apiError("set cache param failed, invalid cache params.");
    return -2;
  }
  
  public void setObserver(V2TXLivePlayerObserver paramV2TXLivePlayerObserver)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setObserver: observer-");
    localStringBuilder.append(paramV2TXLivePlayerObserver);
    apiLog(localStringBuilder.toString());
    runOnMainThreadAsync(new V2TXLivePlayerImpl.1(this, paramV2TXLivePlayerObserver));
  }
  
  public int setPlayoutVolume(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPlayoutVolume: volume-");
    localStringBuilder.append(paramInt);
    apiLog(localStringBuilder.toString());
    runOnMainThreadAsync(new V2TXLivePlayerImpl.14(this, paramInt));
    return 0;
  }
  
  public int setProperty(String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setProperty: key-");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" value-");
    localStringBuilder.append(paramObject);
    apiLog(localStringBuilder.toString());
    runOnMainThreadAsync(new V2TXLivePlayerImpl.2(this, paramString, paramObject));
    return 0;
  }
  
  public int setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode paramV2TXLiveFillMode)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRenderFillMode: mode-");
    localStringBuilder.append(paramV2TXLiveFillMode);
    apiLog(localStringBuilder.toString());
    runOnMainThreadAsync(new V2TXLivePlayerImpl.7(this, paramV2TXLiveFillMode));
    return 0;
  }
  
  public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRenderRotation: rotation-");
    localStringBuilder.append(paramV2TXLiveRotation);
    apiLog(localStringBuilder.toString());
    runOnMainThreadAsync(new V2TXLivePlayerImpl.6(this, paramV2TXLiveRotation));
    return 0;
  }
  
  public int setRenderView(SurfaceView paramSurfaceView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSurfaceView: view-");
    Object localObject;
    if (paramSurfaceView != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramSurfaceView.hashCode());
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    apiLog(localStringBuilder.toString());
    runOnMainThreadAsync(new V2TXLivePlayerImpl.5(this, paramSurfaceView));
    return 0;
  }
  
  public int setRenderView(TextureView paramTextureView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setTextureView: view-");
    Object localObject;
    if (paramTextureView != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramTextureView.hashCode());
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    apiLog(localStringBuilder.toString());
    runOnMainThreadAsync(new V2TXLivePlayerImpl.4(this, paramTextureView));
    return 0;
  }
  
  public int setRenderView(TXCloudVideoView paramTXCloudVideoView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setTXCloudVideoView: view-");
    Object localObject;
    if (paramTXCloudVideoView != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramTXCloudVideoView.hashCode());
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    apiLog(localStringBuilder.toString());
    runOnMainThreadAsync(new V2TXLivePlayerImpl.3(this, paramTXCloudVideoView));
    return 0;
  }
  
  public void showDebugView(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showDebugView: enable-");
    localStringBuilder.append(paramBoolean);
    apiLog(localStringBuilder.toString());
    runOnMainThreadAsync(new V2TXLivePlayerImpl.19(this, paramBoolean));
  }
  
  public int snapshot()
  {
    if (isPlaying() == 0)
    {
      apiError("snapshot: snapshot is not allowed before the player starts playing.");
      return -3;
    }
    runOnMainThreadAsync(new V2TXLivePlayerImpl.17(this));
    return 0;
  }
  
  public int startPlay(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("startPlay url:");
    ((StringBuilder)localObject1).append(paramString);
    apiLog(((StringBuilder)localObject1).toString());
    if (TextUtils.isEmpty(paramString))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("start play fail, url invalid:");
      ((StringBuilder)localObject1).append(paramString);
      TXCLog.e("V2-TXLivePlayerImpl", ((StringBuilder)localObject1).toString());
      return -2;
    }
    Object localObject2 = b.a(paramString);
    if (localObject2 == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC)
    {
      localObject1 = com.tencent.live2.b.a.b(paramString);
      if ((localObject1 == null) || (!((com.tencent.live2.b.a)localObject1).g()))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("start play fail. invalid param. [url:");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("][param:");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append("]");
        apiError(((StringBuilder)localObject2).toString());
        return -2;
      }
    }
    else
    {
      int i = com.tencent.live2.a.a.a(paramString);
      if (i != 0) {
        return i;
      }
    }
    this.mAsyncState = a.b.b;
    runOnMainThreadAsync(new V2TXLivePlayerImpl.8(this, (V2TXLiveDef.V2TXLiveMode)localObject2, paramString));
    return 0;
  }
  
  public int stopPlay()
  {
    apiLog("stopPlay");
    this.mAsyncState = a.b.c;
    runOnMainThreadAsync(new V2TXLivePlayerImpl.9(this));
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePlayerImpl
 * JD-Core Version:    0.7.0.1
 */