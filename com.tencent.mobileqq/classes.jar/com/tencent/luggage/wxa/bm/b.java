package com.tencent.luggage.wxa.bm;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.luggage.wxa.bl.c;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.pd.k;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.i;
import java.util.LinkedList;

class b
{
  private g a;
  private h b;
  private Context c;
  private boolean d = false;
  private View e;
  private LinkedList<String> f;
  private boolean g = false;
  private e h;
  
  private b(g paramg, e parame, Context paramContext, h paramh)
  {
    this.b = paramh;
    this.a = paramg;
    this.c = paramContext;
    this.h = parame;
    this.a.a(paramContext);
    e();
  }
  
  static b a(e parame, Context paramContext, h paramh)
  {
    return new b(c.a().b(), parame, paramContext, paramh);
  }
  
  private void b(String paramString)
  {
    paramString = k.a(paramString);
    if (Build.VERSION.SDK_INT >= 19)
    {
      localg = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("console._log('");
      localStringBuilder.append(paramString);
      localStringBuilder.append("')");
      localg.b(localStringBuilder.toString());
      return;
    }
    g localg = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("javascript:console._log('");
    localStringBuilder.append(paramString);
    localStringBuilder.append("')");
    localg.a(localStringBuilder.toString());
  }
  
  private void e()
  {
    this.a.b().a(true);
    this.e = new a(this.c);
    this.e.setOnClickListener(new b.1(this));
    this.a.a(new b.2(this));
    this.a.a("wagame://servicewechat.com/WAGameVConsole.html");
    this.a.a(100000.0F);
    this.a.a(8);
  }
  
  private void f()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new b.3(this));
    localValueAnimator.start();
  }
  
  private void g()
  {
    this.a.a(h());
    this.a.a(0);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    localValueAnimator.addUpdateListener(new b.4(this));
    localValueAnimator.start();
  }
  
  private int h()
  {
    return (int)(this.h.t().find(0).getWidth() * this.c.getResources().getDisplayMetrics().density) + 1;
  }
  
  public View a()
  {
    return this.e;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.a.a().post(paramRunnable);
  }
  
  public void a(String paramString)
  {
    if (this.g)
    {
      b(paramString);
      return;
    }
    if (this.f == null) {
      this.f = new LinkedList();
    }
    this.f.add(paramString);
  }
  
  public void b()
  {
    if (this.d)
    {
      f();
      this.d = false;
      return;
    }
    g();
    this.d = true;
  }
  
  public View c()
  {
    return this.a.a();
  }
  
  public void d()
  {
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bm.b
 * JD-Core Version:    0.7.0.1
 */