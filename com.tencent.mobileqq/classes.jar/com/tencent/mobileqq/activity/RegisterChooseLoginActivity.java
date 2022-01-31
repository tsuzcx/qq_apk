package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import ttz;
import tua;
import tub;
import tuc;

public class RegisterChooseLoginActivity
  extends RegisterNewBaseActivity
  implements View.OnClickListener
{
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new tuc(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new ttz(this);
  public boolean a;
  private String c;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      super.setTitle(2131434233);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    super.setTitle(2131434232);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }
  
  private void d()
  {
    DialogUtil.a(this, 0, null, super.getResources().getString(2131434316, new Object[] { "+" + this.jdField_b_of_type_JavaLangString + " " + this.jdField_a_of_type_JavaLangString }), super.getResources().getString(2131434317), super.getResources().getString(2131434318), null, new tua(this), new tub(this)).show();
  }
  
  private void e()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    c(2131434344);
    b();
    a(65);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131372228));
    Object localObject1 = (ImageView)super.findViewById(2131372232);
    Object localObject2 = super.getIntent().getStringExtra("key_register_binded_qq_face_url");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    for (;;)
    {
      try
      {
        int i = AIOUtils.a(70.0F, super.getResources());
        int j = AIOUtils.a(70.0F, super.getResources());
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = j;
        localURLDrawableOptions.mLoadingDrawable = super.getResources().getDrawable(2130839147);
        localURLDrawableOptions.mFailedDrawable = super.getResources().getDrawable(2130839319);
        localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
        ((URLDrawable)localObject2).setTag(URLDrawableDecodeHandler.a(i, j));
        ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.a);
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
        localObject1 = (TextView)super.findViewById(2131372233);
        localObject2 = super.getIntent().getStringExtra("key_register_binded_qq_nick");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label259;
        }
        ((TextView)localObject1).setText((CharSequence)localObject2);
        ((TextView)super.findViewById(2131372234)).setText(this.jdField_e_of_type_JavaLangString);
        ((Button)super.findViewById(2131372236)).setOnClickListener(this);
        ((Button)super.findViewById(2131372239)).setOnClickListener(this);
        b(false);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      localException.setImageResource(2130839319);
      continue;
      label259:
      localException.setVisibility(8);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130970941);
    this.jdField_c_of_type_JavaLangString = super.getIntent().getStringExtra("key_register_smscode");
    if (this.jdField_c_of_type_JavaLangString == null) {
      this.jdField_c_of_type_JavaLangString = "";
    }
    this.jdField_a_of_type_JavaLangString = super.getIntent().getStringExtra("phonenum");
    this.jdField_b_of_type_JavaLangString = super.getIntent().getStringExtra("key");
    this.jdField_d_of_type_JavaLangString = super.getIntent().getStringExtra("key_register_binded_qq");
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      int i = this.jdField_d_of_type_JavaLangString.length();
      this.jdField_e_of_type_JavaLangString = (this.jdField_d_of_type_JavaLangString.substring(0, 2) + "****" + this.jdField_d_of_type_JavaLangString.substring(i - 2, i));
    }
    this.jdField_e_of_type_Boolean = super.getIntent().getBooleanExtra("key_register_chose_bind_phone", false);
    this.jdField_c_of_type_Boolean = super.getIntent().getBooleanExtra("key_register_has_pwd", true);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)super.getSystemService("input_method"));
    this.jdField_b_of_type_Boolean = true;
    a();
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    ReportController.a(this.app, "dc00898", "", "", "0X8007363", "0X8007363", 0, 0, "", "", "", "");
    if (!this.jdField_c_of_type_Boolean) {
      ReportController.a(this.app, "dc00898", "", "", "0X8007363", "0X8007363", 1, 0, "", "", "", "");
    }
    if (!this.jdField_e_of_type_Boolean) {
      ReportController.a(this.app, "dc00898", "", "", "0X8007363", "0X8007363", 2, 0, "", "", "", "");
    }
    for (;;)
    {
      return true;
      ReportController.a(this.app, "dc00898", "", "", "0X8007363", "0X8007363", 3, 0, "", "", "", "");
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_RegisterNewQQActivity", 2, "onAccountChanged success");
    }
    this.app = ((QQAppInterface)getAppRuntime());
    LoginActivity.a(this.app, this.app.getAccount());
    Object localObject = new Intent(this, SplashActivity.class);
    ((Intent)localObject).putExtra("tab_index", MainFragment.a);
    ((Intent)localObject).addFlags(67108864);
    startActivity((Intent)localObject);
    super.finish();
    localObject = this.app.getHandler(LoginActivity.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(20140325);
    }
    e();
  }
  
  protected boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Boolean) {
      b(false);
    }
    for (;;)
    {
      return true;
      MqqHandler localMqqHandler = this.app.getHandler(RegisterVerifyCodeActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(108);
      }
      super.finish();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131372237: 
    case 2131372238: 
    default: 
      return;
    case 2131372236: 
      paramView = new Intent(this, LoginActivity.class);
      paramView.putExtra("from_register_choose", true);
      paramView.putExtra("uin", this.jdField_d_of_type_JavaLangString);
      paramView.putExtra("hasPwd", this.jdField_c_of_type_Boolean);
      startActivity(paramView);
      return;
    }
    if ((!this.jdField_c_of_type_Boolean) || (!this.jdField_e_of_type_Boolean))
    {
      RegisterByNicknameAndPwdActivity.a(this.app, this, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, true, this.jdField_c_of_type_Boolean, false);
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterChooseLoginActivity
 * JD-Core Version:    0.7.0.1
 */