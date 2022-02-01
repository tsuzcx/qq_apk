package com.tencent.mobileqq.apollo;

import amhy;
import amia;
import com.tencent.mobileqq.data.ApolloActionPush;
import mqq.util.WeakReference;

public class ApolloPushManager$2
  implements Runnable
{
  public ApolloPushManager$2(amhy paramamhy, int paramInt, ApolloActionPush paramApolloActionPush) {}
  
  public void run()
  {
    if (amhy.a(this.this$0) != null)
    {
      amia localamia = (amia)amhy.a(this.this$0).get();
      if (localamia != null) {
        localamia.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataApolloActionPush);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPushManager.2
 * JD-Core Version:    0.7.0.1
 */