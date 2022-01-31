package com.tencent.gamecenter.common.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import yfn;
import yfp;

public class ScreenshotManager$1
  implements Runnable
{
  public ScreenshotManager$1(yfn paramyfn, String paramString, yfp paramyfp) {}
  
  public void run()
  {
    yfn localyfn;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localyfn = this.this$0;
      if (yfn.a(this.this$0) != null) {
        break label80;
      }
    }
    label80:
    for (Bitmap localBitmap = BitmapFactory.decodeFile(yfn.b + this.jdField_a_of_type_JavaLangString);; localBitmap = yfn.a(this.this$0))
    {
      yfn.a(localyfn, localBitmap);
      if (this.jdField_a_of_type_Yfp != null) {
        this.jdField_a_of_type_Yfp.a(304, "load to mem");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.1
 * JD-Core Version:    0.7.0.1
 */