package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.view.View;
import anni;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.qqcircle.events.QCircleSelectTabEvent;
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
import tja;
import tjf;
import uxc;
import uxf;
import uzo;
import uzu;
import vbg;
import vbh;
import vbi;
import vbj;
import vja;
import vrf;
import vtt;
import vul;
import vup;
import zwp;
import zwr;
import zzk;

public class QCircleFolderFragmentsPart
  extends uzu
  implements tja, zwr
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 300L;
  private TabLayoutCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat;
  private ViewPagerCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat;
  private QCircleFolderFragmentsPart.FolderTabFragmentAdapter jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter;
  private QCirclePolyLikeAniView jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView;
  private QCircleStatusView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView;
  private vul jdField_a_of_type_Vul;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_c_of_type_Int = 1;
  private ArrayList<QCircleBaseTabFragment> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private int d = 1;
  
  private void a()
  {
    this.jdField_a_of_type_Vul = ((vul)a(vul.class));
    this.jdField_a_of_type_Vul.a().observe(a(), new vbi(this));
    if (!this.jdField_a_of_type_Vul.a())
    {
      QLog.d("QCircleFolderCacheHelper", 4, "initTabs without tab cache");
      if (zzk.a("2002"))
      {
        QLog.i("QCircleFolderFragmentsPart", 1, "runPreload");
        zzk.a("2002", new vbj(this));
        return;
      }
      this.jdField_a_of_type_Vul.a(uxf.a().a());
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
      uzo localuzo = ((QCircleBaseTabFragment)this.jdField_c_of_type_JavaUtilArrayList.get(paramInt1)).a();
      if (localuzo == null) {
        break label153;
      }
      if (localuzo.a() != 1) {
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
          vrf.a("", paramInt2, paramInt1);
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
        vrf.a("", paramInt2, paramInt1);
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
      if (this.jdField_c_of_type_JavaUtilArrayList.size() <= 0) {
        break label217;
      }
      if (!a(paramList))
      {
        QLog.d("QCircleFolderFragmentsPart", 1, "tryReuseFragment failed!refresh all!");
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
        this.d = uxc.a();
        QLog.d("QCircleFolderFragmentsPart", 1, "firstShowTabType:" + this.d);
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
          a(uzo.a(localStTabInfo).a(paramBoolean));
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter.notifyDataSetChanged();
    }
  }
  
  private void a(uzo paramuzo)
  {
    Object localObject = null;
    switch (paramuzo.a())
    {
    }
    while (localObject != null)
    {
      ((QCircleBaseTabFragment)localObject).a(paramuzo);
      ((QCircleBaseTabFragment)localObject).a(this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView);
      ((QCircleBaseTabFragment)localObject).a(this);
      this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
      this.jdField_b_of_type_JavaUtilArrayList.add(paramuzo.a());
      return;
      localObject = new QCircleFolderFollowTabFragment();
      continue;
      localObject = new QCircleFolderRcmdTabFragment();
    }
    QLog.e("QCircleFolderFragmentsPart", 1, "addTab invalid input data!");
  }
  
  private void a(vup<List<QQCircleFeedBase.StTabInfo>> paramvup)
  {
    boolean bool = true;
    if (paramvup == null) {
      QLog.e("QCircleFolderFragmentsPart", 1, "handleTabDataRsp() return unexpected data！");
    }
    do
    {
      return;
      switch (paramvup.a())
      {
      case 1: 
      default: 
        return;
      case 0: 
        QLog.e("QCircleFolderFragmentsPart", 1, "handleTabDataRsp() return empty data!");
      }
    } while ((this.jdField_c_of_type_JavaUtilArrayList == null) || (this.jdField_c_of_type_JavaUtilArrayList.size() != 0) || (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView == null));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.b(null);
    return;
    if (paramvup.a() == null) {}
    for (Object localObject = anni.a(2131718323);; localObject = paramvup.a())
    {
      QLog.e("QCircleFolderFragmentsPart", 1, "handleTabDataRsp() return error！errMsg:" + (String)localObject);
      if ((this.jdField_c_of_type_JavaUtilArrayList == null) || (this.jdField_c_of_type_JavaUtilArrayList.size() != 0)) {
        break label193;
      }
      vtt.a(paramvup.a(), BaseApplicationImpl.getContext(), 1, (String)localObject, 1);
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.b((String)localObject);
      return;
    }
    label193:
    vtt.a(paramvup.a(), BaseApplicationImpl.getContext(), 1, (String)localObject, 1);
    return;
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.a();
    }
    localObject = (List)paramvup.a();
    if (paramvup.a() == 2) {}
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
          QCircleBaseTabFragment localQCircleBaseTabFragment = (QCircleBaseTabFragment)this.jdField_c_of_type_JavaUtilArrayList.get(i);
          if (!((String)this.jdField_b_of_type_JavaUtilArrayList.get(i)).equals(localStTabInfo.tabName.get())) {
            return false;
          }
          if (localStTabInfo.tabType.get() != localQCircleBaseTabFragment.a().a.tabType.get()) {
            return false;
          }
          localQCircleBaseTabFragment.b(uzo.a(localStTabInfo).a(false));
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
      QLog.d("QCircleFolderFragmentsPart", 1, "get current item:" + i);
      return Integer.valueOf(i);
    }
    return super.a(paramString, paramObject);
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
    boolean bool = false;
    int i;
    if (paramInt > 0) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.jdField_c_of_type_JavaUtilArrayList.size())
      {
        QCircleBaseTabFragment localQCircleBaseTabFragment = (QCircleBaseTabFragment)this.jdField_c_of_type_JavaUtilArrayList.get(i);
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
          localBasePartFragment.b(paramBoolean1);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat = ((TabLayoutCompat)paramView.findViewById(2131373166));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabTextColors(-16777216, -16777216);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabMode(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabGravity(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorHeight(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setViewPagerTabEventListener(new vbg(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = ((ViewPagerCompat)paramView.findViewById(2131373170));
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter = new QCircleFolderFragmentsPart.FolderTabFragmentAdapter(this, ((FragmentActivity)a()).getSupportFragmentManager());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setAdapter(this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart$FolderTabFragmentAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setOffscreenPageLimit(3);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setupWithViewPager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.addOnPageChangeListener(new vbh(this));
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView = ((QCirclePolyLikeAniView)paramView.findViewById(2131373871));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView = ((QCircleStatusView)paramView.findViewById(2131373934));
    a();
    ViewCompat.setPaddingRelative(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat, 0, 0, 0, 0);
  }
  
  public void a(tjf paramtjf)
  {
    this.jdField_b_of_type_Int = paramtjf.a();
  }
  
  public void b(tjf paramtjf)
  {
    ((QCircleBaseTabFragment)this.jdField_c_of_type_JavaUtilArrayList.get(paramtjf.a())).b();
  }
  
  public void c(tjf paramtjf)
  {
    if (paramtjf.a() == this.jdField_b_of_type_Int) {
      ((QCircleBaseTabFragment)this.jdField_c_of_type_JavaUtilArrayList.get(this.jdField_b_of_type_Int)).k();
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
    zwp.a().a(this);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    vja.a().a(this.d, this.jdField_a_of_type_Vul);
    zwp.a().b(this);
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