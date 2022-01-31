package com.tencent.mobileqq.activity.qwallet.voice;

import Wallet.VoiceRedPackMatchRsp;
import agxa;
import ahiw;
import ahjk;
import ahjm;
import ahjn;
import ahjs;
import ahjt;
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
  public VoiceRedPacketHelper$3$1$1(ahjn paramahjn, boolean paramBoolean, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Ahjn.jdField_a_of_type_Long;
    ahjs localahjs = (ahjs)this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_Ahjk.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localahjs != null) {}
    for (int i = localahjs.hashCode();; i = 0)
    {
      QQAppInterface localQQAppInterface = ahiw.a();
      if (!this.jdField_a_of_type_Boolean) {
        ahjk.a(this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_Ahjk, 3, l, 1, this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      }
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidOsBundle == null) || (this.jdField_a_of_type_Int != 13) || (localQQAppInterface == null) || (this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (localahjs == null) || (localahjs.c()) || (this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_Ahjk.b) || (i != this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_Ahjk.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_Ahjk.c("onReceive VoiceRedPackMatchRsp erorr");
        return;
      }
      Object localObject1 = (VoiceRedPackMatchRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
      if (QLog.isColorLevel()) {
        QLog.d("VoiceRedPacketHelper", 2, "VoiceRedPackMatchRsp onReceive:" + localObject1);
      }
      if ((localObject1 != null) && (((VoiceRedPackMatchRsp)localObject1).grabUin == localQQAppInterface.getLongAccountUin()) && (((VoiceRedPackMatchRsp)localObject1).billno != null) && (((VoiceRedPackMatchRsp)localObject1).billno.equals(this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceRedPacketHelper", 2, "VoiceRedPackMatchRsp status:" + ((VoiceRedPackMatchRsp)localObject1).status);
        }
        Object localObject2 = this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_Ahjk;
        ((ahjk)localObject2).jdField_c_of_type_Int += 1;
        ahjk.a(this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_Ahjk, ((VoiceRedPackMatchRsp)localObject1).status, l, 1, this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
        switch (((VoiceRedPackMatchRsp)localObject1).status)
        {
        }
        for (;;)
        {
          this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_Ahjk.jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
          return;
          localahjs.a(false, "");
          continue;
          ahjk.a(((VoiceRedPackMatchRsp)localObject1).degree, this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_Aypg);
          ahjk.b(((VoiceRedPackMatchRsp)localObject1).degree, this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
          localahjs.a(true, ((VoiceRedPackMatchRsp)localObject1).degree);
          localQQAppInterface.a().a(this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_Akat);
          continue;
          localObject2 = ((VoiceRedPackMatchRsp)localObject1).strErr;
          l = NetConnInfoCenter.getServerTime();
          agxa.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone", l + ((VoiceRedPackMatchRsp)localObject1).timeInterval);
          agxa.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone_tips", (String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "server is busy interval is " + ((VoiceRedPackMatchRsp)localObject1).timeInterval + ",tips is " + (String)localObject2);
          }
          if (this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_Ahjk.jdField_c_of_type_Boolean)
          {
            localObject1 = ahjk.a(this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_Ahjk, this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_Ahjk.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
            if (((ahjt)localObject1).jdField_a_of_type_Boolean)
            {
              ahjk.a(((ahjt)localObject1).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_Aypg);
              localQQAppInterface.a().a(this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_Akat);
            }
            localahjs.a(((ahjt)localObject1).jdField_a_of_type_Boolean, ((ahjt)localObject1).jdField_a_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.d("VoiceRedPacketHelper", 2, "check in phone, result is " + localObject1);
            }
          }
          else
          {
            ahjk.a(this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_Ahjk, (String)localObject2);
          }
        }
      }
      this.jdField_a_of_type_Ahjn.jdField_a_of_type_Ahjm.jdField_a_of_type_Ahjk.c("rsp is null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.3.1.1
 * JD-Core Version:    0.7.0.1
 */