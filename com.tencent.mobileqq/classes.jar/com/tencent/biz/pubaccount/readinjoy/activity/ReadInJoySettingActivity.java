package com.tencent.biz.pubaccount.readinjoy.activity;

import Override;
import android.content.Context;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anhk;
import anni;
import anry;
import bcst;
import bgjq;
import biau;
import bkho;
import bkif;
import bmqa;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailySettingFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyProteusFamilyFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.SetMessageConfigurationRequest;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Calendar;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import nir;
import oat;
import oaz;
import ohp;
import ojr;
import ojs;
import ojt;
import oju;
import ojv;
import ojw;
import ojx;
import ojy;
import ojz;
import oka;
import okb;
import okc;
import okd;
import oke;
import okf;
import okg;
import okh;
import org.json.JSONException;
import org.json.JSONObject;
import pha;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.ReqBody;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.SetFlagInfoReq;
import tencent.kandian.flaginfo.flag_info.FlagInfo;
import tlg;
import tyg;
import tyh;
import tzo;
import uaq;

public class ReadInJoySettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String a;
  public int a;
  public Context a;
  private DialogInterface.OnKeyListener jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener = new ojy(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  public Resources a;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anry jdField_a_of_type_Anry = new okg(this);
  public biau a;
  private bkho jdField_a_of_type_Bkho;
  private KandianMergeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  public QQAppInterface a;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  Calendar jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
  public boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  public int b;
  private View jdField_b_of_type_AndroidViewView;
  private bkho jdField_b_of_type_Bkho;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  private String jdField_b_of_type_JavaLangString = "QQ看点";
  protected boolean b;
  private int jdField_c_of_type_Int = 2;
  private View jdField_c_of_type_AndroidViewView;
  private bkho jdField_c_of_type_Bkho;
  private Switch jdField_c_of_type_ComTencentWidgetSwitch;
  private final String jdField_c_of_type_JavaLangString = anni.a(2131711880);
  public boolean c;
  private Switch jdField_d_of_type_ComTencentWidgetSwitch;
  private final String jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private Switch jdField_e_of_type_ComTencentWidgetSwitch;
  private final String jdField_e_of_type_JavaLangString = anni.a(2131711667);
  private boolean jdField_e_of_type_Boolean;
  private Switch jdField_f_of_type_ComTencentWidgetSwitch;
  private final String jdField_f_of_type_JavaLangString = anni.a(2131711621);
  private boolean jdField_f_of_type_Boolean;
  private final String jdField_g_of_type_JavaLangString = anni.a(2131711552);
  private boolean jdField_g_of_type_Boolean;
  private final String jdField_h_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private final String jdField_i_of_type_JavaLangString = anni.a(2131711532);
  private boolean jdField_i_of_type_Boolean;
  private final String jdField_j_of_type_JavaLangString = anni.a(2131711530);
  private boolean jdField_j_of_type_Boolean;
  private final String jdField_k_of_type_JavaLangString = anni.a(2131711681);
  private boolean jdField_k_of_type_Boolean;
  private final String l = "https://kandian.qq.com/mqq/vue/configPush?_wv=3&x5PreFetch=1&_bid=2378";
  
  static
  {
    jdField_a_of_type_JavaLangString = anhk.az;
  }
  
  public ReadInJoySettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private Drawable a()
  {
    tyh localtyh = tyg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3);
    if ((localtyh != null) && (localtyh.a() != null)) {
      return localtyh.a();
    }
    return tyg.a(this.jdField_a_of_type_AndroidContentContext, 3);
  }
  
  private void b()
  {
    PublicFragmentActivity.a(getActivity(), ReadInJoyDailySettingFragment.class);
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "createVideoActionSheet");
    }
    if (this.jdField_c_of_type_Bkho != null) {
      return;
    }
    this.jdField_c_of_type_Bkho = ((bkho)bkif.a(this, null));
    this.jdField_c_of_type_Bkho.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131698484), 5, false);
    this.jdField_c_of_type_Bkho.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131698486), 5, false);
    this.jdField_c_of_type_Bkho.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131698485), 5, false);
    this.jdField_c_of_type_Bkho.d(paramInt);
    this.jdField_c_of_type_Bkho.c(2131690582);
    this.jdField_c_of_type_Bkho.a(new ojw(this));
    this.jdField_c_of_type_Bkho.a(new ojx(this));
  }
  
  private void b(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject1.put("uin", localQQAppInterface.getCurrentAccountUin());
        if (!paramBoolean) {
          continue;
        }
        m = 1;
        localJSONObject2.put("state", m);
      }
      catch (JSONException localJSONException)
      {
        int m;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ReadInJoySettingActivity", 2, "report youngster switch click" + localJSONException.toString());
        continue;
      }
      oat.a(localQQAppInterface, "", "0X800AB85", "0X800AB85", 0, 0, localJSONObject1.toString(), localJSONObject2.toString(), "", "");
      return;
      m = 0;
    }
  }
  
  private void c()
  {
    PublicFragmentActivity.a(getActivity(), ReadInJoyProteusFamilyFragment.class);
  }
  
  private void c(boolean paramBoolean)
  {
    QLog.e("ReadInJoySettingActivity", 2, "requestChangeYoungsterMode, value = " + paramBoolean);
    oidb_0xe1b.ReqBody localReqBody = new oidb_0xe1b.ReqBody();
    localReqBody.uint32_req_type.set(2);
    oidb_0xe1b.SetFlagInfoReq localSetFlagInfoReq = new oidb_0xe1b.SetFlagInfoReq();
    flag_info.FlagInfo localFlagInfo = new flag_info.FlagInfo();
    localFlagInfo.uint64_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    if (paramBoolean) {
      localFlagInfo.uint32_teenager_flag.set(1);
    }
    for (;;)
    {
      localSetFlagInfoReq.rpt_msg_flag_info_list.add(localFlagInfo);
      localReqBody.msg_set_flag_info_req.set(localSetFlagInfoReq);
      nir.a((QQAppInterface)getAppInterface(), new okh(this, paramBoolean), localReqBody.toByteArray(), "OidbSvc.0xe1b", 3611, 1);
      return;
      localFlagInfo.uint32_teenager_flag.set(0);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(new ReadInJoyNewFeedsTopGestureLayout(this));
    }
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources();
    setTitle(anni.a(2131711555));
    this.leftView.setContentDescription(anni.a(2131711477));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c();
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d();
    this.jdField_f_of_type_Boolean = SettingCloneUtil.readValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", false);
    this.jdField_j_of_type_Boolean = bmqa.h();
    boolean bool;
    if (!bmqa.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      bool = true;
    }
    for (;;)
    {
      this.jdField_i_of_type_Boolean = bool;
      try
      {
        if (pha.d() != null) {
          this.jdField_c_of_type_Int = Integer.parseInt(pha.d());
        }
        label204:
        this.jdField_b_of_type_JavaLangString = tyg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3);
        Object localObject = a();
        ((ImageView)findViewById(2131368138)).setImageDrawable((Drawable)localObject);
        localObject = (TextView)findViewById(2131371550);
        ((TextView)localObject).setText(this.jdField_b_of_type_JavaLangString);
        ((TextView)localObject).setContentDescription(this.jdField_b_of_type_JavaLangString);
        localObject = (TextView)findViewById(2131365365);
        ((TextView)localObject).setText(String.format(this.jdField_e_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        ((TextView)localObject).setContentDescription(String.format(this.jdField_e_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        g(this.jdField_i_of_type_Boolean);
        localObject = (TextView)findViewById(2131376162);
        ((TextView)localObject).setText(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        ((TextView)localObject).setContentDescription(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        n();
        m();
        b(this.jdField_c_of_type_Int);
        e();
        f();
        this.jdField_e_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131380353));
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370175));
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        int m;
        if (Aladdin.getConfig(232).getIntegerFromString("user_data_switch_switch", 0) == 1)
        {
          m = 0;
          label460:
          ((LinearLayout)localObject).setVisibility(m);
          localObject = this.jdField_e_of_type_ComTencentWidgetSwitch;
          if (uaq.a() != 0) {
            break label746;
          }
        }
        label746:
        for (bool = true;; bool = false)
        {
          ((Switch)localObject).setChecked(bool);
          this.jdField_e_of_type_ComTencentWidgetSwitch.setContentDescription(Aladdin.getConfig(232).getString("user_data_switch_content", getString(2131717222)));
          ((TextView)findViewById(2131379589)).setText(Aladdin.getConfig(232).getString("user_data_switch_content", getString(2131717222)));
          this.jdField_e_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new ojr(this));
          oat.a(null, "", "0X800A80A", "0X800A80A", 0, 0, "", "", "", "", false);
          l();
          i();
          this.jdField_b_of_type_AndroidViewView = findViewById(2131368694);
          this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_c_of_type_AndroidViewView = findViewById(2131377630);
          this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
          findViewById(2131380773).setOnClickListener(this);
          this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { this.jdField_a_of_type_AndroidContentResResources.getString(2131698484), this.jdField_a_of_type_AndroidContentResResources.getString(2131698486), this.jdField_a_of_type_AndroidContentResResources.getString(2131698485) };
          ((TextView)findViewById(2131372559)).setText(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int]);
          g();
          h();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anry);
          k();
          o();
          return;
          bool = false;
          break;
          m = 8;
          break label460;
        }
      }
      catch (Exception localException)
      {
        break label204;
      }
    }
  }
  
  private void d(boolean paramBoolean)
  {
    this.jdField_b_of_type_Int += 1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = true;
    a(2131698470);
    NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), oaz.class);
    localNewIntent.putExtra("cmd", "set_message_configuration");
    localNewIntent.putExtra("uin", 2171946401L);
    mobileqq_mp.SetMessageConfigurationRequest localSetMessageConfigurationRequest = new mobileqq_mp.SetMessageConfigurationRequest();
    localSetMessageConfigurationRequest.uin.set(2171946401L);
    if (paramBoolean) {
      localSetMessageConfigurationRequest.type.set(1);
    }
    for (;;)
    {
      localSetMessageConfigurationRequest.versionInfo.set(tzo.a());
      localNewIntent.putExtra("data", localSetMessageConfigurationRequest.toByteArray());
      localNewIntent.putExtra("kandian_seq", this.jdField_b_of_type_Int);
      oaz.a(localNewIntent);
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return;
      localSetMessageConfigurationRequest.type.set(2);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Biau = new biau(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Biau.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_Biau.a(new oka(this));
  }
  
  private void e(boolean paramBoolean)
  {
    if (paramBoolean) {
      oat.a(null, "CliOper", "", "", "0X80067D7", "0X80067D7", 0, 0, "", "", "", pha.e(), false);
    }
    SettingCloneUtil.writeValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", paramBoolean);
  }
  
  private void f()
  {
    this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131372561));
    this.jdField_b_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_f_of_type_Boolean);
    this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new okb(this));
  }
  
  private void f(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      bmqa.a(localQQAppInterface, bool);
      this.jdField_d_of_type_Boolean = paramBoolean;
      d(this.jdField_d_of_type_Boolean);
      if (!paramBoolean) {
        break;
      }
      g(paramBoolean);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_d_of_type_Boolean);
      bcst.b(null, "CliOper", "", "", "0X80067FA", "0X80067FA", 0, 0, "", "", "", "");
      return;
    }
    oat.a(null, "CliOper", "", "", "0X80067F9", "0X80067F9", 0, 0, "", "", "", pha.e(), false);
    oat.a("0X80067F9", "", "", "", "", pha.e());
    g(paramBoolean);
  }
  
  private void g()
  {
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131374062);
    if (bool) {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void g(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131377304);
    TextView localTextView = (TextView)findViewById(2131377826);
    if (paramBoolean)
    {
      localLinearLayout.setVisibility(0);
      localTextView.setText(anni.a(2131711670));
      return;
    }
    localLinearLayout.setVisibility(8);
    localTextView.setText(anni.a(2131711869));
  }
  
  private void h()
  {
    if (bmqa.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localObject = findViewById(2131376054);
      ((View)localObject).setVisibility(0);
      ((View)localObject).setOnClickListener(new okc(this));
      return;
    }
    findViewById(2131376161).setVisibility(0);
    Object localObject = (TextView)findViewById(2131376164);
    ((TextView)localObject).setText(this.jdField_f_of_type_JavaLangString);
    ((TextView)localObject).setContentDescription(this.jdField_f_of_type_JavaLangString);
    j();
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369416));
    this.jdField_d_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131377464));
    this.jdField_d_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_j_of_type_Boolean);
    this.jdField_d_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new okd(this));
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717180);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717183);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131369418));
    Switch localSwitch = this.jdField_a_of_type_ComTencentWidgetSwitch;
    if (!this.jdField_d_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localSwitch.setChecked(bool);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new oke(this));
      return;
    }
  }
  
  private void k()
  {
    View localView1 = findViewById(2131361803);
    View localView2 = findViewById(2131366032);
    View localView3 = findViewById(2131371977);
    View localView4 = findViewById(2131365211);
    View localView5 = findViewById(2131362643);
    localView1.setVisibility(8);
    localView2.setVisibility(8);
    localView3.setVisibility(8);
    localView4.setVisibility(8);
    localView5.setVisibility(8);
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new okf(this);
    if (((Integer)bmqa.a("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_g_of_type_Boolean = bool;
      this.jdField_h_of_type_Boolean = this.jdField_g_of_type_Boolean;
      this.jdField_c_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131381376));
      this.jdField_c_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_g_of_type_Boolean);
      this.jdField_c_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      return;
    }
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "showConfirmDialog");
    }
    if (this.jdField_a_of_type_Bkho != null) {
      return;
    }
    String str = String.format(this.jdField_c_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_Bkho = ((bkho)bkif.a(this, null));
    this.jdField_a_of_type_Bkho.a(str);
    this.jdField_a_of_type_Bkho.a(this.jdField_h_of_type_JavaLangString, 3);
    this.jdField_a_of_type_Bkho.c(2131690582);
    this.jdField_a_of_type_Bkho.a(new ojs(this));
    this.jdField_a_of_type_Bkho.a(new ojt(this));
    this.jdField_a_of_type_Bkho.setOnKeyListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener);
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "showEnableActionSheet");
    }
    if (this.jdField_b_of_type_Bkho != null) {
      return;
    }
    String str = String.format(this.jdField_k_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString });
    this.jdField_b_of_type_Bkho = ((bkho)bkif.a(this, null));
    this.jdField_b_of_type_Bkho.a(str);
    this.jdField_b_of_type_Bkho.a(String.format(this.jdField_j_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }), 3);
    this.jdField_b_of_type_Bkho.c(2131690582);
    this.jdField_b_of_type_Bkho.a(new oju(this));
    this.jdField_b_of_type_Bkho.a(new ojv(this));
  }
  
  private void o()
  {
    this.jdField_f_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131364801));
    p();
    this.jdField_f_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new ojz(this));
  }
  
  private void p()
  {
    boolean bool = bmqa.D();
    this.jdField_f_of_type_ComTencentWidgetSwitch.setChecked(bool);
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
      if ((bgjq.b()) || (bgjq.d())) {
        break label151;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130849526);
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
      if ((Build.VERSION.SDK_INT >= 23) && (!bgjq.b()) && (!bgjq.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!bgjq.d())
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
    this.jdField_b_of_type_AndroidViewView.postDelayed(new ReadInJoySettingActivity.10(this, paramInt), 500L);
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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131560262);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    d();
    if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      a();
    }
    this.jdField_k_of_type_Boolean = false;
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bkho != null) && (this.jdField_a_of_type_Bkho.isShowing()))
    {
      this.jdField_a_of_type_Bkho.dismiss();
      this.jdField_a_of_type_Bkho = null;
    }
    if ((this.jdField_b_of_type_Bkho != null) && (this.jdField_b_of_type_Bkho.isShowing()))
    {
      this.jdField_b_of_type_Bkho.dismiss();
      this.jdField_b_of_type_Bkho = null;
    }
    if ((this.jdField_c_of_type_Bkho != null) && (this.jdField_c_of_type_Bkho.isShowing()))
    {
      this.jdField_c_of_type_Bkho.dismiss();
      this.jdField_c_of_type_Bkho = null;
    }
    super.doOnDestroy();
    this.jdField_a_of_type_Biau = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anry);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_g_of_type_Boolean != this.jdField_h_of_type_Boolean) {
      bmqa.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(true));
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_k_of_type_Boolean)
    {
      QLog.d("ReadInJoySettingActivity", 1, "refresh channel list while leave interest label");
      this.jdField_k_of_type_Boolean = false;
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
      this.jdField_k_of_type_Boolean = true;
      bmqa.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ohp.a(this);
      oat.a(null, "CliOper", "", "", "0X80067D8", "0X80067D8", 0, 0, "", "", "", pha.e(), false);
      continue;
      this.jdField_c_of_type_Bkho.show();
      continue;
      ohp.a(this.mContentView.getContext(), 1);
      continue;
      c();
      continue;
      ReadInJoySelfFragment.a(this);
      continue;
      tlg.a(this.mContentView.getContext(), "viola测试页面", "https://kandian.qq.com/viola/bundle_home.js?v_bid=3256&statusColor=1", null);
      continue;
      b();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity
 * JD-Core Version:    0.7.0.1
 */