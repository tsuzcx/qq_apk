package com.tencent.map.sdk.a;

import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView;

final class mx$1
  implements Runnable
{
  mx$1(mx parammx) {}
  
  public final void run()
  {
    if ((this.a.d != null) && (this.a.b != null) && (this.a.b.az != null) && (this.a.b.az.b.h != null) && (this.a.a != null))
    {
      if (this.a.a.c == null) {
        return;
      }
      if (!this.a.g)
      {
        this.a.d.setVisibility(8);
        return;
      }
      this.a.d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      Object localObject1 = this.a;
      ((mx)localObject1).e = ((mx)localObject1).d.getMeasuredWidth();
      localObject1 = this.a;
      ((mx)localObject1).f = ((mx)localObject1).d.getMeasuredHeight();
      this.a.d.layout(0, 0, this.a.d.getMeasuredWidth(), this.a.d.getMeasuredHeight());
      localObject1 = this.a.a.c;
      Object localObject2 = this.a.b.az.b.h;
      localObject2 = this.a.a((fu)localObject2);
      if (localObject2 == null) {
        return;
      }
      if (this.a.d.getParent() == null) {
        ((BaseMapView)localObject1).addView(this.a.d);
      }
      Rect localRect = new Rect();
      ((BaseMapView)localObject1).getLocalVisibleRect(localRect);
      if (localRect.isEmpty())
      {
        this.a.d.setVisibility(8);
        return;
      }
      if (localRect.intersect((Rect)localObject2)) {
        this.a.d.setVisibility(0);
      }
      this.a.d.setX(((Rect)localObject2).left);
      this.a.d.setY(((Rect)localObject2).top);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.mx.1
 * JD-Core Version:    0.7.0.1
 */