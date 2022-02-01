package com.tencent.mobileqq.activity.phone;

import Override;
import ajcr;
import akif;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import anvx;
import arcd;
import arce;
import arcf;
import bdla;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PhoneMatchActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Button jdField_a_of_type_AndroidWidgetButton;
  
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 99999)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
      }
      if (((PhoneContactManagerImp)this.app.getManager(QQManagerFactory.CONTACT_MANAGER)).a(true))
      {
        ContactBindedActivity.a(this.app, -1, 2, null);
        setResult(-1);
        finish();
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559298);
    PhoneContactManagerImp.a(this.app, getResources(), (ImageView)findViewById(2131365097));
    paramBundle = findViewById(2131369788);
    Object localObject;
    String str;
    if ((paramBundle != null) && ("1000".equals(ThemeUtil.curThemeId)))
    {
      paramBundle.setBackgroundResource(2130839458);
      this.centerView.setText(anvx.a(2131707472));
      this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
      localObject = arcf.a();
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.k()) {
        break label251;
      }
      str = ((arcd)localObject).b.a;
      paramBundle = ((arcd)localObject).b.b;
      localObject = ((arcd)localObject).b.c;
      label124:
      ((TextView)findViewById(2131365099)).setText(str);
      ((TextView)findViewById(2131365098)).setText(paramBundle);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365096));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      if (this.jdField_a_of_type_Int != 14) {
        break label278;
      }
      setLeftViewName(2131690499);
    }
    for (;;)
    {
      bdla.b(this.app, "dc00898", "", "", "0X800689B", "0X800689B", 0, 0, "", "", "", "");
      ThreadManager.excute(new PhoneMatchActivity.1(this), 16, null, true);
      return true;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setBackgroundResource(2130838911);
      break;
      label251:
      str = ((arcd)localObject).a.a;
      paramBundle = ((arcd)localObject).a.b;
      localObject = ((arcd)localObject).a.c;
      break label124;
      label278:
      setLeftButton("", null);
      setRightButton(2131690845, this);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_Int == 14) {
      return;
    }
    overridePendingTransition(0, 2130771978);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
      if (!NetworkUtil.isNetSupport(this)) {
        QQToast.a(BaseApplicationImpl.getContext(), 1, 2131694305, 0).b(getTitleBarHeight());
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("IphoneTitleBarActivity", 2, "clickMatch state: " + this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.d());
      }
      bdla.b(this.app, "dc00898", "", "", "0X80095ED", "0X80095ED", 0, 0, "", "", "", "");
      PhoneMatchActivity.2 local2 = new PhoneMatchActivity.2(this);
      DenyRunnable localDenyRunnable = new DenyRunnable(this, new akif(this.app));
      ajcr.a(this, this.app, local2, localDenyRunnable);
      continue;
      finish();
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
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchActivity
 * JD-Core Version:    0.7.0.1
 */