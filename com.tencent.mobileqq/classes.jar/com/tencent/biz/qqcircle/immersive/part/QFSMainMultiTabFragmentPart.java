package com.tencent.biz.qqcircle.immersive.part;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.QCircleGpsHelper;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.folder.QCircleFolderCacheHelper;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.adapter.QFSMultiTabFragmentAdapter;
import com.tencent.biz.qqcircle.immersive.bean.QFSLayerHeadViewRefreshInfo;
import com.tencent.biz.qqcircle.immersive.bean.QFSRecentlyFeedStateData;
import com.tencent.biz.qqcircle.immersive.events.QFSEnableSlideRightActionEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSPageSelectEvent;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSFolderIoc;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSTabFragmentIoc;
import com.tencent.biz.qqcircle.immersive.tab.QFSBaseTabFragment;
import com.tencent.biz.qqcircle.immersive.tab.QFSNearbyTabFragment;
import com.tencent.biz.qqcircle.immersive.views.QFSMultiTabView;
import com.tencent.biz.qqcircle.immersive.views.QFSViewPager;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat;
import com.tencent.biz.qqcircle.viewmodels.QCircleTabViewModel;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qcircle.api.event.QCircleFeedOptEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.winkpublish.event.PopBannerEvent;
import com.tencent.mobileqq.winkpublish.event.PublishUploadTaskResultEvent;
import com.tencent.mobileqq.winkpublish.event.QCirclePublishBoxStatusEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class QFSMainMultiTabFragmentPart
  extends QFSBasePart
  implements Observer<QFSRecentlyFeedStateData>, IQFSTabFragmentIoc, SimpleEventReceiver
{
  private static int m;
  private TabLayoutCompat a;
  private FrameLayout b;
  private QFSViewPager c;
  private QFSMultiTabFragmentAdapter d;
  private final ArrayList<QFSMultiTabView> e = new ArrayList();
  private final ArrayList<String> f = new ArrayList();
  private final ArrayList<QFSBaseTabFragment> g = new ArrayList();
  private QCircleTabViewModel h;
  private IQFSFolderIoc i;
  private int j;
  private int k = -1;
  private int l;
  private int n = 0;
  private boolean o = false;
  private FeedCloudMeta.StUser p;
  private ValueAnimator q;
  private FeedCloudMeta.StFeed r;
  private QCircleTabInfo s;
  private QFSBaseTabFragment t;
  private boolean u;
  private boolean v;
  private boolean w = false;
  private int x = 501;
  private boolean y;
  
  private QCircleLpReportDc05504.DataBuilder a(int paramInt, boolean paramBoolean)
  {
    QCircleLpReportDc05504.DataBuilder localDataBuilder = new QCircleLpReportDc05504.DataBuilder();
    int i1 = 2;
    if (paramInt == 1)
    {
      localDataBuilder.setActionType(22);
      if (!paramBoolean) {
        i1 = 3;
      }
      localDataBuilder.setSubActionType(i1);
      return localDataBuilder;
    }
    int i2 = 11;
    if (paramInt == 6)
    {
      localDataBuilder.setActionType(23);
      if (!paramBoolean) {
        i2 = 9;
      }
      localDataBuilder.setSubActionType(i2);
      return localDataBuilder;
    }
    if (paramInt == 4)
    {
      localDataBuilder.setActionType(94);
      if (!paramBoolean) {
        i1 = 3;
      }
      localDataBuilder.setSubActionType(i1);
      return localDataBuilder;
    }
    localDataBuilder.setActionType(22);
    if (!paramBoolean) {
      i2 = 9;
    }
    localDataBuilder.setSubActionType(i2);
    return localDataBuilder;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Object localObject = this.g;
    if ((localObject != null) && (((ArrayList)localObject).size() > paramInt1))
    {
      localObject = ((QFSBaseTabFragment)this.g.get(paramInt1)).W();
      int i1;
      if (localObject != null) {
        i1 = ((QCircleTabInfo)localObject).a();
      } else {
        i1 = 0;
      }
      QLog.d("QFSMainMultiTabFragmentPart", 1, new Object[] { "[checkPageSelected] pos: ", Integer.valueOf(paramInt1), " | triggerCallback: ", Integer.valueOf(paramInt2), " | tabType: ", Integer.valueOf(i1) });
      if (paramInt2 == 1)
      {
        QCircleLpReportDc05504.report(a(i1, false));
        return;
      }
      if (paramInt2 == 2) {
        QCircleLpReportDc05504.report(a(i1, true));
      }
    }
  }
  
  private void a(QCircleTabInfo paramQCircleTabInfo)
  {
    QFSBaseTabFragment localQFSBaseTabFragment = QFSBaseTabFragment.a(paramQCircleTabInfo, n());
    boolean bool = true;
    if (localQFSBaseTabFragment != null)
    {
      localQFSBaseTabFragment.a(this);
      if (this.k != paramQCircleTabInfo.a()) {
        bool = false;
      }
      localQFSBaseTabFragment.a(bool);
      this.g.add(localQFSBaseTabFragment);
      this.f.add(paramQCircleTabInfo.b());
      return;
    }
    QLog.e("QFSMainMultiTabFragmentPart", 1, "addTab invalid input data!");
  }
  
  private void a(ASEngineTabStatusEvent paramASEngineTabStatusEvent)
  {
    if (!paramASEngineTabStatusEvent.getBusinessKey().equals("qcircle-app")) {
      return;
    }
    if (paramASEngineTabStatusEvent.isSelected())
    {
      QLog.d("QFSMainMultiTabFragmentPart", 1, "receive onTab selected event");
      b(this.l);
    }
    b(paramASEngineTabStatusEvent);
  }
  
  private void a(PublishUploadTaskResultEvent paramPublishUploadTaskResultEvent)
  {
    int i1;
    if (((QFSBaseTabFragment)this.g.get(this.l)).W() != null) {
      i1 = ((QFSBaseTabFragment)this.g.get(this.l)).W().a.tabType.get();
    } else {
      i1 = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFSMainMultiTabFragmentPart", 1, new Object[] { "handlePublishEvent curTabType:", Integer.valueOf(i1) });
    }
    SimpleEventBus.getInstance().dispatchEvent(new PopBannerEvent(paramPublishUploadTaskResultEvent.getMissionId(), paramPublishUploadTaskResultEvent.isUploadSuccess(), i1, paramPublishUploadTaskResultEvent.getClientKey(), paramPublishUploadTaskResultEvent.getUploadCoverUrl(), paramPublishUploadTaskResultEvent.getFeedId(), paramPublishUploadTaskResultEvent.getCreateTime()));
  }
  
  private void a(List<QQCircleFeedBase.StTabInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      QCirclePluginGlobalInfo.b(false);
      b(paramList);
      return;
    }
    QLog.e("QFSMainMultiTabFragmentPart", 1, "handleTabInfoRsp() return unexpected data！");
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    QFSViewPager localQFSViewPager = this.c;
    if (localQFSViewPager != null)
    {
      this.v = true;
      localQFSViewPager.setCurrentItem(paramInt, paramBoolean);
    }
  }
  
  private void a(boolean paramBoolean, QFSBaseTabFragment paramQFSBaseTabFragment)
  {
    if (paramBoolean) {
      paramQFSBaseTabFragment.L();
    }
  }
  
  private void a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      if (!(paramVarArgs[0] instanceof Boolean)) {
        return;
      }
      this.y = ((Boolean)paramVarArgs[0]).booleanValue();
      QFSViewPager localQFSViewPager = this.c;
      if (localQFSViewPager != null) {
        localQFSViewPager.setScrollable(((Boolean)paramVarArgs[0]).booleanValue());
      }
      int i1 = 0;
      while (i1 < this.g.size())
      {
        ((QFSBaseTabFragment)this.g.get(i1)).a((Boolean)paramVarArgs[0]);
        i1 += 1;
      }
    }
  }
  
  private boolean a(int paramInt, QFSBaseTabFragment paramQFSBaseTabFragment)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQFSBaseTabFragment != null)
    {
      if (paramQFSBaseTabFragment.W() == null) {
        return false;
      }
      bool1 = bool2;
      if (paramInt == paramQFSBaseTabFragment.W().a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean a(QFSBaseTabFragment paramQFSBaseTabFragment, QCircleTabInfo paramQCircleTabInfo)
  {
    if ((paramQCircleTabInfo != null) && (paramQFSBaseTabFragment != null))
    {
      paramQFSBaseTabFragment.X();
      return paramQFSBaseTabFragment.Z();
    }
    return false;
  }
  
  private void b(View paramView)
  {
    this.b = ((FrameLayout)paramView.findViewById(2131433861));
    this.a = ((TabLayoutCompat)paramView.findViewById(2131433858));
    this.a.setTabTextColors(-16777216, -16777216);
    this.a.setTabMode(1);
    this.a.setTabGravity(1);
    this.a.setSelectedTabIndicatorHeight(0);
    this.a.setupWithViewPager(this.c);
    this.a.setViewPagerTabEventListener(new QFSMainMultiTabFragmentPart.1(this));
    o();
  }
  
  private void b(ASEngineTabStatusEvent paramASEngineTabStatusEvent)
  {
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    int i1 = ((QFSViewPager)localObject).getCurrentItem();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fs_lifecycle dtReportPageRegisterWhenTabStatusChange  mMultiViewPagerIndex = ");
    ((StringBuilder)localObject).append(i1);
    QLog.d("QFSMainMultiTabFragmentPart", 1, ((StringBuilder)localObject).toString());
    if (paramASEngineTabStatusEvent.isSelected())
    {
      if ((this.g.size() > i1) && (i1 >= 0)) {
        ((QFSBaseTabFragment)this.g.get(i1)).h();
      }
    }
    else if ((this.g.size() > i1) && (i1 >= 0)) {
      ((QFSBaseTabFragment)this.g.get(i1)).i();
    }
  }
  
  private void b(List<QQCircleFeedBase.StTabInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      x();
      c(paramList);
      d(paramList);
      y();
      return;
    }
    QLog.e("QFSMainMultiTabFragmentPart", 1, "initTabLayout invalid input data!");
  }
  
  private void b(Object... paramVarArgs)
  {
    if ((this.b != null) && (paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      if (!(paramVarArgs[0] instanceof QFSLayerHeadViewRefreshInfo)) {
        return;
      }
      paramVarArgs = (QFSLayerHeadViewRefreshInfo)paramVarArgs[0];
      int i1 = paramVarArgs.a();
      if (i1 == 3)
      {
        this.b.setAlpha(1.0F - paramVarArgs.b());
        this.b.setTranslationY(this.a.getHeight() * paramVarArgs.b());
        return;
      }
      if (i1 == 2)
      {
        d(200);
        QFSMessageNoticePart.e();
      }
    }
  }
  
  private boolean b(QFSBaseTabFragment paramQFSBaseTabFragment, QCircleTabInfo paramQCircleTabInfo)
  {
    if (paramQCircleTabInfo != null)
    {
      if (paramQFSBaseTabFragment == null) {
        return false;
      }
      if ((paramQFSBaseTabFragment instanceof QFSNearbyTabFragment)) {
        return QCirclePluginConfig.a().E();
      }
    }
    return false;
  }
  
  private void c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fs_lifecycle onPageSelected  mMultiViewPager pos = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" , mLastPageSelectPosition = ");
    localStringBuilder.append(this.j);
    QLog.i("QFSMainMultiTabFragmentPart", 1, localStringBuilder.toString());
    if (this.g == null) {
      return;
    }
    this.l = paramInt;
    p();
    int i1 = 0;
    while (i1 < this.g.size())
    {
      if (i1 == paramInt) {
        ((QFSBaseTabFragment)this.g.get(i1)).onResume();
      } else if (i1 == this.j) {
        ((QFSBaseTabFragment)this.g.get(i1)).onStop();
      }
      i1 += 1;
    }
    this.j = paramInt;
    boolean bool;
    if (paramInt == this.g.size() - 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.o = bool;
    d(0);
    SimpleEventBus.getInstance().dispatchEvent(new QFSPageSelectEvent(paramInt));
    this.u = true;
  }
  
  private void c(List<QQCircleFeedBase.StTabInfo> paramList)
  {
    if (paramList.size() > 4)
    {
      this.a.setTabMode(0);
      this.a.setTabGravity(1);
      this.a.setScrollableTabMinWidth(-2);
      return;
    }
    this.a.setTabMode(1);
    this.a.setTabGravity(1);
  }
  
  public static String d()
  {
    int i2 = m;
    int i1 = 3;
    if (i2 != 1)
    {
      if (i2 != 3) {
        if (i2 != 6) {
          i1 = -1;
        } else {
          i1 = 2;
        }
      }
    }
    else {
      i1 = 1;
    }
    return String.valueOf(i1);
  }
  
  private void d(int paramInt)
  {
    RFThreadManager.getUIHandler().postDelayed(new QFSMainMultiTabFragmentPart.10(this), paramInt);
  }
  
  private void d(View paramView)
  {
    this.d = new QFSMultiTabFragmentAdapter(m().getChildFragmentManager());
    this.c = ((QFSViewPager)paramView.findViewById(2131433862));
    this.c.setAdapter(this.d);
    this.c.setOffscreenPageLimit(3);
    q();
    r();
  }
  
  private void d(List<QQCircleFeedBase.StTabInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QQCircleFeedBase.StTabInfo localStTabInfo = (QQCircleFeedBase.StTabInfo)paramList.next();
      if (localStTabInfo != null) {
        a(QCircleTabInfo.a(localStTabInfo));
      }
    }
    this.a.setVisibility(0);
    this.d.a(this.g);
    this.d.b(this.f);
    this.d.notifyDataSetChanged();
  }
  
  private void e(int paramInt)
  {
    if (paramInt == 1) {
      this.x = 501;
    } else if (paramInt == 6) {
      this.x = 503;
    } else if (paramInt == 4) {
      this.x = 591;
    }
    c("tab_changed_new_layer", Integer.valueOf(paramInt));
  }
  
  private int n()
  {
    int i1 = this.n;
    this.n = (i1 + 1);
    return i1;
  }
  
  private void o()
  {
    this.a.a(new QFSMainMultiTabFragmentPart.2(this));
  }
  
  private void p()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      this.t = ((QFSBaseTabFragment)((QFSMultiTabFragmentAdapter)localObject).getItem(this.l));
      this.s = this.t.W();
      localObject = this.s;
      if (localObject != null)
      {
        m = ((QCircleTabInfo)localObject).a();
        e(m);
      }
    }
  }
  
  private void q()
  {
    this.c.addOnPageChangeListener(new QFSMainMultiTabFragmentPart.3(this));
  }
  
  private void r()
  {
    if (!QCircleHostGlobalInfo.isCurrentTabActive()) {
      return;
    }
    this.c.a(new QFSMainMultiTabFragmentPart.4(this));
  }
  
  private void s()
  {
    QCircleInitBean localQCircleInitBean = new QCircleInitBean();
    localQCircleInitBean.setFeed(this.r);
    localQCircleInitBean.setUser(this.p);
    localQCircleInitBean.setFromReportBean(l().clone());
    QCircleLauncher.b(g(), localQCircleInitBean);
  }
  
  private void t() {}
  
  private void u()
  {
    if (c() == null) {
      return;
    }
    Object localObject = c().getIntent();
    if (localObject != null)
    {
      if (!((Intent)localObject).hasExtra("key_bundle_common_init_bean")) {
        return;
      }
      localObject = ((Intent)localObject).getSerializableExtra("key_bundle_common_init_bean");
      if (!(localObject instanceof QCircleFolderBean)) {
        return;
      }
      this.k = ((QCircleFolderBean)localObject).getAssignShowTabType();
    }
  }
  
  private void v()
  {
    QCircleGpsHelper.a().c();
    this.h = ((QCircleTabViewModel)a(QCircleTabViewModel.class));
    this.h.b().observe(m(), new QFSMainMultiTabFragmentPart.5(this));
    QCirclePeriodCollect.record("request_tab");
    if (!this.h.c()) {
      this.h.a(QCircleGpsHelper.a().e(), new QCircleFolderBean((QCircleReportBean)D()));
    } else {
      QLog.e("QFSMainMultiTabFragmentPart", 1, "initTabs from cache");
    }
    ViewCompat.setPaddingRelative(this.a, 0, 0, 0, 0);
  }
  
  private void w()
  {
    QCircleFeedDataCenter.a().a(this);
  }
  
  private void x()
  {
    if (this.k == -1) {
      this.k = QCirclePluginGlobalInfo.b();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("firstShowTabSourceType:");
    localStringBuilder.append(this.k);
    QLog.d("QFSMainMultiTabFragmentPart", 1, localStringBuilder.toString());
  }
  
  private void y()
  {
    int i1 = this.k;
    if (i1 == -1) {
      return;
    }
    e(i1);
    a(this.k, false, false);
  }
  
  private void z()
  {
    QFSBaseTabFragment localQFSBaseTabFragment = this.t;
    if (localQFSBaseTabFragment != null) {
      localQFSBaseTabFragment.Y();
    }
  }
  
  public QFSMultiTabView a(int paramInt)
  {
    ArrayList localArrayList = this.e;
    if ((localArrayList != null) && (localArrayList.size() > paramInt)) {
      return (QFSMultiTabView)this.e.get(paramInt);
    }
    return null;
  }
  
  public String a()
  {
    return "QFSMainMultiTabFragmentPart";
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt < 0) {
      return;
    }
    int i1 = 0;
    while (i1 < this.g.size())
    {
      QFSBaseTabFragment localQFSBaseTabFragment = (QFSBaseTabFragment)this.g.get(i1);
      if (a(paramInt, localQFSBaseTabFragment))
      {
        a(paramBoolean1, i1);
        a(paramBoolean2, localQFSBaseTabFragment);
        return;
      }
      i1 += 1;
    }
  }
  
  public void a(View paramView)
  {
    d(paramView);
    b(paramView);
    t();
    u();
    v();
    w();
  }
  
  public void a(QFSRecentlyFeedStateData paramQFSRecentlyFeedStateData)
  {
    if (paramQFSRecentlyFeedStateData != null)
    {
      this.p = ((FeedCloudMeta.StUser)paramQFSRecentlyFeedStateData.b.get());
      this.r = ((FeedCloudMeta.StFeed)paramQFSRecentlyFeedStateData.a.get());
    }
  }
  
  public void a(IQFSFolderIoc paramIQFSFolderIoc)
  {
    this.i = paramIQFSFolderIoc;
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    IQFSFolderIoc localIQFSFolderIoc = this.i;
    if (localIQFSFolderIoc != null) {
      localIQFSFolderIoc.a(paramString, paramVarArgs);
    }
    if (TextUtils.equals(paramString, "event_open_comment"))
    {
      c("comment_panel_show", paramVarArgs[0]);
      return;
    }
    if (TextUtils.equals(paramString, "event_hide_comment"))
    {
      c("comment_panel_dismiss", null);
      return;
    }
    if (TextUtils.equals(paramString, "event_open_comment_input"))
    {
      c("comment_input_window_show", null);
      return;
    }
    if (TextUtils.equals(paramString, "event_open_share"))
    {
      c("share_action_show_share_sheet", paramVarArgs[0]);
      return;
    }
    if (TextUtils.equals(paramString, "event_set_viewpager_enable"))
    {
      a(paramVarArgs);
      return;
    }
    if (TextUtils.equals(paramString, "event_layer_head_view_refresh_status"))
    {
      b(paramVarArgs);
      return;
    }
    if (TextUtils.equals(paramString, "event_open_friend_push_panel")) {
      c("light_interact_list_show", paramVarArgs[0]);
    }
  }
  
  public boolean ah_()
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      QFSBaseFragment localQFSBaseFragment = (QFSBaseFragment)localIterator.next();
      if (localQFSBaseFragment != null) {
        localQFSBaseFragment.onBackEvent();
      }
    }
    return false;
  }
  
  public Object b(String paramString, Object paramObject)
  {
    return super.b(paramString, paramObject);
  }
  
  public void b(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.g.size())
    {
      QFSMultiTabView localQFSMultiTabView = a(i1);
      QCircleTabInfo localQCircleTabInfo = ((QFSBaseTabFragment)this.g.get(i1)).W();
      if ((localQFSMultiTabView != null) && (localQCircleTabInfo != null) && (localQCircleTabInfo.a != null))
      {
        boolean bool = a((QFSBaseTabFragment)this.g.get(i1), localQCircleTabInfo);
        if ((bool) && (localQCircleTabInfo.a() == 1)) {
          ((QFSBaseTabFragment)this.g.get(i1)).bm_();
        }
        if (i1 == paramInt)
        {
          localQFSMultiTabView.c();
          localQFSMultiTabView.e();
          z();
        }
        else
        {
          if (bool) {
            localQFSMultiTabView.b();
          }
          if (b((QFSBaseTabFragment)this.g.get(i1), localQCircleTabInfo)) {
            localQFSMultiTabView.d();
          }
        }
      }
      i1 += 1;
    }
  }
  
  public int bl_()
  {
    Object localObject = this.i;
    if ((localObject != null) && (((IQFSFolderIoc)localObject).f() != 0)) {
      return -1;
    }
    localObject = this.c;
    if (localObject != null) {
      return ((QFSViewPager)localObject).getCurrentItem();
    }
    return -1;
  }
  
  public int e()
  {
    return this.x;
  }
  
  public int f()
  {
    IQFSFolderIoc localIQFSFolderIoc = this.i;
    if (localIQFSFolderIoc == null) {
      return -1;
    }
    return localIQFSFolderIoc.f();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QFSLayerHeadViewRefreshInfo.class);
    localArrayList.add(QCirclePublishBoxStatusEvent.class);
    localArrayList.add(QFSEnableSlideRightActionEvent.class);
    localArrayList.add(QCircleSelectTabEvent.class);
    localArrayList.add(PublishUploadTaskResultEvent.class);
    localArrayList.add(QCircleFeedOptEvent.class);
    localArrayList.add(ASEngineTabStatusEvent.class);
    return localArrayList;
  }
  
  public void k()
  {
    super.k();
    if (this.s != null) {
      QCircleFolderCacheHelper.a().a(this.s.a());
    }
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
    {
      QFSBaseFragment localQFSBaseFragment = (QFSBaseFragment)localIterator.next();
      if (localQFSBaseFragment != null) {
        localQFSBaseFragment.beforeFinish();
      }
    }
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    paramActivity = this.q;
    if (paramActivity != null)
    {
      paramActivity.removeAllUpdateListeners();
      this.q.cancel();
      this.q = null;
    }
    if (this.g == null) {
      return;
    }
    QLog.d("QFSMainMultiTabFragmentPart", 1, "fs_lifecycle onActivityDestroyed");
    paramActivity = this.g.iterator();
    while (paramActivity.hasNext()) {
      ((QFSBaseTabFragment)paramActivity.next()).onDestroy();
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    paramActivity = this.c;
    if (paramActivity != null)
    {
      if (this.g == null) {
        return;
      }
      int i1 = paramActivity.getCurrentItem();
      paramActivity = new StringBuilder();
      paramActivity.append("fs_lifecycle onActivityPaused  mMultiViewPagerIndex = ");
      paramActivity.append(i1);
      QLog.d("QFSMainMultiTabFragmentPart", 1, paramActivity.toString());
      if (this.g.size() > i1) {
        ((QFSBaseTabFragment)this.g.get(i1)).onPause();
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    paramActivity = this.c;
    if (paramActivity != null)
    {
      if (this.g == null) {
        return;
      }
      int i1 = paramActivity.getCurrentItem();
      paramActivity = new StringBuilder();
      paramActivity.append("fs_lifecycle onActivityResumed  mMultiViewPagerIndex = ");
      paramActivity.append(i1);
      QLog.d("QFSMainMultiTabFragmentPart", 1, paramActivity.toString());
      if ((this.g.size() > i1) && (i1 >= 0)) {
        ((QFSBaseTabFragment)this.g.get(i1)).onResume();
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    super.onActivityStopped(paramActivity);
    super.onActivityPaused(paramActivity);
    paramActivity = this.c;
    if (paramActivity != null)
    {
      if (this.g == null) {
        return;
      }
      int i1 = paramActivity.getCurrentItem();
      paramActivity = new StringBuilder();
      paramActivity.append("fs_lifecycle onActivityStopped  mMultiViewPagerIndex = ");
      paramActivity.append(i1);
      QLog.d("QFSMainMultiTabFragmentPart", 1, paramActivity.toString());
      if (this.g.size() > i1) {
        ((QFSBaseTabFragment)this.g.get(i1)).onStop();
      }
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCirclePublishBoxStatusEvent))
    {
      paramSimpleBaseEvent = (QCirclePublishBoxStatusEvent)paramSimpleBaseEvent;
      if ((paramSimpleBaseEvent.taskCount > 0) && (!this.w))
      {
        G().post(new QFSMainMultiTabFragmentPart.6(this));
        this.w = true;
      }
      if ((paramSimpleBaseEvent.taskCount <= 0) && (this.w))
      {
        this.w = false;
        G().post(new QFSMainMultiTabFragmentPart.7(this));
      }
    }
    else if ((paramSimpleBaseEvent instanceof QFSEnableSlideRightActionEvent))
    {
      paramSimpleBaseEvent = (QFSEnableSlideRightActionEvent)paramSimpleBaseEvent;
      QFSViewPager localQFSViewPager = this.c;
      if (localQFSViewPager != null) {
        localQFSViewPager.setEnableSlideRightAction(paramSimpleBaseEvent.isEnable());
      }
    }
    else
    {
      if ((paramSimpleBaseEvent instanceof PublishUploadTaskResultEvent))
      {
        G().post(new QFSMainMultiTabFragmentPart.8(this, paramSimpleBaseEvent));
        return;
      }
      if ((paramSimpleBaseEvent instanceof QCircleSelectTabEvent))
      {
        paramSimpleBaseEvent = (QCircleSelectTabEvent)paramSimpleBaseEvent;
        int i1 = paramSimpleBaseEvent.tabType;
        boolean bool = paramSimpleBaseEvent.needScrollTop;
        G().post(new QFSMainMultiTabFragmentPart.9(this, i1, bool));
        return;
      }
      if ((paramSimpleBaseEvent instanceof ASEngineTabStatusEvent)) {
        a((ASEngineTabStatusEvent)paramSimpleBaseEvent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSMainMultiTabFragmentPart
 * JD-Core Version:    0.7.0.1
 */