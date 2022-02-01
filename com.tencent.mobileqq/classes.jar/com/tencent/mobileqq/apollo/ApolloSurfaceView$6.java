package com.tencent.mobileqq.apollo;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloSurfaceView$6
  implements Runnable
{
  ApolloSurfaceView$6(ApolloSurfaceView paramApolloSurfaceView) {}
  
  public void run()
  {
    if (this.this$0.mIsDestroy.get()) {}
    do
    {
      do
      {
        return;
      } while (this.this$0.mSurfaceCallBackData == null);
      ApolloSurfaceView.access$1101(this.this$0, this.this$0.mSurfaceCallBackData.jdField_a_of_type_AndroidViewSurfaceHolder, this.this$0.mSurfaceCallBackData.jdField_a_of_type_Int, this.this$0.mSurfaceCallBackData.b, this.this$0.mSurfaceCallBackData.c);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloSurfaceView", 2, new Object[] { "mSurfaceChangeRunnable mSurfaceCallBackData:", this.this$0.mSurfaceCallBackData });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloSurfaceView.6
 * JD-Core Version:    0.7.0.1
 */