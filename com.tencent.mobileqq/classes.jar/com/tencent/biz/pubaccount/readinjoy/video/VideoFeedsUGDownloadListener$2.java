package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import ohk;
import rvl;
import rvm;

public class VideoFeedsUGDownloadListener$2
  implements Runnable
{
  public VideoFeedsUGDownloadListener$2(rvl paramrvl, String paramString) {}
  
  public void run()
  {
    rvm localrvm = (rvm)rvl.a(this.this$0).get(this.a);
    if (localrvm != null)
    {
      ohk.a(ohk.b(localrvm.a, "19", localrvm.b));
      Intent localIntent = BaseApplicationImpl.getContext().getPackageManager().getLaunchIntentForPackage(this.a);
      if (localIntent != null)
      {
        localIntent.setFlags(268435456);
        localIntent.putExtra("big_brother_source_key", "biz_src_kandian_videos");
        BaseApplicationImpl.getContext().startActivity(localIntent);
        ohk.a(ohk.b(localrvm.a, "106", localrvm.b));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGDownloadListener.2
 * JD-Core Version:    0.7.0.1
 */