package com.tencent.mobileqq.app;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class WebPushObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, int paramInt, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt != 11) {
      return;
    }
    a(paramBoolean, paramBundle.getInt("msgType", 0), paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.WebPushObserver
 * JD-Core Version:    0.7.0.1
 */