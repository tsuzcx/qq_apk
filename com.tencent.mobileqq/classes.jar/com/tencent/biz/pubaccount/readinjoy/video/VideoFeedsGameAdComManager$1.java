package com.tencent.biz.pubaccount.readinjoy.video;

import alpo;
import android.graphics.Color;
import android.widget.TextView;
import oed;
import rbt;
import rcz;

public class VideoFeedsGameAdComManager$1
  implements Runnable
{
  public VideoFeedsGameAdComManager$1(rcz paramrcz) {}
  
  public void run()
  {
    if ((rcz.a(this.this$0) != null) && (rcz.a(this.this$0).J != null))
    {
      rcz.a(this.this$0).J.setTextColor(Color.parseColor("#262626"));
      if (oed.a()) {
        rcz.a(this.this$0).J.setTextColor(Color.parseColor("#80000000"));
      }
      rcz.a(this.this$0).J.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      rcz.a(this.this$0).J.setText(alpo.a(2131716597));
      rcz.a(this.this$0).J.setClickable(false);
      rcz.a(this.this$0).J.setClickable(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGameAdComManager.1
 * JD-Core Version:    0.7.0.1
 */