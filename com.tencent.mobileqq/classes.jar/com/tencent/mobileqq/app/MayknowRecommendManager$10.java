package com.tencent.mobileqq.app;

import akaa;
import aukp;
import com.tencent.mobileqq.troop.data.RecentRecommendTroopItem;

public class MayknowRecommendManager$10
  implements Runnable
{
  public MayknowRecommendManager$10(akaa paramakaa, String paramString) {}
  
  public void run()
  {
    akaa.a(this.this$0).a(RecentRecommendTroopItem.class.getSimpleName(), "uin=?", new String[] { String.valueOf(this.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.10
 * JD-Core Version:    0.7.0.1
 */