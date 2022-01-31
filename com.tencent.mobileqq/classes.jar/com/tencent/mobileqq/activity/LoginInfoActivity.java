package com.tencent.mobileqq.activity;

import QQService.SvcDevLoginInfo;
import abbu;
import abbv;
import abbw;
import abbx;
import abby;
import abbz;
import abca;
import abcb;
import abcc;
import abce;
import abcf;
import abcg;
import abch;
import ajjh;
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
import anoc;
import atdh;
import atok;
import auqh;
import awqx;
import azys;
import badq;
import baig;
import baiu;
import bbms;
import bbmy;
import bbnr;
import bbst;
import bdzl;
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
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mmj;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class LoginInfoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, bbnr
{
  public static volatile int a;
  public static String a;
  private static int jdField_c_of_type_Int;
  private static int jdField_d_of_type_Int = 1;
  private static int jdField_e_of_type_Int = 2;
  private float jdField_a_of_type_Float;
  private ajjh jdField_a_of_type_Ajjh = new abce(this);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private View jdField_a_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new abbv(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private atdh jdField_a_of_type_Atdh = new abbu(this);
  private bbms jdField_a_of_type_Bbms;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private ArrayList<RiskInfoItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<SvcDevLoginInfo> jdField_a_of_type_JavaUtilList;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new abcf(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new abcb(this);
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
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
    this.jdField_a_of_type_MqqOsMqqHandler.post(new LoginInfoActivity.3(this, paramInt));
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
    awqx.b(null, "dc00899", "Safe_SecCenter", "", "ModifyPwd", paramString, paramInt, 0, "", "", "", "");
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
    View localView = getLayoutInflater().inflate(2131493631, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    Object localObject1 = (RelativeLayout)localView.findViewById(2131302722);
    label119:
    Object localObject2;
    TextView localTextView1;
    Button localButton;
    TextView localTextView2;
    ImageView localImageView;
    if (n == 1)
    {
      ((RelativeLayout)localObject1).setBackgroundResource(2130839144);
      getResources().getString(2131628827);
      localObject2 = getResources().getString(2131628829);
      localTextView1 = (TextView)localView.findViewById(2131303177);
      localButton = (Button)localView.findViewById(2131303179);
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        localTextView1.setContentDescription(getString(2131628829));
        localButton.setContentDescription(getString(2131628827));
      }
      localTextView2 = (TextView)localView.findViewById(2131304981);
      localObject1 = (TextView)localView.findViewById(2131302466);
      localImageView = (ImageView)localView.findViewById(2131302061);
      if (m != 0) {
        break label470;
      }
      localTextView1.setText((CharSequence)localObject2);
      localTextView1.setClickable(false);
      localButton.setVisibility(8);
      localTextView1.setVisibility(0);
      localImageView.setImageResource(2130840253);
      label275:
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceName)) {
        break label558;
      }
      localTextView2.setText(2131628832);
    }
    for (;;)
    {
      localObject2 = new StringBuffer();
      if (localSvcDevLoginInfo.iLoginTime > 0L) {
        ((StringBuffer)localObject2).append(baiu.a(localSvcDevLoginInfo.iLoginTime * 1000L, "MM-dd HH:mm"));
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
        ((RelativeLayout)localObject1).setBackgroundResource(2130839160);
        break label119;
      }
      if (m == n - 1)
      {
        ((RelativeLayout)localObject1).setBackgroundResource(2130839151);
        break label119;
      }
      ((RelativeLayout)localObject1).setBackgroundResource(2130839154);
      break label119;
      label470:
      if (localSvcDevLoginInfo.iProductType == 1L)
      {
        localTextView1.setVisibility(8);
        localButton.setVisibility(8);
        localImageView.setImageResource(2130840251);
        break label275;
      }
      localTextView1.setVisibility(8);
      localButton.setVisibility(0);
      localButton.setTag(localSvcDevLoginInfo);
      localButton.setClickable(true);
      localImageView.setImageResource(2130840252);
      localButton.setOnClickListener(new abcc(this, localButton, m));
      break label275;
      label558:
      localTextView2.setText(localSvcDevLoginInfo.strDeviceName);
    }
  }
  
  private void a(DevlockInfo paramDevlockInfo)
  {
    if ((paramDevlockInfo != null) && (!TextUtils.isEmpty(paramDevlockInfo.MbGuideInfo))) {
      anoc.a().a(paramDevlockInfo.MbGuideInfo);
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
        anoc.a().a(this.app, this, this.app.getCurrentAccountUin(), true);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131626508));
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844194);
      }
      for (;;)
      {
        e();
        return;
        m = 0;
        break;
        anoc.a().a(this.app, this, this.app.getCurrentAccountUin(), false);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(getString(2131626511));
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844193);
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
    ((AnimationSet)localObject1).setAnimationListener(new abbx(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    if (AppSetting.jdField_c_of_type_Boolean) {
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
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845921);
      paramString = new AnimationSet(false);
      localObject1 = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      ((Animation)localObject1).setDuration(500L);
      localObject2 = new AlphaAnimation(1.0F, 0.0F);
      ((Animation)localObject2).setDuration(500L);
      paramString.addAnimation((Animation)localObject1);
      paramString.addAnimation((Animation)localObject2);
      this.jdField_f_of_type_AndroidWidgetImageView.startAnimation(paramString);
      paramString.setAnimationListener(new abby(this));
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
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845923);
        if (!paramBoolean1) {
          break label109;
        }
      }
    }
    label109:
    for (int m = 2130845930;; m = 2130845920)
    {
      this.jdField_h_of_type_Boolean = this.jdField_g_of_type_Boolean;
      this.jdField_g_of_type_Boolean = paramBoolean1;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(m);
      getTitleBarView().setBackgroundResource(m);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundResource(m);
      return;
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845921);
      break;
      c(-15550475);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845922);
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
    bbst localbbst = (bbst)ScConfigManager.a().a("SecCenterConfig", false);
    if (localbbst != null) {
      return localbbst.a("ModifyPwdUrls", paramString);
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
        j();
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
    ((Animation)localObject).setAnimationListener(new abbz(this));
    localObject = new AnimationSet(false);
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 1620.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(1500L);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(1500L);
    ((AnimationSet)localObject).addAnimation(localRotateAnimation);
    ((AnimationSet)localObject).addAnimation(localAlphaAnimation);
    this.jdField_d_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
    ((AnimationSet)localObject).setAnimationListener(new abca(this, paramBoolean, paramString));
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
      Drawable localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(2130848818);
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
      auqh localauqh = (auqh)this.app.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localauqh.a("100190.100199.100199001");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      localauqh.a(localAppInfo);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      auqh localauqh = (auqh)this.app.getManager(36);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localauqh.a("100190.100199.100199002");
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      localauqh.a(localAppInfo);
    }
  }
  
  private void g()
  {
    Object localObject = (auqh)this.app.getManager(36);
    ((auqh)localObject).b("100190.100199");
    ((auqh)localObject).b("100190.100199.100199001");
    localObject = ((auqh)localObject).a("100190.100199.100199001");
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
  }
  
  private void h()
  {
    Object localObject = (auqh)this.app.getManager(36);
    ((auqh)localObject).b("100190.100199");
    ((auqh)localObject).b("100190.100199.100199002");
    localObject = ((auqh)localObject).a("100190.100199.100199002");
    this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
  }
  
  private void i()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new LoginInfoActivity.4(this));
  }
  
  private void j()
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
  
  private void k()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131101265));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
  }
  
  private void l()
  {
    this.jdField_b_of_type_Int = GesturePWDUtils.getGesturePWDState(this, this.app.getCurrentAccountUin());
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131627352));
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131627343));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131627351));
  }
  
  private void m()
  {
    ThreadManager.postImmediately(new LoginInfoActivity.CheckPIMStatus(this, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem), null, true);
  }
  
  private void n()
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
  
  private void o()
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
  
  private void p()
  {
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131307383));
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_e_of_type_JavaLangString = "https://aq.qq.com";
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
  }
  
  private void q()
  {
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131296339));
    if (baig.a(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_entrance", false))
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      String str = baig.a(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_url", "");
      if (TextUtils.isEmpty(str)) {}
      for (this.jdField_d_of_type_JavaLangString = "https://ti.qq.com/qqcancel/index.html";; this.jdField_d_of_type_JavaLangString = str)
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        return;
      }
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
  }
  
  private void r()
  {
    long l1 = System.currentTimeMillis();
    Object localObject = baig.a(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_success_text", "");
    String str = baig.a(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_bold_text", "");
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
    int m = azys.a(this, this.app.getCurrentAccountUin());
    azys.a(this, this.app.getCurrentAccountUin(), m + 1);
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
    int m = anoc.a().a(this.app, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (m != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "startGetDevLockStatus CheckDevLockStatus failed. ret=" + m);
      }
      k();
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundResource(2130838503);
      this.jdField_i_of_type_Boolean = false;
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    o();
  }
  
  void b()
  {
    try
    {
      c();
      Dialog localDialog = new Dialog(this, 2131690181);
      localDialog.setContentView(2131493323);
      TextView localTextView1 = (TextView)localDialog.findViewById(2131299583);
      if (localTextView1 != null) {
        localTextView1.setText(getString(2131626585));
      }
      localTextView1 = (TextView)localDialog.findViewById(2131299579);
      if (localTextView1 != null) {
        localTextView1.setText(getString(2131626582));
      }
      localTextView1 = (TextView)localDialog.findViewById(2131299568);
      if (localTextView1 != null) {
        localTextView1.setText(2131626583);
      }
      TextView localTextView2 = (TextView)localDialog.findViewById(2131299574);
      if (localTextView2 != null) {
        localTextView2.setText(2131626584);
      }
      localDialog.setOnDismissListener(new abcg(this));
      if (localTextView1 != null) {
        localTextView1.setOnClickListener(this);
      }
      if (localTextView2 != null) {
        localTextView2.setOnClickListener(this);
      }
      this.jdField_a_of_type_AndroidAppDialog = localDialog;
      this.jdField_a_of_type_AndroidAppDialog.show();
      awqx.b(null, "dc00898", "", "", "0X800A5CF", "0X800A5CF", 0, 0, "", "", "", "");
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
    n();
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    QQProtectRisks.QQProtectRisksRequest localQQProtectRisksRequest = new QQProtectRisks.QQProtectRisksRequest();
    localQQProtectRisksRequest.uint32_sec_cmd.set(1);
    localQQProtectRisksRequest.str_package_name.set(bdzl.c());
    localQQProtectRisksRequest.uint32_app_id.set(AppSetting.a());
    mmj.a(this.app, new abbw(this), localQQProtectRisksRequest.toByteArray(), "AccountSafeSvc.RiskDetect");
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
        d();
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
        l();
        return;
      }
      if (paramInt1 == 2)
      {
        m();
        return;
      }
      if (paramInt1 == 3)
      {
        d();
        return;
      }
    } while (paramInt1 != 4);
    if (QLog.isColorLevel()) {
      QLog.d("LoginInfoActivity.AccDevSec", 2, String.format("doOnActivityResult, resultCode: %s", new Object[] { Integer.valueOf(paramInt2) }));
    }
    if (paramInt2 == -1)
    {
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.postDelayed(new LoginInfoActivity.10(this), 50L);
      awqx.a(this.app, "dc00898", "", "", "0X800989B", "0X800989B", 0, 0, "", "", "", "");
      return;
    }
    awqx.a(this.app, "dc00898", "", "", "0X800989A", "0X800989A", 0, 0, "", "", "", "");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131493630);
    setTitle(2131633616);
    d(-1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131309573));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131304867));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131309569));
    paramBundle = (RelativeLayout)findViewById(2131309562);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131309571));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131309564));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131309566));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131309563));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131309576));
    this.jdField_j_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131309570));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131309577));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131309565));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131309575));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131309574));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131309572));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131309560));
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131651460));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131303892));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_b_of_type_AndroidWidgetRelativeLayout).c(27).a();
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131304868));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299516));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131301389));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131297777));
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131627776));
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131312834);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_a_of_type_AndroidViewView).c(27).a();
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131305964));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131307474));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131653328));
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131310008));
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131653349));
    }
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    boolean bool = SettingCloneUtil.readValue(this, this.app.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    bool = SettingCloneUtil.readValue(this, null, "security_scan_key", "qqsetting_security_scan_key", false);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    if (!anoc.a().b()) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramBundle = new SpannableString(getResources().getString(2131628830));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299514));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131306334));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299515));
    int m = paramBundle.length();
    paramBundle.setSpan(new abch(this, null), 0, m, 33);
    paramBundle.setSpan(new ForegroundColorSpan(getResources().getColor(2131101272)), 0, m, 33);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramBundle);
    try
    {
      this.jdField_f_of_type_JavaLangString = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
      addObserver(this.jdField_a_of_type_Ajjh);
      if (QLog.isColorLevel()) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "packName = " + this.jdField_f_of_type_JavaLangString);
      }
      a(null);
      if (QLog.isColorLevel()) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "onCreate begin to getLoginDevList");
      }
      if (badq.d(this))
      {
        bool = anoc.a().a(this.app, this.jdField_f_of_type_JavaLangString, 0L);
        if (bool)
        {
          a();
          l();
          m();
          d();
          q();
          p();
          this.app.registObserver(this.jdField_a_of_type_Atdh);
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
          bbmy.a(this, getString(2131626719), 0).b(getTitleBarHeight());
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
    i();
    removeObserver(this.jdField_a_of_type_Ajjh);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.app.removeHandler(getClass());
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    d(-1);
    a();
    l();
    m();
    e();
    f();
    this.jdField_j_of_type_Boolean = false;
    this.k = false;
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
    Object localObject;
    String str;
    int m;
    switch (paramView.getId())
    {
    default: 
    case 2131303892: 
      do
      {
        return;
        g();
        awqx.b(this.app, "CliOper", "", "", "My_eq", "My_eq_protect", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
        {
          if (!badq.d(this))
          {
            bbmy.a(this, getString(2131626719), 0).b(getTitleBarHeight());
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
    case 2131299574: 
      try
      {
        c();
        awqx.b(null, "dc00898", "", "", "0X800A5D0", "0X800A5D0", 0, 0, "", "", "", "");
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
    case 2131299568: 
      awqx.b(null, "dc00898", "", "", "0X800A5D1", "0X800A5D1", 0, 0, "", "", "", "");
      c();
      return;
    case 2131305964: 
      startActivity(new Intent(this, SecurityPickproofActivity.class));
      awqx.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof", "enter pickproof page", 0, 0, "", "", "", "");
      return;
    case 2131304868: 
      if (!badq.d(this))
      {
        bbmy.a(this, getString(2131626719), 0).b(getTitleBarHeight());
        return;
      }
      awqx.b(this.app, "CliOper", "", "", "My_eq", "Clk_eq_recently", 0, 0, "", "", "", "");
      startActivity(new Intent(this, RecentLoginDevActivity.class));
      return;
    case 2131301389: 
      startActivityForResult(new Intent(this, GesturePWDSettingActivity.class), 1);
      return;
    case 2131312834: 
      h();
      if (atok.a().a(this.app, this.app.getCurrentAccountUin()))
      {
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("uin", this.app.getCurrentAccountUin());
        str = b("HasSetPwdUrl");
        m = 1;
        if (str != null)
        {
          paramView = str;
          if (!str.equals("")) {}
        }
        else
        {
          paramView = "http://aq.qq.com/cn2/change_psw/mobile/mobile_change_psw_way?source_id=2733";
          m = 0;
        }
        if (paramView.indexOf("?") == -1) {}
        for (paramView = paramView + "?uin=" + this.app.getCurrentAccountUin();; paramView = paramView + "&uin=" + this.app.getCurrentAccountUin())
        {
          startActivity(((Intent)localObject).putExtra("url", paramView));
          this.app.sendWirelessPswReq(1);
          if (m == 0) {
            a("FetchUrl", 1);
          }
          a("ClkModifyPwd", 1);
          return;
        }
      }
      str = this.app.getCurrentAccountUin();
      paramView = b("RegNewUrl");
      if ((paramView == null) || (paramView.equals("")))
      {
        m = 0;
        paramView = "http://aq.qq.com/cn2/change_psw/mobile/mobile_change_psw_reg_input_psw";
      }
      break;
    }
    for (;;)
    {
      localObject = new StringBuilder(paramView);
      if (paramView.indexOf("?") == -1) {
        ((StringBuilder)localObject).append("?");
      }
      for (;;)
      {
        ((StringBuilder)localObject).append("uin=");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("&plat=1");
        ((StringBuilder)localObject).append("&app=1");
        ((StringBuilder)localObject).append("&version=8.2.6.4370");
        ((StringBuilder)localObject).append("&device=" + URLEncoder.encode(Build.DEVICE));
        ((StringBuilder)localObject).append("&system=" + Build.VERSION.RELEASE);
        ((StringBuilder)localObject).append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
        paramView = ((StringBuilder)localObject).toString();
        localObject = new Intent();
        ((Intent)localObject).putExtra("portraitOnly", true);
        ((Intent)localObject).putExtra("url", paramView);
        ((Intent)localObject).putExtra("uin", str);
        ((Intent)localObject).putExtra("hide_operation_bar", true);
        ((Intent)localObject).putExtra("hide_more_button", true);
        VasWebviewUtil.openQQBrowserActivity(this, paramView, 32768L, (Intent)localObject, false, -1);
        if (m == 0) {
          a("FetchUrl", 2);
        }
        a("ClkModifyPwd", 2);
        return;
        ((StringBuilder)localObject).append("&");
      }
      startActivityForResult(new Intent(this, SecurityProtectActivity.class), 2);
      awqx.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on qqpimsecure_detect", 0, 0, "", "", "", "");
      return;
      if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
        break;
      }
      paramView = new Intent(this, RiskInfoActivity.class);
      paramView.putParcelableArrayListExtra("data", this.jdField_a_of_type_JavaUtilArrayList);
      paramView.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
      startActivityForResult(paramView, 3);
      awqx.b(this.app, "dc00899", "Safe_RiskInfo", "", "RiskDetails", "click on risk details", 0, 0, "", "", "", "");
      awqx.b(null, "dc00898", "", "", "0X800A718", "0X800A718", 0, 0, "", "", "", "");
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
      awqx.b(this.app, "dc00899", "QQSafetyCenter", this.app.getCurrentAccountUin(), "clickQQSafetyCenter", "qq_safety_center_item", 0, 1, "", "", "", "");
      awqx.b(null, "dc00898", "", "", "0X800A719", "0X800A719", 0, 0, "", "", "", "");
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
      awqx.b(this.app, "dc00898", "", "", "0X8009899", "0X8009899", 0, 0, "", "", "", "");
      return;
      m = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity
 * JD-Core Version:    0.7.0.1
 */