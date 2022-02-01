package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.HashMap;
import oix;
import scp;
import scq;

public class VideoFeedsUGDownloadListener$1
  implements Runnable
{
  public VideoFeedsUGDownloadListener$1(scp paramscp, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    scq localscq = (scq)scp.a(this.this$0).get(this.a.e);
    if ((localscq != null) && (!TextUtils.isEmpty(localscq.c)) && (localscq.c.equals(this.a.d)))
    {
      oix.a(oix.b(localscq.a, "11", localscq.b));
      oix.a(oix.b(localscq.a, "20", localscq.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */