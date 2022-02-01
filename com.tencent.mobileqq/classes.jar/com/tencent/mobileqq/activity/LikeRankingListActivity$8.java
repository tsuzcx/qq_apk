package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import blqp;
import com.tencent.widget.PullToZoomListView;

class LikeRankingListActivity$8
  implements Runnable
{
  LikeRankingListActivity$8(LikeRankingListActivity paramLikeRankingListActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    blqp localblqp = new blqp(this.this$0, this.a, this.this$0.b.getWidth(), this.this$0.b.getHeight());
    this.this$0.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.this$0.b.setImageDrawable(localblqp);
    localblqp.a();
    this.this$0.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.8
 * JD-Core Version:    0.7.0.1
 */