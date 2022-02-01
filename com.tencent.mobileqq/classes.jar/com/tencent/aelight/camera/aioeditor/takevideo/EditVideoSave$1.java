package com.tencent.aelight.camera.aioeditor.takevideo;

import android.content.Intent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class EditVideoSave$1
  implements Runnable
{
  EditVideoSave$1(EditVideoSave paramEditVideoSave, int paramInt, Intent paramIntent) {}
  
  public void run()
  {
    this.this$0.g();
    if (this.jdField_a_of_type_Int == 222)
    {
      String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_video_save_path");
      this.this$0.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(str);
      return;
    }
    QQToast.a(this.this$0.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext(), 2, HardCodeUtil.a(2131703913), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSave.1
 * JD-Core Version:    0.7.0.1
 */