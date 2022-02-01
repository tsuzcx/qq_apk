package com.tencent.mobileqq.ark.multiproc;

import com.tencent.ark.ArkEnvironmentManager.IDataReport;
import com.tencent.ark.open.ArkAppReport;

final class ArkMultiProcUtil$4
  implements ArkEnvironmentManager.IDataReport
{
  public void report(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString3, String paramString4)
  {
    ArkAppReport.platformEventReport(paramString1, paramString2, paramInt2, paramInt1, paramInt3, paramLong1, paramLong2, paramString3, paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil.4
 * JD-Core Version:    0.7.0.1
 */