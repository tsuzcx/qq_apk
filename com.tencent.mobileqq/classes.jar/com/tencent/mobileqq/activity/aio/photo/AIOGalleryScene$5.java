package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.mobileqq.activity.photo.VideoPlayControllerForAIO;
import mqq.os.MqqHandler;

class AIOGalleryScene$5
  implements Runnable
{
  AIOGalleryScene$5(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void run()
  {
    this.this$0.d(false);
    this.this$0.c(false);
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a() != null) && ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().a instanceof AIOShortVideoData))) {
      AIOGalleryScene.a(this.this$0, true);
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoVideoPlayControllerForAIO.c())
    {
      this.this$0.u();
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.this$0.b);
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.this$0.b, 100L);
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.post(this.this$0.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.5
 * JD-Core Version:    0.7.0.1
 */