package com.tencent.mobileqq.activity.qwallet.redpacket;

import Wallet.GetGroupRedPackListRsp;
import ahje;
import android.text.TextUtils;
import bbdj;
import com.qq.taf.jce.JceOutputStream;
import java.io.File;

class RedPacketManager$8
  implements Runnable
{
  RedPacketManager$8(RedPacketManager paramRedPacketManager, GetGroupRedPackListRsp paramGetGroupRedPackListRsp, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_WalletGetGroupRedPackListRsp == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    try
    {
      String str = ahje.f + this.jdField_a_of_type_JavaLangString + this.b + "_" + this.jdField_a_of_type_Int;
      Object localObject = new File(str);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localObject = new JceOutputStream();
      ((JceOutputStream)localObject).setServerEncoding("utf-8");
      this.jdField_a_of_type_WalletGetGroupRedPackListRsp.writeTo((JceOutputStream)localObject);
      bbdj.a(((JceOutputStream)localObject).toByteArray(), str);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager.8
 * JD-Core Version:    0.7.0.1
 */