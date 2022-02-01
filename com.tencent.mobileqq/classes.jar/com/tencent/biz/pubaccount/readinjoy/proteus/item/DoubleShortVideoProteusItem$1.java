package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.List;
import org.json.JSONObject;

class DoubleShortVideoProteusItem$1
  implements ViewBase.OnClickListener
{
  DoubleShortVideoProteusItem$1(DoubleShortVideoProteusItem paramDoubleShortVideoProteusItem, IReadInJoyModel paramIReadInJoyModel, int paramInt, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
    if (localArticleInfo == null) {}
    JSONObject localJSONObject;
    do
    {
      return;
      localJSONObject = localArticleInfo.getProteusItemData();
    } while (localJSONObject == null);
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
    if (this.jdField_a_of_type_Int == 1130) {}
    for (boolean bool = true;; bool = false)
    {
      paramViewBase = localArticleInfo;
      if (!bool)
      {
        paramViewBase = localArticleInfo;
        if (localArticleInfo.mSubArtilceList != null)
        {
          paramViewBase = localArticleInfo;
          if (localArticleInfo.mSubArtilceList.size() > 0)
          {
            paramViewBase = localArticleInfo;
            if (localArticleInfo.mSubArtilceList.get(0) != null) {
              paramViewBase = (BaseArticleInfo)localArticleInfo.mSubArtilceList.get(0);
            }
          }
        }
      }
      if (!VideoFeedsHelper.a(paramViewBase, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext())) {
        DoubleShortVideoProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemDoubleShortVideoProteusItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase, localReadInJoyBaseAdapter);
      }
      ReadInJoyLogicEngine.a().a(paramViewBase.mArticleID, System.currentTimeMillis());
      DoubleShortVideoProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemDoubleShortVideoProteusItem, paramViewBase, bool, localJSONObject);
      localReadInJoyBaseAdapter.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.DoubleShortVideoProteusItem.1
 * JD-Core Version:    0.7.0.1
 */