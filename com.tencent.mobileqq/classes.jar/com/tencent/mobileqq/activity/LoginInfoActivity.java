package com.tencent.mobileqq.activity;

import QQService.SvcDevLoginInfo;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.QQProtectRisks.QQProtectRisksRequest;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollListener;
import com.tencent.mqp.app.sec.ScConfigManager;
import com.tencent.mqp.app.sec.SecCenterConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.common.QPMiscUtils;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.immersive.SystemBarCompact;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import swt;
import swu;
import swv;
import sww;
import swx;
import swy;
import swz;
import sxa;
import sxe;
import sxf;
import sxg;
import sxh;
import sxi;
import sxj;

public class LoginInfoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, ScrollListener
{
  private static int jdField_b_of_type_Int;
  private static int jdField_c_of_type_Int = 1;
  private static int jdField_d_of_type_Int = 2;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new sxg(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new sxe(this);
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List jdField_a_of_type_JavaUtilList;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new sxf(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new swt(this);
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = jdField_b_of_type_Int;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private boolean jdField_f_of_type_Boolean = true;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private boolean jdField_g_of_type_Boolean = true;
  private ImageView jdField_h_of_type_AndroidWidgetImageView;
  private boolean jdField_h_of_type_Boolean = true;
  private ImageView jdField_i_of_type_AndroidWidgetImageView;
  private boolean jdField_i_of_type_Boolean;
  private ImageView j;
  
  private String a(String paramString)
  {
    SecCenterConfig localSecCenterConfig = (SecCenterConfig)ScConfigManager.a().a("SecCenterConfig", false);
    if (localSecCenterConfig != null) {
      return localSecCenterConfig.a("ModifyPwdUrls", paramString);
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new swy(this, paramInt));
  }
  
  private void a(long paramLong, String paramString)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("sp_qs_settings", 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("qsec_status_expired_time" + this.app.getCurrentAccountUin(), paramLong).putString("qsec_status_tip_text" + this.app.getCurrentAccountUin(), paramString).putLong("qsec_status_update_last_time" + this.app.getCurrentAccountUin(), new Date().getTime()).commit();
    }
  }
  
  private void a(RelativeLayout paramRelativeLayout, int paramInt)
  {
    if ((paramRelativeLayout instanceof FormSimpleItem)) {
      ((FormSimpleItem)paramRelativeLayout).setBgType(paramInt);
    }
    while (!(paramRelativeLayout instanceof FormSwitchItem)) {
      return;
    }
    ((FormSwitchItem)paramRelativeLayout).setBgType(paramInt);
  }
  
  private void a(String paramString, int paramInt)
  {
    ReportController.b(null, "dc00899", "Safe_SecCenter", "", "ModifyPwd", paramString, paramInt, 0, "", "", "", "");
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    int m;
    int k;
    SvcDevLoginInfo localSvcDevLoginInfo;
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      m = paramList.size();
      k = 0;
      while (k < m)
      {
        localSvcDevLoginInfo = (SvcDevLoginInfo)paramList.get(k);
        if (localSvcDevLoginInfo != null) {
          break label76;
        }
        k += 1;
      }
    }
    label76:
    View localView = getLayoutInflater().inflate(2130969060, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    Object localObject1 = (RelativeLayout)localView.findViewById(2131362731);
    label119:
    Object localObject2;
    TextView localTextView1;
    Button localButton;
    TextView localTextView2;
    ImageView localImageView;
    if (m == 1)
    {
      ((RelativeLayout)localObject1).setBackgroundResource(2130838619);
      getResources().getString(2131436487);
      localObject2 = getResources().getString(2131436486);
      localTextView1 = (TextView)localView.findViewById(2131364899);
      localButton = (Button)localView.findViewById(2131364900);
      if (AppSetting.jdField_b_of_type_Boolean)
      {
        localTextView1.setContentDescription(getString(2131436486));
        localButton.setContentDescription(getString(2131436487));
      }
      localTextView2 = (TextView)localView.findViewById(2131362736);
      localObject1 = (TextView)localView.findViewById(2131364095);
      localImageView = (ImageView)localView.findViewById(2131362701);
      if (k != 0) {
        break label470;
      }
      localTextView1.setText((CharSequence)localObject2);
      localTextView1.setClickable(false);
      localButton.setVisibility(8);
      localTextView1.setVisibility(0);
      localImageView.setImageResource(2130839303);
      label275:
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceName)) {
        break label558;
      }
      localTextView2.setText(2131436490);
    }
    for (;;)
    {
      localObject2 = new StringBuffer();
      if (localSvcDevLoginInfo.iLoginTime > 0L) {
        ((StringBuffer)localObject2).append(TimeFormatterUtils.a(localSvcDevLoginInfo.iLoginTime * 1000L, "MM-dd HH:mm"));
      }
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strLoginLocation))
      {
        ((StringBuffer)localObject2).append(" ");
        ((StringBuffer)localObject2).append(localSvcDevLoginInfo.strLoginLocation);
      }
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceTypeInfo))
      {
        ((StringBuffer)localObject2).append(" ");
        ((StringBuffer)localObject2).append(localSvcDevLoginInfo.strDeviceTypeInfo);
      }
      if (((StringBuffer)localObject2).length() > 0) {
        ((TextView)localObject1).setText(((StringBuffer)localObject2).toString());
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      break;
      if (k == 0)
      {
        ((RelativeLayout)localObject1).setBackgroundResource(2130838631);
        break label119;
      }
      if (k == m - 1)
      {
        ((RelativeLayout)localObject1).setBackgroundResource(2130838626);
        break label119;
      }
      ((RelativeLayout)localObject1).setBackgroundResource(2130838629);
      break label119;
      label470:
      if (localSvcDevLoginInfo.iProductType == 1L)
      {
        localTextView1.setVisibility(8);
        localButton.setVisibility(8);
        localImageView.setImageResource(2130839301);
        break label275;
      }
      localTextView1.setVisibility(8);
      localButton.setVisibility(0);
      localButton.setTag(localSvcDevLoginInfo);
      localButton.setClickable(true);
      localImageView.setImageResource(2130839302);
      localButton.setOnClickListener(new sxa(this, localButton, k));
      break label275;
      label558:
      localTextView2.setText(localSvcDevLoginInfo.strDeviceName);
    }
  }
  
  private void a(DevlockInfo paramDevlockInfo)
  {
    if ((paramDevlockInfo != null) && (!TextUtils.isEmpty(paramDevlockInfo.MbGuideInfo))) {
      EquipmentLockImpl.a().a(paramDevlockInfo.MbGuideInfo);
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    int k;
    if (paramDevlockInfo != null) {
      if (paramDevlockInfo.DevSetup == 1) {
        k = 1;
      }
    }
    for (;;)
    {
      if (k != 0)
      {
        EquipmentLockImpl.a().a(this.app, this, this.app.getCurrentAccountUin(), true);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131436541));
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842430);
        return;
        k = 0;
      }
      else
      {
        EquipmentLockImpl.a().a(this.app, this, this.app.getCurrentAccountUin(), false);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131436540));
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842429);
        return;
        k = 0;
      }
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (!this.jdField_e_of_type_Boolean) {
      return;
    }
    Object localObject1 = new AnimationSet(false);
    Object localObject2 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 2, 0.0F, 2, 1.0F);
    ((Animation)localObject2).setDuration(500L);
    Object localObject3 = new AlphaAnimation(1.0F, 0.0F);
    ((Animation)localObject3).setDuration(500L);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
    ((AnimationSet)localObject1).addAnimation((Animation)localObject3);
    this.jdField_b_of_type_AndroidWidgetTextView.startAnimation((Animation)localObject1);
    ((AnimationSet)localObject1).setAnimationListener(new swu(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    if (AppSetting.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramString);
    }
    paramString = new AnimationSet(false);
    localObject1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 2, -1.0F, 2, 0.0F);
    ((Animation)localObject1).setDuration(500L);
    localObject2 = new AlphaAnimation(0.0F, 1.0F);
    ((Animation)localObject2).setDuration(500L);
    paramString.addAnimation((Animation)localObject1);
    paramString.addAnimation((Animation)localObject2);
    this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(paramString);
    localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      ((TextView)localObject1).setClickable(bool);
      if (!paramBoolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(paramString);
      }
      paramString = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramBoolean) {
        break label551;
      }
      bool = true;
      label252:
      paramString.setClickable(bool);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130843760);
      paramString = new AnimationSet(false);
      localObject1 = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      ((Animation)localObject1).setDuration(500L);
      localObject2 = new AlphaAnimation(1.0F, 0.0F);
      ((Animation)localObject2).setDuration(500L);
      paramString.addAnimation((Animation)localObject1);
      paramString.addAnimation((Animation)localObject2);
      this.jdField_f_of_type_AndroidWidgetImageView.startAnimation(paramString);
      paramString.setAnimationListener(new swv(this));
      paramString = new AnimationSet(false);
      localObject1 = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      ((Animation)localObject1).setDuration(500L);
      localObject2 = new AlphaAnimation(0.0F, 1.0F);
      ((Animation)localObject2).setDuration(500L);
      localObject3 = new RotateAnimation(90.0F, -5.0F, 1, 0.5F, 1, 0.5F);
      ((Animation)localObject3).setDuration(500L);
      RotateAnimation localRotateAnimation = new RotateAnimation(-5.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(500L / 10L);
      localRotateAnimation.setStartOffset(500L);
      paramString.addAnimation((Animation)localObject1);
      paramString.addAnimation((Animation)localObject2);
      paramString.addAnimation((Animation)localObject3);
      paramString.addAnimation(localRotateAnimation);
      if (!paramBoolean) {
        break label556;
      }
      this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetImageView.startAnimation(paramString);
    }
    for (;;)
    {
      a(paramBoolean, true);
      this.jdField_d_of_type_Boolean = false;
      this.jdField_e_of_type_Boolean = false;
      return;
      bool = false;
      break;
      label551:
      bool = false;
      break label252;
      label556:
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_h_of_type_AndroidWidgetImageView.startAnimation(paramString);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    d(-1);
    if (!paramBoolean1)
    {
      c(-31676);
      if (!paramBoolean2)
      {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130843762);
        if (!paramBoolean1) {
          break label109;
        }
      }
    }
    label109:
    for (int k = 2130843769;; k = 2130843759)
    {
      this.jdField_h_of_type_Boolean = this.jdField_g_of_type_Boolean;
      this.jdField_g_of_type_Boolean = paramBoolean1;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(k);
      getTitleBarView().setBackgroundResource(k);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundResource(k);
      return;
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130843760);
      break;
      c(-15550475);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130843761);
      break;
    }
  }
  
  private void b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramInt & 0x1) != 0)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      localArrayList.add(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem);
      if ((paramInt & 0x2) == 0) {
        break label123;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      localArrayList.add(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem);
      label58:
      if ((paramInt & 0x4) == 0) {
        break label135;
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      localArrayList.add(this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem);
      label83:
      paramInt = localArrayList.size();
      if (paramInt != 1) {
        break label147;
      }
      a((RelativeLayout)localArrayList.get(0), 0);
    }
    label123:
    do
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break;
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break label58;
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
      break label83;
      if (paramInt == 2)
      {
        a((RelativeLayout)localArrayList.get(0), 1);
        a((RelativeLayout)localArrayList.get(1), 3);
        return;
      }
    } while (paramInt != 3);
    label135:
    label147:
    a((RelativeLayout)localArrayList.get(0), 1);
    a((RelativeLayout)localArrayList.get(1), 2);
    a((RelativeLayout)localArrayList.get(2), 3);
  }
  
  private void b(boolean paramBoolean, String paramString)
  {
    if (!this.jdField_d_of_type_Boolean) {
      return;
    }
    this.jdField_e_of_type_Boolean = true;
    Object localObject = new TranslateAnimation(0, 0.0F, 0, 0.0F, 2, -0.25F, 2, 0.9F);
    ((Animation)localObject).setDuration(1500L);
    ((Animation)localObject).setRepeatMode(1);
    this.jdField_c_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
    ((Animation)localObject).setAnimationListener(new sww(this));
    localObject = new AnimationSet(false);
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 1620.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(1500L);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(1500L);
    ((AnimationSet)localObject).addAnimation(localRotateAnimation);
    ((AnimationSet)localObject).addAnimation(localAlphaAnimation);
    this.jdField_d_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
    ((AnimationSet)localObject).setAnimationListener(new swx(this, paramBoolean, paramString));
  }
  
  private void c()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new swz(this));
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = this.mSystemBarComp;
    this.mSystemBarComp = null;
    new SystemBarCompact(this, true, paramInt).init();
  }
  
  private void d()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131494210));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
  }
  
  private void d(int paramInt)
  {
    if (this.leftView != null)
    {
      this.leftView.setTextColor(paramInt);
      Drawable localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(2130845754);
      this.leftView.setBackgroundDrawable(localDrawable);
    }
    if (this.leftViewNotBack != null) {
      this.leftViewNotBack.setTextColor(paramInt);
    }
    if (this.centerView != null) {
      this.centerView.setTextColor(paramInt);
    }
    if (this.rightViewText != null) {
      this.rightViewText.setTextColor(paramInt);
    }
    if (this.rightHighLView != null) {
      this.rightHighLView.setTextColor(paramInt);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Int = GesturePWDUtils.getGesturePWDState(this, this.app.getCurrentAccountUin());
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131436020));
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131436019));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131436018));
  }
  
  private void f()
  {
    ThreadManager.postImmediately(new sxi(this, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem), null, true);
  }
  
  private void g()
  {
    if (this.jdField_d_of_type_Boolean) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    a(this.jdField_f_of_type_Boolean, false);
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(20170210, 300L);
    Object localObject = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    ((Animation)localObject).setDuration(333L);
    ((Animation)localObject).setRepeatCount(-1);
    ((Animation)localObject).setInterpolator(new LinearInterpolator());
    this.jdField_d_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
    localObject = new TranslateAnimation(0, 0.0F, 0, 0.0F, 2, -0.25F, 2, 0.9F);
    ((Animation)localObject).setDuration(1000L);
    ((Animation)localObject).setRepeatMode(1);
    ((Animation)localObject).setRepeatCount(-1);
    this.jdField_c_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
  }
  
  private void h()
  {
    if (!this.jdField_i_of_type_Boolean) {
      if (this.jdField_g_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundColor(-15550475);
        this.jdField_i_of_type_Boolean = true;
      }
    }
    while (this.jdField_h_of_type_Boolean == this.jdField_g_of_type_Boolean) {
      for (;;)
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundColor(-31676);
      }
    }
    if (this.jdField_g_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundColor(-15550475);
    }
    for (;;)
    {
      this.jdField_i_of_type_Boolean = true;
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundColor(-31676);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginInfoActivity.AccDevSec", 2, "startGetDevLockStatus begin to CheckDevLockStatus");
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    String str = this.app.getCurrentAccountUin();
    int k = EquipmentLockImpl.a().a(this.app, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (k != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "startGetDevLockStatus CheckDevLockStatus failed. ret=" + k);
      }
      d();
    }
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      if ((paramFloat2 - this.jdField_b_of_type_Float > 600.0F) && (this.jdField_c_of_type_Boolean)) {
        b();
      }
    }
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 > 0)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundResource(2130838210);
      this.jdField_i_of_type_Boolean = false;
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    h();
  }
  
  protected void b()
  {
    if ((this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean)) {
      return;
    }
    g();
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    QQProtectRisks.QQProtectRisksRequest localQQProtectRisksRequest = new QQProtectRisks.QQProtectRisksRequest();
    localQQProtectRisksRequest.uint32_sec_cmd.set(1);
    localQQProtectRisksRequest.str_package_name.set(QPMiscUtils.c());
    localQQProtectRisksRequest.uint32_app_id.set(AppSetting.jdField_a_of_type_Int);
    ProtoUtils.a(this.app, new sxh(this), localQQProtectRisksRequest.toByteArray(), "AccountSafeSvc.RiskDetect");
  }
  
  public void b(View paramView, float paramFloat1, float paramFloat2)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool1;
    if (paramInt1 == 0) {
      if (((paramInt2 == 0) || (paramInt2 == -1)) && (paramIntent != null) && (paramIntent.getExtras() != null) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null))
      {
        paramIntent = paramIntent.getExtras();
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup != 1) {
          break label153;
        }
        bool1 = true;
        bool1 = paramIntent.getBoolean("auth_dev_open", bool1);
        String str = paramIntent.getString("phone_num");
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 1) {}
        boolean bool2 = paramIntent.getBoolean("allow_set");
        if (!bool1) {
          break label159;
        }
        this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup = 1;
        label110:
        if (!TextUtils.isEmpty(str)) {
          this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = str;
        }
        if (!bool2) {
          break label170;
        }
        this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet = 1;
        label140:
        a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
        b();
      }
    }
    label153:
    label159:
    label170:
    do
    {
      return;
      bool1 = false;
      break;
      this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup = 0;
      break label110;
      this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet = 0;
      break label140;
      if (paramInt1 == 1)
      {
        e();
        return;
      }
      if (paramInt1 == 2)
      {
        f();
        return;
      }
    } while (paramInt1 != 3);
    b();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130969059);
    setTitle(2131436782);
    d(-1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131364865));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364888));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364867));
    paramBundle = (RelativeLayout)findViewById(2131364868);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364872));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364873));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364874));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364876));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364869));
    this.j = ((ImageView)findViewById(2131364870));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364871));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364875));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364877));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364878));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364879));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364880));
    if (AppSetting.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131436615));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364884));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364889));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364885));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364891));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131364890));
    if (AppSetting.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131433485));
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364883);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364893));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364894));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    if (AppSetting.jdField_b_of_type_Boolean) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131436628));
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131364895));
    if (AppSetting.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131435426));
    }
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    boolean bool = SettingCloneUtil.readValue(this, this.app.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    bool = SettingCloneUtil.readValue(this, null, "security_scan_key", "qqsetting_security_scan_key", false);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    if (!EquipmentLockImpl.a().b()) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramBundle = new SpannableString(getResources().getString(2131436484));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131364887));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131363448));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364886));
    int k = paramBundle.length();
    paramBundle.setSpan(new sxj(this, null), 0, k, 33);
    paramBundle.setSpan(new ForegroundColorSpan(getResources().getColor(2131494217)), 0, k, 33);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramBundle);
    try
    {
      this.jdField_c_of_type_JavaLangString = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      if (QLog.isColorLevel()) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "packName = " + this.jdField_c_of_type_JavaLangString);
      }
      a(null);
      if (QLog.isColorLevel()) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "onCreate begin to getLoginDevList");
      }
      if (NetworkUtil.d(this))
      {
        bool = EquipmentLockImpl.a().a(this.app, this.jdField_c_of_type_JavaLangString, 0L);
        if (bool)
        {
          a();
          e();
          f();
          b();
          return true;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        continue;
        if (QLog.isColorLevel())
        {
          QLog.d("LoginInfoActivity.AccDevSec", 2, "onCreate getLoginDevList failed ret=" + bool);
          continue;
          QQToast.a(this, getString(2131432992), 0).b(getTitleBarHeight());
        }
      }
    }
  }
  
  protected void doOnDestroy()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
      this.mSystemBarComp = this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
    }
    super.doOnDestroy();
    c();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.app.removeHandler(getClass());
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    d(-1);
    a();
    e();
    f();
  }
  
  protected boolean onBackEvent()
  {
    boolean bool2 = true;
    Intent localIntent;
    boolean bool1;
    if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
    {
      localIntent = new Intent();
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup != 1) {
        break label71;
      }
      bool1 = true;
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet != 1) {
        break label76;
      }
    }
    for (;;)
    {
      localIntent.putExtra("auth_dev_open", bool1);
      localIntent.putExtra("allow_set", bool2);
      setResult(0, localIntent);
      finish();
      return false;
      label71:
      bool1 = false;
      break;
      label76:
      bool2 = false;
    }
  }
  
  public void onClick(View paramView)
  {
    int k = 0;
    Object localObject1;
    switch (paramView.getId())
    {
    case 2131364879: 
    case 2131364881: 
    case 2131364882: 
    case 2131364885: 
    case 2131364886: 
    case 2131364887: 
    case 2131364888: 
    case 2131364890: 
    case 2131364892: 
    default: 
    case 2131364884: 
      do
      {
        return;
        ReportController.b(this.app, "CliOper", "", "", "My_eq", "My_eq_protect", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
        {
          if (!NetworkUtil.d(this))
          {
            QQToast.a(this, getString(2131432992), 0).b(getTitleBarHeight());
            return;
          }
          a();
          return;
        }
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
        {
          this.app.sendWirelessMeibaoReq(1);
          paramView = new Intent(this, AuthDevActivity.class);
          paramView.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          paramView.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
          paramView.putExtra("auth_dev_open", true);
          startActivityForResult(paramView, 0);
          return;
        }
        this.app.sendWirelessMeibaoReq(1);
        if (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))
        {
          paramView = new Intent(this, AuthDevOpenUgActivity.class);
          paramView.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
          startActivityForResult(paramView, 0);
          return;
        }
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 0)
        {
          paramView = new Intent(this, AuthDevOpenUgActivity.class);
          paramView.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
          startActivityForResult(paramView, 0);
          return;
        }
      } while (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet != 1);
      paramView = new Intent(this, AuthDevActivity.class);
      paramView.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
      paramView.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
      paramView.putExtra("auth_dev_open", false);
      startActivityForResult(paramView, 0);
      return;
    case 2131364893: 
      startActivity(new Intent(this, SecurityPickproofActivity.class));
      ReportController.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof", "enter pickproof page", 0, 0, "", "", "", "");
      return;
    case 2131364889: 
      if (!NetworkUtil.d(this))
      {
        QQToast.a(this, getString(2131432992), 0).b(getTitleBarHeight());
        return;
      }
      ReportController.b(this.app, "CliOper", "", "", "My_eq", "Clk_eq_recently", 0, 0, "", "", "", "");
      startActivity(new Intent(this, RecentLoginDevActivity.class));
      return;
    case 2131364891: 
      startActivityForResult(new Intent(this, GesturePWDSettingActivity.class), 1);
      return;
    case 2131364883: 
      if (PhoneNumLoginImpl.a().a(this.app, this.app.getCurrentAccountUin()))
      {
        localObject1 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("uin", this.app.getCurrentAccountUin());
        paramView = a("HasSetPwdUrl");
        if ((paramView != null) && (!paramView.equals(""))) {
          break label1170;
        }
        paramView = "http://aq.qq.com/cn2/change_psw/mobile/mobile_change_psw_way?source_id=2733";
      }
      break;
    }
    for (;;)
    {
      if (paramView.indexOf("?") == -1) {}
      for (paramView = paramView + "?uin=" + this.app.getCurrentAccountUin();; paramView = paramView + "&uin=" + this.app.getCurrentAccountUin())
      {
        startActivity(((Intent)localObject1).putExtra("url", paramView));
        this.app.sendWirelessPswReq(1);
        if (k == 0) {
          a("FetchUrl", 1);
        }
        a("ClkModifyPwd", 1);
        return;
      }
      localObject1 = this.app.getCurrentAccountUin();
      paramView = a("RegNewUrl");
      if ((paramView == null) || (paramView.equals(""))) {
        paramView = "http://aq.qq.com/cn2/change_psw/mobile/mobile_change_psw_reg_input_psw";
      }
      for (k = 0;; k = 1)
      {
        Object localObject2 = new StringBuilder(paramView);
        if (paramView.indexOf("?") == -1) {
          ((StringBuilder)localObject2).append("?");
        }
        for (;;)
        {
          ((StringBuilder)localObject2).append("uin=");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("&plat=1");
          ((StringBuilder)localObject2).append("&app=1");
          ((StringBuilder)localObject2).append("&version=7.6.0.3525");
          ((StringBuilder)localObject2).append("&device=" + URLEncoder.encode(Build.DEVICE));
          ((StringBuilder)localObject2).append("&system=" + Build.VERSION.RELEASE);
          ((StringBuilder)localObject2).append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
          paramView = ((StringBuilder)localObject2).toString();
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("portraitOnly", true);
          ((Intent)localObject2).putExtra("url", paramView);
          ((Intent)localObject2).putExtra("uin", (String)localObject1);
          ((Intent)localObject2).putExtra("hide_operation_bar", true);
          ((Intent)localObject2).putExtra("hide_more_button", true);
          VasWebviewUtil.openQQBrowserActivity(this, paramView, 32768L, (Intent)localObject2, false, -1);
          if (k == 0) {
            a("FetchUrl", 2);
          }
          a("ClkModifyPwd", 2);
          return;
          ((StringBuilder)localObject2).append("&");
        }
        startActivityForResult(new Intent(this, SecurityProtectActivity.class), 2);
        ReportController.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on qqpimsecure_detect", 0, 0, "", "", "", "");
        return;
        if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
          break;
        }
        paramView = new Intent(this, RiskInfoActivity.class);
        paramView.putParcelableArrayListExtra("data", this.jdField_a_of_type_JavaUtilArrayList);
        paramView.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
        startActivityForResult(paramView, 3);
        ReportController.b(this.app, "dc00899", "Safe_RiskInfo", "", "RiskDetails", "click on risk details", 0, 0, "", "", "", "");
        return;
      }
      label1170:
      k = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity
 * JD-Core Version:    0.7.0.1
 */