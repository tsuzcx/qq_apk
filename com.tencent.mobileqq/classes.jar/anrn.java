import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditPicSave;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoUi;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;

public class anrn
  extends SimpleObserver
{
  public anrn(EditPicSave paramEditPicSave) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.a.a(40);
    paramGenerateContext = paramGenerateContext.a.b;
    SLog.b("EditPicSave", "picPath = " + paramGenerateContext);
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity() != null)
    {
      ThreadManager.post(new anro(this, paramGenerateContext), 5, this.a.jdField_a_of_type_ComTencentMobileqqAppThreadExcutor$IThreadListener, true);
      this.a.jdField_a_of_type_Int = 40;
      this.a.jdField_a_of_type_Boolean = false;
      this.a.b = 10;
      this.a.c();
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d("EditPicSave", "saveVideo cancel !");
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    this.a.d();
    QQToast.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), "取消保存", 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    SLog.e("EditPicSave", "saveVideo error ：" + paramError);
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    QQToast.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), 1, "保存失败，请重试 : " + paramError, 0).a();
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anrn
 * JD-Core Version:    0.7.0.1
 */