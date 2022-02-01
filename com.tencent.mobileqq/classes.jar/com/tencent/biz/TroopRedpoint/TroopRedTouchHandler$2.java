package com.tencent.biz.TroopRedpoint;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.observer.BusinessObserver;

class TroopRedTouchHandler$2
  implements BusinessObserver
{
  TroopRedTouchHandler$2(TroopRedTouchHandler paramTroopRedTouchHandler, List paramList) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManager.post(new TroopRedTouchHandler.2.1(this, paramBoolean, paramBundle), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.TroopRedpoint.TroopRedTouchHandler.2
 * JD-Core Version:    0.7.0.1
 */