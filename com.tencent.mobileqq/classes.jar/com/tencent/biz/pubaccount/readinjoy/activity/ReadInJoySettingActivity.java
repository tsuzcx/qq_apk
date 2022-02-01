package com.tencent.biz.pubaccount.readinjoy.activity;

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
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtReportHelper;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyDailySettingFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyProteusFamilyFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.biz.pubaccount.util.ReadInJoyUserDataUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil.PublicAccountConfigFolder;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mp.mobileqq_mp.SetMessageConfigurationRequest;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Calendar;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.ReqBody;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.SetFlagInfoReq;
import tencent.kandian.flaginfo.flag_info.FlagInfo;

public class ReadInJoySettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String a;
  protected int a;
  public Context a;
  private DialogInterface.OnKeyListener jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener = new ReadInJoySettingActivity.20(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  public Resources a;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianMergeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  private PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new ReadInJoySettingActivity.12(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  Calendar jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
  protected boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  protected int b;
  private View jdField_b_of_type_AndroidViewView;
  private ActionSheet jdField_b_of_type_ComTencentWidgetActionSheet;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  private String jdField_b_of_type_JavaLangString = "QQ看点";
  protected boolean b;
  private int jdField_c_of_type_Int = 2;
  private ActionSheet jdField_c_of_type_ComTencentWidgetActionSheet;
  private Switch jdField_c_of_type_ComTencentWidgetSwitch;
  private final String jdField_c_of_type_JavaLangString = HardCodeUtil.a(2131713065);
  protected boolean c;
  private Switch jdField_d_of_type_ComTencentWidgetSwitch;
  private final String jdField_d_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private Switch jdField_e_of_type_ComTencentWidgetSwitch;
  private final String jdField_e_of_type_JavaLangString = HardCodeUtil.a(2131712864);
  private boolean jdField_e_of_type_Boolean;
  private Switch jdField_f_of_type_ComTencentWidgetSwitch;
  private final String jdField_f_of_type_JavaLangString = HardCodeUtil.a(2131712821);
  private boolean jdField_f_of_type_Boolean;
  private final String jdField_g_of_type_JavaLangString = HardCodeUtil.a(2131712752);
  private boolean jdField_g_of_type_Boolean;
  private final String jdField_h_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private final String jdField_i_of_type_JavaLangString = HardCodeUtil.a(2131712732);
  private boolean jdField_i_of_type_Boolean;
  private final String jdField_j_of_type_JavaLangString = HardCodeUtil.a(2131712730);
  private boolean jdField_j_of_type_Boolean;
  private final String jdField_k_of_type_JavaLangString = HardCodeUtil.a(2131712878);
  private boolean jdField_k_of_type_Boolean;
  private final String l = "https://kandian.qq.com/mqq/vue/configPush?_wv=3&x5PreFetch=1&_bid=2378";
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.NEW_KANDIAN_UIN;
  }
  
  public ReadInJoySettingActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private Drawable a()
  {
    IPublicAccountConfigUtil.PublicAccountConfigFolder localPublicAccountConfigFolder = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getFolder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3);
    if ((localPublicAccountConfigFolder != null) && (localPublicAccountConfigFolder.a() != null)) {
      return localPublicAccountConfigFolder.a();
    }
    return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(this.jdField_a_of_type_AndroidContentContext, 3);
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
    if (this.jdField_c_of_type_ComTencentWidgetActionSheet != null) {
      return;
    }
    this.jdField_c_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    this.jdField_c_of_type_ComTencentWidgetActionSheet.addRadioButton(this.jdField_a_of_type_AndroidContentResResources.getString(2131699748), 5, false);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.addRadioButton(this.jdField_a_of_type_AndroidContentResResources.getString(2131699750), 5, false);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.addRadioButton(this.jdField_a_of_type_AndroidContentResResources.getString(2131699749), 5, false);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.setRadioButtonChecked(paramInt);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new ReadInJoySettingActivity.18(this));
    this.jdField_c_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ReadInJoySettingActivity.19(this));
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
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(localQQAppInterface, "", "0X800AB85", "0X800AB85", 0, 0, localJSONObject1.toString(), localJSONObject2.toString(), "", "");
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
      ProtoUtils.a((QQAppInterface)getAppInterface(), new ReadInJoySettingActivity.ChangeYoungsterModeCallback(this, paramBoolean), localReqBody.toByteArray(), "OidbSvc.0xe1b", 3611, 1);
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
    setTitle(HardCodeUtil.a(2131712755));
    this.leftView.setContentDescription(HardCodeUtil.a(2131712680));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c();
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d();
    this.jdField_f_of_type_Boolean = SettingCloneUtil.readValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", false);
    this.jdField_j_of_type_Boolean = ReadInJoyHelper.m();
    boolean bool;
    if (!ReadInJoyHelper.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      bool = true;
    }
    for (;;)
    {
      this.jdField_i_of_type_Boolean = bool;
      try
      {
        if (RIJAppSetting.a() != null) {
          this.jdField_c_of_type_Int = Integer.parseInt(RIJAppSetting.a());
        }
        label204:
        this.jdField_b_of_type_JavaLangString = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3);
        Object localObject = a();
        ((ImageView)findViewById(2131368603)).setImageDrawable((Drawable)localObject);
        localObject = (TextView)findViewById(2131372126);
        ((TextView)localObject).setText(this.jdField_b_of_type_JavaLangString);
        ((TextView)localObject).setContentDescription(this.jdField_b_of_type_JavaLangString);
        localObject = (TextView)findViewById(2131365695);
        ((TextView)localObject).setText(String.format(this.jdField_e_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        ((TextView)localObject).setContentDescription(String.format(this.jdField_e_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        g(this.jdField_i_of_type_Boolean);
        localObject = (TextView)findViewById(2131376710);
        ((TextView)localObject).setText(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        ((TextView)localObject).setContentDescription(String.format(this.jdField_d_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }));
        n();
        m();
        b(this.jdField_c_of_type_Int);
        e();
        f();
        this.jdField_e_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131381043));
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370695));
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        int m;
        if (Aladdin.getConfig(232).getIntegerFromString("user_data_switch_switch", 0) == 1)
        {
          m = 0;
          label470:
          ((LinearLayout)localObject).setVisibility(m);
          localObject = this.jdField_e_of_type_ComTencentWidgetSwitch;
          if (ReadInJoyUserDataUtils.a() != 0) {
            break label748;
          }
        }
        label748:
        for (bool = true;; bool = false)
        {
          ((Switch)localObject).setChecked(bool);
          this.jdField_e_of_type_ComTencentWidgetSwitch.setContentDescription(Aladdin.getConfig(232).getString("user_data_switch_content", getString(2131718428)));
          ((TextView)findViewById(2131380284)).setText(Aladdin.getConfig(232).getString("user_data_switch_content", getString(2131718428)));
          this.jdField_e_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new ReadInJoySettingActivity.1(this));
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800A80A", "0X800A80A", 0, 0, "", "", "", "", false);
          l();
          i();
          this.jdField_b_of_type_AndroidViewView = findViewById(2131369184);
          this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
          findViewById(2131381488).setOnClickListener(this);
          this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { this.jdField_a_of_type_AndroidContentResResources.getString(2131699748), this.jdField_a_of_type_AndroidContentResResources.getString(2131699750), this.jdField_a_of_type_AndroidContentResResources.getString(2131699749) };
          ((TextView)findViewById(2131373159)).setText(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int]);
          g();
          h();
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
          k();
          o();
          return;
          bool = false;
          break;
          m = 8;
          break label470;
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
    a(2131699734);
    NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
    localNewIntent.putExtra("cmd", "set_message_configuration");
    localNewIntent.putExtra("uin", 2171946401L);
    mobileqq_mp.SetMessageConfigurationRequest localSetMessageConfigurationRequest = new mobileqq_mp.SetMessageConfigurationRequest();
    localSetMessageConfigurationRequest.uin.set(2171946401L);
    if (paramBoolean) {
      localSetMessageConfigurationRequest.type.set(1);
    }
    for (;;)
    {
      localSetMessageConfigurationRequest.versionInfo.set(((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getVersionInfo());
      localNewIntent.putExtra("data", localSetMessageConfigurationRequest.toByteArray());
      localNewIntent.putExtra("kandian_seq", this.jdField_b_of_type_Int);
      ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).configNeedHandler(localNewIntent);
      this.jdField_a_of_type_Int += 1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return;
      localSetMessageConfigurationRequest.type.set(2);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(new ReadInJoySettingActivity.2(this));
  }
  
  private void e(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80067D7", "0X80067D7", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
    }
    SettingCloneUtil.writeValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", paramBoolean);
  }
  
  private void f()
  {
    this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131373161));
    this.jdField_b_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_f_of_type_Boolean);
    this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new ReadInJoySettingActivity.3(this));
  }
  
  private void f(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      ReadInJoyHelper.a(localQQAppInterface, bool);
      this.jdField_d_of_type_Boolean = paramBoolean;
      d(this.jdField_d_of_type_Boolean);
      if (!paramBoolean) {
        break;
      }
      g(paramBoolean);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_d_of_type_Boolean);
      ReportController.b(null, "CliOper", "", "", "0X80067FA", "0X80067FA", 0, 0, "", "", "", "");
      return;
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80067F9", "0X80067F9", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80067F9", "", "", "", "", RIJTransMergeKanDianReport.a());
    g(paramBoolean);
  }
  
  private void g()
  {
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131374494);
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
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131377898);
    TextView localTextView = (TextView)findViewById(2131378450);
    if (paramBoolean)
    {
      localLinearLayout.setVisibility(0);
      localTextView.setText(HardCodeUtil.a(2131712867));
      return;
    }
    localLinearLayout.setVisibility(8);
    localTextView.setText(HardCodeUtil.a(2131713056));
  }
  
  private void h()
  {
    if (ReadInJoyHelper.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      localObject = findViewById(2131376595);
      ((View)localObject).setVisibility(0);
      ((View)localObject).setOnClickListener(new ReadInJoySettingActivity.4(this));
      return;
    }
    findViewById(2131376709).setVisibility(0);
    Object localObject = (TextView)findViewById(2131376712);
    ((TextView)localObject).setText(this.jdField_f_of_type_JavaLangString);
    ((TextView)localObject).setContentDescription(this.jdField_f_of_type_JavaLangString);
    j();
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369932));
    this.jdField_d_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131378070));
    this.jdField_d_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_j_of_type_Boolean);
    this.jdField_d_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new ReadInJoySettingActivity.5(this));
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718386);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718389);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131369934));
    Switch localSwitch = this.jdField_a_of_type_ComTencentWidgetSwitch;
    if (!this.jdField_d_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localSwitch.setChecked(bool);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new ReadInJoySettingActivity.6(this));
      return;
    }
  }
  
  private void k()
  {
    View localView1 = findViewById(2131361804);
    View localView2 = findViewById(2131366382);
    View localView3 = findViewById(2131372553);
    View localView4 = findViewById(2131365524);
    View localView5 = findViewById(2131362701);
    View localView6 = findViewById(2131378733);
    View localView7 = findViewById(2131366019);
    View localView8 = findViewById(2131366985);
    localView1.setVisibility(8);
    localView2.setVisibility(8);
    localView3.setVisibility(8);
    localView4.setVisibility(8);
    localView5.setVisibility(8);
    localView6.setVisibility(8);
    localView7.setVisibility(8);
    localView8.setVisibility(8);
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new ReadInJoySettingActivity.11(this);
    if (((Integer)ReadInJoyHelper.a("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_g_of_type_Boolean = bool;
      this.jdField_h_of_type_Boolean = this.jdField_g_of_type_Boolean;
      this.jdField_c_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131382110));
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
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      return;
    }
    String str = String.format(this.jdField_c_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setMainTitle(str);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(this.jdField_h_of_type_JavaLangString, 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new ReadInJoySettingActivity.14(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ReadInJoySettingActivity.15(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnKeyListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener);
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "showEnableActionSheet");
    }
    if (this.jdField_b_of_type_ComTencentWidgetActionSheet != null) {
      return;
    }
    String str = String.format(this.jdField_k_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString });
    this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    this.jdField_b_of_type_ComTencentWidgetActionSheet.setMainTitle(str);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.addButton(String.format(this.jdField_j_of_type_JavaLangString, new Object[] { this.jdField_b_of_type_JavaLangString }), 3);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new ReadInJoySettingActivity.16(this));
    this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ReadInJoySettingActivity.17(this));
  }
  
  private void o()
  {
    this.jdField_f_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131365099));
    p();
    this.jdField_f_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new ReadInJoySettingActivity.21(this));
  }
  
  private void p()
  {
    boolean bool = ReadInJoyHelper.H();
    this.jdField_f_of_type_ComTencentWidgetSwitch.setChecked(bool);
  }
  
  public void a()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label172;
      }
      if ((SystemUtil.b()) || (SystemUtil.d())) {
        break label151;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130849916);
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
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!SystemUtil.d())
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
    this.jdField_b_of_type_AndroidViewView.postDelayed(new ReadInJoySettingActivity.13(this, paramInt), 500L);
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
    RIJDtReportHelper.a.a(getActivity(), "44");
    setContentView(2131560396);
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
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    }
    if ((this.jdField_b_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_b_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      this.jdField_b_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_b_of_type_ComTencentWidgetActionSheet = null;
    }
    if ((this.jdField_c_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_c_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      this.jdField_c_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_c_of_type_ComTencentWidgetActionSheet = null;
    }
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_g_of_type_Boolean != this.jdField_h_of_type_Boolean) {
      ReadInJoyHelper.a("key_sp_is_readinjoy_youngster_changed", Boolean.valueOf(true));
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
      ReadInJoyHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ReadInJoyActivityHelper.a(this);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80067D8", "0X80067D8", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
      continue;
      this.jdField_c_of_type_ComTencentWidgetActionSheet.show();
      continue;
      c();
      continue;
      ReadInJoySelfActivity.a(this);
      continue;
      ViolaAccessHelper.a(this.mContentView.getContext(), "viola测试页面", "https://kandian.qq.com/viola/bundle_home.js?v_bid=3256&statusColor=1", null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity
 * JD-Core Version:    0.7.0.1
 */