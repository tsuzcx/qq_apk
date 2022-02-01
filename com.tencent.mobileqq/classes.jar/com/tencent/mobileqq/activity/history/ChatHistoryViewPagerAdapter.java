package com.tencent.mobileqq.activity.history;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.FragmentLifeListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.CustomFragmentStatePagerAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
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
  
  public ChatHistoryBaseFragment a(int paramInt, boolean paramBoolean)
  {
    ChatHistoryTabs.ChatHistoryTabInfo localChatHistoryTabInfo = a(paramInt);
    Object localObject1;
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
          ((ChatHistoryBaseFragment)localObject1).a(this.jdField_a_of_type_JavaLangString);
          ((ChatHistoryBaseFragment)localObject1).b(localChatHistoryTabInfo.a);
          ((ChatHistoryBaseFragment)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryBaseViewController);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("should_restore_from_kill", false);
          ((ChatHistoryBaseFragment)localObject1).setArguments((Bundle)localObject2);
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
          return localObject1;
        }
      }
    }
    else
    {
      localObject1 = null;
    }
    return localObject1;
  }
  
  public BaseFragment a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getItem:");
      localStringBuilder.append(paramInt);
      QLog.d("Q.history.ViewPagerAdapter", 2, localStringBuilder.toString());
    }
    return a(paramInt, true);
  }
  
  public void a()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnDestroy  mFragmentsCache.size() = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilArrayList.size());
      QLog.d("Q.history.ViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject = (ChatHistoryBaseFragment)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localObject != null) {
        ((ChatHistoryBaseFragment)localObject).g();
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("remove fragment cache :");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.history.ViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramInt);
    if (localObject != null)
    {
      ((ChatHistoryBaseFragment)localObject).g();
      this.jdField_a_of_type_JavaUtilArrayList.remove(localObject);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageSelected. curPos:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" prePos:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("Q.history.ViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramInt1, false);
    if (localObject != null) {
      ((ChatHistoryBaseFragment)localObject).a(true);
    }
    localObject = a(paramInt2, false);
    if (localObject != null) {
      ((ChatHistoryBaseFragment)localObject).a(false);
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnResume:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.history.ViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramInt, false);
    if ((localObject != null) && (((ChatHistoryBaseFragment)localObject).isAdded())) {
      ((ChatHistoryBaseFragment)localObject).e();
    }
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnPause:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.history.ViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramInt, false);
    if ((localObject != null) && (((ChatHistoryBaseFragment)localObject).isAdded())) {
      ((ChatHistoryBaseFragment)localObject).f();
    }
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getItemPosition ");
    localStringBuilder.append(paramObject);
    QLog.d("Q.history.ViewPagerAdapter", 2, localStringBuilder.toString());
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
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getItemPosition newPos");
        localStringBuilder.append(i);
        localStringBuilder.append(" oldPos:");
        localStringBuilder.append(paramObject.b());
        QLog.d("Q.history.ViewPagerAdapter", 2, localStringBuilder.toString());
        paramObject.e(i);
        return i;
      }
    }
    QLog.d("Q.history.ViewPagerAdapter", 2, "getItemPosition POSITION_NONE");
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */