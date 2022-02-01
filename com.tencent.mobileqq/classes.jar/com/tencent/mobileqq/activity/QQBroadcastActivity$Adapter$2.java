package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQBroadcastActivity$Adapter$2
  implements View.OnClickListener
{
  QQBroadcastActivity$Adapter$2(QQBroadcastActivity.Adapter paramAdapter, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.a.edit().putBoolean(this.b, true).commit();
    this.c.b.e.sendEmptyMessageDelayed(1010, 1000L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBroadcastActivity.Adapter.2
 * JD-Core Version:    0.7.0.1
 */