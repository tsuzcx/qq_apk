package com.tencent.biz.pubaccount.readinjoy.activity;

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
import com.tencent.biz.pubaccount.AccountDetail.view.ReadInJoyNewFeedsTopGestureLayout;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.PublicAccountConfigFolder;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.SetMessageConfigurationRequest;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Calendar;
import leg;
import leh;
import lei;
import lej;
import lek;
import lel;
import lem;
import len;
import leo;
import lep;
import leq;
import ler;
import les;
import let;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class ReadInJoySettingActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String a;
  public int a;
  public Context a;
  private DialogInterface.OnKeyListener jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener = new lep(this);
  Intent jdField_a_of_type_AndroidContentIntent;
  public Resources a;
  public Handler a;
  View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianMergeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  private PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new leh(this);
  public QQAppInterface a;
  public QQProgressDialog a;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  Calendar jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
  public boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  public int b;
  private View jdField_b_of_type_AndroidViewView;
  private ActionSheet jdField_b_of_type_ComTencentWidgetActionSheet;
  private Switch jdField_b_of_type_ComTencentWidgetSwitch;
  private String jdField_b_of_type_JavaLangString = "QQ看点";
  protected boolean b;
  private int jdField_c_of_type_Int = 2;
  private ActionSheet jdField_c_of_type_ComTencentWidgetActionSheet;
  private Switch jdField_c_of_type_ComTencentWidgetSwitch;
  private final String jdField_c_of_type_JavaLangString = "开启后，将不再收到除订阅内容以外的推送提醒";
  public boolean c;
  private final String jdField_d_of_type_JavaLangString = "开启后，将不再收到除订阅内容以外的推送提醒";
  private boolean jdField_d_of_type_Boolean;
  private final String jdField_e_of_type_JavaLangString = "根据你的兴趣爱好，为你推荐最想看的资讯：新闻时事、娱乐八卦、科技动漫、文化历史……你想看的，尽在%s。";
  private boolean jdField_e_of_type_Boolean;
  private final String jdField_f_of_type_JavaLangString = "仅接收我订阅内容的提醒";
  private boolean jdField_f_of_type_Boolean;
  private final String jdField_g_of_type_JavaLangString = "置顶%s";
  private boolean jdField_g_of_type_Boolean;
  private final String jdField_h_of_type_JavaLangString = "仅接收我订阅内容的提醒";
  private boolean jdField_h_of_type_Boolean;
  private final String jdField_i_of_type_JavaLangString = "启用%s";
  private boolean jdField_i_of_type_Boolean;
  private final String j = "停用%s";
  private final String k = "停用%s后将无法接收看点及订阅内容的消息及提醒";
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.ar;
  }
  
  public ReadInJoySettingActivity()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private Drawable a()
  {
    PublicAccountConfigUtil.PublicAccountConfigFolder localPublicAccountConfigFolder = PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3);
    if ((localPublicAccountConfigFolder != null) && (localPublicAccountConfigFolder.a() != null)) {
      return localPublicAccountConfigFolder.a();
    }
    return PublicAccountConfigUtil.a(this.jdField_a_of_type_AndroidContentContext, 3);
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
    setTitle("设置");
    this.leftView.setContentDescription("返回");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b();
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c();
    this.jdField_f_of_type_Boolean = SettingCloneUtil.readValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", false);
    this.jdField_h_of_type_Boolean = ReadInJoyHelper.f();
    boolean bool1;
    if (!ReadInJoyHelper.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      bool1 = true;
    }
    for (;;)
    {
      this.jdField_g_of_type_Boolean = bool1;
      try
      {
        if (ReadInJoyUtils.b() != null) {
          this.jdField_c_of_type_Int = Integer.parseInt(ReadInJoyUtils.b());
        }
        label197:
        this.jdField_b_of_type_JavaLangString = PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, 3);
        Object localObject = a();
        ((ImageView)findViewById(2131362719)).setImageDrawable((Drawable)localObject);
        localObject = (TextView)findViewById(2131365450);
        ((TextView)localObject).setText(this.jdField_b_of_type_JavaLangString);
        ((TextView)localObject).setContentDescription(this.jdField_b_of_type_JavaLangString);
        localObject = (TextView)findViewById(2131367299);
        ((TextView)localObject).setText(String.format("根据你的兴趣爱好，为你推荐最想看的资讯：新闻时事、娱乐八卦、科技动漫、文化历史……你想看的，尽在%s。", new Object[] { this.jdField_b_of_type_JavaLangString }));
        ((TextView)localObject).setContentDescription(String.format("根据你的兴趣爱好，为你推荐最想看的资讯：新闻时事、娱乐八卦、科技动漫、文化历史……你想看的，尽在%s。", new Object[] { this.jdField_b_of_type_JavaLangString }));
        e(this.jdField_g_of_type_Boolean);
        localObject = (TextView)findViewById(2131367309);
        ((TextView)localObject).setText(String.format("开启后，将不再收到除订阅内容以外的推送提醒", new Object[] { this.jdField_b_of_type_JavaLangString }));
        ((TextView)localObject).setContentDescription(String.format("开启后，将不再收到除订阅内容以外的推送提醒", new Object[] { this.jdField_b_of_type_JavaLangString }));
        d();
        c();
        b(this.jdField_c_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(new leg(this));
        this.jdField_b_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131367301));
        this.jdField_b_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_f_of_type_Boolean);
        this.jdField_b_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new leq(this));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363357));
        this.jdField_c_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131367314));
        this.jdField_c_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_h_of_type_Boolean);
        this.jdField_c_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new ler(this));
        if (this.jdField_h_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131433554);
          label535:
          this.jdField_b_of_type_AndroidViewView = findViewById(2131367300);
          this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
          findViewById(2131367302).setOnClickListener(this);
          this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { this.jdField_a_of_type_AndroidContentResResources.getString(2131428471), this.jdField_a_of_type_AndroidContentResResources.getString(2131428472), this.jdField_a_of_type_AndroidContentResResources.getString(2131428473) };
          ((TextView)findViewById(2131367303)).setText(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_c_of_type_Int]);
          bool1 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          this.jdField_a_of_type_AndroidViewView = findViewById(2131362703);
          if (!bool1) {
            break label737;
          }
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          }
        }
        for (;;)
        {
          if (!ReadInJoyHelper.f(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
            break label756;
          }
          localObject = findViewById(2131367312);
          ((View)localObject).setVisibility(0);
          ((View)localObject).setOnClickListener(new les(this));
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
          return;
          bool1 = false;
          break;
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131433553);
          break label535;
          label737:
          if (this.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          }
        }
        label756:
        findViewById(2131367306).setVisibility(0);
        localObject = (TextView)findViewById(2131367307);
        ((TextView)localObject).setText("仅接收我订阅内容的提醒");
        ((TextView)localObject).setContentDescription("仅接收我订阅内容的提醒");
        this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131367308));
        localObject = this.jdField_a_of_type_ComTencentWidgetSwitch;
        if (!this.jdField_d_of_type_Boolean) {}
        for (bool1 = bool2;; bool1 = false)
        {
          ((Switch)localObject).setChecked(bool1);
          this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new let(this));
          break;
        }
      }
      catch (Exception localException)
      {
        break label197;
      }
    }
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
    this.jdField_c_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131428471), 5, false);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131428472), 5, false);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_AndroidContentResResources.getString(2131428473), 5, false);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.d(paramInt);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.c(2131433015);
    this.jdField_c_of_type_ComTencentWidgetActionSheet.a(new len(this));
    this.jdField_c_of_type_ComTencentWidgetActionSheet.a(new leo(this));
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Int += 1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = true;
    a(2131428479);
    NewIntent localNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "set_message_configuration");
    mobileqq_mp.SetMessageConfigurationRequest localSetMessageConfigurationRequest = new mobileqq_mp.SetMessageConfigurationRequest();
    localSetMessageConfigurationRequest.uin.set(2171946401L);
    if (paramBoolean) {
      localSetMessageConfigurationRequest.type.set(1);
    }
    for (;;)
    {
      localSetMessageConfigurationRequest.versionInfo.set(PublicAccountUtil.a());
      localNewIntent.putExtra("data", localSetMessageConfigurationRequest.toByteArray());
      localNewIntent.putExtra("kandian_seq", this.jdField_b_of_type_Int);
      PublicAccountServlet.a(localNewIntent);
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
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      return;
    }
    String str = String.format("开启后，将不再收到除订阅内容以外的推送提醒", new Object[] { this.jdField_b_of_type_JavaLangString });
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(str);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a("仅接收我订阅内容的提醒", 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433015);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new lej(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new lek(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnKeyListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnKeyListener);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067D7", "0X80067D7", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
    }
    SettingCloneUtil.writeValue(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", paramBoolean);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoySettingActivity", 2, "showEnableActionSheet");
    }
    if (this.jdField_b_of_type_ComTencentWidgetActionSheet != null) {
      return;
    }
    String str = String.format("停用%s后将无法接收看点及订阅内容的消息及提醒", new Object[] { this.jdField_b_of_type_JavaLangString });
    this.jdField_b_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a(str);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a(String.format("停用%s", new Object[] { this.jdField_b_of_type_JavaLangString }), 3);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.c(2131433015);
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new lel(this));
    this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new lem(this));
  }
  
  private void d(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      ReadInJoyHelper.a(localQQAppInterface, bool);
      this.jdField_d_of_type_Boolean = paramBoolean;
      b(this.jdField_d_of_type_Boolean);
      if (!paramBoolean) {
        break;
      }
      e(paramBoolean);
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.jdField_d_of_type_Boolean);
      ReportController.b(null, "CliOper", "", "", "0X80067FA", "0X80067FA", 0, 0, "", "", "", "");
      return;
    }
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067F9", "0X80067F9", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
    PublicAccountReportUtils.a("0X80067F9", "", "", "", "", ReadInJoyUtils.c());
    e(paramBoolean);
  }
  
  private void e(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131367281);
    TextView localTextView = (TextView)findViewById(2131367272);
    if (paramBoolean)
    {
      localLinearLayout.setVisibility(0);
      localTextView.setText("已启用");
      return;
    }
    localLinearLayout.setVisibility(8);
    localTextView.setText("已停用");
  }
  
  public void a()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label161;
      }
      if ((SystemUtil.b()) || (SystemUtil.d())) {
        break label140;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130845433);
      if (this.centerView != null) {
        this.centerView.setTextColor(-16777216);
      }
      this.vg.setBackgroundColor(-1);
      return;
      label140:
      this.mSystemBarComp.setStatusBarColor(-7829368);
      this.mSystemBarComp.setStatusBarDarkMode(true);
      continue;
      label161:
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
    this.jdField_b_of_type_AndroidViewView.postDelayed(new lei(this, paramInt), 500L);
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
    setContentView(2130969649);
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    b();
    a();
    this.jdField_i_of_type_Boolean = false;
    return true;
  }
  
  protected void doOnDestroy()
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
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
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
    case 2131367301: 
    default: 
      return;
    case 2131367300: 
      this.jdField_i_of_type_Boolean = true;
      ReadInJoyHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ReadInJoyActivityHelper.a(this);
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80067D8", "0X80067D8", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
      return;
    }
    this.jdField_c_of_type_ComTencentWidgetActionSheet.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity
 * JD-Core Version:    0.7.0.1
 */