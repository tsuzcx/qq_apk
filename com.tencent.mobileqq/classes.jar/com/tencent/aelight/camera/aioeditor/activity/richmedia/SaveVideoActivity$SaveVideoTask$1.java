package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.editor.composite.VideoCompositeHelper.VideoCompositeCallBack;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;

class SaveVideoActivity$SaveVideoTask$1
  implements VideoCompositeHelper.VideoCompositeCallBack
{
  SaveVideoActivity$SaveVideoTask$1(SaveVideoActivity.SaveVideoTask paramSaveVideoTask, PeakActivity paramPeakActivity, String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 0)
    {
      SaveVideoActivity.SaveVideoTask.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaSaveVideoActivity$SaveVideoTask, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakActivity, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry);
      return;
    }
    SaveVideoActivity.SaveVideoTask.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorActivityRichmediaSaveVideoActivity$SaveVideoTask, 1, this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.SaveVideoActivity.SaveVideoTask.1
 * JD-Core Version:    0.7.0.1
 */