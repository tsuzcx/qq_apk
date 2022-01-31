package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.biz.qqstory.playvideo.player.TextureVideoView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.registerGuideLogin.GuideBaseFragment;
import com.tencent.mobileqq.activity.registerGuideLogin.GuideBaseFragment.GuideCallBack;
import com.tencent.mobileqq.activity.registerGuideLogin.GuideHandler;
import com.tencent.mobileqq.activity.registerGuideLogin.GuideVideoHandler;
import com.tencent.mobileqq.activity.registerGuideLogin.GuideVideoHandler.GuideVideoCallBack;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.MTAReportController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.open.OpenProxy;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SoftInputResizeLayout;
import cooperation.qqreader.QRBridgeActivity;
import cooperation.qwallet.plugin.PatternLockUtils;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import swq;
import swr;
import sws;

public class LoginActivity
  extends FragmentActivity
  implements Handler.Callback, GuideBaseFragment.GuideCallBack, GuideVideoHandler.GuideVideoCallBack
{
  private static LoginActivity jdField_a_of_type_ComTencentMobileqqActivityLoginActivity;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  ReadInJoyLogicManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicManager;
  private TextureVideoView jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView;
  private GuideBaseFragment jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment;
  private GuideVideoHandler jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this);
  boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ThreadManager.postImmediately(new swq(paramQQAppInterface, paramString), null, false);
    try
    {
      StatisticCollector.a(BaseApplicationImpl.sApplication).a(paramString);
      MTAReportController.a(BaseApplicationImpl.sApplication).a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("login", 2, "loginSuccess set CURRENT_ACCOUNT: " + paramString);
      }
      SharedPreUtils.a(BaseApplicationImpl.sApplication, paramString, true);
      BaseApplicationImpl.sApplication.refreAccountList();
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("login", 2, "loginSuccess throwable: " + paramQQAppInterface);
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    OpenProxy.a().a(paramString);
    int i;
    if ((getIntent().getFlags() & 0x100000) != 0)
    {
      i = 1;
      if (!d()) {
        break label46;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        finish();
      }
      return;
      i = 0;
      break;
      label46:
      if (((i != 0) || (!c())) && ((i != 0) || (!a(paramString))) && (!f()) && (!a()) && (!e())) {
        if (getIntent().getParcelableExtra("shortcut_jump_key") != null)
        {
          paramString = (Intent)getIntent().getParcelableExtra("shortcut_jump_key");
          paramString.setClass(this, ShortcutRouterActivity.class);
          startActivity(paramString);
        }
        else if (getIntent().getBooleanExtra("jump_shortcut_dataline", false))
        {
          paramString = new Intent();
          paramString.putExtras(getIntent().getExtras());
          paramString.setClass(this, qfileJumpActivity.class);
          startActivity(paramString);
        }
        else if (getIntent().getParcelableExtra("QLINK_SHORTCUT_JUMP_KEY") != null)
        {
          paramString = new Intent(this, JumpActivity.class);
          paramString.putExtra("_goto_qlink_when_login_suc_", true);
          paramString.putExtra("IS_LOGIN_SUC_CALL", true);
          startActivity(paramString);
        }
        else if (getIntent().getParcelableExtra("QFILE_SHORTCUT_JUMP_KEY") != null)
        {
          paramString = new Intent(this, JumpActivity.class);
          paramString.putExtra("_goto_qfile_when_login_suc_", true);
          paramString.putExtra("IS_LOGIN_SUC_CALL", true);
          startActivity(paramString);
        }
        else if (getIntent().getParcelableExtra("qlink_share_intent_data") != null)
        {
          paramString = (Intent)getIntent().getParcelableExtra("qlink_share_intent_data");
          paramString.putExtra("qlink_share_login_suc_flag", true);
          startActivity(paramString);
        }
        else if (getIntent().getParcelableExtra("QREADER_SHORTCUT_JUMP_KEY") != null)
        {
          paramString = (Intent)getIntent().getParcelableExtra("QREADER_SHORTCUT_JUMP_KEY");
          Intent localIntent = new Intent(this, QRBridgeActivity.class);
          localIntent.putExtras(paramString);
          startActivity(localIntent);
        }
        else if ((!g()) && (!h()))
        {
          setResult(-1);
          if (!this.c) {
            d();
          }
        }
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    boolean bool = false;
    if ((this.c) || (this.b) || (this.e))
    {
      bool = true;
      paramInt = 2131493045;
    }
    try
    {
      getWindow().setBackgroundDrawableResource(paramInt);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      getWindow().setBackgroundDrawableResource(2131493045);
    }
    return bool;
  }
  
  private boolean a(String paramString)
  {
    boolean bool = getIntent().getBooleanExtra("key_gesture_from_authority", false);
    this.jdField_a_of_type_Boolean = true;
    if (bool)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("uin", paramString);
      setResult(-1, (Intent)localObject);
      return true;
    }
    if (JumpActivity.jdField_a_of_type_Boolean)
    {
      setResult(-1);
      return true;
    }
    paramString = getIntent().getStringExtra("scheme_content");
    if (getIntent().getBooleanExtra("isActionSend", false))
    {
      setResult(-1);
      return true;
    }
    Object localObject = getIntent().getStringExtra("pkg_name");
    if ((paramString != null) && (paramString.length() > 0))
    {
      JumpAction localJumpAction = JumpParser.a(this.app, this, paramString);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) || ("web".equals(localJumpAction.a("src_type"))) || (localJumpAction.e()) || (localJumpAction.f()))
      {
        localJumpAction.b((String)localObject);
        if (localJumpAction.e()) {
          this.jdField_a_of_type_Boolean = false;
        }
        localJumpAction.b();
        return true;
      }
      if (("h5".equalsIgnoreCase(localJumpAction.a("jump_from"))) && (localJumpAction.d()))
      {
        getIntent().putExtra("package_from_h5", "pakage_from_h5");
        getIntent().putExtra("jump_action_from_h5", paramString);
        d();
        return true;
      }
    }
    return false;
  }
  
  private boolean b()
  {
    if (("Meizu".equalsIgnoreCase(DeviceInfoUtil.i())) && (Build.VERSION.SDK_INT < 24))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity", 2, "onMultiWindowModeChanged meizu < 7.0 not support!");
      }
      return false;
    }
    return true;
  }
  
  @TargetApi(11)
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity", 2, "setSystemUiVisibility has been called.");
    }
    if ((VersionUtils.g()) && (!ShortVideoUtils.c()) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setSystemUiVisibility(1284);
    }
  }
  
  private boolean c()
  {
    boolean bool = false;
    this.jdField_a_of_type_Boolean = false;
    if (getIntent().getBooleanExtra("authority_start_qq_login", false))
    {
      Intent localIntent = new Intent("action_login_sucess");
      String str = this.app.getAccount();
      localIntent.putExtra("login_success_uin", str);
      sendBroadcast(localIntent);
      ThreadManager.getUIHandler().postDelayed(new sws(this, str), 1000L);
      bool = true;
    }
    return bool;
  }
  
  private void d()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    Object localObject = getIntent().getStringExtra("key_action");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((BindGroupActivity.class.getSimpleName().equals(localObject)) || (ChatSettingForTroop.class.getSimpleName().equals(localObject)) || (AddFriendLogicActivity.class.getSimpleName().equals(localObject)))) {
      localIntent.putExtras(getIntent().getExtras());
    }
    localIntent.addFlags(67108864);
    localIntent.putExtra("k_from_login", true);
    localObject = getIntent().getExtras();
    if (localObject != null)
    {
      if (((Bundle)localObject).containsKey("tab_index")) {
        localIntent.putExtra("tab_index", getIntent().getExtras().getInt("tab_index"));
      }
      if (((Bundle)localObject).containsKey("main_tab_id")) {
        localIntent.putExtra("main_tab_id", ((Bundle)localObject).getInt("main_tab_id"));
      }
      if (((Bundle)localObject).containsKey("jump_action_from_h5")) {
        localIntent.putExtra("jump_action_from_h5", getIntent().getExtras().getString("jump_action_from_h5"));
      }
      if (((Bundle)localObject).containsKey("package_from_h5")) {
        localIntent.putExtra("package_from_h5", getIntent().getExtras().getString("package_from_h5"));
      }
    }
    startActivity(localIntent);
    overridePendingTransition(2131034197, 0);
  }
  
  private boolean d()
  {
    Object localObject = getIntent().getStringExtra("scheme_content");
    String str = getIntent().getStringExtra("pkg_name");
    if ((localObject != null) && ((((String)localObject).startsWith("mqqopensdkapi://bizAgent/")) || (((String)localObject).startsWith("http://qm.qq.com/cgi-bin/")) || (((String)localObject).startsWith("mqq://shop/")) || (((String)localObject).startsWith("mqqapi://wallet/open")) || (((String)localObject).startsWith("mqqmdpass://wallet/modify_pass")) || (((String)localObject).startsWith("mqqapi://qqdataline/openqqdataline")) || (((String)localObject).startsWith("mqqapi://dating/")) || (((String)localObject).startsWith("mqqapi://qlink/openqlink")) || (((String)localObject).startsWith("mqqapi://qqc2b/callc2bphone"))))
    {
      localObject = JumpParser.a(this.app, this, (String)localObject);
      if (localObject != null)
      {
        ((JumpAction)localObject).b(str);
        ((JumpAction)localObject).b();
        return true;
      }
    }
    return false;
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler != null))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView);
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler = null;
    }
  }
  
  private boolean e()
  {
    Object localObject = getIntent().getStringExtra("scheme_content");
    String str = getIntent().getStringExtra("pkg_name");
    if (QLog.isColorLevel()) {
      QLog.d("ODProxy", 2, "handleODJumpAction: schemeStr:" + (String)localObject + "pkgName :" + str);
    }
    if ((localObject != null) && (((String)localObject).startsWith("mqqapi://od")))
    {
      localObject = JumpParser.a(this.app, this, (String)localObject);
      ((JumpAction)localObject).b(str);
      ((JumpAction)localObject).b();
      return true;
    }
    return false;
  }
  
  private boolean f()
  {
    boolean bool = getIntent().getBooleanExtra("key_req_by_contact_sync", false);
    if (bool)
    {
      Intent localIntent = new Intent(this, ContactSyncJumpActivity.class);
      localIntent.putExtra("key_req_from_switch_account", true);
      localIntent.putExtra("key_change", true);
      localIntent.putExtra("key_orginal_intent", getIntent().getParcelableExtra("key_orginal_intent"));
      startActivity(localIntent);
      moveTaskToBack(true);
      finish();
    }
    return bool;
  }
  
  private boolean g()
  {
    Object localObject = getIntent().getStringExtra("scheme_content");
    String str = getIntent().getStringExtra("pkg_name");
    if (QLog.isColorLevel()) {
      QLog.d("schedule", 2, "handleScheduleJumpAction: schemeStr:" + (String)localObject + "pkgName :" + str);
    }
    if ((localObject != null) && (((String)localObject).startsWith("mqqapi://schedule/showDetail?")))
    {
      localObject = JumpParser.a(this.app, this, (String)localObject);
      ((JumpAction)localObject).b(str);
      ((JumpAction)localObject).b();
      return true;
    }
    return false;
  }
  
  private boolean h()
  {
    boolean bool2 = false;
    boolean bool3 = getIntent().getBooleanExtra("is_from_king_moment", false);
    String str = getIntent().getStringExtra("king_moment_cover_url");
    long l = getIntent().getLongExtra("arg_wang_zhe_app_id", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("KingShareReadInjoyModule", 2, "url is " + str);
    }
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        Intent localIntent = new Intent(this, ReadInJoyDeliverVideoActivity.class);
        localIntent.putExtra("arg_is_from_wang_zhe", true);
        localIntent.putExtra("arg_wang_zhe_app_id", l);
        startActivity(localIntent);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicManager = ((ReadInJoyLogicManager)this.app.getManager(162));
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicManager != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicManager.a().a(str, this.app.c());
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void a()
  {
    onBackEvent();
  }
  
  @TargetApi(11)
  public void a(GuideBaseFragment paramGuideBaseFragment)
  {
    Object localObject = getSupportFragmentManager();
    FragmentTransaction localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
    localObject = ((FragmentManager)localObject).findFragmentById(2131374751);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment != null) || (localObject != null))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment == null) && (localObject != null) && ((localObject instanceof GuideBaseFragment))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment = ((GuideBaseFragment)localObject);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment.a(null);
      }
      localFragmentTransaction.replace(2131374751, paramGuideBaseFragment);
      if (VersionUtils.e()) {
        localFragmentTransaction.commitAllowingStateLoss();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment = paramGuideBaseFragment;
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment.a(this);
      return;
      localFragmentTransaction.commit();
      continue;
      localFragmentTransaction.add(2131374751, paramGuideBaseFragment);
      if (VersionUtils.e()) {
        localFragmentTransaction.commitAllowingStateLoss();
      } else {
        localFragmentTransaction.commit();
      }
    }
  }
  
  protected boolean a()
  {
    Intent localIntent = getIntent();
    if ("webview".equals(localIntent.getStringExtra("action_name")))
    {
      localIntent = new Intent(localIntent);
      localIntent.setClass(this, QQBrowserActivity.class);
      startActivity(localIntent);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    e();
    if (this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842605);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  protected void checkUnlockForSpecial()
  {
    if ((this.c) && (this.app != null) && (GesturePWDUtils.getGesturePWDState(getActivity(), this.app.getCurrentAccountUin()) == 2) && (GesturePWDUtils.getGesturePWDMode(getActivity(), this.app.getCurrentAccountUin()) == 21)) {
      startUnlockActivity();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    getWindow().addFlags(1024);
    this.b = getIntent().getBooleanExtra("is_change_account", false);
    this.c = getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false);
    this.e = getIntent().getBooleanExtra("from_register_choose", false);
    this.d = getIntent().getBooleanExtra("login_from_account_change", false);
    a(2130842605);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      SoftInputResizeLayout.a(this);
    }
    if (jdField_a_of_type_ComTencentMobileqqActivityLoginActivity != null) {
      jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.finish();
    }
    jdField_a_of_type_ComTencentMobileqqActivityLoginActivity = this;
    if (this.app != null)
    {
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity", 2, "LoginActivity app is " + this.app);
      }
      this.jdField_a_of_type_Boolean = true;
      super.setContentView(2130971451);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131374749));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131374751));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374750));
      if (paramBundle != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment = ((GuideBaseFragment)getSupportFragmentManager().findFragmentById(2131374751));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment.a(this);
        }
        if ("doOnCreate savedInstanceState != null, mCurrentView isExist:" + this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment == null) {
          break label543;
        }
      }
    }
    label543:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("LoginActivity", 1, new Object[] { Boolean.valueOf(bool) });
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment == null) {
        a(GuideHandler.a(this, this.app));
      }
      if ((this.c) && (this.d))
      {
        ReportController.b(this.app, "CliOper", "", "", "0X800664D", "0X800664D", 0, 0, "", "", "", "");
        ReportController.b(this.app, "dc00898", "", "", "0X800735D", "0X800735D", 0, 0, "", "", "", "");
        ReportController.a(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 0, 0, "", "", "", "");
        ReportController.a(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 3, 0, "", "", "", "");
      }
      return true;
      AppRuntime localAppRuntime = getAppRuntime();
      if ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface))) {
        break;
      }
      this.app = ((QQAppInterface)localAppRuntime);
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      break;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    jdField_a_of_type_ComTencentMobileqqActivityLoginActivity = null;
    if (this.app != null) {
      this.app.removeHandler(getClass());
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    e();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment.a(paramIntent);
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler.d();
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity", 2, "doOnNewIntent in LoginActivity");
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler != null))
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler.b();
    }
  }
  
  protected void doOnRestoreInstanceState(Bundle paramBundle)
  {
    super.doOnRestoreInstanceState(paramBundle);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler != null) && (paramBundle != null))
    {
      int i = paramBundle.getInt("save_video_current_position", 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler.a(i);
    }
  }
  
  protected void doOnResume()
  {
    setRequestedOrientation(1);
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("main", 2, "onResume in LoginActivity");
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler.d();
    }
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    super.doOnSaveInstanceState(paramBundle);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler != null) && (paramBundle != null)) {
      paramBundle.putInt("save_video_current_position", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler.a());
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler != null)) {
      c();
    }
  }
  
  @TargetApi(16)
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (!isFinishing())
      {
        try
        {
          dismissDialog(0);
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
        }
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("LoginActivity", 2, "recv message FINISH_ACTIVITY.. finish activity");
        }
        finish();
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("LoginActivity", 2, "handleMessage in LoginActivity count=" + this.jdField_a_of_type_Int);
        }
        if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler != null) && (this.jdField_a_of_type_Int < 10))
        {
          this.jdField_a_of_type_Int += 1;
          this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideVideoHandler.d();
        }
        else if (this.jdField_a_of_type_Int >= 10)
        {
          this.jdField_a_of_type_Int = 0;
          b();
          continue;
          if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
            this.jdField_a_of_type_AndroidGraphicsBitmap = null;
          }
          if (paramMessage.obj != null) {
            this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)paramMessage.obj);
          }
          if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView.isPlaying()))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setBackground(new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap));
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          }
          if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842605);
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          }
          if (QLog.isColorLevel())
          {
            QLog.d("LoginActivity", 2, "handleMessage in LoginActivity mVideoView=" + this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerTextureVideoView + " mFirstBitmap" + this.jdField_a_of_type_AndroidGraphicsBitmap);
            continue;
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          }
        }
      }
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
    QLog.d("login", 1, "LoginActivity onAccountChanged");
    this.app.removeHandler(getClass());
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment != null) {}
    Object localObject;
    for (String str = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment.a();; localObject = null)
    {
      if (!TextUtils.isEmpty(str))
      {
        if (!str.equalsIgnoreCase(this.app.getCurrentAccountUin())) {
          SharedPreUtils.a(BaseApplicationImpl.sApplication, str, true);
        }
        PatternLockUtils.setFirstEnterAfterLoginState(this, str, true);
      }
      if (PhoneNumLoginImpl.a().a()) {
        return;
      }
      ThreadManager.postImmediately(new swr(this), null, false);
      a(this.app.getAccount());
      if (!isFinishing()) {}
      try
      {
        dismissDialog(0);
        PatternLockUtils.setFirstEnterAfterLoginState(this, this.app.getAccount(), true);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  protected void onAccoutChangeFailed()
  {
    QLog.d("login", 1, "LoginActivity onAccoutChangeFailed");
  }
  
  protected boolean onBackEvent()
  {
    boolean bool1 = getIntent().getBooleanExtra("is_change_account", false);
    boolean bool2 = getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false);
    boolean bool3 = getIntent().getBooleanExtra("key_req_by_contact_sync", false);
    boolean bool4 = getIntent().getBooleanExtra("login_from_account_change", false);
    boolean bool5 = getIntent().getBooleanExtra("from_register_choose", false);
    if (bool3) {
      if (bool2)
      {
        moveTaskToBack(true);
        finish();
      }
    }
    do
    {
      for (;;)
      {
        return true;
        try
        {
          this.app.b(false);
        }
        catch (Exception localException1)
        {
          QLog.e("LoginActivity", 1, "onBackEvent app exit exception: " + localException1.getMessage());
          localException1.printStackTrace();
        }
      }
      break;
      if ((!bool1) && (!bool2) && (!bool5)) {
        break label181;
      }
      if (bool1) {
        setResult(-1);
      }
      finish();
    } while ((!bool2) || (!bool4));
    overridePendingTransition(2131034131, 2131034135);
    return true;
    try
    {
      label181:
      this.app.b(false);
      finish();
      return true;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        QLog.e("LoginActivity", 1, "onBackEvent app exit exception: " + localException2.getMessage());
        localException2.printStackTrace();
      }
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Dialog localDialog = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment != null) {
      localDialog = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment.a(paramInt);
    }
    return localDialog;
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    if (!b()) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment.a(paramBoolean);
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment.a(paramInt, paramDialog);
    }
    super.onPrepareDialog(paramInt, paramDialog);
  }
  
  protected void receiveScreenOff()
  {
    super.receiveScreenOff();
    if ((this.c) && (this.app != null) && (GesturePWDUtils.getGesturePWDState(getActivity(), this.app.getCurrentAccountUin()) == 2) && (GesturePWDUtils.getGesturePWDMode(getActivity(), this.app.getCurrentAccountUin()) == 21)) {
      startUnlockActivity();
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginActivity
 * JD-Core Version:    0.7.0.1
 */