package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stCollection;
import UserGrowth.stGlobalConfig;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView.ListEventListener;
import com.tencent.biz.pubaccount.weishi_new.RichBlockDialog;
import com.tencent.biz.pubaccount.weishi_new.WSBaseFragment;
import com.tencent.biz.pubaccount.weishi_new.WSUserAuthDialog;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.event.WSUserAuthEvent;
import com.tencent.biz.pubaccount.weishi_new.like.WSLikeAnimationManger;
import com.tencent.biz.pubaccount.weishi_new.miniaio.MiniAIOPresenter;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerAudioControl;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.ui.HomeTabSelectListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSBlockPage;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSMonitorUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.deltatime.WSVerticalDeltaTimeCalculatorManager;
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
import com.tencent.mobileqq.now.utils.StatusBarUtil;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class WSVerticalPageFragment
  extends WSBaseFragment<WSVerticalPageContract.View, WSVerticalPageContract.Presenter>
  implements SwipeRefreshLayout.OnRefreshListener, VideoFeedsRecyclerView.ListEventListener, WSSimpleEventReceiver, HomeTabSelectListener, WSVerticalDialogListener, WSVerticalPageContract.View
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new WSVerticalPageFragment.2(this);
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private RichBlockDialog jdField_a_of_type_ComTencentBizPubaccountWeishi_newRichBlockDialog;
  private AbsWsUIGroup<Object> jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
  public WsCommentPresenter a;
  private MiniAIOPresenter jdField_a_of_type_ComTencentBizPubaccountWeishi_newMiniaioMiniAIOPresenter;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private WSBlockPage jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilWSBlockPage;
  private WSVerticalPageAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter;
  private WSVerticalDeltaTimeCalculatorManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeCalculatorManager;
  private WSSwipeRefreshLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private String jdField_a_of_type_JavaLangString;
  private List<WSVerticalItemData> jdField_a_of_type_JavaUtilList;
  private long jdField_b_of_type_Long = 0L;
  private AbsWsUIGroup jdField_b_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup;
  private String jdField_b_of_type_JavaLangString;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  @NotNull
  private static Intent a(String paramString1, String paramString2, List<stSimpleMetaFeed> paramList, int paramInt, String paramString3, stCollection paramstCollection, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_from", paramString1);
    localBundle.putString("key_play_scene", paramString2);
    localBundle.putString("key_sub_tab_id", paramString3);
    if ((paramList != null) && (paramList.size() > 0)) {
      localBundle.putSerializable("key_feed_list", new ArrayList(paramList));
    }
    localBundle.putInt("key_feed_position", paramInt);
    localBundle.putLong("key_start_time", SystemClock.uptimeMillis());
    localBundle.putBoolean("key_cal_delta_time", paramBoolean);
    localBundle.putSerializable("key_collection", paramstCollection);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  private WSPlayerParam a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter != null)
    {
      WSVerticalVideoHolder localWSVerticalVideoHolder = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a();
      if (localWSVerticalVideoHolder != null) {
        return localWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam;
      }
    }
    return null;
  }
  
  public static WSVerticalPageFragment a(String paramString1, String paramString2)
  {
    WSVerticalPageFragment localWSVerticalPageFragment = new WSVerticalPageFragment();
    localWSVerticalPageFragment.setArguments(a(paramString1, paramString2, null, 0, "", null, false).getExtras());
    return localWSVerticalPageFragment;
  }
  
  private void a(int paramInt, BaseViewHolder paramBaseViewHolder)
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
        WSVerticalBeaconReport.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramInt, paramBaseViewHolder);
        WSVerticalBeaconReport.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramBaseViewHolder);
      }
    }
  }
  
  private static void a(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130772215, 2130772214);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, List<stSimpleMetaFeed> paramList, int paramInt1, int paramInt2)
  {
    WSLog.b("WSVerticalPageFragment", "startForResult() needScrollToPosition:" + paramInt1);
    PublicFragmentActivity.Launcher.a(paramActivity, a(paramString1, paramString2, paramList, paramInt1, "", null, false), PublicFragmentActivity.class, WSVerticalPageFragment.class, paramInt2);
    a(paramActivity);
  }
  
  @Deprecated
  public static void a(Context paramContext, String paramString1, String paramString2, List<stSimpleMetaFeed> paramList, int paramInt)
  {
    a(paramContext, paramString1, paramString2, paramList, paramInt, false);
  }
  
  @Deprecated
  public static void a(Context paramContext, String paramString1, String paramString2, List<stSimpleMetaFeed> paramList, int paramInt, boolean paramBoolean)
  {
    a(new WSVerticalPageOpenParams(paramContext, paramString1, paramString2).a(paramList).a(paramInt).a(paramBoolean));
  }
  
  public static void a(WSVerticalPageOpenParams paramWSVerticalPageOpenParams)
  {
    Context localContext = paramWSVerticalPageOpenParams.a();
    String str1 = paramWSVerticalPageOpenParams.a();
    String str2 = paramWSVerticalPageOpenParams.b();
    String str3 = paramWSVerticalPageOpenParams.c();
    List localList = paramWSVerticalPageOpenParams.a();
    int i = paramWSVerticalPageOpenParams.a();
    boolean bool = paramWSVerticalPageOpenParams.a();
    stCollection localstCollection = paramWSVerticalPageOpenParams.a();
    WSLog.b("WSVerticalPageFragment", "start() needScrollToPosition:" + i);
    paramWSVerticalPageOpenParams = a(str1, str2, localList, i, str3, localstCollection, paramWSVerticalPageOpenParams.b());
    if (bool) {
      paramWSVerticalPageOpenParams.setFlags(67108864);
    }
    PublicFragmentActivity.Launcher.a(localContext, paramWSVerticalPageOpenParams, PublicFragmentActivity.class, WSVerticalPageFragment.class);
    if ((localContext instanceof Activity)) {
      a((Activity)localContext);
    }
  }
  
  private void a(String paramString1, String paramString2, WSPlayerManager paramWSPlayerManager)
  {
    if (paramWSPlayerManager == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a() != null)) {
      WSVerticalBeaconReport.a(paramString1, paramString2, paramWSPlayerManager.a(), true, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a().getAdapterPosition() - 1);
    }
    paramWSPlayerManager.g();
  }
  
  private boolean a(int paramInt)
  {
    List localList = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.b();
    WSLog.b("WSVerticalPageFragment", "onCenterViewChanged currentPosition:" + paramInt + ", dataList.size:" + localList.size());
    if ((paramInt != 1) && (localList.size() - paramInt < ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a()))
    {
      WSLog.b("WSVerticalPageFragment", "onPreLoadMore");
      return true;
    }
    return false;
  }
  
  private void b(View paramView)
  {
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131381202);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup = WSVerticalPageTopAreaFactory.a(this, this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup.a(localViewStub);
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131381191));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131381210));
    k();
    c(paramView);
    d(paramView);
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout = ((WSSwipeRefreshLayout)paramView.findViewById(2131373700));
    int i = StatusBarUtil.a(getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout.setProgressViewOffset(true, 0, i + WeishiUIUtil.n);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)paramView.findViewById(2131382031));
    paramView = new WSVerticalLinearLayoutManager(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 1, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter = new WSVerticalPageAdapter(getActivity(), this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a(this.jdField_a_of_type_JavaUtilList);
    }
    for (;;)
    {
      paramView.scrollToPosition(this.jdField_a_of_type_Int);
      return;
      c();
    }
  }
  
  private boolean d()
  {
    if ((TextUtils.equals(this.jdField_a_of_type_JavaLangString, "aio_home_page")) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f();
      return true;
    }
    return false;
  }
  
  private void h()
  {
    WSSimpleEventBus.a().a(this);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter == null)
    {
      WSLog.a("weishi-comment", "initCommentPresenter create!!!");
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter = new WsCommentPresenter(this, WSVerticalUtils.b(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter.a(this);
    }
  }
  
  private void j()
  {
    if (getArguments() != null)
    {
      this.jdField_b_of_type_JavaLangString = getArguments().getString("key_play_scene");
      this.jdField_c_of_type_JavaLangString = getArguments().getString("key_sub_tab_id");
      this.jdField_a_of_type_Long = getArguments().getLong("key_start_time");
      this.e = getArguments().getBoolean("key_cal_delta_time");
      this.jdField_a_of_type_JavaUtilList = ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a((ArrayList)getArguments().getSerializable("key_feed_list"));
      ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a(getArguments());
      this.jdField_a_of_type_Int = ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a(getArguments().getInt("key_feed_position"));
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = new WSPlayerManager(WeishiUtils.a());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f(false);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e(false);
    boolean bool = d();
    WSLog.e("WSVerticalPageFragment", "[WSVerticalPageFragment.java][initPlayerManager] isPlayerDoOnPause:" + bool);
  }
  
  private void l()
  {
    ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).e();
    a(false, true);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter.a();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter = null;
    }
  }
  
  private void n()
  {
    if (TextUtils.equals("mini_app_personal_main", this.jdField_a_of_type_JavaLangString)) {
      WeishiUtils.c("homepage_main");
    }
    while (!TextUtils.equals("mini_app_personal_guest", this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    WeishiUtils.c("homepage_guest");
  }
  
  private void o()
  {
    if (TextUtils.equals("aio_home_page", this.jdField_a_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Boolean) {
        WeishiUtils.c("feeds_fullscreen");
      }
      return;
    }
    WeishiUtils.c("fullscreen_videoplay");
  }
  
  public void E_()
  {
    WSLog.b("WSVerticalPageFragment", "onLoadMore");
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public VideoFeedsRecyclerView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  }
  
  public MiniAIOPresenter a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newMiniaioMiniAIOPresenter;
  }
  
  public WSPlayerManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
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
  
  public MiniMsgUserParam a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newMiniaioMiniAIOPresenter = new MiniAIOPresenter();
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newMiniaioMiniAIOPresenter.a();
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
    return localArrayList;
  }
  
  public List<WSVerticalItemData> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    WSLog.e("WSVerticalPageFragment", "[WSVerticalPageFragment.java][onTabSelected] index:" + paramInt);
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager == null) {
      return;
    }
    if (paramInt != 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f();
      c(false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e();
    c(true);
    WSPlayerAudioControl.a().a(true);
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
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRichBlockDialog.setOnDismissListener(new WSVerticalPageFragment.3(this));
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRichBlockDialog.a(paramstGlobalConfig);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newRichBlockDialog.a(getActivity());
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.f();
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    WSLog.b("WSVerticalPageFragment", "onCenterViewChanged: " + paramViewHolder);
    if ((paramViewHolder instanceof WSVerticalBaseHolder))
    {
      paramViewHolder = (WSVerticalBaseHolder)paramViewHolder;
      int i = paramViewHolder.getLayoutPosition() - 1;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a(paramViewHolder, i);
      ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a(paramViewHolder, i);
      paramViewHolder.a(i);
      if (a(i + 1)) {
        a(false, false);
      }
      a(i, paramViewHolder);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newMiniaioMiniAIOPresenter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newMiniaioMiniAIOPresenter.a(paramView);
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
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeCalculatorManager.a(paramWSPlayerParam, paramInt1, paramInt2, paramString);
  }
  
  public void a(WSVerticalItemData paramWSVerticalItemData, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeCalculatorManager.a(paramWSVerticalItemData, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
  }
  
  public void a(List<WSVerticalItemData> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup instanceof WSVerticalPageCommonTopAreaController)) {
      ((WSVerticalPageCommonTopAreaController)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup).a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a(paramBoolean1, paramBoolean2, this.jdField_a_of_type_JavaLangString);
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b()
  {
    super.b();
    o();
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e(true);
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void b(Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup.a(paramObject);
    }
  }
  
  public void b(List<WSVerticalItemData> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a(paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup instanceof WSVerticalPageCommonTopAreaController)) {
      ((WSVerticalPageCommonTopAreaController)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup).a(paramBoolean, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newMiniaioMiniAIOPresenter);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void beforeFinish()
  {
    super.beforeFinish();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeCalculatorManager.c(a());
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null)
    {
      boolean bool = WSExpABTestManager.a().d();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.e(bool);
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d()) {
        g();
      }
    }
  }
  
  public boolean c()
  {
    return (getActivity() != null) && (getActivity().isFinishing());
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
  }
  
  public void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup instanceof WSVerticalPageCollectionTopAreaController)) {
      ((WSVerticalPageCollectionTopAreaController)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newBaseuiAbsWsUIGroup).c(paramInt);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoViewWSSwipeRefreshLayout.setRefreshing(false);
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public boolean f_()
  {
    return true;
  }
  
  public void g()
  {
    VideoFeedsRecyclerView localVideoFeedsRecyclerView = a();
    if ((localVideoFeedsRecyclerView != null) && (!localVideoFeedsRecyclerView.a()))
    {
      a(a(), b(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.a(), false);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter != null) {}
    for (boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter.b();; bool = false)
    {
      if (!bool) {
        ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).i();
      }
      return (bool) || (super.onBackEvent());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    WSLog.a("weishi-beacon", "进入播放页的时间：" + this.jdField_b_of_type_Long);
    if (getArguments() != null) {
      this.jdField_a_of_type_JavaLangString = getArguments().getString("key_from");
    }
    super.onCreate(paramBundle);
    ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).f();
    if ((getActivity() instanceof PublicFragmentActivity)) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = ((PublicFragmentActivity)getActivity()).mSystemBarComp;
    }
    j();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeCalculatorManager = new WSVerticalDeltaTimeCalculatorManager();
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeCalculatorManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long, this.e);
    WSReportDC898Vertical.a(a(), WSVerticalBeaconReport.a(this.jdField_a_of_type_JavaLangString), b());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560135, paramViewGroup, false);
    WSLog.a("weishi-comment", "onCreateView before initUI~~~~~~~~~~~");
    b(paramLayoutInflater);
    l();
    WSLog.a("weishi-comment", "onCreateView after initData~~~~~~~~~~~");
    i();
    h();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).d();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.d();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = null;
    n();
    WSSimpleEventBus.a().b(this);
    WSLikeAnimationManger.a().a();
    m();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a() != null))
    {
      WSVerticalVideoHolder localWSVerticalVideoHolder = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a();
      if (localWSVerticalVideoHolder != null) {
        localWSVerticalVideoHolder.c();
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.removeOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "aio_home_page"))
    {
      int i = 0;
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter != null) {
        i = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a();
      }
      WsBeaconReportPresenter.a().a(this.jdField_c_of_type_Long, ((WSVerticalPageContract.Presenter)b()).a(), i, WeishiUtils.jdField_a_of_type_Boolean, WeishiScehmeUtil.jdField_a_of_type_Boolean, 2);
    }
    WSMonitorUtil.a(getActivity());
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_c_of_type_Long += System.currentTimeMillis() - this.jdField_d_of_type_Long;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeCalculatorManager.b(a());
    ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).h();
    WSPublicAccReport.getInstance().reportPageVisitExit(WSVerticalBeaconReport.a(this.jdField_a_of_type_JavaLangString));
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a() != null))
    {
      WSVerticalVideoHolder localWSVerticalVideoHolder = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a();
      if (localWSVerticalVideoHolder != null) {
        localWSVerticalVideoHolder.b();
      }
    }
  }
  
  public void onRefresh()
  {
    WSLog.b("WSVerticalPageFragment", "[WSVerticalPageFragment.java][onRefresh]");
    ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    WSReportDC898Vertical.a(WSVerticalBeaconReport.a(this.jdField_a_of_type_JavaLangString), b());
    ((WSVerticalPageContract.Presenter)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newIWSPresenter).g();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a() != null))
    {
      WSVerticalVideoHolder localWSVerticalVideoHolder = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a();
      if (localWSVerticalVideoHolder != null) {
        localWSVerticalVideoHolder.a();
      }
    }
    com.tencent.biz.pubaccount.weishi_new.WSFollowFragment.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarVisible(2, 0);
    }
    if (this.jdField_b_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
      this.jdField_b_of_type_Long = 0L;
      WSLog.a("weishi-beacon", "播放页初始化耗时：" + l);
      WsBeaconReportPresenter.a().a(true, l, "fullscreen_videoplay", this.jdField_b_of_type_JavaLangString);
    }
    WSPublicAccReport.getInstance().reportPageVisitEnter(WSVerticalBeaconReport.a(this.jdField_a_of_type_JavaLangString));
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle != null)
    {
      String str = WSReportUtils.a();
      WSLog.e("WSVerticalPageFragment", "[WSHomeFragment.java][onSaveInstanceState] sceneFrom:" + str);
      paramBundle.putString("key_scene_from", str);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoDeltatimeWSVerticalDeltaTimeCalculatorManager;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {}
    for (paramView = (WSVerticalItemData)this.jdField_a_of_type_JavaUtilList.get(0);; paramView = null)
    {
      paramBundle.a(paramView);
      return;
    }
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("key_scene_from");
      WSLog.e("WSVerticalPageFragment", "[WSHomeFragment.java][onViewStateRestored] sceneFrom:" + paramBundle);
      if (!TextUtils.isEmpty(paramBundle)) {
        WSReportUtils.a(paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment
 * JD-Core Version:    0.7.0.1
 */