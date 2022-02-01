package com.tencent.aelight.camera.qqstory.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQIMBeautyManager
  extends QRouteApi
{
  public abstract int getBeautyConfigVersion(Context paramContext);
  
  public abstract void parseConfig();
  
  public abstract boolean saveBeautyConfig(String paramString, int paramInt, Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.IQIMBeautyManager
 * JD-Core Version:    0.7.0.1
 */