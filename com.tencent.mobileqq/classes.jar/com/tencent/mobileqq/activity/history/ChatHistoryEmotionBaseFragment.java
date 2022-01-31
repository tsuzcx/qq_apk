package com.tencent.mobileqq.activity.history;

import acne;
import acnf;
import acnt;
import aghu;
import aghw;
import ahec;
import ahyo;
import aiae;
import aiag;
import aiah;
import aiai;
import aiaj;
import aiei;
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
import apzy;
import aqam;
import arri;
import aupt;
import aupx;
import auqc;
import bdin;
import bdjz;
import bhsl;
import bhuf;
import bhus;
import bkjc;
import bkjy;
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
  implements acnf, aghw, Handler.Callback
{
  acne jdField_a_of_type_Acne;
  private ahec jdField_a_of_type_Ahec;
  private List<aqam> jdField_a_of_type_JavaUtilList;
  protected final MqqHandler a;
  private bdjz b;
  
  public ChatHistoryEmotionBaseFragment()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new bhsl(Looper.getMainLooper(), this, true);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, acnt paramacnt)
  {
    if ((this.b != null) && (this.b.isShowing())) {
      this.b.dismiss();
    }
    bdjz localbdjz = new bdjz(getActivity(), 2131755801);
    localbdjz.setContentView(2131558942);
    this.b = localbdjz;
    this.b.setTitle(paramString1);
    this.b.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131690648);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131691089);
    }
    this.b.setNegativeButton(paramString1, new aiai(this, paramacnt));
    this.b.setPositiveButton(paramString2, new aiaj(this, paramacnt));
    this.b.setCancelable(true);
    this.b.setCanceledOnTouchOutside(false);
    this.b.show();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Acne != null) && (this.jdField_a_of_type_Acne.jdField_a_of_type_Apzy != null) && (this.jdField_a_of_type_Acne.jdField_a_of_type_Apzy.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "onEmotionLoaded, mEmotionView.mAdapter is null");
      }
      this.jdField_a_of_type_Ahyo.a(false);
      return;
    }
    this.jdField_a_of_type_Ahyo.a(true);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Acne != null) {
      this.jdField_a_of_type_Acne.a(paramLong);
    }
  }
  
  public void a(aqam paramaqam)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramaqam);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Acne != null) && (this.jdField_a_of_type_Acne.a())) {
      this.jdField_a_of_type_Acne.a();
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
        arri.a(2131692640);
      }
      return bool;
    }
  }
  
  protected void b() {}
  
  public void b(aqam paramaqam)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramaqam);
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
    this.jdField_a_of_type_Aiei.a(localArrayList);
  }
  
  public void e()
  {
    super.e();
    u();
    if (this.jdField_a_of_type_Acne != null) {
      this.jdField_a_of_type_Acne.b();
    }
    if ((this.jdField_a_of_type_Acne != null) && (this.jdField_a_of_type_Acne.jdField_a_of_type_Apzy != null) && (this.jdField_a_of_type_Acne.jdField_a_of_type_Apzy.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "doOnResume, mEmotionView.mAdapter is null");
      }
      if (this.jdField_a_of_type_Ahyo != null) {
        this.jdField_a_of_type_Ahyo.a(false);
      }
    }
    while (this.jdField_a_of_type_Ahyo == null) {
      return;
    }
    this.jdField_a_of_type_Ahyo.a(true);
  }
  
  public void g()
  {
    super.g();
    aghu.a().b(this);
    if (this.jdField_a_of_type_Acne != null) {
      this.jdField_a_of_type_Acne.d();
    }
    if (this.jdField_a_of_type_Ahec != null) {
      this.jdField_a_of_type_Ahec.b();
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
      if (this.jdField_a_of_type_Acne != null) {
        this.jdField_a_of_type_Acne.g();
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
      bkjy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), d());
      u();
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      u();
      i = paramMessage.arg1;
    } while (!bkjc.a(i));
    if (bkjc.d(i))
    {
      getString(2131695081);
      paramMessage = "";
      if (bkjc.b(i))
      {
        getString(2131695081);
        paramMessage = getString(2131692267);
      }
      for (;;)
      {
        aiah localaiah = new aiah(this);
        a(getString(2131699061), paramMessage, null, null, localaiah);
        return true;
        if (bkjc.c(i))
        {
          getString(2131695081);
          paramMessage = getString(2131692265);
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
    if (!bdin.d(BaseApplication.getContext()))
    {
      QQToast.a(getActivity(), 2131694831, 1).b(getResources().getDimensionPixelSize(2131298914));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (aqam)((Iterator)localObject1).next();
      if ((((aqam)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic))
      {
        localArrayList.add(aupx.a((MessageForPic)((aqam)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord));
        continue;
        arri.c(2131692637);
        return;
      }
    }
    Object localObject1 = new aupt(getActivity());
    Object localObject2 = (auqc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(324);
    ((auqc)localObject2).a(new aiae(this, (aupt)localObject1, (auqc)localObject2, localArrayList));
    ((auqc)localObject2).a(localArrayList, true);
    ((auqc)localObject2).a(localArrayList, 1, 5);
    r();
  }
  
  protected void m()
  {
    if (!bdin.d(BaseApplication.getContext()))
    {
      QQToast.a(getActivity(), 2131694831, 1).b(getResources().getDimensionPixelSize(2131298914));
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((ChatMessage)((aqam)localIterator.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
      if (this.jdField_a_of_type_Ahec == null)
      {
        this.jdField_a_of_type_Ahec = new ahec(getActivity(), 3);
        this.jdField_a_of_type_Ahec.a();
      }
      this.jdField_a_of_type_Ahec.a(localArrayList);
      q();
      return;
    }
    arri.c(2131692637);
  }
  
  protected void n()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = 0 + this.jdField_a_of_type_JavaUtilList.size();
    }
    if (i == 0)
    {
      arri.c(2131692637);
      return;
    }
    bhuf localbhuf = (bhuf)bhus.a(getActivity(), null);
    localbhuf.a(2131696570);
    localbhuf.a(getActivity().getString(2131692486), 3);
    localbhuf.c(2131690648);
    localbhuf.a(new aiag(this, localbhuf));
    localbhuf.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    aghu.a().a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Acne == null)
    {
      this.jdField_a_of_type_Acne = new acne();
      this.jdField_a_of_type_Acne.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_Acne.jdField_a_of_type_Acnf = this;
    }
    return this.jdField_a_of_type_Acne.a();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Acne != null) {
      this.jdField_a_of_type_Acne.c();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Acne != null) {
      this.jdField_a_of_type_Acne.b();
    }
  }
  
  void p() {}
  
  void q() {}
  
  void r() {}
  
  void s() {}
  
  protected void t()
  {
    if (this.jdField_a_of_type_Acne != null) {
      this.jdField_a_of_type_Acne.e();
    }
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_Acne != null) {
      this.jdField_a_of_type_Acne.f();
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((aqam)localIterator.next()).jdField_a_of_type_Boolean = false;
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