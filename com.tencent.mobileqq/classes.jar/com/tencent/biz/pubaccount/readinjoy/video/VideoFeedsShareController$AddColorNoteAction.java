package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.res.Resources;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.share.ShareAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class VideoFeedsShareController$AddColorNoteAction
  extends ShareAction
{
  VideoFeedsShareController$AddColorNoteAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (VideoFeedsShareController.a(this.a) != null)
    {
      if (VideoFeedsShareController.a(this.a).b())
      {
        QLog.d("VideoFeedsShareController", 2, "mColorNoteController ：add colorNote");
        VideoFeedsShareController.a(this.a).e();
        QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690972), 5000).a();
      }
    }
    else {
      return;
    }
    VideoFeedsShareController.a(this.a).i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.AddColorNoteAction
 * JD-Core Version:    0.7.0.1
 */