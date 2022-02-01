package com.etrump.mixlayout;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.DisplayMetrics;

class ETTextView$BitmapLocker
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  
  private ETTextView$BitmapLocker(ETTextView paramETTextView) {}
  
  private void a(int paramInt1, int paramInt2)
  {
    try
    {
      int j = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.mFont.getSize() * 4;
      int i = paramInt2;
      if (paramInt2 < j) {
        i = j;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && ((this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() < i) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() < paramInt1) || (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() > j + i)))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt1, i, Bitmap.Config.ARGB_8888);
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.setDensity(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getResources().getDisplayMetrics().densityDpi);
      }
      return;
    }
    finally {}
  }
  
  Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextView.BitmapLocker
 * JD-Core Version:    0.7.0.1
 */