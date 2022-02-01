package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletRedPkgUtils;
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
      QWalletRedPkgUtils.b(this.a.jdField_a_of_type_AndroidContentContext, str);
      if ((this.a.m > 0) && ((this.a.n == 2) || (this.a.n == 3))) {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "wrap.aiotail.click", 0, 0, "" + this.a.m, "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQWalletMsgItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */