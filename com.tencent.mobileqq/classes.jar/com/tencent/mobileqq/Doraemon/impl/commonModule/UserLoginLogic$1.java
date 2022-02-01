package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.os.Bundle;
import com.tencent.mobileqq.Doraemon.ui.SdkAuthDialog;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.entity.Permission;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class UserLoginLogic$1
  implements OpensdkBusinessObserver
{
  UserLoginLogic$1(UserLoginLogic paramUserLoginLogic, String paramString, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("ssoAccount");
    if (!this.jdField_a_of_type_JavaLangString.equals(localObject)) {
      return;
    }
    paramInt = paramBundle.getInt("code");
    if (paramBoolean)
    {
      localObject = new SdkAuthorize.GetAuthApiListResponse();
      try
      {
        paramBundle = (SdkAuthorize.GetAuthApiListResponse)((SdkAuthorize.GetAuthApiListResponse)localObject).mergeFrom(paramBundle.getByteArray("data"));
        paramInt = paramBundle.ret.get();
        localObject = paramBundle.msg.get();
        if (paramInt != 0)
        {
          DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramInt, (String)localObject);
          return;
        }
        localObject = (SdkAuthorize.AuthorizeResponse)paramBundle.auth_response.get();
        if ((!SdkAuthDialog.jdField_a_of_type_Boolean) && (UserLoginLogic.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic, paramBundle)) && (localObject != null) && (((SdkAuthorize.AuthorizeResponse)localObject).has()))
        {
          paramBundle = new UserInfoModule.LoginInfo();
          paramBundle.jdField_a_of_type_JavaLangString = ((SdkAuthorize.AuthorizeResponse)localObject).openid.get().toUpperCase();
          paramBundle.jdField_b_of_type_JavaLangString = ((SdkAuthorize.AuthorizeResponse)localObject).access_token.get().toUpperCase();
          paramBundle.jdField_a_of_type_Long = ((SdkAuthorize.AuthorizeResponse)localObject).expires_in.get();
          paramBundle.jdField_b_of_type_Long = (paramBundle.jdField_a_of_type_Long + System.currentTimeMillis());
          this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserInfoModule.a(paramBundle);
          DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramBundle.a());
          return;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          UserLoginLogic.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic);
          return;
        }
        paramInt = 0;
        paramBundle = "";
        while (paramInt < this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_JavaUtilList.size())
        {
          localObject = (Permission)this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_JavaUtilList.get(paramInt);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramBundle);
          localStringBuilder.append(((Permission)localObject).jdField_a_of_type_JavaLangString);
          localStringBuilder.append("\n");
          paramBundle = localStringBuilder.toString();
          paramInt += 1;
        }
        UserLoginLogic.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic, paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        StringBuilder localStringBuilder;
        if (QLog.isDevelopLevel())
        {
          localObject = UserLoginLogic.jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("parse auth info error: \n");
          localStringBuilder.append(paramBundle.getMessage());
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, -1, "parse auth info error");
        return;
      }
    }
    DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramInt, "get auth info failure");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.UserLoginLogic.1
 * JD-Core Version:    0.7.0.1
 */