package com.tencent.biz.pubaccount.accountdetail.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.bean.DynamicInfo;
import com.tencent.biz.pubaccount.accountdetail.bean.MsgAttr;
import com.tencent.biz.pubaccount.accountdetail.handler.AccountDetailBaseItemClickHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import org.json.JSONException;
import org.json.JSONObject;

class AccountDetailBaseAdapter$5
  implements View.OnClickListener
{
  AccountDetailBaseAdapter$5(AccountDetailBaseAdapter paramAccountDetailBaseAdapter, int paramInt, String paramString, DynamicInfo paramDynamicInfo) {}
  
  public void onClick(View paramView)
  {
    int i = this.a;
    if (i == 1)
    {
      if ((!TextUtils.isEmpty(this.b)) && (this.d.y != null)) {
        this.d.y.a(this.b);
      }
    }
    else if ((i == 2) && (this.d.y != null)) {
      this.d.y.a(this.c);
    }
    ReportController.b(this.d.v, "dc00899", "Pb_account_lifeservice", this.d.o, "0X8006981", "0X8006981", 0, 0, String.valueOf(this.c.d.a), String.valueOf(this.c.d.g), String.valueOf(this.c.d.d), String.valueOf(this.c.d.e));
    JSONObject localJSONObject = new JSONObject();
    if (!this.d.t) {}
    for (;;)
    {
      try
      {
        localJSONObject.put("cha_1", this.c.d.h);
        localJSONObject.put("cha_2", AccountDetailBaseAdapter.a(this.d));
        QQAppInterface localQQAppInterface = this.d.v;
        String str = this.d.o;
        i = this.c.d.d;
        long l = this.c.d.a;
        if (this.d.q.followType != 1) {
          break label305;
        }
        paramView = "02";
        ReportController.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", str, "0X80077FA", "0X80077FA", 0, 0, String.valueOf(i), String.valueOf(l), paramView, localJSONObject.toString());
        return;
      }
      catch (JSONException paramView)
      {
        paramView.printStackTrace();
      }
      return;
      label305:
      paramView = "01";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter.5
 * JD-Core Version:    0.7.0.1
 */