package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;

class AEBeautyProviderView$2
  implements SeekBar.OnSeekBarChangeListener
{
  AEBeautyProviderView$2(AEBeautyProviderView paramAEBeautyProviderView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (AEBeautyProviderView.a(this.a) != null)
    {
      AEBeautyProviderView.a(this.a).b(paramInt);
      paramSeekBar = this.a.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("+");
      localStringBuilder.append(String.format("%.1f", new Object[] { Float.valueOf(paramInt / 10.0F) }));
      paramSeekBar.setText(localStringBuilder.toString());
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    paramSeekBar = this.a;
    AEBeautyProviderView.a(paramSeekBar, AEBeautyProviderView.b(paramSeekBar), AEBeautyProviderView.a(this.a));
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if ((AEBeautyProviderView.c(this.a) != null) && ((AEBeautyProviderView.c(this.a) instanceof ViewGroup))) {
      ((ViewGroup)AEBeautyProviderView.c(this.a)).setMotionEventSplittingEnabled(true);
    }
    AEBeautyProviderView.b(this.a, paramSeekBar.getProgress());
    AEBaseReportParam.a().g(paramSeekBar.getProgress());
    paramSeekBar = this.a;
    AEBeautyProviderView.b(paramSeekBar, AEBeautyProviderView.b(paramSeekBar), AEBeautyProviderView.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderView.2
 * JD-Core Version:    0.7.0.1
 */