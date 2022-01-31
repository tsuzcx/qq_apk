package com.tencent.biz.qqcircle.fragments;

import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import axlx;
import com.tencent.biz.qqcircle.component.QCircleComponentPageView;
import com.tencent.biz.qqcircle.events.QCircleCloseBannerEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import tra;
import trg;
import tri;
import trq;
import tuc;
import tvv;
import tvw;
import tws;
import twt;
import twu;
import twv;
import tzv;
import tzy;
import ubm;
import ubo;
import yhy;
import yib;
import yiw;
import yiy;

public class QCircleFolderFollowTabFragment
  extends QCircleBaseTabFragment
  implements yiy
{
  public static String j = "QCircleFolderFollowTabFragment";
  private trg jdField_a_of_type_Trg;
  private tri jdField_a_of_type_Tri;
  private tuc jdField_a_of_type_Tuc;
  private ubo jdField_a_of_type_Ubo;
  
  @NotNull
  private View a(@Nullable ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560556, null);
    paramViewGroup.setOnClickListener(new twt(this));
    return paramViewGroup;
  }
  
  private void j()
  {
    tra.a();
    tra.b();
    tra.a(getActivity());
    if (this.jdField_a_of_type_Trq != null) {
      this.jdField_a_of_type_Trq.a();
    }
  }
  
  private void k()
  {
    axlx localaxlx = (axlx)BaseApplicationImpl.getApplication().getRuntime().getManager(36);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localaxlx.a("140000");
    if (localAppInfo != null)
    {
      localAppInfo.buffer.clear();
      QLog.i(j, 1, "reportRedPoint clear buffer");
    }
    localaxlx.b("140000");
  }
  
  public String a()
  {
    return j;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Tvw.a().a().a(a(paramViewGroup));
    this.jdField_a_of_type_Tvw.a().a().addOnScrollListener(new tws(this));
    yiw.a().a(this);
  }
  
  protected void a(List<tvv> paramList)
  {
    super.a(paramList);
    this.jdField_a_of_type_Tuc = new tuc();
    paramList.add(this.jdField_a_of_type_Tuc);
  }
  
  protected List<yhy> b()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Trg = new trg(new Bundle());
    this.jdField_a_of_type_Trg.a(false);
    this.jdField_a_of_type_Tri = new tri(new Bundle());
    this.jdField_a_of_type_Tri.a(false);
    localArrayList.add(this.jdField_a_of_type_Trg);
    localArrayList.add(this.jdField_a_of_type_Tri);
    return localArrayList;
  }
  
  public String c()
  {
    return c;
  }
  
  public void c()
  {
    super.c();
  }
  
  protected void d()
  {
    super.d();
    this.jdField_a_of_type_Ubo = ((ubo)a(ubo.class));
    this.jdField_a_of_type_Ubo.a().observe(this, new twu(this));
    this.jdField_a_of_type_Ubm.c().observe(this, new twv(this));
  }
  
  protected void e()
  {
    super.e();
    j();
    k();
  }
  
  protected void g()
  {
    this.jdField_a_of_type_Ubo.a(getActivity());
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    localArrayList.add(QCircleCloseBannerEvent.class);
    return localArrayList;
  }
  
  public void onDestroy()
  {
    tra.c();
    tra.b(getActivity());
    super.onDestroy();
    yiw.a().b(this);
    tqb.a = false;
  }
  
  public void onDetach()
  {
    QLog.d(j, 1, "QCircleFolderFollowTabFragment->onDetach");
    super.onDetach();
    tzy.a().a(1);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFeedEvent)) && (((QCircleFeedEvent)paramSimpleBaseEvent).mState == 3)) {
      if (this.jdField_a_of_type_Ubm != null) {
        this.jdField_a_of_type_Ubm.c(((QCircleFeedEvent)paramSimpleBaseEvent).mTargetId);
      }
    }
    while ((!(paramSimpleBaseEvent instanceof QCircleCloseBannerEvent)) || (this.jdField_a_of_type_Ubm == null)) {
      return;
    }
    this.jdField_a_of_type_Ubm.c().removeObservers(this);
    this.jdField_a_of_type_Ubm.c().postValue(null);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    QLog.d(j, 1, "QCircleFolderFollowTabFragment->setUserVisibleHint:" + paramBoolean);
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (tzy.a().b(1)) {
        tzy.a().a(getActivity().getIntent());
      }
      tzv.a("", 22, 1L);
      return;
    }
    tzy.a().a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleFolderFollowTabFragment
 * JD-Core Version:    0.7.0.1
 */