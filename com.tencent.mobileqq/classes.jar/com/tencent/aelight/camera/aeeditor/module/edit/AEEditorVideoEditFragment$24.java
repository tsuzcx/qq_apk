package com.tencent.aelight.camera.aeeditor.module.edit;

import android.widget.ImageView;
import com.tencent.aelight.camera.aeeditor.module.controlpanel.AEEditorMusicControlPanel;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicAdapter.AEEditorMusicInfo;
import com.tencent.aelight.camera.aeeditor.module.music.AEEditorMusicHelper;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class AEEditorVideoEditFragment$24
  implements Runnable
{
  AEEditorVideoEditFragment$24(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    int i;
    if ((this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo != null) && (!this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a()) && (!this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a()) && (this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a().equals(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a()))) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool = this.jdField_a_of_type_Boolean;
    Object localObject;
    if (!bool)
    {
      AEEditorVideoEditFragment.a(this.this$0, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo, bool);
      if (i != 0)
      {
        if (AEEditorVideoEditFragment.a(this.this$0) != null) {
          AEEditorVideoEditFragment.a(this.this$0).d();
        }
        QQToast.a(BaseApplicationImpl.getApplication(), 2064515152, 0).a();
      }
      localObject = AEEditorVideoEditFragment.h();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onDownloadFinished], download music failed, editorMusicInfo=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
      AEQLog.d((String)localObject, localStringBuilder.toString());
      return;
    }
    if (i != 0)
    {
      if (this.this$0.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null)
      {
        AEQLog.b(AEEditorVideoEditFragment.h(), "[onDownloadFinished], avCutVideoSession=null");
        return;
      }
      this.this$0.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = AEEditorMusicHelper.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a(), this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.b());
      localObject = this.this$0;
      ((AEEditorVideoEditFragment)localObject).a(((AEEditorVideoEditFragment)localObject).jdField_a_of_type_ComTencentWeseevideoModelDataMusicData, this.this$0.jdField_a_of_type_Float, this.this$0.b, this.this$0.jdField_a_of_type_Boolean ^ true);
      if ((!this.this$0.jdField_a_of_type_Boolean) && (AEEditorVideoEditFragment.a(this.this$0) != null) && (AEEditorVideoEditFragment.a(this.this$0).getVisibility() == 0)) {
        AEEditorVideoEditFragment.a(this.this$0, true);
      }
      AEEditorVideoEditFragment.a(this.this$0, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo, this.jdField_a_of_type_Boolean);
      AEEditorVideoEditFragment.a(this.this$0).setBgmPlayed(true, this.this$0.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
      return;
    }
    AEEditorVideoEditFragment.a(this.this$0, this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo, bool);
    AEQLog.b(AEEditorVideoEditFragment.h(), "[onDownloadFinished], currentMusic invalid OR editorMusicInfo invalid OR mid not match");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorVideoEditFragment.24
 * JD-Core Version:    0.7.0.1
 */