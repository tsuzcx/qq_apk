package com.dataline.activities;

import android.graphics.Bitmap;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.util.BitmapManager;
import java.io.File;

final class LiteActivity$15
  implements Runnable
{
  LiteActivity$15(String paramString, LiteActivity.GetBackgroundCB paramGetBackgroundCB) {}
  
  public void run()
  {
    if (ChatBackgroundManager.a(new File(this.a)))
    {
      this.b.a(null, true);
      return;
    }
    Bitmap localBitmap = BitmapManager.a(this.a);
    LiteActivity.GetBackgroundCB localGetBackgroundCB = this.b;
    if (localGetBackgroundCB != null) {
      localGetBackgroundCB.a(localBitmap, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.15
 * JD-Core Version:    0.7.0.1
 */