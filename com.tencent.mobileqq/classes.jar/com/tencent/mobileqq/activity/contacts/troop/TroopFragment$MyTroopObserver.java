package com.tencent.mobileqq.activity.contacts.troop;

import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.RefreshDataListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class TroopFragment$MyTroopObserver
  extends TroopObserver
{
  protected TroopFragment$MyTroopObserver(TroopFragment paramTroopFragment) {}
  
  public void onGetMutilTroopInfoResult(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if (paramBoolean) {
      this.a.h();
    }
  }
  
  public void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.h();
    }
  }
  
  public void onUpdateTroopList(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "onUpdateTroopList " + paramBoolean);
    }
    if (this.a.d)
    {
      this.a.d = false;
      if (TroopFragment.a(this.a) != null) {
        TroopFragment.b(this.a).a(this.a.b(), paramBoolean, null);
      }
    }
    ThreadManager.getUIHandler().postDelayed(new TroopFragment.MyTroopObserver.1(this), 500L);
  }
  
  public void onUpdateTroopNickname(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.TroopFragment.MyTroopObserver
 * JD-Core Version:    0.7.0.1
 */