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
  
  protected void onGenNewTroopName(String paramString1, String paramString2)
  {
    if (this.a.a != null) {
      this.a.a.d();
    }
  }
  
  protected void onGetMutilTroopInfoResult(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if (paramBoolean) {
      this.a.h();
    }
  }
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.h();
    }
  }
  
  protected void onUpdateTroopList(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateTroopList ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("contacts.fragment.TroopFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.d)
    {
      localObject = this.a;
      ((TroopFragment)localObject).d = false;
      if (TroopFragment.a((TroopFragment)localObject) != null) {
        TroopFragment.b(this.a).a(this.a.b(), paramBoolean, null);
      }
    }
    ThreadManager.getUIHandler().postDelayed(new TroopFragment.MyTroopObserver.1(this), 500L);
  }
  
  protected void onUpdateTroopNickname(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.TroopFragment.MyTroopObserver
 * JD-Core Version:    0.7.0.1
 */