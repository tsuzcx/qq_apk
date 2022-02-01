package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;

class ReadinjoyTabFrame$13
  implements Runnable
{
  ReadinjoyTabFrame$13(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void run()
  {
    if (ReadinjoyTabFrame.b(this.this$0) != null)
    {
      ReadinjoyTabFrame.b(this.this$0).setAnimation(AnimationUtils.loadAnimation(this.this$0.a(), 2130772340));
      ReadinjoyTabFrame.b(this.this$0).setVisibility(8);
      SharedPreUtils.A(this.this$0.a(), this.this$0.a().getCurrentAccountUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.13
 * JD-Core Version:    0.7.0.1
 */