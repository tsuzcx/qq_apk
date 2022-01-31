package com.tencent.gamecenter.common.util;

import aahx;
import aahz;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;

public class ScreenshotManager$1
  implements Runnable
{
  public ScreenshotManager$1(aahx paramaahx, String paramString, aahz paramaahz) {}
  
  public void run()
  {
    aahx localaahx;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localaahx = this.this$0;
      if (aahx.a(this.this$0) != null) {
        break label80;
      }
    }
    label80:
    for (Bitmap localBitmap = BitmapFactory.decodeFile(aahx.b + this.jdField_a_of_type_JavaLangString);; localBitmap = aahx.a(this.this$0))
    {
      aahx.a(localaahx, localBitmap);
      if (this.jdField_a_of_type_Aahz != null) {
        this.jdField_a_of_type_Aahz.a(304, "load to mem");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.1
 * JD-Core Version:    0.7.0.1
 */