package com.tencent.gdtad.api.interstitial;

import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ark.open.ArkAppMgr.AppPathInfo;
import com.tencent.gdtad.log.GdtLog;

class GdtArkPreDownloadTask$6$1
  implements Runnable
{
  GdtArkPreDownloadTask$6$1(GdtArkPreDownloadTask.6 param6, ArkAppMgr.AppPathInfo paramAppPathInfo, int paramInt, String paramString) {}
  
  public void run()
  {
    String str1 = null;
    ArkAppMgr.AppPathInfo localAppPathInfo;
    try
    {
      Object localObject = AdJSON.fromObject(this.a);
    }
    catch (Throwable localThrowable)
    {
      GdtLog.b("GdtArkPreDownloadTask", "onGetAppPathByName", localThrowable);
      localAppPathInfo = null;
    }
    int i = this.b;
    int j = 0;
    String str2 = this.c;
    if (localAppPathInfo != null) {
      str1 = localAppPathInfo.toString();
    }
    GdtLog.b("GdtArkPreDownloadTask", String.format("onGetAppPathByName retCode:%d msg:%s appPathInfo:%s", new Object[] { Integer.valueOf(i), str2, str1 }));
    i = this.b;
    if (i == -6) {
      return;
    }
    int k = GdtArkUtil.a(i);
    i = j;
    if (k == 0)
    {
      localAppPathInfo = this.a;
      i = j;
      if (localAppPathInfo != null)
      {
        i = j;
        if (!TextUtils.isEmpty(localAppPathInfo.path))
        {
          i = j;
          if (!TextUtils.isEmpty(GdtArkPreDownloadTask.c(this.d.a))) {
            i = 1;
          }
        }
      }
    }
    j = k;
    if (i == 0)
    {
      j = k;
      if (k == 0) {
        j = 1;
      }
    }
    if (i != 0)
    {
      GdtArkPreDownloadTask.a(this.d.a, 3);
      GdtArkPreDownloadTask.e(this.d.a);
      return;
    }
    GdtArkPreDownloadTask.a(this.d.a, 4);
    GdtArkPreDownloadTask.a(this.d.a, j, this.b, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtArkPreDownloadTask.6.1
 * JD-Core Version:    0.7.0.1
 */