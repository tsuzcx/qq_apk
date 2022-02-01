package com.tencent.aelight.camera.qqstory.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPtvFilterUtil
  extends QRouteApi
{
  public static final String DynamicAdjustmentTag = "DynamicAdjustment";
  public static final int FILTER_KIND_INVALID = 0;
  public static final String OPEN_CUSTOM_CAMERA_TAG = "open_custom_camera";
  public static final int PTV_FILTER_KIND_BEAUTY = 1;
  
  public abstract void createFakeVidConfigFile(String paramString1, String paramString2);
  
  public abstract void glSyncCommand(boolean paramBoolean);
  
  public abstract void setBeautyKindSafety(int paramInt);
  
  public abstract void setSupportBeautySafety(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.IPtvFilterUtil
 * JD-Core Version:    0.7.0.1
 */