package com.tencent.mobileqq.activity.history;

import ajjt;
import ajra;
import ajti;
import ajtj;
import ajwb;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.CustomFragmentStatePagerAdapter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ChatHistoryViewPagerAdapter
  extends CustomFragmentStatePagerAdapter
  implements ajjt
{
  private ajra jdField_a_of_type_Ajra;
  private ajti jdField_a_of_type_Ajti;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private String jdField_a_of_type_JavaLangString;
  protected ArrayList<ChatHistoryBaseFragment> a;
  private ArrayList<ajtj> b = new ArrayList();
  
  public ChatHistoryViewPagerAdapter(FragmentManager paramFragmentManager, BaseActivity paramBaseActivity, ajra paramajra, ajti paramajti, String paramString)
  {
    super(paramFragmentManager);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Ajra = paramajra;
    this.jdField_a_of_type_Ajti = paramajti;
    this.b.clear();
    this.b.addAll(this.jdField_a_of_type_Ajti.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private int a(int paramInt)
  {
    int i = 0;
    while (i < this.b.size())
    {
      if (((ajtj)this.b.get(i)).a == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private ajtj a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return (ajtj)this.b.get(paramInt);
    }
    return null;
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
  
  public Fragment a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.ViewPagerAdapter", 2, "getItem:" + paramInt);
    }
    return a(paramInt, true);
  }
  
  public ChatHistoryBaseFragment a(int paramInt, boolean paramBoolean)
  {
    ajtj localajtj = a(paramInt);
    Object localObject1 = null;
    if (localajtj != null)
    {
      Object localObject2 = a(localajtj.a);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramBoolean)
        {
          localObject1 = ajwb.a(localajtj.a);
          ((ChatHistoryBaseFragment)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          ((ChatHistoryBaseFragment)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
          ((ChatHistoryBaseFragment)localObject1).a(paramInt);
          ((ChatHistoryBaseFragment)localObject1).b(this.jdField_a_of_type_JavaLangString);
          ((ChatHistoryBaseFragment)localObject1).b(localajtj.a);
          ((ChatHistoryBaseFragment)localObject1).a(this.jdField_a_of_type_Ajra);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */