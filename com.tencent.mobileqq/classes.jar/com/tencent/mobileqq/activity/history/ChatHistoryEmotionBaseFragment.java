package com.tencent.mobileqq.activity.history;

import aduo;
import adup;
import advd;
import ahsa;
import ahsc;
import aiqp;
import ajpc;
import ajqs;
import ajqu;
import ajqv;
import ajqw;
import ajqx;
import ajuw;
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
import asem;
import asfa;
import atvf;
import awwz;
import awxd;
import awxi;
import bgnt;
import bgpa;
import bkfv;
import bkho;
import bkif;
import bmxr;
import bmyl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.startup.step.CheckPermission;
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
  implements adup, ahsc, Handler.Callback
{
  aduo jdField_a_of_type_Aduo;
  private aiqp jdField_a_of_type_Aiqp;
  private List<asfa> jdField_a_of_type_JavaUtilList;
  protected final MqqHandler a;
  private bgpa b;
  
  public ChatHistoryEmotionBaseFragment()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new bkfv(Looper.getMainLooper(), this, true);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, advd paramadvd)
  {
    if ((this.b != null) && (this.b.isShowing())) {
      this.b.dismiss();
    }
    bgpa localbgpa = new bgpa(getActivity(), 2131755823);
    localbgpa.setContentView(2131559009);
    this.b = localbgpa;
    this.b.setTitle(paramString1);
    this.b.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131690582);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131690912);
    }
    this.b.setNegativeButton(paramString1, new ajqw(this, paramadvd));
    this.b.setPositiveButton(paramString2, new ajqx(this, paramadvd));
    this.b.setCancelable(true);
    this.b.setCanceledOnTouchOutside(false);
    this.b.show();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Aduo != null) && (this.jdField_a_of_type_Aduo.jdField_a_of_type_Asem != null) && (this.jdField_a_of_type_Aduo.jdField_a_of_type_Asem.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "onEmotionLoaded, mEmotionView.mAdapter is null");
      }
      this.jdField_a_of_type_Ajpc.a(false);
      return;
    }
    this.jdField_a_of_type_Ajpc.a(true);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Aduo != null) {
      this.jdField_a_of_type_Aduo.a(paramLong);
    }
  }
  
  public void a(asfa paramasfa)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramasfa);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aduo != null) && (this.jdField_a_of_type_Aduo.a())) {
      this.jdField_a_of_type_Aduo.a();
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
        atvf.a(2131692227);
      }
      return bool;
    }
  }
  
  protected void b() {}
  
  public void b(asfa paramasfa)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramasfa);
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
    return getResources().getDimensionPixelSize(2131298998);
  }
  
  protected void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_Ajuw.a(localArrayList);
  }
  
  public void e()
  {
    super.e();
    v();
    if (this.jdField_a_of_type_Aduo != null) {
      this.jdField_a_of_type_Aduo.b();
    }
    if ((this.jdField_a_of_type_Aduo != null) && (this.jdField_a_of_type_Aduo.jdField_a_of_type_Asem != null) && (this.jdField_a_of_type_Aduo.jdField_a_of_type_Asem.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "doOnResume, mEmotionView.mAdapter is null");
      }
      if (this.jdField_a_of_type_Ajpc != null) {
        this.jdField_a_of_type_Ajpc.a(false);
      }
    }
    while (this.jdField_a_of_type_Ajpc == null) {
      return;
    }
    this.jdField_a_of_type_Ajpc.a(true);
  }
  
  public void g()
  {
    super.g();
    ahsa.a().b(this);
    if (this.jdField_a_of_type_Aduo != null) {
      this.jdField_a_of_type_Aduo.d();
    }
    if (this.jdField_a_of_type_Aiqp != null) {
      this.jdField_a_of_type_Aiqp.b();
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
      if (this.jdField_a_of_type_Aduo != null) {
        this.jdField_a_of_type_Aduo.g();
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
      bmyl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), d());
      v();
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      v();
      i = paramMessage.arg1;
    } while (!bmxr.a(i));
    if (bmxr.d(i))
    {
      getString(2131694153);
      paramMessage = "";
      if (bmxr.b(i))
      {
        getString(2131694153);
        paramMessage = getString(2131691881);
      }
      for (;;)
      {
        ajqv localajqv = new ajqv(this);
        a(getString(2131697860), paramMessage, null, null, localajqv);
        return true;
        if (bmxr.c(i))
        {
          getString(2131694153);
          paramMessage = getString(2131691879);
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
    if (!bgnt.d(BaseApplication.getContext()))
    {
      QQToast.a(getActivity(), 2131693991, 1).b(getResources().getDimensionPixelSize(2131298998));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (asfa)((Iterator)localObject1).next();
      if ((((asfa)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic))
      {
        localArrayList.add(awxd.a((MessageForPic)((asfa)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord));
        continue;
        atvf.c(2131692224);
        return;
      }
    }
    Object localObject1 = new awwz(getActivity());
    Object localObject2 = (awxi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(324);
    ((awxi)localObject2).a(new ajqs(this, (awwz)localObject1, (awxi)localObject2, localArrayList));
    ((awxi)localObject2).a(localArrayList, true);
    ((awxi)localObject2).a(localArrayList, 1, 5);
    s();
  }
  
  protected void m()
  {
    if (!bgnt.d(BaseApplication.getContext()))
    {
      QQToast.a(getActivity(), 2131693991, 1).b(getResources().getDimensionPixelSize(2131298998));
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((ChatMessage)((asfa)localIterator.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
      if (this.jdField_a_of_type_Aiqp == null)
      {
        this.jdField_a_of_type_Aiqp = new aiqp(getActivity(), 3);
        this.jdField_a_of_type_Aiqp.a();
      }
      this.jdField_a_of_type_Aiqp.a(localArrayList);
      r();
      return;
    }
    atvf.c(2131692224);
  }
  
  protected void n()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = 0 + this.jdField_a_of_type_JavaUtilList.size();
    }
    if (i == 0)
    {
      atvf.c(2131692224);
      return;
    }
    bkho localbkho = (bkho)bkif.a(getActivity(), null);
    localbkho.a(2131695396);
    localbkho.a(getActivity().getString(2131692070), 3);
    localbkho.c(2131690582);
    localbkho.a(new ajqu(this, localbkho));
    localbkho.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ahsa.a().a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Aduo == null)
    {
      this.jdField_a_of_type_Aduo = new aduo();
      this.jdField_a_of_type_Aduo.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_Aduo.jdField_a_of_type_Adup = this;
    }
    paramLayoutInflater = this.jdField_a_of_type_Aduo.a();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Aduo != null) {
      this.jdField_a_of_type_Aduo.c();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Aduo != null) {
      this.jdField_a_of_type_Aduo.b();
    }
  }
  
  void q() {}
  
  void r() {}
  
  void s() {}
  
  void t() {}
  
  protected void u()
  {
    if (this.jdField_a_of_type_Aduo != null) {
      this.jdField_a_of_type_Aduo.e();
    }
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_Aduo != null) {
      this.jdField_a_of_type_Aduo.f();
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((asfa)localIterator.next()).jdField_a_of_type_Boolean = false;
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