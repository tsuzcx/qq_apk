package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQWalletMsgItemBuilder$2
  implements View.OnClickListener
{
  QQWalletMsgItemBuilder$2(QQWalletMsgItemBuilder paramQQWalletMsgItemBuilder) {}
  
  public void onClick(View paramView)
  {
    String str = (String)paramView.getTag();
    if (!TextUtils.isEmpty(str))
    {
      ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).doStartBrowser(this.a.e, str);
      if ((this.a.K > 0) && ((this.a.L == 2) || (this.a.L == 3)))
      {
        if (this.a.H.aE().a == 10014) {
          str = "2";
        } else {
          str = "1";
        }
        QQAppInterface localQQAppInterface = this.a.d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.a.K);
        ReportController.b(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "wrap.aiotail.click", 0, 0, localStringBuilder.toString(), str, "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */