package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import nwh;
import rit;
import riu;

public class VideoFeedsUGDownloadListener$2
  implements Runnable
{
  public VideoFeedsUGDownloadListener$2(rit paramrit, String paramString) {}
  
  public void run()
  {
    riu localriu = (riu)rit.a(this.this$0).get(this.a);
    if (localriu != null)
    {
      nwh.a(nwh.b(localriu.a, "19", localriu.b));
      Intent localIntent = BaseApplicationImpl.getContext().getPackageManager().getLaunchIntentForPackage(this.a);
      if (localIntent != null)
      {
        localIntent.setFlags(268435456);
        localIntent.putExtra("big_brother_source_key", "biz_src_kandian_videos");
        BaseApplicationImpl.getContext().startActivity(localIntent);
        nwh.a(nwh.b(localriu.a, "106", localriu.b));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGDownloadListener.2
 * JD-Core Version:    0.7.0.1
 */