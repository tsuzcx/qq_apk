package com.tencent.biz.qqcircle.fragments;

import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import axho;
import com.tencent.biz.qqcircle.component.ComponentPageView;
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
import tra;
import trf;
import trl;
import trv;
import ttn;
import tvg;
import tvm;
import twc;
import twd;
import twe;
import tyj;
import tym;
import tzb;
import tzd;
import ydp;
import yej;
import yel;

public class QCircleFolderFollowTabFragment
  extends QCircleBaseTabFragment
  implements yel
{
  public static String k = "QCircleFolderFollowTabFragment";
  private trf jdField_a_of_type_Trf;
  private ttn jdField_a_of_type_Ttn;
  private tzd jdField_a_of_type_Tzd;
  
  private void h()
  {
    tra.a();
    tra.b();
    tra.a(getActivity());
    if (this.jdField_a_of_type_Trl != null) {
      this.jdField_a_of_type_Trl.Q_();
    }
  }
  
  private void i()
  {
    axho localaxho = (axho)BaseApplicationImpl.getApplication().getRuntime().getManager(36);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localaxho.a("140000");
    if (localAppInfo != null)
    {
      localAppInfo.buffer.clear();
      QLog.i(k, 1, "reportRedPoint clear buffer");
    }
    localaxho.b("140000");
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Tvm.a().a();
    this.jdField_a_of_type_Tvm.a().a().addOnScrollListener(new twc(this));
    yej.a().a(this);
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFeedEvent)) && (((QCircleFeedEvent)paramSimpleBaseEvent).mState == 3) && (this.jdField_a_of_type_Tzb != null)) {
      this.jdField_a_of_type_Tzb.b(((QCircleFeedEvent)paramSimpleBaseEvent).mTargetId);
    }
  }
  
  protected void a(List<tvg> paramList)
  {
    super.a(paramList);
    this.jdField_a_of_type_Ttn = new ttn();
    paramList.add(this.jdField_a_of_type_Ttn);
  }
  
  public String b()
  {
    return d;
  }
  
  protected List<ydp> b()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Trf = new trf(new Bundle());
    this.jdField_a_of_type_Trf.a(false);
    localArrayList.add(this.jdField_a_of_type_Trf);
    return localArrayList;
  }
  
  public void c()
  {
    super.c();
  }
  
  protected void c(trv paramtrv)
  {
    this.jdField_a_of_type_Tzd.a(getActivity());
  }
  
  protected void d()
  {
    super.d();
    this.jdField_a_of_type_Tzd = ((tzd)a(tzd.class));
    this.jdField_a_of_type_Tzd.a().observe(this, new twd(this));
    this.jdField_a_of_type_Tzb.c().observe(this, new twe(this));
  }
  
  protected void e()
  {
    super.e();
    h();
    i();
  }
  
  public void onDestroy()
  {
    tra.c();
    tra.b(getActivity());
    super.onDestroy();
    yej.a().b(this);
    tqb.a = false;
  }
  
  public void onDetach()
  {
    super.onDetach();
    tym.a().a(1);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (tym.a().b(1)) {
        tym.a().a(getActivity().getIntent());
      }
      tyj.a("", 22, 1L);
      return;
    }
    tym.a().a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleFolderFollowTabFragment
 * JD-Core Version:    0.7.0.1
 */