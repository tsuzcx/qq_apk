package com.tencent.mobileqq.app;

import android.util.Pair;
import com.tencent.mobileqq.app.utils.MessageRoamHandler;
import java.util.Calendar;

class MessageRoamManager$4
  implements Runnable
{
  MessageRoamManager$4(MessageRoamManager paramMessageRoamManager, Calendar paramCalendar) {}
  
  public void run()
  {
    Pair localPair = this.this$0.f((Calendar)this.a.clone());
    MessageRoamManager localMessageRoamManager = this.this$0;
    int i = localMessageRoamManager.b(localMessageRoamManager.i, ((Long)localPair.first).longValue(), ((Long)localPair.second).longValue());
    if (i >= 8)
    {
      this.this$0.a(0, null);
      return;
    }
    this.this$0.c.a(this.this$0.i, (Calendar)this.a.clone(), true, 8 - i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.4
 * JD-Core Version:    0.7.0.1
 */