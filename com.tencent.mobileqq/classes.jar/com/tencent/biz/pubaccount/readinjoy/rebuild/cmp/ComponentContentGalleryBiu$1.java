package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComponentContentGalleryBiu$1
  implements View.OnClickListener
{
  ComponentContentGalleryBiu$1(ComponentContentGalleryBiu paramComponentContentGalleryBiu, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    ComponentContentGalleryBiu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentGalleryBiu, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGalleryBiu.1
 * JD-Core Version:    0.7.0.1
 */