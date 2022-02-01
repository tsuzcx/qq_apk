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
    localReqScreenShareAsk.to_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().c));
    localReqScreenShareAsk.is_online.set(true);
    Object localObject = createToServiceMsg("QQRTCSvc.screen_share_ask");
    ((ToServiceMsg)localObject).putWupBuffer(localReqScreenShareAsk.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("askScreenShare, from ");
    ((StringBuilder)localObject).append(localReqScreenShareAsk.from_uin.get());
    ((StringBuilder)localObject).append(" , to ");
    ((StringBuilder)localObject).append(localReqScreenShareAsk.to_uin.get());
    QLog.i("ScreenShareHandler", 4, ((StringBuilder)localObject).toString());
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("askScreenShare, from ");
      ((StringBuilder)localObject).append(localReqScreenShareAsk.from_uin);
      ((StringBuilder)localObject).append(" , to ");
      ((StringBuilder)localObject).append(localReqScreenShareAsk.to_uin);
      QLog.i("ScreenShareHandler", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    paramToServiceMsg = null;
    int j = i;
    if (i != 0)
    {
      paramFromServiceMsg = new ReqGroupVideo.RspScreenShareAsk();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramObject = new StringBuilder();
        paramObject.append("handleScreenShareAsk(): ");
        paramObject.append(paramToServiceMsg);
        QLog.e("ScreenShareHandler", 1, paramObject.toString());
        i = 0;
      }
      paramToServiceMsg = paramFromServiceMsg;
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.i("ScreenShareHandler", 2, "handleScreenShareAsk receive success");
        j = i;
        paramToServiceMsg = paramFromServiceMsg;
      }
    }
    if (j == 0)
    {
      QLog.e("ScreenShareHandler", 2, "handleScreenShareAsk() failed");
      return;
    }
    paramToServiceMsg = (common.ErrorInfo)paramToServiceMsg.result.get();
    int i = MessageHandler.a(paramToServiceMsg);
    paramToServiceMsg = MessageHandler.a(paramToServiceMsg);
    if ((i != -99) && (i != 0))
    {
      new Handler(Looper.getMainLooper()).post(new ScreenShareHandler.1(this, paramToServiceMsg));
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleScreenShareAsk() error code: %d");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append("error msg: ");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.e("ScreenShareHandler", 2, paramFromServiceMsg.toString());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ScreenShareHandler", 2, "handleScreenShareAsk() found no error");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ReqGroupVideo.ReqScreenShareAnswer localReqScreenShareAnswer = new ReqGroupVideo.ReqScreenShareAnswer();
    localReqScreenShareAnswer.from_uin.set(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getLongAccountUin());
    localReqScreenShareAnswer.to_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().c));
    localReqScreenShareAnswer.is_accept.set(paramBoolean);
    Object localObject = createToServiceMsg("QQRTCSvc.screen_share_answer");
    ((ToServiceMsg)localObject).putWupBuffer(localReqScreenShareAnswer.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("answerScreenShare, from ");
      ((StringBuilder)localObject).append(localReqScreenShareAnswer.from_uin);
      ((StringBuilder)localObject).append(", to ");
      ((StringBuilder)localObject).append(localReqScreenShareAnswer.to_uin);
      ((StringBuilder)localObject).append(", isAccept: ");
      ((StringBuilder)localObject).append(localReqScreenShareAnswer.is_accept);
      QLog.i("ScreenShareHandler", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    paramToServiceMsg = null;
    int j = i;
    if (i != 0)
    {
      paramFromServiceMsg = new ReqGroupVideo.RspScreenShareAnswer();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramObject = new StringBuilder();
        paramObject.append("handleScreenShareAnswer(): ");
        paramObject.append(paramToServiceMsg);
        QLog.e("ScreenShareHandler", 1, paramObject.toString());
        i = 0;
      }
      paramToServiceMsg = paramFromServiceMsg;
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.i("ScreenShareHandler", 2, "handleScreenShareAnswer receive success");
        j = i;
        paramToServiceMsg = paramFromServiceMsg;
      }
    }
    if (j == 0)
    {
      QLog.e("ScreenShareHandler", 2, "handleScreenShareAnswer() failed");
      return;
    }
    paramToServiceMsg = (common.ErrorInfo)paramToServiceMsg.result.get();
    int i = MessageHandler.a(paramToServiceMsg);
    paramToServiceMsg = MessageHandler.a(paramToServiceMsg);
    if (i != -99)
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleScreenShareAnswer() error code: %d");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append("error msg: ");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.e("ScreenShareHandler", 2, paramFromServiceMsg.toString());
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("ScreenShareHandler", 2, "handleScreenShareAnswer() found no error");
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
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return ScreenShareObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QQRTCSvc.screen_share_ask".equals(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("QQRTCSvc.screen_share_answer".equals(paramFromServiceMsg.getServiceCmd())) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareHandler
 * JD-Core Version:    0.7.0.1
 */