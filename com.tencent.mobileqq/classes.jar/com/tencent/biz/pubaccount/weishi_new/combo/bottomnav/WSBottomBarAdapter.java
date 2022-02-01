package com.tencent.biz.pubaccount.weishi_new.combo.bottomnav;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.combo.WSComboHelper;
import com.tencent.biz.pubaccount.weishi_new.combo.WSFrameBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.holder.AbsWSBottomBarHolder;
import com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.holder.WSBottomBarHolderFactory;
import com.tencent.biz.pubaccount.weishi_new.combo.main.WSComboMainContract.View;
import com.tencent.biz.pubaccount.weishi_new.combo.publisher.WSPublisherHelper;
import com.tencent.biz.pubaccount.weishi_new.combo.publisher.WSPublisherUtil;
import com.tencent.biz.pubaccount.weishi_new.event.WSComboMainPageChangeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.view.bottomnav.WSBottomNavigationBar.BarAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarAdapter;", "Lcom/tencent/biz/pubaccount/weishi_new/view/bottomnav/WSBottomNavigationBar$BarAdapter;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/holder/AbsWSBottomBarHolder;", "comboMainView", "Lcom/tencent/biz/pubaccount/weishi_new/combo/main/WSComboMainContract$View;", "(Lcom/tencent/biz/pubaccount/weishi_new/combo/main/WSComboMainContract$View;)V", "barInfoList", "", "Lcom/tencent/biz/pubaccount/weishi_new/combo/bottomnav/WSBottomBarInfo;", "getBarCount", "", "getBarType", "position", "getBottomBarInfoById", "barId", "", "getBottomBarStyleByBarId", "handleOnBarTabSelected", "", "selectedBarInfo", "nonRefreshBarView", "", "currentBarId", "onBarViewClick", "barHolder", "onBindBarHolder", "onCreateBarHolder", "parent", "Landroid/view/ViewGroup;", "barType", "refreshBarViewOnSelected", "barStyle", "refreshBarViewRedDot", "redNum", "setData", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSBottomBarAdapter
  extends WSBottomNavigationBar.BarAdapter<AbsWSBottomBarHolder>
{
  public static final WSBottomBarAdapter.Companion a = new WSBottomBarAdapter.Companion(null);
  private List<WSBottomBarInfo> b;
  private final WSComboMainContract.View c;
  
  public WSBottomBarAdapter(@NotNull WSComboMainContract.View paramView)
  {
    this.c = paramView;
  }
  
  private final int a(String paramString)
  {
    int i = paramString.hashCode();
    if (i != -235365105)
    {
      if ((i == 194805079) && (paramString.equals("monofeed_tab"))) {
        return 2;
      }
    }
    else if (paramString.equals("publish")) {
      return -1;
    }
    return 1;
  }
  
  private final WSBottomBarInfo b(String paramString)
  {
    List localList = this.b;
    if (localList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("barInfoList");
    }
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      localList = this.b;
      if (localList == null) {
        Intrinsics.throwUninitializedPropertyAccessException("barInfoList");
      }
      if (Intrinsics.areEqual(((WSBottomBarInfo)localList.get(i)).f(), paramString))
      {
        paramString = this.b;
        if (paramString == null) {
          Intrinsics.throwUninitializedPropertyAccessException("barInfoList");
        }
        return (WSBottomBarInfo)paramString.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  private final boolean c(String paramString)
  {
    return Intrinsics.areEqual(paramString, "publish");
  }
  
  public int a()
  {
    List localList = this.b;
    if (localList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("barInfoList");
    }
    return localList.size();
  }
  
  public int a(int paramInt)
  {
    List localList = this.b;
    if (localList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("barInfoList");
    }
    return ((WSBottomBarInfo)localList.get(paramInt)).g();
  }
  
  @NotNull
  public AbsWSBottomBarHolder a(@NotNull ViewGroup paramViewGroup, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "parent");
    return WSBottomBarHolderFactory.a.a(this, paramViewGroup, paramInt);
  }
  
  public final void a(@NotNull WSBottomBarInfo paramWSBottomBarInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramWSBottomBarInfo, "selectedBarInfo");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSBottomBarAdapter.java][handleOnBarTabSelected] barId:");
    localStringBuilder.append(paramWSBottomBarInfo.f());
    WSLog.e("WSBottomBarAdapterLog", localStringBuilder.toString());
    if ((Intrinsics.areEqual(paramWSBottomBarInfo.f(), WSComboHelper.a.a()) ^ true))
    {
      WSComboHelper.a.a(paramWSBottomBarInfo.f());
      int i = a(paramWSBottomBarInfo.f());
      a(paramWSBottomBarInfo.f(), i);
      this.c.a(paramWSBottomBarInfo.f());
      this.c.a(i);
      this.c.b(i);
      WSSimpleEventBus.a().a((WSSimpleBaseEvent)new WSComboMainPageChangeEvent(paramWSBottomBarInfo));
    }
  }
  
  public final void a(@NotNull AbsWSBottomBarHolder paramAbsWSBottomBarHolder)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsWSBottomBarHolder, "barHolder");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSBottomBarAdapter.java][onBarViewClick] barType:");
    ((StringBuilder)localObject).append(paramAbsWSBottomBarHolder.a().g());
    ((StringBuilder)localObject).append(", barId:");
    ((StringBuilder)localObject).append(paramAbsWSBottomBarHolder.a().f());
    WSLog.e("WSBottomBarAdapterLog", ((StringBuilder)localObject).toString());
    if (Intrinsics.areEqual(paramAbsWSBottomBarHolder.a().f(), "publish"))
    {
      localObject = WSPublisherUtil.a;
      paramAbsWSBottomBarHolder = paramAbsWSBottomBarHolder.c().getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramAbsWSBottomBarHolder, "barHolder.barView.context");
      ((WSPublisherUtil)localObject).a(paramAbsWSBottomBarHolder, WSPublisherHelper.a.a(), "frame");
      return;
    }
    WSFrameBeaconReport.a(paramAbsWSBottomBarHolder.a().b(), 1000001);
    a(paramAbsWSBottomBarHolder.a());
  }
  
  public void a(@NotNull AbsWSBottomBarHolder paramAbsWSBottomBarHolder, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsWSBottomBarHolder, "barHolder");
    List localList = this.b;
    if (localList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("barInfoList");
    }
    localList.get(paramInt);
    localList = this.b;
    if (localList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("barInfoList");
    }
    paramAbsWSBottomBarHolder.b((WSBottomBarInfo)localList.get(paramInt), paramInt);
  }
  
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "currentBarId");
    if (c(paramString)) {
      return;
    }
    Object localObject = this.b;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("barInfoList");
    }
    int j = ((List)localObject).size();
    int i = 0;
    while (i < j)
    {
      localObject = this.b;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("barInfoList");
      }
      localObject = (WSBottomBarInfo)((List)localObject).get(i);
      if (!c(((WSBottomBarInfo)localObject).f()))
      {
        if (Intrinsics.areEqual(((WSBottomBarInfo)localObject).f(), paramString)) {
          ((WSBottomBarInfo)localObject).a(0);
        }
        ((WSBottomBarInfo)localObject).b(paramString);
        ((WSBottomBarInfo)localObject).b(paramInt);
        b(i);
      }
      i += 1;
    }
  }
  
  public final void a(@NotNull List<WSBottomBarInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "barInfoList");
    this.b = paramList;
    c();
  }
  
  public final void b(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "currentBarId");
    paramString = b(paramString);
    if (paramString != null)
    {
      paramString.a(paramInt);
      b(paramString.e());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.bottomnav.WSBottomBarAdapter
 * JD-Core Version:    0.7.0.1
 */