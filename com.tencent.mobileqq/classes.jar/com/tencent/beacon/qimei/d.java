package com.tencent.beacon.qimei;

import java.util.List;

class d
  implements Runnable
{
  d(QimeiSDK paramQimeiSDK, IAsyncQimeiListener paramIAsyncQimeiListener) {}
  
  public void run()
  {
    synchronized (QimeiSDK.access$000(this.b))
    {
      Qimei localQimei = this.b.getQimei();
      if (localQimei != null)
      {
        boolean bool = localQimei.isEmpty();
        if (!bool)
        {
          try
          {
            this.a.onQimeiDispatch(localQimei);
          }
          catch (Throwable localThrowable)
          {
            this.b.logQimeiCallbackError(localThrowable);
          }
          return;
        }
      }
      QimeiSDK.access$000(this.b).add(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.qimei.d
 * JD-Core Version:    0.7.0.1
 */