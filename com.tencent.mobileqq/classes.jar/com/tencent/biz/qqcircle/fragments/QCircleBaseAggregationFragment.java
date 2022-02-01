package com.tencent.biz.qqcircle.fragments;

import aabd;
import aabe;
import aabj;
import aabp;
import aabu;
import aacf;
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
import anzj;
import com.tencent.biz.qqcircle.launchbean.QCircleAggregationBean;
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
import uzt;
import var;
import vbe;
import vfg;
import vfi;
import vlg;
import vlh;
import vli;
import vlj;
import vws;
import vwu;
import vxq;

public abstract class QCircleBaseAggregationFragment
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
  protected aabd a;
  public aabe a;
  public QCirclePolyLikeAniView a;
  private FrameAnimationView jdField_a_of_type_ComTencentBizQqcircleWidgetsFrameAnimationView;
  protected QCircleStatusView a;
  protected uzt a;
  public vbe a;
  protected vfg a;
  public vfi a;
  protected vwu a;
  protected boolean a;
  private int jdField_b_of_type_Int = jdField_a_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  protected String h = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "QCircleBaseAggregationFragment";
    jdField_b_of_type_JavaLangString = "TAB_TYPE_FOLLOW";
  }
  
  public QCircleBaseAggregationFragment()
  {
    jdField_a_of_type_Int += 1;
  }
  
  private var a()
  {
    return new vlh(this);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    NestScrollRecyclerView localNestScrollRecyclerView = this.jdField_a_of_type_Aabd.a().a();
    if (localNestScrollRecyclerView != null) {
      localNestScrollRecyclerView.getViewTreeObserver().addOnPreDrawListener(new vlj(this, localNestScrollRecyclerView, paramInt1, paramInt2));
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
  
  private void k()
  {
    ThreadManager.getUIHandler().postDelayed(new QCircleBaseAggregationFragment.3(this), 2000L);
  }
  
  public int a()
  {
    return 2131560732;
  }
  
  public String a()
  {
    return b() + "_" + this.jdField_b_of_type_Int;
  }
  
  public List<aabe> a()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Aabd = new aabd(2131365189, c(), 3, 1);
    localArrayList.add(this.jdField_a_of_type_Aabd);
    this.jdField_a_of_type_Vfi = new vfi();
    this.jdField_a_of_type_Vfi.a(a());
    localArrayList.add(this.jdField_a_of_type_Vfi);
    this.jdField_a_of_type_Vfg = new vfg();
    localArrayList.add(this.jdField_a_of_type_Vfg);
    a(localArrayList);
    return localArrayList;
  }
  
  public vbe a()
  {
    return this.jdField_a_of_type_Vbe;
  }
  
  public void a()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onPageUnSelected unique tabkey:" + a());
    if (this.jdField_a_of_type_Uzt != null) {
      this.jdField_a_of_type_Uzt.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      c(bool);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptScrollLRFlag(false);
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onPageSelected unique tabkey:" + a());
      if (this.jdField_a_of_type_Uzt != null) {
        this.jdField_a_of_type_Uzt.a(paramInt);
      }
      return;
    }
  }
  
  public void a(aabe paramaabe)
  {
    this.jdField_a_of_type_Aabe = paramaabe;
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    QLog.d("QCircleFolderCacheHelper", 1, "scrollToPosWithOffset pos:" + paramInt1 + ",top:" + paramInt2 + "." + a());
    try
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof aacf)) {
        ((aacf)paramRecyclerView).scrollToPositionWithOffset(paramInt1, paramInt2);
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
    this.jdField_a_of_type_Aabd.a().setEnableRefresh(true);
    this.jdField_a_of_type_Aabd.a().setEnableLoadMore(true);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView = this.jdField_a_of_type_Aabd.a();
    a((ViewGroup)this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(QCirclePolyLikeAniView paramQCirclePolyLikeAniView)
  {
    this.jdField_a_of_type_ComTencentBizQqcirclePolylikeQCirclePolyLikeAniView = paramQCirclePolyLikeAniView;
  }
  
  protected void a(List<aabe> paramList) {}
  
  public void a(vbe paramvbe)
  {
    this.jdField_a_of_type_Vbe = paramvbe;
  }
  
  public void a(vxq<List<FeedCloudMeta.StFeed>> paramvxq)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqcircleWidgetsFrameAnimationView != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeView(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsFrameAnimationView);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsFrameAnimationView = null;
    }
    if (paramvxq == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "handleFeedDataRsp() return unexpected data！");
      return;
    }
    boolean bool = paramvxq.a();
    int i;
    switch (paramvxq.a())
    {
    default: 
      i = 0;
    }
    while ((i != 0) && (this.jdField_a_of_type_Uzt != null))
    {
      this.jdField_a_of_type_Uzt.a(true, bool);
      return;
      QLog.e(jdField_a_of_type_JavaLangString, 1, "handleFeedDataRsp() return empty");
      if ((paramvxq.b()) && (this.jdField_a_of_type_Uzt != null) && (this.jdField_a_of_type_Uzt.getItemCount() > 0))
      {
        this.jdField_a_of_type_Uzt.getLoadInfo().a(bool);
        i = 1;
      }
      else
      {
        if ((this.jdField_a_of_type_Uzt != null) && (!this.jdField_a_of_type_Uzt.a()))
        {
          if (!b()) {
            break label216;
          }
          QQToast.a(BaseApplicationImpl.getContext(), 1, anzj.a(2131718459), 1).a();
        }
        for (;;)
        {
          i = 1;
          break;
          label216:
          if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null) {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.b(null);
          }
        }
        if (paramvxq.a() == null) {}
        for (String str = anzj.a(2131718459);; str = paramvxq.a())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "handleFeedDataRsp() return error！errMsg:" + str);
          if ((this.jdField_a_of_type_Uzt == null) || (this.jdField_a_of_type_Uzt.a())) {
            break label527;
          }
          if (!b()) {
            break label329;
          }
          vws.a(paramvxq.a(), BaseApplicationImpl.getContext(), 1, str, 1);
          i = 1;
          break;
        }
        label329:
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null)
        {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.b(str);
          i = 1;
          continue;
          i = 0;
          continue;
          if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView != null) {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleStatusView.a();
          }
          if (this.jdField_a_of_type_Uzt != null)
          {
            if (paramvxq.b()) {
              this.jdField_a_of_type_Uzt.addAll((List)paramvxq.a());
            }
            for (;;)
            {
              this.jdField_a_of_type_Uzt.getLoadInfo().a(bool);
              k();
              i = 1;
              break;
              this.jdField_a_of_type_Uzt.setDatas((ArrayList)paramvxq.a());
              if (jdField_b_of_type_JavaLangString.equals(b())) {
                this.jdField_a_of_type_Uzt.b();
              }
            }
            if (this.jdField_a_of_type_Uzt != null)
            {
              this.jdField_a_of_type_Uzt.setDatas((ArrayList)paramvxq.a());
              if (jdField_b_of_type_JavaLangString.equals(b())) {
                this.jdField_a_of_type_Uzt.b();
              }
              this.jdField_a_of_type_Uzt.getLoadInfo().a(bool);
              a(paramvxq.b(), paramvxq.c());
              k();
              i = 1;
              continue;
            }
          }
        }
        label527:
        i = 1;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    f();
    if (this.jdField_a_of_type_Vwu != null)
    {
      QCircleAggregationBean localQCircleAggregationBean = (QCircleAggregationBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      this.jdField_a_of_type_Vwu.a(localQCircleAggregationBean.getTroopUin(), paramBoolean);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public abstract String b();
  
  protected List<aabp> b()
  {
    return null;
  }
  
  public void b()
  {
    if ((!this.jdField_a_of_type_Boolean) && (!getUserVisibleHint()))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "tryLazyLoadTab hasInit:" + this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Boolean = true;
      c();
      d();
    }
  }
  
  public void b(vbe paramvbe)
  {
    this.jdField_a_of_type_Vbe = paramvbe;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Vwu != null) {
        this.jdField_a_of_type_Vwu.a(this.jdField_a_of_type_Vbe);
      }
      a(false);
    }
  }
  
  protected boolean b()
  {
    return (this.jdField_a_of_type_Uzt != null) && (this.jdField_a_of_type_Uzt.getItemCount() > 0);
  }
  
  protected List<aabp> c()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Uzt = new uzt(new Bundle());
    this.jdField_a_of_type_Uzt.a(a());
    ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
    if (a() != null)
    {
      localExtraTypeInfo.pageType = a().b();
      this.jdField_a_of_type_Uzt.a(localExtraTypeInfo);
      this.jdField_a_of_type_Uzt.c(this.jdField_b_of_type_Int);
    }
    this.jdField_a_of_type_Uzt.setInteractor(a());
    this.jdField_a_of_type_Uzt.a(jdField_b_of_type_JavaLangString.equals(b()));
    this.jdField_a_of_type_Uzt.setOnLoadDataDelegate(new vlg(this));
    if (b() != null) {
      localArrayList.addAll(b());
    }
    localArrayList.add(this.jdField_a_of_type_Uzt);
    return localArrayList;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_Vwu = ((vwu)a(a(), vwu.class));
    this.jdField_a_of_type_Vwu.b(b());
    this.jdField_a_of_type_Vwu.a().observe(this, new vli(this));
    this.jdField_a_of_type_Vwu.a(this.jdField_a_of_type_Vbe);
  }
  
  protected void d()
  {
    if ((!this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Vwu.a()))
    {
      QLog.d("QCircleFolderCacheHelper", 1, "initViewData without page cache" + a());
      a(true);
      return;
    }
    f();
    QLog.d("QCircleFolderCacheHelper", 1, "initViewData with page cache" + a());
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Vwu != null)
    {
      QCircleAggregationBean localQCircleAggregationBean = (QCircleAggregationBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      this.jdField_a_of_type_Vwu.a(localQCircleAggregationBean.getTroopUin());
    }
  }
  
  protected void f() {}
  
  public void g()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "scrollToTop" + a());
    try
    {
      this.jdField_a_of_type_Aabd.a().a().scrollToPosition(0);
      return;
    }
    catch (Exception localException)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "scrollToTop exception:" + localException.toString() + a());
    }
  }
  
  public void h()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "scrollToTopAndRefresh" + a());
    try
    {
      this.jdField_a_of_type_Aabd.a().a().g();
      return;
    }
    catch (Exception localException)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "scrollToTopAndRefresh exception:" + localException.toString() + a());
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
        if ((this.jdField_a_of_type_Vwu != null) && (this.jdField_a_of_type_Aabd.a() != null) && (this.jdField_a_of_type_Aabd.a().a() != null))
        {
          Object localObject1 = this.jdField_a_of_type_Aabd.a().a();
          Object localObject2 = this.jdField_a_of_type_Aabd.a().a().getLayoutManager();
          if ((localObject2 instanceof aacf))
          {
            localObject2 = (aacf)localObject2;
            localObject1 = ((RecyclerView)localObject1).getChildAt(0);
            if (localObject1 == null) {
              break label159;
            }
            j = ((aacf)localObject2).getPosition((View)localObject1);
            i = ((View)localObject1).getTop();
            this.jdField_a_of_type_Vwu.a(this.jdField_a_of_type_Uzt.a());
            this.jdField_a_of_type_Vwu.a(j, i);
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
    if (this.jdField_a_of_type_Vwu != null)
    {
      this.jdField_a_of_type_Vwu.a().removeObservers(this);
      this.jdField_a_of_type_Vwu = null;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "onDetach()" + a());
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((getUserVisibleHint()) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      c();
      d();
    }
    QLog.d(jdField_a_of_type_JavaLangString, 4, "setUserVisibleHint :" + getUserVisibleHint());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBaseAggregationFragment
 * JD-Core Version:    0.7.0.1
 */