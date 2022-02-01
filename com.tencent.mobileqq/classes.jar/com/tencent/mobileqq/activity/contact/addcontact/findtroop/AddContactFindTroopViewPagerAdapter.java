package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.util.SparseArray;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.activity.contacts.base.HeadViewScrollListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.base.tabs.TabInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class AddContactFindTroopViewPagerAdapter
  extends ContactsViewPagerAdapter
{
  public AddContactFindTroopViewPagerAdapter(FragmentManager paramFragmentManager, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ArrayList<TabInfo> paramArrayList)
  {
    super(paramFragmentManager, paramQQAppInterface, paramBaseActivity, paramArrayList);
  }
  
  public ContactsBaseFragment a(int paramInt, boolean paramBoolean)
  {
    TabInfo localTabInfo = c(paramInt);
    Object localObject1;
    if ((localTabInfo != null) && ((localTabInfo instanceof AddContactFindTroopClassifyInfo)))
    {
      AddContactFindTroopClassifyInfo localAddContactFindTroopClassifyInfo = (AddContactFindTroopClassifyInfo)localTabInfo;
      Object localObject2 = f(localTabInfo.j);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramBoolean)
        {
          localObject1 = new AddContactViewPagerTroopFragment();
          localObject2 = (AddContactViewPagerTroopFragment)localObject1;
          ((AddContactViewPagerTroopFragment)localObject2).c = localAddContactFindTroopClassifyInfo.f;
          ((AddContactViewPagerTroopFragment)localObject2).d = localAddContactFindTroopClassifyInfo.a;
          ((AddContactViewPagerTroopFragment)localObject2).e = localAddContactFindTroopClassifyInfo.d;
          ((ContactsBaseFragment)localObject1).a(this.d);
          ((ContactsBaseFragment)localObject1).a(this.c);
          ((ContactsBaseFragment)localObject1).a(this);
          ((ContactsBaseFragment)localObject1).a(this.b);
          ((ContactsBaseFragment)localObject1).e(paramInt);
          if ((localObject1 instanceof HeadViewScrollListener)) {
            this.f.add((HeadViewScrollListener)localObject1);
          }
          this.a.put(localTabInfo.j, localObject1);
        }
      }
    }
    else
    {
      localObject1 = null;
    }
    if ((localObject1 != null) && ((localObject1 instanceof HeadViewScrollListener)) && (this.h > 0)) {
      ((HeadViewScrollListener)localObject1).a(this.g, this.h);
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactFindTroopViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */