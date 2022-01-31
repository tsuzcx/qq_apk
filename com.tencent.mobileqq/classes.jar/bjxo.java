import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;

class bjxo
  extends SimpleObserver<bkkm>
{
  bjxo(bjxm parambjxm, bkkm parambkkm) {}
  
  public void a(bkkm parambkkm)
  {
    super.onNext(parambkkm);
    this.jdField_a_of_type_Bjxm.a(5);
    parambkkm = this.jdField_a_of_type_Bkkm.a;
    veg.b("EditVideoSave", "publishParam = " + parambkkm);
    Intent localIntent1;
    int j;
    int i;
    if (this.jdField_a_of_type_Bjxm.jdField_a_of_type_Bjye.getActivity() != null)
    {
      localIntent1 = this.jdField_a_of_type_Bjxm.jdField_a_of_type_Bjye.getActivity().getIntent();
      if (localIntent1 == null) {
        break label318;
      }
      j = localIntent1.getIntExtra("sv_total_frame_count", 0);
      i = localIntent1.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent2 = SaveVideoActivity.a(this.jdField_a_of_type_Bjxm.jdField_a_of_type_Bjye.a(), parambkkm.b, i, j, this.jdField_a_of_type_Bjxm.jdField_a_of_type_Bjww.a.a());
      bjxm.a(this.jdField_a_of_type_Bjxm, parambkkm.b);
      localIntent2.putExtra("mediacodec_encode_enable", true);
      boolean bool;
      if (parambkkm.e != 0)
      {
        bool = true;
        localIntent2.putExtra("video_edit_flag", bool);
        if (localIntent1 != null) {
          localIntent2.putExtra("qqstory_slide_show_scene", localIntent1.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if (this.jdField_a_of_type_Bjxm.jdField_a_of_type_Int != 47) {
          break label296;
        }
        this.jdField_a_of_type_Bjxm.jdField_a_of_type_Bjye.getActivity().startActivityForResult(localIntent2, 222);
      }
      for (;;)
      {
        this.jdField_a_of_type_Bjxm.jdField_a_of_type_Float = 5.0F;
        this.jdField_a_of_type_Bjxm.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Bjxm.b = (50000.0F / (float)parambkkm.a);
        if (this.jdField_a_of_type_Bjxm.b == 0.0F) {
          this.jdField_a_of_type_Bjxm.b = 1.0F;
        }
        this.jdField_a_of_type_Bjxm.d();
        return;
        bool = false;
        break;
        label296:
        this.jdField_a_of_type_Bjxm.jdField_a_of_type_Bjye.getActivity().startActivityForResult(localIntent2, 111);
      }
      label318:
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    veg.d("EditVideoSave", "saveVideo cancel !");
    this.jdField_a_of_type_Bjxm.jdField_a_of_type_Bjww.a(0);
    this.jdField_a_of_type_Bjxm.j();
    bcpw.a(this.jdField_a_of_type_Bjxm.jdField_a_of_type_Bjye.a(), ajyc.a(2131703824), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    veg.e("EditVideoSave", "saveVideo error ：" + paramError);
    this.jdField_a_of_type_Bjxm.jdField_a_of_type_Bjww.a(0);
    bcpw.a(this.jdField_a_of_type_Bjxm.jdField_a_of_type_Bjye.a(), 1, ajyc.a(2131703733) + paramError, 0).a();
    this.jdField_a_of_type_Bjxm.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjxo
 * JD-Core Version:    0.7.0.1
 */