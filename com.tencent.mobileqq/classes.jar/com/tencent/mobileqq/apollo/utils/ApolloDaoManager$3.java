package com.tencent.mobileqq.apollo.utils;

import aliw;
import com.tencent.mobileqq.data.ApolloActionData;

public class ApolloDaoManager$3
  implements Runnable
{
  public ApolloDaoManager$3(aliw paramaliw, int paramInt) {}
  
  public void run()
  {
    ApolloActionData localApolloActionData = this.this$0.a(this.a);
    if (localApolloActionData != null)
    {
      localApolloActionData.limitFree = 0;
      this.this$0.b(localApolloActionData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloDaoManager.3
 * JD-Core Version:    0.7.0.1
 */