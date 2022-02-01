package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

class RecentLoginDevActivity$3
  implements ActionSheet.OnButtonClickListener
{
  RecentLoginDevActivity$3(RecentLoginDevActivity paramRecentLoginDevActivity, String paramString, ArrayList paramArrayList, int paramInt) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if (!NetworkUtil.isNetSupport(this.d))
      {
        paramView = this.d;
        QQToast.makeText(paramView, paramView.getString(2131889169), 0).show(this.d.getTitleBarHeight());
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.RecentLoginDevActivity", 2, "OnClick begin to delHistoryDev");
        }
        if (EquipmentLockImpl.a().a(this.d.app, this.a, this.b, this.c)) {
          RecentLoginDevActivity.b(this.d);
        } else if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.RecentLoginDevActivity", 2, "showDelDevActionSheet.OnClick delHistoryDev failed");
        }
      }
    }
    if ((RecentLoginDevActivity.c(this.d) != null) && (RecentLoginDevActivity.c(this.d).isShowing()) && (!this.d.isFinishing()))
    {
      RecentLoginDevActivity.c(this.d).dismiss();
      RecentLoginDevActivity.c(this.d).cancel();
      RecentLoginDevActivity.a(this.d, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecentLoginDevActivity.3
 * JD-Core Version:    0.7.0.1
 */