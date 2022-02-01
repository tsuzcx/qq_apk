package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;

final class TVKPreloader$2
  implements TVK_ICacheMgr.IPreloadCallback
{
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    synchronized ()
    {
      TVKPreloader.PreloadItem localPreloadItem = TVKPreloader.d();
      TVKPreloader.f().post(new TVKPreloader.2.2(this, localPreloadItem, paramString1, paramInt, paramString2));
      return;
    }
  }
  
  public void onPreLoadSucess(String arg1, String paramString2)
  {
    synchronized ()
    {
      paramString2 = TVKPreloader.d();
      TVKPreloader.f().post(new TVKPreloader.2.1(this, paramString2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.2
 * JD-Core Version:    0.7.0.1
 */