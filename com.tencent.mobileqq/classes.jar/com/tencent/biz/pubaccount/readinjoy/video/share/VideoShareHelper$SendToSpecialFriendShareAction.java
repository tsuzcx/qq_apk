package com.tencent.biz.pubaccount.readinjoy.video.share;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;

class VideoShareHelper$SendToSpecialFriendShareAction
  extends ShareAction
{
  VideoShareHelper$SendToSpecialFriendShareAction(VideoShareHelper paramVideoShareHelper) {}
  
  public int a()
  {
    return 19;
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoShareHelper.a(this.a, false);
    VideoShareHelper.a(this.a, paramBaseArticleInfo, paramActionSheetItem.uin, paramActionSheetItem.uinType, paramActionSheetItem.label);
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.share.VideoShareHelper.SendToSpecialFriendShareAction
 * JD-Core Version:    0.7.0.1
 */