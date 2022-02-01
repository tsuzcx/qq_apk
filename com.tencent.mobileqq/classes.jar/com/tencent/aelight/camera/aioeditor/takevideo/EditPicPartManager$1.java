package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.AutoSaveUtils;
import com.tribe.async.reactive.SimpleObserver;

class EditPicPartManager$1
  extends SimpleObserver<GenerateContext>
{
  EditPicPartManager$1(EditPicPartManager paramEditPicPartManager) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.dismissLoadingDialog();
    Activity localActivity = this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("picDestPath = ");
      ((StringBuilder)localObject1).append(paramGenerateContext.a.b);
      SLog.b("EditPicActivity.EditPicPartManager", ((StringBuilder)localObject1).toString());
      localObject1 = this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getPublishIntent(paramGenerateContext);
      if (!paramGenerateContext.a.c) {
        ((Intent)localObject1).putExtra("extra_is_edited_pic", paramGenerateContext.a.c ^ true);
      }
      this.a.d();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("subBussinessId = ");
      ((StringBuilder)localObject2).append(this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.b());
      SLog.b("EditPicActivity.EditPicPartManager", ((StringBuilder)localObject2).toString());
      if (this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a == 2)
      {
        int i = this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.b();
        if (i != 106)
        {
          if ((i != 107) && (i != 110))
          {
            if (paramGenerateContext.a()) {
              AutoSaveUtils.b(true, paramGenerateContext.a.b);
            }
          }
          else if (paramGenerateContext.a()) {
            AutoSaveUtils.a(paramGenerateContext.a.b, true);
          }
        }
        else {
          AutoSaveUtils.b(true, paramGenerateContext.a.b);
        }
      }
      EditPicPartManager.a(this.a);
      localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool = ((Intent)localObject1).getBooleanExtra("DirectBackToQzone", false);
      if (("qzone_plugin.apk".equals(localObject2)) && (bool))
      {
        this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.finish(-1, (Intent)localObject1, 2130772056, 0);
        return;
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a == 2) && ((this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c() == 122) || (this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c() == 133)))
      {
        paramGenerateContext = ((Intent)localObject1).getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        EditPicPartManager.a(this.a, (Intent)localObject1);
        AIOLongShotHelper.a(localActivity, paramGenerateContext, new EditPicPartManager.1.1(this));
        return;
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a == 2) && (this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c() == 125))
      {
        this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.finish(-1, (Intent)localObject1, 2130772056, 0, false);
        ReportController.b(null, "dc00898", "", "", "0X800A188", "0X800A188", 0, 0, "", "", "", "");
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a == 2)
      {
        localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams;
        if (EditVideoParams.a(this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.c()))
        {
          EditPicPartManager.a(this.a, (Intent)localObject1);
          ReportController.b(null, "dc00898", "", "", "0X800A183", "0X800A183", 0, 0, "", "", "", "");
          return;
        }
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a == 2) && (this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.h()))
      {
        ((Intent)localObject1).putExtra("PhotoConst.SEND_ORIGIN", paramGenerateContext.a() ^ true);
        this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.finish(-1, (Intent)localObject1, 2130772056, 0, false);
        return;
      }
      if (((Intent)localObject1).getBooleanExtra("input_full_screen_mode", false))
      {
        this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.finish(-1, (Intent)localObject1, 2130772056, 0, false);
        return;
      }
      paramGenerateContext = this.a;
      paramGenerateContext.a(localActivity, paramGenerateContext.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a(), (Intent)localObject1);
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.dismissLoadingDialog();
    QQToast.a(this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext(), HardCodeUtil.a(2131703837), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager.1
 * JD-Core Version:    0.7.0.1
 */