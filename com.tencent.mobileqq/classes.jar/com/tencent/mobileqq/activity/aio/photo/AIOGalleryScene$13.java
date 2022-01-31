package com.tencent.mobileqq.activity.aio.photo;

import advv;
import android.net.Uri;
import aqcb;
import java.io.File;
import java.util.ArrayList;

public class AIOGalleryScene$13
  implements Runnable
{
  public AIOGalleryScene$13(advv paramadvv, File paramFile, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (aqcb.a().b()) {}
    while ((this.this$0.g == null) || (!this.this$0.g.equals(this.jdField_a_of_type_JavaIoFile.getPath()))) {
      return;
    }
    Uri localUri = Uri.parse("file://" + this.jdField_a_of_type_JavaIoFile.getAbsolutePath());
    advv.a(this.this$0, localUri, this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.13
 * JD-Core Version:    0.7.0.1
 */