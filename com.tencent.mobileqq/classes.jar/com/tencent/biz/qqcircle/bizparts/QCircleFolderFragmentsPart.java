package com.tencent.biz.qqcircle.bizparts;

import aaak;
import aaam;
import aadg;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.view.View;
import anzj;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.qqcircle.events.QCircleSelectTabEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderFollowTabFragment;
import com.tencent.biz.qqcircle.fragments.main.QCircleFolderRcmdTabFragment;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import qqcircle.QQCircleFeedBase.StTabInfo;
import szu;
import szz;
import uyn;
import uyq;
import vbe;
import vbk;
import vcw;
import vcx;
import vcy;
import vcz;
import vle;
import vtq;
import vws;
import vxm;
import vxq;
import vzy;

public class QCircleFolderFragmentsPart
  extends vbk
  implements aaam, szu
{
  private int jdField_a_of_type_Int;
  private TabLayoutCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat;
  private ViewPagerCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat;
  private QCircleFolderFragmentsPart.FolderTabFragmentAdapter jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter;
  private QCirclePolyLikeAniView jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView;
  private QCircleStatusView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView;
  private vxm jdField_a_of_type_Vxm;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 1;
  private ArrayList<vzy> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_c_of_type_Int = -1;
  private ArrayList<String> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_d_of_type_Int = 1;
  private ArrayList<QCircleBaseTabFragment> jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  
  private void a()
  {
    this.jdField_a_of_type_Vxm = ((vxm)a(vxm.class));
    this.jdField_a_of_type_Vxm.a().observe(a(), new vcy(this));
    if (!this.jdField_a_of_type_Vxm.a()) {
      b();
    }
    for (;;)
    {
      ViewCompat.setPaddingRelative(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat, 0, 0, 0, 0);
      return;
      QLog.d("QCircleFolderCacheHelper", 1, "initTabs with tab cache");
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i = 23;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    if ((this.jdField_d_of_type_JavaUtilArrayList != null) && (this.jdField_d_of_type_JavaUtilArrayList.size() > paramInt1))
    {
      vbe localvbe = ((QCircleBaseTabFragment)this.jdField_d_of_type_JavaUtilArrayList.get(paramInt1)).a();
      if (localvbe == null) {
        break label153;
      }
      if (localvbe.a() != 1) {
        break label96;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt2 == 1) {
        if (paramInt1 != 0)
        {
          paramInt2 = i;
          if (paramInt1 == 0) {
            break label107;
          }
          paramInt1 = 3;
          vtq.a("", paramInt2, paramInt1);
        }
      }
      label96:
      label107:
      while (paramInt2 != 2) {
        for (;;)
        {
          this.jdField_a_of_type_Boolean = false;
          return;
          paramInt1 = 0;
          break;
          paramInt2 = 22;
          continue;
          paramInt1 = 9;
        }
      }
      if (paramInt1 != 0)
      {
        paramInt2 = 23;
        label125:
        if (paramInt1 == 0) {
          break label147;
        }
      }
      label147:
      for (paramInt1 = 2;; paramInt1 = 11)
      {
        vtq.a("", paramInt2, paramInt1);
        break;
        paramInt2 = 22;
        break label125;
      }
      label153:
      paramInt1 = 0;
    }
  }
  
  private void a(List<QQCircleFeedBase.StTabInfo> paramList)
  {
    if (paramList.size() > 4)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabMode(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabGravity(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setScrollableTabMinWidth(-2);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabMode(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabGravity(1);
  }
  
  private void a(List<QQCircleFeedBase.StTabInfo> paramList, boolean paramBoolean)
  {
    QLog.d("QCircleFolderFragmentsPart", 1, "initTabDatasFromServer isFromCache:" + paramBoolean);
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("QCircleFolderFragmentsPart", 1, "initTabDatasFromServer invalid input data!");
      return;
    }
    d();
    a(paramList);
    b(paramList, paramBoolean);
    f();
  }
  
  private void a(vbe paramvbe)
  {
    boolean bool = true;
    Object localObject = null;
    int i = paramvbe.a();
    if (i == 1)
    {
      localObject = new QCircleFolderFollowTabFragment();
      if (localObject == null) {
        break label110;
      }
      if (i != this.jdField_d_of_type_Int) {
        break label105;
      }
    }
    for (;;)
    {
      ((QCircleBaseTabFragment)localObject).b(bool);
      ((QCircleBaseTabFragment)localObject).a(paramvbe);
      ((QCircleBaseTabFragment)localObject).a(this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView);
      ((QCircleBaseTabFragment)localObject).a(this);
      this.jdField_d_of_type_JavaUtilArrayList.add(localObject);
      this.jdField_c_of_type_JavaUtilArrayList.add(paramvbe.a());
      return;
      if (i != 6) {
        break;
      }
      localObject = new QCircleFolderRcmdTabFragment();
      break;
      label105:
      bool = false;
    }
    label110:
    QLog.e("QCircleFolderFragmentsPart", 1, "addTab invalid input data!");
  }
  
  private void a(vxq<List<QQCircleFeedBase.StTabInfo>> paramvxq)
  {
    if (paramvxq == null)
    {
      QLog.e("QCircleFolderFragmentsPart", 1, "handleTabDataRsp() return unexpected data！");
      return;
    }
    switch (paramvxq.a())
    {
    case 1: 
    default: 
      return;
    case 0: 
      c();
      return;
    case 4: 
      b(paramvxq);
      return;
    }
    c(paramvxq);
  }
  
  private boolean a(List<QQCircleFeedBase.StTabInfo> paramList)
  {
    try
    {
      if ((QzoneConfig.getQQCircleEnableReuseFragment()) && (paramList.size() == this.jdField_d_of_type_JavaUtilArrayList.size()) && (paramList.size() == this.jdField_c_of_type_JavaUtilArrayList.size()))
      {
        int i = 0;
        while (i < paramList.size())
        {
          QQCircleFeedBase.StTabInfo localStTabInfo = (QQCircleFeedBase.StTabInfo)paramList.get(i);
          QCircleBaseTabFragment localQCircleBaseTabFragment = (QCircleBaseTabFragment)this.jdField_d_of_type_JavaUtilArrayList.get(i);
          if (!((String)this.jdField_c_of_type_JavaUtilArrayList.get(i)).equals(localStTabInfo.tabName.get())) {
            return false;
          }
          if (localStTabInfo.tabType.get() != localQCircleBaseTabFragment.a().a.tabType.get()) {
            return false;
          }
          localQCircleBaseTabFragment.b(vbe.a(localStTabInfo).a(false));
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
  
  private void b()
  {
    QLog.d("QCircleFolderCacheHelper", 1, "initTabs without tab cache");
    if (aadg.a("2002"))
    {
      QLog.i("QCircleFolderFragmentsPart", 1, "runPreload");
      aadg.a("2002", new vcz(this));
      return;
    }
    this.jdField_a_of_type_Vxm.a(uyq.a().a());
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_b_of_type_Int = 1;
    }
    while (paramInt != 6) {
      return;
    }
    this.jdField_b_of_type_Int = 3;
  }
  
  private void b(List<QQCircleFeedBase.StTabInfo> paramList, boolean paramBoolean)
  {
    if (this.jdField_d_of_type_JavaUtilArrayList.size() > 0)
    {
      if (!a(paramList))
      {
        QLog.d("QCircleFolderFragmentsPart", 1, "tryReuseFragment failed!refresh all!");
        e();
        a(paramList, paramBoolean);
      }
      return;
    }
    QCircleBaseTabFragment.a();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QQCircleFeedBase.StTabInfo localStTabInfo = (QQCircleFeedBase.StTabInfo)paramList.next();
      if (localStTabInfo != null) {
        a(vbe.a(localStTabInfo).a(paramBoolean));
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter.notifyDataSetChanged();
  }
  
  private void b(vxq<List<QQCircleFeedBase.StTabInfo>> paramvxq)
  {
    if (paramvxq.a() == null) {}
    for (String str = anzj.a(2131718459);; str = paramvxq.a())
    {
      QLog.e("QCircleFolderFragmentsPart", 1, "handleTabDataRsp() return error！errMsg:" + str);
      if ((this.jdField_d_of_type_JavaUtilArrayList == null) || (this.jdField_d_of_type_JavaUtilArrayList.size() != 0)) {
        break;
      }
      vws.a(paramvxq.a(), BaseApplicationImpl.getContext(), 1, str, 1);
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.b(str);
      }
      return;
    }
    vws.a(paramvxq.a(), BaseApplicationImpl.getContext(), 1, str, 1);
  }
  
  private void c()
  {
    QLog.e("QCircleFolderFragmentsPart", 1, "handleTabDataRsp() return empty data!");
    if ((this.jdField_d_of_type_JavaUtilArrayList != null) && (this.jdField_d_of_type_JavaUtilArrayList.size() == 0) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null)) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.b(null);
    }
  }
  
  private void c(vxq<List<QQCircleFeedBase.StTabInfo>> paramvxq)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.a();
    }
    List localList = (List)paramvxq.a();
    if (paramvxq.a() == 2) {}
    for (boolean bool = true;; bool = false)
    {
      a(localList, bool);
      return;
    }
  }
  
  private void d()
  {
    if (this.jdField_c_of_type_Int == -1)
    {
      this.jdField_d_of_type_Int = uyn.a();
      QLog.d("QCircleFolderFragmentsPart", 1, "firstShowTabType:" + this.jdField_d_of_type_Int);
      return;
    }
    this.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
  }
  
  private void e()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    this.jdField_d_of_type_JavaUtilArrayList.clear();
  }
  
  private void f()
  {
    b(this.jdField_d_of_type_Int);
    a(this.jdField_d_of_type_Int, false, false);
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public Object a(String paramString, Object paramObject)
  {
    if (("get_current_page_index".equals(paramString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat != null))
    {
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.getCurrentItem();
      QLog.d("QCircleFolderFragmentsPart", 1, "get current item:" + i);
      return Integer.valueOf(i);
    }
    return super.a(paramString, paramObject);
  }
  
  public String a()
  {
    return "QCircleFolderFragmentsPart";
  }
  
  public vzy a(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaUtilArrayList != null) && (this.jdField_b_of_type_JavaUtilArrayList.size() > paramInt)) {
      return (vzy)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = false;
    int i;
    if (paramInt > 0) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.jdField_d_of_type_JavaUtilArrayList.size())
      {
        QCircleBaseTabFragment localQCircleBaseTabFragment = (QCircleBaseTabFragment)this.jdField_d_of_type_JavaUtilArrayList.get(i);
        if ((localQCircleBaseTabFragment == null) || (localQCircleBaseTabFragment.a() == null) || (paramInt != localQCircleBaseTabFragment.a().a()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat == null)) {
          break label117;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setCurrentItem(i, paramBoolean1);
        if (a() != null)
        {
          BasePartFragment localBasePartFragment = a();
          paramBoolean1 = bool;
          if (i == 0) {
            paramBoolean1 = true;
          }
          localBasePartFragment.c(paramBoolean1);
        }
        if (paramBoolean2) {
          localQCircleBaseTabFragment.h();
        }
      }
      return;
      label117:
      i += 1;
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat = ((TabLayoutCompat)paramView.findViewById(2131373295));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabTextColors(-16777216, -16777216);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabMode(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabGravity(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorHeight(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setViewPagerTabEventListener(new vcw(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = ((ViewPagerCompat)paramView.findViewById(2131373299));
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter = new QCircleFolderFragmentsPart.FolderTabFragmentAdapter(this, ((FragmentActivity)a()).getSupportFragmentManager());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setAdapter(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setOffscreenPageLimit(3);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setupWithViewPager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.addOnPageChangeListener(new vcx(this));
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView = ((QCirclePolyLikeAniView)paramView.findViewById(2131374004));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView = ((QCircleStatusView)paramView.findViewById(2131374073));
    a();
  }
  
  public void a(szz paramszz)
  {
    this.jdField_a_of_type_Int = paramszz.a();
  }
  
  public boolean a()
  {
    vle.a().a(this.jdField_d_of_type_Int, this.jdField_a_of_type_Vxm);
    Iterator localIterator = this.jdField_d_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      QCircleBaseFragment localQCircleBaseFragment = (QCircleBaseFragment)localIterator.next();
      if (localQCircleBaseFragment != null) {
        localQCircleBaseFragment.onBackEvent();
      }
    }
    return false;
  }
  
  public void b(szz paramszz)
  {
    ((QCircleBaseTabFragment)this.jdField_d_of_type_JavaUtilArrayList.get(paramszz.a())).b();
  }
  
  public void c(szz paramszz)
  {
    if (paramszz.a() == this.jdField_a_of_type_Int) {
      ((QCircleBaseTabFragment)this.jdField_d_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int)).k();
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
    aaak.a().a(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    aaak.a().b(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart
 * JD-Core Version:    0.7.0.1
 */