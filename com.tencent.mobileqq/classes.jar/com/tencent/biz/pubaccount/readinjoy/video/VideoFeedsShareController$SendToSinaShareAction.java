package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.share.ShareAction;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoFeedsShareController$SendToSinaShareAction
  extends ShareAction
{
  VideoFeedsShareController$SendToSinaShareAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if ((paramVideoInfo.n != null) && (paramVideoInfo.n.contains("kandianshare.html5.qq.com")))
    {
      VideoFeedsShareController.a(this.a, paramVideoInfo.c, "", paramVideoInfo.n, paramVideoInfo.b);
      return;
    }
    VideoFeedsShareController.a(this.a, paramVideoInfo.c, "", paramString + "&sourcefrom=4", paramVideoInfo.b);
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.SendToSinaShareAction
 * JD-Core Version:    0.7.0.1
 */