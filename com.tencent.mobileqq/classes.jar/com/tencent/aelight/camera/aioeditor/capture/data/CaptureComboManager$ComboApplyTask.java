package com.tencent.aelight.camera.aioeditor.capture.data;

import android.app.Activity;
import android.os.Bundle;
import java.lang.ref.WeakReference;

public class CaptureComboManager$ComboApplyTask
{
  public CaptureSet a;
  public Bundle b;
  public WeakReference<Activity> c;
  
  public CaptureComboManager$ComboApplyTask(CaptureSet paramCaptureSet, Bundle paramBundle, Activity paramActivity)
  {
    this.a = paramCaptureSet;
    this.b = paramBundle;
    this.c = new WeakReference(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager.ComboApplyTask
 * JD-Core Version:    0.7.0.1
 */