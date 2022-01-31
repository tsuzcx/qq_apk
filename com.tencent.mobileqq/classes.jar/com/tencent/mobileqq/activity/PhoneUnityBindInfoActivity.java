package com.tencent.mobileqq.activity;

import MyCarrier.Carrier;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.activity.phone.MyBusinessActivity;
import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.PhoneUnityManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.equipmentlock.EquipLockWebEntrance;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.mybusiness.MyBusinessServlet;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.net.URLEncoder;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import tfk;
import tfl;
import tfr;
import tfs;
import tft;
import tfu;
import tfv;
import tfw;

public class PhoneUnityBindInfoActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  public int a;
  public BroadcastReceiver a;
  public Bundle a;
  public RelativeLayout a;
  public TextView a;
  public PhoneUnityManager a;
  public SecSvcObserver a;
  public ContactBindObserver a;
  public QQCustomDialog a;
  public ActionSheet a;
  public boolean a;
  public RelativeLayout b;
  public QQCustomDialog b;
  public boolean b;
  public RelativeLayout c;
  public boolean c;
  public RelativeLayout d;
  public boolean d;
  public boolean e;
  
  public PhoneUnityBindInfoActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new tfk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver = new tfl(this);
  }
  
  public static SpannableStringBuilder a(String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, paramString.length(), 18);
    return localSpannableStringBuilder;
  }
  
  private void a()
  {
    a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 2, 1);
    a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 2, 1);
    a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, 2, 1);
    a(this.jdField_d_of_type_AndroidWidgetRelativeLayout, 2, 1);
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
      localObject3 = this.jdField_a_of_type_ComTencentWidgetActionSheet;
      if (localObject3 != null) {
        ((ActionSheet)localObject3).dismiss();
      }
      localObject3 = (ActionSheet)ActionSheetHelper.a(this, null);
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)localObject3);
      localObject4 = LayoutInflater.from(this).inflate(2130969171, null);
      if (localObject4 != null)
      {
        ((View)localObject4).setOnClickListener(new tft(this));
        Object localObject5 = Bitmap.Config.ARGB_8888;
        Object localObject6 = (LinearLayout)((View)localObject4).findViewById(2131365494);
        Object localObject7;
        Object localObject8;
        if (localObject6 != null)
        {
          localObject7 = (TextView)((LinearLayout)localObject6).findViewById(2131365496);
          if ((localObject7 != null) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.equals((CharSequence)localObject2, paramBundle)))
          {
            ((LinearLayout)localObject6).setVisibility(0);
            i = (int)((TextView)localObject7).getTextSize();
            localObject8 = Bitmap.createBitmap(i * 2, i * 2, (Bitmap.Config)localObject5);
            localObject8 = new ImageSpan(getApplicationContext(), (Bitmap)localObject8);
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("登 录");
            localSpannableStringBuilder.setSpan(localObject8, 1, 2, 33);
            ((TextView)((LinearLayout)localObject6).findViewById(2131365495)).setText(localSpannableStringBuilder);
            ((TextView)localObject7).setText((CharSequence)localObject2);
          }
        }
        localObject2 = (LinearLayout)((View)localObject4).findViewById(2131365497);
        if (localObject2 != null)
        {
          localObject6 = (TextView)((LinearLayout)localObject2).findViewById(2131365499);
          if ((localObject6 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.equals((CharSequence)localObject1, paramBundle)))
          {
            ((LinearLayout)localObject2).setVisibility(0);
            i = (int)((TextView)localObject6).getTextSize();
            localObject7 = Bitmap.createBitmap(i / 2, i / 2, (Bitmap.Config)localObject5);
            localObject5 = new ImageSpan(getApplicationContext(), (Bitmap)localObject7);
            localObject7 = new ImageSpan(getApplicationContext(), (Bitmap)localObject7);
            localObject8 = new SpannableStringBuilder("设 备 锁");
            ((SpannableStringBuilder)localObject8).setSpan(localObject5, 1, 2, 33);
            ((SpannableStringBuilder)localObject8).setSpan(localObject7, 3, 4, 33);
            ((TextView)((LinearLayout)localObject2).findViewById(2131365498)).setText((CharSequence)localObject8);
            ((TextView)localObject6).setText((CharSequence)localObject1);
          }
        }
        localObject1 = (LinearLayout)((View)localObject4).findViewById(2131365500);
        if (localObject1 != null)
        {
          localObject2 = (TextView)((View)localObject4).findViewById(2131365502);
          if ((localObject2 != null) && (!TextUtils.isEmpty(paramBundle)))
          {
            ((LinearLayout)localObject1).setVisibility(0);
            ((TextView)localObject2).setText(paramBundle);
          }
        }
        ((View)localObject4).setBackgroundResource(2130837543);
        ((ActionSheet)localObject3).b((View)localObject4);
      }
      ((ActionSheet)localObject3).c(a(String.format(super.getString(2131436843), new Object[] { paramBundle })));
      ((ActionSheet)localObject3).c(super.getString(2131436844));
      ((ActionSheet)localObject3).c(super.getString(2131433015));
      ((ActionSheet)localObject3).setOnCancelListener(new tfu(this));
      ((ActionSheet)localObject3).a(new tfv(this));
      ((ActionSheet)localObject3).a(new tfw(this, str2, str1, (ActionSheet)localObject3));
      localObject2 = ((ActionSheet)localObject3).a();
      localObject1 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = new RelativeLayout.LayoutParams(-2, -2);
      }
      paramBundle.addRule(12, 0);
      paramBundle.addRule(13, -1);
      paramBundle.setMargins(80, 0, 80, 0);
      ((RelativeLayout)localObject2).setLayoutParams(paramBundle);
      ((ActionSheet)localObject3).show();
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
      localObject = (TextView)paramRelativeLayout.findViewById(2131371300);
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
          ((TextView)localObject).setText(2131436830);
        }
      }
      localObject = (ProgressBar)paramRelativeLayout.findViewById(2131371301);
      if (localObject != null)
      {
        if (paramInt1 != 2) {
          break label260;
        }
        i = 0;
        ((ProgressBar)localObject).setVisibility(i);
        if (AppSetting.jdField_b_of_type_Boolean) {
          ((ProgressBar)localObject).setContentDescription(super.getString(2131436839));
        }
      }
      localObject = (Button)paramRelativeLayout.findViewById(2131371302);
      if (localObject != null)
      {
        ((Button)localObject).setOnClickListener(this);
        if (paramInt1 != 3) {
          break label267;
        }
        i = 0;
        ((Button)localObject).setVisibility(i);
      }
      paramRelativeLayout = (ImageView)paramRelativeLayout.findViewById(2131371303);
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
        ((TextView)localObject).setText(2131436831);
        paramRelativeLayout.setOnClickListener(null);
        break label72;
      }
      if (paramInt2 == 3)
      {
        ((TextView)localObject).setText(2131436832);
        break label72;
      }
      if (paramInt2 != 1) {
        break label72;
      }
      ((TextView)localObject).setText(2131436829);
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
    Object localObject;
    Bundle[] arrayOfBundle;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localObject = paramBundle.getString("phone");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
    }
    else
    {
      arrayOfBundle = (Bundle[])paramBundle.getParcelableArray("phone_info");
      if (arrayOfBundle == null) {
        break label194;
      }
      i = 0;
      label68:
      if (i >= arrayOfBundle.length) {
        break label194;
      }
      localObject = arrayOfBundle[i];
      if (localObject != null) {
        break label153;
      }
    }
    label153:
    while (((Bundle)localObject).getInt("phone_type", 0) != 16)
    {
      i += 1;
      break label68;
      if (paramBundle.containsKey("skip_url")) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(true, false);
      paramBundle = new Intent(this, PhoneUnityIntroductionActivity.class);
      paramBundle.putExtra("kSrouce", this.jdField_a_of_type_Int);
      super.startActivityForResult(paramBundle, 1003);
      super.finish();
      return;
    }
    if (((Bundle)localObject).getInt("status", 0) != 5) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.jdField_a_of_type_Boolean = paramBoolean1;
      break;
    }
    label194:
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null)
    {
      localObject = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
      if (this.jdField_a_of_type_Boolean)
      {
        i = 0;
        ((RelativeLayout)localObject).setVisibility(i);
      }
    }
    else
    {
      if (paramBundle.getInt("need_unify", 0) != 1) {
        break label286;
      }
      i = 1;
      label239:
      localObject = paramBundle.getString("skip_url");
      if ((!paramBoolean2) || (TextUtils.isEmpty((CharSequence)localObject))) {
        break label292;
      }
    }
    label286:
    label292:
    for (int n = 1;; n = 0)
    {
      if ((n != 0) || (i == 0)) {
        break label298;
      }
      a(paramBundle);
      return;
      i = 8;
      break;
      i = 0;
      break label239;
    }
    label298:
    int i5 = 1;
    int i = 1;
    int i3 = 1;
    int j = 1;
    int i2 = 1;
    int k = 1;
    int m = 2;
    int i1 = m;
    if (arrayOfBundle != null)
    {
      int i4 = 0;
      i1 = m;
      i2 = k;
      i3 = j;
      i5 = i;
      if (i4 < arrayOfBundle.length)
      {
        paramBundle = arrayOfBundle[i4];
        if (paramBundle == null) {}
        for (;;)
        {
          i4 += 1;
          break;
          switch (paramBundle.getInt("phone_type", 0))
          {
          default: 
            break;
          case 2: 
            i = paramBundle.getInt("status", 0);
            break;
          case 4: 
            j = paramBundle.getInt("status", 0);
            break;
          case 8: 
            k = paramBundle.getInt("status", 0);
            break;
          case 16: 
            m = paramBundle.getInt("status", 0);
          }
        }
      }
    }
    paramBundle = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (i5 == 2)
    {
      i = 1;
      label493:
      a(paramBundle, i, i5);
      paramBundle = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      if (i3 != 2) {
        break label793;
      }
      i = 1;
      label516:
      a(paramBundle, i, i3);
      paramBundle = this.jdField_c_of_type_AndroidWidgetRelativeLayout;
      if (i2 != 1) {
        break label799;
      }
      i = 3;
      label539:
      a(paramBundle, i, i2);
      if (this.jdField_a_of_type_Boolean)
      {
        paramBundle = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
        if (i1 != 2) {
          break label805;
        }
      }
    }
    label793:
    label799:
    label805:
    for (i = 1;; i = 3)
    {
      a(paramBundle, i, i1);
      if (n == 0) {
        break;
      }
      paramBundle = new StringBuilder((String)localObject);
      paramBundle.append("?");
      paramBundle.append("type=" + EquipLockWebEntrance.d);
      paramBundle.append("&plat=1");
      paramBundle.append("&app=1");
      paramBundle.append("&version=7.6.3.3560");
      paramBundle.append("&device=" + URLEncoder.encode(Build.DEVICE));
      paramBundle.append("&system=" + Build.VERSION.RELEASE);
      paramBundle.append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
      paramBundle = paramBundle.toString();
      localObject = new Intent(this, PhoneUnityVerifyActivity.class);
      ((Intent)localObject).putExtra("url", paramBundle);
      super.startActivityForResult((Intent)localObject, 1006);
      BaseActivity.sTopActivity.overridePendingTransition(2131034134, 0);
      return;
      i = 3;
      break label493;
      i = 3;
      break label516;
      i = 1;
      break label539;
    }
  }
  
  private void b()
  {
    ProgressBar localProgressBar;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      localProgressBar = (ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371301);
      if (localProgressBar != null) {
        localProgressBar.setVisibility(8);
      }
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      localProgressBar = (ProgressBar)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131371301);
      if (localProgressBar != null) {
        localProgressBar.setVisibility(8);
      }
    }
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null)
    {
      localProgressBar = (ProgressBar)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131371301);
      if (localProgressBar != null) {
        localProgressBar.setVisibility(8);
      }
    }
    if ((this.jdField_d_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_Boolean))
    {
      localProgressBar = (ProgressBar)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131371301);
      if (localProgressBar != null) {
        localProgressBar.setVisibility(8);
      }
    }
  }
  
  private void c()
  {
    Object localObject1 = new NewIntent(this.app.getApplication(), MyBusinessServlet.class);
    ((NewIntent)localObject1).putExtra("cmd_id", 2);
    this.app.startServlet((NewIntent)localObject1);
    localObject1 = ((MyBusinessManager)this.app.getManager(48)).a();
    Object localObject2;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((Carrier)localObject1).carrierExtraInfo)))
    {
      if ((((Carrier)localObject1).carrierExtraInfo.indexOf("&") <= -1) && (((Carrier)localObject1).carrierExtraInfo.indexOf("?") <= -1)) {
        break label249;
      }
      localObject2 = (TicketManager)this.app.getManager(2);
    }
    for (localObject1 = ((Carrier)localObject1).carrierExtraInfo + "&skey=" + ((TicketManager)localObject2).getSkey(this.app.getCurrentAccountUin());; localObject1 = ((Carrier)localObject1).carrierExtraInfo + "?skey=" + ((TicketManager)localObject2).getSkey(this.app.getCurrentAccountUin()))
    {
      localObject2 = new Intent(this, MyBusinessActivity.class);
      ((Intent)localObject2).putExtra("hide_operation_bar", true);
      ((Intent)localObject2).putExtra("uin", this.app.getCurrentAccountUin());
      ((Intent)localObject2).putExtra("title", super.getString(2131437122));
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      ((Intent)localObject2).putExtra("hideRightButton", true);
      ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject2).putExtra("selfSet_leftViewText", getString(2131436794));
      startActivityForResult((Intent)localObject2, 1001);
      return;
      label249:
      localObject2 = (TicketManager)this.app.getManager(2);
    }
  }
  
  public void a(int paramInt)
  {
    SecSvcHandler localSecSvcHandler = (SecSvcHandler)this.app.a(34);
    if (localSecSvcHandler != null) {
      localSecSvcHandler.a(paramInt, 31, null, null);
    }
    a();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
            a(this.jdField_d_of_type_AndroidWidgetRelativeLayout, 2, 1);
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
                a(2);
              }
              while ((paramInt2 == -1) && (paramIntent != null) && (!paramIntent.getBooleanExtra("phone_num_login_result", true)))
              {
                a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 3, 1);
                return;
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("kIsWeb", false);
    this.jdField_d_of_type_Boolean = getIntent().getBooleanExtra("kBindNew", false);
    super.setContentView(2130970515);
    super.setTitle(getString(2131436794));
    super.setContentBackgroundResource(2130838214);
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityManager = ((PhoneUnityManager)this.app.getManager(101));
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.g()) && (!this.jdField_d_of_type_Boolean))
    {
      if (this.jdField_c_of_type_Boolean)
      {
        paramBundle = new Intent(this, BindNumberActivity.class);
        paramBundle.putExtra("cmd_param_is_from_uni", true);
        paramBundle.putExtra("cmd_param_is_from_change_bind", false);
        paramBundle.putExtra("kUnityWebBind", true);
        paramBundle.putExtra("kSrouce", this.jdField_a_of_type_Int);
        startActivityForResult(paramBundle, 1007);
        return true;
      }
      paramBundle = new Intent(this, PhoneUnityIntroductionActivity.class);
      paramBundle.putExtra("kSrouce", this.jdField_a_of_type_Int);
      startActivityForResult(paramBundle, 1003);
      finish();
      return true;
    }
    paramBundle = (Button)super.findViewById(2131370969);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131370970));
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838635);
      paramBundle = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371299);
      if (paramBundle != null) {
        paramBundle.setText(2131436826);
      }
      paramBundle = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371300);
      if (paramBundle != null) {
        paramBundle.setText(2131436830);
      }
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131370971));
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838633);
      paramBundle = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131371299);
      if (paramBundle != null) {
        paramBundle.setText(2131436827);
      }
      paramBundle = (TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131371300);
      if (paramBundle != null) {
        paramBundle.setText(2131436830);
      }
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131370972));
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838633);
      paramBundle = (TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131371299);
      if (paramBundle != null) {
        paramBundle.setText(2131436552);
      }
      paramBundle = (TextView)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131371300);
      if (paramBundle != null) {
        paramBundle.setText(2131436830);
      }
    }
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131370973));
    if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838630);
      paramBundle = (TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131371299);
      if (paramBundle != null) {
        paramBundle.setText(2131436828);
      }
      paramBundle = (TextView)this.jdField_d_of_type_AndroidWidgetRelativeLayout.findViewById(2131371300);
      if (paramBundle != null) {
        paramBundle.setText(2131436830);
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370968));
    if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneUnityManager.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_d_of_type_Boolean)
    {
      a(1);
      ContactBindedActivity.a(this.app, 222);
    }
    for (;;)
    {
      super.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
      ((MyBusinessManager)this.app.getManager(48)).a();
      return true;
      a(4);
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    b();
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d();
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null) {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    int i;
    do
    {
      Object localObject;
      do
      {
        return;
        super.startActivityForResult(new Intent(this, PhoneUnityChangeActivity.class), 1004);
        ReportController.b(this.app, "CliOper", "", "", "0X8005B7F", "0X8005B7F", 0, 0, "", "", "", "");
        return;
        ReportController.b(this.app, "CliOper", "", "", "0X8005B85", "0X8005B85", 0, 0, "", "", "", "");
        paramView = new Intent(this, SettingActivity2.class);
        paramView.putExtra("kSrouce", 2);
        paramView.putExtra("selfSet_leftViewText", getString(2131436794));
        super.startActivityForResult(paramView, 1002);
        return;
        ReportController.b(this.app, "CliOper", "", "", "0X8005B86", "0X8005B86", 0, 0, "", "", "", "");
        paramView = null;
        localObject = this.jdField_a_of_type_AndroidOsBundle;
        if (localObject != null) {
          paramView = ((Bundle)localObject).getByteArray("vaskey");
        }
        localObject = new Intent(this, PhoneUnityPhoneLoginActivity.class);
        ((Intent)localObject).putExtra("phone_num_login_sig", paramView);
        super.startActivityForResult((Intent)localObject, 1005);
        return;
        ReportController.b(this.app, "CliOper", "", "", "0X8005B87", "0X8005B87", 0, 0, "", "", "", "");
        paramView = new IntentFilter("mqq.intent.action.DEVLOCK_ROAM");
        super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramView);
        paramView = new Intent();
        paramView.setFlags(268435456);
        paramView.setAction("android.intent.action.VIEW");
        paramView.putExtra("devlock_open_source", "PhoneUnity");
        paramView.setData(Uri.parse("mqqdevlock://devlock/open?"));
        super.startActivity(paramView);
        return;
        ReportController.b(this.app, "CliOper", "", "", "0X8005B88", "0X8005B88", 0, 0, "", "", "", "");
        c();
        return;
        paramView = paramView.getParent();
      } while ((paramView == null) || (!(paramView instanceof RelativeLayout)));
      switch (((RelativeLayout)paramView).getId())
      {
      default: 
        return;
      case 2131370970: 
        if (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.f())
        {
          super.startActivity(new Intent(this, GuideBindPhoneActivity.class));
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null) {
          this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new tfr(this);
        }
        this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
        this.app.a(new tfs(this));
        a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 2, 1);
        QQToast.a(BaseApplicationImpl.sApplication, "特征码匹配中。", 0).a();
        ReportController.b(this.app, "CliOper", "", "", "0X8005B82", "0X8005B82", 0, 0, "", "", "", "");
        return;
      case 2131370971: 
        ReportController.b(this.app, "CliOper", "", "", "0X8005B83", "0X8005B83", 0, 0, "", "", "", "");
        if (!NetworkUtil.d(this))
        {
          QQToast.a(this, getString(2131433009), 0).b(getTitleBarHeight());
          return;
        }
        a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 2, 1);
        int j = 1;
        paramView = (SecSvcHandler)this.app.a(34);
        i = j;
        if (paramView != null)
        {
          localObject = this.jdField_a_of_type_AndroidOsBundle;
          i = j;
          if (localObject != null)
          {
            localObject = ((Bundle)localObject).getByteArray("vaskey");
            i = j;
            if (localObject != null)
            {
              i = 0;
              paramView.a((byte[])localObject);
            }
          }
        }
        break;
      }
    } while (i == 0);
    a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 3, 1);
    return;
    ReportController.b(this.app, "CliOper", "", "", "0X8005B84", "0X8005B84", 0, 0, "", "", "", "");
    paramView = new IntentFilter("mqq.intent.action.DEVLOCK_ROAM");
    super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramView);
    paramView = new Intent();
    paramView.setFlags(268435456);
    paramView.setAction("android.intent.action.VIEW");
    paramView.putExtra("devlock_open_source", "PhoneUnity");
    paramView.putExtra("enable_open_allowset_dev", true);
    paramView.setData(Uri.parse("mqqdevlock://devlock/open?"));
    super.startActivity(paramView);
    return;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity
 * JD-Core Version:    0.7.0.1
 */