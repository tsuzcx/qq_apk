package com.tencent.mobileqq.activity.phone;

import Override;
import SecurityAccountServer.RespondQueryQQBindingStat;
import akhk;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import anvx;
import azip;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BindNumberFromPcActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  public Button a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private azip jdField_a_of_type_Azip;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private azip jdField_b_of_type_Azip;
  public String b;
  private String c;
  
  private void a()
  {
    setTitle(anvx.a(2131700630));
    if (this.jdField_a_of_type_Boolean) {
      setLeftButton(2131690845, null);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372601));
    int i = this.jdField_a_of_type_JavaLangString.length();
    String str = this.jdField_a_of_type_JavaLangString.substring(0, i - 5) + "****" + this.jdField_a_of_type_JavaLangString.substring(i - 1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString + " " + str);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372600));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131694546, new Object[] { this.c }));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131372599));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131372598));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void b()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      a(2131694305);
      return;
    }
    if (this.jdField_a_of_type_Azip == null)
    {
      this.jdField_a_of_type_Azip = new akhk(this);
      this.app.registObserver(this.jdField_a_of_type_Azip);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    a(2131718527, 1000L, true);
  }
  
  private void c()
  {
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    localIntent.putExtra("key_change_number", true);
    startActivityForResult(localIntent, 1);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_Boolean) {
      overridePendingTransition(2130771990, 2130772301);
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
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b();
      continue;
      c();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131559586);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.d();
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a();
    if ((i != 5) || (paramBundle == null))
    {
      a(anvx.a(2131700629), anvx.a(2131700632));
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
    if (this.jdField_a_of_type_Azip != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_Azip);
      this.jdField_a_of_type_Azip = null;
    }
    if (this.jdField_b_of_type_Azip != null)
    {
      this.app.unRegistObserver(this.jdField_b_of_type_Azip);
      this.jdField_b_of_type_Azip = null;
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberFromPcActivity
 * JD-Core Version:    0.7.0.1
 */