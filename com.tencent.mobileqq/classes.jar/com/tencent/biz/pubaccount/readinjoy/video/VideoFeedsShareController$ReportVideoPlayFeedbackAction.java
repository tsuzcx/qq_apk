package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeedback.PlayFeedbackHelper;
import com.tencent.biz.pubaccount.readinjoy.video.share.ShareAction;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoFeedsShareController$ReportVideoPlayFeedbackAction
  extends ShareAction
{
  VideoFeedsShareController$ReportVideoPlayFeedbackAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.g)) && (VideoFeedsShareController.a(this.a).a() != null))
    {
      PlayFeedbackHelper.a(VideoFeedsShareController.a(this.a), FeedsChannelDataHelper.a(paramVideoInfo), VideoFeedsShareController.a(this.a).a().a, 2, 0);
      PlayFeedbackHelper.a(paramVideoInfo.g, 2, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.ReportVideoPlayFeedbackAction
 * JD-Core Version:    0.7.0.1
 */