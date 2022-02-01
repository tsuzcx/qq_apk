package com.tencent.aelight.camera.aeeditor.module.music;

import android.support.annotation.NonNull;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class AEEditorMusicHelper$MusicDownloadRunnable
  implements Runnable
{
  private AEEditorMusicAdapter.AEEditorMusicInfo jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
  private String jdField_a_of_type_JavaLangString;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private WeakReference<AEEditorMusicHelper.MusicDownloadCallback> jdField_a_of_type_MqqUtilWeakReference;
  private String b;
  
  public AEEditorMusicHelper$MusicDownloadRunnable(@NonNull AppRuntime paramAppRuntime, @NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, @NonNull String paramString1, @NonNull String paramString2, @NonNull AEEditorMusicHelper.MusicDownloadCallback paramMusicDownloadCallback)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = paramAEEditorMusicInfo;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramMusicDownloadCallback);
  }
  
  public void run()
  {
    AEEditorMusicHelper.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo, this.jdField_a_of_type_JavaLangString, this.b, (AEEditorMusicHelper.MusicDownloadCallback)this.jdField_a_of_type_MqqUtilWeakReference.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicHelper.MusicDownloadRunnable
 * JD-Core Version:    0.7.0.1
 */