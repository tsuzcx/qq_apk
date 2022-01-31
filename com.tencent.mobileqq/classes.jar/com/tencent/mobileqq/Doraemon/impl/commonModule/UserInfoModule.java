package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.AppInfo;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.DoraemonAPIModule;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import mqq.app.AppRuntime;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import rcd;
import rce;
import rcf;
import rcg;
import rch;
import rcj;
import tencent.im.oidb.cmd0xb6e.Oidb_0xb6e.ReqBody;

public class UserInfoModule
  extends DoraemonAPIModule
  implements IEventReceiver
{
  public static final String a;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver;
  private rcj jdField_a_of_type_Rcj;
  
  static
  {
    jdField_a_of_type_JavaLangString = "DoraemonOpenAPI." + UserInfoModule.class.getSimpleName();
  }
  
  private void a(APIParam paramAPIParam, APICallback paramAPICallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString + ".requestAppFriends", 2, "url params = " + paramAPIParam);
    }
    paramAPIParam = new Oidb_0xb6e.ReqBody();
    paramAPIParam.appid.set(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.jdField_a_of_type_JavaLangString).intValue());
    paramAPIParam.openid.set(this.jdField_a_of_type_Rcj.jdField_a_of_type_JavaLangString);
    paramAPIParam.openkey.set(this.jdField_a_of_type_Rcj.b);
    paramAPIParam.platform.set("qzone");
    ProtoUtils.a(BaseApplicationImpl.getApplication().getRuntime(), new rcg(this, paramAPICallback), paramAPIParam.toByteArray(), "OidbSvc.0xb6e", 2926, 1, null, 0L);
  }
  
  private void b(APIParam paramAPIParam, APICallback paramAPICallback)
  {
    paramAPIParam = BaseApplicationImpl.getApplication().getRuntime();
    String str = paramAPIParam.getAccount();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    this.jdField_a_of_type_MqqObserverWtloginObserver = new rch(this, paramAPICallback);
    ((WtloginManager)paramAPIParam.getManager(1)).GetOpenKeyWithoutPasswd(str, 16L, l1, this.jdField_a_of_type_MqqObserverWtloginObserver);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rcj = null;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Rcj != null;
  }
  
  public boolean a(int paramInt, String paramString, APIParam paramAPIParam, @NonNull APICallback paramAPICallback)
  {
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      return false;
    case 5: 
      if (a())
      {
        DoraemonUtil.a(paramAPICallback, this.jdField_a_of_type_Rcj.a());
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString + "." + paramString, 2, "has login, use cache: " + this.jdField_a_of_type_Rcj.toString());
        }
        return true;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a();
      if (TextUtils.isEmpty(paramString.b))
      {
        paramString = "当前应用";
        this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a("用户授权", paramString, "允许", new rcd(this, paramAPIParam, paramAPICallback), "拒绝", new rce(this, paramAPICallback), new rcf(this, paramAPICallback));
      }
      break;
    }
    for (;;)
    {
      return true;
      paramString = paramString.b + "需要访问你的帐号进行登录";
      break;
      if (!a())
      {
        DoraemonUtil.a(paramAPICallback, 5);
        return true;
      }
      DoraemonUtil.a(paramAPICallback, 1, "get user info error, try again");
      continue;
      if (!a())
      {
        DoraemonUtil.a(paramAPICallback, 5);
        return true;
      }
      a(paramAPIParam, paramAPICallback);
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule
 * JD-Core Version:    0.7.0.1
 */