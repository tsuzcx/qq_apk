package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelItemInfo;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelManager;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;

class EditPicSave$1$1
  implements Runnable
{
  EditPicSave$1$1(EditPicSave.1 param1) {}
  
  public void run()
  {
    if (EditPicSave.a(this.a.a)) {
      return;
    }
    int i = EditPicSave.a(this.a.a);
    boolean bool = true;
    if (i == 20) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject1 = EditPicSave.a(this.a.a);
    this.a.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
    this.a.a.jdField_a_of_type_Boolean = true;
    this.a.a.a(100);
    this.a.a.g();
    if ((!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isFromCheckEntry(this.a.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent())) && (!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isFromMiniApp(this.a.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent())))
    {
      if (this.a.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.a() == 14)
      {
        Object localObject2 = this.a.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent();
        if (!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isStoryDefaultShare((Intent)localObject2))
        {
          this.a.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.p = false;
          this.a.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
          if (EditPicSave.b(this.a.a))
          {
            if (((Intent)localObject2).getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) != 2) {
              bool = false;
            }
            if (i == 0)
            {
              ShortVideoForwardManager.a(this.a.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity(), EditPicSave.a(this.a.a), bool, 2);
              return;
            }
            SendPanelManager.a().a(((Intent)localObject2).getStringExtra("widgetinfo"));
            localObject2 = ((Intent)localObject2).getStringExtra("key_camera_material_name");
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onPostRun---takeSameName=");
            localStringBuilder.append((String)localObject2);
            AEQLog.b("EditPicSave", localStringBuilder.toString());
            SendPanelManager.a().b((String)localObject2);
            SendPanelManager.a().a(((SendPanelItemInfo)localObject1).jdField_a_of_type_JavaLangString, ((SendPanelItemInfo)localObject1).jdField_a_of_type_Int, EditPicSave.a(this.a.a), "", false);
            return;
          }
          QQToast.a(this.a.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext(), 1, HardCodeUtil.a(2131703842), 0).a();
        }
      }
      else
      {
        QQToast.a(this.a.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext(), 2, HardCodeUtil.a(2131703844), 0).a();
      }
    }
    else
    {
      localObject1 = new Intent();
      ((Intent)localObject1).setAction("com.tencent.mobileqq.mini.out.nativePlugins.native_back");
      ((Intent)localObject1).putExtra("file_path", EditPicSave.a(this.a.a));
      ((Intent)localObject1).putExtra("is_video", false);
      this.a.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().sendBroadcast((Intent)localObject1);
      this.a.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().setResult(-1, this.a.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent());
      this.a.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave.1.1
 * JD-Core Version:    0.7.0.1
 */