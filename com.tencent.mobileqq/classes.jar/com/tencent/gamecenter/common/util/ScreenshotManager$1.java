package com.tencent.gamecenter.common.util;

import abfg;
import abfi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;

public class ScreenshotManager$1
  implements Runnable
{
  public ScreenshotManager$1(abfg paramabfg, String paramString, abfi paramabfi) {}
  
  public void run()
  {
    abfg localabfg;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localabfg = this.this$0;
      if (abfg.a(this.this$0) != null) {
        break label80;
      }
    }
    label80:
    for (Bitmap localBitmap = BitmapFactory.decodeFile(abfg.b + this.jdField_a_of_type_JavaLangString);; localBitmap = abfg.a(this.this$0))
    {
      abfg.a(localabfg, localBitmap);
      if (this.jdField_a_of_type_Abfi != null) {
        this.jdField_a_of_type_Abfi.a(304, "load to mem");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.1
 * JD-Core Version:    0.7.0.1
 */