package com.tencent.av.screenshare;

import android.os.Handler;
import android.os.Looper;
import com.tencent.av.ReqGroupVideo.ReqScreenShareAnswer;
import com.tencent.av.ReqGroupVideo.ReqScreenShareAsk;
import com.tencent.av.ReqGroupVideo.RspScreenShareAnswer;
import com.tencent.av.ReqGroupVideo.RspScreenShareAsk;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.MessageHandler;
import com.tencent.av.common.ErrorInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;

public class ScreenShareHandler
  extends BusinessHandler
{
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "QQRTCSvc.screen_share_ask", "QQRTCSvc.screen_share_answer" };
  private final VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  
  public ScreenShareHandler(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public static String[] a()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public void a()
  {
    ReqGroupVideo.ReqScreenShareAsk localReqScreenShareAsk = new ReqGroupVideo.ReqScreenShareAsk();
    localReqScreenShareAsk.from_uin.set(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin());
    localReqScreenShareAsk.to_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d));
    localReqScreenShareAsk.is_online.set(true);
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQRTCSvc.screen_share_ask");
    localToServiceMsg.putWupBuffer(localReqScreenShareAsk.toByteArray());
    sendPbReq(localToServiceMsg);
    QLog.i("ScreenShareHandler", 4, "askScreenShare, from " + localReqScreenShareAsk.from_uin.get() + " , to " + localReqScreenShareAsk.to_uin.get());
    if (QLog.isDevelopLevel()) {
      QLog.i("ScreenShareHandler", 4, "askScreenShare, from " + localReqScreenShareAsk.from_uin + " , to " + localReqScreenShareAsk.to_uin);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i == 0) {
        break label217;
      }
    }
    label217:
    for (paramToServiceMsg = new ReqGroupVideo.RspScreenShareAsk();; paramToServiceMsg = null) {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (QLog.isColorLevel()) {
          QLog.i("ScreenShareHandler", 2, "handleScreenShareAsk receive success");
        }
        if (i == 0)
        {
          QLog.e("ScreenShareHandler", 2, "handleScreenShareAsk() failed");
          return;
          i = 0;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        do
        {
          for (;;)
          {
            QLog.e("ScreenShareHandler", 1, "handleScreenShareAsk(): " + paramFromServiceMsg);
            i = 0;
          }
          paramToServiceMsg = (common.ErrorInfo)paramToServiceMsg.result.get();
          i = MessageHandler.a(paramToServiceMsg);
          paramToServiceMsg = MessageHandler.a(paramToServiceMsg);
          if ((i != -99) && (i != 0))
          {
            new Handler(Looper.getMainLooper()).post(new ScreenShareHandler.1(this, paramToServiceMsg));
            QLog.e("ScreenShareHandler", 2, "handleScreenShareAsk() error code: %d" + i + "error msg: " + paramToServiceMsg);
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.i("ScreenShareHandler", 2, "handleScreenShareAsk() found no error");
        return;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ReqGroupVideo.ReqScreenShareAnswer localReqScreenShareAnswer = new ReqGroupVideo.ReqScreenShareAnswer();
    localReqScreenShareAnswer.from_uin.set(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin());
    localReqScreenShareAnswer.to_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d));
    localReqScreenShareAnswer.is_accept.set(paramBoolean);
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQRTCSvc.screen_share_answer");
    localToServiceMsg.putWupBuffer(localReqScreenShareAnswer.toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isDevelopLevel()) {
      QLog.i("ScreenShareHandler", 4, "answerScreenShare, from " + localReqScreenShareAnswer.from_uin + ", to " + localReqScreenShareAnswer.to_uin + ", isAccept: " + localReqScreenShareAnswer.is_accept);
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i == 0) {
        break label189;
      }
    }
    label189:
    for (paramToServiceMsg = new ReqGroupVideo.RspScreenShareAnswer();; paramToServiceMsg = null) {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (QLog.isColorLevel()) {
          QLog.i("ScreenShareHandler", 2, "handleScreenShareAnswer receive success");
        }
        if (i == 0)
        {
          QLog.e("ScreenShareHandler", 2, "handleScreenShareAnswer() failed");
          return;
          i = 0;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        do
        {
          for (;;)
          {
            QLog.e("ScreenShareHandler", 1, "handleScreenShareAnswer(): " + paramFromServiceMsg);
            i = 0;
          }
          paramToServiceMsg = (common.ErrorInfo)paramToServiceMsg.result.get();
          i = MessageHandler.a(paramToServiceMsg);
          paramToServiceMsg = MessageHandler.a(paramToServiceMsg);
          if (i != -99)
          {
            QLog.e("ScreenShareHandler", 2, "handleScreenShareAnswer() error code: %d" + i + "error msg: " + paramToServiceMsg);
            return;
          }
        } while (!QLog.isDevelopLevel());
        QLog.i("ScreenShareHandler", 2, "handleScreenShareAnswer() found no error");
        return;
      }
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("QQRTCSvc.screen_share_ask");
      this.allowCmdSet.add("QQRTCSvc.screen_share_answer");
    }
    return this.allowCmdSet;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return ScreenShareObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QQRTCSvc.screen_share_ask".equals(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!"QQRTCSvc.screen_share_answer".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareHandler
 * JD-Core Version:    0.7.0.1
 */