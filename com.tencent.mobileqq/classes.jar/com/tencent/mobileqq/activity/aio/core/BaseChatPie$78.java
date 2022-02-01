package com.tencent.mobileqq.activity.aio.core;

import amsw;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import mqq.os.MqqHandler;

class BaseChatPie$78
  implements Runnable
{
  BaseChatPie$78(BaseChatPie paramBaseChatPie, amsw paramamsw) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = this.val$fm.a(this.this$0.sessionInfo.curFriendUin, true);
    if ((localExtensionInfo != null) && (localExtensionInfo.audioPanelType != -1) && (this.this$0.mAudioPanel != null)) {
      this.this$0.uiHandler.obtainMessage(40, localExtensionInfo.audioPanelType, this.this$0.sessionInfo.curType).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.78
 * JD-Core Version:    0.7.0.1
 */