package com.tencent.map.sdk.a;

import android.view.MotionEvent;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerDragListener;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;

final class lq$1
  implements lq.a
{
  private Marker b = null;
  private boolean c = false;
  
  lq$1(lq paramlq) {}
  
  public final void a()
  {
    this.c = false;
    this.b = null;
  }
  
  public final void a(MotionEvent paramMotionEvent)
  {
    if ((this.a.a != null) && (this.a.a.az != null) && (this.c))
    {
      Object localObject = this.b;
      if (localObject == null) {
        return;
      }
      localObject = ((Marker)localObject).getOnDragListener();
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if (i != 1) {
          if (i != 2)
          {
            if ((i == 3) || (i == 4)) {}
          }
          else
          {
            i = (int)paramMotionEvent.getX();
            int j = (int)paramMotionEvent.getY();
            paramMotionEvent = new DoublePoint(i, j);
            paramMotionEvent = fz.a(this.a.a.az.b.h.a(paramMotionEvent));
            this.b.setPosition(paramMotionEvent);
            if (localObject != null) {
              ((TencentMap.OnMarkerDragListener)localObject).onMarkerDrag(this.b);
            }
            if (this.a.d == null) {
              return;
            }
            this.a.d.onMarkerDrag(this.b);
            return;
          }
        }
        this.c = false;
        if (localObject != null) {
          ((TencentMap.OnMarkerDragListener)localObject).onMarkerDragEnd(this.b);
        }
        if (this.a.d != null) {
          this.a.d.onMarkerDragEnd(this.b);
        }
        this.b = null;
      }
    }
  }
  
  public final void a(String paramString)
  {
    if (paramString.trim().length() == 0)
    {
      this.b = null;
      this.c = false;
      return;
    }
    this.b = this.a.o(paramString);
    paramString = this.b;
    if (paramString != null)
    {
      if (!paramString.isDraggable())
      {
        this.b = null;
        this.c = false;
        return;
      }
      this.c = true;
      if (this.a.d != null) {
        this.a.d.onMarkerDragStart(this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.lq.1
 * JD-Core Version:    0.7.0.1
 */