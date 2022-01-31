package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.HashMap;
import obz;
import pzs;

public class VideoFeedsAdapter$1
  implements Runnable
{
  public VideoFeedsAdapter$1(pzs parampzs, long paramLong) {}
  
  public void run()
  {
    if (pzs.a(this.this$0) != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_scrollInterval", String.valueOf(this.a));
      obz.e(pzs.a(this.this$0), obz.a(), true, localHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.1
 * JD-Core Version:    0.7.0.1
 */