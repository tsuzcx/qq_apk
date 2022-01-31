package com.tencent.biz.pubaccount.readinjoy.activity;

import ajed;
import ajjy;
import ajpe;
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
import awqx;
import azzu;
import bbms;
import begr;
import behe;
import bgmq;
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
import ndn;
import ndt;
import nji;
import nli;
import nlj;
import nlk;
import nll;
import nlm;
import nln;
import nlo;
import nlp;
import nlq;
import nlr;
import nls;
import nlt;
import nlu;
import nlv;
import obz;
import rsp;
import rsq;
import rtr;
import rup;

public class ReadInJoySettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String a;
  public int a;
  private ajpe jdField_a_of_type_Ajpe = new nlu(this);
  public Context a;
  private DialogInterface.OnKeyListener jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener = new nlo(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  public Resources a;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public bbms a;
  private begr jdField_a_of_type_Begr;
  private KandianMergeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  public QQAppInterface a;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  Calendar jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
  public boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  public int b;
  private View jdField_b_of_type_AndroidViewView;
  private begr jdField_b_of_type_Begr;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  private String jdField_b_of_type_JavaLangString = "QQ看点";
  protected boolean b;
  private int jdField_c_of_type_Int = 2;
  private View jdField_c_of_type_AndroidViewView;
  private begr jdField_c_of_type_Begr;
  private Switch jdField_c_of_type_ComTencentWidgetSwitch;
  private final String jdField_c_of_type_JavaLangString = ajjy.a(2131647318);
  public boolean c;
  private Switch jdField_d_of_type_ComTencentWidgetSwitch;
  private final String jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private final String jdField_e_of_type_JavaLangString = ajjy.a(2131647105);
  private boolean jdField_e_of_type_Boolean;
  private final String jdField_f_of_type_JavaLangString = ajjy.a(2131647059);
  private boolean jdField_f_of_type_Boolean;
  private final String jdField_g_of_type_JavaLangString = ajjy.a(2131646990);
  private boolean jdField_g_of_type_Boolean;
  private final String jdField_h_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private final String jdField_i_of_type_JavaLangString = ajjy.a(2131646970);
  private boolean jdField_i_of_type_Boolean;
  private final String j = ajjy.a(2131646968);
  private final String k = ajjy.a(2131647119);
  private final String l = "https://kandian.qq.com/mqq/vue/configPush?_wv=3&x5PreFetch=1&_bid=2378";
  
  static
  {
    jdField_a_of_type_JavaLangString = ajed.ay;
  }
  
  public ReadInJoySettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private Drawable a()
  {
    rsq localrsq = rsp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3);
    if ((localrsq != null) && (localrsq.a() != null)) {
      return localrsq.a();
    }
    return rsp.a(this.jdField_a_of_type_AndroidContentContext, 3);
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
    setTitle(ajjy.a(2131646993));
    this.leftView.setContentDescription(ajjy.a(2131646915));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c();
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d();
    this.jdField_f_of_type_Boolean = SettingCloneUtil.readValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", false);
    this.jdField_h_of_type_Boolean = bgmq.i();
    boolean bool1;
    if (!bgmq.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      bool1 = true;
    }
    for (;;)
    {
      this.jdField_g_of_type_Boolean = bool1;
      try
      {
        if (obz.b() != null) {
          this.jdField_c_of_type_Int = Integer.parseInt(obz.b());
        }
        label203:
        this.jdField_b_of_type_JavaLangString = rsp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3);
        Object localObject = a();
        ((ImageView)findViewById(2131302061)).setImageDrawable((Drawable)localObject);
        localObject = (TextView)findViewById(2131304993);
        ((TextView)localObject).setText(this.jdField_b_of_type_JavaLangString);
        ((TextView)localObject).setContentDescription(this.jdField_b_of_type_JavaLangString);
        localObject = (TextView)findViewById(2131299471);
        ((TextView)localObject).setText(String.format(this.jdField_e_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        ((TextView)localObject).setContentDescription(String.format(this.jdField_e_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        e(this.jdField_g_of_type_Boolean);
        localObject = (TextView)findViewById(2131309175);
        ((TextView)localObject).setText(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        ((TextView)localObject).setContentDescription(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        d();
        c();
        b(this.jdField_c_of_type_Int);
        this.jdField_a_of_type_Bbms = new bbms(this, super.getTitleBarHeight());
        this.jdField_a_of_type_Bbms.setCanceledOnTouchOutside(true);
        this.jdField_a_of_type_Bbms.a(new nli(this));
        this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131305957));
        this.jdField_b_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_f_of_type_Boolean);
        this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new nlp(this));
        this.jdField_d_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131312921));
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131303791));
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        int m;
        if (Aladdin.getConfig(232).getIntegerFromString("user_data_switch_switch", 0) == 1)
        {
          m = 0;
          label542:
          ((LinearLayout)localObject).setVisibility(m);
          localObject = this.jdField_d_of_type_ComTencentWidgetSwitch;
          if (rup.a() != 0) {
            break label957;
          }
          bool1 = true;
          label562:
          ((Switch)localObject).setChecked(bool1);
          this.jdField_d_of_type_ComTencentWidgetSwitch.setContentDescription(Aladdin.getConfig(232).getString("user_data_switch_content", getString(2131652781)));
          ((TextView)findViewById(2131312290)).setText(Aladdin.getConfig(232).getString("user_data_switch_content", getString(2131652781)));
          this.jdField_d_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new nlq(this));
          ndn.a(null, "", "0X800A80A", "0X800A80A", 0, 0, "", "", "", "", false);
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131303153));
          this.jdField_c_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131310314));
          this.jdField_c_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_h_of_type_Boolean);
          this.jdField_c_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new nlr(this));
          if (!this.jdField_h_of_type_Boolean) {
            break label962;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131652745);
          label740:
          this.jdField_b_of_type_AndroidViewView = findViewById(2131302609);
          this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_c_of_type_AndroidViewView = findViewById(2131310467);
          this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
          findViewById(2131313238).setOnClickListener(this);
          this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { this.jdField_a_of_type_AndroidContentResResources.getString(2131633879), this.jdField_a_of_type_AndroidContentResResources.getString(2131633881), this.jdField_a_of_type_AndroidContentResResources.getString(2131633880) };
          ((TextView)findViewById(2131305955)).setText(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int]);
          bool1 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.jdField_a_of_type_AndroidViewView = findViewById(2131307157);
          if (!bool1) {
            break label975;
          }
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          }
        }
        for (;;)
        {
          if (!bgmq.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label994;
          }
          localObject = findViewById(2131309072);
          ((View)localObject).setVisibility(0);
          ((View)localObject).setOnClickListener(new nls(this));
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajpe);
          return;
          bool1 = false;
          break;
          m = 8;
          break label542;
          label957:
          bool1 = false;
          break label562;
          label962:
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131652748);
          break label740;
          label975:
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          }
        }
        label994:
        findViewById(2131309174).setVisibility(0);
        localObject = (TextView)findViewById(2131309177);
        ((TextView)localObject).setText(this.jdField_f_of_type_JavaLangString);
        ((TextView)localObject).setContentDescription(this.jdField_f_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131303155));
        localObject = this.jdField_a_of_type_ComTencentWidgetSwitch;
        if (!this.jdField_d_of_type_Boolean) {}
        for (bool1 = bool2;; bool1 = false)
        {
          ((Switch)localObject).setChecked(bool1);
          this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new nlt(this));
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
    if (this.jdField_c_of_type_Begr != null) {
      return;
    }
    this.jdField_c_of_type_Begr = ((begr)behe.a(this, null));
    this.jdField_c_of_type_Begr.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131633879), 5, false);
    this.jdField_c_of_type_Begr.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131633881), 5, false);
    this.jdField_c_of_type_Begr.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131633880), 5, false);
    this.jdField_c_of_type_Begr.d(paramInt);
    this.jdField_c_of_type_Begr.c(2131625035);
    this.jdField_c_of_type_Begr.a(new nlm(this));
    this.jdField_c_of_type_Begr.a(new nln(this));
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Int += 1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = true;
    a(2131633864);
    NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), ndt.class);
    localNewIntent.putExtra("cmd", "set_message_configuration");
    localNewIntent.putExtra("uin", 2171946401L);
    mobileqq_mp.SetMessageConfigurationRequest localSetMessageConfigurationRequest = new mobileqq_mp.SetMessageConfigurationRequest();
    localSetMessageConfigurationRequest.uin.set(2171946401L);
    if (paramBoolean) {
      localSetMessageConfigurationRequest.type.set(1);
    }
    for (;;)
    {
      localSetMessageConfigurationRequest.versionInfo.set(rtr.a());
      localNewIntent.putExtra("data", localSetMessageConfigurationRequest.toByteArray());
      localNewIntent.putExtra("kandian_seq", this.jdField_b_of_type_Int);
      ndt.a(localNewIntent);
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
    if (this.jdField_a_of_type_Begr != null) {
      return;
    }
    String str = String.format(this.jdField_c_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_Begr = ((begr)behe.a(this, null));
    this.jdField_a_of_type_Begr.a(str);
    this.jdField_a_of_type_Begr.a(this.jdField_h_of_type_JavaLangString, 3);
    this.jdField_a_of_type_Begr.c(2131625035);
    this.jdField_a_of_type_Begr.a(new nlv(this));
    this.jdField_a_of_type_Begr.a(new nlj(this));
    this.jdField_a_of_type_Begr.setOnKeyListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      ndn.a(null, "CliOper", "", "", "0X80067D7", "0X80067D7", 0, 0, "", "", "", obz.c(), false);
    }
    SettingCloneUtil.writeValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", paramBoolean);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "showEnableActionSheet");
    }
    if (this.jdField_b_of_type_Begr != null) {
      return;
    }
    String str = String.format(this.k, new Object[] { this.jdField_b_of_type_JavaLangString });
    this.jdField_b_of_type_Begr = ((begr)behe.a(this, null));
    this.jdField_b_of_type_Begr.a(str);
    this.jdField_b_of_type_Begr.a(String.format(this.j, new Object[] { this.jdField_b_of_type_JavaLangString }), 3);
    this.jdField_b_of_type_Begr.c(2131625035);
    this.jdField_b_of_type_Begr.a(new nlk(this));
    this.jdField_b_of_type_Begr.a(new nll(this));
  }
  
  private void d(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      bgmq.a(localQQAppInterface, bool);
      this.jdField_d_of_type_Boolean = paramBoolean;
      b(this.jdField_d_of_type_Boolean);
      if (!paramBoolean) {
        break;
      }
      e(paramBoolean);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_d_of_type_Boolean);
      awqx.b(null, "CliOper", "", "", "0X80067FA", "0X80067FA", 0, 0, "", "", "", "");
      return;
    }
    ndn.a(null, "CliOper", "", "", "0X80067F9", "0X80067F9", 0, 0, "", "", "", obz.c(), false);
    ndn.a("0X80067F9", "", "", "", "", obz.c());
    e(paramBoolean);
  }
  
  private void e(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131310192);
    TextView localTextView = (TextView)findViewById(2131310673);
    if (paramBoolean)
    {
      localLinearLayout.setVisibility(0);
      localTextView.setText(ajjy.a(2131647108));
      return;
    }
    localLinearLayout.setVisibility(8);
    localTextView.setText(ajjy.a(2131647307));
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
      if ((azzu.b()) || (azzu.d())) {
        break label151;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130848260);
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
      if ((Build.VERSION.SDK_INT >= 23) && (!azzu.b()) && (!azzu.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!azzu.d())
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
    setContentView(2131494453);
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
    if ((this.jdField_a_of_type_Begr != null) && (this.jdField_a_of_type_Begr.isShowing()))
    {
      this.jdField_a_of_type_Begr.dismiss();
      this.jdField_a_of_type_Begr = null;
    }
    if ((this.jdField_b_of_type_Begr != null) && (this.jdField_b_of_type_Begr.isShowing()))
    {
      this.jdField_b_of_type_Begr.dismiss();
      this.jdField_b_of_type_Begr = null;
    }
    if ((this.jdField_c_of_type_Begr != null) && (this.jdField_c_of_type_Begr.isShowing()))
    {
      this.jdField_c_of_type_Begr.dismiss();
      this.jdField_c_of_type_Begr = null;
    }
    super.doOnDestroy();
    this.jdField_a_of_type_Bbms = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajpe);
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
    case 2131302609: 
      this.jdField_i_of_type_Boolean = true;
      bgmq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      nji.a(this);
      ndn.a(null, "CliOper", "", "", "0X80067D8", "0X80067D8", 0, 0, "", "", "", obz.c(), false);
      return;
    case 2131313238: 
      this.jdField_c_of_type_Begr.show();
      return;
    }
    nji.a(this.mContentView.getContext(), 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity
 * JD-Core Version:    0.7.0.1
 */