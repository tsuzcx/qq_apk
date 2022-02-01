package com.tencent.comic;

import com.tencent.qphone.base.util.QLog;
import com.tencent.webbundle.sdk.WebBundleManager;

final class VipComicHelper$2
  implements Runnable
{
  public void run()
  {
    WebBundleManager.getInstance("comic").destroy();
    QLog.d("WebBundle.Comic", 2, "WebBundleManager destroy cause setWebBundleOption");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.VipComicHelper.2
 * JD-Core Version:    0.7.0.1
 */