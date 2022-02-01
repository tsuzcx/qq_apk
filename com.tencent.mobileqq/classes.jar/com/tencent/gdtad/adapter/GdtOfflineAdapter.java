package com.tencent.gdtad.adapter;

import android.os.Looper;
import com.tencent.ad.tangram.offline.AdOfflineAdapter;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.qqproxy.GdtVersionUtil;

public final class GdtOfflineAdapter
  implements AdOfflineAdapter
{
  public String getAppVersion()
  {
    return GdtVersionUtil.a();
  }
  
  public String getVersionIfExists(String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      GdtLog.d("GdtOfflineAdapter", "getVersionIfExists error");
      return null;
    }
    return HtmlOffline.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtOfflineAdapter
 * JD-Core Version:    0.7.0.1
 */