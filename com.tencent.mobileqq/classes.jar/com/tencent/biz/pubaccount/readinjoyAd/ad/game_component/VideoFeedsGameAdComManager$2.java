package com.tencent.biz.pubaccount.readinjoyAd.ad.game_component;

import android.graphics.Color;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;

class VideoFeedsGameAdComManager$2
  implements Runnable
{
  VideoFeedsGameAdComManager$2(VideoFeedsGameAdComManager paramVideoFeedsGameAdComManager) {}
  
  public void run()
  {
    if ((VideoFeedsGameAdComManager.b(this.this$0) != null) && (VideoFeedsGameAdComManager.b(this.this$0).bk != null))
    {
      VideoFeedsGameAdComManager.a(VideoFeedsGameAdComManager.b(this.this$0).bk, Color.parseColor("#262626"));
      if (ReadInJoyAdSwitchUtil.a()) {
        VideoFeedsGameAdComManager.a(VideoFeedsGameAdComManager.b(this.this$0).bk, Color.parseColor("#80000000"));
      }
      VideoFeedsGameAdComManager.a(VideoFeedsGameAdComManager.b(this.this$0).bk, null, null, null, null);
      VideoFeedsGameAdComManager.a(VideoFeedsGameAdComManager.b(this.this$0).bk, HardCodeUtil.a(2131913420));
      VideoFeedsGameAdComManager.b(this.this$0).bk.setClickable(false);
      VideoFeedsGameAdComManager.b(this.this$0).bk.setClickable(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.2
 * JD-Core Version:    0.7.0.1
 */