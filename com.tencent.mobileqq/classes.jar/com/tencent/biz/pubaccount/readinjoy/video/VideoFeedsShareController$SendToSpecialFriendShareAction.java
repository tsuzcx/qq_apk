package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.share.ShareAction;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoFeedsShareController$SendToSpecialFriendShareAction
  extends ShareAction
{
  VideoFeedsShareController$SendToSpecialFriendShareAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public int a()
  {
    return 19;
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoFeedsShareController.a(this.a, paramVideoInfo, paramActionSheetItem.uin, paramActionSheetItem.uinType, paramActionSheetItem.label);
  }
  
  public int b()
  {
    return 0;
  }
  
  public int c()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.SendToSpecialFriendShareAction
 * JD-Core Version:    0.7.0.1
 */