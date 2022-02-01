package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.share.ShareAction;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoFeedsShareController$SendToWeChatShareAction
  extends ShareAction
{
  VideoFeedsShareController$SendToWeChatShareAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoFeedsShareController.b(2);
    VideoFeedsShareController.a(this.a, paramInt, paramVideoInfo, paramString, c(), a());
  }
  
  public int b()
  {
    return 2;
  }
  
  public int c()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.SendToWeChatShareAction
 * JD-Core Version:    0.7.0.1
 */