package com.tencent.aelight.camera.entry.api;

import android.os.Bundle;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

public final class AELaunchParamsBuilder
  implements Serializable
{
  private Bundle bundle = new Bundle();
  
  public AELaunchParamsBuilder() {}
  
  public AELaunchParamsBuilder(@NotNull Bundle paramBundle)
  {
    this.bundle = paramBundle;
  }
  
  public Bundle build()
  {
    return this.bundle;
  }
  
  public AELaunchParamsBuilder canMixPickPhotoAndVideo(boolean paramBoolean)
  {
    this.bundle.putBoolean("BUNDLE_KEY_CIRCLE_CAN_MIX_PICK_PHOTO_AND_VIDEO", paramBoolean);
    return this;
  }
  
  public AELaunchParamsBuilder canSwitchSelectionMode(boolean paramBoolean)
  {
    this.bundle.putBoolean("BUNDLE_KEY_CIRCLE_CAN_SWITCH_SECTION_MODE", paramBoolean);
    return this;
  }
  
  public AELaunchParamsBuilder from(AECameraEntry paramAECameraEntry)
  {
    this.bundle.putInt("VIDEO_STORY_FROM_TYPE", paramAECameraEntry.a());
    return this;
  }
  
  public AELaunchParamsBuilder initialPickedNum(int paramInt)
  {
    this.bundle.putInt("BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM", paramInt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.entry.api.AELaunchParamsBuilder
 * JD-Core Version:    0.7.0.1
 */