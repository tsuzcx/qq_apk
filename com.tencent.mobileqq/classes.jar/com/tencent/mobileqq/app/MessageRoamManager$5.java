package com.tencent.mobileqq.app;

import android.util.Pair;
import java.util.Calendar;
import java.util.List;

class MessageRoamManager$5
  implements Runnable
{
  MessageRoamManager$5(MessageRoamManager paramMessageRoamManager, int paramInt) {}
  
  public void run()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = this.a;
    int j = 8;
    while (i < this.this$0.n.size())
    {
      localCalendar.setTimeInMillis(((Long)this.this$0.n.get(i)).longValue());
      this.this$0.a(localCalendar);
      Pair localPair = this.this$0.f((Calendar)localCalendar.clone());
      MessageRoamManager localMessageRoamManager = this.this$0;
      j -= localMessageRoamManager.b(localMessageRoamManager.i, ((Long)localPair.first).longValue(), ((Long)localPair.second).longValue());
      if (j <= 0) {
        break;
      }
      i += 1;
    }
    this.this$0.a(0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.5
 * JD-Core Version:    0.7.0.1
 */