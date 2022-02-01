package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.apollo.api.listener.OnApolloViewListener;
import com.tencent.qphone.base.util.QLog;

class ApolloRender$5
  implements Runnable
{
  ApolloRender$5(ApolloRender paramApolloRender, OnApolloViewListener paramOnApolloViewListener, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiListenerOnApolloViewListener != null)
    {
      QLog.d("sava_ApolloRender", 2, "cb.onSurfaceReady");
      this.jdField_a_of_type_ComTencentMobileqqApolloApiListenerOnApolloViewListener.onSurfaceReady(this.jdField_a_of_type_Int, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.5
 * JD-Core Version:    0.7.0.1
 */