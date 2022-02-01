package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.HashMap;
import oqt;
import sot;
import sou;

public class VideoFeedsUGDownloadListener$1
  implements Runnable
{
  public VideoFeedsUGDownloadListener$1(sot paramsot, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    sou localsou = (sou)sot.a(this.this$0).get(this.a.e);
    if ((localsou != null) && (!TextUtils.isEmpty(localsou.c)) && (localsou.c.equals(this.a.d)))
    {
      oqt.a(oqt.b(localsou.a, "11", localsou.b));
      oqt.a(oqt.b(localsou.a, "20", localsou.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */