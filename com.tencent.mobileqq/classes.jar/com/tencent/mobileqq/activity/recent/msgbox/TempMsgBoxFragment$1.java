package com.tencent.mobileqq.activity.recent.msgbox;

import android.os.Bundle;

class TempMsgBoxFragment$1
  extends TempMsgBoxObserver
{
  TempMsgBoxFragment$1(TempMsgBoxFragment paramTempMsgBoxFragment) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt != 1) {
      return;
    }
    this.a.a();
    TempMsgBoxFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxFragment.1
 * JD-Core Version:    0.7.0.1
 */