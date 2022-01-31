package com.tencent.mobileqq.activity.qwallet;

import Wallet.PfaFriendRsp;
import aiwp;
import ajeu;
import ajfa;
import bdhb;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;

public final class TopayManager$2
  implements Runnable
{
  public void run()
  {
    if (aiwp.a == null) {
      return;
    }
    Object localObject1 = "";
    Object localObject2 = ajeu.a();
    if (localObject2 != null) {}
    try
    {
      localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
      localObject2 = ajfa.e + (String)localObject1;
      localObject1 = localObject2;
      if (aiwp.b == 1)
      {
        localObject1 = localObject2;
        if (aiwp.c > 0)
        {
          localObject1 = localObject2;
          if (aiwp.c < 3) {
            localObject1 = (String)localObject2 + "_" + aiwp.b + "_" + aiwp.c;
          }
        }
      }
      localObject2 = new File((String)localObject1);
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      localObject2 = new JceOutputStream();
      ((JceOutputStream)localObject2).setServerEncoding("utf-8");
      aiwp.a.writeTo((JceOutputStream)localObject2);
      bdhb.a(((JceOutputStream)localObject2).toByteArray(), (String)localObject1);
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