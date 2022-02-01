package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xef9.oidb_cmd0xef9.PrivilegeReqBody;
import tencent.im.oidb.cmd0xef9.oidb_cmd0xef9.PrivilegeRspBody;
import tencent.im.oidb.cmd0xef9.oidb_cmd0xef9.ReqBody;
import tencent.im.oidb.cmd0xef9.oidb_cmd0xef9.RspBody;

public class RIJUserLevelRequestModule
  extends ReadInJoyEngineModule
{
  public RIJUserLevelRequestModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private void a(oidb_cmd0xef9.PrivilegeRspBody paramPrivilegeRspBody, long paramLong, int paramInt)
  {
    ThreadManager.a().post(new RIJUserLevelRequestModule.1(this, paramPrivilegeRspBody, paramLong, paramInt));
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xef9.RspBody localRspBody = new oidb_cmd0xef9.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    QLog.d("RIJUserLevelRequestModule", 1, "handleUserLevel, result=" + i);
    if ((i == 0) && (localRspBody.privilege_rsp.has()) && (localRspBody.privilege_rsp.get() != null))
    {
      paramFromServiceMsg = (oidb_cmd0xef9.PrivilegeRspBody)localRspBody.privilege_rsp.get();
      paramObject = paramToServiceMsg.getAttribute("ope_user_info_uin", null);
      paramToServiceMsg = paramToServiceMsg.getAttribute("ope_user_info_type", null);
      if ((paramObject != null) && (paramToServiceMsg != null))
      {
        a(paramFromServiceMsg, ((Long)paramObject).longValue(), ((Integer)paramToServiceMsg).intValue());
        QLog.d("RIJUserLevelRequestModule", 1, "handleUserLevel, update data! uin=" + paramObject + " operType=" + paramToServiceMsg);
      }
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    QLog.d("RIJUserLevelRequestModule", 1, "requestIconRefreshInfo ,uin=" + paramLong + " operType=" + paramInt);
    Object localObject = new oidb_cmd0xef9.ReqBody();
    oidb_cmd0xef9.PrivilegeReqBody localPrivilegeReqBody = new oidb_cmd0xef9.PrivilegeReqBody();
    localPrivilegeReqBody.uin.set(paramLong);
    localPrivilegeReqBody.oper_type.set(paramInt);
    ((oidb_cmd0xef9.ReqBody)localObject).privilege_req.set(localPrivilegeReqBody);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0xef9", 3833, 1, ((oidb_cmd0xef9.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("ope_user_info_uin", Long.valueOf(paramLong));
    ((ToServiceMsg)localObject).addAttribute("ope_user_info_type", Integer.valueOf(paramInt));
    a((ToServiceMsg)localObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xef9")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelRequestModule
 * JD-Core Version:    0.7.0.1
 */