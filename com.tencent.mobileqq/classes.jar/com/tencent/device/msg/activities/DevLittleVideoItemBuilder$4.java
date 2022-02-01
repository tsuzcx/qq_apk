package com.tencent.device.msg.activities;

import android.view.View;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.app.MobileQQ;

class DevLittleVideoItemBuilder$4
  implements ActionSheet.OnButtonClickListener
{
  DevLittleVideoItemBuilder$4(DevLittleVideoItemBuilder paramDevLittleVideoItemBuilder, MessageForDevLittleVideo paramMessageForDevLittleVideo, ShortVideoRealItemBuilder.Holder paramHolder, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    if (paramInt == 0)
    {
      boolean bool = NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder.a.getApplication().getApplicationContext());
      paramView = this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo;
      if (bool) {
        paramInt = 2002;
      } else {
        paramInt = 2005;
      }
      paramView.videoFileStatus = paramInt;
      paramView = this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo;
      paramView.videoFileProgress = 0;
      paramView.serial();
      this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder.a.getMessageFacade().a(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.frienduin, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.istroop, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.uniseq, this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.msgData);
      if (bool)
      {
        if (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.mThumbFilePath))
        {
          this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder.c(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo);
          paramInt = 1;
        }
        else
        {
          paramInt = 0;
        }
        if (!FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo.videoFileName))
        {
          this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder.b(this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo);
          paramInt = i;
        }
        if (paramInt != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$Holder.a.setFailedIconVisable(false, this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder);
          paramView = this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevLittleVideoItemBuilder;
          MessageForDevLittleVideo localMessageForDevLittleVideo = this.jdField_a_of_type_ComTencentDeviceMsgDataMessageForDevLittleVideo;
          DevLittleVideoItemBuilder.b(paramView, localMessageForDevLittleVideo, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoRealItemBuilder$Holder, localMessageForDevLittleVideo.videoFileProgress, false);
        }
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */