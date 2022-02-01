package com.tencent.mobileqq.activity;

import android.os.Message;
import android.widget.Toast;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class AssociatedAccountManageActivity$1
  extends MqqHandler
{
  AssociatedAccountManageActivity$1(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    AssociatedAccountManageActivity localAssociatedAccountManageActivity;
    switch (paramMessage.what)
    {
    default: 
      break;
    case 8195: 
      if (AssociatedAccountManageActivity.access$100(this.a) != null) {
        AssociatedAccountManageActivity.access$100(this.a).cancel();
      }
      localAssociatedAccountManageActivity = this.a;
      AssociatedAccountManageActivity.access$102(localAssociatedAccountManageActivity, QQToast.makeText(localAssociatedAccountManageActivity, paramMessage.arg1, paramMessage.arg2, 0).show(this.a.getTitleBarHeight()));
      break;
    case 8194: 
      if ((AssociatedAccountManageActivity.access$000(this.a) != null) && (AssociatedAccountManageActivity.access$000(this.a).isShowing()))
      {
        AssociatedAccountManageActivity.access$000(this.a).dismiss();
        AssociatedAccountManageActivity.access$002(this.a, null);
      }
      break;
    case 8193: 
      if (AssociatedAccountManageActivity.access$000(this.a) == null)
      {
        localAssociatedAccountManageActivity = this.a;
        AssociatedAccountManageActivity.access$002(localAssociatedAccountManageActivity, new QQProgressDialog(localAssociatedAccountManageActivity, localAssociatedAccountManageActivity.getTitleBarHeight()));
      }
      if ((!this.a.isFinishing()) && (!AssociatedAccountManageActivity.access$000(this.a).isShowing())) {
        try
        {
          AssociatedAccountManageActivity.access$000(this.a).show();
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AssociatedAccountManage", 2, "QQProgressDialog show exception.", localException);
          }
        }
      }
      break;
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.1
 * JD-Core Version:    0.7.0.1
 */