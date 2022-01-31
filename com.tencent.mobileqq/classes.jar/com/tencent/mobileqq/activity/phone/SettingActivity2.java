package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import xax;
import xbb;
import xbc;

public class SettingActivity2
  extends DialogBaseActivity
  implements View.OnClickListener
{
  public int a;
  public Button a;
  public TextView a;
  public ContactBindObserver a;
  public String a;
  public int b;
  public Button b;
  public ContactBindObserver b;
  public ContactBindObserver c;
  
  public SettingActivity2()
  {
    this.jdField_b_of_type_Int = -1;
  }
  
  public void a()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.setCanceledOnTouchOutside(true);
    localActionSheet.a("停用", 3);
    localActionSheet.c(2131433029);
    localActionSheet.a(new xax(this, localActionSheet));
    localActionSheet.c(2131433029);
    localActionSheet.show();
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
    if ((1 != this.jdField_a_of_type_Int) && (5 != this.jdField_a_of_type_Int)) {}
    try
    {
      this.jdField_a_of_type_JavaLangString = (localRespondQueryQQBindingStat.nationCode + " " + localRespondQueryQQBindingStat.mobileNo);
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        super.finish();
        return false;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SettingActivity2", 2, "" + this.jdField_a_of_type_Int, localException);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SettingActivity2", 2, "updateStateLayout mNumber = " + this.jdField_a_of_type_JavaLangString + ", mState = " + this.jdField_a_of_type_Int);
      }
      super.setTitle("手机通讯录");
      if (this.jdField_a_of_type_Int != 7) {
        break label320;
      }
    }
    Object localObject = "启用手机通讯录匹配。如果你的通讯录中有朋友开通此功能，系统会通知你。可在QQ直接给朋友发消息、图片等。";
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365509));
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365510));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131365511));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (this.jdField_a_of_type_Int == 7)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    }
    for (;;)
    {
      localObject = (ImageView)findViewById(2131363493);
      ((ImageView)localObject).setVisibility(0);
      if (AppSetting.b) {
        ((ImageView)localObject).setContentDescription(getString(2131436875));
      }
      ((ImageView)localObject).setBackgroundResource(2130839162);
      ((ImageView)localObject).setOnClickListener(this);
      return true;
      label320:
      localObject = "已启用手机通讯录匹配。如果你的通讯录中有朋友开通此功能，系统会通知你。可在QQ直接给朋友发消息、图片等。";
      break;
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
  }
  
  public void b()
  {
    if (!NetworkUtil.d(this))
    {
      b(2131434629);
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.f())
    {
      startActivity(new Intent(this, GuideBindPhoneActivity.class));
      return;
    }
    int i = getResources().getDimensionPixelSize(2131558448);
    if (this.c == null)
    {
      this.c = new xbb(this);
      this.app.registObserver(this.c);
    }
    this.app.a(new xbc(this));
    QQToast.a(BaseApplicationImpl.sApplication, "特征码匹配中。", 0).b(i);
    a(2131434469, 1000L, true);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    a();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = super.getIntent();
    if (paramBundle == null) {
      super.finish();
    }
    do
    {
      return true;
      this.jdField_b_of_type_Int = paramBundle.getIntExtra("kSrouce", -1);
      super.setContentView(2130969170);
    } while (a());
    super.finish();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_b_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    this.app.removeHandler(SettingActivity2.class);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    switch (i)
    {
    default: 
      throw new RuntimeException("unknown id: " + i);
    case 2131363493: 
      a();
      return;
    case 2131365512: 
      if (!NetworkUtil.d(this))
      {
        b(2131434629);
        return;
      }
      paramView = new Intent(this, BindNumberActivity.class);
      paramView.putExtra("kNeedUnbind", true);
      paramView.putExtra("cmd_param_is_from_uni", true);
      paramView.putExtra("cmd_param_is_from_change_bind", true);
      startActivity(paramView);
      return;
    case 2131365510: 
      ReportController.b(this.app, "CliOper", "", "", "0X8005B89", "0X8005B89", 0, 0, "", "", "", "");
      b();
      return;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.f())
    {
      startActivity(new Intent(this, GuideBindPhoneActivity.class));
      return;
    }
    if (this.jdField_b_of_type_Int == 6)
    {
      super.finish();
      return;
    }
    paramView = new Intent(getActivity(), PhoneFrameActivity.class);
    paramView.putExtra("key_req_type", 5);
    getActivity().startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2
 * JD-Core Version:    0.7.0.1
 */