package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyConstants;

class NearbyActivity$2
  implements Runnable
{
  NearbyActivity$2(NearbyActivity paramNearbyActivity) {}
  
  public void run()
  {
    this.this$0.a.c();
    ((NearbyHandler)this.this$0.a.getBusinessHandler(NearbyConstants.a)).b(this.this$0.a.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity.2
 * JD-Core Version:    0.7.0.1
 */