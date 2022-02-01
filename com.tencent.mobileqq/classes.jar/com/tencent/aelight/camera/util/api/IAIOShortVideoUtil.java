package com.tencent.aelight.camera.util.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAIOShortVideoUtil
  extends QRouteApi
{
  public static final int AIO_SHORTVIDEO_REQUEST_CODE = 11;
  public static final boolean CAM_START_MONITOR_FLAG = false;
  public static final String CAM_START_MONITOR_TAG = "CAM_START_MONITOR";
  public static final String MONITOR_EVENT_TAG = "CAM_MONITOR_EVENT";
  public static final int SYS_CAMERA_PHOTO = 0;
  public static final int SYS_CAMERA_VIDEO = 1;
  public static final String debugDecodeFilePath;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append("/Tencent/com/tencent/mobileqq/debugDecodeShortVideo");
    debugDecodeFilePath = localStringBuilder.toString();
  }
  
  public abstract long getBaseActivtiyCreateTime();
  
  public abstract long getBaseActivtiyResumeTime();
  
  public abstract long getBaseActivtiyStartTime();
  
  public abstract long getClickCameraTime();
  
  public abstract int getEntranceType(int paramInt);
  
  public abstract long getPeakLoadTime();
  
  public abstract long getStartActivityTime();
  
  public abstract void handleSysCameraResult(AppInterface paramAppInterface, Activity paramActivity, Intent paramIntent, Object paramObject, int paramInt1, int paramInt2);
  
  public abstract void setBaseActivtiyCreateTime(long paramLong);
  
  public abstract void setBaseActivtiyResumeTime(long paramLong);
  
  public abstract void setBaseActivtiyStartTime(long paramLong);
  
  public abstract void setClickCameraTime(long paramLong);
  
  public abstract void setPeakLoadTime(long paramLong);
  
  public abstract void setStartActivtiyTime(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.util.api.IAIOShortVideoUtil
 * JD-Core Version:    0.7.0.1
 */