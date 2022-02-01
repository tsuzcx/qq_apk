package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;

class AEBeautyProviderView$1
  implements SeekBar.OnSeekBarChangeListener
{
  AEBeautyProviderView$1(AEBeautyProviderView paramAEBeautyProviderView) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (AEBeautyProviderView.a(this.a) != null)
    {
      AEBeautyProviderView.a(this.a).a(paramInt);
      paramSeekBar = this.a.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("+");
      localStringBuilder.append(String.format("%.1f", new Object[] { Float.valueOf(paramInt / 10.0F) }));
      paramSeekBar.setText(localStringBuilder.toString());
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    paramSeekBar = this.a;
    AEBeautyProviderView.a(paramSeekBar, AEBeautyProviderView.b(paramSeekBar), AEBeautyProviderView.c(this.a));
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if ((AEBeautyProviderView.d(this.a) != null) && ((AEBeautyProviderView.d(this.a) instanceof ViewGroup))) {
      ((ViewGroup)AEBeautyProviderView.d(this.a)).setMotionEventSplittingEnabled(true);
    }
    AEBeautyProviderView.a(this.a, paramSeekBar.getProgress());
    AEBaseReportParam.a().h(paramSeekBar.getProgress());
    paramSeekBar = this.a;
    AEBeautyProviderView.b(paramSeekBar, AEBeautyProviderView.b(paramSeekBar), AEBeautyProviderView.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderView.1
 * JD-Core Version:    0.7.0.1
 */