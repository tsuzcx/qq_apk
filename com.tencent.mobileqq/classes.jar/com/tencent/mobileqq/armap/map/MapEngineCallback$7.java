package com.tencent.mobileqq.armap.map;

import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.statistics.ReportController;

class MapEngineCallback$7
  implements Runnable
{
  MapEngineCallback$7(MapEngineCallback paramMapEngineCallback, int paramInt, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    long l;
    if (this.this$0.mActivity != null)
    {
      l = this.this$0.mActivity.e;
      if (this.val$distance > ARMapActivity.a) {
        break label77;
      }
    }
    label77:
    for (int i = 1;; i = 2)
    {
      ReportController.b(null, "dc01440", "", "", "0X800783B", "0X800783B", 0, 0, String.valueOf(this.val$taskId), String.valueOf(this.val$poiId), String.valueOf(l), String.valueOf(i));
      return;
      l = 0L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.MapEngineCallback.7
 * JD-Core Version:    0.7.0.1
 */