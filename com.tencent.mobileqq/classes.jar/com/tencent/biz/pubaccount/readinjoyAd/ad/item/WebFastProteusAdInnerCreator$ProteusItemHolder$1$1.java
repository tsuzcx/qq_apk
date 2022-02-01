package com.tencent.biz.pubaccount.readinjoyAd.ad.item;

import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRecommendAdHelper;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.JumpAdUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyBottomAdVideoUtil;

class WebFastProteusAdInnerCreator$ProteusItemHolder$1$1
  implements ViewBase.OnClickListener
{
  WebFastProteusAdInnerCreator$ProteusItemHolder$1$1(WebFastProteusAdInnerCreator.ProteusItemHolder.1 param1) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool = true;
    int k;
    Object localObject;
    int j;
    int i;
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusAdInnerCreator$ProteusItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData != null)
    {
      k = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
      localObject = AdClickPos.SoftAdComponent;
      switch (k)
      {
      default: 
        paramViewBase = (ViewBase)localObject;
        j = -1;
        i = 0;
      }
    }
    for (;;)
    {
      if ((i != 0) && (k != -1))
      {
        localObject = ReadInJoyBottomAdVideoUtil.a((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusAdInnerCreator$ProteusItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData);
        if ((localObject != null) && (((AdvertisementInfo)localObject).mSoftAdType != 0)) {
          ((AdvertisementInfo)localObject).adClickPos = paramViewBase;
        }
        paramViewBase = this.a.jdField_a_of_type_AndroidContentContext;
        if (j == 8) {
          label184:
          FastWebRecommendAdHelper.a(paramViewBase, (AdvertisementInfo)localObject, bool, j);
        }
      }
      else
      {
        return;
        if (this.a.jdField_a_of_type_AndroidContentContext == null) {
          break label391;
        }
        JumpAdUtils.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusAdInnerCreator$ProteusItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase.getNativeView(), this.a.jdField_a_of_type_AndroidContentContext);
        paramViewBase = (ViewBase)localObject;
        j = 8;
        i = 0;
        continue;
        j = 5;
        paramViewBase = (ViewBase)localObject;
        i = 1;
        continue;
        j = 4;
        paramViewBase = (ViewBase)localObject;
        i = 1;
        continue;
        paramViewBase = AdClickPos.SoftAdClickBtn;
        if (FastWeqAdUtils.g((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusAdInnerCreator$ProteusItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData))
        {
          FastWeqAdUtils.a(this.a.jdField_a_of_type_AndroidContentContext, (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusAdInnerCreator$ProteusItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, 8);
          return;
        }
        if (!FastWeqAdUtils.h((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusAdInnerCreator$ProteusItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData)) {
          break label385;
        }
      }
      label385:
      for (i = 1;; i = 8)
      {
        j = i;
        i = 1;
        break;
        paramViewBase = (ViewBase)localObject;
        j = 1;
        i = 1;
        break;
        j = 3;
        paramViewBase = (ViewBase)localObject;
        i = 1;
        break;
        j = 1000;
        paramViewBase = (ViewBase)localObject;
        i = 1;
        break;
        paramViewBase = AdClickPos.SoftAdClickBtn;
        j = 1;
        i = 1;
        break;
        bool = false;
        break label184;
      }
      label391:
      paramViewBase = (ViewBase)localObject;
      j = 8;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusAdInnerCreator.ProteusItemHolder.1.1
 * JD-Core Version:    0.7.0.1
 */