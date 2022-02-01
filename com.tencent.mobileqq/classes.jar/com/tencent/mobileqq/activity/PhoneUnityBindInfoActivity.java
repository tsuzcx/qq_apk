package com.tencent.mobileqq.activity;

import Override;
import aetk;
import aetl;
import aetm;
import aets;
import aett;
import aetu;
import aetv;
import aetw;
import aetx;
import aety;
import aetz;
import ajby;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anni;
import anus;
import anut;
import asfl;
import asfn;
import asfr;
import bcst;
import bglp;
import bgnt;
import bgpa;
import bkho;
import bkif;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;
import java.util.ArrayList;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class PhoneUnityBindInfoActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  public int a;
  public ajby a;
  public BroadcastReceiver a;
  public Bundle a;
  public RelativeLayout a;
  public TextView a;
  public anut a;
  public bgpa a;
  public bkho a;
  private DevlockInfo a;
  public boolean a;
  private Bundle b;
  public RelativeLayout b;
  public bgpa b;
  public boolean b;
  public RelativeLayout c;
  private bgpa c;
  public boolean c;
  private bgpa d;
  public boolean d;
  public boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  
  public PhoneUnityBindInfoActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aetk(this);
    this.jdField_a_of_type_Anut = new aetm(this);
  }
  
  private static int a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    do
    {
      return 0;
      paramBundle = a(paramBundle);
    } while (paramBundle == null);
    int j = paramBundle.length;
    int i = 0;
    label20:
    Object localObject;
    if (i < j)
    {
      localObject = paramBundle[i];
      if (localObject != null) {
        break label40;
      }
    }
    label40:
    while (localObject.getInt("phone_type", 0) != 8)
    {
      i += 1;
      break label20;
      break;
    }
    return localObject.getInt("status", 0);
  }
  
  public static SpannableStringBuilder a(String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, paramString.length(), 18);
    return localSpannableStringBuilder;
  }
  
  private String a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      Button localButton = (Button)findViewById(2131364295);
      String str = paramBundle.getString("phone");
      if (!TextUtils.isEmpty(str))
      {
        this.f = true;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        localButton.setText(2131694197);
      }
      for (;;)
      {
        return str;
        aetz.a(this.app, "0X800AE4B");
        this.f = false;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694205);
        localButton.setText(2131694191);
        if (!paramBundle.containsKey("skip_url")) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(true, false, 17);
        }
      }
    }
    return "";
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.e) {
      return;
    }
    String str2 = paramBundle.getString("country_code");
    String str1 = paramBundle.getString("phone");
    Object localObject3 = "";
    Object localObject2 = "";
    Object localObject4 = paramBundle.getParcelableArray("phone_info");
    int i;
    Object localObject1;
    if (localObject4 != null)
    {
      i = 0;
      localObject1 = str1;
      paramBundle = (Bundle)localObject3;
      if (i < localObject4.length)
      {
        localObject3 = (Bundle)localObject4[i];
        if (localObject3 == null)
        {
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = paramBundle;
          paramBundle = (Bundle)localObject3;
        }
        for (;;)
        {
          i += 1;
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = paramBundle;
          paramBundle = (Bundle)localObject3;
          break;
          switch (((Bundle)localObject3).getInt("phone_type", 0))
          {
          default: 
            localObject3 = paramBundle;
            paramBundle = (Bundle)localObject1;
            localObject1 = localObject2;
            localObject2 = localObject3;
            break;
          case 1: 
            localObject3 = ((Bundle)localObject3).getString("phone");
            localObject1 = localObject2;
            localObject2 = paramBundle;
            paramBundle = (Bundle)localObject3;
            break;
          case 8: 
            localObject3 = ((Bundle)localObject3).getString("phone");
            localObject2 = paramBundle;
            paramBundle = (Bundle)localObject1;
            localObject1 = localObject3;
            break;
          case 4: 
            localObject3 = ((Bundle)localObject3).getString("phone");
            paramBundle = (Bundle)localObject1;
            localObject1 = localObject2;
            localObject2 = localObject3;
          }
        }
      }
      localObject3 = localObject2;
      localObject2 = paramBundle;
      paramBundle = (Bundle)localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      localObject3 = this.jdField_a_of_type_Bkho;
      if (localObject3 != null) {
        ((bkho)localObject3).dismiss();
      }
      if ((paramBundle != null) && (((paramBundle.equals(localObject2)) && (!paramBundle.equals(localObject1))) || ((TextUtils.isEmpty((CharSequence)localObject2)) && (!paramBundle.equals(localObject1)))))
      {
        g();
        return;
      }
      localObject3 = (bkho)bkif.a(this, null);
      ((bkho)localObject3).a(true);
      this.jdField_a_of_type_Bkho = ((bkho)localObject3);
      localObject4 = LayoutInflater.from(this).inflate(2131559557, null);
      if (localObject4 != null)
      {
        ((View)localObject4).setOnClickListener(new aett(this));
        Object localObject6 = Bitmap.Config.ARGB_8888;
        Object localObject5 = (LinearLayout)((View)localObject4).findViewById(2131372339);
        if (localObject5 != null)
        {
          TextView localTextView = (TextView)((LinearLayout)localObject5).findViewById(2131372341);
          if ((localTextView != null) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.equals((CharSequence)localObject2, paramBundle)))
          {
            ((LinearLayout)localObject5).setVisibility(0);
            i = (int)localTextView.getTextSize();
            localObject6 = Bitmap.createBitmap(i * 2, i * 2, (Bitmap.Config)localObject6);
            localObject6 = new ImageSpan(getApplicationContext(), (Bitmap)localObject6);
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(anni.a(2131706807));
            localSpannableStringBuilder.setSpan(localObject6, 1, 2, 33);
            ((TextView)((LinearLayout)localObject5).findViewById(2131372340)).setText(localSpannableStringBuilder);
            localTextView.setText((CharSequence)localObject2);
          }
        }
        localObject2 = (LinearLayout)((View)localObject4).findViewById(2131372330);
        if (localObject2 != null)
        {
          localObject5 = (TextView)((LinearLayout)localObject2).findViewById(2131372332);
          if ((localObject5 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.equals((CharSequence)localObject1, paramBundle)))
          {
            ((LinearLayout)localObject2).setVisibility(0);
            ((TextView)localObject5).setText((CharSequence)localObject1);
          }
        }
        localObject1 = (LinearLayout)((View)localObject4).findViewById(2131372357);
        if (localObject1 != null)
        {
          localObject2 = (TextView)((View)localObject4).findViewById(2131372365);
          if ((localObject2 != null) && (!TextUtils.isEmpty(paramBundle)))
          {
            ((LinearLayout)localObject1).setVisibility(0);
            ((TextView)localObject2).setText(paramBundle);
          }
        }
        ((View)localObject4).setBackgroundResource(2130850649);
        ((bkho)localObject3).b((View)localObject4);
      }
      ((bkho)localObject3).a(a(String.format(super.getString(2131694194), new Object[] { paramBundle })), 8);
      ((bkho)localObject3).a(super.getString(2131694193), 8);
      ((bkho)localObject3).a(super.getString(2131690582), 8);
      ((bkho)localObject3).setOnCancelListener(new aetu(this));
      ((bkho)localObject3).a(new aetv(this));
      ((bkho)localObject3).a(new aetw(this, str2, str1, (bkho)localObject3));
      localObject2 = ((bkho)localObject3).a();
      localObject1 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = new RelativeLayout.LayoutParams(-2, -2);
      }
      paramBundle.addRule(12, 0);
      paramBundle.addRule(13, -1);
      paramBundle.setMargins(80, 0, 80, 0);
      ((RelativeLayout)localObject2).setLayoutParams(paramBundle);
      ((bkho)localObject3).show();
      bcst.b(this.app, "dc00898", "", "", "0X8009EC7", "0X8009EC7", 0, 0, "", "", "", "");
      return;
      localObject1 = "";
      localObject2 = "";
      paramBundle = str1;
    }
  }
  
  private void a(Bundle paramBundle, String paramString)
  {
    int m = 1;
    paramBundle = a(paramBundle);
    int k;
    if (paramBundle != null)
    {
      int j = 0;
      i = 1;
      k = i;
      if (j < paramBundle.length)
      {
        Object localObject = paramBundle[j];
        if (localObject == null) {}
        for (;;)
        {
          j += 1;
          break;
          switch (localObject.getInt("phone_type", 0))
          {
          default: 
            break;
          case 4: 
            i = localObject.getInt("status", 0);
            break;
          case 16: 
            localObject.getInt("status", 0);
          }
        }
      }
    }
    else
    {
      k = 1;
    }
    l();
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramBundle = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      if (k != 2) {
        break label181;
      }
    }
    label181:
    for (int i = m;; i = 3)
    {
      a(paramBundle, i, k);
      return;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      break;
    }
  }
  
  private void a(RelativeLayout paramRelativeLayout, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (paramRelativeLayout == null) {}
    Object localObject;
    int i;
    label47:
    label72:
    label97:
    do
    {
      return;
      if (paramInt1 != 1) {
        break;
      }
      localObject = this;
      paramRelativeLayout.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)paramRelativeLayout.findViewById(2131374408);
      if (localObject != null)
      {
        if (paramInt1 != 1) {
          break label200;
        }
        i = 0;
        ((TextView)localObject).setVisibility(i);
        if (paramInt1 == 1)
        {
          if (paramInt2 != 2) {
            break label207;
          }
          ((TextView)localObject).setText(2131694215);
        }
      }
      localObject = (ProgressBar)paramRelativeLayout.findViewById(2131374407);
      if (localObject != null)
      {
        if (paramInt1 != 2) {
          break label260;
        }
        i = 0;
        ((ProgressBar)localObject).setVisibility(i);
        if (AppSetting.jdField_c_of_type_Boolean) {
          ((ProgressBar)localObject).setContentDescription(super.getString(2131694216));
        }
      }
      localObject = (Button)paramRelativeLayout.findViewById(2131374403);
      if (localObject != null)
      {
        ((Button)localObject).setOnClickListener(this);
        if (paramInt1 != 3) {
          break label267;
        }
        i = 0;
        ((Button)localObject).setVisibility(i);
      }
      paramRelativeLayout = (ImageView)paramRelativeLayout.findViewById(2131374402);
    } while (paramRelativeLayout == null);
    label153:
    if ((paramInt1 != 3) && (paramInt2 != 4)) {}
    for (paramInt1 = j;; paramInt1 = 8)
    {
      paramRelativeLayout.setVisibility(paramInt1);
      return;
      localObject = null;
      break;
      label200:
      i = 8;
      break label47;
      label207:
      if (paramInt2 == 4)
      {
        ((TextView)localObject).setText(2131694218);
        paramRelativeLayout.setOnClickListener(null);
        break label72;
      }
      if (paramInt2 == 3)
      {
        ((TextView)localObject).setText(2131694189);
        break label72;
      }
      if (paramInt2 != 1) {
        break label72;
      }
      ((TextView)localObject).setText(2131694217);
      break label72;
      label260:
      i = 8;
      break label97;
      label267:
      i = 8;
      break label153;
    }
  }
  
  private void a(DevlockInfo paramDevlockInfo)
  {
    this.g = false;
    k();
    if (paramDevlockInfo == null)
    {
      QLog.i("IphoneTitleBarActivity", 1, "onGetDevlockInfo, fail");
      return;
    }
    QLog.i("IphoneTitleBarActivity", 1, "fetchSecurePhoneNum, success");
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = paramDevlockInfo;
    asfl.a().a(paramDevlockInfo.TransferInfo);
    TextView localTextView = (TextView)findViewById(2131363464);
    Button localButton = (Button)findViewById(2131364296);
    if (TextUtils.isEmpty(paramDevlockInfo.Mobile))
    {
      aetz.a(this.app, "0X800AE4C");
      localTextView.setText(2131694205);
      localButton.setText(2131694191);
      if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
    for (;;)
    {
      b(paramDevlockInfo);
      return;
      localTextView.setText(paramDevlockInfo.Mobile);
      localButton.setText(2131694197);
      if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
    }
  }
  
  private void a(boolean paramBoolean1, Bundle paramBundle, boolean paramBoolean2)
  {
    boolean bool = true;
    j();
    if (paramBoolean1) {
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    }
    if (paramBundle == null) {}
    label153:
    label156:
    for (;;)
    {
      return;
      String str1 = a(paramBundle);
      a(paramBundle, str1);
      int i;
      String str2;
      if (paramBundle.getInt("need_unify", 0) == 1)
      {
        i = 1;
        str2 = paramBundle.getString("skip_url");
        if ((!paramBoolean2) || (TextUtils.isEmpty(str2))) {
          break label95;
        }
      }
      label95:
      for (int j = 1;; j = 0)
      {
        if ((j != 0) || (i == 0)) {
          break label101;
        }
        a(paramBundle);
        return;
        i = 0;
        break;
      }
      label101:
      if (j != 0)
      {
        b(str2);
        return;
      }
      if (a(paramBundle) == 2)
      {
        paramBoolean1 = true;
        if (TextUtils.isEmpty(str1)) {
          break label153;
        }
      }
      for (paramBoolean2 = bool;; paramBoolean2 = false)
      {
        if (!a(paramBoolean1, paramBoolean2)) {
          break label156;
        }
        m();
        return;
        paramBoolean1 = false;
        break;
      }
    }
  }
  
  private boolean a()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("last_time_recommend_dialog" + this.app.getCurrentAccountUin(), 0);
    long l1 = localSharedPreferences.getLong("last_time", 0L);
    if (localSharedPreferences.getLong("duration", -1L) != -1L) {}
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 2592000000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "isOverTimeThirtyDays is overtime 30 days, so show dialog tips!");
      }
      localSharedPreferences.edit().putLong("last_time", l2).apply();
      bool = true;
    }
    while (!QLog.isColorLevel()) {
      return bool;
    }
    QLog.d("IphoneTitleBarActivity", 2, "isOverTimeThirtyDays is in 30 days, so do not show dialog tips! duration = " + 2592000000L);
    return false;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "isNeedShowTips isDevLock = " + paramBoolean1 + ", isBindPhoneNumber = " + paramBoolean2 + ", isBackFromDevLock = " + this.h);
    }
    if (paramBoolean1) {
      return false;
    }
    if (this.h)
    {
      this.h = false;
      return false;
    }
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.app.getManager(11);
    int i = localPhoneContactManagerImp.d();
    if (((i != 8) && (i != 9)) || (!localPhoneContactManagerImp.k())) {}
    for (paramBoolean1 = false;; paramBoolean1 = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarActivity", 2, "isNeedShowTips isOpenContact = " + paramBoolean1);
      }
      if (((!paramBoolean2) && (!paramBoolean1)) || (!a())) {
        break;
      }
      return true;
    }
  }
  
  private static Bundle[] a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getParcelableArray("phone_info");
    if ((paramBundle == null) || (paramBundle.length == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramBundle.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramBundle[i];
      if ((localObject instanceof Bundle)) {
        localArrayList.add((Bundle)localObject);
      }
      i += 1;
    }
    return (Bundle[])localArrayList.toArray(new Bundle[localArrayList.size()]);
  }
  
  private void b()
  {
    if (this.g)
    {
      QLog.i("IphoneTitleBarActivity", 1, "fetchSecurePhoneNum, in progress");
      return;
    }
    this.g = true;
    i();
    QLog.i("IphoneTitleBarActivity", 1, "fetchSecurePhoneNum, start");
    WeakReference localWeakReference = new WeakReference(this);
    asfr.a().a(this.app, this.app.getCurrentAccountUin(), new aets(this, localWeakReference));
  }
  
  private void b(String paramString)
  {
    paramString = new StringBuilder(paramString);
    paramString.append("?");
    paramString.append("type=" + asfn.d);
    paramString.append("&plat=1");
    paramString.append("&app=1");
    paramString.append("&version=8.4.1.4680");
    paramString.append("&device=" + URLEncoder.encode(Build.DEVICE));
    paramString.append("&system=" + Build.VERSION.RELEASE);
    paramString.append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
    paramString = paramString.toString();
    Intent localIntent = new Intent(this, PhoneUnityVerifyActivity.class);
    localIntent.putExtra("url", paramString);
    super.startActivityForResult(localIntent, 1006);
    BaseActivity.sTopActivity.overridePendingTransition(2130771997, 0);
  }
  
  private void b(DevlockInfo paramDevlockInfo)
  {
    boolean bool2 = false;
    if (paramDevlockInfo.DevSetup == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!TextUtils.isEmpty(paramDevlockInfo.Mobile)) {
        bool2 = true;
      }
      QLog.i("IphoneTitleBarActivity", 1, "setDevLockLayoutStatus, open=" + bool1 + "phoneSet=" + bool2);
      if (!bool2) {
        break label108;
      }
      if (asfl.a().a() != asfl.c) {
        break;
      }
      a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, 1, 4);
      return;
    }
    if (bool1)
    {
      a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, 1, 2);
      return;
    }
    label108:
    a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, 3, 1);
  }
  
  private void c()
  {
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    localIntent.putExtra("kSrouce", this.jdField_a_of_type_Int);
    super.startActivityForResult(localIntent, 1003);
  }
  
  private void c(DevlockInfo paramDevlockInfo)
  {
    if (paramDevlockInfo == null)
    {
      QLog.i("IphoneTitleBarActivity", 1, "dev lock info not exists");
      b();
    }
    do
    {
      return;
      Intent localIntent;
      if (TextUtils.isEmpty(paramDevlockInfo.Mobile))
      {
        QLog.i("IphoneTitleBarActivity", 1, "onClickChangeSecurePhone, no secure phone");
        localIntent = new Intent(this, AuthDevOpenUgActivity.class);
        localIntent.putExtra("DevlockInfo", paramDevlockInfo);
        startActivityForResult(localIntent, 0);
        return;
      }
      if (paramDevlockInfo.AllowSet == 0)
      {
        QLog.i("IphoneTitleBarActivity", 1, "onClickChangeSecurePhone, allow set is 0");
        localIntent = new Intent(this, AuthDevOpenUgActivity.class);
        localIntent.putExtra("DevlockInfo", paramDevlockInfo);
        startActivityForResult(localIntent, 0);
        return;
      }
    } while (paramDevlockInfo.AllowSet != 1);
    QLog.i("IphoneTitleBarActivity", 1, "onClickChangeSecurePhone, allow set is 1");
    asfn.a(this, this.app, asfn.jdField_a_of_type_Int, 1003, null);
  }
  
  private void d()
  {
    Intent localIntent = new Intent(this, PhoneUnityChangeActivity.class);
    localIntent.putExtra("kSrouce", this.jdField_a_of_type_Int);
    super.startActivityForResult(localIntent, 1004);
    bcst.b(this.app, "dc00898", "", "", "0X8009EC2", "0X8009EC2", 0, 0, "", "", "", "");
  }
  
  private void e()
  {
    if (!this.f)
    {
      c();
      return;
    }
    d();
  }
  
  private void f()
  {
    QLog.i("IphoneTitleBarActivity", 1, "openDevLockSetting");
    this.h = true;
    bcst.b(this.app, "CliOper", "", "", "0X8005B84", "0X8005B84", 0, 0, "", "", "", "");
    Object localObject = new IntentFilter("mqq.intent.action.DEVLOCK_ROAM");
    super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    localObject = new Intent();
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    ((Intent)localObject).putExtra("devlock_open_source", "PhoneUnity");
    ((Intent)localObject).putExtra("enable_open_allowset_dev", true);
    ((Intent)localObject).setData(Uri.parse("mqqdevlock://devlock/open?"));
    super.startActivity((Intent)localObject);
  }
  
  private void g()
  {
    aetz.a(this.app, "0X800AE50");
    QLog.i("IphoneTitleBarActivity", 1, "showUnityPromptDialog");
    if (this.jdField_d_of_type_Bgpa == null)
    {
      bgpa localbgpa = bglp.a(this, 230);
      localbgpa.setCancelable(true);
      localbgpa.adjustMessageTopBottomMargin(8.0F, 40.0F);
      localbgpa.setTitle(2131694203);
      localbgpa.setMessage(2131694202);
      localbgpa.setPositiveButton(2131694254, new aetx(this));
      this.jdField_d_of_type_Bgpa = localbgpa;
    }
    if ((!this.jdField_d_of_type_Bgpa.isShowing()) && (!isFinishing())) {
      this.jdField_d_of_type_Bgpa.show();
    }
  }
  
  private void h()
  {
    a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 2, 1);
    Button localButton = (Button)super.findViewById(2131364295);
    if (localButton != null) {
      localButton.setOnClickListener(null);
    }
  }
  
  private void i()
  {
    a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, 2, 1);
    Button localButton = (Button)super.findViewById(2131364296);
    if (localButton != null) {
      localButton.setOnClickListener(null);
    }
  }
  
  private void j()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      localObject = (ProgressBar)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131374407);
      if (localObject != null) {
        ((ProgressBar)localObject).setVisibility(8);
      }
    }
    Object localObject = (Button)super.findViewById(2131364295);
    if (localObject != null) {
      ((Button)localObject).setOnClickListener(this);
    }
  }
  
  private void k()
  {
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null)
    {
      localObject = (ProgressBar)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131374407);
      if (localObject != null) {
        ((ProgressBar)localObject).setVisibility(8);
      }
    }
    Object localObject = (Button)super.findViewById(2131364296);
    if (localObject != null) {
      ((Button)localObject).setOnClickListener(this);
    }
  }
  
  private void l()
  {
    Object localObject = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374406);
    if (localObject != null) {
      ((TextView)localObject).setText(2131694198);
    }
    localObject = (PhoneContactManagerImp)this.app.getManager(11);
    int i = ((PhoneContactManagerImp)localObject).d();
    if (((i != 8) && (i != 9)) || (!((PhoneContactManagerImp)localObject).k())) {}
    for (localObject = anni.a(2131706794);; localObject = anni.a(2131706804))
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374408);
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)localObject);
        localTextView.setVisibility(0);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374407);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374403);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374402);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      return;
    }
  }
  
  private void m()
  {
    if (this.jdField_c_of_type_Bgpa == null)
    {
      this.jdField_c_of_type_Bgpa = bglp.a(this, 0, super.getString(2131717843), super.getString(2131717844), super.getString(2131717841), super.getString(2131717842), new aety(this), new aetl(this));
      this.jdField_c_of_type_Bgpa.setCancelable(false);
    }
    if ((this.jdField_c_of_type_Bgpa != null) && (!this.jdField_c_of_type_Bgpa.isShowing()) && (!isFinishing()))
    {
      this.jdField_c_of_type_Bgpa.show();
      bcst.b(this.app, "dc00898", "", "", "0X800A603", "0X800A603", 0, 0, "", "", "", "");
    }
  }
  
  public void a()
  {
    aetz.a(this.app, "0X800AE4D");
    bcst.b(this.app, "CliOper", "", "", "0X8005B85", "0X8005B85", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(this, SettingActivity2.class);
    localIntent.putExtra("kSrouce", 2);
    localIntent.putExtra("selfSet_leftViewText", getString(2131698268));
    super.startActivityForResult(localIntent, 1002);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    b();
    if (paramBundle == null)
    {
      h();
      paramBundle = (anus)this.app.a(34);
      if (paramBundle != null)
      {
        QLog.i("IphoneTitleBarActivity", 1, "refreshServerData, getPhoneUnityInfo");
        paramBundle.a(paramInt, 31, null, null);
      }
      return;
    }
    QLog.i("IphoneTitleBarActivity", 1, "init with prefetched bind phone data");
    a(true, paramBundle, false);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneUnityBindInfoActivity", 2, "doOnActivityResult requestCode = " + paramInt1 + " resultCode = " + paramInt2);
    }
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        return;
        a(4, null);
        return;
        super.setResult(paramInt2);
        a(4, null);
        return;
        if (paramInt2 == -1) {
          if (this.jdField_a_of_type_Int == 21) {
            super.setResult(paramInt2);
          }
        }
        for (;;)
        {
          a(4, null);
          if ((paramInt2 != -1) || (paramIntent == null) || (paramIntent.getBooleanExtra("phone_num_login_result", true))) {
            break;
          }
          a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 3, 1);
          return;
          super.setResult(paramInt2);
        }
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          switch (paramIntent.getIntExtra("resultState", 5))
          {
          default: 
            super.setResult(paramInt2);
            super.finish();
            return;
          }
          a(4, null);
          return;
        }
      } while (paramInt2 != 0);
      paramIntent = this.jdField_a_of_type_AndroidOsBundle;
    } while ((paramIntent == null) || ((paramIntent.getInt("need_unify", 0) == 1) && (TextUtils.isEmpty(paramIntent.getString("skip_url")))));
    a(paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.h = false;
    this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("kIsWeb", false);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("kBindNew", false);
    this.jdField_b_of_type_AndroidOsBundle = getIntent().getBundleExtra("kBindPhoneData");
    super.setContentView(2131561355);
    super.setTitle(getString(2131698268));
    super.setContentBackgroundResource(2130838758);
    this.jdField_a_of_type_Ajby = ((ajby)this.app.getManager(102));
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.i()) && (!this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      paramBundle = new Intent(this, BindNumberActivity.class);
      paramBundle.putExtra("cmd_param_is_from_uni", true);
      paramBundle.putExtra("cmd_param_is_from_change_bind", false);
      paramBundle.putExtra("kUnityWebBind", true);
      paramBundle.putExtra("kSrouce", this.jdField_a_of_type_Int);
      startActivityForResult(paramBundle, 1007);
      return true;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131372354));
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839448);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      l();
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131372356));
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839442);
      paramBundle = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131374406);
      if (paramBundle != null) {
        paramBundle.setText(2131694201);
      }
      paramBundle = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131374408);
      if (paramBundle != null) {
        paramBundle.setText(2131694215);
      }
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131372355));
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839442);
      paramBundle = (TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131374406);
      if (paramBundle != null) {
        paramBundle.setText(2131691831);
      }
      paramBundle = (TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131374408);
      if (paramBundle != null) {
        paramBundle.setText(2131694215);
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363463));
    if (this.jdField_a_of_type_Ajby != null) {
      this.jdField_a_of_type_Ajby.jdField_a_of_type_Boolean = true;
    }
    super.addObserver(this.jdField_a_of_type_Anut);
    if (this.jdField_c_of_type_Boolean)
    {
      a(1, null);
      ContactBindedActivity.a(this.app, 222, 1);
    }
    for (;;)
    {
      aetz.a(this.app, "0X800AE4A");
      bcst.b(this.app, "dc00898", "", "", "0X8009EC1", "0X8009EC1", 0, 0, "", "", "", "");
      return true;
      a(4, this.jdField_b_of_type_AndroidOsBundle);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.jdField_a_of_type_Anut);
    j();
    k();
    if (this.jdField_a_of_type_Bkho != null)
    {
      this.jdField_a_of_type_Bkho.e();
      this.jdField_a_of_type_Bkho = null;
    }
    if (this.jdField_a_of_type_Bgpa != null)
    {
      this.jdField_a_of_type_Bgpa.dismiss();
      this.jdField_a_of_type_Bgpa = null;
    }
    if (this.jdField_b_of_type_Bgpa != null)
    {
      this.jdField_b_of_type_Bgpa.dismiss();
      this.jdField_b_of_type_Bgpa = null;
    }
    if (this.jdField_c_of_type_Bgpa != null)
    {
      this.jdField_c_of_type_Bgpa.dismiss();
      this.jdField_c_of_type_Bgpa = null;
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_d_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = true;
      if (this.jdField_c_of_type_Boolean) {
        QQToast.a(BaseApplication.getContext(), 2, 2131694219, 0);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    switch (paramView.getId())
    {
    }
    label527:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      e();
      continue;
      c(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
      continue;
      a();
      continue;
      aetz.a(this.app, "0X800AE4E");
      bcst.b(this.app, "CliOper", "", "", "0X8005B86", "0X8005B86", 0, 0, "", "", "", "");
      Object localObject1 = null;
      Object localObject2 = this.jdField_a_of_type_AndroidOsBundle;
      if (localObject2 != null) {
        localObject1 = ((Bundle)localObject2).getByteArray("vaskey");
      }
      localObject2 = new Intent(this, PhoneUnityPhoneLoginActivity.class);
      ((Intent)localObject2).putExtra("phone_num_login_sig", (byte[])localObject1);
      super.startActivityForResult((Intent)localObject2, 1005);
      continue;
      QLog.i("IphoneTitleBarActivity", 1, "phone_unity_info_devlock clicked");
      aetz.a(this.app, "0X800AE4F");
      bcst.b(this.app, "CliOper", "", "", "0X8005B87", "0X8005B87", 0, 0, "", "", "", "");
      this.h = true;
      localObject1 = new IntentFilter("mqq.intent.action.DEVLOCK_ROAM");
      super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject1);
      localObject1 = new Intent();
      ((Intent)localObject1).setFlags(268435456);
      ((Intent)localObject1).setAction("android.intent.action.VIEW");
      ((Intent)localObject1).putExtra("devlock_open_source", "PhoneUnity");
      ((Intent)localObject1).setData(Uri.parse("mqqdevlock://devlock/open?"));
      super.startActivity((Intent)localObject1);
      continue;
      localObject1 = paramView.getParent();
      if ((localObject1 != null) && ((localObject1 instanceof RelativeLayout))) {
        switch (((RelativeLayout)localObject1).getId())
        {
        default: 
          break;
        case 2131372355: 
          f();
          break;
        case 2131372356: 
          bcst.b(this.app, "CliOper", "", "", "0X8005B83", "0X8005B83", 0, 0, "", "", "", "");
          if (!bgnt.d(this))
          {
            QQToast.a(this, getString(2131691985), 0).b(getTitleBarHeight());
          }
          else
          {
            a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 2, 1);
            localObject1 = (anus)this.app.a(34);
            if (localObject1 != null)
            {
              localObject2 = this.jdField_a_of_type_AndroidOsBundle;
              if (localObject2 != null)
              {
                QLog.i("IphoneTitleBarActivity", 1, "phone_unity_info_login, bindPhoneNumLogin");
                localObject2 = ((Bundle)localObject2).getByteArray("vaskey");
                if (localObject2 != null) {
                  ((anus)localObject1).a((byte[])localObject2);
                }
              }
            }
            for (;;)
            {
              if (i == 0) {
                break label527;
              }
              a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 3, 1);
              break;
              i = 1;
            }
          }
          break;
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity
 * JD-Core Version:    0.7.0.1
 */