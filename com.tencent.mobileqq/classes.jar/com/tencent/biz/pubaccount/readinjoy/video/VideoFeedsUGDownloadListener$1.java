package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.HashMap;
import nwh;
import rit;
import riu;

public class VideoFeedsUGDownloadListener$1
  implements Runnable
{
  public VideoFeedsUGDownloadListener$1(rit paramrit, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    riu localriu = (riu)rit.a(this.this$0).get(this.a.e);
    if ((localriu != null) && (!TextUtils.isEmpty(localriu.c)) && (localriu.c.equals(this.a.d)))
    {
      nwh.a(nwh.b(localriu.a, "11", localriu.b));
      nwh.a(nwh.b(localriu.a, "20", localriu.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */