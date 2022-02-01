package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.page.bd.a;
import com.tencent.mm.plugin.appbrand.page.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class d
  extends AbsoluteLayout
  implements ae, bd, bi
{
  private final AbsoluteLayout a = this;
  private final List<bd.a> b = new LinkedList();
  
  public d(@NonNull Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a() {}
  
  private boolean a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return false;
    }
    localObject = ((AbsoluteLayout)localObject).getLayoutParams();
    if (localObject == null)
    {
      localObject = new ViewGroup.LayoutParams(paramInt1, paramInt2);
      this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return true;
    }
    if ((paramInt1 == ((ViewGroup.LayoutParams)localObject).width) && (paramInt2 == ((ViewGroup.LayoutParams)localObject).height)) {
      return paramBoolean;
    }
    ((ViewGroup.LayoutParams)localObject).width = paramInt1;
    ((ViewGroup.LayoutParams)localObject).height = paramInt2;
    this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    return true;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    o.f("MicroMsg.AppBrandGlobalNativeWidgetContainerView", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (this.a != null)
    {
      a(false, paramView.getWidth(), paramView.getHeight());
      this.a.scrollTo(paramInt1, paramInt2);
    }
    paramView = this.b.iterator();
    while (paramView.hasNext()) {
      ((bd.a)paramView.next()).a(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void a(bd.a parama)
  {
    if (parama == null) {
      return;
    }
    if (this.b.contains(parama)) {
      return;
    }
    this.b.add(parama);
  }
  
  public boolean a(@NonNull Canvas paramCanvas)
  {
    draw(paramCanvas);
    return true;
  }
  
  public void b(bd.a parama)
  {
    if (parama == null) {
      return;
    }
    this.b.remove(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d
 * JD-Core Version:    0.7.0.1
 */