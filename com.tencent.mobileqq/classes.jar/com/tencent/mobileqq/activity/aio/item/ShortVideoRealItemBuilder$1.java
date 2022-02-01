package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.data.MessageForShortVideo;
import java.lang.ref.WeakReference;

class ShortVideoRealItemBuilder$1
  implements Runnable
{
  ShortVideoRealItemBuilder$1(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, MessageForShortVideo paramMessageForShortVideo, WeakReference paramWeakReference) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progress <= 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      ((MessageForShortVideo)localObject).progress = ((MessageForShortVideo)localObject).videoFileProgress;
    }
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, (ShortVideoRealItemBuilder.Holder)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progress);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */