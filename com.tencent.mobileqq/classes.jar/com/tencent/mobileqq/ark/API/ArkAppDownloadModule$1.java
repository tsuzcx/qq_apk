package com.tencent.mobileqq.ark.API;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.util.ArrayList;

class ArkAppDownloadModule$1
  implements ArkAppDownloadModule.QueryPackageStateListener
{
  ArkAppDownloadModule$1(ArkAppDownloadModule paramArkAppDownloadModule, long paramLong) {}
  
  public void a(ArrayList<WadlResult> paramArrayList)
  {
    ArkAppCenter.a().post(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppDownloadModule.a, new ArkAppDownloadModule.1.1(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDownloadModule.1
 * JD-Core Version:    0.7.0.1
 */