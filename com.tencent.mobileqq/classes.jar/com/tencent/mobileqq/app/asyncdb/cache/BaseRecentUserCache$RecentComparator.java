package com.tencent.mobileqq.app.asyncdb.cache;

import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import java.util.Comparator;

class BaseRecentUserCache$RecentComparator
  implements Comparator<Entity>
{
  private boolean a;
  
  public BaseRecentUserCache$RecentComparator(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public int a(Entity paramEntity1, Entity paramEntity2)
  {
    paramEntity1 = (RecentUser)paramEntity1;
    paramEntity2 = (RecentUser)paramEntity2;
    long l2 = Math.max(paramEntity1.lastmsgtime, paramEntity1.lastmsgdrafttime);
    long l4 = Math.max(paramEntity2.lastmsgtime, paramEntity2.lastmsgdrafttime);
    long l1;
    if (this.a)
    {
      if ((paramEntity1.showUpTime > 0L) && (l2 == 0L))
      {
        l1 = Math.max(paramEntity1.opTime, paramEntity1.showUpTime);
      }
      else
      {
        l1 = l2;
        if (l2 == 0L) {
          l1 = paramEntity1.opTime;
        }
      }
      if ((paramEntity2.showUpTime > 0L) && (l4 == 0L))
      {
        l2 = Math.max(paramEntity2.opTime, paramEntity2.showUpTime);
        l3 = l1;
      }
      else
      {
        l3 = l1;
        l2 = l4;
        if (l4 == 0L)
        {
          l2 = paramEntity2.opTime;
          l3 = l1;
        }
      }
    }
    else
    {
      l1 = l2;
      if (l2 == 0L) {
        l1 = paramEntity1.opTime;
      }
      l3 = l1;
      l2 = l4;
      if (l4 == 0L)
      {
        l2 = paramEntity2.opTime;
        l3 = l1;
      }
    }
    long l5 = 2L;
    if (l3 > l2) {
      l1 = 3L;
    } else if (l3 < l2) {
      l1 = 1L;
    } else {
      l1 = 2L;
    }
    long l3 = l1;
    l4 = l5;
    if (this.a)
    {
      l2 = l1;
      if (paramEntity1.showUpTime > 0L) {
        l2 = l1 | 0x1000;
      }
      l3 = l2;
      l4 = l5;
      if (paramEntity2.showUpTime > 0L)
      {
        l4 = 4098L;
        l3 = l2;
      }
    }
    if (l3 < l4) {
      return 1;
    }
    if (l3 == l4) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.BaseRecentUserCache.RecentComparator
 * JD-Core Version:    0.7.0.1
 */