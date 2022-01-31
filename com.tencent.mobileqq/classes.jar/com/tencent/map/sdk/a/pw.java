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
    Object localObject;
    if ((paramTencentMapOptions != null) && (paramContext != null))
    {
      localObject = paramTencentMapOptions.getExtSurface();
      if (localObject != null) {}
    }
    else
    {
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
  
  public final lf getVectorMapDelegate()
  {
    return this.b;
  }
  
  public final void onDestroy()
  {
    if (this.b != null) {
      this.b.onDestroy();
    }
    if (this.g != null) {
      this.g.c();
    }
  }
  
  public final void onPause()
  {
    if (this.b != null) {
      this.b.onPause();
    }
    if (this.g != null) {
      this.g.a();
    }
  }
  
  public final void onRedraw()
  {
    if (this.g != null) {
      synchronized (this.g)
      {
        this.g.notify();
        return;
      }
    }
  }
  
  public final void onResume()
  {
    if (this.b != null) {
      this.b.onResume();
    }
    if (this.g != null) {
      this.g.b();
    }
    if ((this.b != null) && (this.h == true))
    {
      this.b.a(null, null);
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
    if (this.b != null)
    {
      this.d = paramInt1;
      this.e = paramInt2;
      this.b.a(null, paramInt1, paramInt2);
      this.b.a(paramInt1, paramInt2);
      this.b.s();
      this.h = true;
    }
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    if ((this.b == null) || (this.g == null) || (!this.g.isAlive())) {}
    do
    {
      return;
      if (this.g != null)
      {
        this.c = paramObject;
        this.g.a(paramObject);
      }
    } while (this.b == null);
    this.b.a(null, null);
    this.b.a(null, paramInt1, paramInt2);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b != null) {
      return this.b.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public final void setZOrderMediaOverlay(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.pw
 * JD-Core Version:    0.7.0.1
 */