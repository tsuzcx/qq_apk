package com.tencent.mobileqq.activity;

import abmn;
import abyw;
import abyx;
import abyy;
import abyz;
import abza;
import abzb;
import ajyc;
import akcz;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import avpw;
import axqw;
import bbgg;
import bbxx;
import com.tencent.mobileqq.activity.phone.NewStyleCountryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.ConfigClearableEditText;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class RegisterPhoneNumActivity
  extends RegisterNewBaseActivity
  implements TextWatcher, View.OnClickListener, Animation.AnimationListener, CompoundButton.OnCheckedChangeListener
{
  public abmn a;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private avpw jdField_a_of_type_Avpw;
  private ConfigClearableEditText jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new abyx(this);
  private boolean jdField_a_of_type_Boolean = true;
  private View jdField_b_of_type_AndroidViewView;
  private CheckBox jdField_b_of_type_AndroidWidgetCheckBox;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ConfigClearableEditText jdField_b_of_type_ComTencentMobileqqWidgetConfigClearableEditText;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString = ajyc.a(2131713340);
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  @TargetApi(11)
  private void a()
  {
    this.jdField_b_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364185));
    this.jdField_b_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
    c(2131717080);
    b();
    a(33);
    String str = getIntent().getStringExtra("invite_code");
    if (!TextUtils.isEmpty(str)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378505));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131717178) + getString(2131691105));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378489));
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131717119) + getString(2131691105));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378456));
      this.jdField_c_of_type_AndroidWidgetTextView.setText("+" + this.jdField_b_of_type_JavaLangString);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      a(this.jdField_c_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidViewView = findViewById(2131368976);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView = findViewById(2131375884);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131363981));
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131368975);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      a(this.jdField_c_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText = ((ConfigClearableEditText)findViewById(2131370993));
      this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.addTextChangedListener(this);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText);
      this.jdField_b_of_type_ComTencentMobileqqWidgetConfigClearableEditText = ((ConfigClearableEditText)findViewById(2131370989));
      this.jdField_b_of_type_ComTencentMobileqqWidgetConfigClearableEditText.addTextChangedListener(this);
      if (!TextUtils.isEmpty(str)) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetConfigClearableEditText.setText(str);
      }
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363592));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.post(new RegisterPhoneNumActivity.3(this, bool));
      return;
    }
  }
  
  private void a(View paramView)
  {
    paramView.setOnTouchListener(new abyy(this));
  }
  
  private void a(EditText paramEditText)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramEditText.setCustomSelectionActionModeCallback(new abyz(this));
      return;
    }
    paramEditText.setOnCreateContextMenuListener(new abza(this));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_d_of_type_Boolean == paramBoolean1) {
      return;
    }
    this.jdField_d_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean1);
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.jdField_b_of_type_AndroidViewView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetButton.clearAnimation();
    this.jdField_c_of_type_AndroidViewView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(b());
    if (paramBoolean1)
    {
      localObject = new TranslateAnimation(0.0F, 0.0F, -getResources().getDimension(2131298333), 0.0F);
      ((Animation)localObject).setDuration(200L);
      ((Animation)localObject).setInterpolator(new LinearInterpolator());
      localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setInterpolator(new AccelerateInterpolator());
      localAlphaAnimation.setDuration(200L);
      localAnimationSet = new AnimationSet(false);
      localAnimationSet.addAnimation((Animation)localObject);
      localAnimationSet.addAnimation(localAlphaAnimation);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
      this.jdField_b_of_type_AndroidViewView.startAnimation(localAnimationSet);
      this.jdField_a_of_type_AndroidWidgetButton.startAnimation((Animation)localObject);
      this.jdField_c_of_type_AndroidViewView.startAnimation((Animation)localObject);
      if (paramBoolean2)
      {
        localObject = getIntent().getStringExtra("invite_code");
        this.jdField_b_of_type_ComTencentMobileqqWidgetConfigClearableEditText.setText((CharSequence)localObject);
      }
      for (;;)
      {
        ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.jdField_b_of_type_ComTencentMobileqqWidgetConfigClearableEditText, 0);
        return;
        this.jdField_b_of_type_ComTencentMobileqqWidgetConfigClearableEditText.setText("");
        this.jdField_b_of_type_ComTencentMobileqqWidgetConfigClearableEditText.requestFocus();
      }
    }
    Object localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -getResources().getDimension(2131298333));
    ((Animation)localObject).setDuration(200L);
    ((Animation)localObject).setInterpolator(new LinearInterpolator());
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
    localAlphaAnimation.setDuration(200L);
    AnimationSet localAnimationSet = new AnimationSet(false);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.addAnimation(localAlphaAnimation);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
    this.jdField_b_of_type_AndroidViewView.startAnimation(localAnimationSet);
    this.jdField_a_of_type_AndroidWidgetButton.startAnimation((Animation)localObject);
    this.jdField_c_of_type_AndroidViewView.startAnimation((Animation)localObject);
    localAnimationSet.setAnimationListener(this);
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
    int j = 0;
    boolean bool1;
    for (;;)
    {
      try
      {
        str = this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getText().toString();
        str = this.jdField_a_of_type_Avpw.a(str);
        if (str != null)
        {
          i = 1;
          bool1 = i & 0x1;
        }
      }
      catch (Exception localException1)
      {
        String str;
        int i;
        return true;
      }
      try
      {
        str = this.jdField_b_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getText().toString();
        if (this.jdField_d_of_type_Boolean)
        {
          i = j;
          if (this.jdField_d_of_type_Boolean)
          {
            boolean bool2 = TextUtils.isEmpty(str);
            i = j;
            if (bool2) {}
          }
        }
        else
        {
          i = 1;
        }
        return i & bool1;
      }
      catch (Exception localException2) {}
      i = 0;
    }
    return bool1;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getText().toString();
  }
  
  public boolean a()
  {
    if (this.jdField_b_of_type_AndroidWidgetCheckBox != null) {
      return this.jdField_b_of_type_AndroidWidgetCheckBox.isChecked();
    }
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(b());
    }
  }
  
  public String b()
  {
    if (this.jdField_d_of_type_Boolean) {
      return this.jdField_b_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getText().toString();
    }
    return "";
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
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
    this.jdField_a_of_type_Avpw.a(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (a(this)) {
      getWindow().setSoftInputMode(2);
    }
    super.doOnCreate(paramBundle);
    setContentView(2131561460);
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
      bbxx.a(getClass().getSimpleName(), getIntent());
    }
    this.jdField_a_of_type_Avpw = new avpw(this);
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_Avpw.a(getApplicationContext());
    a();
    axqw.b(this.app, "CliOper", "", "", "0X8006650", "0X8006650", 0, 0, "", "", "", "");
    axqw.a(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 0, 0, "", "", "", "");
    axqw.a(this.app, "dc00898", "", "", "0X8007360", "0X8007360", getIntent().getIntExtra("key_report_extra_from", 0), 0, "", "", "", "");
    if (this.jdField_b_of_type_Int == -1) {
      axqw.a(this.app, "new_reg_805", "reg_page", "page_exp", "", 1, "", "4", "", "", "", "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_Abmn = new abmn();
      paramBundle = new abyw(this);
      this.jdField_a_of_type_Abmn.a(paramBundle);
      return true;
      axqw.a(this.app, "new_reg_805", "reg_page", "page_exp", "", 1, "", Integer.toString(this.jdField_b_of_type_Int), "", "", "", "", "", "", "");
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Avpw.a();
    this.app.removeHandler(getClass());
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText.getParent();
    if (localViewGroup != null) {
      localViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetConfigClearableEditText);
    }
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.jdField_b_of_type_AndroidViewView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetButton.clearAnimation();
    this.jdField_c_of_type_AndroidViewView.clearAnimation();
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
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.i("RegisterPhoneNumActivity", 2, "RegisterPhoneNumActivity onAnimationEnd");
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.getId() == 2131364185) {
      return;
    }
    if (paramBoolean != this.jdField_d_of_type_Boolean) {
      axqw.b(this.app, "dc00898", "", "", "0X8009700", "0X8009700", 0, 0, "", "", "", "");
    }
    a(paramBoolean, false);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    switch (paramView.getId())
    {
    default: 
    case 2131378456: 
    case 2131363592: 
    case 2131378489: 
    case 2131378505: 
      label358:
      label363:
      do
      {
        do
        {
          do
          {
            return;
            paramView = new Intent(this, NewStyleCountryActivity.class);
            paramView.putExtra("k_code", this.jdField_b_of_type_JavaLangString);
            paramView.putExtra("k_name", this.jdField_d_of_type_JavaLangString);
            startActivityForResult(paramView, 1);
            return;
            axqw.b(this.app, "CliOper", "", "", "0X8006651", "0X8006651", 0, 0, "", "", "", "");
            axqw.a(this.app, "dc00898", "", "", "0X8007CC7", "0X8007CC7", 0, 0, "", "", "", "");
            paramView = this.app;
            if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_d_of_type_JavaLangString.equals(getString(2131717060))))
            {
              i = 1;
              axqw.a(paramView, "dc00898", "", "", "0X8007CC7", "0X8007CC7", i, 0, "", "", "", "");
              paramView = this.app;
              if (!this.jdField_d_of_type_Boolean) {
                break label358;
              }
            }
            for (i = 1;; i = 2)
            {
              axqw.b(paramView, "dc00898", "", "", "0X8009701", "0X8009701", i, 0, "", "", "", "");
              axqw.a(this.app, "new_reg_805", "reg_page", "next_clk", "", 1, "", "", "", "", "", "", "", "", "");
              if (a()) {
                break label363;
              }
              a(2131690785, 0);
              return;
              i = 2;
              break;
            }
            if (!this.e) {
              break;
            }
          } while (!this.jdField_a_of_type_Abmn.a(this, false));
          this.jdField_a_of_type_Avpw.b();
          return;
          paramView = new abzb(this, this);
          akcz.a(this, "", paramView, paramView).show();
          return;
        } while (!this.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new RegisterPhoneNumActivity.8(this), 1000L);
        for (;;)
        {
          try
          {
            if (paramView.getId() != 2131378505) {
              continue;
            }
            paramView = "https://ti.qq.com/agreement/index.html";
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramView)));
          }
          catch (Exception paramView)
          {
            QLog.d("RegisterPhoneNumActivity", 1, "no system browser exp=", paramView);
            continue;
          }
          if (i != 2131378505) {
            break label551;
          }
          axqw.a(this.app, "new_reg_805", "reg_page", "terms_clk", "", 1, "", "", "", "", "", "", "", "", "");
          return;
          paramView = "https://ti.qq.com/agreement/privacy/index.html";
        }
      } while (i != 2131378489);
      label551:
      axqw.a(this.app, "new_reg_805", "reg_page", "privacy_clk", "", 1, "", "", "", "", "", "", "", "", "");
      return;
    }
    paramView = this.jdField_a_of_type_AndroidWidgetCheckBox;
    if (!this.jdField_d_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      return;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPhoneNumActivity
 * JD-Core Version:    0.7.0.1
 */