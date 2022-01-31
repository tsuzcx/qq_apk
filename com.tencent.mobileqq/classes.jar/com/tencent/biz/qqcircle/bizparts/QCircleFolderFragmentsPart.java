package com.tencent.biz.qqcircle.bizparts;

import alpo;
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
import trv;
import tsb;
import tsc;
import tsd;
import tse;
import tuk;
import tvg;
import tyj;
import tzi;
import tzm;
import yej;
import yel;
import yfo;

public class QCircleFolderFragmentsPart
  extends tvg
  implements skj, yel
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private TabLayoutCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat;
  private ViewPagerCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat;
  private QCircleFolderFragmentsPart.FolderTabFragmentAdapter jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter;
  private QCirclePolymorphicAniView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView;
  private QCircleStatusView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private tuk jdField_a_of_type_Tuk;
  private tzi jdField_a_of_type_Tzi;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 300L;
  private ArrayList<QCircleBaseTabFragment> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  
  private void a()
  {
    this.jdField_a_of_type_Tzi = ((tzi)a(tzi.class));
    this.jdField_a_of_type_Tzi.a().observe(a(), new tsd(this));
    if (yfo.a("2002"))
    {
      QLog.i("QCircleFolderFragmentsPart", 1, "runPreload");
      yfo.a("2002", new tse(this));
      return;
    }
    this.jdField_a_of_type_Tzi.a(tqj.a().a());
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
      trv localtrv = ((QCircleBaseTabFragment)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt1)).a();
      if (localtrv == null) {
        break label160;
      }
      if (localtrv.a() != 1) {
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
          tyj.a("", i, l);
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
        tyj.a("", i, l);
        break;
        i = 22;
        break label126;
      }
      label160:
      paramInt1 = 0;
    }
  }
  
  private void a(List<QQCircleFeedBase.StTabInfo> paramList)
  {
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
        break label134;
      }
      if (!a(paramList))
      {
        QLog.d("QCircleFolderFragmentsPart", 1, "tryReuseFragment failed!refresh all!");
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter.notifyDataSetChanged();
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Int, false, false);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabGravity(1);
      break;
      label134:
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        QQCircleFeedBase.StTabInfo localStTabInfo = (QQCircleFeedBase.StTabInfo)paramList.next();
        if (localStTabInfo != null) {
          a(trv.a(localStTabInfo));
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter.notifyDataSetChanged();
    }
  }
  
  private void a(trv paramtrv)
  {
    Object localObject = null;
    switch (paramtrv.a())
    {
    }
    while (localObject != null)
    {
      ((QCircleBaseTabFragment)localObject).a(paramtrv);
      ((QCircleBaseTabFragment)localObject).a(this.jdField_a_of_type_Tuk, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView);
      this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramtrv.a());
      return;
      localObject = new QCircleFolderFollowTabFragment();
      continue;
      localObject = new QCircleFolderRcmdTabFragment();
    }
    QLog.e("QCircleFolderFragmentsPart", 1, "addTab invalid input data!");
  }
  
  private void a(tzm<List<QQCircleFeedBase.StTabInfo>> paramtzm)
  {
    if (paramtzm == null) {
      QLog.e("QCircleFolderFragmentsPart", 1, "handleTabDataRsp() return unexpected data！");
    }
    do
    {
      return;
      switch (paramtzm.a())
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
    if (paramtzm.a() == null) {}
    for (paramtzm = alpo.a(2131720466);; paramtzm = paramtzm.a())
    {
      QLog.e("QCircleFolderFragmentsPart", 1, "handleTabDataRsp() return error！errMsg:" + paramtzm);
      if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.size() != 0)) {
        break label188;
      }
      QQToast.a(BaseApplicationImpl.getContext(), 1, paramtzm, 1).a();
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.c(paramtzm);
      return;
    }
    label188:
    QQToast.a(BaseApplicationImpl.getContext(), 1, paramtzm, 1).a();
    return;
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.c();
    }
    a((List)paramtzm.a());
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
          localQCircleBaseTabFragment.b(trv.a(localStTabInfo));
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
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleSelectTabEvent.class);
    return localArrayList;
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
          localQCircleBaseTabFragment.g();
        }
      }
      return;
      label85:
      i += 1;
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat = ((TabLayoutCompat)paramView.findViewById(2131372530));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabTextColors(-16777216, -16777216);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabMode(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabGravity(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorHeight(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setViewPagerTabEventListener(new tsb(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = ((ViewPagerCompat)paramView.findViewById(2131372534));
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter = new QCircleFolderFragmentsPart.FolderTabFragmentAdapter(this, ((FragmentActivity)a()).getSupportFragmentManager());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setAdapter(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setOffscreenPageLimit(3);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setupWithViewPager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.a(new tsc(this));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131373128));
    this.jdField_a_of_type_Tuk = new tuk(a());
    this.jdField_a_of_type_Tuk.a(a(), this.jdField_a_of_type_AndroidViewViewStub);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView = ((QCirclePolymorphicAniView)paramView.findViewById(2131373173));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView = ((QCircleStatusView)paramView.findViewById(2131373191));
    a();
    ViewCompat.setPaddingRelative(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat, 0, 0, 0, 0);
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleSelectTabEvent))
    {
      int i = ((QCircleSelectTabEvent)paramSimpleBaseEvent).tabType;
      boolean bool = ((QCircleSelectTabEvent)paramSimpleBaseEvent).needScrollTop;
      ThreadManager.getUIHandler().post(new QCircleFolderFragmentsPart.5(this, i, bool));
    }
  }
  
  public void a(sko paramsko)
  {
    this.jdField_b_of_type_Int = paramsko.a();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Tuk != null) && (this.jdField_a_of_type_Tuk.a())) {
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
    long l;
    if (paramsko.a() == this.jdField_b_of_type_Int)
    {
      l = System.currentTimeMillis();
      if ((this.jdField_b_of_type_Boolean) && (l - this.jdField_a_of_type_Long <= this.jdField_b_of_type_Long))
      {
        ((QCircleBaseTabFragment)this.jdField_b_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)).g();
        this.jdField_b_of_type_Boolean = false;
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Long = l;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    yej.a().a(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    yej.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart
 * JD-Core Version:    0.7.0.1
 */