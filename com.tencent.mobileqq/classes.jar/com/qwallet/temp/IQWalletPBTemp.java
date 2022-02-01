package com.qwallet.temp;

import com.tencent.mobileqq.data.QWalletGoldMsgTipsElem;
import com.tencent.mobileqq.data.QWalletSubmsgtype0x66.MsgBody;
import com.tencent.mobileqq.data.QWalletSubmsgtype0x7e.MsgBody.OnlinePush;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQWalletPBTemp
  extends QRouteApi
{
  public abstract QWalletSubmsgtype0x66.MsgBody convertSubmsgtype0x66$MsgBody(byte[] paramArrayOfByte);
  
  public abstract QWalletSubmsgtype0x7e.MsgBody.OnlinePush convertSubmsgtype0x7e$MsgBody$OnlinePush(byte[] paramArrayOfByte);
  
  public abstract QWalletGoldMsgTipsElem convertTroopTips(Object paramObject);
  
  public abstract QWalletGoldMsgTipsElem convertTroopTips(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qwallet.temp.IQWalletPBTemp
 * JD-Core Version:    0.7.0.1
 */