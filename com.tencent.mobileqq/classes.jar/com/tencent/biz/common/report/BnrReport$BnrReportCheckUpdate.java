package com.tencent.biz.common.report;

import KQQ.ReqItem;
import KQQ.RespItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bnr.BnrReport.BNRConfigMsg;
import com.tencent.mobileqq.bnr.BnrReport.BNReportConfigRsp;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;

public class BnrReport$BnrReportCheckUpdate
  implements CheckUpdateItemInterface
{
  private QQAppInterface a;
  
  public BnrReport$BnrReportCheckUpdate(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    BnrReport.a();
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BnrReport", 2, "getCheckUpdateItemData");
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.cOperType = 1;
    localReqItem.eServiceID = 118;
    BnrReport.BNRConfigMsg localBNRConfigMsg = BnrReport.a(this.a.getCurrentAccountUin());
    if (localBNRConfigMsg != null) {
      localReqItem.vecParam = WupUtil.a(localBNRConfigMsg.toByteArray());
    }
    BnrReport.a = true;
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BnrReport", 2, "handleCheckUpdateItemData");
    }
    BnrReport.BNRConfigMsg localBNRConfigMsg;
    if (paramRespItem.cResult == 2) {
      if (paramRespItem.eServiceID == 118)
      {
        paramRespItem = WupUtil.b(paramRespItem.vecUpdate);
        if (paramRespItem != null) {
          localBNRConfigMsg = new BnrReport.BNRConfigMsg();
        }
      }
    }
    for (;;)
    {
      try
      {
        localBNRConfigMsg.mergeFrom(paramRespItem);
        BnrReport.a((BnrReport.BNReportConfigRsp)localBNRConfigMsg.msg_rsp_body.get());
        BnrReport.a(this.a, 74);
        BnrReport.a = false;
        return;
      }
      catch (InvalidProtocolBufferMicroException paramRespItem)
      {
        paramRespItem.printStackTrace();
        continue;
      }
      catch (Exception paramRespItem)
      {
        paramRespItem.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BnrReport", 2, "***handleCheckUpdateItemData fail respitem.cResult:" + paramRespItem.cResult);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.report.BnrReport.BnrReportCheckUpdate
 * JD-Core Version:    0.7.0.1
 */