package com.tencent.mobileqq.activity.qwallet.voice;

import Wallet.SongRedPackMatchRsp;
import ajvu;
import akgd;
import akgt;
import akgx;
import akgy;
import akhb;
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
  public VoiceRedPacketHelper$4$1$1(akgy paramakgy, boolean paramBoolean, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Akgy.jdField_a_of_type_Long;
    Object localObject = (akhb)this.jdField_a_of_type_Akgy.jdField_a_of_type_Akgx.jdField_a_of_type_Akgt.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      QQAppInterface localQQAppInterface = akgd.a();
      if (!this.jdField_a_of_type_Boolean) {
        akgt.a(this.jdField_a_of_type_Akgy.jdField_a_of_type_Akgx.jdField_a_of_type_Akgt, 3, l1 - l2, 1, this.jdField_a_of_type_Akgy.jdField_a_of_type_Akgx.b);
      }
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_AndroidOsBundle == null) || (this.jdField_a_of_type_Int != 21) || (localQQAppInterface == null) || (this.jdField_a_of_type_Akgy.jdField_a_of_type_Akgx.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg == null) || (localObject == null) || (((akhb)localObject).c()) || (this.jdField_a_of_type_Akgy.jdField_a_of_type_Akgx.jdField_a_of_type_Akgt.b) || (i != this.jdField_a_of_type_Akgy.jdField_a_of_type_Akgx.jdField_a_of_type_Akgt.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_Akgy.jdField_a_of_type_Akgx.jdField_a_of_type_Akgt.c("onReceive SongRedPackMatchRsp erorr");
        return;
      }
      SongRedPackMatchRsp localSongRedPackMatchRsp = (SongRedPackMatchRsp)this.jdField_a_of_type_AndroidOsBundle.getSerializable("rsp");
      if (QLog.isColorLevel()) {
        QLog.d("VoiceRedPacketHelper", 2, "SongRedPackMatchRsp onReceive:" + localSongRedPackMatchRsp);
      }
      if ((localSongRedPackMatchRsp != null) && (localSongRedPackMatchRsp.grabUin == localQQAppInterface.getLongAccountUin()) && (localSongRedPackMatchRsp.billno != null) && (localSongRedPackMatchRsp.billno.equals(this.jdField_a_of_type_Akgy.jdField_a_of_type_Akgx.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceRedPacketHelper", 2, "VoiceRedPackMatchRsp status:" + localSongRedPackMatchRsp.status);
        }
        akgt localakgt = this.jdField_a_of_type_Akgy.jdField_a_of_type_Akgx.jdField_a_of_type_Akgt;
        localakgt.c += 1;
        switch (localSongRedPackMatchRsp.status)
        {
        }
        for (;;)
        {
          this.jdField_a_of_type_Akgy.jdField_a_of_type_Akgx.jdField_a_of_type_Akgt.jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_Akgy.jdField_a_of_type_Akgx.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
          this.jdField_a_of_type_Akgy.jdField_a_of_type_Akgx.jdField_a_of_type_Akgt.jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_Akgy.jdField_a_of_type_Akgx.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt);
          return;
          ((akhb)localObject).a(false, "");
          continue;
          akgt.a(localSongRedPackMatchRsp.degree, this.jdField_a_of_type_Akgy.jdField_a_of_type_Akgx.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Akgy.jdField_a_of_type_Akgx.jdField_a_of_type_ComTencentMobileqqTransfileBaseUploadProcessor);
          akgt.b(localSongRedPackMatchRsp.degree, this.jdField_a_of_type_Akgy.jdField_a_of_type_Akgx.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
          ((akhb)localObject).a(true, localSongRedPackMatchRsp.degree);
          localQQAppInterface.getMessageFacade().addAndSendMessage(this.jdField_a_of_type_Akgy.jdField_a_of_type_Akgx.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, this.jdField_a_of_type_Akgy.jdField_a_of_type_Akgx.jdField_a_of_type_Amwl);
          continue;
          localObject = localSongRedPackMatchRsp.strErr;
          l1 = NetConnInfoCenter.getServerTime();
          ajvu.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone", l1 + localSongRedPackMatchRsp.timeInterval);
          ajvu.a(localQQAppInterface.getCurrentAccountUin(), "voice_recognieze_in_phone_tips", (String)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceRedPacketHelper", 2, "server is busy interval is " + localSongRedPackMatchRsp.timeInterval + ",tips is " + (String)localObject);
          }
          akgt.a(this.jdField_a_of_type_Akgy.jdField_a_of_type_Akgx.jdField_a_of_type_Akgt, (String)localObject);
        }
      }
      this.jdField_a_of_type_Akgy.jdField_a_of_type_Akgx.jdField_a_of_type_Akgt.c("rsp is null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.4.1.1
 * JD-Core Version:    0.7.0.1
 */