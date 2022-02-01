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
    Pair localPair = this.this$0.a((Calendar)this.a.clone());
    int i = this.this$0.a(this.this$0.jdField_a_of_type_JavaLangString, ((Long)localPair.first).longValue(), ((Long)localPair.second).longValue());
    if (i >= 8)
    {
      this.this$0.a(0, null);
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a(this.this$0.jdField_a_of_type_JavaLangString, (Calendar)this.a.clone(), true, 8 - i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.4
 * JD-Core Version:    0.7.0.1
 */