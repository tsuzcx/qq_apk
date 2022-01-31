package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.HashMap;
import onk;
import qls;

public class VideoFeedsAdapter$1
  implements Runnable
{
  public VideoFeedsAdapter$1(qls paramqls, long paramLong) {}
  
  public void run()
  {
    if (qls.a(this.this$0) != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_scrollInterval", String.valueOf(this.a));
      onk.e(qls.a(this.this$0), onk.a(), true, localHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.1
 * JD-Core Version:    0.7.0.1
 */