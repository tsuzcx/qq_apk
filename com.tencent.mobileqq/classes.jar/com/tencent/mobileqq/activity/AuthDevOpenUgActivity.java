package com.tencent.mobileqq.activity;

import acgo;
import acgp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import aqax;
import aqaz;
import aqbd;
import azqs;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.Ticket;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthDevOpenUgActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static boolean jdField_c_of_type_Boolean;
  private int jdField_a_of_type_Int;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private String jdField_a_of_type_JavaLangString;
  VerifyDevLockManager.VerifyDevLockObserver jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new acgp(this);
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new acgo(this);
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  
  private void a(String paramString)
  {
    for (;;)
    {
      int m;
      String str;
      try
      {
        paramString = new JSONObject(paramString);
        this.d = paramString.getString("title");
        this.e = paramString.getString("smallTitle");
        this.f = paramString.getString("guideTitle");
        paramString = paramString.getJSONArray("guideArray");
        if ((paramString != null) && (paramString.length() > 0))
        {
          m = 0;
          if (m < paramString.length())
          {
            str = paramString.getString(m);
            if (m == 0) {
              this.g = str;
            } else if (m == 1) {
              this.h = str;
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "parseJson error.");
        }
      }
      return;
      if (m == 2) {
        this.i = str;
      } else if (m == 3) {
        this.j = str;
      }
      m += 1;
    }
  }
  
  private void a(DevlockInfo paramDevlockInfo)
  {
    try
    {
      aqbd.a().a(null, this.app.getCurrentAccountUin(), 3);
      aqax localaqax = aqax.a();
      if ((localaqax != null) && (localaqax.a() == aqax.c))
      {
        String str2 = "";
        String str1 = str2;
        if (paramDevlockInfo != null)
        {
          str1 = str2;
          if (!TextUtils.isEmpty(paramDevlockInfo.Mobile)) {
            str1 = paramDevlockInfo.Mobile;
          }
        }
        localaqax.a(this, str1);
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        do
        {
          for (;;)
          {
            localException.printStackTrace();
          }
          if ((paramDevlockInfo == null) || (TextUtils.isEmpty(paramDevlockInfo.Mobile))) {
            break label444;
          }
          if ((paramDevlockInfo.AllowSet != 1) || (paramDevlockInfo.DevSetup == 1)) {
            break;
          }
          if (aqbd.a().a(this.app, this.app.getCurrentAccountUin(), "", null, this.jdField_a_of_type_MqqObserverWtloginObserver) != 0) {
            QQToast.a(getApplicationContext(), getString(2131692216), 0).b(getTitleBarHeight());
          }
        } while (!jdField_c_of_type_Boolean);
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, new Object[] { "h5call", "BIND_AND_CREDIT_NOT_OPEN_DEVLOCK" });
        aqbd.a().b(null, this.app.getCurrentAccountUin(), 9);
        finish();
        startActivity(new Intent(this, LoginInfoActivity.class));
        return;
        if (paramDevlockInfo.DevSetup != 1) {
          break;
        }
      } while (!jdField_c_of_type_Boolean);
      QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, new Object[] { "h5call", "OPENED_DEVLOCK" });
      finish();
      startActivity(new Intent(this, LoginInfoActivity.class));
      return;
      if (jdField_c_of_type_Boolean)
      {
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, new Object[] { "h5call", "BIND_BUT_CREDIT_NOT_OPEN_DEVLOCK" });
        aqbd.a().b(null, this.app.getCurrentAccountUin(), 7);
      }
      Intent localIntent = new Intent(this, AuthDevConfirmPhoneNoActivity.class);
      if (getIntent() != null) {
        localIntent.putExtra("devlock_need_broadcast", getIntent().getExtras().getBoolean("devlock_need_broadcast"));
      }
      localIntent.putExtra("ParaTextUp", this.i);
      localIntent.putExtra("ParaTextDown", this.j);
      localIntent.putExtra("PhoneNO", paramDevlockInfo.Mobile);
      localIntent.putExtra("mainaccount", this.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("from_where", this.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("DevlockInfo", paramDevlockInfo);
      startActivityForResult(localIntent, 1001);
      overridePendingTransition(0, 2130771997);
      return;
      label444:
      if (jdField_c_of_type_Boolean)
      {
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, new Object[] { "h5call", "NO_BIND_AND_NO_CREDIT_NOT_OPEN_DEVLOCK" });
        aqbd.a().b(null, this.app.getCurrentAccountUin(), 6);
      }
      aqaz.a(this, this.app, aqaz.c, 1003, null);
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    Object localObject1 = getIntent();
    if (localObject1 == null) {}
    do
    {
      return;
      localObject1 = ((Intent)localObject1).getExtras();
    } while ((localObject1 == null) || (!((Bundle)localObject1).containsKey("devlock_need_broadcast")) || (!((Bundle)localObject1).getBoolean("devlock_need_broadcast")));
    localObject1 = new Intent();
    ((Intent)localObject1).setAction("mqq.intent.action.DEVLOCK_ROAM");
    ((Intent)localObject1).putExtra("auth_dev_open", paramBoolean);
    ((Intent)localObject1).putExtra("auth_dev_open_cb_reason", paramInt);
    if (paramBoolean)
    {
      Object localObject2 = (WtloginManager)this.app.getManager(1);
      if (localObject2 != null)
      {
        localObject2 = ((WtloginManager)localObject2).GetLocalTicket(this.app.getCurrentAccountUin(), 16L, 33554432);
        if (localObject2 != null) {
          ((Intent)localObject1).putExtra("devlock_roam_sig", ((Ticket)localObject2)._sig);
        }
      }
    }
    sendBroadcast((Intent)localObject1, "com.tencent.msg.permission.pushnotify");
  }
  
  public static boolean a()
  {
    return jdField_c_of_type_Boolean;
  }
  
  private boolean a(Bundle paramBundle)
  {
    return "true".equals(paramBundle.getString("AUTH_DEV_OPEN_UG_ACTIVITY"));
  }
  
  private void b(String paramString)
  {
    Object localObject = (TextView)findViewById(2131367422);
    if (TextUtils.isEmpty(paramString))
    {
      ((TextView)localObject).setVisibility(8);
      localObject = this.jdField_a_of_type_AndroidWidgetButton;
      if (TextUtils.isEmpty(this.e)) {
        break label178;
      }
    }
    label178:
    for (paramString = this.e;; paramString = getString(2131692209))
    {
      ((Button)localObject).setText(paramString);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131692167));
      if (!TextUtils.isEmpty(this.f)) {
        setTitle(this.f);
      }
      if (this.jdField_b_of_type_Int != 0)
      {
        paramString = (ImageView)findViewById(2131367407);
        if (paramString != null) {
          paramString.setImageResource(this.jdField_b_of_type_Int);
        }
      }
      if (!TextUtils.isEmpty(this.k))
      {
        paramString = (Button)findViewById(2131367408);
        if (paramString != null)
        {
          paramString.setVisibility(0);
          paramString.setText(this.k);
          paramString.setOnClickListener(this);
        }
      }
      aqbd.a().a(null, this.app.getCurrentAccountUin(), 1);
      return;
      ((TextView)localObject).setText(paramString);
      break;
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    if (getIntent().getBooleanExtra("open_devlock_from_roam", false))
    {
      finish();
      overridePendingTransition(2130771977, 2130771978);
      return;
    }
    finish();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001) {
      if (paramInt2 == -1)
      {
        if ((paramIntent == null) || (paramIntent.getExtras().getInt("requestCode") != 1002)) {
          break label46;
        }
        a(-1, paramIntent);
      }
    }
    label46:
    label835:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  aqax.a().a(aqax.d);
                  a(true, 0);
                  if (aqbd.a().a())
                  {
                    paramIntent = new Intent(this, AuthDevEnableCompleteActivity.class);
                    if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
                    {
                      paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
                      paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
                    }
                    if (jdField_c_of_type_Boolean) {
                      paramIntent.putExtra("h5_flag", true);
                    }
                    startActivity(paramIntent);
                  }
                  for (;;)
                  {
                    paramIntent = new Intent();
                    paramIntent.putExtra("allow_set", true);
                    if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
                      paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
                    }
                    a(-1, paramIntent);
                    return;
                    if (this.jdField_b_of_type_Boolean)
                    {
                      paramIntent = new Intent(this, AuthDevActivity.class);
                      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
                      {
                        paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
                        paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
                      }
                      if (getIntent() != null) {
                        paramIntent.putExtra("devlock_need_broadcast", getIntent().getExtras().getBoolean("devlock_need_broadcast"));
                      }
                      paramIntent.putExtra("auth_dev_open", true);
                      if (jdField_c_of_type_Boolean) {
                        paramIntent.putExtra("h5_flag", true);
                      }
                      startActivity(paramIntent);
                    }
                  }
                  if (paramInt1 != 1002) {
                    break;
                  }
                } while (paramInt2 != -1);
                finish();
                return;
                if (paramInt1 != 1003) {
                  break label835;
                }
                if ((paramIntent == null) || (paramIntent.getExtras() == null)) {
                  break;
                }
                paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultState =" + paramInt1);
                }
              } while (paramInt1 != 2);
              String str = paramIntent.getExtras().getString("resultMobileMask");
              bool = paramIntent.getExtras().getBoolean("resultSetMobile");
              if (QLog.isColorLevel()) {
                QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onActivityResult.resultCode= RESULT_OK  resultMobileMask =" + str + " openSuccess=" + bool);
              }
              if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
                this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = str;
              }
            } while (!bool);
            aqbd.a().a(this.app, this, this.app.getCurrentAccountUin(), true);
            a(true, 0);
            boolean bool = aqbd.a().a();
            paramIntent = new Intent(getIntent());
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
            {
              paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
              paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
            }
            if (bool)
            {
              paramIntent.setClass(this, AuthDevEnableCompleteActivity.class);
              startActivity(paramIntent);
            }
            for (;;)
            {
              QQToast.a(getApplicationContext(), 2, getString(2131692161), 0).b(getTitleBarHeight());
              paramIntent = new Intent();
              paramIntent.putExtra("auth_dev_open", true);
              paramIntent.putExtra("allow_set", true);
              if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
                paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
              }
              a(-1, paramIntent);
              return;
              if (this.jdField_b_of_type_Boolean)
              {
                paramIntent.setClass(this, AuthDevActivity.class);
                paramIntent.putExtra("auth_dev_open", true);
                startActivity(paramIntent);
              }
            }
          } while ((paramInt2 != 0) || (paramIntent == null) || (paramIntent.getExtras() == null));
          paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onActivityResult.resultCode= RESULT_CANCELED resultState =" + paramInt1);
          }
        } while (paramInt1 != 2);
        paramIntent = paramIntent.getExtras().getString("resultMobileMask");
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onActivityResult.resultCode= RESULT_CANCELED resultMobileMask =" + paramIntent);
        }
        if (!TextUtils.isEmpty(paramIntent)) {
          aqbd.a().a(this.app, this.app.getCurrentAccountUin(), null);
        }
      } while (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null);
      this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = paramIntent;
      return;
    } while (paramInt1 != 1004);
    if (paramInt2 == 3000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "verify passwd failed");
      }
      a(false, 3);
      finish();
      overridePendingTransition(2130771977, 2130771978);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "verify passwd succ");
    }
    if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
    {
      aqbd.a().a(this.app, this.app.getCurrentAccountUin(), this.jdField_a_of_type_MqqObserverWtloginObserver);
      return;
    }
    a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject = super.getIntent();
    if (localObject == null)
    {
      super.doOnCreate(paramBundle);
      finish();
      return false;
    }
    Bundle localBundle = ((Intent)localObject).getExtras();
    if (localBundle == null)
    {
      super.doOnCreate(paramBundle);
      finish();
      return false;
    }
    jdField_c_of_type_Boolean = a(localBundle);
    aqbd.a().a(false);
    localObject = localBundle.getString("devlock_open_source");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = "Manually";
    }
    for (;;)
    {
      aqbd.a().a((String)localObject);
      this.jdField_a_of_type_Boolean = localBundle.getBoolean("from_login");
      this.jdField_a_of_type_Int = localBundle.getInt("seq");
      this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)localBundle.get("DevlockInfo"));
      this.jdField_a_of_type_JavaLangString = localBundle.getString("uin");
      this.jdField_b_of_type_JavaLangString = localBundle.getString("from_where");
      this.jdField_c_of_type_JavaLangString = localBundle.getString("mainaccount");
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onCreate mIsFromLogin = " + this.jdField_a_of_type_Boolean + " mVerifySeq=" + this.jdField_a_of_type_Int + " mUin=" + this.jdField_a_of_type_JavaLangString + " mFromWhere=" + this.jdField_b_of_type_JavaLangString + " mMainAccount=" + this.jdField_c_of_type_JavaLangString);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
        {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onCreate DevlockInfo devSetup:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup + " countryCode:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode + " mobile:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile + " MbItemSmsCodeStatus:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.TimeLimit + " AvailableMsgCount:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AvailableMsgCount + " AllowSet:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet);
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "DevlockInfo.ProtectIntro:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro + "  info.MbGuideType:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideType);
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "DevlockInfo.MbGuideMsg:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideMsg);
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "DevlockInfo.MbGuideInfoType:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfoType);
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "DevlockInfo.MbGuideInfo:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo);
        }
      }
      super.doOnCreate(paramBundle);
      super.setContentView(2131560925);
      super.setTitle(2131692213);
      if (this.app == null) {
        this.app = ((QQAppInterface)getAppRuntime());
      }
      if (this.app == null)
      {
        super.doOnCreate(paramBundle);
        finish();
        return false;
      }
      if (TextUtils.equals((CharSequence)localObject, "PhoneUnity")) {
        this.leftView.setText(2131699798);
      }
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131379231));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_Boolean = localBundle.getBoolean("devlock_show_auth_dev_list", true);
      paramBundle = localBundle.getString("devlock_guide_config");
      if (!TextUtils.isEmpty(paramBundle)) {}
      for (;;)
      {
        try
        {
          paramBundle = new JSONObject(paramBundle);
          this.f = paramBundle.getString("title");
          this.d = paramBundle.getString("wording");
          this.jdField_b_of_type_Int = paramBundle.getInt("image_res_id");
          this.e = paramBundle.getString("btn_text");
          this.k = paramBundle.getString("jump_text");
          if (TextUtils.isEmpty(this.d)) {
            this.d = getString(2131692208);
          }
          if (TextUtils.isEmpty(this.g)) {
            this.g = getString(2131692185);
          }
          if (TextUtils.isEmpty(this.h)) {
            this.h = getString(2131692186);
          }
          if (TextUtils.isEmpty(this.i)) {
            this.i = getString(2131692182);
          }
          if (TextUtils.isEmpty(this.j)) {
            this.j = getString(2131692183);
          }
          if (TextUtils.isEmpty(this.f)) {
            this.f = getString(2131692188);
          }
          b(this.d);
          this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(this.jdField_a_of_type_Int);
          return true;
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
          continue;
        }
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
          a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro);
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    if (getIntent().getBooleanExtra("from_risk_hint", false))
    {
      getIntent().removeExtra("from_risk_hint");
      Intent localIntent = new Intent(this, LoginInfoActivity.class);
      localIntent.putExtra("from_risk_hint", true);
      startActivity(localIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    a(false, 1);
    Intent localIntent = new Intent();
    localIntent.putExtra("auth_dev_open", false);
    if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))) {
      localIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
    }
    a(0, localIntent);
    if (jdField_c_of_type_Boolean) {
      startActivity(new Intent(this, LoginInfoActivity.class));
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364091: 
      if (this.app != null) {
        this.app.sendWirelessMeibaoReq(1);
      }
      if (mAppForground)
      {
        if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.equals("subaccount")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "subaccount enter webview mUin=" + this.jdField_a_of_type_JavaLangString + " mMainAccount=" + this.jdField_c_of_type_JavaLangString);
          }
          if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (QLog.isColorLevel())) {
            QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "mUin is empty.");
          }
          aqaz.a(this, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, aqaz.jdField_a_of_type_Int);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "mainaccount enter webview mUin=" + this.jdField_a_of_type_JavaLangString);
        }
        if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (QLog.isColorLevel())) {
          QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "mUin is empty.");
        }
        aqaz.a(this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, aqaz.jdField_a_of_type_Int);
        return;
      }
      aqaz.a(this, this.app, aqaz.jdField_a_of_type_Int);
      return;
    case 2131379231: 
      azqs.b(null, "dc00898", "", "", "0X800A71F", "0X800A71F", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("DevRpt", 2, "点击打开设备锁上报！0X800A71F");
      }
      if (getIntent().getBooleanExtra("open_devlock_verify_passwd", false))
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", "http://mapp.3g.qq.com/touch/psw/verify.jsp?_wv=5123&type=history&from=[from]".replace("[from]", "open_devlock"));
        startActivityForResult(paramView, 1004);
      }
      for (;;)
      {
        paramView = getIntent().getStringExtra("devlock_open_source");
        if ((TextUtils.isEmpty(paramView)) || ((!paramView.equals("RoamMsg")) && (!paramView.equals("RoamMsgWeb")))) {
          break;
        }
        VipUtils.a(this.app, "chat_history", "LockSet", "Clk_buttonUse", 1, 0, new String[0]);
        return;
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) {
          aqbd.a().a(this.app, this.app.getCurrentAccountUin(), this.jdField_a_of_type_MqqObserverWtloginObserver);
        } else {
          a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
        }
      }
    case 2131368655: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.AuthDevOpenUgActivity", 2, "onClick.cancelVerifyCode mVerifyObserver.seq=" + this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.getSeq());
      }
      aqbd.a().a(this.app, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
      this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = null;
      finish();
      overridePendingTransition(0, 2130772001);
    }
    a(false, 2);
    finish();
    overridePendingTransition(2130771977, 2130771978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevOpenUgActivity
 * JD-Core Version:    0.7.0.1
 */