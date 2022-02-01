package com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.receiver;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.event.WSComboProfilePageChangeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForEssencePresenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/home/rightpager/receiver/WSComboProfilePageChangeReceiver;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleEventReceiver;", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSComboProfilePageChangeEvent;", "presenter", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/presenter/WSVerticalForEssencePresenter;", "(Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/presenter/WSVerticalForEssencePresenter;)V", "presenterWeakReference", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getPresenterWeakReference", "()Ljava/lang/ref/WeakReference;", "setPresenterWeakReference", "(Ljava/lang/ref/WeakReference;)V", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "onReceiveEvent", "", "event", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleBaseEvent;", "reportAvatarClick", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboProfilePageChangeReceiver
  implements WSSimpleEventReceiver<WSComboProfilePageChangeEvent>
{
  @NotNull
  private WeakReference<WSVerticalForEssencePresenter> a;
  
  public WSComboProfilePageChangeReceiver(@NotNull WSVerticalForEssencePresenter paramWSVerticalForEssencePresenter)
  {
    this.a = new WeakReference(paramWSVerticalForEssencePresenter);
  }
  
  private final void a()
  {
    Object localObject1 = (WSVerticalForEssencePresenter)this.a.get();
    String str2 = null;
    if (localObject1 != null)
    {
      localObject1 = ((WSVerticalForEssencePresenter)localObject1).u();
      if (localObject1 != null)
      {
        localObject1 = ((WSVerticalItemData)localObject1).b();
        break label37;
      }
    }
    localObject1 = null;
    label37:
    Object localObject2 = (WSVerticalForEssencePresenter)this.a.get();
    if (localObject2 != null) {
      localObject2 = ((WSVerticalForEssencePresenter)localObject2).n();
    } else {
      localObject2 = null;
    }
    Object localObject3 = (WSVerticalForEssencePresenter)this.a.get();
    if (localObject3 != null) {
      localObject3 = ((WSVerticalForEssencePresenter)localObject3).z();
    } else {
      localObject3 = null;
    }
    String str1;
    if (localObject3 != null) {
      str1 = ((WSVerticalPageContract.View)localObject3).k();
    } else {
      str1 = null;
    }
    if (localObject3 != null) {
      str2 = ((WSVerticalPageContract.View)localObject3).l();
    }
    WSVerticalBeaconReport.a(str1, str2, "left_slide", 1007007, (stSimpleMetaFeed)localObject1, (Map)localObject2);
  }
  
  public void a(@Nullable WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (!(paramWSSimpleBaseEvent instanceof WSComboProfilePageChangeEvent)) {
      return;
    }
    WSVerticalForEssencePresenter localWSVerticalForEssencePresenter = (WSVerticalForEssencePresenter)this.a.get();
    if (localWSVerticalForEssencePresenter != null) {
      localWSVerticalForEssencePresenter.a(((WSComboProfilePageChangeEvent)paramWSSimpleBaseEvent).getSelectedProfile() ^ true);
    }
    paramWSSimpleBaseEvent = (WSComboProfilePageChangeEvent)paramWSSimpleBaseEvent;
    if ((paramWSSimpleBaseEvent.getSelectedProfile()) && (!paramWSSimpleBaseEvent.isSelectedByClickAvatar())) {
      a();
    }
  }
  
  @NotNull
  public ArrayList<Class<WSComboProfilePageChangeEvent>> z()
  {
    return CollectionsKt.arrayListOf(new Class[] { WSComboProfilePageChangeEvent.class });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.receiver.WSComboProfilePageChangeReceiver
 * JD-Core Version:    0.7.0.1
 */