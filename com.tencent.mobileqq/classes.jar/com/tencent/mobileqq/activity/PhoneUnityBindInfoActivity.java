package com.tencent.mobileqq.activity;

import admw;
import admx;
import adnd;
import adne;
import adnf;
import adng;
import adnh;
import adni;
import alud;
import alys;
import amci;
import amcj;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqaz;
import azqs;
import bdgm;
import bdin;
import bdjz;
import bhuf;
import bhus;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;

public class PhoneUnityBindInfoActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  public int a;
  public alys a;
  public amcj a;
  public BroadcastReceiver a;
  public Bundle a;
  public RelativeLayout a;
  public TextView a;
  public bdjz a;
  public bhuf a;
  public boolean a;
  public RelativeLayout b;
  public bdjz b;
  public boolean b;
  public RelativeLayout c;
  private bdjz c;
  public boolean c;
  public boolean d;
  public boolean e;
  private boolean f;
  
  public PhoneUnityBindInfoActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new admw(this);
    this.jdField_a_of_type_Amcj = new admx(this);
  }
  
  public static SpannableStringBuilder a(String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, paramString.length(), 18);
    return localSpannableStringBuilder;
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
      localObject3 = this.jdField_a_of_type_Bhuf;
      if (localObject3 != null) {
        ((bhuf)localObject3).dismiss();
      }
      localObject3 = (bhuf)bhus.a(this, null);
      ((bhuf)localObject3).a(true);
      this.jdField_a_of_type_Bhuf = ((bhuf)localObject3);
      localObject4 = LayoutInflater.from(this).inflate(2131559428, null);
      if (localObject4 != null)
      {
        ((View)localObject4).setOnClickListener(new adnd(this));
        Object localObject6 = Bitmap.Config.ARGB_8888;
        Object localObject5 = (LinearLayout)((View)localObject4).findViewById(2131371767);
        if (localObject5 != null)
        {
          TextView localTextView = (TextView)((LinearLayout)localObject5).findViewById(2131371769);
          if ((localTextView != null) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.equals((CharSequence)localObject2, paramBundle)))
          {
            ((LinearLayout)localObject5).setVisibility(0);
            i = (int)localTextView.getTextSize();
            localObject6 = Bitmap.createBitmap(i * 2, i * 2, (Bitmap.Config)localObject6);
            localObject6 = new ImageSpan(getApplicationContext(), (Bitmap)localObject6);
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(alud.a(2131708430));
            localSpannableStringBuilder.setSpan(localObject6, 1, 2, 33);
            ((TextView)((LinearLayout)localObject5).findViewById(2131371768)).setText(localSpannableStringBuilder);
            localTextView.setText((CharSequence)localObject2);
          }
        }
        localObject2 = (LinearLayout)((View)localObject4).findViewById(2131371758);
        if (localObject2 != null)
        {
          localObject5 = (TextView)((LinearLayout)localObject2).findViewById(2131371760);
          if ((localObject5 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.equals((CharSequence)localObject1, paramBundle)))
          {
            ((LinearLayout)localObject2).setVisibility(0);
            ((TextView)localObject5).setText((CharSequence)localObject1);
          }
        }
        localObject1 = (LinearLayout)((View)localObject4).findViewById(2131371785);
        if (localObject1 != null)
        {
          localObject2 = (TextView)((View)localObject4).findViewById(2131371793);
          if ((localObject2 != null) && (!TextUtils.isEmpty(paramBundle)))
          {
            ((LinearLayout)localObject1).setVisibility(0);
            ((TextView)localObject2).setText(paramBundle);
          }
        }
        ((View)localObject4).setBackgroundResource(2130850057);
        ((bhuf)localObject3).b((View)localObject4);
      }
      ((bhuf)localObject3).a(a(String.format(super.getString(2131695151), new Object[] { paramBundle })), 8);
      ((bhuf)localObject3).a(super.getString(2131695150), 8);
      ((bhuf)localObject3).a(super.getString(2131690648), 8);
      ((bhuf)localObject3).setOnCancelListener(new adne(this));
      ((bhuf)localObject3).a(new adnf(this));
      ((bhuf)localObject3).a(new adng(this, str2, str1, (bhuf)localObject3));
      localObject2 = ((bhuf)localObject3).a();
      localObject1 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = new RelativeLayout.LayoutParams(-2, -2);
      }
      paramBundle.addRule(12, 0);
      paramBundle.addRule(13, -1);
      paramBundle.setMargins(80, 0, 80, 0);
      ((RelativeLayout)localObject2).setLayoutParams(paramBundle);
      ((bhuf)localObject3).show();
      azqs.b(this.app, "dc00898", "", "", "0X8009EC7", "0X8009EC7", 0, 0, "", "", "", "");
      return;
      localObject1 = "";
      localObject2 = "";
      paramBundle = str1;
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
      localObject = (TextView)paramRelativeLayout.findViewById(2131373705);
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
          ((TextView)localObject).setText(2131695172);
        }
      }
      localObject = (ProgressBar)paramRelativeLayout.findViewById(2131373704);
      if (localObject != null)
      {
        if (paramInt1 != 2) {
          break label260;
        }
        i = 0;
        ((ProgressBar)localObject).setVisibility(i);
        if (AppSetting.jdField_c_of_type_Boolean) {
          ((ProgressBar)localObject).setContentDescription(super.getString(2131695173));
        }
      }
      localObject = (Button)paramRelativeLayout.findViewById(2131373700);
      if (localObject != null)
      {
        ((Button)localObject).setOnClickListener(this);
        if (paramInt1 != 3) {
          break label267;
        }
        i = 0;
        ((Button)localObject).setVisibility(i);
      }
      paramRelativeLayout = (ImageView)paramRelativeLayout.findViewById(2131373699);
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
        ((TextView)localObject).setText(2131695175);
        paramRelativeLayout.setOnClickListener(null);
        break label72;
      }
      if (paramInt2 == 3)
      {
        ((TextView)localObject).setText(2131695144);
        break label72;
      }
      if (paramInt2 != 1) {
        break label72;
      }
      ((TextView)localObject).setText(2131695174);
      break label72;
      label260:
      i = 8;
      break label97;
      label267:
      i = 8;
      break label153;
    }
  }
  
  private void a(boolean paramBoolean1, Bundle paramBundle, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    }
    if (paramBundle == null) {
      return;
    }
    String str;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      str = paramBundle.getString("phone");
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      }
    }
    for (;;)
    {
      Bundle[] arrayOfBundle = (Bundle[])paramBundle.getParcelableArray("phone_info");
      label75:
      Object localObject;
      if (paramBundle.getInt("need_unify", 0) == 1)
      {
        i = 1;
        localObject = paramBundle.getString("skip_url");
        if ((!paramBoolean2) || (TextUtils.isEmpty((CharSequence)localObject))) {
          break label179;
        }
      }
      label179:
      for (int k = 1;; k = 0)
      {
        if ((k != 0) || (i == 0)) {
          break label185;
        }
        a(paramBundle);
        return;
        if (paramBundle.containsKey("skip_url")) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(true, false, 17);
        paramBundle = new Intent(this, BindNumberActivity.class);
        paramBundle.putExtra("kSrouce", this.jdField_a_of_type_Int);
        super.startActivityForResult(paramBundle, 1003);
        super.finish();
        return;
        i = 0;
        break label75;
      }
      label185:
      int n = 1;
      int i = 1;
      int m = 1;
      int j = 1;
      if (arrayOfBundle != null)
      {
        int i1 = 0;
        m = j;
        n = i;
        if (i1 < arrayOfBundle.length)
        {
          paramBundle = arrayOfBundle[i1];
          if (paramBundle == null) {}
          for (;;)
          {
            i1 += 1;
            break;
            switch (paramBundle.getInt("phone_type", 0))
            {
            default: 
              break;
            case 4: 
              i = paramBundle.getInt("status", 0);
              break;
            case 8: 
              j = paramBundle.getInt("status", 0);
              break;
            case 16: 
              paramBundle.getInt("status", 0);
            }
          }
        }
      }
      e();
      paramBundle = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      if (n == 2)
      {
        i = 1;
        a(paramBundle, i, n);
        paramBundle = this.jdField_c_of_type_AndroidWidgetRelativeLayout;
        if (m != 1) {
          break label617;
        }
        i = 3;
        label362:
        a(paramBundle, i, m);
        if (k != 0)
        {
          paramBundle = new StringBuilder((String)localObject);
          paramBundle.append("?");
          paramBundle.append("type=" + aqaz.d);
          paramBundle.append("&plat=1");
          paramBundle.append("&app=1");
          paramBundle.append("&version=8.3.5.4555");
          paramBundle.append("&device=" + URLEncoder.encode(Build.DEVICE));
          paramBundle.append("&system=" + Build.VERSION.RELEASE);
          paramBundle.append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
          paramBundle = paramBundle.toString();
          localObject = new Intent(this, PhoneUnityVerifyActivity.class);
          ((Intent)localObject).putExtra("url", paramBundle);
          super.startActivityForResult((Intent)localObject, 1006);
          BaseActivity.sTopActivity.overridePendingTransition(2130771997, 0);
        }
        if (m != 2) {
          break label623;
        }
        paramBoolean1 = true;
        label587:
        if (TextUtils.isEmpty(str)) {
          break label628;
        }
      }
      label617:
      label623:
      label628:
      for (paramBoolean2 = true;; paramBoolean2 = false)
      {
        if (!a(paramBoolean1, paramBoolean2)) {
          break label631;
        }
        f();
        return;
        i = 3;
        break;
        i = 1;
        break label362;
        paramBoolean1 = false;
        break label587;
      }
      label631:
      break;
      str = "";
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
      QLog.d("IphoneTitleBarActivity", 2, "isNeedShowTips isDevLock = " + paramBoolean1 + ", isBindPhoneNumber = " + paramBoolean2 + ", isBackFromDevLock = " + this.f);
    }
    if (paramBoolean1) {
      return false;
    }
    if (this.f)
    {
      this.f = false;
      return false;
    }
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.app.getManager(11);
    int i = localPhoneContactManagerImp.d();
    if (((i != 8) && (i != 9)) || (!localPhoneContactManagerImp.i())) {}
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
  
  private void b()
  {
    this.f = true;
    azqs.b(this.app, "CliOper", "", "", "0X8005B84", "0X8005B84", 0, 0, "", "", "", "");
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
  
  private void c()
  {
    a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 2, 1);
    a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, 2, 1);
  }
  
  private void d()
  {
    ProgressBar localProgressBar;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      localProgressBar = (ProgressBar)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373704);
      if (localProgressBar != null) {
        localProgressBar.setVisibility(8);
      }
    }
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null)
    {
      localProgressBar = (ProgressBar)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131373704);
      if (localProgressBar != null) {
        localProgressBar.setVisibility(8);
      }
    }
  }
  
  private void e()
  {
    Object localObject = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373703);
    if (localObject != null) {
      ((TextView)localObject).setText(2131695154);
    }
    localObject = (PhoneContactManagerImp)this.app.getManager(11);
    int i = ((PhoneContactManagerImp)localObject).d();
    if (((i != 8) && (i != 9)) || (!((PhoneContactManagerImp)localObject).i())) {}
    for (localObject = alud.a(2131708417);; localObject = alud.a(2131708427))
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373705);
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)localObject);
        localTextView.setVisibility(0);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373704);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373700);
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373699);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      return;
    }
  }
  
  private void f()
  {
    if (this.jdField_c_of_type_Bdjz == null)
    {
      this.jdField_c_of_type_Bdjz = bdgm.a(this, 0, super.getString(2131719895), super.getString(2131719896), super.getString(2131719893), super.getString(2131719894), new adnh(this), new adni(this));
      this.jdField_c_of_type_Bdjz.setCancelable(false);
    }
    if ((this.jdField_c_of_type_Bdjz != null) && (!this.jdField_c_of_type_Bdjz.isShowing()) && (!isFinishing()))
    {
      this.jdField_c_of_type_Bdjz.show();
      azqs.b(this.app, "dc00898", "", "", "0X800A603", "0X800A603", 0, 0, "", "", "", "");
    }
  }
  
  public void a()
  {
    azqs.b(this.app, "CliOper", "", "", "0X8005B85", "0X8005B85", 0, 0, "", "", "", "");
    Intent localIntent = new Intent(this, SettingActivity2.class);
    localIntent.putExtra("kSrouce", 2);
    localIntent.putExtra("selfSet_leftViewText", getString(2131699798));
    super.startActivityForResult(localIntent, 1002);
  }
  
  public void a(int paramInt)
  {
    amci localamci = (amci)this.app.a(34);
    if (localamci != null) {
      localamci.a(paramInt, 31, null, null);
    }
    c();
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
        for (;;)
        {
          return;
          if ((paramInt2 == -1) || (paramInt2 == 4002))
          {
            a(4);
            return;
            super.setResult(paramInt2);
            super.finish();
            return;
            super.setResult(paramInt2);
            if (paramInt2 == -1)
            {
              a(1);
              return;
            }
            if (paramInt2 == 0)
            {
              super.finish();
              return;
              if (paramInt2 == -1) {
                if (this.jdField_a_of_type_Int == 21)
                {
                  super.setResult(paramInt2);
                  super.finish();
                }
              }
              while ((paramInt2 == -1) && (paramIntent != null) && (!paramIntent.getBooleanExtra("phone_num_login_result", true)))
              {
                a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 3, 1);
                return;
                a(2);
                continue;
                super.setResult(paramInt2);
                super.finish();
              }
            }
          }
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
          a(4);
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
    this.f = false;
    this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("kIsWeb", false);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("kBindNew", false);
    super.setContentView(2131561144);
    super.setTitle(getString(2131699798));
    super.setContentBackgroundResource(2130838592);
    this.jdField_a_of_type_Alys = ((alys)this.app.getManager(102));
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.h()) && (!this.jdField_c_of_type_Boolean))
    {
      if (this.jdField_b_of_type_Boolean)
      {
        paramBundle = new Intent(this, BindNumberActivity.class);
        paramBundle.putExtra("cmd_param_is_from_uni", true);
        paramBundle.putExtra("cmd_param_is_from_change_bind", false);
        paramBundle.putExtra("kUnityWebBind", true);
        paramBundle.putExtra("kSrouce", this.jdField_a_of_type_Int);
        startActivityForResult(paramBundle, 1007);
        return true;
      }
      paramBundle = new Intent(this, BindNumberActivity.class);
      paramBundle.putExtra("kSrouce", this.jdField_a_of_type_Int);
      startActivityForResult(paramBundle, 1003);
      finish();
      return true;
    }
    paramBundle = (Button)super.findViewById(2131364090);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131371782));
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839270);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      e();
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131371784));
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839264);
      paramBundle = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373703);
      if (paramBundle != null) {
        paramBundle.setText(2131695157);
      }
      paramBundle = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131373705);
      if (paramBundle != null) {
        paramBundle.setText(2131695172);
      }
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131371783));
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839264);
      paramBundle = (TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131373703);
      if (paramBundle != null) {
        paramBundle.setText(2131692213);
      }
      paramBundle = (TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131373705);
      if (paramBundle != null) {
        paramBundle.setText(2131695172);
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363274));
    if (this.jdField_a_of_type_Alys != null) {
      this.jdField_a_of_type_Alys.jdField_a_of_type_Boolean = true;
    }
    super.addObserver(this.jdField_a_of_type_Amcj);
    if (this.jdField_c_of_type_Boolean)
    {
      a(1);
      ContactBindedActivity.a(this.app, 222, 1);
    }
    for (;;)
    {
      azqs.b(this.app, "dc00898", "", "", "0X8009EC1", "0X8009EC1", 0, 0, "", "", "", "");
      return true;
      a(4);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.jdField_a_of_type_Amcj);
    d();
    if (this.jdField_a_of_type_Bhuf != null)
    {
      this.jdField_a_of_type_Bhuf.e();
      this.jdField_a_of_type_Bhuf = null;
    }
    if (this.jdField_a_of_type_Bdjz != null)
    {
      this.jdField_a_of_type_Bdjz.dismiss();
      this.jdField_a_of_type_Bdjz = null;
    }
    if (this.jdField_b_of_type_Bdjz != null)
    {
      this.jdField_b_of_type_Bdjz.dismiss();
      this.jdField_b_of_type_Bdjz = null;
    }
    if (this.jdField_c_of_type_Bdjz != null)
    {
      this.jdField_c_of_type_Bdjz.dismiss();
      this.jdField_c_of_type_Bdjz = null;
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
    if ((paramBoolean) && (!this.d))
    {
      this.d = true;
      if (this.jdField_c_of_type_Boolean) {
        QQToast.a(BaseApplication.getContext(), 2, 2131695176, 0);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      return;
      paramView = new Intent(this, PhoneUnityChangeActivity.class);
      paramView.putExtra("kSrouce", this.jdField_a_of_type_Int);
      super.startActivityForResult(paramView, 1004);
      azqs.b(this.app, "dc00898", "", "", "0X8009EC2", "0X8009EC2", 0, 0, "", "", "", "");
      return;
      a();
      return;
      azqs.b(this.app, "CliOper", "", "", "0X8005B86", "0X8005B86", 0, 0, "", "", "", "");
      paramView = null;
      Object localObject = this.jdField_a_of_type_AndroidOsBundle;
      if (localObject != null) {
        paramView = ((Bundle)localObject).getByteArray("vaskey");
      }
      localObject = new Intent(this, PhoneUnityPhoneLoginActivity.class);
      ((Intent)localObject).putExtra("phone_num_login_sig", paramView);
      super.startActivityForResult((Intent)localObject, 1005);
      return;
      this.f = true;
      azqs.b(this.app, "CliOper", "", "", "0X8005B87", "0X8005B87", 0, 0, "", "", "", "");
      paramView = new IntentFilter("mqq.intent.action.DEVLOCK_ROAM");
      super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramView);
      paramView = new Intent();
      paramView.setFlags(268435456);
      paramView.setAction("android.intent.action.VIEW");
      paramView.putExtra("devlock_open_source", "PhoneUnity");
      paramView.setData(Uri.parse("mqqdevlock://devlock/open?"));
      super.startActivity(paramView);
      return;
      paramView = paramView.getParent();
      if ((paramView != null) && ((paramView instanceof RelativeLayout)))
      {
        switch (((RelativeLayout)paramView).getId())
        {
        default: 
          return;
        case 2131371783: 
          b();
          return;
        }
        azqs.b(this.app, "CliOper", "", "", "0X8005B83", "0X8005B83", 0, 0, "", "", "", "");
        if (!bdin.d(this))
        {
          QQToast.a(this, getString(2131692398), 0).b(getTitleBarHeight());
          return;
        }
        a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 2, 1);
        paramView = (amci)this.app.a(34);
        if (paramView != null)
        {
          localObject = this.jdField_a_of_type_AndroidOsBundle;
          if (localObject != null)
          {
            localObject = ((Bundle)localObject).getByteArray("vaskey");
            if (localObject != null) {
              paramView.a((byte[])localObject);
            }
          }
        }
        while (i != 0)
        {
          a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 3, 1);
          return;
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity
 * JD-Core Version:    0.7.0.1
 */