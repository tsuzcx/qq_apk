package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import java.util.Properties;
import prg;
import spn;
import stn;

public class VideoPlayerWrapper$1
  implements Runnable
{
  public VideoPlayerWrapper$1(spn paramspn, stn paramstn) {}
  
  public void run()
  {
    Object localObject = this.a.a();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = prg.a((String)localObject);
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