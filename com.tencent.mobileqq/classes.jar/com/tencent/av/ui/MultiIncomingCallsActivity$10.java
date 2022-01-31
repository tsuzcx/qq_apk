package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class MultiIncomingCallsActivity$10
  implements Runnable
{
  MultiIncomingCallsActivity$10(MultiIncomingCallsActivity paramMultiIncomingCallsActivity, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    ArrayList localArrayList = this.this$0.a.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList);
    ThreadManager.getUIHandler().post(new MultiIncomingCallsActivity.10.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.10
 * JD-Core Version:    0.7.0.1
 */