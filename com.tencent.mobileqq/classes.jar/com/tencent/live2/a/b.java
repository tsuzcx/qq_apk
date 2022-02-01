package com.tencent.live2.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.util.h;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.liteav.device.TXDeviceManagerImpl;
import com.tencent.live2.V2TXLiveDef.V2TXLiveAudioQuality;
import com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMirrorType;
import com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat;
import com.tencent.live2.V2TXLiveDef.V2TXLivePushStatus;
import com.tencent.live2.V2TXLiveDef.V2TXLivePusherStatistics;
import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.V2TXLiveDef.V2TXLiveTexture;
import com.tencent.live2.V2TXLiveDef.V2TXLiveTranscodingConfig;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoFrame;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolutionMode;
import com.tencent.live2.V2TXLivePusher;
import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.live2.impl.a.a;
import com.tencent.live2.impl.a.c;
import com.tencent.live2.impl.a.e;
import com.tencent.live2.impl.a.f;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.TXLivePusher.AudioCustomProcessListener;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener;
import com.tencent.rtmp.TXLivePusherImpl;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

public class b
  extends V2TXLivePusher
  implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, ITXLivePushListener, TXLivePusher.AudioCustomProcessListener, TXLivePusher.ITXAudioVolumeEvaluationListener, TXLivePusher.VideoCustomProcessListener
{
  private boolean A;
  private Context a;
  private TXLivePushConfig b;
  private TXLivePusher c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private int k;
  private V2TXLiveDef.V2TXLivePusherStatistics l;
  private a.e m;
  private int n;
  private boolean o;
  private int p;
  private boolean q;
  private TXCloudVideoView r;
  private TextureView s;
  private SurfaceView t;
  private V2TXLivePusherObserver u;
  private TXDeviceManager v;
  private Surface w;
  private a.a x;
  private boolean y;
  private a.c z;
  
  public b(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.l = new V2TXLiveDef.V2TXLivePusherStatistics();
    this.c = new TXLivePusher(this.a);
    this.c.setPushListener(this);
    this.c.setAudioVolumeEvaluationListener(this);
    this.b = new TXLivePushConfig();
    this.b.setTouchFocus(false);
    this.c.setConfig(this.b);
    a(this.c);
    TXAudioEffectManagerImpl.getAutoCacheHolder().setAudioEffectManagerListener(new b.1(this));
    ((TXDeviceManagerImpl)this.v).setDeviceManagerListener(new b.2(this));
    a();
  }
  
