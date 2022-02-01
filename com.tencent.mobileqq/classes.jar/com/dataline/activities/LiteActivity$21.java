package com.dataline.activities;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

class LiteActivity$21
  implements View.OnClickListener
{
  LiteActivity$21(LiteActivity paramLiteActivity) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.o = true;
    StatisticAssist.a(this.a.app.getApplication().getApplicationContext(), this.a.app.getCurrentAccountUin(), "dl_ckadv");
    Intent localIntent = new Intent(this.a, LiteAdvanceActivity.class);
    localIntent.putExtra("targetUin", this.a.b);
    this.a.startActivityForResult(localIntent, 7);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.21
 * JD-Core Version:    0.7.0.1
 */