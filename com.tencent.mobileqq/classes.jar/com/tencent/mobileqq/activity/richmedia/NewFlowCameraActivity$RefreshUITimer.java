package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;

class NewFlowCameraActivity$RefreshUITimer
  implements Runnable
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  
  NewFlowCameraActivity$RefreshUITimer(NewFlowCameraActivity paramNewFlowCameraActivity, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramNewFlowCameraActivity.a.jdField_a_of_type_Int;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.this$0.F();
      this.this$0.G();
      this.this$0.H();
      this.this$0.I();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.RefreshUITimer
 * JD-Core Version:    0.7.0.1
 */