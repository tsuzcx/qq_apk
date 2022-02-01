package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Intent;
import android.content.pm.PackageManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import oix;
import scp;
import scq;

public class VideoFeedsUGDownloadListener$2
  implements Runnable
{
  public VideoFeedsUGDownloadListener$2(scp paramscp, String paramString) {}
  
  public void run()
  {
    scq localscq = (scq)scp.a(this.this$0).get(this.a);
    if (localscq != null)
    {
      oix.a(oix.b(localscq.a, "19", localscq.b));
      Intent localIntent = BaseApplicationImpl.getContext().getPackageManager().getLaunchIntentForPackage(this.a);
      if (localIntent != null)
      {
        localIntent.setFlags(268435456);
        localIntent.putExtra("big_brother_source_key", "biz_src_kandian_videos");
        BaseApplicationImpl.getContext().startActivity(localIntent);
        oix.a(oix.b(localscq.a, "106", localscq.b));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsUGDownloadListener.2
 * JD-Core Version:    0.7.0.1
 */