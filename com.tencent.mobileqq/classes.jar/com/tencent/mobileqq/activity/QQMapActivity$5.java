package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQMapActivity$5
  implements View.OnClickListener
{
  QQMapActivity$5(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.fetchDataFailed)
    {
      this.a.refresh();
    }
    else if ("group_activity".equals(this.a.mFrom))
    {
      this.a.onTroopActivityCallback();
    }
    else
    {
      QQMapActivity localQQMapActivity = this.a;
      localQQMapActivity.setResult(-1, localQQMapActivity.getLocationData());
      this.a.finish();
      this.a.sendSuccessCall();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity.5
 * JD-Core Version:    0.7.0.1
 */