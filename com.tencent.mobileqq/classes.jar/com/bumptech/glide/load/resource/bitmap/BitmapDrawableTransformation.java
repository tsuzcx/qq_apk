package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

@Deprecated
public class BitmapDrawableTransformation
  implements Transformation<BitmapDrawable>
{
  private final Transformation<Drawable> b;
  
  private static Resource<BitmapDrawable> a(Resource<Drawable> paramResource)
  {
    if ((paramResource.d() instanceof BitmapDrawable)) {
      return paramResource;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: ");
    localStringBuilder.append(paramResource.d());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static Resource<Drawable> b(Resource<BitmapDrawable> paramResource)
  {
    return paramResource;
  }
  
  @NonNull
  public Resource<BitmapDrawable> a(@NonNull Context paramContext, @NonNull Resource<BitmapDrawable> paramResource, int paramInt1, int paramInt2)
  {
    paramResource = b(paramResource);
    return a(this.b.a(paramContext, paramResource, paramInt1, paramInt2));
  }
  
  public void a(@NonNull MessageDigest paramMessageDigest)
  {
    this.b.a(paramMessageDigest);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof BitmapDrawableTransformation))
    {
      paramObject = (BitmapDrawableTransformation)paramObject;
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
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.BitmapDrawableTransformation
 * JD-Core Version:    0.7.0.1
 */