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
      this.a.j();
    }
  }
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.j();
    }
  }
  
  protected void onUpdateTroopList(boolean paramBoolean)
  {
    if (paramBoolean) {
      TroopView.a(this.a);
    }
    if (this.a.c)
    {
      TroopView localTroopView = this.a;
      localTroopView.c = false;
      if (paramBoolean)
      {
        localTroopView.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
        this.a.a(101, 800L);
      }
      else
      {
        localTroopView.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.springBackOverScrollHeaderView();
        this.a.b(2131719247);
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.postDelayed(new TroopView.MyTroopObserver.1(this), 1200L);
  }
  
  protected void onUpdateTroopNickname(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopView.MyTroopObserver
 * JD-Core Version:    0.7.0.1
 */