package com.tencent.aelight.camera.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAECameraUnit
  extends QRouteApi
{
  public static final String KEY_ARCAKE_ID = "KEY_ARCAKE_ID";
  public static final String KEY_CURRENT_SELECT_ID = "KEY_CURRENT_SELECT_ID";
  public static final String KEY_CURRENT_TAB = "KEY_CURRENT_TAB";
  public static final String KEY_CURRENT_TYPE = "KEY_CURRENT_TYPE";
  public static final String KEY_FACE_UNLOCK_CODE = "key_face_unlock_code";
  public static final String KEY_READ_IN_JOY_VIDEO_UPLOAD_REPORT = "key_read_in_joy_video_upload_report";
  public static final String WIDGET_NAME = "widgetid";
  
  public abstract Class getAEPitUnitClass();
  
  public abstract void setPublishStoryFlag(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.api.IAECameraUnit
 * JD-Core Version:    0.7.0.1
 */