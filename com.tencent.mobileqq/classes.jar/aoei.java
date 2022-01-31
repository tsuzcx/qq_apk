import android.app.Activity;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPart;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayerExport;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoUi;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import java.util.Iterator;
import java.util.List;

public class aoei
  extends SimpleObserver
{
  public aoei(EditWebVideoPartManager paramEditWebVideoPartManager) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.f();
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().overridePendingTransition(0, 0);
    this.a.o();
    this.a.jdField_b_of_type_Boolean = false;
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((EditVideoPart)localIterator.next()).b(paramGenerateContext);
    }
    this.a.jdField_b_of_type_Boolean = false;
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.f();
    paramGenerateContext = (EditVideoPlayerExport)this.a.a(EditVideoPlayerExport.class);
    if (paramGenerateContext != null) {
      paramGenerateContext.m();
    }
    if (this.a.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
      return;
    }
    QQToast.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), "对不起，视频发送失败...", 0).a();
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().finish();
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.jdField_b_of_type_JavaUtilList.add(paramError);
    if (QLog.isColorLevel()) {
      QLog.e("EditWebVideoActivity", 2, "publish error:", paramError);
    }
    QQToast.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), "对不起，视频处理失败...", 0).a();
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoei
 * JD-Core Version:    0.7.0.1
 */