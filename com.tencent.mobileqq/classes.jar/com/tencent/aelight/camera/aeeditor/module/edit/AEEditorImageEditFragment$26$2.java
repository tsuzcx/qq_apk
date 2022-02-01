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
    if (this.a.b.getActivity() == null)
    {
      AEQLog.d("AEEditorImageEditFragment", "[onExportComplete], activity == null");
      return;
    }
    this.a.b.e();
    boolean bool = this.a.a;
    int i = 0;
    if (bool)
    {
      QQToast.makeText(this.a.b.getActivity(), "导出成功", 0).show();
      AEEditorImageEditFragment.D(this.a.b);
      return;
    }
    while (i < AEEditorImageEditFragment.A(this.a.b).size())
    {
      if ((QzoneConfig.isNeedDeleteTmpFile()) && (!((AEAlbumMediaBaseModel)this.a.b.x.get(i)).getOriginPath().equals(((AEAlbumMediaBaseModel)this.a.b.x.get(i)).getPath())))
      {
        FileUtils.deleteFile(((AEAlbumMediaBaseModel)this.a.b.x.get(i)).getPath());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onExportComplete], deleteFile:");
        localStringBuilder.append(((AEAlbumMediaBaseModel)this.a.b.x.get(i)).getPath());
        AEQLog.a("AEEditorImageEditFragment", localStringBuilder.toString());
      }
      ((AEAlbumMediaBaseModel)this.a.b.x.get(i)).setPath((String)AEEditorImageEditFragment.A(this.a.b).get(i));
      i += 1;
    }
    this.a.b.getArguments().putSerializable("ae_album_selected_media_models", this.a.b.x);
    this.a.b.getArguments().putSerializable("key_is_need_update_source_path", Boolean.valueOf(true));
    this.a.b.getArguments().putSerializable("resource_model", null);
    AEEditorImageEditFragment.E(this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.26.2
 * JD-Core Version:    0.7.0.1
 */