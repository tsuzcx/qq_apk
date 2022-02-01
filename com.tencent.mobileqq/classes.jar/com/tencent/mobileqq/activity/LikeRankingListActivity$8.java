package com.tencent.mobileqq.activity;

import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.widget.PullToZoomListView;

class LikeRankingListActivity$8
  implements Runnable
{
  LikeRankingListActivity$8(LikeRankingListActivity paramLikeRankingListActivity) {}
  
  public void run()
  {
    if (this.this$0.D == null) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestHeight = this.this$0.C;
    localURLDrawableOptions.mRequestWidth = this.this$0.B;
    this.this$0.q.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.this$0.q.setImageDrawable(URLDrawable.getDrawable(this.this$0.D, localURLDrawableOptions));
    this.this$0.m.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.8
 * JD-Core Version:    0.7.0.1
 */