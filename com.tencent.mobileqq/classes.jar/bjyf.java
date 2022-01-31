import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class bjyf
  extends SimpleObserver<bkld>
{
  bjyf(bjyd parambjyd, bkld parambkld) {}
  
  public void a(bkld parambkld)
  {
    super.onNext(parambkld);
    this.jdField_a_of_type_Bjyd.a(5);
    parambkld = this.jdField_a_of_type_Bkld.a;
    ved.b("EditVideoSave", "publishParam = " + parambkld);
    Intent localIntent1;
    int j;
    int i;
    if (this.jdField_a_of_type_Bjyd.jdField_a_of_type_Bjyv.getActivity() != null)
    {
      localIntent1 = this.jdField_a_of_type_Bjyd.jdField_a_of_type_Bjyv.getActivity().getIntent();
      if (localIntent1 == null) {
        break label318;
      }
      j = localIntent1.getIntExtra("sv_total_frame_count", 0);
      i = localIntent1.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent2 = SaveVideoActivity.a(this.jdField_a_of_type_Bjyd.jdField_a_of_type_Bjyv.a(), parambkld.b, i, j, this.jdField_a_of_type_Bjyd.jdField_a_of_type_Bjxn.a.a());
      bjyd.a(this.jdField_a_of_type_Bjyd, parambkld.b);
      localIntent2.putExtra("mediacodec_encode_enable", true);
      boolean bool;
      if (parambkld.e != 0)
      {
        bool = true;
        localIntent2.putExtra("video_edit_flag", bool);
        if (localIntent1 != null) {
          localIntent2.putExtra("qqstory_slide_show_scene", localIntent1.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if (this.jdField_a_of_type_Bjyd.jdField_a_of_type_Int != 47) {
          break label296;
        }
        this.jdField_a_of_type_Bjyd.jdField_a_of_type_Bjyv.getActivity().startActivityForResult(localIntent2, 222);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bjyd.jdField_a_of_type_Float = 5.0F;
        this.jdField_a_of_type_Bjyd.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Bjyd.b = (50000.0F / (float)parambkld.a);
        if (this.jdField_a_of_type_Bjyd.b == 0.0F) {
          this.jdField_a_of_type_Bjyd.b = 1.0F;
        }
        this.jdField_a_of_type_Bjyd.d();
        return;
        bool = false;
        break;
        label296:
        this.jdField_a_of_type_Bjyd.jdField_a_of_type_Bjyv.getActivity().startActivityForResult(localIntent2, 111);
      }
      label318:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    ved.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_Bjyd.jdField_a_of_type_Bjxn.a(0);
    this.jdField_a_of_type_Bjyd.j();
    bcql.a(this.jdField_a_of_type_Bjyd.jdField_a_of_type_Bjyv.a(), ajya.a(2131703835), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ved.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Bjyd.jdField_a_of_type_Bjxn.a(0);
    bcql.a(this.jdField_a_of_type_Bjyd.jdField_a_of_type_Bjyv.a(), 1, ajya.a(2131703744) + paramError, 0).a();
    this.jdField_a_of_type_Bjyd.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjyf
 * JD-Core Version:    0.7.0.1
 */