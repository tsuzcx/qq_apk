package com.tencent.mobileqq.activity;

import Override;
import adqx;
import aecu;
import aecv;
import aecw;
import aecx;
import aecy;
import aecz;
import amtj;
import amxq;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import azvp;
import bcef;
import bgpv;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.ConfigClearableEditText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class RegisterPhoneNumActivity
  extends RegisterNewBaseActivity
  implements TextWatcher, View.OnClickListener
{
  public adqx a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private azvp jdField_a_of_type_Azvp;
  private ConfigClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new aecv(this);
  private TextView b;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = true;
  private String jdField_d_of_type_JavaLangString = amtj.a(2131712455);
  private boolean jdField_d_of_type_Boolean;
  
  @TargetApi(11)
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364519));
    c(2131716075);
    b();
    a(33);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380016));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131716145) + getString(2131691002));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379998));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131716102) + getString(2131691002));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379971));
    this.jdField_c_of_type_AndroidWidgetTextView.setText("+" + this.jdField_b_of_type_JavaLangString);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    a(this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText = ((ConfigClearableEditText)findViewById(2131371968));
    this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.addTextChangedListener(this);
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363892));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void a(View paramView)
  {
    paramView.setOnTouchListener(new aecw(this));
  }
  
  private void a(EditText paramEditText)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramEditText.setCustomSelectionActionModeCallback(new aecx(this));
      return;
    }
    paramEditText.setOnCreateContextMenuListener(new aecy(this));
  }
  
  private static final boolean a(Context paramContext)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
        localPoint = new Point();
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        paramContext.getRealSize(localPoint);
        j = localPoint.y;
        if (j >= 1920) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramContext)
      {
        Point localPoint;
        int j;
        QLog.e("RegisterPhoneNumActivity", 2, "isNeedHideSoftkey", paramContext);
        boolean bool = false;
        continue;
        bool = false;
        continue;
      }
      i = j;
      if (QLog.isColorLevel()) {
        QLog.d("RegisterPhoneNumActivity", 2, "isNeedHideSoftkey, result=" + bool + ", mRealSizeHeight=" + i);
      }
      return bool;
      paramContext.getSize(localPoint);
    }
  }
  
  private boolean b()
  {
    int i = 0;
    try
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getText().toString();
      str = this.jdField_a_of_type_Azvp.a(str);
      if (str != null) {
        i = 1;
      }
      return 0x1 & i;
    }
    catch (Exception localException)
    {
      QLog.d("RegisterPhoneNumActivity", 1, new Object[] { "checkInputValid error : ", localException.getMessage() });
    }
    return true;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getText().toString();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidWidgetCheckBox != null) {
      return this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked();
    }
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(b());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      this.jdField_d_of_type_JavaLangString = paramIntent.getStringExtra("k_name");
      this.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("k_code");
      this.jdField_c_of_type_AndroidWidgetTextView.setText("+" + this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(b());
    }
    while ((paramInt1 != 2) || (paramInt2 != -1)) {
      return;
    }
    this.jdField_a_of_type_Azvp.a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (a(this)) {
      getWindow().setSoftInputMode(2);
    }
    super.doOnCreate(paramBundle);
    setContentView(2131561822);
    if (this.app == null)
    {
      paramBundle = getAppRuntime();
      if ((paramBundle != null) && ((paramBundle instanceof QQAppInterface))) {
        this.app = ((QQAppInterface)paramBundle);
      }
    }
    if (this.app == null)
    {
      QLog.d("RegisterPhoneNumActivity", 1, "doOnCreate app == null");
      finish();
      return true;
    }
    if (QLog.isDevelopLevel()) {
      bgpv.a(getClass().getSimpleName(), getIntent());
    }
    this.jdField_a_of_type_Azvp = new azvp(this);
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Azvp.a(getApplicationContext());
    a();
    bcef.b(this.app, "CliOper", "", "", "0X8006650", "0X8006650", 0, 0, "", "", "", "");
    bcef.a(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 0, 0, "", "", "", "");
    bcef.a(this.app, "dc00898", "", "", "0X8007360", "0X8007360", getIntent().getIntExtra("key_report_extra_from", 0), 0, "", "", "", "");
    if (this.jdField_a_of_type_Int == -1) {
      bcef.a(this.app, "new_reg_805", "reg_page", "page_exp", "", 1, "", "4", "", "", "", "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_Adqx = new adqx();
      paramBundle = new aecu(this);
      this.jdField_a_of_type_Adqx.a(paramBundle);
      return true;
      bcef.a(this.app, "new_reg_805", "reg_page", "page_exp", "", 1, "", Integer.toString(this.jdField_a_of_type_Int), "", "", "", "", "", "", "");
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Azvp.a();
    this.app.removeHandler(getClass());
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText);
    }
    this.jdField_a_of_type_AndroidWidgetButton.clearAnimation();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(b());
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = new Intent(this, NewStyleCountryActivity.class);
      ((Intent)localObject).putExtra("k_code", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject).putExtra("k_name", this.jdField_d_of_type_JavaLangString);
      startActivityForResult((Intent)localObject, 1);
      continue;
      bcef.b(this.app, "CliOper", "", "", "0X8006651", "0X8006651", 0, 0, "", "", "", "");
      bcef.a(this.app, "dc00898", "", "", "0X8007CC7", "0X8007CC7", 0, 0, "", "", "", "");
      localObject = this.app;
      if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_d_of_type_JavaLangString.equals(getString(2131716056)))) {}
      for (i = 1;; i = 2)
      {
        bcef.a((QQAppInterface)localObject, "dc00898", "", "", "0X8007CC7", "0X8007CC7", i, 0, "", "", "", "");
        bcef.a(this.app, "new_reg_805", "reg_page", "next_clk", "", 1, "", "", "", "", "", "", "", "", "");
        if (a()) {
          break label314;
        }
        a(2131690737, 0);
        break;
      }
      label314:
      if (this.jdField_d_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Adqx.a(this, false)) {
          this.jdField_a_of_type_Azvp.b();
        }
      }
      else
      {
        localObject = new aecz(this, this);
        amxq.a(this, "", (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject).show();
        continue;
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RegisterPhoneNumActivity.7(this), 1000L);
          for (;;)
          {
            try
            {
              if (paramView.getId() != 2131380016) {
                continue;
              }
              localObject = "https://ti.qq.com/agreement/index.html";
              startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)localObject)));
            }
            catch (Exception localException)
            {
              QLog.d("RegisterPhoneNumActivity", 1, "no system browser exp=", localException);
              continue;
            }
            if (i != 2131380016) {
              break label507;
            }
            bcef.a(this.app, "new_reg_805", "reg_page", "terms_clk", "", 1, "", "", "", "", "", "", "", "", "");
            break;
            localObject = "https://ti.qq.com/agreement/privacy/index.html";
          }
          label507:
          if (i == 2131379998) {
            bcef.a(this.app, "new_reg_805", "reg_page", "privacy_clk", "", 1, "", "", "", "", "", "", "", "", "");
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */