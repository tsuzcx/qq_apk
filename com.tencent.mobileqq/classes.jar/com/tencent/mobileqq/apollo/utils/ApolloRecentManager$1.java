package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;

class ApolloRecentManager$1
  implements Runnable
{
  public void run()
  {
    if (ApolloRecentManager.a(this.this$0) == null) {
      return;
    }
    if (this.a == null)
    {
      ApolloDaoManagerServiceImpl.insertRecentData(ApolloRecentManager.a(this.this$0), this.b);
      return;
    }
    ApolloDaoManagerServiceImpl.insertAndDeleteData(ApolloRecentManager.a(this.this$0), this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloRecentManager.1
 * JD-Core Version:    0.7.0.1
 */