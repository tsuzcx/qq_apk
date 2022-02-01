package com.tencent.biz.pubaccount.readinjoy.video;

import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import rpt;

public final class VideoFeedsHelper$10
  implements Runnable
{
  public VideoFeedsHelper$10(int paramInt, String paramString, TextView paramTextView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int > 0) {}
    for (String str = rpt.e(this.jdField_a_of_type_Int);; str = this.jdField_a_of_type_JavaLangString)
    {
      ThreadManager.getUIHandler().post(new VideoFeedsHelper.10.1(this, str));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper.10
 * JD-Core Version:    0.7.0.1
 */