package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;

final class TVKPreloader$1
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  public void onComplete(String arg1, String paramString2)
  {
    synchronized ()
    {
      paramString2 = TVKPreloader.a();
      TVKPreloader.a().post(new TVKPreloader.1.1(this, paramString2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.1
 * JD-Core Version:    0.7.0.1
 */