package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class QQWalletMsgItemBuilder$2
  implements View.OnClickListener
{
  QQWalletMsgItemBuilder$2(QQWalletMsgItemBuilder paramQQWalletMsgItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (String)paramView.getTag();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).doStartBrowser(this.a.jdField_a_of_type_AndroidContentContext, (String)localObject);
      if ((this.a.m > 0) && ((this.a.n == 2) || (this.a.n == 3)))
      {
        localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.a.m);
        ReportController.b((AppRuntime)localObject, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "wrap.aiotail.click", 0, 0, localStringBuilder.toString(), "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */