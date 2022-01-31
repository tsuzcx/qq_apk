package com.tencent.mobileqq.app;

import alwd;
import awgf;
import com.tencent.mobileqq.troop.data.RecentRecommendTroopItem;

public class MayknowRecommendManager$11
  implements Runnable
{
  public MayknowRecommendManager$11(alwd paramalwd, String paramString) {}
  
  public void run()
  {
    alwd.a(this.this$0).a(RecentRecommendTroopItem.class.getSimpleName(), "uin=?", new String[] { String.valueOf(this.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.11
 * JD-Core Version:    0.7.0.1
 */