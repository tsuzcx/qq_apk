package com.tencent.mobileqq.activity.history;

import afvv;
import afvw;
import afvx;
import afwf;
import afyi;
import agbd;
import agbq;
import agbt;
import aibw;
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
import bbdj;
import bbgu;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public abstract class ChatHistoryBaseFragment
  extends Fragment
{
  private int jdField_a_of_type_Int;
  protected afwf a;
  afyi jdField_a_of_type_Afyi = new afvx(this);
  public agbd a;
  public agbq a;
  agbt jdField_a_of_type_Agbt = new afvw(this);
  public aibw a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  protected Handler a;
  protected View a;
  bbgu jdField_a_of_type_Bbgu;
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
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(afwf paramafwf)
  {
    this.jdField_a_of_type_Afwf = paramafwf;
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
    this.jdField_a_of_type_Int = paramInt;
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
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Bbgu == null)
    {
      this.jdField_a_of_type_Bbgu = bbdj.a(getActivity(), 230);
      this.jdField_a_of_type_Bbgu.setNegativeButton(2131719551, new afvv(this));
    }
    if (!this.jdField_a_of_type_Bbgu.isShowing()) {
      this.jdField_a_of_type_Bbgu.setMessage(paramString);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bbgu.show();
        return;
      }
      catch (Throwable paramString) {}
      this.jdField_a_of_type_Bbgu.dismiss();
    }
  }
  
  protected void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_Agbq.a(localArrayList);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Afwf.a(this.jdField_a_of_type_Afyi);
    this.jdField_a_of_type_Afwf.a(c());
    this.jdField_a_of_type_Afwf.a(true);
    this.jdField_a_of_type_Aibw.a(4);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Agbq != null) {
      this.jdField_a_of_type_Agbq.b();
    }
    this.jdField_a_of_type_Aibw.a(8);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Agbq != null) {
      this.jdField_a_of_type_Agbq.b();
    }
    c();
  }
  
  public void h()
  {
    this.jdField_a_of_type_Agbd.a();
    this.jdField_a_of_type_Afwf.e();
    this.c = false;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(getActivity(), 2131755791);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559386);
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371557);
    localTextView.setText(localTextView.getResources().getString(2131689932));
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
  
  public void o()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.post(new ChatHistoryBaseFragment.5(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Agbd = new agbd();
    this.jdField_a_of_type_Aibw = new aibw(this);
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
    this.jdField_a_of_type_Agbq = new agbq(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (ViewGroup)getView());
    this.jdField_a_of_type_Agbq.a(this.jdField_a_of_type_Agbt);
    d();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment
 * JD-Core Version:    0.7.0.1
 */