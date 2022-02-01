import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class bqhb
  extends SimpleObserver<bqua>
{
  bqhb(bqha parambqha, bqua parambqua) {}
  
  public void a(bqua parambqua)
  {
    super.onNext(parambqua);
    this.jdField_a_of_type_Bqha.a(5);
    parambqua = this.jdField_a_of_type_Bqua.a;
    yuk.b("EditVideoSave", "publishParam = " + parambqua);
    Intent localIntent;
    int j;
    int i;
    if (this.jdField_a_of_type_Bqha.jdField_a_of_type_Bqhs.getActivity() != null)
    {
      localIntent = this.jdField_a_of_type_Bqha.jdField_a_of_type_Bqhs.getActivity().getIntent();
      if (localIntent == null) {
        break label292;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Bqha.jdField_a_of_type_Bqhs.a(), parambqua.b, i, j, this.jdField_a_of_type_Bqha.jdField_a_of_type_Bqgk.a.a());
      boolean bool;
      if (parambqua.e != 0)
      {
        bool = true;
        localIntent.putExtra("video_edit_flag", bool);
        bqha.a(this.jdField_a_of_type_Bqha, parambqua.b);
        if (this.jdField_a_of_type_Bqha.jdField_a_of_type_Int != 47) {
          break label260;
        }
        localIntent.putExtra("requestCode", 222);
        this.jdField_a_of_type_Bqha.jdField_a_of_type_Bqhs.getActivity().startActivityForResult(localIntent, 222);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bqha.jdField_a_of_type_Float = 5.0F;
        this.jdField_a_of_type_Bqha.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Bqha.b = (7000.0F / (float)parambqua.a * 4.0F);
        this.jdField_a_of_type_Bqha.d();
        return;
        bool = false;
        break;
        label260:
        localIntent.putExtra("requestCode", 111);
        this.jdField_a_of_type_Bqha.jdField_a_of_type_Bqhs.getActivity().startActivityForResult(localIntent, 111);
      }
      label292:
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
    QQToast.a(this.jdField_a_of_type_Bqha.jdField_a_of_type_Bqhs.a(), anzj.a(2131702677), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    yuk.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Bqha.jdField_a_of_type_Bqgk.a(0);
    QQToast.a(this.jdField_a_of_type_Bqha.jdField_a_of_type_Bqhs.a(), 1, anzj.a(2131702640) + paramError, 0).a();
    this.jdField_a_of_type_Bqha.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqhb
 * JD-Core Version:    0.7.0.1
 */