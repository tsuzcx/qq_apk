package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.video.share.ShareAction;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;

class VideoFeedsShareController$AddVideoToTopic
  extends ShareAction
{
  VideoFeedsShareController$AddVideoToTopic(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramVideoInfo != null)
    {
      RIJUgcUtils.b(VideoFeedsShareController.a(this.a), paramVideoInfo.g, 1);
      return;
    }
    QLog.e("VideoFeedsShareController", 1, "add to topic failed, mPlayingVideoInfo = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.AddVideoToTopic
 * JD-Core Version:    0.7.0.1
 */