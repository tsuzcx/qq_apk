package com.tencent.biz.pubaccount.weishi_new.event;

import UserGrowth.stSimpleMetaPerson;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/event/WSRedDotPersonEvent;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleBaseEvent;", "person", "LUserGrowth/stSimpleMetaPerson;", "(LUserGrowth/stSimpleMetaPerson;)V", "getPerson", "()LUserGrowth/stSimpleMetaPerson;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSRedDotPersonEvent
  extends WSSimpleBaseEvent
{
  @Nullable
  private final stSimpleMetaPerson person;
  
  public WSRedDotPersonEvent(@Nullable stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    this.person = paramstSimpleMetaPerson;
  }
  
  @Nullable
  public final stSimpleMetaPerson getPerson()
  {
    return this.person;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSRedDotPersonEvent
 * JD-Core Version:    0.7.0.1
 */