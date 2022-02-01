package com.tencent.mobileqq.activity.history;

import akab;
import akac;
import akad;
import akal;
import akcs;
import akfq;
import akgf;
import akgi;
import amcd;
import android.app.Dialog;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bhlq;
import bhpc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import java.util.ArrayList;

public abstract class ChatHistoryBaseFragment
  extends ReportV4Fragment
{
  private int jdField_a_of_type_Int;
  protected akal a;
  akcs jdField_a_of_type_Akcs = new akad(this);
  public akfq a;
  public akgf a;
  akgi jdField_a_of_type_Akgi = new akac(this);
  public amcd a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  protected Handler a;
  protected View a;
  bhpc jdField_a_of_type_Bhpc;
  protected ChatHistoryBaseFragment.ProgressView a;
  public BaseActivity a;
  public QQAppInterface a;
  protected String a;
  public boolean a;
  private int b;
  protected Dialog b;
  public boolean b;
  public boolean c;
  
  public ChatHistoryBaseFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(akal paramakal)
  {
    this.jdField_a_of_type_Akal = paramakal;
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  public void a(CharSequence paramCharSequence, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.post(new ChatHistoryBaseFragment.4(this, paramOnCancelListener, paramCharSequence));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_Boolean)) {
        break label71;
      }
      e();
    }
    label71:
    label96:
    for (;;)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "onTabChange " + paramBoolean + " " + a());
      }
      return;
      if (!paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        if ((i & this.jdField_a_of_type_Boolean) == 0) {
          break label96;
        }
        f();
        break;
      }
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected abstract void b();
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean) {}
  
  protected int c()
  {
    return 1600;
  }
  
  protected abstract void c();
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Bhpc == null)
    {
      this.jdField_a_of_type_Bhpc = bhlq.a(getActivity(), 230);
      this.jdField_a_of_type_Bhpc.setNegativeButton(2131718195, new akab(this));
    }
    if (!this.jdField_a_of_type_Bhpc.isShowing()) {
      this.jdField_a_of_type_Bhpc.setMessage(paramString);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bhpc.show();
        return;
      }
      catch (Throwable paramString) {}
      this.jdField_a_of_type_Bhpc.dismiss();
    }
  }
  
  protected void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_Akgf.a(localArrayList);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Akal.a(this.jdField_a_of_type_Akcs);
    this.jdField_a_of_type_Akal.a(c());
    this.jdField_a_of_type_Akal.a(true);
    this.jdField_a_of_type_Amcd.a(5);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Akgf != null) {
      this.jdField_a_of_type_Akgf.b();
    }
    this.jdField_a_of_type_Amcd.a(9);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Akgf != null) {
      this.jdField_a_of_type_Akgf.b();
    }
    c();
  }
  
  public void h()
  {
    this.jdField_a_of_type_Akfq.a();
    this.jdField_a_of_type_Akal.e();
    this.c = false;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(getActivity(), 2131755824);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559572);
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372578);
    localTextView.setText(localTextView.getResources().getString(2131689883));
    if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void j() {}
  
  public void k() {}
  
  public void l() {}
  
  public void m() {}
  
  public void n() {}
  
  public void o() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Akfq = new akfq();
    this.jdField_a_of_type_Amcd = new amcd(this);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_AndroidViewView = paramView;
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_b_of_type_Boolean))
    {
      e();
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.BaseFragment", 2, "onViewCreated " + a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
      return;
    }
    this.jdField_a_of_type_Akgf = new akgf(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (ViewGroup)getView());
    this.jdField_a_of_type_Akgf.a(this.jdField_a_of_type_Akgi);
    d();
  }
  
  public void p()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.post(new ChatHistoryBaseFragment.5(this));
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment
 * JD-Core Version:    0.7.0.1
 */