package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.handler.GetOpenID;
import com.tencent.mobileqq.data.KplHelper;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.Serializable;
import java.util.ArrayList;

public class AddFriendLogicActivity
  extends BaseActivity
{
  public static String a = "";
  public static boolean b = false;
  private int jdField_a_of_type_Int;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new AddFriendLogicActivity.4(this);
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new AddFriendLogicActivity.6(this);
  protected Handler a;
  protected OpenIdObserver a;
  FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new AddFriendLogicActivity.3(this);
  protected QQCustomDialog a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  protected boolean a;
  private int jdField_b_of_type_Int = -1;
  DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new AddFriendLogicActivity.5(this);
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int = -1;
  private String jdField_e_of_type_JavaLangString;
  private int f;
  
  public AddFriendLogicActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver = new AddFriendLogicActivity.9(this);
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, short paramShort, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return a(paramContext, paramString1, paramString2, paramShort, paramInt, paramString3, paramString4, paramString5, paramString6, null, paramString7, null);
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, short paramShort, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    paramContext = new Intent(paramContext, AddFriendLogicActivity.class);
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("k_uin_type", 4);
    paramContext.putExtra("group_option", paramShort);
    paramContext.putExtra("troop_question", paramString3);
    paramContext.putExtra("troop_answer", paramString4);
    paramContext.putExtra("nick_name", paramString2);
    paramContext.putExtra("stat_option", paramInt);
    paramContext.putExtra("param_return_addr", paramString5);
    paramContext.putExtra("last_activity", paramString6);
    paramContext.putExtra("authKey", paramString7);
    paramContext.putExtra("authSig", paramString8);
    paramContext.putExtra("key_param_homework_intro_str", paramString9);
    return paramContext;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (getIntent() != null)
    {
      if (getIntent().getIntExtra("source_id", 3999) != 3090) {
        return;
      }
      try
      {
        ForwardSdkShareOption.a(this, true, "action_game_make_friend", Long.valueOf(getIntent().getStringExtra("extra")).longValue(), paramInt, paramString);
        return;
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("feedBackToGameSDK error = ");
        localStringBuilder.append(paramString);
        QLog.e("AddFriendLogicActivity", 1, localStringBuilder.toString());
        return;
      }
    }
    QLog.e("AddFriendLogicActivity", 1, "feedBackToGameSDK intent = null");
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dismissOrHideProgress hide: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("qqBaseActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localObject != null)
    {
      if (!((QQProgressDialog)localObject).isShowing()) {
        return;
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.hide();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private boolean a()
  {
    Object localObject1 = getIntent();
    this.jdField_d_of_type_Int = ((Intent)localObject1).getIntExtra("source_id", 3999);
    this.jdField_e_of_type_JavaLangString = ((Intent)localObject1).getStringExtra("extra");
    if (!a(this.jdField_c_of_type_Int, this.jdField_d_of_type_JavaLangString)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "addFriend");
    }
    localObject1 = ((Intent)localObject1).getStringExtra("nick_name");
    if ((this.jdField_d_of_type_Int == 3004) && (localObject1 == null) && (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)))
    {
      localObject1 = this.app.getEntityManagerFactory().createEntityManager();
      Object localObject2 = (TroopMemberInfo)((EntityManager)localObject1).find(TroopMemberInfo.class, new String[] { this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString });
      if (localObject2 != null)
      {
        localObject2 = ((TroopMemberInfo)localObject2).friendnick;
        getIntent().putExtra("nick_name", (String)localObject2);
      }
      ((EntityManager)localObject1).close();
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    if (this.jdField_c_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("qqBaseActivity", 2, "queryUinSafetyFlag");
      }
      b();
      ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestUinSafetyFlag(Long.parseLong(this.jdField_d_of_type_JavaLangString));
      return true;
    }
    if (this.jdField_d_of_type_Int == 3024)
    {
      c();
      return true;
    }
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      d();
      return true;
    }
    c();
    return true;
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          finish();
          return false;
        }
        if (this.jdField_d_of_type_Int == 3999)
        {
          this.jdField_d_of_type_Int = 3016;
          if (QLog.isColorLevel()) {
            QLog.d("Q.contacts.", 2, "openId source id is default!");
          }
        }
      }
      else if (this.jdField_d_of_type_Int == 3999)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacts.", 2, "mobile source id is default!");
        }
        this.jdField_d_of_type_Int = 3006;
      }
    }
    try
    {
      Long.parseLong(paramString);
      if (((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString))
      {
        QQToast.a(this.app.getApplication(), 2131689998, 0).b(getTitleBarHeight());
        finish();
        return false;
      }
      if (!NetworkUtil.isNetSupport(this))
      {
        QQToast.a(this.app.getApplication(), 2131694424, 0).b(getTitleBarHeight());
        finish();
        return false;
      }
      return true;
    }
    catch (Throwable paramString) {}
    return false;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "showProgress");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(new AddFriendLogicActivity.1(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131692930);
    if (!isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private boolean b()
  {
    if (!NetworkUtil.isNetSupport(this))
    {
      QQToast.a(this.app.getApplication(), 2131694424, 0).b(getTitleBarHeight());
      finish();
      return false;
    }
    Intent localIntent = new Intent(this, AddFriendVerifyActivity.class);
    localIntent.putExtras(getIntent());
    localIntent.putExtra("param_mode", 0);
    localIntent.putExtra("contact_bothway", true);
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      startActivity(localIntent);
      finish();
      return true;
    }
    startActivityForResult(localIntent, 1);
    return true;
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "getAddFriendSetting");
    }
    b();
    int i = getIntent().getIntExtra("sub_source_id", 0);
    ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestUserAddFriendSetting(this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int, i, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  private boolean c()
  {
    Object localObject = getIntent();
    String str = ((Intent)localObject).getStringExtra("uin");
    int i = ((Intent)localObject).getShortExtra("group_option", (short)2);
    if (((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(str) != null)
    {
      QQToast.a(this.app.getApplication(), 2131689995, 0).b(getTitleBarHeight());
      finish();
      return false;
    }
    if (i == 3)
    {
      localObject = getIntent().getStringExtra("nick_name");
      if ((localObject == null) || (((String)localObject).length() == 0)) {
        getString(2131693517);
      }
      QQToast.a(this.app.getApplication(), 2131719932, 0).b(getTitleBarHeight());
      finish();
      return false;
    }
    localObject = new Intent(this, AddFriendVerifyActivity.class);
    ((Intent)localObject).putExtras(getIntent());
    ((Intent)localObject).putExtra("friend_setting", 9);
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      ((Intent)localObject).putExtra("param_return_addr", getIntent().getStringExtra("param_return_addr"));
      startActivity((Intent)localObject);
      finish();
      return false;
    }
    startActivityForResult((Intent)localObject, 1);
    return true;
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("addFriendTag", 2, "checkAccountDiff");
    }
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      OpenID localOpenID;
      if (this.jdField_e_of_type_JavaLangString == null) {
        localOpenID = null;
      } else {
        localOpenID = this.app.getMsgHandler().a(this.jdField_e_of_type_JavaLangString);
      }
      if ((localOpenID != null) && (!TextUtils.isEmpty(localOpenID.openID)))
      {
        if (!jdField_a_of_type_JavaLangString.equals(localOpenID.openID))
        {
          a();
          return;
        }
        c();
        return;
      }
      b();
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AddFriendLogicActivity.2(this), 3000L);
      this.app.addObserver(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
      if (this.jdField_e_of_type_JavaLangString != null) {
        GetOpenID.a(this.app.getMsgHandler(), this.jdField_e_of_type_JavaLangString);
      }
    }
  }
  
  private void e()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.f != 0))
    {
      Object localObject1 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertTitle", 147, this.f);
      if (localObject1 != null) {
        localObject1 = ((Bundle)localObject1).getString("AlertTitle");
      } else {
        localObject1 = null;
      }
      Object localObject2 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertText", 147, this.f);
      Object localObject4;
      if (localObject2 != null) {
        localObject4 = ((Bundle)localObject2).getString("AlertText");
      } else {
        localObject4 = null;
      }
      localObject2 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertLeftBtnText", 147, this.f);
      if (localObject2 != null) {
        localObject2 = ((Bundle)localObject2).getString("AlertLeftBtnText");
      } else {
        localObject2 = null;
      }
      Object localObject3 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertRightBtnText", 147, this.f);
      if (localObject3 != null) {
        localObject3 = ((Bundle)localObject3).getString("AlertRightBtnText");
      } else {
        localObject3 = null;
      }
      Object localObject5 = localObject1;
      int i;
      if (localObject1 == null)
      {
        if (this.f == 1) {
          i = 2131718638;
        } else {
          i = 2131718642;
        }
        localObject5 = getString(i);
      }
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        i = this.f;
        if (i == 1) {
          localObject1 = getString(2131718639);
        } else if (i == 2) {
          localObject1 = getString(2131718637);
        } else if (i == 3) {
          localObject1 = getString(2131718641);
        } else if (i == 4) {
          localObject1 = getString(2131718640);
        } else if (i == 5) {
          localObject1 = getString(2131718635);
        } else {
          localObject1 = getString(2131718636);
        }
      }
      if (localObject2 == null)
      {
        if (this.f == 1)
        {
          this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
          localObject4 = localObject2;
        }
        else
        {
          localObject4 = getString(2131718634);
        }
      }
      else
      {
        localObject4 = localObject2;
        if (TextUtils.isEmpty(((String)localObject2).trim()))
        {
          this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
          localObject4 = localObject2;
        }
      }
      if (localObject3 == null)
      {
        if (this.f == 1) {
          localObject2 = getString(2131718633);
        } else {
          localObject2 = getString(2131718632);
        }
      }
      else
      {
        localObject2 = localObject3;
        if (TextUtils.isEmpty(((String)localObject3).trim()))
        {
          this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = null;
          localObject2 = localObject3;
        }
      }
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle((String)localObject5);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage((CharSequence)localObject1);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton((String)localObject4, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton((String)localObject2, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
      if ((this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null) || (this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener == null)) {
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131363829).setVisibility(8);
      }
    }
  }
  
  private void f()
  {
    if (isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "showRefuseAddFriendDialog is finishing return");
      }
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(getString(2131689611));
    localQQCustomDialog.setMessage(getString(2131718172));
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    Window localWindow = localQQCustomDialog.getWindow();
    if (localWindow != null)
    {
      localWindow.setDimAmount(0.5F);
      localWindow.addFlags(2);
    }
    localQQCustomDialog.setPositiveButton(2131694583, new AddFriendLogicActivity.8(this)).setNegativeButton(null, null).show();
  }
  
  protected void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localObject != null) && (!((QQCustomDialog)localObject).isShowing()) && (!isFinishing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131695206);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131692113);
    localObject = new AddFriendLogicActivity.7(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690728, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131695174, (DialogInterface.OnClickListener)localObject);
    if (!isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  void a(int paramInt1, boolean paramBoolean, ArrayList<String> paramArrayList, Class<?> paramClass, int paramInt2)
  {
    this.jdField_e_of_type_Int = paramInt1;
    if ((this.jdField_d_of_type_Int == 3024) && (paramInt1 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendLogicActivity", 2, "startVerifyActivity() from applets add friend and friendSetting is 0 ");
      }
      if (NetworkUtil.isNetSupport(this))
      {
        paramInt2 = getIntent().getIntExtra("sub_source_id", 0);
        ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestAddFriend(this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, paramInt1, (byte)0, "", this.jdField_d_of_type_Int, paramInt2, false, null, false, null, this.jdField_c_of_type_JavaLangString, getIntent().getBundleExtra("flc_extra_param"), false);
        return;
      }
      QQToast.a(this.app.getApplication(), 2131694424, 0).b(getTitleBarHeight());
      return;
    }
    paramClass = new Intent(this, paramClass);
    paramClass.putExtras(getIntent());
    paramClass.putExtra("param_mode", 0);
    paramClass.putExtra("friend_setting", paramInt1);
    paramClass.putExtra("contact_bothway", paramBoolean);
    paramClass.putExtra("user_question", paramArrayList);
    paramClass.putExtra("sort_id", this.jdField_d_of_type_Int);
    paramClass.putExtra("extra", this.jdField_e_of_type_JavaLangString);
    paramClass.putExtra("entrance", this.jdField_b_of_type_Int);
    if (this.jdField_d_of_type_Int == 3094) {
      paramClass.putExtra("sub_source_id", getIntent().getIntExtra("sub_source_id", 8));
    }
    if ((!paramClass.hasExtra("param_wzry_data")) && (KplHelper.a(this.app, this, this.jdField_d_of_type_JavaLangString, paramInt2)))
    {
      paramArrayList = KplRoleInfo.WZRYUIinfo.buildNickName(getIntent().getStringExtra("nick_name"), KplHelper.a(this.app, this.jdField_d_of_type_JavaLangString));
      Object localObject = KplHelper.a(this.app);
      localObject = KplRoleInfo.WZRYUIinfo.createInfo(this.jdField_d_of_type_JavaLangString, paramArrayList, (String)localObject, 0, 0);
      if (localObject != null)
      {
        paramClass.putExtra("param_wzry_data", (Serializable)localObject);
        paramClass.putExtra("nick_name", paramArrayList);
      }
    }
    if (getIntent().getStringExtra("param_return_addr") != null)
    {
      startActivity(paramClass);
      finish();
      return;
    }
    startActivityForResult(paramClass, 1);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Intent localIntent = getIntent();
    boolean bool = false;
    if (localIntent != null) {
      bool = localIntent.getBooleanExtra("need_result_uin", false);
    }
    localIntent = paramIntent;
    if (bool)
    {
      localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.putExtra("uin", this.jdField_d_of_type_JavaLangString);
    }
    setResult(paramInt2, localIntent);
    finish();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("k_uin_type", 0);
    this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("uin");
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("last_activity");
    this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("src_name");
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("entrance", -1);
    String str = this.jdField_d_of_type_JavaLangString;
    if ((str != null) && (str.length() >= 5))
    {
      this.jdField_a_of_type_Int = hashCode();
      if (this.jdField_c_of_type_Int == 4) {
        return c();
      }
      return a();
    }
    this.jdField_d_of_type_Int = paramBundle.getIntExtra("source_id", 3999);
    int i = this.jdField_d_of_type_Int;
    if ((i != 3078) && (i != 3079))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "uin should not be null, activity finish");
      }
      super.finish();
      return false;
    }
    return b();
  }
  
  protected void doOnDestroy()
  {
    a(false);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    localObject = this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver;
    if (localObject != null) {
      removeObserver((BusinessObserver)localObject);
    }
    super.doOnDestroy();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected String setLastActivityName()
  {
    String str = this.jdField_b_of_type_JavaLangString;
    if (str != null) {
      return str;
    }
    return super.setLastActivityName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendLogicActivity
 * JD-Core Version:    0.7.0.1
 */