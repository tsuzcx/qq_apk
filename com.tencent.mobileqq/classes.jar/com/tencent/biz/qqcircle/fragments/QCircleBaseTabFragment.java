package com.tencent.biz.qqcircle.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.QCircleCollection;
import com.tencent.biz.qcircleshadow.lib.QCircleHostDropFrameMonitorHelper._Constants;
import com.tencent.biz.qqcircle.QCircleJsUrlConfig;
import com.tencent.biz.qqcircle.adapter.QCircleBaseFeedBlock;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter;
import com.tencent.biz.qqcircle.adapter.QCircleMessageNoticeBubbleBlock;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleMessageNoticeInfo;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseBlockPart;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.folder.QCircleFeedBlockStrategyHelper;
import com.tencent.biz.qqcircle.folder.QCircleFolderCacheHelper;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderFollowTabFragment;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderRcmdTabFragment;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.biz.qqcircle.viewmodels.QCircleAbsTabFeedViewModel;
import com.tencent.biz.qqcircle.viewmodels.QCircleMessageNoticeViewModel;
import com.tencent.biz.qqcircle.viewmodels.QCirclePublishButtonViewModel;
import com.tencent.biz.qqcircle.viewmodels.QCircleTabFeedViewModel;
import com.tencent.biz.qqcircle.widgets.FrameAnimationView;
import com.tencent.biz.qqcircle.widgets.QCircleFolderTabView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeStaggeredGridLayoutManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReportHelper.LaunchParam;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import qqcircle.QQCircleFeedBase.StPageRedPointInfo;
import qqcircle.QQCircleFeedBase.StTabInfo;

