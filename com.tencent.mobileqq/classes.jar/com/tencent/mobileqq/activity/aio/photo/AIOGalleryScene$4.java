package com.tencent.mobileqq.activity.aio.photo;

import android.widget.SeekBar;
import android.widget.TextView;

class AIOGalleryScene$4
  implements Runnable
{
  AIOGalleryScene$4(AIOGalleryScene paramAIOGalleryScene, long paramLong, float paramFloat, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a();
    if ((localObject == null) || (((AIORichMediaInfo)localObject).a.f != this.jdField_a_of_type_Long)) {
      return;
    }
    if (AIOFileVideoData.class.isInstance(((AIORichMediaInfo)localObject).a))
    {
      localObject = (AIOFileVideoData)((AIORichMediaInfo)localObject).a;
      ((AIOFileVideoData)localObject).c = (((float)((AIOFileVideoData)localObject).h * this.jdField_a_of_type_Float));
    }
    this.this$0.c(false);
    this.this$0.a(true);
    this.this$0.b.setText(this.jdField_a_of_type_JavaLangString);
    int i = (int)(10000.0F * this.jdField_a_of_type_Float);
    this.this$0.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.4
 * JD-Core Version:    0.7.0.1
 */