package com.tencent.mobileqq.ark.api.module;

import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

class ArkAppDownloadModule$1
  implements ArkAppDownloadModule.QueryPackageStateListener
{
  ArkAppDownloadModule$1(ArkAppDownloadModule paramArkAppDownloadModule, long paramLong) {}
  
  public void a(ArrayList<WadlResult> paramArrayList)
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(ArkAppDownloadModule.a(this.jdField_a_of_type_ComTencentMobileqqArkApiModuleArkAppDownloadModule), new ArkAppDownloadModule.1.1(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.1
 * JD-Core Version:    0.7.0.1
 */