package com.tencent.mobileqq.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
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
    Object localObject = this.this$0;
    localObject = new UpSideDownDrawable((Context)localObject, this.a, ((LikeRankingListActivity)localObject).q.getWidth(), this.this$0.q.getHeight());
    this.this$0.q.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.this$0.q.setImageDrawable((Drawable)localObject);
    ((UpSideDownDrawable)localObject).start();
    this.this$0.m.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity.9
 * JD-Core Version:    0.7.0.1
 */