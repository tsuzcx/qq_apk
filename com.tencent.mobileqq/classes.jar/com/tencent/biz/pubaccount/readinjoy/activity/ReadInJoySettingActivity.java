package com.tencent.biz.pubaccount.readinjoy.activity;

import alof;
import alud;
import alzr;
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
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import azqs;
import bdep;
import bety;
import bhuf;
import bhus;
import bkbq;
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
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Calendar;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mzy;
import nrt;
import nrz;
import nxu;
import nzu;
import nzv;
import nzw;
import nzx;
import nzy;
import nzz;
import oaa;
import oab;
import oac;
import oad;
import oae;
import oaf;
import oag;
import oah;
import oai;
import oaj;
import ors;
import swy;
import swz;
import syb;
import syz;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.ReqBody;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.SetFlagInfoReq;
import tencent.kandian.flaginfo.flag_info.FlagInfo;

public class ReadInJoySettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String a;
  public int a;
  private alzr jdField_a_of_type_Alzr = new oai(this);
  public Context a;
  private DialogInterface.OnKeyListener jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener = new oab(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  public Resources a;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public bety a;
  private bhuf jdField_a_of_type_Bhuf;
  private KandianMergeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  public QQAppInterface a;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  Calendar jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
  public boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  public int b;
  private View jdField_b_of_type_AndroidViewView;
  private bhuf jdField_b_of_type_Bhuf;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  private String jdField_b_of_type_JavaLangString = "QQ看点";
  protected boolean b;
  private int jdField_c_of_type_Int = 2;
  private View jdField_c_of_type_AndroidViewView;
  private bhuf jdField_c_of_type_Bhuf;
  private Switch jdField_c_of_type_ComTencentWidgetSwitch;
  private final String jdField_c_of_type_JavaLangString = alud.a(2131713501);
  public boolean c;
  private Switch jdField_d_of_type_ComTencentWidgetSwitch;
  private final String jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private Switch jdField_e_of_type_ComTencentWidgetSwitch;
  private final String jdField_e_of_type_JavaLangString = alud.a(2131713288);
  private boolean jdField_e_of_type_Boolean;
  private final String jdField_f_of_type_JavaLangString = alud.a(2131713242);
  private boolean jdField_f_of_type_Boolean;
  private final String jdField_g_of_type_JavaLangString = alud.a(2131713173);
  private boolean jdField_g_of_type_Boolean;
  private final String jdField_h_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private final String jdField_i_of_type_JavaLangString = alud.a(2131713153);
  private boolean jdField_i_of_type_Boolean;
  private final String jdField_j_of_type_JavaLangString = alud.a(2131713151);
  private boolean jdField_j_of_type_Boolean;
  private final String jdField_k_of_type_JavaLangString = alud.a(2131713302);
  private boolean jdField_k_of_type_Boolean;
  private final String l = "https://kandian.qq.com/mqq/vue/configPush?_wv=3&x5PreFetch=1&_bid=2378";
  
  static
  {
    jdField_a_of_type_JavaLangString = alof.az;
  }
  
  public ReadInJoySettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private Drawable a()
  {
    swz localswz = swy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3);
    if ((localswz != null) && (localswz.a() != null)) {
      return localswz.a();
    }
    return swy.a(this.jdField_a_of_type_AndroidContentContext, 3);
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
    setTitle(alud.a(2131713176));
    this.leftView.setContentDescription(alud.a(2131713098));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c();
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d();
    this.jdField_f_of_type_Boolean = SettingCloneUtil.readValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", false);
    this.jdField_j_of_type_Boolean = bkbq.i();
    boolean bool1;
    if (!bkbq.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      bool1 = true;
    }
    for (;;)
    {
      this.jdField_i_of_type_Boolean = bool1;
      try
      {
        if (ors.b() != null) {
          this.jdField_c_of_type_Int = Integer.parseInt(ors.b());
        }
        label203:
        this.jdField_b_of_type_JavaLangString = swy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3);
        Object localObject = a();
        ((ImageView)findViewById(2131367819)).setImageDrawable((Drawable)localObject);
        localObject = (TextView)findViewById(2131370989);
        ((TextView)localObject).setText(this.jdField_b_of_type_JavaLangString);
        ((TextView)localObject).setContentDescription(this.jdField_b_of_type_JavaLangString);
        localObject = (TextView)findViewById(2131365125);
        ((TextView)localObject).setText(String.format(this.jdField_e_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        ((TextView)localObject).setContentDescription(String.format(this.jdField_e_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        f(this.jdField_i_of_type_Boolean);
        localObject = (TextView)findViewById(2131375440);
        ((TextView)localObject).setText(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        ((TextView)localObject).setContentDescription(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        e();
        d();
        b(this.jdField_c_of_type_Int);
        this.jdField_a_of_type_Bety = new bety(this, super.getTitleBarHeight());
        this.jdField_a_of_type_Bety.setCanceledOnTouchOutside(true);
        this.jdField_a_of_type_Bety.a(new nzu(this));
        this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131371990));
        this.jdField_b_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_f_of_type_Boolean);
        this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new oac(this));
        this.jdField_e_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131379427));
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131369744));
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        int m;
        if (Aladdin.getConfig(232).getIntegerFromString("user_data_switch_switch", 0) == 1)
        {
          m = 0;
          label542:
          ((LinearLayout)localObject).setVisibility(m);
          localObject = this.jdField_e_of_type_ComTencentWidgetSwitch;
          if (syz.a() != 0) {
            break label961;
          }
          bool1 = true;
          label562:
          ((Switch)localObject).setChecked(bool1);
          this.jdField_e_of_type_ComTencentWidgetSwitch.setContentDescription(Aladdin.getConfig(232).getString("user_data_switch_content", getString(2131719090)));
          ((TextView)findViewById(2131378723)).setText(Aladdin.getConfig(232).getString("user_data_switch_content", getString(2131719090)));
          this.jdField_e_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new oad(this));
          nrt.a(null, "", "0X800A80A", "0X800A80A", 0, 0, "", "", "", "", false);
          c();
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369030));
          this.jdField_d_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131376661));
          this.jdField_d_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_j_of_type_Boolean);
          this.jdField_d_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new oae(this));
          if (!this.jdField_j_of_type_Boolean) {
            break label966;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719050);
          label744:
          this.jdField_b_of_type_AndroidViewView = findViewById(2131368388);
          this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_c_of_type_AndroidViewView = findViewById(2131376818);
          this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
          findViewById(2131379815).setOnClickListener(this);
          this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { this.jdField_a_of_type_AndroidContentResResources.getString(2131700058), this.jdField_a_of_type_AndroidContentResResources.getString(2131700060), this.jdField_a_of_type_AndroidContentResResources.getString(2131700059) };
          ((TextView)findViewById(2131371988)).setText(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int]);
          bool1 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.jdField_a_of_type_AndroidViewView = findViewById(2131373361);
          if (!bool1) {
            break label979;
          }
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          }
        }
        for (;;)
        {
          if (!bkbq.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label998;
          }
          localObject = findViewById(2131375330);
          ((View)localObject).setVisibility(0);
          ((View)localObject).setOnClickListener(new oaf(this));
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alzr);
          return;
          bool1 = false;
          break;
          m = 8;
          break label542;
          label961:
          bool1 = false;
          break label562;
          label966:
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719053);
          break label744;
          label979:
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          }
        }
        label998:
        findViewById(2131375439).setVisibility(0);
        localObject = (TextView)findViewById(2131375442);
        ((TextView)localObject).setText(this.jdField_f_of_type_JavaLangString);
        ((TextView)localObject).setContentDescription(this.jdField_f_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131369032));
        localObject = this.jdField_a_of_type_ComTencentWidgetSwitch;
        if (!this.jdField_d_of_type_Boolean) {}
        for (bool1 = bool2;; bool1 = false)
        {
          ((Switch)localObject).setChecked(bool1);
          this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new oag(this));
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
    if (this.jdField_c_of_type_Bhuf != null) {
      return;
    }
    this.jdField_c_of_type_Bhuf = ((bhuf)bhus.a(this, null));
    this.jdField_c_of_type_Bhuf.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131700058), 5, false);
    this.jdField_c_of_type_Bhuf.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131700060), 5, false);
    this.jdField_c_of_type_Bhuf.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131700059), 5, false);
    this.jdField_c_of_type_Bhuf.d(paramInt);
    this.jdField_c_of_type_Bhuf.c(2131690648);
    this.jdField_c_of_type_Bhuf.a(new nzz(this));
    this.jdField_c_of_type_Bhuf.a(new oaa(this));
  }
  
  private void b(boolean paramBoolean)
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
      mzy.a((QQAppInterface)getAppInterface(), new oaj(this, paramBoolean), localReqBody.toByteArray(), "OidbSvc.0xe1b", 3611, 1);
      return;
      localFlagInfo.uint32_teenager_flag.set(0);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new oah(this);
    if (((Integer)bkbq.a("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_g_of_type_Boolean = bool;
      this.jdField_h_of_type_Boolean = this.jdField_g_of_type_Boolean;
      this.jdField_c_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131380371));
      this.jdField_c_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_g_of_type_Boolean);
      this.jdField_c_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
      return;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Int += 1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = true;
    a(2131700043);
    NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), nrz.class);
    localNewIntent.putExtra("cmd", "set_message_configuration");
    localNewIntent.putExtra("uin", 2171946401L);
    mobileqq_mp.SetMessageConfigurationRequest localSetMessageConfigurationRequest = new mobileqq_mp.SetMessageConfigurationRequest();
    localSetMessageConfigurationRequest.uin.set(2171946401L);
    if (paramBoolean) {
      localSetMessageConfigurationRequest.type.set(1);
    }
    for (;;)
    {
      localSetMessageConfigurationRequest.versionInfo.set(syb.a());
      localNewIntent.putExtra("data", localSetMessageConfigurationRequest.toByteArray());
      localNewIntent.putExtra("kandian_seq", this.jdField_b_of_type_Int);
      nrz.a(localNewIntent);
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return;
      localSetMessageConfigurationRequest.type.set(2);
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "showConfirmDialog");
    }
    if (this.jdField_a_of_type_Bhuf != null) {
      return;
    }
    String str = String.format(this.jdField_c_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_Bhuf = ((bhuf)bhus.a(this, null));
    this.jdField_a_of_type_Bhuf.a(str);
    this.jdField_a_of_type_Bhuf.a(this.jdField_h_of_type_JavaLangString, 3);
    this.jdField_a_of_type_Bhuf.c(2131690648);
    this.jdField_a_of_type_Bhuf.a(new nzv(this));
    this.jdField_a_of_type_Bhuf.a(new nzw(this));
    this.jdField_a_of_type_Bhuf.setOnKeyListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener);
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      nrt.a(null, "CliOper", "", "", "0X80067D7", "0X80067D7", 0, 0, "", "", "", ors.c(), false);
    }
    SettingCloneUtil.writeValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", paramBoolean);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "showEnableActionSheet");
    }
    if (this.jdField_b_of_type_Bhuf != null) {
      return;
    }
    String str = String.format(this.jdField_k_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString });
    this.jdField_b_of_type_Bhuf = ((bhuf)bhus.a(this, null));
    this.jdField_b_of_type_Bhuf.a(str);
    this.jdField_b_of_type_Bhuf.a(String.format(this.jdField_j_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }), 3);
    this.jdField_b_of_type_Bhuf.c(2131690648);
    this.jdField_b_of_type_Bhuf.a(new nzx(this));
    this.jdField_b_of_type_Bhuf.a(new nzy(this));
  }
  
  private void e(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      bkbq.a(localQQAppInterface, bool);
      this.jdField_d_of_type_Boolean = paramBoolean;
      c(this.jdField_d_of_type_Boolean);
      if (!paramBoolean) {
        break;
      }
      f(paramBoolean);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_d_of_type_Boolean);
      azqs.b(null, "CliOper", "", "", "0X80067FA", "0X80067FA", 0, 0, "", "", "", "");
      return;
    }
    nrt.a(null, "CliOper", "", "", "0X80067F9", "0X80067F9", 0, 0, "", "", "", ors.c(), false);
    nrt.a("0X80067F9", "", "", "", "", ors.c());
    f(paramBoolean);
  }
  
  private void f(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131376514);
    TextView localTextView = (TextView)findViewById(2131377022);
    if (paramBoolean)
    {
      localLinearLayout.setVisibility(0);
      localTextView.setText(alud.a(2131713291));
      return;
    }
    localLinearLayout.setVisibility(8);
    localTextView.setText(alud.a(2131713490));
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
      if ((bdep.b()) || (bdep.d())) {
        break label151;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130848998);
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
      if ((Build.VERSION.SDK_INT >= 23) && (!bdep.b()) && (!bdep.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!bdep.d())
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
    this.jdField_b_of_type_AndroidViewView.postDelayed(new ReadInJoySettingActivity.9(this, paramInt), 500L);
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
    setContentView(2131560119);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    b();
    if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      a();
    }
    this.jdField_k_of_type_Boolean = false;
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bhuf != null) && (this.jdField_a_of_type_Bhuf.isShowing()))
    {
      this.jdField_a_of_type_Bhuf.dismiss();
      this.jdField_a_of_type_Bhuf = null;
    }
    if ((this.jdField_b_of_type_Bhuf != null) && (this.jdField_b_of_type_Bhuf.isShowing()))
    {
      this.jdField_b_of_type_Bhuf.dismiss();
      this.jdField_b_of_type_Bhuf = null;
    }
    if ((this.jdField_c_of_type_Bhuf != null) && (this.jdField_c_of_type_Bhuf.isShowing()))
    {
      this.jdField_c_of_type_Bhuf.dismiss();
      this.jdField_c_of_type_Bhuf = null;
    }
    super.doOnDestroy();
    this.jdField_a_of_type_Bety = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alzr);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_g_of_type_Boolean != this.jdField_h_of_type_Boolean) {
      bkbq.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(true));
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
    default: 
      return;
    case 2131368388: 
      this.jdField_k_of_type_Boolean = true;
      bkbq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      nxu.a(this);
      nrt.a(null, "CliOper", "", "", "0X80067D8", "0X80067D8", 0, 0, "", "", "", ors.c(), false);
      return;
    case 2131379815: 
      this.jdField_c_of_type_Bhuf.show();
      return;
    }
    nxu.a(this.mContentView.getContext(), 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity
 * JD-Core Version:    0.7.0.1
 */