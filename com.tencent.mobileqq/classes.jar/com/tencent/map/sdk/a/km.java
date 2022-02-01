package com.tencent.map.sdk.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

public final class km
  implements gs, hv.a
{
  public kx a = null;
  private Marker b;
  private Marker c;
  private Marker d;
  
  public km(kx paramkx)
  {
    this.a = paramkx;
  }
  
  public final Marker a(MarkerOptions paramMarkerOptions, km paramkm)
  {
    if (this.a != null) {
      return this.a.a(paramMarkerOptions, paramkm);
    }
    return null;
  }
  
  public final void a()
  {
    if (this.c != null) {
      this.c.setVisible(true);
    }
    if (this.b != null) {
      this.b.setVisible(true);
    }
  }
  
  public final void a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (this.d == null)
    {
      MarkerOptions localMarkerOptions = new MarkerOptions();
      localMarkerOptions.anchor(0.5F, 0.5F);
      localMarkerOptions.tag("AUTH_MARKER");
      localMarkerOptions.icon(BitmapDescriptorFactory.fromBitmap(paramBitmap));
      this.d = a(localMarkerOptions, this);
      this.d.setFixingPoint(paramInt1 / 2, paramInt2 / 2);
      this.d.setClickable(false);
      return;
    }
    this.d.setIcon(BitmapDescriptorFactory.fromBitmap(paramBitmap));
    this.d.setFixingPoint(paramInt1 / 2, paramInt2 / 2);
  }
  
  public final void a(View paramView, Rect paramRect, boolean paramBoolean)
  {
    if (paramView == null) {}
    do
    {
      return;
      paramView = fy.a(paramView);
    } while (paramView == null);
    if (this.b == null)
    {
      MarkerOptions localMarkerOptions = new MarkerOptions().anchor(0.0F, 0.0F).visible(false);
      localMarkerOptions.tag("AUTH_MARKER");
      localMarkerOptions.fastLoad(true);
      this.b = a(localMarkerOptions, this);
      this.b.setClickable(false);
    }
    this.b.setFixingPoint(paramRect.left, paramRect.top);
    this.b.setIcon(BitmapDescriptorFactory.fromBitmap(paramView));
    this.b.setVisible(paramBoolean);
  }
  
  public final void a(jr paramjr)
  {
    if (this.c != null) {
      this.c.setVisible(false);
    }
    if ((this.b != null) && (!paramjr.h())) {
      this.b.setVisible(false);
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.d(paramString, paramBoolean);
    }
  }
  
  public final void b()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public final void b(View paramView, Rect paramRect, boolean paramBoolean)
  {
    if (paramView == null) {}
    do
    {
      return;
      paramView = fy.a(paramView);
    } while (paramView == null);
    if (this.c == null)
    {
      MarkerOptions localMarkerOptions = new MarkerOptions().anchor(0.0F, 0.0F).visible(false);
      localMarkerOptions.tag("AUTH_MARKER");
      localMarkerOptions.fastLoad(true);
      this.c = a(localMarkerOptions, this);
      this.c.setClickable(false);
    }
    this.c.setFixingPoint(paramRect.left, paramRect.top);
    this.c.setIcon(BitmapDescriptorFactory.fromBitmap(paramView));
    this.c.setVisible(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.km
 * JD-Core Version:    0.7.0.1
 */