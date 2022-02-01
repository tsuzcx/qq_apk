package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.notecard.ReadInJoyNoteCardUtil;
import com.tencent.biz.pubaccount.readinjoy.notecard.SoundCheckRunnable;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyLottieView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ScripCmsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.IReadInJoyListItemLifeCycle;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class NoteCardProteusItem$1
  implements IReadInJoyListItemLifeCycle
{
  NoteCardProteusItem$1(NoteCardProteusItem paramNoteCardProteusItem, ReadInJoyLottieView paramReadInJoyLottieView, IReadInJoyModel paramIReadInJoyModel, Container paramContainer) {}
  
  public void a()
  {
    int j = 1;
    QLog.d("NoteCardProteusItem", 1, "onItemResume");
    NoteCardProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemNoteCardProteusItem, true);
    if (NoteCardProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemNoteCardProteusItem) != null) {
      NoteCardProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemNoteCardProteusItem).a();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoyLottieView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoyLottieView.a();
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().scripCmsInfo;
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((NoteCardProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemNoteCardProteusItem)) && (ReadInJoyNoteCardUtil.a() != 0))
    {
      i = ReadInJoyNoteCardUtil.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str);
      int k = ReadInJoyNoteCardUtil.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str);
      if ((i < ReadInJoyNoteCardUtil.b()) && (k < ReadInJoyNoteCardUtil.c()))
      {
        ((ScripCmsInfo)localObject).a = 2;
        ReadInJoyNoteCardUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str, i + 1);
        ReadInJoyNoteCardUtil.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str, k + 1);
      }
    }
    if ((ReadInJoyNoteCardUtil.a() == 1) && (ReadInJoyNoteCardUtil.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), str) > 0))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext();
      i = j;
      if (Build.VERSION.SDK_INT >= 23)
      {
        i = j;
        if (localObject != null) {
          if (((Context)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            break label290;
          }
        }
      }
    }
    label290:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        ThreadManager.getUIHandler().postDelayed(new NoteCardProteusItem.1.1(this), 1000L);
      }
      NoteCardProteusItem.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemNoteCardProteusItem, false);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a();
      if (localObject != null)
      {
        ((ArticleInfo)localObject).invalidateProteusTemplateBean();
        ReadInJoyLogicEngineEventDispatcher.a().c();
      }
      return;
    }
  }
  
  public void b()
  {
    QLog.d("NoteCardProteusItem", 1, "onItemPause");
    NoteCardProteusItem.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemNoteCardProteusItem, false);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoyLottieView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoyLottieView.b();
    }
    NoteCardProteusItem.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemNoteCardProteusItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.NoteCardProteusItem.1
 * JD-Core Version:    0.7.0.1
 */