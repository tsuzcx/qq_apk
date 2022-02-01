package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiVideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class ColumnTwoVideoProteusItem$4
  implements ViewBase.OnClickListener
{
  ColumnTwoVideoProteusItem$4(ColumnTwoVideoProteusItem paramColumnTwoVideoProteusItem, MultiVideoColumnInfo paramMultiVideoColumnInfo, ArticleInfo paramArticleInfo) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool = true;
    int i;
    ArticleInfo localArticleInfo;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructMultiVideoColumnInfo.a)
    {
      i = 2;
      ColumnTwoVideoProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemColumnTwoVideoProteusItem, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i);
      paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemColumnTwoVideoProteusItem;
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructMultiVideoColumnInfo.a) {
        break label60;
      }
    }
    for (;;)
    {
      ColumnTwoVideoProteusItem.a(paramViewBase, localArticleInfo, bool);
      return;
      i = 1;
      break;
      label60:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.ColumnTwoVideoProteusItem.4
 * JD-Core Version:    0.7.0.1
 */