package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;

class BindNumberFromPcActivity$1
  extends ContactBindObserver
{
  BindNumberFromPcActivity$1(BindNumberFromPcActivity paramBindNumberFromPcActivity) {}
  
  protected void onBindMobile(boolean paramBoolean, Bundle paramBundle)
  {
    this.a.a.setEnabled(true);
    this.a.dismissProgressDialog();
    if (paramBoolean)
    {
      int i = paramBundle.getInt("k_result");
      if ((i != 104) && (i != 0))
      {
        if (i == 107)
        {
          Intent localIntent = new Intent(this.a, RebindActivity.class);
          localIntent.putExtra("k_uin", paramBundle.getString("k_uin"));
          localIntent.putExtra("k_number", this.a.b);
          localIntent.putExtra("k_country_code", this.a.c);
          paramBundle = localIntent;
        }
        else
        {
          if (i == 106)
          {
            this.a.setResult(-1);
            this.a.finish();
          }
          else
          {
            this.a.showToast(getBindErrorMessage(i));
          }
          paramBundle = null;
        }
      }
      else
      {
        paramBundle = new Intent(this.a, BindVerifyActivity.class);
        paramBundle.putExtra("k_number", this.a.b);
        paramBundle.putExtra("k_country_code", this.a.c);
      }
      if ((paramBundle != null) && (!this.a.isFinishing()))
      {
        paramBundle.addFlags(536870912);
        this.a.startActivityForResult(paramBundle, 1);
      }
    }
    else
    {
      this.a.showToast(2131915700);
    }
    this.a.app.unRegistObserver(BindNumberFromPcActivity.a(this.a));
    BindNumberFromPcActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberFromPcActivity.1
 * JD-Core Version:    0.7.0.1
 */