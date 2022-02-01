package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import java.util.List;
import mqq.os.MqqHandler;

class TroopNotifyAndRecommendView$18
  extends TroopBusinessObserver
{
  TroopNotifyAndRecommendView$18(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onRecommendTroopBack(boolean paramBoolean, List<RecommendTroopItem> paramList)
  {
    if ((paramBoolean) && (paramList != null)) {
      this.a.a(paramList);
    }
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if (1 == paramInt1) {
      ThreadManager.getUIHandler().post(new TroopNotifyAndRecommendView.18.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.18
 * JD-Core Version:    0.7.0.1
 */