package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.together.TogetherUtils;
import java.util.concurrent.atomic.AtomicBoolean;

class TogetherControlHelper$3
  implements Runnable
{
  TogetherControlHelper$3(TogetherControlHelper paramTogetherControlHelper, String paramString) {}
  
  public void run()
  {
    if (TogetherControlHelper.f(this.this$0).compareAndSet(true, true)) {
      return;
    }
    if (TogetherUtils.a(TogetherUtils.a(TogetherControlHelper.a(this.this$0).d, TogetherControlHelper.a(this.this$0).ah.b, TogetherControlHelper.a(this.this$0).ah.a)))
    {
      TogetherControlHelper.g(this.this$0).removeMessages(3);
      Message localMessage = TogetherControlHelper.g(this.this$0).obtainMessage(3);
      localMessage.obj = this.a;
      TogetherControlHelper.g(this.this$0).sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper.3
 * JD-Core Version:    0.7.0.1
 */