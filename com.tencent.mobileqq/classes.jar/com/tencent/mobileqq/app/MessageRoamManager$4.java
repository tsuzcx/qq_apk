package com.tencent.mobileqq.app;

import akaw;
import akwb;
import android.util.Pair;
import java.util.Calendar;

public class MessageRoamManager$4
  implements Runnable
{
  public MessageRoamManager$4(akaw paramakaw, Calendar paramCalendar) {}
  
  public void run()
  {
    Pair localPair = this.this$0.a((Calendar)this.a.clone());
    int i = this.this$0.a(this.this$0.jdField_a_of_type_JavaLangString, ((Long)localPair.first).longValue(), ((Long)localPair.second).longValue());
    if (i >= 8)
    {
      this.this$0.a(0, null);
      return;
    }
    this.this$0.jdField_a_of_type_Akwb.a(this.this$0.jdField_a_of_type_JavaLangString, (Calendar)this.a.clone(), true, 8 - i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.4
 * JD-Core Version:    0.7.0.1
 */