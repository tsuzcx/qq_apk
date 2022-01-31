package com.tencent.mobileqq.activity.qwallet;

import Wallet.PfaFriendRsp;
import aisa;
import ajaf;
import ajal;
import bdcs;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;

public final class TopayManager$2
  implements Runnable
{
  public void run()
  {
    if (aisa.a == null) {
      return;
    }
    Object localObject1 = "";
    Object localObject2 = ajaf.a();
    if (localObject2 != null) {}
    try
    {
      localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
      localObject2 = ajal.e + (String)localObject1;
      localObject1 = localObject2;
      if (aisa.b == 1)
      {
        localObject1 = localObject2;
        if (aisa.c > 0)
        {
          localObject1 = localObject2;
          if (aisa.c < 3) {
            localObject1 = (String)localObject2 + "_" + aisa.b + "_" + aisa.c;
          }
        }
      }
      localObject2 = new File((String)localObject1);
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      localObject2 = new JceOutputStream();
      ((JceOutputStream)localObject2).setServerEncoding("utf-8");
      aisa.a.writeTo((JceOutputStream)localObject2);
      bdcs.a(((JceOutputStream)localObject2).toByteArray(), (String)localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TopayManager.2
 * JD-Core Version:    0.7.0.1
 */