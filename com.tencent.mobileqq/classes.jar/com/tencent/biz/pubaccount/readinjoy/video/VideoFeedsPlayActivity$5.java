package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import oat;
import skb;
import skc;

class VideoFeedsPlayActivity$5
  implements Runnable
{
  VideoFeedsPlayActivity$5(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void run()
  {
    int i = 3;
    VideoFeedsPlayActivity.a(this.this$0).a();
    Object localObject = VideoFeedsPlayActivity.a(this.this$0).a();
    skc localskc1 = new skc((VideoInfo)localObject);
    skc localskc2;
    if (localObject != null)
    {
      localObject = ((VideoInfo)localObject).g;
      localskc2 = localskc1.a("icon_position", Integer.valueOf(3));
      if (!VideoFeedsPlayActivity.b(this.this$0)) {
        break label111;
      }
    }
    for (;;)
    {
      localskc2.a("icon_status", Integer.valueOf(i)).h((String)localObject);
      oat.a(null, "", "0X800ABBB", "0X800ABBB", 0, 0, "", "", (String)localObject, localskc1.a().a(), false);
      return;
      localObject = "";
      break;
      label111:
      if (VideoFeedsPlayActivity.a(this.this$0).a() == 1) {
        i = 2;
      } else {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity.5
 * JD-Core Version:    0.7.0.1
 */