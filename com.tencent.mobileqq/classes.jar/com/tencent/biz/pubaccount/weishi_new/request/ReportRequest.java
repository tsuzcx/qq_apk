package com.tencent.biz.pubaccount.weishi_new.request;

import UserGrowth.stReportItem;
import UserGrowth.stWeishiReportReq;
import UserGrowth.stWeishiReportRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import java.util.ArrayList;

public class ReportRequest
  extends WeishiRequest<stWeishiReportRsp>
{
  public ReportRequest(ArrayList<stReportItem> paramArrayList)
  {
    super("WeishiReport");
    this.a = new stWeishiReportReq(paramArrayList);
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.request.ReportRequest
 * JD-Core Version:    0.7.0.1
 */