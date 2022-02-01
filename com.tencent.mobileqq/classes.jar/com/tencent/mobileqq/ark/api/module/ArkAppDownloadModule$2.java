package com.tencent.mobileqq.ark.api.module;

import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

class ArkAppDownloadModule$2
  implements ArkAppDownloadModule.QueryPackageStateViaListener
{
  ArkAppDownloadModule$2(ArkAppDownloadModule paramArkAppDownloadModule, long paramLong) {}
  
  public void a(ArrayList<WadlResult> paramArrayList)
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppDownloadModule.b(this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppDownloadModule), new ArkAppDownloadModule.2.1(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.2
 * JD-Core Version:    0.7.0.1
 */