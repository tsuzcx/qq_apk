package com.tencent.biz.pubaccount.readinjoy.engine;

import absm;
import ayzl;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;

class KandianDailyManager$3
  implements Runnable
{
  KandianDailyManager$3(KandianDailyManager paramKandianDailyManager) {}
  
  public void run()
  {
    Object localObject = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
    ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).peer_uin.set(2171946401L);
    ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject).last_read_time.set((int)NetConnInfoCenter.getServerTime());
    msg_svc.PbC2CReadedReportReq localPbC2CReadedReportReq = new msg_svc.PbC2CReadedReportReq();
    localPbC2CReadedReportReq.pair_info.add((MessageMicro)localObject);
    localObject = this.this$0.a.a().a().a();
    if (localObject != null) {
      localPbC2CReadedReportReq.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject));
    }
    localObject = new msg_svc.PbMsgReadedReportReq();
    ((msg_svc.PbMsgReadedReportReq)localObject).c2c_read_report.set(localPbC2CReadedReportReq);
    this.this$0.a.a().a("c2c_processor").a((msg_svc.PbMsgReadedReportReq)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager.3
 * JD-Core Version:    0.7.0.1
 */