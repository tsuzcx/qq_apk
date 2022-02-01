package com.tencent.aelight.camera.entry.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
public abstract interface IAECameraEntryManager
  extends QRouteApi
{
  public abstract int getAEFromType(Intent paramIntent);
  
  public abstract int getStoryMediaType(Intent paramIntent);
  
  public abstract int getStoryShareType(Intent paramIntent);
  
  public abstract boolean isAddPlayShowEntry(int paramInt);
  
  public abstract boolean isAddPlayShowEntry(Activity paramActivity);
  
  public abstract boolean isFromCheckEntry(Intent paramIntent);
  
  public abstract boolean isFromGuideCircle(Intent paramIntent);
  
  public abstract boolean isFromMiniApp(Intent paramIntent);
  
  public abstract boolean isQzoneTailEntry(Intent paramIntent);
  
  public abstract boolean isSameStoryPhotoEntry(Intent paramIntent);
  
  public abstract boolean isStoryDefaultShare(Intent paramIntent);
  
  public abstract boolean isStoryPhoto(Intent paramIntent, int paramInt);
  
  public abstract int switchModeToInt(String paramString);
  
  public abstract String switchTabToName(@Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.entry.api.IAECameraEntryManager
 * JD-Core Version:    0.7.0.1
 */