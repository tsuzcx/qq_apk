package com.tencent.av.wtogether;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import mbf;
import mxh;

public class WTogetherObserverImpl$1
  implements Runnable
{
  public WTogetherObserverImpl$1(mxh parammxh, int paramInt) {}
  
  public void run()
  {
    String str = BaseApplicationImpl.getContext().getString(this.a);
    mbf.a(this.this$0.a, str, 3000L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherObserverImpl.1
 * JD-Core Version:    0.7.0.1
 */