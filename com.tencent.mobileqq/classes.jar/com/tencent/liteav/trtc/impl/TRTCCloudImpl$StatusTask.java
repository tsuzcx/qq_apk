package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.h;
import java.lang.ref.WeakReference;

class TRTCCloudImpl$StatusTask
  implements Runnable
{
  private WeakReference<TRTCCloudImpl> mTRTCEngine;
  
  TRTCCloudImpl$StatusTask(TRTCCloudImpl paramTRTCCloudImpl)
  {
    this.mTRTCEngine = new WeakReference(paramTRTCCloudImpl);
  }
  
  public void run()
  {
    TRTCCloudImpl localTRTCCloudImpl = (TRTCCloudImpl)this.mTRTCEngine.get();
    if (localTRTCCloudImpl == null) {
      return;
    }
    int j = h.e(localTRTCCloudImpl.mContext);
    int[] arrayOfInt = h.a();
    int i = h.b();
    TXCStatus.a("18446744073709551615", 11006, Integer.valueOf(j));
    TXCStatus.a("18446744073709551615", 11001, Integer.valueOf(arrayOfInt[0] / 10));
    TXCStatus.a("18446744073709551615", 11002, Integer.valueOf(arrayOfInt[1] / 10));
    TXCStatus.a("18446744073709551615", 11003, Integer.valueOf(i * 1024));
    if (h.a(localTRTCCloudImpl.mContext))
    {
      TXCStatus.a("18446744073709551615", 11004, Integer.valueOf(1));
      i = 1;
    }
    else
    {
      TXCStatus.a("18446744073709551615", 11004, Integer.valueOf(0));
      i = 0;
    }
    if (TRTCCloudImpl.access$10500(localTRTCCloudImpl) != j)
    {
      if ((TRTCCloudImpl.access$10500(localTRTCCloudImpl) >= 0) && (j > 0)) {
        TRTCCloudImpl.access$10600(localTRTCCloudImpl, localTRTCCloudImpl.mNativeRtcContext, 100);
      }
      long l;
      if (j == 0) {
        l = 0L;
      } else {
        l = j;
      }
      TXCEventRecorderProxy.a("18446744073709551615", 1003, l, -1L, "", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.format("network switch from:%d to %d", new Object[] { Integer.valueOf(TRTCCloudImpl.access$10500(localTRTCCloudImpl)), Integer.valueOf(j) }));
      localStringBuilder.append(" self:");
      localStringBuilder.append(localTRTCCloudImpl.hashCode());
      Monitor.a(2, localStringBuilder.toString(), "1:wifi/2:4G/3:3G/4:2G/5:Cable", 0);
      TRTCCloudImpl.access$10502(localTRTCCloudImpl, j);
      TXCKeyPointReportProxy.a(40039, j, 0);
    }
    if (TRTCCloudImpl.access$10700(localTRTCCloudImpl) != i)
    {
      TXCEventRecorderProxy.a("18446744073709551615", 2001, i, -1L, "", 0);
      TRTCCloudImpl.access$10702(localTRTCCloudImpl, i);
      if (i == 0) {
        localTRTCCloudImpl.apiOnlineLog("onAppDidBecomeActive");
      } else {
        localTRTCCloudImpl.apiOnlineLog("onAppEnterBackground");
      }
      TXCKeyPointReportProxy.c(50001, i);
    }
    TXCKeyPointReportProxy.a(arrayOfInt[0] / 10, arrayOfInt[1] / 10);
    TXCKeyPointReportProxy.a();
    TRTCCloudImpl.access$10800(localTRTCCloudImpl);
    localTRTCCloudImpl.checkDashBoard();
    TRTCCloudImpl.access$10900(localTRTCCloudImpl);
    localTRTCCloudImpl.startCollectStatus();
    if (TRTCCloudImpl.access$3400(localTRTCCloudImpl) != 0) {
      TRTCCloudImpl.access$2200(localTRTCCloudImpl).checkOrientation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.StatusTask
 * JD-Core Version:    0.7.0.1
 */