public abstract class QCircleBaseTabFragment
  extends QCircleBaseFragment
  implements SimpleEventReceiver
{
  private static final long I = QCircleConfigHelper.aF();
  public static String c = "QCircleBaseTabFragment";
  public static String d = "TAB_TYPE_FOLLOW";
  public static String e = "TAB_TYPE_RECOMMEND";
  public static String f = "TAB_TYPE_NEARBY";
  protected byte[] A;
  private FrameAnimationView B;
  private boolean F = false;
  private QCircleMessageNoticeViewModel G;
  private long H;
  protected boolean g;
  protected int h = 0;
  protected boolean i = false;
  protected QCircleBaseBlockPart j;
  protected QCircleSharePartV2 k;
  protected QCircleRichMediaDownLoadPart l;
  protected QCircleBaseFeedBlock m;
  protected QCircleAbsTabFeedViewModel n;
  protected QCircleTabInfo o;
  protected QCircleStatusView p;
  protected QCirclePolyLikeAniView q;
  protected QCircleFolderFragmentsPart r;
  protected boolean s = true;
  protected boolean t = false;
  protected boolean u = false;
  protected boolean v = false;
  protected boolean w = false;
  protected QCircleMessageNoticeBubbleBlock x;
  protected int y = 0;
  protected QQCircleFeedBase.StPageRedPointInfo z = null;
  
  public QCircleBaseTabFragment(int paramInt)
  {
    this.h = paramInt;
  }
  
  private void a(long paramLong, String paramString)
  {
    QCircleStatusView localQCircleStatusView;
    if (a(paramLong))
    {
      this.m.clearData();
      this.m.notifyDataSetChanged();
      localQCircleStatusView = this.p;
      if (localQCircleStatusView != null) {
        localQCircleStatusView.c(paramString);
      }
      return;
    }
    if ((!M()) && (!ak()))
    {
      localQCircleStatusView = this.p;
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
      String str;
      int i1;
      if (A() == 2)
      {
        if (QCircleCommonUtil.isInNightMode()) {
          str = "https://downv6.qq.com/video_story/wezone_url/darkmode/870/square_skeleton_loading.zip";
        } else {
          str = "https://downv6.qq.com/video_story/wezone_url/defaultmode/870/square_skeleton_loading.zip";
        }
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
      paramViewGroup.addView(this.B, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  private void a(QCircleFrameEvent paramQCircleFrameEvent)
  {
    if ((getContext() != null) && (getContext().hashCode() != paramQCircleFrameEvent.mHashCode)) {
      b(paramQCircleFrameEvent.mRefreshTab);
    }
    if ((bg_()) && (paramQCircleFrameEvent.mIsRefreshRedNum)) {
      T();
    }
  }
  
  private void ad()
  {
    boolean bool = QCircleReportHelper.getInstance().isLaunchFromFolderPage();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(b());
    ((StringBuilder)localObject).append(" onAttach isLaunchFromFolderPage:");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append(",isFirstShownFragment");
    ((StringBuilder)localObject).append(aa());
    QLog.d("QCircleReportHelper", 1, ((StringBuilder)localObject).toString());
    if ((bool) && (aa()))
    {
      localObject = (QCircleInitBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      QCircleReportHelper.getInstance().setLaunchParms(QCircleReportHelper.LaunchParam.wrap(((QCircleInitBean)localObject).getLaunchFrom(), ((QCircleInitBean)localObject).getLaunchId(), ((QCircleInitBean)localObject).getUin(), a(), ((QCircleInitBean)localObject).getSchemeAttrs()));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(b());
      ((StringBuilder)localObject).append(" launchPageId:");
      ((StringBuilder)localObject).append(a());
      QLog.d("QCircleReportHelper", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void ae()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append(" init hasInit:");
    localStringBuilder.append(this.i);
    QLog.d(str, 1, localStringBuilder.toString());
    if (!this.i)
    {
      this.i = true;
      J();
      K();
    }
  }
  
  private void aj()
  {
    Object localObject = this.r;
    if (localObject != null)
    {
      localObject = ((QCircleFolderFragmentsPart)localObject).j();
      this.G = ((QCircleMessageNoticeViewModel)a(QCircleMessageNoticeViewModel.class));
      this.G.a((BasePartFragment)localObject);
    }
  }
  
  private boolean ak()
  {
    QCircleBaseFeedBlock localQCircleBaseFeedBlock = this.m;
    return ((localQCircleBaseFeedBlock instanceof QCircleInsFeedAdapter)) && (((QCircleInsFeedAdapter)localQCircleBaseFeedBlock).f());
  }
  
  private void al()
  {
    if (bg_())
    {
      QCircleMessageNoticeBubbleBlock localQCircleMessageNoticeBubbleBlock = this.x;
      if ((localQCircleMessageNoticeBubbleBlock != null) && (localQCircleMessageNoticeBubbleBlock.b())) {
        this.x.c();
      }
    }
  }
  
  private String am()
  {
    if ((this instanceof QCircleFolderFollowTabFragment)) {
      return QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_FOLLOW_TAB_PAGE();
    }
    return QCircleHostDropFrameMonitorHelper._Constants.QCIRCLE_ALL_PUSH_TAB_PAGE();
  }
  
  private void b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 4) {
            return;
          }
          O();
          return;
        }
        if ((this instanceof QCircleFolderFollowTabFragment)) {
          O();
        }
      }
      else if ((this instanceof QCircleFolderRcmdTabFragment))
      {
        O();
      }
    }
    else {
      ab();
    }
  }
  
  protected abstract int A();
  
  protected List<MultiViewBlock> B()
  {
    return null;
  }
  
  protected List<MultiViewBlock> C()
  {
    ArrayList localArrayList = new ArrayList();
    if (B() != null) {
      localArrayList.addAll(B());
    }
    QCircleFeedBlockStrategyHelper localQCircleFeedBlockStrategyHelper = new QCircleFeedBlockStrategyHelper(N(), this.h, A(), u());
    localQCircleFeedBlockStrategyHelper.a(n());
    localQCircleFeedBlockStrategyHelper.a(D());
    localQCircleFeedBlockStrategyHelper.a(U());
    localQCircleFeedBlockStrategyHelper.a(new QCircleBaseTabFragment.5(this));
    this.m = localQCircleFeedBlockStrategyHelper.a();
    localArrayList.add(this.m);
    return localArrayList;
  }
  
  protected QCircleInteractor D()
  {
    return new QCircleBaseTabFragment.6(this);
  }
  
  void E()
  {
    if (!aa()) {
      ae();
    }
  }
  
  public void F()
  {
    this.g = false;
    QCircleBaseFeedBlock localQCircleBaseFeedBlock = this.m;
    if (localQCircleBaseFeedBlock != null) {
      localQCircleBaseFeedBlock.c();
    }
  }
  
  public void G()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append(" tryLazyLoadTab");
    QLog.d(str, 1, localStringBuilder.toString());
    ae();
  }
  
  protected void H()
  {
    RFThreadManager.getUIHandler().postDelayed(new QCircleBaseTabFragment.7(this), I);
  }
  
  protected QCircleAbsTabFeedViewModel I()
  {
    return (QCircleAbsTabFeedViewModel)a(u(), QCircleTabFeedViewModel.class);
  }
  
  protected void J()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initViewModel,tabKey:");
    localStringBuilder.append(u());
    localStringBuilder.append("class:");
    localStringBuilder.append(getClass().getSimpleName());
    QLog.d(str, 1, localStringBuilder.toString());
    this.n = I();
    QCircleFeedDataCenter.a().a(u(), this.n);
    this.n.a(N());
    this.n.d().observe(this, new QCircleBaseTabFragment.8(this));
    this.n.a(this.o);
    this.n.a(this.z);
    aj();
  }
  
  protected void K()
  {
    if ((this.s) && (this.n.h()))
    {
      T();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initViewData with page cache");
      localStringBuilder.append(u());
      QLog.d("QCircleFolderCacheHelper", 1, localStringBuilder.toString());
      return;
    }
    QCircleCollection.a("qcircle_feed");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initViewData without page cache");
    localStringBuilder.append(u());
    QLog.d("QCircleFolderCacheHelper", 1, localStringBuilder.toString());
    b(true);
  }
  
  protected void L()
  {
    if ((this.B != null) && (this.D != null))
    {
      ((ViewGroup)this.D).removeView(this.B);
      this.B = null;
    }
  }
  
  protected boolean M()
  {
    QCircleBaseFeedBlock localQCircleBaseFeedBlock = this.m;
    return (localQCircleBaseFeedBlock != null) && (localQCircleBaseFeedBlock.getItemCount() > 0);
  }
  
  public abstract String N();
  
  public abstract void O();
  
  protected void P()
  {
    QCircleAbsTabFeedViewModel localQCircleAbsTabFeedViewModel = this.n;
    if (localQCircleAbsTabFeedViewModel != null) {
      localQCircleAbsTabFeedViewModel.a(this.y);
    }
  }
  
  protected boolean Q()
  {
    return false;
  }
  
  protected QCircleFolderBean R()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null) && (getActivity().getIntent().hasExtra("key_bundle_common_init_bean"))) {
      return (QCircleFolderBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
    }
    return null;
  }
  
  protected void S()
  {
    boolean bool = bg_();
    this.y = (bool ^ true);
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[refreshData] isRealVisibleToUser :");
    localStringBuilder.append(bool);
    localStringBuilder.append(",initPullSceneType : ");
    localStringBuilder.append(this.y);
    QLog.d(str, 1, localStringBuilder.toString());
  }
  
  protected void T()
  {
    QLog.d(b(), 1, "customRefreshData");
    if (this.G != null)
    {
      QLog.d(b(), 1, "mMessageNoticeViewModel pullLastestInfo");
      this.G.a(getActivity());
    }
  }
  
  public QCircleTabInfo U()
  {
    return this.o;
  }
  
  public void V()
  {
    String str = b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("scrollToTop");
    ((StringBuilder)localObject).append(u());
    QLog.d(str, 1, ((StringBuilder)localObject).toString());
    try
    {
      this.j.be_().getRecyclerView().scrollToPosition(0);
      return;
    }
    catch (Exception localException)
    {
      localObject = b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollToTop exception:");
      localStringBuilder.append(localException.toString());
      localStringBuilder.append(u());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  public void W()
  {
    Object localObject1 = b();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("scrollToTopAndRefresh");
    ((StringBuilder)localObject2).append(u());
    QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = this.p;
    if (localObject1 != null) {
      ((QCircleStatusView)localObject1).c();
    }
    try
    {
      this.j.be_().getBlockMerger().t();
      return;
    }
    catch (Exception localException)
    {
      localObject2 = b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollToTopAndRefresh exception:");
      localStringBuilder.append(localException.toString());
      localStringBuilder.append(u());
      QLog.d((String)localObject2, 1, localStringBuilder.toString());
    }
  }
  
  public void X()
  {
    String str = b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("showRefreshAnimation");
    ((StringBuilder)localObject).append(u());
    QLog.d(str, 1, ((StringBuilder)localObject).toString());
    try
    {
      this.j.be_().getBlockMerger().a();
      return;
    }
    catch (Exception localException)
    {
      localObject = b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showRefreshAnimation exception:");
      localStringBuilder.append(localException.toString());
      localStringBuilder.append(u());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  protected void Y()
  {
    Object localObject = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("savePageCache");
    localStringBuilder.append(u());
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    try
    {
      localObject = ac();
      if ((localObject != null) && (((QCircleBaseTabFragment.PageCacheInfo)localObject).a()))
      {
        if (this.n != null)
        {
          this.n.a(QCircleBaseTabFragment.PageCacheInfo.a((QCircleBaseTabFragment.PageCacheInfo)localObject));
          this.n.a(QCircleBaseTabFragment.PageCacheInfo.b((QCircleBaseTabFragment.PageCacheInfo)localObject), QCircleBaseTabFragment.PageCacheInfo.c((QCircleBaseTabFragment.PageCacheInfo)localObject));
        }
      }
      else
      {
        localObject = b();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("savePageCache error");
        localStringBuilder.append(u());
        QLog.e((String)localObject, 1, localStringBuilder.toString());
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void Z() {}
  
  public void a(int paramInt)
  {
    this.g = true;
    al();
    QCircleBaseFeedBlock localQCircleBaseFeedBlock = this.m;
    if (localQCircleBaseFeedBlock != null) {
      localQCircleBaseFeedBlock.b(paramInt);
    }
    E();
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    QLog.d(b(), 1, new Object[] { "resumePageCachePosition pos:", Integer.valueOf(paramInt1), ",top:", Integer.valueOf(paramInt2) });
    NestScrollRecyclerView localNestScrollRecyclerView = this.j.be_().getRecyclerView();
    if (localNestScrollRecyclerView != null) {
      localNestScrollRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new QCircleBaseTabFragment.9(this, localNestScrollRecyclerView, paramInt1, paramInt2));
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.j.be_().setEnableRefresh(true);
    this.j.be_().setEnableLoadMore(true);
    w();
    SimpleEventBus.getInstance().registerReceiver(this);
    a((ViewGroup)this.D);
    paramLayoutInflater = (QCirclePublishButtonViewModel)getViewModel((BasePartFragment)getParentFragment(), null, QCirclePublishButtonViewModel.class);
    this.j.be_().getRecyclerView().addOnScrollListener(new QCircleBaseTabFragment.1(this, paramLayoutInflater));
    this.j.be_().getBlockMerger().a(new QCircleBaseTabFragment.2(this));
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("scrollToPosWithOffset pos:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",top:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(u());
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
      localStringBuilder.append(u());
      QLog.e((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  protected void a(QCircleMessageNoticeInfo paramQCircleMessageNoticeInfo)
  {
    if (this.x != null)
    {
      QCircleTabInfo localQCircleTabInfo = this.o;
      if ((localQCircleTabInfo != null) && (localQCircleTabInfo.a != null)) {
        if (paramQCircleMessageNoticeInfo != null)
        {
          paramQCircleMessageNoticeInfo.a(QCircleJsUrlConfig.a(this.o.a.urlInfo.get(), "NoticeListUrl"));
          boolean bool = paramQCircleMessageNoticeInfo.f();
          this.x.a(bool);
          if (bool)
          {
            QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(18).setSubActionType(1));
            this.x.setDatas(new ArrayList(Collections.singletonList(paramQCircleMessageNoticeInfo)));
            al();
          }
        }
        else
        {
          this.x.a(false);
        }
      }
    }
  }
  
  public void a(QCircleTabInfo paramQCircleTabInfo)
  {
    this.o = paramQCircleTabInfo;
    this.g = aa();
  }
  
  public void a(QCircleFolderFragmentsPart paramQCircleFolderFragmentsPart)
  {
    this.r = paramQCircleFolderFragmentsPart;
  }
  
  public void a(QCirclePolyLikeAniView paramQCirclePolyLikeAniView)
  {
    this.q = paramQCirclePolyLikeAniView;
  }
  
  protected void a(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    if (paramUIStateData == null)
    {
      QLog.e(b(), 1, "handleFeedDataRsp() return unexpected data！");
      return;
    }
    if (paramUIStateData.c() == 1) {
      return;
    }
    L();
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
  
  protected void a(List<Part> paramList) {}
  
  protected void a(boolean paramBoolean)
  {
    Object localObject = this.A;
    if ((localObject != null) && (localObject.length != 0))
    {
      localObject = this.n;
      if (localObject != null)
      {
        ((QCircleAbsTabFeedViewModel)localObject).b("allpush_reddot");
        if (paramBoolean) {
          this.n.a(QCircleReportHelper.newEntry("allpush_reddot", this.A));
        }
        return;
      }
    }
    QLog.e(c, 1, "wrapRedDotTransInfo no data or no model,direct return!");
  }
  
  protected boolean a(long paramLong)
  {
    return paramLong == 10009L;
  }
  
  public boolean aa()
  {
    return this.F;
  }
  
  protected void ab()
  {
    if (System.currentTimeMillis() - this.H > 1000L)
    {
      QCircleBaseBlockPart localQCircleBaseBlockPart = this.j;
      if ((localQCircleBaseBlockPart != null) && (!localQCircleBaseBlockPart.be_().getBlockMerger().v()))
      {
        W();
        this.H = System.currentTimeMillis();
      }
    }
  }
  
  public QCircleBaseTabFragment.PageCacheInfo ac()
  {
    QCircleBaseBlockPart localQCircleBaseBlockPart = this.j;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localQCircleBaseBlockPart != null)
    {
      localObject1 = localObject2;
      if (localQCircleBaseBlockPart.be_() != null)
      {
        if (this.j.be_().getRecyclerView() == null) {
          return null;
        }
        localObject1 = this.j.be_().getRecyclerView();
        localObject2 = this.j.be_().getRecyclerView().getLayoutManager();
        if (!(localObject2 instanceof SafeStaggeredGridLayoutManager)) {
          return null;
        }
        localObject2 = (SafeStaggeredGridLayoutManager)localObject2;
        int i3 = 0;
        localObject1 = ((RecyclerView)localObject1).getChildAt(0);
        int i1;
        int i2;
        if (localObject1 != null)
        {
          i1 = ((SafeStaggeredGridLayoutManager)localObject2).getPosition((View)localObject1);
          i2 = ((View)localObject1).getTop();
        }
        else
        {
          i2 = 0;
          i1 = 0;
        }
        localObject1 = this.m;
        if ((localObject1 instanceof QCircleInsFeedAdapter)) {
          i3 = ((QCircleInsFeedAdapter)localObject1).h();
        }
        localObject1 = this.x;
        int i4 = i1;
        if (localObject1 != null)
        {
          i4 = i1;
          if (((QCircleMessageNoticeBubbleBlock)localObject1).f()) {
            i4 = i1 - 1;
          }
        }
        localObject1 = new QCircleBaseTabFragment.PageCacheInfo(this.m.d(), i4, i2 - i3);
      }
    }
    return localObject1;
  }
  
  protected void b(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    Object localObject = this.m;
    if (localObject == null)
    {
      QLog.e(b(), 1, "handleEmptyRsp feed adapter is null!");
      return;
    }
    ((QCircleBaseFeedBlock)localObject).notifyLoadingComplete(true, paramUIStateData.h());
    if ((!M()) && (!ak()))
    {
      localObject = this.p;
      if (localObject != null) {
        ((QCircleStatusView)localObject).a();
      }
    }
    else
    {
      QLog.e(b(), 1, "hasFeedContents do nothing");
    }
    if ((paramUIStateData.i()) && (M())) {
      this.m.getLoadInfo().a(paramUIStateData.h());
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (Q()) {
      a(true);
    } else {
      a(paramBoolean);
    }
    S();
    T();
    QCircleAbsTabFeedViewModel localQCircleAbsTabFeedViewModel = this.n;
    if (localQCircleAbsTabFeedViewModel != null) {
      localQCircleAbsTabFeedViewModel.a(paramBoolean, this.y, R());
    }
  }
  
  public void beforeFinish()
  {
    super.beforeFinish();
    Y();
  }
  
  protected boolean bg_()
  {
    return this.g;
  }
  
  protected int c()
  {
    return 2131626832;
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
    localObject = this.m;
    if (localObject == null)
    {
      QLog.e(b(), 1, "handleErrorRsp feed adapter is null!");
      return;
    }
    ((QCircleBaseFeedBlock)localObject).notifyLoadingComplete(true, paramUIStateData.h());
    a(paramUIStateData.g(), str);
  }
  
  public void c(boolean paramBoolean)
  {
    this.F = paramBoolean;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    int i1;
    if (A() == 2)
    {
      i1 = 2;
    }
    else
    {
      this.k = new QCircleSharePartV2();
      this.k.a(n());
      localArrayList.add(this.k);
      this.l = new QCircleRichMediaDownLoadPart();
      localArrayList.add(this.l);
      i1 = 1;
    }
    this.j = new QCircleBaseTabFragment.4(this, 2131431490, C(), 3, i1);
    if (A() == 1) {
      this.j.b(true);
    }
    localArrayList.add(this.j);
    a(localArrayList);
    return localArrayList;
  }
  
  protected void d(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    if (this.m == null)
    {
      QLog.e(b(), 1, "handleNetSuccRsp feed adapter is null!");
      return;
    }
    if (paramUIStateData.c() == 2)
    {
      QLog.d(b(), 1, "load data from cache");
      X();
    }
    else
    {
      this.m.getLoadInfo().a(paramUIStateData.h());
      this.m.notifyLoadingComplete(true, paramUIStateData.h());
    }
    QCircleStatusView localQCircleStatusView = this.p;
    if (localQCircleStatusView != null) {
      localQCircleStatusView.c();
    }
    this.m.setDatas((ArrayList)paramUIStateData.e());
    if ((!paramUIStateData.i()) && (d.equals(N())))
    {
      paramUIStateData = this.m;
      if ((paramUIStateData instanceof QCircleInsFeedAdapter)) {
        ((QCircleInsFeedAdapter)paramUIStateData).e();
      }
    }
    H();
  }
  
  protected void e(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    QCircleBaseFeedBlock localQCircleBaseFeedBlock = this.m;
    if (localQCircleBaseFeedBlock == null)
    {
      QLog.e(b(), 1, "handlePageCacheRsp feed adapter is null!");
      return;
    }
    localQCircleBaseFeedBlock.notifyLoadingComplete(true, paramUIStateData.h());
    this.m.setDatas((ArrayList)paramUIStateData.e());
    if (d.equals(N()))
    {
      localQCircleBaseFeedBlock = this.m;
      if ((localQCircleBaseFeedBlock instanceof QCircleInsFeedAdapter)) {
        ((QCircleInsFeedAdapter)localQCircleBaseFeedBlock).e();
      }
    }
    this.m.getLoadInfo().a(paramUIStateData.h());
    int i1;
    if (this.t) {
      i1 = paramUIStateData.j() + 1;
    } else {
      i1 = paramUIStateData.j();
    }
    a(i1, paramUIStateData.k());
    H();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = super.getEventClass();
    localArrayList.add(QCircleFrameEvent.class);
    return localArrayList;
  }
  
  protected void l() {}
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    Z();
    if (aa()) {
      ae();
    }
    ad();
  }
  
  public boolean onBackEvent()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBackEvent");
    localStringBuilder.append(u());
    QLog.d(str, 1, localStringBuilder.toString());
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onDestroyView()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroyView");
    localStringBuilder.append(u());
    QLog.d(str, 1, localStringBuilder.toString());
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
    Object localObject = this.n;
    if (localObject != null)
    {
      ((QCircleAbsTabFeedViewModel)localObject).d().removeObservers(this);
      this.n = null;
    }
    localObject = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDetach()");
    localStringBuilder.append(u());
    QLog.d((String)localObject, 1, localStringBuilder.toString());
  }
  
  public void onPause()
  {
    super.onPause();
    if (getUserVisibleHint())
    {
      QCircleReportHelper localQCircleReportHelper = QCircleReportHelper.getInstance();
      int i1 = a();
      QCircleFolderFragmentsPart localQCircleFolderFragmentsPart = this.r;
      boolean bool;
      if ((localQCircleFolderFragmentsPart != null) && ((localQCircleFolderFragmentsPart.j() instanceof QCircleBaseFragment)) && (((QCircleBaseFragment)this.r.j()).g())) {
        bool = true;
      } else {
        bool = false;
      }
      localQCircleReportHelper.recordPageEndShow(i1, bool);
      QCircleFolderCacheHelper.a().c();
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
    if ((paramSimpleBaseEvent instanceof QCircleFrameEvent)) {
      a((QCircleFrameEvent)paramSimpleBaseEvent);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (getUserVisibleHint()) {
      QCircleReportHelper.getInstance().recordPageStartShow(a());
    }
    T();
    QLog.d(b(), 1, "init success on resume QCircleBaseTabFragment");
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      QCircleReportHelper.getInstance().pushPageScene(a());
      QCircleReportHelper.getInstance().recordPageStartShow(a());
    }
    else
    {
      QCircleReportHelper.getInstance().recordPageEndShow(a(), g());
      QCircleReportHelper.getInstance().popPageScene(a());
    }
    h();
  }
  
  public QCircleFolderTabView t()
  {
    QCircleFolderFragmentsPart localQCircleFolderFragmentsPart = this.r;
    if (localQCircleFolderFragmentsPart != null) {
      return localQCircleFolderFragmentsPart.b(this.h);
    }
    return null;
  }
  
  protected String u()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(N());
    localStringBuilder.append("_");
    localStringBuilder.append(this.h);
    return localStringBuilder.toString();
  }
  
  protected boolean v()
  {
    return false;
  }
  
  protected void w()
  {
    this.p = ((QCircleStatusView)this.j.bc_());
    this.p.setOnRetryClickListener(new QCircleBaseTabFragment.3(this));
  }
  
  protected boolean x()
  {
    return true;
  }
  
  protected String y()
  {
    return null;
  }
  
  protected boolean z()
  {
    FragmentActivity localFragmentActivity = getActivity();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localFragmentActivity != null)
    {
      bool1 = bool2;
      if (getActivity().findViewById(2131441747) != null)
      {
        bool1 = bool2;
        if (getActivity().findViewById(2131441747).getVisibility() == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment
 * JD-Core Version:    0.7.0.1
 */