package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.share.ShareAction;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoFeedsShareController$SendToWeChatCircleShareAction
  extends ShareAction
{
  VideoFeedsShareController$SendToWeChatCircleShareAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoFeedsShareController.b(3);
    VideoFeedsShareController.a(this.a, paramInt, paramVideoInfo, paramString, c(), a());
  }
  
  public int b()
  {
    return 4;
  }
  
  public int c()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.SendToWeChatCircleShareAction
 * JD-Core Version:    0.7.0.1
 */