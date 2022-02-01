package com.tencent.mobileqq.app.asyncdb.cache;

import com.tencent.mobileqq.data.BaseRecentUser;
import com.tencent.mobileqq.persistence.Entity;
import java.util.Comparator;

class BaseRecentUserCache$RecentComparator
  implements Comparator<Entity>
{
  private boolean withShowUp;
  
  public BaseRecentUserCache$RecentComparator(boolean paramBoolean)
  {
    this.withShowUp = paramBoolean;
  }
  
  public int compare(Entity paramEntity1, Entity paramEntity2)
  {
    paramEntity1 = (BaseRecentUser)paramEntity1;
    paramEntity2 = (BaseRecentUser)paramEntity2;
    long l3 = Math.max(paramEntity1.lastmsgtime, paramEntity1.lastmsgdrafttime);
    long l2 = Math.max(paramEntity2.lastmsgtime, paramEntity2.lastmsgdrafttime);
    long l1;
    if (this.withShowUp) {
      if ((paramEntity1.showUpTime > 0L) && (l3 == 0L))
      {
        l1 = Math.max(paramEntity1.opTime, paramEntity1.showUpTime);
        if ((paramEntity2.showUpTime <= 0L) || (l2 != 0L)) {
          break label194;
        }
        l3 = Math.max(paramEntity2.opTime, paramEntity2.showUpTime);
        l2 = l1;
        l1 = l3;
      }
    }
    for (;;)
    {
      if (l2 > l1)
      {
        l1 = 3L;
        label117:
        l3 = l1;
        if (!this.withShowUp) {
          break label280;
        }
        l2 = l1;
        if (paramEntity1.showUpTime > 0L) {
          l2 = l1 | 0x1000;
        }
        l3 = l2;
        if (paramEntity2.showUpTime <= 0L) {
          break label280;
        }
        l1 = 0x2 | 0x1000;
        label167:
        if (l2 >= l1) {
          break label269;
        }
        return 1;
        l1 = l3;
        if (l3 != 0L) {
          break;
        }
        l1 = paramEntity1.opTime;
        break;
        label194:
        if (l2 != 0L) {
          break label310;
        }
        l3 = paramEntity2.opTime;
        l2 = l1;
        l1 = l3;
        continue;
        if (l3 != 0L) {
          break label304;
        }
      }
      label269:
      label280:
      label304:
      for (l1 = paramEntity1.opTime;; l1 = l3)
      {
        if (l2 == 0L)
        {
          l3 = paramEntity2.opTime;
          l2 = l1;
          l1 = l3;
          break;
          if (l2 < l1)
          {
            l1 = 1L;
            break label117;
          }
          l1 = 2L;
          break label117;
          if (l2 == l1) {
            return 0;
          }
          return -1;
          l2 = l3;
          l1 = 2L;
          break label167;
        }
        l3 = l1;
        l1 = l2;
        l2 = l3;
        break;
      }
      label310:
      l3 = l1;
      l1 = l2;
      l2 = l3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.BaseRecentUserCache.RecentComparator
 * JD-Core Version:    0.7.0.1
 */