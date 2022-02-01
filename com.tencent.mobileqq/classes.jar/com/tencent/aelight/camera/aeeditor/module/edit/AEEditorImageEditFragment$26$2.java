package com.tencent.aelight.camera.aeeditor.module.edit;

import android.os.Bundle;
import com.tencent.aelight.camera.ae.album.data.AEAlbumMediaBaseModel;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import common.config.service.QzoneConfig;
import java.util.ArrayList;

class AEEditorImageEditFragment$26$2
  implements Runnable
{
  AEEditorImageEditFragment$26$2(AEEditorImageEditFragment.26 param26) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment.getActivity() == null)
    {
      AEQLog.d("AEEditorImageEditFragment", "[onExportComplete], activity == null");
      return;
    }
    this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment.b();
    boolean bool = this.a.jdField_a_of_type_Boolean;
    int i = 0;
    if (bool)
    {
      QQToast.a(this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment.getActivity(), "导出成功", 0).a();
      AEEditorImageEditFragment.e(this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment);
      return;
    }
    while (i < AEEditorImageEditFragment.b(this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment).size())
    {
      if ((QzoneConfig.isNeedDeleteTmpFile()) && (!((AEAlbumMediaBaseModel)this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment.a.get(i)).getOriginPath().equals(((AEAlbumMediaBaseModel)this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment.a.get(i)).getPath())))
      {
        FileUtils.deleteFile(((AEAlbumMediaBaseModel)this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment.a.get(i)).getPath());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onExportComplete], deleteFile:");
        localStringBuilder.append(((AEAlbumMediaBaseModel)this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment.a.get(i)).getPath());
        AEQLog.a("AEEditorImageEditFragment", localStringBuilder.toString());
      }
      ((AEAlbumMediaBaseModel)this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment.a.get(i)).setPath((String)AEEditorImageEditFragment.b(this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment).get(i));
      i += 1;
    }
    this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment.getArguments().putSerializable("ae_album_selected_media_models", this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment.a);
    this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment.getArguments().putSerializable("key_is_need_update_source_path", Boolean.valueOf(true));
    this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment.getArguments().putSerializable("resource_model", null);
    AEEditorImageEditFragment.f(this.a.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleEditAEEditorImageEditFragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.26.2
 * JD-Core Version:    0.7.0.1
 */