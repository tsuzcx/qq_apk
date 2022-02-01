package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.OnTabListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FadeIconImageView;

public class ChatHistoryCommonViewController
  extends ChatHistoryBaseViewController
  implements View.OnClickListener, SimpleSlidingIndicator.OnTabListener
{
  int jdField_a_of_type_Int;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
  ChatHistoryTabs jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTabs;
  ChatHistoryViewPagerAdapter jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter;
  QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  FadeIconImageView jdField_a_of_type_ComTencentWidgetFadeIconImageView;
  int b = -1;
  public int c = 0;
  
  public ChatHistoryCommonViewController(BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity);
  }
  
  private void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageChange. position:");
      localStringBuilder.append(paramInt);
      QLog.d("Q.history.CommonViewController", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter.a(paramInt, this.b);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(paramInt, true);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTabs.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int];
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onContactTabChange. position:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" fromUserClick:");
      localStringBuilder.append(paramBoolean);
      QLog.i("Q.history.CommonViewController", 2, localStringBuilder.toString());
    }
    this.b = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt, false);
    return 0;
  }
  
  public ChatHistoryBaseFragment a()
  {
    ChatHistoryViewPagerAdapter localChatHistoryViewPagerAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter;
    if (localChatHistoryViewPagerAdapter != null) {
      return localChatHistoryViewPagerAdapter.a(this.jdField_a_of_type_Int, false);
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    a(2131369202).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131369233));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView = ((FadeIconImageView)a(2131369201));
    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)a(2131377670));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)a(2131364476));
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTabs = new ChatHistoryTabs();
    int[] arrayOfInt1 = a();
    int[] arrayOfInt2 = b();
    if ((arrayOfInt1 != null) && (arrayOfInt2 != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTabs.a(a(), arrayOfInt1, arrayOfInt2);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setTabData(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTabs.jdField_a_of_type_ArrayOfJavaLangString, arrayOfInt1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter = new ChatHistoryViewPagerAdapter(a(), a(), this, this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTabs, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter);
    if (arrayOfInt1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOffscreenPageLimit(arrayOfInt1.length);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(new ChatHistoryCommonViewController.1(this));
    b(0);
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1603: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690728);
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
      this.c = 2;
      return;
    case 1602: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131689937);
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
      this.c = 1;
      return;
    case 1601: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    ChatHistoryBaseFragment localChatHistoryBaseFragment = a();
    if (localChatHistoryBaseFragment != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onActivityResult, cur Fragment = ");
        localStringBuilder.append(localChatHistoryBaseFragment.getClass().getName());
        QLog.d("Q.history.CommonViewController", 2, localStringBuilder.toString());
      }
      localChatHistoryBaseFragment.a(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.CommonViewController", 2, "onActivityResult, cur Fragment is null ");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setEnabled(paramBoolean);
    }
  }
  
  protected int[] a()
  {
    return null;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchToTabPos mCurrentTabPos:");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("  pos:");
      localStringBuilder.append(paramInt);
      QLog.i("Q.history.CommonViewController", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(this.jdField_a_of_type_Int, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.jdField_a_of_type_Int, false);
  }
  
  protected int[] b()
  {
    return null;
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter.c(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter.a();
  }
  
  public void e()
  {
    if (this.c == 2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131689937);
      this.c = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryRightButtonListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryRightButtonListener.c();
      }
    }
  }
  
  protected void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131369233: 
      int i = this.c;
      if (i == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryRightButtonListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryRightButtonListener.b();
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690728);
        this.c = 2;
      }
      else if (i == 2)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryRightButtonListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryRightButtonListener.c();
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131689937);
        this.c = 1;
      }
      break;
    case 2131369202: 
      g();
      break;
    case 2131369201: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryRightButtonListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryRightButtonListener.a();
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryCommonViewController
 * JD-Core Version:    0.7.0.1
 */