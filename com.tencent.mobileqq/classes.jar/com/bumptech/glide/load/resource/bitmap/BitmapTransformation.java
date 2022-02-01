package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

public abstract class BitmapTransformation
  implements Transformation<Bitmap>
{
  protected abstract Bitmap a(@NonNull BitmapPool paramBitmapPool, @NonNull Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  @NonNull
  public final Resource<Bitmap> a(@NonNull Context paramContext, @NonNull Resource<Bitmap> paramResource, int paramInt1, int paramInt2)
  {
    if (Util.a(paramInt1, paramInt2))
    {
      paramContext = Glide.a(paramContext).a();
      Bitmap localBitmap1 = (Bitmap)paramResource.d();
      int i = paramInt1;
      if (paramInt1 == -2147483648) {
        i = localBitmap1.getWidth();
      }
      paramInt1 = paramInt2;
      if (paramInt2 == -2147483648) {
        paramInt1 = localBitmap1.getHeight();
      }
      Bitmap localBitmap2 = a(paramContext, localBitmap1, i, paramInt1);
      if (localBitmap1.equals(localBitmap2)) {
        return paramResource;
      }
      return BitmapResource.a(localBitmap2, paramContext);
    }
    paramContext = new StringBuilder();
    paramContext.append("Cannot apply transformation on width: ");
    paramContext.append(paramInt1);
    paramContext.append(" or height: ");
    paramContext.append(paramInt2);
    paramContext.append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
    throw new IllegalArgumentException(paramContext.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.BitmapTransformation
 * JD-Core Version:    0.7.0.1
 */