import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class bpfh
  extends SimpleObserver<bpsf>
{
  bpfh(bpff parambpff, bpsf parambpsf) {}
  
  public void a(bpsf parambpsf)
  {
    super.onNext(parambpsf);
    this.jdField_a_of_type_Bpff.a(5);
    parambpsf = this.jdField_a_of_type_Bpsf.a;
    yqp.b("EditVideoSave", "publishParam = " + parambpsf);
    Intent localIntent1;
    int j;
    int i;
    if (this.jdField_a_of_type_Bpff.jdField_a_of_type_Bpfx.getActivity() != null)
    {
      localIntent1 = this.jdField_a_of_type_Bpff.jdField_a_of_type_Bpfx.getActivity().getIntent();
      if (localIntent1 == null) {
        break label318;
      }
      j = localIntent1.getIntExtra("sv_total_frame_count", 0);
      i = localIntent1.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent2 = SaveVideoActivity.a(this.jdField_a_of_type_Bpff.jdField_a_of_type_Bpfx.a(), parambpsf.b, i, j, this.jdField_a_of_type_Bpff.jdField_a_of_type_Bpep.a.a());
      bpff.a(this.jdField_a_of_type_Bpff, parambpsf.b);
      localIntent2.putExtra("mediacodec_encode_enable", true);
      boolean bool;
      if (parambpsf.e != 0)
      {
        bool = true;
        localIntent2.putExtra("video_edit_flag", bool);
        if (localIntent1 != null) {
          localIntent2.putExtra("qqstory_slide_show_scene", localIntent1.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if (this.jdField_a_of_type_Bpff.jdField_a_of_type_Int != 47) {
          break label296;
        }
        this.jdField_a_of_type_Bpff.jdField_a_of_type_Bpfx.getActivity().startActivityForResult(localIntent2, 222);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bpff.jdField_a_of_type_Float = 5.0F;
        this.jdField_a_of_type_Bpff.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Bpff.b = (50000.0F / (float)parambpsf.a);
        if (this.jdField_a_of_type_Bpff.b == 0.0F) {
          this.jdField_a_of_type_Bpff.b = 1.0F;
        }
        this.jdField_a_of_type_Bpff.d();
        return;
        bool = false;
        break;
        label296:
        this.jdField_a_of_type_Bpff.jdField_a_of_type_Bpfx.getActivity().startActivityForResult(localIntent2, 111);
      }
      label318:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    yqp.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_Bpff.jdField_a_of_type_Bpep.a(0);
    this.jdField_a_of_type_Bpff.j();
    QQToast.a(this.jdField_a_of_type_Bpff.jdField_a_of_type_Bpfx.a(), anni.a(2131702616), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    yqp.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Bpff.jdField_a_of_type_Bpep.a(0);
    QQToast.a(this.jdField_a_of_type_Bpff.jdField_a_of_type_Bpfx.a(), 1, anni.a(2131702525) + paramError, 0).a();
    this.jdField_a_of_type_Bpff.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpfh
 * JD-Core Version:    0.7.0.1
 */