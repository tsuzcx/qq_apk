package com.tencent.biz.pubaccount.weishi_new.event;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/event/WSComboHomePageChangeEvent;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleBaseEvent;", "pageChangeEvent", "", "bottomBarId", "pageIndex", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getBottomBarId", "()Ljava/lang/String;", "offset", "", "getOffset", "()F", "setOffset", "(F)V", "getPageChangeEvent", "getPageIndex", "()I", "scrollState", "getScrollState", "setScrollState", "(I)V", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboHomePageChangeEvent
  extends WSSimpleBaseEvent
{
  public static final WSComboHomePageChangeEvent.Companion Companion = new WSComboHomePageChangeEvent.Companion(null);
  @NotNull
  public static final String EVENT_ON_PAGE_SCROLLED = "onPageScrolled";
  @NotNull
  public static final String EVENT_ON_PAGE_SCROLL_STATE_CHANGED = "onPageScrollStateChanged";
  @NotNull
  public static final String EVENT_ON_PAGE_SELECTED = "onPageSelected";
  @NotNull
  private final String bottomBarId;
  private float offset;
  @NotNull
  private final String pageChangeEvent;
  private final int pageIndex;
  private int scrollState;
  
  public WSComboHomePageChangeEvent(@NotNull String paramString1, @NotNull String paramString2, int paramInt)
  {
    this.pageChangeEvent = paramString1;
    this.bottomBarId = paramString2;
    this.pageIndex = paramInt;
  }
  
  @NotNull
  public final String getBottomBarId()
  {
    return this.bottomBarId;
  }
  
  public final float getOffset()
  {
    return this.offset;
  }
  
  @NotNull
  public final String getPageChangeEvent()
  {
    return this.pageChangeEvent;
  }
  
  public final int getPageIndex()
  {
    return this.pageIndex;
  }
  
  public final int getScrollState()
  {
    return this.scrollState;
  }
  
  public final void setOffset(float paramFloat)
  {
    this.offset = paramFloat;
  }
  
  public final void setScrollState(int paramInt)
  {
    this.scrollState = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSComboHomePageChangeEvent
 * JD-Core Version:    0.7.0.1
 */