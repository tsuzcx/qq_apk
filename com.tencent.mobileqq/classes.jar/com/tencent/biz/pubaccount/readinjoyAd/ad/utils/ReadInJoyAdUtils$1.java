package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GameLoadData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;

final class ReadInJoyAdUtils$1
  implements Runnable
{
  public void run()
  {
    boolean bool = ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).isWebProcessExist();
    Object localObject = ReadinjoyAdCache.b(2);
    if ((localObject != null) && ((localObject instanceof GameLoadData))) {
      ((GameLoadData)localObject).g = bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils.1
 * JD-Core Version:    0.7.0.1
 */