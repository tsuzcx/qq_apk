package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class DoubleVideoProteusItem$1
  implements ViewBase.OnClickListener
{
  DoubleVideoProteusItem$1(DoubleVideoProteusItem paramDoubleVideoProteusItem, int paramInt, IReadInJoyModel paramIReadInJoyModel, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    int i;
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter;
    if (this.jdField_a_of_type_Int == 1166)
    {
      i = 1;
      localReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
      if (i == 0) {
        break label42;
      }
    }
    label42:
    for (paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;; paramViewBase = this.b)
    {
      localReadInJoyBaseAdapter.b(paramViewBase);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.DoubleVideoProteusItem.1
 * JD-Core Version:    0.7.0.1
 */