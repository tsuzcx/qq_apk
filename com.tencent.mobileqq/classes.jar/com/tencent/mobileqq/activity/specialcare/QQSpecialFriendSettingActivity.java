package com.tencent.mobileqq.activity.specialcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
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
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ReflectedMethods;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class QQSpecialFriendSettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, DecodeTaskCompletionListener
{
  final Handler a = new QQSpecialFriendSettingActivity.3(this);
  private FormSimpleItem b;
  private FormSwitchItem c;
  private FormSwitchItem d;
  private View e;
  private QQProgressDialog f;
  private View g;
  private ImageView h;
  private TextView i;
  private FriendListHandler j;
  private IQvipSpecialSoundManager k;
  private FriendsManager l;
  private String m;
  private int n;
  private boolean o;
  private SpecialCareInfo p;
  private IFaceDecoder q;
  private boolean r = true;
  private boolean s = false;
  private FriendListObserver t = new QQSpecialFriendSettingActivity.4(this);
  private QvipSpecialCareObserver u = new QQSpecialFriendSettingActivity.5(this);
  
  private void a()
  {
    this.b = ((FormSimpleItem)findViewById(2131440010));
    this.b.setOnClickListener(this);
    this.b.setVisibility(0);
    this.c = ((FormSwitchItem)findViewById(2131433801));
    this.c.setVisibility(8);
    this.c.setOnCheckedChangeListener(this);
    this.d = ((FormSwitchItem)findViewById(2131433816));
    this.d.setOnCheckedChangeListener(this);
    this.e = findViewById(2131443779);
    this.g = findViewById(2131430275);
    this.g.setOnClickListener(this);
    this.h = ((ImageView)findViewById(2131432767));
    this.i = ((TextView)findViewById(2131439320));
    if (this.o)
    {
      setLeftViewName(2131886199);
      setRightButton(2131889474, new QQSpecialFriendSettingActivity.1(this));
      this.g.setVisibility(8);
    }
    else
    {
      setLeftViewName(2131891485);
    }
    if (AppSetting.e)
    {
      this.c.setContentDescription(getString(2131897339));
      this.d.setContentDescription(getString(2131897340));
    }
  }
  
  private void b()
  {
    this.k = VasUtil.a().getSpecialSoundManager();
    if (!this.k.isCacheData())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialFriendSettingActivity", 2, "QvipSpecialSoundManager no cache data.");
      }
      d();
    }
    this.q = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.q.setDecodeTaskCompletionListener(this);
    Object localObject = this.q.getBitmapFromCache(1, this.m, 0);
    if (localObject == null)
    {
      if (!this.q.isPausing()) {
        this.q.requestDecodeFace(this.m, 1, true);
      }
      this.h.setBackgroundDrawable((BitmapDrawable)ImageUtil.m());
    }
    else
    {
      this.h.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
    }
    localObject = this.l.c(this.m);
    if (localObject == null)
    {
      this.i.setText(this.m);
      return;
    }
    this.i.setText(((Friends)localObject).getFriendNickWithAlias());
  }
  
  private void c()
  {
    this.p = this.l.y(this.m);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showItems mSpecInfo: ");
      ((StringBuilder)localObject).append(this.p);
      QLog.d("QQSpecialFriendSettingActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.p;
    int i1 = 8;
    if (localObject == null)
    {
      if (!this.o)
      {
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
        this.b.setVisibility(8);
        this.g.setVisibility(8);
        return;
      }
      this.g.setVisibility(8);
      e();
      return;
    }
    this.c.setVisibility(8);
    this.d.setVisibility(0);
    this.e.setVisibility(0);
    if (!this.o) {
      this.g.setVisibility(0);
    }
    localObject = this.c;
    int i2 = this.p.specialRingSwitch;
    boolean bool2 = true;
    if (i2 == 0) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    a((FormSwitchItem)localObject, bool1);
    localObject = this.d;
    boolean bool1 = bool2;
    if (this.p.qzoneSwitch == 0) {
      bool1 = false;
    }
    a((FormSwitchItem)localObject, bool1);
    localObject = this.b;
    if (this.c.a()) {
      i1 = 0;
    }
    ((FormSimpleItem)localObject).setVisibility(i1);
    this.b.setVisibility(0);
    e();
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "loadSpecialSoundConfig start loading...");
    }
    startTitleProgress();
    this.k.loadSpecialSoundConfig(new QQSpecialFriendSettingActivity.2(this));
  }
  
  private void e()
  {
    Object localObject1;
    Object localObject2;
    FormSimpleItem localFormSimpleItem;
    if (this.o)
    {
      localObject1 = ReflectedMethods.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq_preferences");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("special_care_id_cache");
      ((StringBuilder)localObject2).append(this.m);
      this.n = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), 1);
      localObject2 = this.k.getSoundName(this.n);
      localFormSimpleItem = this.b;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = getString(2131892167);
      } else {
        localObject1 = localObject2;
      }
      localFormSimpleItem.setRightText((CharSequence)localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updatePersonalVoice FromForwardFriendActivity mFriUin: ");
        ((StringBuilder)localObject1).append(this.m);
        ((StringBuilder)localObject1).append(", soundId: ");
        ((StringBuilder)localObject1).append(this.n);
        ((StringBuilder)localObject1).append(", soundName: ");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.d("QQSpecialFriendSettingActivity", 2, ((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      if (QvipSpecialCareUtil.d(this.m, this.app))
      {
        if (!this.k.isCacheData()) {
          d();
        }
        int i1 = QvipSpecialCareUtil.f(this.m, this.app);
        localObject2 = this.k.getSoundName(i1);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("updatePersonalVoice mFriUin: ");
          ((StringBuilder)localObject1).append(this.m);
          ((StringBuilder)localObject1).append(", soundId: ");
          ((StringBuilder)localObject1).append(i1);
          ((StringBuilder)localObject1).append(", soundName: ");
          ((StringBuilder)localObject1).append((String)localObject2);
          QLog.d("QQSpecialFriendSettingActivity", 2, ((StringBuilder)localObject1).toString());
        }
        localFormSimpleItem = this.b;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = getString(2131892167);
        }
        localFormSimpleItem.setRightText((CharSequence)localObject1);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updatePersonalVoice not contain friend: ");
        ((StringBuilder)localObject1).append(this.m);
        QLog.d("QQSpecialFriendSettingActivity", 2, ((StringBuilder)localObject1).toString());
      }
      this.b.setRightText(getString(2131892167));
    }
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
    setContentView(2131627855);
    setTitle(2131897344);
    paramBundle = getIntent();
    this.m = paramBundle.getStringExtra("key_friend_uin");
    this.o = paramBundle.getBooleanExtra("key_is_from_friendsforward_activity", false);
    a();
    this.j = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    this.l = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.app.addObserver(this.t);
    this.app.addObserver(this.u);
    b();
    ReportController.b(null, "CliOper", "", "", "0X80050E5", "0X80050E5", 0, 0, "0", "", "", "");
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("doOnCreate mFriUin: ");
      paramBundle.append(this.m);
      QLog.d("QQSpecialFriendSettingActivity", 2, paramBundle.toString());
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.q;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    if (this.app != null)
    {
      this.app.removeObserver(this.u);
      this.app.removeObserver(this.t);
    }
    if (this.o)
    {
      localObject = ReflectedMethods.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq_preferences");
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("special_care_id_cache");
        localStringBuilder.append(this.m);
        ((SharedPreferences.Editor)localObject).remove(localStringBuilder.toString()).commit();
      }
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.r = false;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    c();
    this.r = true;
    if (this.s)
    {
      this.s = false;
      Intent localIntent = new Intent();
      localIntent.setClass(this, SpecailCareListActivity.class);
      localIntent.addFlags(67108864);
      localIntent.putExtra("selfSet_leftViewText", getString(2131892912));
      startActivity(localIntent);
      finish();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i2 = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCheckedChanged isCheck: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", switched by user.");
      QLog.d("QQSpecialFriendSettingActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b;
    int i1;
    if (this.c.a()) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((FormSimpleItem)localObject).setVisibility(i1);
    if (!this.o)
    {
      if (paramCompoundButton == this.c.getSwitch())
      {
        localObject = this.c;
        i1 = i2;
      }
      else
      {
        if (paramCompoundButton != this.d.getSwitch()) {
          break label225;
        }
        i1 = 3;
        localObject = this.d;
      }
      if (NetworkUtil.isNetworkAvailable(this))
      {
        this.j.setSpecialCareSwitch(i1, new String[] { this.m }, new boolean[] { paramBoolean });
      }
      else
      {
        Message localMessage = this.a.obtainMessage(8195);
        localMessage.arg1 = 0;
        localMessage.arg2 = 2131889169;
        this.a.sendMessage(localMessage);
        a((FormSwitchItem)localObject, ((FormSwitchItem)localObject).a() ^ true);
      }
    }
    label225:
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
    Object localObject;
    if (i1 != 2131430275)
    {
      if (i1 == 2131440010)
      {
        localObject = new Intent(this, QQBrowserActivity.class);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(IndividuationUrlHelper.a("specialCareRingUrl"));
        localStringBuilder.append("&suin=");
        localStringBuilder.append(this.m);
        localStringBuilder.append("&uin=");
        localStringBuilder.append(this.app.getCurrentAccountUin());
        localStringBuilder.append("&_bid=279&lazy=");
        localStringBuilder.append(this.o);
        ((Intent)localObject).putExtra("url", localStringBuilder.toString().replace("[uid]", this.m).replace("[lType]", "2"));
        ((Intent)localObject).putExtra("uin", this.m);
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        startActivity((Intent)localObject);
      }
    }
    else
    {
      if (NetworkUtil.isNetworkAvailable(this))
      {
        this.j.setSpecialCareSwitch(1, new String[] { this.m }, new boolean[] { false });
        localObject = this.a.obtainMessage(8193);
        ((Message)localObject).obj = getString(2131897330);
        this.a.sendMessage((Message)localObject);
      }
      else
      {
        localObject = this.a.obtainMessage(8195);
        ((Message)localObject).arg1 = 0;
        ((Message)localObject).arg2 = 2131889169;
        this.a.sendMessage((Message)localObject);
      }
      ReportController.b(null, "CliOper", "", "", "0X80050E6", "0X80050E6", 0, 0, "0", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", type=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",avatar= ");
      localStringBuilder.append(paramBitmap);
      QLog.d("QQSpecialFriendSettingActivity", 2, localStringBuilder.toString());
    }
    if (paramBitmap != null)
    {
      if (this.q.isPausing()) {
        return;
      }
      this.h.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity
 * JD-Core Version:    0.7.0.1
 */