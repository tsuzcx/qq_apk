package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.share.ShareAction;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;

class VideoFeedsShareController$SendToQzoneShareAction
  extends ShareAction
{
  VideoFeedsShareController$SendToQzoneShareAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoFeedsShareController.a(this.a).b(VideoFeedsShareController.b(this.a));
    paramActionSheetItem = new Bundle();
    paramActionSheetItem.putString("title", paramVideoInfo.c);
    paramActionSheetItem.putString("desc", paramVideoInfo.d);
    if ((paramVideoInfo.n != null) && (paramVideoInfo.n.contains("kandianshare.html5.qq.com"))) {
      paramActionSheetItem.putString("detail_url", paramVideoInfo.n);
    }
    for (;;)
    {
      paramString = new ArrayList(1);
      paramString.add(paramVideoInfo.b);
      paramActionSheetItem.putStringArrayList("image_url", paramString);
      paramActionSheetItem.putLong("req_share_id", 0L);
      QZoneShareManager.jumpToQzoneShare(VideoFeedsShareController.a(this.a), VideoFeedsShareController.a(this.a), paramActionSheetItem, null, 10001);
      return;
      paramActionSheetItem.putString("detail_url", paramString + "&sourcefrom=1");
    }
  }
  
  public int b()
  {
    return 1;
  }
  
  public int c()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShareController.SendToQzoneShareAction
 * JD-Core Version:    0.7.0.1
 */