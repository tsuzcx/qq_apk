package com.tencent.mapsdk.rastercore.e;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.GroundOverlayOptions;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mapsdk.rastercore.d.f;

public class b
  implements c
{
  private BitmapDescriptor a;
  private LatLng b;
  private float c;
  private float d;
  private LatLngBounds e;
  private float f;
  private float g;
  private boolean h = true;
  private float i = 0.0F;
  private float j = 0.5F;
  private float k = 0.5F;
  private String l;
  private Bitmap m;
  private f n;
  private a o;
  
  public b(f paramf, GroundOverlayOptions paramGroundOverlayOptions)
  {
    this.n = paramf;
    this.o = paramf.e();
    this.l = getId();
    this.j = paramGroundOverlayOptions.getAnchorU();
    this.k = paramGroundOverlayOptions.getAnchorV();
    this.f = paramGroundOverlayOptions.getBearing();
    this.c = paramGroundOverlayOptions.getWidth();
    this.d = paramGroundOverlayOptions.getHeight();
    this.a = paramGroundOverlayOptions.getImage();
    this.b = paramGroundOverlayOptions.getLocation();
    this.e = paramGroundOverlayOptions.getBounds();
    this.i = paramGroundOverlayOptions.getTransparency();
    this.h = paramGroundOverlayOptions.isVisible();
    this.g = paramGroundOverlayOptions.getZIndex();
  }
  
  private void g()
  {
    double d1 = this.c / (6371000.79D * Math.cos(this.b.getLatitude() * 0.01745329251994329D) * 0.01745329251994329D);
    double d2 = this.d / 111194.94043265979D;
    LatLng localLatLng = new LatLng(this.b.getLatitude() - (1.0F - this.k) * d2, this.b.getLongitude() - this.j * d1);
    double d3 = this.b.getLatitude();
    double d4 = this.k;
    double d5 = this.b.getLongitude();
    this.e = new LatLngBounds(localLatLng, new LatLng(d2 * d4 + d3, d1 * (1.0F - this.j) + d5));
  }
  
  private void h()
  {
    LatLng localLatLng1 = this.e.getSouthwest();
    LatLng localLatLng2 = this.e.getNortheast();
    this.b = new LatLng(localLatLng1.getLatitude() + (1.0F - this.k) * (localLatLng2.getLatitude() - localLatLng1.getLatitude()), localLatLng1.getLongitude() + this.j * (localLatLng2.getLongitude() - localLatLng1.getLongitude()));
    this.c = ((float)(6371000.79D * Math.cos(this.b.getLatitude() * 0.01745329251994329D) * (localLatLng2.getLongitude() - localLatLng1.getLongitude()) * 0.01745329251994329D));
    this.d = ((float)((localLatLng2.getLatitude() - localLatLng1.getLatitude()) * 6371000.79D * 0.01745329251994329D));
  }
  
  public LatLng a()
  {
    return this.b;
  }
  
  public void a(float paramFloat)
  {
    if (this.c != paramFloat)
    {
      this.c = paramFloat;
      this.d = paramFloat;
      g();
    }
    for (;;)
    {
      this.n.a(false, false);
      return;
      this.c = paramFloat;
      this.d = paramFloat;
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if ((this.c != paramFloat1) && (this.d != paramFloat2))
    {
      this.c = paramFloat1;
      this.d = paramFloat2;
      g();
    }
    for (;;)
    {
      this.n.a(false, false);
      return;
      this.c = paramFloat1;
      this.d = paramFloat2;
    }
  }
  
  public void a(BitmapDescriptor paramBitmapDescriptor)
  {
    this.a = paramBitmapDescriptor;
    if (this.a == null) {}
    this.n.a(false, false);
  }
  
  public void a(LatLng paramLatLng)
  {
    if ((this.b != null) && (!this.b.equals(paramLatLng)))
    {
      this.b = paramLatLng;
      g();
    }
    for (;;)
    {
      this.n.a(false, false);
      return;
      this.b = paramLatLng;
    }
  }
  
  public void a(LatLngBounds paramLatLngBounds)
  {
    if ((this.e != null) && (!this.e.equals(paramLatLngBounds)))
    {
      this.e = paramLatLngBounds;
      h();
    }
    for (;;)
    {
      this.n.a(false, false);
      return;
      this.e = paramLatLngBounds;
    }
  }
  
  public float b()
  {
    return this.c;
  }
  
  public void b(float paramFloat)
  {
    this.f = paramFloat;
    this.n.a(false, false);
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    this.j = paramFloat1;
    this.k = paramFloat2;
    this.n.a(false, false);
  }
  
  public float c()
  {
    return this.d;
  }
  
  public void c(float paramFloat)
  {
    this.i = paramFloat;
    this.n.a(false, false);
  }
  
  public boolean checkInBounds()
  {
    if (this.e == null) {}
    LatLngBounds localLatLngBounds;
    do
    {
      return false;
      localLatLngBounds = this.n.b().c();
      if (localLatLngBounds == null) {
        return true;
      }
    } while ((!localLatLngBounds.contains(this.e)) && (!this.e.intersects(localLatLngBounds)));
    return true;
  }
  
  public LatLngBounds d()
  {
    return this.e;
  }
  
  public void destroy()
  {
    try
    {
      remove();
      if (this.a != null)
      {
        Bitmap localBitmap = this.a.getBitmap();
        if (localBitmap != null)
        {
          localBitmap.recycle();
          this.a = null;
        }
      }
      this.b = null;
      this.e = null;
      return;
    }
    catch (Exception localException)
    {
      new StringBuilder("GroundOverlayDelegateImp destroy").append(localException.getMessage());
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((!this.h) || ((this.b == null) && (this.e == null)) || (this.a == null)) {}
    label295:
    for (;;)
    {
      return;
      if (this.b == null) {
        h();
      }
      for (;;)
      {
        if ((this.c == 0.0F) && (this.d == 0.0F)) {
          break label295;
        }
        this.m = this.a.getBitmap();
        if ((this.m == null) || (this.m.isRecycled())) {
          break;
        }
        Object localObject1 = this.e.getSouthwest();
        Object localObject2 = this.e.getNortheast();
        localObject1 = this.n.b().a((LatLng)localObject1);
        PointF localPointF = this.n.b().a((LatLng)localObject2);
        localObject2 = new Paint();
        float f1 = (localPointF.x - ((PointF)localObject1).x) * this.j + ((PointF)localObject1).x;
        float f2 = (((PointF)localObject1).y - localPointF.y) * this.k + localPointF.y;
        localObject1 = new RectF(((PointF)localObject1).x - f1, localPointF.y - f2, localPointF.x - f1, ((PointF)localObject1).y - f2);
        ((Paint)localObject2).setAlpha((int)(255.0F - this.i * 255.0F));
        ((Paint)localObject2).setFilterBitmap(true);
        paramCanvas.save();
        paramCanvas.translate(f1, f2);
        paramCanvas.rotate(this.f);
        paramCanvas.drawBitmap(this.m, null, (RectF)localObject1, (Paint)localObject2);
        paramCanvas.restore();
        return;
        if (this.e == null) {
          g();
        }
      }
    }
  }
  
  public float e()
  {
    return this.f;
  }
  
  public boolean equalsRemote(c paramc)
  {
    return (equals(paramc)) || (paramc.getId().equals(getId()));
  }
  
  public float f()
  {
    return this.i;
  }
  
  public String getId()
  {
    if (this.l == null) {
      this.l = a.a("GroundOverlay");
    }
    return this.l;
  }
  
  public float getZIndex()
  {
    return this.g;
  }
  
  public int hashCodeRemote()
  {
    return super.hashCode();
  }
  
  public boolean isVisible()
  {
    return this.h;
  }
  
  public void remove()
  {
    this.o.b(getId());
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.n.a(false, false);
  }
  
  public void setZIndex(float paramFloat)
  {
    this.g = paramFloat;
    this.o.c();
    this.n.a(false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.e.b
 * JD-Core Version:    0.7.0.1
 */