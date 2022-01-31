package com.tencent.mobileqq.activity;

import QQService.SvcDevLoginInfo;
import ablq;
import ablr;
import abls;
import ablt;
import ablu;
import ablv;
import ablw;
import ablx;
import ably;
import ablz;
import abma;
import abmb;
import abmd;
import abme;
import abmf;
import ajxl;
import android.app.Dialog;
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
import android.support.v4.util.MQLruCache;
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
import aoen;
import arch;
import atzl;
import aumi;
import avpq;
import axby;
import axqw;
import bazw;
import bbev;
import bbjn;
import bbkb;
import bcpq;
import bcpw;
import bcqs;
import bcwt;
import bfhb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.QQProtectRisks.QQProtectRisksRequest;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mqp.app.sec.ScConfigManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.immersive.SystemBarCompact;
import face.qqlogin.FaceSecureCheck.SecureCheckResponse;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import mxi;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x5e1.UdcUinData;

public class LoginInfoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, bcqs
{
  public static volatile int a;
  public static String a;
  private static int jdField_c_of_type_Int;
  private static int jdField_d_of_type_Int = 1;
  private static int jdField_e_of_type_Int = 2;
  private float jdField_a_of_type_Float;
  private ajxl jdField_a_of_type_Ajxl = new abmd(this);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private View jdField_a_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new abls(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private atzl jdField_a_of_type_Atzl = new ablq(this);
  private bcpq jdField_a_of_type_Bcpq;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private FaceSecureCheck.SecureCheckResponse jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse;
  private ArrayList<RiskInfoItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<SvcDevLoginInfo> jdField_a_of_type_JavaUtilList;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new abme(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new ably(this);
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private oidb_0x5e1.RspBody jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_b_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  private FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = jdField_c_of_type_Int;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString = "";
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private boolean jdField_g_of_type_Boolean = true;
  private ImageView jdField_h_of_type_AndroidWidgetImageView;
  private boolean jdField_h_of_type_Boolean = true;
  private ImageView jdField_i_of_type_AndroidWidgetImageView;
  private boolean jdField_i_of_type_Boolean;
  private ImageView jdField_j_of_type_AndroidWidgetImageView;
  private boolean jdField_j_of_type_Boolean;
  private boolean k;
  
  static
  {
    jdField_a_of_type_JavaLangString = "last_safety_risk_dialog_time";
    jdField_a_of_type_Int = 86400000;
  }
  
  public static String a(String paramString)
  {
    int m = 0;
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes(Charset.forName("US-ASCII")), 0, paramString.length());
      paramString = new StringBuilder();
      localObject = ((MessageDigest)localObject).digest();
      int n = localObject.length;
      while (m < n)
      {
        paramString.append(String.format("%02x", new Object[] { Integer.valueOf(localObject[m] & 0xFF) }));
        m += 1;
      }
      paramString = paramString.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new LoginInfoActivity.5(this, paramInt));
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
    axqw.b(null, "dc00899", "Safe_SecCenter", "", "ModifyPwd", paramString, paramInt, 0, "", "", "", "");
  }
  
