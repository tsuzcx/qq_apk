package com.tencent.mobileqq.activity.contacts.adapter;

import afpo;
import aipt;
import aipx;
import aipz;
import aiqb;
import aktg;
import aukm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class ContactsTroopAdapter$6$1
  implements Runnable
{
  ContactsTroopAdapter$6$1(ContactsTroopAdapter.6 param6, ArrayList paramArrayList, List paramList) {}
  
  public void run()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTroopAdapter", 2, "load data troopListInfo.size: " + this.jdField_a_of_type_JavaUtilArrayList.size() + " discussions.size:" + this.jdField_a_of_type_JavaUtilList.size());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.c.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.e.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.d.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.b.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.g.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.f.clear();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTroopAdapter", 2, "getCommonlyUsedTroopList troops size= " + ((List)localObject1).size());
    }
    Object localObject3;
    if (localObject1 != null)
    {
      Collections.sort((List)localObject1, new aipx());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CommonlyUsedTroop)((Iterator)localObject1).next();
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(((CommonlyUsedTroop)localObject2).troopUin);
        if (localObject3 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.a((TroopInfo)localObject3, this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.jdField_a_of_type_Aktg);
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.b.add(localObject3);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("ContactsTroopAdapter", 2, "findTroopInfo troopInfo==null item.troopUin:" + ((CommonlyUsedTroop)localObject2).troopUin);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTroopAdapter", 2, "mSetTopTroopList1 size= " + this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.b.size());
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    label684:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (TroopInfo)((Iterator)localObject2).next();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.a((TroopInfo)localObject3, this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.jdField_a_of_type_Aktg);
      i = aipt.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localObject3).troopuin));
      if (((TroopInfo)localObject3).isQidianPrivateTroop())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.g.add(new aiqb(i, (aukm)localObject3));
      }
      else
      {
        if (((((TroopInfo)localObject3).dwAdditionalFlag & 1L) == 1L) || ((((TroopInfo)localObject3).troopowneruin != null) && (((TroopInfo)localObject3).troopowneruin.equals(localObject1)))) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.c.add(new aiqb(i, (aukm)localObject3));
        }
        for (;;)
        {
          if (((TroopInfo)localObject3).hasSetTroopName()) {
            break label684;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.f.add(new aiqb(i, (aukm)localObject3));
          break;
          if ((((TroopInfo)localObject3).dwCmdUinUinFlag & 1L) == 1L) {
            this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.d.add(new aiqb(i, (aukm)localObject3));
          } else {
            this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.e.add(new aiqb(i, (aukm)localObject3));
          }
        }
      }
    }
    localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    label888:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.jdField_a_of_type_Aktg.a(((DiscussionInfo)localObject2).uin, 3000);
      ((DiscussionInfo)localObject2).lastMsgTime = ((RecentUser)localObject3).lastmsgtime;
      if (((RecentUser)localObject3).showUpTime != 0L) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.b.add(localObject2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(((DiscussionInfo)localObject2).ownerUin)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.c.add(new aiqb(1, (aukm)localObject2));
      }
      for (;;)
      {
        if (((DiscussionInfo)localObject2).hasRenamed()) {
          break label888;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.f.add(new aiqb(1, (aukm)localObject2));
        break;
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.e.add(new aiqb(1, (aukm)localObject2));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactsTroopAdapter", 2, "mSetTopTroopList2 size= " + this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.b.size());
    }
    localObject1 = new aipz();
    Collections.sort(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.c, (Comparator)localObject1);
    Collections.sort(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.d, (Comparator)localObject1);
    Collections.sort(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.e, (Comparator)localObject1);
    Collections.sort(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.f, (Comparator)localObject1);
    Collections.sort(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.g, (Comparator)localObject1);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.b.isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.f.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(8));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.c.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(4));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.d.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(6));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.e.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.g.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(10));
      }
      localObject1 = new HashSet(5);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Integer)((Iterator)localObject2).next();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.jdField_a_of_type_JavaUtilList.contains(localObject3)) {
          ((HashSet)localObject1).add(localObject3);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.jdField_a_of_type_JavaUtilHashSet = ((HashSet)localObject1);
    afpo.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0);
    if (afpo.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0))
    {
      afpo.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0, false);
      afpo.c(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0);
    }
    for (;;)
    {
      if ((afpo.d(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0) instanceof PinnedHeaderExpandableListView))
      {
        localObject1 = (PinnedHeaderExpandableListView)afpo.e(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.jdField_a_of_type_JavaUtilList.size() > 1) {
          bool = true;
        }
        ((PinnedHeaderExpandableListView)localObject1).setHeaderViewShouldShow(bool);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.jdField_a_of_type_JavaUtilList.size() != 1) {
        break;
      }
      afpo.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0).a(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.jdField_a_of_type_JavaUtilList.get(0));
    }
    i = 0;
    label1513:
    if (i < this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.jdField_a_of_type_JavaUtilList.size())
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0.jdField_a_of_type_JavaUtilList.get(i))) {
        break label1586;
      }
      afpo.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0).a(i);
    }
    for (;;)
    {
      i += 1;
      break label1513;
      break;
      label1586:
      afpo.c(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsTroopAdapter$6.this$0).b(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.adapter.ContactsTroopAdapter.6.1
 * JD-Core Version:    0.7.0.1
 */