package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AccountManageActivity$MyOnButtonClickListener
  implements ActionSheet.OnButtonClickListener
{
  int a = -1;
  
  AccountManageActivity$MyOnButtonClickListener(AccountManageActivity paramAccountManageActivity) {}
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void onClick(View paramView, int paramInt)
  {
    if (this.b.isFinishing()) {
      return;
    }
    if (this.b.p != null) {
      this.b.p.dismiss();
    }
    StringBuilder localStringBuilder;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      try
      {
        this.b.g.show();
      }
      catch (Throwable paramView)
      {
        paramView.printStackTrace();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("MyOnButtonClickListener 1 error");
        localStringBuilder.append(paramView.getMessage());
        QLog.i("AccountManageActivity", 1, localStringBuilder.toString());
      }
      paramInt = this.a;
      if (paramInt >= 0) {
        this.b.a(paramInt, true);
      }
    }
    else
    {
      try
      {
        this.b.g.show();
      }
      catch (Throwable paramView)
      {
        paramView.printStackTrace();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("MyOnButtonClickListener 0 error");
        localStringBuilder.append(paramView.getMessage());
        QLog.i("AccountManageActivity", 1, localStringBuilder.toString());
      }
      paramInt = this.a;
      if (paramInt >= 0) {
        this.b.a(paramInt, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.MyOnButtonClickListener
 * JD-Core Version:    0.7.0.1
 */