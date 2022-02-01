package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager.RingCallback;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.settings.message.NotifyPushSettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class SoundAndVibrateActivity
  extends IphoneTitleBarActivity
  implements MessageNotificationSettingManager.RingCallback
{
  public static int g = AppSetting.s;
  public static int h = AppSetting.t;
  public static String i = "user_choose_";
  private final int A = 4;
  private FormSwitchItem B;
  private FormSwitchItem C;
  private FormSwitchItem D;
  View a;
  FormSwitchItem b;
  FormSwitchItem c;
  FormSimpleItem d;
  float e;
  MessageNotificationSettingManager f;
  private FormSimpleItem j;
  private FormSimpleItem k;
  private FormSimpleItem l;
  private FormSimpleItem m;
  private FormSwitchItem n;
  private FormSwitchItem o;
  private FormSimpleItem p;
  private MediaPlayer q;
  private FormSwitchItem r;
  private FormSimpleItem s;
  private TextView t;
  private HashMap<Integer, SoundAndVibrateActivity.MenuItemInfo> u = new HashMap();
  private final int v = 1;
  private final int w = 0;
  private final int x = 1;
  private final int y = 2;
  private final int z = 3;
  
  private void a(TextView paramTextView)
  {
    String str = getResources().getString(2131916392);
    int i1 = paramTextView.getCurrentTextColor();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramTextView.getText());
    ((StringBuilder)localObject).append(str);
    localObject = ((StringBuilder)localObject).toString();
    SpannableString localSpannableString = new SpannableString((CharSequence)localObject);
    localSpannableString.setSpan(new SoundAndVibrateActivity.16(this), ((String)localObject).length() - str.length(), ((String)localObject).length(), 17);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText(localSpannableString);
    paramTextView.setClickable(false);
    paramTextView.setTextColor(i1);
  }
  
  private void a(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      try
      {
        Object localObject = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
        ((Intent)localObject).putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
        ((Intent)localObject).putExtra("android.provider.extra.CHANNEL_ID", paramString);
        startActivity((Intent)localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("go to channel setting  notificationChannelId: ");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("IphoneTitleBarActivity", 2, ((StringBuilder)localObject).toString());
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        try
        {
          paramString = new Intent();
          paramString.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
          paramString.setData(Uri.fromParts("package", getPackageName(), null));
          startActivity(paramString);
          if (QLog.isColorLevel())
          {
            QLog.d("IphoneTitleBarActivity", 2, "go to system setting");
            return;
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          QLog.e("IphoneTitleBarActivity", 2, "go to setting fail");
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).setSpecialCareRingRoamingSetting(this.app, 1);
      if (AppSetting.e) {
        this.r.getSwitch().setContentDescription(getString(2131916747));
      }
      VipUtils.a(this.app, "Vip_SpecialCare", "0X80049EC", "0X80049EC", 0, 1, null);
      return;
    }
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).setSpecialCareRingRoamingSetting(this.app, 2);
    if (AppSetting.e) {
      this.r.getSwitch().setContentDescription(getString(2131916746));
    }
    VipUtils.a(this.app, "Vip_SpecialCare", "0X80049ED", "0X80049ED", 0, 1, null);
  }
  
  private void c(int paramInt)
  {
    FormSwitchItem localFormSwitchItem;
    if ((Build.VERSION.SDK_INT <= 28) && (paramInt == 0))
    {
      ViewUtils.setVisible(this.c, 0);
      localFormSwitchItem = this.o;
      if (localFormSwitchItem != null) {
        localFormSwitchItem.setBgType(1);
      }
    }
    else
    {
      ViewUtils.setVisible(this.c, 8);
      localFormSwitchItem = this.o;
      if (localFormSwitchItem != null) {
        localFormSwitchItem.setBgType(3);
      }
    }
  }
  
  private void d()
  {
    int i1 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getSpecialCareRingRoamingSetting(this.app);
    boolean bool2 = false;
    boolean bool1 = false;
    FormSwitchItem localFormSwitchItem;
    if (i1 == 0)
    {
      localFormSwitchItem = this.r;
      if (this.app.getALLGeneralSettingRing() != 0) {
        bool1 = true;
      }
      localFormSwitchItem.setChecked(bool1);
    }
    else
    {
      localFormSwitchItem = this.r;
      bool1 = bool2;
      if (((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getSpecialCareRingRoamingSetting(this.app) == 1) {
        bool1 = true;
      }
      localFormSwitchItem.setChecked(bool1);
    }
    if (AppSetting.e)
    {
      if (this.r.a())
      {
        this.r.getSwitch().setContentDescription(getString(2131916747));
        return;
      }
      this.r.getSwitch().setContentDescription(getString(2131916746));
    }
  }
  
  private void d(int paramInt)
  {
    Iterator localIterator = this.u.values().iterator();
    while (localIterator.hasNext())
    {
      SoundAndVibrateActivity.MenuItemInfo localMenuItemInfo = (SoundAndVibrateActivity.MenuItemInfo)localIterator.next();
      if (localMenuItemInfo.a == paramInt)
      {
        localMenuItemInfo.c = true;
        int i1 = this.f.b();
        this.f.a(this.s, i1);
        this.s.setRightTextColor(1);
      }
      else
      {
        localMenuItemInfo.c = false;
      }
    }
  }
  
  private void e()
  {
    startActivity(new Intent(getActivity(), SpecailCareListActivity.class));
  }
  
  private void f()
  {
    SoundAndVibrateActivity.MenuItemInfo localMenuItemInfo1 = new SoundAndVibrateActivity.MenuItemInfo(this, 0, getResources().getString(2131916721), false);
    SoundAndVibrateActivity.MenuItemInfo localMenuItemInfo2 = new SoundAndVibrateActivity.MenuItemInfo(this, 1, getResources().getString(2131916722), false);
    SoundAndVibrateActivity.MenuItemInfo localMenuItemInfo3 = new SoundAndVibrateActivity.MenuItemInfo(this, 2, getResources().getString(2131916723), false);
    SoundAndVibrateActivity.MenuItemInfo localMenuItemInfo4 = new SoundAndVibrateActivity.MenuItemInfo(this, 3, getResources().getString(2131916724), false);
    SoundAndVibrateActivity.MenuItemInfo localMenuItemInfo5 = new SoundAndVibrateActivity.MenuItemInfo(this, 2131439735, getResources().getString(2131887626), false);
    this.u.put(Integer.valueOf(0), localMenuItemInfo1);
    this.u.put(Integer.valueOf(1), localMenuItemInfo2);
    this.u.put(Integer.valueOf(2), localMenuItemInfo3);
    this.u.put(Integer.valueOf(3), localMenuItemInfo4);
    this.u.put(Integer.valueOf(4), localMenuItemInfo5);
  }
  
  public void a()
  {
    this.e = getResources().getDisplayMetrics().density;
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.app.getApp());
    int i2 = this.app.getALLGeneralSettingRing();
    int i3 = this.app.getALLGeneralSettingVibrate();
    this.n = ((FormSwitchItem)findViewById(2131446169));
    this.o = ((FormSwitchItem)findViewById(2131449437));
    this.b = ((FormSwitchItem)findViewById(2131434400));
    this.c = ((FormSwitchItem)findViewById(2131434401));
    this.p = ((FormSimpleItem)findViewById(2131433884));
    this.d = ((FormSimpleItem)findViewById(2131433885));
    if (Build.VERSION.SDK_INT <= 28)
    {
      ViewUtils.setVisible(this.o, 0);
      ViewUtils.setVisible(this.c, 0);
      ViewUtils.setVisible(this.p, 8);
      ViewUtils.setVisible(this.d, 8);
    }
    else
    {
      ViewUtils.setVisible(this.o, 8);
      ViewUtils.setVisible(this.c, 8);
      ViewUtils.setVisible(this.p, 0);
    }
    this.r = ((FormSwitchItem)findViewById(2131446208));
    this.s = ((FormSimpleItem)findViewById(2131446170));
    Object localObject1 = this.s;
    int i1;
    if (this.n.a()) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((FormSimpleItem)localObject1).setVisibility(i1);
    this.C = ((FormSwitchItem)findViewById(2131445884));
    this.D = ((FormSwitchItem)findViewById(2131437714));
    localObject1 = this.app.getCurrentUin();
    boolean bool1 = SettingCloneUtil.readValue(this, (String)localObject1, getString(2131915892), "qqsetting_notify_showcontent_key", true);
    this.C.setChecked(bool1);
    Object localObject2 = this.D;
    if (this.C.a()) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((FormSwitchItem)localObject2).setVisibility(i1);
    this.C.setOnCheckedChangeListener(new SoundAndVibrateActivity.1(this, (String)localObject1));
    boolean bool2 = SettingCloneUtil.readValue(this, (String)localObject1, getString(2131891413), "qqsetting_lock_screen_whenexit_key", true);
    this.D.setChecked(bool2);
    if (NotifyPushSettingFragment.a())
    {
      this.D.setChecked(false);
      this.D.setVisibility(8);
    }
    else if (bool1)
    {
      this.D.setVisibility(0);
    }
    else
    {
      this.D.setVisibility(8);
    }
    this.D.setOnCheckedChangeListener(new SoundAndVibrateActivity.2(this, (String)localObject1));
    if (AppSetting.e) {
      this.D.setContentDescription("锁屏显示消息弹框");
    }
    if (AppSetting.e) {
      this.C.setContentDescription("通知内显示消息内容");
    }
    if (AppSetting.e)
    {
      this.o.setContentDescription(getString(2131917823));
      this.c.setContentDescription(getString(2131890200));
      this.n.setContentDescription(getString(2131916720));
      this.b.setContentDescription(getString(2131890195));
    }
    this.a = findViewById(2131446178);
    this.j = ((FormSimpleItem)findViewById(2131449013));
    this.k = ((FormSimpleItem)findViewById(2131449012));
    this.l = ((FormSimpleItem)findViewById(2131449014));
    f();
    this.m = ((FormSimpleItem)findViewById(2131449015));
    this.B = ((FormSwitchItem)findViewById(2131446168));
    if (i3 != 0)
    {
      this.o.setChecked(true);
      c(0);
      i1 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingVibrate(this.app);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("canVibratorGroup :");
        ((StringBuilder)localObject1).append(i1);
        QLog.d("SoundSetting", 2, ((StringBuilder)localObject1).toString());
      }
      if (i1 == 0) {
        this.c.setChecked(false);
      } else {
        this.c.setChecked(true);
      }
    }
    else
    {
      this.o.setChecked(false);
      c(8);
    }
    if (i2 != 0)
    {
      this.n.setChecked(true);
      this.b.setVisibility(0);
      i1 = SettingCloneUtil.readValueForInt(this, this.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", h);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(this.app.getCurrentAccountUin());
      if ((!localSharedPreferences.getBoolean(((StringBuilder)localObject1).toString(), false)) && (i1 == h))
      {
        localObject1 = localSharedPreferences.edit();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(this.app.getCurrentAccountUin());
        ((SharedPreferences.Editor)localObject1).putBoolean(((StringBuilder)localObject2).toString(), true);
        ((SharedPreferences.Editor)localObject1).commit();
      }
      this.j.setRightIcon(null);
      this.k.setRightIcon(null);
      this.l.setRightIcon(null);
      this.m.setRightIcon(null);
      if (i1 == 2131230720)
      {
        this.j.setRightIcon(getResources().getDrawable(2130853331));
        d(0);
        if (AppSetting.e)
        {
          localObject1 = this.j;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(getString(2131916721));
          ((StringBuilder)localObject2).append(getString(2131887795));
          ((FormSimpleItem)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
        }
      }
      else if (i1 == 2131230721)
      {
        this.k.setRightIcon(getResources().getDrawable(2130853331));
        d(1);
        if (AppSetting.e)
        {
          localObject1 = this.k;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(getString(2131916722));
          ((StringBuilder)localObject2).append(getString(2131887795));
          ((FormSimpleItem)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
        }
      }
      else if (i1 == g)
      {
        this.l.setRightIcon(getResources().getDrawable(2130853331));
        d(2);
        if (AppSetting.e)
        {
          localObject1 = this.l;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(getString(2131916723));
          ((StringBuilder)localObject2).append(getString(2131887795));
          ((FormSimpleItem)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
        }
      }
      else if (i1 == h)
      {
        this.m.setRightIcon(getResources().getDrawable(2130853331));
        d(3);
        SettingCloneUtil.writeValueForInt(this, this.app.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", h);
      }
      else
      {
        this.k.setRightIcon(getResources().getDrawable(2130853331));
        d(1);
      }
      i1 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingRing(this.app);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("canPlayGroupSound :");
        ((StringBuilder)localObject1).append(i1);
        QLog.d("SoundSetting", 2, ((StringBuilder)localObject1).toString());
      }
      if (i1 == 0) {
        this.b.setChecked(false);
      } else {
        this.b.setChecked(true);
      }
      localObject1 = ThemeUtil.getUserCurrentThemeId(this.app);
      if (!((String)localObject1).equals("1000"))
      {
        localObject1 = ThemeUtil.getThemeInfo(this, (String)localObject1);
        if ((localObject1 != null) && (((ThemeUtil.ThemeInfo)localObject1).isVoiceTheme))
        {
          i1 = 1;
          break label1422;
        }
      }
      i1 = 0;
      label1422:
      if (i1 != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("theme_voice_setting_");
        ((StringBuilder)localObject1).append(this.app.getCurrentAccountUin());
        if (localSharedPreferences.getBoolean(((StringBuilder)localObject1).toString(), true)) {
          this.B.setChecked(true);
        } else {
          this.B.setChecked(false);
        }
      }
      else
      {
        this.B.setVisibility(8);
      }
    }
    else
    {
      this.n.setChecked(false);
      this.b.setVisibility(8);
      this.B.setVisibility(8);
      this.s.setVisibility(8);
    }
    this.j.setOnClickListener(new SoundAndVibrateActivity.3(this));
    this.k.setOnClickListener(new SoundAndVibrateActivity.4(this));
    this.l.setOnClickListener(new SoundAndVibrateActivity.5(this));
    this.m.setOnClickListener(new SoundAndVibrateActivity.6(this));
    if (this.n.a()) {
      this.n.setBackgroundResource(2130839638);
    } else {
      this.n.setBackgroundResource(2130839622);
    }
    this.n.setOnCheckedChangeListener(new SoundAndVibrateActivity.7(this));
    if (this.o.a()) {
      this.o.setBackgroundResource(2130839638);
    } else {
      this.o.setBackgroundResource(2130839622);
    }
    this.o.setOnCheckedChangeListener(new SoundAndVibrateActivity.8(this));
    this.b.setOnCheckedChangeListener(new SoundAndVibrateActivity.9(this));
    this.c.setOnCheckedChangeListener(new SoundAndVibrateActivity.10(this));
    this.p.setOnClickListener(new SoundAndVibrateActivity.11(this));
    this.d.setOnClickListener(new SoundAndVibrateActivity.12(this));
    this.B.setOnCheckedChangeListener(new SoundAndVibrateActivity.13(this, localSharedPreferences));
    this.r = ((FormSwitchItem)findViewById(2131446208));
    this.t = ((TextView)findViewById(2131446209));
    a(this.t);
    this.r.setOnCheckedChangeListener(new SoundAndVibrateActivity.14(this));
    this.s.setOnClickListener(new SoundAndVibrateActivity.15(this));
    if (this.s.getVisibility() == 0) {
      VasWebviewUtil.a(this.app.getCurrentAccountUin(), "bell", "show", "", 1, 0, 0, "", "", "");
    }
    d();
  }
  
  public void a(int paramInt)
  {
    this.f.a(this.s, paramInt);
  }
  
  /* Error */
  void a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 660	com/tencent/mobileqq/activity/SoundAndVibrateActivity:q	Landroid/media/MediaPlayer;
    //   4: ifnonnull +14 -> 18
    //   7: aload_0
    //   8: new 662	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   11: dup
    //   12: invokespecial 663	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   15: putfield 660	com/tencent/mobileqq/activity/SoundAndVibrateActivity:q	Landroid/media/MediaPlayer;
    //   18: aconst_null
    //   19: astore 5
    //   21: aconst_null
    //   22: astore 6
    //   24: aconst_null
    //   25: astore 4
    //   27: aload 5
    //   29: astore_2
    //   30: aload 6
    //   32: astore_3
    //   33: aload_0
    //   34: getfield 660	com/tencent/mobileqq/activity/SoundAndVibrateActivity:q	Landroid/media/MediaPlayer;
    //   37: ifnonnull +4 -> 41
    //   40: return
    //   41: aload 5
    //   43: astore_2
    //   44: aload 6
    //   46: astore_3
    //   47: aload_0
    //   48: getfield 660	com/tencent/mobileqq/activity/SoundAndVibrateActivity:q	Landroid/media/MediaPlayer;
    //   51: invokevirtual 668	android/media/MediaPlayer:reset	()V
    //   54: aload 5
    //   56: astore_2
    //   57: aload 6
    //   59: astore_3
    //   60: aload_1
    //   61: invokevirtual 671	android/net/Uri:getScheme	()Ljava/lang/String;
    //   64: ldc_w 673
    //   67: invokevirtual 573	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifeq +72 -> 142
    //   73: aload 5
    //   75: astore_2
    //   76: aload 6
    //   78: astore_3
    //   79: new 675	java/io/FileInputStream
    //   82: dup
    //   83: new 677	java/io/File
    //   86: dup
    //   87: aload_1
    //   88: invokevirtual 680	android/net/Uri:getPath	()Ljava/lang/String;
    //   91: invokespecial 681	java/io/File:<init>	(Ljava/lang/String;)V
    //   94: invokespecial 684	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   97: astore_1
    //   98: aload_0
    //   99: getfield 660	com/tencent/mobileqq/activity/SoundAndVibrateActivity:q	Landroid/media/MediaPlayer;
    //   102: aload_1
    //   103: invokevirtual 688	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   106: invokevirtual 692	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   109: aload_0
    //   110: getfield 660	com/tencent/mobileqq/activity/SoundAndVibrateActivity:q	Landroid/media/MediaPlayer;
    //   113: iconst_3
    //   114: invokevirtual 695	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   117: aload_0
    //   118: getfield 660	com/tencent/mobileqq/activity/SoundAndVibrateActivity:q	Landroid/media/MediaPlayer;
    //   121: invokevirtual 698	android/media/MediaPlayer:prepare	()V
    //   124: aload_1
    //   125: invokevirtual 701	java/io/FileInputStream:close	()V
    //   128: goto +59 -> 187
    //   131: astore_2
    //   132: aload_1
    //   133: astore_3
    //   134: aload_2
    //   135: astore_1
    //   136: goto +86 -> 222
    //   139: goto +101 -> 240
    //   142: aload 5
    //   144: astore_2
    //   145: aload 6
    //   147: astore_3
    //   148: aload_0
    //   149: getfield 660	com/tencent/mobileqq/activity/SoundAndVibrateActivity:q	Landroid/media/MediaPlayer;
    //   152: aload_0
    //   153: aload_1
    //   154: invokevirtual 704	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   157: aload 5
    //   159: astore_2
    //   160: aload 6
    //   162: astore_3
    //   163: aload_0
    //   164: getfield 660	com/tencent/mobileqq/activity/SoundAndVibrateActivity:q	Landroid/media/MediaPlayer;
    //   167: iconst_3
    //   168: invokevirtual 695	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   171: aload 5
    //   173: astore_2
    //   174: aload 6
    //   176: astore_3
    //   177: aload_0
    //   178: getfield 660	com/tencent/mobileqq/activity/SoundAndVibrateActivity:q	Landroid/media/MediaPlayer;
    //   181: invokevirtual 698	android/media/MediaPlayer:prepare	()V
    //   184: aload 4
    //   186: astore_1
    //   187: aload_1
    //   188: astore_2
    //   189: aload_1
    //   190: astore_3
    //   191: aload_0
    //   192: getfield 660	com/tencent/mobileqq/activity/SoundAndVibrateActivity:q	Landroid/media/MediaPlayer;
    //   195: invokevirtual 707	android/media/MediaPlayer:start	()V
    //   198: aload_1
    //   199: astore_2
    //   200: aload_1
    //   201: astore_3
    //   202: aload_0
    //   203: getfield 660	com/tencent/mobileqq/activity/SoundAndVibrateActivity:q	Landroid/media/MediaPlayer;
    //   206: iconst_0
    //   207: invokevirtual 710	android/media/MediaPlayer:setLooping	(Z)V
    //   210: aload_1
    //   211: ifnull +43 -> 254
    //   214: aload_1
    //   215: invokevirtual 701	java/io/FileInputStream:close	()V
    //   218: return
    //   219: astore_1
    //   220: aload_2
    //   221: astore_3
    //   222: aload_3
    //   223: ifnull +15 -> 238
    //   226: aload_3
    //   227: invokevirtual 701	java/io/FileInputStream:close	()V
    //   230: goto +8 -> 238
    //   233: astore_2
    //   234: aload_2
    //   235: invokevirtual 711	java/io/IOException:printStackTrace	()V
    //   238: aload_1
    //   239: athrow
    //   240: aload_1
    //   241: ifnull +13 -> 254
    //   244: aload_1
    //   245: invokevirtual 701	java/io/FileInputStream:close	()V
    //   248: return
    //   249: astore_1
    //   250: aload_1
    //   251: invokevirtual 711	java/io/IOException:printStackTrace	()V
    //   254: return
    //   255: astore_1
    //   256: aload_3
    //   257: astore_1
    //   258: goto -18 -> 240
    //   261: astore_2
    //   262: goto -123 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	SoundAndVibrateActivity
    //   0	265	1	paramUri	Uri
    //   29	47	2	localObject1	Object
    //   131	4	2	localObject2	Object
    //   144	77	2	localObject3	Object
    //   233	2	2	localIOException	java.io.IOException
    //   261	1	2	localException	Exception
    //   32	225	3	localObject4	Object
    //   25	160	4	localObject5	Object
    //   19	153	5	localObject6	Object
    //   22	153	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   98	128	131	finally
    //   33	40	219	finally
    //   47	54	219	finally
    //   60	73	219	finally
    //   79	98	219	finally
    //   148	157	219	finally
    //   163	171	219	finally
    //   177	184	219	finally
    //   191	198	219	finally
    //   202	210	219	finally
    //   226	230	233	java/io/IOException
    //   214	218	249	java/io/IOException
    //   244	248	249	java/io/IOException
    //   33	40	255	java/lang/Exception
    //   47	54	255	java/lang/Exception
    //   60	73	255	java/lang/Exception
    //   79	98	255	java/lang/Exception
    //   148	157	255	java/lang/Exception
    //   163	171	255	java/lang/Exception
    //   177	184	255	java/lang/Exception
    //   191	198	255	java/lang/Exception
    //   202	210	255	java/lang/Exception
    //   98	128	261	java/lang/Exception
  }
  
  Boolean b()
  {
    if ((!this.app.isRingerVibrate()) && (!this.app.isRingEqualsZero()) && (this.app.isCallIdle()) && ((this.app.getCheckPttListener() == null) || (!this.app.getCheckPttListener().ac()))) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  void b(int paramInt)
  {
    FormSimpleItem localFormSimpleItem;
    StringBuilder localStringBuilder;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          this.j.setRightIcon(null);
          this.k.setRightIcon(null);
          this.l.setRightIcon(null);
          this.m.setRightIcon(getResources().getDrawable(2130853331));
          if (AppSetting.e)
          {
            localFormSimpleItem = this.j;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(getString(2131916721));
            localStringBuilder.append(getString(2131917725));
            localFormSimpleItem.setContentDescription(localStringBuilder.toString());
            localFormSimpleItem = this.k;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(getString(2131916722));
            localStringBuilder.append(getString(2131917725));
            localFormSimpleItem.setContentDescription(localStringBuilder.toString());
            localFormSimpleItem = this.l;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(getString(2131916723));
            localStringBuilder.append(getString(2131917725));
            localFormSimpleItem.setContentDescription(localStringBuilder.toString());
            localFormSimpleItem = this.m;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(getString(2131916724));
            localStringBuilder.append(getString(2131887795));
            localFormSimpleItem.setContentDescription(localStringBuilder.toString());
          }
          ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "4", "", "", "");
          return;
        }
        this.j.setRightIcon(null);
        this.k.setRightIcon(null);
        this.l.setRightIcon(getResources().getDrawable(2130853331));
        this.m.setRightIcon(null);
        if (AppSetting.e)
        {
          localFormSimpleItem = this.j;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(getString(2131916721));
          localStringBuilder.append(getString(2131917725));
          localFormSimpleItem.setContentDescription(localStringBuilder.toString());
          localFormSimpleItem = this.k;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(getString(2131916722));
          localStringBuilder.append(getString(2131917725));
          localFormSimpleItem.setContentDescription(localStringBuilder.toString());
          localFormSimpleItem = this.l;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(getString(2131916723));
          localStringBuilder.append(getString(2131887795));
          localFormSimpleItem.setContentDescription(localStringBuilder.toString());
          localFormSimpleItem = this.m;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(getString(2131916724));
          localStringBuilder.append(getString(2131917725));
          localFormSimpleItem.setContentDescription(localStringBuilder.toString());
        }
        ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "3", "", "", "");
        return;
      }
      this.j.setRightIcon(null);
      this.k.setRightIcon(getResources().getDrawable(2130853331));
      this.l.setRightIcon(null);
      this.m.setRightIcon(null);
      if (AppSetting.e)
      {
        localFormSimpleItem = this.j;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(getString(2131916721));
        localStringBuilder.append(getString(2131917725));
        localFormSimpleItem.setContentDescription(localStringBuilder.toString());
        localFormSimpleItem = this.k;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(getString(2131916722));
        localStringBuilder.append(getString(2131887795));
        localFormSimpleItem.setContentDescription(localStringBuilder.toString());
        localFormSimpleItem = this.l;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(getString(2131916723));
        localStringBuilder.append(getString(2131917725));
        localFormSimpleItem.setContentDescription(localStringBuilder.toString());
        localFormSimpleItem = this.m;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(getString(2131916724));
        localStringBuilder.append(getString(2131917725));
        localFormSimpleItem.setContentDescription(localStringBuilder.toString());
      }
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "1", "", "", "");
      return;
    }
    this.j.setRightIcon(getResources().getDrawable(2130853331));
    this.k.setRightIcon(null);
    this.l.setRightIcon(null);
    this.m.setRightIcon(null);
    if (AppSetting.e)
    {
      localFormSimpleItem = this.j;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131916721));
      localStringBuilder.append(getString(2131887795));
      localFormSimpleItem.setContentDescription(localStringBuilder.toString());
      localFormSimpleItem = this.k;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131916722));
      localStringBuilder.append(getString(2131917725));
      localFormSimpleItem.setContentDescription(localStringBuilder.toString());
      localFormSimpleItem = this.l;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131916723));
      localStringBuilder.append(getString(2131917725));
      localFormSimpleItem.setContentDescription(localStringBuilder.toString());
      localFormSimpleItem = this.m;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131916724));
      localStringBuilder.append(getString(2131917725));
      localFormSimpleItem.setContentDescription(localStringBuilder.toString());
    }
    ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Select_sound", 0, 0, "2", "", "", "");
  }
  
  void c()
  {
    MediaPlayer localMediaPlayer = this.q;
    if ((localMediaPlayer != null) && (localMediaPlayer.isPlaying())) {
      this.q.stop();
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131629297);
    setTitle(getString(2131892201));
    this.f = MessageNotificationSettingManager.a(this.app);
    this.f.a(this);
    a();
    return false;
  }
  
  protected void doOnDestroy()
  {
    c();
    MediaPlayer localMediaPlayer = this.q;
    if (localMediaPlayer != null)
    {
      localMediaPlayer.release();
      this.q = null;
    }
    this.f.b(this);
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    int i1 = this.f.b();
    this.f.a(this.s, i1);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SoundAndVibrateActivity
 * JD-Core Version:    0.7.0.1
 */