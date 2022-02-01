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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DoraemonOpenAPI.");
    localStringBuilder.append(UserInfoModule.class.getSimpleName());
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public static Bundle a()
  {
    Object localObject1 = PlayModeUtils.a();
    Object localObject2 = (FriendsManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject4 = ((QQAppInterface)localObject1).getCurrentAccountUin();
    Object localObject3 = ((FriendsManager)localObject2).a((String)localObject4);
    if (localObject3 != null)
    {
      localObject2 = ((Card)localObject3).strNick;
      int j = ((Card)localObject3).shGender;
      int i = 1;
      if (j != 0) {
        if (((Card)localObject3).shGender == 1) {
          i = 2;
        } else {
          i = 0;
        }
      }
      String str1 = ((Card)localObject3).strCity;
      String str2 = ((Card)localObject3).strProvince;
      localObject3 = ((Card)localObject3).strCountry;
      localObject1 = ((QQAppInterface)localObject1).getQQHeadSettingFromDB((String)localObject4);
      if ((localObject1 != null) && (!TextUtils.isEmpty(((Setting)localObject1).url)))
      {
        localObject1 = MsfSdkUtils.insertMtype("QQHeadIcon", AvatarDownloadUtil.getQQAvatarDownLoadUrl(((Setting)localObject1).url, ((Setting)localObject1).bFaceFlags, ((Setting)localObject1).bUsrType, 0));
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(".getUserInfoDirectly");
          QLog.i(((StringBuilder)localObject1).toString(), 2, "getUserInfo QQHeadSetting is empty");
        }
        localObject1 = "";
      }
      localObject4 = new Bundle();
      ((Bundle)localObject4).putString("nickName", (String)localObject2);
      ((Bundle)localObject4).putInt("gender", i);
      ((Bundle)localObject4).putString("avatarUrl", (String)localObject1);
      ((Bundle)localObject4).putString("city", str1);
      ((Bundle)localObject4).putString("province", str2);
      ((Bundle)localObject4).putString("country", (String)localObject3);
      if (QLog.isDevelopLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(".getUserInfoDirectly");
        QLog.i(((StringBuilder)localObject1).toString(), 2, ((Bundle)localObject4).toString());
      }
      return localObject4;
    }
    return null;
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
    if (QLog.isColorLevel())
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append(jdField_a_of_type_JavaLangString);
      paramJSONObject.append(".requestUserInfo");
      QLog.i(paramJSONObject.toString(), 2, "not main process, send to main process");
    }
    DoraemonBridge.a(1, null, new UserInfoModule.1(this, paramAPICallback));
  }
  
  private void b(JSONObject paramJSONObject, APICallback paramAPICallback)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(".requestAppFriends");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url params = ");
      localStringBuilder.append(paramJSONObject);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
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
    UserInfoModule.LoginInfo localLoginInfo = this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo;
    return (localLoginInfo != null) && (!TextUtils.isEmpty(localLoginInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.b));
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    if (paramInt != 5)
    {
      if (paramInt != 10)
      {
        if (paramInt != 17)
        {
          if (paramInt != 18) {
            return false;
          }
          if (a())
          {
            DoraemonUtil.a(paramAPICallback, this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.a());
            if (QLog.isColorLevel())
            {
              paramJSONObject = new StringBuilder();
              paramJSONObject.append(jdField_a_of_type_JavaLangString);
              paramJSONObject.append(".");
              paramJSONObject.append(paramString);
              paramString = paramJSONObject.toString();
              paramJSONObject = new StringBuilder();
              paramJSONObject.append("has login, use cache: ");
              paramJSONObject.append(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.toString());
              QLog.i(paramString, 2, paramJSONObject.toString());
            }
            return true;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic == null) {
            this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic = new UserLoginLogic(this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this);
          }
          this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.a(paramJSONObject, paramAPICallback, true);
          return true;
        }
        if ((a()) && (!SdkAuthDialog.a))
        {
          DoraemonUtil.a(paramAPICallback, this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.a());
          if (QLog.isColorLevel())
          {
            paramJSONObject = new StringBuilder();
            paramJSONObject.append(jdField_a_of_type_JavaLangString);
            paramJSONObject.append(".");
            paramJSONObject.append(paramString);
            paramString = paramJSONObject.toString();
            paramJSONObject = new StringBuilder();
            paramJSONObject.append("has login, use cache: ");
            paramJSONObject.append(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule$LoginInfo.toString());
            QLog.i(paramString, 2, paramJSONObject.toString());
          }
          return true;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic == null) {
          this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic = new UserLoginLogic(this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, this);
        }
        this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.a(paramJSONObject, paramAPICallback, false);
        return true;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule
 * JD-Core Version:    0.7.0.1
 */