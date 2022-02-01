package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ForwardTroopListFragment$MyTroopObserver
  extends TroopObserver
{
  protected ForwardTroopListFragment$MyTroopObserver(ForwardTroopListFragment paramForwardTroopListFragment) {}
  
  public void onGetMutilTroopInfoResult(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
  
  public void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
  
  public void onUpdateTroopList(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "onUpdateTroopList " + paramBoolean);
    }
    if (paramBoolean) {
      ThreadManager.getUIHandler().postDelayed(new ForwardTroopListFragment.MyTroopObserver.1(this), 500L);
    }
  }
  
  public void onUpdateTroopNickname(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListFragment.MyTroopObserver
 * JD-Core Version:    0.7.0.1
 */