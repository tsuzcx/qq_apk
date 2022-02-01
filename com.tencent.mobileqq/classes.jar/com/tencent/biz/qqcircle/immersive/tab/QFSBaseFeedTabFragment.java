package com.tencent.biz.qqcircle.immersive.tab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.QCircleCollection;
import com.tencent.biz.qqcircle.adapter.QCircleBaseFeedBlock;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseBlockPart;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.folder.QCircleFeedBlockStrategyHelper;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.fragments.QCircleBlockMerger;
import com.tencent.biz.qqcircle.immersive.bean.QFSLayerHeadViewRefreshInfo;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSTabFragmentIoc;
import com.tencent.biz.qqcircle.immersive.refresh.QFSLayerLoadFooterView;
import com.tencent.biz.qqcircle.immersive.refresh.QFSLayerRefreshHeaderView;
import com.tencent.biz.qqcircle.immersive.refresh.QFSPullRefreshLayout;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.viewmodels.QCircleTabFeedViewModel;
import com.tencent.biz.qqcircle.widgets.FrameAnimationView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rfw.barrage.util.RFWBarrageViewUtils;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StPageRedPointInfo;

public abstract class QFSBaseFeedTabFragment
  extends QFSBaseTabFragment
{
  private static final long F = QCircleConfigHelper.aF();
  private QFSLayerLoadFooterView A;
  private FrameAnimationView B;
  private int G;
  protected IQFSTabFragmentIoc c;
  protected boolean d;
  protected boolean e = false;
  protected QCircleBaseBlockPart f;
  protected QCircleSharePartV2 g;
  protected QCircleRichMediaDownLoadPart h;
  protected QCircleBaseFeedBlock i;
  protected QCircleTabFeedViewModel j;
  protected QCircleStatusView k;
  protected QCirclePolyLikeAniView l;
  protected QCircleFolderFragmentsPart m;
  protected boolean n = true;
  protected boolean o = false;
  protected boolean p = false;
  protected boolean q = false;
  protected QQCircleFeedBase.StPageRedPointInfo r = null;
  protected byte[] s;
  protected int t = 0;
  private View x;
  private QFSPullRefreshLayout y;
  private QFSLayerRefreshHeaderView z;
  
  protected QFSBaseFeedTabFragment(QCircleTabInfo paramQCircleTabInfo, int paramInt)
  {
    super(paramQCircleTabInfo, paramInt);
  }
  
  private void a(long paramLong, String paramString)
  {
    QCircleStatusView localQCircleStatusView;
    if (a(paramLong))
    {
      this.i.clearData();
      this.i.notifyDataSetChanged();
      localQCircleStatusView = this.k;
      if (localQCircleStatusView != null) {
        localQCircleStatusView.c(paramString);
      }
      return;
    }
    if ((!U()) && (!ae()))
    {
      localQCircleStatusView = this.k;
      if (localQCircleStatusView != null) {
        localQCircleStatusView.c(paramString);
      }
    }
    else
    {
      QCircleToastUtil.a(paramLong, QCircleToast.c, paramString, 1);
    }
  }
  
  private void a(@Nullable ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      this.B = new FrameAnimationView(getActivity());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      String str;
      int i1;
      if (w() == 2)
      {
        localLayoutParams.setMargins(0, RFWBarrageViewUtils.a(100.0F), 0, 0);
        str = null;
        if (QCircleCommonUtil.isInNightMode()) {
          i1 = 2130845470;
        } else {
          i1 = 2130845469;
        }
      }
      else
      {
        if (QCircleCommonUtil.isInNightMode()) {
          str = "https://down.qq.com/video_story/qcircle/pic/loadingframe/qcircle_night_mode_loading.zip";
        } else {
          str = "https://downv6.qq.com/video_story/follow_page_loading.zip";
        }
        if (QCircleCommonUtil.isInNightMode()) {
          i1 = 2130845114;
        } else {
          i1 = 2130845115;
        }
      }
      this.B.setDownloadZipFilePath(str, 1000, i1, false);
      paramViewGroup.addView(this.B, localLayoutParams);
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, float paramFloat)
  {
    if (paramBoolean) {
      return;
    }
    QFSLayerHeadViewRefreshInfo localQFSLayerHeadViewRefreshInfo = new QFSLayerHeadViewRefreshInfo(paramInt);
    localQFSLayerHeadViewRefreshInfo.a(paramFloat);
    this.c.a("event_layer_head_view_refresh_status", new Object[] { localQFSLayerHeadViewRefreshInfo });
  }
  
  private void ab()
  {
    this.y = ((QFSPullRefreshLayout)this.D.findViewById(2131440660));
    this.x = this.D.findViewById(2131449875);
    this.y.setRefreshEnable(true);
    this.y.setLoadMoreEnable(true);
    this.y.setAutoLoadEnable(true);
    this.y.setOffsetRadio(3.0F);
    this.y.setHeaderViewMarginTop(ViewUtils.a());
    this.y.setOnRefreshListener(new QFSBaseFeedTabFragment.2(this));
    ac();
  }
  
  private void ac()
  {
    QFSBaseFeedTabFragment.3 local3 = new QFSBaseFeedTabFragment.3(this);
    this.z = new QFSLayerRefreshHeaderView(getContext());
    this.z.setOnRefreshViewStatusListener(local3);
    this.y.setHeaderView(this.z, 3);
    this.A = new QFSLayerLoadFooterView(getContext());
    this.A.setOnRefreshViewStatusListener(local3);
    this.y.setFooterView(this.A, 2);
  }
  
  private void ad()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append(" init hasInit:");
    localStringBuilder.append(this.e);
    QLog.d(str, 1, localStringBuilder.toString());
    if (!this.e)
    {
      this.e = true;
      R();
      S();
    }
  }
  
  private boolean ae()
  {
    QCircleBaseFeedBlock localQCircleBaseFeedBlock = this.i;
    return ((localQCircleBaseFeedBlock instanceof QCircleInsFeedAdapter)) && (((QCircleInsFeedAdapter)localQCircleBaseFeedBlock).f());
  }
  
  private void aj()
  {
    FrameAnimationView localFrameAnimationView = this.B;
    if (localFrameAnimationView == null) {
      return;
    }
    localFrameAnimationView.animate().setDuration(100L).alpha(0.0F).setListener(new QFSBaseFeedTabFragment.11(this));
  }
  
  void A()
  {
    if (!aa()) {
      ad();
    }
  }
  
  public void B()
  {
    this.d = false;
    QCircleBaseFeedBlock localQCircleBaseFeedBlock = this.i;
    if (localQCircleBaseFeedBlock != null) {
      localQCircleBaseFeedBlock.c();
    }
  }
  
  protected void C() {}
  
  protected void D()
  {
    QCircleTabFeedViewModel localQCircleTabFeedViewModel = this.j;
    if (localQCircleTabFeedViewModel != null) {
      localQCircleTabFeedViewModel.a(this.t);
    }
  }
  
  protected boolean E()
  {
    return false;
  }
  
  protected QCircleFolderBean F()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null) && (getActivity().getIntent().hasExtra("key_bundle_common_init_bean"))) {
      return (QCircleFolderBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
    }
    return null;
  }
  
  protected void G()
  {
    boolean bool = H();
    this.t = (bool ^ true);
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[refreshData] isRealVisibleToUser :");
    localStringBuilder.append(bool);
    localStringBuilder.append(",initPullSceneType : ");
    localStringBuilder.append(this.t);
    QLog.d(str, 1, localStringBuilder.toString());
  }
  
  protected boolean H()
  {
    return this.d;
  }
  
  public abstract String I();
  
  protected String J()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(I());
    localStringBuilder.append("_");
    localStringBuilder.append(this.v);
    return localStringBuilder.toString();
  }
  
  protected void K()
  {
    QLog.d(b(), 1, "customRefreshData");
  }
  
  public void L()
  {
    String str = b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("scrollToTop");
    ((StringBuilder)localObject).append(J());
    QLog.d(str, 1, ((StringBuilder)localObject).toString());
    try
    {
      this.f.be_().getRecyclerView().scrollToPosition(0);
      return;
    }
    catch (Exception localException)
    {
      localObject = b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollToTop exception:");
      localStringBuilder.append(localException.toString());
      localStringBuilder.append(J());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  public void M()
  {
    Object localObject1 = b();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("scrollToTopAndRefresh");
    ((StringBuilder)localObject2).append(J());
    QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = this.k;
    if (localObject1 != null) {
      ((QCircleStatusView)localObject1).c();
    }
    try
    {
      if (this.c != null) {
        this.c.a("event_hide_comment", new Object[0]);
      }
      this.x.setVisibility(8);
      this.y.e();
      return;
    }
    catch (Exception localException)
    {
      localObject2 = b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollToTopAndRefresh exception:");
      localStringBuilder.append(localException.toString());
      localStringBuilder.append(J());
      QLog.d((String)localObject2, 1, localStringBuilder.toString());
    }
  }
  
  public void N()
  {
    String str = b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showRefreshAnimation");
    ((StringBuilder)localObject).append(J());
    QLog.d(str, 1, ((StringBuilder)localObject).toString());
    try
    {
      this.f.be_().getBlockMerger().a();
      return;
    }
    catch (Exception localException)
    {
      localObject = b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showRefreshAnimation exception:");
      localStringBuilder.append(localException.toString());
      localStringBuilder.append(J());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  public void O()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append(" tryLazyLoadTab");
    QLog.d(str, 1, localStringBuilder.toString());
    ad();
  }
  
  protected void P()
  {
    RFThreadManager.getUIHandler().postDelayed(new QFSBaseFeedTabFragment.8(this), F);
  }
  
  protected QCircleTabFeedViewModel Q()
  {
    return (QCircleTabFeedViewModel)a(J(), QCircleTabFeedViewModel.class);
  }
  
  protected void R()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initViewModel,tabKey:");
    localStringBuilder.append(J());
    localStringBuilder.append("class:");
    localStringBuilder.append(getClass().getSimpleName());
    QLog.d(str, 1, localStringBuilder.toString());
    this.j = Q();
    QCircleFeedDataCenter.a().a(J(), this.j);
    this.j.a(I());
    this.j.d().observe(this, new QFSBaseFeedTabFragment.9(this));
    this.j.a(this.u);
    this.j.a(this.r);
  }
  
  protected void S()
  {
    if ((this.n) && (this.j.h()))
    {
      K();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initViewData with page cache");
      localStringBuilder.append(J());
      QLog.d("QCircleFolderCacheHelper", 1, localStringBuilder.toString());
      return;
    }
    QCircleCollection.a("qcircle_feed");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initViewData without page cache");
    localStringBuilder.append(J());
    QLog.d("QCircleFolderCacheHelper", 1, localStringBuilder.toString());
    b(true);
  }
  
  protected void T()
  {
    QFSPullRefreshLayout localQFSPullRefreshLayout = this.y;
    if (localQFSPullRefreshLayout != null)
    {
      localQFSPullRefreshLayout.b(true);
      this.y.a(true);
    }
    if ((this.B != null) && (this.D != null))
    {
      ((ViewGroup)this.D).removeView(this.B);
      this.B = null;
    }
  }
  
  protected boolean U()
  {
    QCircleBaseFeedBlock localQCircleBaseFeedBlock = this.i;
    return (localQCircleBaseFeedBlock != null) && (localQCircleBaseFeedBlock.getItemCount() > 0);
  }
  
  protected void V()
  {
    Object localObject1 = b();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("savePageCache");
    ((StringBuilder)localObject2).append(J());
    QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    for (;;)
    {
      try
      {
        if ((this.j != null) && (this.f.be_() != null) && (this.f.be_().getRecyclerView() != null))
        {
          localObject1 = this.f.be_().getRecyclerView();
          localObject2 = this.f.be_().getRecyclerView().getLayoutManager();
          if ((localObject2 instanceof SafeStaggeredGridLayoutManager))
          {
            localObject2 = (SafeStaggeredGridLayoutManager)localObject2;
            int i2 = 0;
            localObject1 = ((RecyclerView)localObject1).getChildAt(0);
            if (localObject1 == null) {
              break label188;
            }
            i2 = ((SafeStaggeredGridLayoutManager)localObject2).getPosition((View)localObject1);
            i1 = ((View)localObject1).getTop();
            localObject1 = this.i.d();
            if (localObject1 != null)
            {
              if (((List)localObject1).size() == 0) {
                return;
              }
              this.j.a((List)localObject1);
              this.j.a(i2, i1);
              return;
            }
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label188:
      int i1 = 0;
    }
  }
  
  public void a(int paramInt)
  {
    this.d = true;
    QCircleBaseFeedBlock localQCircleBaseFeedBlock = this.i;
    if (localQCircleBaseFeedBlock != null) {
      localQCircleBaseFeedBlock.b(paramInt);
    }
    A();
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    QLog.d(b(), 1, new Object[] { "resumePageCachePosition pos:", Integer.valueOf(paramInt1), ",top:", Integer.valueOf(paramInt2) });
    NestScrollRecyclerView localNestScrollRecyclerView = this.f.be_().getRecyclerView();
    if (localNestScrollRecyclerView != null) {
      localNestScrollRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new QFSBaseFeedTabFragment.10(this, localNestScrollRecyclerView, paramInt1, paramInt2));
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.f.be_().setEnableRefresh(false);
    this.f.be_().setEnableLoadMore(false);
    a((ViewGroup)this.D);
    this.G = (DisplayUtil.e() / 3);
    this.f.be_().getRecyclerView().addOnScrollListener(new QFSBaseFeedTabFragment.1(this));
    u();
    ab();
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("scrollToPosWithOffset pos:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",top:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(J());
    QLog.d("QCircleFolderCacheHelper", 1, ((StringBuilder)localObject).toString());
    try
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof SafeStaggeredGridLayoutManager))
      {
        ((SafeStaggeredGridLayoutManager)paramRecyclerView).scrollToPositionWithOffset(paramInt1, paramInt2);
        return;
      }
    }
    catch (Exception paramRecyclerView)
    {
      localObject = b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollToPosWithOffset exception:");
      localStringBuilder.append(paramRecyclerView.toString());
      localStringBuilder.append(J());
      QLog.e((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  public void a(IQFSTabFragmentIoc paramIQFSTabFragmentIoc)
  {
    this.c = paramIQFSTabFragmentIoc;
  }
  
  protected void a(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    if (paramUIStateData == null)
    {
      QLog.e(b(), 1, "handleFeedDataRsp() return unexpected data！");
      return;
    }
    if (5 != paramUIStateData.c()) {
      T();
    }
    int i1 = paramUIStateData.c();
    if (i1 != 0)
    {
      if ((i1 != 2) && (i1 != 3))
      {
        if (i1 != 4)
        {
          if (i1 != 5) {
            return;
          }
          e(paramUIStateData);
          return;
        }
        c(paramUIStateData);
        return;
      }
      d(paramUIStateData);
      if (!paramUIStateData.i())
      {
        if (paramUIStateData.c() == 2) {
          paramUIStateData = "formCache ";
        } else {
          paramUIStateData = "fromNet ";
        }
        QCircleCollection.a("qcircle_feed", paramUIStateData);
      }
    }
    else
    {
      b(paramUIStateData);
    }
  }
  
  public void a(Boolean paramBoolean) {}
  
  protected void a(List<Part> paramList) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.d = paramBoolean;
  }
  
  protected boolean a(long paramLong)
  {
    return paramLong == 10009L;
  }
  
  protected void b(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    Object localObject = this.i;
    if (localObject == null)
    {
      QLog.e(b(), 1, "handleEmptyRsp feed adapter is null!");
      return;
    }
    ((QCircleBaseFeedBlock)localObject).notifyLoadingComplete(true, paramUIStateData.h());
    if ((!U()) && (!ae()))
    {
      localObject = this.k;
      if (localObject != null) {
        ((QCircleStatusView)localObject).a();
      }
    }
    else
    {
      QLog.e(b(), 1, "hasFeedContents do nothing");
    }
    if ((paramUIStateData.i()) && (U())) {
      this.i.getLoadInfo().a(paramUIStateData.h());
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (E()) {
      c(true);
    } else {
      c(paramBoolean);
    }
    G();
    K();
    QCircleTabFeedViewModel localQCircleTabFeedViewModel = this.j;
    if (localQCircleTabFeedViewModel != null) {
      localQCircleTabFeedViewModel.a(paramBoolean, this.t, F());
    }
  }
  
  public void beforeFinish()
  {
    super.beforeFinish();
    V();
  }
  
  protected void c(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    String str;
    if (paramUIStateData.f() == null) {
      str = HardCodeUtil.a(2131895632);
    } else {
      str = paramUIStateData.f();
    }
    Object localObject = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleFeedDataRsp() return error！errMsg:");
    localStringBuilder.append(str);
    QLog.e((String)localObject, 1, localStringBuilder.toString());
    localObject = this.i;
    if (localObject == null)
    {
      QLog.e(b(), 1, "handleErrorRsp feed adapter is null!");
      return;
    }
    ((QCircleBaseFeedBlock)localObject).notifyLoadingComplete(true, paramUIStateData.h());
    a(paramUIStateData.g(), str);
  }
  
  protected void c(boolean paramBoolean)
  {
    Object localObject = this.s;
    if ((localObject != null) && (localObject.length != 0))
    {
      localObject = this.j;
      if (localObject != null)
      {
        ((QCircleTabFeedViewModel)localObject).b("allpush_reddot");
        if (paramBoolean) {
          this.j.a(QCircleReportHelper.newEntry("allpush_reddot", this.s));
        }
        return;
      }
    }
    QLog.e(b(), 1, "wrapRedDotTransInfo no data or no model,direct return!");
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    int i1;
    if (w() == 2)
    {
      i1 = 2;
    }
    else
    {
      this.g = new QCircleSharePartV2();
      this.g.a(n());
      localArrayList.add(this.g);
      this.h = new QCircleRichMediaDownLoadPart();
      localArrayList.add(this.h);
      i1 = 1;
    }
    this.f = new QFSBaseFeedTabFragment.5(this, 2131431490, y(), 3, i1);
    if (w() == 1) {
      this.f.b(true);
    }
    localArrayList.add(this.f);
    a(localArrayList);
    return localArrayList;
  }
  
  protected void d(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    if (this.i == null)
    {
      QLog.e(b(), 1, "handleNetSuccRsp feed adapter is null!");
      return;
    }
    if (paramUIStateData.c() == 2)
    {
      QLog.d(b(), 1, "load data from cache");
      N();
    }
    else
    {
      this.i.getLoadInfo().a(paramUIStateData.h());
      this.i.notifyLoadingComplete(true, paramUIStateData.h());
    }
    Object localObject = this.k;
    if (localObject != null) {
      ((QCircleStatusView)localObject).c();
    }
    localObject = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleNetSuccRsp uiStateData.getData()");
    localStringBuilder.append(((List)paramUIStateData.e()).size());
    QLog.e((String)localObject, 1, localStringBuilder.toString());
    this.i.setDatas((ArrayList)paramUIStateData.e());
    if ((!paramUIStateData.i()) && (QCircleBaseTabFragment.d.equals(I())))
    {
      localObject = this.i;
      if ((localObject instanceof QCircleInsFeedAdapter)) {
        ((QCircleInsFeedAdapter)localObject).e();
      }
    }
    if (!paramUIStateData.i()) {
      L();
    }
    P();
  }
  
  protected void e(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    QCircleBaseFeedBlock localQCircleBaseFeedBlock = this.i;
    if (localQCircleBaseFeedBlock == null)
    {
      QLog.e(b(), 1, "handlePageCacheRsp feed adapter is null!");
      return;
    }
    localQCircleBaseFeedBlock.notifyLoadingComplete(true, paramUIStateData.h());
    this.i.setDatas((ArrayList)paramUIStateData.e());
    if (QCircleBaseTabFragment.d.equals(I()))
    {
      localQCircleBaseFeedBlock = this.i;
      if ((localQCircleBaseFeedBlock instanceof QCircleInsFeedAdapter)) {
        ((QCircleInsFeedAdapter)localQCircleBaseFeedBlock).e();
      }
    }
    this.i.getLoadInfo().a(paramUIStateData.h());
    a(paramUIStateData.j(), paramUIStateData.k());
    P();
  }
  
  public QCircleReportBean n()
  {
    if (this.a == null) {
      this.a = new QCircleReportBean();
    }
    this.a.setPageId(a());
    return this.a;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    C();
    if (aa()) {
      ad();
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    h();
  }
  
  protected void u()
  {
    this.k = ((QCircleStatusView)this.f.bc_());
    this.k.setOnRetryClickListener(new QFSBaseFeedTabFragment.4(this));
  }
  
  protected abstract int w();
  
  protected List<MultiViewBlock> x()
  {
    return null;
  }
  
  protected List<MultiViewBlock> y()
  {
    ArrayList localArrayList = new ArrayList();
    if (x() != null) {
      localArrayList.addAll(x());
    }
    QCircleFeedBlockStrategyHelper localQCircleFeedBlockStrategyHelper = new QCircleFeedBlockStrategyHelper(I(), this.v, w(), J());
    localQCircleFeedBlockStrategyHelper.a(n());
    localQCircleFeedBlockStrategyHelper.a(z());
    localQCircleFeedBlockStrategyHelper.a(W());
    localQCircleFeedBlockStrategyHelper.a(new QFSBaseFeedTabFragment.6(this));
    this.i = localQCircleFeedBlockStrategyHelper.a();
    localArrayList.add(this.i);
    return localArrayList;
  }
  
  protected QCircleInteractor z()
  {
    return new QFSBaseFeedTabFragment.7(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.tab.QFSBaseFeedTabFragment
 * JD-Core Version:    0.7.0.1
 */