package com.tencent.mobileqq.activity;

import abtq;
import ahrb;
import ahrc;
import ajwj;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import andx;
import aqcp;
import aumk;
import axbj;
import axqn;
import axqy;
import axrn;
import bbdh;
import bbeg;
import bbex;
import bbkb;
import bcxy;
import bfnz;
import bfyd;
import bgyp;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.registerGuideLogin.GuideBaseFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.mini.appbrand.ui.AppBrandLaunchUI;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.startup.step.RecordTracer;
import com.tencent.open.agent.BindGroupActivity;
import com.tencent.open.agent.BindTroopPreVerificationFragment;
import com.tencent.open.agent.JoinTroopPreVerificationFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trackrecordlib.core.RecordManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqreader.QRBridgeActivity;
import cooperation.qwallet.plugin.PatternLockUtils;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import osg;
import osl;
import zzp;

public class LoginActivity
  extends FragmentActivity
  implements ahrb, Handler.Callback
{
  private static LoginActivity jdField_a_of_type_ComTencentMobileqqActivityLoginActivity;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private GuideBaseFragment jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this);
  osl jdField_a_of_type_Osl;
  boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ThreadManager.postImmediately(new LoginActivity.1(paramQQAppInterface, paramString), null, false);
    try
    {
      axrn.a(BaseApplicationImpl.sApplication).a(paramString);
      axqn.a(BaseApplicationImpl.sApplication).a(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("login", 2, "loginSuccess set CURRENT_ACCOUNT: " + paramString);
      }
      bbkb.a(BaseApplicationImpl.sApplication, paramString, true);
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
    bcxy.a().a(paramString);
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
      if (((i != 0) || (!c())) && ((i != 0) || (!a(paramString))) && (!g()) && (!a()) && (!f()) && (!e())) {
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
        else
        {
          Intent localIntent;
          if (getIntent().getParcelableExtra("QREADER_SHORTCUT_JUMP_KEY") != null)
          {
            paramString = (Intent)getIntent().getParcelableExtra("QREADER_SHORTCUT_JUMP_KEY");
            localIntent = new Intent(this, QRBridgeActivity.class);
            localIntent.putExtras(paramString);
            startActivity(localIntent);
          }
          else if (getIntent().getParcelableExtra("MINI_SHORTCUT_JUMP_KEY") != null)
          {
            paramString = (Intent)getIntent().getParcelableExtra("MINI_SHORTCUT_JUMP_KEY");
            localIntent = new Intent(this, AppBrandLaunchUI.class);
            localIntent.putExtras(paramString);
            startActivity(localIntent);
          }
          else if ((!h()) && (!i()) && (!j()))
          {
            setResult(-1);
            if (!this.c) {
              b();
            }
          }
        }
      }
    }
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
    if ((JumpActivity.jdField_a_of_type_Boolean) || (JumpActivity.b))
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
      bbeg localbbeg = bbex.a(this.app, this, paramString);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) || ("web".equals(localbbeg.b("src_type"))) || (localbbeg.g()) || (localbbeg.h()))
      {
        localbbeg.b((String)localObject);
        if (localbbeg.g()) {
          this.jdField_a_of_type_Boolean = false;
        }
        localbbeg.c();
        return true;
      }
      if (("h5".equalsIgnoreCase(localbbeg.b("jump_from"))) && (localbbeg.f()))
      {
        getIntent().putExtra("package_from_h5", "pakage_from_h5");
        getIntent().putExtra("jump_action_from_h5", paramString);
        b();
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    Intent localIntent = new Intent(this, SplashActivity.class);
    Object localObject = getIntent().getStringExtra("key_action");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((BindGroupActivity.class.getSimpleName().equals(localObject)) || (ChatSettingForTroop.class.getSimpleName().equals(localObject)) || (AddFriendLogicActivity.class.getSimpleName().equals(localObject)) || (aqcp.class.getSimpleName().equals(localObject)) || (ajwj.class.getSimpleName().equals(localObject)))) {
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
    overridePendingTransition(2130772071, 0);
  }
  
  private boolean b()
  {
    if (("Meizu".equalsIgnoreCase(bbdh.h())) && (Build.VERSION.SDK_INT < 24))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity", 2, "onMultiWindowModeChanged meizu < 7.0 not support!");
      }
      return false;
    }
    return true;
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("LoginActivity", 2, "only kandian tab switch, login delayTime:" + (NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long));
    }
    if (aumk.a().a()) {
      return;
    }
    ThreadManager.postImmediately(new LoginActivity.2(this), null, false);
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
      ThreadManager.getUIHandler().postDelayed(new LoginActivity.3(this, str), 1000L);
      bool = true;
    }
    return bool;
  }
  
  private boolean d()
  {
    Object localObject = getIntent().getStringExtra("scheme_content");
    String str = getIntent().getStringExtra("pkg_name");
    if ((localObject != null) && ((((String)localObject).startsWith("mqqopensdkapi://bizAgent/")) || (((String)localObject).startsWith("http://qm.qq.com/cgi-bin/")) || (((String)localObject).startsWith("mqq://shop/")) || (((String)localObject).startsWith("mqqapi://wallet/open")) || (((String)localObject).startsWith("mqqmdpass://wallet/modify_pass")) || (((String)localObject).startsWith("mqqapi://qqdataline/openqqdataline")) || (((String)localObject).startsWith("mqqapi://dating/")) || (((String)localObject).startsWith("mqqapi://qlink/openqlink")) || (((String)localObject).startsWith("mqqapi://qqc2b/callc2bphone"))))
    {
      localObject = bbex.a(this.app, this, (String)localObject);
      if (localObject != null)
      {
        ((bbeg)localObject).b(str);
        ((bbeg)localObject).c();
        return true;
      }
    }
    return false;
  }
  
  private boolean e()
  {
    Bundle localBundle = getIntent().getBundleExtra("key_params");
    if (getIntent().getBooleanExtra("fromThirdAppByOpenSDK", false))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_params", localBundle);
      int i = localBundle.getInt("action");
      if (i == 3) {
        abtq.a(this, localIntent, PublicTransFragmentActivity.class, JoinTroopPreVerificationFragment.class);
      }
      while (i != 1) {
        return true;
      }
      abtq.a(this, localIntent, PublicTransFragmentActivity.class, BindTroopPreVerificationFragment.class);
      return true;
    }
    return false;
  }
  
  private boolean f()
  {
    Object localObject = getIntent().getStringExtra("scheme_content");
    String str = getIntent().getStringExtra("pkg_name");
    if (QLog.isColorLevel()) {
      QLog.d("ODProxy", 2, "handleODJumpAction: schemeStr:" + (String)localObject + "pkgName :" + str);
    }
    if ((localObject != null) && (((String)localObject).startsWith("mqqapi://od")))
    {
      localObject = bbex.a(this.app, this, (String)localObject);
      ((bbeg)localObject).b(str);
      ((bbeg)localObject).c();
      return true;
    }
    return false;
  }
  
  private boolean g()
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
  
  private boolean h()
  {
    Object localObject = getIntent().getStringExtra("scheme_content");
    String str = getIntent().getStringExtra("pkg_name");
    if (QLog.isColorLevel()) {
      QLog.d("schedule", 2, "handleScheduleJumpAction: schemeStr:" + (String)localObject + "pkgName :" + str);
    }
    if ((localObject != null) && (((String)localObject).startsWith("mqqapi://schedule/showDetail?")))
    {
      localObject = bbex.a(this.app, this, (String)localObject);
      ((bbeg)localObject).b(str);
      ((bbeg)localObject).c();
      return true;
    }
    return false;
  }
  
  private boolean i()
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
        this.jdField_a_of_type_Osl = ((osl)this.app.getManager(163));
        if (this.jdField_a_of_type_Osl != null) {
          this.jdField_a_of_type_Osl.a().a(str, this.app.c());
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean j()
  {
    boolean bool = false;
    if (getIntent().getBooleanExtra("UploadPhoto.key_from_album_shortcut", false))
    {
      Bundle localBundle = getIntent().getExtras();
      bgyp.a(this, localBundle.getString("UploadPhoto.key_album_id"), localBundle.getLong("UploadPhoto.key_album_owner_uin", 0L), String.valueOf(getAppRuntime().getLongAccountUin()));
      finish();
      bool = true;
    }
    return bool;
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
    localObject = ((FragmentManager)localObject).findFragmentById(2131367260);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment != null) || (localObject != null))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment == null) && (localObject != null) && ((localObject instanceof GuideBaseFragment))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment = ((GuideBaseFragment)localObject);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment.a(null);
      }
      localFragmentTransaction.replace(2131367260, paramGuideBaseFragment);
      if (bfnz.e()) {
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
      localFragmentTransaction.add(2131367260, paramGuideBaseFragment);
      if (bfnz.e()) {
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
  
  public void checkUnlockForSpecial()
  {
    if ((this.c) && (this.app != null) && (GesturePWDUtils.getGesturePWDState(getActivity(), this.app.getCurrentAccountUin()) == 2) && (GesturePWDUtils.getGesturePWDMode(getActivity(), this.app.getCurrentAccountUin()) == 21)) {
      startUnlockActivity();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    Object localObject = getWindow();
    ((Window)localObject).addFlags(1024);
    if (Build.VERSION.SDK_INT >= 28)
    {
      View localView = ((Window)localObject).getDecorView();
      WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
      localLayoutParams.layoutInDisplayCutoutMode = 1;
      ((Window)localObject).setAttributes(localLayoutParams);
      int i = localView.getSystemUiVisibility();
      ((Window)localObject).getDecorView().setSystemUiVisibility(i | 0x400);
    }
    this.b = getIntent().getBooleanExtra("is_change_account", false);
    this.c = getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false);
    this.e = getIntent().getBooleanExtra("from_register_choose", false);
    this.d = getIntent().getBooleanExtra("login_from_account_change", false);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      bfyd.a(this);
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
      super.setContentView(2131562345);
      if (paramBundle != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment = ((GuideBaseFragment)getSupportFragmentManager().findFragmentById(2131367260));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment.a(this);
        }
        if ("doOnCreate savedInstanceState != null, mCurrentView isExist:" + this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment == null) {
          break label640;
        }
      }
    }
    label640:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("LoginActivity", 1, new Object[] { Boolean.valueOf(bool) });
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment == null) {
        a(ahrc.a(this, this.app));
      }
      if (axbj.a(1, BaseApplicationImpl.processName))
      {
        long l1 = System.currentTimeMillis();
        paramBundle = BaseActivity.sTopActivity;
        if (QLog.isColorLevel()) {
          QLog.d("RecordTracer", 2, "doTracebackSDK in LoginActivity");
        }
        RecordManager.getInstance().setRecentActivityName(paramBundle);
        RecordTracer.a().step();
        long l2 = System.currentTimeMillis();
        QLog.d("RecordTracer", 1, "fuction time = " + (l2 - l1));
      }
      if ((this.c) && (this.d))
      {
        axqy.b(this.app, "CliOper", "", "", "0X800664D", "0X800664D", 0, 0, "", "", "", "");
        axqy.b(this.app, "dc00898", "", "", "0X800735D", "0X800735D", 0, 0, "", "", "", "");
        axqy.a(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 0, 0, "", "", "", "");
        axqy.a(this.app, "dc00898", "", "", "0X8007360", "0X8007360", 3, 0, "", "", "", "");
      }
      return true;
      localObject = getAppRuntime();
      if ((localObject == null) || (!(localObject instanceof QQAppInterface))) {
        break;
      }
      this.app = ((QQAppInterface)localObject);
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      break;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    jdField_a_of_type_ComTencentMobileqqActivityLoginActivity = null;
    if (this.app != null) {
      this.app.removeHandler(getClass());
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20140326);
    }
    zzp.a(this);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment.a(paramIntent);
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity", 2, "doOnNewIntent in LoginActivity");
    }
  }
  
  public void doOnResume()
  {
    setRequestedOrientation(1);
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("main", 2, "onResume in LoginActivity");
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
        if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20140326);
        }
        if (QLog.isColorLevel()) {
          QLog.d("LoginActivity", 2, "handleMessage  LOGIN_DO_NEXT");
        }
        c();
      }
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    QLog.d("login", 1, "LoginActivity onAccountChanged");
    this.app.removeHandler(getClass());
    this.app = ((QQAppInterface)getAppRuntime());
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment != null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment.a();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (!((String)localObject).equalsIgnoreCase(this.app.getCurrentAccountUin())) {
        bbkb.a(BaseApplicationImpl.sApplication, (String)localObject, true);
      }
      PatternLockUtils.setFirstEnterAfterLoginState(this, (String)localObject, true);
    }
    localObject = Message.obtain();
    ((Message)localObject).what = 20140326;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, 800L);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (!andx.a(getAppRuntime(), getClass(), this.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(20140326);
      c();
    }
    axqy.a(this.app, "dc00898", "", "", "0X800AC0B", "0X800AC0B", 0, 0, "", "", "", "");
    MiniAppSecurityUtil.doClearAfterLoginSuccess();
  }
  
  public void onAccoutChangeFailed()
  {
    QLog.d("login", 1, "LoginActivity onAccoutChangeFailed");
  }
  
  public boolean onBackEvent()
  {
    boolean bool1 = getIntent().getBooleanExtra("is_change_account", false);
    boolean bool2 = getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false);
    boolean bool3 = getIntent().getBooleanExtra("key_req_by_contact_sync", false);
    boolean bool4 = getIntent().getBooleanExtra("login_from_account_change", false);
    boolean bool5 = getIntent().getBooleanExtra("from_register_choose", false);
    boolean bool6 = getIntent().getBooleanExtra("fromsubaccount", false);
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
        break label199;
      }
      if ((bool1) && (!bool6)) {
        setResult(-1);
      }
      finish();
    } while ((!bool2) || (!bool4));
    overridePendingTransition(2130771990, 2130772001);
    return true;
    try
    {
      label199:
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
  
  public void onLogout(Constants.LogoutReason paramLogoutReason) {}
  
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
  
  public void receiveScreenOff()
  {
    super.receiveScreenOff();
    if ((this.c) && (this.app != null) && (GesturePWDUtils.getGesturePWDState(getActivity(), this.app.getCurrentAccountUin()) == 2) && (GesturePWDUtils.getGesturePWDMode(getActivity(), this.app.getCurrentAccountUin()) == 21)) {
      startUnlockActivity();
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginActivity
 * JD-Core Version:    0.7.0.1
 */