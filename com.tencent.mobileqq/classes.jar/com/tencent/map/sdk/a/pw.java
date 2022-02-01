package com.tencent.map.sdk.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.map.sdk.basemap.interfaces.IMapRenderView;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

public final class pw
  extends View
  implements IMapRenderView
{
  private Context a;
  private pn b;
  private Object c;
  private int d;
  private int e;
  private TencentMapOptions f;
  private pl g;
  private boolean h = true;
  private boolean i = false;
  
  public pw(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext);
    if ((paramTencentMapOptions != null) && (paramContext != null))
    {
      Object localObject = paramTencentMapOptions.getExtSurface();
      if (localObject == null) {
        return;
      }
      this.a = paramContext.getApplicationContext();
      this.c = localObject;
      this.d = paramTencentMapOptions.getExtSurfaceWidth();
      this.e = paramTencentMapOptions.getExtSurfaceHeight();
      if ((this.e <= 0) || (this.d <= 0))
      {
        this.d = 0;
        this.e = 0;
      }
      this.f = paramTencentMapOptions;
      this.b = new pn(this, this.a, this.f);
    }
  }
  
  public final lf getVectorMapDelegate()
  {
    return this.b;
  }
  
  public final void onDestroy()
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((pn)localObject).onDestroy();
    }
    localObject = this.g;
    if (localObject != null) {
      ((pl)localObject).c();
    }
  }
  
  public final void onPause()
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((pn)localObject).onPause();
    }
    localObject = this.g;
    if (localObject != null) {
      ((pl)localObject).a();
    }
  }
  
  public final void onRedraw()
  {
    pl localpl = this.g;
    if (localpl != null) {
      try
      {
        this.g.notify();
        return;
      }
      finally {}
    }
  }
  
  public final void onResume()
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((pn)localObject).onResume();
    }
    localObject = this.g;
    if (localObject != null) {
      ((pl)localObject).b();
    }
    localObject = this.b;
    if ((localObject != null) && (this.h == true))
    {
      ((pn)localObject).a(null, null);
      this.b.a(null, this.d, this.e);
      this.b.a(this.d, this.e);
      this.h = false;
    }
    if (this.g == null) {
      this.g = new pl(this.c, this.b);
    }
    if (!this.i)
    {
      this.g.start();
      this.i = true;
    }
  }
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    pn localpn = this.b;
    if (localpn != null)
    {
      this.d = paramInt1;
      this.e = paramInt2;
      localpn.a(null, paramInt1, paramInt2);
      this.b.a(paramInt1, paramInt2);
      this.b.s();
      this.h = true;
    }
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    if (this.b != null)
    {
      pl localpl = this.g;
      if (localpl != null)
      {
        if (!localpl.isAlive()) {
          return;
        }
        localpl = this.g;
        if (localpl != null)
        {
          this.c = paramObject;
          localpl.a(paramObject);
        }
        paramObject = this.b;
        if (paramObject != null)
        {
          paramObject.a(null, null);
          this.b.a(null, paramInt1, paramInt2);
        }
      }
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    pn localpn = this.b;
    if (localpn != null) {
      return localpn.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public final void setZOrderMediaOverlay(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.pw
 * JD-Core Version:    0.7.0.1
 */