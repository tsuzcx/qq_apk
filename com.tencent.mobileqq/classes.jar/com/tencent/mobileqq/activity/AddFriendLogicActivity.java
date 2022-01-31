package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import rmu;
import rmv;
import rmw;
import rmx;
import rmy;
import rmz;
import rna;
import rnb;

public class AddFriendLogicActivity
  extends BaseActivity
{
  public static String a;
  public static boolean b;
  private int jdField_a_of_type_Int;
  public DialogInterface.OnClickListener a;
  public DialogInterface.OnDismissListener a;
  public Handler a;
  protected OpenIdObserver a;
  public QQCustomDialog a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private rnb jdField_a_of_type_Rnb;
  public boolean a;
  private int jdField_b_of_type_Int;
  public DialogInterface.OnClickListener b;
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public AddFriendLogicActivity()
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new rmw(this);
    this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new rmx(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new rmy(this);
    this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver = new rna(this);
  }
  
  public static Intent a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if ((paramInt2 == 3005) && (QLog.isColorLevel())) {
      QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "AddFriendLogicActivity.startAddFriend uin: %s extUin: %s", new Object[] { paramString1, paramString2 }));
    }
    Intent localIntent = new Intent(paramContext, AddFriendLogicActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("k_uin_type", paramInt1);
    localIntent.putExtra("extra", paramString2);
    localIntent.putExtra("source_id", paramInt2);
    localIntent.putExtra("sub_source_id", paramInt3);
    localIntent.putExtra("is_from_game", JumpAction.k);
    JumpAction.k = null;
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
        break label363;
      }
    }
    label363:
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
      StatisticCollector.a(paramContext).a(null, "addFriendSource", true, 0L, 0L, paramString2, null);
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "startAddFriend Extras = " + localIntent.getExtras().toString());
      }
      return localIntent;
    }
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, short paramShort, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return a(paramContext, paramString1, paramString2, paramShort, paramInt, paramString3, paramString4, paramString5, paramString6, null, null);
  }
  
  public static Intent a(Context paramContext, String paramString1, String paramString2, short paramShort, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
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
    paramContext.putExtra("key_param_homework_intro_str", paramString8);
    return paramContext;
  }
  
  public static Intent a(Context paramContext, List paramList, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
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
  
  private boolean a()
  {
    Object localObject1 = getIntent();
    this.jdField_c_of_type_Int = ((Intent)localObject1).getIntExtra("source_id", 3999);
    this.e = ((Intent)localObject1).getStringExtra("extra");
    if (!a(this.jdField_b_of_type_Int, this.jdField_d_of_type_JavaLangString)) {
      return false;
    }
    localObject1 = ((Intent)localObject1).getStringExtra("nick_name");
    if ((this.jdField_c_of_type_Int == 3004) && (localObject1 == null) && (!TextUtils.isEmpty(this.e)))
    {
      localObject1 = this.app.getEntityManagerFactory().createEntityManager();
      Object localObject2 = (TroopMemberInfo)((EntityManager)localObject1).a(TroopMemberInfo.class, new String[] { this.e, this.jdField_d_of_type_JavaLangString });
      if (localObject2 != null)
      {
        localObject2 = ((TroopMemberInfo)localObject2).friendnick;
        getIntent().putExtra("nick_name", (String)localObject2);
      }
      ((EntityManager)localObject1).a();
    }
    this.jdField_a_of_type_Rnb = new rnb(this, this);
    addObserver(this.jdField_a_of_type_Rnb);
    if (this.jdField_b_of_type_Int == 1) {
      ((FriendListHandler)this.app.a(1)).a("OidbSvc.0x476_147", Long.parseLong(this.jdField_d_of_type_JavaLangString), 147);
    }
    for (;;)
    {
      return true;
      if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
        c();
      } else {
        b();
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
      if (paramString.equals(this.app.getCurrentAccountUin()))
      {
        QQToast.a(this, 2131434444, 0).b(getTitleBarHeight());
        finish();
        return false;
      }
      try
      {
        Long.parseLong(paramString);
        if (((FriendsManager)this.app.getManager(50)).b(paramString))
        {
          QQToast.a(this.app.getApplication(), 2131434445, 0).b(getTitleBarHeight());
          finish();
          return false;
        }
      }
      catch (Throwable paramString)
      {
        return false;
      }
    case 2: 
      if (this.jdField_c_of_type_Int == 3999)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacts.", 2, "mobile source id is default!");
        }
        this.jdField_c_of_type_Int = 3006;
      }
      break;
    }
    while (!NetworkUtil.d(this))
    {
      QQToast.a(this.app.getApplication(), 2131434827, 0).b(getTitleBarHeight());
      finish();
      return false;
      if (this.jdField_c_of_type_Int == 3999)
      {
        this.jdField_c_of_type_Int = 3016;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacts.", 2, "openId source id is default!");
        }
      }
    }
    return true;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
    int i = getIntent().getIntExtra("sub_source_id", 0);
    localFriendListHandler.a(this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_Int, i, this.e, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131434449);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(new rmu(this));
    if (!isFinishing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  private boolean b()
  {
    if (!NetworkUtil.d(this))
    {
      QQToast.a(this.app.getApplication(), 2131434827, 0).b(getTitleBarHeight());
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
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
    }
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      if (this.e != null) {
        break label135;
      }
    }
    label135:
    for (OpenID localOpenID = null; (localOpenID == null) || (TextUtils.isEmpty(localOpenID.openID)); localOpenID = this.app.a().a(this.e))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131434449);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new rmv(this), 3000L);
      this.app.addObserver(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
      if (this.e != null) {
        this.app.a().d(this.e);
      }
      return;
    }
    if (!jdField_a_of_type_JavaLangString.equals(localOpenID.openID))
    {
      a();
      return;
    }
    b();
  }
  
  private boolean c()
  {
    Object localObject = getIntent();
    String str = ((Intent)localObject).getStringExtra("uin");
    int i = ((Intent)localObject).getShortExtra("group_option", (short)2);
    if (((TroopManager)this.app.getManager(51)).a(str) != null)
    {
      QQToast.a(this.app.getApplication(), 2131434446, 0).b(getTitleBarHeight());
      finish();
      return false;
    }
    if (i == 3)
    {
      localObject = getIntent().getStringExtra("nick_name");
      if ((localObject == null) || (((String)localObject).length() == 0)) {
        getString(2131433063);
      }
      QQToast.a(this.app.getApplication(), 2131434447, 0).b(getTitleBarHeight());
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
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_d_of_type_Int != 0))
    {
      localObject1 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertTitle", 147, this.jdField_d_of_type_Int);
      if (localObject1 == null) {
        break label506;
      }
    }
    label209:
    label229:
    label506:
    for (Object localObject1 = ((Bundle)localObject1).getString("AlertTitle");; localObject1 = null)
    {
      Object localObject2 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertText", 147, this.jdField_d_of_type_Int);
      if (localObject2 != null) {}
      for (Object localObject4 = ((Bundle)localObject2).getString("AlertText");; localObject4 = null)
      {
        localObject2 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertLeftBtnText", 147, this.jdField_d_of_type_Int);
        if (localObject2 != null) {}
        for (localObject2 = ((Bundle)localObject2).getString("AlertLeftBtnText");; localObject2 = null)
        {
          Object localObject3 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertRightBtnText", 147, this.jdField_d_of_type_Int);
          if (localObject3 != null) {}
          for (localObject3 = ((Bundle)localObject3).getString("AlertRightBtnText");; localObject3 = null)
          {
            Object localObject5 = localObject1;
            int i;
            if (localObject1 == null)
            {
              if (this.jdField_d_of_type_Int == 1)
              {
                i = 2131433000;
                localObject5 = getString(i);
              }
            }
            else
            {
              localObject1 = localObject4;
              if (localObject4 == null)
              {
                if (this.jdField_d_of_type_Int != 1) {
                  break label333;
                }
                localObject1 = getString(2131433002);
              }
              if (localObject2 != null) {
                break label432;
              }
              if (this.jdField_d_of_type_Int != 1) {
                break label420;
              }
              this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
              localObject4 = localObject2;
              if (localObject3 != null) {
                break label467;
              }
              if (this.jdField_d_of_type_Int != 1) {
                break label456;
              }
              localObject2 = getString(2131433008);
            }
            for (;;)
            {
              this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle((String)localObject5);
              this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage((CharSequence)localObject1);
              this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton((String)localObject4, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
              this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton((String)localObject2, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
              if ((this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener == null) || (this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener == null)) {
                this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131364069).setVisibility(8);
              }
              return;
              i = 2131433001;
              break;
              if (this.jdField_d_of_type_Int == 2)
              {
                localObject1 = getString(2131433003);
                break label209;
              }
              if (this.jdField_d_of_type_Int == 3)
              {
                localObject1 = getString(2131433004);
                break label209;
              }
              if (this.jdField_d_of_type_Int == 4)
              {
                localObject1 = getString(2131433005);
                break label209;
              }
              if (this.jdField_d_of_type_Int == 5)
              {
                localObject1 = getString(2131433006);
                break label209;
              }
              localObject1 = getString(2131433007);
              break label209;
              localObject4 = getString(2131433009);
              break label229;
              localObject4 = localObject2;
              if (!TextUtils.isEmpty(((String)localObject2).trim())) {
                break label229;
              }
              this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
              localObject4 = localObject2;
              break label229;
              localObject2 = getString(2131433010);
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
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131430027);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131430162);
    rmz localrmz = new rmz(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131433029, localrmz);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131430028, localrmz);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(int paramInt1, boolean paramBoolean, ArrayList paramArrayList, Class paramClass, int paramInt2)
  {
    paramClass = new Intent(this, paramClass);
    paramClass.putExtras(getIntent());
    paramClass.putExtra("param_mode", 0);
    paramClass.putExtra("friend_setting", paramInt1);
    paramClass.putExtra("contact_bothway", paramBoolean);
    paramClass.putExtra("user_question", paramArrayList);
    paramClass.putExtra("sort_id", this.jdField_c_of_type_Int);
    paramClass.putExtra("extra", this.e);
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("k_uin_type", 0);
    this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("uin");
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("last_activity");
    this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("src_name");
    if ((this.jdField_d_of_type_JavaLangString == null) || (this.jdField_d_of_type_JavaLangString.length() < 5))
    {
      this.jdField_c_of_type_Int = paramBundle.getIntExtra("source_id", 3999);
      if ((this.jdField_c_of_type_Int == 3078) || (this.jdField_c_of_type_Int == 3079)) {
        return b();
      }
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "uin should not be null, activity finish");
      }
      super.finish();
      return false;
    }
    this.jdField_a_of_type_Int = hashCode();
    if (this.jdField_b_of_type_Int == 4) {
      return c();
    }
    return a();
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_a_of_type_Rnb != null) {
      removeObserver(this.jdField_a_of_type_Rnb);
    }
    if (this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver != null) {
      removeObserver(this.jdField_a_of_type_ComTencentBizCommonUtilOpenIdObserver);
    }
    super.doOnDestroy();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
  
  protected String setLastActivityName()
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