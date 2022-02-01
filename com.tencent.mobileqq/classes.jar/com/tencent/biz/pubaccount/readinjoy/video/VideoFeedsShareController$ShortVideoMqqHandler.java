package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class VideoFeedsShareController$ShortVideoMqqHandler
  extends MqqHandler
{
  private VideoFeedsShareController$ShortVideoMqqHandler(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      QQToast.a(VideoFeedsShareController.a(this.a), 2131719357, 0).a();
      return;
      String str = VideoFeedsShareController.a(this.a).getString(2131719358);
      paramMessage = (String)paramMessage.obj;
      QQToast.a(VideoFeedsShareController.a(this.a), 2, str + paramMessage, 0).a();
      ImageUtil.a(VideoFeedsShareController.a(this.a), paramMessage);
      return;
    } while ((VideoFeedsShareController.a(this.a) == null) || (VideoFeedsShareController.a(this.a).jdField_a_of_type_Int != 0));
    paramMessage = ShortVideoUtils.getShortVideoSavePath(VideoFeedsShareController.a(this.a).jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    DialogUtil.a(VideoFeedsShareController.a(this.a), 232, VideoFeedsShareController.a(this.a).getResources().getString(2131719389), VideoFeedsShareController.a(this.a).getResources().getString(2131719388), 2131719372, 2131718540, new VideoFeedsShareController.ShortVideoMqqHandler.1(this, paramMessage), new VideoFeedsShareController.ShortVideoMqqHandler.2(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.ShortVideoMqqHandler
 * JD-Core Version:    0.7.0.1
 */