package com.tencent.biz.pubaccount.weishi_new.combo.msg;

import com.tencent.widget.pull2refresh.XRecyclerView;
import com.tencent.widget.pull2refresh.XRecyclerView.RefreshCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgFragment$initRecyclerView$1", "Lcom/tencent/widget/pull2refresh/XRecyclerView$RefreshCallback;", "endOfRefresh", "", "startLoadMore", "recyclerView", "Lcom/tencent/widget/pull2refresh/XRecyclerView;", "reqType", "", "startTopRefresh", "isMachineRefresh", "", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMsgFragment$initRecyclerView$1
  implements XRecyclerView.RefreshCallback
{
  public void endOfRefresh() {}
  
  public void startLoadMore(@NotNull XRecyclerView paramXRecyclerView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramXRecyclerView, "recyclerView");
    ((WSMsgFragmentPresenter)this.a.aO_()).a(false, false);
  }
  
  public void startTopRefresh(@NotNull XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramXRecyclerView, "recyclerView");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.WSMsgFragment.initRecyclerView.1
 * JD-Core Version:    0.7.0.1
 */