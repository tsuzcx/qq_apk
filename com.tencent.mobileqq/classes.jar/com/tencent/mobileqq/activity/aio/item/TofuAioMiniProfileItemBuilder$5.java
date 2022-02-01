package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.utils.AnonymousViewHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TofuAioMiniProfileItemBuilder$5
  implements View.OnClickListener
{
  TofuAioMiniProfileItemBuilder$5(TofuAioMiniProfileItemBuilder paramTofuAioMiniProfileItemBuilder, TofuAioMiniProfileItemBuilder.Holder paramHolder) {}
  
  public void onClick(View paramView)
  {
    AnonymousViewHelper.jumpToQuestionListAndAnswer((BaseActivity)this.b.c, this.a.d, 9);
    ReportController.b(null, "dc00898", "", this.a.d, "0X800B5BF", "0X800B5BF", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuAioMiniProfileItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */