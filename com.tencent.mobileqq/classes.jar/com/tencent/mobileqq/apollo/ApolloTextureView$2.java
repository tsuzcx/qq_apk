package com.tencent.mobileqq.apollo;

import com.tencent.qphone.base.util.QLog;

class ApolloTextureView$2
  implements Runnable
{
  ApolloTextureView$2(ApolloTextureView paramApolloTextureView, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt1, int[] paramArrayOfInt2) {}
  
  public void run()
  {
    try
    {
      ApolloSurfaceView.nativeTouchInput(this.this$0.getRender().getSavaWrapper().a, this.jdField_a_of_type_ArrayOfFloat, this.jdField_b_of_type_ArrayOfFloat, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloTextureView", 1, "send touch event err e=" + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloTextureView.2
 * JD-Core Version:    0.7.0.1
 */