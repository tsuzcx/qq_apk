package com.tencent.biz.pubaccount.weishi_new.combo;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.aiolist.WSAioListHelper;
import com.tencent.biz.pubaccount.weishi_new.data.WSFeedDataManager;
import com.tencent.biz.pubaccount.weishi_new.event.WSComboProfilePageChangeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.main.WSVideoPageChangeObserver;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSBasePresenter;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileFragment;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSExposeDataManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSRecommendReportManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.gdtad.util.GdtManager.Params;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.biz.common.api.IWeiShiReportUtil;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/WSComboMainContainerPresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/presenter/WSBasePresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/WSComboMainContainerContract$View;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/WSComboMainContainerContract$Presenter;", "Lcom/tencent/biz/pubaccount/weishi_new/main/WSVideoPageChangeObserver;", "()V", "isProfilePageSelectedByClickAvatar", "", "()Z", "setProfilePageSelectedByClickAvatar", "(Z)V", "createFragmentFactory", "Lcom/tencent/biz/pubaccount/weishi_new/combo/IWSFragmentFactory;", "doOnCreate", "", "doOnDestroy", "donOnDestroyView", "getOffscreenPageLimit", "", "initGdtManager", "context", "Landroid/content/Context;", "onRightLeftPageSelected", "position", "onVideoPageHeaderClick", "onVideoSelected", "data", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/data/WSVerticalItemData;", "onVideoSelectedIdle", "reqAioListOperationFeed", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSComboMainContainerPresenter
  extends WSBasePresenter<WSComboMainContainerContract.View>
  implements WSComboMainContainerContract.Presenter, WSVideoPageChangeObserver
{
  private boolean isProfilePageSelectedByClickAvatar;
  
  @NotNull
  public IWSFragmentFactory createFragmentFactory()
  {
    return (IWSFragmentFactory)new WSMainContainerPagerFragmentFactory();
  }
  
  public void doOnCreate()
  {
    WSReportUtils.a("QQ_official_account");
    WSInitializeHelper.a().e();
    ((IWeiShiReportUtil)QRoute.api(IWeiShiReportUtil.class)).reportEnter();
  }
  
  public void doOnDestroy()
  {
    WSInitializeHelper.a().i();
    WSRecommendReportManager.a().b();
    ((IWeiShiReportUtil)QRoute.api(IWeiShiReportUtil.class)).reportExit();
    ((IImageManager)QRoute.api(IImageManager.class)).clean();
  }
  
  public void donOnDestroyView()
  {
    WSFeedDataManager.a().c();
    WeishiRequest.n.clear();
    WSExposeDataManager.a().c();
    WSPublicAccReport localWSPublicAccReport = WSPublicAccReport.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localWSPublicAccReport, "WSPublicAccReport.getInstance()");
    if (!TextUtils.equals((CharSequence)localWSPublicAccReport.getEnterPublicAccFrom(), (CharSequence)"from_qq_chat")) {
      ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast((Context)BaseApplicationImpl.getContext(), true, 10);
    }
  }
  
  public int getOffscreenPageLimit()
  {
    return 2;
  }
  
  public void initGdtManager(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    GdtManager.Params localParams = new GdtManager.Params();
    GdtManager.a().a(paramContext, localParams);
  }
  
  public final boolean isProfilePageSelectedByClickAvatar()
  {
    return this.isProfilePageSelectedByClickAvatar;
  }
  
  public void onRightLeftPageSelected(int paramInt)
  {
    Object localObject = (WSComboMainContainerContract.View)getView();
    if (localObject != null)
    {
      localObject = ((WSComboMainContainerContract.View)localObject).c();
      if (localObject != null)
      {
        localObject = (QBaseFragment)((List)localObject).get(1);
        break label39;
      }
    }
    localObject = null;
    label39:
    if (localObject != null)
    {
      localObject = (WSProfileFragment)localObject;
      if (paramInt != 0)
      {
        if (paramInt == 1)
        {
          WSSimpleEventBus.a().a((WSSimpleBaseEvent)new WSComboProfilePageChangeEvent(true, this.isProfilePageSelectedByClickAvatar));
          ((WSProfileFragment)localObject).e(false);
        }
      }
      else
      {
        WSSimpleEventBus.a().a((WSSimpleBaseEvent)new WSComboProfilePageChangeEvent(false, this.isProfilePageSelectedByClickAvatar));
        ((WSProfileFragment)localObject).n();
      }
      this.isProfilePageSelectedByClickAvatar = false;
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi_new.profile.WSProfileFragment");
  }
  
  public void onVideoPageHeaderClick()
  {
    this.isProfilePageSelectedByClickAvatar = true;
    WSComboMainContainerContract.View localView = (WSComboMainContainerContract.View)getView();
    if (localView != null) {
      localView.aG_();
    }
  }
  
  public void onVideoSelected(@NotNull WSVerticalItemData paramWSVerticalItemData, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramWSVerticalItemData, "data");
    paramWSVerticalItemData = (WSComboMainContainerContract.View)getView();
    if (paramWSVerticalItemData != null) {
      paramWSVerticalItemData.b_(false);
    }
  }
  
  public void onVideoSelectedIdle(@NotNull WSVerticalItemData paramWSVerticalItemData, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramWSVerticalItemData, "data");
    paramInt = paramWSVerticalItemData.b().video_type;
    boolean bool2 = false;
    if (paramInt != 2) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    boolean bool3 = Intrinsics.areEqual(WSComboHelper.a.a(), "monofeed_tab");
    Object localObject = (WSComboMainContainerContract.View)getView();
    if (localObject != null)
    {
      boolean bool1 = bool2;
      if (paramInt != 0)
      {
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      ((WSComboMainContainerContract.View)localObject).b_(bool1);
    }
    localObject = (WSComboMainContainerContract.View)getView();
    if (localObject != null)
    {
      localObject = ((WSComboMainContainerContract.View)localObject).c();
      if (localObject != null)
      {
        localObject = (QBaseFragment)((List)localObject).get(1);
        break label129;
      }
    }
    localObject = null;
    label129:
    if (localObject != null)
    {
      ((WSProfileFragment)localObject).a(paramWSVerticalItemData.b().poster, paramWSVerticalItemData.b().id);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi_new.profile.WSProfileFragment");
  }
  
  public void reqAioListOperationFeed() {}
  
  public final void setProfilePageSelectedByClickAvatar(boolean paramBoolean)
  {
    this.isProfilePageSelectedByClickAvatar = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.WSComboMainContainerPresenter
 * JD-Core Version:    0.7.0.1
 */