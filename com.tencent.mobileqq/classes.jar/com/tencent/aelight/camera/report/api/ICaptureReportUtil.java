package com.tencent.aelight.camera.report.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ICaptureReportUtil
  extends QRouteApi
{
  public static final int editVideoType = -1;
  
  public abstract void reportDoubleClickChangeCamera();
  
  public abstract void reportPhotoTaken(int paramInt);
  
  public abstract void reportVideoCapture(int paramInt);
  
  public abstract void setVideoDuration(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.report.api.ICaptureReportUtil
 * JD-Core Version:    0.7.0.1
 */