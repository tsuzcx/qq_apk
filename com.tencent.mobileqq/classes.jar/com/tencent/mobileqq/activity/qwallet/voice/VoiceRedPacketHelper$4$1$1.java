package com.tencent.mobileqq.activity.qwallet.voice;

import Wallet.SongRedPackMatchRsp;
import agxc;
import ahiy;
import ahjm;
import ahjq;
import ahjr;
import ahju;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class VoiceRedPacketHelper$4$1$1
  implements Runnable
{
  public VoiceRedPacketHelper$4$1$1(ahjr paramahjr, boolean paramBoolean, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Ahjr.jdField_a_of_type_Long;
    Object localObject = (ahju)this.jdField_a_of_type_Ahjr.jdField_a_of_type_Ahjq.jdField_a_of_type_Ahjm.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      QQAppInterface localQQAppInterface = ahiy.a();
      if (!this.jdField_a_of_type_Boolean) {
        ahjm.a(this.jdField_a_of_type_Ahjr.jdField_a_of_type_Ahjq.jdField_a_of_type_Ahjm, 3, l1 - l2, 1, this.jdField_a_of_type_Ahjr.jdField_a_of_type_Ahjq.b);
      }
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidOsBundle == null) || (this.jdField_a_of_type_Int != 21) || (localQQAppInterface == null) || (this.jdField_a_of_type_Ahjr.jdField_a_of_type_Ahjq.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (localObject == null) || (((ahju)localObject).c()) || (this.jdField_a_of_type_Ahjr.jdField_a_of_type_Ahjq.jdField_a_of_type_Ahjm.b) || (i != this.jdField_a_of_type_Ahjr.jdField_a_of_type_Ahjq.jdField_a_of_type_Ahjm.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Ahjr.jdField_a_of_type_Ahjq.jdField_a_of_type_Ahjm.c("onReceive SongRedPackMatchRsp erorr");
        return;
      }
      SongRedPackMatchRsp localSongRedPackMatchRsp = (SongRedPackMatchRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
      if (QLog.isColorLevel()) {
        QLog.d("VoiceRedPacketHelper", 2, "SongRedPackMatchRsp onReceive:" + localSongRedPackMatchRsp);
      }
      if ((localSongRedPackMatchRsp != null) && (localSongRedPackMatchRsp.grabUin == localQQAppInterface.getLongAccountUin()) && (localSongRedPackMatchRsp.billno != null) && (localSongRedPackMatchRsp.billno.equals(this.jdField_a_of_type_Ahjr.jdField_a_of_type_Ahjq.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceRedPacketHelper", 2, "VoiceRedPackMatchRsp status:" + localSongRedPackMatchRsp.status);
        }
        ahjm localahjm = this.jdField_a_of_type_Ahjr.jdField_a_of_type_Ahjq.jdField_a_of_type_Ahjm;
        localahjm.c += 1;
        switch (localSongRedPackMatchRsp.status)
        {
        }
        for (;;)
        {
          this.jdField_a_of_type_Ahjr.jdField_a_of_type_Ahjq.jdField_a_of_type_Ahjm.jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Ahjr.jdField_a_of_type_Ahjq.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
          this.jdField_a_of_type_Ahjr.jdField_a_of_type_Ahjq.jdField_a_of_type_Ahjm.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_Ahjr.jdField_a_of_type_Ahjq.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
          return;
          ((ahju)localObject).a(false, "");
          continue;
          ahjm.a(localSongRedPackMatchRsp.degree, this.jdField_a_of_type_Ahjr.jdField_a_of_type_Ahjq.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Ahjr.jdField_a_of_type_Ahjq.jdField_a_of_type_Aype);
          ahjm.b(localSongRedPackMatchRsp.degree, this.jdField_a_of_type_Ahjr.jdField_a_of_type_Ahjq.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
          ((ahju)localObject).a(true, localSongRedPackMatchRsp.degree);
          localQQAppInterface.a().a(this.jdField_a_of_type_Ahjr.jdField_a_of_type_Ahjq.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Ahjr.jdField_a_of_type_Ahjq.jdField_a_of_type_Akav);
          continue;
          localObject = localSongRedPackMatchRsp.strErr;
          l1 = NetConnInfoCenter.getServerTime();
          agxc.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone", l1 + localSongRedPackMatchRsp.timeInterval);
          agxc.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone_tips", (String)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "server is busy interval is " + localSongRedPackMatchRsp.timeInterval + ",tips is " + (String)localObject);
          }
          ahjm.a(this.jdField_a_of_type_Ahjr.jdField_a_of_type_Ahjq.jdField_a_of_type_Ahjm, (String)localObject);
        }
      }
      this.jdField_a_of_type_Ahjr.jdField_a_of_type_Ahjq.jdField_a_of_type_Ahjm.c("rsp is null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.4.1.1
 * JD-Core Version:    0.7.0.1
 */