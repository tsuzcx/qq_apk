package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;

class DataMigrationService$2
  extends WtloginListener
{
  DataMigrationService$2(DataMigrationService paramDataMigrationService, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, WtloginHelper paramWtloginHelper) {}
  
  public void OnException(ErrMsg paramErrMsg, int paramInt, WUserSigInfo paramWUserSigInfo)
  {
    if (QLog.isColorLevel())
    {
      paramWUserSigInfo = new StringBuilder();
      paramWUserSigInfo.append("sendActionAfterGetTicket| OnException=");
      paramWUserSigInfo.append(paramErrMsg);
      paramWUserSigInfo.append(", cmd=");
      paramWUserSigInfo.append(paramInt);
      QLog.d("DataMigrationService", 2, paramWUserSigInfo.toString());
    }
    DataMigrationService.a(this.g, this.a, this.b, this.c, this.d, null, this.e);
  }
  
  public void onGetA1WithA1(String paramString, long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, int paramInt2, ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("sendActionAfterGetTicket| onGetA1WithA1 ret=");
      paramArrayOfByte1.append(paramInt2);
      QLog.d("DataMigrationService", 2, paramArrayOfByte1.toString());
    }
    if (paramInt2 != 0)
    {
      DataMigrationService.a(this.g, this.a, this.b, this.c, this.d, null, this.e);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DataMigrationService", 2, "sendActionAfterGetTicket| send action");
    }
    paramString = this.f.PrepareQloginResult(paramString, paramLong4, paramLong5, paramInt2, paramWFastLoginInfo);
    DataMigrationService.a(this.g, this.a, this.b, this.c, this.d, paramString, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataMigrationService.2
 * JD-Core Version:    0.7.0.1
 */