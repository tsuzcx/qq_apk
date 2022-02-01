package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.SaveVideoActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

class EditVideoSave$2
  extends SimpleObserver<GenerateContext>
{
  EditVideoSave$2(EditVideoSave paramEditVideoSave, GenerateContext paramGenerateContext) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSave.a(5);
    paramGenerateContext = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGenerateContext.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("publishParam = ");
    ((StringBuilder)localObject).append(paramGenerateContext);
    SLog.b("EditVideoSave", ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSave.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity() != null)
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSave.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().getIntent();
      int i;
      int j;
      if (localObject != null)
      {
        i = ((Intent)localObject).getIntExtra("sv_total_frame_count", 0);
        j = ((Intent)localObject).getIntExtra("sv_total_record_time", 0);
      }
      else
      {
        i = 0;
        j = 0;
      }
      Intent localIntent = SaveVideoActivity.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSave.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext(), paramGenerateContext.b, j, i, this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSave.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.a());
      EditVideoSave.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSave, paramGenerateContext.b);
      boolean bool = true;
      localIntent.putExtra("mediacodec_encode_enable", true);
      if (paramGenerateContext.e == 0) {
        bool = false;
      }
      localIntent.putExtra("video_edit_flag", bool);
      if (localObject != null) {
        localIntent.putExtra("qqstory_slide_show_scene", ((Intent)localObject).getIntExtra("qqstory_slide_show_scene", -1));
      }
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSave.jdField_a_of_type_Int == 19) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSave.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().startActivityForResult(localIntent, 222);
      } else {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSave.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity().startActivityForResult(localIntent, 111);
      }
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSave;
      ((EditVideoSave)localObject).jdField_a_of_type_Float = 5.0F;
      ((EditVideoSave)localObject).jdField_a_of_type_Boolean = false;
      ((EditVideoSave)localObject).b = (50000.0F / (float)paramGenerateContext.a);
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSave.b == 0.0F) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSave.b = 1.0F;
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSave.b();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSave.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSave.g();
    QQToast.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSave.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext(), HardCodeUtil.a(2131703959), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveVideo error ：");
    ((StringBuilder)localObject).append(paramError);
    SLog.e("EditVideoSave", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSave.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSave.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131703889));
    localStringBuilder.append(paramError);
    QQToast.a((Context)localObject, 1, localStringBuilder.toString(), 0).a();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoSave.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSave.2
 * JD-Core Version:    0.7.0.1
 */