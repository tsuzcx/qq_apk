package com.tencent.luggage.wxa.fy;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.lp.e;
import com.tencent.luggage.wxa.lp.i;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;

public abstract class d<TextureImageViewLike extends View,  extends h>
  implements i<TextureImageViewLike>
{
  private static e b = new d.1();
  private static Handler c = null;
  protected final String a;
  private SparseArray<TextureView.SurfaceTextureListener> d;
  private SparseArray<Pair<Surface, SurfaceTexture>> e;
  private boolean f;
  
  public d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MicroMsg.AppBrand.AbsXWebVideoContainerChannel#");
    localStringBuilder.append(hashCode());
    this.a = localStringBuilder.toString();
    this.d = new SparseArray();
    this.e = new SparseArray();
    this.f = false;
  }
  
  @MainThread
  private static Handler b()
  {
    if (c == null) {
      c = new Handler(Looper.getMainLooper());
    }
    return c;
  }
  
  private void b(@NonNull Runnable paramRunnable, @NonNull SurfaceTexture paramSurfaceTexture)
  {
    o.d(this.a, "scheduleAfterTransferToTask");
    paramSurfaceTexture = q.a(paramSurfaceTexture);
    com.tencent.luggage.wxa.sj.d locald = f.a.a(paramRunnable, 300L);
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.a(new d.2(this, locald, paramRunnable, paramSurfaceTexture), b());
    }
  }
  
  protected abstract d.a a(@NonNull TextureImageViewLike paramTextureImageViewLike, @Nullable Runnable paramRunnable);
  
  @NonNull
  public e a()
  {
    return b;
  }
  
  public void a(@NonNull TextureImageViewLike paramTextureImageViewLike)
  {
    o.e(this.a, "recycleVideoContainerView");
    int i = paramTextureImageViewLike.hashCode();
    this.d.remove(i);
    ((h)paramTextureImageViewLike).setSurfaceTextureListener(null);
  }
  
  protected void a(@NonNull Runnable paramRunnable, @NonNull SurfaceTexture paramSurfaceTexture)
  {
    o.d(this.a, "scheduleAfterTransferFromTask");
    paramSurfaceTexture = q.a(paramSurfaceTexture);
    if (paramSurfaceTexture != null)
    {
      o.d(this.a, "scheduleAfterTransferFromTask, schedule afterTransferFromTask fallback");
      paramSurfaceTexture.a(new d.4(this, new d.3(this, f.a.a(paramRunnable, 600L), paramRunnable), paramSurfaceTexture), b());
      return;
    }
    o.d(this.a, "scheduleAfterTransferFromTask, schedule afterTransferFromTask fallback when surfaceTextureWrapper is null");
    f.a.a(paramRunnable, 50L);
  }
  
  public void b(@NonNull TextureImageViewLike paramTextureImageViewLike)
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPlayEndWorkaround, textureImageViewLike: ");
    localStringBuilder.append(paramTextureImageViewLike);
    o.d((String)localObject, localStringBuilder.toString());
    if (!this.f) {
      o.d(this.a, "onPlayEndWorkaround, video is not in pip container");
    }
    paramTextureImageViewLike = (h)paramTextureImageViewLike;
    localObject = paramTextureImageViewLike.getBitmap();
    if (localObject == null)
    {
      o.c(this.a, "onPlayEndWorkaround, bitmap is null");
      return;
    }
    paramTextureImageViewLike.setImageBitmap((Bitmap)localObject);
  }
  
  public void b(@NonNull TextureImageViewLike paramTextureImageViewLike, @Nullable Runnable paramRunnable)
  {
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("transferTo, textureImageViewLike: ");
    ((StringBuilder)localObject2).append(paramTextureImageViewLike);
    o.d((String)localObject1, ((StringBuilder)localObject2).toString());
    this.f = true;
    localObject1 = (h)paramTextureImageViewLike;
    ((h)localObject1).setImageBitmap(null);
    int i = paramTextureImageViewLike.hashCode();
    localObject2 = (TextureView.SurfaceTextureListener)this.d.get(i);
    if (localObject2 != null)
    {
      o.c(this.a, "transferTo, surfaceTextureListener is not null");
      localObject1 = ((h)localObject1).getSurfaceTexture();
      if (localObject1 != null) {
        ((TextureView.SurfaceTextureListener)localObject2).onSurfaceTextureSizeChanged((SurfaceTexture)localObject1, paramTextureImageViewLike.getWidth(), paramTextureImageViewLike.getHeight());
      }
      if (paramRunnable != null)
      {
        o.d(this.a, "transferTo, run afterTransferToTask when surfaceTextureListener is not null");
        paramRunnable.run();
      }
      return;
    }
    paramTextureImageViewLike = a(paramTextureImageViewLike, paramRunnable);
    o.e(this.a, "transferTo, setSurfaceTextureListener");
    ((h)localObject1).setSurfaceTextureListener(paramTextureImageViewLike);
    this.d.put(i, paramTextureImageViewLike);
  }
  
  @CallSuper
  public void c(@NonNull TextureImageViewLike paramTextureImageViewLike, @Nullable Runnable paramRunnable)
  {
    this.f = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.d
 * JD-Core Version:    0.7.0.1
 */