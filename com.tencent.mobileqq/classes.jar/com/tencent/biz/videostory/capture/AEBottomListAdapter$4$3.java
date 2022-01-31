package com.tencent.biz.videostory.capture;

import bgya;
import java.util.Map;
import wql;
import wqn;
import wqp;

public class AEBottomListAdapter$4$3
  implements Runnable
{
  public AEBottomListAdapter$4$3(wqn paramwqn, bgya parambgya, int paramInt) {}
  
  public void run()
  {
    if (wql.a(this.jdField_a_of_type_Wqn.a).get(this.jdField_a_of_type_Bgya.a) != null)
    {
      if ((this.jdField_a_of_type_Int < 100) && (!this.jdField_a_of_type_Bgya.d) && (this.jdField_a_of_type_Bgya.e)) {
        ((wqp)wql.a(this.jdField_a_of_type_Wqn.a).get(this.jdField_a_of_type_Bgya.a)).a(1);
      }
    }
    else {
      return;
    }
    ((wqp)wql.a(this.jdField_a_of_type_Wqn.a).get(this.jdField_a_of_type_Bgya.a)).a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.AEBottomListAdapter.4.3
 * JD-Core Version:    0.7.0.1
 */