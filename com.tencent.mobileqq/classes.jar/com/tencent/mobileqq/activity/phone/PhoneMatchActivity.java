package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean;
import com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfBean.UIElement;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.phonecontact.util.PhoneContactUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
    if (paramInt1 == 9999)
    {
      if (QLog.isColorLevel()) {
        QLog.i("BindMsgConstant", 2, "REQ_FOR_SETTING");
      }
      if (((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "")).checkAndUploadContact(true))
      {
        ContactBindedActivity.a(this.app, -1, 2, null);
        setResult(-1);
        finish();
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559216);
    PhoneContactUtils.a(this.app, getResources(), (ImageView)findViewById(2131365110));
    paramBundle = findViewById(2131369736);
    if ((paramBundle != null) && ("1000".equals(ThemeUtil.curThemeId))) {
      paramBundle.setBackgroundResource(2130839393);
    } else if (paramBundle != null) {
      paramBundle.setBackgroundResource(2130838739);
    }
    this.centerView.setText(HardCodeUtil.a(2131708018));
    this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    Object localObject = ((INewFriendApi)QRoute.api(INewFriendApi.class)).loadNewFriendContactGuideConfig();
    String str;
    if (PermissionChecker.a().b())
    {
      paramBundle = ((NewFriendContactGuideConfBean)localObject).b.a;
      str = ((NewFriendContactGuideConfBean)localObject).b.b;
      localObject = ((NewFriendContactGuideConfBean)localObject).b.c;
    }
    else
    {
      paramBundle = ((NewFriendContactGuideConfBean)localObject).a.a;
      str = ((NewFriendContactGuideConfBean)localObject).a.b;
      localObject = ((NewFriendContactGuideConfBean)localObject).a.c;
    }
    ((TextView)findViewById(2131365112)).setText(paramBundle);
    ((TextView)findViewById(2131365111)).setText(str);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365109));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
    if (this.jdField_a_of_type_Int == 14)
    {
      setLeftViewName(2131690529);
    }
    else
    {
      setLeftButton("", null);
      setRightButton(2131690874, this);
    }
    ReportController.b(this.app, "dc00898", "", "", "0X800689B", "0X800689B", 0, 0, "", "", "", "");
    ThreadManager.excute(new PhoneMatchActivity.1(this), 16, null, true);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_Int == 14) {
      return;
    }
    overridePendingTransition(0, 2130771992);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if (!NetworkUtil.isNetSupport(this))
      {
        QQToast.a(BaseApplicationImpl.getContext(), 1, 2131694475, 0).b(getTitleBarHeight());
      }
      else
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("clickMatch state: ");
          localStringBuilder.append(this.mPhoneContactService.getSelfBindState());
          QLog.i("IphoneTitleBarActivity", 2, localStringBuilder.toString());
        }
        ReportController.b(this.app, "dc00898", "", "", "0X80095ED", "0X80095ED", 0, 0, "", "", "", "");
        PermissionChecker.a(this, new PhoneMatchActivity.2(this), new DenyRunnable(this, new DenyRunnable.JumpSettingAction(this.app)));
      }
    }
    else {
      finish();
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
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchActivity
 * JD-Core Version:    0.7.0.1
 */