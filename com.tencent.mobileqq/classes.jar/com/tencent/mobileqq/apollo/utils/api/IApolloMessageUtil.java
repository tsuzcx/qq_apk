package com.tencent.mobileqq.apollo.utils.api;

import android.content.Context;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;
import tencent.im.msg.im_msg_body.RichText;

@QAPI(process={"all"})
public abstract interface IApolloMessageUtil
  extends QRouteApi
{
  public abstract String buildMsgContentForMsg(AppInterface paramAppInterface, Message paramMessage);
  
  public abstract void copyChatMessage(MessageRecord paramMessageRecord);
  
  public abstract MessageRecord createApolloMsgRecord();
  
  public abstract void decodeBaseMsgApollo(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord);
  
  public abstract void decodeC2CApolloMsg(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord);
  
  public abstract void decodeTroopVasApolloMsg(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord);
  
  public abstract void delMsg(Context paramContext, AppInterface paramAppInterface, MessageRecord paramMessageRecord);
  
  public abstract void delMsgWithNoCheck(Context paramContext, AppInterface paramAppInterface, MessageRecord paramMessageRecord);
  
  public abstract String getApolloDescMsg(byte[] paramArrayOfByte);
  
  public abstract String getApolloMsgTranDec(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord);
  
  public abstract im_msg_body.RichText getSendApolloBody(MessageRecord paramMessageRecord);
  
  public abstract void handleRevokeRspByType(MessageRecord paramMessageRecord, AppInterface paramAppInterface, int paramInt);
  
  public abstract void setChatHistoryView(TextView paramTextView, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.IApolloMessageUtil
 * JD-Core Version:    0.7.0.1
 */