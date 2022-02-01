package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.HashMap;
import pkh;
import pqe;
import shl;

public class VideoFeedsAdapter$2
  implements Runnable
{
  public VideoFeedsAdapter$2(shl paramshl, long paramLong) {}
  
  public void run()
  {
    if (shl.a(this.this$0) != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_scrollInterval", String.valueOf(this.a));
      pqe.e(shl.a(this.this$0), pkh.a(), true, localHashMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.2
 * JD-Core Version:    0.7.0.1
 */