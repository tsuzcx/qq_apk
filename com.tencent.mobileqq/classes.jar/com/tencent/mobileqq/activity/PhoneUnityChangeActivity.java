package com.tencent.mobileqq.activity;

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
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class PhoneUnityChangeActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  public ContactBindObserver a;
  public ContactBindObserver b;
  public String c;
  public IPhoneContactService d;
  public QQCustomDialog e;
  public ActionSheet f;
  public Button g;
  private int h;
  
  public boolean a()
  {
    Object localObject1 = (IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "");
    int i = ((IPhoneContactService)localObject1).getSelfBindState();
    localObject1 = ((IPhoneContactService)localObject1).getSelfBindInfo();
    if ((1 != i) && (5 != i)) {
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(((RespondQueryQQBindingStat)localObject1).mobileNo);
        this.c = localStringBuilder.toString();
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(i);
          QLog.d("PhoneUnityChangeActivity", 2, localStringBuilder.toString(), localException);
        }
      }
    }
    if (TextUtils.isEmpty(this.c))
    {
      super.finish();
      return false;
    }
    super.setTitle(HardCodeUtil.a(2131905846));
    Object localObject2 = "更换手机号码#name#，\n将更新以下功能。".replace("#name#", PhoneUnityManager.a(this.c));
    ((TextView)findViewById(2131448323)).setText((CharSequence)localObject2);
    this.g = ((Button)findViewById(2131429825));
    this.g.setOnClickListener(this);
    localObject2 = (ImageView)findViewById(2131436194);
    ((ImageView)localObject2).setVisibility(0);
    if (AppSetting.e) {
      ((ImageView)localObject2).setContentDescription(getString(2131892469));
    }
    i = 2130844816;
    if (!ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
      i = 2130841087;
    }
    ((ImageView)localObject2).setImageResource(i);
    ((ImageView)localObject2).setOnClickListener(this);
    return true;
  }
  
  public void b()
  {
    if (this.f == null)
    {
      this.f = ((ActionSheet)ActionSheetHelper.b(this, null));
      this.f.setCanceledOnTouchOutside(true);
      this.f.addButton(HardCodeUtil.a(2131905835), 3);
      this.f.addCancelButton(2131887648);
      this.f.setOnButtonClickListener(new PhoneUnityChangeActivity.1(this));
      this.f.addCancelButton(2131887648);
    }
    if ((!this.f.isShowing()) && (!isFinishing())) {
      this.f.show();
    }
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
    if ((paramInt1 == 1001) && (paramInt2 == -1))
    {
      super.setResult(paramInt2);
      super.finish();
      return;
    }
    a();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (getIntent() == null)
    {
      super.finish();
      return true;
    }
    super.setContentView(2131625572);
    this.d = ((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, ""));
    this.h = getIntent().getIntExtra("kSrouce", -1);
    if (!a()) {
      super.finish();
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.a != null)
    {
      this.app.unRegistObserver(this.a);
      this.a = null;
    }
    if (this.b != null)
    {
      this.app.unRegistObserver(this.b);
      this.b = null;
    }
    Object localObject = this.e;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).dismiss();
      this.e = null;
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((ActionSheet)localObject).dismiss();
      this.f = null;
    }
    this.app.removeHandler(PhoneUnityChangeActivity.class);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131429825)
    {
      if (i == 2131436194) {
        b();
      }
    }
    else if (!NetworkUtil.isNetSupport(this))
    {
      showToast(2131892157);
    }
    else
    {
      Intent localIntent = new Intent(this, BindNumberActivity.class);
      localIntent.putExtra("kNeedUnbind", true);
      localIntent.putExtra("cmd_param_is_from_uni", true);
      localIntent.putExtra("cmd_param_is_from_change_bind", true);
      i = this.h;
      if (i == -1) {
        i = 1;
      }
      localIntent.putExtra("kSrouce", i);
      localIntent.putExtra("kFPhoneChange", true);
      startActivityForResult(localIntent, 1001);
      ReportController.b(this.app, "CliOper", "", "", "0X8005B80", "0X8005B80", 0, 0, "", "", "", "");
      ContactUtils.d(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityChangeActivity
 * JD-Core Version:    0.7.0.1
 */