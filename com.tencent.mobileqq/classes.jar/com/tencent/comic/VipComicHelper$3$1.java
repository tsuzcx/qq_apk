package com.tencent.comic;

import com.tencent.webbundle.sdk.WebBundleManager;

class VipComicHelper$3$1
  implements Runnable
{
  VipComicHelper$3$1(VipComicHelper.3 param3) {}
  
  public void run()
  {
    WebBundleManager.getInstance("comic").destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.VipComicHelper.3.1
 * JD-Core Version:    0.7.0.1
 */