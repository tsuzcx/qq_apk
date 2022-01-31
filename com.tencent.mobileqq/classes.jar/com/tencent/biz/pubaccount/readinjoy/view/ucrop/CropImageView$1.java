package com.tencent.biz.pubaccount.readinjoy.view.ucrop;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import bame;
import baul;
import java.io.File;
import shq;
import sht;
import xmn;

class CropImageView$1
  implements Runnable
{
  CropImageView$1(CropImageView paramCropImageView, Bitmap paramBitmap, sht paramsht, Bitmap.CompressFormat paramCompressFormat, int paramInt, shq paramshq) {}
  
  public void run()
  {
    boolean bool = true;
    Bitmap localBitmap = xmn.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Sht.a(), this.jdField_a_of_type_Sht.b(), this.jdField_a_of_type_Sht.a());
    int i;
    String str;
    if (localBitmap != null)
    {
      i = 1;
      str = baul.a + File.separator + bame.c(new StringBuilder().append("CropImageView").append(System.currentTimeMillis()).toString());
      if ((i == 0) || (!xmn.a(localBitmap, this.jdField_a_of_type_AndroidGraphicsBitmap$CompressFormat, this.jdField_a_of_type_Int, str))) {
        break label144;
      }
    }
    for (;;)
    {
      CropImageView.a(this.this$0, str, bool, this.jdField_a_of_type_Shq);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ucrop.CropImageView.1
 * JD-Core Version:    0.7.0.1
 */