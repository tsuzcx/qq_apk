package com.tencent.component.media.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.tencent.component.media.utils.ImageManagerLog;

public class IBitmapFactory$DalvikBitmapFactory
  extends IBitmapFactory
{
  ByteArrayPool jdField_a_of_type_ComTencentComponentMediaImageByteArrayPool;
  IDecoder jdField_a_of_type_ComTencentComponentMediaImageIDecoder;
  
  IBitmapFactory$DalvikBitmapFactory(ByteArrayPool paramByteArrayPool, IDecoder paramIDecoder)
  {
    this.jdField_a_of_type_ComTencentComponentMediaImageByteArrayPool = paramByteArrayPool;
    this.jdField_a_of_type_ComTencentComponentMediaImageIDecoder = paramIDecoder;
  }
  
  @TargetApi(12)
  public BitmapReference createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {}
    for (;;)
    {
      try
      {
        ImageManagerLog.w("BitmapFactory", "width height error " + paramInt1 + ", " + paramInt2);
        paramConfig = null;
        return paramConfig;
      }
      finally {}
      short s1 = (short)paramInt1;
      short s2 = (short)paramInt2;
      byte[] arrayOfByte = a(s1, s2, this.jdField_a_of_type_ComTencentComponentMediaImageByteArrayPool);
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
      localObject = this.jdField_a_of_type_ComTencentComponentMediaImageIDecoder.decodeImage(arrayOfByte, 0, jdField_a_of_type_Int, (BitmapFactory.Options)localObject, -1, -1);
      if (localObject == null)
      {
        paramConfig = BitmapReference.getBitmapReference(Bitmap.createBitmap(paramInt1, paramInt2, paramConfig));
      }
      else
      {
        ((BitmapReference)localObject).getBitmap().eraseColor(0);
        ((BitmapReference)localObject).getBitmap().setHasAlpha(true);
        if ((((BitmapReference)localObject).getWidth() != paramInt1) || (((BitmapReference)localObject).getHeight() != paramInt2))
        {
          paramConfig = BitmapReference.getBitmapReference(Bitmap.createBitmap(paramInt1, paramInt2, paramConfig));
        }
        else
        {
          this.jdField_a_of_type_ComTencentComponentMediaImageByteArrayPool.release(arrayOfByte);
          paramConfig = (Bitmap.Config)localObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.IBitmapFactory.DalvikBitmapFactory
 * JD-Core Version:    0.7.0.1
 */