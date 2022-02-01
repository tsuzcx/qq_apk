package com.tencent.mobileqq.activity.history;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.FragmentLifeListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.CustomFragmentStatePagerAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ChatHistoryViewPagerAdapter
  extends CustomFragmentStatePagerAdapter
  implements ContactsBaseFragment.FragmentLifeListener
{
  private ChatHistoryBaseViewController jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController;
  private ChatHistoryTabs jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTabs;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private String jdField_a_of_type_JavaLangString;
  protected ArrayList<ChatHistoryBaseFragment> a;
  private ArrayList<ChatHistoryTabs.ChatHistoryTabInfo> b = new ArrayList();
  
  public ChatHistoryViewPagerAdapter(FragmentManager paramFragmentManager, BaseActivity paramBaseActivity, ChatHistoryBaseViewController paramChatHistoryBaseViewController, ChatHistoryTabs paramChatHistoryTabs, String paramString)
  {
    super(paramFragmentManager);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController = paramChatHistoryBaseViewController;
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTabs = paramChatHistoryTabs;
    this.b.clear();
    this.b.addAll(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTabs.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private int a(int paramInt)
  {
    int i = 0;
    while (i < this.b.size())
    {
      if (((ChatHistoryTabs.ChatHistoryTabInfo)this.b.get(i)).a == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private ChatHistoryBaseFragment a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ChatHistoryBaseFragment localChatHistoryBaseFragment = (ChatHistoryBaseFragment)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if ((localChatHistoryBaseFragment != null) && (localChatHistoryBaseFragment.b() == paramInt)) {
        return localChatHistoryBaseFragment;
      }
      i += 1;
    }
    return null;
  }
  
  private ChatHistoryTabs.ChatHistoryTabInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return (ChatHistoryTabs.ChatHistoryTabInfo)this.b.get(paramInt);
    }
    return null;
  }
  
  public Fragment a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.ViewPagerAdapter", 2, "getItem:" + paramInt);
    }
    return a(paramInt, true);
  }
  
  public ChatHistoryBaseFragment a(int paramInt, boolean paramBoolean)
  {
    ChatHistoryTabs.ChatHistoryTabInfo localChatHistoryTabInfo = a(paramInt);
    Object localObject1 = null;
    if (localChatHistoryTabInfo != null)
    {
      Object localObject2 = a(localChatHistoryTabInfo.a);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramBoolean)
        {
          localObject1 = ChatHistoryUtils.a(localChatHistoryTabInfo.a);
          ((ChatHistoryBaseFragment)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          ((ChatHistoryBaseFragment)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
          ((ChatHistoryBaseFragment)localObject1).a(paramInt);
          ((ChatHistoryBaseFragment)localObject1).b(this.jdField_a_of_type_JavaLangString);
          ((ChatHistoryBaseFragment)localObject1).b(localChatHistoryTabInfo.a);
          ((ChatHistoryBaseFragment)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("should_restore_from_kill", false);
          ((ChatHistoryBaseFragment)localObject1).setArguments((Bundle)localObject2);
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        }
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.ViewPagerAdapter", 2, "doOnDestroy  mFragmentsCache.size() = " + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ChatHistoryBaseFragment localChatHistoryBaseFragment = (ChatHistoryBaseFragment)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localChatHistoryBaseFragment != null) {
        localChatHistoryBaseFragment.g();
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.ViewPagerAdapter", 2, "remove fragment cache :" + paramInt);
    }
    ChatHistoryBaseFragment localChatHistoryBaseFragment = a(paramInt);
    if (localChatHistoryBaseFragment != null)
    {
      localChatHistoryBaseFragment.g();
      this.jdField_a_of_type_JavaUtilArrayList.remove(localChatHistoryBaseFragment);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.ViewPagerAdapter", 2, "onPageSelected. curPos:" + paramInt1 + " prePos:" + paramInt2);
    }
    ChatHistoryBaseFragment localChatHistoryBaseFragment = a(paramInt1, false);
    if (localChatHistoryBaseFragment != null) {
      localChatHistoryBaseFragment.a(true);
    }
    localChatHistoryBaseFragment = a(paramInt2, false);
    if (localChatHistoryBaseFragment != null) {
      localChatHistoryBaseFragment.a(false);
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.ViewPagerAdapter", 2, "doOnResume:" + paramInt);
    }
    ChatHistoryBaseFragment localChatHistoryBaseFragment = a(paramInt, false);
    if (localChatHistoryBaseFragment != null) {
      localChatHistoryBaseFragment.e();
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.ViewPagerAdapter", 2, "doOnPause:" + paramInt);
    }
    ChatHistoryBaseFragment localChatHistoryBaseFragment = a(paramInt, false);
    if (localChatHistoryBaseFragment != null) {
      localChatHistoryBaseFragment.f();
    }
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    QLog.d("Q.history.ViewPagerAdapter", 2, "getItemPosition " + paramObject);
    paramObject = (ContactsBaseFragment)paramObject;
    if (paramObject != null)
    {
      int i = a(paramObject.a());
      if (i >= 0)
      {
        if (paramObject.b() == i)
        {
          QLog.d("Q.history.ViewPagerAdapter", 2, "getItemPosition POSITION_UNCHANGED");
          return -1;
        }
        QLog.d("Q.history.ViewPagerAdapter", 2, "getItemPosition newPos" + i + " oldPos:" + paramObject.b());
        paramObject.e(i);
        return i;
      }
    }
    QLog.d("Q.history.ViewPagerAdapter", 2, "getItemPosition POSITION_NONE");
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */