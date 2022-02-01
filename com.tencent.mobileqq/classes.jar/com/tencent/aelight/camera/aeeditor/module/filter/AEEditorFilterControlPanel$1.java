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
      if (AEEditorFilterControlPanel.b(this.a) != null) {
        AEEditorFilterControlPanel.b(this.a).a(this.a.getSelectedIndex(), paramInt / 100.0F);
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if (AEEditorFilterControlPanel.a(this.a) != null) {
      AEEditorFilterControlPanel.a(this.a).setVisibility(0);
    }
    if (AEEditorFilterControlPanel.b(this.a) != null) {
      AEEditorFilterControlPanel.b(this.a).R();
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    if (AEEditorFilterControlPanel.a(this.a) != null) {
      AEEditorFilterControlPanel.a(this.a).setVisibility(4);
    }
    if (AEEditorFilterControlPanel.b(this.a) != null) {
      AEEditorFilterControlPanel.b(this.a).S();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.filter.AEEditorFilterControlPanel.1
 * JD-Core Version:    0.7.0.1
 */