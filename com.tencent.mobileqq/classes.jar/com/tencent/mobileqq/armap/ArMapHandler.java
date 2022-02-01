package com.tencent.mobileqq.armap;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0x95a.cmd0x95a.GetArActivityRedReq;
import tencent.im.oidb.cmd0x95a.cmd0x95a.GetArActivityRedRsp;
import tencent.im.oidb.cmd0x95a.cmd0x95a.ReqBody;
import tencent.im.oidb.cmd0x95a.cmd0x95a.RspBody;
import tencent.im.oidb.cmd0x95a.cmd0x95a.UpdateArCountRsp;

public class ArMapHandler
  extends BusinessHandler
{
  public ArMapHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reqActRedDotInfo,uin :");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(",actID :");
      ((StringBuilder)localObject).append(paramLong2);
      QLog.d("ArMapHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new cmd0x95a.GetArActivityRedReq();
    ((cmd0x95a.GetArActivityRedReq)localObject).uint64_uin.set(paramLong1);
    ((cmd0x95a.GetArActivityRedReq)localObject).uint64_client_activity_id.set(paramLong2);
    cmd0x95a.ReqBody localReqBody = new cmd0x95a.ReqBody();
    localReqBody.msg_get_ar_activity_red_req.set((MessageMicro)localObject);
    localObject = makeOIDBPkg("OidbSvc.0x95a", 2394, 5, localReqBody.toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("subcmd", 5);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if (paramFromServiceMsg == null) {
      bool = false;
    } else {
      bool = paramFromServiceMsg.isSuccess();
    }
    int k = paramToServiceMsg.extraData.getInt("subcmd", -1);
    int i;
    if (bool)
    {
      cmd0x95a.RspBody localRspBody = new cmd0x95a.RspBody();
      int j = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      paramObject = paramFromServiceMsg.extraData.getString("str_error_msg");
      paramFromServiceMsg = paramObject;
      i = j;
      if (j == 0) {
        if (k != 1)
        {
          if (k != 5)
          {
            paramFromServiceMsg = paramObject;
            i = j;
          }
          else
          {
            a(paramToServiceMsg, bool, j, localRspBody);
            paramFromServiceMsg = paramObject;
            i = j;
          }
        }
        else
        {
          paramFromServiceMsg = paramObject;
          i = j;
          if (localRspBody.msg_update_ar_count_rsp.has())
          {
            paramToServiceMsg = (cmd0x95a.UpdateArCountRsp)localRspBody.msg_update_ar_count_rsp.get();
            long l;
            if (paramToServiceMsg.uint64_uin.has()) {
              l = paramToServiceMsg.uint64_uin.get();
            } else {
              l = -1L;
            }
            paramFromServiceMsg = paramObject;
            i = j;
            if (QLog.isColorLevel())
            {
              paramToServiceMsg = new StringBuilder();
              paramToServiceMsg.append("handle0x95a report scanQRCode result,uin = ");
              paramToServiceMsg.append(l);
              QLog.d("ArMapHandler", 2, paramToServiceMsg.toString());
              paramFromServiceMsg = paramObject;
              i = j;
            }
          }
        }
      }
    }
    else
    {
      paramFromServiceMsg = "";
      i = -1;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handle0x95a errMsg:");
      paramToServiceMsg.append(paramFromServiceMsg);
      paramToServiceMsg.append(",result:");
      paramToServiceMsg.append(i);
      paramToServiceMsg.append(",isSuc:");
      paramToServiceMsg.append(bool);
      paramToServiceMsg.append(",subCmd:");
      paramToServiceMsg.append(k);
      QLog.d("ArMapHandler", 2, paramToServiceMsg.toString());
    }
  }
  
  void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean, int paramInt, cmd0x95a.RspBody paramRspBody)
  {
    if ((paramBoolean) && (paramInt == 0) && (paramRspBody != null))
    {
      if (paramRspBody.msg_get_ar_activity_red_rsp.has()) {
        paramToServiceMsg = (cmd0x95a.GetArActivityRedRsp)paramRspBody.msg_get_ar_activity_red_rsp.get();
      } else {
        paramToServiceMsg = null;
      }
      if (paramToServiceMsg != null)
      {
        boolean bool = paramToServiceMsg.uint64_uin.has();
        long l2 = 0L;
        long l1;
        if (bool) {
          l1 = paramToServiceMsg.uint64_uin.get();
        } else {
          l1 = 0L;
        }
        if (paramToServiceMsg.uint32_red_switch.has()) {
          paramInt = paramToServiceMsg.uint32_red_switch.get();
        } else {
          paramInt = 0;
        }
        if (paramToServiceMsg.uint64_server_activity_id.has()) {
          l2 = paramToServiceMsg.uint64_server_activity_id.get();
        }
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleGetARActRedDotInfo uin:");
          paramToServiceMsg.append(l1);
          paramToServiceMsg.append(",redSwitch:");
          paramToServiceMsg.append(paramInt);
          paramToServiceMsg.append(",actId:");
          paramToServiceMsg.append(l2);
          QLog.d("ArMapHandler", 2, paramToServiceMsg.toString());
        }
        notifyUI(1, paramBoolean, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l2) });
      }
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x95a");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return ArMapObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("onReceive, msgCmdFilter is true,cmd  = ");
          paramToServiceMsg.append(str);
          QLog.d("ArMapHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvc.0x95a".equals(str)) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ArMapHandler
 * JD-Core Version:    0.7.0.1
 */