package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.ArrayList;

public class TroopView$MyTroopObserver
  extends TroopObserver
{
  protected TroopView$MyTroopObserver(TroopView paramTroopView) {}
  
  protected void onGetMutilTroopInfoResult(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if (paramBoolean) {
      this.a.l();
    }
  }
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.l();
    }
  }
  
  protected void onUpdateTroopList(boolean paramBoolean)
  {
    if (paramBoolean) {
      TroopView.a(this.a);
    }
    if (this.a.l)
    {
      TroopView localTroopView = this.a;
      localTroopView.l = false;
      if (paramBoolean)
      {
        localTroopView.m.a(0);
        this.a.a(101, 800L);
      }
      else
      {
        localTroopView.j.springBackOverScrollHeaderView();
        this.a.a(2131916799);
      }
    }
    this.a.j.postDelayed(new TroopView.MyTroopObserver.1(this), 1200L);
  }
  
  protected void onUpdateTroopNickname(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.l();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopView.MyTroopObserver
 * JD-Core Version:    0.7.0.1
 */