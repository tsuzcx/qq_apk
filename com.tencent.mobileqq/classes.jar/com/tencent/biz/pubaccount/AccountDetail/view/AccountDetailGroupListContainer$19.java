package com.tencent.biz.pubaccount.accountdetail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class AccountDetailGroupListContainer$19
  implements View.OnClickListener
{
  AccountDetailGroupListContainer$19(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.b.q)
    {
      paramView = this.b;
      paramView.r = true;
      if (this.a == 0)
      {
        ReportController.b(paramView.b, "P_CliOper", "Grp_public", "", "connect", "Clk_num", 0, 0, "", "", "", this.b.f.uin);
        paramView = new StringBuilder();
        paramView.append("https://qun.qq.com/qqweb/m/qun/qun_pub_bind/qun2pub.html?_wv=1027&scode=");
        paramView.append(this.b.g);
        paramView = paramView.toString();
      }
      else
      {
        ReportController.b(paramView.b, "P_CliOper", "Grp_public", "", "connect", "Clk_grp", 0, 0, "", "", "", this.b.f.uin);
        paramView = new StringBuilder();
        paramView.append("https://qun.qq.com/qqweb/m/qun/qun_pub_bind/qunlist.html?_wv=1027&power=1&scode=");
        paramView.append(this.b.g);
        paramView = paramView.toString();
      }
    }
    else
    {
      ReportController.b(this.b.b, "P_CliOper", "Grp_public", "", "connect", "Clk_grp", 0, 0, "", "", "", this.b.f.uin);
      paramView = new StringBuilder();
      paramView.append("https://qun.qq.com/qqweb/m/qun/qun_pub_bind/qunlist.html?_wv=1027&scode=");
      paramView.append(this.b.g);
      paramView = paramView.toString();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jumpTo:");
      localStringBuilder.append(paramView);
      QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, localStringBuilder.toString());
    }
    AccountDetailGroupListContainer.c(this.b, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.19
 * JD-Core Version:    0.7.0.1
 */