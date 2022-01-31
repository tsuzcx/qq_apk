package com.tencent.biz.qqcircle.fragments;

import alud;
import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tencent.biz.qqcircle.component.QCircleComponentPageView;
import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicAniView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import trq;
import trw;
import tsa;
import ttl;
import tuz;
import tvv;
import tvw;
import two;
import twp;
import twq;
import twr;
import ubm;
import ubz;
import yhy;
import yib;
import yii;
import yiq;

public abstract class QCircleBaseTabFragment
  extends QCircleBaseFragment
{
  private static int a;
  public static String b;
  public static String c = "TAB_TYPE_FOLLOW";
  public static String d = "TAB_TYPE_SCHOOL";
  public static String e = "TAB_TYPE_COMPANY";
  public static String f = "TAB_TYPE_CITY";
  public static String g = "TAB_TYPE_CIRCLE";
  public static String h = "TAB_TYPE_RECOMMEND";
  public QCirclePolymorphicAniView a;
  protected QCircleStatusView a;
  protected trq a;
  public tsa a;
  public ttl a;
  public tuz a;
  public tvv a;
  protected tvw a;
  protected ubm a;
  protected boolean a;
  private int b;
  protected String i = "";
  
  static
  {
    jdField_b_of_type_JavaLangString = "QCircleBaseTabFragment";
  }
  
  public QCircleBaseTabFragment()
  {
    this.jdField_b_of_type_Int = jdField_a_of_type_Int;
    jdField_a_of_type_Int += 1;
  }
  
  private trw a()
  {
    return new twp(this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    NestScrollRecyclerView localNestScrollRecyclerView = this.jdField_a_of_type_Tvw.a().a();
    if (localNestScrollRecyclerView != null) {
      localNestScrollRecyclerView.getViewTreeObserver().addOnPreDrawListener(new twr(this, localNestScrollRecyclerView, paramInt1, paramInt2));
    }
  }
  
  public static void b()
  {
    jdField_a_of_type_Int = 0;
  }
  
  public int a()
  {
    return 2131560553;
  }
  
  public List<tvv> a()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Tvw = new tvw(2131364910, c(), 3, 1);
    localArrayList.add(this.jdField_a_of_type_Tvw);
    this.jdField_a_of_type_Ttl = new ttl();
    localArrayList.add(this.jdField_a_of_type_Ttl);
    a(localArrayList);
    return localArrayList;
  }
  
  public tsa a()
  {
    return this.jdField_a_of_type_Tsa;
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
      QLog.d(jdField_b_of_type_JavaLangString, 1, "onPageSelected unique tabkey:" + b());
      if (this.jdField_a_of_type_Trq != null) {
        this.jdField_a_of_type_Trq.b(paramInt);
      }
      return;
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    QLog.d("QCircleFolderCacheHelper", 1, "scrollToPosWithOffset pos:" + paramInt1 + ",top:" + paramInt2 + "." + b());
    try
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof yiq)) {
        ((yiq)paramRecyclerView).scrollToPositionWithOffset(paramInt1, paramInt2);
      }
      return;
    }
    catch (Exception paramRecyclerView)
    {
      QLog.e(jdField_b_of_type_JavaLangString, 1, "scrollToPosWithOffset exception:" + paramRecyclerView.toString() + b());
    }
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Tvw.a().setEnableRefresh(true);
    this.jdField_a_of_type_Tvw.a().setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView = this.jdField_a_of_type_Tvw.a();
  }
  
  protected void a(List<tvv> paramList) {}
  
  public void a(tsa paramtsa)
  {
    this.jdField_a_of_type_Tsa = paramtsa;
  }
  
  public void a(tuz paramtuz, QCirclePolymorphicAniView paramQCirclePolymorphicAniView)
  {
    this.jdField_a_of_type_Tuz = paramtuz;
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicAniView = paramQCirclePolymorphicAniView;
  }
  
  public void a(tvv paramtvv)
  {
    this.jdField_a_of_type_Tvv = paramtvv;
  }
  
  public void a(ubz<List<FeedCloudMeta.StFeed>> paramubz)
  {
    int k = 0;
    if (paramubz == null)
    {
      QLog.e(jdField_b_of_type_JavaLangString, 1, "handleFeedDataRsp() return unexpected data！");
      return;
    }
    boolean bool = paramubz.a();
    int j = k;
    switch (paramubz.a())
    {
    default: 
      j = k;
    }
    while ((j != 0) && (this.jdField_a_of_type_Trq != null))
    {
      this.jdField_a_of_type_Trq.a(true, bool);
      return;
      QLog.e(jdField_b_of_type_JavaLangString, 1, "handleFeedDataRsp() return empty");
      if ((paramubz.b()) && (this.jdField_a_of_type_Trq != null) && (this.jdField_a_of_type_Trq.getItemCount() > 0))
      {
        this.jdField_a_of_type_Trq.getLoadInfo().a(bool);
        j = 1;
      }
      else
      {
        if ((this.jdField_a_of_type_Trq != null) && (!this.jdField_a_of_type_Trq.a()))
        {
          if (!c()) {
            break label189;
          }
          QQToast.a(BaseApplicationImpl.getContext(), 1, alud.a(2131720478), 1).a();
        }
        for (;;)
        {
          j = 1;
          break;
          label189:
          if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null) {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.d();
          }
        }
        if (paramubz.a() == null) {}
        for (paramubz = alud.a(2131720478);; paramubz = paramubz.a())
        {
          QLog.e(jdField_b_of_type_JavaLangString, 1, "handleFeedDataRsp() return error！errMsg:" + paramubz);
          if ((this.jdField_a_of_type_Trq == null) || (this.jdField_a_of_type_Trq.a())) {
            break label483;
          }
          if (!c()) {
            break label297;
          }
          QQToast.a(BaseApplicationImpl.getContext(), 1, paramubz, 1).a();
          j = 1;
          break;
        }
        label297:
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.d(paramubz);
          j = 1;
          continue;
          if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null) {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.c();
          }
          if (this.jdField_a_of_type_Trq != null)
          {
            if (paramubz.b()) {
              this.jdField_a_of_type_Trq.addAll((List)paramubz.a());
            }
            for (;;)
            {
              this.jdField_a_of_type_Trq.getLoadInfo().a(bool);
              j = 1;
              break;
              this.jdField_a_of_type_Trq.setDatas((ArrayList)paramubz.a());
              if (c.equals(c())) {
                this.jdField_a_of_type_Trq.a();
              }
            }
            if (this.jdField_a_of_type_Trq != null)
            {
              this.jdField_a_of_type_Trq.setDatas((ArrayList)paramubz.a());
              if (c.equals(c())) {
                this.jdField_a_of_type_Trq.a();
              }
              this.jdField_a_of_type_Trq.getLoadInfo().a(bool);
              a(paramubz.b(), paramubz.c());
              j = 1;
              continue;
            }
          }
        }
        label483:
        j = 1;
      }
    }
  }
  
  public String b()
  {
    return c() + "_" + this.jdField_b_of_type_Int;
  }
  
  protected List<yhy> b()
  {
    return null;
  }
  
  public void b(tsa paramtsa)
  {
    this.jdField_a_of_type_Tsa = paramtsa;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Ubm != null) {
        this.jdField_a_of_type_Ubm.a(this.jdField_a_of_type_Tsa);
      }
      b(false);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    g();
    if (this.jdField_a_of_type_Ubm != null) {
      this.jdField_a_of_type_Ubm.a(paramBoolean);
    }
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public abstract String c();
  
  protected List<yhy> c()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Trq = new trq(new Bundle());
    ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
    if (a() != null)
    {
      localExtraTypeInfo.pageType = a().b();
      this.jdField_a_of_type_Trq.a(localExtraTypeInfo);
    }
    this.jdField_a_of_type_Trq.setInteractor(a());
    this.jdField_a_of_type_Trq.a(c.equals(c()));
    this.jdField_a_of_type_Trq.setOnLoadDataDelegate(new two(this));
    if (b() != null) {
      localArrayList.addAll(b());
    }
    localArrayList.add(this.jdField_a_of_type_Trq);
    return localArrayList;
  }
  
  public void c()
  {
    QLog.d(jdField_b_of_type_JavaLangString, 1, "onPageUnSelected unique tabkey:" + b());
    if (this.jdField_a_of_type_Trq != null) {
      this.jdField_a_of_type_Trq.b();
    }
  }
  
  protected boolean c()
  {
    return (this.jdField_a_of_type_Trq != null) && (this.jdField_a_of_type_Trq.getItemCount() > 0);
  }
  
  protected void d()
  {
    this.jdField_a_of_type_Ubm = ((ubm)a(b(), ubm.class));
    this.jdField_a_of_type_Ubm.b(c());
    this.jdField_a_of_type_Ubm.b().observe(this, new twq(this));
    this.jdField_a_of_type_Ubm.a(this.jdField_a_of_type_Tsa);
  }
  
  protected void e()
  {
    if (!this.jdField_a_of_type_Ubm.a())
    {
      QLog.d("QCircleFolderCacheHelper", 1, "initViewData without page cache" + b());
      b(true);
      return;
    }
    g();
    QLog.d("QCircleFolderCacheHelper", 1, "initViewData with page cache" + b());
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Ubm != null) {
      this.jdField_a_of_type_Ubm.b();
    }
  }
  
  protected void g() {}
  
  public void h()
  {
    QLog.d(jdField_b_of_type_JavaLangString, 1, "scrollToTop" + b());
    try
    {
      this.jdField_a_of_type_Tvw.a().a().scrollToPosition(0);
      return;
    }
    catch (Exception localException)
    {
      QLog.d(jdField_b_of_type_JavaLangString, 1, "scrollToTop exception:" + localException.toString() + b());
    }
  }
  
  public void i()
  {
    QLog.d(jdField_b_of_type_JavaLangString, 1, "scrollToTopAndRefresh" + b());
    try
    {
      this.jdField_a_of_type_Tvw.a().a().g();
      return;
    }
    catch (Exception localException)
    {
      QLog.d(jdField_b_of_type_JavaLangString, 1, "scrollToTopAndRefresh exception:" + localException.toString() + b());
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (getActivity() != null) {
      this.i = getActivity().app.getAccount();
    }
  }
  
  public void onDestroyView()
  {
    int k = 0;
    QLog.d(jdField_b_of_type_JavaLangString, 1, "onDestroyView" + b());
    super.onDestroyView();
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_Ubm != null) && (this.jdField_a_of_type_Tvw.a() != null) && (this.jdField_a_of_type_Tvw.a().a() != null))
        {
          Object localObject1 = this.jdField_a_of_type_Tvw.a().a();
          Object localObject2 = this.jdField_a_of_type_Tvw.a().a().getLayoutManager();
          if ((localObject2 instanceof yiq))
          {
            localObject2 = (yiq)localObject2;
            localObject1 = ((RecyclerView)localObject1).getChildAt(0);
            if (localObject1 == null) {
              break label159;
            }
            k = ((yiq)localObject2).getPosition((View)localObject1);
            j = ((View)localObject1).getTop();
            this.jdField_a_of_type_Ubm.a(this.jdField_a_of_type_Trq.a());
            this.jdField_a_of_type_Ubm.a(k, j);
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      label159:
      int j = 0;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_Ubm != null)
    {
      this.jdField_a_of_type_Ubm.b().removeObservers(this);
      this.jdField_a_of_type_Ubm = null;
    }
    if (this.jdField_a_of_type_Tuz != null)
    {
      this.jdField_a_of_type_Tuz.e();
      this.jdField_a_of_type_Tuz = null;
    }
    QLog.d(jdField_b_of_type_JavaLangString, 1, "onDetach()" + b());
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
    QLog.d(jdField_b_of_type_JavaLangString, 4, "setUserVisibleHint :" + getUserVisibleHint());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment
 * JD-Core Version:    0.7.0.1
 */