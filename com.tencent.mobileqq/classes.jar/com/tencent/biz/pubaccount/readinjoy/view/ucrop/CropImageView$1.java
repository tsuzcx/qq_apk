package com.tencent.biz.pubaccount.readinjoy.view.ucrop;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.io.File;
import toj;
import tom;
import zdr;

class CropImageView$1
  implements Runnable
{
  CropImageView$1(CropImageView paramCropImageView, Bitmap paramBitmap, tom paramtom, Bitmap.CompressFormat paramCompressFormat, int paramInt, toj paramtoj) {}
  
  public void run()
  {
    boolean bool = true;
    Bitmap localBitmap = zdr.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Tom.a(), this.jdField_a_of_type_Tom.b(), this.jdField_a_of_type_Tom.a());
    int i;
    String str;
    if (localBitmap != null)
    {
      i = 1;
      str = URLDrawableHelper.diskCachePath + File.separator + AbsDownloader.getFileName(new StringBuilder().append("CropImageView").append(System.currentTimeMillis()).toString());
      if ((i == 0) || (!zdr.a(localBitmap, this.jdField_a_of_type_AndroidGraphicsBitmap$CompressFormat, this.jdField_a_of_type_Int, str))) {
        break label144;
      }
    }
    for (;;)
    {
      CropImageView.a(this.this$0, str, bool, this.jdField_a_of_type_Toj);
      if ((localBitmap != null) && (!localBitmap.isRecycled())) {
        localBitmap.recycle();
      }
      return;
      i = 0;
      break;
      label144:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ucrop.CropImageView.1
 * JD-Core Version:    0.7.0.1
 */