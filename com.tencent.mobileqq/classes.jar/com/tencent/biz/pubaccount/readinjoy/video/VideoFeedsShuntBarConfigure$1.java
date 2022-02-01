package com.tencent.biz.pubaccount.readinjoy.video;

import android.util.SparseIntArray;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

class VideoFeedsShuntBarConfigure$1
  implements Runnable
{
  VideoFeedsShuntBarConfigure$1(VideoFeedsShuntBarConfigure paramVideoFeedsShuntBarConfigure) {}
  
  public void run()
  {
    int i = 0;
    try
    {
      while (i < VideoFeedsShuntBarConfigure.a(this.this$0).size())
      {
        int j = VideoFeedsShuntBarConfigure.a(this.this$0).keyAt(i);
        int k = VideoFeedsShuntBarConfigure.a(this.this$0).valueAt(i);
        if (k != 0)
        {
          int m = ((Integer)ReadInJoyHelper.a(VideoFeedsShuntBarConfigure.a(this.this$0) + j, Integer.valueOf(0))).intValue();
          ReadInJoyHelper.a(VideoFeedsShuntBarConfigure.a(this.this$0) + j, Integer.valueOf(k + m));
          if (QLog.isColorLevel()) {
            QLog.d(VideoFeedsShuntBarConfigure.a(), 2, "video_source_id: " + j + ", has display counts: " + (m + k));
          }
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(VideoFeedsShuntBarConfigure.a(), 2, "更新引流条配置出现错误: " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShuntBarConfigure.1
 * JD-Core Version:    0.7.0.1
 */