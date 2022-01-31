import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class bigs
  extends SimpleObserver<bitz>
{
  bigs(bigr parambigr, bitz parambitz) {}
  
  public void a(bitz parambitz)
  {
    super.onNext(parambitz);
    this.jdField_a_of_type_Bigr.a(5);
    parambitz = this.jdField_a_of_type_Bitz.a;
    urk.b("EditVideoSave", "publishParam = " + parambitz);
    Intent localIntent;
    int j;
    int i;
    if (this.jdField_a_of_type_Bigr.jdField_a_of_type_Bihj.getActivity() != null)
    {
      localIntent = this.jdField_a_of_type_Bigr.jdField_a_of_type_Bihj.getActivity().getIntent();
      if (localIntent == null) {
        break label292;
      }
      j = localIntent.getIntExtra("sv_total_frame_count", 0);
      i = localIntent.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      localIntent = SaveVideoActivity.a(this.jdField_a_of_type_Bigr.jdField_a_of_type_Bihj.a(), parambitz.b, i, j, this.jdField_a_of_type_Bigr.jdField_a_of_type_Bigb.a.a());
      boolean bool;
      if (parambitz.e != 0)
      {
        bool = true;
        localIntent.putExtra("video_edit_flag", bool);
        bigr.a(this.jdField_a_of_type_Bigr, parambitz.b);
        if (this.jdField_a_of_type_Bigr.jdField_a_of_type_Int != 47) {
          break label260;
        }
        localIntent.putExtra("requestCode", 222);
        this.jdField_a_of_type_Bigr.jdField_a_of_type_Bihj.getActivity().startActivityForResult(localIntent, 222);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bigr.jdField_a_of_type_Float = 5.0F;
        this.jdField_a_of_type_Bigr.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Bigr.b = (7000.0F / (float)parambitz.a * 4.0F);
        this.jdField_a_of_type_Bigr.d();
        return;
        bool = false;
        break;
        label260:
        localIntent.putExtra("requestCode", 111);
        this.jdField_a_of_type_Bigr.jdField_a_of_type_Bihj.getActivity().startActivityForResult(localIntent, 111);
      }
      label292:
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
    bbmy.a(this.jdField_a_of_type_Bigr.jdField_a_of_type_Bihj.a(), ajjy.a(2131637993), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    urk.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Bigr.jdField_a_of_type_Bigb.a(0);
    bbmy.a(this.jdField_a_of_type_Bigr.jdField_a_of_type_Bihj.a(), 1, ajjy.a(2131637956) + paramError, 0).a();
    this.jdField_a_of_type_Bigr.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bigs
 * JD-Core Version:    0.7.0.1
 */