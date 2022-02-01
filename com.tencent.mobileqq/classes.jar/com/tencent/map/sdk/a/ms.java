package com.tencent.map.sdk.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.core.functions.animation.GlAnimation;
import com.tencent.map.core.functions.animation.GlAnimation.SetAnimatePropertyListener;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.maps.model.AnimationListener;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.security.SecureRandom;
import javax.microedition.khronos.opengles.GL10;

public class ms
  extends mu
{
  public boolean A = false;
  public boolean B = true;
  public boolean C = false;
  public int D = 0;
  public int E = 0;
  public pn F = null;
  public Marker G = null;
  public ir H;
  public GlAnimation I = null;
  public gj J;
  public GlAnimation.SetAnimatePropertyListener K = new ms.1(this);
  private boolean O = false;
  private GeoPoint P = null;
  private lq Q;
  private AnimationListener R = null;
  private TencentMap.OnMarkerClickListener S;
  protected Object h = null;
  protected Bitmap i = null;
  boolean j = false;
  protected byte[] k = new byte[0];
  float l = 0.5F;
  float m = 0.5F;
  protected float n = 0.0F;
  protected boolean o = false;
  protected float p = 0.0F;
  protected float q = 0.0F;
  protected float r = -1.0F;
  protected MarkerOptions s = null;
  protected String t = null;
  protected GeoPoint u = null;
  protected GeoPoint v = null;
  protected GeoPoint w = null;
  protected float x = 1.0F;
  protected float y = 1.0F;
  protected float z = 1.0F;
  
  public ms(lq paramlq, pn parampn)
  {
    this.Q = paramlq;
    this.F = parampn;
  }
  
  private void a(Bitmap paramBitmap)
  {
    synchronized (this.k)
    {
      this.i = paramBitmap;
      if (this.t == null) {
        this.t = paramBitmap.toString();
      }
      if (this.H != null) {
        this.H.a(this.t, new Bitmap[] { this.i });
      }
      return;
    }
  }
  
  private void a(String paramString)
  {
    synchronized (this.k)
    {
      this.t = paramString;
      return;
    }
  }
  
  private void b(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    a(paramBitmap);
    s();
  }
  
  private void s()
  {
    synchronized (this.k)
    {
      if ((this.i != null) && (!this.i.isRecycled())) {
        this.j = true;
      }
      return;
    }
  }
  
  public final void a(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {
      return;
    }
    GeoPoint localGeoPoint = this.u;
    if (localGeoPoint == null)
    {
      this.u = new GeoPoint(paramGeoPoint.getLatitudeE6(), paramGeoPoint.getLongitudeE6());
    }
    else
    {
      localGeoPoint.setLatitudeE6(paramGeoPoint.getLatitudeE6());
      this.u.setLongitudeE6(paramGeoPoint.getLongitudeE6());
    }
    paramGeoPoint = this.H;
    if (paramGeoPoint != null) {
      paramGeoPoint.a(this.u);
    }
    paramGeoPoint = this.J;
    if (paramGeoPoint != null) {
      paramGeoPoint.a(fz.a(this.u));
    }
  }
  
  public final void a(BitmapDescriptor paramBitmapDescriptor)
  {
    if (this.F != null)
    {
      if (paramBitmapDescriptor == null) {
        return;
      }
      paramBitmapDescriptor = paramBitmapDescriptor.getFormater();
      if (paramBitmapDescriptor != null)
      {
        Object localObject = this.F;
        if (localObject != null)
        {
          localObject = paramBitmapDescriptor.a(((pt)localObject).ay);
          a(paramBitmapDescriptor.g);
          b((Bitmap)localObject);
        }
      }
      paramBitmapDescriptor = this.J;
      if (paramBitmapDescriptor != null) {
        paramBitmapDescriptor.f();
      }
    }
  }
  
  public final void a(MarkerOptions paramMarkerOptions)
  {
    if (paramMarkerOptions == null) {
      return;
    }
    this.s = paramMarkerOptions;
    a(fz.a(paramMarkerOptions.getPosition()));
    b(paramMarkerOptions.getAnchorU(), paramMarkerOptions.getAnchorV());
    c(paramMarkerOptions.isVisible());
    c(paramMarkerOptions.getRotation());
    a(paramMarkerOptions.getIcon());
    d(paramMarkerOptions.getAlpha());
    b(paramMarkerOptions.getZIndex());
    d(paramMarkerOptions.getLevel());
    this.N = paramMarkerOptions.getIndoorInfo();
    this.h = paramMarkerOptions.getTag();
    if ((this.F != null) && (paramMarkerOptions != null))
    {
      if (this.H != null) {
        return;
      }
      is localis = new is();
      localis.a = fz.a(paramMarkerOptions.getPosition());
      localis.e = paramMarkerOptions.getAlpha();
      localis.a(paramMarkerOptions.getAnchorU(), paramMarkerOptions.getAnchorV());
      Object localObject1 = new SecureRandom();
      Object localObject2 = new byte[20];
      ((SecureRandom)localObject1).nextBytes((byte[])localObject2);
      localObject1 = new String((byte[])localObject2);
      try
      {
        localObject2 = paramMarkerOptions.getIcon().getFormater().g;
        localObject1 = localObject2;
      }
      catch (NullPointerException localNullPointerException)
      {
        localNullPointerException.printStackTrace();
      }
      localObject1 = localis.a((String)localObject1, new Bitmap[] { paramMarkerOptions.getIcon().getBitmap(this.F.ay) });
      ((is)localObject1).g = ((int)paramMarkerOptions.getRotation());
      ((is)localObject1).f = paramMarkerOptions.isFlat();
      ((is)localObject1).j = ((int)paramMarkerOptions.getZIndex());
      ((is)localObject1).l = this.C;
      ((is)localObject1).o = paramMarkerOptions.isAvoidAnnocation();
      ((is)localObject1).p = paramMarkerOptions.isClockwise();
      ((is)localObject1).m = paramMarkerOptions.isFastLoad();
      ((is)localObject1).k = paramMarkerOptions.getLevel();
      this.H = new ir(this.F.az.b.f, localis);
    }
  }
  
  public final void a(GL10 paramGL10)
  {
    if (this.F == null) {
      return;
    }
    if (!a())
    {
      c();
      return;
    }
    Object localObject = this.F;
    if ((localObject != null) && (this.A)) {
      a(((pn)localObject).n());
    }
    if (this.F != null)
    {
      localObject = this.I;
      if (localObject != null)
      {
        ((GlAnimation)localObject).drawAnimation();
        this.O = this.I.isRunning();
        if ((this.O) && (this.F.az != null)) {
          this.F.az.b.k();
        }
      }
    }
    if (this.F.az != null)
    {
      if (this.F.az.b.f != null)
      {
        localObject = this.H;
        if (localObject != null) {
          ((ir)localObject).a(paramGL10);
        }
      }
      localObject = this.J;
      if ((localObject != null) && (((gj)localObject).e())) {
        this.J.a(paramGL10);
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.C = paramBoolean;
    Object localObject = this.H;
    if (localObject != null) {
      ((ir)localObject).a(paramBoolean);
    }
    localObject = this.J;
    if (localObject != null)
    {
      if (paramBoolean)
      {
        ((gj)localObject).a(this.D, this.E);
        return;
      }
      ((gj)localObject).b(false);
    }
  }
  
  public final boolean a()
  {
    if (q() != null) {
      return (this.e) && (this.M);
    }
    return this.e;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.F != null)
    {
      if (!this.B) {
        return false;
      }
      Object localObject = this.H;
      if (localObject != null)
      {
        boolean bool = ((ir)localObject).a(paramFloat1, paramFloat2);
        if (bool)
        {
          localObject = this.S;
          if (localObject != null) {
            ((TencentMap.OnMarkerClickListener)localObject).onMarkerClick(this.G);
          }
        }
        return bool;
      }
    }
    return false;
  }
  
  public final void b()
  {
    this.u = null;
    this.F = null;
    this.Q = null;
    Object localObject = this.H;
    if (localObject != null) {
      ((ir)localObject).b();
    }
    localObject = this.J;
    if (localObject != null) {
      ((gj)localObject).b();
    }
  }
  
  public final void b(float paramFloat)
  {
    this.d = paramFloat;
    ir localir = this.H;
    if (localir != null) {
      localir.c((int)paramFloat);
    }
  }
  
  public final void b(float paramFloat1, float paramFloat2)
  {
    float f;
    if (paramFloat1 > 1.0F)
    {
      f = 1.0F;
    }
    else
    {
      f = paramFloat1;
      if (paramFloat1 < 0.0F) {
        f = 0.0F;
      }
    }
    if (paramFloat2 > 1.0F)
    {
      paramFloat1 = 1.0F;
    }
    else
    {
      paramFloat1 = paramFloat2;
      if (paramFloat2 < 0.0F) {
        paramFloat1 = 0.0F;
      }
    }
    this.l = f;
    this.m = paramFloat1;
    Object localObject = this.H;
    if (localObject != null) {
      ((ir)localObject).b(this.l, this.m);
    }
    localObject = this.J;
    if (localObject != null) {
      ((gj)localObject).a_();
    }
  }
  
  public final void c()
  {
    Object localObject = this.J;
    if (localObject != null)
    {
      ((gj)localObject).b();
      this.J = null;
    }
    localObject = this.H;
    if (localObject != null) {
      ((ir)localObject).b();
    }
  }
  
  public final void c(float paramFloat)
  {
    this.n = paramFloat;
    ir localir = this.H;
    if (localir != null) {
      localir.b((int)this.n);
    }
  }
  
  public final void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
    Object localObject = this.H;
    if (localObject != null) {
      ((ir)localObject).d = paramBoolean;
    }
    localObject = this.F;
    if ((localObject != null) && (((pt)localObject).az != null)) {
      this.F.az.b.k();
    }
  }
  
  public final void d() {}
  
  public final void d(float paramFloat)
  {
    this.x = paramFloat;
    ir localir = this.H;
    if (localir != null) {
      localir.a(paramFloat);
    }
  }
  
  public final void d(int paramInt)
  {
    super.d(paramInt);
    ir localir = this.H;
    if (localir != null) {
      localir.a(paramInt);
    }
  }
  
  public final GeoPoint e()
  {
    return this.u;
  }
  
  public final boolean f()
  {
    pn localpn = this.F;
    if ((localpn != null) && (this.I != null))
    {
      GeoPoint localGeoPoint2 = this.u;
      GeoPoint localGeoPoint1 = localGeoPoint2;
      if (this.C)
      {
        localGeoPoint1 = localGeoPoint2;
        if (localpn.az != null)
        {
          localGeoPoint1 = this.F.az.b.h.a(new DoublePoint(this.D, this.E));
          this.P = new GeoPoint(localGeoPoint1);
        }
      }
      return this.I.startAnimation(localGeoPoint1, this.w);
    }
    return false;
  }
  
  public final Rect g()
  {
    if (this.H != null)
    {
      pn localpn = this.F;
      if ((localpn != null) && (localpn.az != null)) {
        return this.H.a(this.F.az.b.h);
      }
    }
    return new Rect();
  }
  
  public final void h()
  {
    b();
  }
  
  public final String k()
  {
    MarkerOptions localMarkerOptions = this.s;
    if (localMarkerOptions == null) {
      return null;
    }
    return localMarkerOptions.getContentDescription();
  }
  
  public final float l()
  {
    return this.n;
  }
  
  public final boolean m()
  {
    return true;
  }
  
  public final void n()
  {
    ??? = this.F;
    if (??? == null) {
      return;
    }
    ((pn)???).a("");
    this.F.az.b.k();
    synchronized (this.F.a)
    {
      if (this.J == null) {
        return;
      }
      this.J.a(false);
      return;
    }
  }
  
  public final void o()
  {
    ??? = this.F;
    if (??? != null)
    {
      if (this.s == null) {
        return;
      }
      synchronized (((pn)???).a)
      {
        if (this.J == null)
        {
          if (this.s.isViewInfowindow()) {
            this.J = new mx(this.Q, this.G);
          } else {
            this.J = new mr(this.Q, this.G);
          }
        }
        else {
          this.J.f();
        }
        if (this.C) {
          this.J.a(this.D, this.E);
        }
        this.J.a(true);
        return;
      }
    }
  }
  
  public final boolean p()
  {
    Object localObject = this.h;
    return (localObject != null) && ("AUTH_MARKER".equals(localObject.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ms
 * JD-Core Version:    0.7.0.1
 */