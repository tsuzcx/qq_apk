package com.tencent.beacon.module;

import com.tencent.beacon.qimei.QimeiSDK;
import com.tencent.qmsp.sdk.u.U;

class QmspModule$1
  implements Runnable
{
  QmspModule$1(QmspModule paramQmspModule) {}
  
  public void run()
  {
    if (!QmspModule.a(this.a)) {
      QmspModule.a(this.a, QimeiSDK.getInstance().getQimeiInternal());
    }
    String str2;
    try
    {
      boolean bool = U.getSDKIsAlive();
      if (bool) {
        String str1 = "Y";
      }
    }
    catch (Throwable localThrowable)
    {
      com.tencent.beacon.base.util.c.b("[qmsp] getSDKIsAlive error! exception msg", new Object[] { localThrowable.getMessage() });
      com.tencent.beacon.base.util.c.a(localThrowable);
      str2 = "N";
    }
    com.tencent.beacon.base.util.c.a("[qmsp] current qmsp is alive:%s", new Object[] { str2 });
    com.tencent.beacon.a.c.c.d().c(str2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.module.QmspModule.1
 * JD-Core Version:    0.7.0.1
 */