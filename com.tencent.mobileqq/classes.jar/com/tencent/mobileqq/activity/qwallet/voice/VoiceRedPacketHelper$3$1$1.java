package com.tencent.mobileqq.activity.qwallet.voice;

import Wallet.VoiceRedPackMatchRsp;
import akyd;
import alil;
import aljb;
import aljd;
import alje;
import aljj;
import aljk;
import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class VoiceRedPacketHelper$3$1$1
  implements Runnable
{
  public VoiceRedPacketHelper$3$1$1(alje paramalje, boolean paramBoolean, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Alje.jdField_a_of_type_Long;
    aljj localaljj = (aljj)this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_Aljb.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localaljj != null) {}
    for (int i = localaljj.hashCode();; i = 0)
    {
      QQAppInterface localQQAppInterface = alil.a();
      if (!this.jdField_a_of_type_Boolean) {
        aljb.a(this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_Aljb, 3, l, 1, this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      }
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidOsBundle == null) || (this.jdField_a_of_type_Int != 13) || (localQQAppInterface == null) || (this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (localaljj == null) || (localaljj.c()) || (this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_Aljb.b) || (i != this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_Aljb.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_Aljb.c("onReceive VoiceRedPackMatchRsp erorr");
        return;
      }
      Object localObject1 = (VoiceRedPackMatchRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
      if (QLog.isColorLevel()) {
        QLog.d("VoiceRedPacketHelper", 2, "VoiceRedPackMatchRsp onReceive:" + localObject1);
      }
      if ((localObject1 != null) && (((VoiceRedPackMatchRsp)localObject1).grabUin == localQQAppInterface.getLongAccountUin()) && (((VoiceRedPackMatchRsp)localObject1).billno != null) && (((VoiceRedPackMatchRsp)localObject1).billno.equals(this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceRedPacketHelper", 2, "VoiceRedPackMatchRsp status:" + ((VoiceRedPackMatchRsp)localObject1).status);
        }
        Object localObject2 = this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_Aljb;
        ((aljb)localObject2).jdField_c_of_type_Int += 1;
        aljb.a(this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_Aljb, ((VoiceRedPackMatchRsp)localObject1).status, l, 1, this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
        switch (((VoiceRedPackMatchRsp)localObject1).status)
        {
        }
        for (;;)
        {
          this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_Aljb.jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
          return;
          localaljj.a(false, "");
          continue;
          aljb.a(((VoiceRedPackMatchRsp)localObject1).degree, this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_Beru);
          aljb.b(((VoiceRedPackMatchRsp)localObject1).degree, this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
          localaljj.a(true, ((VoiceRedPackMatchRsp)localObject1).degree);
          localQQAppInterface.a().a(this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_Aocj);
          continue;
          localObject2 = ((VoiceRedPackMatchRsp)localObject1).strErr;
          l = NetConnInfoCenter.getServerTime();
          akyd.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone", l + ((VoiceRedPackMatchRsp)localObject1).timeInterval);
          akyd.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone_tips", (String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "server is busy interval is " + ((VoiceRedPackMatchRsp)localObject1).timeInterval + ",tips is " + (String)localObject2);
          }
          if (this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_Aljb.jdField_c_of_type_Boolean)
          {
            localObject1 = aljb.a(this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_Aljb, this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_Aljb.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
            if (((aljk)localObject1).jdField_a_of_type_Boolean)
            {
              aljb.a(((aljk)localObject1).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_Beru);
              localQQAppInterface.a().a(this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_Aocj);
            }
            localaljj.a(((aljk)localObject1).jdField_a_of_type_Boolean, ((aljk)localObject1).jdField_a_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.d("VoiceRedPacketHelper", 2, "check in phone, result is " + localObject1);
            }
          }
          else
          {
            aljb.a(this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_Aljb, (String)localObject2);
          }
        }
      }
      this.jdField_a_of_type_Alje.jdField_a_of_type_Aljd.jdField_a_of_type_Aljb.c("rsp is null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.3.1.1
 * JD-Core Version:    0.7.0.1
 */