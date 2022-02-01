package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspReportEvil;

public class ReportEvilResponse
  extends BaseResponse
{
  public ReportEvilResponse(qqstory_service.RspReportEvil paramRspReportEvil)
  {
    super(paramRspReportEvil.result);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.ReportEvilResponse
 * JD-Core Version:    0.7.0.1
 */