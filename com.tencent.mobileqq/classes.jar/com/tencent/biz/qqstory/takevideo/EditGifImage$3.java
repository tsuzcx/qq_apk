package com.tencent.biz.qqstory.takevideo;

import com.tencent.image.URLImageView;
import cooperation.qzone.widget.FastAnimationDrawable;
import ysk;
import yty;

class EditGifImage$3
  implements Runnable
{
  EditGifImage$3(EditGifImage paramEditGifImage) {}
  
  public void run()
  {
    FastAnimationDrawable localFastAnimationDrawable = this.this$0.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable;
    this.this$0.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.stop();
    this.this$0.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable = this.this$0.b;
    this.this$0.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.this$0.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable);
    this.this$0.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.start();
    this.this$0.d = false;
    this.this$0.jdField_a_of_type_Yty.a.a(true, false);
    this.this$0.b = localFastAnimationDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditGifImage.3
 * JD-Core Version:    0.7.0.1
 */