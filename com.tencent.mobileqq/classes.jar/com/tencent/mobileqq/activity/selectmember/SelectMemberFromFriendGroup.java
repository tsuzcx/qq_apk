package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ybq;

public class SelectMemberFromFriendGroup
  extends SelectMemberInnerFrame
{
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public List a;
  ybq jdField_a_of_type_Ybq;
  List b = new ArrayList();
  
  public SelectMemberFromFriendGroup(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public SelectMemberFromFriendGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public SelectMemberFromFriendGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void i()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    if (localObject1 != null)
    {
      Object localObject3 = ((RecentUserProxy)localObject1).a(true);
      if (localObject3 != null)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject1 = new ArrayList();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (RecentUser)((Iterator)localObject3).next();
          if (localObject4 != null) {
            try
            {
              if ((((RecentUser)localObject4).type == 0) && (Long.parseLong(((RecentUser)localObject4).uin) >= 10000L) && (!((RecentUser)localObject4).uin.equals(localObject2)) && (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.h.contains(((RecentUser)localObject4).uin)))
              {
                localObject4 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(((RecentUser)localObject4).uin);
                if ((localObject4 != null) && (((Friends)localObject4).isFriend())) {
                  ((List)localObject1).add(localObject4);
                }
              }
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
        }
        if (!((List)localObject1).isEmpty())
        {
          localObject2 = new Groups();
          ((Groups)localObject2).group_id = 1003;
          ((Groups)localObject2).group_name = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131433336);
          ((Groups)localObject2).group_friend_count = ((List)localObject1).size();
          ((Groups)localObject2).seqid = 0;
          this.jdField_a_of_type_JavaUtilArrayList.add(0, localObject2);
          this.b = ((List)localObject1);
        }
      }
    }
  }
  
  public ContactSearchFragment a()
  {
    return ContactSearchFragment.a(-1, 1, null, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.h, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
  }
  
  public String a()
  {
    return null;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    h();
    g();
  }
  
  public void a(Groups paramGroups, boolean paramBoolean)
  {
    if (paramGroups.group_id == 1003) {}
    Object localObject;
    ArrayList localArrayList;
    for (paramGroups = this.b;; paramGroups = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(paramGroups.group_id))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f;
      localArrayList = new ArrayList();
      paramGroups = paramGroups.iterator();
      while (paramGroups.hasNext())
      {
        Friends localFriends = (Friends)paramGroups.next();
        if ((localObject == null) || (!((List)localObject).contains(localFriends.uin))) {
          localArrayList.add(SelectMemberActivity.a(localFriends.uin, localFriends.getFriendNickWithAlias(), 0, "-1"));
        }
      }
    }
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localArrayList, false);
    }
    for (;;)
    {
      f();
      return;
      paramGroups = localArrayList.iterator();
      while (paramGroups.hasNext())
      {
        localObject = (ResultRecord)paramGroups.next();
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.e(((ResultRecord)localObject).a);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.b(false);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.j();
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.r();
    }
  }
  
  public boolean a(Groups paramGroups)
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f;
    if (localArrayList == null) {
      return false;
    }
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if (paramGroups.group_id == 1003) {}
    for (paramGroups = this.b;; paramGroups = localFriendsManager.a(paramGroups.group_id))
    {
      paramGroups = paramGroups.iterator();
      do
      {
        if (!paramGroups.hasNext()) {
          break;
        }
      } while (localArrayList.contains(((Friends)paramGroups.next()).uin));
      return false;
    }
    return true;
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(true, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131435991), this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getString(2131435519));
    f();
  }
  
  public void f()
  {
    ArrayList localArrayList1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.i;
    ArrayList localArrayList2 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.f;
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    Groups localGroups;
    if (localIterator1.hasNext())
    {
      localGroups = (Groups)localIterator1.next();
      Object localObject;
      if (localGroups.group_id == 1003)
      {
        localObject = this.b;
        localObject = ((List)localObject).iterator();
      }
      label181:
      do
      {
        Friends localFriends;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localFriends = (Friends)((Iterator)localObject).next();
        } while ((localArrayList2 != null) && (localArrayList2.contains(localFriends.uin)));
        Iterator localIterator2 = localArrayList1.iterator();
        j = 0;
        for (;;)
        {
          if (localIterator2.hasNext())
          {
            if (!((ResultRecord)localIterator2.next()).a.equals(localFriends.uin)) {
              break label285;
            }
            j = 1;
            continue;
            localObject = localFriendsManager.a(localGroups.group_id);
            break;
          }
        }
      } while (j != 0);
    }
    for (int j = 0;; j = 1)
    {
      if (j == 0)
      {
        if (!this.jdField_a_of_type_JavaUtilList.contains(localGroups)) {
          break label282;
        }
        this.jdField_a_of_type_JavaUtilList.remove(localGroups);
        i = 1;
      }
      label282:
      for (;;)
      {
        break;
        if (!this.jdField_a_of_type_JavaUtilList.contains(localGroups))
        {
          this.jdField_a_of_type_JavaUtilList.add(localGroups);
          i = 1;
          continue;
          if (i != 0) {
            this.jdField_a_of_type_Ybq.notifyDataSetChanged();
          }
          return;
        }
      }
      label285:
      break label181;
    }
  }
  
  void g()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
    XListView localXListView = new XListView(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity);
    localXListView.setDivider(null);
    localLinearLayout.addView(localXListView);
    localXListView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_Ybq = new ybq(this);
    localXListView.setAdapter(this.jdField_a_of_type_Ybq);
    setContentView(localLinearLayout);
  }
  
  void h()
  {
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if (localObject != null) {}
    for (localObject = ((FriendsManager)localObject).a();; localObject = null)
    {
      if (((localObject == null) || (((List)localObject).size() == 0)) && (localObject == null)) {
        localObject = new ArrayList();
      }
      for (;;)
      {
        i();
        int i = ((List)localObject).size() - 1;
        if (i >= 0)
        {
          Groups localGroups = (Groups)((List)localObject).get(i);
          if (localGroups.group_friend_count == 0) {}
          for (;;)
          {
            i -= 1;
            break;
            this.jdField_a_of_type_JavaUtilArrayList.add(localGroups);
          }
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.SelectMemberFromFriendGroup
 * JD-Core Version:    0.7.0.1
 */