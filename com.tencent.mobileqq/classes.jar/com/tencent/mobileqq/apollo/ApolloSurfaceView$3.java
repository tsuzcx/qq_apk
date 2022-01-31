package com.tencent.mobileqq.apollo;

import com.tencent.qphone.base.util.QLog;

class ApolloSurfaceView$3
  extends IApolloRunnableTask
{
  ApolloSurfaceView$3(ApolloSurfaceView paramApolloSurfaceView, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt1, int[] paramArrayOfInt2) {}
  
  public String a()
  {
    return "sendMoveTouchToNative_nativeTouchInput";
  }
  
  public void run()
  {
    try
    {
      ApolloSurfaceView.nativeTouchInput(this.this$0.getRender().getSavaWrapper().a, this.jdField_a_of_type_ArrayOfFloat, this.jdField_b_of_type_ArrayOfFloat, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloSurfaceView", 1, "send touch event err e=" + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloSurfaceView.3
 * JD-Core Version:    0.7.0.1
 */