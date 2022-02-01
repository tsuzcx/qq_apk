package com.tencent.mobileqq.activity.qwallet.voice;

import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class VoiceRedPacketHelper$5
  implements WtTicketPromise
{
  VoiceRedPacketHelper$5(VoiceRedPacketHelper paramVoiceRedPacketHelper, VoiceRedPacketHelper.OnGetSkeyListener paramOnGetSkeyListener) {}
  
  public void Done(Ticket paramTicket)
  {
    if ((paramTicket != null) && (paramTicket._sig != null) && (paramTicket._sig.length != 0))
    {
      paramTicket = new String(paramTicket._sig);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper$OnGetSkeyListener.a(paramTicket);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.b("get skey is null");
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.b("get skey failed");
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletVoiceVoiceRedPacketHelper.b("get skey time out");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper.5
 * JD-Core Version:    0.7.0.1
 */