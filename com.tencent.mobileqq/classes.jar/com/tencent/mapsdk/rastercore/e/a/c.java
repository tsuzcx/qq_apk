package com.tencent.mapsdk.rastercore.e.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.BitmapDescriptorFactory;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerDraggedListener;

public final class c
{
  private static int a = 0;
  private static BitmapDescriptor b;
  private Animation A;
  private int B = 25;
  private Object C;
  private com.tencent.mapsdk.rastercore.d.e c;
  private Context d;
  private f e;
  private MapView f;
  private View g;
  private View h;
  private Animation i = null;
  private Animation j = null;
  private GestureDetector k;
  private BitmapDescriptor l = null;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private float q = 0.5F;
  private float r = 1.0F;
  private boolean s = true;
  private float t = 0.0F;
  private float u = 1.0F;
  private String v;
  private LatLng w;
  private String x;
  private String y;
  private Animation z;
  
  public c(com.tencent.mapsdk.rastercore.d.e parame, MarkerOptions paramMarkerOptions)
  {
    this.c = parame;
    this.d = com.tencent.mapsdk.rastercore.d.e.a();
    this.f = parame.d();
    this.e = parame.h();
    this.n = paramMarkerOptions.isGps();
    if ((paramMarkerOptions.getPosition() == null) || (this.n)) {}
    try
    {
      parame = e.a(paramMarkerOptions.getPosition().getLongitude(), paramMarkerOptions.getPosition().getLatitude());
      new LatLng(parame[1], parame[0]);
      this.w = paramMarkerOptions.getPosition();
      a(paramMarkerOptions.getIcon());
      this.g = paramMarkerOptions.getMarkerView();
      this.q = paramMarkerOptions.getAnchorU();
      this.r = paramMarkerOptions.getAnchorV();
      this.u = paramMarkerOptions.getAlpha();
      this.t = paramMarkerOptions.getRotation();
      this.s = paramMarkerOptions.isVisible();
      this.v = paramMarkerOptions.getSnippet();
      this.x = paramMarkerOptions.getTitle();
      this.m = paramMarkerOptions.isDraggable();
      this.y = m();
      this.j = paramMarkerOptions.getInfoWindowHideAnimation();
      this.i = paramMarkerOptions.getInfoWindowShowAnimation();
      this.z = paramMarkerOptions.getShowingAnination();
      this.A = paramMarkerOptions.getHidingAnination();
      this.C = paramMarkerOptions.getTag();
      this.B = ((int)(this.B * this.d.getResources().getDisplayMetrics().density));
      this.k = new GestureDetector(this.d, new GestureDetector.OnGestureListener()
      {
        public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
        {
          return true;
        }
        
        public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          return false;
        }
        
        public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
        {
          if (c.b(c.this))
          {
            float f1 = c.a(c.this).c().getX();
            float f2 = c.a(c.this).c().getY();
            c.a(c.this, true);
            c.b(c.this, c.this.e());
            if (c.e(c.this)) {
              c.this.g();
            }
            c.a(c.this, f1, f2 - c.f(c.this));
            if (c.a(c.this).e() != null) {
              c.a(c.this).e().onMarkerDragStart(new Marker(c.this));
            }
          }
        }
        
        public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
        {
          if ((!c.b(c.this)) || (!c.c(c.this)))
          {
            c.d(c.this).requestDisallowInterceptTouchEvent(false);
            return false;
          }
          return true;
        }
        
        public final void onShowPress(MotionEvent paramAnonymousMotionEvent) {}
        
        public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
        {
          c.this.n();
          if (c.a(c.this).d() == null)
          {
            if (c.this.e()) {
              c.this.g();
            }
            for (;;)
            {
              return true;
              c.this.f();
            }
          }
          return c.a(c.this).d().onMarkerClick(new Marker(c.this));
        }
      });
      q();
      return;
    }
    catch (Exception parame)
    {
      for (;;)
      {
        paramMarkerOptions.getPosition();
      }
    }
  }
  
  private static boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat1 > paramFloat2) && (paramFloat1 <= paramFloat3);
  }
  
  private void q()
  {
    if (this.g == null)
    {
      if (this.l == null)
      {
        if (b == null) {
          b = BitmapDescriptorFactory.defaultMarker();
        }
        this.l = b;
      }
      this.g = new ImageView(this.d);
      ((ImageView)this.g).setImageBitmap(this.l.getBitmap());
    }
    this.g.measure(0, 0);
    b(this.u);
    a(this.t);
    MapView.LayoutParams localLayoutParams = s();
    this.f.addView(this.g, localLayoutParams);
    if ((this.s) && (this.z != null))
    {
      this.g.clearAnimation();
      this.z.setAnimationListener(new a()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          c.g(c.this).setAnimationListener(null);
          c.h(c.this);
        }
      });
      this.g.startAnimation(this.z);
      return;
    }
    r();
  }
  
  private void r()
  {
    this.g.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        do
        {
          for (;;)
          {
            return c.i(c.this).onTouchEvent(paramAnonymousMotionEvent);
            if ((c.b(c.this)) && (c.c(c.this)))
            {
              c.a(c.this, false);
              c.this.n();
              new StringBuilder().append(c.e(c.this));
              if (c.e(c.this))
              {
                c.this.f();
                c.b(c.this, false);
              }
              if (c.a(c.this).e() != null) {
                c.a(c.this).e().onMarkerDragEnd(new Marker(c.this));
              }
            }
          }
        } while ((!c.b(c.this)) || (!c.c(c.this)));
        float f1 = c.a(c.this).c().getX();
        float f2 = c.a(c.this).c().getY();
        c.a(c.this, f1, f2 - c.f(c.this));
        new StringBuilder().append(f1).append(",").append(f2);
        if (c.a(c.this).e() != null) {
          c.a(c.this).e().onMarkerDrag(new Marker(c.this));
        }
        return true;
      }
    });
  }
  
  private MapView.LayoutParams s()
  {
    PointF localPointF = t();
    return new MapView.LayoutParams(-2, -2, this.w, -(int)localPointF.x, -(int)localPointF.y, 0);
  }
  
  private PointF t()
  {
    PointF localPointF = new PointF();
    localPointF.x = (this.g.getMeasuredWidth() * this.q);
    localPointF.y = (this.g.getMeasuredHeight() * this.r);
    return localPointF;
  }
  
  private PointF u()
  {
    PointF localPointF2 = new PointF();
    PointF localPointF1;
    if (a(this.t, 45.0F, 135.0F)) {
      localPointF1 = new PointF(0.0F, this.g.getMeasuredHeight() * 0.5F);
    }
    for (;;)
    {
      PointF localPointF3 = t();
      float f1 = localPointF1.x - localPointF3.x;
      float f2 = -localPointF1.y + localPointF3.y;
      float f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
      double d2 = Math.atan(f1 / f2);
      double d1;
      if ((f1 <= 0.0F) || (f2 >= 0.0F))
      {
        d1 = d2;
        if (f1 < 0.0F)
        {
          d1 = d2;
          if (f2 >= 0.0F) {}
        }
      }
      else
      {
        d1 = d2 + 3.141592653589793D;
      }
      d1 += this.t / 180.0F * 3.141592653589793D;
      localPointF2.x = ((float)(f3 * Math.sin(d1)));
      d2 = f3;
      localPointF2.y = (-(float)(Math.cos(d1) * d2));
      return localPointF2;
      if (a(this.t, 135.0F, 225.0F)) {
        localPointF1 = new PointF(this.g.getMeasuredWidth() * 0.5F, this.g.getMeasuredHeight());
      } else if (a(this.t, 225.0F, 315.0F)) {
        localPointF1 = new PointF(this.g.getMeasuredWidth(), this.g.getMeasuredHeight() * 0.5F);
      } else {
        localPointF1 = new PointF(this.g.getMeasuredWidth() * 0.5F, 0.0F);
      }
    }
  }
  
  private void v()
  {
    if (e())
    {
      this.h.clearAnimation();
      this.f.removeView(this.h);
      Object localObject = u();
      localObject = new MapView.LayoutParams(-2, -2, this.w, (int)((PointF)localObject).x, (int)((PointF)localObject).y, 81);
      int i1 = this.f.indexOfChild(this.g);
      this.f.addView(this.h, i1 + 1, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  private void w()
  {
    if ((e()) && ((this.h instanceof b)))
    {
      ((b)this.h).a.setText(this.x);
      ((b)this.h).b.setText(this.v);
    }
  }
  
  public final View a()
  {
    return this.g;
  }
  
  @SuppressLint({"NewApi"})
  public final void a(float paramFloat)
  {
    paramFloat = (paramFloat + 360.0F) % 360.0F;
    Object localObject;
    if (Build.VERSION.SDK_INT < 11)
    {
      localObject = new RotateAnimation(this.t, paramFloat, 1, this.q, 1, this.r);
      ((RotateAnimation)localObject).setFillAfter(true);
      ((RotateAnimation)localObject).setDuration(0L);
      this.g.clearAnimation();
      this.g.startAnimation((Animation)localObject);
    }
    for (;;)
    {
      this.t = paramFloat;
      v();
      return;
      localObject = t();
      this.g.setPivotX(((PointF)localObject).x);
      this.g.setPivotY(((PointF)localObject).y);
      this.g.setRotation(paramFloat);
    }
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    if ((this.q == paramFloat1) && (this.r == paramFloat2)) {
      return;
    }
    this.q = paramFloat1;
    this.r = paramFloat2;
    this.g.setLayoutParams(s());
    a(this.t);
    v();
  }
  
  public final void a(final View paramView)
  {
    if (this.g != null)
    {
      if (this.A != null)
      {
        this.A.setAnimationListener(new a()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            new Handler().post(new Runnable()
            {
              public final void run()
              {
                c.d(c.this).removeView(c.j(c.this));
                c.k(c.this).setAnimationListener(null);
                c.a(c.this, c.4.this.a);
                c.l(c.this);
                c.m(c.this);
              }
            });
          }
        });
        this.g.setOnTouchListener(null);
        this.g.startAnimation(this.A);
        return;
      }
      this.f.removeView(this.g);
    }
    this.g = paramView;
    q();
    v();
  }
  
  public final void a(Animation paramAnimation)
  {
    this.i = paramAnimation;
  }
  
  public final void a(BitmapDescriptor paramBitmapDescriptor)
  {
    this.l = paramBitmapDescriptor;
    if ((this.g != null) && ((this.g instanceof ImageView)))
    {
      ((ImageView)this.g).setImageBitmap(this.l.getBitmap());
      this.g.measure(0, 0);
      paramBitmapDescriptor = s();
      this.g.setLayoutParams(paramBitmapDescriptor);
    }
  }
  
  public final void a(LatLng paramLatLng)
  {
    this.w = paramLatLng;
    ((MapView.LayoutParams)this.g.getLayoutParams()).setPoint(paramLatLng);
    this.f.layout(this.g);
    if (this.h != null)
    {
      ((MapView.LayoutParams)this.h.getLayoutParams()).setPoint(paramLatLng);
      this.f.layout(this.h);
    }
  }
  
  public final void a(Object paramObject)
  {
    this.C = paramObject;
  }
  
  public final void a(String paramString)
  {
    this.v = paramString;
    w();
  }
  
  public final void a(boolean paramBoolean)
  {
    View localView = this.g;
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      localView.setVisibility(i1);
      if ((!paramBoolean) && (e())) {
        g();
      }
      this.s = paramBoolean;
      return;
    }
  }
  
  public final void b()
  {
    this.c.e().c(m());
  }
  
  public final void b(float paramFloat)
  {
    float f1;
    if (paramFloat < 0.0F)
    {
      f1 = 0.0F;
      if (Build.VERSION.SDK_INT >= 11) {
        break label73;
      }
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(this.u, f1);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setDuration(0L);
      this.g.clearAnimation();
      this.g.startAnimation(localAlphaAnimation);
    }
    for (;;)
    {
      this.u = f1;
      return;
      f1 = paramFloat;
      if (paramFloat <= 1.0F) {
        break;
      }
      f1 = 1.0F;
      break;
      label73:
      this.g.setAlpha(f1);
    }
  }
  
  public final void b(Animation paramAnimation)
  {
    this.j = paramAnimation;
  }
  
  public final void b(String paramString)
  {
    this.x = paramString;
    w();
  }
  
  public final void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public final void c()
  {
    if (this.A != null)
    {
      this.A.setAnimationListener(new a()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          new Handler().post(new Runnable()
          {
            public final void run()
            {
              c.d(c.this).removeView(c.j(c.this));
              c.d(c.this).removeView(c.n(c.this));
              c.k(c.this).setAnimationListener(null);
            }
          });
        }
      });
      this.g.setOnTouchListener(null);
      this.g.clearAnimation();
      this.g.startAnimation(this.A);
      return;
    }
    this.f.removeView(this.g);
    this.f.removeView(this.h);
  }
  
  public final boolean d()
  {
    return this.m;
  }
  
  public final boolean e()
  {
    return (this.h != null) && (this.h.getParent() != null);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while ((!(paramObject instanceof c)) || (paramObject.hashCode() != hashCode()) || (!((c)paramObject).m().equals(m()))) {
      return false;
    }
    return true;
  }
  
  public final void f()
  {
    if (e()) {
      return;
    }
    Object localObject;
    if (this.e.g() != null)
    {
      localObject = new Marker(this);
      localObject = this.e.g().getInfoWindow((Marker)localObject);
      if (localObject == null)
      {
        this.h = new b(this.d, this.x, this.v);
        t();
        localObject = u();
        new StringBuilder().append(((PointF)localObject).x).append(", ").append(((PointF)localObject).y);
        localObject = new MapView.LayoutParams(-2, -2, this.w, (int)((PointF)localObject).x, (int)((PointF)localObject).y, 81);
        int i1 = this.f.indexOfChild(this.g);
        this.f.addView(this.h, i1 + 1, (ViewGroup.LayoutParams)localObject);
        if (this.i == null) {
          break label231;
        }
        localObject = this.i;
      }
    }
    for (;;)
    {
      this.h.startAnimation((Animation)localObject);
      this.h.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (c.a(c.this).f() != null) {
            c.a(c.this).f().onInfoWindowClick(new Marker(c.this));
          }
        }
      });
      return;
      this.h = ((View)localObject);
      break;
      this.h = new b(this.d, this.x, this.v);
      break;
      label231:
      localObject = new AnimationSet(false);
      ScaleAnimation localScaleAnimation1 = new ScaleAnimation(0.0F, 1.1F, 0.0F, 1.1F, 1, 0.5F, 1, 1.0F);
      localScaleAnimation1.setDuration(150L);
      localScaleAnimation1.setInterpolator(new AccelerateInterpolator());
      ScaleAnimation localScaleAnimation2 = new ScaleAnimation(1.0F, 0.9F, 1.0F, 0.9F, 1, 0.5F, 1, 1.0F);
      localScaleAnimation2.setDuration(100L);
      localScaleAnimation2.setInterpolator(new DecelerateInterpolator());
      localScaleAnimation2.setStartOffset(150L);
      ((AnimationSet)localObject).addAnimation(localScaleAnimation1);
      ((AnimationSet)localObject).addAnimation(localScaleAnimation2);
    }
  }
  
  public final void g()
  {
    if (!e()) {
      return;
    }
    this.h.clearAnimation();
    Object localObject;
    if (this.j != null) {
      localObject = this.j;
    }
    for (;;)
    {
      ((Animation)localObject).setAnimationListener(new a()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          new Handler().post(new Runnable()
          {
            public final void run()
            {
              c.d(c.this).removeView(c.n(c.this));
              if (c.a(c.this).g() != null) {
                c.o(c.this).h().g().onInfoWindowDettached(new Marker(c.this), c.n(c.this));
              }
              c.b(c.this, null);
            }
          });
        }
      });
      this.h.startAnimation((Animation)localObject);
      return;
      localObject = new AnimationSet(true);
      ((AnimationSet)localObject).setInterpolator(new AccelerateInterpolator());
      ((AnimationSet)localObject).addAnimation(new AlphaAnimation(1.0F, 0.0F));
      ((AnimationSet)localObject).addAnimation(new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 1.0F));
      ((AnimationSet)localObject).setDuration(100L);
    }
  }
  
  public final String h()
  {
    return this.x;
  }
  
  public final int hashCode()
  {
    return m().hashCode();
  }
  
  public final String i()
  {
    return this.v;
  }
  
  public final float j()
  {
    return this.t;
  }
  
  public final boolean k()
  {
    return this.s;
  }
  
  public final LatLng l()
  {
    return this.w;
  }
  
  public final String m()
  {
    if (this.y == null)
    {
      a += 1;
      this.y = ("Marker" + a);
    }
    return this.y;
  }
  
  public final void n()
  {
    if (Build.VERSION.SDK_INT < 11) {
      this.g.clearAnimation();
    }
    this.f.removeView(this.g);
    this.f.addView(this.g);
    v();
  }
  
  public final float o()
  {
    return this.u;
  }
  
  public final Object p()
  {
    return this.C;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.e.a.c
 * JD-Core Version:    0.7.0.1
 */