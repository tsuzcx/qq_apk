package com.tencent.mobileqq.activity.qwallet.voice;

import Wallet.VoiceRedPackMatchRsp;
import aiqz;
import ajaf;
import ajat;
import ajav;
import ajaw;
import ajbb;
import ajbc;
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
  public VoiceRedPacketHelper$3$1$1(ajaw paramajaw, boolean paramBoolean, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Ajaw.jdField_a_of_type_Long;
    ajbb localajbb = (ajbb)this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_Ajat.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localajbb != null) {}
    for (int i = localajbb.hashCode();; i = 0)
    {
      QQAppInterface localQQAppInterface = ajaf.a();
      if (!this.jdField_a_of_type_Boolean) {
        ajat.a(this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_Ajat, 3, l, 1, this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      }
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidOsBundle == null) || (this.jdField_a_of_type_Int != 13) || (localQQAppInterface == null) || (this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (localajbb == null) || (localajbb.c()) || (this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_Ajat.b) || (i != this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_Ajat.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_Ajat.c("onReceive VoiceRedPackMatchRsp erorr");
        return;
      }
      Object localObject1 = (VoiceRedPackMatchRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
      if (QLog.isColorLevel()) {
        QLog.d("VoiceRedPacketHelper", 2, "VoiceRedPackMatchRsp onReceive:" + localObject1);
      }
      if ((localObject1 != null) && (((VoiceRedPackMatchRsp)localObject1).grabUin == localQQAppInterface.getLongAccountUin()) && (((VoiceRedPackMatchRsp)localObject1).billno != null) && (((VoiceRedPackMatchRsp)localObject1).billno.equals(this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceRedPacketHelper", 2, "VoiceRedPackMatchRsp status:" + ((VoiceRedPackMatchRsp)localObject1).status);
        }
        Object localObject2 = this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_Ajat;
        ((ajat)localObject2).jdField_c_of_type_Int += 1;
        ajat.a(this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_Ajat, ((VoiceRedPackMatchRsp)localObject1).status, l, 1, this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
        switch (((VoiceRedPackMatchRsp)localObject1).status)
        {
        }
        for (;;)
        {
          this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_Ajat.jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
          return;
          localajbb.a(false, "");
          continue;
          ajat.a(((VoiceRedPackMatchRsp)localObject1).degree, this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_Banb);
          ajat.b(((VoiceRedPackMatchRsp)localObject1).degree, this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
          localajbb.a(true, ((VoiceRedPackMatchRsp)localObject1).degree);
          localQQAppInterface.a().a(this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_Alsi);
          continue;
          localObject2 = ((VoiceRedPackMatchRsp)localObject1).strErr;
          l = NetConnInfoCenter.getServerTime();
          aiqz.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone", l + ((VoiceRedPackMatchRsp)localObject1).timeInterval);
          aiqz.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone_tips", (String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "server is busy interval is " + ((VoiceRedPackMatchRsp)localObject1).timeInterval + ",tips is " + (String)localObject2);
          }
          if (this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_Ajat.jdField_c_of_type_Boolean)
          {
            localObject1 = ajat.a(this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_Ajat, this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_Ajat.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
            if (((ajbc)localObject1).jdField_a_of_type_Boolean)
            {
              ajat.a(((ajbc)localObject1).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_Banb);
              localQQAppInterface.a().a(this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_Alsi);
            }
            localajbb.a(((ajbc)localObject1).jdField_a_of_type_Boolean, ((ajbc)localObject1).jdField_a_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.d("VoiceRedPacketHelper", 2, "check in phone, result is " + localObject1);
            }
          }
          else
          {
            ajat.a(this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_Ajat, (String)localObject2);
          }
        }
      }
      this.jdField_a_of_type_Ajaw.jdField_a_of_type_Ajav.jdField_a_of_type_Ajat.c("rsp is null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.3.1.1
 * JD-Core Version:    0.7.0.1
 */