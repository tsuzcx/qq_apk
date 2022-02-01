package com.tencent.biz.pubaccount.readinjoy.video;

import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

final class VideoFeedsHelper$10
  implements Runnable
{
  VideoFeedsHelper$10(int paramInt, String paramString, TextView paramTextView) {}
  
  public void run()
  {
    String str = VideoFeedsHelper.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    ThreadManager.getUIHandler().post(new VideoFeedsHelper.10.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper.10
 * JD-Core Version:    0.7.0.1
 */