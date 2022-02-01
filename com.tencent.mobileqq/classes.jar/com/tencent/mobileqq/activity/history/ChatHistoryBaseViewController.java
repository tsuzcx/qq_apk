package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;

public abstract class ChatHistoryBaseViewController
{
  protected FragmentActivity a;
  protected View a;
  protected ChatHistoryRightButtonListener a;
  protected String a;
  
  public ChatHistoryBaseViewController(FragmentActivity paramFragmentActivity)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
  }
  
  public abstract int a();
  
  public FragmentManager a()
  {
    return this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager();
  }
  
  protected View a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
  }
  
  public BaseActivity a()
  {
    return this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131377356);
    f();
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(ChatHistoryRightButtonListener paramChatHistoryRightButtonListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryRightButtonListener = paramChatHistoryRightButtonListener;
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b() {}
  
  public void c() {}
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryRightButtonListener = null;
  }
  
  public void e() {}
  
  protected void f()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("SissionUin");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseViewController
 * JD-Core Version:    0.7.0.1
 */