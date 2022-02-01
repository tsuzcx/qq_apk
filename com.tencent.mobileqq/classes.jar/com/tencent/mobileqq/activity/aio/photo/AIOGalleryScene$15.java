package com.tencent.mobileqq.activity.aio.photo;

import ahri;
import android.net.Uri;
import avjd;
import java.io.File;
import java.util.ArrayList;

public class AIOGalleryScene$15
  implements Runnable
{
  public AIOGalleryScene$15(ahri paramahri, File paramFile, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (avjd.a().b()) {}
    while ((this.this$0.g == null) || (!this.this$0.g.equals(this.jdField_a_of_type_JavaIoFile.getPath()))) {
      return;
    }
    Uri localUri = Uri.parse("file://" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
    ahri.a(this.this$0, localUri, this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.15
 * JD-Core Version:    0.7.0.1
 */