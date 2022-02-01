package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AssociatedAccountManageActivity$7$1
  implements Runnable
{
  AssociatedAccountManageActivity$7$1(AssociatedAccountManageActivity.7 param7) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountManage", 2, "deleteAccount begin to remove account view");
    }
    try
    {
      View localView = AssociatedAccountManageActivity.access$1500(this.a.this$0, this.a.a, 1);
      if (localView != null) {
        this.a.this$0.mAccountListView.removeView(localView);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountManage", 2, "deleteAccount runOnUiThread removeView error");
      }
    }
    this.a.this$0.hideDelAccountDialog();
    if ((this.a.this$0.mAccountList != null) && (this.a.this$0.mAccountList.size() != 0)) {
      this.a.this$0.mAccountTitle.setVisibility(4);
    } else {
      this.a.this$0.mAccountTitle.setVisibility(8);
    }
    AssociatedAccountManageActivity.access$400(this.a.this$0);
    if (((this.a.this$0.mSubAccountList == null) || (this.a.this$0.mSubAccountList.size() == 0)) && ((this.a.this$0.mAccountList == null) || (this.a.this$0.mAccountList.size() == 0))) {
      this.a.this$0.onBackEvent();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.7.1
 * JD-Core Version:    0.7.0.1
 */