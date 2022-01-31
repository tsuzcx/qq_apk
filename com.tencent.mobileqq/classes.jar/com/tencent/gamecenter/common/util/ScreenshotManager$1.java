package com.tencent.gamecenter.common.util;

import aadi;
import aadk;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;

public class ScreenshotManager$1
  implements Runnable
{
  public ScreenshotManager$1(aadi paramaadi, String paramString, aadk paramaadk) {}
  
  public void run()
  {
    aadi localaadi;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localaadi = this.this$0;
      if (aadi.a(this.this$0) != null) {
        break label80;
      }
    }
    label80:
    for (Bitmap localBitmap = BitmapFactory.decodeFile(aadi.b + this.jdField_a_of_type_JavaLangString);; localBitmap = aadi.a(this.this$0))
    {
      aadi.a(localaadi, localBitmap);
      if (this.jdField_a_of_type_Aadk != null) {
        this.jdField_a_of_type_Aadk.a(304, "load to mem");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.1
 * JD-Core Version:    0.7.0.1
 */