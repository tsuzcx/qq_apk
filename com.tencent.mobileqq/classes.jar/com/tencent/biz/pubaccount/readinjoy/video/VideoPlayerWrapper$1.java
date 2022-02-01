package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import java.util.Properties;
import ozs;
import rwf;
import rzt;

public class VideoPlayerWrapper$1
  implements Runnable
{
  public VideoPlayerWrapper$1(rwf paramrwf, rzt paramrzt) {}
  
  public void run()
  {
    Object localObject = this.a.a();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ozs.a((String)localObject);
      if (localObject != null) {
        this.this$0.a = Long.parseLong(((Properties)localObject).getProperty("VideoBitRate"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.1
 * JD-Core Version:    0.7.0.1
 */