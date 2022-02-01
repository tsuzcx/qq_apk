package com.tencent.biz.qqcircle.fragments.main;

import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.events.QCircleCloseBannerEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedListRefreshEvent;
import com.tencent.biz.qqcircle.events.QCircleLazyLoadTabEvent;
import com.tencent.biz.qqcircle.fragments.QCircleBaseAggregationFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import tlg;
import uxx;
import uyk;
import vee;
import vlw;
import vlx;
import vqu;
import vrf;
import vri;
import vrr;
import vrt;
import vtv;
import vup;
import zwp;
import zwr;
import zxi;
import zxj;
import zxo;

public class QCircleAggregationFragment
  extends QCircleBaseAggregationFragment
  implements zwr
{
  public static String i = "QCircleAggregationFragment";
  private vee a;
  private boolean b;
  
  @NotNull
  private View a(@Nullable ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560725, null);
    paramViewGroup.setOnClickListener(new vlx(this));
    return paramViewGroup;
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      break label7;
    }
    label7:
    label94:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Uyk != null)
      {
        ArrayList localArrayList = this.jdField_a_of_type_Uyk.getDataList();
        if (localArrayList == null) {
          break;
        }
        int j = localArrayList.size() - 1;
        for (;;)
        {
          if (j < 0) {
            break label94;
          }
          FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)localArrayList.get(j);
          if (paramString.equals(localStFeed.poster.id.get()))
          {
            if (this.jdField_a_of_type_Vtv == null) {
              break;
            }
            this.jdField_a_of_type_Vtv.c(localStFeed.id.get());
            return;
          }
          j -= 1;
        }
      }
    }
  }
  
  private void k()
  {
    uxx.b();
    uxx.a();
    uxx.a(getActivity());
    if (this.jdField_a_of_type_Uyk != null) {
      this.jdField_a_of_type_Uyk.b();
    }
    tlg.a();
  }
  
  private void l()
  {
    ((vqu)BaseApplicationImpl.getApplication().getRuntime().getManager(376)).a("circle_entrance", null);
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Zxi.a().a().a(a(paramViewGroup));
    this.jdField_a_of_type_Zxi.a().a().addOnScrollListener(new vlw(this));
    zwp.a().a(this);
  }
  
  public void a(List<zxj> paramList)
  {
    super.a(paramList);
    this.jdField_a_of_type_Vee = new vee();
    this.jdField_a_of_type_Vee.a(a());
    paramList.add(this.jdField_a_of_type_Vee);
  }
  
  public void a(vup<List<FeedCloudMeta.StFeed>> paramvup)
  {
    super.a(paramvup);
    if ((paramvup != null) && (!paramvup.b()))
    {
      QLog.d(i, 1, "handleFeedDataRsp is refresh reportRedPoint");
      l();
    }
  }
  
  public String b()
  {
    return jdField_b_of_type_JavaLangString;
  }
  
  public int c()
  {
    return 1;
  }
  
  public String c()
  {
    return i;
  }
  
  public void c()
  {
    super.c();
  }
  
  public String d()
  {
    return "follow_page";
  }
  
  public void d()
  {
    super.d();
    l();
  }
  
  public void f() {}
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    localArrayList.add(QCircleCloseBannerEvent.class);
    localArrayList.add(QCircleLazyLoadTabEvent.class);
    localArrayList.add(QCircleFeedListRefreshEvent.class);
    return localArrayList;
  }
  
  public void onDestroy()
  {
    uxx.c();
    uxx.b(getActivity());
    super.onDestroy();
    zwp.a().b(this);
    uxb.a = false;
  }
  
  public void onDetach()
  {
    QLog.d(i, 1, "QCircleAggregationFragment->onDetach");
    super.onDetach();
    vri.a().b(c());
  }
  
  public void onPause()
  {
    super.onPause();
    if (getUserVisibleHint()) {
      vri.a().d(c());
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    QCircleFeedEvent localQCircleFeedEvent;
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent))
    {
      localQCircleFeedEvent = (QCircleFeedEvent)paramSimpleBaseEvent;
      if (localQCircleFeedEvent.mState == 3) {
        if (this.jdField_a_of_type_Vtv != null) {
          this.jdField_a_of_type_Vtv.c(((QCircleFeedEvent)paramSimpleBaseEvent).mTargetId);
        }
      }
    }
    label41:
    do
    {
      do
      {
        do
        {
          break label41;
          do
          {
            return;
          } while (localQCircleFeedEvent.mState != 6);
          a(((QCircleFeedEvent)paramSimpleBaseEvent).mTargetId);
          return;
          if (!(paramSimpleBaseEvent instanceof QCircleCloseBannerEvent)) {
            break;
          }
        } while (this.jdField_a_of_type_Vtv == null);
        this.jdField_a_of_type_Vtv.b().removeObservers(this);
        this.jdField_a_of_type_Vtv.b().postValue(null);
        return;
        if (!(paramSimpleBaseEvent instanceof QCircleLazyLoadTabEvent)) {
          break;
        }
        b();
      } while (this.jdField_b_of_type_Boolean);
      k();
      this.jdField_b_of_type_Boolean = true;
      return;
    } while ((!(paramSimpleBaseEvent instanceof QCircleFeedListRefreshEvent)) || (((QCircleFeedListRefreshEvent)paramSimpleBaseEvent).mPageType != 1));
    a(false);
  }
  
  public void onResume()
  {
    super.onResume();
    if (getUserVisibleHint()) {
      vri.a().c(c());
    }
    f();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    QLog.d(i, 1, "QCircleAggregationFragment->setUserVisibleHint:" + paramBoolean);
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (vri.a().d()) {
        vri.a().a(c(), getActivity().getIntent());
      }
      vri.a().a(c());
      vri.a().c(c());
      vrf.a("", 22, 1);
      vrr.a().a(new vrt().a("main").b("impression").a(a()));
      return;
    }
    vri.a().d(c());
    vri.a().b(c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleAggregationFragment
 * JD-Core Version:    0.7.0.1
 */