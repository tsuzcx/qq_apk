package com.tencent.mobileqq.activity.photo;

import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class VideoPlayControllerForFile$1
  implements VideoPlayControllerForAIO.OnDownloadListener
{
  VideoPlayControllerForFile$1(VideoPlayControllerForFile paramVideoPlayControllerForFile) {}
  
  public void a(long paramLong, float paramFloat, String paramString)
  {
    VideoPlayControllerForFile.a(this.a).put(Long.valueOf(paramLong), Float.valueOf(paramFloat));
    VideoPlayControllerForFile.b(this.a).a(paramLong, paramFloat, paramString);
  }
  
  public void b(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadSuccess:");
    localStringBuilder.append(paramLong);
    QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, localStringBuilder.toString());
    VideoPlayControllerForFile.b(this.a).b(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.VideoPlayControllerForFile.1
 * JD-Core Version:    0.7.0.1
 */