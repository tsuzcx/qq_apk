package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import aihd;
import alpo;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import awdn;
import bdee;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BindNumberFromPcActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  public Button a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private awdn jdField_a_of_type_Awdn;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private awdn jdField_b_of_type_Awdn;
  public String b;
  private String c;
  
  private void a()
  {
    setTitle(alpo.a(2131701501));
    if (this.jdField_a_of_type_Boolean) {
      setLeftButton(2131690884, null);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371733));
    int i = this.jdField_a_of_type_JavaLangString.length();
    String str = this.jdField_a_of_type_JavaLangString.substring(0, i - 5) + "****" + this.jdField_a_of_type_JavaLangString.substring(i - 1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString + " " + str);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371732));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131695161, new Object[] { this.c }));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131371731));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131371730));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void b()
  {
    if (!bdee.d(this))
    {
      b(2131694829);
      return;
    }
    if (this.jdField_a_of_type_Awdn == null)
    {
      this.jdField_a_of_type_Awdn = new aihd(this);
      this.app.registObserver(this.jdField_a_of_type_Awdn);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    a(2131719773, 1000L, true);
  }
  
  private void c()
  {
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    localIntent.putExtra("key_change_number", true);
    startActivityForResult(localIntent, 1);
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_Boolean) {
      overridePendingTransition(2130771990, 2130772294);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 != 0))
    {
      setResult(paramInt2);
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131371731: 
      b();
      return;
    }
    c();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131559417);
    int i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
    if ((i != 5) || (paramBundle == null))
    {
      a(alpo.a(2131701500), alpo.a(2131701503));
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramBundle.nationCode;
    this.jdField_a_of_type_JavaLangString = paramBundle.mobileNo;
    this.c = new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramBundle.bindingTime * 1000L));
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_is_first_activity", true);
    a();
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Awdn != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_Awdn);
      this.jdField_a_of_type_Awdn = null;
    }
    if (this.jdField_b_of_type_Awdn != null)
    {
      this.app.unRegistObserver(this.jdField_b_of_type_Awdn);
      this.jdField_b_of_type_Awdn = null;
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberFromPcActivity
 * JD-Core Version:    0.7.0.1
 */