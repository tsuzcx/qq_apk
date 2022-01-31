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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import nol;
import nte;
import nth;
import olm;
import onh;
import onz;
import osd;
import osg;
import osl;
import osx;
import rnv;

public class ReadInJoyBBCircleFragment
  extends ReadInJoyBaseFragment
  implements osd
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  protected nte a;
  private onz jdField_a_of_type_Onz = new onz();
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
        Object localObject = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131374833);
        this.jdField_a_of_type_Nte = ((nte)onh.a.remove(Integer.valueOf(70)));
        if (this.jdField_a_of_type_Nte == null)
        {
          this.jdField_a_of_type_Nte = new nte((Activity)this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_Nte.a(70);
          this.jdField_a_of_type_Nte.b(0);
          this.jdField_a_of_type_Nte.a((ViewGroup)localObject);
          this.jdField_a_of_type_Nte.a();
          this.jdField_a_of_type_Nte.a(this.jdField_a_of_type_Rhm, this.d);
          localObject = this.jdField_a_of_type_Nte.a();
          if ((localObject != null) && ((localObject instanceof ReadInJoyBaseListViewGroup))) {
            ((ReadInJoyBaseListViewGroup)localObject).h();
          }
          osx.a(0, olm.a(), 0);
          ((KandianSubscribeManager)onh.a().getManager(280)).a(this);
          this.jdField_a_of_type_Boolean = true;
          continue;
        }
        this.jdField_a_of_type_Nte.a(localViewGroup);
      }
      finally {}
      this.jdField_a_of_type_Nte.c();
      this.jdField_a_of_type_Nte.b();
    }
  }
  
  private void c()
  {
    ThreadManager.executeOnSubThread(new ReadInJoyBBCircleFragment.1(this));
  }
  
  public void A_()
  {
    a();
  }
  
  public int a()
  {
    return 70;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Nte != null)
    {
      this.jdField_a_of_type_Nte.a(true);
      return;
    }
    nth.e(a());
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (!this.jdField_a_of_type_Boolean) {
      b();
    }
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.h();
    }
    QLog.d("ReadInJoyBBCircleFragment", 2, "[notifyShowSelf] show!");
    a();
    nol.a(null, "", "0X80093F0", "0X80093F0", 0, 0, "", "", "", "", false);
    ((KandianSubscribeManager)onh.a().getManager(280)).a(this);
    if ((this.jdField_a_of_type_Nte != null) && ((this.jdField_a_of_type_Nte.a() instanceof ReadInJoyListViewGroup)))
    {
      paramActivity = ((ReadInJoyListViewGroup)this.jdField_a_of_type_Nte.a()).a().iterator();
      while (paramActivity.hasNext())
      {
        paramBundle = (rnv)paramActivity.next();
        if ((paramBundle instanceof ReadInJoyDiandianHeaderController)) {
          paramBundle.e();
        }
      }
    }
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.a(true);
    }
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.g();
    }
  }
  
  public void i()
  {
    super.i();
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.k();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    View localView = this.jdField_a_of_type_Nte.a();
    if (((localView instanceof ReadInJoyListViewGroup)) && (((ReadInJoyListViewGroup)localView).e())) {
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
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559931, paramViewGroup, false);
    if ((!getUserVisibleHint()) && (onh.l())) {}
    for (;;)
    {
      return this.jdField_a_of_type_AndroidViewView;
      b();
    }
  }
  
  public void onDestroy()
  {
    c();
    super.onDestroy();
    osg.a().a();
    if (this.jdField_a_of_type_Nte != null)
    {
      this.jdField_a_of_type_Nte.d();
      localObject = this.jdField_a_of_type_Nte.a();
      if ((localObject != null) && ((localObject instanceof ReadInJoyBaseListViewGroup))) {
        ((ReadInJoyBaseListViewGroup)localObject).i();
      }
    }
    this.jdField_a_of_type_Nte = null;
    Object localObject = (QQAppInterface)onh.a();
    if (localObject != null)
    {
      localObject = (osl)((QQAppInterface)localObject).getManager(163);
      if ((localObject != null) && (((osl)localObject).a() != null))
      {
        localObject = ((osl)localObject).a().a();
        if (localObject != null) {
          ((ReadInJoyUserInfoModule)localObject).b();
        }
      }
    }
  }
  
  public void onDestroyView()
  {
    ((KandianSubscribeManager)onh.a().getManager(280)).b(this);
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Nte != null) && (this.c)) {
      this.jdField_a_of_type_Nte.h();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.e();
    }
    this.jdField_a_of_type_Onz.a();
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.f();
    }
    if (!BaseActivity.mAppForground) {
      this.jdField_a_of_type_Onz.b();
    }
    if (getActivity().isFinishing())
    {
      osx.a(1, olm.a(), 0);
      olm.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBBCircleFragment
 * JD-Core Version:    0.7.0.1
 */