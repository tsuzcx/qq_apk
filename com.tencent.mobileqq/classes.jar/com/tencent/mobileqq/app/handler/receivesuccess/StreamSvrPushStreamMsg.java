package com.tencent.mobileqq.app.handler.receivesuccess;

import QQService.StreamData;
import QQService.StreamInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;

public class StreamSvrPushStreamMsg
{
  public static void a(QQAppInterface paramQQAppInterface, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (("StreamSvr.PushStreamMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (paramObject != null))
    {
      Object localObject = (Object[])paramObject;
      long l1 = ((Long)localObject[0]).longValue();
      paramFromServiceMsg = (StreamInfo)localObject[1];
      paramObject = (StreamData)localObject[2];
      long l2 = ((Long)localObject[3]).longValue();
      long l3 = ((Long)localObject[4]).longValue();
      long l4 = ((Long)localObject[5]).longValue();
      localObject = new ptt_reserve.ReserveStruct();
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.vPbData != null)) {
        try
        {
          ((ptt_reserve.ReserveStruct)localObject).mergeFrom(paramFromServiceMsg.vPbData);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          QLog.e("Q.msg.MessageHandler", 1, "parse streaminfo.vPbData failed.", localInvalidProtocolBufferMicroException);
        }
      }
      if (paramFromServiceMsg != null) {
        StreamDataManager.a(paramQQAppInterface, paramFromServiceMsg, paramObject, l1, l2, l3, l4, (ptt_reserve.ReserveStruct)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.StreamSvrPushStreamMsg
 * JD-Core Version:    0.7.0.1
 */