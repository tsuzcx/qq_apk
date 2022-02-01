package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.QBaseActivity;

class RiskHintDlgFragment$3
  implements DialogInterface.OnDismissListener
{
  RiskHintDlgFragment$3(RiskHintDlgFragment paramRiskHintDlgFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.getQBaseActivity() != null)
    {
      this.a.getQBaseActivity().finish();
      this.a.getQBaseActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RiskHintDlgFragment.3
 * JD-Core Version:    0.7.0.1
 */