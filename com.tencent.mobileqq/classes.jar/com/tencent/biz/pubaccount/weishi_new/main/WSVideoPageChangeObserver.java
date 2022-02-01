package com.tencent.biz.pubaccount.weishi_new.main;

import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/main/WSVideoPageChangeObserver;", "Ljava/io/Serializable;", "onVideoPageHeaderClick", "", "onVideoSelected", "data", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/data/WSVerticalItemData;", "position", "", "onVideoSelectedIdle", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface WSVideoPageChangeObserver
  extends Serializable
{
  public abstract void onVideoPageHeaderClick();
  
  public abstract void onVideoSelected(@NotNull WSVerticalItemData paramWSVerticalItemData, int paramInt);
  
  public abstract void onVideoSelectedIdle(@NotNull WSVerticalItemData paramWSVerticalItemData, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.main.WSVideoPageChangeObserver
 * JD-Core Version:    0.7.0.1
 */