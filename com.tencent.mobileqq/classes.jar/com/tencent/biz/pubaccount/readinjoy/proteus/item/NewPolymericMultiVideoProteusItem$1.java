package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView.OnStateChangeListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;

class NewPolymericMultiVideoProteusItem$1
  implements ProteusRecycleView.OnStateChangeListener
{
  NewPolymericMultiVideoProteusItem$1(NewPolymericMultiVideoProteusItem paramNewPolymericMultiVideoProteusItem, ArticleInfo paramArticleInfo, Container paramContainer) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mNewPolymericInfo.b != null)
    {
      UrlJumpInfo localUrlJumpInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mNewPolymericInfo.b;
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), localUrlJumpInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.NewPolymericMultiVideoProteusItem.1
 * JD-Core Version:    0.7.0.1
 */