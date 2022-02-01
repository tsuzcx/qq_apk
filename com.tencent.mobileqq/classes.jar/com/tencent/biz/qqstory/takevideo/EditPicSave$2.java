package com.tencent.biz.qqstory.takevideo;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
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
    SLog.b("EditPicSave", "picPath = " + paramGenerateContext);
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity() != null)
    {
      ThreadManager.post(new EditPicSave.2.1(this, paramGenerateContext), 5, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.a.jdField_a_of_type_Int = 40;
      this.a.jdField_a_of_type_Boolean = false;
      this.a.b = 10;
      this.a.g();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d("EditPicSave", "saveVideo cancel !");
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    this.a.h();
    QQToast.a(this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), HardCodeUtil.a(2131703721), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    SLog.e("EditPicSave", "saveVideo error ：" + paramError);
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    QQToast.a(this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), 1, HardCodeUtil.a(2131703722) + paramError, 0).a();
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditPicSave.2
 * JD-Core Version:    0.7.0.1
 */