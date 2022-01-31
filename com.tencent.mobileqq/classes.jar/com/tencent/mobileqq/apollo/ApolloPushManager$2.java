package com.tencent.mobileqq.apollo;

import aisr;
import aist;
import com.tencent.mobileqq.data.ApolloActionPush;
import mqq.util.WeakReference;

public class ApolloPushManager$2
  implements Runnable
{
  public ApolloPushManager$2(aisr paramaisr, int paramInt, ApolloActionPush paramApolloActionPush) {}
  
  public void run()
  {
    if (aisr.a(this.this$0) != null)
    {
      aist localaist = (aist)aisr.a(this.this$0).get();
      if (localaist != null) {
        localaist.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataApolloActionPush);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPushManager.2
 * JD-Core Version:    0.7.0.1
 */