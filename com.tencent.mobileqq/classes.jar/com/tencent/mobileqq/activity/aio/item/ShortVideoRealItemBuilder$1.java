package com.tencent.mobileqq.activity.aio.item;

import afwt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import java.lang.ref.WeakReference;

class ShortVideoRealItemBuilder$1
  implements Runnable
{
  ShortVideoRealItemBuilder$1(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, MessageForShortVideo paramMessageForShortVideo, WeakReference paramWeakReference) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progress <= 0) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progress = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress;
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, (afwt)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progress);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */