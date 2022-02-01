package com.tencent.ad.tangram.net;

import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;

final class AdNet$1
  implements Runnable
{
  public void run()
  {
    String str2 = AdNet.access$000();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = AdNet.access$000();
    }
    if (!TextUtils.isEmpty(str1))
    {
      AdNet.access$102(str1);
      AdNet.access$202(System.currentTimeMillis());
      AdLog.i("AdNet", String.format("updateIpV4Address address:%s timeStamp:%d", new Object[] { AdNet.access$100(), Long.valueOf(AdNet.access$200()) }));
    }
    AdNet.access$300(3600000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.net.AdNet.1
 * JD-Core Version:    0.7.0.1
 */