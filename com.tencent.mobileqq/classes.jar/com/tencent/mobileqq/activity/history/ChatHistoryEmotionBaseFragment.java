package com.tencent.mobileqq.activity.history;

import aarr;
import aars;
import aasg;
import aegp;
import aegr;
import afci;
import afwf;
import afxr;
import afxt;
import afxu;
import afxv;
import afxw;
import agbq;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import aodo;
import aoeb;
import aptx;
import asun;
import asur;
import asuw;
import bbfj;
import bbgu;
import bcql;
import bfnk;
import bfpc;
import bfpp;
import bicz;
import bidv;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryEmotionBaseFragment
  extends ChatHistoryBaseFragment
  implements aars, aegr, Handler.Callback
{
  aarr jdField_a_of_type_Aarr;
  private afci jdField_a_of_type_Afci;
  private List<aoeb> jdField_a_of_type_JavaUtilList;
  protected final MqqHandler a;
  private bbgu b;
  
  public ChatHistoryEmotionBaseFragment()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new bfnk(Looper.getMainLooper(), this, true);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, aasg paramaasg)
  {
    if ((this.b != null) && (this.b.isShowing())) {
      this.b.dismiss();
    }
    bbgu localbbgu = new bbgu(getActivity(), 2131755791);
    localbbgu.setContentView(2131558906);
    this.b = localbbgu;
    this.b.setTitle(paramString1);
    this.b.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131690596);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131691035);
    }
    this.b.setNegativeButton(paramString1, new afxv(this, paramaasg));
    this.b.setPositiveButton(paramString2, new afxw(this, paramaasg));
    this.b.setCancelable(true);
    this.b.setCanceledOnTouchOutside(false);
    this.b.show();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Aarr != null) && (this.jdField_a_of_type_Aarr.jdField_a_of_type_Aodo != null) && (this.jdField_a_of_type_Aarr.jdField_a_of_type_Aodo.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "onEmotionLoaded, mEmotionView.mAdapter is null");
      }
      this.jdField_a_of_type_Afwf.a(false);
      return;
    }
    this.jdField_a_of_type_Afwf.a(true);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Aarr != null) {
      this.jdField_a_of_type_Aarr.a(paramLong);
    }
  }
  
  public void a(aoeb paramaoeb)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramaoeb);
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaUtilList != null) {}
    for (int i = this.jdField_a_of_type_JavaUtilList.size() + 0;; i = 0)
    {
      if (i >= 20) {
        bool = true;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.history.BaseFragment", 2, "isOverLimit");
        }
        aptx.a(2131692563);
      }
      return bool;
    }
  }
  
  protected void b() {}
  
  public void b(aoeb paramaoeb)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramaoeb);
  }
  
  void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      t();
      s();
      return;
    }
    u();
  }
  
  protected int c()
  {
    return 1602;
  }
  
  protected void c() {}
  
  public int d()
  {
    return getResources().getDimensionPixelSize(2131298865);
  }
  
  protected void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_Agbq.a(localArrayList);
  }
  
  public void e()
  {
    super.e();
    u();
    if (this.jdField_a_of_type_Aarr != null) {
      this.jdField_a_of_type_Aarr.a();
    }
    if ((this.jdField_a_of_type_Aarr != null) && (this.jdField_a_of_type_Aarr.jdField_a_of_type_Aodo != null) && (this.jdField_a_of_type_Aarr.jdField_a_of_type_Aodo.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "doOnResume, mEmotionView.mAdapter is null");
      }
      if (this.jdField_a_of_type_Afwf != null) {
        this.jdField_a_of_type_Afwf.a(false);
      }
    }
    while (this.jdField_a_of_type_Afwf == null) {
      return;
    }
    this.jdField_a_of_type_Afwf.a(true);
  }
  
  public void g()
  {
    super.g();
    aegp.a().b(this);
    if (this.jdField_a_of_type_Aarr != null) {
      this.jdField_a_of_type_Aarr.c();
    }
    if (this.jdField_a_of_type_Afci != null) {
      this.jdField_a_of_type_Afci.b();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      return true;
      if (this.jdField_a_of_type_Aarr != null) {
        this.jdField_a_of_type_Aarr.f();
      }
      u();
      p();
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      u();
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      bidv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), d());
      u();
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      u();
      i = paramMessage.arg1;
    } while (!bicz.a(i));
    if (bicz.d(i))
    {
      getString(2131694922);
      paramMessage = "";
      if (bicz.b(i))
      {
        getString(2131694922);
        paramMessage = getString(2131692190);
      }
      for (;;)
      {
        afxu localafxu = new afxu(this);
        a(getString(2131698751), paramMessage, null, null, localafxu);
        return true;
        if (bicz.c(i))
        {
          getString(2131694922);
          paramMessage = getString(2131692188);
        }
      }
    }
    paramMessage = (String)paramMessage.obj;
    bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramMessage, 1).b(d());
    return true;
  }
  
  protected void k()
  {
    if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      CheckPermission.requestStorePermission(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
      return;
    }
    if (!bbfj.d(BaseApplication.getContext()))
    {
      bcql.a(getActivity(), 2131694673, 1).b(getResources().getDimensionPixelSize(2131298865));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (aoeb)((Iterator)localObject1).next();
      if ((((aoeb)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic))
      {
        localArrayList.add(asur.a((MessageForPic)((aoeb)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord));
        continue;
        aptx.c(2131692560);
        return;
      }
    }
    Object localObject1 = new asun(getActivity());
    Object localObject2 = (asuw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(324);
    ((asuw)localObject2).a(new afxr(this, (asun)localObject1, (asuw)localObject2, localArrayList));
    ((asuw)localObject2).a(localArrayList, true);
    ((asuw)localObject2).a(localArrayList, 1, 5);
    r();
  }
  
  protected void m()
  {
    if (!bbfj.d(BaseApplication.getContext()))
    {
      bcql.a(getActivity(), 2131694673, 1).b(getResources().getDimensionPixelSize(2131298865));
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((ChatMessage)((aoeb)localIterator.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
      if (this.jdField_a_of_type_Afci == null)
      {
        this.jdField_a_of_type_Afci = new afci(getActivity(), 3);
        this.jdField_a_of_type_Afci.a();
      }
      this.jdField_a_of_type_Afci.a(localArrayList);
      q();
      return;
    }
    aptx.c(2131692560);
  }
  
  protected void n()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = 0 + this.jdField_a_of_type_JavaUtilList.size();
    }
    if (i == 0)
    {
      aptx.c(2131692560);
      return;
    }
    bfpc localbfpc = (bfpc)bfpp.a(getActivity(), null);
    localbfpc.a(2131696396);
    localbfpc.a(getActivity().getString(2131692409), 3);
    localbfpc.c(2131690596);
    localbfpc.a(new afxt(this, localbfpc));
    localbfpc.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    aegp.a().a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Aarr == null)
    {
      this.jdField_a_of_type_Aarr = new aarr();
      this.jdField_a_of_type_Aarr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_Aarr.jdField_a_of_type_Aars = this;
    }
    return this.jdField_a_of_type_Aarr.a();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Aarr != null) {
      this.jdField_a_of_type_Aarr.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Aarr != null) {
      this.jdField_a_of_type_Aarr.a();
    }
  }
  
  void p() {}
  
  void q() {}
  
  void r() {}
  
  void s() {}
  
  protected void t()
  {
    if (this.jdField_a_of_type_Aarr != null) {
      this.jdField_a_of_type_Aarr.d();
    }
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_Aarr != null) {
      this.jdField_a_of_type_Aarr.e();
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((aoeb)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment
 * JD-Core Version:    0.7.0.1
 */