package com.tencent.gamecenter.common.util;

import acex;
import acez;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;

public class ScreenshotManager$1
  implements Runnable
{
  public ScreenshotManager$1(acex paramacex, String paramString, acez paramacez) {}
  
  public void run()
  {
    acex localacex;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localacex = this.this$0;
      if (acex.a(this.this$0) != null) {
        break label80;
      }
    }
    label80:
    for (Bitmap localBitmap = BitmapFactory.decodeFile(acex.b + this.jdField_a_of_type_JavaLangString);; localBitmap = acex.a(this.this$0))
    {
      acex.a(localacex, localBitmap);
      if (this.jdField_a_of_type_Acez != null) {
        this.jdField_a_of_type_Acez.a(304, "load to mem");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.1
 * JD-Core Version:    0.7.0.1
 */