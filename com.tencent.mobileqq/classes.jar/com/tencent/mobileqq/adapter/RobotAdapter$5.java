package com.tencent.mobileqq.adapter;

import amjc;
import java.util.ArrayList;

public class RobotAdapter$5
  implements Runnable
{
  public RobotAdapter$5(amjc paramamjc, String paramString, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    amjc.a(this.this$0).contains(this.jdField_a_of_type_JavaLangString);
    amjc.a(this.this$0).remove(this.jdField_a_of_type_JavaLangString);
    this.this$0.notifyDataSetChanged();
    if (!this.jdField_a_of_type_Boolean) {
      this.this$0.a(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.RobotAdapter.5
 * JD-Core Version:    0.7.0.1
 */