  private void a(List<SvcDevLoginInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    int n;
    int m;
    SvcDevLoginInfo localSvcDevLoginInfo;
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      n = paramList.size();
      m = 0;
      while (m < n)
      {
        localSvcDevLoginInfo = (SvcDevLoginInfo)paramList.get(m);
        if (localSvcDevLoginInfo != null) {
          break label76;
        }
        m += 1;
      }
    }
    label76:
    View localView = getLayoutInflater().inflate(2131559200, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    Object localObject1 = (RelativeLayout)localView.findViewById(2131368344);
    label119:
    Object localObject2;
    TextView localTextView1;
    Button localButton;
    TextView localTextView2;
    ImageView localImageView;
    if (n == 1)
    {
      ((RelativeLayout)localObject1).setBackgroundResource(2130839169);
      getResources().getString(2131694488);
      localObject2 = getResources().getString(2131694490);
      localTextView1 = (TextView)localView.findViewById(2131368845);
      localButton = (Button)localView.findViewById(2131368847);
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        localTextView1.setContentDescription(getString(2131694490));
        localButton.setContentDescription(getString(2131694488));
      }
      localTextView2 = (TextView)localView.findViewById(2131370647);
      localObject1 = (TextView)localView.findViewById(2131368086);
      localImageView = (ImageView)localView.findViewById(2131367679);
      if (m != 0) {
        break label470;
      }
      localTextView1.setText((CharSequence)localObject2);
      localTextView1.setClickable(false);
      localButton.setVisibility(8);
      localTextView1.setVisibility(0);
      localImageView.setImageResource(2130840301);
      label275:
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceName)) {
        break label558;
      }
      localTextView2.setText(2131694493);
    }
    for (;;)
    {
      localObject2 = new StringBuffer();
      if (localSvcDevLoginInfo.iLoginTime > 0L) {
        ((StringBuffer)localObject2).append(bbkb.a(localSvcDevLoginInfo.iLoginTime * 1000L, "MM-dd HH:mm"));
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
      if (m == 0)
      {
        ((RelativeLayout)localObject1).setBackgroundResource(2130839185);
        break label119;
      }
      if (m == n - 1)
      {
        ((RelativeLayout)localObject1).setBackgroundResource(2130839176);
        break label119;
      }
      ((RelativeLayout)localObject1).setBackgroundResource(2130839179);
      break label119;
      label470:
      if (localSvcDevLoginInfo.iProductType == 1L)
      {
        localTextView1.setVisibility(8);
        localButton.setVisibility(8);
        localImageView.setImageResource(2130840299);
        break label275;
      }
      localTextView1.setVisibility(8);
      localButton.setVisibility(0);
      localButton.setTag(localSvcDevLoginInfo);
      localButton.setClickable(true);
      localImageView.setImageResource(2130840300);
      localButton.setOnClickListener(new abmb(this, localButton, m));
      break label275;
      label558:
      localTextView2.setText(localSvcDevLoginInfo.strDeviceName);
    }
  }
  
  private void a(DevlockInfo paramDevlockInfo)
  {
    if ((paramDevlockInfo != null) && (!TextUtils.isEmpty(paramDevlockInfo.MbGuideInfo))) {
      aoen.a().a(paramDevlockInfo.MbGuideInfo);
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    int m;
    if (paramDevlockInfo != null) {
      if (paramDevlockInfo.DevSetup == 1) {
        m = 1;
      }
    }
    for (;;)
    {
      if (m != 0)
      {
        aoen.a().a(this.app, this, this.app.getCurrentAccountUin(), true);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131692094));
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844271);
      }
      for (;;)
      {
        e();
        return;
        m = 0;
        break;
        aoen.a().a(this.app, this, this.app.getCurrentAccountUin(), false);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131692097));
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844270);
      }
      m = 0;
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
    ((AnimationSet)localObject1).setAnimationListener(new ablu(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    if (AppSetting.jdField_d_of_type_Boolean) {
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
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846102);
      paramString = new AnimationSet(false);
      localObject1 = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      ((Animation)localObject1).setDuration(500L);
      localObject2 = new AlphaAnimation(1.0F, 0.0F);
      ((Animation)localObject2).setDuration(500L);
      paramString.addAnimation((Animation)localObject1);
      paramString.addAnimation((Animation)localObject2);
      this.jdField_f_of_type_AndroidWidgetImageView.startAnimation(paramString);
      paramString.setAnimationListener(new ablv(this));
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
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846104);
        if (!paramBoolean1) {
          break label109;
        }
      }
    }
    label109:
    for (int m = 2130846111;; m = 2130846101)
    {
      this.jdField_h_of_type_Boolean = this.jdField_g_of_type_Boolean;
      this.jdField_g_of_type_Boolean = paramBoolean1;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(m);
      getTitleBarView().setBackgroundResource(m);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundResource(m);
      return;
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846102);
      break;
      c(-15550475);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130846103);
      break;
    }
  }
  
  private boolean a()
  {
    try
    {
      SharedPreferences localSharedPreferences = getSharedPreferences(a(getCurrentAccountUin()) + "_" + jdField_a_of_type_JavaLangString, 0);
      int m = jdField_a_of_type_Int;
      long l1 = localSharedPreferences.getLong(jdField_a_of_type_JavaLangString, 0L);
      long l2 = System.currentTimeMillis();
      if (l2 - l1 < m) {
        return false;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  private String b(String paramString)
  {
    bcwt localbcwt = (bcwt)ScConfigManager.a().a("SecCenterConfig", false);
    if (localbcwt != null) {
      return localbcwt.a("ModifyPwdUrls", paramString);
    }
    return null;
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
  
  private void b(DevlockInfo paramDevlockInfo)
  {
    int m = 1;
    if (paramDevlockInfo != null) {
      if (paramDevlockInfo.DevSetup != 1) {
        break label34;
      }
    }
    for (;;)
    {
      if ((m == 0) && (a()))
      {
        k();
        b();
      }
      return;
      label34:
      m = 0;
    }
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
    ((Animation)localObject).setAnimationListener(new ablw(this));
    localObject = new AnimationSet(false);
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 1620.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(1500L);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(1500L);
    ((AnimationSet)localObject).addAnimation(localRotateAnimation);
    ((AnimationSet)localObject).addAnimation(localAlphaAnimation);
    this.jdField_d_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
    ((AnimationSet)localObject).setAnimationListener(new ablx(this, paramBoolean, paramString));
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = this.mSystemBarComp;
    this.mSystemBarComp = null;
    new SystemBarCompact(this, true, paramInt).init();
  }
  
  private void d(int paramInt)
  {
    if (this.leftView != null)
    {
      this.leftView.setTextColor(paramInt);
      Drawable localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(2130849043);
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
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      avpq localavpq = (avpq)this.app.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localavpq.a("100190.100199.100199001");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      localavpq.a(localAppInfo);
    }
  }
  
  private void e(int paramInt)
  {
    if ((this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody != null) && (this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.size() != 0))
    {
      ((oidb_0x5e1.UdcUinData)this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.set(paramInt);
      TextView localTextView = this.jdField_f_of_type_AndroidWidgetTextView;
      if (paramInt == 1) {}
      for (String str = getString(2131692277);; str = getString(2131692284))
      {
        localTextView.setText(str);
        return;
      }
    }
    QLog.e("LoginInfoActivity.AccDevSec", 1, "refreshUserFaceState mFAceStateRsp is null or rpt_msg_uin_data is empty");
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      avpq localavpq = (avpq)this.app.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localavpq.a("100190.100199.100199002");
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      localavpq.a(localAppInfo);
    }
  }
  
  private void g()
  {
    Object localObject = (avpq)this.app.getManager(36);
    ((avpq)localObject).b("100190.100199");
    ((avpq)localObject).b("100190.100199.100199001");
    localObject = ((avpq)localObject).a("100190.100199.100199001");
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
  }
  
  private void h()
  {
    Object localObject = (avpq)this.app.getManager(36);
    ((avpq)localObject).b("100190.100199");
    ((avpq)localObject).b("100190.100199.100199002");
    localObject = ((avpq)localObject).a("100190.100199.100199002");
    this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
  }
  
  private void i()
  {
    this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(0);
    axby.a(this.app, getCurrentAccountUin(), new ablz(this));
    axby.a(this.app, getCurrentAccountUin(), new abma(this));
  }
  
  private void j()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new LoginInfoActivity.6(this));
  }
  
  private void k()
  {
    try
    {
      SharedPreferences.Editor localEditor = getSharedPreferences(a(getCurrentAccountUin()) + "_" + jdField_a_of_type_JavaLangString, 0).edit();
      localEditor.putLong(jdField_a_of_type_JavaLangString, System.currentTimeMillis());
      localEditor.commit();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void l()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131166859));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
  }
  
  private void m()
  {
    this.jdField_b_of_type_Int = GesturePWDUtils.getGesturePWDState(this, this.app.getCurrentAccountUin());
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131692992));
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131692983));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131692991));
  }
  
  private void n()
  {
    ThreadManager.postImmediately(new LoginInfoActivity.CheckPIMStatus(this, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem), null, true);
  }
  
  private void o()
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
  
  private void p()
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
  
  private void q()
  {
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131373094));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_e_of_type_JavaLangString = "https://aq.qq.com";
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
  }
  
  private void r()
  {
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131361875));
    if (bbjn.a(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_entrance", false))
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      String str = bbjn.a(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_url", "");
      if (TextUtils.isEmpty(str)) {}
      for (this.jdField_d_of_type_JavaLangString = "https://ti.qq.com/qqcancel/index.html";; this.jdField_d_of_type_JavaLangString = str)
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        return;
      }
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
  }
  
  private void s()
  {
    long l1 = System.currentTimeMillis();
    Object localObject = bbjn.a(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_success_text", "");
    String str = bbjn.a(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_bold_text", "");
    Intent localIntent = new Intent();
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
    localIntent.putExtra("is_from_account_release", true);
    localIntent.putExtra("release_account_uin", this.app.getCurrentAccountUin());
    localIntent.putExtra("release_success_text", (String)localObject);
    localIntent.putExtra("release_bold_text", str);
    ThemeUiPlugin.destroy(this.app);
    ChatBackgroundManager.b();
    localObject = this.app.getApp().getSharedPreferences("unreadcount", 4).edit();
    ((SharedPreferences.Editor)localObject).putInt("unread", 0);
    ((SharedPreferences.Editor)localObject).commit();
    this.app.logout(true);
    if (BaseApplicationImpl.sImageCache != null) {
      BaseApplicationImpl.sImageCache.evictAll();
    }
    int m = bazw.a(this, this.app.getCurrentAccountUin());
    bazw.a(this, this.app.getCurrentAccountUin(), m + 1);
    startActivity(localIntent);
    if (QQPlayerService.a())
    {
      localIntent = new Intent();
      localIntent.setAction("qqplayer_exit_action");
      sendBroadcast(localIntent);
    }
    long l2 = System.currentTimeMillis();
    QLog.d("ReleaseAccount", 2, "LoginInfoActivity logout, costTime = " + (l2 - l1));
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
    int m = aoen.a().a(this.app, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (m != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "startGetDevLockStatus CheckDevLockStatus failed. ret=" + m);
      }
      l();
    }
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      if ((paramFloat2 - this.jdField_b_of_type_Float > 600.0F) && (this.jdField_c_of_type_Boolean)) {
        d();
      }
    }
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 > 0)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundResource(2130838514);
      this.jdField_i_of_type_Boolean = false;
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    p();
  }
  
  void b()
  {
    try
    {
      c();
      Dialog localDialog = new Dialog(this, 2131755791);
      localDialog.setContentView(2131558883);
      TextView localTextView1 = (TextView)localDialog.findViewById(2131365151);
      if (localTextView1 != null) {
        localTextView1.setText(getString(2131692171));
      }
      localTextView1 = (TextView)localDialog.findViewById(2131365147);
      if (localTextView1 != null) {
        localTextView1.setText(getString(2131692168));
      }
      localTextView1 = (TextView)localDialog.findViewById(2131365136);
      if (localTextView1 != null) {
        localTextView1.setText(2131692169);
      }
      TextView localTextView2 = (TextView)localDialog.findViewById(2131365142);
      if (localTextView2 != null) {
        localTextView2.setText(2131692170);
      }
      localDialog.setOnDismissListener(new ablr(this));
      if (localTextView1 != null) {
        localTextView1.setOnClickListener(this);
      }
      if (localTextView2 != null) {
        localTextView2.setOnClickListener(this);
      }
      this.jdField_a_of_type_AndroidAppDialog = localDialog;
      this.jdField_a_of_type_AndroidAppDialog.show();
      axqw.b(null, "dc00898", "", "", "0X800A5CF", "0X800A5CF", 0, 0, "", "", "", "");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(View paramView, float paramFloat1, float paramFloat2)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  void c()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog == null) || (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      label24:
      this.jdField_a_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  protected void d()
  {
    if ((this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean)) {
      return;
    }
    o();
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    QQProtectRisks.QQProtectRisksRequest localQQProtectRisksRequest = new QQProtectRisks.QQProtectRisksRequest();
    localQQProtectRisksRequest.uint32_sec_cmd.set(1);
    localQQProtectRisksRequest.str_package_name.set(bfhb.c());
    localQQProtectRisksRequest.uint32_app_id.set(AppSetting.a());
    mxi.a(this.app, new ablt(this), localQQProtectRisksRequest.toByteArray(), "AccountSafeSvc.RiskDetect");
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    boolean bool1;
    if (paramInt1 == 0) {
      if (((paramInt2 == 0) || (paramInt2 == -1)) && (paramIntent != null) && (paramIntent.getExtras() != null) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null))
      {
        Bundle localBundle = paramIntent.getExtras();
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
        {
          bool1 = true;
          bool1 = localBundle.getBoolean("auth_dev_open", bool1);
          String str = localBundle.getString("phone_num");
          if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 1) {}
          boolean bool2 = localBundle.getBoolean("allow_set");
          if (!bool1) {
            break label190;
          }
          this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup = 1;
          label114:
          if (!TextUtils.isEmpty(str)) {
            this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = str;
          }
          if (!bool2) {
            break label201;
          }
          this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet = 1;
          label144:
          a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
          d();
        }
      }
      else if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("faceStateKey");
        if (!TextUtils.isEmpty(paramIntent)) {
          e(Integer.parseInt(paramIntent));
        }
      }
    }
    label190:
    label201:
    do
    {
      return;
      bool1 = false;
      break;
      this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup = 0;
      break label114;
      this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet = 0;
      break label144;
      if (paramInt1 == 1)
      {
        m();
        return;
      }
      if (paramInt1 == 2)
      {
        n();
        return;
      }
      if (paramInt1 == 3)
      {
        d();
        return;
      }
      if (paramInt1 == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LoginInfoActivity.AccDevSec", 2, String.format("doOnActivityResult, resultCode: %s", new Object[] { Integer.valueOf(paramInt2) }));
        }
        if (paramInt2 == -1)
        {
          this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.postDelayed(new LoginInfoActivity.13(this), 50L);
          axqw.a(this.app, "dc00898", "", "", "0X800989B", "0X800989B", 0, 0, "", "", "", "");
          return;
        }
        axqw.a(this.app, "dc00898", "", "", "0X800989A", "0X800989A", 0, 0, "", "", "", "");
        return;
      }
      if ((paramInt1 == 11) || (paramInt1 == 21))
      {
        QLog.d("LoginInfoActivity.AccDevSec", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, resultCode is ", Integer.valueOf(paramInt2) });
        if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("key_face_scan_result", false)))
        {
          e(1);
          return;
        }
        if (paramIntent == null) {}
        for (bool1 = true;; bool1 = false)
        {
          QLog.e("LoginInfoActivity.AccDevSec", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, data == null ? ", Boolean.valueOf(bool1) });
          if (paramIntent == null) {
            break;
          }
          QLog.e("LoginInfoActivity.AccDevSec", 1, new Object[] { "onActivityResult requestCode == REQ_SMS_CODE, KEY_FACE_SCAN_RESULT is ", Boolean.valueOf(paramIntent.getBooleanExtra("key_face_scan_result", false)) });
          return;
        }
      }
    } while ((paramInt1 != 12) || (paramInt2 != -1));
    e(0);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559199);
    setTitle(2131699384);
    d(-1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131375321));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370533));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131375317));
    paramBundle = (RelativeLayout)findViewById(2131375310);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375319));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375312));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375314));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375311));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375324));
    this.jdField_j_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375318));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375325));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375313));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375323));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375322));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375320));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375308));
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131717252));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131369567));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_b_of_type_AndroidWidgetRelativeLayout).c(27).a();
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370534));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365084));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365851));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378159));
    this.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131365871));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131366999));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131363324));
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131693417));
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378658);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_a_of_type_AndroidViewView).c(27).a();
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131371660));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131373185));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131719157));
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131375772));
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131719178));
    }
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    boolean bool = SettingCloneUtil.readValue(this, this.app.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    bool = SettingCloneUtil.readValue(this, null, "security_scan_key", "qqsetting_security_scan_key", false);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    if (!aoen.a().b()) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramBundle = new SpannableString(getResources().getString(2131694491));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365082));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131372031));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365083));
    int m = paramBundle.length();
    paramBundle.setSpan(new abmf(this, null), 0, m, 33);
    paramBundle.setSpan(new ForegroundColorSpan(getResources().getColor(2131166866)), 0, m, 33);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramBundle);
    try
    {
      this.jdField_f_of_type_JavaLangString = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
      addObserver(this.jdField_a_of_type_Ajxl);
      if (QLog.isColorLevel()) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "packName = " + this.jdField_f_of_type_JavaLangString);
      }
      a(null);
      if (QLog.isColorLevel()) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "onCreate begin to getLoginDevList");
      }
      if (bbev.d(this))
      {
        bool = aoen.a().a(this.app, this.jdField_f_of_type_JavaLangString, 0L);
        if (bool)
        {
          a();
          i();
          m();
          n();
          d();
          r();
          q();
          this.app.registObserver(this.jdField_a_of_type_Atzl);
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
          bcpw.a(this, getString(2131692321), 0).b(getTitleBarHeight());
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
      this.mSystemBarComp = this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
    }
    super.doOnDestroy();
    j();
    removeObserver(this.jdField_a_of_type_Ajxl);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.app.removeHandler(getClass());
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    d(-1);
    a();
    m();
    n();
    e();
    f();
    this.jdField_j_of_type_Boolean = false;
    this.k = false;
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setClickable(true);
  }
  
  public void finish()
  {
    super.finish();
    if (getIntent().getBooleanExtra("from_risk_hint", false))
    {
      getIntent().removeExtra("from_risk_hint");
      Intent localIntent = new Intent(this, QQSettingSettingActivity.class);
      localIntent.putExtra("from_risk_hint", true);
      startActivity(localIntent);
    }
  }
  
  public boolean onBackEvent()
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
    Object localObject1;
    label785:
    Object localObject2;
    int m;
    switch (paramView.getId())
    {
    default: 
    case 2131369567: 
      do
      {
        return;
        g();
        axqw.b(this.app, "CliOper", "", "", "My_eq", "My_eq_protect", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
        {
          if (!bbev.d(this))
          {
            bcpw.a(this, getString(2131692321), 0).b(getTitleBarHeight());
            return;
          }
          a();
          return;
        }
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
        {
          this.app.sendWirelessMeibaoReq(1);
          localObject1 = new Intent(this, AuthDevActivity.class);
          ((Intent)localObject1).putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          ((Intent)localObject1).putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
          ((Intent)localObject1).putExtra("auth_dev_open", true);
          if (this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse == null)
          {
            ((Intent)localObject1).putExtra("secureState", "secureStateUNKNOWN");
            startActivityForResult((Intent)localObject1, 0);
            return;
          }
          if (this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.bool_sec_pass.get()) {}
          for (paramView = "secureStateOk";; paramView = "secureStateError")
          {
            ((Intent)localObject1).putExtra("secureState", paramView);
            if (!this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.bool_sec_pass.get()) {
              break;
            }
            ((Intent)localObject1).putExtra("faceAppId", this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.str_openid.get());
            ((Intent)localObject1).putExtra("faceTmpKey", this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.str_tmpkey.get());
            break;
          }
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
    case 2131365142: 
      try
      {
        c();
        axqw.b(null, "dc00898", "", "", "0X800A5D0", "0X800A5D0", 0, 0, "", "", "", "");
        paramView = new Intent(this, AuthDevOpenUgActivity.class);
        paramView.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
        startActivityForResult(paramView, 0);
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
    case 2131365851: 
      if (this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody == null)
      {
        if (!bbev.d(this)) {
          bcpw.a(this, getString(2131692321), 0).b(getTitleBarHeight());
        }
        QLog.e("LoginInfoActivity.AccDevSec", 1, "face_login_layout click error : mFaceStateRsp is null");
        return;
      }
      if (this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.isEmpty())
      {
        QLog.e("LoginInfoActivity.AccDevSec", 1, "faceVerifyLayout click error : mFaceStateRsp.rpt_msg_uin_data is null or empty");
        return;
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setClickable(false);
      localObject1 = this.app;
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
      {
        paramView = "";
        arch.a((QQAppInterface)localObject1, this, paramView, this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody, this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse, new LoginInfoActivity.11(this));
        if (((oidb_0x5e1.UdcUinData)this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.get() != 1) {
          break label785;
        }
      }
      for (paramView = "1";; paramView = "0")
      {
        axqw.b(null, "dc00898", "", "", "0X800AA7B", "0X800AA7B", 0, 0, paramView, "", "", "");
        return;
        paramView = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
        break;
      }
    case 2131365136: 
      axqw.b(null, "dc00898", "", "", "0X800A5D1", "0X800A5D1", 0, 0, "", "", "", "");
      c();
      return;
    case 2131371660: 
      startActivity(new Intent(this, SecurityPickproofActivity.class));
      axqw.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof", "enter pickproof page", 0, 0, "", "", "", "");
      return;
    case 2131370534: 
      if (!bbev.d(this))
      {
        bcpw.a(this, getString(2131692321), 0).b(getTitleBarHeight());
        return;
      }
      axqw.b(this.app, "CliOper", "", "", "My_eq", "Clk_eq_recently", 0, 0, "", "", "", "");
      startActivity(new Intent(this, RecentLoginDevActivity.class));
      return;
    case 2131366999: 
      startActivityForResult(new Intent(this, GesturePWDSettingActivity.class), 1);
      return;
    case 2131378658: 
      h();
      if (aumi.a().a(this.app, this.app.getCurrentAccountUin()))
      {
        localObject2 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("uin", this.app.getCurrentAccountUin());
        localObject1 = b("HasSetPwdUrl");
        m = 1;
        if (localObject1 != null)
        {
          paramView = (View)localObject1;
          if (!((String)localObject1).equals("")) {}
        }
        else
        {
          paramView = "https://aq.qq.com/cn2/change_psw/mobile/mobile_change_psw_way?source_id=2733";
          m = 0;
        }
        if (paramView.indexOf("?") == -1) {}
        for (paramView = paramView + "?uin=" + this.app.getCurrentAccountUin();; paramView = paramView + "&uin=" + this.app.getCurrentAccountUin())
        {
          startActivity(((Intent)localObject2).putExtra("url", paramView));
          this.app.sendWirelessPswReq(1);
          if (m == 0) {
            a("FetchUrl", 1);
          }
          a("ClkModifyPwd", 1);
          return;
        }
      }
      localObject1 = this.app.getCurrentAccountUin();
      paramView = b("RegNewUrl");
      if ((paramView == null) || (paramView.equals("")))
      {
        m = 0;
        paramView = "https://aq.qq.com/cn2/change_psw/mobile/mobile_change_psw_reg_input_psw";
      }
      break;
    }
    for (;;)
    {
      localObject2 = new StringBuilder(paramView);
      if (paramView.indexOf("?") == -1) {
        ((StringBuilder)localObject2).append("?");
      }
      for (;;)
      {
        ((StringBuilder)localObject2).append("uin=");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&plat=1");
        ((StringBuilder)localObject2).append("&app=1");
        ((StringBuilder)localObject2).append("&version=8.2.8.4440");
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
        if (m == 0) {
          a("FetchUrl", 2);
        }
        a("ClkModifyPwd", 2);
        return;
        ((StringBuilder)localObject2).append("&");
      }
      startActivityForResult(new Intent(this, SecurityProtectActivity.class), 2);
      axqw.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on qqpimsecure_detect", 0, 0, "", "", "", "");
      return;
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
        break;
      }
      paramView = new Intent(this, RiskInfoActivity.class);
      paramView.putParcelableArrayListExtra("data", this.jdField_a_of_type_JavaUtilArrayList);
      paramView.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
      startActivityForResult(paramView, 3);
      axqw.b(this.app, "dc00899", "Safe_RiskInfo", "", "RiskDetails", "click on risk details", 0, 0, "", "", "", "");
      axqw.b(null, "dc00898", "", "", "0X800A718", "0X800A718", 0, 0, "", "", "", "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DevRpt", 2, "帐号安全页顶部风险提示区域点击“发现XXX等N项风险”文字进入安全风险页！0X800A718");
      return;
      if (this.k) {
        break;
      }
      this.k = true;
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_e_of_type_JavaLangString);
      startActivity(paramView);
      axqw.b(this.app, "dc00899", "QQSafetyCenter", this.app.getCurrentAccountUin(), "clickQQSafetyCenter", "qq_safety_center_item", 0, 1, "", "", "", "");
      axqw.b(null, "dc00898", "", "", "0X800A719", "0X800A719", 0, 0, "", "", "", "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DevRpt", 2, "帐号安全页点击“QQ安全中心”用户数、次数！0X800A719");
      return;
      if (this.jdField_j_of_type_Boolean) {
        break;
      }
      this.jdField_j_of_type_Boolean = true;
      paramView = new Intent(this, QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_d_of_type_JavaLangString);
      paramView.putExtra("is_release_account", true);
      startActivityForResult(paramView, 4);
      axqw.b(this.app, "dc00898", "", "", "0X8009899", "0X8009899", 0, 0, "", "", "", "");
      return;
      m = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity
 * JD-Core Version:    0.7.0.1
 */