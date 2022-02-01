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
import com.tencent.mobileqq.Doraemon.ui.SdkAuthDialog;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb6e.Oidb_0xb6e.ReqBody;

public class UserInfoModule
  extends DoraemonAPIModule
{
  public static final String a;
  protected UserInfoModule.LoginInfo a;
  protected UserLoginLogic a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "DoraemonOpenAPI." + UserInfoModule.class.getSimpleName();
  }
  
  public static Bundle a()
  {
    Object localObject1 = PlayModeUtils.a();
    Object localObject2 = (FriendsManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
    String str5 = ((QQAppInterface)localObject1).getCurrentAccountUin();
    localObject2 = ((FriendsManager)localObject2).a(str5);
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
      localObject1 = ((QQAppInterface)localObject1).getQQHeadSettingFromDB(str5);
      if ((localObject1 != null) && (!TextUtils.isEmpty(((Setting)localObject1).url))) {
        localObject1 = MsfSdkUtils.insertMtype("QQHeadIcon", AvatarDownloadUtil.getQQAvatarDownLoadUrl(((Setting)localObject1).url, ((Setting)localObject1).bFaceFlags, ((Setting)localObject1).bUsrType, 0));
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
          break label255;
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
      label255:
      i = 0;
    }
  }
  
  private void a(JSONObject paramJSONObject, APICallback paramAPICallback)
  {
    if (DoraemonUtil.a())
    {
      paramJSONObject = a();
      if (paramJSONObject != null)
      {
        DoraemonUtil.a(paramAPICallback, APIParam.a(paramJSONObject));
        return;
      }
      DoraemonUtil.a(paramAPICallback, 1, "get user info error, try again");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString + ".requestUserInfo", 2, "not main process, send to main process");
    }
    DoraemonBridge.a(1, null, new UserInfoModule.1(this, paramAPICallback));
  }
  
  private void b(JSONObject paramJSONObject, APICallback paramAPICallback)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString + ".requestAppFriends", 2, "url params = " + paramJSONObject);
    }
    paramJSONObject = new Oidb_0xb6e.ReqBody();
    paramJSONObject.appid.set(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.jdField_a_of_type_JavaLangString).intValue());
    paramJSONObject.openid.set(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.jdField_a_of_type_JavaLangString);
    paramJSONObject.openkey.set(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.b);
    paramJSONObject.platform.set("openmobile_android");
    ProtoUtils.a(BaseApplicationImpl.getApplication().getRuntime(), new UserInfoModule.2(this, paramAPICallback), paramJSONObject.toByteArray(), "OidbSvc.0xb6e", 2926, 1, null, 0L);
  }
  
  public UserInfoModule.LoginInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo;
  }
  
  protected void a(UserInfoModule.LoginInfo paramLoginInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo = paramLoginInfo;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.b));
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
    case 17: 
    case 18: 
      do
      {
        do
        {
          return bool;
          if ((!a()) || (SdkAuthDialog.a)) {
            break;
          }
          DoraemonUtil.a(paramAPICallback, this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.a());
        } while (!QLog.isColorLevel());
        QLog.i(jdField_a_of_type_JavaLangString + "." + paramString, 2, "has login, use cache: " + this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.toString());
        return true;
        if (this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic == null) {
          this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic = new UserLoginLogic(this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this);
        }
        this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.a(paramJSONObject, paramAPICallback, false);
        return true;
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
      this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.a(paramJSONObject, paramAPICallback, true);
      return true;
    case 10: 
      if (!a())
      {
        DoraemonUtil.a(paramAPICallback, 5);
        return true;
      }
      a(paramJSONObject, paramAPICallback);
      return true;
    }
    if (!a())
    {
      DoraemonUtil.a(paramAPICallback, 5);
      return true;
    }
    b(paramJSONObject, paramAPICallback);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule
 * JD-Core Version:    0.7.0.1
 */