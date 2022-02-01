package com.tencent.mobileqq.activity.aio.core;

import amsw;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import mqq.os.MqqHandler;

class BaseChatPie$79
  implements Runnable
{
  BaseChatPie$79(BaseChatPie paramBaseChatPie, amsw paramamsw) {}
  
  public void run()
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo = this.val$fm.a(this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curType, true);
    if ((localNoC2CExtensionInfo != null) && (localNoC2CExtensionInfo.audioPanelType != -1) && (this.this$0.mAudioPanel != null)) {
      this.this$0.uiHandler.obtainMessage(40, localNoC2CExtensionInfo.audioPanelType, this.this$0.sessionInfo.curType).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.79
 * JD-Core Version:    0.7.0.1
 */