package com.tencent.biz.pubaccount.readinjoy.video.share;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.playfeedback.PlayFeedbackHelper;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoShareHelper$ReportVideoPlayFeedbackAction
  extends ShareAction
{
  VideoShareHelper$ReportVideoPlayFeedbackAction(VideoShareHelper paramVideoShareHelper) {}
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    PlayFeedbackHelper.a(VideoShareHelper.a(this.a), paramBaseArticleInfo, VideoShareHelper.a(this.a).a(paramBaseArticleInfo.getInnerUniqueID()), 0, 1);
    PlayFeedbackHelper.a(paramBaseArticleInfo.getInnerUniqueID(), 0, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.share.VideoShareHelper.ReportVideoPlayFeedbackAction
 * JD-Core Version:    0.7.0.1
 */