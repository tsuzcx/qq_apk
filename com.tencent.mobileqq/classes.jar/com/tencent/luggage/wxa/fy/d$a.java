package com.tencent.luggage.wxa.fy;

import android.graphics.SurfaceTexture;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.o;

public abstract class d$a<TextureImageViewLike>
  implements TextureView.SurfaceTextureListener
{
  @NonNull
  protected final TextureImageViewLike a;
  private final int c;
  @Nullable
  private volatile Runnable d;
  
  protected d$a(TextureImageViewLike paramTextureImageViewLike, @NonNull Runnable paramRunnable)
  {
    this.a = paramRunnable;
    this.c = paramRunnable.hashCode();
    Object localObject;
    this.d = localObject;
  }
  
  private void a(@NonNull SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Object localObject = (Pair)d.b(this.b).get(this.c);
    if ((localObject != null) && (((Pair)localObject).second == paramSurfaceTexture))
    {
      Surface localSurface = (Surface)((Pair)localObject).first;
      paramSurfaceTexture = (SurfaceTexture)localObject;
      localObject = localSurface;
    }
    else
    {
      localObject = new Surface(paramSurfaceTexture);
      paramSurfaceTexture = Pair.create(localObject, paramSurfaceTexture);
    }
    if (a((Surface)localObject, paramInt1, paramInt2)) {
      d.b(this.b).put(this.c, paramSurfaceTexture);
    }
  }
  
  protected abstract void a();
  
  protected abstract boolean a(@NonNull Surface paramSurface, int paramInt1, int paramInt2);
  
  public void onSurfaceTextureAvailable(@NonNull SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Object localObject = this.b.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(" onSurfaceTextureAvailable, surfaceTexture: %s, width: %d, height: %d");
    o.e((String)localObject, localStringBuilder.toString(), new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    a(paramSurfaceTexture, paramInt1, paramInt2);
    localObject = this.d;
    this.d = null;
    if (localObject != null) {
      d.a(this.b, (Runnable)localObject, paramSurfaceTexture);
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    String str = this.b.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(" onSurfaceTextureDestroyed, surfaceTexture: ");
    localStringBuilder.append(paramSurfaceTexture);
    o.e(str, localStringBuilder.toString());
    a();
    paramSurfaceTexture = (Pair)d.b(this.b).get(this.c);
    if (paramSurfaceTexture == null) {
      return true;
    }
    d.b(this.b).remove(this.c);
    ((Surface)paramSurfaceTexture.first).release();
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (!d.a(this.b))
    {
      o.c(this.b.a, "onSurfaceTextureSizeChanged, video is not in pip container");
      return;
    }
    a(paramSurfaceTexture, paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.d.a
 * JD-Core Version:    0.7.0.1
 */