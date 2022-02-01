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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import odq;
import oiz;
import ojc;
import ozk;
import pay;
import pbm;
import pgt;
import pil;
import pkj;
import pkm;
import pks;
import ple;
import sxf;

public class ReadInJoyBBCircleFragment
  extends ReadInJoyBaseFragment
  implements pkj
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  protected oiz a;
  private pbm jdField_a_of_type_Pbm = new pbm();
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
        Object localObject = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131375979);
        this.jdField_a_of_type_Oiz = ((oiz)pay.a.remove(Integer.valueOf(70)));
        if (this.jdField_a_of_type_Oiz == null)
        {
          this.jdField_a_of_type_Oiz = new oiz((Activity)this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_Oiz.a(70);
          this.jdField_a_of_type_Oiz.b(0);
          this.jdField_a_of_type_Oiz.a((ViewGroup)localObject);
          this.jdField_a_of_type_Oiz.a();
          this.jdField_a_of_type_Oiz.a(this.jdField_a_of_type_Sqh, this.d);
          localObject = this.jdField_a_of_type_Oiz.a();
          if ((localObject != null) && ((localObject instanceof ReadInJoyBaseListViewGroup))) {
            ((ReadInJoyBaseListViewGroup)localObject).h();
          }
          ple.a(0, ozk.a(), 0);
          this.jdField_a_of_type_Boolean = true;
          continue;
        }
        this.jdField_a_of_type_Oiz.a(localViewGroup);
      }
      finally {}
      this.jdField_a_of_type_Oiz.c();
      this.jdField_a_of_type_Oiz.b();
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
    if (this.jdField_a_of_type_Oiz != null)
    {
      this.jdField_a_of_type_Oiz.a(true);
      return;
    }
    ojc.e(a());
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    if (this.jdField_a_of_type_Oiz != null) {
      this.jdField_a_of_type_Oiz.h();
    }
    QLog.d("ReadInJoyBBCircleFragment", 2, "[notifyShowSelf] show!");
    a();
    odq.a(null, "", "0X80093F0", "0X80093F0", 0, 0, "", "", "", "", false);
    if ((this.jdField_a_of_type_Oiz != null) && ((this.jdField_a_of_type_Oiz.a() instanceof ReadInJoyListViewGroup)))
    {
      paramActivity = ((ReadInJoyListViewGroup)this.jdField_a_of_type_Oiz.a()).a().a().iterator();
      while (paramActivity.hasNext())
      {
        paramBundle = (sxf)paramActivity.next();
        if ((paramBundle instanceof ReadInJoyDiandianHeaderController)) {
          paramBundle.e();
        }
      }
    }
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_Oiz != null) {
      this.jdField_a_of_type_Oiz.a(true);
    }
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Oiz != null) {
      this.jdField_a_of_type_Oiz.g();
    }
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Oiz != null) {
      this.jdField_a_of_type_Oiz.k();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Oiz != null) {
      this.jdField_a_of_type_Oiz.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    View localView = this.jdField_a_of_type_Oiz.a();
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
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560194, paramViewGroup, false);
    if ((!getUserVisibleHint()) && (pay.n())) {}
    for (;;)
    {
      VideoReport.setPageId(this.jdField_a_of_type_AndroidViewView, "14");
      VideoReport.setPageParams(this.jdField_a_of_type_AndroidViewView, new pil().a(Integer.valueOf(70)).a());
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
    pkm.a().a();
    if (this.jdField_a_of_type_Oiz != null)
    {
      this.jdField_a_of_type_Oiz.d();
      localObject = this.jdField_a_of_type_Oiz.a();
      if ((localObject != null) && ((localObject instanceof ReadInJoyBaseListViewGroup))) {
        ((ReadInJoyBaseListViewGroup)localObject).i();
      }
    }
    this.jdField_a_of_type_Oiz = null;
    Object localObject = (QQAppInterface)pay.a();
    if (localObject != null)
    {
      localObject = (pks)((QQAppInterface)localObject).getManager(163);
      if ((localObject != null) && (((pks)localObject).a() != null))
      {
        localObject = ((pks)localObject).a().a();
        if (localObject != null) {
          ((ReadInJoyUserInfoModule)localObject).b();
        }
      }
    }
  }
  
  public void onDestroyView()
  {
    ((KandianSubscribeManager)pay.a().getManager(280)).a(this);
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_Oiz != null) {
      this.jdField_a_of_type_Oiz.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Oiz != null) {
      this.jdField_a_of_type_Oiz.g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Oiz != null) && (this.c)) {
      this.jdField_a_of_type_Oiz.h();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Oiz != null) {
      this.jdField_a_of_type_Oiz.e();
    }
    this.jdField_a_of_type_Pbm.a();
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Oiz != null) {
      this.jdField_a_of_type_Oiz.f();
    }
    if (!BaseActivity.mAppForground) {
      this.jdField_a_of_type_Pbm.b();
    }
    if (getActivity().isFinishing())
    {
      ple.a(1, ozk.a(), 0);
      ozk.b();
    }
  }
  
  public void w_()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBBCircleFragment
 * JD-Core Version:    0.7.0.1
 */