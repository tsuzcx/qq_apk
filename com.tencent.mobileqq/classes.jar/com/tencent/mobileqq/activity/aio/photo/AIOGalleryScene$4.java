package com.tencent.mobileqq.activity.aio.photo;

import agyh;
import agzn;
import aham;
import android.widget.SeekBar;
import android.widget.TextView;

public class AIOGalleryScene$4
  implements Runnable
{
  public AIOGalleryScene$4(agyh paramagyh, long paramLong, float paramFloat, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_Agzn.a();
    if ((localObject == null) || (((aham)localObject).a.f != this.jdField_a_of_type_Long)) {
      return;
    }
    if (AIOFileVideoData.class.isInstance(((aham)localObject).a))
    {
      localObject = (AIOFileVideoData)((aham)localObject).a;
      ((AIOFileVideoData)localObject).c = (((float)((AIOFileVideoData)localObject).h * this.jdField_a_of_type_Float));
    }
    this.this$0.c(false);
    this.this$0.a(true);
    this.this$0.b.setText(this.jdField_a_of_type_JavaLangString);
    int i = (int)(10000.0F * this.jdField_a_of_type_Float);
    this.this$0.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.4
 * JD-Core Version:    0.7.0.1
 */