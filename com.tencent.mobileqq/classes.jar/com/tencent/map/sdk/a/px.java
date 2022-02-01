package com.tencent.map.sdk.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.map.sdk.basemap.interfaces.IMapRenderView;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

@TargetApi(14)
public final class px
  extends TextureView
  implements TextureView.SurfaceTextureListener, IMapRenderView
{
  private pn a;
  private Object b;
  private pl c;
  
  public px(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext);
    this.a = new pn(this, getContext().getApplicationContext(), paramTencentMapOptions);
    setSurfaceTextureListener(this);
  }
  
  public final boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && (this.a.a(paramMotionEvent))) {
      return true;
    }
    return super.dispatchHoverEvent(paramMotionEvent);
  }
  
  public final lf getVectorMapDelegate()
  {
    return this.a;
  }
  
  public final void onDestroy()
  {
    if (this.a != null) {
      this.a.onDestroy();
    }
    if (this.c != null) {
      this.c.c();
    }
  }
  
  public final void onPause()
  {
    if (this.a != null) {
      this.a.onPause();
    }
    if (this.c != null) {
      this.c.a();
    }
  }
  
  public final void onRedraw()
  {
    if (this.c != null) {
      synchronized (this.c)
      {
        this.c.notify();
        return;
      }
    }
  }
  
  public final void onResume()
  {
    if (this.a != null) {
      this.a.onResume();
    }
    if (this.c != null) {
      this.c.b();
    }
  }
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null) {
      this.a.a(paramInt1, paramInt2);
    }
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    if (this.b == null) {
      this.b = paramObject;
    }
    for (;;)
    {
      if (this.a != null)
      {
        this.a.a(null, null);
        this.a.a(null, paramInt1, paramInt2);
      }
      if (this.c == null)
      {
        this.c = new pl(paramObject, this.a);
        this.c.start();
      }
      return;
      if (this.c != null)
      {
        this.b = paramObject;
        this.c.a(paramObject);
      }
    }
  }
  
  @TargetApi(16)
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    onSurfaceChanged(paramSurfaceTexture, paramInt1, paramInt2);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    return true;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.a != null)
    {
      this.a.a(null, paramInt1, paramInt2);
      if (this.c != null) {
        this.c.d();
      }
    }
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null) {
      return this.a.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public final void setZOrderMediaOverlay(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.px
 * JD-Core Version:    0.7.0.1
 */