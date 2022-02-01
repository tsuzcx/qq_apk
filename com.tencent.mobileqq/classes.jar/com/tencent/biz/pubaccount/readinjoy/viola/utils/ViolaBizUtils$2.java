package com.tencent.biz.pubaccount.readinjoy.viola.utils;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.IGetAllUploadStatusVideosCallback;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

final class ViolaBizUtils$2
  implements RIJUgcVideoPublishManager.IGetAllUploadStatusVideosCallback
{
  ViolaBizUtils$2(String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, BridgeModule paramBridgeModule, int paramInt2, String paramString2) {}
  
  public void a(@NotNull List<UgcVideo> paramList)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = null;
    Iterator localIterator = paramList.iterator();
    Object localObject;
    do
    {
      localObject = localReportR5Builder;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (UgcVideo)localIterator.next();
    } while (!TextUtils.equals(((UgcVideo)localObject).seqId, this.jdField_a_of_type_JavaLangString));
    if (localObject != null)
    {
      paramList.remove(localObject);
      localReportR5Builder = RIJUgcUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, ((UgcVideo)localObject).publicType).a(RIJUgcUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UgcVideo)localObject).a());
      if (((UgcVideo)localObject).reprintDisable) {}
      for (int i = 0;; i = 1)
      {
        localReportR5Builder = localReportR5Builder.a("reprint_flag", Integer.valueOf(i)).a("compress_time", Long.valueOf(((UgcVideo)localObject).compressTime)).a("upload_time", Long.valueOf(((UgcVideo)localObject).uploadTotalCostTime)).a("wait_time", Long.valueOf(((UgcVideo)localObject).userWaitingTotalCostTime));
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC64", localReportR5Builder.a());
        RIJUgcVideoPublishManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((UgcVideo)localObject);
        ViolaBizUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, 0, "");
        return;
      }
    }
    ViolaBizUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, -1, "ugcVideo not exist");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils.2
 * JD-Core Version:    0.7.0.1
 */