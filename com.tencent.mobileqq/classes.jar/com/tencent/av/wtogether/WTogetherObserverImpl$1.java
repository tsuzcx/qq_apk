package com.tencent.av.wtogether;

import android.content.Context;
import com.tencent.av.tips.TipsUtil;
import com.tencent.common.app.BaseApplicationImpl;

class WTogetherObserverImpl$1
  implements Runnable
{
  WTogetherObserverImpl$1(WTogetherObserverImpl paramWTogetherObserverImpl, int paramInt) {}
  
  public void run()
  {
    String str = BaseApplicationImpl.getContext().getString(this.a);
    TipsUtil.a(this.this$0.a, str, 3000L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherObserverImpl.1
 * JD-Core Version:    0.7.0.1
 */