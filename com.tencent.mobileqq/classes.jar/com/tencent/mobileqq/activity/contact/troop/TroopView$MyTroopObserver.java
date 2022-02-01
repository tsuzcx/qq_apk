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
  
  public void onGetMutilTroopInfoResult(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if (paramBoolean) {
      this.a.j();
    }
  }
  
  public void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.j();
    }
  }
  
  public void onUpdateTroopList(boolean paramBoolean)
  {
    if (paramBoolean) {
      TroopView.a(this.a);
    }
    if (this.a.c)
    {
      this.a.c = false;
      if (!paramBoolean) {
        break label79;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0);
      this.a.a(101, 800L);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.postDelayed(new TroopView.MyTroopObserver.1(this), 1200L);
      return;
      label79:
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.springBackOverScrollHeaderView();
      this.a.b(2131719529);
    }
  }
  
  public void onUpdateTroopNickname(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopView.MyTroopObserver
 * JD-Core Version:    0.7.0.1
 */