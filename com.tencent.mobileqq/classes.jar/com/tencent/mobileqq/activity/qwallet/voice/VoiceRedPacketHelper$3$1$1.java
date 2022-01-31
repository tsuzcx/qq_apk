package com.tencent.mobileqq.activity.qwallet.voice;

import Wallet.VoiceRedPackMatchRsp;
import aivo;
import ajeu;
import ajfi;
import ajfk;
import ajfl;
import ajfq;
import ajfr;
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
  public VoiceRedPacketHelper$3$1$1(ajfl paramajfl, boolean paramBoolean, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Ajfl.jdField_a_of_type_Long;
    ajfq localajfq = (ajfq)this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_Ajfi.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localajfq != null) {}
    for (int i = localajfq.hashCode();; i = 0)
    {
      QQAppInterface localQQAppInterface = ajeu.a();
      if (!this.jdField_a_of_type_Boolean) {
        ajfi.a(this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_Ajfi, 3, l, 1, this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      }
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidOsBundle == null) || (this.jdField_a_of_type_Int != 13) || (localQQAppInterface == null) || (this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (localajfq == null) || (localajfq.c()) || (this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_Ajfi.b) || (i != this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_Ajfi.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_Ajfi.c("onReceive VoiceRedPackMatchRsp erorr");
        return;
      }
      Object localObject1 = (VoiceRedPackMatchRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
      if (QLog.isColorLevel()) {
        QLog.d("VoiceRedPacketHelper", 2, "VoiceRedPackMatchRsp onReceive:" + localObject1);
      }
      if ((localObject1 != null) && (((VoiceRedPackMatchRsp)localObject1).grabUin == localQQAppInterface.getLongAccountUin()) && (((VoiceRedPackMatchRsp)localObject1).billno != null) && (((VoiceRedPackMatchRsp)localObject1).billno.equals(this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceRedPacketHelper", 2, "VoiceRedPackMatchRsp status:" + ((VoiceRedPackMatchRsp)localObject1).status);
        }
        Object localObject2 = this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_Ajfi;
        ((ajfi)localObject2).jdField_c_of_type_Int += 1;
        ajfi.a(this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_Ajfi, ((VoiceRedPackMatchRsp)localObject1).status, l, 1, this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
        switch (((VoiceRedPackMatchRsp)localObject1).status)
        {
        }
        for (;;)
        {
          this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_Ajfi.jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
          return;
          localajfq.a(false, "");
          continue;
          ajfi.a(((VoiceRedPackMatchRsp)localObject1).degree, this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_Bark);
          ajfi.b(((VoiceRedPackMatchRsp)localObject1).degree, this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
          localajfq.a(true, ((VoiceRedPackMatchRsp)localObject1).degree);
          localQQAppInterface.a().a(this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_Alwx);
          continue;
          localObject2 = ((VoiceRedPackMatchRsp)localObject1).strErr;
          l = NetConnInfoCenter.getServerTime();
          aivo.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone", l + ((VoiceRedPackMatchRsp)localObject1).timeInterval);
          aivo.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone_tips", (String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "server is busy interval is " + ((VoiceRedPackMatchRsp)localObject1).timeInterval + ",tips is " + (String)localObject2);
          }
          if (this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_Ajfi.jdField_c_of_type_Boolean)
          {
            localObject1 = ajfi.a(this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_Ajfi, this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_Ajfi.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
            if (((ajfr)localObject1).jdField_a_of_type_Boolean)
            {
              ajfi.a(((ajfr)localObject1).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_Bark);
              localQQAppInterface.a().a(this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_Alwx);
            }
            localajfq.a(((ajfr)localObject1).jdField_a_of_type_Boolean, ((ajfr)localObject1).jdField_a_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.d("VoiceRedPacketHelper", 2, "check in phone, result is " + localObject1);
            }
          }
          else
          {
            ajfi.a(this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_Ajfi, (String)localObject2);
          }
        }
      }
      this.jdField_a_of_type_Ajfl.jdField_a_of_type_Ajfk.jdField_a_of_type_Ajfi.c("rsp is null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.3.1.1
 * JD-Core Version:    0.7.0.1
 */