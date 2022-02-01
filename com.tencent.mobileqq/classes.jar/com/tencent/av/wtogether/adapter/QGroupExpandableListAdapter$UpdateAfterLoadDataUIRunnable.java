package com.tencent.av.wtogether.adapter;

import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.adapter.TroopListAdapter2.CommonlyUsedTroopCompator;
import com.tencent.mobileqq.adapter.TroopListAdapter2.TroopListItemWithMask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.CommonlyUsedTroop;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class QGroupExpandableListAdapter$UpdateAfterLoadDataUIRunnable
  implements Runnable
{
  TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  RecentUserProxy jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy;
  ArrayList<Entity> jdField_a_of_type_JavaUtilArrayList;
  List<DiscussionInfo> jdField_a_of_type_JavaUtilList;
  
  private QGroupExpandableListAdapter$UpdateAfterLoadDataUIRunnable(QGroupExpandableListAdapter paramQGroupExpandableListAdapter) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QGroupListAdapter", 2, "load data troopListInfo.size: " + this.jdField_a_of_type_JavaUtilArrayList.size() + " discussions.size:" + this.jdField_a_of_type_JavaUtilList.size());
    }
    this.this$0.jdField_a_of_type_JavaUtilList.clear();
    this.this$0.c.clear();
    this.this$0.e.clear();
    this.this$0.d.clear();
    this.this$0.b.clear();
    this.this$0.g.clear();
    this.this$0.f.clear();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("getCommonlyUsedTroopList troops size= ");
      if (localObject1 != null)
      {
        i = ((List)localObject1).size();
        QLog.d("QGroupListAdapter", 2, i);
      }
    }
    else
    {
      if (localObject1 == null) {
        break label327;
      }
      Collections.sort((List)localObject1, new TroopListAdapter2.CommonlyUsedTroopCompator());
      localObject1 = ((List)localObject1).iterator();
    }
    Object localObject3;
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label327;
      }
      localObject2 = (CommonlyUsedTroop)((Iterator)localObject1).next();
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(((CommonlyUsedTroop)localObject2).troopUin);
      if (localObject3 != null)
      {
        this.this$0.a((TroopInfo)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy);
        this.this$0.b.add(localObject3);
        continue;
        i = 0;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QGroupListAdapter", 2, "findTroopInfo troopInfo==null item.troopUin:" + ((CommonlyUsedTroop)localObject2).troopUin);
      }
    }
    label327:
    int i = this.this$0.b.size();
    localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    label602:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (TroopInfo)((Iterator)localObject2).next();
      this.this$0.a((TroopInfo)localObject3, this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy);
      int j = TroopListAdapter2.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(((TroopInfo)localObject3).troopuin));
      if (((TroopInfo)localObject3).isQidianPrivateTroop())
      {
        this.this$0.g.add(new TroopListAdapter2.TroopListItemWithMask(j, (Entity)localObject3));
      }
      else
      {
        if (((((TroopInfo)localObject3).dwAdditionalFlag & 1L) == 1L) || ((((TroopInfo)localObject3).troopowneruin != null) && (((TroopInfo)localObject3).troopowneruin.equals(localObject1)))) {
          this.this$0.c.add(new TroopListAdapter2.TroopListItemWithMask(j, (Entity)localObject3));
        }
        for (;;)
        {
          if (((TroopInfo)localObject3).hasSetTroopName()) {
            break label602;
          }
          this.this$0.f.add(new TroopListAdapter2.TroopListItemWithMask(j, (Entity)localObject3));
          break;
          if ((((TroopInfo)localObject3).dwCmdUinUinFlag & 1L) == 1L) {
            this.this$0.d.add(new TroopListAdapter2.TroopListItemWithMask(j, (Entity)localObject3));
          } else {
            this.this$0.e.add(new TroopListAdapter2.TroopListItemWithMask(j, (Entity)localObject3));
          }
        }
      }
    }
    localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    label790:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppProxyRecentUserProxy.a(((DiscussionInfo)localObject2).uin, 3000);
      ((DiscussionInfo)localObject2).lastMsgTime = ((RecentUser)localObject3).lastmsgtime;
      if (((RecentUser)localObject3).showUpTime != 0L) {
        this.this$0.b.add(localObject2);
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(((DiscussionInfo)localObject2).ownerUin)) {
        this.this$0.c.add(new TroopListAdapter2.TroopListItemWithMask(1, (Entity)localObject2));
      }
      for (;;)
      {
        if (((DiscussionInfo)localObject2).hasRenamed()) {
          break label790;
        }
        this.this$0.f.add(new TroopListAdapter2.TroopListItemWithMask(1, (Entity)localObject2));
        break;
        this.this$0.e.add(new TroopListAdapter2.TroopListItemWithMask(1, (Entity)localObject2));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QGroupListAdapter", 2, "mSetTopTroopList size1= " + i + " size2:" + this.this$0.b.size());
    }
    QGroupExpandableListAdapter.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.QGroupExpandableListAdapter.UpdateAfterLoadDataUIRunnable
 * JD-Core Version:    0.7.0.1
 */