package com.tencent.biz.qqcircle.fragments;

import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import anni;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeAniView;
import com.tencent.biz.qqcircle.widgets.FrameAnimationView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import uyk;
import uzb;
import uzo;
import vdc;
import vde;
import vjh;
import vji;
import vjj;
import vjk;
import vtt;
import vtz;
import vup;
import zxi;
import zxj;
import zxo;
import zxu;
import zxz;
import zyj;

public abstract class QCircleBaseTabFragment
  extends QCircleBaseFragment
{
  private static int jdField_a_of_type_Int;
  public static String a;
  public static String b;
  public static String c = "TAB_TYPE_SCHOOL";
  public static String d = "TAB_TYPE_COMPANY";
  public static String e = "TAB_TYPE_CITY";
  public static String f = "TAB_TYPE_CIRCLE";
  public static String g = "TAB_TYPE_RECOMMEND";
  public QCirclePolyLikeAniView a;
  private FrameAnimationView jdField_a_of_type_ComTencentBizQqcircleWidgetsFrameAnimationView;
  protected QCircleStatusView a;
  protected uyk a;
  public uzo a;
  protected vdc a;
  public vde a;
  protected vtz a;
  protected zxi a;
  public zxj a;
  protected boolean a;
  private int jdField_b_of_type_Int = jdField_a_of_type_Int;
  private boolean jdField_b_of_type_Boolean = true;
  protected String h = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "QCircleBaseTabFragment";
    jdField_b_of_type_JavaLangString = "TAB_TYPE_FOLLOW";
  }
  
  public QCircleBaseTabFragment()
  {
    jdField_a_of_type_Int += 1;
  }
  
  private uzb a()
  {
    return new vji(this);
  }
  
  public static void a()
  {
    jdField_a_of_type_Int = 0;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    NestScrollRecyclerView localNestScrollRecyclerView = this.jdField_a_of_type_Zxi.a().a();
    if (localNestScrollRecyclerView != null) {
      localNestScrollRecyclerView.getViewTreeObserver().addOnPreDrawListener(new vjk(this, localNestScrollRecyclerView, paramInt1, paramInt2));
    }
  }
  
  private void a(@Nullable ViewGroup paramViewGroup)
  {
    if (paramViewGroup != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsFrameAnimationView = new FrameAnimationView(getActivity());
      if (!b().equals(jdField_b_of_type_JavaLangString)) {
        break label65;
      }
    }
    label65:
    for (String str = "https://downv6.qq.com/video_story/follow_page_loading.zip";; str = "https://downv6.qq.com/video_story/push_page_loading.zip")
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsFrameAnimationView.setDownloadZipFilePath(str, 1000, false);
      paramViewGroup.addView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsFrameAnimationView, new ViewGroup.LayoutParams(-1, -1));
      return;
    }
  }
  
  private void m()
  {
    ThreadManager.getUIHandler().postDelayed(new QCircleBaseTabFragment.3(this), 2000L);
  }
  
  private void n()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      this.jdField_b_of_type_Boolean = getActivity().getIntent().getBooleanExtra("key_enable_page_memory_cache", true);
      QLog.d(jdField_a_of_type_JavaLangString, 4, "enableMemCache:" + this.jdField_b_of_type_Boolean);
    }
  }
  
  public int a()
  {
    return 2131560715;
  }
  
  public String a()
  {
    return b() + "_" + this.jdField_b_of_type_Int;
  }
  
  public List<zxj> a()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Zxi = new zxi(2131365145, c(), 3, 1);
    localArrayList.add(this.jdField_a_of_type_Zxi);
    this.jdField_a_of_type_Vde = new vde();
    this.jdField_a_of_type_Vde.a(a());
    localArrayList.add(this.jdField_a_of_type_Vde);
    this.jdField_a_of_type_Vdc = new vdc();
    localArrayList.add(this.jdField_a_of_type_Vdc);
    a(localArrayList);
    return localArrayList;
  }
  
  public uzo a()
  {
    return this.jdField_a_of_type_Uzo;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptScrollLRFlag(false);
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onPageSelected unique tabkey:" + a());
      if (this.jdField_a_of_type_Uyk != null) {
        this.jdField_a_of_type_Uyk.a(paramInt);
      }
      return;
    }
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    QLog.d("QCircleFolderCacheHelper", 1, "scrollToPosWithOffset pos:" + paramInt1 + ",top:" + paramInt2 + "." + a());
    try
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof zyj)) {
        ((zyj)paramRecyclerView).scrollToPositionWithOffset(paramInt1, paramInt2);
      }
      return;
    }
    catch (Exception paramRecyclerView)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "scrollToPosWithOffset exception:" + paramRecyclerView.toString() + a());
    }
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Zxi.a().setEnableRefresh(true);
    this.jdField_a_of_type_Zxi.a().setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView = this.jdField_a_of_type_Zxi.a();
    a((ViewGroup)this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(QCirclePolyLikeAniView paramQCirclePolyLikeAniView)
  {
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView = paramQCirclePolyLikeAniView;
  }
  
  protected void a(List<zxj> paramList) {}
  
  public void a(uzo paramuzo)
  {
    this.jdField_a_of_type_Uzo = paramuzo;
  }
  
  public void a(vup<List<FeedCloudMeta.StFeed>> paramvup)
  {
    int j = 0;
    if ((this.jdField_a_of_type_ComTencentBizQqcircleWidgetsFrameAnimationView != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsFrameAnimationView);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsFrameAnimationView = null;
    }
    if (paramvup == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "handleFeedDataRsp() return unexpected data！");
      return;
    }
    boolean bool = paramvup.a();
    switch (paramvup.a())
    {
    default: 
      i = 0;
    case 0: 
    case 4: 
    case 1: 
      for (;;)
      {
        if ((i != 0) && (this.jdField_a_of_type_Uyk != null)) {
          this.jdField_a_of_type_Uyk.a(true, bool);
        }
        if (j == 0) {
          break;
        }
        l();
        return;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handleFeedDataRsp() return empty");
        if ((paramvup.b()) && (this.jdField_a_of_type_Uyk != null) && (this.jdField_a_of_type_Uyk.getItemCount() > 0))
        {
          this.jdField_a_of_type_Uyk.getLoadInfo().a(bool);
          i = 1;
        }
        else
        {
          if ((this.jdField_a_of_type_Uyk != null) && (!this.jdField_a_of_type_Uyk.a()))
          {
            if (!b()) {
              break label230;
            }
            QQToast.a(BaseApplicationImpl.getContext(), 1, anni.a(2131718323), 1).a();
          }
          for (;;)
          {
            i = 1;
            break;
            if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null) {
              this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.c();
            }
          }
          if (paramvup.a() == null) {}
          for (String str = anni.a(2131718323);; str = paramvup.a())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 1, "handleFeedDataRsp() return error！errMsg:" + str);
            if ((this.jdField_a_of_type_Uyk == null) || (this.jdField_a_of_type_Uyk.a())) {
              break label556;
            }
            if (!b()) {
              break label342;
            }
            vtt.a(paramvup.a(), BaseApplicationImpl.getContext(), 1, str, 1);
            i = 1;
            break;
          }
          label342:
          if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView == null) {
            break label556;
          }
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.b(str);
          i = 1;
          continue;
          i = 0;
        }
      }
    case 2: 
      label230:
      QLog.d(jdField_a_of_type_JavaLangString, 1, "load data from cache");
    }
    for (int i = 1;; i = 0)
    {
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.a();
      }
      if (this.jdField_a_of_type_Uyk != null)
      {
        if (paramvup.b()) {
          this.jdField_a_of_type_Uyk.addAll((List)paramvup.a());
        }
        for (;;)
        {
          this.jdField_a_of_type_Uyk.getLoadInfo().a(bool);
          m();
          j = i;
          i = 1;
          break;
          this.jdField_a_of_type_Uyk.setDatas((ArrayList)paramvup.a());
          if (jdField_b_of_type_JavaLangString.equals(b())) {
            this.jdField_a_of_type_Uyk.b();
          }
        }
        if (this.jdField_a_of_type_Uyk != null)
        {
          this.jdField_a_of_type_Uyk.setDatas((ArrayList)paramvup.a());
          if (jdField_b_of_type_JavaLangString.equals(b())) {
            this.jdField_a_of_type_Uyk.b();
          }
          this.jdField_a_of_type_Uyk.getLoadInfo().a(bool);
          a(paramvup.b(), paramvup.c());
          m();
          i = 1;
          break;
        }
        label556:
        i = 1;
        break;
      }
      j = i;
      i = 1;
      break;
    }
  }
  
  public void a(zxj paramzxj)
  {
    this.jdField_a_of_type_Zxj = paramzxj;
  }
  
  public void a(boolean paramBoolean)
  {
    g();
    if (this.jdField_a_of_type_Vtz != null) {
      this.jdField_a_of_type_Vtz.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public abstract String b();
  
  protected List<zxu> b()
  {
    return null;
  }
  
  public void b()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onPageUnSelected unique tabkey:" + a());
    if (this.jdField_a_of_type_Uyk != null) {
      this.jdField_a_of_type_Uyk.a();
    }
  }
  
  public void b(uzo paramuzo)
  {
    this.jdField_a_of_type_Uzo = paramuzo;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Vtz != null) {
        this.jdField_a_of_type_Vtz.a(this.jdField_a_of_type_Uzo);
      }
      a(false);
    }
  }
  
  protected boolean b()
  {
    return (this.jdField_a_of_type_Uyk != null) && (this.jdField_a_of_type_Uyk.getItemCount() > 0);
  }
  
  protected List<zxu> c()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Uyk = new uyk(new Bundle());
    this.jdField_a_of_type_Uyk.a(a());
    ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
    if (a() != null)
    {
      localExtraTypeInfo.pageType = a().b();
      this.jdField_a_of_type_Uyk.a(localExtraTypeInfo);
      this.jdField_a_of_type_Uyk.c(this.jdField_b_of_type_Int);
    }
    this.jdField_a_of_type_Uyk.setInteractor(a());
    this.jdField_a_of_type_Uyk.a(jdField_b_of_type_JavaLangString.equals(b()));
    this.jdField_a_of_type_Uyk.setOnLoadDataDelegate(new vjh(this));
    if (b() != null) {
      localArrayList.addAll(b());
    }
    localArrayList.add(this.jdField_a_of_type_Uyk);
    return localArrayList;
  }
  
  public void c()
  {
    if ((!this.jdField_a_of_type_Boolean) && (!getUserVisibleHint()))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "tryLazyLoadTab hasInit:" + this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Boolean = true;
      n();
      d();
      e();
    }
  }
  
  protected void d()
  {
    this.jdField_a_of_type_Vtz = ((vtz)a(a(), vtz.class));
    this.jdField_a_of_type_Vtz.a(b());
    this.jdField_a_of_type_Vtz.b().observe(this, new vjj(this));
    this.jdField_a_of_type_Vtz.a(this.jdField_a_of_type_Uzo);
  }
  
  protected void e()
  {
    if ((!this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Vtz.a()))
    {
      QLog.d("QCircleFolderCacheHelper", 1, "initViewData without page cache" + a());
      a(true);
      return;
    }
    g();
    QLog.d("QCircleFolderCacheHelper", 1, "initViewData with page cache" + a());
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Vtz != null) {
      this.jdField_a_of_type_Vtz.b();
    }
  }
  
  protected void g() {}
  
  public void h()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "scrollToTop" + a());
    try
    {
      this.jdField_a_of_type_Zxi.a().a().scrollToPosition(0);
      return;
    }
    catch (Exception localException)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "scrollToTop exception:" + localException.toString() + a());
    }
  }
  
  public void k()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "scrollToTopAndRefresh" + a());
    try
    {
      this.jdField_a_of_type_Zxi.a().a().g();
      return;
    }
    catch (Exception localException)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "scrollToTopAndRefresh exception:" + localException.toString() + a());
    }
  }
  
  public void l()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "showRefreshAnimation" + a());
    try
    {
      this.jdField_a_of_type_Zxi.a().a().h();
      return;
    }
    catch (Exception localException)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "showRefreshAnimation exception:" + localException.toString() + a());
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (getActivity() != null) {
      this.h = getActivity().app.getAccount();
    }
  }
  
  public void onDestroyView()
  {
    int j = 0;
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onDestroyView" + a());
    super.onDestroyView();
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_Vtz != null) && (this.jdField_a_of_type_Zxi.a() != null) && (this.jdField_a_of_type_Zxi.a().a() != null))
        {
          Object localObject1 = this.jdField_a_of_type_Zxi.a().a();
          Object localObject2 = this.jdField_a_of_type_Zxi.a().a().getLayoutManager();
          if ((localObject2 instanceof zyj))
          {
            localObject2 = (zyj)localObject2;
            localObject1 = ((RecyclerView)localObject1).getChildAt(0);
            if (localObject1 == null) {
              break label159;
            }
            j = ((zyj)localObject2).getPosition((View)localObject1);
            i = ((View)localObject1).getTop();
            this.jdField_a_of_type_Vtz.a(this.jdField_a_of_type_Uyk.a());
            this.jdField_a_of_type_Vtz.a(j, i);
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
      int i = 0;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_Vtz != null)
    {
      this.jdField_a_of_type_Vtz.b().removeObservers(this);
      this.jdField_a_of_type_Vtz = null;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onDetach()" + a());
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((getUserVisibleHint()) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      n();
      d();
      e();
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "setUserVisibleHint :" + getUserVisibleHint());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment
 * JD-Core Version:    0.7.0.1
 */