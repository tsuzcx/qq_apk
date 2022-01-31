package com.tencent.biz.pubaccount.readinjoy.video;

import android.util.SparseIntArray;
import bhvh;
import com.tencent.qphone.base.util.QLog;
import qss;

public class VideoFeedsShuntBarConfigure$1
  implements Runnable
{
  public VideoFeedsShuntBarConfigure$1(qss paramqss) {}
  
  public void run()
  {
    int i = 0;
    try
    {
      while (i < qss.a(this.this$0).size())
      {
        int j = qss.a(this.this$0).keyAt(i);
        int k = qss.a(this.this$0).valueAt(i);
        if (k != 0)
        {
          int m = ((Integer)bhvh.a(qss.a(this.this$0) + j, Integer.valueOf(0))).intValue();
          bhvh.a(qss.a(this.this$0) + j, Integer.valueOf(k + m));
          if (QLog.isColorLevel()) {
            QLog.d(qss.a(), 2, "video_source_id: " + j + ", has display counts: " + (m + k));
          }
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(qss.a(), 2, "更新引流条配置出现错误: " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShuntBarConfigure.1
 * JD-Core Version:    0.7.0.1
 */