package com.tencent.luggage.wxa.bs;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.kt.b;
import com.tencent.mm.plugin.appbrand.page.ak;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.page.aq;

public class a
  extends FrameLayout
  implements aq
{
  private a.b a = null;
  
  public a(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView) {}
  
  public void a(ak paramak) {}
  
  public void a(@NonNull am paramam) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public ViewGroup getContainer()
  {
    return this;
  }
  
  public void onViewAdded(View paramView)
  {
    super.onViewAdded(paramView);
    if (((paramView instanceof b)) && (!paramView.hasOnClickListeners())) {
      paramView.setOnTouchListener(new a.a(null));
    }
    a.b localb = this.a;
    if (localb != null) {
      localb.a(paramView);
    }
  }
  
  public void setNativeWidgetAddedCallback(a.b paramb)
  {
    this.a = paramb;
  }
  
  public void setupWebViewTouchInterceptor(@NonNull am paramam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bs.a
 * JD-Core Version:    0.7.0.1
 */