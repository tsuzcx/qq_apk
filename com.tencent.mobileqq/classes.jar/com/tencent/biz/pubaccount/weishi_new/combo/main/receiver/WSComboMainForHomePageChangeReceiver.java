package com.tencent.biz.pubaccount.weishi_new.combo.main.receiver;

import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.combo.main.WSComboMainFragment;
import com.tencent.biz.pubaccount.weishi_new.event.WSComboHomePageChangeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.util.WSSystemNavigationBarUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/main/receiver/WSComboMainForHomePageChangeReceiver;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleEventReceiver;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSComboHomePageChangeEvent;", "fragment", "Lcom/tencent/biz/pubaccount/weishi_new/combo/main/WSComboMainFragment;", "(Lcom/tencent/biz/pubaccount/weishi_new/combo/main/WSComboMainFragment;)V", "fragmentRef", "Lmqq/util/WeakReference;", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "handleHomePageOnScrolling", "", "event", "handleHomePageSelected", "onReceiveEvent", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleBaseEvent;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboMainForHomePageChangeReceiver
  implements WSSimpleEventReceiver<WSComboHomePageChangeEvent>
{
  private final WeakReference<WSComboMainFragment> a;
  
  public WSComboMainForHomePageChangeReceiver(@NotNull WSComboMainFragment paramWSComboMainFragment)
  {
    this.a = new WeakReference(paramWSComboMainFragment);
  }
  
  private final void a(WSComboHomePageChangeEvent paramWSComboHomePageChangeEvent)
  {
    Object localObject1 = paramWSComboHomePageChangeEvent.getBottomBarId();
    int i = paramWSComboHomePageChangeEvent.getPageIndex();
    if (Intrinsics.areEqual("monofeed_tab", localObject1))
    {
      WSComboMainFragment localWSComboMainFragment = (WSComboMainFragment)this.a.get();
      Object localObject2 = null;
      localObject1 = null;
      if (i == 0)
      {
        if (localWSComboMainFragment != null) {
          localWSComboMainFragment.a(1 - paramWSComboHomePageChangeEvent.getOffset());
        }
        if (localWSComboMainFragment != null) {
          localObject1 = localWSComboMainFragment.getActivity();
        }
        WSSystemNavigationBarUtil.a((Activity)localObject1, 1 - paramWSComboHomePageChangeEvent.getOffset());
        return;
      }
      if (localWSComboMainFragment != null) {
        localWSComboMainFragment.a(paramWSComboHomePageChangeEvent.getOffset());
      }
      localObject1 = localObject2;
      if (localWSComboMainFragment != null) {
        localObject1 = localWSComboMainFragment.getActivity();
      }
      WSSystemNavigationBarUtil.a((Activity)localObject1, paramWSComboHomePageChangeEvent.getOffset());
    }
  }
  
  private final void b(WSComboHomePageChangeEvent paramWSComboHomePageChangeEvent)
  {
    String str = paramWSComboHomePageChangeEvent.getBottomBarId();
    int i = paramWSComboHomePageChangeEvent.getPageIndex();
    if (Intrinsics.areEqual("monofeed_tab", str))
    {
      if (i == 0) {
        i = 1;
      } else {
        i = 2;
      }
      paramWSComboHomePageChangeEvent = (WSComboMainFragment)this.a.get();
      if (paramWSComboHomePageChangeEvent != null) {
        paramWSComboHomePageChangeEvent.a(i);
      }
      if (paramWSComboHomePageChangeEvent != null) {
        paramWSComboHomePageChangeEvent.b(str, i);
      }
      if (paramWSComboHomePageChangeEvent != null) {
        paramWSComboHomePageChangeEvent = paramWSComboHomePageChangeEvent.getActivity();
      } else {
        paramWSComboHomePageChangeEvent = null;
      }
      WSSystemNavigationBarUtil.a((Activity)paramWSComboHomePageChangeEvent, i);
    }
  }
  
  public void a(@Nullable WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if ((paramWSSimpleBaseEvent instanceof WSComboHomePageChangeEvent))
    {
      paramWSSimpleBaseEvent = (WSComboHomePageChangeEvent)paramWSSimpleBaseEvent;
      if (Intrinsics.areEqual(paramWSSimpleBaseEvent.getPageChangeEvent(), "onPageScrolled"))
      {
        a(paramWSSimpleBaseEvent);
        return;
      }
      if (Intrinsics.areEqual(paramWSSimpleBaseEvent.getPageChangeEvent(), "onPageSelected")) {
        b(paramWSSimpleBaseEvent);
      }
    }
  }
  
  @NotNull
  public ArrayList<Class<WSComboHomePageChangeEvent>> z()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSComboHomePageChangeEvent.class);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.main.receiver.WSComboMainForHomePageChangeReceiver
 * JD-Core Version:    0.7.0.1
 */