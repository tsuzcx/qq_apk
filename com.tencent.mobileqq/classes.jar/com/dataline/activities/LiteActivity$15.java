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
    if (ChatBackgroundManager.a(new File(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$GetBackgroundCB.a(null, true);
      return;
    }
    Bitmap localBitmap = BitmapManager.a(this.jdField_a_of_type_JavaLangString);
    LiteActivity.GetBackgroundCB localGetBackgroundCB = this.jdField_a_of_type_ComDatalineActivitiesLiteActivity$GetBackgroundCB;
    if (localGetBackgroundCB != null) {
      localGetBackgroundCB.a(localBitmap, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.15
 * JD-Core Version:    0.7.0.1
 */