package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView.OnStateChangeListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiVideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;

class MultiVideoColumnProteusItem$1
  implements ProteusRecycleView.OnStateChangeListener
{
  MultiVideoColumnProteusItem$1(MultiVideoColumnProteusItem paramMultiVideoColumnProteusItem, ArticleInfo paramArticleInfo, Container paramContainer) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.multiVideoColumnInfo.a != null)
    {
      UrlJumpInfo localUrlJumpInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.multiVideoColumnInfo.a;
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), localUrlJumpInfo);
      MultiVideoColumnProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemMultiVideoColumnProteusItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 1, localUrlJumpInfo.e, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.MultiVideoColumnProteusItem.1
 * JD-Core Version:    0.7.0.1
 */