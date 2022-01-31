package com.tencent.mobileqq.apollo.utils;

import ajmu;
import ajol;

public class ApolloRecentManager$1
  implements Runnable
{
  public void run()
  {
    if (this.this$0.a == null) {
      return;
    }
    if (this.a == null)
    {
      ajmu.a(this.this$0.a, this.b);
      return;
    }
    ajmu.a(this.this$0.a, this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloRecentManager.1
 * JD-Core Version:    0.7.0.1
 */