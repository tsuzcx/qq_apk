package com.tencent.luggage.wxa.ma;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b;

class a$10
  implements a.b
{
  a$10(a parama) {}
  
  public int a(int paramInt, float paramFloat)
  {
    if (!a.l(this.a)) {
      return 0;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDragProgress:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramFloat);
    o.d("MicroMsg.Video.AppBrandVideoView", ((StringBuilder)localObject).toString());
    paramInt = a.b(this.a).getVideoDurationSec();
    int i = b.a(paramFloat, this.a.getMeasuredWidth(), e(), paramInt);
    localObject = k.a(paramInt * 1000L);
    TextView localTextView = a.m(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(k.a(i * 1000L));
    localStringBuilder.append("/");
    localStringBuilder.append((String)localObject);
    localTextView.setText(localStringBuilder.toString());
    a.h(this.a).a(i);
    if (a.h(this.a).e()) {
      a.h(this.a).m();
    }
    return i;
  }
  
  public void a()
  {
    o.e("MicroMsg.Video.AppBrandVideoView", "onSingleTap");
    if ((a.f(this.a)) && (a.g(this.a).getVisibility() != 0))
    {
      a.h(this.a).b();
      if (a.i(this.a)) {
        a.j(this.a);
      }
    }
  }
  
  public void a(float paramFloat)
  {
    if (!g()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAdjustVolume:");
    localStringBuilder.append(paramFloat);
    o.e("MicroMsg.Video.AppBrandVideoView", localStringBuilder.toString());
    a.o(this.a).setPercent(paramFloat);
    a.p(this.a).setText(2131891459);
    a.q(this.a).setImageResource(2130838707);
    a.r(this.a).setVisibility(0);
    a.j(this.a);
  }
  
  public void b()
  {
    o.e("MicroMsg.Video.AppBrandVideoView", "onDoubleTap");
    if (a.k(this.a))
    {
      if (a.b(this.a).b())
      {
        this.a.b();
        return;
      }
      this.a.a();
    }
  }
  
  public void b(float paramFloat)
  {
    if (!f()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAdjustBrightness:");
    localStringBuilder.append(paramFloat);
    o.e("MicroMsg.Video.AppBrandVideoView", localStringBuilder.toString());
    a.o(this.a).setPercent(paramFloat);
    a.p(this.a).setText(2131891458);
    a.q(this.a).setImageResource(2130838693);
    a.r(this.a).setVisibility(0);
    a.j(this.a);
  }
  
  public void b(int paramInt, float paramFloat)
  {
    if (!a.l(this.a)) {
      return;
    }
    a.m(this.a).setVisibility(8);
    a.n(this.a);
    o.d("MicroMsg.Video.AppBrandVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(a.b(this.a).getCurrPosSec()), Float.valueOf(paramFloat) });
    this.a.a(paramInt);
  }
  
  public void c()
  {
    if (!a.l(this.a)) {
      return;
    }
    a.m(this.a).setVisibility(0);
    a.j(this.a);
  }
  
  public void c(float paramFloat)
  {
    if (!g()) {
      return;
    }
    a.r(this.a).setVisibility(8);
    a.n(this.a);
  }
  
  public void d(float paramFloat)
  {
    if (!f()) {
      return;
    }
    a.r(this.a).setVisibility(8);
    a.n(this.a);
  }
  
  public boolean d()
  {
    return true;
  }
  
  public int e()
  {
    return a.b(this.a).getCurrPosSec();
  }
  
  public boolean f()
  {
    return a.s(this.a);
  }
  
  public boolean g()
  {
    return a.s(this.a);
  }
  
  public boolean h()
  {
    return a.l(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ma.a.10
 * JD-Core Version:    0.7.0.1
 */