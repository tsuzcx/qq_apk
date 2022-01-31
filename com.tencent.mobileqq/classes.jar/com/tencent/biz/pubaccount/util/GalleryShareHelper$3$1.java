package com.tencent.biz.pubaccount.util;

import android.graphics.Bitmap;
import java.util.Map;
import svl;

class GalleryShareHelper$3$1
  implements Runnable
{
  GalleryShareHelper$3$1(GalleryShareHelper.3 param3) {}
  
  public void run()
  {
    Bitmap localBitmap = (Bitmap)this.a.jdField_a_of_type_JavaUtilMap.remove("image");
    this.a.this$0.a(svl.b(this.a.this$0), svl.c(this.a.this$0), svl.a(this.a.this$0), localBitmap, this.a.jdField_a_of_type_Boolean, this.a.jdField_a_of_type_Syx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.GalleryShareHelper.3.1
 * JD-Core Version:    0.7.0.1
 */