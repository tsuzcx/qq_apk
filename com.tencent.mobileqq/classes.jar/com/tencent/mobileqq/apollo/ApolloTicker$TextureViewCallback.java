package com.tencent.mobileqq.apollo;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloTicker$TextureViewCallback
  implements Runnable
{
  private final long a;
  public final ApolloTextureView a;
  private final long b;
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.mIsDestroy == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.mIsDestroy.get())) {
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
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloTicker.TextureViewCallback
 * JD-Core Version:    0.7.0.1
 */