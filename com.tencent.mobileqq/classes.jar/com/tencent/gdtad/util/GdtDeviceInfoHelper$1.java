package com.tencent.gdtad.util;

import com.tencent.ad.tangram.log.AdLog;
import com.tencent.gathererga.core.ILog;

final class GdtDeviceInfoHelper$1
  implements ILog
{
  public void a(String paramString1, String paramString2)
  {
    AdLog.d(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AdLog.w(paramString1, paramString2, paramThrowable);
  }
  
  public void b(String paramString1, String paramString2)
  {
    AdLog.i(paramString1, paramString2);
  }
  
  public void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AdLog.e(paramString1, paramString2, paramThrowable);
  }
  
  public void c(String paramString1, String paramString2)
  {
    AdLog.w(paramString1, paramString2);
  }
  
  public void d(String paramString1, String paramString2)
  {
    AdLog.e(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtDeviceInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */