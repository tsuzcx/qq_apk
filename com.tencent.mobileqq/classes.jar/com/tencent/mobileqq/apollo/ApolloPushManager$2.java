package com.tencent.mobileqq.apollo;

import akos;
import akou;
import com.tencent.mobileqq.data.ApolloActionPush;
import mqq.util.WeakReference;

public class ApolloPushManager$2
  implements Runnable
{
  public ApolloPushManager$2(akos paramakos, int paramInt, ApolloActionPush paramApolloActionPush) {}
  
  public void run()
  {
    if (akos.a(this.this$0) != null)
    {
      akou localakou = (akou)akos.a(this.this$0).get();
      if (localakou != null) {
        localakou.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataApolloActionPush);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPushManager.2
 * JD-Core Version:    0.7.0.1
 */