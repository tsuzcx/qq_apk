package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.widget.PullToZoomListView;
import com.tencent.widget.UpSideDownDrawable;

class LikeRankingListActivity$9
  implements Runnable
{
  LikeRankingListActivity$9(LikeRankingListActivity paramLikeRankingListActivity, Bitmap paramBitmap) {}
  
  public void run()
  {
    UpSideDownDrawable localUpSideDownDrawable = new UpSideDownDrawable(this.this$0, this.a, this.this$0.b.getWidth(), this.this$0.b.getHeight());
    this.this$0.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.this$0.b.setImageDrawable(localUpSideDownDrawable);
    localUpSideDownDrawable.a();
    this.this$0.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.9
 * JD-Core Version:    0.7.0.1
 */