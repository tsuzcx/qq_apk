package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItem;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory.FoundClickableViewListener;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

final class ProteusSupportUtil$2
  implements ViewFactory.FoundClickableViewListener
{
  ProteusSupportUtil$2(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, BaseArticleInfo paramBaseArticleInfo, VafContext paramVafContext, ProteusItemView paramProteusItemView, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter) {}
  
  public void onFound(ViewBase paramViewBase)
  {
    ProteusItem localProteusItem = (ProteusItem)ProteusSupportUtil.a().get(Integer.valueOf(this.jdField_a_of_type_Int));
    if ((localProteusItem != null) && (localProteusItem.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel, paramViewBase))) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((paramViewBase.getNativeView() == null) || (paramViewBase.getClickEvnet() == null));
      i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
      if (QLog.isColorLevel()) {
        QLog.d("ProteusSupportUtil", 2, "configListener viewID : " + paramViewBase.getViewId() + ", cmd : " + i + ",, event : " + paramViewBase.getClickEvnet());
      }
    } while (!ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, i, paramViewBase, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext));
    paramViewBase.setOnClickListener(new ProteusSupportUtil.2.1(this, i, paramViewBase));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil.2
 * JD-Core Version:    0.7.0.1
 */