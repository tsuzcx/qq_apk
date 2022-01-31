package com.tencent.gamecenter.common.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import yoo;
import yoq;

public class ScreenshotManager$1
  implements Runnable
{
  public ScreenshotManager$1(yoo paramyoo, String paramString, yoq paramyoq) {}
  
  public void run()
  {
    yoo localyoo;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localyoo = this.this$0;
      if (yoo.a(this.this$0) != null) {
        break label80;
      }
    }
    label80:
    for (Bitmap localBitmap = BitmapFactory.decodeFile(yoo.b + this.jdField_a_of_type_JavaLangString);; localBitmap = yoo.a(this.this$0))
    {
      yoo.a(localyoo, localBitmap);
      if (this.jdField_a_of_type_Yoq != null) {
        this.jdField_a_of_type_Yoq.a(304, "load to mem");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.1
 * JD-Core Version:    0.7.0.1
 */