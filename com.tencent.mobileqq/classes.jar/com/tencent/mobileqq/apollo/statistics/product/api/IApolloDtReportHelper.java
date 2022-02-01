package com.tencent.mobileqq.apollo.statistics.product.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.Map;

@QAPI(process={"all"})
public abstract interface IApolloDtReportHelper
  extends QRouteApi
{
  public abstract void apolloCmEmojiSendReport(ArrayList paramArrayList, AppInterface paramAppInterface, int paramInt);
  
  public abstract int getApolloMode(AppInterface paramAppInterface);
  
  public abstract int getReportSessionType(int paramInt);
  
  public abstract int getUserStatus(AppInterface paramAppInterface);
  
  public abstract void report(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper
 * JD-Core Version:    0.7.0.1
 */