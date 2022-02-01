package com.tencent.liteav.network;

import android.os.Handler;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.log.TXCLog;
import java.util.Iterator;
import java.util.Vector;

class TXCStreamDownloader$2
  implements g.a
{
  TXCStreamDownloader$2(TXCStreamDownloader paramTXCStreamDownloader, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(int paramInt, String paramString, Vector<e> paramVector)
  {
    if ((paramInt == 0) && (paramVector != null) && (!paramVector.isEmpty()))
    {
      if (TXCStreamDownloader.access$500(this.d))
      {
        if (TXCStreamDownloader.access$600(this.d) != null)
        {
          int i = 0;
          paramString = paramVector.iterator();
          while (paramString.hasNext())
          {
            e locale = (e)paramString.next();
            if ((locale != null) && (locale.b) && (locale.a != null) && (locale.a.length() > 0)) {
              i += 1;
            }
          }
          this.d.setStatusValue(7113, Long.valueOf(i));
          this.d.setStatusValue(7112, Long.valueOf(2L));
          TXCStreamDownloader.access$600(this.d).setOriginUrl(this.a);
          TXCStreamDownloader.access$600(this.d).startDownload(paramVector, true, true, this.b, this.c);
        }
        if (TXCStreamDownloader.access$700(this.d) != null) {
          TXCStreamDownloader.access$700(this.d).postDelayed(TXCStreamDownloader.access$800(this.d), 2000L);
        }
        paramString = TXCStreamDownloader.access$900(this.d).b();
        TXCDRApi.txReportDAU(TXCStreamDownloader.access$1000(this.d), a.at, paramInt, paramString);
        return;
      }
      TXCDRApi.txReportDAU(TXCStreamDownloader.access$1000(this.d), a.at, -4, "livePlayer have been stopped");
      return;
    }
    this.d.onNotifyEvent(-2302, null);
    TXCDRApi.txReportDAU(TXCStreamDownloader.access$1000(this.d), a.at, paramInt, paramString);
    TXCLog.e("TXCStreamDownloader", "getAccelerateStreamPlayUrl failed, play stream with raw url");
    if (TXCStreamDownloader.access$500(this.d))
    {
      TXCStreamDownloader.access$1100(this.d, this.a, this.b);
      if (TXCStreamDownloader.access$700(this.d) != null) {
        TXCStreamDownloader.access$700(this.d).postDelayed(TXCStreamDownloader.access$800(this.d), 2000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.network.TXCStreamDownloader.2
 * JD-Core Version:    0.7.0.1
 */