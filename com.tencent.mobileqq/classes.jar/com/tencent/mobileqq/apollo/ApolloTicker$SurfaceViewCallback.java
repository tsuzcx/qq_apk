package com.tencent.mobileqq.apollo;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloTicker$SurfaceViewCallback
  implements Runnable
{
  private final long a;
  public final ApolloSurfaceView a;
  private final long b;
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.mIsDestroy == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.mIsDestroy.get()) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.mRenderMode != 0)) {
      return;
    }
    long l = System.currentTimeMillis();
    try
    {
      this.this$0.nativeCallbackTicker(this.b, l, 0.01666666666666667D * this.jdField_a_of_type_Long);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("sava_ApolloTicker", 1, "[onDrawFrame]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloTicker.SurfaceViewCallback
 * JD-Core Version:    0.7.0.1
 */