package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.share.ShareAction;
import com.tencent.biz.pubaccount.util.ReadInJoyShareHelperV2;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoFeedsShareController$OpenInSysBrowserShareAction
  extends ShareAction
{
  VideoFeedsShareController$OpenInSysBrowserShareAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoFeedsShareController.a(this.a).b(VideoFeedsShareController.b(this.a));
    if ((paramVideoInfo.m != null) && (paramVideoInfo.m.contains("kandianshare.html5.qq.com")))
    {
      this.a.a.b(paramVideoInfo.m);
      return;
    }
    this.a.a.b(paramString + "&sourcefrom=6");
  }
  
  public int c()
  {
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.OpenInSysBrowserShareAction
 * JD-Core Version:    0.7.0.1
 */