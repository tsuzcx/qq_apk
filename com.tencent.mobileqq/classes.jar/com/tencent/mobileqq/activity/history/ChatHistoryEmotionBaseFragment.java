package com.tencent.mobileqq.activity.history;

import adpd;
import adpe;
import adps;
import ahrf;
import ahrh;
import airh;
import ajra;
import ajsq;
import ajss;
import ajst;
import ajsu;
import ajsv;
import ajwu;
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
import askg;
import asku;
import audr;
import axjb;
import axjf;
import axjk;
import bkyc;
import bkzi;
import bkzz;
import bmqx;
import bmrr;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryEmotionBaseFragment
  extends ChatHistoryBaseFragment
  implements adpe, ahrh, Handler.Callback
{
  adpd jdField_a_of_type_Adpd;
  private airh jdField_a_of_type_Airh;
  private List<asku> jdField_a_of_type_JavaUtilList;
  protected final MqqHandler a;
  private QQCustomDialog b;
  
  public ChatHistoryEmotionBaseFragment()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new bkyc(Looper.getMainLooper(), this, true);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, adps paramadps)
  {
    if ((this.b != null) && (this.b.isShowing())) {
      this.b.dismiss();
    }
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(getActivity(), 2131755829);
    localQQCustomDialog.setContentView(2131559043);
    this.b = localQQCustomDialog;
    this.b.setTitle(paramString1);
    this.b.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131690697);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131691037);
    }
    this.b.setNegativeButton(paramString1, new ajsu(this, paramadps));
    this.b.setPositiveButton(paramString2, new ajsv(this, paramadps));
    this.b.setCancelable(true);
    this.b.setCanceledOnTouchOutside(false);
    this.b.show();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Adpd != null) && (this.jdField_a_of_type_Adpd.jdField_a_of_type_Askg != null) && (this.jdField_a_of_type_Adpd.jdField_a_of_type_Askg.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "onEmotionLoaded, mEmotionView.mAdapter is null");
      }
      this.jdField_a_of_type_Ajra.a(false);
      return;
    }
    this.jdField_a_of_type_Ajra.a(true);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Adpd != null) {
      this.jdField_a_of_type_Adpd.a(paramLong);
    }
  }
  
  public void a(asku paramasku)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramasku);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Adpd != null) && (this.jdField_a_of_type_Adpd.a())) {
      this.jdField_a_of_type_Adpd.a();
    }
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
        audr.a(2131692370);
      }
      return bool;
    }
  }
  
  protected void b() {}
  
  public void b(asku paramasku)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramasku);
  }
  
  void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      u();
      t();
      return;
    }
    v();
  }
  
  protected int c()
  {
    return 1602;
  }
  
  protected void c() {}
  
  public int d()
  {
    return getResources().getDimensionPixelSize(2131299080);
  }
  
  protected void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_Ajwu.a(localArrayList);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Ajra == null) {
      return;
    }
    super.e();
    v();
    if (this.jdField_a_of_type_Adpd != null) {
      this.jdField_a_of_type_Adpd.b();
    }
    if ((this.jdField_a_of_type_Adpd != null) && (this.jdField_a_of_type_Adpd.jdField_a_of_type_Askg != null) && (this.jdField_a_of_type_Adpd.jdField_a_of_type_Askg.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "doOnResume, mEmotionView.mAdapter is null");
      }
      this.jdField_a_of_type_Ajra.a(false);
      return;
    }
    this.jdField_a_of_type_Ajra.a(true);
  }
  
  public void g()
  {
    super.g();
    ahrf.a().b(this);
    if (this.jdField_a_of_type_Adpd != null) {
      this.jdField_a_of_type_Adpd.d();
    }
    if (this.jdField_a_of_type_Airh != null) {
      this.jdField_a_of_type_Airh.b();
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
      if (this.jdField_a_of_type_Adpd != null) {
        this.jdField_a_of_type_Adpd.g();
      }
      v();
      q();
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      v();
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      bmrr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), d());
      v();
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      v();
      i = paramMessage.arg1;
    } while (!bmqx.a(i));
    if (bmqx.d(i))
    {
      getString(2131694472);
      paramMessage = "";
      if (bmqx.b(i))
      {
        getString(2131694472);
        paramMessage = getString(2131692021);
      }
      for (;;)
      {
        ajst localajst = new ajst(this);
        a(getString(2131698387), paramMessage, null, null, localajst);
        return true;
        if (bmqx.c(i))
        {
          getString(2131694472);
          paramMessage = getString(2131692019);
        }
      }
    }
    paramMessage = (String)paramMessage.obj;
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramMessage, 1).b(d());
    return true;
  }
  
  protected void k()
  {
    if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      CheckPermission.requestStorePermission(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(getActivity(), 2131694305, 1).b(getResources().getDimensionPixelSize(2131299080));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (asku)((Iterator)localObject1).next();
      if ((((asku)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic))
      {
        localArrayList.add(axjf.a((MessageForPic)((asku)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord));
        continue;
        audr.c(2131692367);
        return;
      }
    }
    Object localObject1 = new axjb(getActivity());
    Object localObject2 = (axjk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MULTI_CHOOSE_SAVE_MANAGER);
    ((axjk)localObject2).a(new ajsq(this, (axjb)localObject1, (axjk)localObject2, localArrayList));
    ((axjk)localObject2).a(localArrayList, true);
    ((axjk)localObject2).a(localArrayList, 1, 5);
    s();
  }
  
  protected void m()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(getActivity(), 2131694305, 1).b(getResources().getDimensionPixelSize(2131299080));
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((ChatMessage)((asku)localIterator.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
      if (this.jdField_a_of_type_Airh == null)
      {
        this.jdField_a_of_type_Airh = new airh(getActivity(), 3);
        this.jdField_a_of_type_Airh.a();
      }
      this.jdField_a_of_type_Airh.a(localArrayList);
      r();
      return;
    }
    audr.c(2131692367);
  }
  
  protected void n()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = 0 + this.jdField_a_of_type_JavaUtilList.size();
    }
    if (i == 0)
    {
      audr.c(2131692367);
      return;
    }
    bkzi localbkzi = (bkzi)bkzz.a(getActivity(), null);
    localbkzi.a(2131695830);
    localbkzi.a(getActivity().getString(2131692213), 3);
    localbkzi.c(2131690697);
    localbkzi.a(new ajss(this, localbkzi));
    localbkzi.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ahrf.a().a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Adpd == null)
    {
      this.jdField_a_of_type_Adpd = new adpd();
      this.jdField_a_of_type_Adpd.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_Adpd.jdField_a_of_type_Adpe = this;
    }
    paramLayoutInflater = this.jdField_a_of_type_Adpd.a();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Adpd != null) {
      this.jdField_a_of_type_Adpd.c();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Adpd != null) {
      this.jdField_a_of_type_Adpd.b();
    }
  }
  
  void q() {}
  
  void r() {}
  
  void s() {}
  
  void t() {}
  
  protected void u()
  {
    if (this.jdField_a_of_type_Adpd != null) {
      this.jdField_a_of_type_Adpd.e();
    }
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_Adpd != null) {
      this.jdField_a_of_type_Adpd.f();
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((asku)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment
 * JD-Core Version:    0.7.0.1
 */