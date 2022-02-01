package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRecommendAdHelper;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.JumpAdUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyBottomAdVideoUtil;

class WebFastProteusViewAdCreator$ProteusItemViewHolder$1$1
  implements ViewBase.OnClickListener
{
  WebFastProteusViewAdCreator$ProteusItemViewHolder$1$1(WebFastProteusViewAdCreator.ProteusItemViewHolder.1 param1) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool = true;
    int i;
    AdvertisementInfo localAdvertisementInfo;
    if ((WebFastProteusViewAdCreator.ProteusItemViewHolder.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebFastProteusViewAdCreator$ProteusItemViewHolder) instanceof AdData)) {
      switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
      {
      default: 
        i = -1;
        paramViewBase = this.a.jdField_a_of_type_AndroidContentContext;
        localAdvertisementInfo = ReadInJoyBottomAdVideoUtil.a((AdData)WebFastProteusViewAdCreator.ProteusItemViewHolder.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebFastProteusViewAdCreator$ProteusItemViewHolder));
        if (i != 8) {
          break;
        }
      }
    }
    for (;;)
    {
      FastWebRecommendAdHelper.a(paramViewBase, localAdvertisementInfo, false, bool, i);
      return;
      JumpAdUtils.a(WebFastProteusViewAdCreator.ProteusItemViewHolder.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebFastProteusViewAdCreator$ProteusItemViewHolder), paramViewBase.getNativeView(), this.a.jdField_a_of_type_AndroidContentContext);
      return;
      i = 4;
      break;
      i = 3;
      break;
      i = 5;
      break;
      i = 8;
      break;
      i = 1;
      break;
      i = 1000;
      break;
      i = 2;
      break;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastProteusViewAdCreator.ProteusItemViewHolder.1.1
 * JD-Core Version:    0.7.0.1
 */