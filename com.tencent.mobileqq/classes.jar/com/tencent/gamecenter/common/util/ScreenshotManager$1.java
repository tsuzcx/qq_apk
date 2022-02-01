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
    if (!TextUtils.isEmpty(this.a))
    {
      ScreenshotManager localScreenshotManager = this.this$0;
      if (ScreenshotManager.a(localScreenshotManager) == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(ScreenshotManager.b);
        ((StringBuilder)localObject).append(this.a);
        localObject = BitmapFactory.decodeFile(((StringBuilder)localObject).toString());
      }
      else
      {
        localObject = ScreenshotManager.a(this.this$0);
      }
      ScreenshotManager.a(localScreenshotManager, (Bitmap)localObject);
      Object localObject = this.b;
      if (localObject != null) {
        ((ScreenshotManager.ShotCallback)localObject).a(304, "load to mem");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ScreenshotManager.1
 * JD-Core Version:    0.7.0.1
 */