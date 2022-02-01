package com.tencent.biz.pubaccount.readinjoy.view.ucrop;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import beqz;
import beyq;
import java.io.File;
import sxb;
import sxe;
import zoc;

class CropImageView$1
  implements Runnable
{
  CropImageView$1(CropImageView paramCropImageView, Bitmap paramBitmap, sxe paramsxe, Bitmap.CompressFormat paramCompressFormat, int paramInt, sxb paramsxb) {}
  
  public void run()
  {
    boolean bool = true;
    Bitmap localBitmap = zoc.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Sxe.a(), this.jdField_a_of_type_Sxe.b(), this.jdField_a_of_type_Sxe.a());
    int i;
    String str;
    if (localBitmap != null)
    {
      i = 1;
      str = beyq.a + File.separator + beqz.c(new StringBuilder().append("CropImageView").append(System.currentTimeMillis()).toString());
      if ((i == 0) || (!zoc.a(localBitmap, this.jdField_a_of_type_AndroidGraphicsBitmap$CompressFormat, this.jdField_a_of_type_Int, str))) {
        break label144;
      }
    }
    for (;;)
    {
      CropImageView.a(this.this$0, str, bool, this.jdField_a_of_type_Sxb);
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