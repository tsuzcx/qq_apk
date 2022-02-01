package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.HashMap;
import ohk;
import rvl;
import rvm;

public class VideoFeedsUGDownloadListener$1
  implements Runnable
{
  public VideoFeedsUGDownloadListener$1(rvl paramrvl, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    rvm localrvm = (rvm)rvl.a(this.this$0).get(this.a.e);
    if ((localrvm != null) && (!TextUtils.isEmpty(localrvm.c)) && (localrvm.c.equals(this.a.d)))
    {
      ohk.a(ohk.b(localrvm.a, "11", localrvm.b));
      ohk.a(ohk.b(localrvm.a, "20", localrvm.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGDownloadListener.1
 * JD-Core Version:    0.7.0.1
 */