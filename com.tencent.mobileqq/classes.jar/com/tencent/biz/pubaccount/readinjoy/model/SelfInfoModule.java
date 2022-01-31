package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import lrj;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.FollowCountInfo;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.LimitInfo;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.ReqBody;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.RspBody;

public class SelfInfoModule
  extends ReadInJoyEngineModule
{
  public SelfInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    if (QLog.isColorLevel()) {
      QLog.d("SelfInfoModule", 2, "construct!");
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("SelfInfoModule", 2, "handle0x97bGetFollowAndFansCount!");
    }
    paramToServiceMsg = new oidb_cmd0x97b.RspBody();
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    int k = ((oidb_cmd0x97b.FollowCountInfo)paramToServiceMsg.msg_follow_count_info.get()).uint32_my_follow_count.get();
    int m = ((oidb_cmd0x97b.FollowCountInfo)paramToServiceMsg.msg_follow_count_info.get()).uint32_my_fans_count.get();
    if ((paramToServiceMsg.msg_limit_info.has()) && (((oidb_cmd0x97b.LimitInfo)paramToServiceMsg.msg_limit_info.get()).uint32_forbidden_flag.has())) {}
    for (int i = ((oidb_cmd0x97b.LimitInfo)paramToServiceMsg.msg_limit_info.get()).uint32_forbidden_flag.get();; i = 0)
    {
      if (i == 1) {
        bool = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelfInfoModule", 1, "handle0x97bGetFollowAndFansCount result=" + j + ", followCnt=" + k + ", fansCnt=" + m + ", isForbidden=" + bool);
      }
      this.a.post(new lrj(this, j, k, m, bool));
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelfInfoModule", 2, "onReceive response cmd=" + paramFromServiceMsg.getServiceCmd());
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x97b")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelfInfoModule", 2, "getSelfFollowAndFansCount uin=" + paramString);
    }
    oidb_cmd0x97b.ReqBody localReqBody = new oidb_cmd0x97b.ReqBody();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (Exception paramString)
    {
      label51:
      break label51;
    }
    localReqBody.uint64_uin.set(l1);
    a(ReadInJoyOidbHelper.a("OidbSvc.0x97b", 2427, 1, localReqBody.toByteArray()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SelfInfoModule
 * JD-Core Version:    0.7.0.1
 */