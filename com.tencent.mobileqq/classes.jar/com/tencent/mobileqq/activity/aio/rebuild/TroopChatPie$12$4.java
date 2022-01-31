package com.tencent.mobileqq.activity.aio.rebuild;

import aetz;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class TroopChatPie$12$4
  implements Runnable
{
  public TroopChatPie$12$4(aetz paramaetz, long paramLong) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Aetz.a.a != null) && (this.jdField_a_of_type_Aetz.a.a.isResume())) {
      ThreadManager.getSubThreadHandler().postDelayed(TroopChatPie.a(this.jdField_a_of_type_Aetz.a), this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.12.4
 * JD-Core Version:    0.7.0.1
 */