package com.tencent.biz.pubaccount.weishi_new.combo.msg;

import com.tencent.biz.pubaccount.weishi_new.verticalvideo.view.WSSwipeRefreshLayout.OnInterceptTouchEventListener;
import com.tencent.biz.pubaccount.weishi_new.view.WSXRecyclerView;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgFragment$initSwipeRefreshLayout$1", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/view/WSSwipeRefreshLayout$OnInterceptTouchEventListener;", "isInterceptTouchEvent", "", "isRequestDisallowInterceptTouchEvent", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMsgFragment$initSwipeRefreshLayout$1
  implements WSSwipeRefreshLayout.OnInterceptTouchEventListener
{
  public boolean a()
  {
    return false;
  }
  
  public boolean b()
  {
    return WSMsgFragment.b(this.a).getRecyclerView().canScrollVertically(-1) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.WSMsgFragment.initSwipeRefreshLayout.1
 * JD-Core Version:    0.7.0.1
 */