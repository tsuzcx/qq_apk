package com.tencent.mobileqq.apollo.statistics.product.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import java.util.ArrayList;
import java.util.Map;

public class ApolloDtReportHelperImpl
  implements IApolloDtReportHelper
{
  public void apolloCmEmojiSendReport(ArrayList paramArrayList, AppInterface paramAppInterface, int paramInt)
  {
    ApolloDtReportUtil.a(paramArrayList, paramAppInterface, paramInt);
  }
  
  public int getApolloMode(AppInterface paramAppInterface)
  {
    return ApolloDtReportUtil.a(paramAppInterface);
  }
  
  public int getReportSessionType(int paramInt)
  {
    return ApolloDtReportUtil.a(paramInt);
  }
  
  public int getUserStatus(AppInterface paramAppInterface)
  {
    return ApolloDtReportUtil.b(paramAppInterface);
  }
  
  public void report(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    ApolloDtReportUtil.a(paramString1, paramString2, paramString3, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.api.impl.ApolloDtReportHelperImpl
 * JD-Core Version:    0.7.0.1
 */