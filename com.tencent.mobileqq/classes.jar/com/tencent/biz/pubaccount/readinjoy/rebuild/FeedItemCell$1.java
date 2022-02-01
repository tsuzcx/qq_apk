package com.tencent.biz.pubaccount.readinjoy.rebuild;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ListenerBuilder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnLastReadRefreshListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import java.util.Map;

class FeedItemCell$1
  implements FeedItemCell.CellListener
{
  FeedItemCell$1(FeedItemCell paramFeedItemCell) {}
  
  public void a(View paramView, Map<String, Object> paramMap)
  {
    if (paramView.getId() == 2131380915) {
      this.a.a(paramView);
    }
    do
    {
      return;
      if (paramView != this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead) {
        break;
      }
      paramView = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.a().a();
    } while (paramView == null);
    paramView.c();
    return;
    this.a.a(paramView, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.1
 * JD-Core Version:    0.7.0.1
 */