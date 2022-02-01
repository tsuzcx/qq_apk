package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.BaseActivity;

public abstract class ChatHistoryBaseViewController
{
  protected View a;
  protected ChatHistoryRightButtonListener a;
  protected BaseActivity a;
  protected String a;
  
  public ChatHistoryBaseViewController(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public abstract int a();
  
  protected View a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidViewView.findViewById(paramInt);
  }
  
  public FragmentManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSupportFragmentManager();
  }
  
  public BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131376809);
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
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("SissionUin");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseViewController
 * JD-Core Version:    0.7.0.1
 */