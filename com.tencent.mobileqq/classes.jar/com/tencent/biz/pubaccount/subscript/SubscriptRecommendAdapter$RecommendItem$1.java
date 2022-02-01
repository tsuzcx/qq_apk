package com.tencent.biz.pubaccount.subscript;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class SubscriptRecommendAdapter$RecommendItem$1
  implements View.OnClickListener
{
  SubscriptRecommendAdapter$RecommendItem$1(SubscriptRecommendAdapter.RecommendItem paramRecommendItem, SubscriptRecommendAdapter paramSubscriptRecommendAdapter) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.b.m.d, "P_CliOper", "Pb_account_lifeservice", "", "0X8005732", "0X8005732", 0, 0, "", "", "", "");
    ReportController.b(this.b.m.d, "CliOper", "", "", "0X800642F", "0X800642F", 0, 0, String.valueOf(this.b.l.a), "", "", "");
    if (this.b.l != null)
    {
      String str = String.valueOf(this.b.l.a);
      if (!TextUtils.isEmpty(str)) {
        if (this.b.l.f == 0)
        {
          if (!NetworkUtil.isNetSupport(this.b.m.a.getApplicationContext()))
          {
            QQToast.makeText(this.b.m.a, 2131892104, 0).show(((BaseActivity)this.b.m.a).getTitleBarHeight());
          }
          else
          {
            this.b.a(2);
            this.b.l.f = 2;
            Object localObject = this.b.m.d.getHandler(SubscriptFeedsActivity.class);
            if ((localObject != null) && (this.b.m.a != null) && ((this.b.m.a instanceof SubscriptFeedsActivity))) {
              ((MqqHandler)localObject).sendEmptyMessage(1007);
            }
            localObject = (IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class);
            ((IPublicAccountObserver)localObject).setOnCallback(new SubscriptRecommendAdapter.RecommendPublicAccountObserverCallback(this.b.m, this.b));
            ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).followUin(this.b.m.d, this.b.m.a, str, (IPublicAccountObserver)localObject);
          }
        }
        else {
          SubscriptRecommendAdapter.RecommendItem.a(this.b);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendAdapter.RecommendItem.1
 * JD-Core Version:    0.7.0.1
 */