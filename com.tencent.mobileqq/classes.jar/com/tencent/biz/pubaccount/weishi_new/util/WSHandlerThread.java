package com.tencent.biz.pubaccount.weishi_new.util;

import android.os.Build.VERSION;
import android.os.HandlerThread;

public class WSHandlerThread
{
  private HandlerThread a;
  
  public HandlerThread a()
  {
    if (this.a == null) {
      this.a = new HandlerThread("WeishiHandlerThread");
    }
    return this.a;
  }
  
  public void b()
  {
    if (this.a != null)
    {
      if (Build.VERSION.SDK_INT >= 18) {
        this.a.quitSafely();
      } else {
        this.a.quit();
      }
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSHandlerThread
 * JD-Core Version:    0.7.0.1
 */