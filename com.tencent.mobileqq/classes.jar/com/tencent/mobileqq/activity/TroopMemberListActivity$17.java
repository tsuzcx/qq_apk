package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopMemberListActivity$17
  implements View.OnClickListener
{
  TroopMemberListActivity$17(TroopMemberListActivity paramTroopMemberListActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((this.b.mCanAtAll) && (!TroopMemberListActivity.access$500(this.b)))
    {
      if (((this.b.mFrom == 11) && (this.b.mDiscRemainCout > 0)) || (this.b.mFrom == 3))
      {
        localObject = this.b.getIntent();
        ((Intent)localObject).putExtra("member_uin", "0");
        ((Intent)localObject).putExtra("member_display_name", this.a);
        this.b.setResult(-1, (Intent)localObject);
        this.b.finish();
        if (this.b.mFrom == 11) {
          ReportController.b(this.b.app, "CliOper", "", "", "0X800621D", "0X800621D", 0, 0, "", "", "", "");
        }
      }
      else
      {
        QQToast.makeText(this.b, HardCodeUtil.a(2131912886), 0).show(this.b.mTitleBar.getHeight());
      }
    }
    else if (!TextUtils.isEmpty(this.b.mNoAtAllRemainTips))
    {
      localObject = this.b;
      QQToast.makeText((Context)localObject, ((TroopMemberListActivity)localObject).mNoAtAllRemainTips, 0).show(this.b.mTitleBar.getHeight());
    }
    else
    {
      QQToast.makeText(this.b, HardCodeUtil.a(2131912847), 0).show(this.b.mTitleBar.getHeight());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.17
 * JD-Core Version:    0.7.0.1
 */