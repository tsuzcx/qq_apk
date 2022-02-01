package com.tencent.mobileqq.apollo.web;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;
import cooperation.vip.manager.QZoneVipInfoManager;

class CmShowWebIPCModule$5
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  CmShowWebIPCModule$5(CmShowWebIPCModule paramCmShowWebIPCModule, int paramInt1, QQAppInterface paramQQAppInterface, String paramString1, int paramInt2, boolean paramBoolean, String paramString2, String paramString3, String paramString4, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    paramString = new Bundle();
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Int == 1)
      {
        paramArrayOfInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt = ((IApolloDaoManagerService)paramArrayOfInt.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          int i;
          if (paramArrayOfInt != null)
          {
            paramInt2 = paramArrayOfInt.apolloVipFlag;
            i = paramArrayOfInt.apolloVipLevel;
          }
          else
          {
            i = 0;
            paramInt2 = 0;
          }
          paramString.putInt("apollo_apolloVipFlag", paramInt2);
          paramString.putInt("apollo_apolloVipLevel", i);
        }
      }
      paramString.putBoolean("apollo_is_super_yellow", QZoneVipInfoManager.a().a());
      paramString.putInt("apollo_result", 0);
      paramString.putInt("apollo_partnerRoleId", paramInt1);
      paramString.putString("apollo_json", this.jdField_a_of_type_JavaLangString);
      paramString.putInt("apollo_previewAction", this.jdField_b_of_type_Int);
      paramString.putBoolean("apollo_previewOnFrame", this.jdField_a_of_type_Boolean);
      paramString.putString("apollo_id", this.jdField_b_of_type_JavaLangString);
      paramString.putString("title", this.c);
      paramString.putString("subTitle", this.d);
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramString);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    paramString.putInt("apollo_result", 1);
    paramString.putString("apollo_json", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramString);
    this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.CmShowWebIPCModule.5
 * JD-Core Version:    0.7.0.1
 */