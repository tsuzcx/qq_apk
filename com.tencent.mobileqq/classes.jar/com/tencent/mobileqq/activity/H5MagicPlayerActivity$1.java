package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class H5MagicPlayerActivity$1
  implements View.OnClickListener
{
  H5MagicPlayerActivity$1(H5MagicPlayerActivity paramH5MagicPlayerActivity) {}
  
  public void onClick(View paramView)
  {
    H5MagicPlayerActivity.a(this.a);
    if ((this.a.n.equals(this.a.m)) && (this.a.d != null)) {
      ReportController.b(null, "CliOper", "", "", "MbFasong", "MbGuanbi", 0, 0, this.a.d.epId, "", "", "");
    } else {
      ReportController.b(null, "CliOper", "", "", "MbJieshou", "MbZhudongGuanbi", 0, 0, this.a.d.epId, "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.H5MagicPlayerActivity.1
 * JD-Core Version:    0.7.0.1
 */