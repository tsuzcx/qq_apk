package com.tencent.luggage.wxa.bp;

import com.tencent.luggage.wxa.du.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.magicbrush.ui.i.c;
import com.tencent.mm.plugin.appbrand.keylogger.d;
import com.tencent.mm.plugin.appbrand.page.l;
import org.jetbrains.annotations.NotNull;

class a$d
  implements i.c
{
  private boolean b = true;
  
  private a$d(a parama) {}
  
  private void a()
  {
    c localc = (c)this.a.y();
    if (localc != null)
    {
      o.d("Luggage.AppBrandGameServiceLogicImp", "hy: on resizeWindow");
      localc.a(new l());
    }
  }
  
  public void a(@NotNull Object paramObject, int paramInt1, int paramInt2)
  {
    a();
  }
  
  public void a(@NotNull Object paramObject, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.b)
    {
      this.b = false;
      d.b(this.a.A(), com.tencent.luggage.wxa.oy.a.R);
      return;
    }
    a();
  }
  
  public void a(@NotNull Object paramObject, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bp.a.d
 * JD-Core Version:    0.7.0.1
 */