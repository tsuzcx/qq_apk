package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import org.json.JSONObject;

class WebFastProteusViewAdCreator$ProteusItemViewHolder
  extends BaseItemViewHolder
{
  private ProteusItemData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  
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
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer == null) || (paramBaseData2 == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramBaseData2 instanceof ProteusItemData));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData = ((ProteusItemData)paramBaseData2);
      paramBaseData1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.a;
    } while (paramBaseData1 == null);
    WebFastProteusViewAdCreator.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebFastProteusViewAdCreator, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer);
    if ((paramBaseData2 instanceof RecommendAdData)) {
      WebFastProteusViewAdCreator.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebFastProteusViewAdCreator, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, (RecommendAdData)paramBaseData2);
    }
    try
    {
      paramBaseData1.bindData(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.c);
      ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.a.getViewBean());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData;
      a(WebFastProteusViewAdCreator.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebItemWebFastProteusViewAdCreator), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.c);
      return;
    }
    catch (Exception paramBaseData1)
    {
      for (;;)
      {
        ReadInJoyAdLog.a("WebFastProteusViewAdCreator", paramBaseData1.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastProteusViewAdCreator.ProteusItemViewHolder
 * JD-Core Version:    0.7.0.1
 */