package com.tencent.mobileqq.activity;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class QZoneFeedsObserver
  implements BusinessObserver
{
  protected void a() {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 10000) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QZoneFeedsObserver
 * JD-Core Version:    0.7.0.1
 */