package com.tencent.aelight.camera.aeeditor.module.music;

import android.support.annotation.NonNull;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class AEEditorMusicHelper$MusicDownloadRunnable
  implements Runnable
{
  private AppRuntime a;
  private AEEditorMusicAdapter.AEEditorMusicInfo b;
  private String c;
  private String d;
  private WeakReference<AEEditorMusicHelper.MusicDownloadCallback> e;
  
  public AEEditorMusicHelper$MusicDownloadRunnable(@NonNull AppRuntime paramAppRuntime, @NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, @NonNull String paramString1, @NonNull String paramString2, @NonNull AEEditorMusicHelper.MusicDownloadCallback paramMusicDownloadCallback)
  {
    this.a = paramAppRuntime;
    this.b = paramAEEditorMusicInfo;
    this.c = paramString1;
    this.d = paramString2;
    this.e = new WeakReference(paramMusicDownloadCallback);
  }
  
  public void run()
  {
    AEEditorMusicHelper.a(this.a, this.b, this.c, this.d, (AEEditorMusicHelper.MusicDownloadCallback)this.e.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicHelper.MusicDownloadRunnable
 * JD-Core Version:    0.7.0.1
 */