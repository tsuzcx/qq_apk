package com.tencent.mobileqq.activity.selectmember;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class TroopDiscussionTroop$MyTroopObserver
  extends TroopObserver
{
  protected TroopDiscussionTroop$MyTroopObserver(TroopDiscussionTroop paramTroopDiscussionTroop) {}
  
  public void onGetMutilTroopInfoResult(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if (paramBoolean) {
      this.a.c();
    }
  }
  
  public void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.c();
    }
  }
  
  public void onUpdateTroopList(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopDiscussionTroop", 2, "onUpdateTroopList " + paramBoolean);
    }
    if (paramBoolean) {
      ThreadManager.getUIHandler().postDelayed(new TroopDiscussionTroop.MyTroopObserver.1(this), 500L);
    }
  }
  
  public void onUpdateTroopNickname(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopDiscussionTroop.MyTroopObserver
 * JD-Core Version:    0.7.0.1
 */