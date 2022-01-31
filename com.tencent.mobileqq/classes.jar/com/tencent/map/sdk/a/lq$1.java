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
    if ((this.a.a == null) || (this.a.a.az == null) || (!this.c) || (this.b == null)) {}
    do
    {
      return;
      TencentMap.OnMarkerDragListener localOnMarkerDragListener = this.b.getOnDragListener();
      switch (paramMotionEvent.getAction())
      {
      case 0: 
      default: 
        return;
      case 1: 
      case 3: 
      case 4: 
        this.c = false;
        if (localOnMarkerDragListener != null) {
          localOnMarkerDragListener.onMarkerDragEnd(this.b);
        }
        if (this.a.d != null) {
          this.a.d.onMarkerDragEnd(this.b);
        }
        this.b = null;
        return;
      }
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      paramMotionEvent = new DoublePoint(i, j);
      paramMotionEvent = fz.a(this.a.a.az.b.h.a(paramMotionEvent));
      this.b.setPosition(paramMotionEvent);
      if (localOnMarkerDragListener != null) {
        localOnMarkerDragListener.onMarkerDrag(this.b);
      }
    } while (this.a.d == null);
    this.a.d.onMarkerDrag(this.b);
  }
  
  public final void a(String paramString)
  {
    if (paramString.trim().length() == 0)
    {
      this.b = null;
      this.c = false;
    }
    do
    {
      do
      {
        return;
        this.b = this.a.o(paramString);
      } while (this.b == null);
      if (!this.b.isDraggable())
      {
        this.b = null;
        this.c = false;
        return;
      }
      this.c = true;
    } while (this.a.d == null);
    this.a.d.onMarkerDragStart(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.lq.1
 * JD-Core Version:    0.7.0.1
 */