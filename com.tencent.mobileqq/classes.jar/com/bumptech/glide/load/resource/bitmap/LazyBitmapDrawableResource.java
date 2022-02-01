package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public final class LazyBitmapDrawableResource
  implements Initializable, Resource<BitmapDrawable>
{
  private final Resources a;
  private final Resource<Bitmap> b;
  
  private LazyBitmapDrawableResource(@NonNull Resources paramResources, @NonNull Resource<Bitmap> paramResource)
  {
    this.a = ((Resources)Preconditions.a(paramResources));
    this.b = ((Resource)Preconditions.a(paramResource));
  }
  
  @Nullable
  public static Resource<BitmapDrawable> a(@NonNull Resources paramResources, @Nullable Resource<Bitmap> paramResource)
  {
    if (paramResource == null) {
      return null;
    }
    return new LazyBitmapDrawableResource(paramResources, paramResource);
  }
  
  public void a()
  {
    Resource localResource = this.b;
    if ((localResource instanceof Initializable)) {
      ((Initializable)localResource).a();
    }
  }
  
  @NonNull
  public BitmapDrawable b()
  {
    return new BitmapDrawable(this.a, (Bitmap)this.b.d());
  }
  
  @NonNull
  public Class<BitmapDrawable> c()
  {
    return BitmapDrawable.class;
  }
  
  public int e()
  {
    return this.b.e();
  }
  
  public void f()
  {
    this.b.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource
 * JD-Core Version:    0.7.0.1
 */