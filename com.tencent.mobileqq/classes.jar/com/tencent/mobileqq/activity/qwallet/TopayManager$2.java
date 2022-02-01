package com.tencent.mobileqq.activity.qwallet;

import Wallet.PfaFriendRsp;
import aksv;
import albw;
import alcc;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

public final class TopayManager$2
  implements Runnable
{
  public void run()
  {
    if (aksv.a == null) {
      return;
    }
    Object localObject1 = "";
    Object localObject2 = albw.a();
    if (localObject2 != null) {}
    try
    {
      localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
      localObject2 = alcc.e + (String)localObject1;
      localObject1 = localObject2;
      if (aksv.b == 1)
      {
        localObject1 = localObject2;
        if (aksv.c > 0)
        {
          localObject1 = localObject2;
          if (aksv.c < 3) {
            localObject1 = (String)localObject2 + "_" + aksv.b + "_" + aksv.c;
          }
        }
      }
      localObject2 = new File((String)localObject1);
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      localObject2 = new JceOutputStream();
      ((JceOutputStream)localObject2).setServerEncoding("utf-8");
      aksv.a.writeTo((JceOutputStream)localObject2);
      FileUtils.writeFile(((JceOutputStream)localObject2).toByteArray(), (String)localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TopayManager.2
 * JD-Core Version:    0.7.0.1
 */