package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.qphone.base.util.QLog;

class TribeShortVideoItemBuilder$6
  implements Runnable
{
  TribeShortVideoItemBuilder$6(TribeShortVideoItemBuilder paramTribeShortVideoItemBuilder, TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder, long paramLong) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoMsgHolder;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeShortVideoItemBuilder", 2, "showPlayIcon");
      }
      return;
    }
    localObject = (Long)((TribeShortVideoItemBuilder.TribeShortVideoMsgHolder)localObject).jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTag();
    if (localObject != null)
    {
      if (((Long)localObject).longValue() != this.jdField_a_of_type_Long) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */