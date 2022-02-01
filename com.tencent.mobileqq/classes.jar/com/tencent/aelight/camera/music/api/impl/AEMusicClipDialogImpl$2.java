package com.tencent.aelight.camera.music.api.impl;

import android.media.MediaPlayer;
import android.os.Handler;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorLyricPanelDialog;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorLyricProgressCalculator;
import com.tencent.mobileqq.wink.editor.music.lyric.WinkLyricPanelDialog;
import com.tencent.mobileqq.wink.editor.music.lyric.WinkLyricProgressCalculator;

class AEMusicClipDialogImpl$2
  implements Runnable
{
  AEMusicClipDialogImpl$2(AEMusicClipDialogImpl paramAEMusicClipDialogImpl) {}
  
  public void run()
  {
    AEMusicClipDialogImpl localAEMusicClipDialogImpl = this.this$0;
    AEMusicClipDialogImpl.access$302(localAEMusicClipDialogImpl, AEMusicClipDialogImpl.access$400(localAEMusicClipDialogImpl).getCurrentPosition());
    if (AEMusicClipDialogImpl.access$500(this.this$0))
    {
      if (AEMusicClipDialogImpl.access$300(this.this$0) > AEMusicClipDialogImpl.access$600(this.this$0) + AEMusicClipDialogImpl.access$700(this.this$0))
      {
        AEMusicClipDialogImpl.access$400(this.this$0).seekTo(AEMusicClipDialogImpl.access$600(this.this$0));
        AEMusicClipDialogImpl.access$800(this.this$0).b(0, AEMusicClipDialogImpl.access$700(this.this$0));
        AEEditorLyricProgressCalculator.a().a(0L, AEMusicClipDialogImpl.access$700(this.this$0));
      }
      else
      {
        AEMusicClipDialogImpl.access$800(this.this$0).b(AEMusicClipDialogImpl.access$300(this.this$0) - AEMusicClipDialogImpl.access$600(this.this$0), AEMusicClipDialogImpl.access$700(this.this$0));
        AEEditorLyricProgressCalculator.a().a(AEMusicClipDialogImpl.access$300(this.this$0) - AEMusicClipDialogImpl.access$600(this.this$0), AEMusicClipDialogImpl.access$700(this.this$0));
      }
    }
    else if (AEMusicClipDialogImpl.access$300(this.this$0) > AEMusicClipDialogImpl.access$600(this.this$0) + AEMusicClipDialogImpl.access$700(this.this$0))
    {
      AEMusicClipDialogImpl.access$400(this.this$0).seekTo(AEMusicClipDialogImpl.access$600(this.this$0));
      AEMusicClipDialogImpl.access$900(this.this$0).b(0, AEMusicClipDialogImpl.access$700(this.this$0));
      WinkLyricProgressCalculator.a().a(0L, AEMusicClipDialogImpl.access$700(this.this$0));
    }
    else
    {
      AEMusicClipDialogImpl.access$900(this.this$0).b(AEMusicClipDialogImpl.access$300(this.this$0) - AEMusicClipDialogImpl.access$600(this.this$0), AEMusicClipDialogImpl.access$700(this.this$0));
      WinkLyricProgressCalculator.a().a(AEMusicClipDialogImpl.access$300(this.this$0) - AEMusicClipDialogImpl.access$600(this.this$0), AEMusicClipDialogImpl.access$700(this.this$0));
    }
    AEMusicClipDialogImpl.access$1000(this.this$0).postDelayed(this, 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.music.api.impl.AEMusicClipDialogImpl.2
 * JD-Core Version:    0.7.0.1
 */