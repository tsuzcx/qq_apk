package com.tencent.aelight.camera.entry.api.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import org.jetbrains.annotations.Nullable;

public class AECameraEntryManagerImpl
  implements IAECameraEntryManager
{
  public int getAEFromType(Intent paramIntent)
  {
    return AECameraEntryManager.a(paramIntent);
  }
  
  public int getStoryMediaType(Intent paramIntent)
  {
    return AECameraEntryManager.c(paramIntent);
  }
  
  public int getStoryShareType(Intent paramIntent)
  {
    return AECameraEntryManager.b(paramIntent);
  }
  
  public boolean isAddPlayShowEntry(int paramInt)
  {
    return AECameraEntryManager.c(paramInt);
  }
  
  public boolean isAddPlayShowEntry(Activity paramActivity)
  {
    return AECameraEntryManager.b(paramActivity);
  }
  
  public boolean isFromCheckEntry(Intent paramIntent)
  {
    return AECameraEntryManager.e(paramIntent);
  }
  
  public boolean isFromGuideCircle(Intent paramIntent)
  {
    return AECameraEntryManager.m(paramIntent);
  }
  
  public boolean isFromMiniApp(Intent paramIntent)
  {
    return AECameraEntryManager.f(paramIntent);
  }
  
  public boolean isQzoneTailEntry(Intent paramIntent)
  {
    return AECameraEntryManager.d(paramIntent);
  }
  
  public boolean isSameStoryPhotoEntry(Intent paramIntent)
  {
    return AECameraEntryManager.c(paramIntent);
  }
  
  public boolean isStoryDefaultShare(Intent paramIntent)
  {
    return AECameraEntryManager.a(paramIntent);
  }
  
  public boolean isStoryPhoto(Intent paramIntent, int paramInt)
  {
    return AECameraEntryManager.a(paramIntent, paramInt);
  }
  
  public int switchModeToInt(String paramString)
  {
    return AECameraEntryManager.a(paramString);
  }
  
  public String switchTabToName(@Nullable String paramString)
  {
    return AECameraEntryManager.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.entry.api.impl.AECameraEntryManagerImpl
 * JD-Core Version:    0.7.0.1
 */