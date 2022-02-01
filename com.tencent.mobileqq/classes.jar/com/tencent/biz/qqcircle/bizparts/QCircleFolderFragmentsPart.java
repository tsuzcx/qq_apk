package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.MutableLiveData;
import com.tencent.QCircleCollection;
import com.tencent.biz.qqcircle.QCircleGpsHelper;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.folder.QCircleFolderCacheHelper;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderFollowTabFragment;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderNearbyTabFragment;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderRcmdTabFragment;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.qqcircle.richframework.part.utils.ArrayUtils;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.OnTabSelectedListener;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.Tab;
import com.tencent.biz.qqcircle.richframework.widget.ViewPagerCompat;
import com.tencent.biz.qqcircle.viewmodels.QCircleTabViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleFolderTabView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qcircle.api.event.QCircleSelectTabEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class QCircleFolderFragmentsPart
  extends QCircleBasePart
  implements View.OnClickListener, TabLayoutCompat.OnTabSelectedListener, SimpleEventReceiver
{
  private TabLayoutCompat a;
  private ViewPagerCompat c;
  private QCircleFolderFragmentsPart.FolderTabFragmentAdapter d;
  private QCirclePolyLikeAniView e;
  private final ArrayList<QCircleFolderTabView> f = new ArrayList();
  private final ArrayList<String> g = new ArrayList();
  private final ArrayList<QCircleBaseTabFragment> h = new ArrayList();
  private QCircleStatusView i;
  private boolean j;
  private int k;
  private int l = 1;
  private int m = -1;
  private int n = 1;
  private int o = -1;
  private QCircleFolderBean p;
  private int q = 0;
  private QCircleTabViewModel r;
  
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
    if (!this.j)
    {
      this.j = true;
      return;
    }
    Object localObject = this.h;
    if ((localObject != null) && (((ArrayList)localObject).size() > paramInt1))
    {
      localObject = ((QCircleBaseTabFragment)this.h.get(paramInt1)).U();
      int i1;
      if (localObject != null) {
        i1 = ((QCircleTabInfo)localObject).a();
      } else {
        i1 = 0;
      }
      QLog.d("QCircleFolderFragmentsPart", 1, new Object[] { "[checkPageSelected] pos: ", Integer.valueOf(paramInt1), " | triggerCallback: ", Integer.valueOf(paramInt2), " | tabType: ", Integer.valueOf(i1) });
      if (paramInt2 == 1) {
        QCircleLpReportDc05504.report(a(i1, false));
      } else if (paramInt2 == 2) {
        QCircleLpReportDc05504.report(a(i1, true));
      }
    }
    this.j = false;
  }
  
  private void a(QCircleTabInfo paramQCircleTabInfo)
  {
    int i1 = paramQCircleTabInfo.a();
    boolean bool = true;
    Object localObject;
    if (i1 == 1)
    {
      localObject = new QCircleFolderFollowTabFragment(l());
    }
    else if (i1 == 6)
    {
      localObject = new QCircleFolderRcmdTabFragment(l());
    }
    else if (i1 == 4)
    {
      localObject = new QCircleFolderNearbyTabFragment(l());
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(94).setSubActionType(4));
    }
    else
    {
      localObject = null;
    }
    if (localObject != null)
    {
      if (i1 != this.n) {
        bool = false;
      }
      ((QCircleBaseTabFragment)localObject).c(bool);
      ((QCircleBaseTabFragment)localObject).a(paramQCircleTabInfo);
      ((QCircleBaseTabFragment)localObject).a(this.e);
      ((QCircleBaseTabFragment)localObject).a(this);
      this.h.add(localObject);
      this.g.add(paramQCircleTabInfo.b());
      return;
    }
    QLog.e("QCircleFolderFragmentsPart", 1, "addTab invalid input data!");
  }
  
  private void a(List<QQCircleFeedBase.StTabInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      QCircleStatusView localQCircleStatusView = this.i;
      if (localQCircleStatusView != null) {
        localQCircleStatusView.c();
      }
      QCirclePluginGlobalInfo.b(false);
      b(paramList);
      return;
    }
    QLog.e("QCircleFolderFragmentsPart", 1, "handleTabInfoRsp() return unexpected data！");
  }
  
  private void b(List<QQCircleFeedBase.StTabInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      p();
      c(paramList);
      d(paramList);
      q();
      return;
    }
    QLog.e("QCircleFolderFragmentsPart", 1, "initTabLayout invalid input data!");
  }
  
  private void c(int paramInt)
  {
    if (paramInt == 1)
    {
      this.l = 1;
      return;
    }
    if (paramInt == 6)
    {
      this.l = 3;
      return;
    }
    if (paramInt == 4) {
      this.l = 91;
    }
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
    this.d.notifyDataSetChanged();
  }
  
  private int l()
  {
    int i1 = this.q;
    this.q = (i1 + 1);
    return i1;
  }
  
  private void m()
  {
    if ((c() != null) && (c().getIntent() != null) && (c().getIntent().hasExtra("key_bundle_common_init_bean"))) {
      this.p = ((QCircleFolderBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean"));
    }
  }
  
  private void n()
  {
    if (!ArrayUtils.a(this.k, this.h)) {
      ((QCircleBaseTabFragment)this.h.get(this.k)).W();
    }
  }
  
  private void o()
  {
    QCircleCollection.a("initTab");
    this.r = ((QCircleTabViewModel)a(QCircleTabViewModel.class));
    this.r.b().observe(j(), new QCircleFolderFragmentsPart.3(this));
    QCirclePeriodCollect.record("request_tab");
    if (!this.r.c())
    {
      this.r.a(QCircleGpsHelper.a().e(), this.p);
      QLog.d("QCircleFolderFragmentsPart", 1, "initTabs without tab cache");
    }
    else
    {
      QLog.d("QCircleFolderFragmentsPart", 1, "initTabs with tab cache");
    }
    ViewCompat.setPaddingRelative(this.a, 0, 0, 0, 0);
  }
  
  private void p()
  {
    int i1 = this.m;
    if (i1 == -1) {
      this.n = QCirclePluginGlobalInfo.b();
    } else {
      this.n = i1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("firstShowTabType:");
    localStringBuilder.append(this.n);
    localStringBuilder.append(",mAssignShowTabType:");
    localStringBuilder.append(this.m);
    QLog.d("QCircleFolderFragmentsPart", 1, localStringBuilder.toString());
  }
  
  private void q()
  {
    c(this.n);
    a(this.n, false, false);
  }
  
  public String a()
  {
    return "QCircleFolderFragmentsPart";
  }
  
  public void a(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramInt < 0) {
      return;
    }
    int i1 = 0;
    while (i1 < this.h.size())
    {
      QCircleBaseTabFragment localQCircleBaseTabFragment = (QCircleBaseTabFragment)this.h.get(i1);
      if ((localQCircleBaseTabFragment != null) && (localQCircleBaseTabFragment.U() != null) && (paramInt == localQCircleBaseTabFragment.U().a()))
      {
        ViewPagerCompat localViewPagerCompat = this.c;
        if (localViewPagerCompat != null) {
          localViewPagerCompat.setCurrentItem(i1, paramBoolean1);
        }
        if (!paramBoolean2) {
          break;
        }
        localQCircleBaseTabFragment.V();
        return;
      }
      i1 += 1;
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView.findViewById(2131441718).setOnClickListener(this);
    paramView.findViewById(2131441587).setOnClickListener(this);
    this.a = ((TabLayoutCompat)paramView.findViewById(2131440974));
    this.a.setTabTextColors(-16777216, -16777216);
    this.a.setTabMode(1);
    this.a.setTabGravity(1);
    this.a.setSelectedTabIndicatorHeight(0);
    this.a.setViewPagerTabEventListener(new QCircleFolderFragmentsPart.1(this));
    this.c = ((ViewPagerCompat)paramView.findViewById(2131440979));
    this.d = new QCircleFolderFragmentsPart.FolderTabFragmentAdapter(this, j().getChildFragmentManager());
    this.c.setAdapter(this.d);
    this.c.setOffscreenPageLimit(3);
    this.a.setupWithViewPager(this.c);
    this.a.a(this);
    this.c.addOnPageChangeListener(new QCircleFolderFragmentsPart.2(this));
    this.e = ((QCirclePolyLikeAniView)paramView.findViewById(2131441777));
    this.i = ((QCircleStatusView)paramView.findViewById(2131441886));
    m();
    o();
  }
  
  public void a(TabLayoutCompat.Tab paramTab)
  {
    this.k = paramTab.c();
  }
  
  public boolean ah_()
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      QCircleBaseFragment localQCircleBaseFragment = (QCircleBaseFragment)localIterator.next();
      if (localQCircleBaseFragment != null) {
        localQCircleBaseFragment.onBackEvent();
      }
    }
    return super.ah_();
  }
  
  public QCircleFolderTabView b(int paramInt)
  {
    if (this.f.size() > paramInt) {
      return (QCircleFolderTabView)this.f.get(paramInt);
    }
    return null;
  }
  
  public Object b(String paramString, Object paramObject)
  {
    if ("get_current_page_index".equals(paramString))
    {
      ViewPagerCompat localViewPagerCompat = this.c;
      if (localViewPagerCompat != null)
      {
        int i1 = localViewPagerCompat.getCurrentItem();
        if (this.o != i1)
        {
          paramString = new StringBuilder();
          paramString.append("get current item:");
          paramString.append(i1);
          QLog.d("QCircleFolderFragmentsPart", 1, paramString.toString());
          this.o = i1;
        }
        return Integer.valueOf(i1);
      }
    }
    return super.b(paramString, paramObject);
  }
  
  public void b(TabLayoutCompat.Tab paramTab)
  {
    ((QCircleBaseTabFragment)this.h.get(paramTab.c())).F();
  }
  
  public void c(TabLayoutCompat.Tab paramTab)
  {
    int i1 = paramTab.c();
    int i2 = this.k;
    if (i1 == i2) {
      ((QCircleBaseTabFragment)this.h.get(i2)).W();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleSelectTabEvent.class);
    return localArrayList;
  }
  
  public int i()
  {
    return this.l;
  }
  
  public void k()
  {
    super.k();
    QCircleFolderCacheHelper.a().a(this.n);
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
    {
      QCircleBaseFragment localQCircleBaseFragment = (QCircleBaseFragment)localIterator.next();
      if (localQCircleBaseFragment != null) {
        localQCircleBaseFragment.beforeFinish();
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
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    if (this.h.size() > 0)
    {
      paramActivity = this.c;
      if (paramActivity != null) {
        ((QCircleBaseTabFragment)this.h.get(paramActivity.getCurrentItem())).onPause();
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    if (this.h.size() > 0)
    {
      paramActivity = this.c;
      if (paramActivity != null) {
        ((QCircleBaseTabFragment)this.h.get(paramActivity.getCurrentItem())).onResume();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((i1 == 2131441718) || (i1 == 2131441587)) {
      n();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleSelectTabEvent))
    {
      paramSimpleBaseEvent = (QCircleSelectTabEvent)paramSimpleBaseEvent;
      int i1 = paramSimpleBaseEvent.tabType;
      boolean bool = paramSimpleBaseEvent.needScrollTop;
      RFThreadManager.getUIHandler().post(new QCircleFolderFragmentsPart.4(this, i1, bool));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart
 * JD-Core Version:    0.7.0.1
 */