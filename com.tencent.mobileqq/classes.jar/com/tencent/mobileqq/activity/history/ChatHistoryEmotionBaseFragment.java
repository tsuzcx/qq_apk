package com.tencent.mobileqq.activity.history;

import aedq;
import aedr;
import aeef;
import aibo;
import aibq;
import ajby;
import akal;
import akcb;
import akcd;
import akce;
import akcf;
import akcg;
import akgf;
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
import asua;
import asuo;
import auna;
import axps;
import axpw;
import axqb;
import bhnv;
import bhpc;
import blha;
import blir;
import blji;
import bnyz;
import bnzt;
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
  implements aedr, aibq, Handler.Callback
{
  aedq jdField_a_of_type_Aedq;
  private ajby jdField_a_of_type_Ajby;
  private List<asuo> jdField_a_of_type_JavaUtilList;
  protected final MqqHandler a;
  private bhpc b;
  
  public ChatHistoryEmotionBaseFragment()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new blha(Looper.getMainLooper(), this, true);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, aeef paramaeef)
  {
    if ((this.b != null) && (this.b.isShowing())) {
      this.b.dismiss();
    }
    bhpc localbhpc = new bhpc(getActivity(), 2131755824);
    localbhpc.setContentView(2131559008);
    this.b = localbhpc;
    this.b.setTitle(paramString1);
    this.b.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131690580);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131690912);
    }
    this.b.setNegativeButton(paramString1, new akcf(this, paramaeef));
    this.b.setPositiveButton(paramString2, new akcg(this, paramaeef));
    this.b.setCancelable(true);
    this.b.setCanceledOnTouchOutside(false);
    this.b.show();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Aedq != null) && (this.jdField_a_of_type_Aedq.jdField_a_of_type_Asua != null) && (this.jdField_a_of_type_Aedq.jdField_a_of_type_Asua.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "onEmotionLoaded, mEmotionView.mAdapter is null");
      }
      this.jdField_a_of_type_Akal.a(false);
      return;
    }
    this.jdField_a_of_type_Akal.a(true);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Aedq != null) {
      this.jdField_a_of_type_Aedq.a(paramLong);
    }
  }
  
  public void a(asuo paramasuo)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramasuo);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aedq != null) && (this.jdField_a_of_type_Aedq.a())) {
      this.jdField_a_of_type_Aedq.a();
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
        auna.a(2131692232);
      }
      return bool;
    }
  }
  
  protected void b() {}
  
  public void b(asuo paramasuo)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramasuo);
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
    return getResources().getDimensionPixelSize(2131299011);
  }
  
  protected void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_Akgf.a(localArrayList);
  }
  
  public void e()
  {
    super.e();
    v();
    if (this.jdField_a_of_type_Aedq != null) {
      this.jdField_a_of_type_Aedq.b();
    }
    if ((this.jdField_a_of_type_Aedq != null) && (this.jdField_a_of_type_Aedq.jdField_a_of_type_Asua != null) && (this.jdField_a_of_type_Aedq.jdField_a_of_type_Asua.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "doOnResume, mEmotionView.mAdapter is null");
      }
      if (this.jdField_a_of_type_Akal != null) {
        this.jdField_a_of_type_Akal.a(false);
      }
    }
    while (this.jdField_a_of_type_Akal == null) {
      return;
    }
    this.jdField_a_of_type_Akal.a(true);
  }
  
  public void g()
  {
    super.g();
    aibo.a().b(this);
    if (this.jdField_a_of_type_Aedq != null) {
      this.jdField_a_of_type_Aedq.d();
    }
    if (this.jdField_a_of_type_Ajby != null) {
      this.jdField_a_of_type_Ajby.b();
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
      if (this.jdField_a_of_type_Aedq != null) {
        this.jdField_a_of_type_Aedq.g();
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
      bnzt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), d());
      v();
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      v();
      i = paramMessage.arg1;
    } while (!bnyz.a(i));
    if (bnyz.d(i))
    {
      getString(2131694171);
      paramMessage = "";
      if (bnyz.b(i))
      {
        getString(2131694171);
        paramMessage = getString(2131691885);
      }
      for (;;)
      {
        akce localakce = new akce(this);
        a(getString(2131697944), paramMessage, null, null, localakce);
        return true;
        if (bnyz.c(i))
        {
          getString(2131694171);
          paramMessage = getString(2131691883);
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
    if (!bhnv.d(BaseApplication.getContext()))
    {
      QQToast.a(getActivity(), 2131694008, 1).b(getResources().getDimensionPixelSize(2131299011));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (asuo)((Iterator)localObject1).next();
      if ((((asuo)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic))
      {
        localArrayList.add(axpw.a((MessageForPic)((asuo)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord));
        continue;
        auna.c(2131692229);
        return;
      }
    }
    Object localObject1 = new axps(getActivity());
    Object localObject2 = (axqb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(324);
    ((axqb)localObject2).a(new akcb(this, (axps)localObject1, (axqb)localObject2, localArrayList));
    ((axqb)localObject2).a(localArrayList, true);
    ((axqb)localObject2).a(localArrayList, 1, 5);
    s();
  }
  
  protected void m()
  {
    if (!bhnv.d(BaseApplication.getContext()))
    {
      QQToast.a(getActivity(), 2131694008, 1).b(getResources().getDimensionPixelSize(2131299011));
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((ChatMessage)((asuo)localIterator.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
      if (this.jdField_a_of_type_Ajby == null)
      {
        this.jdField_a_of_type_Ajby = new ajby(getActivity(), 3);
        this.jdField_a_of_type_Ajby.a();
      }
      this.jdField_a_of_type_Ajby.a(localArrayList);
      r();
      return;
    }
    auna.c(2131692229);
  }
  
  protected void n()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = 0 + this.jdField_a_of_type_JavaUtilList.size();
    }
    if (i == 0)
    {
      auna.c(2131692229);
      return;
    }
    blir localblir = (blir)blji.a(getActivity(), null);
    localblir.a(2131695439);
    localblir.a(getActivity().getString(2131692075), 3);
    localblir.c(2131690580);
    localblir.a(new akcd(this, localblir));
    localblir.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    aibo.a().a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Aedq == null)
    {
      this.jdField_a_of_type_Aedq = new aedq();
      this.jdField_a_of_type_Aedq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_Aedq.jdField_a_of_type_Aedr = this;
    }
    paramLayoutInflater = this.jdField_a_of_type_Aedq.a();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Aedq != null) {
      this.jdField_a_of_type_Aedq.c();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Aedq != null) {
      this.jdField_a_of_type_Aedq.b();
    }
  }
  
  void q() {}
  
  void r() {}
  
  void s() {}
  
  void t() {}
  
  protected void u()
  {
    if (this.jdField_a_of_type_Aedq != null) {
      this.jdField_a_of_type_Aedq.e();
    }
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_Aedq != null) {
      this.jdField_a_of_type_Aedq.f();
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((asuo)localIterator.next()).jdField_a_of_type_Boolean = false;
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