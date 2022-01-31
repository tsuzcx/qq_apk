package com.tencent.mobileqq.activity.phone;

import afxy;
import ajjy;
import amdf;
import amdg;
import amdh;
import amnv;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import awqx;
import badq;
import bbmy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class PhoneMatchActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Button jdField_a_of_type_AndroidWidgetButton;
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 99999)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
      }
      if (((PhoneContactManagerImp)this.app.getManager(11)).a(true))
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
    super.setContentView(2131493562);
    PhoneContactManagerImp.a(this.app, getResources(), (ImageView)findViewById(2131299074));
    paramBundle = findViewById(2131303232);
    Object localObject;
    String str;
    if ((paramBundle != null) && ("1000".equals(ThemeUtil.curThemeId)))
    {
      paramBundle.setBackgroundResource(2130839104);
      this.centerView.setText(ajjy.a(2131642227));
      this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
      localObject = amdh.a();
      if (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.i()) {
        break label251;
      }
      str = ((amdf)localObject).b.a;
      paramBundle = ((amdf)localObject).b.b;
      localObject = ((amdf)localObject).b.c;
      label124:
      ((TextView)findViewById(2131299076)).setText(str);
      ((TextView)findViewById(2131299075)).setText(paramBundle);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131299073));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      if (this.jdField_a_of_type_Int != 14) {
        break label278;
      }
      setLeftViewName(2131624770);
    }
    for (;;)
    {
      awqx.b(this.app, "dc00898", "", "", "0X800689B", "0X800689B", 0, 0, "", "", "", "");
      ThreadManager.excute(new PhoneMatchActivity.1(this), 16, null, true);
      return true;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setBackgroundResource(2130838503);
      break;
      label251:
      str = ((amdf)localObject).a.a;
      paramBundle = ((amdf)localObject).a.b;
      localObject = ((amdf)localObject).a.c;
      break label124;
      label278:
      setLeftButton("", null);
      setRightButton(2131625271, this);
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
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if (!badq.d(this))
      {
        bbmy.a(BaseApplicationImpl.getContext(), 1, 2131629008, 0).b(getTitleBarHeight());
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("IphoneTitleBarActivity", 2, "clickMatch state: " + this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d());
      }
      awqx.b(this.app, "dc00898", "", "", "0X80095ED", "0X80095ED", 0, 0, "", "", "", "");
      paramView = new PhoneMatchActivity.2(this);
      DenyRunnable localDenyRunnable = new DenyRunnable(this, new afxy(this.app));
      amnv.a(this, this.app, paramView, localDenyRunnable);
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchActivity
 * JD-Core Version:    0.7.0.1
 */