package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stGlobalConfig;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.weishi_new.RichBlockDialog;
import com.tencent.biz.pubaccount.weishi_new.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi_new.WSInstanceStateForPublicAccFrom;
import com.tencent.biz.pubaccount.weishi_new.WSInstanceStateForSceneFrom;
import com.tencent.biz.pubaccount.weishi_new.WSUserAuthDialog;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSClearModeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSDramaFollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi_new.like.WSLikeAnimationManger;
import com.tencent.biz.pubaccount.weishi_new.miniaio.MiniAIOPresenter;
import com.tencent.biz.pubaccount.weishi_new.openws.WSOpenWeiShiHelper;
import com.tencent.biz.pubaccount.weishi_new.openws.WSOpenWeiShiReport;
import com.tencent.biz.pubaccount.weishi_new.openws.data.WSOpenWeiShiData;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerAudioControl;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.ui.OnTabSelectedListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSBlockPage;
import com.tencent.biz.pubaccount.weishi_new.util.WSDeviceUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSMonitorUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.IWSEpisodeChoiceView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.WSEpisodeChoicePanel;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.deltatime.WSVerticalDeltaTimeCalculatorManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVideoItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalBaseHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalPagePresenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageCollectionTopAreaController;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageCommonTopAreaController;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageTopAreaFactory;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.view.WSSwipeRefreshLayout;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.kandian.base.view.widget.ListEventListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.widget.immersive.SystemBarCompact;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class WSVerticalPageFragment
  extends WSBaseFragment<WSVerticalPageContract.View, WSVerticalPageContract.Presenter>
  implements SwipeRefreshLayout.OnRefreshListener, WSSimpleEventReceiver, OnTabSelectedListener, WSVerticalDialogListener, WSVerticalPageContract.View, ListEventListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new WSVerticalPageFragment.3(this);
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RichBlockDialog jdField_a_of_type_ComTencentBizPubaccountWeishi_newRichBlockDialog;
  private final WSInstanceStateForPublicAccFrom jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSInstanceStateForPublicAccFrom = new WSInstanceStateForPublicAccFrom();
  private final WSInstanceStateForSceneFrom jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSInstanceStateForSceneFrom = new WSInstanceStateForSceneFrom();
  private AbsWsUIGroup<Object> jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
  public WsCommentPresenter a;
  private MiniAIOPresenter jdField_a_of_type_ComTencentBizPubaccountWeishi_newMiniaioMiniAIOPresenter;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSBlockPage jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSBlockPage;
  private WSVerticalPageAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter;
  private WSEpisodeChoicePanel jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoChoicepanelWSEpisodeChoicePanel;
  private WSVerticalDeltaTimeCalculatorManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeCalculatorManager;
  private WSVerticalBaseHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalBaseHolder;
  private WSSwipeRefreshLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private String jdField_a_of_type_JavaLangString;
  private List<WSVerticalItemData> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
  private AbsWsUIGroup jdField_b_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
  private String jdField_b_of_type_JavaLangString;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  
  @Nullable
  private stSimpleMetaFeed a(@Nullable List<WSVerticalItemData> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0) && (paramList.get(0) != null)) {
      return ((WSVerticalItemData)paramList.get(0)).a();
    }
    return null;
  }
  
  @NotNull
  private static Intent a(WSVerticalPageOpenParams paramWSVerticalPageOpenParams)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_from", paramWSVerticalPageOpenParams.a());
    localBundle.putString("key_play_scene", paramWSVerticalPageOpenParams.b());
    localBundle.putString("key_sub_tab_id", paramWSVerticalPageOpenParams.c());
    localBundle.putString("key_fall_list_feed_id", paramWSVerticalPageOpenParams.d());
    localBundle.putString("key_page_session", paramWSVerticalPageOpenParams.e());
    localBundle.putString("key_collection_id", paramWSVerticalPageOpenParams.f());
    localBundle.putString("key_feed_id", paramWSVerticalPageOpenParams.g());
    List localList = paramWSVerticalPageOpenParams.a();
    if ((localList != null) && (localList.size() > 0)) {
      localBundle.putSerializable("key_feed_list", new ArrayList(localList));
    }
    localBundle.putInt("key_feed_position", paramWSVerticalPageOpenParams.a());
    localBundle.putInt("key_fall_list_index", paramWSVerticalPageOpenParams.c());
    localBundle.putLong("key_start_time", SystemClock.uptimeMillis());
    localBundle.putBoolean("key_cal_delta_time", paramWSVerticalPageOpenParams.b());
    localBundle.putSerializable("key_collection", paramWSVerticalPageOpenParams.a());
    localBundle.putSerializable("auto_show_panel", Boolean.valueOf(paramWSVerticalPageOpenParams.d()));
    if (paramWSVerticalPageOpenParams.a() != null) {
      localBundle.putAll(paramWSVerticalPageOpenParams.a());
    }
    localBundle.putBoolean("key_is_show_open_ws_dialog", paramWSVerticalPageOpenParams.c());
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  private TextView a(@NonNull RecyclerView paramRecyclerView)
  {
    TextView localTextView = (TextView)LayoutInflater.from(getContext()).inflate(2131560042, null);
    paramRecyclerView.addOnLayoutChangeListener(new WSVerticalPageFragment.2(this, paramRecyclerView, localTextView));
    return localTextView;
  }
  
  public static WSVerticalPageFragment a(WSVerticalPageOpenParams paramWSVerticalPageOpenParams)
  {
    WSVerticalPageFragment localWSVerticalPageFragment = new WSVerticalPageFragment();
    localWSVerticalPageFragment.setArguments(a(paramWSVerticalPageOpenParams).getExtras());
    return localWSVerticalPageFragment;
  }
  
  private WSVerticalVideoHolder a()
  {
    WSVerticalPageAdapter localWSVerticalPageAdapter = a();
    if (localWSVerticalPageAdapter != null) {
      return localWSVerticalPageAdapter.a();
    }
    return null;
  }
  
  private void a(int paramInt, BaseViewHolder paramBaseViewHolder, Map<String, String> paramMap)
  {
    if ((paramBaseViewHolder instanceof WSVerticalVideoHolder))
    {
      paramBaseViewHolder = (WSVerticalItemData)((WSVerticalVideoHolder)paramBaseViewHolder).jdField_a_of_type_JavaLangObject;
      if ((paramBaseViewHolder != null) && ((paramBaseViewHolder.a() instanceof stSimpleMetaFeed)))
      {
        paramBaseViewHolder = paramBaseViewHolder.a();
        if (TextUtils.equals(WSVerticalBeaconReport.a(this.jdField_a_of_type_JavaLangString), "feeds_fullscreen")) {
          WSReportDC898Vertical.f();
        }
        WSVerticalBeaconReport.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramInt, paramBaseViewHolder, paramMap);
      }
    }
  }
  
  private static void a(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130772244, 2130772243);
  }
  
  private void a(@Nullable Bundle paramBundle, @Nullable stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramBundle != null)
    {
      if (paramstSimpleMetaFeed == null) {
        return;
      }
      boolean bool = paramBundle.getBoolean("key_is_show_open_ws_dialog", false);
      paramBundle = new StringBuilder();
      paramBundle.append("isShowOpenWSDialog = ");
      paramBundle.append(bool);
      WSLog.e("WSVerticalPageFragmentLog", paramBundle.toString());
      if (!bool) {
        return;
      }
      paramBundle = WSExpABTestManager.a().a();
      paramBundle.e(paramstSimpleMetaFeed.weishi_jump_url);
      String str = WSVerticalBeaconReport.a(this.jdField_a_of_type_JavaLangString);
      WSOpenWeiShiHelper.a().a(getContext(), paramBundle, WSOpenWeiShiReport.a(paramstSimpleMetaFeed, str, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString));
    }
  }
  
  public static void a(WSVerticalPageOpenParams paramWSVerticalPageOpenParams)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSVerticalPageFragment.java][start] params:");
    ((StringBuilder)localObject).append(paramWSVerticalPageOpenParams);
    WSLog.d("WSVerticalPageFragmentLog", ((StringBuilder)localObject).toString());
    localObject = a(paramWSVerticalPageOpenParams);
    if (paramWSVerticalPageOpenParams.a()) {
      ((Intent)localObject).setFlags(67108864);
    }
    paramWSVerticalPageOpenParams = paramWSVerticalPageOpenParams.a();
    PublicFragmentActivity.Launcher.a(paramWSVerticalPageOpenParams, (Intent)localObject, PublicFragmentActivity.class, WSVerticalPageFragment.class);
    if ((paramWSVerticalPageOpenParams instanceof Activity)) {
      a((Activity)paramWSVerticalPageOpenParams);
    }
  }
  
  private void a(String paramString1, String paramString2, WSPlayerManager paramWSPlayerManager)
  {
    if (paramWSPlayerManager == null) {
      return;
    }
    WSVerticalPageAdapter localWSVerticalPageAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter;
    if ((localWSVerticalPageAdapter != null) && (localWSVerticalPageAdapter.a() != null)) {
      WSVerticalBeaconReport.a(paramString1, paramString2, paramWSPlayerManager.a(), true, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a().getAdapterPosition() - 1, ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).b());
    }
    paramWSPlayerManager.g();
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt != 0) && (paramInt + 1 < ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a()))
    {
      WSLog.b("WSVerticalPageFragmentLog", "onPreLoadMoreUp");
      return true;
    }
    return false;
  }
  
  private boolean a(@Nullable WSVerticalPageAdapter paramWSVerticalPageAdapter)
  {
    return (paramWSVerticalPageAdapter != null) && (paramWSVerticalPageAdapter.a() != null) && (paramWSVerticalPageAdapter.a().size() != 0);
  }
  
  private WSPlayerParam b()
  {
    WSVerticalVideoHolder localWSVerticalVideoHolder = a();
    if (localWSVerticalVideoHolder != null) {
      return localWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
    }
    return null;
  }
  
  private void b(View paramView)
  {
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131380458);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup = WSVerticalPageTopAreaFactory.a(this, this.jdField_a_of_type_JavaLangString);
    AbsWsUIGroup localAbsWsUIGroup = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(localViewStub);
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131380444));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131380466));
    n();
    c(paramView);
    d(paramView);
  }
  
  public static void b(WSVerticalPageOpenParams paramWSVerticalPageOpenParams)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[WSVerticalPageFragment.java][startForResult] params:");
    ((StringBuilder)localObject1).append(paramWSVerticalPageOpenParams);
    WSLog.d("WSVerticalPageFragmentLog", ((StringBuilder)localObject1).toString());
    localObject1 = a(paramWSVerticalPageOpenParams);
    Object localObject2 = paramWSVerticalPageOpenParams.a();
    if ((localObject2 instanceof Activity))
    {
      localObject2 = (Activity)localObject2;
      PublicFragmentActivity.Launcher.a((Activity)localObject2, (Intent)localObject1, PublicFragmentActivity.class, WSVerticalPageFragment.class, paramWSVerticalPageOpenParams.b());
      a((Activity)localObject2);
    }
  }
  
  private boolean b(int paramInt)
  {
    List localList = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.getDataList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCenterViewChanged currentPosition:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", dataList.size:");
    localStringBuilder.append(localList.size());
    WSLog.b("WSVerticalPageFragmentLog", localStringBuilder.toString());
    if ((paramInt != 0) && (localList.size() - paramInt - 1 < ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a()))
    {
      WSLog.b("WSVerticalPageFragmentLog", "onPreLoadMore");
      return true;
    }
    return false;
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout = ((WSSwipeRefreshLayout)paramView.findViewById(2131373272));
    int i = WSDeviceUtils.a(getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout.setProgressViewOffset(true, 0, WeishiUIUtil.q + i);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout.setOnRefreshListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout.setOnInterceptTouchEventListener(new WSVerticalPageFragment.1(this));
  }
  
  private void c(boolean paramBoolean)
  {
    WSVerticalPageContract.Presenter localPresenter = (WSVerticalPageContract.Presenter)b();
    if ((localPresenter instanceof AbsWSVerticalPagePresenter)) {
      ((AbsWSVerticalPagePresenter)localPresenter).b(paramBoolean);
    }
  }
  
  private void d(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)paramView.findViewById(2131381236));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.setEnableFooterView(false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.setExtraFooterCount(1);
    this.jdField_a_of_type_AndroidWidgetTextView = a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.addFooterView(this.jdField_a_of_type_AndroidWidgetTextView);
    paramView = new WSVerticalLinearLayoutManager(getActivity(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView, 1, false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter = new WSVerticalPageAdapter(getActivity(), this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.a(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (localList.size() > 0)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.fillList(this.jdField_a_of_type_JavaUtilList);
    } else {
      c();
    }
    paramView.scrollToPosition(this.jdField_a_of_type_Int);
  }
  
  private boolean e()
  {
    if ((TextUtils.equals(this.jdField_a_of_type_JavaLangString, "aio_home_page")) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f();
      return true;
    }
    return false;
  }
  
  private void k()
  {
    WSSimpleEventBus.a().a(this);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter == null)
    {
      WSLog.a("weishi-comment", "initCommentPresenter create!!!");
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter = new WsCommentPresenter(this, WSVerticalUtils.b(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter.a(this);
    }
  }
  
  private void m()
  {
    if (getArguments() != null)
    {
      this.jdField_b_of_type_JavaLangString = getArguments().getString("key_play_scene");
      this.jdField_c_of_type_JavaLangString = getArguments().getString("key_sub_tab_id");
      this.jdField_d_of_type_JavaLangString = getArguments().getString("key_feed_id");
      this.jdField_a_of_type_Long = getArguments().getLong("key_start_time");
      this.e = getArguments().getBoolean("key_cal_delta_time");
      this.jdField_a_of_type_JavaUtilList = ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a((ArrayList)getArguments().getSerializable("key_feed_list"));
      this.jdField_a_of_type_Int = ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a(getArguments().getInt("key_feed_position"));
      ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a(getArguments());
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = new WSPlayerManager(WeishiUtils.a());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f(false);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e(false);
    boolean bool = e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSVerticalPageFragment.java][initPlayerManager] isPlayerDoOnPause:");
    localStringBuilder.append(bool);
    WSLog.e("WSVerticalPageFragmentLog", localStringBuilder.toString());
  }
  
  private void o()
  {
    ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).c();
    a(false, true);
  }
  
  private void p()
  {
    WsCommentPresenter localWsCommentPresenter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter;
    if (localWsCommentPresenter != null)
    {
      localWsCommentPresenter.a();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter = null;
    }
  }
  
  private void q()
  {
    if (TextUtils.equals("mini_app_personal_main", this.jdField_a_of_type_JavaLangString))
    {
      WeishiUtils.c("homepage_main");
      return;
    }
    if (TextUtils.equals("mini_app_personal_guest", this.jdField_a_of_type_JavaLangString)) {
      WeishiUtils.c("homepage_guest");
    }
  }
  
  private void r()
  {
    if (TextUtils.equals("aio_home_page", this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Boolean) {
        WeishiUtils.c("feeds_fullscreen");
      }
    }
    else {
      WeishiUtils.c("fullscreen_videoplay");
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public stSimpleMetaFeed a()
  {
    WSVerticalVideoHolder localWSVerticalVideoHolder = a();
    if ((localWSVerticalVideoHolder != null) && (localWSVerticalVideoHolder.jdField_a_of_type_JavaLangObject != null)) {
      return ((WSVerticalItemData)localWSVerticalVideoHolder.jdField_a_of_type_JavaLangObject).a();
    }
    return null;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public MiniAIOPresenter a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newMiniaioMiniAIOPresenter;
  }
  
  public WSPlayerManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  }
  
  public WSPlayerParam a()
  {
    return ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a();
  }
  
  public WSVerticalPageAdapter a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter;
  }
  
  @NonNull
  public WSVerticalPageContract.Presenter a()
  {
    return WSVerticalPresenterFactory.a(this.jdField_a_of_type_JavaLangString, this);
  }
  
  public IWSEpisodeChoiceView a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoChoicepanelWSEpisodeChoicePanel == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoChoicepanelWSEpisodeChoicePanel = WSEpisodeChoicePanel.a(this);
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoChoicepanelWSEpisodeChoicePanel;
  }
  
  protected MiniMsgUserParam a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newMiniaioMiniAIOPresenter = new MiniAIOPresenter();
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newMiniaioMiniAIOPresenter.a();
  }
  
  public VideoFeedsRecyclerView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(LikeRspEvent.class);
    localArrayList.add(FollowEvent.class);
    localArrayList.add(WSUserAuthEvent.class);
    localArrayList.add(WSAddCommentEvent.class);
    localArrayList.add(WSClearModeEvent.class);
    localArrayList.add(WSDramaFollowEvent.class);
    return localArrayList;
  }
  
  public List<WSVerticalItemData> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  protected void a()
  {
    super.a();
    r();
  }
  
  public void a(int paramInt)
  {
    WSPlayerManager localWSPlayerManager = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
    if (localWSPlayerManager != null) {
      localWSPlayerManager.e(true);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSBlockPage == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSBlockPage = new WSBlockPage();
    }
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSBlockPage.a(this, paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    getActivity().setResult(paramInt, paramIntent);
  }
  
  public void a(int paramInt, WSPlayerParam paramWSPlayerParam)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeCalculatorManager.a(paramInt, paramWSPlayerParam);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup == null)
    {
      this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup = new WSVerticalPageErrorViewController(getActivity(), this);
      this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup.a(this.jdField_a_of_type_AndroidViewViewStub);
    }
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
  }
  
  public void a(stGlobalConfig paramstGlobalConfig)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRichBlockDialog == null)
    {
      int i = WSVerticalUtils.a(this.jdField_a_of_type_JavaLangString);
      String str = WSVerticalBeaconReport.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRichBlockDialog = new RichBlockDialog(getActivity(), 1, i, str);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRichBlockDialog.setOnDismissListener(new WSVerticalPageFragment.4(this));
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRichBlockDialog.a(paramstGlobalConfig);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRichBlockDialog.a(getActivity());
      paramstGlobalConfig = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
      if (paramstGlobalConfig != null) {
        paramstGlobalConfig.f();
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onCenterViewChanged: ");
    ((StringBuilder)localObject).append(paramViewHolder);
    WSLog.b("WSVerticalPageFragmentLog", ((StringBuilder)localObject).toString());
    if ((paramViewHolder instanceof WSVerticalBaseHolder))
    {
      localObject = (WSVerticalBaseHolder)paramViewHolder;
      int i = ((WSVerticalBaseHolder)localObject).getLayoutPosition() - 1;
      this.jdField_b_of_type_Int = i;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a((RecyclerView.ViewHolder)localObject, i);
      ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a((RecyclerView.ViewHolder)localObject, i);
      ((WSVerticalBaseHolder)localObject).a(i);
      if (b(i)) {
        a(false, false);
      } else if (a(i)) {
        j();
      }
      a(i, (BaseViewHolder)localObject, ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).b());
      WSVerticalBaseHolder localWSVerticalBaseHolder = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalBaseHolder;
      if ((localWSVerticalBaseHolder != null) && (localWSVerticalBaseHolder != paramViewHolder)) {
        localWSVerticalBaseHolder.b(i);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalBaseHolder = ((WSVerticalBaseHolder)localObject);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(View paramView)
  {
    MiniAIOPresenter localMiniAIOPresenter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newMiniaioMiniAIOPresenter;
    if (localMiniAIOPresenter != null) {
      localMiniAIOPresenter.a(paramView);
    }
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (((paramWSSimpleBaseEvent instanceof WSUserAuthEvent)) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "aio_new_msg")))
    {
      WSUserAuthDialog.a(getActivity(), "fullscreen_videoplay");
      return;
    }
    ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a(paramWSSimpleBaseEvent);
  }
  
  public void a(WSPlayerParam paramWSPlayerParam)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeCalculatorManager.a(paramWSPlayerParam);
    ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a(paramWSPlayerParam);
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeCalculatorManager.a(paramWSPlayerParam, paramInt1, paramInt2, paramString);
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a(paramWSPlayerParam, paramBoolean);
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData)
  {
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    localObject = ((WSVerticalVideoHolder)localObject).jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiIWSItemView;
    if ((localObject instanceof AbsWSVideoItemView)) {
      ((AbsWSVideoItemView)localObject).b(paramWSVerticalItemData);
    }
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeCalculatorManager.a(paramWSVerticalItemData, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
  }
  
  public void a(List<WSVerticalItemData> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.fillList(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    AbsWsUIGroup localAbsWsUIGroup = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
    if ((localAbsWsUIGroup instanceof WSVerticalPageCommonTopAreaController)) {
      ((WSVerticalPageCommonTopAreaController)localAbsWsUIGroup).a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a(paramBoolean1, paramBoolean2, this.jdField_a_of_type_JavaLangString);
  }
  
  public void aC_()
  {
    WSLog.b("WSVerticalPageFragmentLog", "onLoadMore");
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null)
    {
      boolean bool;
      if ((!((WSVerticalPageContract.Presenter)b()).d()) && (WSExpABTestManager.a().d())) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e(bool);
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d())
      {
        if (bool)
        {
          WSPlayerManager localWSPlayerManager = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
          localWSPlayerManager.b(localWSPlayerManager.a(), false);
          return;
        }
        i();
      }
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void b(List<WSVerticalItemData> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.b(paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    AbsWsUIGroup localAbsWsUIGroup = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
    if ((localAbsWsUIGroup instanceof WSVerticalPageCommonTopAreaController)) {
      ((WSVerticalPageCommonTopAreaController)localAbsWsUIGroup).a(paramBoolean, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newMiniaioMiniAIOPresenter);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void beforeFinish()
  {
    super.beforeFinish();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeCalculatorManager.c(b());
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  public void c(int paramInt)
  {
    AbsWsUIGroup localAbsWsUIGroup = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
    if ((localAbsWsUIGroup instanceof WSVerticalPageCollectionTopAreaController)) {
      ((WSVerticalPageCollectionTopAreaController)localAbsWsUIGroup).c(paramInt);
    }
  }
  
  public void c(List<WSVerticalItemData> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a(paramList);
  }
  
  public boolean c()
  {
    return (getActivity() != null) && (getActivity().isFinishing());
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
  }
  
  public boolean d()
  {
    return ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).b();
  }
  
  public void e()
  {
    WSSwipeRefreshLayout localWSSwipeRefreshLayout = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout;
    if (localWSSwipeRefreshLayout != null) {
      localWSSwipeRefreshLayout.setRefreshing(false);
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void g()
  {
    WSLog.e("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onTabSelected]");
    WSPlayerManager localWSPlayerManager = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
    if (localWSPlayerManager == null) {
      return;
    }
    localWSPlayerManager.e();
    c(true);
    WSPlayerAudioControl.a().a(true);
  }
  
  public void h()
  {
    WSLog.e("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onTabUnselected]");
    WSPlayerManager localWSPlayerManager = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
    if (localWSPlayerManager == null) {
      return;
    }
    localWSPlayerManager.f();
    c(false);
  }
  
  protected boolean h_()
  {
    return true;
  }
  
  public void i()
  {
    Object localObject = a();
    if ((localObject != null) && (!((VideoFeedsRecyclerView)localObject).a()))
    {
      a(a(), b(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
      ((WSPlayerManager)localObject).b(((WSPlayerManager)localObject).a(), false);
    }
  }
  
  public void j()
  {
    ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a(this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean onBackEvent()
  {
    WsCommentPresenter localWsCommentPresenter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter;
    boolean bool2 = false;
    boolean bool1;
    if (localWsCommentPresenter != null) {
      bool1 = localWsCommentPresenter.b();
    } else {
      bool1 = false;
    }
    if (!bool1) {
      ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).h();
    }
    if (!bool1)
    {
      bool1 = bool2;
      if (!super.onBackEvent()) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSVerticalPageFragment.java][onCreate] savedInstanceState:");
    localStringBuilder.append(paramBundle);
    localStringBuilder.append(", getArguments():");
    localStringBuilder.append(getArguments());
    WSLog.e("WSVerticalPageFragmentLog", localStringBuilder.toString());
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("进入播放页的时间：");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    WSLog.a("weishi-beacon", localStringBuilder.toString());
    if (getArguments() != null) {
      this.jdField_a_of_type_JavaLangString = getArguments().getString("key_from");
    }
    super.onCreate(paramBundle);
    ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).d();
    if ((getActivity() instanceof PublicFragmentActivity)) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
    }
    m();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeCalculatorManager = new WSVerticalDeltaTimeCalculatorManager();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeCalculatorManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long, this.e);
    WSReportDC898Vertical.a(a(), WSVerticalBeaconReport.a(this.jdField_a_of_type_JavaLangString), b());
    a(getArguments(), a(a()));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560018, paramViewGroup, false);
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("[WSVerticalPageFragment.java][onCreateView] savedInstanceState:");
    paramViewGroup.append(paramBundle);
    WSLog.e("WSVerticalPageFragmentLog", paramViewGroup.toString());
    b(paramLayoutInflater);
    o();
    l();
    k();
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    WSLog.e("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onDestroyView]");
    ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).b();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView;
    if (localObject != null)
    {
      ((VideoFeedsRecyclerView)localObject).d();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = null;
    q();
    WSSimpleEventBus.a().b(this);
    WSLikeAnimationManger.a().a();
    p();
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter;
    if ((localObject != null) && (((WSVerticalPageAdapter)localObject).a() != null))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a().iterator();
      while (((Iterator)localObject).hasNext())
      {
        WSVerticalVideoHolder localWSVerticalVideoHolder = (WSVerticalVideoHolder)((Iterator)localObject).next();
        if (localWSVerticalVideoHolder != null) {
          localWSVerticalVideoHolder.c();
        }
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView;
    if (localObject != null) {
      ((VideoFeedsRecyclerView)localObject).removeOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "aio_home_page"))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter;
      int i;
      if (localObject != null) {
        i = ((WSVerticalPageAdapter)localObject).a();
      } else {
        i = 0;
      }
      WsBeaconReportPresenter.a().a(this.jdField_c_of_type_Long, ((WSVerticalPageContract.Presenter)b()).a(), i, WeishiUtils.jdField_a_of_type_Boolean, WeishiScehmeUtil.jdField_a_of_type_Boolean, 2);
    }
    WSMonitorUtil.a(getActivity());
  }
  
  public void onPause()
  {
    super.onPause();
    WSLog.e("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onPause]");
    this.jdField_c_of_type_Long += System.currentTimeMillis() - this.jdField_d_of_type_Long;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeCalculatorManager.b(b());
    ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).g();
    WSVerticalBeaconReport.b(WSVerticalBeaconReport.a(this.jdField_a_of_type_JavaLangString), this.jdField_b_of_type_JavaLangString, ((WSVerticalPageContract.Presenter)b()).b());
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter;
    if ((localObject != null) && (((WSVerticalPageAdapter)localObject).a() != null))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a();
      if (localObject != null) {
        ((WSVerticalVideoHolder)localObject).b();
      }
    }
    ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).i();
  }
  
  public void onRefresh()
  {
    WSLog.b("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onRefresh]");
    ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).b(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onResume()
  {
    super.onResume();
    WSLog.e("WSVerticalPageFragmentLog", "[WSVerticalPageFragment.java][onResume]");
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    WSReportDC898Vertical.a(WSVerticalBeaconReport.a(this.jdField_a_of_type_JavaLangString), b());
    ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).f();
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter;
    if ((localObject != null) && (((WSVerticalPageAdapter)localObject).a() != null))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a();
      if (localObject != null) {
        ((WSVerticalVideoHolder)localObject).a();
      }
    }
    com.tencent.biz.pubaccount.weishi_new.WSFollowFragment.jdField_d_of_type_Boolean = false;
    localObject = this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
    if (localObject != null) {
      ((SystemBarCompact)localObject).setStatusBarVisible(2, 0);
    }
    if (this.jdField_b_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
      this.jdField_b_of_type_Long = 0L;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("播放页初始化耗时：");
      ((StringBuilder)localObject).append(l);
      WSLog.a("weishi-beacon", ((StringBuilder)localObject).toString());
      WsBeaconReportPresenter.a().a(true, l, "fullscreen_videoplay", this.jdField_b_of_type_JavaLangString);
    }
    WSVerticalBeaconReport.a(WSVerticalBeaconReport.a(this.jdField_a_of_type_JavaLangString), this.jdField_b_of_type_JavaLangString, ((WSVerticalPageContract.Presenter)b()).b());
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSInstanceStateForSceneFrom.a(paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSInstanceStateForPublicAccFrom.a(paramBundle);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSVerticalPageFragment.java][onSaveInstanceState] outState:");
    localStringBuilder.append(paramBundle);
    WSLog.d("WSVerticalPageFragmentLog", localStringBuilder.toString());
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = new StringBuilder();
    paramView.append("[WSVerticalPageFragment.java][onViewCreated] savedInstanceState:");
    paramView.append(paramBundle);
    WSLog.e("WSVerticalPageFragmentLog", paramView.toString());
    ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).e();
    paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeCalculatorManager;
    paramView = this.jdField_a_of_type_JavaUtilList;
    if ((paramView != null) && (paramView.size() > 0)) {
      paramView = (WSVerticalItemData)this.jdField_a_of_type_JavaUtilList.get(0);
    } else {
      paramView = null;
    }
    paramBundle.a(paramView);
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSVerticalPageFragment.java][onViewStateRestored] savedInstanceState:");
    localStringBuilder.append(paramBundle);
    WSLog.d("WSVerticalPageFragmentLog", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSInstanceStateForSceneFrom.b(paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSInstanceStateForPublicAccFrom.b(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment
 * JD-Core Version:    0.7.0.1
 */