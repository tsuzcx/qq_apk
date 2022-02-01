package com.tencent.aelight.camera.aioeditor.capture.data;

import android.os.Bundle;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools.ComboFilterData;

public abstract interface CaptureComboManager$CaptureComboListener
{
  public abstract void a(VideoFilterTools.ComboFilterData paramComboFilterData);
  
  public abstract void a(ComboSet paramComboSet);
  
  public abstract void a(ComboSet paramComboSet, boolean paramBoolean, int paramInt, Bundle paramBundle);
  
  public abstract void a(FilterSet paramFilterSet, boolean paramBoolean, int paramInt, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.CaptureComboListener
 * JD-Core Version:    0.7.0.1
 */