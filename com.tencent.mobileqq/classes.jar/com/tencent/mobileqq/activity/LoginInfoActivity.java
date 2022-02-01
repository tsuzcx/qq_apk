package com.tencent.mobileqq.activity;

import Override;
import QQService.SvcDevLoginInfo;
import aehc;
import aehd;
import aehf;
import aehg;
import aehh;
import aehi;
import aehj;
import aehk;
import aehl;
import aehm;
import aehn;
import aeho;
import aehp;
import aehq;
import aehr;
import aehs;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anvi;
import aslf;
import aslh;
import asll;
import avpm;
import avpp;
import avpu;
import avql;
import avqm;
import ayqy;
import azit;
import bbbq;
import bcvh;
import bdla;
import bhai;
import bhhr;
import bhid;
import bisl;
import bitm;
import biza;
import bksu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.QQProtectRisks.QQProtectRisksRequest;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mqp.app.sec.ScConfigManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
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
import ntb;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x5e1.UdcUinData;

public class LoginInfoActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, bitm
{
  public static volatile int a;
  public static String a;
  private static int jdField_c_of_type_Int;
  private static int jdField_d_of_type_Int = 1;
  private static int jdField_e_of_type_Int = 2;
  private float jdField_a_of_type_Float;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private View jdField_a_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aehi(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anvi jdField_a_of_type_Anvi = new aehf(this);
  private ayqy jdField_a_of_type_Ayqy = new aehc(this);
  private bisl jdField_a_of_type_Bisl;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private FaceSecureCheck.SecureCheckResponse jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse;
  private ArrayList<RiskInfoItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<SvcDevLoginInfo> jdField_a_of_type_JavaUtilList;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new aehg(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new aehk(this);
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
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = jdField_c_of_type_Int;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private FormSimpleItem jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private boolean jdField_g_of_type_Boolean = true;
  private ImageView jdField_h_of_type_AndroidWidgetImageView;
  private boolean jdField_h_of_type_Boolean = true;
  private ImageView jdField_i_of_type_AndroidWidgetImageView;
  private boolean jdField_i_of_type_Boolean;
  private ImageView jdField_j_of_type_AndroidWidgetImageView;
  private boolean jdField_j_of_type_Boolean;
  private boolean k;
  private boolean l = true;
  private boolean m;
  
  static
  {
    jdField_a_of_type_JavaLangString = "last_safety_risk_dialog_time";
    jdField_a_of_type_Int = 86400000;
  }
  
  public static String a(String paramString)
  {
    int n = 0;
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes(Charset.forName("US-ASCII")), 0, paramString.length());
      paramString = new StringBuilder();
      localObject = ((MessageDigest)localObject).digest();
      int i1 = localObject.length;
      while (n < i1)
      {
        paramString.append(String.format("%02x", new Object[] { Integer.valueOf(localObject[n] & 0xFF) }));
        n += 1;
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
    this.jdField_a_of_type_MqqOsMqqHandler.post(new LoginInfoActivity.9(this, paramInt));
  }
  
  private void a(long paramLong, String paramString)
  {
    SharedPreferences localSharedPreferences = getSharedPreferences("sp_qs_settings", 0);
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("qsec_status_expired_time" + this.app.getCurrentAccountUin(), paramLong).putString("qsec_status_tip_text" + this.app.getCurrentAccountUin(), paramString).putLong("qsec_status_update_last_time" + this.app.getCurrentAccountUin(), new Date().getTime()).commit();
    }
  }
  
  private void a(View paramView)
  {
    paramView.setVisibility(8);
    bhhr.d(this, getCurrentAccountUin(), true);
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
    bdla.b(null, "dc00899", "Safe_SecCenter", "", "ModifyPwd", paramString, paramInt, 0, "", "", "", "");
  }
  
  private void a(List<SvcDevLoginInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    int i1;
    int n;
    SvcDevLoginInfo localSvcDevLoginInfo;
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      i1 = paramList.size();
      n = 0;
      while (n < i1)
      {
        localSvcDevLoginInfo = (SvcDevLoginInfo)paramList.get(n);
        if (localSvcDevLoginInfo != null) {
          break label76;
        }
        n += 1;
      }
    }
    label76:
    View localView = getLayoutInflater().inflate(2131559379, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    Object localObject1 = (RelativeLayout)localView.findViewById(2131369110);
    label119:
    Object localObject2;
    TextView localTextView1;
    Button localButton;
    TextView localTextView2;
    ImageView localImageView;
    if (i1 == 1)
    {
      ((RelativeLayout)localObject1).setBackgroundResource(2130839496);
      getResources().getString(2131694205);
      localObject2 = getResources().getString(2131694207);
      localTextView1 = (TextView)localView.findViewById(2131369723);
      localButton = (Button)localView.findViewById(2131369725);
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        localTextView1.setContentDescription(getString(2131694207));
        localButton.setContentDescription(getString(2131694205));
      }
      localTextView2 = (TextView)localView.findViewById(2131371803);
      localObject1 = (TextView)localView.findViewById(2131368819);
      localImageView = (ImageView)localView.findViewById(2131368381);
      if (n != 0) {
        break label470;
      }
      localTextView1.setText((CharSequence)localObject2);
      localTextView1.setClickable(false);
      localButton.setVisibility(8);
      localTextView1.setVisibility(0);
      localImageView.setImageResource(2130840672);
      label275:
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceName)) {
        break label558;
      }
      localTextView2.setText(2131694210);
    }
    for (;;)
    {
      localObject2 = new StringBuffer();
      if (localSvcDevLoginInfo.iLoginTime > 0L) {
        ((StringBuffer)localObject2).append(bhid.a(localSvcDevLoginInfo.iLoginTime * 1000L, "MM-dd HH:mm"));
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
      if (n == 0)
      {
        ((RelativeLayout)localObject1).setBackgroundResource(2130839512);
        break label119;
      }
      if (n == i1 - 1)
      {
        ((RelativeLayout)localObject1).setBackgroundResource(2130839503);
        break label119;
      }
      ((RelativeLayout)localObject1).setBackgroundResource(2130839506);
      break label119;
      label470:
      if (localSvcDevLoginInfo.iProductType == 1L)
      {
        localTextView1.setVisibility(8);
        localButton.setVisibility(8);
        localImageView.setImageResource(2130840670);
        break label275;
      }
      localTextView1.setVisibility(8);
      localButton.setVisibility(0);
      localButton.setTag(localSvcDevLoginInfo);
      localButton.setClickable(true);
      localImageView.setImageResource(2130840671);
      localButton.setOnClickListener(new aehd(this, localButton, n));
      break label275;
      label558:
      localTextView2.setText(localSvcDevLoginInfo.strDeviceName);
    }
  }
  
  private void a(DevlockInfo paramDevlockInfo)
  {
    int i1 = 1;
    if ((paramDevlockInfo != null) && (!TextUtils.isEmpty(paramDevlockInfo.MbGuideInfo))) {
      asll.a().a(paramDevlockInfo.MbGuideInfo);
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setClickable(true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    int n;
    if (paramDevlockInfo != null) {
      if (paramDevlockInfo.DevSetup == 1) {
        n = 1;
      }
    }
    for (;;)
    {
      TextView localTextView;
      Object localObject;
      if (n != 0)
      {
        asll.a().a(this.app, this, this.app.getCurrentAccountUin(), true);
        localTextView = this.jdField_e_of_type_AndroidWidgetTextView;
        if (this.l)
        {
          localObject = getString(2131691922);
          label127:
          localTextView.setText((CharSequence)localObject);
          localObject = this.jdField_b_of_type_AndroidWidgetImageView;
          if (!this.l) {
            break label256;
          }
          n = 2130845054;
          label151:
          ((ImageView)localObject).setImageResource(n);
          if (paramDevlockInfo == null) {
            break label424;
          }
          if (TextUtils.isEmpty(paramDevlockInfo.Mobile)) {
            break label357;
          }
          n = i1;
        }
      }
      for (;;)
      {
        label173:
        if (n != 0) {
          if (aslf.a().a() == aslf.jdField_c_of_type_Int)
          {
            this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131691979));
            label203:
            bdla.b(this.app, "dc00898", "", "", "0X800AC9D", "0X800AC9D", 0, 0, "1", "", "", "");
          }
        }
        for (;;)
        {
          e();
          return;
          n = 0;
          break;
          localObject = getString(2131691933);
          break label127;
          label256:
          n = 2130845053;
          break label151;
          asll.a().a(this.app, this, this.app.getCurrentAccountUin(), false);
          localTextView = this.jdField_e_of_type_AndroidWidgetTextView;
          if (this.l)
          {
            localObject = getString(2131691931);
            label305:
            localTextView.setText((CharSequence)localObject);
            localObject = this.jdField_b_of_type_AndroidWidgetImageView;
            if (!this.l) {
              break label350;
            }
          }
          label350:
          for (n = 2130845051;; n = 2130845052)
          {
            ((ImageView)localObject).setImageResource(n);
            break;
            localObject = getString(2131691936);
            break label305;
          }
          label357:
          n = 0;
          break label173;
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(paramDevlockInfo.Mobile);
          break label203;
          this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getString(2131691978));
          bdla.b(this.app, "dc00898", "", "", "0X800AC9D", "0X800AC9D", 0, 0, "2", "", "", "");
        }
        label424:
        n = 0;
      }
      n = 0;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    float f2 = 6.0F;
    FrameLayout localFrameLayout = (FrameLayout)findViewById(16908290);
    Object localObject2 = new int[2];
    Object localObject1;
    label54:
    int i1;
    label93:
    float f1;
    if (paramBoolean)
    {
      localObject1 = this.jdField_e_of_type_AndroidWidgetTextView;
      ((View)localObject1).getLocationOnScreen((int[])localObject2);
      if (!paramBoolean) {
        break label364;
      }
      n = localObject2[1] - ((View)localObject1).getHeight();
      localObject1 = new TextView(this);
      ((TextView)localObject1).setBackgroundResource(2130845044);
      ((TextView)localObject1).setIncludeFontPadding(false);
      ((TextView)localObject1).setClickable(false);
      if (!paramBoolean) {
        break label373;
      }
      i1 = 2131691926;
      ((TextView)localObject1).setText(getString(i1));
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(12.0F);
      if (!paramBoolean) {
        break label381;
      }
      f1 = 6.0F;
      label126:
      i1 = AIOUtils.dp2px(f1, getResources());
      if (!paramBoolean) {
        break label388;
      }
      f1 = 6.0F;
      label144:
      int i2 = AIOUtils.dp2px(f1, getResources());
      if (!paramBoolean) {
        break label395;
      }
      f1 = f2;
      label160:
      int i3 = AIOUtils.dp2px(f1, getResources());
      if (!paramBoolean) {
        break label402;
      }
      f1 = 12.0F;
      label178:
      ((TextView)localObject1).setPadding(i1, i3, i2, AIOUtils.dp2px(f1, getResources()));
      localObject2 = new FrameLayout.LayoutParams(-2, -2);
      if (!paramBoolean) {
        break label409;
      }
      ((FrameLayout.LayoutParams)localObject2).rightMargin = AIOUtils.dp2px(20.0F, getResources());
      ((FrameLayout.LayoutParams)localObject2).gravity = 5;
      ((FrameLayout.LayoutParams)localObject2).topMargin = (n - AIOUtils.dp2px(19.0F, getResources()));
      label253:
      ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = new FrameLayout(this);
      ((FrameLayout)localObject2).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      ((FrameLayout)localObject2).addView((View)localObject1);
      if (!paramBoolean) {
        break label451;
      }
      n = 1;
      label298:
      ((FrameLayout)localObject2).setId(n);
      localFrameLayout.addView((View)localObject2);
      ((FrameLayout)localObject2).setOnTouchListener(new aehp(this, paramBoolean, (FrameLayout)localObject2));
      localObject1 = this.jdField_a_of_type_MqqOsMqqHandler;
      if (!paramBoolean) {
        break label457;
      }
    }
    label388:
    label395:
    label402:
    label409:
    label451:
    label457:
    for (int n = 20200313;; n = 20200720)
    {
      ((MqqHandler)localObject1).sendEmptyMessageDelayed(n, 3000L);
      return;
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      break;
      label364:
      n = localObject2[1];
      break label54;
      label373:
      i1 = 2131691927;
      break label93;
      label381:
      f1 = 10.0F;
      break label126;
      f1 = 10.0F;
      break label144;
      f1 = 10.0F;
      break label160;
      f1 = 16.0F;
      break label178;
      ((FrameLayout.LayoutParams)localObject2).gravity = 3;
      ((FrameLayout.LayoutParams)localObject2).leftMargin = AIOUtils.dp2px(10.0F, getResources());
      ((FrameLayout.LayoutParams)localObject2).topMargin = (n - AIOUtils.dp2px(25.0F, getResources()));
      break label253;
      n = 2;
      break label298;
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
    ((AnimationSet)localObject1).setAnimationListener(new aehl(this));
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
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847023);
      paramString = new AnimationSet(false);
      localObject1 = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      ((Animation)localObject1).setDuration(500L);
      localObject2 = new AlphaAnimation(1.0F, 0.0F);
      ((Animation)localObject2).setDuration(500L);
      paramString.addAnimation((Animation)localObject1);
      paramString.addAnimation((Animation)localObject2);
      this.jdField_f_of_type_AndroidWidgetImageView.startAnimation(paramString);
      paramString.setAnimationListener(new aehm(this));
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
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847025);
        if (!paramBoolean1) {
          break label109;
        }
      }
    }
    label109:
    for (int n = 2130847032;; n = 2130847022)
    {
      this.jdField_h_of_type_Boolean = this.jdField_g_of_type_Boolean;
      this.jdField_g_of_type_Boolean = paramBoolean1;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(n);
      getTitleBarView().setBackgroundResource(n);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundResource(n);
      return;
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847023);
      break;
      c(-15550475);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130847024);
      break;
    }
  }
  
  private boolean a()
  {
    try
    {
      SharedPreferences localSharedPreferences = getSharedPreferences(a(getCurrentAccountUin()) + "_" + jdField_a_of_type_JavaLangString, 0);
      int n = jdField_a_of_type_Int;
      long l1 = localSharedPreferences.getLong(jdField_a_of_type_JavaLangString, 0L);
      long l2 = System.currentTimeMillis();
      if (l2 - l1 < n) {
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
    biza localbiza = (biza)ScConfigManager.a().a("SecCenterConfig", false);
    if (localbiza != null) {
      return localbiza.a("ModifyPwdUrls", paramString);
    }
    return null;
  }
  
  private void b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramInt & 0x1) != 0)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      localArrayList.add(this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem);
      if ((paramInt & 0x2) == 0) {
        break label123;
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      localArrayList.add(this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem);
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
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break;
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
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
  
  private void b(View paramView)
  {
    paramView.setVisibility(8);
    bhhr.b("device_manage_phone_num_guide", Boolean.valueOf(false));
  }
  
  private void b(DevlockInfo paramDevlockInfo)
  {
    int n = 1;
    if (paramDevlockInfo != null) {
      if (paramDevlockInfo.DevSetup != 1) {
        break label34;
      }
    }
    for (;;)
    {
      if ((n == 0) && (a()))
      {
        k();
        b();
      }
      return;
      label34:
      n = 0;
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
    ((Animation)localObject).setAnimationListener(new aehn(this));
    localObject = new AnimationSet(false);
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 1620.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(1500L);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(1500L);
    ((AnimationSet)localObject).addAnimation(localRotateAnimation);
    ((AnimationSet)localObject).addAnimation(localAlphaAnimation);
    this.jdField_d_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
    ((AnimationSet)localObject).setAnimationListener(new aeho(this, paramBoolean, paramString));
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
      Drawable localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(2130850126);
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
      bbbq localbbbq = (bbbq)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localbbbq.a("100190.100199.100199001");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      localbbbq.a(localAppInfo);
    }
  }
  
  private void e(int paramInt)
  {
    if ((this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody != null) && (this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.size() != 0))
    {
      ((oidb_0x5e1.UdcUinData)this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.set(paramInt);
      TextView localTextView = this.jdField_f_of_type_AndroidWidgetTextView;
      if (paramInt == 1) {}
      for (String str = getString(2131692088);; str = getString(2131692093))
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
      bbbq localbbbq = (bbbq)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localbbbq.a("100190.100199.100199002");
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      localbbbq.a(localAppInfo);
    }
  }
  
  private void g()
  {
    Object localObject = (bbbq)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
    ((bbbq)localObject).b("100190.100199");
    ((bbbq)localObject).b("100190.100199.100199001");
    localObject = ((bbbq)localObject).a("100190.100199.100199001");
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
  }
  
  private void h()
  {
    Object localObject = (bbbq)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
    ((bbbq)localObject).b("100190.100199");
    ((bbbq)localObject).b("100190.100199.100199002");
    localObject = ((bbbq)localObject).a("100190.100199.100199002");
    this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a((BusinessInfoCheckUpdate.AppInfo)localObject);
  }
  
  private void i()
  {
    this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(0);
    bcvh.a(this.app, getCurrentAccountUin(), new aehq(this));
    bcvh.a(this.app, getCurrentAccountUin(), new aehr(this));
  }
  
  private void j()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new LoginInfoActivity.10(this));
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
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(true);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColorStateList(2131167031));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
  }
  
  private void m()
  {
    Intent localIntent = new Intent(this, AuthDevActivity.class);
    localIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
    localIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
    localIntent.putExtra("auth_dev_open", false);
    localIntent.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
    localIntent.putExtra("auth_dev_gray_switch", this.l);
    startActivityForResult(localIntent, 0);
  }
  
  private void n()
  {
    this.jdField_b_of_type_Int = GesturePWDUtils.getGesturePWDState(this, this.app.getCurrentAccountUin());
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131692788));
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131692779));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(getResources().getString(2131692787));
  }
  
  private void o()
  {
    ThreadManager.postImmediately(new LoginInfoActivity.CheckPIMStatus(this, this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem), null, true);
  }
  
  private void p()
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
  
  private void q()
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
  
  private void r()
  {
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131374428));
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    this.jdField_f_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
  }
  
  private void s()
  {
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131361918));
    if (bhhr.a(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_entrance", false))
    {
      this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      String str = bhhr.a(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_url", "");
      if (TextUtils.isEmpty(str)) {}
      for (this.jdField_d_of_type_JavaLangString = "https://ti.qq.com/qqcancel/index.html";; this.jdField_d_of_type_JavaLangString = str)
      {
        this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        return;
      }
    }
    this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
  }
  
  private void t()
  {
    long l1 = System.currentTimeMillis();
    Object localObject = bhhr.a(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_success_text", "");
    String str = bhhr.a(this.app.getApp(), this.app.getCurrentAccountUin(), "account_logout_bold_text", "");
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
    int n = bhai.a(this, this.app.getCurrentAccountUin());
    bhai.a(this, this.app.getCurrentAccountUin(), n + 1);
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
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    String str = this.app.getCurrentAccountUin();
    int n = asll.a().a(this.app, str, this.jdField_a_of_type_MqqObserverWtloginObserver);
    if (n != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginInfoActivity.AccDevSec", 2, "startGetDevLockStatus CheckDevLockStatus failed. ret=" + n);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setBackgroundResource(2130838911);
      this.jdField_i_of_type_Boolean = false;
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    q();
  }
  
  void b()
  {
    try
    {
      c();
      ReportDialog localReportDialog = new ReportDialog(this, 2131755829);
      localReportDialog.setContentView(2131559019);
      TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365648);
      if (localTextView1 != null) {
        localTextView1.setText(getString(2131692000));
      }
      localTextView1 = (TextView)localReportDialog.findViewById(2131365644);
      if (localTextView1 != null) {
        localTextView1.setText(getString(2131691997));
      }
      localTextView1 = (TextView)localReportDialog.findViewById(2131365633);
      if (localTextView1 != null) {
        localTextView1.setText(2131691998);
      }
      TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365639);
      if (localTextView2 != null) {
        localTextView2.setText(2131691999);
      }
      localReportDialog.setOnDismissListener(new aehh(this));
      if (localTextView1 != null) {
        localTextView1.setOnClickListener(this);
      }
      if (localTextView2 != null) {
        localTextView2.setOnClickListener(this);
      }
      this.jdField_a_of_type_AndroidAppDialog = localReportDialog;
      this.jdField_a_of_type_AndroidAppDialog.show();
      bdla.b(null, "dc00898", "", "", "0X800A5CF", "0X800A5CF", 0, 0, "", "", "", "");
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
    p();
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    QQProtectRisks.QQProtectRisksRequest localQQProtectRisksRequest = new QQProtectRisks.QQProtectRisksRequest();
    localQQProtectRisksRequest.uint32_sec_cmd.set(1);
    localQQProtectRisksRequest.str_package_name.set(bksu.c());
    localQQProtectRisksRequest.uint32_app_id.set(AppSetting.a());
    ntb.a(this.app, new aehj(this), localQQProtectRisksRequest.toByteArray(), "AccountSafeSvc.RiskDetect");
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    boolean bool1;
    if (paramInt1 == 0) {
      if (((paramInt2 == 0) || (paramInt2 == -1)) && (paramIntent != null) && (paramIntent.getExtras() != null) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null))
      {
        localObject = paramIntent.getExtras();
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
        {
          bool1 = true;
          bool1 = ((Bundle)localObject).getBoolean("auth_dev_open", bool1);
          String str = ((Bundle)localObject).getString("phone_num");
          if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 1) {}
          boolean bool2 = ((Bundle)localObject).getBoolean("allow_set");
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
    label716:
    do
    {
      do
      {
        do
        {
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
              n();
              return;
            }
            if (paramInt1 == 2)
            {
              o();
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
                this.jdField_e_of_type_ComTencentMobileqqWidgetFormSimpleItem.postDelayed(new LoginInfoActivity.17(this), 50L);
                bdla.a(this.app, "dc00898", "", "", "0X800989B", "0X800989B", 0, 0, "", "", "", "");
                return;
              }
              bdla.a(this.app, "dc00898", "", "", "0X800989A", "0X800989A", 0, 0, "", "", "", "");
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
            if (paramInt1 != 12) {
              break label547;
            }
          } while ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("key_face_scan_result", false)));
          e(0);
          QQToast.a(this, getString(2131691962), 0).a();
          return;
        } while ((paramInt1 != 1003) || (paramIntent == null));
        paramIntent = paramIntent.getExtras();
      } while (paramIntent == null);
      paramInt1 = paramIntent.getInt("resultState", 1);
      if (paramInt1 == 2) {
        aslf.a().a(aslf.jdField_d_of_type_Int);
      }
      for (;;)
      {
        if (paramInt1 == 1) {
          break label736;
        }
        localObject = paramIntent.getString("resultMobileMask");
        if (paramInt1 != 2) {
          break label716;
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
        bool1 = paramIntent.getBoolean("resultSetMobile");
        QLog.d("LoginInfoActivity.AccDevSec", 1, "onActivityResult.resultCode= RESULT_OK  resultMobileMask =" + (String)localObject + " openSuccess=" + bool1);
        if (!bool1) {
          break;
        }
        asll.a().a(this.app, this, this.app.getCurrentAccountUin(), true);
        return;
        if (paramInt1 == 3)
        {
          aslf.a().a(aslf.jdField_c_of_type_Int);
          aslf.a().a(0L);
        }
      }
    } while (paramInt1 != 3);
    label547:
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(super.getString(2131691979));
    return;
    label736:
    QLog.e("LoginInfoActivity.AccDevSec", 1, "guardPhoneState: error");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559378);
    setTitle(2131698800);
    d(-1);
    paramBundle = bhhr.j(this, getCurrentAccountUin());
    if (!TextUtils.isEmpty(paramBundle)) {}
    try
    {
      paramBundle = new JSONObject(paramBundle);
      if (paramBundle.optInt("securityType", 0) != 0) {
        break label1458;
      }
      bool2 = true;
    }
    catch (Exception paramBundle)
    {
      try
      {
        for (;;)
        {
          boolean bool3;
          boolean bool1;
          this.jdField_e_of_type_JavaLangString = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
          if (!this.l) {
            break;
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setText(getString(2131691924));
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          findViewById(2131370540).setVisibility(0);
          if (this.m)
          {
            bdla.b(null, "dc00898", "", "", "0X800AC59", "0X800AC59", 0, 0, "", "", "", "");
            this.jdField_c_of_type_AndroidWidgetTextView.post(new LoginInfoActivity.5(this));
          }
          bdla.b(null, "dc00898", "", "", "0X800AC50", "0X800AC50", 0, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("LoginInfoActivity.AccDevSec", 2, "packName = " + this.jdField_e_of_type_JavaLangString);
          }
          a(null);
          if (QLog.isColorLevel()) {
            QLog.d("LoginInfoActivity.AccDevSec", 2, "onCreate begin to getLoginDevList");
          }
          if (!NetworkUtil.isNetSupport(this)) {
            break label1547;
          }
          if (!this.l)
          {
            bool2 = asll.a().a(this.app, this.jdField_e_of_type_JavaLangString, 0L);
            if (!bool2) {
              QLog.d("LoginInfoActivity.AccDevSec", 1, new Object[] { "onCreate getLoginDevList failed ret=", Boolean.valueOf(bool2) });
            }
          }
          paramBundle = avpm.a().a();
          if (paramBundle != null) {
            paramBundle.a(new View[] { this.jdField_c_of_type_AndroidWidgetRelativeLayout, this.jdField_g_of_type_AndroidWidgetTextView });
          }
          if (!(paramBundle instanceof avqm)) {
            break label1570;
          }
          i();
          a();
          n();
          o();
          d();
          s();
          r();
          this.app.registObserver(this.jdField_a_of_type_Ayqy);
          return true;
          boolean bool2 = false;
          continue;
          bool2 = false;
          continue;
          int n = 0;
          continue;
          paramBundle = paramBundle;
          QLog.e("LoginInfoActivity.AccDevSec", 1, new Object[] { "parse dev gray switch error : ", paramBundle.getMessage() });
        }
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_b_of_type_AndroidWidgetRelativeLayout).d(27).a();
      }
      catch (PackageManager.NameNotFoundException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          continue;
          addObserver(this.jdField_a_of_type_Anvi);
          continue;
          QQToast.a(this, getString(2131692125), 0).b(getTitleBarHeight());
          continue;
          if ((paramBundle instanceof avql)) {
            bdla.a(null, "dc00898", "", "", "0X800B0EC", "0X800B0EC", 0, 0, "", "", "", "");
          }
        }
      }
    }
    this.l = bool2;
    if (paramBundle.optInt("showGroy", 0) == 1)
    {
      bool2 = true;
      this.m = bool2;
      bool2 = bhhr.e(this, getCurrentAccountUin());
      bool3 = this.m;
      if (bool2) {
        break label1468;
      }
      bool1 = true;
      this.m = (bool1 & bool3);
      QLog.d("LoginInfoActivity.AccDevSec", 1, new Object[] { "mIsGrayAccount : ", Boolean.valueOf(this.l), " showGory : ", Boolean.valueOf(this.m) });
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)findViewById(2131376748));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setScrollListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setPadding(0, 0, 0, 0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371680));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376744));
      paramBundle = (RelativeLayout)findViewById(2131376737);
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376746));
      this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376739));
      this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376741));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376738));
      this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376751));
      this.jdField_j_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376745));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376752));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376740));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376750));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376749));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376747));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376735));
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131716576));
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370539));
      if (!this.l) {
        break label1501;
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.post(new LoginInfoActivity.3(this));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371681));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365580));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131366370));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379913));
      this.jdField_b_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131366390));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370542));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131367651));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131363675));
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131693171));
      }
      this.jdField_a_of_type_AndroidViewView = findViewById(2131380510);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.jdField_a_of_type_AndroidViewView).d(27).a();
      bdla.a(null, "dc00898", "", "", "0X800B29B", "0X800B29B", 0, 0, "", "", "", "");
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131377260));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      if (((Boolean)bhhr.a("device_manage_phone_num_guide", Boolean.valueOf(true))).booleanValue()) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.post(new LoginInfoActivity.4(this));
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131372841));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131374533));
      this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131718431));
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131377265));
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(getString(2131718448));
      }
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      bool2 = SettingCloneUtil.readValue(this, this.app.getCurrentAccountUin(), "login_accounts", "qqsetting_bothonline_key", true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      bool2 = SettingCloneUtil.readValue(this, null, "security_scan_key", "qqsetting_security_scan_key", false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool2);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      if (!asll.a().b()) {
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramBundle = new SpannableString(getResources().getString(2131694208));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365578));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131373255));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365579));
      n = paramBundle.length();
      paramBundle.setSpan(new aehs(this, null), 0, n, 33);
      paramBundle.setSpan(new ForegroundColorSpan(getResources().getColor(2131167038)), 0, n, 33);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramBundle);
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
    removeObserver(this.jdField_a_of_type_Anvi);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.app.removeHandler(getClass());
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    d(-1);
    a();
    n();
    o();
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
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.l) {
        bdla.b(null, "dc00898", "", "", "0X800AC51", "0X800AC51", 0, 0, "", "", "", "");
      }
      g();
      bdla.b(this.app, "CliOper", "", "", "My_eq", "My_eq_protect", 0, 0, "", "", "", "");
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
      {
        if (!NetworkUtil.isNetSupport(this))
        {
          QQToast.a(this, getString(2131692125), 0).b(getTitleBarHeight());
        }
        else
        {
          bdla.b(null, "dc00898", "", "", "0X800ACBF", "0X800ACBF", 0, 0, "", "", "", "");
          QQToast.a(this, getString(2131691921), 0).a();
          a();
        }
      }
      else
      {
        Object localObject3;
        Object localObject1;
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
        {
          this.app.sendWirelessMeibaoReq(1);
          localObject3 = new Intent(this, AuthDevActivity.class);
          ((Intent)localObject3).putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          ((Intent)localObject3).putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
          ((Intent)localObject3).putExtra("auth_dev_open", true);
          ((Intent)localObject3).putExtra("auth_dev_gray_switch", this.l);
          if (this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse == null)
          {
            ((Intent)localObject3).putExtra("secureState", "secureStateUNKNOWN");
            startActivityForResult((Intent)localObject3, 0);
          }
          else
          {
            if (this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.bool_sec_pass.get()) {}
            for (localObject1 = "secureStateOk";; localObject1 = "secureStateError")
            {
              ((Intent)localObject3).putExtra("secureState", (String)localObject1);
              if (!this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.bool_sec_pass.get()) {
                break;
              }
              ((Intent)localObject3).putExtra("faceAppId", this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.str_openid.get());
              ((Intent)localObject3).putExtra("faceTmpKey", this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse.str_tmpkey.get());
              break;
            }
          }
        }
        else
        {
          this.app.sendWirelessMeibaoReq(1);
          if (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))
          {
            if (this.l)
            {
              m();
            }
            else
            {
              localObject1 = new Intent(this, AuthDevOpenUgActivity.class);
              ((Intent)localObject1).putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
              startActivityForResult((Intent)localObject1, 0);
            }
          }
          else if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 0)
          {
            if (this.l)
            {
              m();
            }
            else
            {
              localObject1 = new Intent(this, AuthDevOpenUgActivity.class);
              ((Intent)localObject1).putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
              startActivityForResult((Intent)localObject1, 0);
            }
          }
          else if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 1)
          {
            m();
            continue;
            try
            {
              c();
              bdla.b(null, "dc00898", "", "", "0X800A5D0", "0X800A5D0", 0, 0, "", "", "", "");
              localObject1 = new Intent(this, AuthDevOpenUgActivity.class);
              ((Intent)localObject1).putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
              startActivityForResult((Intent)localObject1, 0);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            continue;
            if (this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody == null)
            {
              if (!NetworkUtil.isNetSupport(this)) {
                QQToast.a(this, getString(2131692125), 0).b(getTitleBarHeight());
              }
              QLog.e("LoginInfoActivity.AccDevSec", 1, "face_login_layout click error : mFaceStateRsp is null");
            }
            else if (this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.isEmpty())
            {
              QLog.e("LoginInfoActivity.AccDevSec", 1, "faceVerifyLayout click error : mFaceStateRsp.rpt_msg_uin_data is null or empty");
            }
            else
            {
              this.jdField_c_of_type_AndroidWidgetRelativeLayout.setClickable(false);
              localObject3 = this.app;
              if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
              {
                localObject2 = "";
                label807:
                avpp.a((QQAppInterface)localObject3, this, (String)localObject2, this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody, this.jdField_a_of_type_FaceQqloginFaceSecureCheck$SecureCheckResponse, new LoginInfoActivity.15(this));
                if (((oidb_0x5e1.UdcUinData)this.jdField_a_of_type_TencentImOidbOidb_0x5e1$RspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.get() != 1) {
                  break label898;
                }
              }
              label898:
              for (Object localObject2 = "1";; localObject2 = "0")
              {
                bdla.b(null, "dc00898", "", "", "0X800AA7B", "0X800AA7B", 0, 0, (String)localObject2, "", "", "");
                break;
                localObject2 = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
                break label807;
              }
              bdla.b(null, "dc00898", "", "", "0X800A5D1", "0X800A5D1", 0, 0, "", "", "", "");
              c();
              continue;
              startActivity(new Intent(this, SecurityPickproofActivity.class));
              bdla.b(null, "P_CliOper", "Safe_Pickproof", "", "Pickproof", "enter pickproof page", 0, 0, "", "", "", "");
              continue;
              if (!NetworkUtil.isNetSupport(this))
              {
                QQToast.a(this, getString(2131692125), 0).b(getTitleBarHeight());
              }
              else
              {
                bdla.b(this.app, "CliOper", "", "", "My_eq", "Clk_eq_recently", 0, 0, "", "", "", "");
                startActivity(new Intent(this, RecentLoginDevActivity.class));
                continue;
                startActivityForResult(new Intent(this, GesturePWDSettingActivity.class), 1);
                continue;
                h();
                bdla.a(null, "dc00898", "", "", "0X800B29C", "0X800B29C", 0, 0, "", "", "", "");
                int n;
                if (azit.a().a(this.app, this.app.getCurrentAccountUin()))
                {
                  localObject3 = new Intent(this, QQBrowserActivity.class);
                  ((Intent)localObject3).putExtra("uin", this.app.getCurrentAccountUin());
                  localObject2 = b("HasSetPwdUrl");
                  if (!TextUtils.isEmpty((CharSequence)localObject2))
                  {
                    n = 1;
                    label1179:
                    if (n == 0) {
                      localObject2 = "https://accounts.qq.com/cn2/change_psw/mobile/mobile_change_psw_way?source_id=2733";
                    }
                    if (((String)localObject2).indexOf("?") != -1) {
                      break label1278;
                    }
                  }
                  label1278:
                  for (localObject2 = (String)localObject2 + "?uin=" + this.app.getCurrentAccountUin();; localObject2 = (String)localObject2 + "&uin=" + this.app.getCurrentAccountUin())
                  {
                    startActivity(((Intent)localObject3).putExtra("url", (String)localObject2));
                    this.app.sendWirelessPswReq(1);
                    if (n == 0) {
                      a("FetchUrl", 1);
                    }
                    a("ClkModifyPwd", 1);
                    break;
                    n = 0;
                    break label1179;
                  }
                }
                localObject3 = this.app.getCurrentAccountUin();
                localObject2 = b("RegNewUrl");
                label1338:
                Object localObject4;
                if (!TextUtils.isEmpty((CharSequence)localObject2))
                {
                  n = 1;
                  if (n == 0) {
                    localObject2 = "https://accounts.qq.com/cn2/change_psw/mobile/mobile_change_psw_reg_input_psw";
                  }
                  localObject4 = new StringBuilder((String)localObject2);
                  if (((String)localObject2).indexOf("?") != -1) {
                    break label1616;
                  }
                  ((StringBuilder)localObject4).append("?");
                }
                for (;;)
                {
                  ((StringBuilder)localObject4).append("uin=");
                  ((StringBuilder)localObject4).append((String)localObject3);
                  ((StringBuilder)localObject4).append("&plat=1");
                  ((StringBuilder)localObject4).append("&app=1");
                  ((StringBuilder)localObject4).append("&version=8.4.10.4875");
                  ((StringBuilder)localObject4).append("&device=" + URLEncoder.encode(Build.DEVICE));
                  ((StringBuilder)localObject4).append("&system=" + Build.VERSION.RELEASE);
                  ((StringBuilder)localObject4).append("&systemInt=" + Integer.toString(Build.VERSION.SDK_INT));
                  localObject2 = ((StringBuilder)localObject4).toString();
                  localObject4 = new Intent();
                  ((Intent)localObject4).putExtra("portraitOnly", true);
                  ((Intent)localObject4).putExtra("url", (String)localObject2);
                  ((Intent)localObject4).putExtra("uin", (String)localObject3);
                  ((Intent)localObject4).putExtra("hide_operation_bar", true);
                  ((Intent)localObject4).putExtra("hide_more_button", true);
                  VasWebviewUtil.openQQBrowserActivity(this, (String)localObject2, 32768L, (Intent)localObject4, false, -1);
                  if (n == 0) {
                    a("FetchUrl", 2);
                  }
                  a("ClkModifyPwd", 2);
                  break;
                  n = 0;
                  break label1338;
                  label1616:
                  ((StringBuilder)localObject4).append("&");
                }
                startActivityForResult(new Intent(this, SecurityProtectActivity.class), 2);
                bdla.b(null, "P_CliOper", "Safe_SecurityDetect", "", "SecurityDetect_", "click on qqpimsecure_detect", 0, 0, "", "", "", "");
                continue;
                if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
                {
                  localObject2 = new Intent(this, RiskInfoActivity.class);
                  ((Intent)localObject2).putParcelableArrayListExtra("data", this.jdField_a_of_type_JavaUtilArrayList);
                  ((Intent)localObject2).putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
                  startActivityForResult((Intent)localObject2, 3);
                  bdla.b(this.app, "dc00899", "Safe_RiskInfo", "", "RiskDetails", "click on risk details", 0, 0, "", "", "", "");
                  bdla.b(null, "dc00898", "", "", "0X800A718", "0X800A718", 0, 0, "", "", "", "");
                  if (QLog.isColorLevel())
                  {
                    QLog.d("DevRpt", 2, "帐号安全页顶部风险提示区域点击“发现XXX等N项风险”文字进入安全风险页！0X800A718");
                    continue;
                    if (!this.k)
                    {
                      this.k = true;
                      MiniAppLauncher.startMiniApp(this, "mqqapi://miniapp/open?_atype=0&_mappid=1109907872&_mvid=&_vt=3&via=4010&_sig=1596013484", 4010, null);
                      bdla.b(this.app, "dc00899", "QQSafetyCenter", this.app.getCurrentAccountUin(), "clickQQSafetyCenter", "qq_safety_center_item", 0, 1, "", "", "", "");
                      bdla.b(null, "dc00898", "", "", "0X800A719", "0X800A719", 0, 0, "", "", "", "");
                      if (QLog.isColorLevel())
                      {
                        QLog.d("DevRpt", 2, "帐号安全页点击“QQ安全中心”用户数、次数！0X800A719");
                        continue;
                        if (!this.jdField_j_of_type_Boolean)
                        {
                          this.jdField_j_of_type_Boolean = true;
                          localObject2 = new Intent(this, QQBrowserActivity.class);
                          ((Intent)localObject2).putExtra("url", this.jdField_d_of_type_JavaLangString);
                          ((Intent)localObject2).putExtra("is_release_account", true);
                          startActivityForResult((Intent)localObject2, 4);
                          bdla.b(this.app, "dc00898", "", "", "0X8009899", "0X8009899", 0, 0, "", "", "", "");
                          continue;
                          if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
                          {
                            if (!NetworkUtil.isNetSupport(this)) {
                              QQToast.a(this, getString(2131692125), 0).b(getTitleBarHeight());
                            } else {
                              a();
                            }
                          }
                          else
                          {
                            this.app.sendWirelessMeibaoReq(1);
                            if (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))
                            {
                              bdla.b(this.app, "dc00898", "", "", "0X800AC9E", "0X800AC9E", 0, 0, "2", "", "", "");
                              localObject2 = new Intent(this, AuthDevOpenUgActivity.class);
                              ((Intent)localObject2).putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
                              startActivityForResult((Intent)localObject2, 0);
                            }
                            else if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 0)
                            {
                              bdla.b(this.app, "dc00898", "", "", "0X800AC9E", "0X800AC9E", 0, 0, "1", "", "", "");
                              localObject2 = new Intent(this, AuthDevOpenUgActivity.class);
                              ((Intent)localObject2).putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
                              startActivityForResult((Intent)localObject2, 0);
                            }
                            else if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 1)
                            {
                              bdla.b(this.app, "dc00898", "", "", "0X800AC9E", "0X800AC9E", 0, 0, "1", "", "", "");
                              if ((TextUtils.isEmpty(this.app.getCurrentAccountUin())) && (QLog.isColorLevel())) {
                                QLog.d("LoginInfoActivity.AccDevSec", 2, "onClick current is empty");
                              }
                              aslh.a(this, this.app, aslh.jdField_a_of_type_Int, 1003, null);
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
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
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity
 * JD-Core Version:    0.7.0.1
 */