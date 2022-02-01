package com.tencent.live2.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.live2.V2TXLiveDef.V2TXLiveAudioQuality;
import com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMirrorType;
import com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat;
import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.V2TXLiveDef.V2TXLiveTranscodingConfig;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoFrame;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolutionMode;
import com.tencent.live2.V2TXLivePusher;
import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.live2.impl.a.a;
import com.tencent.live2.impl.a.c;
import com.tencent.live2.impl.a.g;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef.TRTCScreenShareParams;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoFrameListener;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  extends V2TXLivePusher
  implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, f.a, TRTCCloudListener.TRTCVideoFrameListener
{
  private Context a;
  private f b;
  private Handler c = new Handler(Looper.getMainLooper());
  private V2TXLiveDef.V2TXLiveAudioQuality d = V2TXLiveDef.V2TXLiveAudioQuality.V2TXLiveAudioQualityDefault;
  private V2TXLivePusherObserver e;
  private int f;
  private TXCloudVideoView g;
  private TextureView h;
  private SurfaceView i;
  private Surface j;
  private int k;
  private int l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private a.c q;
  private boolean r;
  private V2TXLiveDef.V2TXLivePixelFormat s;
  private V2TXLiveDef.V2TXLiveBufferType t;
  private boolean u;
  private boolean v;
  private int w = 4;
  
  public e(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    f.a(paramContext);
  }
  
  private void a()
  {
    this.v = false;
    this.u = false;
    this.w = 4;
    c();
    f localf = this.b;
    if (localf != null)
    {
      localf.h();
      f.a(this.b);
      this.b = null;
      return;
    }
    stopCamera();
    stopMicrophone();
    stopScreenCapture();
    enableCustomVideoCapture(false);
    f.a(null, 0, 0);
  }
  
