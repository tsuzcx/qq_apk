package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

class BindNumberFromPcActivity$1
  extends ContactBindObserver
{
  BindNumberFromPcActivity$1(BindNumberFromPcActivity paramBindNumberFromPcActivity) {}
  
  public void onBindMobile(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.a.b();
    int i;
    if (paramBoolean)
    {
      i = paramBundle.getInt("k_result");
      if ((i == 104) || (i == 0))
      {
        paramBundle = new Intent(this.a, BindVerifyActivity.class);
        paramBundle.putExtra("k_number", this.a.jdField_a_of_type_JavaLangString);
        paramBundle.putExtra("k_country_code", this.a.b);
        if ((paramBundle != null) && (!this.a.isFinishing()))
        {
          paramBundle.addFlags(536870912);
          this.a.startActivityForResult(paramBundle, 1);
        }
      }
    }
    for (;;)
    {
      this.a.app.unRegistObserver(BindNumberFromPcActivity.a(this.a));
      BindNumberFromPcActivity.a(this.a, null);
      return;
      if (i == 107)
      {
        Intent localIntent = new Intent(this.a, RebindActivity.class);
        localIntent.putExtra("k_uin", paramBundle.getString("k_uin"));
        localIntent.putExtra("k_number", this.a.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("k_country_code", this.a.b);
        paramBundle = localIntent;
        break;
      }
      if (i == 106)
      {
        this.a.setResult(-1);
        this.a.finish();
        paramBundle = null;
        break;
      }
      this.a.a(getBindErrorMessage(i));
      paramBundle = null;
      break;
      this.a.a(2131718550);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberFromPcActivity.1
 * JD-Core Version:    0.7.0.1
 */