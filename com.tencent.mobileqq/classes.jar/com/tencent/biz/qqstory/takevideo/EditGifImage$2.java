package com.tencent.biz.qqstory.takevideo;

import com.tencent.image.URLImageView;
import cooperation.qzone.widget.FastAnimationDrawable;
import wyz;
import xan;

class EditGifImage$2
  implements Runnable
{
  EditGifImage$2(EditGifImage paramEditGifImage) {}
  
  public void run()
  {
    FastAnimationDrawable localFastAnimationDrawable = this.this$0.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable;
    this.this$0.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.stop();
    this.this$0.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable = this.this$0.b;
    this.this$0.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.this$0.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable);
    this.this$0.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.start();
    this.this$0.b = localFastAnimationDrawable;
    this.this$0.d = true;
    this.this$0.jdField_a_of_type_Xan.a.a(true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditGifImage.2
 * JD-Core Version:    0.7.0.1
 */