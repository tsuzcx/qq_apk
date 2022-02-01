package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public class BitmapDrawableDecoder<DataType>
  implements ResourceDecoder<DataType, BitmapDrawable>
{
  private final ResourceDecoder<DataType, Bitmap> a;
  private final Resources b;
  
  public BitmapDrawableDecoder(@NonNull Resources paramResources, @NonNull ResourceDecoder<DataType, Bitmap> paramResourceDecoder)
  {
    this.b = ((Resources)Preconditions.a(paramResources));
    this.a = ((ResourceDecoder)Preconditions.a(paramResourceDecoder));
  }
  
  public Resource<BitmapDrawable> a(@NonNull DataType paramDataType, int paramInt1, int paramInt2, @NonNull Options paramOptions)
  {
    paramDataType = this.a.a(paramDataType, paramInt1, paramInt2, paramOptions);
    return LazyBitmapDrawableResource.a(this.b, paramDataType);
  }
  
  public boolean a(@NonNull DataType paramDataType, @NonNull Options paramOptions)
  {
    return this.a.a(paramDataType, paramOptions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder
 * JD-Core Version:    0.7.0.1
 */