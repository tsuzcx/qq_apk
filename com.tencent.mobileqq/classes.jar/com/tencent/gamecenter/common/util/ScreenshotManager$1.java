package com.tencent.gamecenter.common.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import yor;
import yot;

public class ScreenshotManager$1
  implements Runnable
{
  public ScreenshotManager$1(yor paramyor, String paramString, yot paramyot) {}
  
  public void run()
  {
    yor localyor;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localyor = this.this$0;
      if (yor.a(this.this$0) != null) {
        break label80;
      }
    }
    label80:
    for (Bitmap localBitmap = BitmapFactory.decodeFile(yor.b + this.jdField_a_of_type_JavaLangString);; localBitmap = yor.a(this.this$0))
    {
      yor.a(localyor, localBitmap);
      if (this.jdField_a_of_type_Yot != null) {
        this.jdField_a_of_type_Yot.a(304, "load to mem");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.1
 * JD-Core Version:    0.7.0.1
 */