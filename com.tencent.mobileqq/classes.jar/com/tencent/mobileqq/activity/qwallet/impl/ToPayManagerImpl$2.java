package com.tencent.mobileqq.activity.qwallet.impl;

import Wallet.PfaFriendRsp;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qwallet.utils.QWalletValues;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

final class ToPayManagerImpl$2
  implements Runnable
{
  public void run()
  {
    if (ToPayManagerImpl.mData == null) {
      return;
    }
    Object localObject1 = "";
    Object localObject2 = QWalletTools.a();
    if (localObject2 != null) {}
    try
    {
      localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
      localObject2 = QWalletValues.e + (String)localObject1;
      localObject1 = localObject2;
      if (ToPayManagerImpl.mBusinessType == 1)
      {
        localObject1 = localObject2;
        if (ToPayManagerImpl.mBusinessSubType > 0)
        {
          localObject1 = localObject2;
          if (ToPayManagerImpl.mBusinessSubType < 3) {
            localObject1 = (String)localObject2 + "_" + ToPayManagerImpl.mBusinessType + "_" + ToPayManagerImpl.mBusinessSubType;
          }
        }
      }
      localObject2 = new File((String)localObject1);
      if (((File)localObject2).exists()) {
        ((File)localObject2).delete();
      }
      localObject2 = new JceOutputStream();
      ((JceOutputStream)localObject2).setServerEncoding("utf-8");
      ToPayManagerImpl.mData.writeTo((JceOutputStream)localObject2);
      FileUtils.a(((JceOutputStream)localObject2).toByteArray(), (String)localObject1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.impl.ToPayManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */