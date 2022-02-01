package com.tencent.biz.qqcircle.requests;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.SingleDcData;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.StDataReportReq;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.StDataReportRsp;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.List;

public class CommandReportRequest
  extends VSBaseRequest
{
  private final APP_REPORT_TRANSFER.StDataReportReq mReq = new APP_REPORT_TRANSFER.StDataReportReq();
  
  public CommandReportRequest(List<APP_REPORT_TRANSFER.SingleDcData> paramList)
  {
    this.mReq.dcdata.set(paramList);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    APP_REPORT_TRANSFER.StDataReportRsp localStDataReportRsp = new APP_REPORT_TRANSFER.StDataReportRsp();
    localStDataReportRsp.mergeFrom(paramArrayOfByte);
    return localStDataReportRsp;
  }
  
  public String getCmdName()
  {
    return "MobileQQReport.mini_app_report_transfer.DataReport";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.CommandReportRequest
 * JD-Core Version:    0.7.0.1
 */