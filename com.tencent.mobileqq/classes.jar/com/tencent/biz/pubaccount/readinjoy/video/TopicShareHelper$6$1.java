package com.tencent.biz.pubaccount.readinjoy.video;

import bjbs;
import rmj;

class TopicShareHelper$6$1
  implements Runnable
{
  TopicShareHelper$6$1(TopicShareHelper.6 param6) {}
  
  public void run()
  {
    if ((rmj.a(this.a.this$0) != null) && (rmj.a(this.a.this$0).isShowing())) {
      rmj.a(this.a.this$0).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.TopicShareHelper.6.1
 * JD-Core Version:    0.7.0.1
 */