package com.tencent.mobileqq.activity.qwallet.voice;

import Wallet.C2CVoiceInfo;
import Wallet.GroupVoiceInfo;
import Wallet.SongRedPackMatchReq;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.qphone.base.util.QLog;

class VoiceRedPacketHelper$4
  implements VoiceRedPacketHelper.OnGetSkeyListener
{
  VoiceRedPacketHelper$4(VoiceRedPacketHelper paramVoiceRedPacketHelper, MessageForQQWalletMsg paramMessageForQQWalletMsg1, QQAppInterface paramQQAppInterface, int paramInt, VoiceRedPacketHelper.RecordMsgInfo paramRecordMsgInfo, long paramLong, byte[] paramArrayOfByte, String paramString, MessageForQQWalletMsg paramMessageForQQWalletMsg2, MessageForPtt paramMessageForPtt, BaseUploadProcessor paramBaseUploadProcessor, MessageObserver paramMessageObserver) {}
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.b("skey is null");
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.songFlag;
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId;
    int j = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.songId;
    int k = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.d;
    long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin);
    long l3 = AppSetting.a();
    int m = this.jdField_a_of_type_Int;
    GroupVoiceInfo localGroupVoiceInfo1;
    label109:
    GroupVoiceInfo localGroupVoiceInfo2;
    label119:
    C2CVoiceInfo localC2CVoiceInfo1;
    if (this.jdField_a_of_type_Int == 0)
    {
      localGroupVoiceInfo1 = null;
      if (this.jdField_a_of_type_Int != 0) {
        break label309;
      }
      localGroupVoiceInfo2 = null;
      if (this.jdField_a_of_type_Int != 0) {
        break label345;
      }
      if (i != 1) {
        break label339;
      }
      localC2CVoiceInfo1 = new C2CVoiceInfo(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper$RecordMsgInfo.jdField_a_of_type_JavaLangString);
      label147:
      if (this.jdField_a_of_type_Int != 0) {
        break label351;
      }
    }
    label309:
    label339:
    label345:
    label351:
    for (C2CVoiceInfo localC2CVoiceInfo2 = new C2CVoiceInfo(this.jdField_a_of_type_JavaLangString);; localC2CVoiceInfo2 = null)
    {
      paramString = new SongRedPackMatchReq(l1, str, j, i, k, l2, paramString, l3, m, 0, "8.5.5", localGroupVoiceInfo1, localGroupVoiceInfo2, localC2CVoiceInfo1, localC2CVoiceInfo2);
      if (QLog.isColorLevel()) {
        QLog.d("VoiceRedPacketHelper", 2, "SongRedPackMatchReq :" + paramString);
      }
      QWalletCommonServlet.a(paramString, new VoiceRedPacketHelper.4.1(this, System.currentTimeMillis()));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VoiceRedPacketHelper", 2, "checkAndSendMessage() sendRequest");
      return;
      if (i == 1)
      {
        localGroupVoiceInfo1 = new GroupVoiceInfo(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin), this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper$RecordMsgInfo.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper$RecordMsgInfo.jdField_a_of_type_ArrayOfByte);
        break label109;
      }
      localGroupVoiceInfo1 = null;
      break label109;
      localGroupVoiceInfo2 = new GroupVoiceInfo(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin), this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte);
      break label119;
      localC2CVoiceInfo1 = null;
      break label147;
      localC2CVoiceInfo1 = null;
      break label147;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.4
 * JD-Core Version:    0.7.0.1
 */