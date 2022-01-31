package com.dataline.activities;

import android.graphics.Bitmap;
import bcwc;
import cb;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import java.io.File;

final class LiteActivity$15
  implements Runnable
{
  LiteActivity$15(String paramString, cb paramcb) {}
  
  public void run()
  {
    if (ChatBackgroundManager.a(new File(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Cb.a(null, true);
    }
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = bcwc.a(this.jdField_a_of_type_JavaLangString);
    } while (this.jdField_a_of_type_Cb == null);
    this.jdField_a_of_type_Cb.a(localBitmap, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.15
 * JD-Core Version:    0.7.0.1
 */