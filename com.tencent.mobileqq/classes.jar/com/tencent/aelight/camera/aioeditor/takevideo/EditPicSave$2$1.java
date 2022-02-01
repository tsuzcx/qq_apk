package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class EditPicSave$2$1
  implements Runnable
{
  EditPicSave$2$1(EditPicSave.2 param2, String paramString) {}
  
  public void run()
  {
    try
    {
      if ((!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isFromCheckEntry(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicSave$2.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent())) && (!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isFromMiniApp(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicSave$2.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent())))
      {
        EditPicSave.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicSave$2.a, PlusPanelUtils.a());
        File localFile = new File(EditPicSave.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicSave$2.a));
        if (FileUtils.copyFile(new File(this.jdField_a_of_type_JavaLangString), localFile))
        {
          if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicSave$2.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.a() == 14) {
            EditPicSave.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicSave$2.a, true);
          }
          ImageUtil.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicSave$2.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity(), localFile);
        }
      }
      else
      {
        EditPicSave.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicSave$2.a, ((IMiniAppService)QRoute.api(IMiniAppService.class)).getTmpPathFromOut(this.jdField_a_of_type_JavaLangString, EditPicSave.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicSave$2.a, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicSave$2.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext())));
        FileUtils.copyFile(new File(this.jdField_a_of_type_JavaLangString), new File(EditPicSave.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditPicSave$2.a)));
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("savePic ");
        localStringBuilder.append(localException.toString());
        QLog.e("EditPicSave", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave.2.1
 * JD-Core Version:    0.7.0.1
 */