package com.tencent.biz.pubaccount.readinjoyAd.ad.item;

import android.content.Context;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.JumpAdUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebRecommendAdService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.qroute.QRoute;

class WebFastProteusAdInnerCreator$ProteusItemHolder$1$1
  implements ViewBase.OnClickListener
{
  WebFastProteusAdInnerCreator$ProteusItemHolder$1$1(WebFastProteusAdInnerCreator.ProteusItemHolder.1 param1) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusAdInnerCreator$ProteusItemHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoPtsEntityProteusItemData != null)
    {
      int k = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
      Object localObject = AdClickPos.SoftAdComponent;
      boolean bool = false;
      if ((k != 1001) && (k != 1071))
      {
        if (k != 1177) {
          switch (k)
          {
          default: 
            j = 0;
            i = -1;
            paramViewBase = (ViewBase)localObject;
            break;
          case 1093: 
            j = 1;
            i = 1000;
            paramViewBase = (ViewBase)localObject;
            break;
          case 1092: 
            j = 1;
            i = 3;
            paramViewBase = (ViewBase)localObject;
            break;
          case 1091: 
            j = 1;
            i = 1;
            paramViewBase = (ViewBase)localObject;
            break;
          case 1090: 
            localObject = AdClickPos.SoftAdClickBtn;
            if (FastWeqAdUtils.h((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusAdInnerCreator$ProteusItemHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData))
            {
              FastWeqAdUtils.a(this.a.jdField_a_of_type_AndroidContentContext, (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusAdInnerCreator$ProteusItemHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData, 8);
              return;
            }
            paramViewBase = (ViewBase)localObject;
            if (FastWeqAdUtils.i((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusAdInnerCreator$ProteusItemHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData))
            {
              paramViewBase = (ViewBase)localObject;
              i = 1;
            }
            break;
          }
        }
        for (;;)
        {
          i = 8;
          j = 1;
          break label334;
          j = 1;
          i = 4;
          paramViewBase = (ViewBase)localObject;
          break label334;
          j = 1;
          i = 5;
          paramViewBase = (ViewBase)localObject;
          break label334;
          localObject = AdClickPos.SoftAdClickBtn;
          paramViewBase = (ViewBase)localObject;
          if (!FastWeqAdUtils.a(((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusAdInnerCreator$ProteusItemHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoPtsEntityProteusItemData))) {
            break;
          }
          paramViewBase = (ViewBase)localObject;
        }
      }
      if (this.a.jdField_a_of_type_AndroidContentContext != null) {
        JumpAdUtils.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusAdInnerCreator$ProteusItemHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData, paramViewBase.getNativeView(), this.a.jdField_a_of_type_AndroidContentContext);
      }
      int j = 0;
      int i = 8;
      paramViewBase = (ViewBase)localObject;
      label334:
      if ((j != 0) && (k != -1))
      {
        localObject = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusAdInnerCreator$ProteusItemHolder.jdField_a_of_type_ComTencentMobileqqKandianRepoPtsEntityProteusItemData);
        if ((localObject != null) && (((AdvertisementInfo)localObject).mSoftAdType != 0)) {
          ((AdvertisementInfo)localObject).adClickPos = paramViewBase;
        }
        paramViewBase = (IRIJFastWebRecommendAdService)QRoute.api(IRIJFastWebRecommendAdService.class);
        Context localContext = this.a.jdField_a_of_type_AndroidContentContext;
        if (i == 8) {
          bool = true;
        }
        paramViewBase.onAdJump(localContext, (AdvertisementInfo)localObject, bool, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusAdInnerCreator.ProteusItemHolder.1.1
 * JD-Core Version:    0.7.0.1
 */