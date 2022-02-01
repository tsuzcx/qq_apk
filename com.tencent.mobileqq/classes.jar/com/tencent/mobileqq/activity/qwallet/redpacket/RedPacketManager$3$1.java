package com.tencent.mobileqq.activity.qwallet.redpacket;

import Wallet.GetSkinListRsp;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;

class RedPacketManager$3$1
  implements Runnable
{
  RedPacketManager$3$1(RedPacketManager.3 param3, GetSkinListRsp paramGetSkinListRsp) {}
  
  public void run()
  {
    try
    {
      JceOutputStream localJceOutputStream = new JceOutputStream();
      localJceOutputStream.setServerEncoding("utf-8");
      this.jdField_a_of_type_WalletGetSkinListRsp.writeTo(localJceOutputStream);
      FileUtils.a(localJceOutputStream.toByteArray(), BaseApplicationImpl.getApplication().getFilesDir() + "skins" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketManager$3.a.getCurrentAccountUin());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager.3.1
 * JD-Core Version:    0.7.0.1
 */