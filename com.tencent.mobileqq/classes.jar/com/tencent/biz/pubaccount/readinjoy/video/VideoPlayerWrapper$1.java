package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import java.util.Properties;
import pay;
import sdj;
import sgx;

public class VideoPlayerWrapper$1
  implements Runnable
{
  public VideoPlayerWrapper$1(sdj paramsdj, sgx paramsgx) {}
  
  public void run()
  {
    Object localObject = this.a.a();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = pay.a((String)localObject);
      if (localObject == null) {
        break label52;
      }
    }
    label52:
    for (localObject = ((Properties)localObject).getProperty("VideoBitRate");; localObject = null)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.this$0.a = Long.parseLong((String)localObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper.1
 * JD-Core Version:    0.7.0.1
 */