package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BindNumberFromPcActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver;
  String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ContactBindObserver jdField_b_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver;
  String jdField_b_of_type_JavaLangString;
  private String c;
  
  private void a()
  {
    setTitle(HardCodeUtil.a(2131701349));
    if (this.jdField_a_of_type_Boolean) {
      setLeftButton(2131690874, null);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372501));
    int i = this.jdField_a_of_type_JavaLangString.length();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString.substring(0, i - 5));
    ((StringBuilder)localObject).append("****");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString.substring(i - 1));
    localObject = ((StringBuilder)localObject).toString();
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(" ");
    localStringBuilder.append((String)localObject);
    localTextView.setText(localStringBuilder.toString());
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372500));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131694749, new Object[] { this.c }));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131372499));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131372498));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void b()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      showToast(2131694475);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = new BindNumberFromPcActivity.1(this);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.mPhoneContactService.sendBindMobile(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    showProgressDialog(2131718766, 1000L, true);
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
      overridePendingTransition(2130772004, 2130772344);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
      break;
    case 2131372499: 
      b();
      break;
    case 2131372498: 
      c();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131559540);
    int i = this.mPhoneContactService.getSelfBindState();
    paramBundle = this.mPhoneContactService.getSelfBindInfo();
    if ((i == 5) && (paramBundle != null))
    {
      this.jdField_b_of_type_JavaLangString = paramBundle.nationCode;
      this.jdField_a_of_type_JavaLangString = paramBundle.mobileNo;
      this.c = new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramBundle.bindingTime * 1000L));
      this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("key_is_first_activity", true);
      a();
      return;
    }
    showConfirmFinish(HardCodeUtil.a(2131701348), HardCodeUtil.a(2131701351));
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_b_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
      this.jdField_b_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = null;
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindNumberFromPcActivity
 * JD-Core Version:    0.7.0.1
 */