package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor.CompressTask;
import com.tencent.mobileqq.video.AioVideoTransFileController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ShortVideoItemBuilder$7
  implements ActionSheet.OnButtonClickListener
{
  ShortVideoItemBuilder$7(ShortVideoItemBuilder paramShortVideoItemBuilder, MessageForShortVideo paramMessageForShortVideo, ShortVideoItemBuilder.Holder paramHolder, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uiOperatorFlag == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder, 10, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uiOperatorFlag == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004) {
          ShortVideoUtils.reportCancelSendVideo("0X800A375", this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder;
        ShortVideoItemBuilder.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder, true, paramView);
        paramView = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
        paramView.isPause = false;
        if ((!TextUtils.isEmpty(paramView.md5)) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004) && (AioVideoTransFileController.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq)))
        {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus = 1002;
          if (QLog.isColorLevel()) {
            QLog.i("ShortVideoItemBuilder", 2, "onErrorIconClick resumeSending!");
          }
        }
        else if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5 == null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1005) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileStatus == 1004)))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.a.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.d.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder.c.setVisibility(8);
          paramView = new VideoCompressProcessor.CompressTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, ShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder));
          VideoCompressProcessor.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, paramView);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder, 10, false);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder$Holder);
        }
        ShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemShortVideoItemBuilder);
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */