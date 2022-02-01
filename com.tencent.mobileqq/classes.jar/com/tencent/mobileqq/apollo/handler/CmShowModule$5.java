package com.tencent.mobileqq.apollo.handler;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.web.MessengerService;
import cooperation.qzone.QZoneVipInfoManager;

class CmShowModule$5
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  CmShowModule$5(CmShowModule paramCmShowModule, int paramInt1, QQAppInterface paramQQAppInterface, String paramString1, int paramInt2, boolean paramBoolean, String paramString2, String paramString3, String paramString4, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    paramString = new Bundle();
    int i;
    if (paramBoolean) {
      if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        paramArrayOfInt = ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloBaseInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramArrayOfInt == null) {
          break label237;
        }
        i = paramArrayOfInt.apolloVipFlag;
        paramInt2 = paramArrayOfInt.apolloVipLevel;
      }
    }
    for (;;)
    {
      paramString.putInt("apollo_apolloVipFlag", i);
      paramString.putInt("apollo_apolloVipLevel", paramInt2);
      paramString.putBoolean("apollo_is_super_yellow", QZoneVipInfoManager.getInstance().isSuperYellow());
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
      paramString.putInt("apollo_result", 1);
      paramString.putString("apollo_json", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidOsBundle.putBundle("response", paramString);
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
      return;
      label237:
      paramInt2 = 0;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.CmShowModule.5
 * JD-Core Version:    0.7.0.1
 */