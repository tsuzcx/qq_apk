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
import com.tencent.biz.qqcircle.fragments.QCircleBaseAggregationFragment;
import com.tencent.biz.qqcircle.fragments.main.QCircleAggregationFragment;
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
import vbg;
import vbh;
import vbi;
import vbj;
import vbk;
import vle;
import vtq;
import vws;
import vxm;
import vxq;

public class QCircleAggregationFragmentsPart
  extends vbk
  implements aaam, szu
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 300L;
  private TabLayoutCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat;
  private ViewPagerCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat;
  private QCircleAggregationFragmentsPart.FolderTabFragmentAdapter jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleAggregationFragmentsPart$FolderTabFragmentAdapter;
  private QCirclePolyLikeAniView jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView;
  private QCircleStatusView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView;
  private vxm jdField_a_of_type_Vxm;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_c_of_type_Int = 1;
  private ArrayList<QCircleBaseAggregationFragment> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private int d = 1;
  
  private void a()
  {
    this.jdField_a_of_type_Vxm = ((vxm)a(vxm.class));
    this.jdField_a_of_type_Vxm.a().observe(a(), new vbi(this));
    if (!this.jdField_a_of_type_Vxm.a())
    {
      QLog.d("QCircleFolderCacheHelper", 4, "initTabs without tab cache");
      if (aadg.a("2002"))
      {
        QLog.i("QCircleAggregationFragmentsPart", 1, "runPreload");
        aadg.a("2002", new vbj(this));
        return;
      }
      this.jdField_a_of_type_Vxm.a(uyq.a().a());
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
    if ((this.jdField_c_of_type_JavaUtilArrayList != null) && (this.jdField_c_of_type_JavaUtilArrayList.size() > paramInt1))
    {
      vbe localvbe = ((QCircleBaseAggregationFragment)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).a();
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
  
  private void a(List<QQCircleFeedBase.StTabInfo> paramList, boolean paramBoolean)
  {
    QLog.d("QCircleAggregationFragmentsPart", 1, "initTabDatasFromServer isFromCache:" + paramBoolean);
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.e("QCircleAggregationFragmentsPart", 1, "initTabDatasFromServer invalid input data!");
      return;
    }
    if (paramList.size() > 4)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabMode(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabGravity(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setScrollableTabMinWidth(-2);
      if (this.jdField_c_of_type_JavaUtilArrayList.size() <= 0) {
        break label217;
      }
      if (!a(paramList))
      {
        QLog.d("QCircleAggregationFragmentsPart", 1, "tryReuseFragment failed!refresh all!");
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        this.jdField_c_of_type_JavaUtilArrayList.clear();
        a(paramList, paramBoolean);
      }
    }
    for (;;)
    {
      this.d = this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_Int == -1)
      {
        this.d = uyn.a();
        QLog.d("QCircleAggregationFragmentsPart", 1, "firstShowTabType:" + this.d);
      }
      b(this.d);
      a(this.d, false, false);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabGravity(1);
      break;
      label217:
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QQCircleFeedBase.StTabInfo localStTabInfo = (QQCircleFeedBase.StTabInfo)paramList.next();
        if (localStTabInfo != null) {
          a(vbe.a(localStTabInfo).a(paramBoolean));
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleAggregationFragmentsPart$FolderTabFragmentAdapter.notifyDataSetChanged();
    }
  }
  
  private void a(vbe paramvbe)
  {
    Object localObject = null;
    switch (paramvbe.a())
    {
    }
    while (localObject != null)
    {
      ((QCircleBaseAggregationFragment)localObject).a(paramvbe);
      ((QCircleBaseAggregationFragment)localObject).a(this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView);
      ((QCircleBaseAggregationFragment)localObject).a(this);
      this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
      this.jdField_b_of_type_JavaUtilArrayList.add(paramvbe.a());
      return;
      localObject = new QCircleAggregationFragment();
    }
    QLog.e("QCircleAggregationFragmentsPart", 1, "addTab invalid input data!");
  }
  
  private void a(vxq<List<QQCircleFeedBase.StTabInfo>> paramvxq)
  {
    boolean bool = true;
    if (paramvxq == null) {
      QLog.e("QCircleAggregationFragmentsPart", 1, "handleTabDataRsp() return unexpected data！");
    }
    do
    {
      return;
      switch (paramvxq.a())
      {
      case 1: 
      default: 
        return;
      case 0: 
        QLog.e("QCircleAggregationFragmentsPart", 1, "handleTabDataRsp() return empty data!");
      }
    } while ((this.jdField_c_of_type_JavaUtilArrayList == null) || (this.jdField_c_of_type_JavaUtilArrayList.size() != 0) || (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView == null));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.b(null);
    return;
    if (paramvxq.a() == null) {}
    for (Object localObject = anzj.a(2131718459);; localObject = paramvxq.a())
    {
      QLog.e("QCircleAggregationFragmentsPart", 1, "handleTabDataRsp() return error！errMsg:" + (String)localObject);
      if ((this.jdField_c_of_type_JavaUtilArrayList == null) || (this.jdField_c_of_type_JavaUtilArrayList.size() != 0)) {
        break label193;
      }
      vws.a(paramvxq.a(), BaseApplicationImpl.getContext(), 1, (String)localObject, 1);
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.b((String)localObject);
      return;
    }
    label193:
    vws.a(paramvxq.a(), BaseApplicationImpl.getContext(), 1, (String)localObject, 1);
    return;
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.a();
    }
    localObject = (List)paramvxq.a();
    if (paramvxq.a() == 2) {}
    for (;;)
    {
      a((List)localObject, bool);
      return;
      bool = false;
    }
  }
  
  private boolean a(List<QQCircleFeedBase.StTabInfo> paramList)
  {
    try
    {
      if ((QzoneConfig.getQQCircleEnableReuseFragment()) && (paramList.size() == this.jdField_c_of_type_JavaUtilArrayList.size()) && (paramList.size() == this.jdField_b_of_type_JavaUtilArrayList.size()))
      {
        int i = 0;
        while (i < paramList.size())
        {
          QQCircleFeedBase.StTabInfo localStTabInfo = (QQCircleFeedBase.StTabInfo)paramList.get(i);
          QCircleBaseAggregationFragment localQCircleBaseAggregationFragment = (QCircleBaseAggregationFragment)this.jdField_c_of_type_JavaUtilArrayList.get(i);
          if (!((String)this.jdField_b_of_type_JavaUtilArrayList.get(i)).equals(localStTabInfo.tabName.get())) {
            return false;
          }
          if (localStTabInfo.tabType.get() != localQCircleBaseAggregationFragment.a().a.tabType.get()) {
            return false;
          }
          localQCircleBaseAggregationFragment.b(vbe.a(localStTabInfo).a(false));
          i += 1;
        }
        QLog.d("QCircleAggregationFragmentsPart", 1, "tryReuseFragment success!");
        return true;
      }
      return false;
    }
    catch (Exception paramList) {}
    return false;
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_c_of_type_Int = 1;
    }
    while (paramInt != 6) {
      return;
    }
    this.jdField_c_of_type_Int = 3;
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public Object a(String paramString, Object paramObject)
  {
    if (("get_current_page_index".equals(paramString)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat != null))
    {
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.getCurrentItem();
      QLog.d("QCircleAggregationFragmentsPart", 1, "get current item:" + i);
      return Integer.valueOf(i);
    }
    return super.a(paramString, paramObject);
  }
  
  public String a()
  {
    return "QCircleAggregationFragmentsPart";
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
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
      if (i < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        QCircleBaseAggregationFragment localQCircleBaseAggregationFragment = (QCircleBaseAggregationFragment)this.jdField_c_of_type_JavaUtilArrayList.get(i);
        if ((localQCircleBaseAggregationFragment == null) || (localQCircleBaseAggregationFragment.a() == null) || (paramInt != localQCircleBaseAggregationFragment.a().a()) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat == null)) {
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
          localQCircleBaseAggregationFragment.g();
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setViewPagerTabEventListener(new vbg(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = ((ViewPagerCompat)paramView.findViewById(2131373299));
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleAggregationFragmentsPart$FolderTabFragmentAdapter = new QCircleAggregationFragmentsPart.FolderTabFragmentAdapter(this, ((FragmentActivity)a()).getSupportFragmentManager());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setAdapter(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleAggregationFragmentsPart$FolderTabFragmentAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setOffscreenPageLimit(3);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setupWithViewPager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.addOnPageChangeListener(new vbh(this));
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView = ((QCirclePolyLikeAniView)paramView.findViewById(2131374004));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView = ((QCircleStatusView)paramView.findViewById(2131374073));
    a();
    ViewCompat.setPaddingRelative(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat, 0, 0, 0, 0);
  }
  
  public void a(szz paramszz)
  {
    this.jdField_b_of_type_Int = paramszz.a();
  }
  
  public void b(szz paramszz)
  {
    ((QCircleBaseAggregationFragment)this.jdField_c_of_type_JavaUtilArrayList.get(paramszz.a())).a();
  }
  
  public void c(szz paramszz)
  {
    if (paramszz.a() == this.jdField_b_of_type_Int) {
      ((QCircleBaseAggregationFragment)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)).h();
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
    vle.a().a(this.d, this.jdField_a_of_type_Vxm);
    aaak.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleSelectTabEvent))
    {
      int i = ((QCircleSelectTabEvent)paramSimpleBaseEvent).tabType;
      boolean bool = ((QCircleSelectTabEvent)paramSimpleBaseEvent).needScrollTop;
      ThreadManager.getUIHandler().post(new QCircleAggregationFragmentsPart.5(this, i, bool));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleAggregationFragmentsPart
 * JD-Core Version:    0.7.0.1
 */