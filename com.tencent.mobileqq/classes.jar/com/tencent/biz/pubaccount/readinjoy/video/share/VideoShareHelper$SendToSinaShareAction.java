package com.tencent.biz.pubaccount.readinjoy.video.share;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.net.URL;

class VideoShareHelper$SendToSinaShareAction
  extends ShareAction
{
  VideoShareHelper$SendToSinaShareAction(VideoShareHelper paramVideoShareHelper) {}
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoShareHelper.a(this.a, false);
    paramActionSheetItem = paramString + "&sourcefrom=4";
    paramString = paramActionSheetItem;
    if (paramBaseArticleInfo.qzoneShareUrl != null)
    {
      paramString = paramActionSheetItem;
      if (paramBaseArticleInfo.qzoneShareUrl.contains("kandianshare.html5.qq.com")) {
        paramString = paramBaseArticleInfo.qzoneShareUrl;
      }
    }
    paramActionSheetItem = this.a;
    String str = paramBaseArticleInfo.mTitle;
    if (paramBaseArticleInfo.getVideoCoverURL() == null) {}
    for (paramBaseArticleInfo = "";; paramBaseArticleInfo = paramBaseArticleInfo.getVideoCoverURL().getFile())
    {
      VideoShareHelper.a(paramActionSheetItem, str, "", paramString, paramBaseArticleInfo);
      return;
    }
  }
  
  public int b()
  {
    return 5;
  }
  
  public int c()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.share.VideoShareHelper.SendToSinaShareAction
 * JD-Core Version:    0.7.0.1
 */