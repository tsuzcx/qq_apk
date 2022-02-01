package com.tencent.mobileqq.app;

import aobl;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.RecentRecommendTroopItem;

public class MayknowRecommendManager$11
  implements Runnable
{
  public MayknowRecommendManager$11(aobl paramaobl, String paramString) {}
  
  public void run()
  {
    aobl.a(this.this$0).delete(RecentRecommendTroopItem.class.getSimpleName(), "uin=?", new String[] { String.valueOf(this.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.11
 * JD-Core Version:    0.7.0.1
 */