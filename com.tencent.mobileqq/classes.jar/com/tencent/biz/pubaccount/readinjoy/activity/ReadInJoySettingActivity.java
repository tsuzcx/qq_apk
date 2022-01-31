package com.tencent.biz.pubaccount.readinjoy.activity;

import ajsf;
import ajyc;
import akdo;
import android.content.Context;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import axqw;
import bbay;
import bcpq;
import bfol;
import bfoy;
import bhvh;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.SetMessageConfigurationRequest;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Calendar;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import noo;
import nou;
import nut;
import nwt;
import nwu;
import nwv;
import nww;
import nwx;
import nwy;
import nwz;
import nxa;
import nxb;
import nxc;
import nxd;
import nxe;
import nxf;
import nxg;
import onk;
import sfh;
import sfi;
import sgj;
import shh;

public class ReadInJoySettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String a;
  public int a;
  private akdo jdField_a_of_type_Akdo = new nxf(this);
  public Context a;
  private DialogInterface.OnKeyListener jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener = new nwz(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  public Resources a;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public bcpq a;
  private bfol jdField_a_of_type_Bfol;
  private KandianMergeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  public QQAppInterface a;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  Calendar jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
  public boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  public int b;
  private View jdField_b_of_type_AndroidViewView;
  private bfol jdField_b_of_type_Bfol;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  private String jdField_b_of_type_JavaLangString = "QQ看点";
  protected boolean b;
  private int jdField_c_of_type_Int = 2;
  private View jdField_c_of_type_AndroidViewView;
  private bfol jdField_c_of_type_Bfol;
  private Switch jdField_c_of_type_ComTencentWidgetSwitch;
  private final String jdField_c_of_type_JavaLangString = ajyc.a(2131713106);
  public boolean c;
  private Switch jdField_d_of_type_ComTencentWidgetSwitch;
  private final String jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private final String jdField_e_of_type_JavaLangString = ajyc.a(2131712893);
  private boolean jdField_e_of_type_Boolean;
  private final String jdField_f_of_type_JavaLangString = ajyc.a(2131712847);
  private boolean jdField_f_of_type_Boolean;
  private final String jdField_g_of_type_JavaLangString = ajyc.a(2131712778);
  private boolean jdField_g_of_type_Boolean;
  private final String jdField_h_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private final String jdField_i_of_type_JavaLangString = ajyc.a(2131712758);
  private boolean jdField_i_of_type_Boolean;
  private final String j = ajyc.a(2131712756);
  private final String k = ajyc.a(2131712907);
  private final String l = "https://kandian.qq.com/mqq/vue/configPush?_wv=3&x5PreFetch=1&_bid=2378";
  
  static
  {
    jdField_a_of_type_JavaLangString = ajsf.az;
  }
  
  public ReadInJoySettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private Drawable a()
  {
    sfi localsfi = sfh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3);
    if ((localsfi != null) && (localsfi.a() != null)) {
      return localsfi.a();
    }
    return sfh.a(this.jdField_a_of_type_AndroidContentContext, 3);
  }
  
  private void b()
  {
    boolean bool2 = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(new ReadInJoyNewFeedsTopGestureLayout(this));
    }
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources();
    setTitle(ajyc.a(2131712781));
    this.leftView.setContentDescription(ajyc.a(2131712703));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c();
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d();
    this.jdField_f_of_type_Boolean = SettingCloneUtil.readValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", false);
    this.jdField_h_of_type_Boolean = bhvh.i();
    boolean bool1;
    if (!bhvh.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      bool1 = true;
    }
    for (;;)
    {
      this.jdField_g_of_type_Boolean = bool1;
      try
      {
        if (onk.b() != null) {
          this.jdField_c_of_type_Int = Integer.parseInt(onk.b());
        }
        label203:
        this.jdField_b_of_type_JavaLangString = sfh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3);
        Object localObject = a();
        ((ImageView)findViewById(2131367679)).setImageDrawable((Drawable)localObject);
        localObject = (TextView)findViewById(2131370659);
        ((TextView)localObject).setText(this.jdField_b_of_type_JavaLangString);
        ((TextView)localObject).setContentDescription(this.jdField_b_of_type_JavaLangString);
        localObject = (TextView)findViewById(2131365039);
        ((TextView)localObject).setText(String.format(this.jdField_e_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        ((TextView)localObject).setContentDescription(String.format(this.jdField_e_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        e(this.jdField_g_of_type_Boolean);
        localObject = (TextView)findViewById(2131374919);
        ((TextView)localObject).setText(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        ((TextView)localObject).setContentDescription(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        d();
        c();
        b(this.jdField_c_of_type_Int);
        this.jdField_a_of_type_Bcpq = new bcpq(this, super.getTitleBarHeight());
        this.jdField_a_of_type_Bcpq.setCanceledOnTouchOutside(true);
        this.jdField_a_of_type_Bcpq.a(new nwt(this));
        this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131371653));
        this.jdField_b_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_f_of_type_Boolean);
        this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new nxa(this));
        this.jdField_d_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131378746));
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369467));
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        int m;
        if (Aladdin.getConfig(232).getIntegerFromString("user_data_switch_switch", 0) == 1)
        {
          m = 0;
          label542:
          ((LinearLayout)localObject).setVisibility(m);
          localObject = this.jdField_d_of_type_ComTencentWidgetSwitch;
          if (shh.a() != 0) {
            break label957;
          }
          bool1 = true;
          label562:
          ((Switch)localObject).setChecked(bool1);
          this.jdField_d_of_type_ComTencentWidgetSwitch.setContentDescription(Aladdin.getConfig(232).getString("user_data_switch_content", getString(2131718606)));
          ((TextView)findViewById(2131378110)).setText(Aladdin.getConfig(232).getString("user_data_switch_content", getString(2131718606)));
          this.jdField_d_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new nxb(this));
          noo.a(null, "", "0X800A80A", "0X800A80A", 0, 0, "", "", "", "", false);
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368793));
          this.jdField_c_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131376106));
          this.jdField_c_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_h_of_type_Boolean);
          this.jdField_c_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new nxc(this));
          if (!this.jdField_h_of_type_Boolean) {
            break label962;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718570);
          label740:
          this.jdField_b_of_type_AndroidViewView = findViewById(2131368231);
          this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_c_of_type_AndroidViewView = findViewById(2131376259);
          this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
          findViewById(2131379074).setOnClickListener(this);
          this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { this.jdField_a_of_type_AndroidContentResResources.getString(2131699667), this.jdField_a_of_type_AndroidContentResResources.getString(2131699669), this.jdField_a_of_type_AndroidContentResResources.getString(2131699668) };
          ((TextView)findViewById(2131371651)).setText(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int]);
          bool1 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.jdField_a_of_type_AndroidViewView = findViewById(2131372869);
          if (!bool1) {
            break label975;
          }
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          }
        }
        for (;;)
        {
          if (!bhvh.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label994;
          }
          localObject = findViewById(2131374814);
          ((View)localObject).setVisibility(0);
          ((View)localObject).setOnClickListener(new nxd(this));
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akdo);
          return;
          bool1 = false;
          break;
          m = 8;
          break label542;
          label957:
          bool1 = false;
          break label562;
          label962:
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718573);
          break label740;
          label975:
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          }
        }
        label994:
        findViewById(2131374918).setVisibility(0);
        localObject = (TextView)findViewById(2131374921);
        ((TextView)localObject).setText(this.jdField_f_of_type_JavaLangString);
        ((TextView)localObject).setContentDescription(this.jdField_f_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131368795));
        localObject = this.jdField_a_of_type_ComTencentWidgetSwitch;
        if (!this.jdField_d_of_type_Boolean) {}
        for (bool1 = bool2;; bool1 = false)
        {
          ((Switch)localObject).setChecked(bool1);
          this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new nxe(this));
          break;
        }
      }
      catch (Exception localException)
      {
        break label203;
      }
    }
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "createVideoActionSheet");
    }
    if (this.jdField_c_of_type_Bfol != null) {
      return;
    }
    this.jdField_c_of_type_Bfol = ((bfol)bfoy.a(this, null));
    this.jdField_c_of_type_Bfol.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131699667), 5, false);
    this.jdField_c_of_type_Bfol.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131699669), 5, false);
    this.jdField_c_of_type_Bfol.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131699668), 5, false);
    this.jdField_c_of_type_Bfol.d(paramInt);
    this.jdField_c_of_type_Bfol.c(2131690596);
    this.jdField_c_of_type_Bfol.a(new nwx(this));
    this.jdField_c_of_type_Bfol.a(new nwy(this));
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Int += 1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = true;
    a(2131699652);
    NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), nou.class);
    localNewIntent.putExtra("cmd", "set_message_configuration");
    localNewIntent.putExtra("uin", 2171946401L);
    mobileqq_mp.SetMessageConfigurationRequest localSetMessageConfigurationRequest = new mobileqq_mp.SetMessageConfigurationRequest();
    localSetMessageConfigurationRequest.uin.set(2171946401L);
    if (paramBoolean) {
      localSetMessageConfigurationRequest.type.set(1);
    }
    for (;;)
    {
      localSetMessageConfigurationRequest.versionInfo.set(sgj.a());
      localNewIntent.putExtra("data", localSetMessageConfigurationRequest.toByteArray());
      localNewIntent.putExtra("kandian_seq", this.jdField_b_of_type_Int);
      nou.a(localNewIntent);
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return;
      localSetMessageConfigurationRequest.type.set(2);
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "showConfirmDialog");
    }
    if (this.jdField_a_of_type_Bfol != null) {
      return;
    }
    String str = String.format(this.jdField_c_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_Bfol = ((bfol)bfoy.a(this, null));
    this.jdField_a_of_type_Bfol.a(str);
    this.jdField_a_of_type_Bfol.a(this.jdField_h_of_type_JavaLangString, 3);
    this.jdField_a_of_type_Bfol.c(2131690596);
    this.jdField_a_of_type_Bfol.a(new nxg(this));
    this.jdField_a_of_type_Bfol.a(new nwu(this));
    this.jdField_a_of_type_Bfol.setOnKeyListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      noo.a(null, "CliOper", "", "", "0X80067D7", "0X80067D7", 0, 0, "", "", "", onk.c(), false);
    }
    SettingCloneUtil.writeValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", paramBoolean);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "showEnableActionSheet");
    }
    if (this.jdField_b_of_type_Bfol != null) {
      return;
    }
    String str = String.format(this.k, new Object[] { this.jdField_b_of_type_JavaLangString });
    this.jdField_b_of_type_Bfol = ((bfol)bfoy.a(this, null));
    this.jdField_b_of_type_Bfol.a(str);
    this.jdField_b_of_type_Bfol.a(String.format(this.j, new Object[] { this.jdField_b_of_type_JavaLangString }), 3);
    this.jdField_b_of_type_Bfol.c(2131690596);
    this.jdField_b_of_type_Bfol.a(new nwv(this));
    this.jdField_b_of_type_Bfol.a(new nww(this));
  }
  
  private void d(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      bhvh.a(localQQAppInterface, bool);
      this.jdField_d_of_type_Boolean = paramBoolean;
      b(this.jdField_d_of_type_Boolean);
      if (!paramBoolean) {
        break;
      }
      e(paramBoolean);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_d_of_type_Boolean);
      axqw.b(null, "CliOper", "", "", "0X80067FA", "0X80067FA", 0, 0, "", "", "", "");
      return;
    }
    noo.a(null, "CliOper", "", "", "0X80067F9", "0X80067F9", 0, 0, "", "", "", onk.c(), false);
    noo.a("0X80067F9", "", "", "", "", onk.c());
    e(paramBoolean);
  }
  
  private void e(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131375959);
    TextView localTextView = (TextView)findViewById(2131376466);
    if (paramBoolean)
    {
      localLinearLayout.setVisibility(0);
      localTextView.setText(ajyc.a(2131712896));
      return;
    }
    localLinearLayout.setVisibility(8);
    localTextView.setText(ajyc.a(2131713095));
  }
  
  public void a()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      ImmersiveUtils.a(getWindow(), this.isClearCoverLayer);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label172;
      }
      if ((bbay.b()) || (bbay.d())) {
        break label151;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130848492);
      if (this.centerView != null) {
        this.centerView.setTextColor(-16777216);
      }
      this.vg.setBackgroundColor(-1);
      return;
      label151:
      this.mSystemBarComp.setStatusBarColor(-7829368);
      this.mSystemBarComp.setStatusBarDarkMode(true);
      continue;
      label172:
      if ((Build.VERSION.SDK_INT >= 23) && (!bbay.b()) && (!bbay.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!bbay.d())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
      }
      else
      {
        this.mSystemBarComp.setStatusBarColor(-1);
        this.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
  }
  
  protected void a(int paramInt)
  {
    this.jdField_b_of_type_AndroidViewView.postDelayed(new ReadInJoySettingActivity.8(this, paramInt), 500L);
  }
  
  public void a(boolean paramBoolean)
  {
    Switch localSwitch = this.jdField_a_of_type_ComTencentWidgetSwitch;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localSwitch.setChecked(paramBoolean);
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131560019);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    b();
    if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      a();
    }
    this.jdField_i_of_type_Boolean = false;
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bfol != null) && (this.jdField_a_of_type_Bfol.isShowing()))
    {
      this.jdField_a_of_type_Bfol.dismiss();
      this.jdField_a_of_type_Bfol = null;
    }
    if ((this.jdField_b_of_type_Bfol != null) && (this.jdField_b_of_type_Bfol.isShowing()))
    {
      this.jdField_b_of_type_Bfol.dismiss();
      this.jdField_b_of_type_Bfol = null;
    }
    if ((this.jdField_c_of_type_Bfol != null) && (this.jdField_c_of_type_Bfol.isShowing()))
    {
      this.jdField_c_of_type_Bfol.dismiss();
      this.jdField_c_of_type_Bfol = null;
    }
    super.doOnDestroy();
    this.jdField_a_of_type_Bcpq = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akdo);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_i_of_type_Boolean)
    {
      QLog.d("ReadInJoySettingActivity", 1, "refresh channel list while leave interest label");
      this.jdField_i_of_type_Boolean = false;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368231: 
      this.jdField_i_of_type_Boolean = true;
      bhvh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      nut.a(this);
      noo.a(null, "CliOper", "", "", "0X80067D8", "0X80067D8", 0, 0, "", "", "", onk.c(), false);
      return;
    case 2131379074: 
      this.jdField_c_of_type_Bfol.show();
      return;
    }
    nut.a(this.mContentView.getContext(), 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity
 * JD-Core Version:    0.7.0.1
 */