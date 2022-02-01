package com.tencent.gamecenter.common.util;

import abuv;
import abux;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;

public class ScreenshotManager$1
  implements Runnable
{
  public ScreenshotManager$1(abuv paramabuv, String paramString, abux paramabux) {}
  
  public void run()
  {
    abuv localabuv;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localabuv = this.this$0;
      if (abuv.a(this.this$0) != null) {
        break label80;
      }
    }
    label80:
    for (Bitmap localBitmap = BitmapFactory.decodeFile(abuv.b + this.jdField_a_of_type_JavaLangString);; localBitmap = abuv.a(this.this$0))
    {
      abuv.a(localabuv, localBitmap);
      if (this.jdField_a_of_type_Abux != null) {
        this.jdField_a_of_type_Abux.a(304, "load to mem");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.1
 * JD-Core Version:    0.7.0.1
 */