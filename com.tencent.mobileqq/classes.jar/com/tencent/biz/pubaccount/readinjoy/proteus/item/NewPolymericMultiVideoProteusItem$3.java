package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class NewPolymericMultiVideoProteusItem$3
  implements ViewBase.OnClickListener
{
  NewPolymericMultiVideoProteusItem$3(NewPolymericMultiVideoProteusItem paramNewPolymericMultiVideoProteusItem, ArticleInfo paramArticleInfo, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mNewPolymericInfo.a != null)
    {
      paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mNewPolymericInfo.a;
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
      NewPolymericMultiVideoProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemNewPolymericMultiVideoProteusItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramViewBase.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.NewPolymericMultiVideoProteusItem.3
 * JD-Core Version:    0.7.0.1
 */