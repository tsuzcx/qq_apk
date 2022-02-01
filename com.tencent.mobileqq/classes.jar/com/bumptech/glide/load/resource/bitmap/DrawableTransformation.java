package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class DrawableTransformation
  implements Transformation<Drawable>
{
  private final Transformation<Bitmap> b;
  private final boolean c;
  
  public DrawableTransformation(Transformation<Bitmap> paramTransformation, boolean paramBoolean)
  {
    this.b = paramTransformation;
    this.c = paramBoolean;
  }
  
  private Resource<Drawable> a(Context paramContext, Resource<Bitmap> paramResource)
  {
    return LazyBitmapDrawableResource.a(paramContext.getResources(), paramResource);
  }
  
  public Transformation<BitmapDrawable> a()
  {
    return this;
  }
  
  @NonNull
  public Resource<Drawable> a(@NonNull Context paramContext, @NonNull Resource<Drawable> paramResource, int paramInt1, int paramInt2)
  {
    Object localObject2 = Glide.a(paramContext).a();
    Object localObject1 = (Drawable)paramResource.d();
    localObject2 = DrawableToBitmapConverter.a((BitmapPool)localObject2, (Drawable)localObject1, paramInt1, paramInt2);
    if (localObject2 == null)
    {
      if (!this.c) {
        return paramResource;
      }
      paramContext = new StringBuilder();
      paramContext.append("Unable to convert ");
      paramContext.append(localObject1);
      paramContext.append(" to a Bitmap");
      throw new IllegalArgumentException(paramContext.toString());
    }
    localObject1 = this.b.a(paramContext, (Resource)localObject2, paramInt1, paramInt2);
    if (localObject1.equals(localObject2))
    {
      ((Resource)localObject1).f();
      return paramResource;
    }
    return a(paramContext, (Resource)localObject1);
  }
  
  public void a(@NonNull MessageDigest paramMessageDigest)
  {
    this.b.a(paramMessageDigest);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof DrawableTransformation))
    {
      paramObject = (DrawableTransformation)paramObject;
      return this.b.equals(paramObject.b);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.DrawableTransformation
 * JD-Core Version:    0.7.0.1
 */