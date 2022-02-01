package com.tencent.biz.pubaccount.readinjoy.viola.utils;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.IGetAllUploadStatusVideosCallback;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

final class ViolaBizUtils$4
  implements RIJUgcVideoPublishManager.IGetAllUploadStatusVideosCallback
{
  ViolaBizUtils$4(String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, BridgeModule paramBridgeModule, int paramInt2, String paramString2) {}
  
  public void a(@NotNull List<UgcVideo> paramList)
  {
    Object localObject = paramList.iterator();
    UgcVideo localUgcVideo;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localUgcVideo = (UgcVideo)((Iterator)localObject).next();
    } while (!TextUtils.equals(localUgcVideo.seqId, this.jdField_a_of_type_JavaLangString));
    for (;;)
    {
      if (localUgcVideo != null)
      {
        localObject = RIJUgcUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, localUgcVideo.publicType).a();
        if (localUgcVideo.status == UgcVideo.STATUS_PAUSE) {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC62", (String)localObject);
        }
        while ((NetworkUtil.b(BaseApplicationImpl.getContext())) && (BaseActivity.sTopActivity != null) && (CUKingCardHelper.a() != 1))
        {
          long l = RIJUgcUtils.a(localUgcVideo);
          if (l > 0L)
          {
            RIJUgcUtils.a(BaseActivity.sTopActivity, l, new ViolaBizUtils.4.1(this, localUgcVideo, paramList), null);
            return;
            if (localUgcVideo.status == UgcVideo.STATUS_FAILED) {
              ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC63", (String)localObject);
            }
          }
          else
          {
            RIJUgcVideoPublishManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localUgcVideo, true);
            ViolaBizUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, 0, "");
            return;
          }
        }
        RIJUgcVideoPublishManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localUgcVideo, true);
        ViolaBizUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, 0, "");
        return;
      }
      ViolaBizUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, -1, "ugcVideo not exist");
      return;
      localUgcVideo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils.4
 * JD-Core Version:    0.7.0.1
 */