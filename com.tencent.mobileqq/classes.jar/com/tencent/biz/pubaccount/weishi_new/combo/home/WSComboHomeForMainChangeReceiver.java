package com.tencent.biz.pubaccount.weishi_new.combo.home;

import com.tencent.biz.pubaccount.weishi_new.event.WSComboMainPageChangeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/home/WSComboHomeForMainChangeReceiver;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleEventReceiver;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSComboMainPageChangeEvent;", "fragment", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/WSComboHomeFragment;", "(Lcom/tencent/biz/pubaccount/weishi_new/combo/home/WSComboHomeFragment;)V", "fragmentRef", "Lmqq/util/WeakReference;", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "onReceiveEvent", "", "event", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleBaseEvent;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboHomeForMainChangeReceiver
  implements WSSimpleEventReceiver<WSComboMainPageChangeEvent>
{
  private final WeakReference<WSComboHomeFragment> a;
  
  public WSComboHomeForMainChangeReceiver(@NotNull WSComboHomeFragment paramWSComboHomeFragment)
  {
    this.a = new WeakReference(paramWSComboHomeFragment);
  }
  
  public void a(@Nullable WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (paramWSSimpleBaseEvent != null)
    {
      paramWSSimpleBaseEvent = ((WSComboMainPageChangeEvent)paramWSSimpleBaseEvent).getBarId();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSComboMainChangeForHomeReceiver.java][onReceiveEvent] barId:");
      ((StringBuilder)localObject).append(paramWSSimpleBaseEvent);
      WSLog.e("MainPagerChangeReceiver", ((StringBuilder)localObject).toString());
      if ((Intrinsics.areEqual(paramWSSimpleBaseEvent, "waterfall_tab")) || (Intrinsics.areEqual(paramWSSimpleBaseEvent, "monofeed_tab")))
      {
        localObject = (WSComboHomeFragment)this.a.get();
        if (localObject != null) {
          ((WSComboHomeFragment)localObject).a(paramWSSimpleBaseEvent);
        }
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi_new.event.WSComboMainPageChangeEvent");
  }
  
  @NotNull
  public ArrayList<Class<WSComboMainPageChangeEvent>> z()
  {
    return CollectionsKt.arrayListOf(new Class[] { WSComboMainPageChangeEvent.class });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.home.WSComboHomeForMainChangeReceiver
 * JD-Core Version:    0.7.0.1
 */