  private int a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getFinalResolution: [rtmpResolution:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("][portrait:");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("][isCameraCapture:");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append("]");
    a(localStringBuilder.toString());
    if (paramBoolean2) {
      paramBoolean1 = true;
    }
    int i1;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 7)
          {
            if (paramInt != 8)
            {
              if (paramInt != 30) {
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    i1 = -1;
                    break;
                  case 17: 
                  case 18: 
                  case 19: 
                    i1 = paramInt;
                  }
                  break;
                case 13: 
                  if (paramBoolean1) {
                    i1 = 13;
                  } else {
                    i1 = 16;
                  }
                  break;
                case 12: 
                  if (paramBoolean1) {
                    i1 = 12;
                  } else {
                    i1 = 15;
                  }
                  break;
                case 11: 
                  if (paramBoolean1) {
                    i1 = 11;
                  } else {
                    i1 = 14;
                  }
                  break;
                }
              } else if (paramBoolean1) {
                i1 = 30;
              } else {
                i1 = 31;
              }
            }
            else if (paramBoolean1) {
              i1 = 8;
            } else {
              i1 = 10;
            }
          }
          else if (paramBoolean1) {
            i1 = 7;
          } else {
            i1 = 9;
          }
        }
        else if (paramBoolean1) {
          i1 = 2;
        } else {
          i1 = 5;
        }
      }
      else if (paramBoolean1) {
        i1 = 1;
      } else {
        i1 = 4;
      }
    }
    else if (paramBoolean1) {
      i1 = 0;
    } else {
      i1 = 3;
    }
    int i2 = i1;
    if (i1 == -1)
    {
      c("getFinalResolution: seriously error!!! can't map resolution, use original resolution.");
      i2 = paramInt;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getFinalResolution: [old res:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("][new res:");
    localStringBuilder.append(i2);
    localStringBuilder.append("]");
    a(localStringBuilder.toString());
    return i2;
  }
  
  private V2TXLiveDef.V2TXLiveVideoFrame a(int paramInt1, int paramInt2, int paramInt3)
  {
    V2TXLiveDef.V2TXLiveVideoFrame localV2TXLiveVideoFrame = new V2TXLiveDef.V2TXLiveVideoFrame();
    localV2TXLiveVideoFrame.texture = new V2TXLiveDef.V2TXLiveTexture();
    localV2TXLiveVideoFrame.texture.textureId = paramInt1;
    localV2TXLiveVideoFrame.width = paramInt2;
    localV2TXLiveVideoFrame.height = paramInt3;
    Object localObject = TXCOpenGlUtils.e();
    if ((localObject instanceof android.opengl.EGLContext))
    {
      localV2TXLiveVideoFrame.texture.eglContext14 = ((android.opengl.EGLContext)localObject);
      return localV2TXLiveVideoFrame;
    }
    localV2TXLiveVideoFrame.texture.eglContext10 = ((javax.microedition.khronos.egl.EGLContext)localObject);
    return localV2TXLiveVideoFrame;
  }
  
  private void a()
  {
    if (this.d)
    {
      a("updateConfig: update config success.");
      this.c.setConfig(this.b);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramInt3 > 0) && (paramInt4 > 0))
    {
      int i1 = paramInt2;
      if (paramInt2 == 0) {
        i1 = paramInt3;
      }
      this.b.setMaxVideoBitrate(paramInt3);
      this.b.setVideoBitrate(paramInt3);
      this.b.setMinVideoBitrate(i1);
      this.b.setVideoResolution(paramInt1);
      this.b.setVideoFPS(paramInt4);
      if (paramInt5 > 0) {
        this.b.setVideoEncodeGop(paramInt5);
      }
      this.b.setAutoAdjustStrategy(paramInt6);
      return;
    }
    c("setVideoEncoderParam: fail, invalid encoder params.");
  }
  
  private void a(a.e parame)
  {
    if (parame == null)
    {
      c("setVideoQualityInner: param is null.");
      return;
    }
    if ((!this.e) && (!this.f) && (!this.o))
    {
      b("setVideoQualityInner: not start video yet, waiting....");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVideoQualityInner: ");
    localStringBuilder.append(parame);
    a(localStringBuilder.toString());
    a(a(parame.e, parame.f, this.e), parame.c, parame.b, parame.a, parame.d, parame.h);
    b();
    a();
  }
  
  private void a(TXLivePusher paramTXLivePusher)
  {
    try
    {
      Object localObject1 = TXLivePusher.class.getDeclaredField("mTXTxLivePusherImpl");
      ((Field)localObject1).setAccessible(true);
      paramTXLivePusher = (TXLivePusherImpl)((Field)localObject1).get(paramTXLivePusher);
      try
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("initReflectMethod livePusher success.psuher: ");
        ((StringBuilder)localObject1).append(paramTXLivePusher);
        a(((StringBuilder)localObject1).toString());
      }
      catch (Exception localException1) {}
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      paramTXLivePusher = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initReflectMethod fail. e: ");
    localStringBuilder.append(localException2);
    c(localStringBuilder.toString());
    if (paramTXLivePusher == null)
    {
      c("initReflectMethod livePusher is null");
      return;
    }
    try
    {
      localObject2 = TXLivePusherImpl.class.getDeclaredMethod("getDeviceManager", new Class[0]);
      ((Method)localObject2).setAccessible(true);
      this.v = ((TXDeviceManager)((Method)localObject2).invoke(paramTXLivePusher, new Object[0]));
      paramTXLivePusher = new StringBuilder();
      paramTXLivePusher.append("initReflectMethod TXDeviceManager success. deviceManager ");
      paramTXLivePusher.append(this.v);
      a(paramTXLivePusher.toString());
      return;
    }
    catch (Exception paramTXLivePusher)
    {
      paramTXLivePusher.printStackTrace();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initReflectMethod TXDeviceManager fail. e: ");
      ((StringBuilder)localObject2).append(paramTXLivePusher);
      c(((StringBuilder)localObject2).toString());
    }
  }
  
  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v2_api_rtmp_pusher(");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(") ");
    localStringBuilder.append(paramString);
    TXLog.i("V2-TXRTMPPusherImpl", localStringBuilder.toString());
  }
  
  private void b()
  {
    Object localObject = this.m;
    boolean bool = this.e;
    int i2 = 1;
    int i1;
    if ((bool) && (localObject != null) && (!((a.e)localObject).f))
    {
      i1 = 90;
      i2 = 0;
    }
    else
    {
      i1 = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fixRenderRotation sdk rule: [homeOrientation:");
    localStringBuilder.append(i2);
    localStringBuilder.append("][innerRotation:");
    localStringBuilder.append(i1);
    localStringBuilder.append("]");
    a(localStringBuilder.toString());
    int i4 = i1;
    int i3 = i2;
    if (localObject != null)
    {
      i4 = i1;
      i3 = i2;
      if (((a.e)localObject).g != -1)
      {
        i3 = ((a.e)localObject).g;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("fixRenderRotation outside rule: [homeOrientation:");
        ((StringBuilder)localObject).append(i3);
        ((StringBuilder)localObject).append("][innerRotation:");
        ((StringBuilder)localObject).append(0);
        ((StringBuilder)localObject).append("]");
        a(((StringBuilder)localObject).toString());
        i4 = 0;
      }
    }
    this.b.setHomeOrientation(i3);
    this.k = i4;
    c();
  }
  
  private void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v2_api_rtmp_pusher(");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(") ");
    localStringBuilder.append(paramString);
    TXLog.w("V2-TXRTMPPusherImpl", localStringBuilder.toString());
  }
  
  private void c()
  {
    int i1 = this.n;
    int i2 = this.k;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setRenderRotationInner: [external:");
    localStringBuilder.append(this.n);
    localStringBuilder.append("][inner:");
    localStringBuilder.append(this.k);
    localStringBuilder.append("]");
    a(localStringBuilder.toString());
    this.c.setRenderRotation(i1 + i2);
  }
  
  private void c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v2_api_rtmp_pusher(");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(") ");
    localStringBuilder.append(paramString);
    TXLog.e("V2-TXRTMPPusherImpl", localStringBuilder.toString());
  }
  
  private void d()
  {
    a("stopPushInner:");
    i();
    this.d = false;
    this.h = false;
    this.k = 0;
    this.l = new V2TXLiveDef.V2TXLivePusherStatistics();
    e();
    f();
    g();
    this.c.setMute(false);
    this.c.stopPusher();
  }
  
  private void e()
  {
    a("stopCameraInner: ");
    this.i = false;
    this.e = false;
    this.c.stopCameraPreview(false);
  }
  
  private void f()
  {
    a("stopMicrophoneInner: ");
    this.j = false;
    this.g = false;
    this.c.setMute(true);
  }
  
  private void g()
  {
    a("stopScreenCaptureInner: ");
    this.i = false;
    this.f = false;
    this.c.stopScreenCapture();
  }
  
  private void h()
  {
    this.c.setSurface(null);
    this.c.setSurfaceSize(0, 0);
    TXCloudVideoView localTXCloudVideoView = this.r;
    Object localObject1 = this.s;
    Object localObject2 = this.t;
    Surface localSurface = this.w;
    if (localTXCloudVideoView != null)
    {
      a("bindRenderView: bind cloud view success.");
      return;
    }
    if (localObject1 != null)
    {
      localObject2 = ((TextureView)localObject1).getSurfaceTexture();
      ((TextureView)localObject1).setSurfaceTextureListener(this);
      if (localObject2 != null)
      {
        a("bindRenderView: bind texture view success.");
        localObject2 = new Surface((SurfaceTexture)localObject2);
        this.c.setSurface((Surface)localObject2);
        this.c.setSurfaceSize(((TextureView)localObject1).getWidth(), ((TextureView)localObject1).getHeight());
      }
    }
    else if (localObject2 != null)
    {
      ((SurfaceView)localObject2).getHolder().addCallback(this);
      localObject1 = ((SurfaceView)localObject2).getHolder().getSurface();
      if (((Surface)localObject1).isValid())
      {
        a("bindRenderView: bind surface view success.");
        this.c.setSurface((Surface)localObject1);
        this.c.setSurfaceSize(((SurfaceView)localObject2).getWidth(), ((SurfaceView)localObject2).getHeight());
      }
    }
    else if (localSurface != null)
    {
      a("bindRenderView: bind surface success.");
      this.c.setSurface(localSurface);
      localObject1 = this.x;
      if (localObject1 != null) {
        this.c.setSurfaceSize(((a.a)localObject1).a, ((a.a)localObject1).b);
      }
    }
    else
    {
      c("bindRender: all view is null, bind fail.");
    }
  }
  
  private void i()
  {
    Object localObject = this.s;
    if (localObject != null)
    {
      a("unbindRenderView: unbind texture view.");
      ((TextureView)localObject).setSurfaceTextureListener(null);
      this.c.setSurface(null);
      this.c.setSurfaceSize(0, 0);
    }
    localObject = this.t;
    if (localObject != null)
    {
      a("unbindRenderView: unbind surface view.");
      ((SurfaceView)localObject).getHolder().removeCallback(this);
      this.c.setSurface(null);
      this.c.setSurfaceSize(0, 0);
    }
    if (this.w != null)
    {
      a("unbindRenderView: unbind surface.");
      this.c.setSurface(null);
      this.c.setSurfaceSize(0, 0);
    }
  }
  
  public int enableCustomVideoCapture(boolean paramBoolean)
  {
    this.o = paramBoolean;
    if (this.o)
    {
      a(this.m);
      this.b.setCustomModeType(2);
      return 0;
    }
    this.b.setCustomModeType(0);
    return 0;
  }
  
  public int enableCustomVideoProcess(boolean paramBoolean, V2TXLiveDef.V2TXLivePixelFormat paramV2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType paramV2TXLiveBufferType)
  {
    if (paramBoolean) {
      this.c.setVideoProcessListener(this);
    } else {
      this.c.setVideoProcessListener(null);
    }
    return 0;
  }
  
  public int enableVolumeEvaluation(int paramInt)
  {
    this.p = paramInt;
    this.c.enableAudioVolumeEvaluation(paramInt);
    return 0;
  }
  
  public TXAudioEffectManager getAudioEffectManager()
  {
    return this.c.getAudioEffectManager();
  }
  
  public TXBeautyManager getBeautyManager()
  {
    return this.c.getBeautyManager();
  }
  
  public TXDeviceManager getDeviceManager()
  {
    return this.v;
  }
  
  public int isPushing()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onAudioVolumeEvaluationNotify(int paramInt)
  {
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.u;
    if (localV2TXLivePusherObserver != null) {
      localV2TXLivePusherObserver.onMicrophoneVolumeUpdate(paramInt);
    }
  }
  
  public void onDetectFacePoints(float[] paramArrayOfFloat) {}
  
  public void onNetStatus(Bundle paramBundle)
  {
    try
    {
      localObject = h.a();
      if ((localObject != null) && (localObject.length == 2))
      {
        this.l.appCpu = (localObject[0] / 10);
        this.l.systemCpu = (localObject[1] / 10);
      }
      this.l.width = paramBundle.getInt("VIDEO_WIDTH");
      this.l.height = paramBundle.getInt("VIDEO_HEIGHT");
      this.l.fps = paramBundle.getInt("VIDEO_FPS");
      this.l.videoBitrate = paramBundle.getInt("VIDEO_BITRATE");
      this.l.audioBitrate = paramBundle.getInt("AUDIO_BITRATE");
    }
    catch (Exception localException)
    {
      Object localObject;
      label110:
      break label110;
    }
    localObject = this.u;
    if (localObject != null) {
      ((V2TXLivePusherObserver)localObject).onStatisticsUpdate(this.l);
    }
    if ((localObject != null) && ((localObject instanceof com.tencent.live2.impl.a.b))) {
      ((com.tencent.live2.impl.a.b)localObject).onPushNetStatus(paramBundle);
    }
  }
  
  public void onPushEvent(int paramInt, Bundle paramBundle)
  {
    if (paramInt != 1020)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("push event:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" param:");
      ((StringBuilder)localObject1).append(paramBundle);
      a(((StringBuilder)localObject1).toString());
    }
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.u;
    Object localObject1 = "";
    int i1;
    Object localObject2;
    if (paramInt != -7001)
    {
      i1 = -1302;
      int i2;
      if (paramInt != -1319)
      {
        i2 = -1301;
        if (paramInt != -1314) {
          if (paramInt != 1001) {
            if ((paramInt != 1003) && (paramInt != 1007)) {
              if (paramInt != 2027)
              {
                if (paramInt == -1317) {
                  break label633;
                }
                if (paramInt == -1316) {
                  break label526;
                }
                if (paramInt == -1302) {
                  break label633;
                }
                if (paramInt == -1301) {
                  break label526;
                }
                if (paramInt != 1101) {
                  if (paramInt == 1102) {}
                }
              }
            }
          }
        }
      }
      switch (paramInt)
      {
      default: 
        break;
      case -1307: 
        this.h = false;
        c("onPushEvent: stop pusher because of disconnect.");
        d();
        if (localV2TXLivePusherObserver == null) {
          break;
        }
        localObject2 = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusDisconnected;
        if (paramBundle != null) {
          localObject1 = paramBundle;
        } else {
          localObject1 = new Bundle();
        }
        localV2TXLivePusherObserver.onPushStatusUpdate((V2TXLiveDef.V2TXLivePushStatus)localObject2, "disconnected from the server.", (Bundle)localObject1);
        break;
        if (this.h) {
          break;
        }
        a("onPushEvent: reconnecting to the server.");
        this.h = true;
        if (localV2TXLivePusherObserver == null) {
          break;
        }
        localObject2 = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusReconnecting;
        if (paramBundle != null) {
          localObject1 = paramBundle;
        } else {
          localObject1 = new Bundle();
        }
        localV2TXLivePusherObserver.onPushStatusUpdate((V2TXLiveDef.V2TXLivePushStatus)localObject2, "reconnecting to the server.", (Bundle)localObject1);
        break;
        if (localV2TXLivePusherObserver == null) {
          break;
        }
        localV2TXLivePusherObserver.onWarning(1101, "Network is busy, please check your network status.", new Bundle());
        break;
        if (this.j) {
          break;
        }
        a("onPushEvent: onCaptureFirstAudioFrame");
        this.j = true;
        if (localV2TXLivePusherObserver == null) {
          break;
        }
        localV2TXLivePusherObserver.onCaptureFirstAudioFrame();
        break;
        if (this.i) {
          break;
        }
        a("onPushEvent: onCaptureFirstVideoFrame");
        this.i = true;
        if (localV2TXLivePusherObserver == null) {
          break;
        }
        localV2TXLivePusherObserver.onCaptureFirstVideoFrame();
        break;
        if (this.h)
        {
          a("onPushEvent: reconnected to the server successfully.");
          this.h = false;
          if (localV2TXLivePusherObserver != null)
          {
            localObject2 = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusConnectSuccess;
            if (paramBundle != null) {
              localObject1 = paramBundle;
            } else {
              localObject1 = new Bundle();
            }
            localV2TXLivePusherObserver.onPushStatusUpdate((V2TXLiveDef.V2TXLivePushStatus)localObject2, "reconnected to the server successfully.", (Bundle)localObject1);
          }
        }
        else
        {
          a("onPushEvent: connected to the server successfully.");
          if (localV2TXLivePusherObserver != null)
          {
            localObject2 = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusConnectSuccess;
            if (paramBundle != null) {
              localObject1 = paramBundle;
            } else {
              localObject1 = new Bundle();
            }
            localV2TXLivePusherObserver.onPushStatusUpdate((V2TXLiveDef.V2TXLivePushStatus)localObject2, "connected to the server successfully.", (Bundle)localObject1);
            break;
            label526:
            c("onPushEvent: camera failed to launch.");
            if (paramInt != -1316)
            {
              if (paramInt != -1314)
              {
                if (paramInt != -1301)
                {
                  i1 = i2;
                }
                else
                {
                  localObject1 = "camera failed to open.";
                  i1 = i2;
                }
              }
              else
              {
                localObject1 = "camera not authorized.";
                i1 = -1314;
              }
            }
            else
            {
              localObject1 = "camera is occupied.";
              i1 = -1316;
            }
            e();
            if (localV2TXLivePusherObserver != null)
            {
              if (paramBundle == null) {
                localObject2 = new Bundle();
              } else {
                localObject2 = paramBundle;
              }
              localV2TXLivePusherObserver.onWarning(i1, (String)localObject1, (Bundle)localObject2);
              break;
              label633:
              c("onPushEvent: microphone failed to launch.");
              if (paramInt != -1319)
              {
                if (paramInt != -1317)
                {
                  if (paramInt == -1302) {
                    localObject1 = "microphone failed to open.";
                  }
                }
                else
                {
                  localObject1 = "microphone not authorized.";
                  i1 = -1317;
                }
              }
              else
              {
                localObject1 = "microphone is occupied.";
                i1 = -1319;
              }
              f();
              if (localV2TXLivePusherObserver != null)
              {
                if (paramBundle == null) {
                  localObject2 = new Bundle();
                } else {
                  localObject2 = paramBundle;
                }
                localV2TXLivePusherObserver.onWarning(i1, (String)localObject1, (Bundle)localObject2);
              }
            }
          }
        }
        break;
      }
    }
    else
    {
      i1 = -1308;
      if (paramInt != -7001)
      {
        if (paramInt != -1309)
        {
          if (paramInt == -1308) {
            localObject1 = "screen capture failed to start.";
          }
        }
        else
        {
          localObject1 = "screen capture is not supported on the system.";
          i1 = -1309;
        }
      }
      else
      {
        localObject1 = "screen capture is interrupted by the system.";
        i1 = -7001;
      }
      g();
      if (localV2TXLivePusherObserver != null)
      {
        if (paramBundle == null) {
          localObject2 = new Bundle();
        } else {
          localObject2 = paramBundle;
        }
        localV2TXLivePusherObserver.onWarning(i1, (String)localObject1, (Bundle)localObject2);
      }
    }
    if ((localV2TXLivePusherObserver != null) && ((localV2TXLivePusherObserver instanceof com.tencent.live2.impl.a.b))) {
      ((com.tencent.live2.impl.a.b)localV2TXLivePusherObserver).onPushEvent(paramInt, paramBundle);
    }
  }
  
  public void onRecordPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onRecordRawPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TextureView: available width-");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" height-");
    localStringBuilder.append(paramInt2);
    a(localStringBuilder.toString());
    if (paramSurfaceTexture != null) {
      this.c.setSurface(new Surface(paramSurfaceTexture));
    }
    this.c.setSurfaceSize(paramInt1, paramInt2);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    a("TextureView: destroyed.");
    this.c.setSurface(null);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    paramSurfaceTexture = new StringBuilder();
    paramSurfaceTexture.append("TextureView: size changed width-");
    paramSurfaceTexture.append(paramInt1);
    paramSurfaceTexture.append(" height-");
    paramSurfaceTexture.append(paramInt2);
    a(paramSurfaceTexture.toString());
    this.c.setSurfaceSize(paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public int onTextureCustomProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.u;
    if (!this.A)
    {
      this.A = true;
      a("onGLContextCreate");
      if (localV2TXLivePusherObserver != null) {
        localV2TXLivePusherObserver.onGLContextCreated();
      }
    }
    V2TXLiveDef.V2TXLiveVideoFrame localV2TXLiveVideoFrame1 = a(paramInt1, paramInt2, paramInt3);
    V2TXLiveDef.V2TXLiveVideoFrame localV2TXLiveVideoFrame2 = a(paramInt1, paramInt2, paramInt3);
    if (localV2TXLivePusherObserver != null)
    {
      localV2TXLivePusherObserver.onProcessVideoFrame(localV2TXLiveVideoFrame1, localV2TXLiveVideoFrame2);
      return localV2TXLiveVideoFrame2.texture.textureId;
    }
    return localV2TXLiveVideoFrame1.texture.textureId;
  }
  
  public void onTextureDestoryed()
  {
    a("onGLContextDestroy");
    this.A = false;
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.u;
    if (localV2TXLivePusherObserver != null) {
      localV2TXLivePusherObserver.onGLContextDestroyed();
    }
  }
  
  public int sendCustomVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame)
  {
    if ((paramV2TXLiveVideoFrame.pixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420) && (paramV2TXLiveVideoFrame.bufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray))
    {
      this.c.sendCustomVideoData(paramV2TXLiveVideoFrame.data, 3, paramV2TXLiveVideoFrame.width, paramV2TXLiveVideoFrame.height);
      return 0;
    }
    if ((paramV2TXLiveVideoFrame.pixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D) && (paramV2TXLiveVideoFrame.bufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture))
    {
      this.c.sendCustomVideoTexture(paramV2TXLiveVideoFrame.texture.textureId, paramV2TXLiveVideoFrame.width, paramV2TXLiveVideoFrame.height);
      return 0;
    }
    return -4;
  }
  
  public int setAudioQuality(V2TXLiveDef.V2TXLiveAudioQuality paramV2TXLiveAudioQuality)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setAudioQuality: quality-");
    ((StringBuilder)localObject).append(paramV2TXLiveAudioQuality);
    a(((StringBuilder)localObject).toString());
    int i1 = isPushing();
    int i3 = 1;
    if (i1 == 1)
    {
      c("set audio quality fail. can't set audio quality after start push.");
      return -3;
    }
    localObject = paramV2TXLiveAudioQuality;
    if (paramV2TXLiveAudioQuality == null) {
      localObject = V2TXLiveDef.V2TXLiveAudioQuality.V2TXLiveAudioQualityDefault;
    }
    int i5 = b.4.c[localObject.ordinal()];
    int i4 = 48000;
    int i2;
    if (i5 != 1)
    {
      i1 = i3;
      i2 = i4;
      if (i5 != 2) {
        if (i5 != 3)
        {
          i1 = i3;
          i2 = i4;
        }
        else
        {
          i1 = 2;
          i2 = i4;
        }
      }
    }
    else
    {
      i2 = 16000;
      i1 = i3;
    }
    this.b.setAudioSampleRate(i2);
    this.b.setAudioChannels(i1);
    return 0;
  }
  
  public int setEncoderMirror(boolean paramBoolean)
  {
    this.c.setMirror(paramBoolean);
    return 0;
  }
  
  public int setMixTranscodingConfig(V2TXLiveDef.V2TXLiveTranscodingConfig paramV2TXLiveTranscodingConfig)
  {
    return -4;
  }
  
  public void setObserver(V2TXLivePusherObserver paramV2TXLivePusherObserver)
  {
    this.u = paramV2TXLivePusherObserver;
  }
  
  public int setProperty(String paramString, Object paramObject)
  {
    if (paramString != "sendSEIMessage")
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set property, key:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" value:");
      localStringBuilder.append(paramObject);
      a(localStringBuilder.toString());
    }
    int i1 = -1;
    int i3 = paramString.hashCode();
    int i2 = 3;
    switch (i3)
    {
    default: 
      break;
    case 2048424571: 
      if (paramString.equals("enableCameraZoom")) {
        i1 = 3;
      }
      break;
    case 1838743896: 
      if (paramString.equals("sendSEIMessage")) {
        i1 = 9;
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
        i1 = 6;
      }
      break;
    case 1120433643: 
      if (paramString.equals("setSurface")) {
        i1 = 4;
      }
      break;
    case 503186875: 
      if (paramString.equals("setCustomVideoEncParam")) {
        i1 = 7;
      }
      break;
    case 480042124: 
      if (paramString.equals("setSurfaceSize")) {
        i1 = 5;
      }
      break;
    case 414798393: 
      if (paramString.equals("setPauseParam")) {
        i1 = 10;
      }
      break;
    case -683331207: 
      if (paramString.equals("setPureAudioPushMode")) {
        i1 = 2;
      }
      break;
    case -1253645946: 
      if (paramString.equals("setVideoQuality")) {
        i1 = 8;
      }
      break;
    case -1890607395: 
      if (paramString.equals("pausePusher")) {
        i1 = 11;
      }
      break;
    }
    switch (i1)
    {
    default: 
      return 0;
    case 11: 
      if ((paramObject != null) && ((paramObject instanceof Boolean)))
      {
        if (((Boolean)paramObject).booleanValue())
        {
          this.c.pausePusher();
          return 0;
        }
        this.c.resumePusher();
        return 0;
      }
      break;
    case 10: 
      if (paramObject == null)
      {
        this.z = null;
        this.b.setPauseImg(null);
        a();
        return 0;
      }
      if ((paramObject instanceof a.c))
      {
        this.z = ((a.c)paramObject);
        this.b.setPauseImg(this.z.a);
        this.b.setPauseImg(this.z.e, this.z.b);
        if ((this.z.d) && (this.z.c)) {
          i1 = i2;
        } else if (this.z.d) {
          i1 = 2;
        } else {
          i1 = 1;
        }
        this.b.setPauseFlag(i1);
        a();
        return 0;
      }
      break;
    case 9: 
      if ((paramObject != null) && ((paramObject instanceof byte[])))
      {
        this.c.sendMessageEx((byte[])paramObject);
        return 0;
      }
      break;
    case 8: 
      if ((paramObject != null) && ((paramObject instanceof a.f)))
      {
        paramString = (a.f)paramObject;
        this.c.setVideoQuality(paramString.a, paramString.c, paramString.b);
        return 0;
      }
      break;
    case 7: 
      if ((paramObject != null) && ((paramObject instanceof a.e)))
      {
        this.m = ((a.e)paramObject);
        a(this.m);
        return 0;
      }
      break;
    case 6: 
      if ((paramObject != null) && ((paramObject instanceof Boolean)))
      {
        this.y = ((Boolean)paramObject).booleanValue();
        this.c.setMute(this.y);
        return 0;
      }
      break;
    case 5: 
      if (paramObject == null)
      {
        this.x = null;
        this.c.setSurfaceSize(0, 0);
        return 0;
      }
      if ((paramObject instanceof a.a))
      {
        this.x = ((a.a)paramObject);
        this.c.setSurfaceSize(this.x.a, this.x.b);
        return 0;
      }
      break;
    case 4: 
      if (paramObject == null)
      {
        this.w = null;
        this.c.setSurface(null);
        return 0;
      }
      if ((paramObject instanceof Surface))
      {
        this.w = ((Surface)paramObject);
        this.c.setSurface(this.w);
        return 0;
      }
      break;
    case 3: 
      if ((paramObject != null) && ((paramObject instanceof Boolean)))
      {
        this.b.setEnableZoom(((Boolean)paramObject).booleanValue());
        a();
        return 0;
      }
      break;
    case 2: 
      if ((paramObject != null) && ((paramObject instanceof Boolean)))
      {
        this.b.enablePureAudioPush(((Boolean)paramObject).booleanValue());
        a();
        return 0;
      }
      break;
    case 1: 
      if ((paramObject != null) && ((paramObject instanceof Boolean)))
      {
        this.b.enableANS(((Boolean)paramObject).booleanValue());
        a();
        return 0;
      }
      break;
    case 0: 
      if ((paramObject != null) && ((paramObject instanceof Boolean)))
      {
        this.b.enableAGC(((Boolean)paramObject).booleanValue());
        a();
      }
      break;
    }
    return 0;
  }
  
  public int setRenderMirror(V2TXLiveDef.V2TXLiveMirrorType paramV2TXLiveMirrorType)
  {
    V2TXLiveDef.V2TXLiveMirrorType localV2TXLiveMirrorType = paramV2TXLiveMirrorType;
    if (paramV2TXLiveMirrorType == null) {
      localV2TXLiveMirrorType = V2TXLiveDef.V2TXLiveMirrorType.V2TXLiveMirrorTypeAuto;
    }
    int i1 = b.4.b[localV2TXLiveMirrorType.ordinal()];
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 == 3) {
          this.b.setLocalVideoMirrorType(2);
        }
      }
      else {
        this.b.setLocalVideoMirrorType(1);
      }
    }
    else {
      this.b.setLocalVideoMirrorType(0);
    }
    a();
    return 0;
  }
  
  public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    V2TXLiveDef.V2TXLiveRotation localV2TXLiveRotation = paramV2TXLiveRotation;
    if (paramV2TXLiveRotation == null) {
      localV2TXLiveRotation = V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation0;
    }
    this.n = com.tencent.live2.impl.b.a(localV2TXLiveRotation);
    c();
    return 0;
  }
  
  public int setRenderView(SurfaceView paramSurfaceView)
  {
    i();
    this.t = paramSurfaceView;
    h();
    return 0;
  }
  
  public int setRenderView(TextureView paramTextureView)
  {
    i();
    this.s = paramTextureView;
    h();
    return 0;
  }
  
  public int setRenderView(TXCloudVideoView paramTXCloudVideoView)
  {
    boolean bool = this.e;
    if (bool) {
      this.c.stopCameraPreview(false);
    }
    i();
    this.r = paramTXCloudVideoView;
    if (paramTXCloudVideoView != null) {
      paramTXCloudVideoView.showLog(this.q);
    }
    if (bool) {
      this.c.startCameraPreview(paramTXCloudVideoView);
    }
    return 0;
  }
  
  public int setVideoQuality(V2TXLiveDef.V2TXLiveVideoResolution paramV2TXLiveVideoResolution, V2TXLiveDef.V2TXLiveVideoResolutionMode paramV2TXLiveVideoResolutionMode)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setVideoQuality: resolution-");
    ((StringBuilder)localObject).append(paramV2TXLiveVideoResolution);
    ((StringBuilder)localObject).append(" mode-");
    ((StringBuilder)localObject).append(paramV2TXLiveVideoResolutionMode);
    a(((StringBuilder)localObject).toString());
    localObject = paramV2TXLiveVideoResolution;
    if (paramV2TXLiveVideoResolution == null)
    {
      localObject = V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution960x540;
      paramV2TXLiveVideoResolution = new StringBuilder();
      paramV2TXLiveVideoResolution.append("setVideoQuality: resolution is null, force set to ");
      paramV2TXLiveVideoResolution.append(localObject);
      b(paramV2TXLiveVideoResolution.toString());
    }
    paramV2TXLiveVideoResolution = paramV2TXLiveVideoResolutionMode;
    if (paramV2TXLiveVideoResolutionMode == null)
    {
      paramV2TXLiveVideoResolution = V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait;
      paramV2TXLiveVideoResolutionMode = new StringBuilder();
      paramV2TXLiveVideoResolutionMode.append("setVideoQuality: mode is null, force set to ");
      paramV2TXLiveVideoResolutionMode.append(paramV2TXLiveVideoResolution);
      b(paramV2TXLiveVideoResolutionMode.toString());
    }
    paramV2TXLiveVideoResolution = new a.e((V2TXLiveDef.V2TXLiveVideoResolution)localObject, paramV2TXLiveVideoResolution);
    this.m = paramV2TXLiveVideoResolution;
    a(paramV2TXLiveVideoResolution);
    return 0;
  }
  
  public int setWatermark(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.b.setWatermark(paramBitmap, paramFloat1, paramFloat2, paramFloat3);
    a();
    return 0;
  }
  
  public void showDebugView(boolean paramBoolean)
  {
    this.q = paramBoolean;
    TXCloudVideoView localTXCloudVideoView = this.r;
    if (localTXCloudVideoView != null) {
      localTXCloudVideoView.showLog(this.q);
    }
  }
  
  public int snapshot()
  {
    this.c.snapshot(new b.3(this));
    return 0;
  }
  
  public int startCamera(boolean paramBoolean)
  {
    this.i = false;
    this.e = true;
    a(this.m);
    getDeviceManager().switchCamera(paramBoolean);
    this.b.setFrontCamera(paramBoolean);
    this.b.setTouchFocus(true ^ getDeviceManager().isAutoFocusEnabled());
    a();
    this.c.startCameraPreview(this.r);
    h();
    return 0;
  }
  
  public int startMicrophone()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startMicrophone: pushing-");
    localStringBuilder.append(this.d);
    a(localStringBuilder.toString());
    this.g = true;
    this.c.setMute(this.y);
    return 0;
  }
  
  public int startPush(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startPush: url-");
    localStringBuilder.append(paramString);
    a(localStringBuilder.toString());
    this.d = true;
    this.c.setConfig(this.b);
    if ((this.g) && (this.y != true)) {
      this.c.setMute(false);
    } else {
      this.c.setMute(true);
    }
    this.c.callExperimentalAPI(String.format(Locale.ENGLISH, "{\"api\":\"setInterfaceType\", \"params\": {\"type\":%d}}", new Object[] { Integer.valueOf(1) }));
    int i1 = this.c.startPusher(paramString);
    if (i1 == 0)
    {
      this.c.enableAudioVolumeEvaluation(this.p);
      paramString = this.u;
      if (paramString != null)
      {
        paramString.onPushStatusUpdate(V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusConnecting, "connecting to the server.", new Bundle());
        return 0;
      }
    }
    else
    {
      this.d = false;
      paramString = new StringBuilder();
      paramString.append("startPush: error, result-");
      paramString.append(i1);
      c(paramString.toString());
    }
    return 0;
  }
  
  public int startScreenCapture()
  {
    this.i = false;
    this.f = true;
    a(this.m);
    this.c.startScreenCapture();
    return 0;
  }
  
  public int stopCamera()
  {
    e();
    i();
    return 0;
  }
  
  public int stopMicrophone()
  {
    f();
    return 0;
  }
  
  public int stopPush()
  {
    a("stopPush:");
    if (!this.d)
    {
      e();
      f();
      g();
      return 0;
    }
    d();
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.u;
    if (localV2TXLivePusherObserver != null) {
      localV2TXLivePusherObserver.onPushStatusUpdate(V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusDisconnected, "disconnected from the server.", new Bundle());
    }
    return 0;
  }
  
  public int stopScreenCapture()
  {
    g();
    return 0;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    paramSurfaceHolder = new StringBuilder();
    paramSurfaceHolder.append("SurfaceView: onSizeChanged. width-");
    paramSurfaceHolder.append(paramInt2);
    paramSurfaceHolder.append(" height-");
    paramSurfaceHolder.append(paramInt3);
    a(paramSurfaceHolder.toString());
    this.c.setSurfaceSize(paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    a("SurfaceView: onCreate.");
    this.c.setSurface(paramSurfaceHolder.getSurface());
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    a("SurfaceView: onDestroyed.");
    this.c.setSurface(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.a.b
 * JD-Core Version:    0.7.0.1
 */