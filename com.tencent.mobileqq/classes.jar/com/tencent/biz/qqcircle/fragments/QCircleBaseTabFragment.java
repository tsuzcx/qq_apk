package com.tencent.biz.qqcircle.fragments;

import alpo;
import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.qqcircle.component.ComponentPageView;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import trl;
import trr;
import trv;
import tsv;
import tuk;
import tvg;
import tvm;
import tvz;
import twa;
import twb;
import tzb;
import tzm;
import ydp;
import yeb;

public abstract class QCircleBaseTabFragment
  extends QCircleBaseFragment
{
  private static int jdField_a_of_type_Int;
  public static String c = "QCircleBaseTabFragment";
  public static String d = "TAB_TYPE_FOLLOW";
  public static String e = "TAB_TYPE_SCHOOL";
  public static String f = "TAB_TYPE_COMPANY";
  public static String g = "TAB_TYPE_CITY";
  public static String h = "TAB_TYPE_CIRCLE";
  public static String i = "TAB_TYPE_RECOMMEND";
  public QCirclePolymorphicAniView a;
  protected QCircleStatusView a;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  protected trl a;
  public trv a;
  public tsv a;
  public tuk a;
  protected tvm a;
  protected tzb a;
  protected boolean a;
  private int b = jdField_a_of_type_Int;
  protected String j = "";
  
  public QCircleBaseTabFragment()
  {
    jdField_a_of_type_Int += 1;
  }
  
  private trr a()
  {
    return new twa(this);
  }
  
  public static void b()
  {
    jdField_a_of_type_Int = 0;
  }
  
  public int a()
  {
    return 2131560551;
  }
  
  protected TopGestureLayout a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getActivity().getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  }
  
  public String a()
  {
    return b() + "_" + this.b;
  }
  
  public List<tvg> a()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Tvm = new tvm(2131364908, c(), 3, 1);
    localArrayList.add(this.jdField_a_of_type_Tvm);
    this.jdField_a_of_type_Tsv = new tsv();
    localArrayList.add(this.jdField_a_of_type_Tsv);
    a(localArrayList);
    return localArrayList;
  }
  
  public trv a()
  {
    return this.jdField_a_of_type_Trv;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptScrollLRFlag(false);
      }
      QLog.d(c, 1, "onPageSelected unique tabkey:" + a());
      if (this.jdField_a_of_type_Trl != null) {
        this.jdField_a_of_type_Trl.b(paramInt);
      }
      return;
    }
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Tvm.a().setEnableRefresh(true);
    this.jdField_a_of_type_Tvm.a().setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView = this.jdField_a_of_type_Tvm.a();
  }
  
  protected void a(List<tvg> paramList) {}
  
  public void a(trv paramtrv)
  {
    this.jdField_a_of_type_Trv = paramtrv;
  }
  
  public void a(tuk paramtuk, QCirclePolymorphicAniView paramQCirclePolymorphicAniView)
  {
    this.jdField_a_of_type_Tuk = paramtuk;
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView = paramQCirclePolymorphicAniView;
  }
  
  public void a(tzm<List<FeedCloudMeta.StFeed>> paramtzm)
  {
    int m = 0;
    if (paramtzm == null)
    {
      QLog.e(c, 1, "handleFeedDataRsp() return unexpected data！");
      return;
    }
    boolean bool = paramtzm.a();
    int k = m;
    switch (paramtzm.a())
    {
    default: 
      k = m;
    }
    while ((k != 0) && (this.jdField_a_of_type_Trl != null))
    {
      this.jdField_a_of_type_Trl.a(true, bool);
      return;
      QLog.e(c, 1, "handleFeedDataRsp() return empty");
      if ((paramtzm.b()) && (this.jdField_a_of_type_Trl != null) && (this.jdField_a_of_type_Trl.getItemCount() > 0))
      {
        this.jdField_a_of_type_Trl.a().a(bool);
        k = 1;
      }
      else
      {
        if ((this.jdField_a_of_type_Trl != null) && (!this.jdField_a_of_type_Trl.a()))
        {
          if (this.jdField_a_of_type_Trl.getItemCount() <= 0) {
            break label187;
          }
          QQToast.a(BaseApplicationImpl.getContext(), 1, alpo.a(2131720466), 1).a();
        }
        for (;;)
        {
          k = 1;
          break;
          label187:
          if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null) {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.d();
          }
        }
        if (paramtzm.a() == null) {}
        for (paramtzm = alpo.a(2131720466);; paramtzm = paramtzm.a())
        {
          QLog.e(c, 1, "handleFeedDataRsp() return error！errMsg:" + paramtzm);
          if ((this.jdField_a_of_type_Trl == null) || (this.jdField_a_of_type_Trl.getItemCount() <= 0)) {
            break label287;
          }
          QQToast.a(BaseApplicationImpl.getContext(), 1, paramtzm, 1).a();
          k = 1;
          break;
        }
        label287:
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.d(paramtzm);
          k = 1;
          continue;
          if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null) {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.c();
          }
          if (this.jdField_a_of_type_Trl != null)
          {
            if (paramtzm.b()) {
              this.jdField_a_of_type_Trl.a((List)paramtzm.a());
            }
            for (;;)
            {
              this.jdField_a_of_type_Trl.a().a(bool);
              k = 1;
              break;
              this.jdField_a_of_type_Trl.a((ArrayList)paramtzm.a());
              if (d.equals(b())) {
                this.jdField_a_of_type_Trl.Q_();
              }
            }
          }
        }
        k = 1;
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "enableFlingRight->enable:" + paramBoolean);
    }
  }
  
  public abstract String b();
  
  protected List<ydp> b()
  {
    return null;
  }
  
  public void b(trv paramtrv)
  {
    this.jdField_a_of_type_Trv = paramtrv;
    if (this.jdField_a_of_type_Boolean) {
      b(false);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Trv != null)
    {
      c(this.jdField_a_of_type_Trv);
      this.jdField_a_of_type_Tzb.a(this.jdField_a_of_type_Trv);
      this.jdField_a_of_type_Tzb.a(paramBoolean);
    }
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected List<ydp> c()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Trl = new trl(new Bundle());
    ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
    if (a() != null)
    {
      localExtraTypeInfo.pageType = a().c();
      this.jdField_a_of_type_Trl.a(localExtraTypeInfo);
    }
    this.jdField_a_of_type_Trl.a(a());
    this.jdField_a_of_type_Trl.a(d.equals(b()));
    this.jdField_a_of_type_Trl.a(new tvz(this));
    if (b() != null) {
      localArrayList.addAll(b());
    }
    localArrayList.add(this.jdField_a_of_type_Trl);
    return localArrayList;
  }
  
  public void c()
  {
    QLog.d(c, 1, "onPageUnSelected unique tabkey:" + a());
    if (this.jdField_a_of_type_Trl != null) {
      this.jdField_a_of_type_Trl.b();
    }
  }
  
  protected void c(trv paramtrv) {}
  
  protected void d()
  {
    this.jdField_a_of_type_Tzb = ((tzb)a(a(), tzb.class));
    this.jdField_a_of_type_Tzb.a(b());
    this.jdField_a_of_type_Tzb.b().observe(this, new twb(this));
  }
  
  protected void e()
  {
    b(true);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Tzb.b();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Tvm.a().a().scrollToPosition(0);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (getActivity() != null) {
      this.j = getActivity().app.getAccount();
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_Tzb != null)
    {
      this.jdField_a_of_type_Tzb.b().removeObservers(this);
      this.jdField_a_of_type_Tzb = null;
    }
    if (this.jdField_a_of_type_Tuk != null)
    {
      this.jdField_a_of_type_Tuk.d();
      this.jdField_a_of_type_Tuk = null;
    }
    QLog.d(c, 1, "onDetach()" + a());
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((getUserVisibleHint()) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      d();
      e();
    }
    QLog.d(c, 4, "setUserVisibleHint :" + getUserVisibleHint());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment
 * JD-Core Version:    0.7.0.1
 */