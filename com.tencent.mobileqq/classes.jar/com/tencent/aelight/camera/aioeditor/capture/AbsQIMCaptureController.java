package com.tencent.aelight.camera.aioeditor.capture;

import android.annotation.TargetApi;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView.ProviderViewListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;

public abstract class AbsQIMCaptureController
  implements ProviderView.ProviderViewListener, DoodleLayout.DoodleEventListener
{
  public int a;
  public View a;
  
  public abstract void a();
  
  @TargetApi(11)
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.AbsQIMCaptureController
 * JD-Core Version:    0.7.0.1
 */