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
  private byte[] A;
  private ILoginApi B;
  private IContactInterface C;
  public String a;
  public String b = "86";
  public String c;
  public boolean d = false;
  public boolean e = true;
  public boolean f = false;
  public boolean g = false;
  WtloginObserver h = new AutoLoginHelper.1(this);
  protected AccountObserver i = new AutoLoginHelper.2(this);
  private String j = null;
  private byte[] k = null;
  private byte[] l = null;
  private boolean m = false;
  private boolean n = false;
  private QQProgressDialog o;
  private boolean p = false;
  private String q = null;
  private boolean r = true;
  private boolean s = true;
  private boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private RegisterLiangHaoHelper w = null;
  private Intent x;
  private AppRuntime y;
  private RegisterNewBaseActivity z;
  
  public AutoLoginHelper(AppRuntime paramAppRuntime, RegisterNewBaseActivity paramRegisterNewBaseActivity, Intent paramIntent)
  {
    this.y = paramAppRuntime;
    this.z = paramRegisterNewBaseActivity;
    this.x = paramIntent;
    this.B = ((ILoginApi)QRoute.api(ILoginApi.class));
    this.C = new ContactProxy();
  }
  
  private void o()
  {
    PhoneNumLoginImpl.a().a(true);
    PhoneNumLoginImpl.a().b(this.y, this.b, this.a, this.h);
  }
  
  public Intent a()
  {
    return this.x;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      if (!paramString.equals(this.j)) {
        return;
      }
      this.t = paramBoolean;
      if ((!this.t) && (this.u))
      {
        j();
        this.z.notifyToast(2131914061, 0);
      }
      else if ((this.t) && (this.u))
      {
        if (this.n) {
          this.z.getAppRuntime().login(this.j, this.l, this.i);
        } else {
          this.C.a(this.y, this.k, this.j);
        }
      }
      this.u = false;
      this.v = false;
    }
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      RegisterLHAssistant.a(getClass().getSimpleName(), a());
    }
    this.C.a(this.z, a());
    this.p = a().getBooleanExtra("key_register_from_quick_register", false);
    if (this.p) {
      this.q = a().getStringExtra("key_register_secret_phone");
    }
    this.a = a().getStringExtra("phonenum");
    this.c = a().getStringExtra("invite_code");
    this.b = a().getStringExtra("key");
    this.d = a().getBooleanExtra("key_register_is_phone_num_registered", false);
    this.e = a().getBooleanExtra("key_register_has_pwd", true);
    this.j = a().getStringExtra("uin");
    this.k = a().getByteArrayExtra("key_register_sign");
    this.A = a().getByteArrayExtra("resp_register_supersig");
    Object localObject2;
    if (QLog.isDevelopLevel())
    {
      Locale localLocale = Locale.getDefault();
      String str1 = this.j;
      String str2 = com.tencent.qphone.base.util.MD5.toMD5(this.k);
      localObject2 = this.c;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      QLog.d("AutoLoginHelper", 4, String.format(localLocale, "onCreate  uin: %s, sign: %s inviteCode: %s", new Object[] { str1, str2, localObject1 }));
    }
    Object localObject1 = a().getStringExtra("key_register_password");
    if (localObject1 != null) {
      this.l = com.tencent.mobileqq.mqsafeedit.MD5.toMD5Byte((String)localObject1);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onCreate ,pwd = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(",mPassByte = ");
      ((StringBuilder)localObject2).append(this.l);
      QLog.d("AutoLoginHelper", 2, ((StringBuilder)localObject2).toString());
    }
    this.n = a().getBooleanExtra("key_register_unbind", false);
    localObject1 = this.y;
    if (localObject1 == null)
    {
      QLog.d("AutoLoginHelper", 2, "onCreate app is null");
      return;
    }
    ((AppRuntime)localObject1).registObserver(this.C.a(this));
    this.r = a().getBooleanExtra("key_register_result", true);
    this.s = a().getBooleanExtra("key_register_is_lh", false);
    if ((this.r) && (this.s))
    {
      this.u = false;
      this.v = true;
      this.w = new RegisterLiangHaoHelper(this.z, null);
      this.w.a(this.j, new AutoLoginHelper.LHCallback(this));
    }
    this.g = false;
    c();
  }
  
  public void c()
  {
    Object localObject = this.y;
    if (!(localObject instanceof AppInterface))
    {
      QLog.e("AutoLoginHelper", 1, "closeAllActs, app is not appinterface");
      return;
    }
    localObject = (AppInterface)localObject;
    MqqHandler localMqqHandler = ((AppInterface)localObject).getHandler(RegisterPhoneNumActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(103);
    }
    localMqqHandler = ((AppInterface)localObject).getHandler(RegisterPersonalInfoActivity.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(109);
    }
    if (!(this.z instanceof RegisterSendUpSms))
    {
      localMqqHandler = ((AppInterface)localObject).getHandler(RegisterSendUpSms.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(107);
      }
    }
    if (!(this.z instanceof RegisterVerifyCodeActivity))
    {
      localMqqHandler = ((AppInterface)localObject).getHandler(RegisterVerifyCodeActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(106);
      }
    }
    if (!(this.z instanceof RegisterByNicknameAndPwdActivity))
    {
      localObject = ((AppInterface)localObject).getHandler(RegisterByNicknameAndPwdActivity.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendEmptyMessage(110);
      }
    }
  }
  
  protected void d()
  {
    if (this.z == null) {
      return;
    }
    this.g = true;
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("tab_index", 0);
    ((Intent)localObject).putExtra("fragment_id", 1);
    ((Intent)localObject).putExtra("afterRegAndAutoLogin", true);
    ((Intent)localObject).addFlags(67108864);
    LoginUtils.a(this.z, (Intent)localObject, "/base/start/splash");
    this.z.finish();
    localObject = this.y;
    if (!(localObject instanceof AppInterface))
    {
      QLog.e("AutoLoginHelper", 1, "closeAllActs, app is not appinterface");
      return;
    }
    localObject = ((AppInterface)localObject).getHandler(LoginProgressClazz.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(2004);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "onAccountChanged success");
    }
    if (this.n)
    {
      this.y.unRegistObserver(this.C.a(this));
      if (this.p)
      {
        this.y = this.z.getAppRuntime();
        this.C.a(this.y, this.j);
      }
      i();
      d();
      return;
    }
    if (!PhoneNumLoginImpl.a().b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AutoLoginHelper", 2, "onAccountChanged not phonenum login");
      }
      return;
    }
    this.y.unRegistObserver(this.C.a(this));
    this.y = this.z.getAppRuntime();
    this.y.registObserver(this.C.a(this));
    this.C.a(this.y);
    i();
    this.C.a(this.y, this.j);
    d();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "onDestroy");
    }
    AppRuntime localAppRuntime = this.y;
    if (localAppRuntime != null) {
      localAppRuntime.unRegistObserver(this.C.a(this));
    }
    this.z.closeDialog();
    j();
  }
  
  public void g()
  {
    Object localObject;
    if (!this.r)
    {
      localObject = this.z;
      if (localObject != null) {
        ((RegisterNewBaseActivity)localObject).finish();
      }
      return;
    }
    if (this.p) {
      ReportController.a(this.y, "dc00898", "", "", "0X80072FC", "0X80072FC", 0, 0, "", "", "", "");
    }
    if (!h())
    {
      localObject = this.z;
      if (localObject != null) {
        ((RegisterNewBaseActivity)localObject).notifyToast(2131889169, 0);
      }
      return;
    }
    this.f = true;
    this.g = false;
    if ((this.s) && (!this.t))
    {
      if (!this.v)
      {
        this.v = true;
        if (this.w == null) {
          this.w = new RegisterLiangHaoHelper(this.z, null);
        }
        this.w.a(this.j, new AutoLoginHelper.LHCallback(this));
      }
      this.u = true;
      i();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AutoLoginHelper", 2, "bindUinWithPhone start to getVerifyBindPhoneUin");
    }
    i();
    if (QLog.isColorLevel()) {
      if (this.k != null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("swz mSign = ");
          ((StringBuilder)localObject).append(HexUtil.bytes2HexStr(this.k));
          QLog.d("AutoLoginHelper", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("AutoLoginHelper", 2, "swz mSign = null");
      }
    }
    if (this.n)
    {
      this.z.getAppRuntime().login(this.j, this.l, this.A, this.i);
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("AutoLoginHelper", 4, String.format(Locale.getDefault(), "onClick  uin: %s, sign: %s", new Object[] { this.j, com.tencent.qphone.base.util.MD5.toMD5(this.k) }));
    }
    this.C.a(this.y, this.k, this.j);
  }
  
  protected boolean h()
  {
    return NetworkUtil.isNetSupport(BaseApplication.getContext());
  }
  
  protected void i()
  {
    this.z.handler.post(new AutoLoginHelper.3(this));
  }
  
  protected void j()
  {
    this.z.handler.post(new AutoLoginHelper.4(this));
  }
  
  public void k()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResume， isStartingMain=");
      localStringBuilder.append(this.g);
      QLog.i("AutoLoginHelper", 2, localStringBuilder.toString());
    }
    if (!this.g) {
      j();
    }
  }
  
  public void l() {}
  
  public void m()
  {
    o();
  }
  
  public void n()
  {
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoLoginHelper
 * JD-Core Version:    0.7.0.1
 */