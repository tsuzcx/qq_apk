package com.tencent.mobileqq.activity.history;

import acyr;
import acys;
import aczg;
import agye;
import agyg;
import ahwi;
import aivl;
import aixb;
import aixd;
import aixe;
import aixf;
import aixg;
import ajbf;
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
import arga;
import argo;
import aszk;
import awcz;
import awdd;
import awdi;
import bjmp;
import bjnw;
import bjon;
import bleg;
import blfa;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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
  implements acys, agyg, Handler.Callback
{
  acyr jdField_a_of_type_Acyr;
  private ahwi jdField_a_of_type_Ahwi;
  private List<argo> jdField_a_of_type_JavaUtilList;
  protected final MqqHandler a;
  private QQCustomDialog b;
  
  public ChatHistoryEmotionBaseFragment()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new bjmp(Looper.getMainLooper(), this, true);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, aczg paramaczg)
  {
    if ((this.b != null) && (this.b.isShowing())) {
      this.b.dismiss();
    }
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(getActivity(), 2131755826);
    localQQCustomDialog.setContentView(2131559016);
    this.b = localQQCustomDialog;
    this.b.setTitle(paramString1);
    this.b.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131690620);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131690952);
    }
    this.b.setNegativeButton(paramString1, new aixf(this, paramaczg));
    this.b.setPositiveButton(paramString2, new aixg(this, paramaczg));
    this.b.setCancelable(true);
    this.b.setCanceledOnTouchOutside(false);
    this.b.show();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Acyr != null) && (this.jdField_a_of_type_Acyr.jdField_a_of_type_Arga != null) && (this.jdField_a_of_type_Acyr.jdField_a_of_type_Arga.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "onEmotionLoaded, mEmotionView.mAdapter is null");
      }
      this.jdField_a_of_type_Aivl.a(false);
      return;
    }
    this.jdField_a_of_type_Aivl.a(true);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Acyr != null) {
      this.jdField_a_of_type_Acyr.a(paramLong);
    }
  }
  
  public void a(argo paramargo)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramargo);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Acyr != null) && (this.jdField_a_of_type_Acyr.a())) {
      this.jdField_a_of_type_Acyr.a();
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
        aszk.a(2131692280);
      }
      return bool;
    }
  }
  
  protected void b() {}
  
  public void b(argo paramargo)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramargo);
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
    return getResources().getDimensionPixelSize(2131299076);
  }
  
  protected void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_Ajbf.a(localArrayList);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Aivl == null) {
      return;
    }
    super.e();
    v();
    if (this.jdField_a_of_type_Acyr != null) {
      this.jdField_a_of_type_Acyr.b();
    }
    if ((this.jdField_a_of_type_Acyr != null) && (this.jdField_a_of_type_Acyr.jdField_a_of_type_Arga != null) && (this.jdField_a_of_type_Acyr.jdField_a_of_type_Arga.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "doOnResume, mEmotionView.mAdapter is null");
      }
      this.jdField_a_of_type_Aivl.a(false);
      return;
    }
    this.jdField_a_of_type_Aivl.a(true);
  }
  
  public void g()
  {
    super.g();
    agye.a().b(this);
    if (this.jdField_a_of_type_Acyr != null) {
      this.jdField_a_of_type_Acyr.d();
    }
    if (this.jdField_a_of_type_Ahwi != null) {
      this.jdField_a_of_type_Ahwi.b();
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
      if (this.jdField_a_of_type_Acyr != null) {
        this.jdField_a_of_type_Acyr.g();
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
      blfa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), d());
      v();
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      v();
      i = paramMessage.arg1;
    } while (!bleg.a(i));
    if (bleg.d(i))
    {
      getString(2131694274);
      paramMessage = "";
      if (bleg.b(i))
      {
        getString(2131694274);
        paramMessage = getString(2131691931);
      }
      for (;;)
      {
        aixe localaixe = new aixe(this);
        a(getString(2131698101), paramMessage, null, null, localaixe);
        return true;
        if (bleg.c(i))
        {
          getString(2131694274);
          paramMessage = getString(2131691929);
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
      QQToast.a(getActivity(), 2131694108, 1).b(getResources().getDimensionPixelSize(2131299076));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (argo)((Iterator)localObject1).next();
      if ((((argo)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic))
      {
        localArrayList.add(awdd.a((MessageForPic)((argo)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord));
        continue;
        aszk.c(2131692277);
        return;
      }
    }
    Object localObject1 = new awcz(getActivity());
    Object localObject2 = (awdi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(324);
    ((awdi)localObject2).a(new aixb(this, (awcz)localObject1, (awdi)localObject2, localArrayList));
    ((awdi)localObject2).a(localArrayList, true);
    ((awdi)localObject2).a(localArrayList, 1, 5);
    s();
  }
  
  protected void m()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(getActivity(), 2131694108, 1).b(getResources().getDimensionPixelSize(2131299076));
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((ChatMessage)((argo)localIterator.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
      if (this.jdField_a_of_type_Ahwi == null)
      {
        this.jdField_a_of_type_Ahwi = new ahwi(getActivity(), 3);
        this.jdField_a_of_type_Ahwi.a();
      }
      this.jdField_a_of_type_Ahwi.a(localArrayList);
      r();
      return;
    }
    aszk.c(2131692277);
  }
  
  protected void n()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = 0 + this.jdField_a_of_type_JavaUtilList.size();
    }
    if (i == 0)
    {
      aszk.c(2131692277);
      return;
    }
    bjnw localbjnw = (bjnw)bjon.a(getActivity(), null);
    localbjnw.a(2131695578);
    localbjnw.a(getActivity().getString(2131692123), 3);
    localbjnw.c(2131690620);
    localbjnw.a(new aixd(this, localbjnw));
    localbjnw.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    agye.a().a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Acyr == null)
    {
      this.jdField_a_of_type_Acyr = new acyr();
      this.jdField_a_of_type_Acyr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_Acyr.jdField_a_of_type_Acys = this;
    }
    paramLayoutInflater = this.jdField_a_of_type_Acyr.a();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Acyr != null) {
      this.jdField_a_of_type_Acyr.c();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Acyr != null) {
      this.jdField_a_of_type_Acyr.b();
    }
  }
  
  void q() {}
  
  void r() {}
  
  void s() {}
  
  void t() {}
  
  protected void u()
  {
    if (this.jdField_a_of_type_Acyr != null) {
      this.jdField_a_of_type_Acyr.e();
    }
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_Acyr != null) {
      this.jdField_a_of_type_Acyr.f();
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((argo)localIterator.next()).jdField_a_of_type_Boolean = false;
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