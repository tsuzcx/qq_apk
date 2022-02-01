package com.tencent.mobileqq.activity.aio.item;

import android.os.Bundle;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class TribeShortVideoItemBuilder$4
  extends DownloadListener
{
  TribeShortVideoItemBuilder$4(TribeShortVideoItemBuilder paramTribeShortVideoItemBuilder, TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder, MessageForTribeShortVideo paramMessageForTribeShortVideo) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    String str = paramDownloadTask.a().getString("filePath");
    if (paramDownloadTask.a == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TribeShortVideoItemBuilder", 2, "download video success! videoFile:" + str);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoMsgHolder.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTribeShortVideoItemBuilder$TribeShortVideoMsgHolder.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTribeShortVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTribeShortVideo.videoWidth, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTribeShortVideo.videoHeight, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTribeShortVideo.coverImgUrl, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */