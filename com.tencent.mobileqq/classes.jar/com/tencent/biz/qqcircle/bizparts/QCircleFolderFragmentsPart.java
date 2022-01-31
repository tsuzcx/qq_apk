package com.tencent.biz.qqcircle.bizparts;

import alud;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.qqcircle.events.QCircleSelectTabEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.fragments.QCircleFolderFollowTabFragment;
import com.tencent.biz.qqcircle.fragments.QCircleFolderRcmdTabFragment;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import qqcircle.QQCircleFeedBase.StTabInfo;
import skj;
import sko;
import tqj;
import tsa;
import tsg;
import tsh;
import tsi;
import tsj;
import tuz;
import tvv;
import twl;
import tzv;
import ubv;
import ubz;
import yiw;
import yiy;
import ykb;

public class QCircleFolderFragmentsPart
  extends tvv
  implements skj, yiy
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 300L;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private TabLayoutCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat;
  private ViewPagerCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat;
  private QCircleFolderFragmentsPart.FolderTabFragmentAdapter jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter;
  private QCirclePolymorphicAniView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView;
  private QCircleStatusView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private tuz jdField_a_of_type_Tuz;
  private ubv jdField_a_of_type_Ubv;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ArrayList<QCircleBaseTabFragment> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  
  private void a()
  {
    this.jdField_a_of_type_Ubv = ((ubv)a(ubv.class));
    this.jdField_a_of_type_Ubv.a().observe(a(), new tsi(this));
    if (!this.jdField_a_of_type_Ubv.a())
    {
      QLog.d("QCircleFolderCacheHelper", 4, "initTabs without tab cache");
      if (ykb.a("2002"))
      {
        QLog.i("QCircleFolderFragmentsPart", 1, "runPreload");
        ykb.a("2002", new tsj(this));
        return;
      }
      this.jdField_a_of_type_Ubv.a(tqj.a().a());
      return;
    }
    QLog.d("QCircleFolderCacheHelper", 4, "initTabs with tab cache");
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i = 23;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > paramInt1))
    {
      tsa localtsa = ((QCircleBaseTabFragment)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt1)).a();
      if (localtsa == null) {
        break label160;
      }
      if (localtsa.a() != 1) {
        break label98;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt2 == 1) {
        if (paramInt1 != 0)
        {
          if (paramInt1 == 0) {
            break label109;
          }
          l = 3L;
          tzv.a("", i, l);
        }
      }
      label98:
      label109:
      while (paramInt2 != 2) {
        for (;;)
        {
          this.jdField_a_of_type_Boolean = false;
          return;
          paramInt1 = 0;
          break;
          i = 22;
          continue;
          l = 9L;
        }
      }
      if (paramInt1 != 0) {
        label126:
        if (paramInt1 == 0) {
          break label152;
        }
      }
      label152:
      for (long l = 2L;; l = 11L)
      {
        tzv.a("", i, l);
        break;
        i = 22;
        break label126;
      }
      label160:
      paramInt1 = 0;
    }
  }
  
  private void a(List<QQCircleFeedBase.StTabInfo> paramList, boolean paramBoolean)
  {
    QLog.d("QCircleFolderFragmentsPart", 1, "initTabDatasFromServer isFromCache:" + paramBoolean);
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("QCircleFolderFragmentsPart", 1, "initTabDatasFromServer invalid input data!");
      return;
    }
    if (paramList.size() > 4)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabMode(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabGravity(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setScrollableTabMinWidth(-2);
      if (this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) {
        break label158;
      }
      if (!a(paramList))
      {
        QLog.d("QCircleFolderFragmentsPart", 1, "tryReuseFragment failed!refresh all!");
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        a(paramList, paramBoolean);
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Int, false, false);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabGravity(1);
      break;
      label158:
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QQCircleFeedBase.StTabInfo localStTabInfo = (QQCircleFeedBase.StTabInfo)paramList.next();
        if (localStTabInfo != null) {
          a(tsa.a(localStTabInfo).a(paramBoolean));
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter.notifyDataSetChanged();
    }
  }
  
  private void a(tsa paramtsa)
  {
    Object localObject = null;
    switch (paramtsa.a())
    {
    }
    while (localObject != null)
    {
      ((QCircleBaseTabFragment)localObject).a(paramtsa);
      ((QCircleBaseTabFragment)localObject).a(this.jdField_a_of_type_Tuz, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView);
      ((QCircleBaseTabFragment)localObject).a(this);
      this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramtsa.a());
      return;
      localObject = new QCircleFolderFollowTabFragment();
      continue;
      localObject = new QCircleFolderRcmdTabFragment();
    }
    QLog.e("QCircleFolderFragmentsPart", 1, "addTab invalid input data!");
  }
  
  private void a(ubz<List<QQCircleFeedBase.StTabInfo>> paramubz)
  {
    boolean bool = true;
    if (paramubz == null) {
      QLog.e("QCircleFolderFragmentsPart", 1, "handleTabDataRsp() return unexpected data！");
    }
    do
    {
      return;
      switch (paramubz.a())
      {
      case 1: 
      default: 
        return;
      case 0: 
        QLog.e("QCircleFolderFragmentsPart", 1, "handleTabDataRsp() return empty data!");
      }
    } while ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.size() != 0) || (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView == null));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.c(null);
    return;
    if (paramubz.a() == null) {}
    for (paramubz = alud.a(2131720478);; paramubz = paramubz.a())
    {
      QLog.e("QCircleFolderFragmentsPart", 1, "handleTabDataRsp() return error！errMsg:" + paramubz);
      if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.size() != 0)) {
        break label193;
      }
      QQToast.a(BaseApplicationImpl.getContext(), 1, paramubz, 1).a();
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.c(paramubz);
      return;
    }
    label193:
    QQToast.a(BaseApplicationImpl.getContext(), 1, paramubz, 1).a();
    return;
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.c();
    }
    List localList = (List)paramubz.a();
    if (paramubz.a() == 2) {}
    for (;;)
    {
      a(localList, bool);
      return;
      bool = false;
    }
  }
  
  private boolean a(List<QQCircleFeedBase.StTabInfo> paramList)
  {
    try
    {
      if ((QzoneConfig.getQQCircleEnableReuseFragment()) && (paramList.size() == this.jdField_b_of_type_JavaUtilArrayList.size()) && (paramList.size() == this.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        int i = 0;
        while (i < paramList.size())
        {
          QQCircleFeedBase.StTabInfo localStTabInfo = (QQCircleFeedBase.StTabInfo)paramList.get(i);
          QCircleBaseTabFragment localQCircleBaseTabFragment = (QCircleBaseTabFragment)this.jdField_b_of_type_JavaUtilArrayList.get(i);
          if (!((String)this.jdField_a_of_type_JavaUtilArrayList.get(i)).equals(localStTabInfo.tabName.get())) {
            return false;
          }
          if (localStTabInfo.tabType.get() != localQCircleBaseTabFragment.a().a.tabType.get()) {
            return false;
          }
          localQCircleBaseTabFragment.b(tsa.a(localStTabInfo).a(false));
          i += 1;
        }
        QLog.d("QCircleFolderFragmentsPart", 1, "tryReuseFragment success!");
        return true;
      }
      return false;
    }
    catch (Exception paramList) {}
    return false;
  }
  
  public String a()
  {
    return "QCircleFolderFragmentsPart";
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramInt > 0) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        QCircleBaseTabFragment localQCircleBaseTabFragment = (QCircleBaseTabFragment)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        if ((localQCircleBaseTabFragment == null) || (localQCircleBaseTabFragment.a() == null) || (paramInt != localQCircleBaseTabFragment.a().a()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat == null)) {
          break label85;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setCurrentItem(i, paramBoolean1);
        if (paramBoolean2) {
          localQCircleBaseTabFragment.h();
        }
      }
      return;
      label85:
      i += 1;
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat = ((TabLayoutCompat)paramView.findViewById(2131372555));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabTextColors(-16777216, -16777216);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabMode(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabGravity(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorHeight(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setViewPagerTabEventListener(new tsg(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = ((ViewPagerCompat)paramView.findViewById(2131372560));
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter = new QCircleFolderFragmentsPart.FolderTabFragmentAdapter(this, ((FragmentActivity)a()).getSupportFragmentManager());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setAdapter(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setOffscreenPageLimit(3);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setupWithViewPager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.a(new tsh(this));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131373154));
    this.jdField_a_of_type_Tuz = new tuz(a());
    this.jdField_a_of_type_Tuz.a(a(), this.jdField_a_of_type_AndroidViewViewStub);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView = ((QCirclePolymorphicAniView)paramView.findViewById(2131373208));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView = ((QCircleStatusView)paramView.findViewById(2131373242));
    a();
    ViewCompat.setPaddingRelative(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat, 0, 0, 0, 0);
  }
  
  public void a(sko paramsko)
  {
    this.jdField_b_of_type_Int = paramsko.a();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Tuz != null) && (this.jdField_a_of_type_Tuz.a())) {
      return true;
    }
    return super.a();
  }
  
  public void b(sko paramsko)
  {
    ((QCircleBaseTabFragment)this.jdField_b_of_type_JavaUtilArrayList.get(paramsko.a())).c();
  }
  
  public void c(sko paramsko)
  {
    if (paramsko.a() == this.jdField_b_of_type_Int) {
      ((QCircleBaseTabFragment)this.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)).i();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleSelectTabEvent.class);
    return localArrayList;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    yiw.a().a(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    twl.a().a(this.jdField_a_of_type_Ubv);
    yiw.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleSelectTabEvent))
    {
      int i = ((QCircleSelectTabEvent)paramSimpleBaseEvent).tabType;
      boolean bool = ((QCircleSelectTabEvent)paramSimpleBaseEvent).needScrollTop;
      ThreadManager.getUIHandler().post(new QCircleFolderFragmentsPart.5(this, i, bool));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart
 * JD-Core Version:    0.7.0.1
 */