package com.tencent.luggage.wxa.ma;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.mg.b;
import com.tencent.luggage.wxa.qz.o;

class a$11
  implements e.c
{
  a$11(a parama) {}
  
  public void a(String paramString1, String paramString2)
  {
    o.d("MicroMsg.Video.AppBrandVideoView", "onPrepared");
    a.a(this.a, 0);
    a.u(this.a);
    a.a(this.a, true);
    if (a.v(this.a)) {
      this.a.a();
    }
    a.w(this.a).a();
    if (a.d(this.a) != null) {
      a.d(this.a).a();
    }
    if (a.t(this.a) != null) {
      a.t(this.a).a(paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    o.d("MicroMsg.Video.AppBrandVideoView", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (a.F(this.a) == -1)
    {
      a locala = this.a;
      int i;
      if (paramInt1 < paramInt2) {
        i = 0;
      } else {
        i = 90;
      }
      a.c(locala, i);
      o.d("MicroMsg.Video.AppBrandVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[] { Integer.valueOf(a.F(this.a)) });
    }
    if (a.d(this.a) != null) {
      a.d(this.a).a(paramInt1, paramInt2, this.a.getDuration());
    }
    if (a.t(this.a) != null) {
      a.t(this.a).a(paramString1, paramString2, paramInt1, paramInt2);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    o.d("MicroMsg.Video.AppBrandVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (a.d(this.a) != null) {
      a.d(this.a).a(paramString3, paramInt1, paramInt2);
    }
    if (a.t(this.a) != null) {
      a.t(this.a).a(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    o.d("MicroMsg.Video.AppBrandVideoView", "onVideoEnded");
    a.x(this.a);
    a.m(this.a).setVisibility(8);
    a.h(this.a).setIsPlay(false);
    if ((a.h(this.a).e()) && (a.h(this.a).i())) {
      a.h(this.a).d();
    }
    if (a.y(this.a).getVisibility() == 0) {
      a.y(this.a).setVisibility(8);
    }
    if ((!a.z(this.a)) && (a.A(this.a)))
    {
      if (a.C(this.a) <= 0)
      {
        TextView localTextView = a.D(this.a);
        a locala = this.a;
        localTextView.setText(a.b(locala, a.b(locala).getVideoDurationSec()));
      }
      a.B(this.a).setVisibility(0);
      a.g(this.a).setVisibility(0);
    }
    else
    {
      a.B(this.a).setVisibility(8);
      a.g(this.a).setVisibility(8);
    }
    if (a.d(this.a) != null) {
      a.d(this.a).c();
    }
    if (a.E(this.a)) {
      this.a.a(0.0D, true);
    }
    if (a.t(this.a) != null) {
      a.t(this.a).b(paramString1, paramString2);
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    o.d("MicroMsg.Video.AppBrandVideoView", "onVideoPause");
    if (a.d(this.a) != null) {
      a.d(this.a).e();
    }
    if (a.t(this.a) != null) {
      a.t(this.a).c(paramString1, paramString2);
    }
  }
  
  public void d(String paramString1, String paramString2)
  {
    o.d("MicroMsg.Video.AppBrandVideoView", "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(a.z(this.a)) });
    if ((a.C(this.a) <= 0) && (!a.z(this.a)))
    {
      localObject = a.D(this.a);
      a locala = this.a;
      ((TextView)localObject).setText(a.b(locala, a.b(locala).getVideoDurationSec()));
    }
    Object localObject = this.a;
    a.b((a)localObject, a.z((a)localObject));
    if (a.f(this.a)) {
      a.G(this.a);
    }
    if (a.d(this.a) != null) {
      a.d(this.a).f();
    }
    if ((a.H(this.a) != null) && (l.a(a.H(this.a).getAppId())))
    {
      o.d("MicroMsg.Video.AppBrandVideoView", "onVideoPlay, send play event");
      com.tencent.luggage.wxa.qy.a.a.a(new com.tencent.luggage.wxa.mg.a());
    }
    if (a.t(this.a) != null) {
      a.t(this.a).d(paramString1, paramString2);
    }
  }
  
  public void e(String paramString1, String paramString2)
  {
    o.d("MicroMsg.Video.AppBrandVideoView", "onVideoWaiting");
    if (a.d(this.a) != null) {
      a.d(this.a).g();
    }
    a.c(this.a, true);
    a.j(this.a);
    if (a.t(this.a) != null) {
      a.t(this.a).e(paramString1, paramString2);
    }
  }
  
  public void f(String paramString1, String paramString2)
  {
    a.c(this.a, false);
    a.n(this.a);
    if (a.t(this.a) != null) {
      a.t(this.a).f(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ma.a.11
 * JD-Core Version:    0.7.0.1
 */