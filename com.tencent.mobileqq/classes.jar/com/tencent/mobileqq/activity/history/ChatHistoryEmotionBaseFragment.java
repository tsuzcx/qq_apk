package com.tencent.mobileqq.activity.history;

import aaid;
import aaie;
import aais;
import advs;
import advu;
import aero;
import afkk;
import aflw;
import afly;
import aflz;
import afma;
import afmb;
import afps;
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
import anmy;
import annl;
import apcb;
import aryh;
import aryl;
import aryq;
import badq;
import bafb;
import bbmy;
import beez;
import begr;
import behe;
import bgtg;
import bguc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryEmotionBaseFragment
  extends ChatHistoryBaseFragment
  implements aaie, advu, Handler.Callback
{
  aaid jdField_a_of_type_Aaid;
  private aero jdField_a_of_type_Aero;
  private List<annl> jdField_a_of_type_JavaUtilList;
  protected final MqqHandler a;
  private bafb b;
  
  public ChatHistoryEmotionBaseFragment()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new beez(Looper.getMainLooper(), this, true);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, aais paramaais)
  {
    if ((this.b != null) && (this.b.isShowing())) {
      this.b.dismiss();
    }
    bafb localbafb = new bafb(getActivity(), 2131690181);
    localbafb.setContentView(2131493345);
    this.b = localbafb;
    this.b.setTitle(paramString1);
    this.b.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131625035);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131625463);
    }
    this.b.setNegativeButton(paramString1, new afma(this, paramaais));
    this.b.setPositiveButton(paramString2, new afmb(this, paramaais));
    this.b.setCancelable(true);
    this.b.setCanceledOnTouchOutside(false);
    this.b.show();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Aaid != null) && (this.jdField_a_of_type_Aaid.jdField_a_of_type_Anmy != null) && (this.jdField_a_of_type_Aaid.jdField_a_of_type_Anmy.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "onEmotionLoaded, mEmotionView.mAdapter is null");
      }
      this.jdField_a_of_type_Afkk.a(false);
      return;
    }
    this.jdField_a_of_type_Afkk.a(true);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Aaid != null) {
      this.jdField_a_of_type_Aaid.a(paramLong);
    }
  }
  
  public void a(annl paramannl)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramannl);
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
        apcb.a(2131626944);
      }
      return bool;
    }
  }
  
  protected void b() {}
  
  public void b(annl paramannl)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramannl);
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
    return getResources().getDimensionPixelSize(2131167766);
  }
  
  protected void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_Afps.a(localArrayList);
  }
  
  public void e()
  {
    super.e();
    u();
    if (this.jdField_a_of_type_Aaid != null) {
      this.jdField_a_of_type_Aaid.a();
    }
    if ((this.jdField_a_of_type_Aaid != null) && (this.jdField_a_of_type_Aaid.jdField_a_of_type_Anmy != null) && (this.jdField_a_of_type_Aaid.jdField_a_of_type_Anmy.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "doOnResume, mEmotionView.mAdapter is null");
      }
      if (this.jdField_a_of_type_Afkk != null) {
        this.jdField_a_of_type_Afkk.a(false);
      }
    }
    while (this.jdField_a_of_type_Afkk == null) {
      return;
    }
    this.jdField_a_of_type_Afkk.a(true);
  }
  
  public void g()
  {
    super.g();
    advs.a().b(this);
    if (this.jdField_a_of_type_Aaid != null) {
      this.jdField_a_of_type_Aaid.c();
    }
    if (this.jdField_a_of_type_Aero != null) {
      this.jdField_a_of_type_Aero.b();
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
      if (this.jdField_a_of_type_Aaid != null) {
        this.jdField_a_of_type_Aaid.f();
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
      bguc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), d());
      u();
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      u();
      i = paramMessage.arg1;
    } while (!bgtg.a(i));
    if (bgtg.d(i))
    {
      getString(2131629244);
      paramMessage = "";
      if (bgtg.b(i))
      {
        getString(2131629244);
        paramMessage = getString(2131626604);
      }
      for (;;)
      {
        aflz localaflz = new aflz(this);
        a(getString(2131633005), paramMessage, null, null, localaflz);
        return true;
        if (bgtg.c(i))
        {
          getString(2131629244);
          paramMessage = getString(2131626602);
        }
      }
    }
    paramMessage = (String)paramMessage.obj;
    bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramMessage, 1).b(d());
    return true;
  }
  
  protected void k()
  {
    if (!badq.d(BaseApplication.getContext()))
    {
      bbmy.a(getActivity(), 2131629008, 1).b(getResources().getDimensionPixelSize(2131167766));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (annl)((Iterator)localObject1).next();
      if ((((annl)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic))
      {
        localArrayList.add(aryl.a((MessageForPic)((annl)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord));
        continue;
        apcb.c(2131626941);
        return;
      }
    }
    Object localObject1 = new aryh(getActivity());
    Object localObject2 = (aryq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(324);
    ((aryq)localObject2).a(new aflw(this, (aryh)localObject1, (aryq)localObject2, localArrayList));
    ((aryq)localObject2).a(localArrayList, true);
    ((aryq)localObject2).a(localArrayList, 1, 5);
    r();
  }
  
  protected void m()
  {
    if (!badq.d(BaseApplication.getContext()))
    {
      bbmy.a(getActivity(), 2131629008, 1).b(getResources().getDimensionPixelSize(2131167766));
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((ChatMessage)((annl)localIterator.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
      if (this.jdField_a_of_type_Aero == null)
      {
        this.jdField_a_of_type_Aero = new aero(getActivity(), 3);
        this.jdField_a_of_type_Aero.a();
      }
      this.jdField_a_of_type_Aero.a(localArrayList);
      q();
      return;
    }
    apcb.c(2131626941);
  }
  
  protected void n()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = 0 + this.jdField_a_of_type_JavaUtilList.size();
    }
    if (i == 0)
    {
      apcb.c(2131626941);
      return;
    }
    begr localbegr = (begr)behe.a(getActivity(), null);
    localbegr.a(2131630692);
    localbegr.a(getActivity().getString(2131626808), 3);
    localbegr.c(2131625035);
    localbegr.a(new afly(this, localbegr));
    localbegr.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    advs.a().a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Aaid == null)
    {
      this.jdField_a_of_type_Aaid = new aaid();
      this.jdField_a_of_type_Aaid.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_Aaid.jdField_a_of_type_Aaie = this;
    }
    return this.jdField_a_of_type_Aaid.a();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Aaid != null) {
      this.jdField_a_of_type_Aaid.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Aaid != null) {
      this.jdField_a_of_type_Aaid.a();
    }
  }
  
  void p() {}
  
  void q() {}
  
  void r() {}
  
  void s() {}
  
  protected void t()
  {
    if (this.jdField_a_of_type_Aaid != null) {
      this.jdField_a_of_type_Aaid.d();
    }
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_Aaid != null) {
      this.jdField_a_of_type_Aaid.e();
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((annl)localIterator.next()).jdField_a_of_type_Boolean = false;
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