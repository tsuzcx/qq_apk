package com.tencent.mobileqq.activity.aio.item;

import agbi;
import com.tencent.mobileqq.data.MessageForShortVideo;
import java.lang.ref.WeakReference;

class ShortVideoRealItemBuilder$2
  implements Runnable
{
  ShortVideoRealItemBuilder$2(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder, WeakReference paramWeakReference, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference != null)) {
      this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, (agbi)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */