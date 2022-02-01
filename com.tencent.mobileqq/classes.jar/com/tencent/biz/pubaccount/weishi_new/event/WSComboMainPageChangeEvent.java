package com.tencent.biz.pubaccount.weishi_new.event;

import com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.WSBottomBarInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/event/WSComboMainPageChangeEvent;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleBaseEvent;", "barInfo", "Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarInfo;", "(Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarInfo;)V", "<set-?>", "", "barId", "getBarId", "()Ljava/lang/String;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboMainPageChangeEvent
  extends WSSimpleBaseEvent
{
  @NotNull
  private String barId;
  private final WSBottomBarInfo barInfo;
  
  public WSComboMainPageChangeEvent(@NotNull WSBottomBarInfo paramWSBottomBarInfo)
  {
    this.barInfo = paramWSBottomBarInfo;
    this.barId = "";
  }
  
  @NotNull
  public final String getBarId()
  {
    return this.barInfo.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSComboMainPageChangeEvent
 * JD-Core Version:    0.7.0.1
 */