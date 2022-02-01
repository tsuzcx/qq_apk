package com.tencent.mobileqq.activity.contacts.troop;

import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class TroopFragment$MyTroopBusinessObserver
  extends TroopBusinessObserver
{
  protected TroopFragment$MyTroopBusinessObserver(TroopFragment paramTroopFragment) {}
  
  public void onGenNewTroopName(String paramString1, String paramString2)
  {
    if (this.a.a != null) {
      this.a.a.c();
    }
  }
  
  public void onModifyTroopInfo(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (paramBoolean) {
      this.a.h();
    }
  }
  
  public void onTroopBlockStatusChanged(String paramString)
  {
    this.a.h();
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6) {
      if (paramInt2 == 0) {
        this.a.h();
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
      this.a.h();
      return;
    } while ((paramInt1 != 9) || (paramInt2 != 0));
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.TroopFragment.MyTroopBusinessObserver
 * JD-Core Version:    0.7.0.1
 */