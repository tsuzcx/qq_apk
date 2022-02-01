package com.tencent.mobileqq.activity.phone;

import Override;
import akpm;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import anzj;
import azov;
import bhnv;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class RebindActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  public int a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private azov jdField_a_of_type_Azov;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
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
    setContentView(2131559560);
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("cmd_param_is_from_uni", false);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("cmd_param_is_from_change_bind", false);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("k_country_code");
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("k_number");
    this.jdField_b_of_type_Int = getIntent().getIntExtra("kBindType", 0);
    setTitle(anzj.a(2131712022));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372436));
    paramBundle = this.jdField_b_of_type_JavaLangString + " " + this.jdField_a_of_type_JavaLangString;
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(-31676);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(getResources().getString(2131694288, new Object[] { paramBundle, getIntent().getStringExtra("k_uin"), this.app.getCurrentAccountUin() }));
    localSpannableStringBuilder.setSpan(localForegroundColorSpan, 4, paramBundle.length() + 4, 33);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableStringBuilder);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131372435));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131372434));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Azov != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_Azov);
      this.jdField_a_of_type_Azov = null;
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      if (!bhnv.d(this)) {
        a(2131694008);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Azov == null)
      {
        this.jdField_a_of_type_Azov = new akpm(this);
        this.app.registObserver(this.jdField_a_of_type_Azov);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean);
      a(2131717902, 1000L, true);
      continue;
      if (paramView == this.jdField_b_of_type_AndroidWidgetButton) {
        finish();
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.RebindActivity
 * JD-Core Version:    0.7.0.1
 */