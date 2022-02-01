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
import com.tencent.biz.pubaccount.weishi_new.instancestate.WSInstanceStateManager;
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
  private AbsWsUIGroup<Object> f;
  private SystemBarCompact g;
  private VideoFeedsRecyclerView h;
  private ProgressBar i;
  private ViewStub j;
  private ViewStub k;
  private ViewStub l;
  private WSDramaMiddlePart m;
  private WSDramaHistoryPart n;
  private String o;
  private String p;
  private String q;
  private String r;
  private boolean s = true;
  private boolean t;
  private final WSInstanceStateManager u = new WSInstanceStateManager();
  private AbsWsUIGroup<Object> v;
  private WSDramaPageAdapter w;
  private WSPlayerManager x;
  private AbsWSDramaHolder y;
  
  private void a(View paramView)
  {
    this.j = ((ViewStub)paramView.findViewById(2131449853));
    this.i = ((ProgressBar)paramView.findViewById(2131439920));
    this.k = ((ViewStub)paramView.findViewById(2131449753));
    this.l = ((ViewStub)paramView.findViewById(2131449746));
    b(paramView);
    t();
    c(paramView);
    r();
  }
  
  public static void a(WSDramaPageIntentParams paramWSDramaPageIntentParams)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSDramaPageFragment.java][start] params:");
    ((StringBuilder)localObject).append(paramWSDramaPageIntentParams);
    WSLog.d("WSDramaPageFragmentLog", ((StringBuilder)localObject).toString());
    localObject = b(paramWSDramaPageIntentParams);
    PublicFragmentActivity.Launcher.a(paramWSDramaPageIntentParams.b(), (Intent)localObject, PublicFragmentActivity.class, WSDramaPageFragment.class);
  }
  
  private void a(WSPlayerManager paramWSPlayerManager)
  {
    if ((paramWSPlayerManager != null) && (paramWSPlayerManager.g())) {
      WSDramaUtils.a(this, paramWSPlayerManager.r(), false);
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
    return TextUtils.equals(paramstDramaFeed.feed.id, WSPlayerUtils.a(paramAbsWSDramaVideoHolder.e()));
  }
  
  private boolean a(AbsWSDramaHolder paramAbsWSDramaHolder1, AbsWSDramaHolder paramAbsWSDramaHolder2)
  {
    if (((paramAbsWSDramaHolder1 instanceof AbsWSDramaVideoHolder)) && ((paramAbsWSDramaHolder2 instanceof AbsWSDramaVideoHolder)))
    {
      paramAbsWSDramaHolder1 = (AbsWSDramaVideoHolder)paramAbsWSDramaHolder1;
      paramAbsWSDramaHolder2 = (AbsWSDramaVideoHolder)paramAbsWSDramaHolder2;
      return WSPlayerUtils.a(paramAbsWSDramaHolder1.e(), paramAbsWSDramaHolder2.e());
    }
    return false;
  }
  
  private static Intent b(WSDramaPageIntentParams paramWSDramaPageIntentParams)
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("from", paramWSDramaPageIntentParams.a());
    localBundle.putString("drama_id", paramWSDramaPageIntentParams.c());
    localBundle.putString("episode_id", paramWSDramaPageIntentParams.d());
    localBundle.putString("drama_jump_schema", paramWSDramaPageIntentParams.g());
    localBundle.putString("sub_tab_id", paramWSDramaPageIntentParams.h());
    localBundle.putInt("cur_episode_num", paramWSDramaPageIntentParams.e());
    localBundle.putInt("drama_num", paramWSDramaPageIntentParams.f());
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  private void b(View paramView)
  {
    paramView = (ViewStub)paramView.findViewById(2131449857);
    this.f = WSDramaPageTopBarAreaFactory.a(this, this.o);
    AbsWsUIGroup localAbsWsUIGroup = this.f;
    if (localAbsWsUIGroup != null) {
      localAbsWsUIGroup.a(paramView);
    }
  }
  
  private void b(WSPlayerManager paramWSPlayerManager)
  {
    if ((paramWSPlayerManager != null) && ((paramWSPlayerManager.g()) || (paramWSPlayerManager.f())))
    {
      WSDramaUtils.b(this, paramWSPlayerManager.r(), false);
      paramWSPlayerManager.t();
    }
  }
  
  private void c(View paramView)
  {
    this.h = ((VideoFeedsRecyclerView)paramView.findViewById(2131445219));
    paramView = new WSVerticalLinearLayoutManager(getActivity(), this.h, 0, false);
    this.h.setLayoutManager(paramView);
    this.h.setEnableHeaderView(false);
    this.w = new WSDramaPageAdapter(getActivity(), this);
    this.w.a(this.x);
    this.h.setAdapter(this.w);
    this.h.a(this);
  }
  
  private void p()
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.o = localBundle.getString("from");
      this.p = localBundle.getString("drama_id");
      this.q = localBundle.getString("drama_jump_schema");
      this.r = localBundle.getString("sub_tab_id");
    }
  }
  
  private void q()
  {
    WSSimpleEventBus.a().a(this);
  }
  
  private void t()
  {
    this.x = new WSPlayerManager(WeishiUtils.h());
    this.x.f(false);
    this.x.e(false);
  }
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaPageFragment.java][showError] code:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", msg:");
    localStringBuilder.append(paramString);
    WSLog.d("WSDramaPageFragmentLog", localStringBuilder.toString());
    if (this.v == null)
    {
      this.v = new WSDramaPageErrorViewController(getActivity(), this);
      this.v.a(this.j);
    }
    this.j.setVisibility(0);
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
    ((StringBuilder)localObject1).append(c());
    WSLog.a("WSDramaPageFragmentLognel-log", ((StringBuilder)localObject1).toString());
    if (paramstDramaFeed != null)
    {
      if (!TextUtils.equals(paramstDramaFeed.dramaID, c())) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[WSDramaPageFragment.java][onDramaFeedReceive] feedDramaId:");
      ((StringBuilder)localObject1).append(paramstDramaFeed.dramaID);
      ((StringBuilder)localObject1).append(", curDramaId:");
      ((StringBuilder)localObject1).append(c());
      WSLog.a("WSDramaPageFragmentLognel-log", ((StringBuilder)localObject1).toString());
      localObject1 = this.y;
      if (!(localObject1 instanceof AbsWSDramaVideoHolder)) {
        return;
      }
      localObject1 = (AbsWSDramaVideoHolder)localObject1;
      if (a(paramstDramaFeed, (AbsWSDramaVideoHolder)localObject1))
      {
        WSLog.d("WSDramaPageFragmentLog", "[WSDramaPageFragment.java][onDramaFeedReceive] sameVideo!");
        return;
      }
      this.w.b();
      localObject2 = ((AbsWSDramaVideoHolder)localObject1).c;
      ((WSDramaItemData)localObject2).a(paramstDramaFeed);
      ((WSDramaItemData)localObject2).a(paramstDramaFeed.feed);
      ((AbsWSDramaVideoHolder)localObject1).a(paramstDramaFeed.feed, ((AbsWSDramaVideoHolder)localObject1).getAdapterPosition(), b());
      a((AbsWSDramaHolder)localObject1);
      this.w.a((AbsWSDramaVideoHolder)localObject1);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    int i1 = paramViewHolder.getLayoutPosition() - 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaPageFragment.java][onCenterViewChanged] currentPosition:");
    localStringBuilder.append(i1);
    localStringBuilder.append(", viewHolder:");
    localStringBuilder.append(paramViewHolder);
    WSLog.e("WSDramaPageFragmentLognel-log", localStringBuilder.toString());
    if ((paramViewHolder instanceof AbsWSDramaHolder))
    {
      paramViewHolder = (AbsWSDramaHolder)paramViewHolder;
      if (a(paramViewHolder, this.w.c()))
      {
        WSLog.d("WSDramaPageFragmentLog", "[WSDramaPageFragment.java][onCenterViewChanged]");
        return;
      }
      this.y = paramViewHolder;
      this.p = paramViewHolder.c.b();
      this.m.a(paramViewHolder, i1);
      this.w.a(paramViewHolder, i1);
      ((WSDramaPageContract.Presenter)this.b).a(paramViewHolder, i1);
      this.n.a(paramViewHolder, i1);
      paramViewHolder.b(i1);
      r();
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void a(WSDramaItemData paramWSDramaItemData, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaPageFragment.java][onDramaSelected] dramaId:");
    localStringBuilder.append(paramWSDramaItemData.b());
    WSLog.a("WSDramaPageFragmentLognel-log", localStringBuilder.toString());
    this.t = false;
    this.p = paramWSDramaItemData.b();
    this.h.scrollToPosition(paramInt);
  }
  
  public void a(WSEpisodeItemData paramWSEpisodeItemData, int paramInt)
  {
    this.t = false;
    this.w.b();
  }
  
  public void a(AbsWSDramaHolder paramAbsWSDramaHolder)
  {
    WSDramaBeaconReport.a(WSDramaUtils.b(paramAbsWSDramaHolder), WSDramaUtils.a(paramAbsWSDramaHolder), WSDramaUtils.c(paramAbsWSDramaHolder), WSDramaUtils.d(paramAbsWSDramaHolder), this.o, WSDramaUtils.e(paramAbsWSDramaHolder));
  }
  
  public void a(AbsWSDramaVideoHolder paramAbsWSDramaVideoHolder, String paramString1, String paramString2, int paramInt)
  {
    if (paramAbsWSDramaVideoHolder == null) {
      return;
    }
    WSPlayerParam localWSPlayerParam = WSDramaDataManager.a().b();
    if (localWSPlayerParam == null) {
      return;
    }
    if ((localWSPlayerParam.d != null) && (localWSPlayerParam.b != null) && (paramAbsWSDramaVideoHolder.e() != null) && (this.x != null))
    {
      paramAbsWSDramaVideoHolder.e().d = localWSPlayerParam.d;
      paramAbsWSDramaVideoHolder.e().b = localWSPlayerParam.b;
      paramAbsWSDramaVideoHolder.e().l = localWSPlayerParam.l;
      paramAbsWSDramaVideoHolder.e().d.d(false);
      this.w.c(paramAbsWSDramaVideoHolder);
      WSVerticalBeaconReport.a(paramString1, paramString2, paramAbsWSDramaVideoHolder.e(), false, paramInt, null);
      this.x.a(paramAbsWSDramaVideoHolder.e(), true);
      paramString1 = new StringBuilder();
      paramString1.append("[WSDramaPageFragment.java][handleOnActivityResultFromVertical], title: ");
      paramString1.append(paramAbsWSDramaVideoHolder.e().c.g);
      paramString1.append(", playingHolder: ");
      paramString1.append(paramAbsWSDramaVideoHolder);
      WSLog.a("WSDramaPageFragmentLog", paramString1.toString());
    }
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    ((WSDramaPageContract.Presenter)this.b).a(paramWSSimpleBaseEvent);
  }
  
  public void a(WSPlayerParam paramWSPlayerParam)
  {
    WSLog.a("WSDramaPageFragmentLognel-log", "[WSDramaPageFragment.java][onVideoStarted]");
    ((WSDramaPageContract.Presenter)this.b).a(paramWSPlayerParam);
    u();
    this.m.j();
  }
  
  public void a(WSPlayerParam paramWSPlayerParam, boolean paramBoolean)
  {
    ((WSDramaPageContract.Presenter)this.b).a(paramWSPlayerParam, paramBoolean);
  }
  
  public void a(List<WSDramaItemData> paramList)
  {
    this.w.fillList(paramList);
    this.m.a(paramList);
  }
  
  public WSPlayerManager aK_()
  {
    return this.x;
  }
  
  public boolean aL_()
  {
    return this.t;
  }
  
  public String b()
  {
    return this.o;
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
    this.t = true;
    ((WSDramaPageContract.Presenter)this.b).b(paramWSPlayerParam);
    this.m.h();
  }
  
  public void b(List<WSDramaItemData> paramList)
  {
    this.w.a(paramList);
    this.m.a(paramList);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    ((WSDramaPageContract.Presenter)this.b).a(paramBoolean2, paramBoolean1);
  }
  
  public String c()
  {
    return this.p;
  }
  
  public WSDramaPageAdapter d()
  {
    return this.w;
  }
  
  public AbsWSDramaHolder e()
  {
    return this.y;
  }
  
  public void e(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(this.x);
      return;
    }
    b(this.x);
  }
  
  protected void i()
  {
    super.i();
    if (this.d) {
      WeishiUtils.m("drama_preview");
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(2130772310, 2130772309);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public HashSet<IWSPartLifeCycle> j()
  {
    HashSet localHashSet = new HashSet();
    this.n = WSDramaHistoryPart.a(getContext(), this.l, this, this.o);
    localHashSet.add(this.n);
    this.m = WSDramaMiddlePart.a(this, this.k, getArguments());
    localHashSet.add(this.m);
    this.m.a(this);
    return localHashSet;
  }
  
  @android.support.annotation.NonNull
  public WSDramaPageContract.Presenter n()
  {
    return new WSDramaForCommonPresenter();
  }
  
  public void o() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 4097) && (paramInt2 == 8194))
    {
      paramIntent.getIntExtra("current_episode_num", 0);
      paramInt1 = paramIntent.getIntExtra("key_feed_position", 0);
      String str = paramIntent.getStringExtra("key_from");
      paramIntent = paramIntent.getStringExtra("key_play_scene");
      a(this.w.c(), str, paramIntent, paramInt1);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    p();
    super.onCreate(paramBundle);
    if ((getActivity() instanceof PublicFragmentActivity)) {
      this.g = ((PublicFragmentActivity)getActivity()).getSystemBarComp();
    }
    a(this.o, this.q);
  }
  
  @Nullable
  public View onCreateView(@androidx.annotation.NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131626054, paramViewGroup, false);
    a(paramLayoutInflater);
    q();
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ((WSDramaPageContract.Presenter)this.b).destroy();
    Object localObject = this.h;
    if (localObject != null) {
      ((VideoFeedsRecyclerView)localObject).h();
    }
    localObject = this.x;
    if (localObject != null)
    {
      ((WSPlayerManager)localObject).d(true);
      this.x = null;
    }
    WSDramaDataManager.a().d();
  }
  
  public void onPause()
  {
    super.onPause();
    WSLog.e("WSDramaPageFragmentLog", "[WSDramaPageFragment.java][onPause]");
    ((WSDramaPageContract.Presenter)this.b).c();
    if (this.s)
    {
      this.x.q();
      this.s = true;
    }
    f(false);
    WSPlayerAudioControl.a().a(false);
    WSDramaBeaconReport.b(this.o);
  }
  
  public void onResume()
  {
    super.onResume();
    WSLog.e("WSDramaPageFragmentLog", "[WSDramaPageFragment.java][onResume]");
    SystemBarCompact localSystemBarCompact = this.g;
    if (localSystemBarCompact != null) {
      localSystemBarCompact.setStatusBarVisible(2, 0);
    }
    this.s = true;
    ((WSDramaPageContract.Presenter)this.b).b();
    this.x.p();
    f(true);
    WSPlayerAudioControl.a().a(true);
    WSDramaBeaconReport.a(this.o);
  }
  
  public void onSaveInstanceState(@androidx.annotation.NonNull Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.u.a(paramBundle);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaPageFragment.java][onSaveInstanceState] outState:");
    localStringBuilder.append(paramBundle);
    WSLog.d("WSDramaPageFragmentLog", localStringBuilder.toString());
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ((WSDramaPageContract.Presenter)this.b).a();
  }
  
  public void onViewStateRestored(@Nullable Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSDramaPageFragment.java][onViewStateRestored] savedInstanceState:");
    localStringBuilder.append(paramBundle);
    WSLog.d("WSDramaPageFragmentLog", localStringBuilder.toString());
    this.u.b(paramBundle);
  }
  
  public void r()
  {
    this.i.setVisibility(0);
  }
  
  public void s()
  {
    this.j.setVisibility(8);
  }
  
  public void u()
  {
    this.i.setVisibility(8);
  }
  
  public ArrayList<Class> z()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSDramaVideoExposureEvent.class);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageFragment
 * JD-Core Version:    0.7.0.1
 */