package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.HashMap;
import ozs;
import rnu;

public class VideoFeedsAdapter$2
  implements Runnable
{
  public VideoFeedsAdapter$2(rnu paramrnu, long paramLong) {}
  
  public void run()
  {
    if (rnu.a(this.this$0) != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_scrollInterval", String.valueOf(this.a));
      ozs.e(rnu.a(this.this$0), ozs.a(), true, localHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.2
 * JD-Core Version:    0.7.0.1
 */