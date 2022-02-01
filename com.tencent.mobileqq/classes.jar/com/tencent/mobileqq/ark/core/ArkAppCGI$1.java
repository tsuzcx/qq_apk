package com.tencent.mobileqq.ark.core;

import com.tencent.mobileqq.ark.delegate.IHTTPDownloadCallback;
import com.tencent.qphone.base.util.QLog;

class ArkAppCGI$1
  implements IHTTPDownloadCallback
{
  ArkAppCGI$1(ArkAppCGI paramArkAppCGI, ArkAppCGI.QueryTask paramQueryTask) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramInt != 0)
    {
      QLog.i("ArkApp.ArkAppCGI", 1, String.format("download fail, url=%s, err=%d", new Object[] { this.a.a, Integer.valueOf(paramInt) }));
      ArkAppCGI.a(this.b, this.a, false, null);
      return;
    }
    ArkAppCGI.a(this.b, this.a, true, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkAppCGI.1
 * JD-Core Version:    0.7.0.1
 */