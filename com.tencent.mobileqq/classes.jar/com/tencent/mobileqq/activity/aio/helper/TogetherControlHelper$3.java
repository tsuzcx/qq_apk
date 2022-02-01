package com.tencent.mobileqq.activity.aio.helper;

import afsw;
import android.os.Handler;
import android.os.Message;
import bddg;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import java.util.concurrent.atomic.AtomicBoolean;

public class TogetherControlHelper$3
  implements Runnable
{
  public TogetherControlHelper$3(afsw paramafsw, String paramString) {}
  
  public void run()
  {
    if (afsw.a(this.this$0).compareAndSet(true, true)) {}
    while (!bddg.a(bddg.a(afsw.a(this.this$0).app, afsw.a(this.this$0).sessionInfo.curFriendUin, afsw.a(this.this$0).sessionInfo.curType))) {
      return;
    }
    afsw.a(this.this$0).removeMessages(3);
    Message localMessage = afsw.a(this.this$0).obtainMessage(3);
    localMessage.obj = this.a;
    afsw.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper.3
 * JD-Core Version:    0.7.0.1
 */