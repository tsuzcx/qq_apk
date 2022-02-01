package com.tencent.biz.pubaccount.weishi_new.combo;

import com.tencent.biz.pubaccount.weishi_new.event.WSComboHomePageChangeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/WSComboHomePageChangeReceiver;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleEventReceiver;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSComboHomePageChangeEvent;", "fragment", "Lcom/tencent/biz/pubaccount/weishi_new/combo/WSComboMainContainerFragment;", "(Lcom/tencent/biz/pubaccount/weishi_new/combo/WSComboMainContainerFragment;)V", "fragmentRef", "Lmqq/util/WeakReference;", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "onReceiveEvent", "", "event", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleBaseEvent;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboHomePageChangeReceiver
  implements WSSimpleEventReceiver<WSComboHomePageChangeEvent>
{
  private final WeakReference<WSComboMainContainerFragment> a;
  
  public WSComboHomePageChangeReceiver(@NotNull WSComboMainContainerFragment paramWSComboMainContainerFragment)
  {
    this.a = new WeakReference(paramWSComboMainContainerFragment);
  }
  
  public void a(@Nullable WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if ((paramWSSimpleBaseEvent instanceof WSComboHomePageChangeEvent))
    {
      paramWSSimpleBaseEvent = (WSComboHomePageChangeEvent)paramWSSimpleBaseEvent;
      if ((Intrinsics.areEqual(paramWSSimpleBaseEvent.getBottomBarId(), "monofeed_tab")) && (Intrinsics.areEqual(paramWSSimpleBaseEvent.getPageChangeEvent(), "onPageSelected")))
      {
        WSComboMainContainerFragment localWSComboMainContainerFragment = (WSComboMainContainerFragment)this.a.get();
        if (localWSComboMainContainerFragment != null)
        {
          int i = paramWSSimpleBaseEvent.getPageIndex();
          boolean bool = true;
          if (i != 1) {
            bool = false;
          }
          localWSComboMainContainerFragment.b_(bool);
        }
      }
    }
  }
  
  @NotNull
  public ArrayList<Class<WSComboHomePageChangeEvent>> z()
  {
    return CollectionsKt.arrayListOf(new Class[] { WSComboHomePageChangeEvent.class });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.WSComboHomePageChangeReceiver
 * JD-Core Version:    0.7.0.1
 */