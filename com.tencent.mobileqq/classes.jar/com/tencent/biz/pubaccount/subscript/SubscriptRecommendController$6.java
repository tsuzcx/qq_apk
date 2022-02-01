package com.tencent.biz.pubaccount.subscript;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class SubscriptRecommendController$6
  implements View.OnClickListener
{
  SubscriptRecommendController$6(SubscriptRecommendController paramSubscriptRecommendController) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.f, "P_CliOper", "Pb_account_lifeservice", "", "0X8005733", "0X8005733", 0, 0, "", "", "", "");
    ReportController.b(this.a.f, "CliOper", "", "", "0X8006430", "0X8006430", 0, 0, "", "", "", "");
    Object localObject = this.a;
    ((SubscriptRecommendController)localObject).i = false;
    ((SubscriptRecommendController)localObject).h.setEnabled(false);
    ThreadManager.getSubThreadHandler().post(new SubscriptRecommendController.6.1(this));
    if (this.a.j == 1)
    {
      SubscriptRecommendController.a(this.a);
    }
    else if (this.a.j == 3)
    {
      localObject = this.a.f.getHandler(SubscriptFeedsActivity.class);
      if ((localObject != null) && (this.a.e.get() != null) && ((this.a.e.get() instanceof SubscriptFeedsActivity))) {
        ((MqqHandler)localObject).sendEmptyMessage(1006);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendController.6
 * JD-Core Version:    0.7.0.1
 */