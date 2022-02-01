package com.tencent.mobileqq.activity.main;

import android.os.Bundle;
import com.tencent.mobileqq.observer.VipGifObserver;

class MainAssistObserver$1
  extends VipGifObserver
{
  MainAssistObserver$1(MainAssistObserver paramMainAssistObserver) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBoolean == true)) {
      MainAssistObserver.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.1
 * JD-Core Version:    0.7.0.1
 */