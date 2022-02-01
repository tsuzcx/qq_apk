package com.tencent.aelight.camera.aeeditor.module.music;

import android.graphics.Color;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.aeeditor.lyric.interaction.MoreLyricLayout;
import com.tencent.aelight.camera.aeeditor.lyric.interaction.MoreLyricLayout.LyricBackgroundEffect;

class AEEditorLyricPanelDialog$2
  implements MoreLyricLayout.LyricBackgroundEffect
{
  AEEditorLyricPanelDialog$2(AEEditorLyricPanelDialog paramAEEditorLyricPanelDialog) {}
  
  public void a(float paramFloat)
  {
    AEEditorLyricPanelDialog.a(this.a).setAlpha(1.0F - paramFloat);
    AEEditorLyricPanelDialog.b(this.a).setBackgroundColor(Color.argb((int)(paramFloat * 255.0F * 0.7F), 0, 0, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorLyricPanelDialog.2
 * JD-Core Version:    0.7.0.1
 */