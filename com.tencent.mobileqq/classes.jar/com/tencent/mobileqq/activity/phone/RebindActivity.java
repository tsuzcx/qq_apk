package com.tencent.mobileqq.activity.phone;

import aiis;
import alpo;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import awdn;
import bdee;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

public class RebindActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  public int a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private awdn jdField_a_of_type_Awdn;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 != 0))
    {
      setResult(paramInt2);
      finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559427);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("cmd_param_is_from_uni", false);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("cmd_param_is_from_change_bind", false);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("k_country_code");
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("k_number");
    this.jdField_b_of_type_Int = getIntent().getIntExtra("kBindType", 0);
    setTitle(alpo.a(2131713522));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371729));
    paramBundle = this.jdField_b_of_type_JavaLangString + " " + this.jdField_a_of_type_JavaLangString;
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-31676);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(getResources().getString(2131695211, new Object[] { paramBundle, getIntent().getStringExtra("k_uin"), this.app.getCurrentAccountUin() }));
    localSpannableStringBuilder.setSpan(localForegroundColorSpan, 4, paramBundle.length() + 4, 33);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131371728));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131371727));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Awdn != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_Awdn);
      this.jdField_a_of_type_Awdn = null;
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      if (!bdee.d(this)) {
        b(2131694829);
      }
    }
    while (paramView != this.jdField_b_of_type_AndroidWidgetButton)
    {
      return;
      if (this.jdField_a_of_type_Awdn == null)
      {
        this.jdField_a_of_type_Awdn = new aiis(this);
        this.app.registObserver(this.jdField_a_of_type_Awdn);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
      a(2131719773, 1000L, true);
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.RebindActivity
 * JD-Core Version:    0.7.0.1
 */