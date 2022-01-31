package com.tencent.mobileqq.app;

import akac;
import aukn;
import com.tencent.mobileqq.troop.data.RecentRecommendTroopItem;

public class MayknowRecommendManager$10
  implements Runnable
{
  public MayknowRecommendManager$10(akac paramakac, String paramString) {}
  
  public void run()
  {
    akac.a(this.this$0).a(RecentRecommendTroopItem.class.getSimpleName(), "uin=?", new String[] { String.valueOf(this.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.10
 * JD-Core Version:    0.7.0.1
 */