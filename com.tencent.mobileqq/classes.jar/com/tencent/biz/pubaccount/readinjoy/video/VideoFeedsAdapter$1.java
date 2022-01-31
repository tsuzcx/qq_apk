package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.HashMap;
import ors;
import raw;

public class VideoFeedsAdapter$1
  implements Runnable
{
  public VideoFeedsAdapter$1(raw paramraw, long paramLong) {}
  
  public void run()
  {
    if (raw.a(this.this$0) != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_scrollInterval", String.valueOf(this.a));
      ors.e(raw.a(this.this$0), ors.a(), true, localHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.1
 * JD-Core Version:    0.7.0.1
 */