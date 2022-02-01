package com.tencent.beacon.qimei;

import java.util.Map;

class f
  implements Runnable
{
  f(QimeiSDK paramQimeiSDK, IAsyncQimeiListener paramIAsyncQimeiListener) {}
  
  public void run()
  {
    if (QimeiSDK.access$000(this.b) != null)
    {
      Qimei localQimei = a.a(QimeiSDK.access$000(this.b)).b();
      if ((localQimei.getQimeiMap() != null) && (!localQimei.getQimeiMap().isEmpty()))
      {
        this.a.onQimeiDispatch(localQimei);
        return;
      }
    }
    if (!QimeiSDK.access$100(this.b))
    {
      QimeiSDK.access$202(this.b, this.a);
      return;
    }
    e.a(QimeiSDK.access$000(this.b)).a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.qimei.f
 * JD-Core Version:    0.7.0.1
 */