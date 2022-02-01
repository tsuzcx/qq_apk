package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

class ShortVideoItemBuilder$CompressUpdateListenerImpl$1
  implements Runnable
{
  ShortVideoItemBuilder$CompressUpdateListenerImpl$1(ShortVideoItemBuilder.CompressUpdateListenerImpl paramCompressUpdateListenerImpl, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean, ShortVideoItemBuilder.Holder paramHolder) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin);
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    localObject = ((StringBuilder)localObject).toString();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.a.setDrawStatus(1);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<MessageProgressView> CompressUpdateListenerImpl , onLaunch, run,  keyStr = ");
        localStringBuilder.append((String)localObject);
        QLog.d("ShortVideoItemBuilder", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.a.setAnimProgress(HardCodeUtil.a(2131713960), (String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.a.e = 10;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.a.setVideoCompressStatus(true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.a.a((String)localObject, 1.0F);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.a.setAnimProgress(10, (String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.a.setVideoCompressStatus(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.CompressUpdateListenerImpl.1
 * JD-Core Version:    0.7.0.1
 */