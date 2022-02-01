package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import olh;
import oqv;
import oqy;
import piq;
import pkh;
import pkn;
import ppx;
import pti;
import pvg;
import pvj;
import pvp;
import pwb;
import tkq;

public class ReadInJoyBBCircleFragment
  extends ReadInJoyBaseFragment
  implements pvg
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  protected oqv a;
  private pkn jdField_a_of_type_Pkn = new pkn();
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    Object localObject = getActivity();
    if (localObject == null) {}
    KandianRedDotInfo localKandianRedDotInfo;
    do
    {
      return;
      localObject = ((Activity)localObject).getIntent();
      localKandianRedDotInfo = KandianSubscribeManager.a();
    } while (localKandianRedDotInfo == null);
    ((Intent)localObject).putExtra("kandian_feeds_red_pnt_info", localKandianRedDotInfo);
  }
  
  private void b()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (bool) {
          return;
        }
        if ((this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
          continue;
        }
        Object localObject = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131376226);
        this.jdField_a_of_type_Oqv = ((oqv)pkh.a.remove(Integer.valueOf(70)));
        if (this.jdField_a_of_type_Oqv == null)
        {
          this.jdField_a_of_type_Oqv = new oqv((Activity)this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_Oqv.a(70);
          this.jdField_a_of_type_Oqv.b(0);
          this.jdField_a_of_type_Oqv.a((ViewGroup)localObject);
          this.jdField_a_of_type_Oqv.b(true);
          this.jdField_a_of_type_Oqv.a();
          this.jdField_a_of_type_Oqv.a(this.jdField_a_of_type_Tds, this.d);
          localObject = this.jdField_a_of_type_Oqv.a();
          if ((localObject != null) && ((localObject instanceof ReadInJoyBaseListViewGroup))) {
            ((ReadInJoyBaseListViewGroup)localObject).h();
          }
          pwb.a(0, piq.a(), 0);
          this.jdField_a_of_type_Boolean = true;
          continue;
        }
        this.jdField_a_of_type_Oqv.a(localViewGroup);
      }
      finally {}
      this.jdField_a_of_type_Oqv.c();
      this.jdField_a_of_type_Oqv.b();
    }
  }
  
  private void c()
  {
    ThreadManager.executeOnSubThread(new ReadInJoyBBCircleFragment.1(this));
  }
  
  public int a()
  {
    return 70;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Oqv != null)
    {
      this.jdField_a_of_type_Oqv.a(true);
      return;
    }
    oqy.e(a());
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    if (this.jdField_a_of_type_Oqv != null) {
      this.jdField_a_of_type_Oqv.h();
    }
    QLog.d("ReadInJoyBBCircleFragment", 2, "[notifyShowSelf] show!");
    a();
    olh.a(null, "", "0X80093F0", "0X80093F0", 0, 0, "", "", "", "", false);
    if ((this.jdField_a_of_type_Oqv != null) && ((this.jdField_a_of_type_Oqv.a() instanceof ReadInJoyListViewGroup)))
    {
      paramActivity = ((ReadInJoyListViewGroup)this.jdField_a_of_type_Oqv.a()).a().a().iterator();
      while (paramActivity.hasNext())
      {
        paramBundle = (tkq)paramActivity.next();
        if ((paramBundle instanceof ReadInJoyDiandianHeaderController)) {
          paramBundle.e();
        }
      }
    }
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_Oqv != null) {
      this.jdField_a_of_type_Oqv.a(true);
    }
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Oqv != null) {
      this.jdField_a_of_type_Oqv.g();
    }
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Oqv != null) {
      this.jdField_a_of_type_Oqv.k();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Oqv != null) {
      this.jdField_a_of_type_Oqv.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    View localView = this.jdField_a_of_type_Oqv.a();
    if (((localView instanceof ReadInJoyListViewGroup)) && (((ReadInJoyListViewGroup)localView).a())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (Build.VERSION.SDK_INT >= 11)) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().setFlags(16777216, 16777216);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560240, paramViewGroup, false);
    if ((!getUserVisibleHint()) && (pkh.c())) {}
    for (;;)
    {
      VideoReport.setPageId(this.jdField_a_of_type_AndroidViewView, "14");
      VideoReport.setPageParams(this.jdField_a_of_type_AndroidViewView, new pti().a(Integer.valueOf(70)).a());
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      b();
    }
  }
  
  public void onDestroy()
  {
    c();
    super.onDestroy();
    pvj.a().a();
    if (this.jdField_a_of_type_Oqv != null)
    {
      this.jdField_a_of_type_Oqv.d();
      localObject = this.jdField_a_of_type_Oqv.a();
      if ((localObject != null) && ((localObject instanceof ReadInJoyBaseListViewGroup))) {
        ((ReadInJoyBaseListViewGroup)localObject).i();
      }
    }
    this.jdField_a_of_type_Oqv = null;
    Object localObject = (QQAppInterface)pkh.a();
    if (localObject != null)
    {
      localObject = (pvp)((QQAppInterface)localObject).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if ((localObject != null) && (((pvp)localObject).a() != null))
      {
        localObject = ((pvp)localObject).a().a();
        if (localObject != null) {
          ((ReadInJoyUserInfoModule)localObject).b();
        }
      }
    }
  }
  
  public void onDestroyView()
  {
    ((KandianSubscribeManager)pkh.a().getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER)).a(this);
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_Oqv != null) {
      this.jdField_a_of_type_Oqv.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Oqv != null) {
      this.jdField_a_of_type_Oqv.g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Oqv != null) && (this.c)) {
      this.jdField_a_of_type_Oqv.h();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Oqv != null) {
      this.jdField_a_of_type_Oqv.e();
    }
    this.jdField_a_of_type_Pkn.a();
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Oqv != null) {
      this.jdField_a_of_type_Oqv.f();
    }
    if (!BaseActivity.mAppForground) {
      this.jdField_a_of_type_Pkn.b();
    }
    if (getActivity().isFinishing())
    {
      pwb.a(1, piq.a(), 0);
      piq.b();
    }
  }
  
  public void y_()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBBCircleFragment
 * JD-Core Version:    0.7.0.1
 */