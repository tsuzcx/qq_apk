package com.tencent.mobileqq.apollo.makeup;

import com.tencent.aelight.camera.cmsshow.api.CMJoyEssentialDownloadCallback;
import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "allSucceeded", "", "resultMap", "Ljava/util/HashMap;", "", "kotlin.jvm.PlatformType", "onComplete"}, k=3, mv={1, 1, 16})
final class CmShowEALoader$AEKitEssentialResDownloadTask$executeAsync$1
  implements CMJoyEssentialDownloadCallback
{
  CmShowEALoader$AEKitEssentialResDownloadTask$executeAsync$1(CmShowEALoader.AEKitEssentialResDownloadTask paramAEKitEssentialResDownloadTask, long paramLong) {}
  
  public final void a(boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (paramBoolean)
    {
      CmShowEALoader.AEKitEssentialResDownloadTask localAEKitEssentialResDownloadTask = this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$AEKitEssentialResDownloadTask;
      paramHashMap = paramHashMap.get("video_3DFaceFila_kapu_placeholder");
      if (paramHashMap != null)
      {
        localAEKitEssentialResDownloadTask.a((String)paramHashMap);
        this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$AEKitEssentialResDownloadTask.e();
        ApolloQualityReportUtil.a("aekit_init", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "success");
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }
    QLog.e(CmShowEALoader.a.a(), 1, "[AEKit]AECMShowQipcModule downloadEssentialResources error");
    this.jdField_a_of_type_ComTencentMobileqqApolloMakeupCmShowEALoader$AEKitEssentialResDownloadTask.a(-5033, "");
    ApolloQualityReportUtil.a("aekit_essential_res", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "download fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowEALoader.AEKitEssentialResDownloadTask.executeAsync.1
 * JD-Core Version:    0.7.0.1
 */