  private static void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enableAGC enable: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", level: ");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.i("V2-TXTRTCPusherImpl", ((StringBuilder)localObject).toString());
    localObject = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("api", "enableAudioAGC");
        JSONObject localJSONObject = new JSONObject();
        if (paramBoolean)
        {
          i1 = 1;
          localJSONObject.put("enable", i1);
          if (paramInt > 0) {
            localJSONObject.put("level", paramInt);
          }
          ((JSONObject)localObject).put("params", localJSONObject);
          f.b(((JSONObject)localObject).toString());
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      int i1 = 0;
    }
  }
  
  private void b()
  {
    Object localObject1 = this.h;
    Object localObject2 = this.i;
    Surface localSurface = this.j;
    if (localObject1 != null)
    {
      ((TextureView)localObject1).setSurfaceTextureListener(this);
      localObject2 = ((TextureView)localObject1).getSurfaceTexture();
      if (localObject2 != null)
      {
        b("bindRenderView surface texture is valid, set into player.");
        f.a(new Surface((SurfaceTexture)localObject2));
        f.a(((TextureView)localObject1).getWidth(), ((TextureView)localObject1).getHeight());
      }
    }
    else if (localObject2 != null)
    {
      ((SurfaceView)localObject2).getHolder().addCallback(this);
      localObject1 = ((SurfaceView)localObject2).getHolder().getSurface();
      if (((Surface)localObject1).isValid())
      {
        b("bindRenderView surface is valid, set into player.");
        f.a((Surface)localObject1);
        f.a(((SurfaceView)localObject2).getWidth(), ((SurfaceView)localObject2).getHeight());
      }
    }
    else if (localSurface != null)
    {
      f.a(localSurface);
      f.a(this.k, this.l);
    }
  }
  
  private void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v2_api_trtc_pusher(");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(") ");
    localStringBuilder.append(paramString);
    TXCLog.i("V2-TXTRTCPusherImpl", localStringBuilder.toString());
  }
  
  private static void b(boolean paramBoolean, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enableANS enable: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", level: ");
    ((StringBuilder)localObject).append(paramInt);
    TXCLog.i("V2-TXTRTCPusherImpl", ((StringBuilder)localObject).toString());
    localObject = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("api", "enableAudioANS");
        JSONObject localJSONObject = new JSONObject();
        if (paramBoolean)
        {
          i1 = 1;
          localJSONObject.put("enable", i1);
          if (paramInt > 0) {
            localJSONObject.put("level", paramInt);
          }
          ((JSONObject)localObject).put("params", localJSONObject);
          f.b(((JSONObject)localObject).toString());
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      int i1 = 0;
    }
  }
  
  private void c()
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      b("unbindRenderView unbind texture view.");
      ((TextureView)localObject).setSurfaceTextureListener(null);
      f.a(null);
      f.a(0, 0);
    }
    localObject = this.i;
    if (localObject != null)
    {
      b("unbindRenderView unbind surface view.");
      ((SurfaceView)localObject).getHolder().removeCallback(this);
      f.a(null);
      f.a(0, 0);
    }
    if (this.j != null)
    {
      b("unbindRenderView: unbind surface.");
      f.a(null);
      f.a(0, 0);
    }
  }
  
  private void c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v2_api_trtc_pusher(");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(") ");
    localStringBuilder.append(paramString);
    TXCLog.e("V2-TXTRTCPusherImpl", localStringBuilder.toString());
  }
  
  private void d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v2_api_trtc_pusher(");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(") ");
    localStringBuilder.append(paramString);
    TXCLog.w("V2-TXTRTCPusherImpl", localStringBuilder.toString());
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExitRoomByServer reason:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" stop push.");
    c(localStringBuilder.toString());
    a();
  }
  
  public void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnterRoomFail reason:");
    localStringBuilder.append(paramLong);
    c(localStringBuilder.toString());
    a();
  }
  
  public void a(String paramString) {}
  
  public int enableCustomVideoCapture(boolean paramBoolean)
  {
    f.b(paramBoolean);
    return 0;
  }
  
  public int enableCustomVideoProcess(boolean paramBoolean, V2TXLiveDef.V2TXLivePixelFormat paramV2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType paramV2TXLiveBufferType)
  {
    this.r = paramBoolean;
    this.s = paramV2TXLivePixelFormat;
    this.t = paramV2TXLiveBufferType;
    if (paramBoolean)
    {
      f.a(this, com.tencent.live2.impl.b.a(paramV2TXLivePixelFormat), com.tencent.live2.impl.b.a(paramV2TXLiveBufferType));
      return 0;
    }
    f.a(null, 0, 0);
    return 0;
  }
  
  public int enableVolumeEvaluation(int paramInt)
  {
    this.f = paramInt;
    f localf = this.b;
    if (localf != null) {
      localf.b(paramInt);
    }
    return 0;
  }
  
  public TXAudioEffectManager getAudioEffectManager()
  {
    return f.e();
  }
  
  public TXBeautyManager getBeautyManager()
  {
    return f.f();
  }
  
  public TXDeviceManager getDeviceManager()
  {
    return f.g();
  }
  
  public int isPushing()
  {
    f localf = this.b;
    int i1 = 0;
    boolean bool;
    if (localf != null) {
      bool = localf.i();
    } else {
      bool = false;
    }
    if (bool) {
      i1 = 1;
    }
    return i1;
  }
  
  public void onGLContextCreated()
  {
    b("onGLContextCreated");
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.e;
    if (localV2TXLivePusherObserver != null) {
      localV2TXLivePusherObserver.onGLContextCreated();
    }
  }
  
  public void onGLContextDestory()
  {
    b("onGLContextDestory");
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.e;
    if (localV2TXLivePusherObserver != null) {
      localV2TXLivePusherObserver.onGLContextDestroyed();
    }
  }
  
  public int onProcessVideoFrame(TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame1, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame2)
  {
    paramTRTCVideoFrame1 = com.tencent.live2.impl.b.a(paramTRTCVideoFrame1);
    V2TXLiveDef.V2TXLiveVideoFrame localV2TXLiveVideoFrame = com.tencent.live2.impl.b.a(paramTRTCVideoFrame2);
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.e;
    if (localV2TXLivePusherObserver != null)
    {
      localV2TXLivePusherObserver.onProcessVideoFrame(paramTRTCVideoFrame1, localV2TXLiveVideoFrame);
      com.tencent.live2.impl.b.a(localV2TXLiveVideoFrame, paramTRTCVideoFrame2);
    }
    return 0;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceTextureAvailable surface: ");
    localStringBuilder.append(paramSurfaceTexture);
    localStringBuilder.append(", width: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height: ");
    localStringBuilder.append(paramInt2);
    b(localStringBuilder.toString());
    if (paramSurfaceTexture != null) {
      f.a(new Surface(paramSurfaceTexture));
    }
    f.a(paramInt1, paramInt2);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceTextureDestroyed surface: ");
    localStringBuilder.append(paramSurfaceTexture);
    b(localStringBuilder.toString());
    f.a(null);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceTextureSizeChanged surface: ");
    localStringBuilder.append(paramSurfaceTexture);
    localStringBuilder.append(", width: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height: ");
    localStringBuilder.append(paramInt2);
    b(localStringBuilder.toString());
    f.a(paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public int sendCustomVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame)
  {
    f.a(paramV2TXLiveVideoFrame);
    return 0;
  }
  
  public int setAudioQuality(V2TXLiveDef.V2TXLiveAudioQuality paramV2TXLiveAudioQuality)
  {
    V2TXLiveDef.V2TXLiveAudioQuality localV2TXLiveAudioQuality = paramV2TXLiveAudioQuality;
    if (paramV2TXLiveAudioQuality == null) {
      localV2TXLiveAudioQuality = V2TXLiveDef.V2TXLiveAudioQuality.V2TXLiveAudioQualityDefault;
    }
    if (this.u)
    {
      c("set audio quality fail. you should set audio quality before start microphone.");
      return -3;
    }
    this.d = localV2TXLiveAudioQuality;
    return 0;
  }
  
  public int setEncoderMirror(boolean paramBoolean)
  {
    f.a(paramBoolean);
    return 0;
  }
  
  public int setMixTranscodingConfig(V2TXLiveDef.V2TXLiveTranscodingConfig paramV2TXLiveTranscodingConfig)
  {
    this.b.a(paramV2TXLiveTranscodingConfig);
    return 0;
  }
  
  public void setObserver(V2TXLivePusherObserver paramV2TXLivePusherObserver)
  {
    this.e = paramV2TXLivePusherObserver;
    paramV2TXLivePusherObserver = this.b;
    if (paramV2TXLivePusherObserver != null) {
      paramV2TXLivePusherObserver.a(this.e);
    }
  }
  
  public int setProperty(String paramString, Object paramObject)
  {
    int i1 = paramString.hashCode();
    boolean bool3 = true;
    boolean bool2 = true;
    switch (i1)
    {
    default: 
      break;
    case 1838743896: 
      if (paramString.equals("sendSEIMessage")) {
        i1 = 6;
      }
      break;
    case 1319772371: 
      if (paramString.equals("enableAudioANS")) {
        i1 = 1;
      }
      break;
    case 1319772138: 
      if (paramString.equals("enableAudioAGC")) {
        i1 = 0;
      }
      break;
    case 1132708157: 
      if (paramString.equals("muteAudio")) {
        i1 = 5;
      }
      break;
    case 1120433643: 
      if (paramString.equals("setSurface")) {
        i1 = 2;
      }
      break;
    case 503186875: 
      if (paramString.equals("setCustomVideoEncParam")) {
        i1 = 4;
      }
      break;
    case 480042124: 
      if (paramString.equals("setSurfaceSize")) {
        i1 = 3;
      }
      break;
    case 414798393: 
      if (paramString.equals("setPauseParam")) {
        i1 = 8;
      }
      break;
    case -1201582794: 
      if (paramString.equals("setFrameWorkType")) {
        i1 = 9;
      }
      break;
    case -1890607395: 
      if (paramString.equals("pausePusher")) {
        i1 = 7;
      }
      break;
    }
    i1 = -1;
    boolean bool1;
    switch (i1)
    {
    default: 
      return 0;
    case 9: 
      if ((paramObject == null) || (!(paramObject instanceof Integer))) {
        break label805;
      }
      this.w = ((Integer)paramObject).intValue();
      return 0;
    case 8: 
      if (paramObject == null)
      {
        this.q = null;
        f.a(null, 0);
        return 0;
      }
      if (!(paramObject instanceof a.c)) {
        break label805;
      }
      this.q = ((a.c)paramObject);
      f.a(this.q.a, this.q.b);
      return 0;
    case 7: 
      if ((paramObject == null) || (!(paramObject instanceof Boolean))) {
        break label805;
      }
      if (((Boolean)paramObject).booleanValue())
      {
        paramString = this.q;
        if (paramString != null)
        {
          this.p = paramString.c;
          this.o = this.q.d;
        }
        else
        {
          this.p = true;
          this.o = true;
        }
        paramString = this.b;
        if (paramString == null) {
          break label805;
        }
        paramString.d(this.p);
        paramString = this.b;
        bool1 = bool2;
        if (!this.o) {
          if (this.n) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
        paramString.c(bool1);
        return 0;
      }
      this.p = false;
      this.o = false;
      paramString = this.b;
      if (paramString == null) {
        break label805;
      }
      paramString.d(false);
      this.b.c(this.n);
      return 0;
    case 6: 
      if ((paramObject == null) || (!(paramObject instanceof byte[]))) {
        break label805;
      }
      paramString = this.b;
      if (paramString == null) {
        break label805;
      }
      paramString.a((byte[])paramObject);
      return 0;
    case 4: 
      if ((paramObject != null) && ((paramObject instanceof a.g))) {
        f.a((a.g)paramObject);
      }
    case 5: 
      if ((paramObject == null) || (!(paramObject instanceof Boolean))) {
        break label805;
      }
      this.n = ((Boolean)paramObject).booleanValue();
      paramString = this.b;
      if (paramString == null) {
        break label805;
      }
      bool1 = bool3;
      if (!this.n) {
        if (this.o) {
          bool1 = bool3;
        } else {
          bool1 = false;
        }
      }
      paramString.c(bool1);
      return 0;
    case 3: 
      if (paramObject == null)
      {
        this.k = 0;
        this.l = 0;
        f.a(0, 0);
        return 0;
      }
      if (!(paramObject instanceof a.a)) {
        break label805;
      }
      paramString = (a.a)paramObject;
      f.a(paramString.a, paramString.b);
      this.k = paramString.a;
      this.l = paramString.b;
      return 0;
    case 2: 
      if (paramObject == null)
      {
        this.j = null;
        f.a(null);
        return 0;
      }
      if (!(paramObject instanceof Surface)) {
        break label805;
      }
      paramString = (Surface)paramObject;
      this.j = paramString;
      f.a(paramString);
      return 0;
    case 1: 
      if (!(paramObject instanceof Boolean)) {
        break label805;
      }
      b(((Boolean)paramObject).booleanValue(), -1);
      return 0;
    }
    if ((paramObject instanceof Boolean)) {
      a(((Boolean)paramObject).booleanValue(), -1);
    }
    label805:
    return 0;
  }
  
  public int setRenderMirror(V2TXLiveDef.V2TXLiveMirrorType paramV2TXLiveMirrorType)
  {
    V2TXLiveDef.V2TXLiveMirrorType localV2TXLiveMirrorType = paramV2TXLiveMirrorType;
    if (paramV2TXLiveMirrorType == null) {
      localV2TXLiveMirrorType = V2TXLiveDef.V2TXLiveMirrorType.V2TXLiveMirrorTypeAuto;
    }
    f.a(localV2TXLiveMirrorType);
    return 0;
  }
  
  public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    V2TXLiveDef.V2TXLiveRotation localV2TXLiveRotation = paramV2TXLiveRotation;
    if (paramV2TXLiveRotation == null) {
      localV2TXLiveRotation = V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation0;
    }
    f.a(localV2TXLiveRotation);
    return 0;
  }
  
  public int setRenderView(SurfaceView paramSurfaceView)
  {
    c();
    this.i = paramSurfaceView;
    b();
    return 0;
  }
  
  public int setRenderView(TextureView paramTextureView)
  {
    c();
    this.h = paramTextureView;
    b();
    return 0;
  }
  
  public int setRenderView(TXCloudVideoView paramTXCloudVideoView)
  {
    c();
    if ((this.v) && (this.g != paramTXCloudVideoView))
    {
      f.b();
      f.a(getDeviceManager().isFrontCamera(), paramTXCloudVideoView);
    }
    this.g = paramTXCloudVideoView;
    return 0;
  }
  
  public int setVideoQuality(V2TXLiveDef.V2TXLiveVideoResolution paramV2TXLiveVideoResolution, V2TXLiveDef.V2TXLiveVideoResolutionMode paramV2TXLiveVideoResolutionMode)
  {
    V2TXLiveDef.V2TXLiveVideoResolution localV2TXLiveVideoResolution = paramV2TXLiveVideoResolution;
    if (paramV2TXLiveVideoResolution == null) {
      localV2TXLiveVideoResolution = V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution960x540;
    }
    paramV2TXLiveVideoResolution = paramV2TXLiveVideoResolutionMode;
    if (paramV2TXLiveVideoResolutionMode == null) {
      paramV2TXLiveVideoResolution = V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait;
    }
    f.a(new a.g(localV2TXLiveVideoResolution, paramV2TXLiveVideoResolution));
    return 0;
  }
  
  public int setWatermark(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    f.a(paramBitmap, paramFloat1, paramFloat2, paramFloat3);
    return 0;
  }
  
  public void showDebugView(boolean paramBoolean)
  {
    this.m = paramBoolean;
    f localf = this.b;
    if (localf != null) {
      localf.e(this.m);
    }
  }
  
  public int snapshot()
  {
    f localf = this.b;
    if (localf != null) {
      localf.e(null, 0);
    }
    return 0;
  }
  
  public int startCamera(boolean paramBoolean)
  {
    this.v = true;
    f.a(paramBoolean, this.g);
    b();
    return 0;
  }
  
  public int startMicrophone()
  {
    boolean bool2 = true;
    this.u = true;
    f.a(this.d);
    if (this.b != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("audio state when start microphone.[muteAudio:");
      ((StringBuilder)localObject).append(this.n);
      ((StringBuilder)localObject).append("][pauseAudio:");
      ((StringBuilder)localObject).append(this.o);
      ((StringBuilder)localObject).append("]");
      b(((StringBuilder)localObject).toString());
      localObject = this.b;
      boolean bool1 = bool2;
      if (!this.n) {
        if (this.o) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      ((f)localObject).c(bool1);
    }
    return 0;
  }
  
  public int startPush(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startPush url : ");
    ((StringBuilder)localObject).append(paramString);
    b(((StringBuilder)localObject).toString());
    localObject = b.a(paramString);
    if (f.a(((b)localObject).f()))
    {
      c("start push fail. duplicate streamId, please ensure that no other player or pusher is using this streamId now.");
      this.c.post(new e.1(this));
      return -3;
    }
    if (this.b != null)
    {
      d("find old instance when start push.");
      this.b.h();
      f.a(this.b);
      this.b = null;
    }
    this.b = f.a(this.a, ((b)localObject).f(), ((b)localObject).j(), this);
    this.b.a(this.e);
    int i1 = this.f;
    if (i1 > 0) {
      this.b.b(i1);
    }
    this.b.a(this.w);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("audio state when start push.[muteAudio:");
    ((StringBuilder)localObject).append(this.n);
    ((StringBuilder)localObject).append("][pauseAudio:");
    ((StringBuilder)localObject).append(this.o);
    ((StringBuilder)localObject).append("]");
    b(((StringBuilder)localObject).toString());
    localObject = this.b;
    boolean bool;
    if ((!this.n) && (!this.o)) {
      bool = false;
    } else {
      bool = true;
    }
    ((f)localObject).c(bool);
    this.b.d(this.p);
    showDebugView(this.m);
    if (this.r) {
      f.a(this, com.tencent.live2.impl.b.a(this.s), com.tencent.live2.impl.b.a(this.t));
    }
    i1 = this.b.c(paramString);
    if (i1 != 0) {
      this.c.post(new e.2(this, i1));
    }
    return i1;
  }
  
  public int startScreenCapture()
  {
    f.a(null, new TRTCCloudDef.TRTCScreenShareParams());
    return 0;
  }
  
  public int stopCamera()
  {
    this.v = false;
    f.b();
    c();
    return 0;
  }
  
  public int stopMicrophone()
  {
    this.u = false;
    f.c();
    f localf = this.b;
    if (localf != null) {
      localf.c(true);
    }
    return 0;
  }
  
  public int stopPush()
  {
    a();
    return 0;
  }
  
  public int stopScreenCapture()
  {
    f.d();
    return 0;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("surfaceChanged holder: ");
    localStringBuilder.append(paramSurfaceHolder);
    localStringBuilder.append(", format: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", width: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", height: ");
    localStringBuilder.append(paramInt3);
    b(localStringBuilder.toString());
    f.a(paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (paramSurfaceHolder != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("surfaceCreated holder: ");
      localStringBuilder.append(paramSurfaceHolder);
      localStringBuilder.append(", surface: ");
      localStringBuilder.append(paramSurfaceHolder.getSurface());
      b(localStringBuilder.toString());
      f.a(paramSurfaceHolder.getSurface());
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("surfaceDestroyed holder: ");
    localStringBuilder.append(paramSurfaceHolder);
    b(localStringBuilder.toString());
    f.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.e
 * JD-Core Version:    0.7.0.1
 */