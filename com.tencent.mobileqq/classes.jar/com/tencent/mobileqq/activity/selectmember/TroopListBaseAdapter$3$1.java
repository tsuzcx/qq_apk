package com.tencent.mobileqq.activity.selectmember;

import akbx;
import aklr;
import aklv;
import aklx;
import aklz;
import amnz;
import awge;
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

class TroopListBaseAdapter$3$1
  implements Runnable
{
  TroopListBaseAdapter$3$1(TroopListBaseAdapter.3 param3, ArrayList paramArrayList, List paramList) {}
  
  public void run()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("TroopListBaseAdapter", 2, "load data troopListInfo.size: " + this.jdField_a_of_type_JavaUtilArrayList.size() + " discussions.size:" + this.jdField_a_of_type_JavaUtilList.size());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.c.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.e.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.d.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.b.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.f.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.g.clear();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopListBaseAdapter", 2, "getCommonlyUsedTroopList troops size= " + ((List)localObject1).size());
    }
    Object localObject3;
    if (localObject1 != null)
    {
      Collections.sort((List)localObject1, new aklv());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CommonlyUsedTroop)((Iterator)localObject1).next();
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(((CommonlyUsedTroop)localObject2).troopUin);
        if (localObject3 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.a((TroopInfo)localObject3, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.jdField_a_of_type_Amnz);
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.b.add(localObject3);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("TroopListBaseAdapter", 2, "findTroopInfo troopInfo==null item.troopUin:" + ((CommonlyUsedTroop)localObject2).troopUin);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopListBaseAdapter", 2, "mSetTopTroopList1 size= " + this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.b.size());
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (TroopInfo)((Iterator)localObject2).next();
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.a((TroopInfo)localObject3, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.jdField_a_of_type_Amnz);
      i = aklr.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localObject3).troopuin));
      if (((((TroopInfo)localObject3).dwAdditionalFlag & 1L) == 1L) || ((((TroopInfo)localObject3).troopowneruin != null) && (((TroopInfo)localObject3).troopowneruin.equals(localObject1)))) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.c.add(new aklz(i, (awge)localObject3));
      }
      for (;;)
      {
        if (!((TroopInfo)localObject3).hasSetTroopName()) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.f.add(new aklz(i, (awge)localObject3));
        }
        if (!akbx.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0, ((TroopInfo)localObject3).troopuin, 1)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.g.add(new aklz(i, (awge)localObject3));
        break;
        if ((((TroopInfo)localObject3).dwCmdUinUinFlag & 1L) == 1L) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.d.add(new aklz(i, (awge)localObject3));
        } else {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.e.add(new aklz(i, (awge)localObject3));
        }
      }
    }
    localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.jdField_a_of_type_Amnz.a(((DiscussionInfo)localObject2).uin, 3000);
      ((DiscussionInfo)localObject2).lastMsgTime = ((RecentUser)localObject3).lastmsgtime;
      if (((RecentUser)localObject3).showUpTime != 0L) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.b.add(localObject2);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(((DiscussionInfo)localObject2).ownerUin)) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.c.add(new aklz(1, (awge)localObject2));
      }
      for (;;)
      {
        if (!((DiscussionInfo)localObject2).hasRenamed()) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.f.add(new aklz(1, (awge)localObject2));
        }
        if (!akbx.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0, ((DiscussionInfo)localObject2).uin, 3000)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.g.add(new aklz(1, (awge)localObject2));
        break;
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.e.add(new aklz(1, (awge)localObject2));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopListBaseAdapter", 2, "mSetTopTroopList2 size= " + this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.b.size());
    }
    localObject1 = new aklx();
    Collections.sort(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.c, (Comparator)localObject1);
    Collections.sort(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.d, (Comparator)localObject1);
    Collections.sort(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.e, (Comparator)localObject1);
    Collections.sort(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.f, (Comparator)localObject1);
    Collections.sort(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.g, (Comparator)localObject1);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.g.isEmpty()) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(13));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.b.isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.f.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(8));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.c.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(4));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.d.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(6));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.e.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(2));
      }
      localObject1 = new HashSet(5);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Integer)((Iterator)localObject2).next();
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.contains(localObject3)) {
          ((HashSet)localObject1).add(localObject3);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilHashSet = ((HashSet)localObject1);
    akbx.b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0);
    if (akbx.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.get(0));
        akbx.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0).a(0);
      }
      akbx.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0, false);
    }
    for (;;)
    {
      if ((akbx.e(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0) instanceof PinnedHeaderExpandableListView))
      {
        localObject1 = (PinnedHeaderExpandableListView)akbx.f(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0);
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.size() > 1) {
          bool = true;
        }
        ((PinnedHeaderExpandableListView)localObject1).setHeaderViewShouldShow(bool);
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.size() != 1) {
        break;
      }
      akbx.b(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0).a(0);
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilHashSet.add(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.get(0));
    }
    i = 0;
    label1621:
    if (i < this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.size())
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0.jdField_a_of_type_JavaUtilList.get(i))) {
        break label1694;
      }
      akbx.c(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0).a(i);
    }
    for (;;)
    {
      i += 1;
      break label1621;
      break;
      label1694:
      akbx.d(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopListBaseAdapter$3.this$0).b(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.3.1
 * JD-Core Version:    0.7.0.1
 */