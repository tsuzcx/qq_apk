package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.pts.api.IProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

class WebFastProteusViewAdCreator$ProteusItemViewHolder
  extends BaseItemViewHolder
{
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private ProteusItemData jdField_a_of_type_ComTencentMobileqqKandianRepoPtsEntityProteusItemData;
  
  public WebFastProteusViewAdCreator$ProteusItemViewHolder(WebFastProteusViewAdCreator paramWebFastProteusViewAdCreator, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    if ((paramView instanceof Container)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = ((Container)paramView);
    }
  }
  
  private void a(Context paramContext, JSONObject paramJSONObject)
  {
    ViewFactory.findClickableViewListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), new WebFastProteusViewAdCreator.ProteusItemViewHolder.1(this, paramContext));
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer != null)
    {
      if (paramBaseData2 == null) {
        return;
      }
      if ((paramBaseData2 instanceof ProteusItemData))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoPtsEntityProteusItemData = ((ProteusItemData)paramBaseData2);
        paramBaseData1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoPtsEntityProteusItemData.a;
        if (paramBaseData1 != null)
        {
          WebFastProteusViewAdCreator.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebFastProteusViewAdCreator, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer);
          if ((paramBaseData2 instanceof RecommendAdData)) {
            WebFastProteusViewAdCreator.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebFastProteusViewAdCreator, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, (RecommendAdData)paramBaseData2);
          }
          try
          {
            paramBaseData1.bindData(this.jdField_a_of_type_ComTencentMobileqqKandianRepoPtsEntityProteusItemData.c);
            ((IProteusSupportUtil)QRoute.api(IProteusSupportUtil.class)).bindDynamicValue(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoPtsEntityProteusItemData.a.getViewBean());
            this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData = this.jdField_a_of_type_ComTencentMobileqqKandianRepoPtsEntityProteusItemData;
          }
          catch (Exception paramBaseData1)
          {
            ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("WebFastProteusViewAdCreator", paramBaseData1.getMessage());
          }
          a(WebFastProteusViewAdCreator.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebFastProteusViewAdCreator), this.jdField_a_of_type_ComTencentMobileqqKandianRepoPtsEntityProteusItemData.c);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastProteusViewAdCreator.ProteusItemViewHolder
 * JD-Core Version:    0.7.0.1
 */