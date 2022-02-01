package com.tencent.mobileqq.activity.contact.addcontact;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class ClassificationSearchActivity$7
  implements TextView.OnEditorActionListener
{
  ClassificationSearchActivity$7(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 3) && ((paramKeyEvent == null) || (paramKeyEvent.getKeyCode() != 66))) {
      return false;
    }
    paramTextView = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (!TextUtils.isEmpty(paramTextView))
    {
      if ((this.a.f == ClassificationSearchActivity.jdField_a_of_type_Int) && (!TextUtils.isEmpty(paramTextView.trim())))
      {
        this.a.a(paramTextView);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "dc00899", "Pb_account_lifeservice", "", "0X80067C4", "0X80067C4", 0, 0, "", "", paramTextView, "", true);
        ClassificationSearchActivity.a(this.a, paramTextView);
      }
      else if (this.a.f == ClassificationSearchActivity.d)
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800742D", "0X800742D", 0, 0, paramTextView, "", "", "");
        ClassificationSearchActivity.a(this.a, paramTextView);
      }
      else
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(paramTextView, false);
      }
    }
    else if (this.a.f == ClassificationSearchActivity.jdField_a_of_type_Int)
    {
      paramTextView = this.a.jdField_a_of_type_AndroidWidgetEditText.getHint().toString();
      if ((!TextUtils.isEmpty(paramTextView.trim())) && (!TextUtils.equals(paramTextView, HardCodeUtil.a(2131702118))) && (!TextUtils.equals(paramTextView, HardCodeUtil.a(2131702133))))
      {
        this.a.a(paramTextView);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "dc00899", "Pb_account_lifeservice", "", "0X80067C4", "0X80067C4", 0, 0, "", "", paramTextView, "", true);
        ClassificationSearchActivity.a(this.a, paramTextView);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.7
 * JD-Core Version:    0.7.0.1
 */