package com.tencent.biz.pubaccount.readinjoy.video;

import android.util.SparseIntArray;
import bgmq;
import com.tencent.qphone.base.util.QLog;
import qgu;

public class VideoFeedsShuntBarConfigure$1
  implements Runnable
{
  public VideoFeedsShuntBarConfigure$1(qgu paramqgu) {}
  
  public void run()
  {
    int i = 0;
    try
    {
      while (i < qgu.a(this.this$0).size())
      {
        int j = qgu.a(this.this$0).keyAt(i);
        int k = qgu.a(this.this$0).valueAt(i);
        if (k != 0)
        {
          int m = ((Integer)bgmq.a(qgu.a(this.this$0) + j, Integer.valueOf(0))).intValue();
          bgmq.a(qgu.a(this.this$0) + j, Integer.valueOf(k + m));
          if (QLog.isColorLevel()) {
            QLog.d(qgu.a(), 2, "video_source_id: " + j + ", has display counts: " + (m + k));
          }
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(qgu.a(), 2, "更新引流条配置出现错误: " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShuntBarConfigure.1
 * JD-Core Version:    0.7.0.1
 */