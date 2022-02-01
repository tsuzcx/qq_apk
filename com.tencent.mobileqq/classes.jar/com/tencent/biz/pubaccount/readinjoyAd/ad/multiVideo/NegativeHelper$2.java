package com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.KandianPopupWindow.OnUninterestConfirmListener;
import java.util.ArrayList;

class NegativeHelper$2
  implements KandianPopupWindow.OnUninterestConfirmListener
{
  NegativeHelper$2(NegativeHelper paramNegativeHelper, int paramInt, VideoInfo paramVideoInfo) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if (paramInt == this.jdField_a_of_type_Int)
    {
      paramView = NegativeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper);
      paramInt = 0;
      QQToast.a(paramView, 0, 2131695168, 0).a();
      if (NegativeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper) != null) {
        NegativeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper).d(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
      }
      long l2 = 0L;
      long l1 = l2;
      if (paramObject != null)
      {
        l1 = l2;
        if ((paramObject instanceof DislikeInfo)) {
          l1 = ((DislikeInfo)paramObject).jdField_a_of_type_Long;
        }
      }
      Object localObject2 = "";
      Object localObject1 = "";
      while (paramInt < paramArrayList.size())
      {
        DislikeInfo localDislikeInfo = (DislikeInfo)paramArrayList.get(paramInt);
        paramObject = localObject1;
        paramView = (View)localObject2;
        if (localDislikeInfo != null)
        {
          paramView = new StringBuilder();
          paramView.append((String)localObject2);
          paramView.append(localDislikeInfo.jdField_a_of_type_Long);
          localObject2 = paramView.toString();
          paramView = new StringBuilder();
          paramView.append((String)localObject1);
          paramView.append(localDislikeInfo.jdField_a_of_type_JavaLangString);
          localObject1 = paramView.toString();
          paramObject = localObject1;
          paramView = (View)localObject2;
          if (paramInt != paramArrayList.size() - 1)
          {
            paramView = new StringBuilder();
            paramView.append((String)localObject2);
            paramView.append(",");
            paramView = paramView.toString();
            paramObject = new StringBuilder();
            paramObject.append((String)localObject1);
            paramObject.append(",");
            paramObject = paramObject.toString();
          }
        }
        paramInt += 1;
        localObject1 = paramObject;
        localObject2 = paramView;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.a != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.a.f = l1;
        paramView = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertVideoAd2AdsInfo(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.a);
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.b(NegativeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper)))
        {
          ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(NegativeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper)).a(3).b(10).a(paramView).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.a).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.a.f).a((String)localObject2).b((String)localObject1));
          return;
        }
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(NegativeHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdMultiVideoNegativeHelper)).a(3).b(5).a(paramView).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.a).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.a.f).a((String)localObject2).b((String)localObject1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo.NegativeHelper.2
 * JD-Core Version:    0.7.0.1
 */