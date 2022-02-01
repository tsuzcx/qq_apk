package com.tencent.mobileqq.activity.specialcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushForSpecialCareDialog;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager.RingCallback;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;
import java.util.Set;

public class QQSpecialCareSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, MessageNotificationSettingManager.RingCallback
{
  final Handler a = new QQSpecialCareSettingActivity.2(this);
  private FormSwitchItem b;
  private FormSwitchItem c;
  private FormSwitchItem d;
  private FormSimpleItem e;
  private QQProgressDialog f;
  private View g;
  private View h;
  private FriendListHandler i;
  private IQvipSpecialSoundManager j;
  private FriendsManager k;
  private SpecialCareInfo l;
  private String m;
  private int n;
  private Toast o;
  private boolean p;
  private MessageNotificationSettingManager q;
  private FriendListObserver r = new QQSpecialCareSettingActivity.4(this);
  private QvipSpecialCareObserver s = new QQSpecialCareSettingActivity.5(this);
  
  private void a()
  {
    this.l = this.k.y(this.m);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showItems mSpecInfo: ");
      ((StringBuilder)localObject).append(this.l);
      QLog.d("QQSpecialCareSettingActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.l;
    int i2 = 8;
    if (localObject == null)
    {
      if (!this.k.p())
      {
        this.b.setVisibility(8);
        this.g.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.h.setVisibility(8);
        this.e.setVisibility(8);
        return;
      }
      this.b.setVisibility(0);
      this.g.setVisibility(0);
      this.c.setVisibility(8);
      this.d.setVisibility(8);
      this.h.setVisibility(8);
      a(this.b, false);
      return;
    }
    this.b.setVisibility(0);
    this.g.setVisibility(0);
    localObject = this.b;
    int i1 = this.l.globalSwitch;
    boolean bool2 = true;
    if (i1 == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    a((FormSwitchItem)localObject, bool1);
    boolean bool3 = this.b.a();
    localObject = this.c;
    if (bool3) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((FormSwitchItem)localObject).setVisibility(i1);
    this.c.setVisibility(8);
    localObject = this.d;
    if (bool3) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((FormSwitchItem)localObject).setVisibility(i1);
    localObject = this.h;
    i1 = i2;
    if (bool3) {
      i1 = 0;
    }
    ((View)localObject).setVisibility(i1);
    localObject = this.c;
    if (this.l.specialRingSwitch == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    a((FormSwitchItem)localObject, bool1);
    localObject = this.d;
    boolean bool1 = bool2;
    if (this.l.qzoneSwitch == 0) {
      bool1 = false;
    }
    a((FormSwitchItem)localObject, bool1);
    if (this.p)
    {
      localObject = getResources().getDrawable(2130852591);
      this.e.setRightIcon((Drawable)localObject);
    }
    else
    {
      this.e.setRightIcon(null);
    }
    this.e.setVisibility(0);
    a(bool3);
    if (this.e.getVisibility() == 0) {
      VasWebviewUtil.a(this.app.getCurrentAccountUin(), "bell", "care_show", "", 1, 0, 0, "", "", "");
    }
    d();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.e.setLeftText(getString(2131916745));
      return;
    }
    this.e.setLeftText(getString(2131888267));
  }
  
  private void b()
  {
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("special_care_voice_red_dot");
    ((StringBuilder)localObject1).append(this.app.getCurrentAccountUin());
    String str = ((StringBuilder)localObject1).toString();
    Object localObject2 = SharedPreferencesHandler.a(localSharedPreferences, str, null);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new HashSet();
    }
    if (((Set)localObject1).add(this.m))
    {
      this.p = true;
      localObject2 = localSharedPreferences.edit();
      SharedPreferencesHandler.a((SharedPreferences.Editor)localObject2, str, ((Set)localObject1).toArray());
      ((SharedPreferences.Editor)localObject2).commit();
      VasWebviewUtil.a(this.app.getCurrentAccountUin(), "Care", "RedShow", "", 1, 0, 0, null, null, null);
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "loadSpecialSoundConfig start loading...");
    }
    startTitleProgress();
    this.j.loadSpecialSoundConfig(new QQSpecialCareSettingActivity.1(this));
  }
  
