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
  public TextView a;
  public TextView b;
  public ContactBindObserver c;
  public ContactBindObserver d;
  public ContactBindObserver e;
  public Button f;
  public Button g;
  public int h = -1;
  public int i = 0;
  public Boolean j = null;
  
  public void a()
  {
    int k = this.mPhoneContactService.getSelfBindState();
    boolean bool = PermissionChecker.a().d();
    Object localObject1 = this.mPhoneContactService.getSelfBindInfo();
    Object localObject2;
    if ((1 != k) && (5 != k) && (localObject1 != null))
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
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append("], number[");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("], hasPermission[");
      ((StringBuilder)localObject2).append(this.j);
      ((StringBuilder)localObject2).append("]");
      QLog.d("SettingActivity2", 2, ((StringBuilder)localObject2).toString());
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (k > 5))
    {
      if (k == this.i)
      {
        localObject1 = this.j;
        if ((localObject1 != null) && (((Boolean)localObject1).booleanValue() == bool)) {
          return;
        }
      }
      this.i = k;
      this.j = Boolean.valueOf(bool);
      setTitle(HardCodeUtil.a(2131911280));
      this.a = ((TextView)findViewById(2131431259));
      this.b = ((TextView)findViewById(2131431258));
      this.f = ((Button)findViewById(2131437994));
      this.f.setOnClickListener(this);
      this.g = ((Button)findViewById(2131449811));
      this.g.setOnClickListener(this);
      if ((k != 7) && (k != 6))
      {
        this.g.setVisibility(0);
        this.f.setVisibility(8);
        this.a.setVisibility(8);
        this.b.setVisibility(8);
      }
      else
      {
        this.g.setVisibility(8);
        this.f.setVisibility(0);
        this.a.setVisibility(0);
        this.b.setVisibility(0);
        localObject2 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).loadNewFriendContactGuideConfig();
        String str;
        if (bool)
        {
          localObject1 = ((NewFriendContactGuideConfBean)localObject2).d.a;
          str = ((NewFriendContactGuideConfBean)localObject2).d.b;
          localObject2 = ((NewFriendContactGuideConfBean)localObject2).d.c;
        }
        else
        {
          localObject1 = ((NewFriendContactGuideConfBean)localObject2).c.a;
          str = ((NewFriendContactGuideConfBean)localObject2).c.b;
          localObject2 = ((NewFriendContactGuideConfBean)localObject2).c.c;
        }
        this.a.setText((CharSequence)localObject1);
        this.b.setText(str);
        this.f.setText((CharSequence)localObject2);
      }
      localObject1 = (ImageView)findViewById(2131436194);
      if (k == 7) {
        ((ImageView)localObject1).setVisibility(8);
      } else {
        ((ImageView)localObject1).setVisibility(0);
      }
      if (AppSetting.e) {
        ((ImageView)localObject1).setContentDescription(getString(2131892468));
      }
      ((ImageView)localObject1).setBackgroundResource(2130841087);
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
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
    localActionSheet.setCanceledOnTouchOutside(true);
    localActionSheet.addButton(HardCodeUtil.a(2131911281), 3);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new SettingActivity2.2(this, localActionSheet));
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.show();
  }
  
  public void c()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      showToast(2131892157);
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
    this.h = paramBundle.getIntExtra("kSrouce", -1);
    super.setContentView(2131625575);
    PhoneContactUtils.a(this.app, getResources(), (ImageView)findViewById(2131431257));
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.c != null)
    {
      this.app.unRegistObserver(this.c);
      this.c = null;
    }
    if (this.d != null)
    {
      this.app.unRegistObserver(this.d);
      this.d = null;
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
    int k = paramView.getId();
    if (k != 2131436194)
    {
      if (k != 2131437994)
      {
        if (k == 2131449811)
        {
          PermissionChecker.a(this, new SettingActivity2.4(this), new DenyRunnable(this, new DenyRunnable.JumpSettingAction(this.app)));
        }
        else
        {
          paramView = new StringBuilder();
          paramView.append("unknown id: ");
          paramView.append(k);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2
 * JD-Core Version:    0.7.0.1
 */