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
    if ((this.a.d == null) || (this.a.b == null) || (this.a.b.az == null) || (this.a.b.az.b.h == null) || (this.a.a == null) || (this.a.a.c == null)) {}
    BaseMapView localBaseMapView;
    Object localObject;
    do
    {
      return;
      if (!this.a.g)
      {
        this.a.d.setVisibility(8);
        return;
      }
      this.a.d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      this.a.e = this.a.d.getMeasuredWidth();
      this.a.f = this.a.d.getMeasuredHeight();
      this.a.d.layout(0, 0, this.a.d.getMeasuredWidth(), this.a.d.getMeasuredHeight());
      localBaseMapView = this.a.a.c;
      localObject = this.a.b.az.b.h;
      localObject = this.a.a((fu)localObject);
    } while (localObject == null);
    if (this.a.d.getParent() == null) {
      localBaseMapView.addView(this.a.d);
    }
    Rect localRect = new Rect();
    localBaseMapView.getLocalVisibleRect(localRect);
    if (localRect.isEmpty())
    {
      this.a.d.setVisibility(8);
      return;
    }
    if (localRect.intersect((Rect)localObject)) {
      this.a.d.setVisibility(0);
    }
    this.a.d.setX(((Rect)localObject).left);
    this.a.d.setY(((Rect)localObject).top);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.mx.1
 * JD-Core Version:    0.7.0.1
 */