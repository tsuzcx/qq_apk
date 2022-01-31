import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSave;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoUi;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

public class anuy
  extends SimpleObserver
{
  public anuy(EditVideoSave paramEditVideoSave, GenerateContext paramGenerateContext) {}
  
  public void a(GenerateContext paramGenerateContext)
  {
    super.onNext(paramGenerateContext);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.a(5);
    paramGenerateContext = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoPublishGenerateContext.a;
    SLog.b("EditVideoSave", "publishParam = " + paramGenerateContext);
    Intent localIntent;
    int j;
    int i;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity() != null)
    {
      localIntent = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent();
      if (localIntent == null) {
        break label238;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), paramGenerateContext.b, i, j, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a());
      if (paramGenerateContext.e != 0) {}
      for (boolean bool = true;; bool = false)
      {
        localIntent.putExtra("video_edit_flag", bool);
        EditVideoSave.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave, paramGenerateContext.b);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().startActivityForResult(localIntent, 111);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_Int = 5;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.b = ((int)(7000.0D / paramGenerateContext.a * 4.0D));
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.c();
        return;
      }
      label238:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.j();
    QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), "取消保存", 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    SLog.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
    QQToast.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), 1, "保存失败，请重试 : " + paramError, 0).a();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoSave.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anuy
 * JD-Core Version:    0.7.0.1
 */