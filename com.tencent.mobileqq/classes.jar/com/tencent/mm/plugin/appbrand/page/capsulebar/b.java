package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.u;

class b
  extends j
  implements a
{
  private final d b;
  private final i.a c;
  private Drawable d;
  private CharSequence e;
  private int f;
  
  public b(d paramd, i.a parama)
  {
    this.b = paramd;
    this.c = parama;
  }
  
  private boolean d()
  {
    d locald = this.b;
    return (locald == null) || (locald.au()) || (this.b.av()) || (this.b.aV() == null);
  }
  
  public int a()
  {
    return this.f;
  }
  
  @UiThread
  public i.a a(a.b paramb)
  {
    int i = paramb.f;
    int j = paramb.g;
    i.a locala = super.c();
    locala.c(j);
    locala.d(i);
    locala.b(paramb.ordinal());
    return locala;
  }
  
  protected final void a(int paramInt)
  {
    this.f = paramInt;
    if (d()) {
      return;
    }
    this.c.b(paramInt);
  }
  
  protected final void a(@Nullable Drawable paramDrawable)
  {
    this.d = paramDrawable;
    if (d()) {
      return;
    }
    this.c.b(paramDrawable);
  }
  
  protected final void a(@Nullable CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
    if (d()) {
      return;
    }
    this.c.b(paramCharSequence);
  }
  
  protected void a(Runnable paramRunnable)
  {
    this.b.d(paramRunnable);
  }
  
  protected Context b()
  {
    try
    {
      Context localContext = this.b.C().getCurrentPage().getCurrentPageView().ah().getContext();
      return localContext;
    }
    catch (NullPointerException localNullPointerException)
    {
      label22:
      break label22;
    }
    return this.b.ah();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.b
 * JD-Core Version:    0.7.0.1
 */