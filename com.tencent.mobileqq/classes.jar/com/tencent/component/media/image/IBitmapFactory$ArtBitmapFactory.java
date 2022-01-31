package com.tencent.component.media.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.tencent.component.media.utils.ImageManagerLog;

public class IBitmapFactory$ArtBitmapFactory
  extends IBitmapFactory
{
  ByteArrayPool jdField_a_of_type_ComTencentComponentMediaImageByteArrayPool;
  IDecoder jdField_a_of_type_ComTencentComponentMediaImageIDecoder;
  
  public IBitmapFactory$ArtBitmapFactory(ByteArrayPool paramByteArrayPool, IDecoder paramIDecoder)
  {
    this.jdField_a_of_type_ComTencentComponentMediaImageByteArrayPool = paramByteArrayPool;
    this.jdField_a_of_type_ComTencentComponentMediaImageIDecoder = paramIDecoder;
  }
  
  @TargetApi(12)
  public BitmapReference createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      ImageManagerLog.w("BitmapFactory", "width height error " + paramInt1 + ", " + paramInt2);
      return null;
    }
    byte[] arrayOfByte = a((short)paramInt1, (short)paramInt2, this.jdField_a_of_type_ComTencentComponentMediaImageByteArrayPool);
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inPreferredConfig = paramConfig;
    localObject = this.jdField_a_of_type_ComTencentComponentMediaImageIDecoder.decodeImage(arrayOfByte, 0, jdField_a_of_type_Int, (BitmapFactory.Options)localObject, paramInt1, paramInt2);
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
    this.jdField_a_of_type_ComTencentComponentMediaImageByteArrayPool.release(arrayOfByte);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.IBitmapFactory.ArtBitmapFactory
 * JD-Core Version:    0.7.0.1
 */