package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.View;
import android.view.animation.AnimationUtils;
import baig;
import com.tencent.mobileqq.app.QQAppInterface;

class ReadinjoyTabFrame$15
  implements Runnable
{
  ReadinjoyTabFrame$15(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void run()
  {
    if (ReadinjoyTabFrame.b(this.this$0) != null)
    {
      ReadinjoyTabFrame.b(this.this$0).setAnimation(AnimationUtils.loadAnimation(this.this$0.a(), 2130772301));
      ReadinjoyTabFrame.b(this.this$0).setVisibility(8);
      baig.A(this.this$0.a(), this.this$0.a.getCurrentAccountUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.15
 * JD-Core Version:    0.7.0.1
 */