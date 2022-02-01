package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class DoubleVideoProteusItem$2
  implements ViewBase.OnClickListener
{
  DoubleVideoProteusItem$2(DoubleVideoProteusItem paramDoubleVideoProteusItem, int paramInt, IReadInJoyModel paramIReadInJoyModel, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    boolean bool;
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter;
    if (this.jdField_a_of_type_Int == 1164)
    {
      bool = true;
      localReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
      if (!bool) {
        break label43;
      }
    }
    label43:
    for (paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;; paramViewBase = this.b)
    {
      localReadInJoyBaseAdapter.a(bool, paramViewBase);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.DoubleVideoProteusItem.2
 * JD-Core Version:    0.7.0.1
 */