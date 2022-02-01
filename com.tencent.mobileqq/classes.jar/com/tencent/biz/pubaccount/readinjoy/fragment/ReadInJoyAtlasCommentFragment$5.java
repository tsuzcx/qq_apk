package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.FirstCommentEvent;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyAtlasCommentFragment$5
  implements ReadInJoyCommentUtils.FirstCommentEvent
{
  ReadInJoyAtlasCommentFragment$5(ReadInJoyAtlasCommentFragment paramReadInJoyAtlasCommentFragment) {}
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ReadInJoyAtlasCommentFragment.a(this.a);
      return;
    }
    this.a.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      RIJTransMergeKanDianReport.a(0, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.b(), 0);
      this.a.onBackEvent();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment.5
 * JD-Core Version:    0.7.0.1
 */