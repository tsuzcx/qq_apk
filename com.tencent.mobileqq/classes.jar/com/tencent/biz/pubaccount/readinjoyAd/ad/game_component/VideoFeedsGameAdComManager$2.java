package com.tencent.biz.pubaccount.readinjoyAd.ad.game_component;

import android.graphics.Color;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.mobileqq.app.HardCodeUtil;

class VideoFeedsGameAdComManager$2
  implements Runnable
{
  VideoFeedsGameAdComManager$2(VideoFeedsGameAdComManager paramVideoFeedsGameAdComManager) {}
  
  public void run()
  {
    if ((VideoFeedsGameAdComManager.a(this.this$0) != null) && (VideoFeedsGameAdComManager.a(this.this$0).C != null))
    {
      VideoFeedsGameAdComManager.a(VideoFeedsGameAdComManager.a(this.this$0).C, Color.parseColor("#262626"));
      if (ReadInJoyAdSwitchUtil.a()) {
        VideoFeedsGameAdComManager.a(VideoFeedsGameAdComManager.a(this.this$0).C, Color.parseColor("#80000000"));
      }
      VideoFeedsGameAdComManager.a(VideoFeedsGameAdComManager.a(this.this$0).C, null, null, null, null);
      VideoFeedsGameAdComManager.a(VideoFeedsGameAdComManager.a(this.this$0).C, HardCodeUtil.a(2131716043));
      VideoFeedsGameAdComManager.a(this.this$0).C.setClickable(false);
      VideoFeedsGameAdComManager.a(this.this$0).C.setClickable(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.2
 * JD-Core Version:    0.7.0.1
 */