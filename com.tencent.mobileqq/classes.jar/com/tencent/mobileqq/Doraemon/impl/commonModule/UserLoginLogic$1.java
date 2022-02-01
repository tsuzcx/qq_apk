package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.os.Bundle;
import com.tencent.mobileqq.Doraemon.ui.SdkAuthDialog;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.CardContainer.Permission;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse;
import com.tencent.protofile.sdkauthorize.SdkAuthorize.GetAuthApiListResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.observer.BusinessObserver;

class UserLoginLogic$1
  implements BusinessObserver
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
      }
      catch (Exception paramBundle)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d(UserLoginLogic.jdField_a_of_type_JavaLangString, 2, "parse auth info error: \n" + paramBundle.getMessage());
        }
        DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, -1, "parse auth info error");
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
      paramBundle = "";
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (CardContainer.Permission)this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_JavaUtilList.get(paramInt);
        paramBundle = paramBundle + ((CardContainer.Permission)localObject).jdField_a_of_type_JavaLangString + "\n";
        paramInt += 1;
      }
      UserLoginLogic.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic, paramBundle);
      return;
    }
    DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonImplCommonModuleUserLoginLogic.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, paramInt, "get auth info failure");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.UserLoginLogic.1
 * JD-Core Version:    0.7.0.1
 */