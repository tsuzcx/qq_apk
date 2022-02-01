package com.tencent.biz.pubaccount.weishi_new.event;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/event/WSComboProfilePageChangeEvent;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleBaseEvent;", "selectedProfile", "", "isSelectedByClickAvatar", "(ZZ)V", "()Z", "getSelectedProfile", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboProfilePageChangeEvent
  extends WSSimpleBaseEvent
{
  private final boolean isSelectedByClickAvatar;
  private final boolean selectedProfile;
  
  public WSComboProfilePageChangeEvent(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.selectedProfile = paramBoolean1;
    this.isSelectedByClickAvatar = paramBoolean2;
  }
  
  public final boolean getSelectedProfile()
  {
    return this.selectedProfile;
  }
  
  public final boolean isSelectedByClickAvatar()
  {
    return this.isSelectedByClickAvatar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSComboProfilePageChangeEvent
 * JD-Core Version:    0.7.0.1
 */