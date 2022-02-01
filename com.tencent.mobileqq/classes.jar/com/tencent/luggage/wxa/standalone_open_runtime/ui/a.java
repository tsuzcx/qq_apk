package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.jj.s.f;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.rh.b;
import com.tencent.mm.plugin.appbrand.ui.f;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class a
  extends b
  implements com.tencent.mm.plugin.appbrand.ui.d, f
{
  private com.tencent.luggage.wxa.iu.d a;
  private e c;
  private Function0<Unit> d;
  @Nullable
  private s.f e;
  
  public a(@NonNull Context paramContext, @Nullable com.tencent.luggage.wxa.iu.d paramd, @Nullable s.f paramf)
  {
    super(paramContext);
    this.a = paramd;
    this.e = paramf;
    a(paramContext);
  }
  
  private void a(@NonNull Context paramContext)
  {
    setBackgroundColor(getResources().getColor(2131165190));
    this.c = new com.tencent.mm.plugin.appbrand.ui.k(paramContext);
    this.c.setBackgroundColor(ContextCompat.getColor(paramContext, 2131168376));
    addView(this.c.getActionView());
    a();
  }
  
  private boolean b()
  {
    com.tencent.luggage.wxa.iu.d locald = this.a;
    return (locald != null) && ((locald instanceof com.tencent.luggage.wxa.ed.d)) && (((com.tencent.luggage.wxa.ed.d)locald).w());
  }
  
  protected void a()
  {
    this.c.c(false);
    Object localObject = new a.1(this);
    this.c.setCloseButtonClickListener((View.OnClickListener)localObject);
    this.c.setBackButtonClickListener((View.OnClickListener)localObject);
    int k = getContext().getResources().getColor(2131165190);
    int m = getContext().getResources().getColor(2131166595);
    localObject = this.a;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.iu.d)localObject).B();
    }
    s.f localf = this.e;
    String str = "white";
    int i = k;
    int j = m;
    localObject = str;
    if (localf != null) {
      if (com.tencent.luggage.util.k.a.a())
      {
        if (!af.c(this.e.r)) {
          k = g.a(this.e.r, getContext().getResources().getColor(2131165190));
        }
        i = k;
        j = m;
        localObject = str;
        if (!af.c(this.e.q))
        {
          j = g.a(this.e.q, getContext().getResources().getColor(2131166595));
          i = k;
          localObject = str;
        }
      }
      else
      {
        i = k;
        if (!af.c(this.e.p)) {
          i = g.a(this.e.p, getContext().getResources().getColor(2131165190));
        }
        j = m;
        if (!af.c(this.e.o)) {
          j = g.a(this.e.o, getContext().getResources().getColor(2131166595));
        }
        localObject = "black";
      }
    }
    a(getContext().getString(2131886753), i, (String)localObject, j);
    a(i);
  }
  
  public void a(int paramInt)
  {
    setBackgroundColor(ColorUtils.compositeColors(paramInt, getContext().getResources().getColor(2131165190)));
  }
  
  protected void a(String paramString1, @ColorInt int paramInt1, String paramString2, @ColorInt int paramInt2)
  {
    this.c.setMainTitle(paramString1);
    this.c.setForegroundStyle(paramString2);
    this.c.setLoadingIconVisibility(true);
    this.c.setForegroundColor(paramInt2);
    a(paramInt1, "black".equals(paramString2));
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.c.setMainTitle(getContext().getString(2131886753));
  }
  
  public void a(@NonNull Function0<Unit> paramFunction0)
  {
    this.d = paramFunction0;
  }
  
  public void b(Function0<Unit> paramFunction0)
  {
    post(new a.2(this, paramFunction0));
  }
  
  public View getView()
  {
    return this;
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return false;
    }
    if ((!ViewCompat.isAttachedToWindow(this)) && (b()))
    {
      t.a(paramRunnable);
      return true;
    }
    return super.post(paramRunnable);
  }
  
  public final boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null) {
      return false;
    }
    if ((!ViewCompat.isAttachedToWindow(this)) && (b()))
    {
      t.a(paramRunnable, paramLong);
      return true;
    }
    return super.postDelayed(paramRunnable, paramLong);
  }
  
  public void setProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.a
 * JD-Core Version:    0.7.0.1
 */