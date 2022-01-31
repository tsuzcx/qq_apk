package com.tencent.mobileqq.activity.history;

import ahtp;
import ahtq;
import ahtr;
import ahtz;
import ahwg;
import ahze;
import ahzt;
import ahzw;
import ajtg;
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
import bdcd;
import bdfq;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public abstract class ChatHistoryBaseFragment
  extends Fragment
{
  private int jdField_a_of_type_Int;
  protected ahtz a;
  ahwg jdField_a_of_type_Ahwg = new ahtr(this);
  public ahze a;
  public ahzt a;
  ahzw jdField_a_of_type_Ahzw = new ahtq(this);
  public ajtg a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  protected Handler a;
  protected View a;
  bdfq jdField_a_of_type_Bdfq;
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
  
  public void a(ahtz paramahtz)
  {
    this.jdField_a_of_type_Ahtz = paramahtz;
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
    if (this.jdField_a_of_type_Bdfq == null)
    {
      this.jdField_a_of_type_Bdfq = bdcd.a(getActivity(), 230);
      this.jdField_a_of_type_Bdfq.setNegativeButton(2131720083, new ahtp(this));
    }
    if (!this.jdField_a_of_type_Bdfq.isShowing()) {
      this.jdField_a_of_type_Bdfq.setMessage(paramString);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bdfq.show();
        return;
      }
      catch (Throwable paramString) {}
      this.jdField_a_of_type_Bdfq.dismiss();
    }
  }
  
  protected void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_Ahzt.a(localArrayList);
  }
  
  public void e()
  {
    this.jdField_a_of_type_Ahtz.a(this.jdField_a_of_type_Ahwg);
    this.jdField_a_of_type_Ahtz.a(c());
    this.jdField_a_of_type_Ahtz.a(true);
    this.jdField_a_of_type_Ajtg.a(4);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Ahzt != null) {
      this.jdField_a_of_type_Ahzt.b();
    }
    this.jdField_a_of_type_Ajtg.a(8);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Ahzt != null) {
      this.jdField_a_of_type_Ahzt.b();
    }
    c();
  }
  
  public void h()
  {
    this.jdField_a_of_type_Ahze.a();
    this.jdField_a_of_type_Ahtz.e();
    this.c = false;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(getActivity(), 2131755801);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559438);
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371874);
    localTextView.setText(localTextView.getResources().getString(2131689979));
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
    this.jdField_a_of_type_Ahze = new ahze();
    this.jdField_a_of_type_Ajtg = new ajtg(this);
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
    this.jdField_a_of_type_Ahzt = new ahzt(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (ViewGroup)getView());
    this.jdField_a_of_type_Ahzt.a(this.jdField_a_of_type_Ahzw);
    d();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment
 * JD-Core Version:    0.7.0.1
 */