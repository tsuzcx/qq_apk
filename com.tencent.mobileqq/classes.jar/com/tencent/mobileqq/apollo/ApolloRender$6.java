package com.tencent.mobileqq.apollo;

import aiil;
import com.tencent.qphone.base.util.QLog;

class ApolloRender$6
  implements Runnable
{
  ApolloRender$6(ApolloRender paramApolloRender, aiil paramaiil, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aiil != null)
    {
      QLog.d("sava_ApolloRender", 2, "cb.onSurfaceReady");
      this.jdField_a_of_type_Aiil.onSurfaceReady(this.jdField_a_of_type_Int, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.6
 * JD-Core Version:    0.7.0.1
 */