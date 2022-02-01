package com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.receiver;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.WSComboVerticalVideoProgressManager;
import com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.WSComboVerticalVideoProgressManager.Companion;
import com.tencent.biz.pubaccount.weishi_new.event.WSComboHomePageChangeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForEssencePresenter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/home/rightpager/receiver/WSComboScrollStateChangeReceiver;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleEventReceiver;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSComboHomePageChangeEvent;", "presenter", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/presenter/WSVerticalForEssencePresenter;", "(Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/presenter/WSVerticalForEssencePresenter;)V", "presenterWeakReference", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getPresenterWeakReference", "()Ljava/lang/ref/WeakReference;", "setPresenterWeakReference", "(Ljava/lang/ref/WeakReference;)V", "scrollState", "", "getScrollState", "()I", "setScrollState", "(I)V", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "handleOnPageScrollStateChangedEvent", "", "changeEvent", "state", "index", "handleOnPageSelectedEvent", "onReceiveEvent", "event", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleBaseEvent;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboScrollStateChangeReceiver
  implements WSSimpleEventReceiver<WSComboHomePageChangeEvent>
{
  @NotNull
  private WeakReference<WSVerticalForEssencePresenter> a;
  private int b;
  
  public WSComboScrollStateChangeReceiver(@NotNull WSVerticalForEssencePresenter paramWSVerticalForEssencePresenter)
  {
    this.a = new WeakReference(paramWSVerticalForEssencePresenter);
  }
  
  private final void a(WSComboHomePageChangeEvent paramWSComboHomePageChangeEvent)
  {
    if (Intrinsics.areEqual(paramWSComboHomePageChangeEvent.getPageChangeEvent(), "onPageSelected"))
    {
      WSVerticalForEssencePresenter localWSVerticalForEssencePresenter = (WSVerticalForEssencePresenter)this.a.get();
      if (localWSVerticalForEssencePresenter != null)
      {
        int i = paramWSComboHomePageChangeEvent.getPageIndex();
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        localWSVerticalForEssencePresenter.a(bool);
      }
    }
  }
  
  private final void a(WSComboHomePageChangeEvent paramWSComboHomePageChangeEvent, int paramInt1, int paramInt2)
  {
    if ((Intrinsics.areEqual(paramWSComboHomePageChangeEvent.getPageChangeEvent(), "onPageScrollStateChanged") ^ true)) {
      return;
    }
    if (this.b == paramInt1) {
      return;
    }
    this.b = paramInt1;
    if ((paramInt2 == 1) && (paramInt1 == 0))
    {
      paramWSComboHomePageChangeEvent = (WSVerticalForEssencePresenter)this.a.get();
      if (paramWSComboHomePageChangeEvent != null) {
        paramWSComboHomePageChangeEvent.O();
      }
    }
    else
    {
      if ((paramInt2 == 1) && ((paramInt1 == 1) || (paramInt1 == 2)))
      {
        WSComboVerticalVideoProgressManager.a.a().c();
        return;
      }
      if ((paramInt2 == 0) && (paramInt1 == 0)) {
        WSComboVerticalVideoProgressManager.a.a().c();
      }
    }
  }
  
  public void a(@Nullable WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (paramWSSimpleBaseEvent != null)
    {
      paramWSSimpleBaseEvent = (WSComboHomePageChangeEvent)paramWSSimpleBaseEvent;
      if (!TextUtils.equals((CharSequence)paramWSSimpleBaseEvent.getBottomBarId(), (CharSequence)"monofeed_tab")) {
        return;
      }
      int i = paramWSSimpleBaseEvent.getScrollState();
      int j = paramWSSimpleBaseEvent.getPageIndex();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[WSComboScrollStateChangeReceiver][onReceiveEvent] pageIndex:");
      localStringBuilder.append(j);
      localStringBuilder.append(", scrollState:");
      localStringBuilder.append(i);
      WSLog.a("WSComboVerticalVideoProgressManager", localStringBuilder.toString());
      a(paramWSSimpleBaseEvent);
      a(paramWSSimpleBaseEvent, i, j);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi_new.event.WSComboHomePageChangeEvent");
  }
  
  @NotNull
  public ArrayList<Class<WSComboHomePageChangeEvent>> z()
  {
    return CollectionsKt.arrayListOf(new Class[] { WSComboHomePageChangeEvent.class });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.receiver.WSComboScrollStateChangeReceiver
 * JD-Core Version:    0.7.0.1
 */