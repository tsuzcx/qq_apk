package com.tencent.biz.pubaccount.readinjoy.activity;

import Override;
import amtj;
import amyh;
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
import bcef;
import bhht;
import bjnw;
import bjon;
import bkwm;
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
import com.tencent.mobileqq.app.AppConstants;
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
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Calendar;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import nmb;
import odq;
import odw;
import okj;
import omk;
import oml;
import omm;
import omn;
import omo;
import omp;
import omq;
import omr;
import oms;
import omt;
import omu;
import omv;
import omw;
import omx;
import omy;
import omz;
import ona;
import org.json.JSONException;
import org.json.JSONObject;
import pay;
import pim;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.ReqBody;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.SetFlagInfoReq;
import tencent.kandian.flaginfo.flag_info.FlagInfo;
import tgc;
import uex;
import uey;
import ugf;
import uhh;

public class ReadInJoySettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String a;
  public int a;
  private amyh jdField_a_of_type_Amyh = new oml(this);
  public Context a;
  private DialogInterface.OnKeyListener jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener = new oms(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  public Resources a;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public bhht a;
  private bjnw jdField_a_of_type_Bjnw;
  private KandianMergeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  public QQAppInterface a;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  Calendar jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
  public boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  public int b;
  private View jdField_b_of_type_AndroidViewView;
  private bjnw jdField_b_of_type_Bjnw;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  private String jdField_b_of_type_JavaLangString = "QQ看点";
  protected boolean b;
  private int jdField_c_of_type_Int = 2;
  private bjnw jdField_c_of_type_Bjnw;
  private Switch jdField_c_of_type_ComTencentWidgetSwitch;
  private final String jdField_c_of_type_JavaLangString = amtj.a(2131712221);
  public boolean c;
  private Switch jdField_d_of_type_ComTencentWidgetSwitch;
  private final String jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private Switch jdField_e_of_type_ComTencentWidgetSwitch;
  private final String jdField_e_of_type_JavaLangString = amtj.a(2131712008);
  private boolean jdField_e_of_type_Boolean;
  private Switch jdField_f_of_type_ComTencentWidgetSwitch;
  private final String jdField_f_of_type_JavaLangString = amtj.a(2131711962);
  private boolean jdField_f_of_type_Boolean;
  private final String jdField_g_of_type_JavaLangString = amtj.a(2131711893);
  private boolean jdField_g_of_type_Boolean;
  private final String jdField_h_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private final String jdField_i_of_type_JavaLangString = amtj.a(2131711873);
  private boolean jdField_i_of_type_Boolean;
  private final String jdField_j_of_type_JavaLangString = amtj.a(2131711871);
  private boolean jdField_j_of_type_Boolean;
  private final String jdField_k_of_type_JavaLangString = amtj.a(2131712022);
  private boolean jdField_k_of_type_Boolean;
  private final String l = "https://kandian.qq.com/mqq/vue/configPush?_wv=3&x5PreFetch=1&_bid=2378";
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.NEW_KANDIAN_UIN;
  }
  
  public ReadInJoySettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private Drawable a()
  {
    uey localuey = uex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3);
    if ((localuey != null) && (localuey.a() != null)) {
      return localuey.a();
    }
    return uex.a(this.jdField_a_of_type_AndroidContentContext, 3);
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
    if (this.jdField_c_of_type_Bjnw != null) {
      return;
    }
    this.jdField_c_of_type_Bjnw = ((bjnw)bjon.a(this, null));
    this.jdField_c_of_type_Bjnw.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131698826), 5, false);
    this.jdField_c_of_type_Bjnw.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131698828), 5, false);
    this.jdField_c_of_type_Bjnw.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131698827), 5, false);
    this.jdField_c_of_type_Bjnw.d(paramInt);
    this.jdField_c_of_type_Bjnw.c(2131690620);
    this.jdField_c_of_type_Bjnw.a(new omq(this));
    this.jdField_c_of_type_Bjnw.a(new omr(this));
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
      odq.a(localQQAppInterface, "", "0X800AB85", "0X800AB85", 0, 0, localJSONObject1.toString(), localJSONObject2.toString(), "", "");
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
      nmb.a((QQAppInterface)getAppInterface(), new ona(this, paramBoolean), localReqBody.toByteArray(), "OidbSvc.0xe1b", 3611, 1);
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
    setTitle(amtj.a(2131711896));
    this.leftView.setContentDescription(amtj.a(2131711818));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c();
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d();
    this.jdField_f_of_type_Boolean = SettingCloneUtil.readValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", false);
    this.jdField_j_of_type_Boolean = bkwm.i();
    boolean bool;
    if (!bkwm.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      bool = true;
    }
    for (;;)
    {
      this.jdField_i_of_type_Boolean = bool;
      try
      {
        if (pay.e() != null) {
          this.jdField_c_of_type_Int = Integer.parseInt(pay.e());
        }
        label204:
        this.jdField_b_of_type_JavaLangString = uex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3);
        Object localObject = a();
        ((ImageView)findViewById(2131368236)).setImageDrawable((Drawable)localObject);
        localObject = (TextView)findViewById(2131371626);
        ((TextView)localObject).setText(this.jdField_b_of_type_JavaLangString);
        ((TextView)localObject).setContentDescription(this.jdField_b_of_type_JavaLangString);
        localObject = (TextView)findViewById(2131365441);
        ((TextView)localObject).setText(String.format(this.jdField_e_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        ((TextView)localObject).setContentDescription(String.format(this.jdField_e_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        g(this.jdField_i_of_type_Boolean);
        localObject = (TextView)findViewById(2131376068);
        ((TextView)localObject).setText(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        ((TextView)localObject).setContentDescription(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        n();
        m();
        b(this.jdField_c_of_type_Int);
        e();
        f();
        this.jdField_e_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131380263));
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370243));
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        int m;
        if (Aladdin.getConfig(232).getIntegerFromString("user_data_switch_switch", 0) == 1)
        {
          m = 0;
          label460:
          ((LinearLayout)localObject).setVisibility(m);
          localObject = this.jdField_e_of_type_ComTencentWidgetSwitch;
          if (uhh.a() != 0) {
            break label727;
          }
        }
        label727:
        for (bool = true;; bool = false)
        {
          ((Switch)localObject).setChecked(bool);
          this.jdField_e_of_type_ComTencentWidgetSwitch.setContentDescription(Aladdin.getConfig(232).getString("user_data_switch_content", getString(2131717570)));
          ((TextView)findViewById(2131379545)).setText(Aladdin.getConfig(232).getString("user_data_switch_content", getString(2131717570)));
          this.jdField_e_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new omk(this));
          odq.a(null, "", "0X800A80A", "0X800A80A", 0, 0, "", "", "", "", false);
          l();
          i();
          this.jdField_b_of_type_AndroidViewView = findViewById(2131368793);
          this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
          findViewById(2131380676).setOnClickListener(this);
          this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { this.jdField_a_of_type_AndroidContentResResources.getString(2131698826), this.jdField_a_of_type_AndroidContentResResources.getString(2131698828), this.jdField_a_of_type_AndroidContentResResources.getString(2131698827) };
          ((TextView)findViewById(2131372638)).setText(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int]);
          g();
          h();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amyh);
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
    a(2131698812);
    NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), odw.class);
    localNewIntent.putExtra("cmd", "set_message_configuration");
    localNewIntent.putExtra("uin", 2171946401L);
    mobileqq_mp.SetMessageConfigurationRequest localSetMessageConfigurationRequest = new mobileqq_mp.SetMessageConfigurationRequest();
    localSetMessageConfigurationRequest.uin.set(2171946401L);
    if (paramBoolean) {
      localSetMessageConfigurationRequest.type.set(1);
    }
    for (;;)
    {
      localSetMessageConfigurationRequest.versionInfo.set(ugf.a());
      localNewIntent.putExtra("data", localSetMessageConfigurationRequest.toByteArray());
      localNewIntent.putExtra("kandian_seq", this.jdField_b_of_type_Int);
      odw.a(localNewIntent);
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return;
      localSetMessageConfigurationRequest.type.set(2);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Bhht = new bhht(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Bhht.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_Bhht.a(new omu(this));
  }
  
  private void e(boolean paramBoolean)
  {
    if (paramBoolean) {
      odq.a(null, "CliOper", "", "", "0X80067D7", "0X80067D7", 0, 0, "", "", "", pay.f(), false);
    }
    SettingCloneUtil.writeValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", paramBoolean);
  }
  
  private void f()
  {
    this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131372640));
    this.jdField_b_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_f_of_type_Boolean);
    this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new omv(this));
  }
  
  private void f(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      bkwm.a(localQQAppInterface, bool);
      this.jdField_d_of_type_Boolean = paramBoolean;
      d(this.jdField_d_of_type_Boolean);
      if (!paramBoolean) {
        break;
      }
      g(paramBoolean);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_d_of_type_Boolean);
      bcef.b(null, "CliOper", "", "", "0X80067FA", "0X80067FA", 0, 0, "", "", "", "");
      return;
    }
    odq.a(null, "CliOper", "", "", "0X80067F9", "0X80067F9", 0, 0, "", "", "", pay.f(), false);
    odq.a("0X80067F9", "", "", "", "", pay.f());
    g(paramBoolean);
  }
  
  private void g()
  {
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131373946);
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
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131377207);
    TextView localTextView = (TextView)findViewById(2131377748);
    if (paramBoolean)
    {
      localLinearLayout.setVisibility(0);
      localTextView.setText(amtj.a(2131712011));
      return;
    }
    localLinearLayout.setVisibility(8);
    localTextView.setText(amtj.a(2131712210));
  }
  
  private void h()
  {
    if (bkwm.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localObject = findViewById(2131375959);
      ((View)localObject).setVisibility(0);
      ((View)localObject).setOnClickListener(new omw(this));
      return;
    }
    findViewById(2131376067).setVisibility(0);
    Object localObject = (TextView)findViewById(2131376070);
    ((TextView)localObject).setText(this.jdField_f_of_type_JavaLangString);
    ((TextView)localObject).setContentDescription(this.jdField_f_of_type_JavaLangString);
    j();
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369491));
    this.jdField_d_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131377386));
    this.jdField_d_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_j_of_type_Boolean);
    this.jdField_d_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new omx(this));
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717528);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717531);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131369493));
    Switch localSwitch = this.jdField_a_of_type_ComTencentWidgetSwitch;
    if (!this.jdField_d_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localSwitch.setChecked(bool);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new omy(this));
      return;
    }
  }
  
  private void k()
  {
    View localView1 = findViewById(2131361803);
    View localView2 = findViewById(2131366108);
    View localView3 = findViewById(2131372056);
    View localView4 = findViewById(2131365280);
    View localView5 = findViewById(2131362662);
    View localView6 = findViewById(2131378019);
    localView1.setVisibility(8);
    localView2.setVisibility(8);
    localView3.setVisibility(8);
    localView4.setVisibility(8);
    localView5.setVisibility(8);
    localView6.setVisibility(8);
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new omz(this);
    if (((Integer)bkwm.a("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_g_of_type_Boolean = bool;
      this.jdField_h_of_type_Boolean = this.jdField_g_of_type_Boolean;
      this.jdField_c_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131381282));
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
    if (this.jdField_a_of_type_Bjnw != null) {
      return;
    }
    String str = String.format(this.jdField_c_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_Bjnw = ((bjnw)bjon.a(this, null));
    this.jdField_a_of_type_Bjnw.a(str);
    this.jdField_a_of_type_Bjnw.a(this.jdField_h_of_type_JavaLangString, 3);
    this.jdField_a_of_type_Bjnw.c(2131690620);
    this.jdField_a_of_type_Bjnw.a(new omm(this));
    this.jdField_a_of_type_Bjnw.a(new omn(this));
    this.jdField_a_of_type_Bjnw.setOnKeyListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener);
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "showEnableActionSheet");
    }
    if (this.jdField_b_of_type_Bjnw != null) {
      return;
    }
    String str = String.format(this.jdField_k_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString });
    this.jdField_b_of_type_Bjnw = ((bjnw)bjon.a(this, null));
    this.jdField_b_of_type_Bjnw.a(str);
    this.jdField_b_of_type_Bjnw.a(String.format(this.jdField_j_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }), 3);
    this.jdField_b_of_type_Bjnw.c(2131690620);
    this.jdField_b_of_type_Bjnw.a(new omo(this));
    this.jdField_b_of_type_Bjnw.a(new omp(this));
  }
  
  private void o()
  {
    this.jdField_f_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131364876));
    p();
    this.jdField_f_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new omt(this));
  }
  
  private void p()
  {
    boolean bool = bkwm.E();
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
      if ((SystemUtil.isMIUI()) || (SystemUtil.isFlyme())) {
        break label151;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130849445);
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
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.isMIUI()) && (!SystemUtil.isFlyme()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!SystemUtil.isFlyme())
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
    this.jdField_b_of_type_AndroidViewView.postDelayed(new ReadInJoySettingActivity.11(this, paramInt), 500L);
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
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    pim.a.a(getActivity(), "44");
    setContentView(2131560281);
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
    if ((this.jdField_a_of_type_Bjnw != null) && (this.jdField_a_of_type_Bjnw.isShowing()))
    {
      this.jdField_a_of_type_Bjnw.dismiss();
      this.jdField_a_of_type_Bjnw = null;
    }
    if ((this.jdField_b_of_type_Bjnw != null) && (this.jdField_b_of_type_Bjnw.isShowing()))
    {
      this.jdField_b_of_type_Bjnw.dismiss();
      this.jdField_b_of_type_Bjnw = null;
    }
    if ((this.jdField_c_of_type_Bjnw != null) && (this.jdField_c_of_type_Bjnw.isShowing()))
    {
      this.jdField_c_of_type_Bjnw.dismiss();
      this.jdField_c_of_type_Bjnw = null;
    }
    super.doOnDestroy();
    this.jdField_a_of_type_Bhht = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amyh);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_g_of_type_Boolean != this.jdField_h_of_type_Boolean) {
      bkwm.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(true));
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
      bkwm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      okj.a(this);
      odq.a(null, "CliOper", "", "", "0X80067D8", "0X80067D8", 0, 0, "", "", "", pay.f(), false);
      continue;
      this.jdField_c_of_type_Bjnw.show();
      continue;
      c();
      continue;
      ReadInJoySelfFragment.a(this);
      continue;
      tgc.a(this.mContentView.getContext(), "viola测试页面", "https://kandian.qq.com/viola/bundle_home.js?v_bid=3256&statusColor=1", null);
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