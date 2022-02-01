package com.tencent.aelight.camera.qqstory.api;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IJumpUtil
  extends QRouteApi
{
  public static final String EDIT_VIDEO_WAY = "edit_video_way";
  public static final int FROM_AIO = 1;
  public static final int FROM_CIRCLE = 13;
  public static final int FROM_FRAME = 2;
  public static final int FROM_PROFILE = 4;
  public static final int FROM_QUICK_SHOOT_ACTIVITY = 6;
  public static final int FROM_QZONE = 12;
  public static final int FROM_READINJOY = 10;
  public static final int FROM_SLIDE_SHOW_VIDE = 7;
  public static final int FROM_STORY = 3;
  public static final int FROM_TEXT_FILTER = 8;
  public static final int FROM_TRIBE = 9;
  public static final int FROM_VIDEO_STORY_STATUS = 11;
  public static final int FROM_WEB = 5;
  public static final int OTHERS = 0;
  public static final int REQ_PIC_EDIT_ACTIVITY = 1012;
  public static final int REQ_VIDEO_EDIT_ACTIVITY = 1013;
  
  public abstract String getCircleScheme(String paramString1, String paramString2);
  
  public abstract String getSchemeForTail(@Nullable String paramString);
  
  public abstract Bundle handleWidgetInfo(Bundle paramBundle, String paramString);
  
  public abstract void jumpToCameraActivityForAio(Activity paramActivity, String paramString);
  
  public abstract void jumpToCameraForTakeSameGif(Activity paramActivity, String paramString);
  
  public abstract void jumpToSlideShowEditVideoActivityForQzone(Activity paramActivity, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.IJumpUtil
 * JD-Core Version:    0.7.0.1
 */