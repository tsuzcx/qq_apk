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
    BnrReport.b = true;
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BnrReport", 2, "handleCheckUpdateItemData");
    }
    Object localObject;
    if (paramRespItem.cResult == 2)
    {
      if (paramRespItem.eServiceID == 118)
      {
        paramRespItem = WupUtil.b(paramRespItem.vecUpdate);
        if (paramRespItem != null)
        {
          localObject = new BnrReport.BNRConfigMsg();
          try
          {
            ((BnrReport.BNRConfigMsg)localObject).mergeFrom(paramRespItem);
            BnrReport.a((BnrReport.BNReportConfigRsp)((BnrReport.BNRConfigMsg)localObject).msg_rsp_body.get());
            BnrReport.a(this.a, 74);
          }
          catch (Exception paramRespItem)
          {
            paramRespItem.printStackTrace();
          }
          catch (InvalidProtocolBufferMicroException paramRespItem)
          {
            paramRespItem.printStackTrace();
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("***handleCheckUpdateItemData fail respitem.cResult:");
      ((StringBuilder)localObject).append(paramRespItem.cResult);
      QLog.d("BnrReport", 2, ((StringBuilder)localObject).toString());
    }
    BnrReport.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.report.BnrReport.BnrReportCheckUpdate
 * JD-Core Version:    0.7.0.1
 */