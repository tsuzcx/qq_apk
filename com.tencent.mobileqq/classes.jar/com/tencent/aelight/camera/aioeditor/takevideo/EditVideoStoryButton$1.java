package com.tencent.aelight.camera.aioeditor.takevideo;

import android.content.Intent;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelItemInfo;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.editor.params.EditVideoParams;

class EditVideoStoryButton$1
  implements Runnable
{
  EditVideoStoryButton$1(EditVideoStoryButton paramEditVideoStoryButton, Intent paramIntent, boolean paramBoolean, SendPanelItemInfo paramSendPanelItemInfo) {}
  
  public void run()
  {
    if (!EditVideoStoryButton.a(this.this$0)) {
      this.this$0.h();
    }
    String str1 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_video_save_path");
    String str2 = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("thumbfile_send_path");
    Object localObject = this.this$0.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a;
    boolean bool = false;
    if (((EditVideoParams)localObject).a("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {
      bool = true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("jumpQzoneShuoshuoDirect=");
    ((StringBuilder)localObject).append(bool);
    AEQLog.b("EditVideoStoryButton", ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_Boolean)
    {
      SendPanelManager.a().a(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("widgetinfo"));
      localObject = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_camera_material_name");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPostRun---takeSameName=");
      localStringBuilder.append((String)localObject);
      AEQLog.b("EditVideoStoryButton", localStringBuilder.toString());
      SendPanelManager.a().b((String)localObject);
      SendPanelManager.a().a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSendpanelSendPanelItemInfo.jdField_a_of_type_Int, str1, str2, true);
      return;
    }
    if (EditVideoStoryButton.a(this.this$0))
    {
      AEQLog.b("EditVideoStoryButton", "arkViewId is not empty, doUploadAndForwardVideoArkMsg");
      EditVideoStoryButton.a(this.this$0, str1);
      return;
    }
    ShortVideoForwardManager.a(this.this$0.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity(), str1, str2, bool, "caller_aecamera");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoStoryButton.1
 * JD-Core Version:    0.7.0.1
 */