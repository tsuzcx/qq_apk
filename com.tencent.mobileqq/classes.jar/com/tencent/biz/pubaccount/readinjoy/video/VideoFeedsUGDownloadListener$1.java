package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.HashMap;
import ogc;
import seh;
import sei;

public class VideoFeedsUGDownloadListener$1
  implements Runnable
{
  public VideoFeedsUGDownloadListener$1(seh paramseh, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    sei localsei = (sei)seh.a(this.this$0).get(this.a.e);
    if ((localsei != null) && (!TextUtils.isEmpty(localsei.c)) && (localsei.c.equals(this.a.d)))
    {
      ogc.a(ogc.b(localsei.a, "11", localsei.b));
      ogc.a(ogc.b(localsei.a, "20", localsei.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */