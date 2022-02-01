package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.redtouch.NumRedMsgManager;
import com.tencent.mobileqq.tianshu.pb.NumRedMsg.NumMsgBusi;
import com.tencent.mobileqq.tianshu.pb.NumRedMsg.NumMsgReqBody;
import com.tencent.mobileqq.tianshu.pb.NumRedMsg.NumMsgRspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class NumRedMsgHandler
  extends BusinessHandler
{
  protected QQAppInterface a;
  
  protected NumRedMsgHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    paramFromServiceMsg = (NumRedMsgManager)this.a.getManager(QQManagerFactory.NUMREDMSG_MANAGER);
    if (i != 0)
    {
      NumRedMsg.NumMsgRspBody localNumMsgRspBody = new NumRedMsg.NumMsgRspBody();
      try
      {
        localNumMsgRspBody.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        paramObject.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i("NumRedMsgHandler", 2, "mergeFrom failed");
        }
      }
      if (localNumMsgRspBody.i_retcode.get() == 0)
      {
        paramFromServiceMsg.a(localNumMsgRspBody, paramToServiceMsg, true);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("rsp code != 0 , error msg == ");
        paramObject.append(localNumMsgRspBody.str_errmsg.get());
        QLog.i("NumRedMsgHandler", 2, paramObject.toString());
      }
      paramFromServiceMsg.a(localNumMsgRspBody, paramToServiceMsg, false);
      return;
    }
    paramFromServiceMsg.a(null, paramToServiceMsg, false);
  }
  
  public void a(List<NumRedMsg.NumMsgBusi> paramList, int paramInt, String paramString, long[] paramArrayOfLong)
  {
    NumRedMsg.NumMsgReqBody localNumMsgReqBody = new NumRedMsg.NumMsgReqBody();
    localNumMsgReqBody.i_proto_ver.set(1);
    localNumMsgReqBody.ui_plat_id.set(109);
    localNumMsgReqBody.str_client_ver.set("8.7.0.5295");
    localNumMsgReqBody.ui64_uin.set(Long.parseLong(this.a.getCurrentAccountUin()));
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(paramList);
    localNumMsgReqBody.rpt_num_msg.set(localArrayList);
    paramList = new ToServiceMsg("mobileqq.service", this.a.getCurrentAccountUin(), "red_touch_num_svr.get_num_msg");
    paramList.putWupBuffer(localNumMsgReqBody.toByteArray());
    paramList.extraData.putInt("NumMsgListenerKey", paramInt);
    paramList.extraData.putLongArray("NumMsgIDList", paramArrayOfLong);
    paramList.extraData.putString("NumMsgListenerCmd", paramString);
    sendPbReq(paramList);
    if (QLog.isColorLevel()) {
      QLog.i("NumRedMsgHandler", 2, "sendPbReq called.");
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("red_touch_num_svr.get_num_msg".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("NumRedMsgHandler", 2, "onReceive called.");
      }
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.NumRedMsgHandler
 * JD-Core Version:    0.7.0.1
 */