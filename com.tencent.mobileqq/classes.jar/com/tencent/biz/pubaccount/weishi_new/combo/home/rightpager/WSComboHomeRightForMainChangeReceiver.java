package com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager;

import com.tencent.biz.pubaccount.weishi_new.event.WSComboMainPageChangeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/home/rightpager/WSComboHomeRightForMainChangeReceiver;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleEventReceiver;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSComboMainPageChangeEvent;", "fragment", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/rightpager/WSComboHomeRightPagerFragment;", "(Lcom/tencent/biz/pubaccount/weishi_new/combo/home/rightpager/WSComboHomeRightPagerFragment;)V", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "onReceiveEvent", "", "event", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleBaseEvent;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboHomeRightForMainChangeReceiver
  implements WSSimpleEventReceiver<WSComboMainPageChangeEvent>
{
  private final WSComboHomeRightPagerFragment a;
  
  public WSComboHomeRightForMainChangeReceiver(@NotNull WSComboHomeRightPagerFragment paramWSComboHomeRightPagerFragment)
  {
    this.a = paramWSComboHomeRightPagerFragment;
  }
  
  public void a(@Nullable WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (paramWSSimpleBaseEvent != null)
    {
      paramWSSimpleBaseEvent = ((WSComboMainPageChangeEvent)paramWSSimpleBaseEvent).getBarId();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSComboMainChangeForRightReceiver.java][onReceiveEvent] barId:");
      localStringBuilder.append(paramWSSimpleBaseEvent);
      WSLog.e("MainPagerChangeReceiver", localStringBuilder.toString());
      int i = paramWSSimpleBaseEvent.hashCode();
      if (i != -710258968)
      {
        if (i != 194805079) {
          return;
        }
        if (paramWSSimpleBaseEvent.equals("monofeed_tab")) {
          this.a.a(1);
        }
      }
      else if (paramWSSimpleBaseEvent.equals("waterfall_tab"))
      {
        this.a.a(0);
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
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.WSComboHomeRightForMainChangeReceiver
 * JD-Core Version:    0.7.0.1
 */