package com.tencent.aelight.camera.aeeditor.module.music;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.aelight.camera.aebase.AEReportUtils;

class AEEditorMusicVolumePanelDialog$5
  implements SeekBar.OnSeekBarChangeListener
{
  AEEditorMusicVolumePanelDialog$5(AEEditorMusicVolumePanelDialog paramAEEditorMusicVolumePanelDialog) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (AEEditorMusicVolumePanelDialog.d(this.a) != null) {
      AEEditorMusicVolumePanelDialog.d(this.a).a(paramInt / 100.0F);
    }
    if (paramBoolean) {
      AEEditorMusicVolumePanelDialog.b(this.a, paramInt);
    }
    AEReportUtils.a(7);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicVolumePanelDialog.5
 * JD-Core Version:    0.7.0.1
 */