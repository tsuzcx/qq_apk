package com.tencent.mobileqq.activity.recent.msgbox;

import android.os.Bundle;
import com.tencent.imcore.message.ConversationProxyObserver;

class TempMsgBoxFragment$2
  extends ConversationProxyObserver
{
  TempMsgBoxFragment$2(TempMsgBoxFragment paramTempMsgBoxFragment) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt != 0) {
      return;
    }
    TempMsgBoxFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxFragment.2
 * JD-Core Version:    0.7.0.1
 */