package com.tencent.aelight.camera.report.api.impl;

import com.tencent.aelight.camera.aioeditor.CaptureReportUtil;
import com.tencent.aelight.camera.report.api.ICaptureReportUtil;

public class CaptureReportUtilImpl
  implements ICaptureReportUtil
{
  public void reportDoubleClickChangeCamera() {}
  
  public void reportPhotoTaken(int paramInt)
  {
    CaptureReportUtil.b(paramInt);
  }
  
  public void reportVideoCapture(int paramInt)
  {
    CaptureReportUtil.c(paramInt);
  }
  
  public void setVideoDuration(long paramLong)
  {
    CaptureReportUtil.g = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.report.api.impl.CaptureReportUtilImpl
 * JD-Core Version:    0.7.0.1
 */