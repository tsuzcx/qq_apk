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
    kx localkx = this.a;
    if (localkx != null) {
      return localkx.a(paramMarkerOptions, paramkm);
    }
    return null;
  }
  
  public final void a()
  {
    Marker localMarker = this.c;
    if (localMarker != null) {
      localMarker.setVisible(true);
    }
    localMarker = this.b;
    if (localMarker != null) {
      localMarker.setVisible(true);
    }
  }
  
  public final void a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Object localObject = this.d;
    if (localObject == null)
    {
      localObject = new MarkerOptions();
      ((MarkerOptions)localObject).anchor(0.5F, 0.5F);
      ((MarkerOptions)localObject).tag("AUTH_MARKER");
      ((MarkerOptions)localObject).icon(BitmapDescriptorFactory.fromBitmap(paramBitmap));
      this.d = a((MarkerOptions)localObject, this);
      this.d.setFixingPoint(paramInt1 / 2, paramInt2 / 2);
      this.d.setClickable(false);
      return;
    }
    ((Marker)localObject).setIcon(BitmapDescriptorFactory.fromBitmap(paramBitmap));
    this.d.setFixingPoint(paramInt1 / 2, paramInt2 / 2);
  }
  
  public final void a(View paramView, Rect paramRect, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    paramView = fy.a(paramView);
    if (paramView == null) {
      return;
    }
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
    Marker localMarker = this.c;
    if (localMarker != null) {
      localMarker.setVisible(false);
    }
    if ((this.b != null) && (!paramjr.h())) {
      this.b.setVisible(false);
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    kx localkx = this.a;
    if (localkx != null) {
      localkx.d(paramString, paramBoolean);
    }
  }
  
  public final void b()
  {
    kx localkx = this.a;
    if (localkx != null) {
      localkx.a();
    }
  }
  
  public final void b(View paramView, Rect paramRect, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    paramView = fy.a(paramView);
    if (paramView == null) {
      return;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.km
 * JD-Core Version:    0.7.0.1
 */