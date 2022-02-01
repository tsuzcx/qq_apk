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
    int j = this.a;
    int i = 8;
    while (j < this.this$0.jdField_a_of_type_JavaUtilList.size())
    {
      localCalendar.setTimeInMillis(((Long)this.this$0.jdField_a_of_type_JavaUtilList.get(j)).longValue());
      this.this$0.a(localCalendar);
      Pair localPair = this.this$0.a((Calendar)localCalendar.clone());
      int k = this.this$0.a(this.this$0.jdField_a_of_type_JavaLangString, ((Long)localPair.first).longValue(), ((Long)localPair.second).longValue());
      if (i - k <= 0) {
        break;
      }
      j += 1;
      i -= k;
    }
    this.this$0.a(0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.5
 * JD-Core Version:    0.7.0.1
 */