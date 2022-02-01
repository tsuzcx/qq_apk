import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class bqhc
  extends SimpleObserver<bqua>
{
  bqhc(bqha parambqha, bqua parambqua) {}
  
  public void a(bqua parambqua)
  {
    super.onNext(parambqua);
    this.jdField_a_of_type_Bqha.a(5);
    parambqua = this.jdField_a_of_type_Bqua.a;
    yuk.b("EditVideoSave", "publishParam = " + parambqua);
    Intent localIntent1;
    int j;
    int i;
    if (this.jdField_a_of_type_Bqha.jdField_a_of_type_Bqhs.getActivity() != null)
    {
      localIntent1 = this.jdField_a_of_type_Bqha.jdField_a_of_type_Bqhs.getActivity().getIntent();
      if (localIntent1 == null) {
        break label318;
      }
      j = localIntent1.getIntExtra("sv_total_frame_count", 0);
      i = localIntent1.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent2 = SaveVideoActivity.a(this.jdField_a_of_type_Bqha.jdField_a_of_type_Bqhs.a(), parambqua.b, i, j, this.jdField_a_of_type_Bqha.jdField_a_of_type_Bqgk.a.a());
      bqha.a(this.jdField_a_of_type_Bqha, parambqua.b);
      localIntent2.putExtra("mediacodec_encode_enable", true);
      boolean bool;
      if (parambqua.e != 0)
      {
        bool = true;
        localIntent2.putExtra("video_edit_flag", bool);
        if (localIntent1 != null) {
          localIntent2.putExtra("qqstory_slide_show_scene", localIntent1.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if (this.jdField_a_of_type_Bqha.jdField_a_of_type_Int != 47) {
          break label296;
        }
        this.jdField_a_of_type_Bqha.jdField_a_of_type_Bqhs.getActivity().startActivityForResult(localIntent2, 222);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bqha.jdField_a_of_type_Float = 5.0F;
        this.jdField_a_of_type_Bqha.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Bqha.b = (50000.0F / (float)parambqua.a);
        if (this.jdField_a_of_type_Bqha.b == 0.0F) {
          this.jdField_a_of_type_Bqha.b = 1.0F;
        }
        this.jdField_a_of_type_Bqha.d();
        return;
        bool = false;
        break;
        label296:
        this.jdField_a_of_type_Bqha.jdField_a_of_type_Bqhs.getActivity().startActivityForResult(localIntent2, 111);
      }
      label318:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    yuk.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_Bqha.jdField_a_of_type_Bqgk.a(0);
    this.jdField_a_of_type_Bqha.j();
    QQToast.a(this.jdField_a_of_type_Bqha.jdField_a_of_type_Bqhs.a(), anzj.a(2131702723), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    yuk.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Bqha.jdField_a_of_type_Bqgk.a(0);
    QQToast.a(this.jdField_a_of_type_Bqha.jdField_a_of_type_Bqhs.a(), 1, anzj.a(2131702632) + paramError, 0).a();
    this.jdField_a_of_type_Bqha.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqhc
 * JD-Core Version:    0.7.0.1
 */