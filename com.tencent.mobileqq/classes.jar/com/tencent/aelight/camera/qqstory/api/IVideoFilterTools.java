package com.tencent.aelight.camera.qqstory.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IVideoFilterTools
  extends QRouteApi
{
  public static final String BASE_CONFIG = "filter_config_new.xml";
  public static final String CATEGORYS = "categorys";
  public static final String CONFIG_FILE = "params.json";
  public static final String FILTERS = "filters";
  public static final String FILTER_ASSET = "filter_template.cfg";
  public static final String LOCK_CATEGORYS = "locked_categorys";
  public static final String TEMP_FILTER_CONFIG_ZIP = "temp_filter_zip";
  
  public abstract String getCommonPrefix();
  
  public abstract int getQQShortVideoFilterConfigVersion(Context paramContext);
  
  public abstract void handleQQShortVideoCommonConfig(String paramString);
  
  public abstract void updateQQShortVideoFilterConfig(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.IVideoFilterTools
 * JD-Core Version:    0.7.0.1
 */