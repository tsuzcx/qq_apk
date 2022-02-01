package com.tencent.ilivesdk.recordservice_interface;

import android.app.Activity;
import android.media.projection.MediaProjection;
import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface RecordServiceInterface
  extends ServiceBaseInterface
{
  public abstract void cancelRecord();
  
  public abstract void init(RecordServiceAdapter paramRecordServiceAdapter);
  
  public abstract void setActivity(Activity paramActivity);
  
  public abstract void setMediaProjection(MediaProjection paramMediaProjection);
  
  public abstract void setRecordListener(RecordScreenListener paramRecordScreenListener);
  
  public abstract void setVideoRecordHeight(int paramInt);
  
  public abstract void setVideoRecordWidth(int paramInt);
  
  public abstract void setVideoSaveDirPath(String paramString);
  
  public abstract void startRecord();
  
  public abstract String stopRecord();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.recordservice_interface.RecordServiceInterface
 * JD-Core Version:    0.7.0.1
 */