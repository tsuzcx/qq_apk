package com.tencent.mobileqq.activity.aio;

import aixs;
import ajeu;
import com.tencent.mobileqq.app.QQAppInterface;

class CustomizeStrategyFactory$2
  implements Runnable
{
  CustomizeStrategyFactory$2(CustomizeStrategyFactory paramCustomizeStrategyFactory) {}
  
  public void run()
  {
    synchronized (CustomizeStrategyFactory.a(this.this$0))
    {
      if (!CustomizeStrategyFactory.a(this.this$0))
      {
        QQAppInterface localQQAppInterface = ajeu.a();
        if (localQQAppInterface != null) {
          this.this$0.a = ((aixs)localQQAppInterface.getManager(245));
        }
        if (this.this$0.a != null) {
          this.this$0.a.c("redPack", this.this$0);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.2
 * JD-Core Version:    0.7.0.1
 */