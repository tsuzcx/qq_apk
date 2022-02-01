package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ListenerBuilder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnGalleryImageClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGalleryBiu;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FeedItemCellTypeGalleryBiu$1
  implements View.OnClickListener
{
  FeedItemCellTypeGalleryBiu$1(FeedItemCellTypeGalleryBiu paramFeedItemCellTypeGalleryBiu) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ArticleInfo localArticleInfo = ((IReadInJoyModel)this.a.jdField_a_of_type_JavaLangObject).a();
      if (localArticleInfo != null)
      {
        int i = ComponentContentGalleryBiu.a(localArticleInfo, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter);
        OnGalleryImageClickListener localOnGalleryImageClickListener = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a().a();
        if (localOnGalleryImageClickListener != null) {
          localOnGalleryImageClickListener.a(this.a.jdField_a_of_type_AndroidContentContext, localArticleInfo, 0, localArticleInfo.innerUniqueID, i, this.a.jdField_a_of_type_Int, 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCellTypeGalleryBiu.1
 * JD-Core Version:    0.7.0.1
 */