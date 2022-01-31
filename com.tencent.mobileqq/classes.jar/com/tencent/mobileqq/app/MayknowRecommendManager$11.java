package com.tencent.mobileqq.app;

import ajls;
import atmp;
import com.tencent.mobileqq.troop.data.RecentRecommendTroopItem;

public class MayknowRecommendManager$11
  implements Runnable
{
  public MayknowRecommendManager$11(ajls paramajls, String paramString) {}
  
  public void run()
  {
    ajls.a(this.this$0).a(RecentRecommendTroopItem.class.getSimpleName(), "uin=?", new String[] { String.valueOf(this.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.11
 * JD-Core Version:    0.7.0.1
 */