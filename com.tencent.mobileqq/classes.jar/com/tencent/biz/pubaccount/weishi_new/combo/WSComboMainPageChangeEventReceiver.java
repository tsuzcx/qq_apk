package com.tencent.biz.pubaccount.weishi_new.combo;

import com.tencent.biz.pubaccount.weishi_new.event.WSComboMainPageChangeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/WSComboMainPageChangeEventReceiver;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleEventReceiver;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSComboMainPageChangeEvent;", "fragment", "Lcom/tencent/biz/pubaccount/weishi_new/combo/WSComboMainContainerFragment;", "(Lcom/tencent/biz/pubaccount/weishi_new/combo/WSComboMainContainerFragment;)V", "fragmentRef", "Lmqq/util/WeakReference;", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "onReceiveEvent", "", "event", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleBaseEvent;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboMainPageChangeEventReceiver
  implements WSSimpleEventReceiver<WSComboMainPageChangeEvent>
{
  private final WeakReference<WSComboMainContainerFragment> a;
  
  public WSComboMainPageChangeEventReceiver(@NotNull WSComboMainContainerFragment paramWSComboMainContainerFragment)
  {
    this.a = new WeakReference(paramWSComboMainContainerFragment);
  }
  
  public void a(@NotNull WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramWSSimpleBaseEvent, "event");
    paramWSSimpleBaseEvent = ((WSComboMainPageChangeEvent)paramWSSimpleBaseEvent).getBarId();
    WSComboMainContainerFragment localWSComboMainContainerFragment = (WSComboMainContainerFragment)this.a.get();
    if (localWSComboMainContainerFragment != null) {
      localWSComboMainContainerFragment.b_(Intrinsics.areEqual(paramWSSimpleBaseEvent, "monofeed_tab"));
    }
  }
  
  @NotNull
  public ArrayList<Class<WSComboMainPageChangeEvent>> z()
  {
    return CollectionsKt.arrayListOf(new Class[] { WSComboMainPageChangeEvent.class });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.WSComboMainPageChangeEventReceiver
 * JD-Core Version:    0.7.0.1
 */