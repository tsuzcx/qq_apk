package com.tencent.biz.pubaccount.readinjoy.video;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnExtractFrameListener;
import java.util.HashMap;

class VideoExtractFrameTask$5
  implements TVK_IMediaPlayer.OnExtractFrameListener
{
  VideoExtractFrameTask$5(VideoExtractFrameTask paramVideoExtractFrameTask) {}
  
  public void onExtractFrame(int paramInt, Bitmap paramBitmap)
  {
    VideoExtractFrameTask.FrameInfo localFrameInfo = (VideoExtractFrameTask.FrameInfo)VideoExtractFrameTask.a(this.a).get(Integer.valueOf(paramInt));
    if (localFrameInfo != null) {}
    try
    {
      localFrameInfo.jdField_b_of_type_Long = VideoExtractFrameHash.a(paramBitmap, true);
      localFrameInfo.jdField_b_of_type_Int = VideoExtractFrameHash.a(localFrameInfo.a, localFrameInfo.jdField_b_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.d(VideoExtractFrameTask.a(), 2, "onExtractFrame frameIndex = " + paramInt + ", localHash = " + localFrameInfo.jdField_b_of_type_Long + ", hashDiff = " + localFrameInfo.jdField_b_of_type_Int);
      }
      return;
    }
    catch (Throwable paramBitmap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(VideoExtractFrameTask.a(), 2, "VideoExtractFrameHash.dctImageHash ERROR e = " + paramBitmap.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoExtractFrameTask.5
 * JD-Core Version:    0.7.0.1
 */