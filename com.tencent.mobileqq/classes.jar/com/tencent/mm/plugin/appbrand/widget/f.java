package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.ot.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class f
  extends FrameLayout
{
  private final c a;
  private f.b b = new f.b(this);
  private final Set<Runnable> c = new HashSet();
  
  public f(@NonNull Context paramContext)
  {
    super(paramContext);
    setWillNotDraw(false);
    this.a = ((c)e.a(c.class, true));
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (willNotDraw()) {
      return;
    }
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas)
    {
      o.a("Luggage.WXA.AppBrandRuntimeFrameLayout", paramCanvas, "", new Object[0]);
      if ((paramCanvas instanceof NullPointerException)) {
        this.a.a(1088L, 0L, 1L, false);
      } else {
        this.a.a(1088L, 1L, 1L, false);
      }
      throw paramCanvas;
    }
  }
  
  protected FrameLayout.LayoutParams generateDefaultLayoutParams()
  {
    return new FrameLayout.LayoutParams(-1, -1);
  }
  
  protected void onAnimationEnd()
  {
    super.onAnimationEnd();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((Runnable)localIterator.next()).run();
    }
    this.c.clear();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.b.a(paramCanvas);
    super.onDraw(paramCanvas);
  }
  
  public void onViewRemoved(View paramView)
  {
    super.onViewRemoved(paramView);
    o.d("Luggage.WXA.AppBrandRuntimeFrameLayout", "onViewRemoved %s", new Object[] { paramView });
  }
  
  public void removeAllViews()
  {
    o.e("Luggage.WXA.AppBrandRuntimeFrameLayout", "removeAllViews stack = %s", new Object[] { Log.getStackTraceString(new Throwable()) });
    super.removeAllViews();
  }
  
  public void setRoundCornerProvider(f.a parama)
  {
    this.b.a = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f
 * JD-Core Version:    0.7.0.1
 */