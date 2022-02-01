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

final class ViolaBizUtils$5
  implements RIJUgcVideoPublishManager.IGetAllUploadStatusVideosCallback
{
  ViolaBizUtils$5(String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, BridgeModule paramBridgeModule, int paramInt2, String paramString2) {}
  
  public void a(@NotNull List<UgcVideo> paramList)
  {
    String str = null;
    Iterator localIterator = paramList.iterator();
    Object localObject;
    do
    {
      localObject = str;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (UgcVideo)localIterator.next();
    } while (!TextUtils.equals(((UgcVideo)localObject).seqId, this.jdField_a_of_type_JavaLangString));
    if (localObject != null)
    {
      str = RIJUgcUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, ((UgcVideo)localObject).publicType).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC61", str);
      RIJUgcVideoPublishManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b((UgcVideo)localObject);
      ViolaBizUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, 0, "");
      return;
    }
    ViolaBizUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, -1, "ugcVideo not exist");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils.5
 * JD-Core Version:    0.7.0.1
 */