  private void d()
  {
    int i1;
    if (QvipSpecialCareUtil.d(this.m, this.app))
    {
      if (!this.j.isCacheData()) {
        c();
      }
      i1 = QvipSpecialCareUtil.f(this.m, this.app);
      localObject = this.j.getSoundName(i1);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updatePersonalVoice mFriUin: ");
        localStringBuilder.append(this.m);
        localStringBuilder.append(", soundId: ");
        localStringBuilder.append(i1);
        localStringBuilder.append(", soundName: ");
        localStringBuilder.append((String)localObject);
        QLog.d("QQSpecialCareSettingActivity", 2, localStringBuilder.toString());
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updatePersonalVoice not contain friend: ");
        ((StringBuilder)localObject).append(this.m);
        QLog.d("QQSpecialCareSettingActivity", 2, ((StringBuilder)localObject).toString());
      }
      this.e.setRightText("");
    }
    Object localObject = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.m, false);
    if (localObject == null)
    {
      QLog.d("QQSpecialCareSettingActivity", 1, new Object[] { "onResume: invoked. ", " extensionInfo: ", localObject });
      i1 = 0;
    }
    else
    {
      i1 = ((ExtensionInfo)localObject).friendRingId;
    }
    this.q.a(this.e, i1, this.m, 0);
  }
  
  public void a(int paramInt)
  {
    this.q.a(this.e, paramInt, this.m, 0);
  }
  
  void a(FormSwitchItem paramFormSwitchItem, boolean paramBoolean)
  {
    paramFormSwitchItem.setOnCheckedChangeListener(null);
    paramFormSwitchItem.setChecked(paramBoolean);
    paramFormSwitchItem.setOnCheckedChangeListener(this);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131627854);
    setTitle(2131897344);
    setLeftViewName(2131887625);
    this.b = ((FormSwitchItem)findViewById(2131446225));
    this.b.setOnCheckedChangeListener(this);
    this.g = findViewById(2131446226);
    this.c = ((FormSwitchItem)findViewById(2131433801));
    this.c.setOnCheckedChangeListener(this);
    this.d = ((FormSwitchItem)findViewById(2131433816));
    this.d.setOnCheckedChangeListener(this);
    this.h = findViewById(2131443779);
    this.e = ((FormSimpleItem)findViewById(2131440010));
    this.e.setVisibility(0);
    this.e.setOnClickListener(this);
    this.m = getIntent().getStringExtra("key_friend_uin");
    this.n = getIntent().getIntExtra("key_start_from", 5);
    if (this.app != null)
    {
      this.i = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
      this.k = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
      this.app.addObserver(this.r);
      this.app.addObserver(this.s);
    }
    this.j = VasUtil.a().getSpecialSoundManager();
    if (!this.j.isCacheData())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialCareSettingActivity", 2, "QvipSpecialSoundManager no cache data.");
      }
      c();
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("doOnCreate mFriUin: ");
      paramBundle.append(this.m);
      QLog.d("QQSpecialCareSettingActivity", 2, paramBundle.toString());
    }
    if (this.app == null) {
      paramBundle = "";
    } else {
      paramBundle = this.app.getCurrentAccountUin();
    }
    VasWebviewUtil.a(paramBundle, "Care", "PageView", Integer.toString(this.n), 1, 0, 0, null, null, null);
    b();
    this.b.setContentDescription(getString(2131914364));
    this.q = MessageNotificationSettingManager.a(this.app);
    this.q.a(this);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null)
    {
      this.app.removeObserver(this.s);
      this.app.removeObserver(this.r);
      MessageNotificationSettingManager.a(this.app).b(this);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.q.d(this.m, 0);
    a();
    a(this.b.a());
    d();
  }
  
  public void finish()
  {
    if (getIntent().getBooleanExtra("key_is_from_management_activity", false)) {
      setResult(-1);
    }
    super.finish();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i1 = 2;
    Object localObject1;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onCheckedChanged isCheck: ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(", switched by user.");
      QLog.d("QQSpecialCareSettingActivity", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    if (paramCompoundButton == this.b.getSwitch())
    {
      if ((QQAppInterface.isNotificationEnabled() == 0) && (paramBoolean))
      {
        localObject1 = new MsgNotifyPushForSpecialCareDialog(this, this.app, this.m);
        ((MsgNotifyPushForSpecialCareDialog)localObject1).setOnDismissListener(new QQSpecialCareSettingActivity.3(this, paramBoolean, (MsgNotifyPushForSpecialCareDialog)localObject1));
        ((MsgNotifyPushForSpecialCareDialog)localObject1).show();
        ReportController.b(null, "dc00898", "", "", "0X8009ACB", "0X8009ACB", 0, 0, "", "", "", "");
      }
      else
      {
        if (NetworkUtil.isNetworkAvailable(this))
        {
          this.i.setSpecialCareSwitch(1, new String[] { this.m }, new boolean[] { paramBoolean });
          localObject1 = this.a.obtainMessage(8193);
          this.a.sendMessage((Message)localObject1);
          bool = this.b.a();
          this.e.setVisibility(0);
          a(bool);
        }
        else
        {
          localObject1 = this.a.obtainMessage(8195);
          ((Message)localObject1).arg1 = 0;
          ((Message)localObject1).arg2 = 2131889169;
          this.a.sendMessage((Message)localObject1);
          localObject1 = this.b;
          a((FormSwitchItem)localObject1, ((FormSwitchItem)localObject1).a() ^ true);
        }
        localObject2 = this.app.getCurrentAccountUin();
        if (paramBoolean) {
          localObject1 = "SwitchOn";
        } else {
          localObject1 = "SwitchOff";
        }
        VasWebviewUtil.a((String)localObject2, "Care", (String)localObject1, Integer.toString(this.n), 1, 0, 0, null, null, null);
      }
    }
    else if ((paramCompoundButton == this.c.getSwitch()) || (paramCompoundButton == this.d.getSwitch()))
    {
      if (paramCompoundButton == this.c.getSwitch())
      {
        localObject1 = this.c;
      }
      else
      {
        if (paramCompoundButton != this.d.getSwitch()) {
          break label504;
        }
        i1 = 3;
        localObject1 = this.d;
      }
      if (NetworkUtil.isNetworkAvailable(this))
      {
        this.i.setSpecialCareSwitch(i1, new String[] { this.m }, new boolean[] { paramBoolean });
      }
      else
      {
        localObject2 = this.a.obtainMessage(8195);
        ((Message)localObject2).arg1 = 0;
        ((Message)localObject2).arg2 = 2131889169;
        this.a.sendMessage((Message)localObject2);
        a((FormSwitchItem)localObject1, ((FormSwitchItem)localObject1).a() ^ true);
      }
      bool = this.b.a();
      this.e.setVisibility(0);
      a(bool);
    }
    label504:
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    int i1;
    if (paramView == null) {
      i1 = 0;
    } else {
      i1 = paramView.getId();
    }
    if (i1 == 2131440010)
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("url", IndividuationUrlHelper.a("specialCareRingUrl").replace("[uid]", this.m).replace("[lType]", "2"));
      startActivity(localIntent);
      this.p = false;
      ReportController.b(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 2, 0, "", "", "", "");
      VasWebviewUtil.a(this.app.getCurrentAccountUin(), "bell", " care_click", "", 1, 0, 0, "", "", "");
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
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity
 * JD-Core Version:    0.7.0.1
 */