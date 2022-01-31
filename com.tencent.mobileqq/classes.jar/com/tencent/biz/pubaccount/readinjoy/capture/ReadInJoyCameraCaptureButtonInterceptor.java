package com.tencent.biz.pubaccount.readinjoy.capture;

import android.support.annotation.NonNull;
import android.widget.TextView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout.CaptureButtonProgressInterceptor;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyCameraCaptureButtonInterceptor
  implements CameraCaptureButtonLayout.CaptureButtonProgressInterceptor
{
  private static final String a = ReadInJoyCameraCaptureButtonInterceptor.class.getSimpleName();
  
  public boolean a(@NonNull TextView paramTextView, @NonNull CircleProgress paramCircleProgress, long paramLong, float paramFloat)
  {
    float f = 100.0F;
    paramLong = System.currentTimeMillis() - paramLong;
    boolean bool;
    if ((float)paramLong >= paramFloat)
    {
      bool = true;
      if (!bool) {
        break label120;
      }
    }
    label120:
    for (paramFloat = f;; paramFloat = 100.0F * ((float)paramLong / paramFloat))
    {
      String str = (int)paramLong / 1000 + "秒";
      paramTextView.setText(str);
      paramCircleProgress.setProgress(paramFloat);
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "updateProgress percent:" + paramFloat + ", time:" + str);
      }
      return bool;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureButtonInterceptor
 * JD-Core Version:    0.7.0.1
 */