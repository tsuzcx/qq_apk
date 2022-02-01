import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class boui
  extends SimpleObserver<bpel>
{
  boui(boug paramboug, bpel parambpel) {}
  
  public void a(bpel parambpel)
  {
    super.onNext(parambpel);
    this.jdField_a_of_type_Boug.a(5);
    parambpel = this.jdField_a_of_type_Bpel.a;
    ykq.b("EditVideoSave", "publishParam = " + parambpel);
    Intent localIntent1;
    int j;
    int i;
    if (this.jdField_a_of_type_Boug.jdField_a_of_type_Bouo.getActivity() != null)
    {
      localIntent1 = this.jdField_a_of_type_Boug.jdField_a_of_type_Bouo.getActivity().getIntent();
      if (localIntent1 == null) {
        break label318;
      }
      j = localIntent1.getIntExtra("sv_total_frame_count", 0);
      i = localIntent1.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent2 = SaveVideoActivity.a(this.jdField_a_of_type_Boug.jdField_a_of_type_Bouo.a(), parambpel.b, i, j, this.jdField_a_of_type_Boug.jdField_a_of_type_Botw.a.a());
      boug.a(this.jdField_a_of_type_Boug, parambpel.b);
      localIntent2.putExtra("mediacodec_encode_enable", true);
      boolean bool;
      if (parambpel.e != 0)
      {
        bool = true;
        localIntent2.putExtra("video_edit_flag", bool);
        if (localIntent1 != null) {
          localIntent2.putExtra("qqstory_slide_show_scene", localIntent1.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if (this.jdField_a_of_type_Boug.jdField_a_of_type_Int != 19) {
          break label296;
        }
        this.jdField_a_of_type_Boug.jdField_a_of_type_Bouo.getActivity().startActivityForResult(localIntent2, 222);
      }
      for (;;)
      {
        this.jdField_a_of_type_Boug.jdField_a_of_type_Float = 5.0F;
        this.jdField_a_of_type_Boug.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Boug.b = (50000.0F / (float)parambpel.a);
        if (this.jdField_a_of_type_Boug.b == 0.0F) {
          this.jdField_a_of_type_Boug.b = 1.0F;
        }
        this.jdField_a_of_type_Boug.b();
        return;
        bool = false;
        break;
        label296:
        this.jdField_a_of_type_Boug.jdField_a_of_type_Bouo.getActivity().startActivityForResult(localIntent2, 111);
      }
      label318:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    ykq.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_Boug.jdField_a_of_type_Botw.a(0);
    this.jdField_a_of_type_Boug.c();
    QQToast.a(this.jdField_a_of_type_Boug.jdField_a_of_type_Bouo.a(), anvx.a(2131703306), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ykq.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Boug.jdField_a_of_type_Botw.a(0);
    QQToast.a(this.jdField_a_of_type_Boug.jdField_a_of_type_Bouo.a(), 1, anvx.a(2131703218) + paramError, 0).a();
    this.jdField_a_of_type_Boug.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boui
 * JD-Core Version:    0.7.0.1
 */