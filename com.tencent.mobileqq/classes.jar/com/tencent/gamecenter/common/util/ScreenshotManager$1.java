package com.tencent.gamecenter.common.util;

import aciy;
import acja;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;

public class ScreenshotManager$1
  implements Runnable
{
  public ScreenshotManager$1(aciy paramaciy, String paramString, acja paramacja) {}
  
  public void run()
  {
    aciy localaciy;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localaciy = this.this$0;
      if (aciy.a(this.this$0) != null) {
        break label80;
      }
    }
    label80:
    for (Bitmap localBitmap = BitmapFactory.decodeFile(aciy.b + this.jdField_a_of_type_JavaLangString);; localBitmap = aciy.a(this.this$0))
    {
      aciy.a(localaciy, localBitmap);
      if (this.jdField_a_of_type_Acja != null) {
        this.jdField_a_of_type_Acja.a(304, "load to mem");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.1
 * JD-Core Version:    0.7.0.1
 */