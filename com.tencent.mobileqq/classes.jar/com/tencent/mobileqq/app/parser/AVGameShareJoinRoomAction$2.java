package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import aost;
import com.tencent.qphone.base.util.QLog;
import ncz;

public class AVGameShareJoinRoomAction$2
  implements Runnable
{
  public AVGameShareJoinRoomAction$2(aost paramaost, ncz paramncz, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((this.this$0.a instanceof Activity))
    {
      this.jdField_a_of_type_Ncz.a((Activity)this.this$0.a, 1, this.jdField_a_of_type_JavaLangString, this.b);
      return;
    }
    QLog.e("AVGameShareJoinRoomAction", 2, "directJoinRoom context not instance of activity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.AVGameShareJoinRoomAction.2
 * JD-Core Version:    0.7.0.1
 */