import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import cooperation.qzone.QZoneHelper;
import dov.com.tencent.biz.qqstory.takevideo.EditPicPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoUi;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.GeneratePicArgs;

public class anrj
  extends SimpleObserver
{
  public anrj(EditPicPartManager paramEditPicPartManager) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.f();
    Object localObject = this.a.a();
    String str = paramGenerateContext.a.jdField_b_of_type_JavaLangString;
    if ((this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null) && (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 2)) {}
    for (boolean bool = true;; bool = false)
    {
      EditPicPartManager.a((String)localObject, str, paramGenerateContext.a.jdField_b_of_type_Boolean, paramGenerateContext.a.a, bool, this.a.c);
      localObject = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity();
      if ((localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        SLog.b("EditPicActivity.EditPicPartManager", "picDestPath = " + paramGenerateContext.a.jdField_b_of_type_JavaLangString);
        paramGenerateContext = this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(paramGenerateContext);
        this.a.a();
        str = paramGenerateContext.getStringExtra("PhotoConst.PLUGIN_APK");
        bool = paramGenerateContext.getBooleanExtra("DirectBackToQzone", false);
        if ((!"qzone_plugin.apk".equals(str)) || (!bool)) {
          break;
        }
        QZoneHelper.a((Activity)localObject, "", paramGenerateContext, -1);
        this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(-1, null, 2131034158, 0);
      }
      return;
    }
    if (this.a.jdField_a_of_type_Int == 1)
    {
      this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(-1, paramGenerateContext, 2131034158, 0);
      return;
    }
    this.a.a((Activity)localObject, this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.a(), paramGenerateContext);
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.f();
    QQToast.a(this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), "取消编辑", 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.a.a(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anrj
 * JD-Core Version:    0.7.0.1
 */