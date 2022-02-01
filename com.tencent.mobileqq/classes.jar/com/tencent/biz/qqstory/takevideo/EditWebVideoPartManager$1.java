package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Iterator;
import java.util.List;

class EditWebVideoPartManager$1
  extends SimpleObserver<GenerateContext>
{
  EditWebVideoPartManager$1(EditWebVideoPartManager paramEditWebVideoPartManager, GenerateContext paramGenerateContext) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.b();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().overridePendingTransition(0, 0);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.o();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_b_of_type_Boolean = false;
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).b(paramGenerateContext);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.b();
    paramGenerateContext = (EditVideoPlayerExport)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.a(EditVideoPlayerExport.class);
    if (paramGenerateContext != null) {
      paramGenerateContext.i();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      paramGenerateContext = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
      if (paramGenerateContext != null)
      {
        ((EditWebVideoActivity)paramGenerateContext).a(HardCodeUtil.a(2131703995));
        EditWebVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager, paramGenerateContext, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateContext.a);
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), HardCodeUtil.a(2131703994), 0).a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().finish();
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_b_of_type_JavaUtilList.add(paramError);
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "publish error:", paramError);
    }
    QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a(), HardCodeUtil.a(2131703998), 0).a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditWebVideoPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.1
 * JD-Core Version:    0.7.0.1
 */