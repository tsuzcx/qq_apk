package com.tencent.mobileqq.activity.contact.addcontact;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ClassificationSearchActivity$7
  implements TextView.OnEditorActionListener
{
  ClassificationSearchActivity$7(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt != 3)
    {
      bool1 = bool2;
      if (paramKeyEvent != null)
      {
        bool1 = bool2;
        if (paramKeyEvent.getKeyCode() != 66) {}
      }
    }
    else
    {
      String str = this.a.K.getText().toString();
      if (!TextUtils.isEmpty(str))
      {
        if ((this.a.q == ClassificationSearchActivity.k) && (!TextUtils.isEmpty(str.trim())))
        {
          this.a.a(str);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "dc00899", "Pb_account_lifeservice", "", "0X80067C4", "0X80067C4", 0, 0, "", "", str, "", true);
          ClassificationSearchActivity.a(this.a, str);
        }
        else if (this.a.q == ClassificationSearchActivity.n)
        {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800742D", "0X800742D", 0, 0, str, "", "", "");
          ClassificationSearchActivity.a(this.a, str);
        }
        else
        {
          this.a.M.a(str, false);
        }
      }
      else if (this.a.q == ClassificationSearchActivity.k)
      {
        str = this.a.K.getHint().toString();
        if ((!TextUtils.isEmpty(str.trim())) && (!TextUtils.equals(str, HardCodeUtil.a(2131900126))) && (!TextUtils.equals(str, HardCodeUtil.a(2131900141))))
        {
          this.a.a(str);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "dc00899", "Pb_account_lifeservice", "", "0X80067C4", "0X80067C4", 0, 0, "", "", str, "", true);
          ClassificationSearchActivity.a(this.a, str);
        }
      }
      bool1 = true;
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.7
 * JD-Core Version:    0.7.0.1
 */