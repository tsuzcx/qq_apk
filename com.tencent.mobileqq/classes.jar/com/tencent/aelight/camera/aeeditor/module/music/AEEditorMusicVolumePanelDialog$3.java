package com.tencent.aelight.camera.aeeditor.module.music;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.aelight.camera.aebase.AEReportUtils;

class AEEditorMusicVolumePanelDialog$3
  implements SeekBar.OnSeekBarChangeListener
{
  AEEditorMusicVolumePanelDialog$3(AEEditorMusicVolumePanelDialog paramAEEditorMusicVolumePanelDialog) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (AEEditorMusicVolumePanelDialog.d(this.a) != null) {
      AEEditorMusicVolumePanelDialog.d(this.a).b(paramInt / 100.0F);
    }
    AEReportUtils.a(6);
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicVolumePanelDialog.3
 * JD-Core Version:    0.7.0.1
 */