package com.tencent.biz.pubaccount.weishi_new.drama;

import UserGrowth.stDramaFeed;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi_new.WSInstanceStateForSceneFrom;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.cache.WSVideoPreloadManager;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaDataManager;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSEpisodeItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.history.WSDramaHistoryPart;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaHolder;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.drama.part.IWSPartLifeCycle;
import com.tencent.biz.pubaccount.weishi_new.drama.presenter.WSDramaForCommonPresenter;
import com.tencent.biz.pubaccount.weishi_new.drama.report.WSDramaBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.drama.topbar.WSDramaPageTopBarAreaFactory;
import com.tencent.biz.pubaccount.weishi_new.drama.utils.WSDramaUtils;
import com.tencent.biz.pubaccount.weishi_new.event.WSDramaVideoExposureEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerAudioControl;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalLinearLayoutManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.kandian.base.view.widget.ListEventListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WSDramaPageFragment
  extends WSBaseFragment<WSDramaPageContract.View, WSDramaPageContract.Presenter>
  implements WSDramaMiddlePart.OnDramaDataListener, WSDramaPageContract.View, WSSimpleEventReceiver, ListEventListener
{
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private final WSInstanceStateForSceneFrom jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSInstanceStateForSceneFrom = new WSInstanceStateForSceneFrom();
  private AbsWsUIGroup<Object> jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
  private WSDramaMiddlePart jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaMiddlePart;
  private WSDramaPageAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageAdapter;
  private WSDramaHistoryPart jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryPart;
  private AbsWSDramaHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHolderAbsWSDramaHolder;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private String jdField_a_of_type_JavaLangString;
  private ViewStub jdField_b_of_type_AndroidViewViewStub;
  private AbsWsUIGroup<Object> jdField_b_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
  private String jdField_b_of_type_JavaLangString;
  private ViewStub jdField_c_of_type_AndroidViewViewStub;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  
  private static Intent a(WSDramaPageIntentParams paramWSDramaPageIntentParams)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("from", paramWSDramaPageIntentParams.a());
    localBundle.putString("drama_id", paramWSDramaPageIntentParams.b());
    localBundle.putString("episode_id", paramWSDramaPageIntentParams.c());
    localBundle.putString("drama_jump_schema", paramWSDramaPageIntentParams.d());
    localBundle.putString("sub_tab_id", paramWSDramaPageIntentParams.e());
    localBundle.putInt("cur_episode_num", paramWSDramaPageIntentParams.a());
    localBundle.putInt("drama_num", paramWSDramaPageIntentParams.b());
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131380871));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131372399));
    this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131380783));
    this.jdField_c_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131380776));
    b(paramView);
    h();
    c(paramView);
    c();
  }
  
  public static void a(WSDramaPageIntentParams paramWSDramaPageIntentParams)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSDramaPageFragment.java][start] params:");
    ((StringBuilder)localObject).append(paramWSDramaPageIntentParams);
    WSLog.d("WSDramaPageFragmentLog", ((StringBuilder)localObject).toString());
    localObject = a(paramWSDramaPageIntentParams);
    PublicFragmentActivity.Launcher.a(paramWSDramaPageIntentParams.a(), (Intent)localObject, PublicFragmentActivity.class, WSDramaPageFragment.class);
  }
  
  private void a(WSPlayerManager paramWSPlayerManager)
  {
    if ((paramWSPlayerManager != null) && (paramWSPlayerManager.c())) {
      WSDramaUtils.a(this, paramWSPlayerManager.a(), false);
    }
  }
  
  private void a(@Nullable String paramString1, @Nullable String paramString2)
  {
    if ("aio_red_dot".equals(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      WeishiScehmeUtil.a(getContext(), "biz_src_jc_gzh_weishi", paramString2);
    }
  }
  
  private boolean a(stDramaFeed paramstDramaFeed, AbsWSDramaVideoHolder paramAbsWSDramaVideoHolder)
  {
    return TextUtils.equals(paramstDramaFeed.feed.id, WSPlayerUtils.a(paramAbsWSDramaVideoHolder.a()));
  }
  
  private boolean a(AbsWSDramaHolder paramAbsWSDramaHolder1, AbsWSDramaHolder paramAbsWSDramaHolder2)
  {
    if (((paramAbsWSDramaHolder1 instanceof AbsWSDramaVideoHolder)) && ((paramAbsWSDramaHolder2 instanceof AbsWSDramaVideoHolder)))
    {
      paramAbsWSDramaHolder1 = (AbsWSDramaVideoHolder)paramAbsWSDramaHolder1;
      paramAbsWSDramaHolder2 = (AbsWSDramaVideoHolder)paramAbsWSDramaHolder2;
      return WSPlayerUtils.a(paramAbsWSDramaHolder1.a(), paramAbsWSDramaHolder2.a());
    }
    return false;
  }
  
  private void b(View paramView)
  {
    paramView = (ViewStub)paramView.findViewById(2131380874);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup = WSDramaPageTopBarAreaFactory.a(this, this.jdField_a_of_type_JavaLangString);
    AbsWsUIGroup localAbsWsUIGroup = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(paramView);
    }
  }
  
  private void b(WSPlayerManager paramWSPlayerManager)
  {
    if ((paramWSPlayerManager != null) && ((paramWSPlayerManager.c()) || (paramWSPlayerManager.b())))
    {
      WSDramaUtils.b(this, paramWSPlayerManager.a(), false);
      paramWSPlayerManager.g();
    }
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)paramView.findViewById(2131376877));
    paramView = new WSVerticalLinearLayoutManager(getActivity(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView, 0, false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.setEnableHeaderView(false);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageAdapter = new WSDramaPageAdapter(getActivity(), this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.a(this);
  }
  
  private void e()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.jdField_a_of_type_JavaLangString = localBundle.getString("from");
      this.jdField_b_of_type_JavaLangString = localBundle.getString("drama_id");
      this.jdField_c_of_type_JavaLangString = localBundle.getString("drama_jump_schema");
      this.jdField_d_of_type_JavaLangString = localBundle.getString("sub_tab_id");
    }
  }
  
  private void g()
  {
    WSSimpleEventBus.a().a(this);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = new WSPlayerManager(WeishiUtils.a());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f(false);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e(false);
  }
  
  public WSDramaPageAdapter a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageAdapter;
  }
  
  @android.support.annotation.NonNull
  public WSDramaPageContract.Presenter a()
  {
    return new WSDramaForCommonPresenter();
  }
  
  public AbsWSDramaHolder a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHolderAbsWSDramaHolder;
  }
  
  public WSPlayerManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSDramaVideoExposureEvent.class);
    return localArrayList;
  }
  
  public HashSet<IWSPartLifeCycle> a()
  {
    HashSet localHashSet = new HashSet();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryPart = WSDramaHistoryPart.a(getContext(), this.jdField_c_of_type_AndroidViewViewStub, this, this.jdField_a_of_type_JavaLangString);
    localHashSet.add(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryPart);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaMiddlePart = WSDramaMiddlePart.a(this, this.jdField_b_of_type_AndroidViewViewStub, getArguments());
    localHashSet.add(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaMiddlePart);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaMiddlePart.a(this);
    return localHashSet;
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_a_of_type_Boolean) {
      WeishiUtils.c("drama_preview");
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaPageFragment.java][showError] code:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", msg:");
    localStringBuilder.append(paramString);
    WSLog.d("WSDramaPageFragmentLog", localStringBuilder.toString());
    if (this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup == null)
    {
      this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup = new WSDramaPageErrorViewController(getActivity(), this);
      this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup.a(this.jdField_a_of_type_AndroidViewViewStub);
    }
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
  }
  
  public void a(stDramaFeed paramstDramaFeed)
  {
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[WSDramaPageFragment.java][onDramaFeedReceive] dramaFeed:");
    if (paramstDramaFeed == null) {
      localObject1 = null;
    } else {
      localObject1 = paramstDramaFeed.toString();
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    WSLog.a("WSDramaPageFragmentLognel-log", ((StringBuilder)localObject2).toString());
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[WSDramaPageFragment.java][onDramaFeedReceive] getIntentDramaId:");
    ((StringBuilder)localObject1).append(b());
    WSLog.a("WSDramaPageFragmentLognel-log", ((StringBuilder)localObject1).toString());
    if (paramstDramaFeed != null)
    {
      if (!TextUtils.equals(paramstDramaFeed.dramaID, b())) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[WSDramaPageFragment.java][onDramaFeedReceive] feedDramaId:");
      ((StringBuilder)localObject1).append(paramstDramaFeed.dramaID);
      ((StringBuilder)localObject1).append(", curDramaId:");
      ((StringBuilder)localObject1).append(b());
      WSLog.a("WSDramaPageFragmentLognel-log", ((StringBuilder)localObject1).toString());
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHolderAbsWSDramaHolder;
      if (!(localObject1 instanceof AbsWSDramaVideoHolder)) {
        return;
      }
      localObject1 = (AbsWSDramaVideoHolder)localObject1;
      if (a(paramstDramaFeed, (AbsWSDramaVideoHolder)localObject1))
      {
        WSLog.d("WSDramaPageFragmentLog", "[WSDramaPageFragment.java][onDramaFeedReceive] sameVideo!");
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageAdapter.a();
      localObject2 = ((AbsWSDramaVideoHolder)localObject1).a;
      ((WSDramaItemData)localObject2).a(paramstDramaFeed);
      ((WSDramaItemData)localObject2).a(paramstDramaFeed.feed);
      ((AbsWSDramaVideoHolder)localObject1).a(paramstDramaFeed.feed, ((AbsWSDramaVideoHolder)localObject1).getAdapterPosition(), a());
      a((AbsWSDramaHolder)localObject1);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageAdapter.a((AbsWSDramaVideoHolder)localObject1);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = paramViewHolder.getLayoutPosition() - 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaPageFragment.java][onCenterViewChanged] currentPosition:");
    localStringBuilder.append(i);
    localStringBuilder.append(", viewHolder:");
    localStringBuilder.append(paramViewHolder);
    WSLog.e("WSDramaPageFragmentLognel-log", localStringBuilder.toString());
    if ((paramViewHolder instanceof AbsWSDramaHolder))
    {
      paramViewHolder = (AbsWSDramaHolder)paramViewHolder;
      if (a(paramViewHolder, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageAdapter.a()))
      {
        WSLog.d("WSDramaPageFragmentLog", "[WSDramaPageFragment.java][onCenterViewChanged]");
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHolderAbsWSDramaHolder = paramViewHolder;
      this.jdField_b_of_type_JavaLangString = paramViewHolder.a.a();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaMiddlePart.a(paramViewHolder, i);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageAdapter.a(paramViewHolder, i);
      ((WSDramaPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a(paramViewHolder, i);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHistoryWSDramaHistoryPart.a(paramViewHolder, i);
      paramViewHolder.a(i);
      c();
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(WSDramaItemData paramWSDramaItemData, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaPageFragment.java][onDramaSelected] dramaId:");
    localStringBuilder.append(paramWSDramaItemData.a());
    WSLog.a("WSDramaPageFragmentLognel-log", localStringBuilder.toString());
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramWSDramaItemData.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.scrollToPosition(paramInt);
  }
  
  public void a(WSEpisodeItemData paramWSEpisodeItemData, int paramInt)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageAdapter.a();
  }
  
  public void a(AbsWSDramaHolder paramAbsWSDramaHolder)
  {
    WSDramaBeaconReport.a(WSDramaUtils.b(paramAbsWSDramaHolder), WSDramaUtils.a(paramAbsWSDramaHolder), WSDramaUtils.c(paramAbsWSDramaHolder), WSDramaUtils.a(paramAbsWSDramaHolder), this.jdField_a_of_type_JavaLangString, WSDramaUtils.b(paramAbsWSDramaHolder));
  }
  
  public void a(AbsWSDramaVideoHolder paramAbsWSDramaVideoHolder, String paramString1, String paramString2, int paramInt)
  {
    if (paramAbsWSDramaVideoHolder == null) {
      return;
    }
    WSPlayerParam localWSPlayerParam = WSDramaDataManager.a().a();
    if (localWSPlayerParam == null) {
      return;
    }
    if ((localWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper != null) && (localWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView != null) && (paramAbsWSDramaVideoHolder.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null))
    {
      paramAbsWSDramaVideoHolder.a().jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper = localWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper;
      paramAbsWSDramaVideoHolder.a().jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView = localWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWrapperIWSVideoView;
      paramAbsWSDramaVideoHolder.a().jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportIWSPlayerReport = localWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerReportIWSPlayerReport;
      paramAbsWSDramaVideoHolder.a().jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper.c(false);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageAdapter.c(paramAbsWSDramaVideoHolder);
      WSVerticalBeaconReport.a(paramString1, paramString2, paramAbsWSDramaVideoHolder.a(), false, paramInt, null);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(paramAbsWSDramaVideoHolder.a(), true);
      paramString1 = new StringBuilder();
      paramString1.append("[WSDramaPageFragment.java][handleOnActivityResultFromVertical], title: ");
      paramString1.append(paramAbsWSDramaVideoHolder.a().jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.jdField_d_of_type_JavaLangString);
      paramString1.append(", playingHolder: ");
      paramString1.append(paramAbsWSDramaVideoHolder);
      WSLog.a("WSDramaPageFragmentLog", paramString1.toString());
    }
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    ((WSDramaPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a(paramWSSimpleBaseEvent);
  }
  
  public void a(WSPlayerParam paramWSPlayerParam)
  {
    WSLog.a("WSDramaPageFragmentLognel-log", "[WSDramaPageFragment.java][onVideoStarted]");
    ((WSDramaPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a(paramWSPlayerParam);
    f();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaMiddlePart.g();
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    ((WSDramaPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a(paramWSPlayerParam, paramBoolean);
  }
  
  public void a(List<WSDramaItemData> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageAdapter.fillList(paramList);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaMiddlePart.a(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ((WSDramaPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a(paramBoolean2, paramBoolean1);
  }
  
  public void aC_() {}
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(stDramaFeed paramstDramaFeed)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaPageFragment.java][onDramaPreloadFeedReceive] dramaFeed:");
    String str;
    if (paramstDramaFeed == null) {
      str = null;
    } else {
      str = paramstDramaFeed.toString();
    }
    localStringBuilder.append(str);
    WSLog.a("WSDramaPageFragmentLognel-log", localStringBuilder.toString());
    if (paramstDramaFeed == null) {
      return;
    }
    WSVideoPreloadManager.a(paramstDramaFeed.feed);
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void b(WSPlayerParam paramWSPlayerParam)
  {
    this.jdField_d_of_type_Boolean = true;
    ((WSDramaPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).b(paramWSPlayerParam);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaMiddlePart.f();
  }
  
  public void b(List<WSDramaItemData> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageAdapter.a(paramList);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaMiddlePart.a(paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
      return;
    }
    b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public boolean g_()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(2130772244, 2130772243);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 4097) && (paramInt2 == 8194))
    {
      paramIntent.getIntExtra("current_episode_num", 0);
      paramInt1 = paramIntent.getIntExtra("key_feed_position", 0);
      String str = paramIntent.getStringExtra("key_from");
      paramIntent = paramIntent.getStringExtra("key_play_scene");
      a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageAdapter.a(), str, paramIntent, paramInt1);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    e();
    super.onCreate(paramBundle);
    if ((getActivity() instanceof PublicFragmentActivity)) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)getActivity()).getSystemBarComp();
    }
    a(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
  }
  
  @Nullable
  public View onCreateView(@androidx.annotation.NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560011, paramViewGroup, false);
    a(paramLayoutInflater);
    g();
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ((WSDramaPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).b();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView;
    if (localObject != null) {
      ((VideoFeedsRecyclerView)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
    if (localObject != null)
    {
      ((WSPlayerManager)localObject).d(true);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = null;
    }
    WSDramaDataManager.a().a();
  }
  
  public void onPause()
  {
    super.onPause();
    WSLog.e("WSDramaPageFragmentLog", "[WSDramaPageFragment.java][onPause]");
    ((WSDramaPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).e();
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f();
      this.jdField_c_of_type_Boolean = true;
    }
    b(false);
    WSPlayerAudioControl.a().a(false);
    WSDramaBeaconReport.b(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onResume()
  {
    super.onResume();
    WSLog.e("WSDramaPageFragmentLog", "[WSDramaPageFragment.java][onResume]");
    SystemBarCompact localSystemBarCompact = this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
    if (localSystemBarCompact != null) {
      localSystemBarCompact.setStatusBarVisible(2, 0);
    }
    this.jdField_c_of_type_Boolean = true;
    ((WSDramaPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).d();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e();
    b(true);
    WSPlayerAudioControl.a().a(true);
    WSDramaBeaconReport.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onSaveInstanceState(@androidx.annotation.NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSInstanceStateForSceneFrom.a(paramBundle);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaPageFragment.java][onSaveInstanceState] outState:");
    localStringBuilder.append(paramBundle);
    WSLog.d("WSDramaPageFragmentLog", localStringBuilder.toString());
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ((WSDramaPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).c();
  }
  
  public void onViewStateRestored(@Nullable Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaPageFragment.java][onViewStateRestored] savedInstanceState:");
    localStringBuilder.append(paramBundle);
    WSLog.d("WSDramaPageFragmentLog", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSInstanceStateForSceneFrom.b(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageFragment
 * JD-Core Version:    0.7.0.1
 */