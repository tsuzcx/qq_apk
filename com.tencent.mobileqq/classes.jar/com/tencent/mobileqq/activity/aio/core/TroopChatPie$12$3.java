package com.tencent.mobileqq.activity.aio.core;

import afjq;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class TroopChatPie$12$3
  implements Runnable
{
  public TroopChatPie$12$3(afjq paramafjq, long paramLong) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Afjq.a.mActivity != null) && (this.jdField_a_of_type_Afjq.a.mActivity.isResume())) {
      ThreadManager.getSubThreadHandler().postDelayed(TroopChatPie.a(this.jdField_a_of_type_Afjq.a), this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.12.3
 * JD-Core Version:    0.7.0.1
 */