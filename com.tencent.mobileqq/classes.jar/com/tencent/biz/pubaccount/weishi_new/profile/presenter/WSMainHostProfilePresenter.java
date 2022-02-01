package com.tencent.biz.pubaccount.weishi_new.profile.presenter;

import UserGrowth.stSimpleMetaPerson;
import com.tencent.biz.pubaccount.weishi_new.event.WSRedDotPersonEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileContract.View;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/profile/presenter/WSMainHostProfilePresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/profile/presenter/AbsWSProfilePresenter;", "()V", "hasLoadData", "", "isFragmentVisible", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "handleRetDotPerson", "", "person", "LUserGrowth/stSimpleMetaPerson;", "isToolbarShowDetailBtn", "isToolbarShowFeedbackBtn", "onFragmentVisibilityChanged", "onReceiveEvent", "event", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleBaseEvent;", "reportPageChanged", "updateAndLoadData", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMainHostProfilePresenter
  extends AbsWSProfilePresenter
{
  public static final WSMainHostProfilePresenter.Companion b = new WSMainHostProfilePresenter.Companion(null);
  private boolean c;
  private boolean d;
  
  private final void b(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (!this.c)
    {
      Object localObject1 = c();
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = ((stSimpleMetaPerson)localObject1).id;
      } else {
        localObject1 = null;
      }
      localObject1 = (CharSequence)localObject1;
      int i;
      if ((localObject1 != null) && (!StringsKt.isBlank((CharSequence)localObject1))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("person id is null. update person data. ");
        localObject1 = localObject2;
        if (paramstSimpleMetaPerson != null) {
          localObject1 = paramstSimpleMetaPerson.id;
        }
        localStringBuilder.append((String)localObject1);
        WSLog.d("WSMainHostProfilePresenter", localStringBuilder.toString());
        if (this.d)
        {
          m();
          return;
        }
        a(paramstSimpleMetaPerson);
      }
    }
  }
  
  private final void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      WSProfileBeaconReport.a(g(), d());
      return;
    }
    WSProfileBeaconReport.b(g(), d());
  }
  
  private final void m()
  {
    a(c(), f());
    a();
    WSProfileContract.View localView = (WSProfileContract.View)getView();
    if (localView != null) {
      localView.aP_();
    }
    this.c = true;
  }
  
  public void a(@Nullable WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    super.a(paramWSSimpleBaseEvent);
    if ((paramWSSimpleBaseEvent instanceof WSRedDotPersonEvent)) {
      b(((WSRedDotPersonEvent)paramWSSimpleBaseEvent).getPerson());
    }
  }
  
  @Nullable
  public ArrayList<Class<?>> b()
  {
    ArrayList localArrayList = super.b();
    if (localArrayList != null)
    {
      localArrayList.add(WSRedDotPersonEvent.class);
      return localArrayList;
    }
    return null;
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
    c(this.d);
    if (paramBoolean)
    {
      WSProfileContract.View localView = (WSProfileContract.View)getView();
      if (localView != null) {
        localView.aQ_();
      }
    }
    if ((!this.c) && (paramBoolean))
    {
      if (StringsKt.isBlank((CharSequence)d())) {
        return;
      }
      m();
    }
  }
  
  public boolean h()
  {
    return true;
  }
  
  public boolean i()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.presenter.WSMainHostProfilePresenter
 * JD-Core Version:    0.7.0.1
 */