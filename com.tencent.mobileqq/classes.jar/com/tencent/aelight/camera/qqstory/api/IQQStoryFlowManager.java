package com.tencent.aelight.camera.qqstory.api;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQStoryFlowManager
  extends QRouteApi
{
  public abstract boolean isValidMedia(@NonNull Activity paramActivity, @NonNull LocalMediaInfo paramLocalMediaInfo);
  
  public abstract void startEditVideoActivity(Activity paramActivity, String paramString1, LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, boolean paramBoolean, int paramInt6, int paramInt7, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.IQQStoryFlowManager
 * JD-Core Version:    0.7.0.1
 */