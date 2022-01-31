package com.tencent.mobileqq.activity.history;

import acip;
import aciq;
import acje;
import agdf;
import agdh;
import agzn;
import ahtz;
import ahvp;
import ahvr;
import ahvs;
import ahvt;
import ahvu;
import ahzt;
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
import apvp;
import apwd;
import armz;
import aulk;
import aulo;
import ault;
import bdee;
import bdfq;
import bhoe;
import bhpy;
import bhql;
import bkev;
import bkfr;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ChatHistoryEmotionBaseFragment
  extends ChatHistoryBaseFragment
  implements aciq, agdh, Handler.Callback
{
  acip jdField_a_of_type_Acip;
  private agzn jdField_a_of_type_Agzn;
  private List<apwd> jdField_a_of_type_JavaUtilList;
  protected final MqqHandler a;
  private bdfq b;
  
  public ChatHistoryEmotionBaseFragment()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new bhoe(Looper.getMainLooper(), this, true);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, acje paramacje)
  {
    if ((this.b != null) && (this.b.isShowing())) {
      this.b.dismiss();
    }
    bdfq localbdfq = new bdfq(getActivity(), 2131755801);
    localbdfq.setContentView(2131558943);
    this.b = localbdfq;
    this.b.setTitle(paramString1);
    this.b.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131690648);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131691088);
    }
    this.b.setNegativeButton(paramString1, new ahvt(this, paramacje));
    this.b.setPositiveButton(paramString2, new ahvu(this, paramacje));
    this.b.setCancelable(true);
    this.b.setCanceledOnTouchOutside(false);
    this.b.show();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Acip != null) && (this.jdField_a_of_type_Acip.jdField_a_of_type_Apvp != null) && (this.jdField_a_of_type_Acip.jdField_a_of_type_Apvp.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "onEmotionLoaded, mEmotionView.mAdapter is null");
      }
      this.jdField_a_of_type_Ahtz.a(false);
      return;
    }
    this.jdField_a_of_type_Ahtz.a(true);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Acip != null) {
      this.jdField_a_of_type_Acip.a(paramLong);
    }
  }
  
  public void a(apwd paramapwd)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramapwd);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Acip != null) && (this.jdField_a_of_type_Acip.a())) {
      this.jdField_a_of_type_Acip.a();
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
        armz.a(2131692639);
      }
      return bool;
    }
  }
  
  protected void b() {}
  
  public void b(apwd paramapwd)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramapwd);
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
    return getResources().getDimensionPixelSize(2131298914);
  }
  
  protected void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_Ahzt.a(localArrayList);
  }
  
  public void e()
  {
    super.e();
    u();
    if (this.jdField_a_of_type_Acip != null) {
      this.jdField_a_of_type_Acip.b();
    }
    if ((this.jdField_a_of_type_Acip != null) && (this.jdField_a_of_type_Acip.jdField_a_of_type_Apvp != null) && (this.jdField_a_of_type_Acip.jdField_a_of_type_Apvp.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "doOnResume, mEmotionView.mAdapter is null");
      }
      if (this.jdField_a_of_type_Ahtz != null) {
        this.jdField_a_of_type_Ahtz.a(false);
      }
    }
    while (this.jdField_a_of_type_Ahtz == null) {
      return;
    }
    this.jdField_a_of_type_Ahtz.a(true);
  }
  
  public void g()
  {
    super.g();
    agdf.a().b(this);
    if (this.jdField_a_of_type_Acip != null) {
      this.jdField_a_of_type_Acip.d();
    }
    if (this.jdField_a_of_type_Agzn != null) {
      this.jdField_a_of_type_Agzn.b();
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
      if (this.jdField_a_of_type_Acip != null) {
        this.jdField_a_of_type_Acip.g();
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
      bkfr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), d());
      u();
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      u();
      i = paramMessage.arg1;
    } while (!bkev.a(i));
    if (bkev.d(i))
    {
      getString(2131695079);
      paramMessage = "";
      if (bkev.b(i))
      {
        getString(2131695079);
        paramMessage = getString(2131692266);
      }
      for (;;)
      {
        ahvs localahvs = new ahvs(this);
        a(getString(2131699049), paramMessage, null, null, localahvs);
        return true;
        if (bkev.c(i))
        {
          getString(2131695079);
          paramMessage = getString(2131692264);
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
    if (!bdee.d(BaseApplication.getContext()))
    {
      QQToast.a(getActivity(), 2131694829, 1).b(getResources().getDimensionPixelSize(2131298914));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (apwd)((Iterator)localObject1).next();
      if ((((apwd)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic))
      {
        localArrayList.add(aulo.a((MessageForPic)((apwd)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord));
        continue;
        armz.c(2131692636);
        return;
      }
    }
    Object localObject1 = new aulk(getActivity());
    Object localObject2 = (ault)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(324);
    ((ault)localObject2).a(new ahvp(this, (aulk)localObject1, (ault)localObject2, localArrayList));
    ((ault)localObject2).a(localArrayList, true);
    ((ault)localObject2).a(localArrayList, 1, 5);
    r();
  }
  
  protected void m()
  {
    if (!bdee.d(BaseApplication.getContext()))
    {
      QQToast.a(getActivity(), 2131694829, 1).b(getResources().getDimensionPixelSize(2131298914));
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((ChatMessage)((apwd)localIterator.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
      if (this.jdField_a_of_type_Agzn == null)
      {
        this.jdField_a_of_type_Agzn = new agzn(getActivity(), 3);
        this.jdField_a_of_type_Agzn.a();
      }
      this.jdField_a_of_type_Agzn.a(localArrayList);
      q();
      return;
    }
    armz.c(2131692636);
  }
  
  protected void n()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = 0 + this.jdField_a_of_type_JavaUtilList.size();
    }
    if (i == 0)
    {
      armz.c(2131692636);
      return;
    }
    bhpy localbhpy = (bhpy)bhql.a(getActivity(), null);
    localbhpy.a(2131696568);
    localbhpy.a(getActivity().getString(2131692485), 3);
    localbhpy.c(2131690648);
    localbhpy.a(new ahvr(this, localbhpy));
    localbhpy.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    agdf.a().a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Acip == null)
    {
      this.jdField_a_of_type_Acip = new acip();
      this.jdField_a_of_type_Acip.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_Acip.jdField_a_of_type_Aciq = this;
    }
    return this.jdField_a_of_type_Acip.a();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Acip != null) {
      this.jdField_a_of_type_Acip.c();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Acip != null) {
      this.jdField_a_of_type_Acip.b();
    }
  }
  
  void p() {}
  
  void q() {}
  
  void r() {}
  
  void s() {}
  
  protected void t()
  {
    if (this.jdField_a_of_type_Acip != null) {
      this.jdField_a_of_type_Acip.e();
    }
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_Acip != null) {
      this.jdField_a_of_type_Acip.f();
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((apwd)localIterator.next()).jdField_a_of_type_Boolean = false;
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment
 * JD-Core Version:    0.7.0.1
 */