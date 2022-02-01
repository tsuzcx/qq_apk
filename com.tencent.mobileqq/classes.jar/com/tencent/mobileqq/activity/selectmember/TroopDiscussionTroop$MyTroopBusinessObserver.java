package com.tencent.mobileqq.activity.selectmember;

import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class TroopDiscussionTroop$MyTroopBusinessObserver
  extends TroopBusinessObserver
{
  protected TroopDiscussionTroop$MyTroopBusinessObserver(TroopDiscussionTroop paramTroopDiscussionTroop) {}
  
  public void onGenNewTroopName(String paramString1, String paramString2)
  {
    if (TroopDiscussionTroop.a(this.a) != null) {
      TroopDiscussionTroop.a(this.a).a();
    }
  }
  
  public void onModifyTroopInfo(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (paramBoolean) {
      this.a.c();
    }
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6) {
      if (paramInt2 == 0) {
        this.a.c();
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt1 != 2) {
          break;
        }
      } while (paramInt2 != 0);
      this.a.c();
      return;
    } while ((paramInt1 != 9) || (paramInt2 != 0));
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopDiscussionTroop.MyTroopBusinessObserver
 * JD-Core Version:    0.7.0.1
 */