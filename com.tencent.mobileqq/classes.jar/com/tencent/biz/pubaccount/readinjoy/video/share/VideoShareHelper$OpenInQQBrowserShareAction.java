package com.tencent.biz.pubaccount.readinjoy.video.share;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoShareHelper$OpenInQQBrowserShareAction
  extends ShareAction
{
  VideoShareHelper$OpenInQQBrowserShareAction(VideoShareHelper paramVideoShareHelper) {}
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if ((paramBaseArticleInfo.qzoneShareUrl != null) && (paramBaseArticleInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com")))
    {
      VideoShareHelper.a(this.a).a(paramBaseArticleInfo.qzoneShareUrl);
      return;
    }
    VideoShareHelper.a(this.a).a(paramString + "&sourcefrom=6");
  }
  
  public int c()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.share.VideoShareHelper.OpenInQQBrowserShareAction
 * JD-Core Version:    0.7.0.1
 */