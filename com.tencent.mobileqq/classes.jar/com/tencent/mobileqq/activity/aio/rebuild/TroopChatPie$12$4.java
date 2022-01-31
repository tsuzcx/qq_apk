package com.tencent.mobileqq.activity.aio.rebuild;

import agvm;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class TroopChatPie$12$4
  implements Runnable
{
  public TroopChatPie$12$4(agvm paramagvm, long paramLong) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Agvm.a.a != null) && (this.jdField_a_of_type_Agvm.a.a.isResume())) {
      ThreadManager.getSubThreadHandler().postDelayed(TroopChatPie.a(this.jdField_a_of_type_Agvm.a), this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.12.4
 * JD-Core Version:    0.7.0.1
 */