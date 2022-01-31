package com.tencent.biz.pubaccount.readinjoy.video;

import ajyc;
import android.graphics.Color;
import android.widget.TextView;
import oat;
import qms;
import qny;

public class VideoFeedsGameAdComManager$1
  implements Runnable
{
  public VideoFeedsGameAdComManager$1(qny paramqny) {}
  
  public void run()
  {
    if ((qny.a(this.this$0) != null) && (qny.a(this.this$0).J != null))
    {
      qny.a(this.this$0).J.setTextColor(Color.parseColor("#262626"));
      if (oat.a()) {
        qny.a(this.this$0).J.setTextColor(Color.parseColor("#80000000"));
      }
      qny.a(this.this$0).J.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      qny.a(this.this$0).J.setText(ajyc.a(2131716214));
      qny.a(this.this$0).J.setClickable(false);
      qny.a(this.this$0).J.setClickable(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGameAdComManager.1
 * JD-Core Version:    0.7.0.1
 */