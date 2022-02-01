package com.tencent.biz.pubaccount.readinjoyAd.ad.item;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRecommendAdHelper;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.JumpAdUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;

class WebFastProteusViewAdBannerBigPicCreator$ProteusItemViewHolder$1$1
  implements ViewBase.OnClickListener
{
  WebFastProteusViewAdBannerBigPicCreator$ProteusItemViewHolder$1$1(WebFastProteusViewAdBannerBigPicCreator.ProteusItemViewHolder.1 param1) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    int j = 101;
    boolean bool2 = true;
    boolean bool1;
    int i;
    if ((this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerBigPicCreator$ProteusItemViewHolder.a instanceof ProteusItemData))
    {
      bool1 = bool2;
      i = j;
      switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
      {
      default: 
        bool1 = false;
        i = -1;
      }
    }
    while (((i == 4) || (i == 3) || (i == 1000) || (i == 8)) && (FastWeqAdUtils.g((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData)))
    {
      FastWeqAdUtils.a(this.a.jdField_a_of_type_AndroidContentContext, (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      return;
      JumpAdUtils.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase.getNativeView(), this.a.jdField_a_of_type_AndroidContentContext);
      return;
      bool1 = false;
      i = 4;
      continue;
      bool1 = false;
      i = 3;
      continue;
      i = 5;
      bool1 = false;
      continue;
      i = 8;
      bool1 = bool2;
      continue;
      i = 1000;
      bool1 = false;
      continue;
      bool1 = false;
      i = j;
      continue;
      i = 102;
      bool1 = false;
      continue;
      bool1 = false;
      i = 4;
      continue;
      bool1 = false;
      i = 3;
      continue;
      i = 102;
      bool1 = bool2;
      continue;
      i = 2;
      bool1 = false;
    }
    FastWebRecommendAdHelper.a(this.a.jdField_a_of_type_AndroidContentContext, (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerBigPicCreator$ProteusItemViewHolder.a, bool1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusViewAdBannerBigPicCreator.ProteusItemViewHolder.1.1
 * JD-Core Version:    0.7.0.1
 */