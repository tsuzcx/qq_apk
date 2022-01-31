package com.tencent.mobileqq.activity.history;

import aarv;
import aarw;
import aask;
import aegr;
import aegt;
import afck;
import afwh;
import afxt;
import afxv;
import afxw;
import afxx;
import afxy;
import agbs;
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
import aodj;
import aodw;
import aptv;
import asul;
import asup;
import asuu;
import bbev;
import bbgg;
import bcpw;
import bfmt;
import bfol;
import bfoy;
import bici;
import bide;
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
  implements aarw, aegt, Handler.Callback
{
  aarv jdField_a_of_type_Aarv;
  private afck jdField_a_of_type_Afck;
  private List<aodw> jdField_a_of_type_JavaUtilList;
  protected final MqqHandler a;
  private bbgg b;
  
  public ChatHistoryEmotionBaseFragment()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new bfmt(Looper.getMainLooper(), this, true);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, aask paramaask)
  {
    if ((this.b != null) && (this.b.isShowing())) {
      this.b.dismiss();
    }
    bbgg localbbgg = new bbgg(getActivity(), 2131755791);
    localbbgg.setContentView(2131558906);
    this.b = localbbgg;
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
    this.b.setNegativeButton(paramString1, new afxx(this, paramaask));
    this.b.setPositiveButton(paramString2, new afxy(this, paramaask));
    this.b.setCancelable(true);
    this.b.setCanceledOnTouchOutside(false);
    this.b.show();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Aarv != null) && (this.jdField_a_of_type_Aarv.jdField_a_of_type_Aodj != null) && (this.jdField_a_of_type_Aarv.jdField_a_of_type_Aodj.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "onEmotionLoaded, mEmotionView.mAdapter is null");
      }
      this.jdField_a_of_type_Afwh.a(false);
      return;
    }
    this.jdField_a_of_type_Afwh.a(true);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Aarv != null) {
      this.jdField_a_of_type_Aarv.a(paramLong);
    }
  }
  
  public void a(aodw paramaodw)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramaodw);
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
        aptv.a(2131692562);
      }
      return bool;
    }
  }
  
  protected void b() {}
  
  public void b(aodw paramaodw)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramaodw);
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
    this.jdField_a_of_type_Agbs.a(localArrayList);
  }
  
  public void e()
  {
    super.e();
    u();
    if (this.jdField_a_of_type_Aarv != null) {
      this.jdField_a_of_type_Aarv.a();
    }
    if ((this.jdField_a_of_type_Aarv != null) && (this.jdField_a_of_type_Aarv.jdField_a_of_type_Aodj != null) && (this.jdField_a_of_type_Aarv.jdField_a_of_type_Aodj.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "doOnResume, mEmotionView.mAdapter is null");
      }
      if (this.jdField_a_of_type_Afwh != null) {
        this.jdField_a_of_type_Afwh.a(false);
      }
    }
    while (this.jdField_a_of_type_Afwh == null) {
      return;
    }
    this.jdField_a_of_type_Afwh.a(true);
  }
  
  public void g()
  {
    super.g();
    aegr.a().b(this);
    if (this.jdField_a_of_type_Aarv != null) {
      this.jdField_a_of_type_Aarv.c();
    }
    if (this.jdField_a_of_type_Afck != null) {
      this.jdField_a_of_type_Afck.b();
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
      if (this.jdField_a_of_type_Aarv != null) {
        this.jdField_a_of_type_Aarv.f();
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
      bide.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), d());
      u();
      return true;
      if (this.jdField_a_of_type_AndroidAppDialog != null) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      u();
      i = paramMessage.arg1;
    } while (!bici.a(i));
    if (bici.d(i))
    {
      getString(2131694921);
      paramMessage = "";
      if (bici.b(i))
      {
        getString(2131694921);
        paramMessage = getString(2131692190);
      }
      for (;;)
      {
        afxw localafxw = new afxw(this);
        a(getString(2131698741), paramMessage, null, null, localafxw);
        return true;
        if (bici.c(i))
        {
          getString(2131694921);
          paramMessage = getString(2131692188);
        }
      }
    }
    paramMessage = (String)paramMessage.obj;
    bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramMessage, 1).b(d());
    return true;
  }
  
  protected void k()
  {
    if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity))
    {
      CheckPermission.requestStorePermission(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null);
      return;
    }
    if (!bbev.d(BaseApplication.getContext()))
    {
      bcpw.a(getActivity(), 2131694672, 1).b(getResources().getDimensionPixelSize(2131298865));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    }
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (aodw)((Iterator)localObject1).next();
      if ((((aodw)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForPic))
      {
        localArrayList.add(asup.a((MessageForPic)((aodw)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord));
        continue;
        aptv.c(2131692559);
        return;
      }
    }
    Object localObject1 = new asul(getActivity());
    Object localObject2 = (asuu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(324);
    ((asuu)localObject2).a(new afxt(this, (asul)localObject1, (asuu)localObject2, localArrayList));
    ((asuu)localObject2).a(localArrayList, true);
    ((asuu)localObject2).a(localArrayList, 1, 5);
    r();
  }
  
  protected void m()
  {
    if (!bbev.d(BaseApplication.getContext()))
    {
      bcpw.a(getActivity(), 2131694672, 1).b(getResources().getDimensionPixelSize(2131298865));
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((ChatMessage)((aodw)localIterator.next()).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
      if (this.jdField_a_of_type_Afck == null)
      {
        this.jdField_a_of_type_Afck = new afck(getActivity(), 3);
        this.jdField_a_of_type_Afck.a();
      }
      this.jdField_a_of_type_Afck.a(localArrayList);
      q();
      return;
    }
    aptv.c(2131692559);
  }
  
  protected void n()
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      i = 0 + this.jdField_a_of_type_JavaUtilList.size();
    }
    if (i == 0)
    {
      aptv.c(2131692559);
      return;
    }
    bfol localbfol = (bfol)bfoy.a(getActivity(), null);
    localbfol.a(2131696395);
    localbfol.a(getActivity().getString(2131692409), 3);
    localbfol.c(2131690596);
    localbfol.a(new afxv(this, localbfol));
    localbfol.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    aegr.a().a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Aarv == null)
    {
      this.jdField_a_of_type_Aarv = new aarv();
      this.jdField_a_of_type_Aarv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_Aarv.jdField_a_of_type_Aarw = this;
    }
    return this.jdField_a_of_type_Aarv.a();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Aarv != null) {
      this.jdField_a_of_type_Aarv.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Aarv != null) {
      this.jdField_a_of_type_Aarv.a();
    }
  }
  
  void p() {}
  
  void q() {}
  
  void r() {}
  
  void s() {}
  
  protected void t()
  {
    if (this.jdField_a_of_type_Aarv != null) {
      this.jdField_a_of_type_Aarv.d();
    }
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_Aarv != null) {
      this.jdField_a_of_type_Aarv.e();
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((aodw)localIterator.next()).jdField_a_of_type_Boolean = false;
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