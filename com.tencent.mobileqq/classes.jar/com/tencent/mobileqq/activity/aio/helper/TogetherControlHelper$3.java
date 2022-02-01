package com.tencent.mobileqq.activity.aio.helper;

import agkk;
import android.os.Handler;
import android.os.Message;
import beki;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import java.util.concurrent.atomic.AtomicBoolean;

public class TogetherControlHelper$3
  implements Runnable
{
  public TogetherControlHelper$3(agkk paramagkk, String paramString) {}
  
  public void run()
  {
    if (agkk.a(this.this$0).compareAndSet(true, true)) {}
    while (!beki.a(beki.a(agkk.a(this.this$0).app, agkk.a(this.this$0).sessionInfo.curFriendUin, agkk.a(this.this$0).sessionInfo.curType))) {
      return;
    }
    agkk.a(this.this$0).removeMessages(3);
    Message localMessage = agkk.a(this.this$0).obtainMessage(3);
    localMessage.obj = this.a;
    agkk.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper.3
 * JD-Core Version:    0.7.0.1
 */