package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.HashMap;
import onh;
import qlp;

public class VideoFeedsAdapter$1
  implements Runnable
{
  public VideoFeedsAdapter$1(qlp paramqlp, long paramLong) {}
  
  public void run()
  {
    if (qlp.a(this.this$0) != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_scrollInterval", String.valueOf(this.a));
      onh.e(qlp.a(this.this$0), onh.a(), true, localHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.1
 * JD-Core Version:    0.7.0.1
 */