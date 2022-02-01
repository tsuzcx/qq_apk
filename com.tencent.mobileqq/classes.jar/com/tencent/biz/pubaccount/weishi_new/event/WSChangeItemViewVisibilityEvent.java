package com.tencent.biz.pubaccount.weishi_new.event;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/event/WSChangeItemViewVisibilityEvent;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleBaseEvent;", "feedId", "", "isShow", "", "(Ljava/lang/String;Z)V", "isChangeFirstItem", "(ZZ)V", "<set-?>", "getFeedId", "()Ljava/lang/String;", "()Z", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSChangeItemViewVisibilityEvent
  extends WSSimpleBaseEvent
{
  @NotNull
  private String feedId;
  private boolean isChangeFirstItem;
  private boolean isShow;
  
  public WSChangeItemViewVisibilityEvent(@NotNull String paramString, boolean paramBoolean)
  {
    this.feedId = paramString;
    this.isShow = paramBoolean;
    this.isChangeFirstItem = false;
  }
  
  public WSChangeItemViewVisibilityEvent(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.feedId = "";
    this.isShow = paramBoolean2;
    this.isChangeFirstItem = paramBoolean1;
  }
  
  @NotNull
  public final String getFeedId()
  {
    return this.feedId;
  }
  
  public final boolean isChangeFirstItem()
  {
    return this.isChangeFirstItem;
  }
  
  public final boolean isShow()
  {
    return this.isShow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSChangeItemViewVisibilityEvent
 * JD-Core Version:    0.7.0.1
 */