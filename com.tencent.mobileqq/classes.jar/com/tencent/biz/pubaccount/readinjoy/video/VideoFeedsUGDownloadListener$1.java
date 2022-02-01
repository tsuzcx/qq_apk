package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.KandianUGStatisticUtils;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.HashMap;

class VideoFeedsUGDownloadListener$1
  implements Runnable
{
  VideoFeedsUGDownloadListener$1(VideoFeedsUGDownloadListener paramVideoFeedsUGDownloadListener, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    VideoFeedsUGDownloadListener.UGClickData localUGClickData = (VideoFeedsUGDownloadListener.UGClickData)VideoFeedsUGDownloadListener.a(this.this$0).get(this.a.e);
    if ((localUGClickData != null) && (!TextUtils.isEmpty(localUGClickData.c)) && (localUGClickData.c.equals(this.a.d)))
    {
      KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(localUGClickData.a, "11", localUGClickData.b));
      KandianUGStatisticUtils.a(KandianUGStatisticUtils.b(localUGClickData.a, "20", localUGClickData.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */