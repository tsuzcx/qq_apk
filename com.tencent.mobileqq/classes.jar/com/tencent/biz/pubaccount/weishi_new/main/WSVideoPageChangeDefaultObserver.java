package com.tencent.biz.pubaccount.weishi_new.main;

import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/main/WSVideoPageChangeDefaultObserver;", "Lcom/tencent/biz/pubaccount/weishi_new/main/WSVideoPageChangeObserver;", "()V", "onVideoPageHeaderClick", "", "onVideoSelected", "data", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/data/WSVerticalItemData;", "position", "", "onVideoSelectedIdle", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSVideoPageChangeDefaultObserver
  implements WSVideoPageChangeObserver
{
  public void onVideoPageHeaderClick() {}
  
  public void onVideoSelected(@NotNull WSVerticalItemData paramWSVerticalItemData, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramWSVerticalItemData, "data");
  }
  
  public void onVideoSelectedIdle(@NotNull WSVerticalItemData paramWSVerticalItemData, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramWSVerticalItemData, "data");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.main.WSVideoPageChangeDefaultObserver
 * JD-Core Version:    0.7.0.1
 */