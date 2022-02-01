package com.tencent.mobileqq.activity.main;

import android.os.Bundle;
import com.tencent.mobileqq.observer.VipGifObserver;

class MainAssistObserver$2
  extends VipGifObserver
{
  MainAssistObserver$2(MainAssistObserver paramMainAssistObserver) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBoolean == true)) {
      MainAssistObserver.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.2
 * JD-Core Version:    0.7.0.1
 */