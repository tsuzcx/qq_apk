package com.tencent.aelight.camera.aeeditor.module.edit;

import android.widget.ImageView;
import com.tencent.aelight.camera.aeeditor.module.controlpanel.AEEditorMusicControlPanel;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicAdapter.AEEditorMusicInfo;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicHelper;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qcircle.weseevideo.model.data.MusicData;

class AEEditorVideoEditFragment$24
  implements Runnable
{
  AEEditorVideoEditFragment$24(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.L;
    boolean bool1 = false;
    int i;
    if ((localObject1 != null) && (!this.this$0.L.a()) && (!this.a.a()) && (this.this$0.L.c().equals(this.a.c()))) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool2 = this.b;
    Object localObject2;
    if (!bool2)
    {
      AEEditorVideoEditFragment.a(this.this$0, this.a, bool2);
      if (i != 0)
      {
        if (AEEditorVideoEditFragment.m(this.this$0) != null) {
          AEEditorVideoEditFragment.m(this.this$0).d();
        }
        QQToast.makeText(BaseApplicationImpl.getApplication(), 2064187494, 0).show();
      }
      localObject1 = AEEditorVideoEditFragment.aj();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[onDownloadFinished], download music failed, editorMusicInfo=");
      ((StringBuilder)localObject2).append(this.a);
      AEQLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
      return;
    }
    if (i != 0)
    {
      if (this.this$0.B == null)
      {
        AEQLog.b(AEEditorVideoEditFragment.aj(), "[onDownloadFinished], avCutVideoSession=null");
        return;
      }
      localObject1 = this.this$0;
      ((AEEditorVideoEditFragment)localObject1).N = AEEditorMusicHelper.a(this.c, AEEditorVideoEditFragment.b((AEEditorVideoEditFragment)localObject1, this.a.c()), this.a.f());
      if (AEEditorVideoEditFragment.v(this.this$0) != null) {
        this.this$0.b(this.a);
      }
      localObject1 = this.this$0;
      localObject2 = ((AEEditorVideoEditFragment)localObject1).N;
      float f1 = this.this$0.J;
      float f2 = this.this$0.K;
      if ((!this.this$0.q) || (AEEditorVideoEditFragment.v(this.this$0) != null)) {
        bool1 = true;
      }
      ((AEEditorVideoEditFragment)localObject1).a((MusicData)localObject2, f1, f2, bool1);
      AEEditorVideoEditFragment.a(this.this$0, null);
      if ((!this.this$0.q) && (AEEditorVideoEditFragment.w(this.this$0) != null) && (AEEditorVideoEditFragment.w(this.this$0).getVisibility() == 0)) {
        AEEditorVideoEditFragment.a(this.this$0, true);
      }
      AEEditorVideoEditFragment.a(this.this$0, this.a, this.b);
      AEEditorVideoEditFragment.m(this.this$0).setBgmPlayed(true, this.this$0.L);
      return;
    }
    AEEditorVideoEditFragment.a(this.this$0, this.a, bool2);
    AEQLog.b(AEEditorVideoEditFragment.aj(), "[onDownloadFinished], currentMusic invalid OR editorMusicInfo invalid OR mid not match");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.24
 * JD-Core Version:    0.7.0.1
 */