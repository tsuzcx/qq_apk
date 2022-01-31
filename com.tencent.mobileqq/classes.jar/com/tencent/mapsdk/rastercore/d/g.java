package com.tencent.mapsdk.rastercore.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Scroller;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.rastercore.a.a.a;
import com.tencent.mapsdk.rastercore.b.d;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerDraggedListener;

public final class g
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnKeyListener
{
  private long A = 0L;
  private Point B;
  private f a;
  private b b;
  private a c;
  private GestureDetector d;
  private MotionEvent e;
  private TencentMap.OnMapClickListener f;
  private TencentMap.OnMapLongClickListener g;
  private TencentMap.OnMapCameraChangeListener h;
  private TencentMap.OnInfoWindowClickListener i;
  private TencentMap.InfoWindowAdapter j;
  private TencentMap.OnMarkerDraggedListener k;
  private TencentMap.OnMarkerClickListener l;
  private float m = 1.0F;
  private float n = 1.0F;
  private float o = 1.0F;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private Scroller s;
  private int t = 0;
  private int u = 0;
  private long v;
  private float w;
  private float x;
  private float y;
  private float z;
  
  public g(f paramf)
  {
    this.a = paramf;
    this.b = paramf.c();
    this.c = paramf.e();
    this.d = new GestureDetector(f.a().getApplicationContext(), this);
    this.s = new Scroller(f.a());
    new DisplayMetrics();
    paramf = f.a().getApplicationContext().getResources().getDisplayMetrics();
    this.t = (paramf.widthPixels / 2);
    this.u = (paramf.heightPixels / 2);
  }
  
  private static float c(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    new StringBuilder("event0.x:").append(paramMotionEvent.getX(0)).append(",event0.y:").append(paramMotionEvent.getY(0)).append(";  event1.x:").append(paramMotionEvent.getX(1)).append(",event1.y:").append(paramMotionEvent.getY(1));
    return (float)Math.sqrt(f1 * f1 + f2 * f2);
  }
  
  public final void a()
  {
    int i1;
    int i2;
    if (this.s.computeScrollOffset())
    {
      i1 = this.s.getCurrX() - this.t;
      i2 = this.s.getCurrY() - this.u;
      this.t = this.s.getCurrX();
      this.u = this.s.getCurrY();
      this.b.scrollBy(i1, i2);
      if (this.s.isFinished())
      {
        if (this.h != null) {
          a(true);
        }
        this.a.a(false, false);
      }
    }
    else
    {
      return;
    }
    if (Math.abs(i1) < 6) {
      Math.abs(i2);
    }
    this.a.a(false, false);
  }
  
  public final void a(TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    this.j = paramInfoWindowAdapter;
  }
  
  public final void a(TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    this.i = paramOnInfoWindowClickListener;
  }
  
  public final void a(TencentMap.OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    this.h = paramOnMapCameraChangeListener;
  }
  
  public final void a(TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    this.f = paramOnMapClickListener;
  }
  
  public final void a(TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    this.g = paramOnMapLongClickListener;
  }
  
  public final void a(TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    this.l = paramOnMarkerClickListener;
  }
  
  public final void a(TencentMap.OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    this.k = paramOnMarkerDraggedListener;
  }
  
  public final void a(boolean paramBoolean)
  {
    CameraPosition localCameraPosition;
    if (this.h != null)
    {
      localCameraPosition = this.a.b().d();
      if (paramBoolean)
      {
        this.h.onCameraChangeFinish(localCameraPosition);
        this.r = false;
      }
    }
    else
    {
      return;
    }
    this.h.onCameraChange(localCameraPosition);
    this.r = true;
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i2 = 0;
    int i1 = i2;
    label180:
    Object localObject;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i1 = i2;
    case 3: 
    case 4: 
    case 0: 
      for (;;)
      {
        if (i1 != 0) {
          this.A = paramMotionEvent.getEventTime();
        }
        if ((i1 == 0) && (!this.q)) {
          this.d.onTouchEvent(paramMotionEvent);
        }
        if ((paramMotionEvent.getAction() == 1) && (!this.q) && (this.h != null) && (this.s.isFinished()) && ((this.p) || (this.r))) {
          a(true);
        }
        if (i1 != 0)
        {
          paramMotionEvent.setAction(3);
          this.d.onTouchEvent(paramMotionEvent);
        }
        this.c.a(paramMotionEvent);
        bool = true;
        return bool;
        new StringBuilder("event0.x:").append(paramMotionEvent.getX(0)).append(",event0.y:").append(paramMotionEvent.getY(0));
        this.a.d().stopAnimation();
        i1 = i2;
        if (this.a.f().g())
        {
          this.a.j();
          i1 = i2;
        }
      }
    case 1: 
      this.A = paramMotionEvent.getEventTime();
      if (this.a.f().g()) {
        this.a.k();
      }
      if ((paramMotionEvent.getEventTime() - this.v < 200L) && (((Math.abs(paramMotionEvent.getX(0) - this.x) < 10.0F) && (Math.abs(paramMotionEvent.getY(0) - this.z) < 10.0F)) || ((Math.abs(paramMotionEvent.getX(0) - this.w) < 10.0F) && (Math.abs(paramMotionEvent.getY(0) - this.y) < 10.0F))))
      {
        localObject = this.b.d();
        if ((this.a.f().a() >= 3) && (this.a.f().b() > 1.0F))
        {
          i1 = 1;
          label420:
          if (i1 == 0) {
            break label492;
          }
          ((d)localObject).a(1.3D);
          label433:
          if (this.a.f().i()) {
            this.b.b(true, null);
          }
        }
      }
      break;
    }
    for (i1 = 1;; i1 = 0)
    {
      this.v = 0L;
      this.w = 0.0F;
      this.y = 0.0F;
      this.p = false;
      this.o = 0.0F;
      break;
      i1 = 0;
      break label420;
      label492:
      ((d)localObject).a(1.0D);
      break label433;
      i1 = i2;
      if (paramMotionEvent.getPointerCount() <= 1) {
        break;
      }
      this.v = paramMotionEvent.getEventTime();
      this.x = paramMotionEvent.getX(0);
      this.z = paramMotionEvent.getY(0);
      this.w = paramMotionEvent.getX(1);
      this.y = paramMotionEvent.getY(1);
      this.o = c(paramMotionEvent);
      i1 = i2;
      break;
      i1 = i2;
      if (paramMotionEvent.getPointerCount() != 2) {
        break;
      }
      new StringBuilder("event0.x:").append(paramMotionEvent.getX(0)).append(",event0.y:").append(paramMotionEvent.getY(0)).append(";  event1.x:").append(paramMotionEvent.getX(1)).append(",event1.y:").append(paramMotionEvent.getY(1));
      if (this.q)
      {
        double d1 = Math.sqrt(this.n * this.m);
        localObject = new PointF(this.b.getWidth() / 2, this.b.getHeight() / 2);
        this.b.a((d1 - 1.0D) * 1.5D + this.b.c(), (PointF)localObject, true, 200L, a.a.b, new CancelableCallback()
        {
          public final void onCancel()
          {
            g.a(g.this, false);
          }
          
          public final void onFinish()
          {
            g.a(g.this, false);
          }
        });
      }
      this.B = null;
      i1 = i2;
      break;
      i1 = i2;
      if (paramMotionEvent.getPointerCount() <= 1) {
        break;
      }
      if (!this.a.f().i()) {
        break label180;
      }
      float f1 = c(paramMotionEvent);
      i1 = i2;
      if (f1 < 10.0F) {
        break;
      }
      if (this.o < 10.0F)
      {
        this.o = f1;
        i1 = i2;
        break;
      }
      this.m = this.n;
      this.n = (f1 / this.o);
      new StringBuilder().append(this.n);
      i1 = i2;
      if (Math.abs(this.n - 1.0F) < 0.01D) {
        break;
      }
      localObject = new PointF(this.b.getWidth() / 2, this.b.getHeight() / 2);
      this.b.a(this.n, (PointF)localObject);
      a(false);
      this.o = f1;
      this.a.a(false, false);
      this.q = true;
      i1 = 1;
      break;
    }
  }
  
  public final void b()
  {
    this.s.abortAnimation();
  }
  
  public final void b(MotionEvent paramMotionEvent)
  {
    if (this.e != null) {
      this.e.recycle();
    }
    this.e = paramMotionEvent;
    if (this.e.getAction() == 0)
    {
      if (this.B == null) {
        this.B = new Point();
      }
      this.B.x = ((int)this.e.getX());
      this.B.y = ((int)this.e.getY());
    }
  }
  
  public final MotionEvent c()
  {
    return this.e;
  }
  
  public final TencentMap.OnMarkerClickListener d()
  {
    return this.l;
  }
  
  public final TencentMap.OnMarkerDraggedListener e()
  {
    return this.k;
  }
  
  public final TencentMap.OnInfoWindowClickListener f()
  {
    return this.i;
  }
  
  public final TencentMap.InfoWindowAdapter g()
  {
    return this.j;
  }
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (!this.a.f().i()) {}
    label128:
    for (;;)
    {
      return true;
      d locald = this.b.d();
      int i1;
      if ((this.a.f().a() >= 3) && (this.a.f().b() > 1.0F))
      {
        i1 = 1;
        if (i1 == 0) {
          break label122;
        }
        locald.a(1.3D);
      }
      for (;;)
      {
        if (this.b.d().a() >= this.a.b().i().a()) {
          break label128;
        }
        this.b.a(new PointF(paramMotionEvent.getX(), paramMotionEvent.getY()), true, null);
        return true;
        i1 = 0;
        break;
        label122:
        locald.a(1.0D);
      }
    }
  }
  
  public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    this.p = false;
    return false;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.p = false;
    if (!this.a.f().h()) {
      return true;
    }
    this.s.fling(this.t, this.u, (int)(-paramFloat1 * 0.6D), (int)(-paramFloat2 * 0.6D), -2147483647, 2147483647, -2147483647, 2147483647);
    this.a.a(false, false);
    return true;
  }
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 21: 
      this.b.scrollBy(-10, 0);
      return true;
    case 22: 
      this.b.scrollBy(10, 0);
      return true;
    case 19: 
      this.b.scrollBy(0, -10);
      return true;
    }
    this.b.scrollBy(0, 10);
    return true;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    this.p = false;
    LatLng localLatLng = this.a.b().a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    this.c.a(com.tencent.mapsdk.rastercore.f.b.a(localLatLng), paramMotionEvent);
    if (this.g != null) {
      this.g.onMapLongClick(localLatLng);
    }
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!this.a.f().h()) {
      this.p = false;
    }
    while ((this.q) || (paramMotionEvent2.getEventTime() - this.A < 30L)) {
      return true;
    }
    this.p = true;
    int i1 = (int)this.e.getX();
    int i2 = (int)this.e.getY();
    if (this.B == null)
    {
      this.B = new Point();
      this.B.x = i1;
      this.B.y = i2;
      return true;
    }
    int i3 = this.B.x;
    int i4 = this.B.y;
    this.b.scrollBy(i3 - i1, i4 - i2);
    this.B.x = i1;
    this.B.y = i2;
    a(false);
    return true;
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    this.p = false;
    try
    {
      paramMotionEvent = this.a.b().a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if (this.c.a(com.tencent.mapsdk.rastercore.f.b.a(paramMotionEvent))) {
        return true;
      }
      if (this.f != null)
      {
        this.f.onMapClick(paramMotionEvent);
        this.a.d().setFocusable(true);
        this.a.d().setFocusableInTouchMode(true);
        this.a.d().requestFocus();
        paramMotionEvent = (InputMethodManager)f.a().getSystemService("input_method");
        if (paramMotionEvent.isActive())
        {
          paramMotionEvent.hideSoftInputFromWindow(this.a.d().getWindowToken(), 0);
          return true;
        }
      }
    }
    catch (Exception paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.d.g
 * JD-Core Version:    0.7.0.1
 */