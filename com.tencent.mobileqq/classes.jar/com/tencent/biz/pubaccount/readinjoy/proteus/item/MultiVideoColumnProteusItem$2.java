package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.helper.RecycleViewAdapterHelper.OnItemClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiVideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SubVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MultiVideoColumnProteusItem$2
  implements RecycleViewAdapterHelper.OnItemClickListener
{
  MultiVideoColumnProteusItem$2(MultiVideoColumnProteusItem paramMultiVideoColumnProteusItem, ArticleInfo paramArticleInfo, Container paramContainer) {}
  
  public void a(int paramInt, ViewBase paramViewBase, TemplateBean paramTemplateBean)
  {
    QLog.d("multiVideoColumnInfo", 1, "position : " + paramInt);
    paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.multiVideoColumnInfo.a;
    if ((paramInt >= 0) && (paramInt < paramViewBase.size()) && (paramViewBase.get(paramInt) != null) && (((SubVideoInfo)paramViewBase.get(paramInt)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null))
    {
      paramTemplateBean = ((SubVideoInfo)paramViewBase.get(paramInt)).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo;
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramTemplateBean);
      MultiVideoColumnProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemMultiVideoColumnProteusItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 2, paramTemplateBean.e, ((SubVideoInfo)paramViewBase.get(paramInt)).jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.MultiVideoColumnProteusItem.2
 * JD-Core Version:    0.7.0.1
 */