package com.tencent.mobileqq.activity.aio.photo;

import aegs;
import android.net.Uri;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class AIOGalleryScene$18
  implements Runnable
{
  public AIOGalleryScene$18(aegs paramaegs, File paramFile, ArrayList paramArrayList) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoFile != null)
      {
        Uri localUri = Uri.parse("file://" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
        aegs.a(this.this$0, localUri, this.jdField_a_of_type_JavaUtilArrayList);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.i("AIOGalleryScene", 1, "add qr action sheet error: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.18
 * JD-Core Version:    0.7.0.1
 */