package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.JumpAdUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebRecommendAdService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.qroute.QRoute;

class WebFastProteusViewAdCreator$ProteusItemViewHolder$1$1
  implements ViewBase.OnClickListener
{
  WebFastProteusViewAdCreator$ProteusItemViewHolder$1$1(WebFastProteusViewAdCreator.ProteusItemViewHolder.1 param1) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((WebFastProteusViewAdCreator.ProteusItemViewHolder.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebFastProteusViewAdCreator$ProteusItemViewHolder) instanceof AdData))
    {
      int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
      if (i != 1071)
      {
        switch (i)
        {
        default: 
          i = -1;
          break;
        case 1128: 
          i = 2;
          break;
        case 1127: 
          i = 1000;
          break;
        case 1126: 
          i = 1;
          break;
        case 1125: 
          i = 8;
          break;
        case 1124: 
          i = 5;
          break;
        case 1123: 
          i = 3;
          break;
        case 1122: 
          i = 4;
        }
        paramViewBase = (IRIJFastWebRecommendAdService)QRoute.api(IRIJFastWebRecommendAdService.class);
        Context localContext = this.a.jdField_a_of_type_AndroidContentContext;
        AdvertisementInfo localAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo((AdData)WebFastProteusViewAdCreator.ProteusItemViewHolder.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebFastProteusViewAdCreator$ProteusItemViewHolder));
        boolean bool;
        if (i == 8) {
          bool = true;
        } else {
          bool = false;
        }
        paramViewBase.onAdJump(localContext, localAdvertisementInfo, false, bool, i);
        return;
      }
      JumpAdUtils.a(WebFastProteusViewAdCreator.ProteusItemViewHolder.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebFastProteusViewAdCreator$ProteusItemViewHolder), paramViewBase.getNativeView(), this.a.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastProteusViewAdCreator.ProteusItemViewHolder.1.1
 * JD-Core Version:    0.7.0.1
 */