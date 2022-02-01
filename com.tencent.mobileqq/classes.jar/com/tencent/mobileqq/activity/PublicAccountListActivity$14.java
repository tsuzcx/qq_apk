package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class PublicAccountListActivity$14
  implements AdapterView.OnItemClickListener
{
  PublicAccountListActivity$14(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = null;
    paramView = paramView.getTag();
    if ((paramView instanceof PublicAccountListActivity.PAViewHolder)) {}
    String str;
    do
    {
      paramAdapterView = ((PublicAccountListActivity.PAViewHolder)paramView).a;
      while (paramAdapterView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("PublicAccountListActivity", 2, "onItemClick - info = null[position = " + paramInt + "]");
        }
        return;
        if ((paramView instanceof PublicAccountListActivity.SearchViewHolder)) {
          paramAdapterView = ((PublicAccountListActivity.SearchViewHolder)paramView).a;
        }
      }
      paramView = new Intent(this.a, ChatActivity.class);
      str = paramAdapterView.a.getUin();
      paramInt = 1008;
      if (paramAdapterView.a.extendType == 2)
      {
        paramView.putExtra("chat_subType", 1);
        paramInt = 0;
      }
      if (!TextUtils.isEmpty(str)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("PublicAccountListActivity", 2, "onItemClick - uin = null");
    return;
    paramView.putExtra("uin", str);
    paramView.putExtra("uintype", paramInt);
    paramView.putExtra("uinname", paramAdapterView.a.name);
    paramView.putExtra("selfSet_leftViewText", this.a.getString(2131695175));
    paramView.putExtra("jump_from", 3);
    this.a.startActivity(paramView);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.a.app, "P_CliOper", "Pb_account_lifeservice", str, "mp_msg_sys_4", "contacts_aio", 0, 0, str, "", "", "", false);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "0X800573B", "0X800573B", 0, 0, str, "", "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity.14
 * JD-Core Version:    0.7.0.1
 */