package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.nearby.NearbyConstants;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;

class NearbyActivity$2
  implements Runnable
{
  NearbyActivity$2(NearbyActivity paramNearbyActivity) {}
  
  public void run()
  {
    this.this$0.app.setTalkbackSwitch();
    ((NearbyHandler)this.this$0.app.getBusinessHandler(NearbyConstants.a)).b(this.this$0.app.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity.2
 * JD-Core Version:    0.7.0.1
 */