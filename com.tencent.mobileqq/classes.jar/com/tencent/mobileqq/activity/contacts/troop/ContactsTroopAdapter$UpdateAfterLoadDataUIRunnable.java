package com.tencent.mobileqq.activity.contacts.troop;

import com.tencent.mobileqq.adapter.TroopListAdapter2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.CommonlyUsedTroop;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.troop.adapter.contact.CommonlyUsedTroopCompator;
import com.tencent.mobileqq.troop.adapter.contact.TroopListItemWithMask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ContactsTroopAdapter$UpdateAfterLoadDataUIRunnable
  implements Runnable
{
  TroopManager a;
  RecentUserProxy b;
  ArrayList<Entity> c;
  List<DiscussionInfo> d;
  
  protected ContactsTroopAdapter$UpdateAfterLoadDataUIRunnable(ContactsTroopAdapter paramContactsTroopAdapter) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("load data troopListInfo.size: ");
      ((StringBuilder)localObject1).append(this.c.size());
      ((StringBuilder)localObject1).append(" discussions.size:");
      ((StringBuilder)localObject1).append(this.d.size());
      QLog.d("ContactsTroopAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    this.this$0.c.clear();
    this.this$0.e.clear();
    this.this$0.g.clear();
    this.this$0.f.clear();
    this.this$0.d.clear();
    this.this$0.i.clear();
    this.this$0.h.clear();
    Object localObject1 = this.a.d();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getCommonlyUsedTroopList troops size= ");
      if (localObject1 != null) {
        i = ((List)localObject1).size();
      } else {
        i = 0;
      }
      ((StringBuilder)localObject2).append(i);
      QLog.d("ContactsTroopAdapter", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject3;
    if (localObject1 != null)
    {
      Collections.sort((List)localObject1, new CommonlyUsedTroopCompator());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CommonlyUsedTroop)((Iterator)localObject1).next();
        localObject3 = this.a.f(((CommonlyUsedTroop)localObject2).troopUin);
        if (localObject3 != null)
        {
          this.this$0.a((TroopInfo)localObject3, this.b);
          this.this$0.d.add(localObject3);
        }
        else if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("findTroopInfo troopInfo==null item.troopUin:");
          ((StringBuilder)localObject3).append(((CommonlyUsedTroop)localObject2).troopUin);
          QLog.d("ContactsTroopAdapter", 2, ((StringBuilder)localObject3).toString());
        }
      }
    }
    int i = this.this$0.d.size();
    localObject1 = this.this$0.a.getCurrentUin();
    Object localObject2 = this.c.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (TroopInfo)((Iterator)localObject2).next();
      this.this$0.a((TroopInfo)localObject3, this.b);
      int j = TroopListAdapter2.b(this.this$0.a.getTroopMask(((TroopInfo)localObject3).troopuin));
      if (((TroopInfo)localObject3).isQidianPrivateTroop())
      {
        this.this$0.i.add(new TroopListItemWithMask(j, (Entity)localObject3));
      }
      else
      {
        if (((((TroopInfo)localObject3).dwAdditionalFlag & 1L) != 1L) && ((((TroopInfo)localObject3).troopowneruin == null) || (!((TroopInfo)localObject3).troopowneruin.equals(localObject1))))
        {
          if ((((TroopInfo)localObject3).dwCmdUinUinFlag & 1L) == 1L) {
            this.this$0.f.add(new TroopListItemWithMask(j, (Entity)localObject3));
          } else {
            this.this$0.g.add(new TroopListItemWithMask(j, (Entity)localObject3));
          }
        }
        else {
          this.this$0.e.add(new TroopListItemWithMask(j, (Entity)localObject3));
        }
        if (!((TroopInfo)localObject3).hasSetTroopName()) {
          this.this$0.h.add(new TroopListItemWithMask(j, (Entity)localObject3));
        }
      }
    }
    localObject1 = this.d.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
      localObject3 = this.b.b(((DiscussionInfo)localObject2).uin, 3000);
      ((DiscussionInfo)localObject2).lastMsgTime = ((RecentUser)localObject3).lastmsgtime;
      if (((RecentUser)localObject3).showUpTime != 0L) {
        this.this$0.d.add(localObject2);
      }
      if (this.this$0.a.getCurrentUin().equals(((DiscussionInfo)localObject2).ownerUin)) {
        this.this$0.e.add(new TroopListItemWithMask(1, (Entity)localObject2));
      } else {
        this.this$0.g.add(new TroopListItemWithMask(1, (Entity)localObject2));
      }
      if (!((DiscussionInfo)localObject2).hasRenamed()) {
        this.this$0.h.add(new TroopListItemWithMask(1, (Entity)localObject2));
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mSetTopTroopList size1= ");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(" size2:");
      ((StringBuilder)localObject1).append(this.this$0.d.size());
      QLog.d("ContactsTroopAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    this.this$0.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter.UpdateAfterLoadDataUIRunnable
 * JD-Core Version:    0.7.0.1
 */