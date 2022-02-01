package com.tencent.live2.b;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveFillMode;
import com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat;
import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.live2.impl.a.a;
import com.tencent.live2.impl.a.d;
import com.tencent.live2.impl.b;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class d
  extends V2TXLivePlayer
  implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, f.a
{
  private V2TXLivePlayer a;
  private Context b;
  private Handler c = new Handler(Looper.getMainLooper());
  private V2TXLivePlayerObserver d;
  private TextureView e;
  private SurfaceView f;
  private TXCloudVideoView g;
  private Surface h;
  private int i;
  private int j;
  private V2TXLiveDef.V2TXLiveRotation k;
  private V2TXLiveDef.V2TXLiveFillMode l;
  private V2TXLiveDef.V2TXLivePixelFormat m;
  private V2TXLiveDef.V2TXLiveBufferType n;
  private int o = -1;
  private int p = -1;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private f u;
  private a v;
  private int w = 4;
  
  public d(V2TXLivePlayer paramV2TXLivePlayer, Context paramContext)
  {
    this.a = paramV2TXLivePlayer;
    this.b = paramContext.getApplicationContext();
    f.a(paramContext);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.j = paramInt2;
    if (a()) {
      this.u.a(this.v.b(), this.v.c(), paramInt1, paramInt2);
    }
  }
  
  private void a(Surface paramSurface)
  {
    this.h = paramSurface;
    if (a()) {
      this.u.a(this.v.b(), this.v.c(), paramSurface);
    }
  }
  
  private boolean a()
  {
    if (this.u == null) {
      return false;
    }
    a locala = this.v;
    if (locala == null) {
      return false;
    }
    if (locala.e()) {
      return "27eb683b73944771ce62fbddab2849a4".equals(this.v.b()) ^ true;
    }
    return true;
  }
  
  private void b()
  {
    if (!a()) {
      return;
    }
    String str = this.v.b();
    int i1 = this.v.c();
    this.u.a(str, i1, this.a, this.d);
    this.u.a(this.v.b(), this.v.c(), this.s, b.a(this.m), b.a(this.n));
    Object localObject = this.g;
    if (localObject != null)
    {
      this.u.a(str, i1, (TXCloudVideoView)localObject);
    }
    else
    {
      localObject = this.h;
      if (localObject != null)
      {
        this.u.a(str, i1, (Surface)localObject);
        this.u.a(str, i1, this.i, this.j);
      }
    }
    localObject = this.k;
    if (localObject != null) {
      this.u.a(str, i1, (V2TXLiveDef.V2TXLiveRotation)localObject);
    }
    localObject = this.l;
    if (localObject != null) {
      this.u.a(str, i1, (V2TXLiveDef.V2TXLiveFillMode)localObject);
    }
    this.u.a(str, i1, this.r);
    this.u.b(str, i1, this.q);
    i1 = this.p;
    if (i1 > 0) {
      this.u.b(i1);
    }
    i1 = this.o;
    if (i1 > 0) {
      this.u.d(str, i1);
    }
    this.u.f(this.t);
    this.u.a(this.w);
  }
  
