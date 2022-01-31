package com.tencent.mobileqq.activity;

import alkv;
import android.os.Handler;
import android.os.Message;
import awsp;
import java.util.ArrayList;

class VisitorsActivity$9
  implements Runnable
{
  VisitorsActivity$9(VisitorsActivity paramVisitorsActivity) {}
  
  public void run()
  {
    ArrayList localArrayList1 = this.this$0.jdField_a_of_type_Alkv.a(2, 7);
    ArrayList localArrayList2 = this.this$0.jdField_a_of_type_Alkv.a(3, 7);
    if (!this.this$0.isFinishing())
    {
      this.this$0.jdField_a_of_type_Awsp.a();
      this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(5, 0, 0, new Object[] { localArrayList1, localArrayList2 }).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.9
 * JD-Core Version:    0.7.0.1
 */