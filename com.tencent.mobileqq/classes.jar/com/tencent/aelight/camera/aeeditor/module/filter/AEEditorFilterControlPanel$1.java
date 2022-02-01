package com.tencent.aelight.camera.aeeditor.module.filter;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

class AEEditorFilterControlPanel$1
  implements SeekBar.OnSeekBarChangeListener
{
  AEEditorFilterControlPanel$1(AEEditorFilterControlPanel paramAEEditorFilterControlPanel) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramSeekBar.getVisibility() == 0))
    {
      if (AEEditorFilterControlPanel.a(this.a) != null)
      {
        paramSeekBar = AEEditorFilterControlPanel.a(this.a);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        localStringBuilder.append("%");
        paramSeekBar.setText(localStringBuilder.toString());
      }
      if (AEEditorFilterControlPanel.a(this.a) != null) {
        AEEditorFilterControlPanel.a(this.a).a(this.a.a(), paramInt / 100.0F);
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if (AEEditorFilterControlPanel.a(this.a) != null) {
      AEEditorFilterControlPanel.a(this.a).setVisibility(0);
    }
    if (AEEditorFilterControlPanel.a(this.a) != null) {
      AEEditorFilterControlPanel.a(this.a).B();
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (AEEditorFilterControlPanel.a(this.a) != null) {
      AEEditorFilterControlPanel.a(this.a).setVisibility(4);
    }
    if (AEEditorFilterControlPanel.a(this.a) != null) {
      AEEditorFilterControlPanel.a(this.a).C();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.filter.AEEditorFilterControlPanel.1
 * JD-Core Version:    0.7.0.1
 */