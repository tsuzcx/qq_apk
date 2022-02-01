package com.tencent.luggage.wxa.h;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.luggage.wxa.ad.j.a;
import com.tencent.luggage.wxa.ap.g;
import com.tencent.luggage.wxa.i.e;
import com.tencent.luggage.wxa.j.d;
import com.tencent.luggage.wxa.v.f.a;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

final class w$a
  implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, j.a, g, e, f.a
{
  private w$a(w paramw) {}
  
  public void a(int paramInt)
  {
    w.a(this.a, paramInt);
    if (w.d(this.a) != null) {
      w.d(this.a).a(paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
  {
    Iterator localIterator = w.b(this.a).iterator();
    while (localIterator.hasNext()) {
      ((w.b)localIterator.next()).a(paramInt1, paramInt2, paramInt3, paramFloat);
    }
    if (w.a(this.a) != null) {
      w.a(this.a).a(paramInt1, paramInt2, paramInt3, paramFloat);
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (w.a(this.a) != null) {
      w.a(this.a).a(paramInt, paramLong);
    }
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (w.d(this.a) != null) {
      w.d(this.a).a(paramInt, paramLong1, paramLong2);
    }
  }
  
  public void a(Surface paramSurface)
  {
    if (w.c(this.a) == paramSurface)
    {
      Iterator localIterator = w.b(this.a).iterator();
      while (localIterator.hasNext()) {
        ((w.b)localIterator.next()).a();
      }
    }
    if (w.a(this.a) != null) {
      w.a(this.a).a(paramSurface);
    }
  }
  
  public void a(k paramk)
  {
    w.a(this.a, paramk);
    if (w.a(this.a) != null) {
      w.a(this.a).a(paramk);
    }
  }
  
  public void a(d paramd)
  {
    w.a(this.a, paramd);
    if (w.a(this.a) != null) {
      w.a(this.a).a(paramd);
    }
  }
  
  public void a(com.tencent.luggage.wxa.v.a parama)
  {
    Iterator localIterator = w.f(this.a).iterator();
    while (localIterator.hasNext()) {
      ((f.a)localIterator.next()).a(parama);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (w.a(this.a) != null) {
      w.a(this.a).a(paramString, paramLong1, paramLong2);
    }
  }
  
  public void a(List<com.tencent.luggage.wxa.ad.a> paramList)
  {
    Iterator localIterator = w.e(this.a).iterator();
    while (localIterator.hasNext()) {
      ((j.a)localIterator.next()).a(paramList);
    }
  }
  
  public void b(k paramk)
  {
    w.b(this.a, paramk);
    if (w.d(this.a) != null) {
      w.d(this.a).b(paramk);
    }
  }
  
  public void b(d paramd)
  {
    if (w.a(this.a) != null) {
      w.a(this.a).b(paramd);
    }
    w.a(this.a, null);
    w.a(this.a, null);
  }
  
  public void b(String paramString, long paramLong1, long paramLong2)
  {
    if (w.d(this.a) != null) {
      w.d(this.a).b(paramString, paramLong1, paramLong2);
    }
  }
  
  public void c(d paramd)
  {
    w.b(this.a, paramd);
    if (w.d(this.a) != null) {
      w.d(this.a).c(paramd);
    }
  }
  
  public void d(d paramd)
  {
    if (w.d(this.a) != null) {
      w.d(this.a).d(paramd);
    }
    w.b(this.a, null);
    w.b(this.a, null);
    w.a(this.a, 0);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    w.a(this.a, new Surface(paramSurfaceTexture), true);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    w.a(this.a, null, true);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    w.a(this.a, paramSurfaceHolder.getSurface(), false);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    w.a(this.a, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.h.w.a
 * JD-Core Version:    0.7.0.1
 */