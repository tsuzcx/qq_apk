package com.tencent.mobileqq.activity;

import Override;
import afco;
import afcp;
import afcq;
import afcr;
import afcs;
import afct;
import afcu;
import afcv;
import afcx;
import afcy;
import afcz;
import afda;
import afdb;
import afdc;
import afdd;
import ajng;
import ajnh;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anzj;
import aohe;
import aohf;
import asuz;
import asvf;
import azov;
import bdll;
import bhlq;
import bhnv;
import bhpc;
import blir;
import blji;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.phone.BindVerifyActivity;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.WeakReference;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class PhoneUnityBindInfoActivity
  extends DialogBaseActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public int a;
  public ajng a;
  private ajnh jdField_a_of_type_Ajnh = new ajnh();
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new afco(this);
  public Bundle a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  aohf jdField_a_of_type_Aohf = new afcv(this);
  public azov a;
  public bhpc a;
  public blir a;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  public boolean a;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public azov b;
  public bhpc b;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private boolean jdField_b_of_type_Boolean;
  public azov c;
  private bhpc jdField_c_of_type_Bhpc;
  private boolean jdField_c_of_type_Boolean;
  private bhpc d;
  private bhpc e;
  
  public PhoneUnityBindInfoActivity()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = -1;
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
      Button localButton = (Button)findViewById(2131364340);
      paramBundle = paramBundle.getString("phone");
      if (!TextUtils.isEmpty(paramBundle))
      {
        String str = getResources().getString(2131694254) + paramBundle;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        if (this.jdField_a_of_type_Ajnh.jdField_a_of_type_Int == 3)
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          localButton.setText(2131694259);
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
          if (!this.jdField_a_of_type_Ajnh.jdField_a_of_type_Boolean) {
            break label218;
          }
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
          label125:
          if ((this.jdField_a_of_type_Ajnh.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Ajnh.jdField_b_of_type_Boolean)) {
            break label229;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        return paramBundle;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        localButton.setText(2131694220);
        break;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694230);
        localButton.setText(2131694209);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(true, false, 17);
        break;
        label218:
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(false);
        break label125;
        label229:
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true);
      }
    }
    return "";
  }
  
  private void a(DevlockInfo paramDevlockInfo)
  {
    this.jdField_b_of_type_Boolean = false;
    if (paramDevlockInfo == null)
    {
      QLog.i("PhoneUnityBindInfoActivity", 1, "onGetDevlockInfo, fail");
      return;
    }
    QLog.i("PhoneUnityBindInfoActivity", 1, "fetchSecurePhoneNum, success");
    this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = paramDevlockInfo;
    asuz.a().a(paramDevlockInfo.TransferInfo);
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
      a(paramBundle);
    }
    if (paramBundle == null) {
      return;
    }
    if (paramBundle.getInt("need_unify", 0) == 1) {}
    for (int i = 1; (this.jdField_a_of_type_Ajnh.jdField_a_of_type_Int == 3) && (i != 0); i = 0)
    {
      bdll.b(this.app, "dc00898", "", "", "0X800B313", "0X800B313", 0, 0, "", "", "", "");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Ajnh.d)) {
        ajng.a(this, this.app, this.jdField_a_of_type_Ajnh.d, 1010);
      }
      finish();
      return;
    }
    if (paramBundle.getInt("check_result") == 1)
    {
      paramBundle = paramBundle.getString("mibao_set_url");
      if (!TextUtils.isEmpty(paramBundle)) {
        ajng.a(this, this.app, paramBundle, 1009);
      }
      for (;;)
      {
        finish();
        return;
        QLog.e("PhoneUnityBindInfoActivity", 4, "mb set url is null.");
      }
    }
    a(paramBundle);
    if (i != 0)
    {
      b(paramBundle);
      bdll.b(this.app, "dc00898", "", "", "0X800B322", "0X800B322", 0, 0, "", "", "", "");
      return;
    }
    bdll.b(this.app, "dc00898", "", "", "0X800B314", "0X800B314", 0, 0, "", "", "", "");
  }
  
  private void b(Bundle paramBundle)
  {
    String str = "";
    Object localObject1 = "";
    Object localObject3 = "";
    Object localObject2 = paramBundle.getString("phone");
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("phone_info");
    Object localObject4 = localObject2;
    Object localObject6 = localObject3;
    Object localObject5 = localObject1;
    Object localObject7 = str;
    if (arrayOfParcelable != null)
    {
      int i = 0;
      paramBundle = str;
      localObject4 = localObject2;
      localObject6 = localObject3;
      localObject5 = localObject1;
      localObject7 = paramBundle;
      if (i < arrayOfParcelable.length)
      {
        localObject4 = (Bundle)arrayOfParcelable[i];
        if (localObject4 == null)
        {
          localObject4 = localObject2;
          localObject5 = localObject3;
          localObject3 = paramBundle;
          localObject2 = localObject1;
          localObject1 = localObject5;
          paramBundle = (Bundle)localObject4;
        }
        for (;;)
        {
          i += 1;
          localObject4 = localObject3;
          localObject5 = localObject2;
          localObject2 = paramBundle;
          localObject3 = localObject1;
          localObject1 = localObject5;
          paramBundle = (Bundle)localObject4;
          break;
          switch (((Bundle)localObject4).getInt("phone_type", 0))
          {
          default: 
            localObject4 = localObject1;
            localObject5 = paramBundle;
            paramBundle = (Bundle)localObject2;
            localObject1 = localObject3;
            localObject2 = localObject4;
            localObject3 = localObject5;
            break;
          case 2: 
            localObject5 = ((Bundle)localObject4).getString("phone");
            localObject4 = localObject1;
            paramBundle = (Bundle)localObject2;
            localObject1 = localObject3;
            localObject2 = localObject4;
            localObject3 = localObject5;
            break;
          case 1: 
            localObject5 = ((Bundle)localObject4).getString("phone");
            localObject2 = localObject5;
            localObject3 = localObject1;
            localObject4 = paramBundle;
            paramBundle = (Bundle)localObject5;
            localObject1 = localObject2;
            localObject2 = localObject3;
            localObject3 = localObject4;
            break;
          case 3: 
            localObject5 = ((Bundle)localObject4).getString("phone");
            localObject4 = paramBundle;
            paramBundle = (Bundle)localObject2;
            localObject1 = localObject3;
            localObject2 = localObject5;
            localObject3 = localObject4;
          }
        }
      }
    }
    paramBundle = this.jdField_a_of_type_Blir;
    if (paramBundle != null) {
      paramBundle.dismiss();
    }
    this.jdField_a_of_type_Boolean = true;
    localObject2 = (blir)blji.a(this, null);
    ((blir)localObject2).a(true);
    this.jdField_a_of_type_Blir = ((blir)localObject2);
    paramBundle = LayoutInflater.from(this).inflate(2131559562, null);
    if (paramBundle != null)
    {
      paramBundle.setOnClickListener(new afcy(this));
      localObject1 = (LinearLayout)paramBundle.findViewById(2131372454);
      if (localObject1 != null)
      {
        localObject3 = (TextView)((LinearLayout)localObject1).findViewById(2131372456);
        if ((localObject3 != null) && (!TextUtils.isEmpty((CharSequence)localObject7)))
        {
          ((LinearLayout)localObject1).setVisibility(0);
          ((TextView)localObject3).setText((CharSequence)localObject7);
        }
      }
      localObject1 = (LinearLayout)paramBundle.findViewById(2131372445);
      if (localObject1 != null)
      {
        localObject3 = (TextView)((LinearLayout)localObject1).findViewById(2131372447);
        if ((localObject3 != null) && (!TextUtils.isEmpty(localObject6)))
        {
          ((LinearLayout)localObject1).setVisibility(0);
          ((TextView)localObject3).setText(localObject6);
        }
      }
      localObject1 = (LinearLayout)paramBundle.findViewById(2131372470);
      if (localObject1 != null)
      {
        localObject3 = (TextView)paramBundle.findViewById(2131372478);
        if ((localObject3 != null) && (!TextUtils.isEmpty((CharSequence)localObject5)))
        {
          ((LinearLayout)localObject1).setVisibility(0);
          ((TextView)localObject3).setText((CharSequence)localObject5);
        }
      }
      paramBundle.setBackgroundResource(2130850665);
      ((blir)localObject2).b(paramBundle);
    }
    ((blir)localObject2).a(a(String.format(super.getString(2131694212), new Object[] { localObject4 })), 9, "#03081A");
    ((blir)localObject2).a(a(getString(2131694211)), 9, "#03081A");
    ((blir)localObject2).a(a(getString(2131690580)), 9, "#03081A");
    ((blir)localObject2).setOnCancelListener(new afcz(this));
    ((blir)localObject2).a(new afda(this));
    ((blir)localObject2).a(new afdb(this, (blir)localObject2));
    localObject3 = ((blir)localObject2).a();
    localObject1 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject3).getLayoutParams();
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    }
    paramBundle.addRule(12, 0);
    paramBundle.addRule(13, -1);
    paramBundle.setMargins(80, 0, 80, 0);
    ((RelativeLayout)localObject3).setLayoutParams(paramBundle);
    ((blir)localObject2).setCanceledOnTouchOutside(false);
    ((blir)localObject2).show();
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("PhoneUnityBindInfoActivity", 2, "mibaoChangeUrl is null.");
      return;
    }
    ajng.a(this, this.app, paramString, 1011);
  }
  
  private void l()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      QLog.i("PhoneUnityBindInfoActivity", 1, "fetchSecurePhoneNum, in progress");
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    QLog.i("PhoneUnityBindInfoActivity", 1, "fetchSecurePhoneNum, start");
    WeakReference localWeakReference = new WeakReference(this);
    asvf.a().a(this.app, this.app.getCurrentAccountUin(), new afcx(this, localWeakReference));
  }
  
  private void m()
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Int == 0))
    {
      this.jdField_a_of_type_Int = -1;
      this.jdField_c_of_type_Boolean = false;
      b();
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()) || (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a()))
      {
        QQToast.a(this, 1, getResources().getString(2131694247), 0).b(getTitleBarHeight());
        finish();
      }
    }
    else
    {
      return;
    }
    QQToast.a(this, 2, getResources().getString(2131694257), 0).b(getTitleBarHeight());
    a(1, null);
    bdll.b(this.app, "dc00898", "", "", "0X800B324", "0X800B324", 0, 0, "", "", "", "");
  }
  
  private void n()
  {
    QLog.i("PhoneUnityBindInfoActivity", 1, "showUnityUnderReviewDialog");
    if (this.e == null)
    {
      bhpc localbhpc = bhlq.a(this, 230);
      localbhpc.setCancelable(true);
      localbhpc.setTitle(2131694249);
      localbhpc.adjustMessageTopBottomMargin(8.0F, 40.0F);
      localbhpc.setMessage(2131694253);
      localbhpc.setPositiveButton(2131694294, new afcr(this));
      this.e = localbhpc;
    }
    if ((!this.e.isShowing()) && (!isFinishing())) {
      this.e.show();
    }
  }
  
  private void o()
  {
    QLog.i("PhoneUnityBindInfoActivity", 1, "showUnityUnderReviewDialog");
    if (this.d == null)
    {
      bhpc localbhpc = bhlq.a(this, 230);
      localbhpc.setCancelable(true);
      localbhpc.adjustMessageTopBottomMargin(8.0F, 40.0F);
      localbhpc.setMessage(2131694260);
      localbhpc.setPositiveButton(2131694294, new afcs(this));
      this.d = localbhpc;
    }
    if ((!this.d.isShowing()) && (!isFinishing()))
    {
      this.d.show();
      bdll.b(this.app, "dc00898", "", "", "0X800B318", "0X800B318", 0, 0, "", "", "", "");
    }
  }
  
  private void p()
  {
    QLog.i("PhoneUnityBindInfoActivity", 1, "showBindContactPhoneDialog");
    if (this.jdField_a_of_type_AndroidOsBundle == null) {}
    do
    {
      return;
      if (this.jdField_c_of_type_Bhpc == null)
      {
        bhpc localbhpc = bhlq.a(this, 230);
        localbhpc.setCancelable(true);
        localbhpc.adjustMessageTopBottomMargin(8.0F, 40.0F);
        localbhpc.setTitle(2131694218);
        String str = this.jdField_a_of_type_AndroidOsBundle.getString("phone");
        localbhpc.setMessage(Html.fromHtml(String.format(getString(2131694216), new Object[] { "<font color=\"#FF8343\">" + str + "</font>" })));
        localbhpc.setPositiveButton(2131694217, new afct(this));
        localbhpc.setNegativeButton(2131694215, new afcu(this));
        this.jdField_c_of_type_Bhpc = localbhpc;
      }
    } while ((this.jdField_c_of_type_Bhpc.isShowing()) || (isFinishing()));
    this.jdField_c_of_type_Bhpc.show();
    bdll.b(this.app, "dc00898", "", "", "0X800B31C", "0X800B31C", 0, 0, "", "", "", "");
  }
  
  private void q()
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Int > -1))
    {
      this.jdField_a_of_type_Int -= 1;
      QLog.d("PhoneUnityBindInfoActivity", 1, "phone_unity_info, mUnBindedNum: " + this.jdField_a_of_type_Int);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ajnh.jdField_c_of_type_Boolean = true;
    b();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    l();
    if (paramBundle == null)
    {
      paramBundle = (aohe)this.app.a(34);
      if (paramBundle != null)
      {
        QLog.i("PhoneUnityBindInfoActivity", 1, "refreshServerData, getPhoneUnityInfo");
        paramBundle.a(paramInt);
      }
      return;
    }
    QLog.i("PhoneUnityBindInfoActivity", 1, "init with prefetched bind phone data");
    a(true, paramBundle);
  }
  
  protected void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Ajnh.a();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Ajnh.jdField_c_of_type_JavaLangString = paramBundle.getString("mibao_change_url");
      this.jdField_a_of_type_Ajnh.jdField_b_of_type_JavaLangString = paramBundle.getString("mibao_set_url");
      this.jdField_a_of_type_Ajnh.d = paramBundle.getString("mibao_verify_url");
      paramBundle = paramBundle.getParcelableArray("phone_info");
      if (paramBundle != null)
      {
        int i = 0;
        if (i < paramBundle.length)
        {
          Bundle localBundle = (Bundle)paramBundle[i];
          if (localBundle == null) {}
          int j;
          for (;;)
          {
            i += 1;
            break;
            j = localBundle.getInt("phone_type");
            switch (j)
            {
            default: 
              break;
            case 1: 
              this.jdField_a_of_type_Ajnh.jdField_a_of_type_JavaLangString = localBundle.getString("phone");
              this.jdField_a_of_type_Ajnh.jdField_a_of_type_Int = localBundle.getInt("status");
              this.jdField_a_of_type_Ajnh.jdField_a_of_type_AndroidUtilSparseArray.put(j, localBundle.getByteArray("vaskey"));
            }
          }
          Object localObject = localBundle.getString("phone");
          ajnh localajnh = this.jdField_a_of_type_Ajnh;
          if ((localBundle.getInt("status") == 1) && (!TextUtils.isEmpty((CharSequence)localObject))) {}
          for (boolean bool = true;; bool = false)
          {
            localajnh.jdField_a_of_type_Boolean = bool;
            this.jdField_a_of_type_Ajnh.jdField_a_of_type_AndroidUtilSparseArray.put(j, localBundle.getByteArray("vaskey"));
            break;
          }
          localObject = this.jdField_a_of_type_Ajnh;
          if (!TextUtils.isEmpty(localBundle.getString("phone")))
          {
            bool = true;
            label277:
            ((ajnh)localObject).jdField_c_of_type_Boolean = bool;
            localObject = this.jdField_a_of_type_Ajnh;
            if ((!this.jdField_a_of_type_Ajnh.jdField_c_of_type_Boolean) || (localBundle.getInt("status") != 1)) {
              break label350;
            }
          }
          label350:
          for (bool = true;; bool = false)
          {
            ((ajnh)localObject).jdField_b_of_type_Boolean = bool;
            this.jdField_a_of_type_Ajnh.jdField_a_of_type_AndroidUtilSparseArray.put(j, localBundle.getByteArray("vaskey"));
            break;
            bool = false;
            break label277;
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
  }
  
  public byte[] a(int paramInt)
  {
    return (byte[])this.jdField_a_of_type_Ajnh.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void b()
  {
    if (!bhnv.d(this)) {
      a(2131694008);
    }
    aohe localaohe;
    do
    {
      return;
      localaohe = (aohe)this.app.a(34);
    } while (localaohe == null);
    localaohe.d();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(paramBoolean);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
  }
  
  public void c()
  {
    if (!bhnv.d(this)) {
      a(2131694008);
    }
    aohe localaohe;
    do
    {
      return;
      localaohe = (aohe)this.app.a(34);
    } while (localaohe == null);
    localaohe.e();
  }
  
  public void d()
  {
    if (!bhnv.d(this)) {
      a(2131694008);
    }
    aohe localaohe;
    do
    {
      return;
      localaohe = (aohe)this.app.a(34);
    } while (localaohe == null);
    if (QLog.isColorLevel()) {
      QLog.e("PhoneUnityBindInfoActivity", 2, "unbindPhoneNumLoginOnPhoneUnity contact.");
    }
    localaohe.c();
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
    case 1010: 
    default: 
      return;
    case 1008: 
      if ((paramInt2 != 0) && (paramInt2 == -1))
      {
        a();
        return;
      }
      a(false);
      QQToast.a(this, 1, getResources().getString(2131694247), 0).b(getTitleBarHeight());
      return;
    }
    a(1, null);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getBundleExtra("kBindPhoneData");
    super.setContentView(2131561394);
    super.setTitle(getString(2131698370));
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    this.jdField_a_of_type_Ajng = ((ajng)this.app.getManager(102));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131370776));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131372467));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131364340));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131363481));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131363482));
    paramBundle = super.findViewById(2131372444);
    if (ThemeUtil.isNowThemeIsNight(this.app, false, null)) {
      paramBundle.setBackgroundColor(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (this.jdField_a_of_type_Ajng != null) {
        this.jdField_a_of_type_Ajng.jdField_a_of_type_Boolean = true;
      }
      super.addObserver(this.jdField_a_of_type_Aohf);
      a(1, this.jdField_a_of_type_AndroidOsBundle);
      return true;
      paramBundle.setBackgroundColor(-1);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    super.removeObserver(this.jdField_a_of_type_Aohf);
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    if (this.jdField_a_of_type_Azov != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_Azov);
      this.jdField_a_of_type_Azov = null;
    }
    if (this.jdField_b_of_type_Azov != null)
    {
      this.app.unRegistObserver(this.jdField_b_of_type_Azov);
      this.jdField_b_of_type_Azov = null;
    }
    if (this.jdField_c_of_type_Azov != null)
    {
      this.app.unRegistObserver(this.jdField_c_of_type_Azov);
      this.jdField_c_of_type_Azov = null;
    }
    if (this.jdField_a_of_type_Blir != null)
    {
      this.jdField_a_of_type_Blir.e();
      this.jdField_a_of_type_Blir = null;
    }
    if (this.jdField_a_of_type_Bhpc != null)
    {
      this.jdField_a_of_type_Bhpc.dismiss();
      this.jdField_a_of_type_Bhpc = null;
    }
    if (this.jdField_b_of_type_Bhpc != null)
    {
      this.jdField_b_of_type_Bhpc.dismiss();
      this.jdField_b_of_type_Bhpc = null;
    }
    if (this.jdField_c_of_type_Bhpc != null)
    {
      this.jdField_c_of_type_Bhpc.dismiss();
      this.jdField_c_of_type_Bhpc = null;
    }
    if (this.d != null)
    {
      this.d.dismiss();
      this.d = null;
    }
    if (this.e != null)
    {
      this.e.dismiss();
      this.e = null;
    }
  }
  
  public void e()
  {
    if (!bhnv.d(this)) {
      a(2131694008);
    }
    do
    {
      aohe localaohe;
      do
      {
        return;
        localaohe = (aohe)this.app.a(34);
      } while ((localaohe == null) || (this.jdField_a_of_type_AndroidOsBundle == null));
      QLog.i("PhoneUnityBindInfoActivity", 1, "phone_unity_info_login, unbindPhoneNumLogin");
      byte[] arrayOfByte = a(2);
      if (arrayOfByte != null)
      {
        localaohe.b(arrayOfByte);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("PhoneUnityBindInfoActivity", 2, "unbindPhoneNumLogin contact vaskey is null.");
  }
  
  public void f()
  {
    if (!bhnv.d(this)) {
      a(2131694008);
    }
    do
    {
      aohe localaohe;
      do
      {
        return;
        localaohe = (aohe)this.app.a(34);
      } while ((localaohe == null) || (this.jdField_a_of_type_AndroidOsBundle == null));
      QLog.i("PhoneUnityBindInfoActivity", 1, "phone_unity_info_login, bindPhoneNumLogin");
      byte[] arrayOfByte = a(2);
      if (arrayOfByte != null)
      {
        localaohe.a(arrayOfByte);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("PhoneUnityBindInfoActivity", 2, "bindPhoneNumLogin contact vaskey is null.");
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      if (QLog.isColorLevel()) {
        QLog.e("PhoneUnityBindInfoActivity", 2, "InfoBundle is null.");
      }
    }
    do
    {
      return;
      if (!bhnv.d(this))
      {
        a(2131694008);
        return;
      }
      if (this.jdField_a_of_type_Azov == null)
      {
        this.jdField_a_of_type_Azov = new afdc(this);
        this.app.registObserver(this.jdField_a_of_type_Azov);
      }
      byte[] arrayOfByte = a(3);
      if (arrayOfByte != null)
      {
        QLog.i("PhoneUnityBindInfoActivity", 1, "phone_unity_info, unbindMobileEncrypt");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(arrayOfByte, true, false);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("PhoneUnityBindInfoActivity", 2, "unbindMobileEncrypt contact vaskey is null.");
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {}
    do
    {
      return;
      if (!bhnv.d(this))
      {
        a(2131694008);
        return;
      }
      if (this.jdField_b_of_type_Azov == null)
      {
        this.jdField_b_of_type_Azov = new afdd(this);
        this.app.registObserver(this.jdField_b_of_type_Azov);
      }
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("country_code");
      byte[] arrayOfByte = a(3);
      if (arrayOfByte != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.a(str, arrayOfByte, 0, true, false);
        return;
      }
      a(false);
      QQToast.a(this, 1, getResources().getString(2131694247), 0).b(getTitleBarHeight());
    } while (!QLog.isColorLevel());
    QLog.e("PhoneUnityBindInfoActivity", 2, "sendBindMobileEncrypt contact vaskey is null.");
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {}
    Intent localIntent;
    do
    {
      return;
      byte[] arrayOfByte = a(3);
      if (arrayOfByte == null)
      {
        QLog.e("PhoneUnityBindInfoActivity", 2, "gotoBindVerify contact phoneVasKey is null.");
        return;
      }
      a(false);
      String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("country_code");
      String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("phone");
      localIntent = new Intent(this, BindVerifyActivity.class);
      localIntent.putExtra("kSrouce", 23);
      localIntent.putExtra("kBindType", 0);
      localIntent.putExtra("keyReqBindMode", 0);
      localIntent.putExtra("cmd_param_is_encrypt", true);
      localIntent.putExtra("cmd_param_encrypt_mobile", arrayOfByte);
      localIntent.putExtra("k_mask_number_forshow", str2);
      localIntent.putExtra("k_country_code", str1);
      localIntent.putExtra("k_is_block", getIntent().getBooleanExtra("k_is_block", false));
      localIntent.putExtra("key_is_from_qqhotspot", getIntent().getBooleanExtra("key_is_from_qqhotspot", false));
      localIntent.putExtra("cmd_param_is_from_uni", true);
      localIntent.putExtra("key_is_from_qav_multi_call", getIntent().getBooleanExtra("key_is_from_qav_multi_call", false));
      localIntent.putExtra("cmd_param_is_from_change_bind", false);
      localIntent.addFlags(536870912);
      localIntent.addFlags(67108864);
    } while (isFinishing());
    startActivityForResult(localIntent, 1008);
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Bhpc == null)
    {
      String str = getString(2131694250);
      this.jdField_a_of_type_Bhpc = bhlq.a(this, 230, getString(2131694249), str, null, anzj.a(2131700041), new afcp(this), null);
    }
    if ((this.jdField_a_of_type_Bhpc != null) && (!this.jdField_a_of_type_Bhpc.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_Bhpc.show();
    }
  }
  
  public void k()
  {
    if (this.jdField_b_of_type_Bhpc == null) {
      this.jdField_b_of_type_Bhpc = bhlq.a(this, 230, null, getString(2131694251), null, anzj.a(2131700045), new afcq(this), null);
    }
    if ((this.jdField_b_of_type_Bhpc != null) && (!this.jdField_b_of_type_Bhpc.isShowing()) && (!isFinishing())) {
      this.jdField_b_of_type_Bhpc.show();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    ViewParent localViewParent = paramCompoundButton.getParent();
    if (this.jdField_a_of_type_Ajnh.jdField_a_of_type_Int == 3)
    {
      o();
      if (localViewParent == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem)
      {
        bool1 = bool2;
        if (!paramBoolean) {
          bool1 = true;
        }
        a(bool1);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (localViewParent == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem)
      {
        if (!paramBoolean) {}
        for (;;)
        {
          b(bool1);
          break;
          bool1 = false;
        }
        if (localViewParent == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem)
        {
          if (!bhnv.d(this))
          {
            QQToast.a(this, getString(2131691989), 0).b(getTitleBarHeight());
            if (!paramBoolean) {}
            for (bool1 = bool3;; bool1 = false)
            {
              a(bool1);
              break;
            }
          }
          if (!this.jdField_a_of_type_Ajnh.jdField_c_of_type_Boolean)
          {
            bdll.b(this.app, "dc00898", "", "", "0X800B319", "0X800B319", 0, 0, "2", "", "", "");
            p();
          }
          else if (!this.jdField_a_of_type_Ajnh.jdField_b_of_type_Boolean)
          {
            b();
            bdll.b(this.app, "dc00898", "", "", "0X800B319", "0X800B319", 0, 0, "1", "", "", "");
          }
          else
          {
            c();
          }
        }
        else if (localViewParent == this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem)
        {
          if (!bhnv.d(this))
          {
            QQToast.a(this, getString(2131691989), 0).b(getTitleBarHeight());
            if (!paramBoolean) {}
            for (bool1 = bool4;; bool1 = false)
            {
              b(bool1);
              break;
            }
          }
          if (!this.jdField_a_of_type_Ajnh.jdField_a_of_type_Boolean)
          {
            f();
          }
          else
          {
            e();
            this.jdField_a_of_type_Ajnh.jdField_a_of_type_Boolean = false;
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Ajnh.jdField_a_of_type_Int == 3) && (!TextUtils.isEmpty(this.jdField_a_of_type_Ajnh.d)))
      {
        bdll.b(this.app, "dc00898", "", "", "0X800B317", "0X800B317", 0, 0, "", "", "", "");
        ajng.a(this, this.app, this.jdField_a_of_type_Ajnh.d, 1010);
      }
      else if (!TextUtils.isEmpty(this.jdField_a_of_type_Ajnh.jdField_c_of_type_JavaLangString))
      {
        bdll.b(this.app, "dc00898", "", "", "0X800B315", "0X800B315", 0, 0, "", "", "", "");
        this.jdField_b_of_type_Int = 1;
        b(this.jdField_a_of_type_Ajnh.jdField_c_of_type_JavaLangString);
      }
      else
      {
        QLog.e("PhoneUnityBindInfoActivity", 2, "change bind phone error.");
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