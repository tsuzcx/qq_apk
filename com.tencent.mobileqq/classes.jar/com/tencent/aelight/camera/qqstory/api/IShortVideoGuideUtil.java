package com.tencent.aelight.camera.qqstory.api;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IShortVideoGuideUtil
  extends QRouteApi
{
  public static final String TAG = "ShortVideoGuideUtil";
  
  public abstract boolean isAllResourceReady(AppInterface paramAppInterface);
  
  public abstract boolean isResourceReady(AppInterface paramAppInterface);
  
  public abstract boolean startPTVActivity(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.IShortVideoGuideUtil
 * JD-Core Version:    0.7.0.1
 */