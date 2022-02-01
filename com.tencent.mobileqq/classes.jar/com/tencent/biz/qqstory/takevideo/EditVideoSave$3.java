package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class EditVideoSave$3
  extends SimpleObserver<GenerateContext>
{
  EditVideoSave$3(EditVideoSave paramEditVideoSave, GenerateContext paramGenerateContext) {}
  
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
        break label331;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), paramGenerateContext.b, i, j, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a.a());
      EditVideoSave.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave, paramGenerateContext.b);
      localIntent.putExtra("mediacodec_encode_enable", true);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().startActivityForResult(localIntent, 111);
      EditVideoSave.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave, SystemClock.elapsedRealtime());
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_Int = 5;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.b = ((int)(7000.0D / paramGenerateContext.a * 4.0D));
      SLog.b("EditVideoSave", "[30s]progressIncrement Old = " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.b);
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.b <= 0) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.b = 2;
      }
      SLog.b("EditVideoSave", "[30s]progressIncrement new = " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.b);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.g();
      if (CameraControl.a().jdField_a_of_type_Int == 1) {}
      for (i = 1;; i = 2)
      {
        CaptureReportUtil.g(i);
        return;
      }
      label331:
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
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), HardCodeUtil.a(2131703778), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    SLog.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), 1, HardCodeUtil.a(2131703843) + paramError, 0).a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoSave.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoSave.3
 * JD-Core Version:    0.7.0.1
 */