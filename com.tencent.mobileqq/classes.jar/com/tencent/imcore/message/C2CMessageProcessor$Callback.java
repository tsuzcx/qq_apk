package com.tencent.imcore.message;

import PushNotifyPack.C2CMsgReadedNotify;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import java.util.ArrayList;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;

public abstract interface C2CMessageProcessor$Callback
{
  public abstract int a(C2CMessageProcessor paramC2CMessageProcessor);
  
  public abstract long a(int paramInt1, int paramInt2);
  
  public abstract long a(AppInterface paramAppInterface, long paramLong1, long paramLong2, long paramLong3);
  
  public abstract long a(AppInterface paramAppInterface, long paramLong1, long paramLong2, long paramLong3, msg_comm.UinPairMsg paramUinPairMsg);
  
  public abstract String a(String paramString, C2CMessageProcessor paramC2CMessageProcessor);
  
  public abstract String a(msg_comm.UinPairMsg paramUinPairMsg, AppInterface paramAppInterface, int paramInt);
  
  public abstract List<MessageRecord> a(String paramString, long paramLong1, long paramLong2, C2CMessageProcessor paramC2CMessageProcessor);
  
  public abstract List<MessageRecord> a(String paramString, List<msg_comm.Msg> paramList, C2CMessageProcessor paramC2CMessageProcessor);
  
  public abstract void a(int paramInt, C2CMessageProcessor paramC2CMessageProcessor);
  
  public abstract void a(long paramLong);
  
  public abstract void a(long paramLong, C2CMessageProcessor paramC2CMessageProcessor);
  
  public abstract void a(AppInterface paramAppInterface, String paramString);
  
  public abstract void a(AppInterface paramAppInterface, String paramString, C2CMsgReadedNotify paramC2CMsgReadedNotify);
  
  public abstract void a(C2CMessageProcessor paramC2CMessageProcessor, ArrayList<MessageRecord> paramArrayList, long paramLong1, long paramLong2, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext);
  
  public abstract void a(C2CMessageProcessor paramC2CMessageProcessor, msg_comm.UinPairMsg paramUinPairMsg, long paramLong, ArrayList<MessageRecord> paramArrayList, ArrayList<msg_comm.Msg> paramArrayList1, StringBuilder paramStringBuilder, DecodeProtoPkgContext paramDecodeProtoPkgContext, int paramInt);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, int paramInt, long paramLong, C2CMessageProcessor paramC2CMessageProcessor);
  
  public abstract void a(String paramString, long paramLong, int paramInt, C2CMessageProcessor paramC2CMessageProcessor);
  
  public abstract void a(String paramString, List<msg_comm.Msg> paramList, boolean paramBoolean, int paramInt, C2CMessageProcessor paramC2CMessageProcessor);
  
  public abstract void a(String paramString1, boolean paramBoolean, ArrayList<MessageRecord> paramArrayList, String paramString2, int paramInt, C2CMessageProcessor paramC2CMessageProcessor);
  
  public abstract void a(ArrayList<MessageRecord> paramArrayList, C2CMessageProcessor paramC2CMessageProcessor);
  
  public abstract void a(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean, C2CMessageProcessor paramC2CMessageProcessor);
  
  public abstract void a(List<MessageRecord> paramList);
  
  public abstract void a(List<MessageRecord> paramList, C2CMessageProcessor paramC2CMessageProcessor);
  
  public abstract void a(msg_comm.Msg paramMsg, DecodeProtoPkgContext paramDecodeProtoPkgContext, long paramLong1, ArrayList<MessageRecord> paramArrayList1, msg_comm.MsgHead paramMsgHead, int paramInt1, long paramLong2, long paramLong3, int paramInt2, long paramLong4, int paramInt3, int paramInt4, int paramInt5, ArrayList<MessageRecord> paramArrayList2, C2CMessageProcessor paramC2CMessageProcessor);
  
  public abstract boolean a(MessageRecord paramMessageRecord, C2CMessageProcessor.ProcessMsgPushPBSlaveMaster paramProcessMsgPushPBSlaveMaster, C2CMessageProcessor paramC2CMessageProcessor);
  
  public abstract boolean a(MessageRecord paramMessageRecord, C2CMessageProcessor paramC2CMessageProcessor);
  
  public abstract void b(ArrayList<MessageRecord> paramArrayList, C2CMessageProcessor paramC2CMessageProcessor);
  
  public abstract byte[] b(C2CMessageProcessor paramC2CMessageProcessor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageProcessor.Callback
 * JD-Core Version:    0.7.0.1
 */