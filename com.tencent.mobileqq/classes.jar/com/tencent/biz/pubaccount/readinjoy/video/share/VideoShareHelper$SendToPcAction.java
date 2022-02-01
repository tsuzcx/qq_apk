package com.tencent.biz.pubaccount.readinjoy.video.share;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoShareHelper$SendToPcAction
  extends ShareAction
{
  VideoShareHelper$SendToPcAction(VideoShareHelper paramVideoShareHelper) {}
  
  public int a()
  {
    return 2;
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoShareHelper.a(this.a).d(paramString + "&sourcefrom=6");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.share.VideoShareHelper.SendToPcAction
 * JD-Core Version:    0.7.0.1
 */