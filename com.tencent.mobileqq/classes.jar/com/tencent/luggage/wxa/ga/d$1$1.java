package com.tencent.luggage.wxa.ga;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.fy.u;
import com.tencent.luggage.wxa.gd.b;
import com.tencent.luggage.wxa.lp.e;
import com.tencent.luggage.wxa.lp.i.a;
import com.tencent.luggage.wxa.qz.o;

class d$1$1
  extends u
{
  private com.tencent.luggage.wxa.lp.i<b> d = null;
  
  d$1$1(d.1 param1, com.tencent.luggage.wxa.fy.i parami, com.tencent.luggage.wxa.nb.c paramc)
  {
    super(parami);
  }
  
  @NonNull
  private com.tencent.luggage.wxa.lp.i<b> c()
  {
    if (this.d == null) {
      this.d = c.a.a(this.b);
    }
    return this.d;
  }
  
  @NonNull
  public View a(@NonNull Context paramContext)
  {
    if (!this.b.e()) {
      return c().a(paramContext);
    }
    return super.a(paramContext);
  }
  
  @NonNull
  public e a()
  {
    if (!this.b.e()) {
      return c().a();
    }
    return super.a();
  }
  
  public void a(@NonNull View paramView)
  {
    if (!this.b.e())
    {
      if ((paramView instanceof b))
      {
        c().a((b)paramView);
        return;
      }
      o.c(this.a, "recycleVideoContainerView, view is not instanceof TextureImageViewLikeImpl");
      return;
    }
    super.a(paramView);
  }
  
  public void b(@NonNull View paramView)
  {
    if (!this.b.e())
    {
      if (!(paramView instanceof b))
      {
        o.c(this.a, "onPlayEndWorkaround, view is not instanceof TextureImageViewLikeImpl");
        return;
      }
      c().b((b)paramView);
      return;
    }
    super.b(paramView);
  }
  
  public void b(@NonNull View paramView, @Nullable Runnable paramRunnable)
  {
    if (!this.b.e())
    {
      if (!(paramView instanceof b))
      {
        o.c(this.a, "transferTo, view is not instanceof TextureImageViewLikeImpl");
        if (paramRunnable != null)
        {
          o.d(this.a, "transferTo, run afterTransferToTask when view is not instanceof TextureImageViewLikeImpl");
          paramRunnable.run();
        }
        return;
      }
      c().b((b)paramView, paramRunnable);
      return;
    }
    super.b(paramView, paramRunnable);
  }
  
  public void c(@NonNull View paramView, @Nullable Runnable paramRunnable)
  {
    if (!this.b.e())
    {
      if (!(paramView instanceof b))
      {
        o.c(this.a, "transferFrom, view is not instanceof TextureImageViewLikeImpl");
        if (paramRunnable != null)
        {
          o.d(this.a, "transferFrom, run afterTransferFromTask when view is not instanceof TextureImageViewLikeImpl");
          paramRunnable.run();
        }
        return;
      }
      c().c((b)paramView, paramRunnable);
      return;
    }
    super.c(paramView, paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ga.d.1.1
 * JD-Core Version:    0.7.0.1
 */