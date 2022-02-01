package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;

class TroopDisbandActivity$4
  implements DialogInterface.OnClickListener
{
  TroopDisbandActivity$4(TroopDisbandActivity paramTroopDisbandActivity, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.b.w == null)
    {
      paramDialogInterface = this.b;
      paramDialogInterface.w = new QQProgressNotifier(paramDialogInterface);
    }
    if (NetworkUtil.isNetSupport(this.b))
    {
      paramDialogInterface = (ITroopMngHandler)this.b.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
      if (paramDialogInterface != null)
      {
        if ((this.b.p & 0x1) == 0)
        {
          TroopDisbandActivity localTroopDisbandActivity = this.b;
          localTroopDisbandActivity.p |= 0x1;
          paramDialogInterface.b(this.b.k);
        }
        this.b.w.b(0, 2131889068, 1000);
      }
      else
      {
        this.b.w.b(2, 2131889057, 1500);
      }
    }
    else
    {
      this.b.w.b(2, 2131892157, 1500);
    }
    paramDialogInterface = this.a;
    if ((paramDialogInterface != null) && (paramDialogInterface.isShowing())) {
      this.a.cancel();
    }
    ReportController.b(this.b.app, "CliOper", "", "", "Grp", "Dismiss_grp_OK", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity.4
 * JD-Core Version:    0.7.0.1
 */