package com.tencent.mobileqq.activity.recent.msgbox;

import android.os.Bundle;

class FilterMsgBoxFragment$1
  extends TempMsgBoxObserver
{
  FilterMsgBoxFragment$1(FilterMsgBoxFragment paramFilterMsgBoxFragment) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt != 1) {
      return;
    }
    FilterMsgBoxFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxFragment.1
 * JD-Core Version:    0.7.0.1
 */