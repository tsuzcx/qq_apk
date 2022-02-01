package com.tencent.biz.pubaccount.readinjoyAd.ad.item;

import android.app.Activity;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.JumpAdUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyBottomAdVideoUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.gdtad.aditem.GdtHandler.Params;

class WebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder$1$1
  implements ViewBase.OnClickListener
{
  WebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder$1$1(WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.1 param1) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool1;
    int i;
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder.a != null) {
      switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
      {
      default: 
        bool1 = false;
        i = -1;
        if (FastWeqAdUtils.g((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData)) {
          FastWeqAdUtils.a(this.a.jdField_a_of_type_AndroidContentContext, (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
        }
        break;
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          JumpAdUtils.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase.getNativeView(), this.a.jdField_a_of_type_AndroidContentContext);
        } while (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder) == null);
        WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder).a(true);
        return;
        bool1 = false;
        i = 4;
        break;
        bool1 = false;
        i = 3;
        break;
        bool1 = false;
        i = 5;
        break;
        bool1 = true;
        i = 8;
        break;
        bool1 = false;
        i = 1000;
        break;
        bool1 = false;
        i = 2;
        break;
        paramViewBase = ReadInJoyBottomAdVideoUtil.a((ProteusBannerVideoItemData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      } while (paramViewBase == null);
      if (ReadinJoyActionUtil.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, (AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData, paramViewBase).intValue() == -1) {
        break label300;
      }
    } while (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder) == null);
    WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder).a(true);
    return;
    label300:
    if (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder) != null) {}
    for (boolean bool2 = WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder).a();; bool2 = false)
    {
      paramViewBase.setClickPos(i);
      Object localObject = new AdJumpParams(bool2);
      if (i == 8) {
        ((AdJumpParams)localObject).c = true;
      }
      localObject = ReadinJoyActionUtil.a((Activity)this.a.jdField_a_of_type_AndroidContentContext, paramViewBase, null, 2, bool1, (AdJumpParams)localObject);
      if (localObject == null) {
        break;
      }
      ((GdtHandler.Params)localObject).f = ReadInJoyAdSwitchUtil.b((AdData)this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData);
      Integer localInteger = ReadinJoyActionUtil.a((GdtHandler.Params)localObject, this.a.jdField_a_of_type_AndroidContentContext, paramViewBase);
      WebFastProteusViewAdBannerVideoCreator.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = (GdtHandler.Params)localObject;
      WebFastProteusViewAdBannerVideoCreator.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      paramViewBase.setClickPos(i);
      ReadInJoyAdReportUtils.a(ReportAction.CLICK, localInteger, paramViewBase, 2, 1, 3);
      if (WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder) == null) {
        break;
      }
      WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdItemWebFastProteusViewAdBannerVideoCreator$ProteusItemViewHolder).a(true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusViewAdBannerVideoCreator.ProteusItemViewHolder.1.1
 * JD-Core Version:    0.7.0.1
 */