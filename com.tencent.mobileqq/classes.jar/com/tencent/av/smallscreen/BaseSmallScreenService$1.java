package com.tencent.av.smallscreen;

import android.telephony.PhoneStateListener;

class BaseSmallScreenService$1
  extends PhoneStateListener
{
  BaseSmallScreenService$1(BaseSmallScreenService paramBaseSmallScreenService) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    super.onCallStateChanged(paramInt, paramString);
    this.a.a(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.BaseSmallScreenService.1
 * JD-Core Version:    0.7.0.1
 */