package com.tencent.aelight.camera.aeeditor.module.music;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckedTextView;
import com.tencent.aelight.camera.aebase.AEReportUtils;

class AEEditorMusicPanel$1
  implements View.OnClickListener
{
  AEEditorMusicPanel$1(AEEditorMusicPanel paramAEEditorMusicPanel) {}
  
  public void onClick(View paramView)
  {
    boolean bool = AEEditorMusicPanel.a(this.a).isChecked() ^ true;
    AEEditorMusicPanel.a(this.a).setChecked(bool);
    AEEditorMusicPanel.b(this.a).setChecked(bool);
    if (AEEditorMusicPanel.a(this.a) != null) {
      AEEditorMusicPanel.a(this.a).f(bool);
    }
    int i;
    if (bool) {
      i = 3;
    } else {
      i = 4;
    }
    AEReportUtils.b(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicPanel.1
 * JD-Core Version:    0.7.0.1
 */