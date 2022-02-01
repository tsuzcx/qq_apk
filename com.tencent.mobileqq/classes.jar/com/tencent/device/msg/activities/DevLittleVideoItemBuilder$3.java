package com.tencent.device.msg.activities;

import android.view.View;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.app.MobileQQ;

class DevLittleVideoItemBuilder$3
  implements ActionSheet.OnButtonClickListener
{
  DevLittleVideoItemBuilder$3(DevLittleVideoItemBuilder paramDevLittleVideoItemBuilder, MessageForDevLittleVideo paramMessageForDevLittleVideo, ShortVideoRealItemBuilder.Holder paramHolder, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    boolean bool = NetworkUtil.g(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder.a.getApplication().getApplicationContext());
    paramView = this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo;
    if (bool) {}
    for (paramInt = 1002;; paramInt = 1005)
    {
      paramView.videoFileStatus = paramInt;
      this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileProgress = 0;
      this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.serial();
      this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder.a.getMessageFacade().a(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.frienduin, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.istroop, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.uniseq, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.msgData);
      if (!bool) {
        break;
      }
      this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder.a(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$Holder.a.setFailedIconVisable(false, this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder);
      DevLittleVideoItemBuilder.a(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$Holder, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileProgress, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */