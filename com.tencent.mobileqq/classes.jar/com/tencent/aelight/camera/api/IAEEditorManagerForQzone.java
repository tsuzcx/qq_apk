package com.tencent.aelight.camera.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAEEditorManagerForQzone
  extends QRouteApi
{
  public abstract void addListener(IAEEditorGenerateResultListener paramIAEEditorGenerateResultListener);
  
  public abstract void addUICallbackListener(IAEEditorUICallbackListener paramIAEEditorUICallbackListener);
  
  public abstract void cancelMission(String paramString);
  
  public abstract boolean checkAEResVersionOKForAEBasePackage();
  
  public abstract Class getAECoverSelectFragmentClass();
  
  public abstract Class getAEVideoPreviewFragmentClass();
  
  public abstract LocalMediaInfo getMissionInfo(String paramString);
  
  public abstract void init();
  
  public abstract boolean isAEKitForQQInit();
  
  public abstract boolean isCameraResReady();
  
  public abstract void jumpForAECircle(Context paramContext, Intent paramIntent);
  
  public abstract void launchAECameraFromCircle(Context paramContext, Bundle paramBundle);
  
  public abstract void launchAEMutiCameraFromCircle(Context paramContext, Bundle paramBundle);
  
  public abstract void launchQQPhotoSelect(Context paramContext, Intent paramIntent);
  
  public abstract void removeCallbackListener(@Nullable IAEEditorUICallbackListener paramIAEEditorUICallbackListener);
  
  public abstract void removeListener(IAEEditorGenerateResultListener paramIAEEditorGenerateResultListener);
  
  public abstract void removeUICallbackListener(IAEEditorUICallbackListener paramIAEEditorUICallbackListener);
  
  public abstract void requestGenerateVideo(String paramString);
  
  public abstract void retryMission(String paramString);
  
  public abstract void saveMission(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.api.IAEEditorManagerForQzone
 * JD-Core Version:    0.7.0.1
 */