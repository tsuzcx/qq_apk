package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Handler;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.loginregister.ContactProxy;
import com.tencent.mobileqq.loginregister.IContactInterface;
import com.tencent.mobileqq.loginregister.IRegisterView;
import com.tencent.mobileqq.loginregister.LoginProgressClazz;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.logintempapi.ILoginApi;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant;
import com.tencent.mobileqq.vip.lianghao.RegisterLiangHaoHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.observer.AccountObserver;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;

public class AutoLoginHelper
  implements IRegisterView
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private RegisterNewBaseActivity jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity;
  private IContactInterface jdField_a_of_type_ComTencentMobileqqLoginregisterIContactInterface;
  private ILoginApi jdField_a_of_type_ComTencentMobileqqLogintempapiILoginApi;
  private RegisterLiangHaoHelper jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper = null;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public String a;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new AutoLoginHelper.2(this);
  WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new AutoLoginHelper.1(this);
  public boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  public String b;
  public boolean b;
  private byte[] b;
  public String c;
  public boolean c;
  private byte[] c;
  private String d;
  public boolean d;
  private String jdField_e_of_type_JavaLangString = null;
  private boolean jdField_e_of_type_Boolean = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = true;
  private boolean i = true;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  
  public AutoLoginHelper(AppRuntime paramAppRuntime, RegisterNewBaseActivity paramRegisterNewBaseActivity, Intent paramIntent)
  {
    this.jdField_b_of_type_JavaLangString = "86";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_b_of_type_ArrayOfByte = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity = paramRegisterNewBaseActivity;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentMobileqqLogintempapiILoginApi = ((ILoginApi)QRoute.api(ILoginApi.class));
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterIContactInterface = new ContactProxy();
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity == null) {}
    Object localObject;
    do
    {
      return;
      this.jdField_d_of_type_Boolean = true;
      localObject = new Intent();
      ((Intent)localObject).putExtra("tab_index", 0);
      ((Intent)localObject).putExtra("fragment_id", 1);
      ((Intent)localObject).putExtra("afterRegAndAutoLogin", true);
      ((Intent)localObject).addFlags(67108864);
      LoginUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, (Intent)localObject, "/base/start/splash");
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.finish();
      if (!(this.jdField_a_of_type_MqqAppAppRuntime instanceof AppInterface))
      {
        QLog.e("AutoLoginHelper", 1, "closeAllActs, app is not appinterface");
        return;
      }
      localObject = ((AppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getHandler(LoginProgressClazz.class);
    } while (localObject == null);
    ((MqqHandler)localObject).sendEmptyMessage(20140325);
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.handler.post(new AutoLoginHelper.3(this));
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.handler.post(new AutoLoginHelper.4(this));
  }
  
  private void m()
  {
    PhoneNumLoginImpl.a().a(true);
    PhoneNumLoginImpl.a().b(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverWtloginObserver);
  }
  
  public Intent a()
  {
    return this.jdField_a_of_type_AndroidContentIntent;
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      RegisterLHAssistant.a(getClass().getSimpleName(), a());
    }
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterIContactInterface.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, a());
    this.g = a().getBooleanExtra("key_register_from_quick_register", false);
    if (this.g) {
      this.jdField_e_of_type_JavaLangString = a().getStringExtra("key_register_secret_phone");
    }
    this.jdField_a_of_type_JavaLangString = a().getStringExtra("phonenum");
    this.jdField_c_of_type_JavaLangString = a().getStringExtra("invite_code");
    this.jdField_b_of_type_JavaLangString = a().getStringExtra("key");
    this.jdField_a_of_type_Boolean = a().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.jdField_b_of_type_Boolean = a().getBooleanExtra("key_register_has_pwd", true);
    this.jdField_d_of_type_JavaLangString = a().getStringExtra("uin");
    this.jdField_a_of_type_ArrayOfByte = a().getByteArrayExtra("key_register_sign");
    this.jdField_c_of_type_ArrayOfByte = a().getByteArrayExtra("resp_register_supersig");
    Locale localLocale;
    String str2;
    String str3;
    if (QLog.isDevelopLevel())
    {
      localLocale = Locale.getDefault();
      str2 = this.jdField_d_of_type_JavaLangString;
      str3 = com.tencent.qphone.base.util.MD5.toMD5(this.jdField_a_of_type_ArrayOfByte);
      if (this.jdField_c_of_type_JavaLangString != null) {
        break label344;
      }
    }
    label344:
    for (String str1 = "";; str1 = this.jdField_c_of_type_JavaLangString)
    {
      QLog.d("AutoLoginHelper", 4, String.format(localLocale, "onCreate  uin: %s, sign: %s inviteCode: %s", new Object[] { str2, str3, str1 }));
      str1 = a().getStringExtra("key_register_password");
      if (str1 != null) {
        this.jdField_b_of_type_ArrayOfByte = com.tencent.mobileqq.mqsafeedit.MD5.toMD5Byte(str1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoLoginHelper", 2, "onCreate ,pwd = " + str1 + ",mPassByte = " + this.jdField_b_of_type_ArrayOfByte);
      }
      this.f = a().getBooleanExtra("key_register_unbind", false);
      if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
        break;
      }
      QLog.d("AutoLoginHelper", 2, "onCreate app is null");
      return;
    }
    this.jdField_a_of_type_MqqAppAppRuntime.registObserver(this.jdField_a_of_type_ComTencentMobileqqLoginregisterIContactInterface.a(this));
    this.h = a().getBooleanExtra("key_register_result", true);
    this.i = a().getBooleanExtra("key_register_is_lh", false);
    if ((this.h) && (this.i))
    {
      this.k = false;
      this.l = true;
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper = new RegisterLiangHaoHelper(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, null);
      this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper.a(this.jdField_d_of_type_JavaLangString, new AutoLoginHelper.LHCallback(this));
    }
    this.jdField_d_of_type_Boolean = false;
    b();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (!paramString.equals(this.jdField_d_of_type_JavaLangString))) {
      return;
    }
    this.j = paramBoolean;
    if ((!this.j) && (this.k))
    {
      l();
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(2131716945, 0);
    }
    for (;;)
    {
      this.k = false;
      this.l = false;
      return;
      if ((this.j) && (this.k)) {
        if (this.f) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getAppRuntime().login(this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_MqqObserverAccountObserver);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqLoginregisterIContactInterface.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ArrayOfByte, this.jdField_d_of_type_JavaLangString);
        }
      }
    }
  }
  
  public void b()
  {
    if (!(this.jdField_a_of_type_MqqAppAppRuntime instanceof AppInterface)) {
      QLog.e("AutoLoginHelper", 1, "closeAllActs, app is not appinterface");
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (AppInterface)this.jdField_a_of_type_MqqAppAppRuntime;
        MqqHandler localMqqHandler = ((AppInterface)localObject).getHandler(RegisterPhoneNumActivity.class);
        if (localMqqHandler != null) {
          localMqqHandler.sendEmptyMessage(103);
        }
        localMqqHandler = ((AppInterface)localObject).getHandler(RegisterPersonalInfoActivity.class);
        if (localMqqHandler != null) {
          localMqqHandler.sendEmptyMessage(109);
        }
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity instanceof RegisterSendUpSms))
        {
          localMqqHandler = ((AppInterface)localObject).getHandler(RegisterSendUpSms.class);
          if (localMqqHandler != null) {
            localMqqHandler.sendEmptyMessage(107);
          }
        }
        if (!(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity instanceof RegisterVerifyCodeActivity))
        {
          localMqqHandler = ((AppInterface)localObject).getHandler(RegisterVerifyCodeActivity.class);
          if (localMqqHandler != null) {
            localMqqHandler.sendEmptyMessage(106);
          }
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity instanceof RegisterByNicknameAndPwdActivity));
      localObject = ((AppInterface)localObject).getHandler(RegisterByNicknameAndPwdActivity.class);
    } while (localObject == null);
    ((MqqHandler)localObject).sendEmptyMessage(110);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "onAccountChanged success");
    }
    if (this.f)
    {
      this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqLoginregisterIContactInterface.a(this));
      if (this.g)
      {
        this.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getAppRuntime();
        this.jdField_a_of_type_ComTencentMobileqqLoginregisterIContactInterface.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_d_of_type_JavaLangString);
      }
      k();
      j();
    }
    do
    {
      return;
      if (PhoneNumLoginImpl.a().a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AutoLoginHelper", 2, "onAccountChanged not phonenum login");
    return;
    this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqLoginregisterIContactInterface.a(this));
    this.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getAppRuntime();
    this.jdField_a_of_type_MqqAppAppRuntime.registObserver(this.jdField_a_of_type_ComTencentMobileqqLoginregisterIContactInterface.a(this));
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterIContactInterface.a(this.jdField_a_of_type_MqqAppAppRuntime);
    k();
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterIContactInterface.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_d_of_type_JavaLangString);
    j();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
      this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqLoginregisterIContactInterface.a(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.closeDialog();
    l();
  }
  
  public void e()
  {
    if (!this.h) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.finish();
      }
    }
    do
    {
      return;
      if (this.g) {
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X80072FC", "0X80072FC", 0, 0, "", "", "", "");
      }
      if (NetworkUtil.d(BaseApplication.getContext())) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.notifyToast(2131692257, 0);
    return;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    if ((this.i) && (!this.j))
    {
      if (!this.l)
      {
        this.l = true;
        if (this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper == null) {
          this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper = new RegisterLiangHaoHelper(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqVipLianghaoRegisterLiangHaoHelper.a(this.jdField_d_of_type_JavaLangString, new AutoLoginHelper.LHCallback(this));
      }
      this.k = true;
      k();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "bindUinWithPhone start to getVerifyBindPhoneUin");
    }
    k();
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_ArrayOfByte == null) {
        break label285;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AutoLoginHelper", 2, "swz mSign = " + HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte));
      }
    }
    while (this.f)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getAppRuntime().login(this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_ArrayOfByte, this.jdField_c_of_type_ArrayOfByte, this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
      label285:
      if (QLog.isColorLevel()) {
        QLog.d("AutoLoginHelper", 2, "swz mSign = null");
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AutoLoginHelper", 4, String.format(Locale.getDefault(), "onClick  uin: %s, sign: %s", new Object[] { this.jdField_d_of_type_JavaLangString, com.tencent.qphone.base.util.MD5.toMD5(this.jdField_a_of_type_ArrayOfByte) }));
    }
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterIContactInterface.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ArrayOfByte, this.jdField_d_of_type_JavaLangString);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoLoginHelper", 2, "onResume， isStartingMain=" + this.jdField_d_of_type_Boolean);
    }
    if (!this.jdField_d_of_type_Boolean) {
      l();
    }
  }
  
  public void g() {}
  
  public void h()
  {
    m();
  }
  
  public void i()
  {
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoLoginHelper
 * JD-Core Version:    0.7.0.1
 */