package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tuz;
import tva;
import tvb;

public class RegisterSendUpSms
  extends RegisterNewBaseActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private Runnable jdField_a_of_type_JavaLangRunnable = new tva(this);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new tvb(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new tuz(this);
  private int b;
  private int jdField_c_of_type_Int = 10;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  private String f;
  private String g;
  
  public RegisterSendUpSms()
  {
    this.jdField_b_of_type_Int = 0;
  }
  
  private void a()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        Intent localIntent = new Intent(this, RegisterChooseLoginActivity.class);
        localIntent.putExtra("phonenum", this.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("key", this.jdField_b_of_type_JavaLangString);
        localIntent.putExtra("key_register_smscode", this.jdField_c_of_type_JavaLangString);
        localIntent.putExtra("key_register_binded_qq", this.e);
        localIntent.putExtra("key_register_binded_qq_nick", this.f);
        localIntent.putExtra("key_register_binded_qq_face_url", this.g);
        localIntent.putExtra("key_register_has_pwd", this.jdField_c_of_type_Boolean);
        startActivity(localIntent);
        return;
      }
      RegisterByNicknameAndPwdActivity.a(this.app, this, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, true, false, false);
      return;
    }
    RegisterPersonalInfoActivity.a(this.app, this, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, false, false);
  }
  
  private void b(String paramString)
  {
    int i = 0;
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_c_of_type_JavaLangString = paramString.getString("upmsg");
      Object localObject;
      if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
      {
        localObject = (TextView)super.findViewById(2131375000);
        if (localObject != null) {
          ((TextView)localObject).setText(this.jdField_c_of_type_JavaLangString);
        }
      }
      this.d = paramString.getString("upnum");
      if (!TextUtils.isEmpty(this.d))
      {
        paramString = (TextView)super.findViewById(2131375002);
        if (paramString != null)
        {
          localObject = new StringBuilder();
          int k = this.d.length() / 4;
          int j = 0;
          while (i < k)
          {
            ((StringBuilder)localObject).append(this.d.substring(j, j + 4));
            ((StringBuilder)localObject).append(" ");
            j += 4;
            i += 1;
          }
          ((StringBuilder)localObject).append(this.d.substring(j));
          paramString.setText(((StringBuilder)localObject).toString());
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130971531);
    c(2131434274);
    b();
    a(50);
    this.app.setHandler(RegisterSendUpSms.class, this.jdField_a_of_type_MqqOsMqqHandler);
    Intent localIntent = super.getIntent();
    if (localIntent != null)
    {
      this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("phonenum");
      this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("key");
      this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("key_register_is_phone_num_registered", false);
      this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("key_register_has_pwd", true);
      this.e = getIntent().getStringExtra("key_register_binded_qq");
    }
    this.jdField_c_of_type_JavaLangString = super.getString(2131434277);
    this.d = super.getString(2131434279);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131375003));
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    }
    paramBundle = "";
    if (localIntent != null) {
      paramBundle = localIntent.getStringExtra("key_register_prompt_info");
    }
    if (!TextUtils.isEmpty(paramBundle)) {
      b(paramBundle);
    }
    ReportController.a(this.app, "dc00898", "", "", "0X8007364", "0X8007364", 0, 0, "", "", "", "");
    if (!this.jdField_b_of_type_Boolean) {
      ReportController.a(this.app, "dc00898", "", "", "0X8007364", "0X8007364", 1, 0, "", "", "", "");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.e)) {
        ReportController.a(this.app, "dc00898", "", "", "0X8007364", "0X8007364", 3, 0, "", "", "", "");
      }
      return true;
      if (!this.jdField_c_of_type_Boolean) {
        ReportController.a(this.app, "dc00898", "", "", "0X8007364", "0X8007364", 2, 0, "", "", "", "");
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if ((this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_Int != 0))
    {
      AccountManager localAccountManager = (AccountManager)this.app.getManager(0);
      if (localAccountManager != null) {
        localAccountManager.queryUpSmsStat(this.jdField_a_of_type_MqqObserverAccountObserver);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setText("正在验证(" + this.jdField_c_of_type_Int + "s)");
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_b_of_type_Int == 0)
    {
      paramView = new Intent("android.intent.action.VIEW");
      paramView.setData(Uri.parse("smsto:"));
      paramView.setType("vnd.android-dir/mms-sms");
      paramView.putExtra("address", this.d);
      paramView.putExtra("sms_body", this.jdField_c_of_type_JavaLangString);
      super.startActivity(paramView);
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = 1;
    }
    while (this.jdField_b_of_type_Int != 1) {
      return;
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      a();
      return;
    }
    paramView = (AccountManager)this.app.getManager(0);
    if (paramView != null) {
      paramView.queryUpSmsStat(this.jdField_a_of_type_MqqObserverAccountObserver);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetButton.setText("正在验证(" + this.jdField_c_of_type_Int + "s)");
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.app.removeHandler(RegisterSendUpSms.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterSendUpSms
 * JD-Core Version:    0.7.0.1
 */