package com.tencent.mobileqq.ark;

import com.tencent.ark.ArkEnvironmentManager.IDataReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

final class ArkAppCenter$7
  implements ArkEnvironmentManager.IDataReport
{
  public void report(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString3, String paramString4)
  {
    QQAppInterface localQQAppInterface = null;
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)localAppRuntime;
    }
    ArkAppDataReport.a(localQQAppInterface, paramString1, paramString2, paramInt2, paramInt1, paramInt3, paramLong1, paramLong2, paramString3, paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCenter.7
 * JD-Core Version:    0.7.0.1
 */