package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager.PhoneUnityData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class PhoneUnityBindInfoActivity$9
  implements ActionSheet.OnButtonClickListener
{
  PhoneUnityBindInfoActivity$9(PhoneUnityBindInfoActivity paramPhoneUnityBindInfoActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    paramView = paramView.getContext();
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        this.b.mCloseThisActivity = true;
        this.a.dismiss();
        this.b.finish();
        return;
      }
      if (!NetworkUtil.isNetSupport(paramView))
      {
        PhoneUnityBindInfoActivity.access$1700(this.b, 2131892157);
        return;
      }
      PhoneUnityBindInfoActivity.access$002(this.b, 2);
      paramView = this.b;
      PhoneUnityBindInfoActivity.access$1800(paramView, PhoneUnityBindInfoActivity.access$800(paramView).g);
      this.a.dismiss();
      ReportController.b(this.b.app, "dc00898", "", "", "0X800B325", "0X800B325", 0, 0, "", "", "", "");
      this.b.mCloseThisActivity = false;
      return;
    }
    if (!NetworkUtil.isNetSupport(this.b))
    {
      paramView = this.b;
      QQToast.makeText(paramView, paramView.getString(2131889169), 0).show(this.b.getTitleBarHeight());
    }
    else
    {
      this.a.dismiss();
      PhoneUnityBindInfoActivity.access$1600(this.b, 2131916272, 0L, true);
      paramView = this.b;
      paramView.mUnBindedNum = 2;
      PhoneUnityBindInfoActivity.access$1002(paramView, true);
      if (PhoneUnityBindInfoActivity.access$800(this.b).c)
      {
        QLog.i("PhoneUnityBindInfoActivity", 1, "phone_unity_info, unBindContactsMobile");
        this.b.unBindContactsMobile();
      }
      else
      {
        PhoneUnityBindInfoActivity.access$900(this.b);
        this.b.resetContactSwitch(false);
      }
      if (PhoneUnityBindInfoActivity.access$800(this.b).a)
      {
        QLog.i("PhoneUnityBindInfoActivity", 1, "phone_unity_info, unbindPhoneNumLoginOnPhoneUnity");
        this.b.unbindPhoneNumLoginOnPhoneUnity();
      }
      else
      {
        PhoneUnityBindInfoActivity.access$900(this.b);
        this.b.resetLoginSwitch(false);
      }
      PhoneUnityBindInfoActivity.access$1200(this.b);
      this.b.mCloseThisActivity = false;
    }
    ReportController.b(this.b.app, "dc00898", "", "", "0X800B323", "0X800B323", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity.9
 * JD-Core Version:    0.7.0.1
 */