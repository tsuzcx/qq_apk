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
  protected ArrayList<ChatHistoryBaseFragment> a = new ArrayList();
  private BaseActivity b;
  private ChatHistoryBaseViewController c;
  private ChatHistoryTabs d;
  private ArrayList<ChatHistoryTabs.ChatHistoryTabInfo> e = new ArrayList();
  private String f;
  
  public ChatHistoryViewPagerAdapter(FragmentManager paramFragmentManager, BaseActivity paramBaseActivity, ChatHistoryBaseViewController paramChatHistoryBaseViewController, ChatHistoryTabs paramChatHistoryTabs, String paramString)
  {
    super(paramFragmentManager);
    this.b = paramBaseActivity;
    this.c = paramChatHistoryBaseViewController;
    this.d = paramChatHistoryTabs;
    this.e.clear();
    this.e.addAll(this.d.c);
    this.f = paramString;
  }
  
  private ChatHistoryTabs.ChatHistoryTabInfo e(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.e.size())) {
      return (ChatHistoryTabs.ChatHistoryTabInfo)this.e.get(paramInt);
    }
    return null;
  }
  
  private int f(int paramInt)
  {
    int i = 0;
    while (i < this.e.size())
    {
      if (((ChatHistoryTabs.ChatHistoryTabInfo)this.e.get(i)).a == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private ChatHistoryBaseFragment g(int paramInt)
  {
    int i = 0;
    while (i < this.a.size())
    {
      ChatHistoryBaseFragment localChatHistoryBaseFragment = (ChatHistoryBaseFragment)this.a.get(i);
      if ((localChatHistoryBaseFragment != null) && (localChatHistoryBaseFragment.f() == paramInt)) {
        return localChatHistoryBaseFragment;
      }
      i += 1;
    }
    return null;
  }
  
  public ChatHistoryBaseFragment a(int paramInt, boolean paramBoolean)
  {
    ChatHistoryTabs.ChatHistoryTabInfo localChatHistoryTabInfo = e(paramInt);
    Object localObject1;
    if (localChatHistoryTabInfo != null)
    {
      Object localObject2 = g(localChatHistoryTabInfo.a);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramBoolean)
        {
          localObject1 = ChatHistoryUtils.a(localChatHistoryTabInfo.a);
          ((ChatHistoryBaseFragment)localObject1).a(this.b);
          ((ChatHistoryBaseFragment)localObject1).a(this.b.app);
          ((ChatHistoryBaseFragment)localObject1).a(paramInt);
          ((ChatHistoryBaseFragment)localObject1).a(this.f);
          ((ChatHistoryBaseFragment)localObject1).b(localChatHistoryTabInfo.a);
          ((ChatHistoryBaseFragment)localObject1).a(this.c);
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("should_restore_from_kill", false);
          ((ChatHistoryBaseFragment)localObject1).setArguments((Bundle)localObject2);
          this.a.add(localObject1);
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
  
  public void a()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnDestroy  mFragmentsCache.size() = ");
      ((StringBuilder)localObject).append(this.a.size());
      QLog.d("Q.history.ViewPagerAdapter", 2, ((StringBuilder)localObject).toString());
    }
    int i = 0;
    while (i < this.a.size())
    {
      localObject = (ChatHistoryBaseFragment)this.a.get(i);
      if (localObject != null) {
        ((ChatHistoryBaseFragment)localObject).k();
      }
      i += 1;
    }
    this.a.clear();
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
    Object localObject = g(paramInt);
    if (localObject != null)
    {
      ((ChatHistoryBaseFragment)localObject).k();
      this.a.remove(localObject);
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
  
  public BaseFragment b(int paramInt)
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
  
  public void c(int paramInt)
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
      ((ChatHistoryBaseFragment)localObject).i();
    }
  }
  
  public void d(int paramInt)
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
      ((ChatHistoryBaseFragment)localObject).j();
    }
  }
  
  public int getCount()
  {
    return this.e.size();
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
      int i = f(paramObject.h());
      if (i >= 0)
      {
        if (paramObject.i() == i)
        {
          QLog.d("Q.history.ViewPagerAdapter", 2, "getItemPosition POSITION_UNCHANGED");
          return -1;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getItemPosition newPos");
        localStringBuilder.append(i);
        localStringBuilder.append(" oldPos:");
        localStringBuilder.append(paramObject.i());
        QLog.d("Q.history.ViewPagerAdapter", 2, localStringBuilder.toString());
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