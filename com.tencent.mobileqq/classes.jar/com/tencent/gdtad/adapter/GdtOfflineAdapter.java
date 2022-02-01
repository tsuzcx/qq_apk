package com.tencent.gdtad.adapter;

import android.os.Looper;
import com.tencent.ad.tangram.offline.AdOfflineAdapter;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.gdtad.log.GdtLog;

public final class GdtOfflineAdapter
  implements AdOfflineAdapter
{
  public String getVersionIfExists(String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      GdtLog.d("GdtOfflineAdapter", "getVersionIfExists error");
      return null;
    }
    return HtmlOffline.d(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtOfflineAdapter
 * JD-Core Version:    0.7.0.1
 */