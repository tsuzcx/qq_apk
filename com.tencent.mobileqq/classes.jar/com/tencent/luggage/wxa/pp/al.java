package com.tencent.luggage.wxa.pp;

import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mm.plugin.appbrand.page.ak;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.page.aq;
import com.tencent.mm.plugin.appbrand.page.u;

public class al
  implements aq
{
  private static View.OnTouchListener a = new al.1();
  private final u b;
  private final g c;
  
  public al(@NonNull u paramu)
  {
    this.b = paramu;
    this.c = new g(paramu);
  }
  
  private void a(ViewGroup paramViewGroup, g paramg)
  {
    paramViewGroup.setOnTouchListener(new al.2(this, paramg, new ai(paramg)));
  }
  
  public void a(int paramInt)
  {
    this.c.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    this.c.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
  }
  
  public void a(ak paramak)
  {
    if ((paramak == ak.a) || (paramak == ak.b)) {
      o.a(this.b);
    }
  }
  
  public void a(@NonNull am paramam)
  {
    if (paramam.getContentView() == null) {
      return;
    }
    ((ViewGroup)paramam.getContentView()).setOnTouchListener(a);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c.a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public ViewGroup getContainer()
  {
    return this.c;
  }
  
  public void setupWebViewTouchInterceptor(@NonNull am paramam)
  {
    a((ViewGroup)paramam.getContentView(), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.al
 * JD-Core Version:    0.7.0.1
 */