package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ListenerBuilder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnGalleryImageClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComponentContentGalleryBiu$2
  implements View.OnClickListener
{
  ComponentContentGalleryBiu$2(ComponentContentGalleryBiu paramComponentContentGalleryBiu, ArticleInfo paramArticleInfo, long paramLong, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (ComponentContentGalleryBiu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGalleryBiu) == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = ComponentContentGalleryBiu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, ComponentContentGalleryBiu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGalleryBiu));
      OnGalleryImageClickListener localOnGalleryImageClickListener = ComponentContentGalleryBiu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGalleryBiu).a().a();
      if (localOnGalleryImageClickListener != null) {
        localOnGalleryImageClickListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGalleryBiu.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, i, ComponentContentGalleryBiu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGalleryBiu), this.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGalleryBiu.2
 * JD-Core Version:    0.7.0.1
 */