package com.tencent.mobileqq.activity.history;

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
import com.tencent.mobileqq.activity.history.helper.ChatHistoryItemSelectHelper;
import com.tencent.mobileqq.activity.history.widget.ChatHistorySelectBottomBar;
import com.tencent.mobileqq.activity.history.widget.ChatHistorySelectBottomBar.OnActionListener;
import com.tencent.mobileqq.activity.selectable.CommonSelectableHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import java.util.ArrayList;

public abstract class ChatHistoryBaseFragment
  extends ReportV4Fragment
{
  private int jdField_a_of_type_Int;
  Dialog jdField_a_of_type_AndroidAppDialog;
  protected Handler a;
  protected View a;
  protected ChatHistoryBaseFragment.ProgressView a;
  protected ChatHistoryBaseViewController a;
  ChatHistoryRightButtonListener jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryRightButtonListener = new ChatHistoryBaseFragment.3(this);
  protected ChatHistoryItemSelectHelper a;
  ChatHistorySelectBottomBar.OnActionListener jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar$OnActionListener = new ChatHistoryBaseFragment.2(this);
  protected ChatHistorySelectBottomBar a;
  protected CommonSelectableHelper a;
  protected BaseActivity a;
  public QQAppInterface a;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  protected String a;
  public boolean a;
  private int b;
  protected Dialog b;
  public boolean b;
  protected boolean c;
  
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
  
  void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(ChatHistoryBaseViewController paramChatHistoryBaseViewController)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController = paramChatHistoryBaseViewController;
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
  
  void b(boolean paramBoolean) {}
  
  protected int c()
  {
    return 1600;
  }
  
  protected abstract void c();
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(getActivity(), 230);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131719347, new ChatHistoryBaseFragment.1(this));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
      catch (Throwable paramString) {}
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  protected void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    localArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar.a(localArrayList);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryRightButtonListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController.a(c());
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController.a(true);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonSelectableHelper.onMoveToState(6);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonSelectableHelper.onMoveToState(10);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar.b();
    }
    c();
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperChatHistoryItemSelectHelper.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController.e();
    this.c = false;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(getActivity(), 2131755842);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559683);
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373066);
    localTextView.setText(localTextView.getResources().getString(2131689968));
    if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  void j() {}
  
  protected void k() {}
  
  protected void l() {}
  
  protected void m() {}
  
  protected void n() {}
  
  protected void o() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperChatHistoryItemSelectHelper = new ChatHistoryItemSelectHelper();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectableCommonSelectableHelper = new CommonSelectableHelper(this);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar = new ChatHistorySelectBottomBar(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (ViewGroup)getView());
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryWidgetChatHistorySelectBottomBar$OnActionListener);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment
 * JD-Core Version:    0.7.0.1
 */