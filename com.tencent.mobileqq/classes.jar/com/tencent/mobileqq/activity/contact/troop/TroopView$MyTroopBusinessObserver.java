package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class TroopView$MyTroopBusinessObserver
  extends TroopBusinessObserver
{
  protected TroopView$MyTroopBusinessObserver(TroopView paramTroopView) {}
  
  public void onModifyTroopInfo(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (paramBoolean) {
      this.a.j();
    }
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6) {
      if (paramInt2 == 0) {
        this.a.j();
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
      this.a.j();
      return;
    } while ((paramInt1 != 9) || (paramInt2 != 0));
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopView.MyTroopBusinessObserver
 * JD-Core Version:    0.7.0.1
 */