package com.tencent.mobileqq.activity.qwallet.voice;

import Wallet.VoiceRedPackMatchRsp;
import agkn;
import agwj;
import agwx;
import agwz;
import agxa;
import agxf;
import agxg;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class VoiceRedPacketHelper$3$1$1
  implements Runnable
{
  public VoiceRedPacketHelper$3$1$1(agxa paramagxa, boolean paramBoolean, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Agxa.jdField_a_of_type_Long;
    agxf localagxf = (agxf)this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_Agwx.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localagxf != null) {}
    for (int i = localagxf.hashCode();; i = 0)
    {
      QQAppInterface localQQAppInterface = agwj.a();
      if (!this.jdField_a_of_type_Boolean) {
        agwx.a(this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_Agwx, 3, l, 1, this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      }
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidOsBundle == null) || (this.jdField_a_of_type_Int != 13) || (localQQAppInterface == null) || (this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (localagxf == null) || (localagxf.c()) || (this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_Agwx.b) || (i != this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_Agwx.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_Agwx.c("onReceive VoiceRedPackMatchRsp erorr");
        return;
      }
      Object localObject1 = (VoiceRedPackMatchRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
      if (QLog.isColorLevel()) {
        QLog.d("VoiceRedPacketHelper", 2, "VoiceRedPackMatchRsp onReceive:" + localObject1);
      }
      if ((localObject1 != null) && (((VoiceRedPackMatchRsp)localObject1).grabUin == localQQAppInterface.getLongAccountUin()) && (((VoiceRedPackMatchRsp)localObject1).billno != null) && (((VoiceRedPackMatchRsp)localObject1).billno.equals(this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceRedPacketHelper", 2, "VoiceRedPackMatchRsp status:" + ((VoiceRedPackMatchRsp)localObject1).status);
        }
        Object localObject2 = this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_Agwx;
        ((agwx)localObject2).jdField_c_of_type_Int += 1;
        agwx.a(this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_Agwx, ((VoiceRedPackMatchRsp)localObject1).status, l, 1, this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
        switch (((VoiceRedPackMatchRsp)localObject1).status)
        {
        }
        for (;;)
        {
          this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_Agwx.jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
          return;
          localagxf.a(false, "");
          continue;
          agwx.a(((VoiceRedPackMatchRsp)localObject1).degree, this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_Axox);
          agwx.b(((VoiceRedPackMatchRsp)localObject1).degree, this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
          localagxf.a(true, ((VoiceRedPackMatchRsp)localObject1).degree);
          localQQAppInterface.a().a(this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_Ajmm);
          continue;
          localObject2 = ((VoiceRedPackMatchRsp)localObject1).strErr;
          l = NetConnInfoCenter.getServerTime();
          agkn.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone", l + ((VoiceRedPackMatchRsp)localObject1).timeInterval);
          agkn.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone_tips", (String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "server is busy interval is " + ((VoiceRedPackMatchRsp)localObject1).timeInterval + ",tips is " + (String)localObject2);
          }
          if (this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_Agwx.jdField_c_of_type_Boolean)
          {
            localObject1 = agwx.a(this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_Agwx, this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_Agwx.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
            if (((agxg)localObject1).jdField_a_of_type_Boolean)
            {
              agwx.a(((agxg)localObject1).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_Axox);
              localQQAppInterface.a().a(this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_Ajmm);
            }
            localagxf.a(((agxg)localObject1).jdField_a_of_type_Boolean, ((agxg)localObject1).jdField_a_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.d("VoiceRedPacketHelper", 2, "check in phone, result is " + localObject1);
            }
          }
          else
          {
            agwx.a(this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_Agwx, (String)localObject2);
          }
        }
      }
      this.jdField_a_of_type_Agxa.jdField_a_of_type_Agwz.jdField_a_of_type_Agwx.c("rsp is null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.3.1.1
 * JD-Core Version:    0.7.0.1
 */