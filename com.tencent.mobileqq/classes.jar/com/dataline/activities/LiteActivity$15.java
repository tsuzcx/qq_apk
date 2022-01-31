package com.dataline.activities;

import android.graphics.Bitmap;
import azvq;
import bz;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import java.io.File;

final class LiteActivity$15
  implements Runnable
{
  LiteActivity$15(String paramString, bz parambz) {}
  
  public void run()
  {
    if (ChatBackgroundManager.a(new File(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Bz.a(null, true);
    }
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = azvq.a(this.jdField_a_of_type_JavaLangString);
    } while (this.jdField_a_of_type_Bz == null);
    this.jdField_a_of_type_Bz.a(localBitmap, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.15
 * JD-Core Version:    0.7.0.1
 */