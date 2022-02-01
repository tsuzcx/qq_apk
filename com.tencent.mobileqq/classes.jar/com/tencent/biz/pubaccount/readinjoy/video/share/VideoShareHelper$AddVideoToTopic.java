package com.tencent.biz.pubaccount.readinjoy.video.share;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;

class VideoShareHelper$AddVideoToTopic
  extends ShareAction
{
  VideoShareHelper$AddVideoToTopic(VideoShareHelper paramVideoShareHelper) {}
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    paramBaseArticleInfo = VideoShareHelper.a(this.a);
    if (paramBaseArticleInfo != null)
    {
      RIJUgcUtils.b(VideoShareHelper.a(this.a), paramBaseArticleInfo.innerUniqueID, 3);
      return;
    }
    QLog.e("Q.readinjoy.video.VideoShareHelper", 1, "add video to topic failed, mArticleInfo = null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.share.VideoShareHelper.AddVideoToTopic
 * JD-Core Version:    0.7.0.1
 */