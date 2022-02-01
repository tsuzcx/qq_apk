package com.tencent.mobileqq.activity.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean.UIElement;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.phonecontact.util.PhoneContactUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class SettingActivity2
  extends DialogBaseActivity
  implements View.OnClickListener
{
  public int a;
  public Button a;
  public TextView a;
  public ContactBindObserver a;
  public Boolean a;
  public int b;
  public Button b;
  public TextView b;
  public ContactBindObserver b;
  public ContactBindObserver c;
  
  public SettingActivity2()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangBoolean = null;
  }
  
  public void a()
  {
    int i = this.mPhoneContactService.getSelfBindState();
    boolean bool = PermissionChecker.a().b();
    Object localObject1 = this.mPhoneContactService.getSelfBindInfo();
    Object localObject2;
    if ((1 != i) && (5 != i) && (localObject1 != null))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((RespondQueryQQBindingStat)localObject1).nationCode);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(((RespondQueryQQBindingStat)localObject1).mobileNo);
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject1 = null;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateUIByState state[");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("], number[");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("], hasPermission[");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangBoolean);
      ((StringBuilder)localObject2).append("]");
      QLog.d("SettingActivity2", 2, ((StringBuilder)localObject2).toString());
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (i > 5))
    {
      if (i == this.jdField_b_of_type_Int)
      {
        localObject1 = this.jdField_a_of_type_JavaLangBoolean;
        if ((localObject1 != null) && (((Boolean)localObject1).booleanValue() == bool)) {
          return;
        }
      }
      this.jdField_b_of_type_Int = i;
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
      setTitle(HardCodeUtil.a(2131713738));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365112));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365111));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131370715));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131380835));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      if ((i != 7) && (i != 6))
      {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject2 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).loadNewFriendContactGuideConfig();
        String str;
        if (bool)
        {
          localObject1 = ((NewFriendContactGuideConfBean)localObject2).b.a;
          str = ((NewFriendContactGuideConfBean)localObject2).b.b;
          localObject2 = ((NewFriendContactGuideConfBean)localObject2).b.c;
        }
        else
        {
          localObject1 = ((NewFriendContactGuideConfBean)localObject2).a.a;
          str = ((NewFriendContactGuideConfBean)localObject2).a.b;
          localObject2 = ((NewFriendContactGuideConfBean)localObject2).a.c;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
        this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject2);
      }
      localObject1 = (ImageView)findViewById(2131369216);
      if (i == 7) {
        ((ImageView)localObject1).setVisibility(8);
      } else {
        ((ImageView)localObject1).setVisibility(0);
      }
      if (AppSetting.d) {
        ((ImageView)localObject1).setContentDescription(getString(2131694765));
      }
      ((ImageView)localObject1).setBackgroundResource(2130840347);
      ((ImageView)localObject1).setOnClickListener(this);
      return;
    }
    finish();
  }
  
  public void a(String paramString, int paramInt)
  {
    ReportController.b(this.app, "CliOper", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public void b()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.setCanceledOnTouchOutside(true);
    localActionSheet.addButton(HardCodeUtil.a(2131713739), 3);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new SettingActivity2.2(this, localActionSheet));
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.show();
  }
  
  public void c()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      showToast(2131694475);
      return;
    }
    PermissionChecker.a(this, new SettingActivity2.3(this), new DenyRunnable(this, new DenyRunnable.JumpSettingAction(this.app)));
  }
  
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
    if (paramInt1 == 9999)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
      }
      if (((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "")).checkAndUploadContact(true))
      {
        ContactBindedActivity.a(this.app, 222, this.mPhoneContactService.generateRandomList());
        return;
      }
      a();
      return;
    }
    a();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = super.getIntent();
    if (paramBundle == null)
    {
      super.finish();
      return true;
    }
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("kSrouce", -1);
    super.setContentView(2131559553);
    PhoneContactUtils.a(this.app, getResources(), (ImageView)findViewById(2131365110));
    a();
    return true;
  }
  
  protected void doOnDestroy()
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
    this.app.removeHandler(SettingActivity2.class);
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ThreadManager.excute(new SettingActivity2.1(this), 16, null, true);
    a();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131369216)
    {
      if (i != 2131370715)
      {
        if (i == 2131380835)
        {
          PermissionChecker.a(this, new SettingActivity2.4(this), new DenyRunnable(this, new DenyRunnable.JumpSettingAction(this.app)));
        }
        else
        {
          paramView = new StringBuilder();
          paramView.append("unknown id: ");
          paramView.append(i);
          throw new RuntimeException(paramView.toString());
        }
      }
      else
      {
        a("0X8005B89", 0);
        c();
      }
    }
    else {
      b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2
 * JD-Core Version:    0.7.0.1
 */