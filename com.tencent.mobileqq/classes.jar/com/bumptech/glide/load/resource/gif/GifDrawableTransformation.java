package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public class GifDrawableTransformation
  implements Transformation<GifDrawable>
{
  private final Transformation<Bitmap> b;
  
  public GifDrawableTransformation(Transformation<Bitmap> paramTransformation)
  {
    this.b = ((Transformation)Preconditions.a(paramTransformation));
  }
  
  @NonNull
  public Resource<GifDrawable> a(@NonNull Context paramContext, @NonNull Resource<GifDrawable> paramResource, int paramInt1, int paramInt2)
  {
    GifDrawable localGifDrawable = (GifDrawable)paramResource.d();
    Object localObject = Glide.a(paramContext).a();
    localObject = new BitmapResource(localGifDrawable.b(), (BitmapPool)localObject);
    paramContext = this.b.a(paramContext, (Resource)localObject, paramInt1, paramInt2);
    if (!localObject.equals(paramContext)) {
      ((Resource)localObject).f();
    }
    paramContext = (Bitmap)paramContext.d();
    localGifDrawable.a(this.b, paramContext);
    return paramResource;
  }
  
  public void a(@NonNull MessageDigest paramMessageDigest)
  {
    this.b.a(paramMessageDigest);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof GifDrawableTransformation))
    {
      paramObject = (GifDrawableTransformation)paramObject;
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
 * Qualified Name:     com.bumptech.glide.load.resource.gif.GifDrawableTransformation
 * JD-Core Version:    0.7.0.1
 */