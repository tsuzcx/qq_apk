package com.tencent.biz.pubaccount.util.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IPAReportUtil
  extends QRouteApi
{
  public abstract void reportAdMsgArriveReceipt(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List<String> paramList);
  
  public abstract void reportAdMsgRead(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, List<String> paramList1, List<String> paramList2, List<String> paramList3);
  
  public abstract void reportClickEventForAdver(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.IPAReportUtil
 * JD-Core Version:    0.7.0.1
 */