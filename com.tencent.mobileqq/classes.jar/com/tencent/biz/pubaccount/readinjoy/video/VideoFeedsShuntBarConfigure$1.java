package com.tencent.biz.pubaccount.readinjoy.video;

import android.util.SparseIntArray;
import bnrf;
import com.tencent.qphone.base.util.QLog;
import ruk;

public class VideoFeedsShuntBarConfigure$1
  implements Runnable
{
  public VideoFeedsShuntBarConfigure$1(ruk paramruk) {}
  
  public void run()
  {
    int i = 0;
    try
    {
      while (i < ruk.a(this.this$0).size())
      {
        int j = ruk.a(this.this$0).keyAt(i);
        int k = ruk.a(this.this$0).valueAt(i);
        if (k != 0)
        {
          int m = ((Integer)bnrf.a(ruk.a(this.this$0) + j, Integer.valueOf(0))).intValue();
          bnrf.a(ruk.a(this.this$0) + j, Integer.valueOf(k + m));
          if (QLog.isColorLevel()) {
            QLog.d(ruk.a(), 2, "video_source_id: " + j + ", has display counts: " + (m + k));
          }
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(ruk.a(), 2, "更新引流条配置出现错误: " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsShuntBarConfigure.1
 * JD-Core Version:    0.7.0.1
 */