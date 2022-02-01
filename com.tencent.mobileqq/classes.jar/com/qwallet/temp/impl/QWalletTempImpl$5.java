package com.qwallet.temp.impl;

import com.qwallet.temp.IQWalletTemp.ITempString;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

class QWalletTempImpl$5
  implements WtTicketPromise
{
  QWalletTempImpl$5(QWalletTempImpl paramQWalletTempImpl, IQWalletTemp.ITempString paramITempString) {}
  
  public void Done(Ticket paramTicket)
  {
    if ((paramTicket != null) && (paramTicket._sig != null) && (paramTicket._sig.length != 0))
    {
      this.jdField_a_of_type_ComQwalletTempIQWalletTemp$ITempString.a(0, new String(paramTicket._sig));
      return;
    }
    this.jdField_a_of_type_ComQwalletTempIQWalletTemp$ITempString.a(-1, "get skey is null");
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    this.jdField_a_of_type_ComQwalletTempIQWalletTemp$ITempString.a(-1, "get skey failed");
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    this.jdField_a_of_type_ComQwalletTempIQWalletTemp$ITempString.a(-1, "get skey time out");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.qwallet.temp.impl.QWalletTempImpl.5
 * JD-Core Version:    0.7.0.1
 */