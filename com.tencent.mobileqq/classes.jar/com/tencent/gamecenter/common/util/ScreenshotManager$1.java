package com.tencent.gamecenter.common.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;

class ScreenshotManager$1
  implements Runnable
{
  ScreenshotManager$1(ScreenshotManager paramScreenshotManager, String paramString, ScreenshotManager.ShotCallback paramShotCallback) {}
  
  public void run()
  {
    ScreenshotManager localScreenshotManager;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localScreenshotManager = this.this$0;
      if (ScreenshotManager.a(this.this$0) != null) {
        break label80;
      }
    }
    label80:
    for (Bitmap localBitmap = BitmapFactory.decodeFile(ScreenshotManager.b + this.jdField_a_of_type_JavaLangString);; localBitmap = ScreenshotManager.a(this.this$0))
    {
      ScreenshotManager.a(localScreenshotManager, localBitmap);
      if (this.jdField_a_of_type_ComTencentGamecenterCommonUtilScreenshotManager$ShotCallback != null) {
        this.jdField_a_of_type_ComTencentGamecenterCommonUtilScreenshotManager$ShotCallback.a(304, "load to mem");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.1
 * JD-Core Version:    0.7.0.1
 */