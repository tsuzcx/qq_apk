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
  
  protected final boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    pn localpn = this.a;
    if ((localpn != null) && (localpn.a(paramMotionEvent))) {
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
    Object localObject = this.a;
    if (localObject != null) {
      ((pn)localObject).onDestroy();
    }
    localObject = this.c;
    if (localObject != null) {
      ((pl)localObject).c();
    }
  }
  
  public final void onPause()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((pn)localObject).onPause();
    }
    localObject = this.c;
    if (localObject != null) {
      ((pl)localObject).a();
    }
  }
  
  public final void onRedraw()
  {
    pl localpl = this.c;
    if (localpl != null) {
      try
      {
        this.c.notify();
        return;
      }
      finally {}
    }
  }
  
  public final void onResume()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((pn)localObject).onResume();
    }
    localObject = this.c;
    if (localObject != null) {
      ((pl)localObject).b();
    }
  }
  
  public final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    pn localpn = this.a;
    if (localpn != null) {
      localpn.a(paramInt1, paramInt2);
    }
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    if (this.b == null)
    {
      this.b = paramObject;
    }
    else
    {
      localObject = this.c;
      if (localObject != null)
      {
        this.b = paramObject;
        ((pl)localObject).a(paramObject);
      }
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      ((pn)localObject).a(null, null);
      this.a.a(null, paramInt1, paramInt2);
    }
    if (this.c == null)
    {
      this.c = new pl(paramObject, this.a);
      this.c.start();
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
    paramSurfaceTexture = this.a;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.a(null, paramInt1, paramInt2);
      paramSurfaceTexture = this.c;
      if (paramSurfaceTexture != null) {
        paramSurfaceTexture.d();
      }
    }
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    pn localpn = this.a;
    if (localpn != null) {
      return localpn.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public final void setZOrderMediaOverlay(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.px
 * JD-Core Version:    0.7.0.1
 */