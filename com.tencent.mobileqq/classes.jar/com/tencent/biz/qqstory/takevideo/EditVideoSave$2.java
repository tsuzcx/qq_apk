package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class EditVideoSave$2
  extends SimpleObserver<GenerateContext>
{
  EditVideoSave$2(EditVideoSave paramEditVideoSave, GenerateContext paramGenerateContext) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.a(5);
    paramGenerateContext = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.a;
    SLog.b("EditVideoSave", "publishParam = " + paramGenerateContext);
    Intent localIntent;
    int j;
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity() != null)
    {
      localIntent = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
      if (localIntent == null) {
        break label212;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), paramGenerateContext.b, i, j, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.a());
      EditVideoSave.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave, paramGenerateContext.b);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().startActivityForResult(localIntent, 111);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_Int = 5;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.b = ((int)(7000.0D / paramGenerateContext.a * 4.0D));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.g();
      return;
      label212:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.h();
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), HardCodeUtil.a(2131703859), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    SLog.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), 1, HardCodeUtil.a(2131703797) + paramError, 0).a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoSave.2
 * JD-Core Version:    0.7.0.1
 */