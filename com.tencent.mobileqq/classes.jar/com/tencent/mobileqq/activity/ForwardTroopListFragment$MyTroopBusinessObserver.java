package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class ForwardTroopListFragment$MyTroopBusinessObserver
  extends TroopBusinessObserver
{
  protected ForwardTroopListFragment$MyTroopBusinessObserver(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  public void onGenNewTroopName(String paramString1, String paramString2)
  {
    if (this.a.a != null) {
      this.a.a.a();
    }
  }
  
  public void onModifyTroopInfo(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6) {
      if (paramInt2 == 0) {
        this.a.a();
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
      this.a.a();
      return;
    } while ((paramInt1 != 9) || (paramInt2 != 0));
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListFragment.MyTroopBusinessObserver
 * JD-Core Version:    0.7.0.1
 */