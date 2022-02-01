package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.biz.pubaccount.readinjoy.notecard.ReadInJoyNoteCardUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;

class NoteCardProteusItem$4
  implements ViewBase.OnClickListener
{
  NoteCardProteusItem$4(NoteCardProteusItem paramNoteCardProteusItem, Container paramContainer) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = BaseApplicationImpl.getContext();
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (paramViewBase != null)) {
      if (paramViewBase.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((i == 0) && (ReadInJoyNoteCardUtil.a() == 1) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext() instanceof Activity))) {
        NoteCardProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemNoteCardProteusItem, (Activity)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext());
      }
      return;
      i = 0;
      continue;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.NoteCardProteusItem.4
 * JD-Core Version:    0.7.0.1
 */