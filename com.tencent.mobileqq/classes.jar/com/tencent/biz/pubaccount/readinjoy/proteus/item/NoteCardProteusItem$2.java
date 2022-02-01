package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJFrameworkReportManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;

class NoteCardProteusItem$2
  implements ViewBase.OnClickListener
{
  NoteCardProteusItem$2(NoteCardProteusItem paramNoteCardProteusItem, IReadInJoyModel paramIReadInJoyModel, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
    if (paramViewBase != null)
    {
      RIJJumpUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramViewBase.mArticleContentUrl, null);
      RIJFrameworkReportManager.b(paramViewBase, 0);
      NoteCardProteusItem.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemNoteCardProteusItem, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.NoteCardProteusItem.2
 * JD-Core Version:    0.7.0.1
 */