package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiVideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SubVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import java.util.List;

class ColumnTwoVideoProteusItem$2
  implements ViewBase.OnClickListener
{
  ColumnTwoVideoProteusItem$2(ColumnTwoVideoProteusItem paramColumnTwoVideoProteusItem, Context paramContext, MultiVideoColumnInfo paramMultiVideoColumnInfo, ArticleInfo paramArticleInfo) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    VideoFeedsHelper.a(this.jdField_a_of_type_AndroidContentContext, ((SubVideoInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructMultiVideoColumnInfo.a.get(0)).a);
    ColumnTwoVideoProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemColumnTwoVideoProteusItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.ColumnTwoVideoProteusItem.2
 * JD-Core Version:    0.7.0.1
 */