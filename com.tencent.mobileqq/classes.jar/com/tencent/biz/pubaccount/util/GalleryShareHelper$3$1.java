package com.tencent.biz.pubaccount.util;

import android.graphics.Bitmap;
import java.util.Map;
import sdv;

class GalleryShareHelper$3$1
  implements Runnable
{
  GalleryShareHelper$3$1(GalleryShareHelper.3 param3) {}
  
  public void run()
  {
    Bitmap localBitmap = (Bitmap)this.a.jdField_a_of_type_JavaUtilMap.remove("image");
    this.a.this$0.a(sdv.b(this.a.this$0), sdv.c(this.a.this$0), sdv.a(this.a.this$0), localBitmap, this.a.jdField_a_of_type_Boolean, this.a.jdField_a_of_type_Shf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.GalleryShareHelper.3.1
 * JD-Core Version:    0.7.0.1
 */