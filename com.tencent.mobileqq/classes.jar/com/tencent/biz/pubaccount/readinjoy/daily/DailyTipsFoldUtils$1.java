package com.tencent.biz.pubaccount.readinjoy.daily;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;
import noo;
import onk;
import onr;
import opx;
import opy;

public final class DailyTipsFoldUtils$1
  implements Runnable
{
  public DailyTipsFoldUtils$1(ReadInJoyXListView paramReadInJoyXListView) {}
  
  public void run()
  {
    QLog.i("DailyTipsFoldUtils", 2, "[foldDailyTips], smoothScroll.");
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(1000L);
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    View localView = this.a.getChildAt(this.a.getHeaderViewsCount());
    localValueAnimator.addUpdateListener(new opx(this, localView, localView.getHeight()));
    localValueAnimator.addListener(new opy(this, localView));
    localValueAnimator.start();
    noo.a(null, "", "0X800A577", "0X800A577", 0, 0, onk.a(), "", "", onk.a().a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.daily.DailyTipsFoldUtils.1
 * JD-Core Version:    0.7.0.1
 */