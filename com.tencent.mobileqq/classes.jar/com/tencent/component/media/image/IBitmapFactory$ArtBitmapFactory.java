package com.tencent.component.media.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.tencent.component.media.utils.ImageManagerLog;

public class IBitmapFactory$ArtBitmapFactory
  extends IBitmapFactory
{
  ByteArrayPool mByteArrayPool;
  IDecoder mDecoder;
  
  public IBitmapFactory$ArtBitmapFactory(ByteArrayPool paramByteArrayPool, IDecoder paramIDecoder)
  {
    this.mByteArrayPool = paramByteArrayPool;
    this.mDecoder = paramIDecoder;
  }
  
  @TargetApi(12)
  public BitmapReference createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      ImageManagerLog.w("BitmapFactory", "width height error " + paramInt1 + ", " + paramInt2);
      return null;
    }
    byte[] arrayOfByte = generate((short)paramInt1, (short)paramInt2, this.mByteArrayPool);
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inPreferredConfig = paramConfig;
    localObject = this.mDecoder.decodeImage(arrayOfByte, 0, sEmptyByteSize, (BitmapFactory.Options)localObject, paramInt1, paramInt2);
    if (localObject == null) {
      return BitmapReference.getBitmapReference(Bitmap.createBitmap(paramInt1, paramInt2, paramConfig));
    }
    if (paramConfig != Bitmap.Config.RGB_565)
    {
      ((BitmapReference)localObject).getBitmap().eraseColor(0);
      ((BitmapReference)localObject).getBitmap().setHasAlpha(true);
    }
    if ((((BitmapReference)localObject).getWidth() != paramInt1) || (((BitmapReference)localObject).getHeight() != paramInt2)) {
      return BitmapReference.getBitmapReference(Bitmap.createBitmap(paramInt1, paramInt2, paramConfig));
    }
    this.mByteArrayPool.release(arrayOfByte);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.image.IBitmapFactory.ArtBitmapFactory
 * JD-Core Version:    0.7.0.1
 */