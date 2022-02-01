package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class EqqAccountDetailActivityImpl$13
  implements ActionSheet.OnButtonClickListener
{
  EqqAccountDetailActivityImpl$13(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl, ActionSheet paramActionSheet, String paramString) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.dismiss();
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      paramView = new StringBuilder();
      paramView.append("tel:");
      paramView.append(this.b);
      paramView = new Intent("android.intent.action.DIAL", Uri.parse(paramView.toString()));
      this.c.startActivity(paramView);
      return;
    }
    if (this.c.eqqDetail != null)
    {
      paramView = this.c.app;
      EqqAccountDetailActivityImpl localEqqAccountDetailActivityImpl = this.c;
      CrmUtils.a(paramView, localEqqAccountDetailActivityImpl, localEqqAccountDetailActivityImpl.eqqDetail.name, this.c.uin, "IvrEnterpriseDetailEngineFalse");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.13
 * JD-Core Version:    0.7.0.1
 */