package com.tencent.mobileqq.activity.selectmember;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.CommonlyUsedTroop;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.adapter.contact.CommonlyUsedTroopCompator;
import com.tencent.mobileqq.troop.adapter.contact.TroopCompator;
import com.tencent.mobileqq.troop.adapter.contact.TroopListItemWithMask;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("load data troopListInfo.size: ");
      ((StringBuilder)localObject1).append(this.a.size());
      ((StringBuilder)localObject1).append(" discussions.size:");
      ((StringBuilder)localObject1).append(this.b.size());
      QLog.d("TroopListBaseAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    this.c.this$0.d.clear();
    this.c.this$0.f.clear();
    this.c.this$0.h.clear();
    this.c.this$0.g.clear();
    this.c.this$0.e.clear();
    this.c.this$0.i.clear();
    this.c.this$0.j.clear();
    Object localObject1 = (ITroopInfoService)this.c.this$0.a.getRuntimeService(ITroopInfoService.class, "");
    Object localObject2 = ((ITroopInfoService)localObject1).getCommonlyUsedTroopList();
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("getCommonlyUsedTroopList troops size= ");
      ((StringBuilder)localObject3).append(((List)localObject2).size());
      QLog.d("TroopListBaseAdapter", 2, ((StringBuilder)localObject3).toString());
    }
    if (localObject2 != null)
    {
      Collections.sort((List)localObject2, new CommonlyUsedTroopCompator());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (CommonlyUsedTroop)((Iterator)localObject2).next();
        Object localObject4 = ((ITroopInfoService)localObject1).findTroopInfo(((CommonlyUsedTroop)localObject3).troopUin);
        if (localObject4 != null)
        {
          this.c.this$0.a((TroopInfo)localObject4, this.c.a);
          this.c.this$0.e.add(localObject4);
        }
        else if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("findTroopInfo troopInfo==null item.troopUin:");
          ((StringBuilder)localObject4).append(((CommonlyUsedTroop)localObject3).troopUin);
          QLog.d("TroopListBaseAdapter", 2, ((StringBuilder)localObject4).toString());
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mSetTopTroopList1 size= ");
      ((StringBuilder)localObject1).append(this.c.this$0.e.size());
      QLog.d("TroopListBaseAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = this.c.this$0.a.getCurrentUin();
    localObject2 = this.a.iterator();
    int i;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (TroopInfo)((Iterator)localObject2).next();
      this.c.this$0.a((TroopInfo)localObject3, this.c.a);
      i = ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).changeMask(SearchUtils.h(this.c.this$0.a, ((TroopInfo)localObject3).troopuin));
      if (((((TroopInfo)localObject3).dwAdditionalFlag & 1L) != 1L) && ((((TroopInfo)localObject3).troopowneruin == null) || (!((TroopInfo)localObject3).troopowneruin.equals(localObject1))))
      {
        if ((((TroopInfo)localObject3).dwCmdUinUinFlag & 1L) == 1L) {
          this.c.this$0.g.add(new TroopListItemWithMask(i, (Entity)localObject3));
        } else {
          this.c.this$0.h.add(new TroopListItemWithMask(i, (Entity)localObject3));
        }
      }
      else {
        this.c.this$0.f.add(new TroopListItemWithMask(i, (Entity)localObject3));
      }
      if (!((TroopInfo)localObject3).hasSetTroopName()) {
        this.c.this$0.i.add(new TroopListItemWithMask(i, (Entity)localObject3));
      }
      if (TroopListBaseAdapter.a(this.c.this$0, ((TroopInfo)localObject3).troopuin, 1)) {
        this.c.this$0.j.add(new TroopListItemWithMask(i, (Entity)localObject3));
      }
    }
    localObject1 = this.b.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
      localObject3 = this.c.a.b(((DiscussionInfo)localObject2).uin, 3000);
      ((DiscussionInfo)localObject2).lastMsgTime = ((RecentUser)localObject3).lastmsgtime;
      if (((RecentUser)localObject3).showUpTime != 0L) {
        this.c.this$0.e.add(localObject2);
      }
      if (this.c.this$0.a.getCurrentUin().equals(((DiscussionInfo)localObject2).ownerUin)) {
        this.c.this$0.f.add(new TroopListItemWithMask(1, (Entity)localObject2));
      } else {
        this.c.this$0.h.add(new TroopListItemWithMask(1, (Entity)localObject2));
      }
      if (!((DiscussionInfo)localObject2).hasRenamed()) {
        this.c.this$0.i.add(new TroopListItemWithMask(1, (Entity)localObject2));
      }
      if (TroopListBaseAdapter.a(this.c.this$0, ((DiscussionInfo)localObject2).uin, 3000)) {
        this.c.this$0.j.add(new TroopListItemWithMask(1, (Entity)localObject2));
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mSetTopTroopList2 size= ");
      ((StringBuilder)localObject1).append(this.c.this$0.e.size());
      QLog.d("TroopListBaseAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new TroopCompator();
    Collections.sort(this.c.this$0.f, (Comparator)localObject1);
    Collections.sort(this.c.this$0.g, (Comparator)localObject1);
    Collections.sort(this.c.this$0.h, (Comparator)localObject1);
    Collections.sort(this.c.this$0.i, (Comparator)localObject1);
    Collections.sort(this.c.this$0.j, (Comparator)localObject1);
    if (!this.c.this$0.j.isEmpty()) {
      this.c.this$0.d.add(Integer.valueOf(13));
    }
    boolean bool2 = this.c.this$0.e.isEmpty();
    boolean bool1 = false;
    if ((bool2 ^ true)) {
      this.c.this$0.d.add(Integer.valueOf(0));
    }
    if (this.c.this$0.i.size() > 0) {
      this.c.this$0.d.add(Integer.valueOf(8));
    }
    if (this.c.this$0.f.size() > 0) {
      this.c.this$0.d.add(Integer.valueOf(4));
    }
    if (this.c.this$0.g.size() > 0) {
      this.c.this$0.d.add(Integer.valueOf(6));
    }
    if (this.c.this$0.h.size() > 0) {
      this.c.this$0.d.add(Integer.valueOf(2));
    }
    localObject1 = new HashSet(5);
    localObject2 = this.c.this$0.k.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject2).next();
      if (this.c.this$0.d.contains(localObject3)) {
        ((HashSet)localObject1).add(localObject3);
      }
    }
    this.c.this$0.k = ((HashSet)localObject1);
    TroopListBaseAdapter.b(this.c.this$0);
    if (TroopListBaseAdapter.c(this.c.this$0))
    {
      if (this.c.this$0.d.size() > 0)
      {
        this.c.this$0.k.add(this.c.this$0.d.get(0));
        TroopListBaseAdapter.d(this.c.this$0).expandGroup(0);
      }
      TroopListBaseAdapter.a(this.c.this$0, false);
    }
    else if (this.c.this$0.d.size() == 1)
    {
      TroopListBaseAdapter.e(this.c.this$0).expandGroup(0);
      this.c.this$0.k.add(this.c.this$0.d.get(0));
    }
    else
    {
      i = 0;
      while (i < this.c.this$0.d.size())
      {
        if (this.c.this$0.k.contains(this.c.this$0.d.get(i))) {
          TroopListBaseAdapter.f(this.c.this$0).expandGroup(i);
        } else {
          TroopListBaseAdapter.g(this.c.this$0).collapseGroup(i);
        }
        i += 1;
      }
    }
    if ((TroopListBaseAdapter.h(this.c.this$0) instanceof PinnedHeaderExpandableListView))
    {
      localObject1 = (PinnedHeaderExpandableListView)TroopListBaseAdapter.i(this.c.this$0);
      if (this.c.this$0.d.size() > 1) {
        bool1 = true;
      }
      ((PinnedHeaderExpandableListView)localObject1).setHeaderViewShouldShow(bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.3.1
 * JD-Core Version:    0.7.0.1
 */