package com.tencent.device.msg.activities;

import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.Holder;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class DevShortVideoItemBuilder$3
  implements ActionSheet.OnButtonClickListener
{
  DevShortVideoItemBuilder$3(DevShortVideoItemBuilder paramDevShortVideoItemBuilder, MessageForShortVideo paramMessageForShortVideo, ShortVideoItemBuilder.Holder paramHolder, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder;
        if ((paramView != null) && (paramView.a != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.a.setFailedIconVisable(false, this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder);
          DevShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentDeviceMsgActivitiesDevShortVideoItemBuilder, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder, ShortVideoUtils.getDisplayProgress(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileProgress, 10), true);
        }
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevShortVideoItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */