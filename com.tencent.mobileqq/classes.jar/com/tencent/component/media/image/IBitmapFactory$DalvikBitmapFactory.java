package com.tencent.component.media.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.tencent.component.media.utils.ImageManagerLog;

public class IBitmapFactory$DalvikBitmapFactory
  extends IBitmapFactory
{
  ByteArrayPool mByteArrayPool;
  IDecoder mDecoder;
  
  IBitmapFactory$DalvikBitmapFactory(ByteArrayPool paramByteArrayPool, IDecoder paramIDecoder)
  {
    this.mByteArrayPool = paramByteArrayPool;
    this.mDecoder = paramIDecoder;
  }
  
  @TargetApi(12)
  public BitmapReference createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    short s1;
    short s2;
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      s1 = (short)paramInt1;
      s2 = (short)paramInt2;
    }
    try
    {
      byte[] arrayOfByte = generate(s1, s2, this.mByteArrayPool);
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
      localObject = this.mDecoder.decodeImage(arrayOfByte, 0, sEmptyByteSize, (BitmapFactory.Options)localObject, -1, -1);
      if (localObject == null)
      {
        paramConfig = BitmapReference.getBitmapReference(Bitmap.createBitmap(paramInt1, paramInt2, paramConfig));
        return paramConfig;
      }
      ((BitmapReference)localObject).getBitmap().eraseColor(0);
      ((BitmapReference)localObject).getBitmap().setHasAlpha(true);
      if ((((BitmapReference)localObject).getWidth() == paramInt1) && (((BitmapReference)localObject).getHeight() == paramInt2))
      {
        this.mByteArrayPool.release(arrayOfByte);
        return localObject;
      }
      paramConfig = BitmapReference.getBitmapReference(Bitmap.createBitmap(paramInt1, paramInt2, paramConfig));
      return paramConfig;
    }
    finally {}
    paramConfig = new StringBuilder();
    paramConfig.append("width height error ");
    paramConfig.append(paramInt1);
    paramConfig.append(", ");
    paramConfig.append(paramInt2);
    ImageManagerLog.w("BitmapFactory", paramConfig.toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.IBitmapFactory.DalvikBitmapFactory
 * JD-Core Version:    0.7.0.1
 */