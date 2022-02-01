package com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.receiver;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.combo.WSComboHelper;
import com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.WSComboVerticalVideoProgressManager;
import com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.WSComboVerticalVideoProgressManager.Companion;
import com.tencent.biz.pubaccount.weishi_new.event.WSComboMainPageChangeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForEssencePresenter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/home/rightpager/receiver/WSComboTabChangeReceiver;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleEventReceiver;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSComboMainPageChangeEvent;", "presenter", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/presenter/WSVerticalForEssencePresenter;", "(Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/presenter/WSVerticalForEssencePresenter;)V", "barId", "", "getBarId", "()Ljava/lang/String;", "setBarId", "(Ljava/lang/String;)V", "presenterWeakReference", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getPresenterWeakReference", "()Ljava/lang/ref/WeakReference;", "setPresenterWeakReference", "(Ljava/lang/ref/WeakReference;)V", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "onReceiveEvent", "", "event", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleBaseEvent;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboTabChangeReceiver
  implements WSSimpleEventReceiver<WSComboMainPageChangeEvent>
{
  @NotNull
  private WeakReference<WSVerticalForEssencePresenter> a;
  @NotNull
  private String b;
  
  public WSComboTabChangeReceiver(@NotNull WSVerticalForEssencePresenter paramWSVerticalForEssencePresenter)
  {
    this.a = new WeakReference(paramWSVerticalForEssencePresenter);
    this.b = WSComboHelper.a.a();
  }
  
  public void a(@Nullable WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (paramWSSimpleBaseEvent != null)
    {
      paramWSSimpleBaseEvent = ((WSComboMainPageChangeEvent)paramWSSimpleBaseEvent).getBarId();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSComboTabChangeReceiver][onReceiveEvent] barId:");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(", curBarId:");
      ((StringBuilder)localObject).append(paramWSSimpleBaseEvent);
      WSLog.a("WSComboVerticalVideoProgressManager", ((StringBuilder)localObject).toString());
      if ((TextUtils.equals((CharSequence)this.b, (CharSequence)"monofeed_tab")) && (!TextUtils.equals((CharSequence)paramWSSimpleBaseEvent, (CharSequence)this.b)))
      {
        WSComboVerticalVideoProgressManager.a.a().c();
        localObject = (WSVerticalForEssencePresenter)this.a.get();
        if (localObject != null) {
          ((WSVerticalForEssencePresenter)localObject).a(false);
        }
      }
      if ((!TextUtils.equals((CharSequence)this.b, (CharSequence)"monofeed_tab")) && (TextUtils.equals((CharSequence)paramWSSimpleBaseEvent, (CharSequence)"monofeed_tab")))
      {
        localObject = (WSVerticalForEssencePresenter)this.a.get();
        if (localObject != null) {
          ((WSVerticalForEssencePresenter)localObject).O();
        }
        localObject = (WSVerticalForEssencePresenter)this.a.get();
        if (localObject != null) {
          ((WSVerticalForEssencePresenter)localObject).a(true);
        }
      }
      this.b = paramWSSimpleBaseEvent;
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
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.receiver.WSComboTabChangeReceiver
 * JD-Core Version:    0.7.0.1
 */