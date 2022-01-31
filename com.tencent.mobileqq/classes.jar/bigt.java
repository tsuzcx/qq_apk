import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class bigt
  extends SimpleObserver<bitz>
{
  bigt(bigr parambigr, bitz parambitz) {}
  
  public void a(bitz parambitz)
  {
    super.onNext(parambitz);
    this.jdField_a_of_type_Bigr.a(5);
    parambitz = this.jdField_a_of_type_Bitz.a;
    urk.b("EditVideoSave", "publishParam = " + parambitz);
    Intent localIntent1;
    int j;
    int i;
    if (this.jdField_a_of_type_Bigr.jdField_a_of_type_Bihj.getActivity() != null)
    {
      localIntent1 = this.jdField_a_of_type_Bigr.jdField_a_of_type_Bihj.getActivity().getIntent();
      if (localIntent1 == null) {
        break label318;
      }
      j = localIntent1.getIntExtra("sv_total_frame_count", 0);
      i = localIntent1.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent2 = SaveVideoActivity.a(this.jdField_a_of_type_Bigr.jdField_a_of_type_Bihj.a(), parambitz.b, i, j, this.jdField_a_of_type_Bigr.jdField_a_of_type_Bigb.a.a());
      bigr.a(this.jdField_a_of_type_Bigr, parambitz.b);
      localIntent2.putExtra("mediacodec_encode_enable", true);
      boolean bool;
      if (parambitz.e != 0)
      {
        bool = true;
        localIntent2.putExtra("video_edit_flag", bool);
        if (localIntent1 != null) {
          localIntent2.putExtra("qqstory_slide_show_scene", localIntent1.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if (this.jdField_a_of_type_Bigr.jdField_a_of_type_Int != 47) {
          break label296;
        }
        this.jdField_a_of_type_Bigr.jdField_a_of_type_Bihj.getActivity().startActivityForResult(localIntent2, 222);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bigr.jdField_a_of_type_Float = 5.0F;
        this.jdField_a_of_type_Bigr.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Bigr.b = (50000.0F / (float)parambitz.a);
        if (this.jdField_a_of_type_Bigr.b == 0.0F) {
          this.jdField_a_of_type_Bigr.b = 1.0F;
        }
        this.jdField_a_of_type_Bigr.d();
        return;
        bool = false;
        break;
        label296:
        this.jdField_a_of_type_Bigr.jdField_a_of_type_Bihj.getActivity().startActivityForResult(localIntent2, 111);
      }
      label318:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    urk.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_Bigr.jdField_a_of_type_Bigb.a(0);
    this.jdField_a_of_type_Bigr.j();
    bbmy.a(this.jdField_a_of_type_Bigr.jdField_a_of_type_Bihj.a(), ajjy.a(2131638039), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    urk.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Bigr.jdField_a_of_type_Bigb.a(0);
    bbmy.a(this.jdField_a_of_type_Bigr.jdField_a_of_type_Bihj.a(), 1, ajjy.a(2131637948) + paramError, 0).a();
    this.jdField_a_of_type_Bigr.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bigt
 * JD-Core Version:    0.7.0.1
 */