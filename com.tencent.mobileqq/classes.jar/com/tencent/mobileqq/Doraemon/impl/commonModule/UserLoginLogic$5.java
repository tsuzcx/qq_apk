package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.os.Bundle;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;

class UserLoginLogic$5
  implements OpensdkBusinessObserver
{
  UserLoginLogic$5(UserLoginLogic paramUserLoginLogic, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getString("ssoAccount");
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = UserLoginLogic.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("-->doAuthorize-onReceive, ssoAccount: ");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" | uin: ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" isSuccess: ");
      localStringBuilder.append(paramBoolean);
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_JavaLangString.equals(localObject1)) {
      return;
    }
    paramInt = paramBundle.getInt("code");
    if (paramBoolean)
    {
      localObject1 = new SdkAuthorize.AuthorizeResponse();
      try
      {
        paramBundle = (SdkAuthorize.AuthorizeResponse)((SdkAuthorize.AuthorizeResponse)localObject1).mergeFrom(paramBundle.getByteArray("data"));
        paramInt = paramBundle.ret.get();
        localObject1 = paramBundle.msg.get();
        if (paramInt != 0)
        {
          DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramInt, (String)localObject1);
          return;
        }
        localObject1 = new UserInfoModule.LoginInfo();
        ((UserInfoModule.LoginInfo)localObject1).jdField_a_of_type_JavaLangString = paramBundle.openid.get().toUpperCase();
        ((UserInfoModule.LoginInfo)localObject1).b = paramBundle.access_token.get().toUpperCase();
        paramBundle = paramBundle.callbackURL.get();
        QLog.isColorLevel();
        UserLoginLogic.b(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic, paramBundle);
        this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule.a((UserInfoModule.LoginInfo)localObject1);
        DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, ((UserInfoModule.LoginInfo)localObject1).a());
        return;
      }
      catch (Exception paramBundle)
      {
        if (QLog.isDevelopLevel())
        {
          localObject1 = UserLoginLogic.jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("parse do auth result error: \n");
          ((StringBuilder)localObject2).append(paramBundle.getMessage());
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, -2, "parse do auth result error");
        return;
      }
    }
    DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramInt, "do auth error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.UserLoginLogic.5
 * JD-Core Version:    0.7.0.1
 */