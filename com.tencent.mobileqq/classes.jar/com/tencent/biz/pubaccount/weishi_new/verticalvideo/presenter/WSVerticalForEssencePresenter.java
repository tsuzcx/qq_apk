package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.combo.WSComboExpHelper;
import com.tencent.biz.pubaccount.weishi_new.combo.WSComboHelper;
import com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.WSComboVerticalVideoProgressManager;
import com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.WSComboVerticalVideoProgressManager.Companion;
import com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.receiver.WSComboProfilePageChangeReceiver;
import com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.receiver.WSComboScrollStateChangeReceiver;
import com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.receiver.WSComboTabChangeReceiver;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.ui.OnTabSelectedListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/presenter/WSVerticalForEssencePresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/presenter/WSVerticalForHomePresenter;", "view", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/WSVerticalPageContract$View;", "(Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/WSVerticalPageContract$View;)V", "comboProfilePageChangeEvent", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/rightpager/receiver/WSComboProfilePageChangeReceiver;", "comboScrollChangeReceiver", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/rightpager/receiver/WSComboScrollStateChangeReceiver;", "comboTabChangeReceiver", "Lcom/tencent/biz/pubaccount/weishi_new/combo/home/rightpager/receiver/WSComboTabChangeReceiver;", "mContextFeedId", "", "destroy", "", "doOnCreate", "getBottomBarHeight", "", "getCurrItemData", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/data/WSVerticalItemData;", "getLastFeedId", "getPushInfo", "handleIntent", "bundle", "Landroid/os/Bundle;", "handleVideoSelected", "isSelectedVideo", "", "isIgnoreCacheDataOnPause", "isNeedContinueFeed", "isNeedSetSystemNavigationBarColor", "isShowQuickCommentView", "onPageScrollChangeEnd", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onPageScrollChangeStart", "onPageSelected", "currentPosition", "replaceProgressBar", "shouldFetchVerticalListDataFromLocal", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSVerticalForEssencePresenter
  extends WSVerticalForHomePresenter
{
  public static final WSVerticalForEssencePresenter.Companion a = new WSVerticalForEssencePresenter.Companion(null);
  private static final int m = ScreenUtil.dip2px(52.0F);
  private final WSComboProfilePageChangeReceiver i = new WSComboProfilePageChangeReceiver(this);
  private final WSComboScrollStateChangeReceiver j = new WSComboScrollStateChangeReceiver(this);
  private final WSComboTabChangeReceiver k = new WSComboTabChangeReceiver(this);
  private String l = "";
  
  public WSVerticalForEssencePresenter(@Nullable WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  private final boolean Q()
  {
    return StringsKt.isBlank((CharSequence)this.l) ^ true;
  }
  
  protected boolean E()
  {
    return false;
  }
  
  public final void O()
  {
    Object localObject1 = K();
    if (((localObject1 instanceof WSVerticalVideoHolder)) && ((((WSVerticalVideoHolder)localObject1).c instanceof AbsWSVideoItemView)))
    {
      localObject1 = ((WSVerticalVideoHolder)localObject1).c;
      if (localObject1 != null)
      {
        Object localObject2 = ((AbsWSVideoItemView)localObject1).h();
        if ((localObject2 instanceof WSVerticalItemVideoProgressController))
        {
          localObject1 = WSComboVerticalVideoProgressManager.a.a();
          localObject2 = ((WSVerticalItemVideoProgressController)localObject2).l();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "videoProgressController.playControlBar");
          ((WSComboVerticalVideoProgressManager)localObject1).a((WSPlayerControlBar)localObject2);
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView");
      }
    }
    else
    {
      WSComboVerticalVideoProgressManager.a.a().d();
    }
  }
  
  public void a(@Nullable Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("key_home_to_context_feed_id", "");
      if (paramBundle != null) {}
    }
    else
    {
      paramBundle = "";
    }
    this.l = paramBundle;
  }
  
  public void a(@Nullable RecyclerView.ViewHolder paramViewHolder)
  {
    super.a(paramViewHolder);
    WSLog.a("WSComboVerticalVideoProgressManager", "[WSVerticalForEssencePresenter][onPageScrollChangeStart]");
    WSComboVerticalVideoProgressManager.a.a().c();
  }
  
  public void a(@Nullable RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    WSVerticalPageContract.View localView = z();
    boolean bool;
    if (localView != null) {
      bool = localView.q();
    } else {
      bool = false;
    }
    if ((paramInt == 0) && (bool))
    {
      a(paramViewHolder);
      b(paramViewHolder);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = z();
    if (localObject != null)
    {
      localObject = (OnTabSelectedListener)localObject;
      if (paramBoolean)
      {
        ((OnTabSelectedListener)localObject).A();
        return;
      }
      ((OnTabSelectedListener)localObject).B();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi_new.ui.OnTabSelectedListener");
  }
  
  public void b(@Nullable RecyclerView.ViewHolder paramViewHolder)
  {
    super.b(paramViewHolder);
    WSLog.a("WSComboVerticalVideoProgressManager", "[WSVerticalForEssencePresenter][onPageScrollChangeEnd]");
    if ((paramViewHolder instanceof WSVerticalVideoHolder))
    {
      paramViewHolder = (WSVerticalVideoHolder)paramViewHolder;
      if ((paramViewHolder.c instanceof AbsWSVideoItemView))
      {
        paramViewHolder = paramViewHolder.c;
        if (paramViewHolder != null)
        {
          Object localObject = ((AbsWSVideoItemView)paramViewHolder).h();
          if ((localObject instanceof WSVerticalItemVideoProgressController))
          {
            paramViewHolder = WSComboVerticalVideoProgressManager.a.a();
            localObject = ((WSVerticalItemVideoProgressController)localObject).l();
            Intrinsics.checkExpressionValueIsNotNull(localObject, "videoProgressController.playControlBar");
            paramViewHolder.a((WSPlayerControlBar)localObject);
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView");
        }
      }
    }
  }
  
  public void d()
  {
    super.d();
    WSSimpleEventBus.a().a((WSSimpleEventReceiver)this.i);
    WSSimpleEventBus.a().a((WSSimpleEventReceiver)this.j);
    WSSimpleEventBus.a().a((WSSimpleEventReceiver)this.k);
  }
  
  public void destroy()
  {
    super.destroy();
    WSSimpleEventBus.a().b((WSSimpleEventReceiver)this.i);
    WSSimpleEventBus.a().b((WSSimpleEventReceiver)this.j);
    WSSimpleEventBus.a().b((WSSimpleEventReceiver)this.k);
  }
  
  public boolean r()
  {
    return false;
  }
  
  public int s()
  {
    return m;
  }
  
  @Nullable
  public final WSVerticalItemData u()
  {
    return L();
  }
  
  @NotNull
  protected String v()
  {
    if (WSComboExpHelper.a.d())
    {
      String str = super.v();
      Intrinsics.checkExpressionValueIsNotNull(str, "super.getPushInfo()");
      return str;
    }
    return "";
  }
  
  protected boolean w()
  {
    if (Q()) {
      return false;
    }
    return WSComboExpHelper.a.d();
  }
  
  @NotNull
  protected String x()
  {
    if (WSComboExpHelper.a.d())
    {
      String str;
      if (StringsKt.isBlank((CharSequence)this.l)) {
        str = super.x();
      } else {
        str = this.l;
      }
      Intrinsics.checkExpressionValueIsNotNull(str, "if (mContextFeedId.isBla…ntextFeedId\n            }");
      return str;
    }
    return "";
  }
  
  protected boolean y()
  {
    return Intrinsics.areEqual(WSComboHelper.a.a(), "monofeed_tab") ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForEssencePresenter
 * JD-Core Version:    0.7.0.1
 */