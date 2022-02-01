package com.tencent.mobileqq.activity;

import android.app.Activity;
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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class AddFriendLogicActivity
  extends BaseActivity
{
  public static String a;
  public static boolean b;
  private int jdField_a_of_type_Int;
  DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new AddFriendLogicActivity.3(this);
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new AddFriendLogicActivity.5(this);
  protected Handler a;
  protected OpenIdObserver a;
  private AddFriendLogicActivity.MyFriendListObserver jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity$MyFriendListObserver;
  protected QQCustomDialog a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  protected boolean a;
  private int jdField_b_of_type_Int = -1;
  DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new AddFriendLogicActivity.4(this);
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int = -1;
  private String jdField_e_of_type_JavaLangString;
  private int f;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_Boolean = false;
  }
  
  public AddFriendLogicActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver = new AddFriendLogicActivity.8(this);
  }
  
  public static Intent a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if (QLog.isColorLevel()) {
      QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "AddFriendLogicActivity.startAddFriend [type:%s, uin: %s, extUin: %s, source:%s, subSource:%s]", new Object[] { Integer.valueOf(paramInt1), Utils.a(paramString1), paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
    }
    Intent localIntent = new Intent(paramContext, AddFriendLogicActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("k_uin_type", paramInt1);
    localIntent.putExtra("extra", paramString2);
    localIntent.putExtra("source_id", paramInt2);
    localIntent.putExtra("sub_source_id", paramInt3);
    localIntent.putExtra("is_from_game", JumpAction.n);
    JumpAction.n = null;
    paramString1 = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1 = AutoRemarkActivity.a(paramString3);
    }
    localIntent.putExtra("nick_name", paramString1);
    paramString1 = paramString4;
    if (paramString4 != null)
    {
      paramString1 = paramString4;
      if (paramString4.length() > 30) {
        paramString1 = paramString4.substring(0, 28);
      }
    }
    localIntent.putExtra("msg", paramString1);
    localIntent.putExtra("param_return_addr", paramString5);
    localIntent.putExtra("last_activity", paramString6);
    localIntent.putExtra("src_name", paramString7);
    if (paramInt2 == 3999)
    {
      paramString2 = new HashMap(4);
      paramString2.put("act", paramContext.getClass().getSimpleName());
      if (BaseActivity.sTopActivity != null) {
        break label423;
      }
    }
    label423:
    for (paramString1 = "null";; paramString1 = BaseActivity.sTopActivity.toString())
    {
      paramString2.put("top", paramString1);
      if ((paramContext instanceof Activity))
      {
        paramString1 = ((Activity)paramContext).getIntent();
        if (paramString1 != null)
        {
          paramString2.put("intent", paramString1.toString());
          paramString1 = paramString1.getExtras();
          if (paramString1 != null) {
            paramString2.put("extra", paramString1.toString());
          }
        }
      }
      StatisticCollector.getInstance(paramContext).collectPerformance(null, "addFriendSource", true, 0L, 0L, paramString2, null);
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "startAddFriend Extras = " + localIntent.getExtras().toString());
      }
      if (QLog.isDebugVersion()) {
        QLog.d("addfriend", 2, "source =  " + paramInt2 + "subSource= " + paramInt3);
      }
      return localIntent;
    }
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
  
  public static Intent a(Context paramContext, List<PhoneContact> paramList, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, AddFriendLogicActivity.class);
    localIntent.putExtra("k_uin_type", 2);
    localIntent.putExtra("contacts", (Serializable)paramList);
    localIntent.putExtra("source_id", paramInt1);
    paramContext = paramString1;
    if (paramString1 != null)
    {
      paramContext = paramString1;
      if (paramString1.length() > 30) {
        paramContext = paramString1.substring(0, 28);
      }
    }
    localIntent.putExtra("msg", paramContext);
    localIntent.putExtra("last_activity", paramString2);
    localIntent.putExtra("src_name", paramString3);
    localIntent.putExtra("contact_from_type", paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "startMultiAddFriend Extras = " + localIntent.getExtras().toString());
    }
    return localIntent;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (getIntent() != null)
    {
      if (getIntent().getIntExtra("source_id", 3999) == 3090) {}
      try
      {
        ForwardSdkShareOption.a(this, true, "action_game_make_friend", Long.valueOf(getIntent().getStringExtra("extra")).longValue(), paramInt, paramString);
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("AddFriendLogicActivity", 1, "feedBackToGameSDK error = " + paramString);
        return;
      }
    }
    QLog.e("AddFriendLogicActivity", 1, "feedBackToGameSDK intent = null");
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "dismissOrHideProgress hide: " + paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.hide();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity$MyFriendListObserver = new AddFriendLogicActivity.MyFriendListObserver(this, this);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity$MyFriendListObserver);
    if (this.jdField_c_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("qqBaseActivity", 2, "queryUinSafetyFlag");
      }
      b();
      ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).queryUinSafetyFlag("OidbSvc.0x476_147", Long.parseLong(this.jdField_d_of_type_JavaLangString), 147);
    }
    for (;;)
    {
      return true;
      if (this.jdField_d_of_type_Int == 3024)
      {
        c();
        return true;
      }
      if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
        d();
      } else {
        c();
      }
    }
  }
  
  private boolean a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      finish();
      return false;
    case 1: 
      try
      {
        Long.parseLong(paramString);
        if (((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString))
        {
          QQToast.a(this.app.getApplication(), 2131690082, 0).b(getTitleBarHeight());
          finish();
          return false;
        }
      }
      catch (Throwable paramString)
      {
        return false;
      }
    case 2: 
      if (this.jdField_d_of_type_Int == 3999)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacts.", 2, "mobile source id is default!");
        }
        this.jdField_d_of_type_Int = 3006;
      }
      break;
    }
    while (!NetworkUtil.d(this))
    {
      QQToast.a(this.app.getApplication(), 2131694459, 0).b(getTitleBarHeight());
      finish();
      return false;
      if (this.jdField_d_of_type_Int == 3999)
      {
        this.jdField_d_of_type_Int = 3016;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacts.", 2, "openId source id is default!");
        }
      }
    }
    return true;
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131692970);
    if (!isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private boolean b()
  {
    if (!NetworkUtil.d(this))
    {
      QQToast.a(this.app.getApplication(), 2131694459, 0).b(getTitleBarHeight());
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
    }
    for (;;)
    {
      return true;
      startActivityForResult(localIntent, 1);
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "getAddFriendSetting");
    }
    b();
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    int i = getIntent().getIntExtra("sub_source_id", 0);
    localFriendListHandler.getUserAddFriendSetting(this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int, i, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  private boolean c()
  {
    Object localObject = getIntent();
    String str = ((Intent)localObject).getStringExtra("uin");
    int i = ((Intent)localObject).getShortExtra("group_option", (short)2);
    if (((TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(str) != null)
    {
      QQToast.a(this.app.getApplication(), 2131690079, 0).b(getTitleBarHeight());
      finish();
      return false;
    }
    if (i == 3)
    {
      localObject = getIntent().getStringExtra("nick_name");
      if ((localObject == null) || (((String)localObject).length() == 0)) {
        getString(2131693562);
      }
      QQToast.a(this.app.getApplication(), 2131720199, 0).b(getTitleBarHeight());
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
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      if (this.jdField_e_of_type_JavaLangString != null) {
        break label114;
      }
    }
    label114:
    for (OpenID localOpenID = null; (localOpenID == null) || (TextUtils.isEmpty(localOpenID.openID)); localOpenID = this.app.getMsgHandler().a(this.jdField_e_of_type_JavaLangString))
    {
      b();
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AddFriendLogicActivity.2(this), 3000L);
      this.app.addObserver(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
      if (this.jdField_e_of_type_JavaLangString != null) {
        this.app.getMsgHandler().d(this.jdField_e_of_type_JavaLangString);
      }
      return;
    }
    if (!jdField_a_of_type_JavaLangString.equals(localOpenID.openID))
    {
      a();
      return;
    }
    c();
  }
  
  private void e()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.f != 0))
    {
      localObject1 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertTitle", 147, this.f);
      if (localObject1 == null) {
        break label506;
      }
    }
    label209:
    label229:
    label506:
    for (Object localObject1 = ((Bundle)localObject1).getString("AlertTitle");; localObject1 = null)
    {
      Object localObject2 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertText", 147, this.f);
      if (localObject2 != null) {}
      for (Object localObject4 = ((Bundle)localObject2).getString("AlertText");; localObject4 = null)
      {
        localObject2 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertLeftBtnText", 147, this.f);
        if (localObject2 != null) {}
        for (localObject2 = ((Bundle)localObject2).getString("AlertLeftBtnText");; localObject2 = null)
        {
          Object localObject3 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertRightBtnText", 147, this.f);
          if (localObject3 != null) {}
          for (localObject3 = ((Bundle)localObject3).getString("AlertRightBtnText");; localObject3 = null)
          {
            Object localObject5 = localObject1;
            int i;
            if (localObject1 == null)
            {
              if (this.f == 1)
              {
                i = 2131718922;
                localObject5 = getString(i);
              }
            }
            else
            {
              localObject1 = localObject4;
              if (localObject4 == null)
              {
                if (this.f != 1) {
                  break label333;
                }
                localObject1 = getString(2131718923);
              }
              if (localObject2 != null) {
                break label432;
              }
              if (this.f != 1) {
                break label420;
              }
              this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
              localObject4 = localObject2;
              if (localObject3 != null) {
                break label467;
              }
              if (this.f != 1) {
                break label456;
              }
              localObject2 = getString(2131718917);
            }
            for (;;)
            {
              this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle((String)localObject5);
              this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage((CharSequence)localObject1);
              this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton((String)localObject4, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
              this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton((String)localObject2, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
              if ((this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null) || (this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener == null)) {
                this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131363901).setVisibility(8);
              }
              return;
              i = 2131718926;
              break;
              if (this.f == 2)
              {
                localObject1 = getString(2131718921);
                break label209;
              }
              if (this.f == 3)
              {
                localObject1 = getString(2131718925);
                break label209;
              }
              if (this.f == 4)
              {
                localObject1 = getString(2131718924);
                break label209;
              }
              if (this.f == 5)
              {
                localObject1 = getString(2131718919);
                break label209;
              }
              localObject1 = getString(2131718920);
              break label209;
              localObject4 = getString(2131718918);
              break label229;
              localObject4 = localObject2;
              if (!TextUtils.isEmpty(((String)localObject2).trim())) {
                break label229;
              }
              this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
              localObject4 = localObject2;
              break label229;
              localObject2 = getString(2131718916);
              continue;
              if (TextUtils.isEmpty(((String)localObject3).trim())) {
                this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = null;
              }
              localObject2 = localObject3;
            }
          }
        }
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
    localQQCustomDialog.setTitle(getString(2131689579));
    localQQCustomDialog.setMessage(getString(2131718507));
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    Window localWindow = localQQCustomDialog.getWindow();
    if (localWindow != null)
    {
      localWindow.setDimAmount(0.5F);
      localWindow.addFlags(2);
    }
    localQQCustomDialog.setPositiveButton(2131694615, new AddFriendLogicActivity.7(this)).setNegativeButton(null, null).show();
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131695214);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131692187);
      AddFriendLogicActivity.6 local6 = new AddFriendLogicActivity.6(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690800, local6);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131695183, local6);
    } while (isFinishing());
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  void a(int paramInt1, boolean paramBoolean, ArrayList<String> paramArrayList, Class<?> paramClass, int paramInt2)
  {
    this.jdField_e_of_type_Int = paramInt1;
    if ((this.jdField_d_of_type_Int == 3024) && (paramInt1 == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendLogicActivity", 2, "startVerifyActivity() from applets add friend and friendSetting is 0 ");
      }
      if (NetworkUtil.d(this))
      {
        paramArrayList = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        paramInt2 = getIntent().getIntExtra("sub_source_id", 0);
        paramArrayList.addFriend(this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, paramInt1, (byte)0, "", this.jdField_d_of_type_Int, paramInt2, false, null, false, null, this.jdField_c_of_type_JavaLangString, getIntent().getBundleExtra("flc_extra_param"), false);
        return;
      }
      QQToast.a(this.app.getApplication(), 2131694459, 0).b(getTitleBarHeight());
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
    if ((!paramClass.hasExtra("param_wzry_data")) && (KplRoleInfo.isKplSession(this.app, this, this.jdField_d_of_type_JavaLangString, paramInt2)))
    {
      paramArrayList = KplRoleInfo.WZRYUIinfo.buildNickName(getIntent().getStringExtra("nick_name"), KplRoleInfo.getGameNickByUin(this.app, this.jdField_d_of_type_JavaLangString));
      Object localObject = KplRoleInfo.getKplVerifyMsg(this.app);
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("k_uin_type", 0);
    this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("uin");
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("last_activity");
    this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("src_name");
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("entrance", -1);
    if ((this.jdField_d_of_type_JavaLangString == null) || (this.jdField_d_of_type_JavaLangString.length() < 5))
    {
      this.jdField_d_of_type_Int = paramBundle.getIntExtra("source_id", 3999);
      if ((this.jdField_d_of_type_Int == 3078) || (this.jdField_d_of_type_Int == 3079)) {
        return b();
      }
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "uin should not be null, activity finish");
      }
      super.finish();
      return false;
    }
    this.jdField_a_of_type_Int = hashCode();
    if (this.jdField_c_of_type_Int == 4) {
      return c();
    }
    return a();
  }
  
  public void doOnDestroy()
  {
    a(false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity$MyFriendListObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendLogicActivity$MyFriendListObserver);
    }
    if (this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
    }
    super.doOnDestroy();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = false;
    Intent localIntent = getIntent();
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
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public String setLastActivityName()
  {
    if (this.jdField_b_of_type_JavaLangString != null) {
      return this.jdField_b_of_type_JavaLangString;
    }
    return super.setLastActivityName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendLogicActivity
 * JD-Core Version:    0.7.0.1
 */