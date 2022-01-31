package com.tencent.mobileqq.activity.qwallet.voice;

import Wallet.SongRedPackMatchRsp;
import aivo;
import ajeu;
import ajfi;
import ajfm;
import ajfn;
import ajfq;
import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
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
  public VoiceRedPacketHelper$4$1$1(ajfn paramajfn, boolean paramBoolean, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Ajfn.jdField_a_of_type_Long;
    Object localObject = (ajfq)this.jdField_a_of_type_Ajfn.jdField_a_of_type_Ajfm.jdField_a_of_type_Ajfi.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      QQAppInterface localQQAppInterface = ajeu.a();
      if (!this.jdField_a_of_type_Boolean) {
        ajfi.a(this.jdField_a_of_type_Ajfn.jdField_a_of_type_Ajfm.jdField_a_of_type_Ajfi, 3, l1 - l2, 1, this.jdField_a_of_type_Ajfn.jdField_a_of_type_Ajfm.b);
      }
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidOsBundle == null) || (this.jdField_a_of_type_Int != 21) || (localQQAppInterface == null) || (this.jdField_a_of_type_Ajfn.jdField_a_of_type_Ajfm.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (localObject == null) || (((ajfq)localObject).c()) || (this.jdField_a_of_type_Ajfn.jdField_a_of_type_Ajfm.jdField_a_of_type_Ajfi.b) || (i != this.jdField_a_of_type_Ajfn.jdField_a_of_type_Ajfm.jdField_a_of_type_Ajfi.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Ajfn.jdField_a_of_type_Ajfm.jdField_a_of_type_Ajfi.c("onReceive SongRedPackMatchRsp erorr");
        return;
      }
      SongRedPackMatchRsp localSongRedPackMatchRsp = (SongRedPackMatchRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
      if (QLog.isColorLevel()) {
        QLog.d("VoiceRedPacketHelper", 2, "SongRedPackMatchRsp onReceive:" + localSongRedPackMatchRsp);
      }
      if ((localSongRedPackMatchRsp != null) && (localSongRedPackMatchRsp.grabUin == localQQAppInterface.getLongAccountUin()) && (localSongRedPackMatchRsp.billno != null) && (localSongRedPackMatchRsp.billno.equals(this.jdField_a_of_type_Ajfn.jdField_a_of_type_Ajfm.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceRedPacketHelper", 2, "VoiceRedPackMatchRsp status:" + localSongRedPackMatchRsp.status);
        }
        ajfi localajfi = this.jdField_a_of_type_Ajfn.jdField_a_of_type_Ajfm.jdField_a_of_type_Ajfi;
        localajfi.c += 1;
        switch (localSongRedPackMatchRsp.status)
        {
        }
        for (;;)
        {
          this.jdField_a_of_type_Ajfn.jdField_a_of_type_Ajfm.jdField_a_of_type_Ajfi.jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Ajfn.jdField_a_of_type_Ajfm.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
          this.jdField_a_of_type_Ajfn.jdField_a_of_type_Ajfm.jdField_a_of_type_Ajfi.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_Ajfn.jdField_a_of_type_Ajfm.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
          return;
          ((ajfq)localObject).a(false, "");
          continue;
          ajfi.a(localSongRedPackMatchRsp.degree, this.jdField_a_of_type_Ajfn.jdField_a_of_type_Ajfm.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Ajfn.jdField_a_of_type_Ajfm.jdField_a_of_type_Bark);
          ajfi.b(localSongRedPackMatchRsp.degree, this.jdField_a_of_type_Ajfn.jdField_a_of_type_Ajfm.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
          ((ajfq)localObject).a(true, localSongRedPackMatchRsp.degree);
          localQQAppInterface.a().a(this.jdField_a_of_type_Ajfn.jdField_a_of_type_Ajfm.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Ajfn.jdField_a_of_type_Ajfm.jdField_a_of_type_Alwx);
          continue;
          localObject = localSongRedPackMatchRsp.strErr;
          l1 = NetConnInfoCenter.getServerTime();
          aivo.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone", l1 + localSongRedPackMatchRsp.timeInterval);
          aivo.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone_tips", (String)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "server is busy interval is " + localSongRedPackMatchRsp.timeInterval + ",tips is " + (String)localObject);
          }
          ajfi.a(this.jdField_a_of_type_Ajfn.jdField_a_of_type_Ajfm.jdField_a_of_type_Ajfi, (String)localObject);
        }
      }
      this.jdField_a_of_type_Ajfn.jdField_a_of_type_Ajfm.jdField_a_of_type_Ajfi.c("rsp is null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.4.1.1
 * JD-Core Version:    0.7.0.1
 */