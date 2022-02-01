package com.tencent.biz.pubaccount.readinjoyAd.ad.handlers;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

class AdHandler$4
  implements Runnable
{
  AdHandler$4(AdHandler paramAdHandler, View paramView, AbsListView paramAbsListView, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int i = this.a.getBottom() - this.b.getBottom() - this.b.getPaddingBottom() + AdHandler.c(this.this$0);
    this.b.setInterpolator(AdHandler.d(this.this$0));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("adjust scroll Before:");
      localStringBuilder.append(this.c - i);
      localStringBuilder.append(", After:");
      localStringBuilder.append(this.d / 1);
      QLog.d("AdHandler", 2, localStringBuilder.toString());
    }
    i = i + this.d / 1 + 1;
    int j = (int)(AdHandler.e(this.this$0) * 1000.0F * 2.0F * i / this.b.getFlingVelocityY());
    this.b.smoothScrollByImmediately(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdHandler.4
 * JD-Core Version:    0.7.0.1
 */