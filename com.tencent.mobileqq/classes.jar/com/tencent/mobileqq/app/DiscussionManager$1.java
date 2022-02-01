package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.persistence.Entity;
import java.util.Comparator;
import java.util.HashMap;

class DiscussionManager$1
  implements Comparator<Entity>
{
  public int a(Entity paramEntity1, Entity paramEntity2)
  {
    long l1 = ((Long)this.a.get(((DiscussionInfo)paramEntity1).uin)).longValue();
    long l2 = ((Long)this.a.get(((DiscussionInfo)paramEntity2).uin)).longValue();
    if (l1 < l2) {
      return -1;
    }
    if (l1 > l2) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.DiscussionManager.1
 * JD-Core Version:    0.7.0.1
 */