package com.tencent.mobileqq.activity.qwallet.voice;

import Wallet.VoiceRedPackMatchRsp;
import akrn;
import albw;
import alcm;
import alco;
import alcp;
import alcu;
import alcv;
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
  public VoiceRedPacketHelper$3$1$1(alcp paramalcp, boolean paramBoolean, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Alcp.jdField_a_of_type_Long;
    alcu localalcu = (alcu)this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_Alcm.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localalcu != null) {}
    for (int i = localalcu.hashCode();; i = 0)
    {
      QQAppInterface localQQAppInterface = albw.a();
      if (!this.jdField_a_of_type_Boolean) {
        alcm.a(this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_Alcm, 3, l, 1, this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
      }
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidOsBundle == null) || (this.jdField_a_of_type_Int != 13) || (localQQAppInterface == null) || (this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (localalcu == null) || (localalcu.c()) || (this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_Alcm.b) || (i != this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_Alcm.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_Alcm.b("onReceive VoiceRedPackMatchRsp erorr");
        return;
      }
      Object localObject1 = (VoiceRedPackMatchRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
      if (QLog.isColorLevel()) {
        QLog.d("VoiceRedPacketHelper", 2, "VoiceRedPackMatchRsp onReceive:" + localObject1);
      }
      if ((localObject1 != null) && (((VoiceRedPackMatchRsp)localObject1).grabUin == localQQAppInterface.getLongAccountUin()) && (((VoiceRedPackMatchRsp)localObject1).billno != null) && (((VoiceRedPackMatchRsp)localObject1).billno.equals(this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceRedPacketHelper", 2, "VoiceRedPackMatchRsp status:" + ((VoiceRedPackMatchRsp)localObject1).status);
        }
        Object localObject2 = this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_Alcm;
        ((alcm)localObject2).jdField_c_of_type_Int += 1;
        alcm.a(this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_Alcm, ((VoiceRedPackMatchRsp)localObject1).status, l, 1, this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
        switch (((VoiceRedPackMatchRsp)localObject1).status)
        {
        }
        for (;;)
        {
          this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_Alcm.jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
          return;
          localalcu.a(false, "");
          continue;
          alcm.a(((VoiceRedPackMatchRsp)localObject1).degree, this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_ComTencentMobileqqTransfileBaseUploadProcessor);
          alcm.b(((VoiceRedPackMatchRsp)localObject1).degree, this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
          localalcu.a(true, ((VoiceRedPackMatchRsp)localObject1).degree);
          localQQAppInterface.getMessageFacade().addAndSendMessage(this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_Anyz);
          continue;
          localObject2 = ((VoiceRedPackMatchRsp)localObject1).strErr;
          l = NetConnInfoCenter.getServerTime();
          akrn.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone", l + ((VoiceRedPackMatchRsp)localObject1).timeInterval);
          akrn.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone_tips", (String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "server is busy interval is " + ((VoiceRedPackMatchRsp)localObject1).timeInterval + ",tips is " + (String)localObject2);
          }
          if (this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_Alcm.jdField_c_of_type_Boolean)
          {
            localObject1 = alcm.a(this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_Alcm, this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_Alcm.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
            if (((alcv)localObject1).jdField_a_of_type_Boolean)
            {
              alcm.a(((alcv)localObject1).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_ComTencentMobileqqTransfileBaseUploadProcessor);
              localQQAppInterface.getMessageFacade().addAndSendMessage(this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_Anyz);
            }
            localalcu.a(((alcv)localObject1).jdField_a_of_type_Boolean, ((alcv)localObject1).jdField_a_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.d("VoiceRedPacketHelper", 2, "check in phone, result is " + localObject1);
            }
          }
          else
          {
            alcm.a(this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_Alcm, (String)localObject2);
          }
        }
      }
      this.jdField_a_of_type_Alcp.jdField_a_of_type_Alco.jdField_a_of_type_Alcm.b("rsp is null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.3.1.1
 * JD-Core Version:    0.7.0.1
 */