package com.tencent.mobileqq.activity.phone;

import aihy;
import alpo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import aoki;
import aokj;
import aokk;
import aovo;
import azmj;
import bdee;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
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
    super.setContentView(2131559174);
    PhoneContactManagerImp.a(this.app, getResources(), (ImageView)findViewById(2131364712));
    paramBundle = findViewById(2131369129);
    Object localObject;
    String str;
    if ((paramBundle != null) && ("1000".equals(ThemeUtil.curThemeId)))
    {
      paramBundle.setBackgroundResource(2130839216);
      this.centerView.setText(alpo.a(2131708395));
      this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
      localObject = aokk.a();
      if (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.i()) {
        break label251;
      }
      str = ((aoki)localObject).b.a;
      paramBundle = ((aoki)localObject).b.b;
      localObject = ((aoki)localObject).b.c;
      label124:
      ((TextView)findViewById(2131364714)).setText(str);
      ((TextView)findViewById(2131364713)).setText(paramBundle);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364711));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      if (this.jdField_a_of_type_Int != 14) {
        break label278;
      }
      setLeftViewName(2131690382);
    }
    for (;;)
    {
      azmj.b(this.app, "dc00898", "", "", "0X800689B", "0X800689B", 0, 0, "", "", "", "");
      ThreadManager.excute(new PhoneMatchActivity.1(this), 16, null, true);
      return true;
      if (paramBundle == null) {
        break;
      }
      paramBundle.setBackgroundResource(2130838591);
      break;
      label251:
      str = ((aoki)localObject).a.a;
      paramBundle = ((aoki)localObject).a.b;
      localObject = ((aoki)localObject).a.c;
      break label124;
      label278:
      setLeftButton("", null);
      setRightButton(2131690884, this);
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
      if (!bdee.d(this))
      {
        QQToast.a(BaseApplicationImpl.getContext(), 1, 2131694829, 0).b(getTitleBarHeight());
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("IphoneTitleBarActivity", 2, "clickMatch state: " + this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d());
      }
      azmj.b(this.app, "dc00898", "", "", "0X80095ED", "0X80095ED", 0, 0, "", "", "", "");
      paramView = new PhoneMatchActivity.2(this);
      DenyRunnable localDenyRunnable = new DenyRunnable(this, new aihy(this.app));
      aovo.a(this, this.app, paramView, localDenyRunnable);
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchActivity
 * JD-Core Version:    0.7.0.1
 */