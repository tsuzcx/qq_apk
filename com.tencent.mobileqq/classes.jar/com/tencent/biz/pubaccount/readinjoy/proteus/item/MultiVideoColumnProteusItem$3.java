package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiVideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class MultiVideoColumnProteusItem$3
  implements ViewBase.OnClickListener
{
  MultiVideoColumnProteusItem$3(MultiVideoColumnProteusItem paramMultiVideoColumnProteusItem, ArticleInfo paramArticleInfo, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.multiVideoColumnInfo.a;
    if (paramViewBase != null)
    {
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase);
      MultiVideoColumnProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemMultiVideoColumnProteusItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 1, paramViewBase.e, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.MultiVideoColumnProteusItem.3
 * JD-Core Version:    0.7.0.1
 */