  private void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v2_api_trtc_player(");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(") ");
    localStringBuilder.append(paramString);
    TXCLog.i("V2-TXTRTCPlayerImpl", localStringBuilder.toString());
  }
  
  private int c()
  {
    b("stopPlayInner");
    this.w = 4;
    if ((this.v != null) && (this.u != null))
    {
      e();
      this.u.a(this.v.b(), this.v.c(), false, 0, 0);
      this.u.c(this.v.b(), this.v.c());
      this.u.a(this.v.b(), this.v.c());
      if (this.v.e())
      {
        f localf = this.u;
        if (localf != null)
        {
          f.a(localf);
          this.u = null;
        }
      }
      this.v = null;
      b("stopPlayInner success");
      return 0;
    }
    c("stop play inner warning. have benn stop.");
    return 0;
  }
  
  private void c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v2_api_trtc_player(");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(") ");
    localStringBuilder.append(paramString);
    TXCLog.w("V2-TXTRTCPlayerImpl", localStringBuilder.toString());
  }
  
  private void d()
  {
    TXCloudVideoView localTXCloudVideoView = this.g;
    Object localObject1 = this.e;
    Object localObject2 = this.f;
    if (localTXCloudVideoView != null)
    {
      if (a()) {
        this.u.a(this.v.b(), this.v.c(), localTXCloudVideoView);
      }
    }
    else if (localObject1 != null)
    {
      ((TextureView)localObject1).setSurfaceTextureListener(this);
      localObject2 = ((TextureView)localObject1).getSurfaceTexture();
      if (localObject2 != null)
      {
        b("bindRenderView surface texture is valid, set into player.");
        a(new Surface((SurfaceTexture)localObject2));
        a(((TextureView)localObject1).getWidth(), ((TextureView)localObject1).getHeight());
      }
    }
    else if (localObject2 != null)
    {
      ((SurfaceView)localObject2).getHolder().addCallback(this);
      localObject1 = ((SurfaceView)localObject2).getHolder().getSurface();
      if (((Surface)localObject1).isValid())
      {
        b("bindRenderView surface is valid, set into player.");
        a((Surface)localObject1);
        a(((SurfaceView)localObject2).getWidth(), ((SurfaceView)localObject2).getHeight());
      }
    }
  }
  
  private void d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v2_api_trtc_player(");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(") ");
    localStringBuilder.append(paramString);
    TXCLog.e("V2-TXTRTCPlayerImpl", localStringBuilder.toString());
  }
  
  private void e()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      b("unbindRenderView unbind texture view.");
      ((TextureView)localObject).setSurfaceTextureListener(null);
      a(null);
      a(0, 0);
    }
    localObject = this.f;
    if (localObject != null)
    {
      b("unbindRenderView unbind surface view.");
      ((SurfaceView)localObject).getHolder().removeCallback(this);
      a(null);
      a(0, 0);
    }
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExitRoomByServer reason:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" stop play inner.");
    d(localStringBuilder.toString());
    c();
  }
  
  public void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnterRoomFail reason:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" stop play inner.");
    d(localStringBuilder.toString());
    c();
  }
  
  public void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyUserId [userId:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("][isDefault:");
    ((StringBuilder)localObject).append("27eb683b73944771ce62fbddab2849a4".equals(paramString));
    ((StringBuilder)localObject).append("]");
    b(((StringBuilder)localObject).toString());
    localObject = this.v;
    if (localObject == null)
    {
      d("notify user id fail. play url param is null. maybe something error.");
      return;
    }
    if (!((a)localObject).e())
    {
      d("notify user id fail. current play is not trtc protocol. maybe something error.");
      return;
    }
    this.v.a(paramString);
    if (a()) {
      b();
    }
  }
  
  public int enableCustomRendering(boolean paramBoolean, V2TXLiveDef.V2TXLivePixelFormat paramV2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType paramV2TXLiveBufferType)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enableCustomRendering enable: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", format: ");
    localStringBuilder.append(paramV2TXLivePixelFormat);
    localStringBuilder.append(", type: ");
    localStringBuilder.append(paramV2TXLiveBufferType);
    b(localStringBuilder.toString());
    this.s = paramBoolean;
    this.m = paramV2TXLivePixelFormat;
    this.n = paramV2TXLiveBufferType;
    if (a()) {
      this.u.a(this.v.b(), this.v.c(), paramBoolean, b.a(this.m), b.a(this.n));
    }
    return 0;
  }
  
  public int enableVolumeEvaluation(int paramInt)
  {
    this.p = paramInt;
    if (a()) {
      this.u.b(paramInt);
    }
    return 0;
  }
  
  public int isPlaying()
  {
    Object localObject = this.v;
    boolean bool;
    if ((localObject != null) && (this.u != null))
    {
      localObject = ((a)localObject).b();
      int i1 = this.v.c();
      if ("27eb683b73944771ce62fbddab2849a4".equals(localObject)) {
        bool = true;
      } else {
        bool = this.u.b((String)localObject, i1);
      }
    }
    else
    {
      bool = false;
    }
    if (bool) {
      return 1;
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
      a(new Surface(paramSurfaceTexture));
    }
    a(paramInt1, paramInt2);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceTextureDestroyed surface: ");
    localStringBuilder.append(paramSurfaceTexture);
    b(localStringBuilder.toString());
    a(null);
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
    a(paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public int pauseAudio()
  {
    this.r = true;
    if (a())
    {
      if (this.v.c() == 2)
      {
        c("pause audio fail. you shouldn't pause sub stream audio.");
        return -4;
      }
      this.u.a(this.v.b(), this.v.c(), true);
    }
    return 0;
  }
  
  public int pauseVideo()
  {
    this.q = true;
    if (a())
    {
      if (this.v.c() == 2)
      {
        c("pause audio fail. you shouldn't pause sub stream video.");
        return -4;
      }
      this.u.b(this.v.b(), this.v.c(), true);
    }
    return 0;
  }
  
  public int resumeAudio()
  {
    this.r = false;
    if (a())
    {
      if (this.v.c() == 2)
      {
        c("pause audio fail. you shouldn't resume sub stream audio.");
        return -4;
      }
      this.u.a(this.v.b(), this.v.c(), false);
    }
    return 0;
  }
  
  public int resumeVideo()
  {
    this.q = false;
    if (a())
    {
      if (this.v.c() == 2)
      {
        c("pause audio fail. you shouldn't resume sub stream video.");
        return -4;
      }
      this.u.b(this.v.b(), this.v.c(), false);
    }
    return 0;
  }
  
  public int setCacheParams(float paramFloat1, float paramFloat2)
  {
    return -4;
  }
  
  public void setObserver(V2TXLivePlayerObserver paramV2TXLivePlayerObserver)
  {
    this.d = paramV2TXLivePlayerObserver;
    if (a()) {
      this.u.a(this.v.b(), this.v.c(), this.a, this.d);
    }
  }
  
  public int setPlayoutVolume(int paramInt)
  {
    this.o = paramInt;
    if (a()) {
      this.u.d(this.v.b(), paramInt);
    }
    return 0;
  }
  
  public int setProperty(String paramString, Object paramObject)
  {
    int i1 = paramString.hashCode();
    if (i1 != -1201582794)
    {
      if (i1 != 480042124)
      {
        if ((i1 == 1120433643) && (paramString.equals("setSurface")))
        {
          i1 = 0;
          break label76;
        }
      }
      else if (paramString.equals("setSurfaceSize"))
      {
        i1 = 1;
        break label76;
      }
    }
    else if (paramString.equals("setFrameWorkType"))
    {
      i1 = 2;
      break label76;
    }
    i1 = -1;
    label76:
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return 0;
        }
        if ((paramObject != null) && ((paramObject instanceof Integer)))
        {
          this.w = ((Integer)paramObject).intValue();
          return 0;
        }
      }
      else
      {
        if (paramObject == null)
        {
          this.i = 0;
          this.j = 0;
          a(0, 0);
          return 0;
        }
        if ((paramObject != null) && ((paramObject instanceof a.a)))
        {
          paramString = (a.a)paramObject;
          this.i = paramString.a;
          this.j = paramString.b;
          a(this.i, this.j);
          return 0;
        }
      }
    }
    else
    {
      if (paramObject == null)
      {
        this.h = null;
        a(null);
        return 0;
      }
      if ((paramObject != null) && ((paramObject instanceof Surface)))
      {
        this.h = ((Surface)paramObject);
        a(this.h);
      }
    }
    return 0;
  }
  
  public int setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode paramV2TXLiveFillMode)
  {
    V2TXLiveDef.V2TXLiveFillMode localV2TXLiveFillMode = paramV2TXLiveFillMode;
    if (paramV2TXLiveFillMode == null) {
      localV2TXLiveFillMode = V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFill;
    }
    this.l = localV2TXLiveFillMode;
    if (a()) {
      this.u.a(this.v.b(), this.v.c(), this.l);
    }
    return 0;
  }
  
  public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    V2TXLiveDef.V2TXLiveRotation localV2TXLiveRotation = paramV2TXLiveRotation;
    if (paramV2TXLiveRotation == null) {
      localV2TXLiveRotation = V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation0;
    }
    this.k = localV2TXLiveRotation;
    if (a()) {
      this.u.a(this.v.b(), this.v.c(), this.k);
    }
    return 0;
  }
  
  public int setRenderView(SurfaceView paramSurfaceView)
  {
    e();
    this.f = paramSurfaceView;
    d();
    return 0;
  }
  
  public int setRenderView(TextureView paramTextureView)
  {
    e();
    this.e = paramTextureView;
    d();
    return 0;
  }
  
  public int setRenderView(TXCloudVideoView paramTXCloudVideoView)
  {
    e();
    this.g = paramTXCloudVideoView;
    d();
    return 0;
  }
  
  public void showDebugView(boolean paramBoolean)
  {
    this.t = paramBoolean;
    if (a()) {
      this.u.f(paramBoolean);
    }
  }
  
  public int snapshot()
  {
    if (a())
    {
      this.u.e(this.v.b(), this.v.c());
      return 0;
    }
    return -3;
  }
  
  public int startPlay(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startPlay url: ");
    ((StringBuilder)localObject).append(paramString);
    b(((StringBuilder)localObject).toString());
    localObject = this.u;
    if (localObject != null)
    {
      a locala = this.v;
      if (locala != null)
      {
        ((f)localObject).c(locala.b(), this.v.c());
        if (this.v.e())
        {
          f.a(this.u);
          this.u = null;
        }
      }
    }
    localObject = a.b(paramString);
    if ((((a)localObject).e()) && (f.a(((a)localObject).a())))
    {
      d("start play fail. duplicate streamId, please ensure that no other player or pusher is using this streamId now.");
      this.c.post(new d.1(this));
      return -3;
    }
    this.u = f.a(this.b, ((a)localObject).a(), ((a)localObject).d(), this);
    if (this.u == null)
    {
      if (((a)localObject).d() == a.d.a) {
        paramString = "start play fail. you should start pusher firstly when using room protocol.";
      } else {
        paramString = "start play fail. can't find available instance.";
      }
      d(paramString);
      this.c.post(new d.2(this, paramString));
      return -3;
    }
    this.v = ((a)localObject);
    e();
    d();
    b();
    int i1 = this.u.d(paramString);
    if (i1 != 0) {
      this.c.post(new d.3(this, i1));
    }
    paramString = new StringBuilder();
    paramString.append("startPlay finish. result:");
    paramString.append(i1);
    b(paramString.toString());
    return i1;
  }
  
  public int stopPlay()
  {
    b("stopPlay");
    return c();
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
    a(paramInt2, paramInt3);
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
      a(paramSurfaceHolder.getSurface());
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("surfaceDestroyed holder: ");
    localStringBuilder.append(paramSurfaceHolder);
    b(localStringBuilder.toString());
    a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.d
 * JD-Core Version:    0.7.0.1
 */