package com.tencent.av.ui;

class GAudioMembersCtrlActivity$RefreshUIRunnable
  implements Runnable
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean;
  int b;
  
  public GAudioMembersCtrlActivity$RefreshUIRunnable(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b = paramInt2;
  }
  
  public void run()
  {
    this.this$0.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMembersCtrlActivity.RefreshUIRunnable
 * JD-Core Version:    0.7.0.1
 */