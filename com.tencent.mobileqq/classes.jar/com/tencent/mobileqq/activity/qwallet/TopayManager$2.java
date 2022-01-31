package com.tencent.mobileqq.activity.qwallet;

import Wallet.PfaFriendRsp;
import agln;
import agwj;
import android.content.Context;
import bace;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public final class TopayManager$2
  implements Runnable
{
  public void run()
  {
    if (agln.a == null) {
      return;
    }
    Object localObject1 = "";
    Object localObject2 = agwj.a();
    if (localObject2 != null) {}
    try
    {
      localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
      localObject2 = BaseApplicationImpl.getContext().getApplicationContext().getFilesDir() + "/QWallet/.tmp/topay_recommends" + (String)localObject1;
      localObject1 = localObject2;
      if (agln.b == 1)
      {
        localObject1 = localObject2;
        if (agln.c > 0)
        {
          localObject1 = localObject2;
          if (agln.c < 3) {
            localObject1 = (String)localObject2 + "_" + agln.b + "_" + agln.c;
          }
        }
      }
      localObject2 = new File((String)localObject1);
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      localObject2 = new JceOutputStream();
      ((JceOutputStream)localObject2).setServerEncoding("utf-8");
      agln.a.writeTo((JceOutputStream)localObject2);
      bace.a(((JceOutputStream)localObject2).toByteArray(), (String)localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TopayManager.2
 * JD-Core Version:    0.7.0.1
 */