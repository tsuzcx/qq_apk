package com.tencent.aelight.camera.aioeditor.takevideo;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

class EditPicSave$2
  extends SimpleObserver<GenerateContext>
{
  EditPicSave$2(EditPicSave paramEditPicSave) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.a.a(40);
    paramGenerateContext = paramGenerateContext.a.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("picPath = ");
    localStringBuilder.append(paramGenerateContext);
    SLog.b("EditPicSave", localStringBuilder.toString());
    if (this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity() != null)
    {
      ThreadManager.excute(new EditPicSave.2.1(this, paramGenerateContext), 64, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      paramGenerateContext = this.a;
      paramGenerateContext.jdField_a_of_type_Int = 40;
      paramGenerateContext.jdField_a_of_type_Boolean = false;
      paramGenerateContext.b = 10;
      paramGenerateContext.b();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d("EditPicSave", "saveVideo cancel !");
    if (!EditPicSave.a(this.a))
    {
      if (this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.a() == 14) {
        this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.p = false;
      }
      this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
    }
    this.a.g();
    QQToast.a(this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext(), HardCodeUtil.a(2131703843), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveVideo error ：");
    ((StringBuilder)localObject).append(paramError);
    SLog.e("EditPicSave", ((StringBuilder)localObject).toString());
    if (!EditPicSave.a(this.a))
    {
      if (this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a.a() == 14) {
        this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.p = false;
      }
      this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
    }
    localObject = this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131703845));
    localStringBuilder.append(paramError);
    QQToast.a((Context)localObject, 1, localStringBuilder.toString(), 0).a();
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave.2
 * JD-Core Version:    0.7.0.1
 */