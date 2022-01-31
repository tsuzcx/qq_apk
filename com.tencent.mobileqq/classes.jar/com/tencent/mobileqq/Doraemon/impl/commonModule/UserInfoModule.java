package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.DoraemonAPIModule;
import com.tencent.mobileqq.Doraemon.DoraemonBridge;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQHeadDownloadHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import rjm;
import rjn;
import tencent.im.oidb.cmd0xb6e.Oidb_0xb6e.ReqBody;

public class UserInfoModule
  extends DoraemonAPIModule
{
  public static final String a;
  public UserInfoModule.LoginInfo a;
  protected UserLoginLogic a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "DoraemonOpenAPI." + UserInfoModule.class.getSimpleName();
  }
  
  public static Bundle a()
  {
    Object localObject1 = PlayModeUtils.a();
    Object localObject2 = (FriendsManager)((QQAppInterface)localObject1).getManager(50);
    Object localObject3 = ((QQAppInterface)localObject1).getCurrentAccountUin();
    localObject2 = ((FriendsManager)localObject2).a((String)localObject3);
    String str1;
    int i;
    if (localObject2 != null)
    {
      str1 = ((Card)localObject2).strNick;
      if (((Card)localObject2).shGender == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      String str2 = ((Card)localObject2).strCity;
      String str3 = ((Card)localObject2).strProvince;
      String str4 = ((Card)localObject2).strCountry;
      localObject2 = "";
      localObject3 = ((QQAppInterface)localObject1).c((String)localObject3);
      if ((localObject3 != null) && (!TextUtils.isEmpty(((Setting)localObject3).url))) {
        localObject1 = MsfSdkUtils.insertMtype("QQHeadIcon", ((FriendListHandler)((QQAppInterface)localObject1).a(1)).a().a(((Setting)localObject3).url, ((Setting)localObject3).bFaceFlags, ((Setting)localObject3).bUsrType, 0));
      }
      for (;;)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("nickName", str1);
        ((Bundle)localObject2).putInt("gender", i);
        ((Bundle)localObject2).putString("avatarUrl", (String)localObject1);
        ((Bundle)localObject2).putString("city", str2);
        ((Bundle)localObject2).putString("province", str3);
        ((Bundle)localObject2).putString("country", str4);
        if (QLog.isDevelopLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString + ".getUserInfoDirectly", 2, ((Bundle)localObject2).toString());
        }
        return localObject2;
        if (((Card)localObject2).shGender != 1) {
          break label271;
        }
        i = 2;
        break;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i(jdField_a_of_type_JavaLangString + ".getUserInfoDirectly", 2, "getUserInfo QQHeadSetting is empty");
          localObject1 = localObject2;
        }
      }
      return null;
      label271:
      i = 0;
    }
  }
  
  private void a(APIParam paramAPIParam, APICallback paramAPICallback)
  {
    if (DoraemonUtil.a())
    {
      paramAPIParam = a();
      if (paramAPIParam != null)
      {
        DoraemonUtil.a(paramAPICallback, new APIParam(paramAPIParam));
        return;
      }
      DoraemonUtil.a(paramAPICallback, 1, "get user info error, try again");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString + ".requestUserInfo", 2, "not main process, send to main process");
    }
    DoraemonBridge.a(1, null, new rjm(this, paramAPICallback));
  }
  
  private void b(APIParam paramAPIParam, APICallback paramAPICallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString + ".requestAppFriends", 2, "url params = " + paramAPIParam);
    }
    paramAPIParam = new Oidb_0xb6e.ReqBody();
    paramAPIParam.appid.set(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.jdField_a_of_type_JavaLangString).intValue());
    paramAPIParam.openid.set(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.jdField_a_of_type_JavaLangString);
    paramAPIParam.openkey.set(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.b);
    paramAPIParam.platform.set("openmobile_android");
    ProtoUtils.a(BaseApplicationImpl.getApplication().getRuntime(), new rjn(this, paramAPICallback), paramAPIParam.toByteArray(), "OidbSvc.0xb6e", 2926, 1, null, 0L);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo = null;
  }
  
  public void a(UserInfoModule.LoginInfo paramLoginInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo = paramLoginInfo;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo != null;
  }
  
  public boolean a(int paramInt, String paramString, APIParam paramAPIParam, @NonNull APICallback paramAPICallback)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      bool = false;
    case 5: 
      do
      {
        return bool;
        if (!a()) {
          break;
        }
        DoraemonUtil.a(paramAPICallback, this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.a());
      } while (!QLog.isColorLevel());
      QLog.i(jdField_a_of_type_JavaLangString + "." + paramString, 2, "has login, use cache: " + this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.toString());
      return true;
      if (this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic == null) {
        this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic = new UserLoginLogic(this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this);
      }
      this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.a(paramAPIParam, paramAPICallback);
      return true;
    case 4: 
      if (!a())
      {
        DoraemonUtil.a(paramAPICallback, 5);
        return true;
      }
      a(paramAPIParam, paramAPICallback);
      return true;
    }
    if (!a())
    {
      DoraemonUtil.a(paramAPICallback, 5);
      return true;
    }
    b(paramAPIParam, paramAPICallback);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule
 * JD-Core Version:    0.7.0.1
 */