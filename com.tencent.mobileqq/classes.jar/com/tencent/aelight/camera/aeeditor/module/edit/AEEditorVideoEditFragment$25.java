package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.aelight.camera.aeeditor.module.controlpanel.AEEditorMusicControlPanel;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicAdapter.AEEditorMusicInfo;
import java.util.List;

class AEEditorVideoEditFragment$25
  implements Runnable
{
  AEEditorVideoEditFragment$25(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, int paramInt, AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo) {}
  
  public void run()
  {
    int j = this.a;
    int i = j;
    if (j > 100) {
      i = 100;
    }
    j = i;
    if (i < 0) {
      j = 0;
    }
    List localList = AEEditorVideoEditFragment.a(this.this$0, this.b, 1, j);
    if (localList != null) {
      AEEditorVideoEditFragment.m(this.this$0).a(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.25
 * JD-Core Version:    0.7.0.1
 */